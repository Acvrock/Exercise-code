package conditional;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by moon on 16/10/2016.
 *
 * @Description:
 */
public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(ConditionConfig.class);
        Listservice listservice = annotationConfigApplicationContext.getBean(Listservice.class);
        System.out.println(annotationConfigApplicationContext.getEnvironment().getProperty("os.name") + " 系统下的列表命令为：" + listservice.showListCmd());
    }
}
