package com.acvrock.mail;

import java.util.concurrent.PriorityBlockingQueue;

/**
 * Created by moon on 25/06/2017.
 *
 * @Description:
 */
public class SendMailTaskConsumer implements Runnable {
    private PriorityBlockingQueue<MailTask> queue;

    public SendMailTaskConsumer(PriorityBlockingQueue<MailTask> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while (!Thread.interrupted()) {
            MailTask task = null;
            try {
                task = queue.take();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                task.send();// 任务的消费者，从PriorityBlockingQueue中取出任务执行
            } catch (Exception e) {
                task.setErrorCount(task.getErrorCount() + 1);
                if (task.getErrorCount() > 10) {
                    System.out.println("重试次数超过10次，移除该任务");
                } else {
                    // 发生错误时记录，去除优先级，重新发送
                    task.setPriority(1);  //设置优先级防止发送状态不佳的任务不断抢占资源
                    queue.add(task);
                }
            }
        }
        System.out.println("Finished SendMailTaskConsumer");
    }

}



