package com.acvrock;

import org.junit.Test;

import java.util.Map;
import java.util.stream.Stream;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;
import static org.junit.Assert.assertEquals;

/**
 * Created by moon on 31/12/2016.
 *
 * @Description: 对数据进行分组并计数
 */
public class Q4_3 {
    @Test
    public void passesBookExample() {
        Stream<String> names = Stream.of("John", "Paul", "George", "John", "Paul", "John");
        Map<String, Long> counts = names.collect(groupingBy(name -> name, counting()));

        assertEquals(3, counts.size());
        assertEquals(Long.valueOf(3), counts.get("John"));
        assertEquals(Long.valueOf(2), counts.get("Paul"));
        assertEquals(Long.valueOf(1), counts.get("George"));
    }
}
