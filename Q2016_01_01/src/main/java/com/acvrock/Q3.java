package com.acvrock;

import java.util.Date;
import java.util.Random;

/**
 * Created by moon on 04/12/2016.
 *
 * @Description:
 */
public class Q3 {
    public static void main(String[] args) {
        byte[][] b = new byte[10240][10240];
        Random random = new Random();
        for (byte[] bytes : b) {
            random.nextBytes(bytes);
        }
        long start = new Date().getTime();
        int row = 10240;
        for (int i = 0; i < row; i++) {
            for (int i1 = 0; i1 < row; i1++) {
                byte ll = b[i][i1];

            }
        }
        long end = new Date().getTime();
        System.out.println(end - start);

        long start1 = new Date().getTime();
        for (int i = 0; i < row; i++) {
            for (int i1 = 0; i1 < row; i1++) {
                byte ll = b[i1][i];
            }
        }
        long end1 = new Date().getTime();
        System.out.println(end1 - start1);
    }
}
