package com.mall.common.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.mall.common.config.security.JwtAuthenticationToken;
import com.mall.common.model.JwtUserDetail;
import com.mall.common.model.RSAKeyProvider;
import com.mall.common.model.RsaKeyProperties;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Date;

/**
 * JWT 工具类
 *
 * @author 李重辰
 * @date 2020/11/29 18:37
 */
public class JwtUtils {

  private static final String JWT_PAYLOAD_USER_KEY = "user";

  public static String generateToken(Authentication authentication, RsaKeyProperties rsaKeyProperties, Gson gson) {
    JwtUserDetail jwtUserDetail = (JwtUserDetail) authentication.getPrincipal();
    // 设置1小时后过期
    Date date = new Date(System.currentTimeMillis() + 3600 * 1000);
    Algorithm algorithm = Algorithm.RSA256(new RSAKeyProvider(rsaKeyProperties));
    return JWT.create()
        .withClaim(JWT_PAYLOAD_USER_KEY, gson.toJson(jwtUserDetail))
        .withExpiresAt(date)
        .withIssuedAt(new Date())
        .sign(algorithm);
  }

  public static UserDetails getPayLoad(Authentication authentication, Gson gson) {
    DecodedJWT jwt = ((JwtAuthenticationToken) authentication).getToken();
    Claim claim = jwt.getClaim(JWT_PAYLOAD_USER_KEY);
    JwtUserDetail userDetail = null;
    try {
      userDetail = gson.fromJson(claim.asString(), JwtUserDetail.class);
    } catch (JsonSyntaxException e) {
      e.printStackTrace();
    }
    return userDetail;
  }
}
