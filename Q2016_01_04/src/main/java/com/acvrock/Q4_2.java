package com.acvrock;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;

/**
 * Created by moon on 31/12/2016.
 *
 * @Description:
 */
public class Q4_2 {
    @Test public void emptyList() {
        assertFiltered(x -> false, Collections.emptyList(), Collections.emptyList());
    }
    @Test public void trueReturnsEverything() {
        assertFiltered((Integer x) -> true, asList(1, 2, 3), asList(1, 2, 3));
    }
    @Test public void falseRemovesEverything() {
        assertFiltered((Integer x) -> false, asList(1, 2, 3), asList());
    }
    @Test public void filterPartOfList() {
        assertFiltered((Integer x) -> x > 2, asList(1, 2, 3), asList(3));
    }
    private <I> void assertFiltered(Predicate<I> predicate, List<I> input, List<I> expectedOutput) {
        long startTime1 = System.currentTimeMillis();
        for (int i = 0; i < 1000; i++) {
            List<I> output = filter(input.stream(), predicate);
            assertEquals(expectedOutput, output);
        }
        long endTime1 = System.currentTimeMillis();
        System.out.println("stream程序运行时间：" + (endTime1 - startTime1) + "ms");    //输出程序运行时间
        long startTime2 = System.currentTimeMillis();
        for (int i = 0; i < 1000; i++) {
            List<I> parallelOutput = filter(input.parallelStream(), predicate);
            assertEquals(expectedOutput, parallelOutput);
        }
        long endTime2 = System.currentTimeMillis();
        System.out.println("parallel程序运行时间：" + (endTime2 - startTime2) + "ms");    //输出程序运行时间
    }
    public static <I> List<I> filter(Stream<I> stream, Predicate<I> predicate) {
        List<I> initial = new ArrayList<>();
        return stream.reduce(initial,
                (List<I> acc, I x) -> {
                    if (predicate.test(x)) {
                        List<I> newAcc = new ArrayList<>(acc);
                        newAcc.add(x);
                        return newAcc;} else {return acc;}
                }, Q4_2::combineLists);
    }
    private static <I> List<I> combineLists(List<I> left, List<I> right) {
        List<I> newLeft = new ArrayList<>(left);
        newLeft.addAll(right);
        return newLeft;
    }
}
