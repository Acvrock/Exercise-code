package profile;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by moon on 14/10/2016.
 *
 * @Description:
 */
public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext();
        annotationConfigApplicationContext.getEnvironment().setActiveProfiles("prod");
        annotationConfigApplicationContext.register(ProfileConfig.class);
        annotationConfigApplicationContext.refresh();

        DemoBean demoBean = annotationConfigApplicationContext.getBean(DemoBean.class);
        System.out.println(demoBean.getContent());
        annotationConfigApplicationContext.close();
    }
}
