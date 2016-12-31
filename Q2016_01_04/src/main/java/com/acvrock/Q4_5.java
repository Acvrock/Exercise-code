package com.acvrock;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.regex.Pattern;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

/**
 * Created by moon on 31/12/2016.
 *
 * @Description: 统计文本中相同单词的数量
 */
public class Q4_5 {

    public static void main(String[] args) {
        InputStream huckleberryFinn = Q4_5.class.getResourceAsStream("HappyNewYear");
        new Q4_5().countWords(huckleberryFinn);
    }

    private static final Pattern space = Pattern.compile("\\s+");

    public void countWords(InputStream stream) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(stream))) {
            Map<String, Long> counts = reader
                    .lines()
                    .flatMap(space::splitAsStream)
                    .map(String::trim)
                    .filter(word -> !word.isEmpty())
                    .collect(groupingBy(word -> word, counting()));
            counts.forEach((word, count) -> System.out.println(word + " -> " + count));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
