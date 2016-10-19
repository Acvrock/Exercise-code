package springmvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.async.DeferredResult;
import service.PushService;

/**
 * Created by moon on 19/10/2016.
 *
 * @Description:
 */
@Controller
public class AysncController {

    @Autowired
    PushService pushService;

    @RequestMapping("/defer")
    @ResponseBody
    public DeferredResult<String> deferredResult() {
        return pushService.getAsyncUpdate();
    }
}
