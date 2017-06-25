package com.acvrock;

/**
 * Created by moon on 25/06/2017.
 *
 * @Description:
 */

import java.util.Queue;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

public  class PrioritizedTaskProducer implements Runnable {
    private Random random = new Random(47);
    private Queue<Runnable> queue;
    private ExecutorService exec;

    public PrioritizedTaskProducer(Queue<Runnable> queue, ExecutorService exec) {
        this.queue = queue;
        this.exec = exec;
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            queue.add(new PrioritizedTask(random.nextInt(10))); // 往PriorityBlockingQueue中添加随机优先级的任务
            Thread.yield();
        }
        try {
            for (int i = 0; i < 10; i++) {
                TimeUnit.MILLISECONDS.sleep(250);
                queue.add(new PrioritizedTask(10)); // 往PriorityBlockingQueue中添加优先级为10的任务
            }
            for (int i = 0; i < 10; i++) {
                queue.add(new PrioritizedTask(i));// 往PriorityBlockingQueue中添加优先级为1-10的任务
            }
            queue.add(new PrioritizedTask.EndSentinel(exec));
        } catch (InterruptedException e) {}
        System.out.println("Finished PrioritizedTaskProducer");
    }
}
