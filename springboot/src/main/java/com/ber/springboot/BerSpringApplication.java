package com.ber.springboot;

import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;

import java.util.Map;

/**
 * @Author 鳄鱼儿
 * @Description TODO
 * @date 2023/8/19 14:08
 * @Version 1.0
 */

public class BerSpringApplication {
    public static void run(Class clazz) {
        // 1. 创建Spring 容器
        AnnotationConfigWebApplicationContext applicationContext = new AnnotationConfigWebApplicationContext();
        applicationContext.register(clazz);
        applicationContext.refresh();

        // 2. 获取特定WebServer类型的Bean
        WebServer webServer = getWebServer(applicationContext);
        // 3. 调用start方法
        webServer.start(applicationContext);

    }

    private static WebServer getWebServer(AnnotationConfigWebApplicationContext applicationContext) {
        // key为beanName, value为Bean对象
        Map<String, WebServer> webServers = applicationContext.getBeansOfType(WebServer.class);

        if (webServers.isEmpty()) {
            throw new NullPointerException();
        }

        if (webServers.size() > 1) {
            throw new IllegalStateException();
        }

        return webServers.values().stream().findFirst().get();
    }
}
