package aop;

import org.springframework.stereotype.Service;

/**
 * Created by moon on 2016/10/12.
 *
 * @Description:
 */
@Service
public class DemoMethodService {
    public void add(){
        System.out.println("无拦截");
    }
}
