package javaconfig;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by moon on 2016/10/12.
 *
 * @Description:
 */
public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext configApplicationContext = new AnnotationConfigApplicationContext(JavaConfig.class);
        UseFunctionService useFunctionService = configApplicationContext.getBean(UseFunctionService.class);
        System.out.println(useFunctionService.SayHello("javaConfig"));
        configApplicationContext.close();
    }
}
