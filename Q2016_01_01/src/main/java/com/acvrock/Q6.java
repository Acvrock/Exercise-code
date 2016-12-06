package com.acvrock;

import java.util.*;

/**
 * Created by moon on 06/12/2016.
 *
 * @Description:
 */
public class Q6 {
    public static void main(String[] args) {
//        new byte[1 << 16]
        Random random = new Random();
        List<int[]> arrays = new ArrayList<>();
        arrays.add(random.ints().limit(1 << 20).toArray());
        arrays.add(random.ints().limit(1 << 19).toArray());
        arrays.add(random.ints().limit(1 << 18).toArray());
        arrays.add(random.ints().limit(1 << 17).toArray());
        arrays.add(random.ints().limit(1 << 16).toArray());
        arrays.add(random.ints().limit(1 << 15).toArray());
        arrays.add(random.ints().limit(1 << 14).toArray());
        arrays.add(random.ints().limit(1 << 13).toArray());
        arrays.add(random.ints().limit(1 << 12).toArray());
        arrays.add(random.ints().limit(1 << 11).toArray());
        arrays.add(random.ints().limit(1 << 10).toArray());
        arrays.add(random.ints().limit(1 << 9).toArray());
        arrays.add(random.ints().limit(1 << 8).toArray());
        arrays.add(random.ints().limit(1 << 7).toArray());
        arrays.add(random.ints().limit(1 << 6).toArray());
        arrays.add(random.ints().limit(1 << 5).toArray());
        arrays.add(random.ints().limit(1 << 4).toArray());
        arrays.add(random.ints().limit(1 << 3).toArray());
        arrays.add(random.ints().limit(1 << 2).toArray());
        arrays.add(random.ints().limit(1 << 1).toArray());

        for (int i = 0; i < arrays.size(); i++) {
            long start1 = new Date().getTime();
            for (int j = 0; j <(1 << (i+1)); j++) {
                Arrays.parallelSort(arrays.get(i));
            }
            long end1 = new Date().getTime();
            System.out.println(end1 - start1+"::: "+arrays.get(i).length);
        }
    }
}
