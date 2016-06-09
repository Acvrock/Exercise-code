import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by moon on 16/6/9.
 *
 * @Description:倒计数器,多线程控制工具类,让某个线程先等待,等到计数结束后才执行
 */
public class CountDownLatchDemo implements Runnable {
    static final CountDownLatch end = new CountDownLatch(10);
    static final CountDownLatchDemo demo = new CountDownLatchDemo();

    public void run() { //模拟检查任务
        try {
            Thread.sleep(new Random().nextInt(10) * 1000);
            System.out.println("check complete");
            end.countDown();  //检查任务后进行检查通过计数
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 模拟火箭发射前的检查工作
     *
     * @param args
     * @throws InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 10; i++) {   //发出检查指令
            executorService.submit(demo);
        }
        end.await();  //等待检查
        System.out.println("Fire!");  //检查成功后该线程自动执行
        executorService.shutdown();
    }
}
