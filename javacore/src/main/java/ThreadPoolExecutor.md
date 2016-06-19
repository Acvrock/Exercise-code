#线程池

- newFixedThreadPool() 方法:该方法返回一个固定线程数量的线程池. 该线程池中的线程数量始终不变.当有一个新的任务提交时,线程池中若有空闲线
程,则立即执行,若没有,则新的任务会暂存在一个任务队列中,待有线程空闲时,便处理在任务队列中的任务

- newSingleThreadExecutor() 方法:该方法返回一个只有一个线程的线程池,若有多于一个任务被提交到该线程池,任务会被保存在一个任务队列中,待线
程空闲,按先进显出的顺序执行队列中的任务.

- newCachedThreadPool() 方法:该方法返回一个可根据实际情况调节线程数量的线程池,线程池的线程数量不确定,但若有空闲线程可复用,则会优先使用
可复用的线程.若所有线程都在工作,又有新任务提交,则会创建新的线程处理任务,所有线程在当前任务执行完毕后,将返回线程池进行复用.

- newSingleThreadScheduledExecutor() 方法:该方法返回一个 ScheduledExecutorService 对象,线程池大小为1. ScheduledExecutorService
 接口在 ExecutorService 接口之上拓展了在给定时间执行某任务的功能,如在某个固定的延时之后执行,或者周期性执行某个任务.

- newScheduledThreadPool() 方法:该方法也返回一个 ScheduledExecutorService 对象,但该线程池可以指定线程数量.