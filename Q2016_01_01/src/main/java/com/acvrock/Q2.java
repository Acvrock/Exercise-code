package com.acvrock;

/**
 * Created by moon on 04/12/2016.
 *
 * @Description:
 */
public class Q2 {
    public static void main(String[] args) {
        int a = -1024;
        Integer 右位移 = a >> 1;
        Integer 无符号右移 = a >>> 1;
        System.out.println(a);
        System.out.println(Integer.toBinaryString(a));
        System.out.println(右位移);
        System.out.println(Integer.toBinaryString(右位移));
        System.out.println(无符号右移);
        System.out.println(Integer.toBinaryString(无符号右移));
    }
}
