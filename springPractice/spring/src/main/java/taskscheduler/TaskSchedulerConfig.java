package taskscheduler;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * Created by moon on 15/10/2016.
 *
 * @Description:
 */
@Configuration
@ComponentScan("taskscheduler")
@EnableScheduling
public class TaskSchedulerConfig {
}
