import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by moon on 6/19/16.
 *
 * @Description: 线程池
 */
public class ThreadPoolDemo {
    public static class MyTask implements Runnable {

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
            System.out.println(System.currentTimeMillis() + ",Thread.currentThread().getId() = " + Thread.currentThread().getId());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        MyTask task = new MyTask();
        ExecutorService executorService = Executors.newFixedThreadPool(5);   //固定长队的线程池
        for (int i = 0; i < 10; i++) {
            executorService.submit(task);
        }
    }
}
