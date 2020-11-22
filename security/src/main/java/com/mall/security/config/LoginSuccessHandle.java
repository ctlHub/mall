package com.mall.security.config;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
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
public class LoginSuccessHandle implements AuthenticationSuccessHandler {

  private static final String JWT_PAYLOAD_USER_KEY = "user";

  @Override
  public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
    String userName = authentication.getName();
    Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
    new UserPayLoad(userName, authorities);
    Algorithm algorithm = Algorithm.RSA256(new RSAKeyProvider());
    // 设置1小时后过期
    Date date = new Date(System.currentTimeMillis() + 3600 * 1000);
    String token = JWT.create()
        .withClaim(JWT_PAYLOAD_USER_KEY, "")
        .withExpiresAt(date)
        .withIssuedAt(new Date())
        .sign(algorithm);
    response.setHeader("Authorization", token);
  }

}
