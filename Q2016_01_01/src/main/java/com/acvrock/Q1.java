package com.acvrock;

/**
 * Created by moon on 04/12/2016.
 *
 * @Description:
 */
public class Q1 {
    public static void main(String[] args) {
        byte ba = 127;
        short bb = (short) (ba<<2);
        System.out.println(Integer.toBinaryString(ba));
        System.out.println(Integer.toBinaryString(bb));
        System.out.println(bb);
    }
}
