问题：
![](6ECB49A79D15F77866CB692C7CD83005.png)

```

```

参考：[ spring 之脱离容器管理创建的对象进行依赖注入](http://blog.csdn.net/doctor_who2004/article/details/46525361)

工程使用 Spring boot 搭建，运行参数：```-javaagent:classFileTransformer-1.0-SNAPSHOT.jar```
![](QQ20161029-0@2x.png)
classFileTransformer-1.0-SNAPSHOT.jar的核心代码如下：
![](QQ20161029-1@2x.png)
运行结果：
![](88822B21-CF85-4E4E-8AF1-1C0EC38C0B47.png)