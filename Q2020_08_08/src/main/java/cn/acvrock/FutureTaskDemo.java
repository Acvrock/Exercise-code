package cn.acvrock;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

/**
 * Created by panjinghong on 2020/8/8.
 */
public class FutureTaskDemo {

    public static void main(String[] args) {
         ExecutorService executor = Executors.newCachedThreadPool();
         Task task = new Task();
         FutureTask<Integer> futureTask = new FutureTask<>(task);
        // 提交futureTask对象进入线程池
        executor.submit(futureTask);
        // 关闭线程池
        executor.shutdown();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        }

        System.out.println("主线程在执行任务");

        try {
            // 获取futuretask结果
            System.out.println("task运行结果" + futureTask.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        System.getSecurityManager();
        System.out.println("所有任务执行完毕");
    }
}
