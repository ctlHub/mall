package com.mall.security.config;

import com.google.gson.Gson;
import com.mall.common.model.RsaKeyProperties;
import com.mall.security.utils.JwtUtils;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * JWT效验成功处理器
 *
 * @author 李重辰
 * @date 2020/11/23 0:44
 */
public class JwtLoginSuccessHandle implements AuthenticationSuccessHandler {

  private final RsaKeyProperties rsaKeyProperties;
  private final Gson gson;

  JwtLoginSuccessHandle(RsaKeyProperties rsaKeyProperties, Gson gson) {
    this.rsaKeyProperties = rsaKeyProperties;
    this.gson = gson;
  }

  @Override
  public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) {
    String token = JwtUtils.generateToken(authentication, rsaKeyProperties, gson);
    response.setHeader("Authorization", token);
  }

}
