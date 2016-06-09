import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created by moon on 16/6/9.
 *
 * @Description:读写锁
 */
public class ReadWriteLockDemo {
    private static Lock lock = new ReentrantLock();
    private static ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
    private static Lock readLock = reentrantReadWriteLock.readLock();
    private static Lock writeLock = reentrantReadWriteLock.writeLock();
    private int value;

    public Object handleRead(Lock lock) throws InterruptedException {
        try {
            lock.lock();          //模拟读操作
            Thread.sleep(1000);   //模拟非常耗时操作
            return value;
        } finally {
            lock.unlock();
        }
    }

    public void handleWrite(Lock lock, int index) throws InterruptedException {
        try {
            lock.lock();         //模拟写操作
            Thread.sleep(1000);  //模拟非常耗时操作
            value = index;
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        final ReadWriteLockDemo demo = new ReadWriteLockDemo();
        Runnable readRunnale = new Runnable() {
            public void run() {
                try {
                    demo.handleRead(readLock);   //读线程,读写操作分别加锁,大概2秒左右能够执行完毕
//                    demo.handleRead(lock);     //读线程,读写都会等待,大概需要20秒左右能够执行完毕
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        final Runnable writeRunnale = new Runnable() {
            public void run() {
                try {
                    demo.handleWrite(writeLock, new Random().nextInt());  //写线程,读写操作分别加锁,大概2秒左右能够执行完毕
//                demo.handleWrite(lock,new Random().nextInt());    //写线程,读写都会等待,大概需要20秒左右能够执行完毕
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        for (int i = 0; i < 18; i++) {
            new Thread(readRunnale).start();
        }

        for (int i = 18; i < 20; i++) {
            new Thread(writeRunnale).start();
        }
    }
}
