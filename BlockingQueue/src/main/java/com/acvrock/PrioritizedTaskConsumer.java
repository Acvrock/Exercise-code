package com.acvrock;

import java.util.concurrent.PriorityBlockingQueue;

/**
 * Created by moon on 25/06/2017.
 *
 * @Description:
 */
public class PrioritizedTaskConsumer implements Runnable {
    private PriorityBlockingQueue<Runnable> queue;

    public PrioritizedTaskConsumer(PriorityBlockingQueue<Runnable> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                queue.take().run(); // 任务的消费者，从PriorityBlockingQueue中取出任务执行
            }
        } catch (InterruptedException e) {
        }
        System.out.println("Finished PrioritizedTaskConsumer");
    }
}