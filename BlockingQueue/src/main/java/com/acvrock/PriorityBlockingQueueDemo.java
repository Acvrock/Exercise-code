package com.acvrock;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.PriorityBlockingQueue;

/**
 * Created by moon on 25/06/2017.
 *
 * @Description:
 */
public class PriorityBlockingQueueDemo {
    public static void main(String[] args) throws Exception {
        ExecutorService exec = Executors.newFixedThreadPool(2);
        PriorityBlockingQueue<Runnable> queue = new PriorityBlockingQueue<>();
        exec.execute(new PrioritizedTaskProducer(queue, exec)); // 这里需要注意，往PriorityBlockingQueue中添加任务和取出任务的
        exec.execute(new PrioritizedTaskConsumer(queue)); // 步骤是同时进行的，因而输出结果并不一定是有序的
    }
}


