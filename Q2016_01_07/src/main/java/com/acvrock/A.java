package com.acvrock;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by moon on 31/01/2017.
 *
 * @Description:
 */
public class A {
    private int code;

    public A(int code) {
        this.code = code;
    }

    public int get() {
        return code;
    }

    public static void main(String[] args) throws Exception {
        Map map = new HashMap();
// 往map里放1w个从1开始的A对象
        while (true) {
            Collection<A> values = map.values();
            for (A a : values) {
                if (!map.containsKey(a.get())) {
// 不可能发生，所以可以随便打点什么
                }
                Thread.sleep(1);
            }
        }
    }
}