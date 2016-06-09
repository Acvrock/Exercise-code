import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by moon on 16/6/9.
 *
 * @Description: Condition 使用
 * await() 使当前线程等待,同时释放当前锁,或者当线程被中断时,也能跳出等待
 * awaitUninterruptibly() 和await()方法相同,但是不响应中断
 * singal() 用于唤醒一个在等待中的线程
 * singalAll() 用于唤醒在等待中的所有线程
 */
public class ReenterLockCondition implements Runnable {

    public static ReentrantLock lock = new ReentrantLock();
    public static Condition condition = lock.newCondition();   //生成一个和 lock 绑定的 Condition 对象

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
        try {
            lock.lock();
            System.out.println("Thread is lock ...");
            condition.await();   //线程释放这把锁
            System.out.println("Thread is going on...");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ReenterLockCondition reenterLockCondition = new ReenterLockCondition();
        Thread t1 = new Thread(reenterLockCondition);
        t1.start();
        Thread.sleep(2000);
        lock.lock();
        System.out.println("main Thread is going on ...");
        condition.signal();  //向 main 线程发出通知,告知等待在 Condition 上的线程可以继续执行,系统从 Condition 对象的等待队列中,唤醒一个线程
        lock.unlock();  //main 线程释放锁,Condition 上的线程才能获得锁继续执行,否则Condition唤醒的线程会继续等待
    }
}
