package com.mall.security;

import org.springframework.security.test.context.support.WithSecurityContext;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * @author tanghao
 * @date 2020/11/16 17:33
 */
@Retention(RetentionPolicy.RUNTIME)
@WithSecurityContext(factory = WithMockCustomUserSecurityContextFactory.class)
public @interface MyWithMockUser {

  long id() default 775412006114766848L;

  String username() default "tom";

  long merchant() default 1L;

  String[] role() default {"ROLE_ADMIN"};

}
