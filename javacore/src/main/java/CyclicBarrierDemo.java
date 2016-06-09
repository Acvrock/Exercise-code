import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * Created by moon on 16/6/9.
 *
 * @Description: 循环栅栏CyclicBarrier, 和 CountDownLatch 类似,但是功能更强大且复杂
 * InterruptedException 在等待过程中,线程被中断
 * BrokenBarrierException 表示CyclicBarrier已经损坏,无法再等到线程到齐的情况,最好就地散伙,打道回府
 */
public class CyclicBarrierDemo {

    public static class Soldier implements Runnable {
        private String soldier;
        private final CyclicBarrier cyclic;

        public Soldier(CyclicBarrier cyclicBarrier, String soldierName) {
            this.cyclic = cyclicBarrier;
            this.soldier = soldierName;
        }

        public void run() {
            try {
                cyclic.await();  //准备的等待,CyclicBarrier 计数+1
                doWork();
                cyclic.await(); //完成的等待,CyclicBarrier 计数+1
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }

        private void doWork() {
            try {
                Thread.sleep(Math.abs(new Random().nextInt() % 10000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(soldier + ":任务完成");
        }

    }

    public static class BarrierRun implements Runnable {
        boolean flag;
        int N;

        public BarrierRun(boolean flag, int n) {
            this.flag = flag;
            N = n;
        }

        public void run() {
            if (flag) {
                System.out.println("总控制器:[线程:" + N + "个,任务完成!]");
            } else {
                System.out.println("总控制器:[线程:" + N + "个,准备完毕!]");
                flag = true;
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        final int N = 10;
        Thread[] allSoldier = new Thread[N];
        boolean flag = false;
        //创建CyclicBarrier实例,计时器数量为10,而且如果计数器达到指标时,执行BarrierRun任务
        CyclicBarrier cyclicBarrier = new CyclicBarrier(N, new BarrierRun(flag, N));
        System.out.println("开始准备");
        for (int i = 0; i < N; ++i) {
            System.out.println("线程" + i + "准备");
            allSoldier[i] = new Thread(new Soldier(cyclicBarrier, "线程" + i));
//            if(i==5){   //模拟异常情况
//                allSoldier[0].interrupt();
//            }
            allSoldier[i].start();

        }
    }


}
