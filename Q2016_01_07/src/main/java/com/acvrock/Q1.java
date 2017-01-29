package com.acvrock;

import java.util.concurrent.SynchronousQueue;

/**
 * Created by moon on 29/01/2017.
 *
 * @Description:
 */
public class Q1 {
    public static void main(String[] args) throws InterruptedException {
        final SynchronousQueue<String> queue = new SynchronousQueue();

        new Thread(new Runnable() {
            public void run() {
                while (true) {
                    // 线程运行到queue.take()阻塞，直到Product生产一个产品queue.offer。
                    try {
                        System.out.println("Thread 消费了一个产品:" + queue.take());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("------------------------------------------");
                }
            }
        }).start();
        Thread.sleep(4000);

        if (queue.offer("S1")) {
            System.out.println("scucess");
        } else {
            System.out.println("faield");
        }
    }
}
