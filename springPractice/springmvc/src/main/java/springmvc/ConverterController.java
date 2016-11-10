package springmvc;

import domain.DemoObj;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by moon on 18/10/2016.
 *
 * @Description:
 */
@Controller
public class ConverterController {

    @RequestMapping(value = "/convert", produces = {"application/x-wisely"})
    public
    @ResponseBody
    DemoObj convert(@RequestBody DemoObj demoObj) {
        return demoObj;
    }
}
