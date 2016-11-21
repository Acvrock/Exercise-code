1. Lambda  
2. Stream API  
3. JavaFX API  
4. time API   
5. 并发 API  
6. Nashorn 引擎  
7.   


接口经常会重新声明 Object 类中的方法，而这些方法声明并不是抽象的   
Java 8 中接口可以声明非抽象的方法   
不能将一个 lambda 表达式赋值给一个 Object 类型的变量，因为 Object 不是一个函数式接口   
函数式接口在 java.util.function 包中   
使用 @FuntionalInterface 注解   
两种方式处理 lambda 中的异常，1：捕获、2:将 lambda 表达式赋给一个其抽象方法可以抛出异常的接口，例如 Callable   

方法引用：如果只想传递一个方法过去执行，可以使用方法引用， x->System.out.println(x); == System.out::println   
方法引用有三种情况：    
- 对象::实例方法   
- 类::静态方法     
- 类::实例方法   

构造器引用   
构造器引用和方法引用类似，不过写法为：   
- 类::new    

lambda 表达式构成：   
1. 一段代码   
2. 参数     
3. 自由变量的值   

含有自由变量的代码块被称为 “闭包”(closure)   
lambda 表达式中，被引用的变量的值不可以被改变   
lambda 表达式的方法体和嵌套代码块有着相同的作用域，所以有相同的命名冲突和屏蔽规则   

默认方法：如果接口需要添加新方法时，所有的实现类都必须要实现该方法，但是在 Java8 中可以通过默认方法来解决这个问题   
如果接口中的默认方法和其他父类或者接口的方法冲突，有以下解决方法   
1. 其他父类冲突，选择父类的方法   
2. 接口冲突，覆盖该方法来解决冲突,程序员手动指定要使用哪个默认方法   
优先使用类中的方法，即“类优先”原则   

接口中可以声明一些静态方法   

迭代器意味着特定的遍历策略，禁制了高效的并发执行    
从集合中创建 Stream   
使用 filter 选择元素，使用 map 改变元素      
使用 limit、distinct、sorted 改变元素   
使用 reduction 操作符获得结果，如 count、max、min、findFirst、findAny、orElse   
使用 Optional 类型安全代替 null 借助 ifPresent 和 orElse 方法   
使用 Collectors 类中的 groupingBy 和 partitioningBy 方法对 Stream 进行分组   
Java8 默认对原始类型提供了专门的 Stream，如 ing、long、double   
使用并行 Stream 时，请保证他不带有副作用，并且不保证排序约定   

Stream 和 集合的区别：  
1. Stream 自己不会存储元素
2. Stream 操作符不会改变源对象
3. Stream 操作符可能延迟执行

使用 Stream 过程   
1. 创建一个 Stream
2. 在1～N 个步骤中，制定将 Stream 转换成另外一个 Stream 的中间操作
3. 使用终止操作产生一个结果，该操作会让之前的中间操作立即强制执行，之后该 Stream 就不会再被使用了

创建 Stream 方法
1. java.util.stream.Stream.of 方法
2. Stream.empty
3. Stream.generate