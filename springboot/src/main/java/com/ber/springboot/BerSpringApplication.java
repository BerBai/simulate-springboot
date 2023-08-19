package com.ber.springboot;

import org.apache.catalina.*;
import org.apache.catalina.connector.Connector;
import org.apache.catalina.core.StandardContext;
import org.apache.catalina.core.StandardEngine;
import org.apache.catalina.core.StandardHost;
import org.apache.catalina.startup.Tomcat;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

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

        // 2. 创建并启动Tomcat
        startTomcat(applicationContext);
    }

    private static void startTomcat(WebApplicationContext applicationContext) {
        // 2.1 创建tomcat对象
        Tomcat tomcat = new Tomcat();

        Server server = tomcat.getServer();
        Service service = server.findService("Tomcat");

        Connector connector = new Connector();
        // 设置默认tomcat启动端口
        connector.setPort(8023);

        Engine engine = new StandardEngine();
        engine.setDefaultHost("localhost");

        Host host = new StandardHost();
        host.setName("localhost");

        String contextPath = "";
        Context context = new StandardContext();
        context.setPath(contextPath);
        context.addLifecycleListener(new Tomcat.FixContextListener());

        host.addChild(context);
        engine.addChild(host);

        service.setContainer(engine);
        service.addConnector(connector);

        // 2.2 创建DispatcherServlet对象，并与Spring容器绑定，并将DispatcherServlet对象添加至Tomcat中
        tomcat.addServlet(contextPath, "dispatcher", new DispatcherServlet(applicationContext));
        context.addServletMappingDecoded("/*", "dispatcher");

        // 2.3 启动tomcat
        try {
            tomcat.start();
        } catch (LifecycleException e) {
            e.printStackTrace();
        }
    }
}
