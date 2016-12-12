package com.acvrock;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ForkJoinPool;

/**
 * Created by moon on 06/12/2016.
 *
 * @Description:
 */
public class Q6 {
    public static void main(String[] args) {
        Random random = new Random();
        List<int[]> arrays = new ArrayList<>();
        arrays.add(random.ints().limit((1 << 13) - 1).toArray());
        arrays.add(random.ints().limit(1 << 13).toArray());
        arrays.add(random.ints().limit((1 << 13) + 1).toArray());
        for (int[] array : arrays) {
            Arrays.parallelSort(array);
            System.out.println(array.length);
            System.out.println(ForkJoinPool.commonPool());
        }
    }
}
