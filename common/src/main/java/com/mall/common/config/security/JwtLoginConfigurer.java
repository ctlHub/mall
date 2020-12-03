package com.mall.common.config.security;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.HttpSecurityBuilder;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.logout.LogoutFilter;

/**
 * 携带token登录
 *
 * @author 李重辰
 * @date 2020/11/29 19:14
 */
public class JwtLoginConfigurer<T extends JwtLoginConfigurer<T, B>, B extends HttpSecurityBuilder<B>> extends AbstractHttpConfigurer<T, B> {
  private final JwtAuthenticationFilter authFilter;

  public JwtLoginConfigurer() {
    this.authFilter = new JwtAuthenticationFilter();
  }

  @Override
  public void configure(B http) {
    authFilter.setAuthenticationManager(http.getSharedObject(AuthenticationManager.class));
    authFilter.setAuthenticationFailureHandler(new JwtFailureHandle());

    JwtAuthenticationFilter filter = postProcess(authFilter);
    http.addFilterBefore(filter, LogoutFilter.class);
  }

  /**
   * 匿名用户可以访问的url
   *
   * @param urls url路径
   */
  public JwtLoginConfigurer<T, B> permissiveRequestUrls(String... urls) {
    authFilter.setPermissiveUrl(urls);
    return this;
  }

  public JwtLoginConfigurer<T, B> tokenValidSuccessHandler(AuthenticationSuccessHandler successHandler) {
    authFilter.setAuthenticationSuccessHandler(successHandler);
    return this;
  }
}
