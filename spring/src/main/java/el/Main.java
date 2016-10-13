package el;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by moon on 13/10/2016.
 *
 * @Description:
 */
public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(ElConfig.class);

        ElConfig resourceService = annotationConfigApplicationContext.getBean(ElConfig.class);
        resourceService.outputResource();
        annotationConfigApplicationContext.close();

    }
}
