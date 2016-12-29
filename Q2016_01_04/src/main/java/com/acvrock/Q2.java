package com.acvrock;

import java.util.stream.Stream;

/**
 * Created by moon on 28/12/2016.
 *
 * @Description:
 */
public class Q2 {

    public static void main(String[] args) {
        Stream.of("d2", "a2", "b1", "b3", "c")
                .filter(s -> {
                    System.out.println("filter: " + s);
                    return true;
                })
                .forEach(s -> System.out.println("forEach: " + s));
    }
}
