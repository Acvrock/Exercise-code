package com.acvrock;

/**
 * Created by moon on 12/01/2017.
 *
 * @Description:
 */
public class TestSynchronized {
    public static void main(String[] args) {
        testS3();
    }

    public void testS0() {
        synchronized (TestSynchronized.class) {
            int i = 0;
        }
    }

    public void testS1() {
      testS2();
    }

    public synchronized void testS2() {
    }

    public static synchronized void testS3() {
        int i = 0;
        int b=3;
    }
}
