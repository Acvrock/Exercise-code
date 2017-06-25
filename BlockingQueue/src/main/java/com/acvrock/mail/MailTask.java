package com.acvrock.mail;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by moon on 25/06/2017.
 *
 * @Description:
 */
public class MailTask implements Comparable<MailTask> {

    private int errorCount = 0;
    private int priority;
    private final String content;

    protected static List<MailTask> sequence = new ArrayList<>();

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public int getErrorCount() {
        return errorCount;
    }

    public void setErrorCount(int errorCount) {
        this.errorCount = errorCount;
    }

    public MailTask(String content, Integer priority) {
        this.priority = priority;
        this.content = content;
        synchronized (sequence) {
            sequence.add(this);
        }
    }

    @Override
    public int compareTo(MailTask o) {
        return priority < o.priority ? 1 : (priority > o.priority ? -1 : 0);  // 定义优先级计算方式
    }

    @Override
    public String toString() {
        return String.format(" Thread " + Thread.currentThread().getId() + "content : " + content);
    }

    public String summary() {
        return "priority : " + priority + "content : " + content + ")";
    }


    public void send() {
        synchronized (sequence) {
            for (MailTask task : sequence) {
                System.out.print(task.priority + " ");
            }
            System.out.print("\n");
            System.out.println(this);
            sequence.remove(this);
        }
    }
}
