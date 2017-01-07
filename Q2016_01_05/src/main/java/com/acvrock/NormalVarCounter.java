package com.acvrock;

/**
 * Created by moon on 07/01/2017.
 *
 * @Description: 无任何锁的变量，多线程共享时会出现操作丢失
 */
public class NormalVarCounter implements MyCounter {
    private long value;//根据需要进行替换
    @Override
    public void incr() {
        value++;
    }

    @Override
    public long getCurValue() {
        return value;
    }
}
