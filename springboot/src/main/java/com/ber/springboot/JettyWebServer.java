package com.ber.springboot;

import org.springframework.web.context.WebApplicationContext;

/**
 * @Author 鳄鱼儿
 * @Description TODO
 * @date 2023/8/19 19:46
 * @Version 1.0
 */

public class JettyWebServer implements WebServer{
    @Override
    public void start(WebApplicationContext applicationContext) {
        System.out.println("启动Jetty");
    }
}
