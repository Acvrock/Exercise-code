package com.acvrock;

import java.util.concurrent.CountDownLatch;

/**
 * Created by moon on 06/01/2017.
 *
 * @Description:
 */
class VolatileExampleTest {

    long a = 0;
    volatile long b = 0;
    volatile boolean flag = true;


    @org.junit.jupiter.api.Test
    void Testwriter() throws InterruptedException {
        int size = 2000;  // 100 个线程
        final CountDownLatch startCountDownLatch = new CountDownLatch(1);  // 使用 CountDownLatch 让 100 个线程在短时间内竞争
        final CountDownLatch endDownLatch = new CountDownLatch(size);  //使用 CountDownLatch 让主线程等待，不过早结束
        
        for (int i = 0; i < size; i++) {
            new Thread() {
                public void run() {
                    try {
                        startCountDownLatch.await();   // 使用 CountDownLatch 的 await 让所有线程先停下来
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                    for (int j = 0; j < 100; j++) {
//                        if(b>=0) {
                            System.out.println(Thread.currentThread().getId() + "->" + b+ "->"+a);
                            a++;
//                        flag=flag;
                            b++;
                            System.out.println(Thread.currentThread().getId() + "->>" + b+ "->"+a);
                        }
//                    }

                    endDownLatch.countDown();

                }
            }.start();
        }

        startCountDownLatch.countDown();   // 上面的 for 为循环 new 线程，但是线程开始后就处于等待状态，这里是调用 countDown，所有线程都马上开始竞争
        endDownLatch.await(); // 让第二个 CountDownLatch 让主线程等待，不过早结束

        System.out.println(b);
        System.out.println(a);
    }

}