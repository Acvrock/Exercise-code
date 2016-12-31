IOC 底层原理使用到的技术
1. 定义 xml 配置文件
2. dom4j 解析 xml
3. 创建工厂设计模式  
4. 反射创建类对象   

Bean 配置方式：
1. xml 方法
2. 注解

Bean 实例化方式
1. 使用类的的无参数构造方式  使用类名
2. 使用静态工厂方法   factory-method
3. 使用实例工厂方法    factory-bean    factory-method

Bean 标签常用属性   
1. ID 属性
2. Class 属性
3. Name 属性    和 ID 比较：Name 可以包含特殊符号
4. Scope 属性
   -  singleton   单例   
   -  prototype   原型    
   -  request   
   -  session   
   -  globalSession   

属性注入的方式   
1. 使用 set 方式注入  property:     name,value/ref、p:name        
2. 有参构造方法注入   constructor-arg    

Spring 和 web 项目的整合   
实现原理   
1. ServletContext 对象实例化时各种事件
2. 配置对象创建监听器   