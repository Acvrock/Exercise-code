package com.acvrock;

/**
 * Created by moon on 07/01/2017.
 *
 * @Description: volatile 变量在读的时候和普通变量差异很小，但是在写时会有性能消耗，能够保证变量在不同线程之间可见，但是无法保证原子性
 */
public class VolaitleVarCounter implements MyCounter {
    private volatile long value;
    @Override
    public void incr() {
        value++;
    }

    @Override
    public long getCurValue() {
        return value;
    }
}
