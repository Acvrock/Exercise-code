package lambda;

import java.util.function.Predicate;

/**
 * Created by moon on 8/20/16.
 *
 * @Description:
 */
public class PredicateTest {
    public static void main(String[] args) {
        Predicate<Integer> atLeast5 = x -> x>5;
        System.out.println(atLeast5.test(4));
    }
}
