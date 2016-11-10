package conditional;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

/**
 * Created by moon on 16/10/2016.
 *
 * @Description:
 */
@Configuration
public class ConditionConfig {

    @Bean
    @Conditional(MacOSCondition.class)
    public Listservice MacOSListService() {
        return new MacOSListService();
    }

    @Bean
    @Conditional(LinuxCondition.class)
    public Listservice linuxListService() {
        return new LinuxListService();
    }
}
