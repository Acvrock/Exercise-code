import java.util.concurrent.locks.LockSupport;

/**
 * Created by moon on 6/19/16.
 *
 * @Description: LockSupport.park() 支持中断影响,不抛出异常而是返回,可以通过 Thread.interrupted() 捕获到中断标记
 */
public class LockSupportIntDemo {
    public static Object u = new Object();
    static ChangeObjectThread t1 = new ChangeObjectThread("t1");
    static ChangeObjectThread t2 = new ChangeObjectThread("t2");

    public static class ChangeObjectThread extends Thread {

        public ChangeObjectThread(String name) {
            super(name);
        }

        @Override
        public void run() {
            synchronized (u) {
                System.out.println("run in = " + getName());
                LockSupport.park();
                if (Thread.interrupted()) {
                    System.out.println(getName() + "被中断了");
                }
            }
            System.out.println(getName() + "执行结束");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        t1.start();              // t1 启动,打印出 run in = t1 后进行等待
        Thread.sleep(100);       // main 线程等待一段时间
        t2.start();              // t2 启动,无法获得 u 对象锁而等待
        t1.interrupt();          // 被block的线程(sleep() or join())在被调用interrupt时会产生InterruptException，此时是否终止线程由本线程自己决定
        LockSupport.unpark(t2);  //t1 不会抛出异常而是退出执行,t2 打印出run in = t2 后等待,再次启动后打印出t2执行结束
    }
}
