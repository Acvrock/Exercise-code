package com.acvrock.mail;

import java.util.Collection;
import java.util.Collections;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.PriorityBlockingQueue;

/**
 * Created by moon on 25/06/2017.
 *
 * @Description:
 */
public class SendMailHandler {
    private static final ExecutorService exec = Executors.newFixedThreadPool(1);
    private static final PriorityBlockingQueue<MailTask> queue = new PriorityBlockingQueue<>();

    static {
        exec.execute(new SendMailTaskConsumer(queue)); // 步骤是同时进行的，因而输出结果并不一定是有序的
        queue.addAll(getQueueFromFile());
    }


    public static boolean send(String content, Integer i) {
        if (queue.size() > 2) {
            System.out.println("\n队列内邮件数量超过2，请密切关注");
        }
        return queue.add(new MailTask(content, i));// 往PriorityBlockingQueue中添加优先级为1-10的任务
    }

    public static void finished() {
        exec.shutdownNow();
        saveQueueToFile(queue);
    }

    private static Collection<? extends MailTask> getQueueFromFile() {
        return Collections.EMPTY_LIST;
    }

    private static void saveQueueToFile(PriorityBlockingQueue<MailTask> queue) {
        MailTask[] mailTasks = queue.toArray(new MailTask[queue.size()]);
        String out = "";
        for (MailTask task : mailTasks) {
            out = out + task.summary();
        }
        System.out.println("saveQueueToFile:" + out);
    }
}
