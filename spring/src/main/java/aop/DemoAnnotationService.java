package aop;

import org.springframework.stereotype.Service;

/**
 * Created by moon on 2016/10/12.
 *
 * @Description:
 */
@Service
public class DemoAnnotationService {
    @Action(name = "注解式拦截的 add 操作")
    public void add() {
        System.out.println("被拦截");
    }
}
