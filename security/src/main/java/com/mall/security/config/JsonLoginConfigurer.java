package com.mall.security.config;

import com.google.gson.Gson;
import com.mall.common.config.security.JwtFailureHandle;
import com.mall.security.filter.JsonLoginFilter;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.HttpSecurityBuilder;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.logout.LogoutFilter;
import org.springframework.security.web.authentication.session.NullAuthenticatedSessionStrategy;

/**
 * 以Json方式post用户信息登录配置器
 *
 * @author 李重辰
 * @date 2020/11/24 22:36
 */
public class JsonLoginConfigurer<T extends JsonLoginConfigurer<T, B>, B extends HttpSecurityBuilder<B>> extends AbstractHttpConfigurer<T, B> {

  private final JsonLoginFilter authFilter;

  JsonLoginConfigurer(Gson json) {
    this.authFilter = new JsonLoginFilter(json);
  }

  @Override
  public void configure(B http) {
    // 设置Filter使用的AuthenticationManager,这里取公共的即可
    authFilter.setAuthenticationManager(http.getSharedObject(AuthenticationManager.class));
    // 设置失败的Handler
    authFilter.setAuthenticationFailureHandler(new JwtFailureHandle());
    // 不将认证后的context放入session
    authFilter.setSessionAuthenticationStrategy(new NullAuthenticatedSessionStrategy());
    JsonLoginFilter filter = postProcess(authFilter);
    //指定Filter的位置
    http.addFilterAfter(filter, LogoutFilter.class);
  }

  /**
   * 设置成功的Handler，这个handler定义成Bean，所以从外面set进来
   */
  JsonLoginConfigurer<T, B> loginSuccessHandler(AuthenticationSuccessHandler authSuccessHandler) {
    authFilter.setAuthenticationSuccessHandler(authSuccessHandler);
    return this;
  }

}
