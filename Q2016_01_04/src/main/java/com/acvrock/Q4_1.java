package com.acvrock;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Stream;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by moon on 31/12/2016.
 *
 * @Description: 只用 reduce 和 Lambda 表达式实现 Stream 中的 map 操作
 */
public class Q4_1 {
    @Test
    public void mapExample() {
        long startTime1 = System.currentTimeMillis();
        for (int i = 0; i < 1000; i++) {
            Stream<Integer> stream = Stream.of(1, 2, 3);
            List<Integer> values = map(stream, x -> x + 1);
            assertEquals(Arrays.asList(2, 3, 4), values);
        }
        long endTime1 = System.currentTimeMillis();
        System.out.println("mapExample程序运行时间：" + (endTime1 - startTime1) + "ms");    //输出程序运行时间
    }
    @Test
    public void mapExampleParallel() {
        long startTime1 = System.currentTimeMillis();
        for (int i = 0; i < 1000; i++) {
            Stream<Integer> parallelStream = Stream.of(1, 2, 3).parallel();
            List<Integer> values = map(parallelStream, x -> x + 1);
            assertEquals(Arrays.asList(2, 3, 4), values);
        }
        long endTime1 = System.currentTimeMillis();
        System.out.println("mapExampleParallel程序运行时间：" + (endTime1 - startTime1) + "ms");    //输出程序运行时间
    }
    // map f = foldr ((:) . f) []
    //  <U> U reduce(U identity,BiFunction<U, ? super T, U> accumulator,BinaryOperator<U> combiner);
    // accumulator 方法对流进行操作,如果是非并行的流执行这一个操作后就已经完成认为并返回
    // combiner 方法对流进行合并／转换成输出结果，如果是并行的流就会走这一步合并操作
    public static <T, R> List<R> map(Stream<T> stream, Function<T, R> mapper) {
        return stream.reduce(new ArrayList<>(), (acc, value) -> {
            ArrayList<R> result = new ArrayList<>();
            result.addAll(acc);
            result.add(mapper.apply(value));
            return result;
        }, (left, right) -> {
            ArrayList<R> result = new ArrayList<>();
            result.addAll(left);
            result.addAll(right);
            return result;
        });
    }
}
