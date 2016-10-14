package prepost;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by moon on 14/10/2016.
 *
 * @Description:
 */
public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(PrepostConfig.class);
        BeanWayService beanWayService = annotationConfigApplicationContext.getBean(BeanWayService.class);

        JSR250WayService jsr250WayService = annotationConfigApplicationContext.getBean(JSR250WayService.class);

        annotationConfigApplicationContext.close();
    }
}
