package com.acvrock;

import java.util.Arrays;

/**
 * Created by moon on 29/01/2017.
 *
 * @Description:
 */
public class UnicodeTest {
    public static void main(String[] args) {
        String c = "\uD83D\uDE04";
        System.out.println(c);
        System.out.println(c.length());
        System.out.println(c.codePointCount(0, c.length()));
        System.out.println(c.codePointAt(0));
//        c.codePointAt(0).
        System.out.println(new String(new int[]{c.codePointAt(0)}, 0, 1));
//        System.out.println(c.codePointAt(1));
        System.out.println(c.charAt(0));
        System.out.println(Arrays.toString(c.getBytes()));
    }
}
