package di;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by moon on 2016/10/12.
 *
 * @Description:
 */
public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext configApplicationContext = new AnnotationConfigApplicationContext(DiConfig.class);
        UseFunctionService useFunctionService = configApplicationContext.getBean(UseFunctionService.class);
        System.out.println(useFunctionService.SayHello("di"));
        configApplicationContext.close();
    }
}
