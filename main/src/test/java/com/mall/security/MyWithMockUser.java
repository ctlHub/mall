package com.mall.security;

import org.springframework.security.test.context.support.WithSecurityContext;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * @author tanghao
 * @date 2020/11/16 17:33
 */
@Retention(RetentionPolicy.RUNTIME)
@WithSecurityContext(factory = WithMockUserSecurityContextFactory.class)
public @interface MyWithMockUser {

  String username() default "tom";

}
