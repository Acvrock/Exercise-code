package scope;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

/**
 * Created by moon on 13/10/2016.
 *
 * @Description:
 */
@Service
@Scope("prototype")
public class DemoPrototypeService {
}
