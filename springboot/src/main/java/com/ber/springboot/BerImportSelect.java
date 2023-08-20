package com.ber.springboot;

import org.springframework.context.annotation.DeferredImportSelector;
import org.springframework.core.type.AnnotationMetadata;

import java.util.ArrayList;
import java.util.List;
import java.util.ServiceLoader;

/**
 * @Author 鳄鱼儿
 * @Description
 * @date 2023/8/19 21:15
 * @Version 1.0
 */

public class BerImportSelect implements DeferredImportSelector {
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        /** 使用Java的ServiceLoader机制加载实现了AutoConfiguration接口的类
         * AutoConfiguration是Spring Boot中用于自动配置的接口
         * AutoConfiguration的实现类通常包含了一些配置信息，帮助应用程序在不需要显式配置的情况下自动完成一些功能
         */
        ServiceLoader<AutoConfiguration> serviceLoader = ServiceLoader.load(AutoConfiguration.class);

        List<String> list = new ArrayList<>();
        for (AutoConfiguration autoConfiguration : serviceLoader) {
            list.add(autoConfiguration.getClass().getName());
        }

        // 返回包含所有加载的AutoConfiguration实现类名的字符串数组
        return list.toArray(new String[0]);
    }
}
