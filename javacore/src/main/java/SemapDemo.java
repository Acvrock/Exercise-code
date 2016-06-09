import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * Created by moon on 16/6/9.
 *
 * @Description:信号量使用
 */
public class SemapDemo implements Runnable {
    final Semaphore semp = new Semaphore(5);  //允许信号量为5,同时只能有5个线程进入代码段

    public void run() {
        try {
            semp.acquire();   //申请信号量
            Thread.sleep(2000);  //模拟耗时操作
            System.out.println(Thread.currentThread().getId() + ":done!");
            semp.release();   //释放信号量
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(20);
        final SemapDemo demo = new SemapDemo();
        for (int i = 0; i < 20; i++) {
            executorService.submit(demo);
        }
    }
}
