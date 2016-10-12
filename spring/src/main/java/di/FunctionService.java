package di;

import org.springframework.stereotype.Service;

/**
 * Created by moon on 2016/10/12.
 *
 * @Description:
 */
@Service
public class FunctionService {
    public String sayHello(String word) {
        return String.format("Hello %s !",word);
    }
}
