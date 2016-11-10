package annotation;

import org.springframework.stereotype.Service;

/**
 * Created by moon on 16/10/2016.
 *
 * @Description:
 */
@Service
public class DemoService {

    public void outputResult() {
        System.out.println("从组合注解配置照样获得的 Bean");
    }
}
