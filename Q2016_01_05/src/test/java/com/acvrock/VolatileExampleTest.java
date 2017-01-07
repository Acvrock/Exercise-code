package com.acvrock;

import java.util.concurrent.CountDownLatch;

/**
 * Created by moon on 06/01/2017.
 *
 * @Description:
 */
class VolatileExampleTest {



    @org.junit.jupiter.api.Test
    void TesNormalVarCounter() throws InterruptedException {
        int size = 10;  // 10 个线程
        MyCounter counter = new NormalVarCounter();
        final CountDownLatch startCountDownLatch = new CountDownLatch(1);  // 使用 CountDownLatch 让 10 个线程在短时间内竞争
        final CountDownLatch endDownLatch = new CountDownLatch(size);  //使用 CountDownLatch 让主线程等待，不过早结束
        long startTime1 = System.currentTimeMillis();
        for (int i = 0; i < size; i++) {
            new Thread(() -> {
                try {
                    startCountDownLatch.await();   // 使用 CountDownLatch 的 await 让所有线程先停下来
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
                for (int j = 0; j < 100000; j++) {
                    counter.incr();
                    }

                endDownLatch.countDown();

            }).start();
        }

        startCountDownLatch.countDown();   // 上面的 for 为循环 new 线程，但是线程开始后就处于等待状态，这里是调用 countDown，所有线程都马上开始竞争
        endDownLatch.await(); // 让第二个 CountDownLatch 让主线程等待，不过早结束
        long endTime1 = System.currentTimeMillis();
        System.out.println("NormalVarCounter:"+counter.getCurValue()+"程序运行时间：" + (endTime1 - startTime1) + "ms");
    }



    @org.junit.jupiter.api.Test
    void TestVolaitleVarCounter() throws InterruptedException {
        int size = 10;  // 10 个线程
        MyCounter counter = new VolaitleVarCounter();
        final CountDownLatch startCountDownLatch = new CountDownLatch(1);  // 使用 CountDownLatch 让 10 个线程在短时间内竞争
        final CountDownLatch endDownLatch = new CountDownLatch(size);  //使用 CountDownLatch 让主线程等待，不过早结束
        long startTime1 = System.currentTimeMillis();
        for (int i = 0; i < size; i++) {
            new Thread(() -> {
                try {
                    startCountDownLatch.await();   // 使用 CountDownLatch 的 await 让所有线程先停下来
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
                for (int j = 0; j < 100000; j++) {
                    counter.incr();
                }

                endDownLatch.countDown();

            }).start();
        }

        startCountDownLatch.countDown();   // 上面的 for 为循环 new 线程，但是线程开始后就处于等待状态，这里是调用 countDown，所有线程都马上开始竞争
        endDownLatch.await(); // 让第二个 CountDownLatch 让主线程等待，不过早结束
        long endTime1 = System.currentTimeMillis();
        System.out.println("VolaitleVarCounter:"+counter.getCurValue()+"程序运行时间：" + (endTime1 - startTime1) + "ms");
    }

    @org.junit.jupiter.api.Test
    void TestSynchronizeVarCounter() throws InterruptedException {
        int size = 10;  // 10 个线程
        MyCounter counter = new SynchronizeVarCounter();
        final CountDownLatch startCountDownLatch = new CountDownLatch(1);  // 使用 CountDownLatch 让 10 个线程在短时间内竞争
        final CountDownLatch endDownLatch = new CountDownLatch(size);  //使用 CountDownLatch 让主线程等待，不过早结束
        long startTime1 = System.currentTimeMillis();
        for (int i = 0; i < size; i++) {
            new Thread(() -> {
                try {
                    startCountDownLatch.await();   // 使用 CountDownLatch 的 await 让所有线程先停下来
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
                for (int j = 0; j < 100000; j++) {
                    counter.incr();
                }

                endDownLatch.countDown();

            }).start();
        }

        startCountDownLatch.countDown();   // 上面的 for 为循环 new 线程，但是线程开始后就处于等待状态，这里是调用 countDown，所有线程都马上开始竞争
        endDownLatch.await(); // 让第二个 CountDownLatch 让主线程等待，不过早结束
        long endTime1 = System.currentTimeMillis();
        System.out.println("SynchronizeVarCounter:"+counter.getCurValue()+"程序运行时间：" + (endTime1 - startTime1) + "ms");
    }

    @org.junit.jupiter.api.Test
    void TestAtomicLongVarCounter() throws InterruptedException {
        int size = 10;  // 10 个线程
        MyCounter counter = new AtomicLongVarCounter();
        final CountDownLatch startCountDownLatch = new CountDownLatch(1);  // 使用 CountDownLatch 让 10 个线程在短时间内竞争
        final CountDownLatch endDownLatch = new CountDownLatch(size);  //使用 CountDownLatch 让主线程等待，不过早结束
        long startTime1 = System.currentTimeMillis();
        for (int i = 0; i < size; i++) {
            new Thread(() -> {
                try {
                    startCountDownLatch.await();   // 使用 CountDownLatch 的 await 让所有线程先停下来
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
                for (int j = 0; j < 100000; j++) {
                    counter.incr();
                }

                endDownLatch.countDown();

            }).start();
        }

        startCountDownLatch.countDown();   // 上面的 for 为循环 new 线程，但是线程开始后就处于等待状态，这里是调用 countDown，所有线程都马上开始竞争
        endDownLatch.await(); // 让第二个 CountDownLatch 让主线程等待，不过早结束
        long endTime1 = System.currentTimeMillis();
        System.out.println("AtomicLongVarCounter:"+counter.getCurValue()+"程序运行时间：" + (endTime1 - startTime1) + "ms");
    }

    @org.junit.jupiter.api.Test
    void TestLongAdderVarCounter() throws InterruptedException {
        int size = 10;  // 10 个线程
        LongAdderVarCounter counter = new LongAdderVarCounter();
        final CountDownLatch startCountDownLatch = new CountDownLatch(1);  // 使用 CountDownLatch 让 10 个线程在短时间内竞争
        final CountDownLatch endDownLatch = new CountDownLatch(size);  //使用 CountDownLatch 让主线程等待，不过早结束
        long startTime1 = System.currentTimeMillis();
        for (int i = 0; i < size; i++) {
            new Thread(() -> {
                try {
                    startCountDownLatch.await();   // 使用 CountDownLatch 的 await 让所有线程先停下来
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
                for (int j = 0; j < 100000; j++) {
                    counter.incr();
                }

                endDownLatch.countDown();

            }).start();
        }

        startCountDownLatch.countDown();   // 上面的 for 为循环 new 线程，但是线程开始后就处于等待状态，这里是调用 countDown，所有线程都马上开始竞争
        endDownLatch.await(); // 让第二个 CountDownLatch 让主线程等待，不过早结束
        long endTime1 = System.currentTimeMillis();
        System.out.println("LongAdderVarCounter:"+counter.getCurValue()+"程序运行时间：" + (endTime1 - startTime1) + "ms");
    }
}