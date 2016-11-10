package springmvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import service.DemoService;

/**
 * Created by moon on 20/10/2016.
 *
 * @Description:
 */
@RestController
public class MyRestController {

    @Autowired
    DemoService demoService;

    @RequestMapping(value = "/testRest", produces = "text/plain;charset=UTF-8")
    public
    @ResponseBody
    String testRest() {
        return demoService.sayService();
    }
}
