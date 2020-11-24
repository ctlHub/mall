package com.mall.security.config;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.google.gson.Gson;
import com.mall.common.api.RsaKeyProperties;
import com.mall.security.utils.RSAKeyProvider;
import com.mall.security.utils.UserPayLoad;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collection;
import java.util.Date;

/**
 * JWT效验成功处理器
 *
 * @author 李重辰
 * @date 2020/11/23 0:44
 */
public class JwtLoginSuccessHandle implements AuthenticationSuccessHandler {

  private static final String JWT_PAYLOAD_USER_KEY = "user";

  private final RsaKeyProperties rsaKeyProperties;
  private final Gson gson;

  public JwtLoginSuccessHandle(RsaKeyProperties rsaKeyProperties, Gson gson) {
    this.rsaKeyProperties = rsaKeyProperties;
    this.gson = gson;
  }

  @Override
  public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
    UserPayLoad userPayLoad = getUserPayLoad(authentication);
    // 设置1小时后过期
    Date date = new Date(System.currentTimeMillis() + 3600 * 1000);
    Algorithm algorithm = Algorithm.RSA256(new RSAKeyProvider(rsaKeyProperties));
    String token = JWT.create()
        .withClaim(JWT_PAYLOAD_USER_KEY, gson.toJson(userPayLoad))
        .withExpiresAt(date)
        .withIssuedAt(new Date())
        .sign(algorithm);
    response.setHeader("Authorization", token);
  }

  private UserPayLoad getUserPayLoad(Authentication authentication) {
    String userName = authentication.getName();
    Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
    return new UserPayLoad(userName, authorities);
  }

}
