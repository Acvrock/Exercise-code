package com.acvrock;

/**
 * Created by moon on 07/01/2017.
 *
 * @Description: 悲观锁实现，Synchronized 是通过对象内部的一个叫做监视器锁（monitor）来实现的，但是也有如锁粗化（Lock Coarsening）、锁消除（Lock Elimination）、轻量级锁（Lightweight Locking）、偏向锁（Biased Locking）、适应性自旋（Adaptive Spinning）等技术来减少锁操作的开销
 */
public class SynchronizeVarCounter implements MyCounter {
    private  long value;
    @Override
    public synchronized void incr() {
        value++;
    }

    @Override
    public synchronized long getCurValue() {
        return value;
    }
}
