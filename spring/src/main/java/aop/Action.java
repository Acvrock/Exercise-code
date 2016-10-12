package aop;

import java.lang.annotation.*;

/**
 * Created by moon on 2016/10/12.
 *
 * @Description:
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Action {
    String name();
}
