package com.acvrock;

import java.util.concurrent.atomic.LongAdder;

/**
 * Created by moon on 07/01/2017.
 *
 * @Description:
 * 对比 AtomicLong ，LongAdder 采取的措施是：减少并发，将单一 value 的更新压力分担到多个 value 中去，降低单个 value 的 “热度”，分段更新
 * 低并发时 LongAdder 和 AtomicLong 性能差不多，高并发时 LongAdder 更高效！
 */
public class LongAdderVarCounter implements MyCounter {
    LongAdder longAdder =  new LongAdder();
    @Override
    public void incr() {
        longAdder.increment();
    }

    @Override
    public long getCurValue() {
        return longAdder.longValue();
    }
}
