package annotation;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by moon on 16/10/2016.
 *
 * @Description:
 */
public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(DemoConfig.class);
        DemoService demoService = annotationConfigApplicationContext.getBean(DemoService.class);
        demoService.outputResult();
        annotationConfigApplicationContext.close();
    }
}
