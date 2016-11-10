package aware;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by moon on 15/10/2016.
 *
 * @Description:
 */
public class Main {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(AwareConfig.class);
        AwareService awareService = annotationConfigApplicationContext.getBean(AwareService.class);
        awareService.outputResult();
        annotationConfigApplicationContext.close();
    }
}
