package com.mall.security;

import com.mall.common.model.JwtUserDetail;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.test.context.support.WithSecurityContextFactory;

import java.util.Arrays;

/**
 * 解析{@link MyWithMockUser}注解,向SecurityContext中添加用户信息
 *
 * @author tanghao
 * @date 2020/11/18 13:43
 */
public class WithMockCustomUserSecurityContextFactory implements WithSecurityContextFactory<MyWithMockUser> {

  @Override
  public SecurityContext createSecurityContext(MyWithMockUser myWithMockUser) {
    SecurityContext context = SecurityContextHolder.createEmptyContext();

    JwtUserDetail principal = new JwtUserDetail();
    principal.setId(myWithMockUser.id());
    principal.setMerchantId(myWithMockUser.merchant());
    principal.setUsername(myWithMockUser.username());
    principal.setResourceList(Arrays.asList(myWithMockUser.resources()));

    Authentication auth = new UsernamePasswordAuthenticationToken(principal, "password", principal.getAuthorities());
    context.setAuthentication(auth);
    return context;
  }
}
