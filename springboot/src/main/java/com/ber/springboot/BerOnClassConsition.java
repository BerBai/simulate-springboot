package com.ber.springboot;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

import java.util.Map;

/**
 * @Author 鳄鱼儿
 * @Description TODO
 * @date 2023/8/19 20:08
 * @Version 1.0
 */

public class BerOnClassConsition implements Condition {
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        Map<String, Object> annotationAttributes =
                metadata.getAnnotationAttributes(BerConditionalOnClass.class.getName());
        // 1. 拿到@BerConditionalOnClass中的value属性
        String className = (String) annotationAttributes.get("value");

        // 2. 类加载器进行加载
        try {
            // 2.1 加载到了特定的类名，则符合条件 true
            context.getClassLoader().loadClass(className);
            return true;
        } catch (ClassNotFoundException e) {
            // 2.2 加载不到，则不符合条件 false
            return false;
        }
    }
}
