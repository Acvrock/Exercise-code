# Java 多线程编程   

并行计算（服务）    
及时响应（非阻塞）    

锁     
1. 准入控制，一次只允许一个线程进入    
2. 内存可见性，确保多线程间的 Happens-before    

Java 线程很重三个方法    

- interrupt: 置线程的中断状态   
- isInterrupt：判断线程是否中断    
- interrupted 返回线程上次的中断状态，并清除中断状态   
