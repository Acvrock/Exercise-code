package aop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by moon on 2016/10/12.
 *
 * @Description:
 */
public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(AopConfig.class);
        DemoAnnotationService demoAnnotationService = annotationConfigApplicationContext.getBean(DemoAnnotationService.class);
        DemoMethodService demoMethodService = annotationConfigApplicationContext.getBean(DemoMethodService.class);
        demoAnnotationService.add();
        demoMethodService.add();
        annotationConfigApplicationContext.close();
    }

}
