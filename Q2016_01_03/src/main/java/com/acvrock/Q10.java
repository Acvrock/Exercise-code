package com.acvrock;

import java.util.IdentityHashMap;

/**
 * Created by moon on 24/12/2016.
 *
 * @Description:
 */
public class Q10 {
    public static void main(String[] args) {
        IdentityHashMap<Object, Object> map = new IdentityHashMap();
        Integer a=5;
        Integer b=5;
        map.put(a,"100");
        map.put(b,"100");
        System.out.println(map.size());
        map.clear();
        a = Integer.MAX_VALUE - 1;
        b = Integer.MAX_VALUE - 1;
        map.put(a,"100");
        map.put(b,"100");
        System.out.println(map.size());
        map.clear();
        a = 127;
        b = 127;
        map.put(a,"100");
        map.put(b,"100");
        System.out.println(map.size());
        map.clear();
        a = 128;
        b = 128;
        map.put(a,"100");
        map.put(b,"100");
        System.out.println(map.size());
    }
}
