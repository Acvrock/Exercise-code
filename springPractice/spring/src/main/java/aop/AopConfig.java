package aop;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * Created by moon on 2016/10/12.
 *
 * @Description:
 */
@Configuration
@ComponentScan("aop")
@EnableAspectJAutoProxy
public class AopConfig {
}
