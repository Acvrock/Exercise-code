package com.acvrock;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Created by moon on 14/01/2017.
 *
 * @Description:
 */

public class S1_0 {
    static ArrayList<String> datas = new ArrayList<String>();
    static Lock lock = new ReentrantLock();
    public static void main(String[] args) throws InterruptedException {
        List<Thread> threads = IntStream.range(1, 10).mapToObj(i -> {
            if (i % 2 == 0) {
                return new MThread("consumer " + i);
            } else return new NThread("producer " + i);
        }).filter(t -> {
            t.start();
            return true;
        }).collect(Collectors.toList());
        threads.forEach(t -> {
            try {
                t.join();
            } catch (InterruptedException e) {

            }
        });

    }
    static class MThread extends Thread {
        public MThread(String string) {
            this.setName(string);
        }
        public void run() {
            while (true) {
                S1_0.lock.lock();
                try {
                    if (!TestOnly.datas.isEmpty()) {
                        TestOnly.datas.forEach(s -> System.out.println(Thread.currentThread().getName()+" 消费:" + s));
                        TestOnly.datas.clear();
                    }
                } finally {
                    S1_0.lock.unlock();
                }
            }
        }
    }
    static class NThread extends Thread {
        public NThread(String string) {
            this.setName(string);
        }
        public void run() {
            while (true) {
                S1_0.lock.lock();
                try {
                    if (TestOnly.datas.size() < 2) {
                        IntStream.range(0, 2).forEach(i ->
                        {
                            TestOnly.datas.add(i+"");
                            System.out.println(Thread.currentThread().getName()+" 生产:" + i);
                        });
                    }
                } finally {
                    S1_0.lock.unlock();
                }
            }
        }
    }
}