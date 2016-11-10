package com.acvrock;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Created by moon on 22/10/2016.
 *
 * @Description:
 */
@ConfigurationProperties(prefix = "hello")
public class HelloServiceProperties {

    private static final String MSG = "world";

    private String msg = MSG;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
