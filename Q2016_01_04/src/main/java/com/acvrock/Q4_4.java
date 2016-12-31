package com.acvrock;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;

/**
 * Created by moon on 31/12/2016.
 *
 * @Description: 在一个字符串列表中找出包含最多小写字母的字符串
 */
public class Q4_4 {
    @Test
    public void findsMostLowercaseString() {
        Optional<String> result = Q4_4.mostLowercaseString(Arrays.asList("a", "abc", "ABCde"));
        assertEquals(result, Optional.of("abc"));
    }

    public static Optional<String> mostLowercaseString(List<String> strings) {
        return strings.stream().max(Comparator.comparing(Q4_4::countLowercaseLetters));
    }

    public static int countLowercaseLetters(String string) {
        return (int) string.chars().filter(Character::isLowerCase).count();
    }
}
