package com.acvrock;

import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by moon on 07/01/2017.
 *
 * @Description: 乐观锁实现，volatile+CAS 实现，更新不成功继续循环更新，效率比每次都加锁(悲观锁)高很多的
 */
public class AtomicLongVarCounter implements MyCounter {

    private AtomicLong value = new AtomicLong(0);
    @Override
    public void incr() {
        value.incrementAndGet();
    }

    @Override
    public long getCurValue() {
        return value.longValue();
    }
}
