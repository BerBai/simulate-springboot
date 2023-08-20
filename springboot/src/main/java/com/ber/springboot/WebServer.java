package com.ber.springboot;

import org.springframework.web.context.WebApplicationContext;

/**
 * @Author 鳄鱼儿
 * @Description TODO
 * @date 2023/8/19 19:44
 * @Version 1.0
 */
public interface WebServer {
    void start(WebApplicationContext applicationContext);
}
