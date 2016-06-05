import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by moon on 16/6/5.
 *
 * @Description: 重入锁
 */
public class ReenterLock implements Runnable {
    public static ReentrantLock lock = new ReentrantLock();
    public static int i = 0;

    /**
     * When an object implementing interface <code>Runnable</code> is used
     * to create a thread, starting the thread causes the object's
     * <code>run</code> method to be called in that separately executing
     * thread.
     * <p>
     * The general contract of the method <code>run</code> is that it may
     * take any action whatsoever.
     *
     * @see Thread#run()
     */
    public void run() {
        for (int j = 0; j < 10000000; j++) {
            lock.lock();
            try {
                i++;
            } finally {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ReenterLock reeterLock = new ReenterLock();
        Thread t1 = new Thread(reeterLock);
        Thread t2 = new Thread(reeterLock);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(i); //如果运行正常,此处输出20000000;

    }
}
