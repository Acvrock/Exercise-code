### 问题描述
我们在系统中使用 Guava 的 EventBus 进行代码解耦，一直运行良好，但是在某一次发版后，出现了消息重复消费的情况，示例代码如下:

```java
AbstractListener.java //抽象父类
public abstract class AbstractListener<T> implements InitializingBean {
	@Override
	public void afterPropertiesSet() {  //系统初始化时进行消费者注册
		GuavaEventBusFactory.getDefault().eventBus().register(this);
	}

	protected abstract void onEvent(T t) throws Exception;
} 
``` 

```java
CallNotifyListener.java //具体业务类，对事件进行消费
@Component
@Lazy(false)
public class CallNotifyListener extends AbstractListener<CallBack> {
	Logger logger = LoggerFactory.getLogger(CallNotifyListener.class);

	@Subscribe
	@Override
	public void onEvent(CallBack event) throws Exception {
		logger.info("CallNotifyListener onEvent :{},{}", event.getAppid(),event);
	}
}

```
 
```java
ScheduledTasks.java //事件生产者
@Component
public class ScheduledTasks {
	Logger logger = LoggerFactory.getLogger(ScheduledTasks.class);

	@Scheduled(fixedRate = 2000)
	public void scheduleTaskWithFixedRate() {
		logger.info("send msg - {}",new Date());
		CallBack callBack = new CallBack(1,System.currentTimeMillis());
		GuavaEventBusFactory.getDefault().eventBus().post(callBack);
	}
}
```

预期执行情况：
```
2018-08-11 20:49:22.728  INFO 27619 --- [           main] c.a.eventbus.EventBusTestApplication     : Started EventBusTestApplication in 1.476 seconds (JVM running for 1.848)
2018-08-11 20:49:24.724  INFO 27619 --- [pool-2-thread-1] com.acvrock.eventbus.ScheduledTasks      : send msg - Sat Aug 11 20:49:24 CST 2018
2018-08-11 20:49:24.725  INFO 27619 --- [pool-1-thread-2] com.acvrock.eventbus.CallNotifyListener  : CallNotifyListener onEvent :1533991764724,CallBack{chid=1, appid=1533991764724}
2018-08-11 20:49:26.726  INFO 27619 --- [pool-2-thread-1] com.acvrock.eventbus.ScheduledTasks      : send msg - Sat Aug 11 20:49:26 CST 2018
2018-08-11 20:49:26.727  INFO 27619 --- [pool-1-thread-3] com.acvrock.eventbus.CallNotifyListener  : CallNotifyListener onEvent :1533991766727,CallBack{chid=1, appid=1533991766727}
```

实际执行情况：
```
2018-08-11 20:51:20.279  INFO 27674 --- [           main] c.a.eventbus.EventBusTestApplication     : Started EventBusTestApplication in 1.062 seconds (JVM running for 1.442)
2018-08-11 20:51:22.271  INFO 27674 --- [pool-2-thread-1] com.acvrock.eventbus.ScheduledTasks      : send msg - Sat Aug 11 20:51:22 CST 2018
2018-08-11 20:51:22.272  INFO 27674 --- [pool-1-thread-3] com.acvrock.eventbus.CallNotifyListener  : CallNotifyListener onEvent :1533991882271,CallBack{chid=1, appid=1533991882271}
2018-08-11 20:51:22.272  INFO 27674 --- [pool-1-thread-4] com.acvrock.eventbus.CallNotifyListener  : CallNotifyListener onEvent :1533991882271,CallBack{chid=1, appid=1533991882271}
2018-08-11 20:51:24.275  INFO 27674 --- [pool-2-thread-1] com.acvrock.eventbus.ScheduledTasks      : send msg - Sat Aug 11 20:51:24 CST 2018
2018-08-11 20:51:24.275  INFO 27674 --- [pool-1-thread-2] com.acvrock.eventbus.CallNotifyListener  : CallNotifyListener onEvent :1533991884275,CallBack{chid=1, appid=1533991884275}
2018-08-11 20:51:24.275  INFO 27674 --- [pool-1-thread-5] com.acvrock.eventbus.CallNotifyListener  : CallNotifyListener onEvent :1533991884275,CallBack{chid=1, appid=1533991884275}
```

可以看到消费者对事件消费了两次，但是通过检查代码发现并没有相关的改动，机器环境也没有变动。   
经过一番定位后发现是编译机器 JDK 版本升级到 JDK 8，新版 javac 编译后字节码有变动。   
导致相同代码和环境下出现了不同的行为。
### 定位过程：   
对代码调用进行跟踪，先从 EventBus.post 方法看起

```java
public void post(Object event) {
    Set<Class<?>> dispatchTypes = flattenHierarchy(event.getClass());

    boolean dispatched = false;
    for (Class<?> eventType : dispatchTypes) {
      subscribersByTypeLock.readLock().lock();
      try {
        Set<EventSubscriber> wrappers = subscribersByType.get(eventType);

        if (!wrappers.isEmpty()) {
          dispatched = true;
          for (EventSubscriber wrapper : wrappers) {
            enqueueEvent(event, wrapper);
          }
        }
      } finally {
        subscribersByTypeLock.readLock().unlock();
      }
    }

    if (!dispatched && !(event instanceof DeadEvent)) {
      post(new DeadEvent(this, event));
    }

    dispatchQueuedEvents();
  }
```

debug 时发现在 JDK 7 环境下，subscribersByType.get(eventType) 只能获取到一个 EventSubscriber 对象，即：onEvent(CallBack event)。   
而在 JDK 8 环境下，subscribersByType.get(eventType) 的确能够获取到两个 EventSubscriber 对象，分别是：onEvent(CallBack event)和onEvent(Object o)，
导致 enqueueEvent 了两次   
subscribersByType 对象是一个类似 Map 结构，用于存储 EventSubscriber 对象，初始化数据的位置在 EventBus.register中：

```java
 public void register(Object object) {
    Multimap<Class<?>, EventSubscriber> methodsInListener =
        finder.findAllSubscribers(object);
    subscribersByTypeLock.writeLock().lock();
    try {
      subscribersByType.putAll(methodsInListener);
    } finally {
      subscribersByTypeLock.writeLock().unlock();
    }
  }
```

这里 findAllSubscribers 的实现是在 AnnotatedSubscriberFinder 类中，逻辑比较简单，先调用  getAnnotatedMethods(clazz) 获取类中有 @Subscribe 注解的方法列表，然后实例化成 EventSubscriber 对象，存进 methodsInListener 并返回。   
JDK 7 环境下 getAnnotatedMethods(clazz) 返回了 onEvent(CallBack event) 方法   
JDK 8 环境下 getAnnotatedMethods(clazz) 返回了 onEvent(CallBack event) 方法和 onEvent(Object o) 方法，但是 onEvent(Object o) 不是我们定义的方法，而是 JDK 实现泛型时生成的桥方法，可以看成是在父类中定义的 onEvent(T t) 擦除泛型转换而来，并没有带 @Subscribe 

```java
  public Multimap<Class<?>, EventSubscriber> findAllSubscribers(Object listener) {
    Multimap<Class<?>, EventSubscriber> methodsInListener = HashMultimap.create();
    Class<?> clazz = listener.getClass();
    for (Method method : getAnnotatedMethods(clazz)) {
      Class<?>[] parameterTypes = method.getParameterTypes();
      Class<?> eventType = parameterTypes[0];
      EventSubscriber subscriber = makeSubscriber(listener, method);
      methodsInListener.put(eventType, subscriber);
    }
    return methodsInListener;
  }
```

getAnnotatedMethods(clazz) 方法中使用了 LoadingCache 缓存，最后获取注解的方法是：getAnnotatedMethodsInternal

```java
 private static ImmutableList<Method> getAnnotatedMethodsInternal(Class<?> clazz) {
    Set<? extends Class<?>> supers = TypeToken.of(clazz).getTypes().rawTypes();
    Map<MethodIdentifier, Method> identifiers = Maps.newHashMap();
    for (Class<?> superClazz : supers) {
      for (Method superClazzMethod : superClazz.getMethods()) {
        if (superClazzMethod.isAnnotationPresent(Subscribe.class)) {
          Class<?>[] parameterTypes = superClazzMethod.getParameterTypes();
          if (parameterTypes.length != 1) {
            throw new IllegalArgumentException("Method " + superClazzMethod
                + " has @Subscribe annotation, but requires " + parameterTypes.length
                + " arguments.  Event subscriber methods must require a single argument.");
          }
          
          MethodIdentifier ident = new MethodIdentifier(superClazzMethod);
          if (!identifiers.containsKey(ident)) {
            identifiers.put(ident, superClazzMethod);
          }
        }
      }
    }
    return ImmutableList.copyOf(identifiers.values());
  }
```

这里关键的一句判断是 superClazzMethod.isAnnotationPresent(Subscribe.class)，isAnnotationPresent是 JDK reflect 包中的方法，经过调试，发现在 JDK 7 中，

```
onEvent(CallBack event) 方法返回 true，
onEvent(Object o) 方法返回 false，
```

而在 JDK 8 中，

```
onEvent(CallBack event) 方法返回 true，
onEvent(Object o) 方法返回 true。
```

导致返回了 onEvent(CallBack event) 和 onEvent(Object o)，并初始化出两个 EventSubscriber。

### 原因
对比两个版本 javac 编译出来的字节码

JDK 7 版本

```
 g6763$ javap -v  CallNotifyListener.class
...
public class com.acvrock.eventbus.CallNotifyListener extends com.acvrock.eventbus.AbstractListener<com.acvrock.eventbus.CallBack>
  minor version: 0
  major version: 51
  flags: ACC_PUBLIC, ACC_SUPER
Constant pool:
   ...
  #26 = Utf8               RuntimeVisibleAnnotations
  #27 = Utf8               Lcom/google/common/eventbus/Subscribe;
  #28 = Utf8               (Ljava/lang/Object;)V
  ...
{
  ...

  public void onEvent(com.acvrock.eventbus.CallBack) throws java.lang.Exception;
    ...
    Exceptions:
      throws java.lang.Exception
    RuntimeVisibleAnnotations:
      0: #27()

  public void onEvent(java.lang.Object) throws java.lang.Exception;
    ...
    Exceptions:
      throws java.lang.Exception
}
...
```
第一个方法 onEvent(com.acvrock.guavatest.CallBack) 有一个 `#27` Subscribe 运行时注解
第二个方法 onEvent(java.lang.Object) 没有带 RuntimeVisibleAnnotations

JDK 8 版本

```
g6763$ javap -v  CallNotifyListener.class 
...
public class com.acvrock.eventbus.CallNotifyListener extends com.acvrock.eventbus.AbstractListener<com.acvrock.eventbus.CallBack>
  minor version: 0
  major version: 51
  flags: ACC_PUBLIC, ACC_SUPER
Constant pool:
  ...
  #26 = Utf8               RuntimeVisibleAnnotations
  #27 = Utf8               Lcom/google/common/eventbus/Subscribe;
  #28 = Utf8               (Ljava/lang/Object;)V
  ...
  
{
  ...
  
  public void onEvent(com.acvrock.eventbus.CallBack) throws java.lang.Exception;
    ...
    Exceptions:
      throws java.lang.Exception
    RuntimeVisibleAnnotations:
      0: #27()

  public void onEvent(java.lang.Object) throws java.lang.Exception;
    ...
    Exceptions:
      throws java.lang.Exception
    RuntimeVisibleAnnotations:
      0: #27()
}
...
```

两个方法都有 运行时注解  `#27()`，也就是 `Subscribe`   
在网上 [JDK-8029563 : Method.getAnnotations() changed its return value in JDK 8.](https://bugs.java.com/bugdatabase/view_bug.do?bug_id=8029563) 这个描述和我们发现的问题是一致的   
导致这一变动的是这个调整
[JDK-6695379 : Copy method annotations and parameter annotations to synthetic bridge methods](https://bugs.java.com/view_bug.do?bug_id=JDK-6695379)，
javac 实现了在编译时，拷贝方法和参数上的注解到桥方法上，也就是 onEvent(java.lang.Object)上，在 JDK 7u80 和 JDK 8b94 后生效

### guava 如何解决

在 guava 18 中就已经解决了这个问题，代码如下：

```java
private static ImmutableList<Method> getAnnotatedMethodsInternal(Class<?> clazz) {
    Set<? extends Class<?>> supers = TypeToken.of(clazz).getTypes().rawTypes();
    Map<MethodIdentifier, Method> identifiers = Maps.newHashMap();
    for (Class<?> superClazz : supers) {
      for (Method superClazzMethod : superClazz.getMethods()) {
        if (superClazzMethod.isAnnotationPresent(Subscribe.class)
            && !superClazzMethod.isBridge()) {
          Class<?>[] parameterTypes = superClazzMethod.getParameterTypes();
          if (parameterTypes.length != 1) {
            throw new IllegalArgumentException("Method " + superClazzMethod
                + " has @Subscribe annotation, but requires " + parameterTypes.length
                + " arguments.  Event subscriber methods must require a single argument.");
          }

          MethodIdentifier ident = new MethodIdentifier(superClazzMethod);
          if (!identifiers.containsKey(ident)) {
            identifiers.put(ident, superClazzMethod);
          }
        }
      }
    }
    return ImmutableList.copyOf(identifiers.values());
  }
```
判断了方法有 Subscribe 注解并且不是桥方法才认为是 subscribe 方法,对应的代码提交记录：
[Fix EventBus to not include bridge methods when registering subscribe](https://github.com/google/guava/commit/32d7dc732dfee93c82942e2d776adbbc02bd85ba#diff-e3fca3176dda68793f07e756ca2f412c)   
真是一个摸不着头脑的 bug

#### 参考
关于桥方法可以参考
[Effects of Type Erasure and Bridge Methods](https://docs.oracle.com/javase/tutorial/java/generics/bridgeMethods.html)
