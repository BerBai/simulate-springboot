package com.ber.springboot;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author 鳄鱼儿
 * @Description TODO
 * @date 2023/8/19 20:34
 * @Version 1.0
 */

@Configuration
public class WebServiceAutoConfiguration implements AutoConfiguration{

    @Bean
    @BerConditionalOnClass("org.apache.catalina.startup.Tomcat")
    public TomcatWebServer tomcatWebServer() {
        return new TomcatWebServer();
    }

    @Bean
    @BerConditionalOnClass("org.eclipse.jetty.server.Server")
    public JettyWebServer jettyWebServer() {
        return new JettyWebServer();
    }
}
