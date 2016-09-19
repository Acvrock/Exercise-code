package lambda;

import java.awt.event.ActionListener;
import java.util.function.BinaryOperator;

/**
 * Created by moon on 8/2/16.
 *
 * @Description:
 */
public class Lambda {
    public static void main(String[] args) {
        Runnable noArguments = () -> System.out.printf("Hello World");

        ActionListener oneArgument = event -> System.out.printf("button clicked");

        Runnable multiStatement = () -> {
            System.out.printf("Hello");
            System.out.println(" World");
        };

       BinaryOperator<Long> add=  (x, y) -> x+y;

        BinaryOperator<Long> addExplicit =  (Long x,Long y) -> x+y;


        Thread thread = new Thread(noArguments);
        thread.run();
    }
}
