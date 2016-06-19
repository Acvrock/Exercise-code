import java.util.concurrent.locks.LockSupport;

/**
 * Created by moon on 16/6/9.
 *
 * @Description: 线程阻塞工具类 LockSupport
 * LockSupport是用来创建锁和其他同步类的基本线程阻塞原语。
 * LockSupport中的park() 和 unpark() 的作用分别是阻塞线程和解除阻塞线程，
 * 而且park()和unpark()不会遇到“Thread.suspend 和 Thread.resume所可能引发的死锁”问题。
 * // 返回提供给最近一次尚未解除阻塞的 park 方法调用的 blocker 对象，如果该调用不受阻塞，则返回 null。
 * static Object getBlocker(Thread t)
 * // 为了线程调度，禁用当前线程，除非许可可用。
 * static void park()
 * // 为了线程调度，在许可可用之前禁用当前线程。
 * static void park(Object blocker)
 * // 为了线程调度禁用当前线程，最多等待指定的等待时间，除非许可可用。
 * static void parkNanos(long nanos)
 * // 为了线程调度，在许可可用前禁用当前线程，并最多等待指定的等待时间。
 * static void parkNanos(Object blocker, long nanos)
 * // 为了线程调度，在指定的时限前禁用当前线程，除非许可可用。
 * static void parkUntil(long deadline)
 * // 为了线程调度，在指定的时限前禁用当前线程，除非许可可用。
 * static void parkUntil(Object blocker, long deadline)
 * // 如果给定线程的许可尚不可用，则使其可用。
 * static void unpark(Thread thread)
 */
public class LockSupportDemo {
    public static Object u = new Object();
    static ChangeObjectThread t1 = new ChangeObjectThread("t1");
    static ChangeObjectThread t2 = new ChangeObjectThread("t2");

    //    static ChangeObje
    public static class ChangeObjectThread extends Thread {

        public ChangeObjectThread(String name) {
            super(name);
        }

        @Override
        public void run() {
            synchronized (u) {
                System.out.println("ChangeObjectThread.run in " + getName());
                LockSupport.park();
                System.out.println("unpark,ChangeObjectThread.run in " + getName());
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        t1.start();             //t1 线程启动,但是打印出 ChangeObjectThread.run in t1 后进行等待
        Thread.sleep(1000);     //main 线程停止一段时间
        t2.start();             //t2 线程启动,但是这时候 t1 拥有了 u 对象的锁,所以无法进入代码块执行
        LockSupport.unpark(t1); //t1 再次启动,打印出 unpark,ChangeObjectThread.run in t1 ,释放 u 对象
        LockSupport.unpark(t2); //t2 获得 u 对象的锁,执行代码块打印出ChangeObjectThread.run in t2 后进行等待,又再次启动,打印出unpark,ChangeObjectThread.run in t2
        t1.join();              // t1 线程把 main 线程加入到当前线程, t1 执行完毕后 main 线程才开始执行
        t2.join();              // t2 线程把 main 线程加入到当前线程, t2 执行完毕后 main 线程才开始执行
        System.out.println("main running");   //t1 t2 执行完毕,main线程接下去执行
    }
}
