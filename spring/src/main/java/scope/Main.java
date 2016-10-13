package scope;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by moon on 13/10/2016.
 *
 * @Description:
 */
public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(ScopeConfig.class);
        DemoSingletonService s1 = annotationConfigApplicationContext.getBean(DemoSingletonService.class);
        DemoSingletonService s2 = annotationConfigApplicationContext.getBean(DemoSingletonService.class);

        DemoPrototypeService p1 = annotationConfigApplicationContext.getBean(DemoPrototypeService.class);
        DemoPrototypeService p2 = annotationConfigApplicationContext.getBean(DemoPrototypeService.class);

        System.out.println("s1 和 s2 是否相等: " + s1.equals(s2));
        System.out.println("p1 和 p2 是否相等: " + p1.equals(p2));

        annotationConfigApplicationContext.close();
    }

}
