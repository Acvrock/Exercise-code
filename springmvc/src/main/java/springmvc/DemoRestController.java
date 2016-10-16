package springmvc;

import domain.DemoObj;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by moon on 16/10/2016.
 *
 * @Description:
 */
@RestController
@RequestMapping("/rest")
public class DemoRestController {

    @RequestMapping(value = "/getjson",produces = "application/json;charset=UTF-8")
    public DemoObj getjson(DemoObj obj){
        return new DemoObj(obj.getId()+1,obj.getName()+"yy");
    }

    @RequestMapping(value = "/getxml",produces = "application/xml;charset=UTF-8")
    public DemoObj getXml(DemoObj obj){
        return new DemoObj(obj.getId()+1,obj.getName()+"yy");
    }

}
