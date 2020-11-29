package com.mall.security.config;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.google.gson.Gson;
import com.mall.common.model.RSAKeyProvider;
import com.mall.common.model.RsaKeyProperties;
import com.mall.security.utils.JwtUtils;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.www.NonceExpiredException;

import java.util.Calendar;

/**
 * 接受jwt的token，在收到token请求后，对token进行验证
 *
 * @author 李重辰
 * @date 2020/11/25 0:15
 */
public class JwtAuthenticationProvider implements AuthenticationProvider {

  private final RsaKeyProperties rsaKeyProperties;
  private final Gson gson;

  JwtAuthenticationProvider(RsaKeyProperties rsaKeyProperties, Gson gson) {
    this.rsaKeyProperties = rsaKeyProperties;
    this.gson = gson;
  }

  @Override
  public Authentication authenticate(Authentication authentication) throws AuthenticationException {
    DecodedJWT jwt = ((JwtAuthenticationToken) authentication).getToken();
    if (jwt.getExpiresAt().before(Calendar.getInstance().getTime())) {
      throw new NonceExpiredException("Token expires");
    }
    UserDetails user;
    try {
      user = JwtUtils.getPayLoad(authentication, gson);
      Algorithm algorithm = Algorithm.RSA256(new RSAKeyProvider(rsaKeyProperties));
      JWTVerifier verifier = JWT.require(algorithm).build();
      verifier.verify(jwt.getToken());
    } catch (Exception e) {
      throw new BadCredentialsException("JWT token verify fail", e);
    }
    // 通过token认证成功后，将认证信息放入
    return new JwtAuthenticationToken(user, jwt, user == null ? null : user.getAuthorities());
  }

  @Override
  public boolean supports(Class<?> authentication) {
    return authentication.isAssignableFrom(JwtAuthenticationToken.class);
  }
}
