package lambda;

import java.util.function.BinaryOperator;

/**
 * Created by moon on 8/20/16.
 *
 * @Description:
 */
public class BinaryOperatorTest {
    public static void main(String[] args) {
        BinaryOperator<Long> addLogs = (x, y) -> x + y;
        System.out.println(addLogs.apply(1l, 2l));
//        ThreadLocal
    }
}
