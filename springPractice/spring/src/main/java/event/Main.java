package event;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by moon on 14/10/2016.
 *
 * @Description:
 */
public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(EventConfig.class);
        DemoPublisher demoPublisher = annotationConfigApplicationContext.getBean(DemoPublisher.class);
        demoPublisher.publish("hello application event");
        annotationConfigApplicationContext.close();
    }
}
