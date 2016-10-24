package com.acvrock.web;

import com.acvrock.domain.WiselyMessage;
import com.acvrock.domain.WiselyResponse;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

/**
 * Created by moon on 24/10/2016.
 *
 * @Description:
 */
@Controller
public class WsController {

    @MessageMapping("/welcome")
    @SendTo("/topic/getResponse")
    public WiselyResponse say(WiselyMessage message) throws Exception {
        Thread.sleep(3000);
        return new WiselyResponse("Welcome, " + message.getName() + "!");
    }

}
