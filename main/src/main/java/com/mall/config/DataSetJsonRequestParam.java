package com.mall.config;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * value对应HttpRequest请求中携带的参数名字，type对应List中将要存储的bean的类型
 * 被注解过的形参将会被 {@linkplain DataSetJsonArgumentResolver} 解析
 *
 * @author 李重辰
 * @date 2020/9/7 20:00
 */
@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface DataSetJsonRequestParam {

    /**
     * 请求参数中的字段名
     */
    String value();

    /**
     * List中是哪个类
     */
    Class<?> type();

    boolean required() default true;
}
