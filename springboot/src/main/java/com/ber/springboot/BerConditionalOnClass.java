package com.ber.springboot;

import org.springframework.context.annotation.Conditional;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Author 鳄鱼儿
 * @Description TODO
 * @date 2023/8/19 20:06
 * @Version 1.0
 */

@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Conditional(BerOnClassConsition.class)
public @interface BerConditionalOnClass {
    String value() default "";
}
