package com.mall.security;

import org.springframework.security.test.context.support.WithSecurityContext;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * 自定义用户信息注解
 *
 * @author tanghao
 * @date 2020/11/16 17:33
 */
@Retention(RetentionPolicy.RUNTIME)
@WithSecurityContext(factory = WithMockCustomUserSecurityContextFactory.class)
public @interface MyWithMockUser {

  long id() default 775412006114766848L;

  String username() default "tom";

  long merchant() default 1L;

  String[] resources() default {"ROLE_ADMIN"};

}
