package com.mall.common.config.security;

import com.google.gson.Gson;
import com.mall.common.model.RsaKeyProperties;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

/**
 * 认证成功后检测token创建时间，适时刷新token
 *
 * @author 李重辰
 * @date 2020/11/29 18:31
 */
public class JwtRefreshSuccessHandler implements AuthenticationSuccessHandler {

  /**
   * 刷新间隔5分钟
   */
  private static final int TOKEN_REFRESH_INTERVAL = 300;
  private final RsaKeyProperties rsaKeyProperties;
  private final Gson gson;

  public JwtRefreshSuccessHandler(RsaKeyProperties rsaKeyProperties, Gson gson) {
    this.rsaKeyProperties = rsaKeyProperties;
    this.gson = gson;
  }

  @Override
  public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                      Authentication authentication) {
/// 暂时不刷新token，后续如果需要刷新，考虑发送请求到认证服务器的方式来刷新token
//    DecodedJWT jwt = ((JwtAuthenticationToken) authentication).getToken();
//    boolean shouldRefresh = shouldTokenRefresh(jwt.getIssuedAt());
//    if (shouldRefresh) {
//      String newToken = JwtUtils.generateToken(authentication, rsaKeyProperties, gson);
//      response.setHeader("Authorization", newToken);
//    }
  }

  private boolean shouldTokenRefresh(Date issueAt) {
    LocalDateTime issueTime = LocalDateTime.ofInstant(issueAt.toInstant(), ZoneId.systemDefault());
    return LocalDateTime.now().minusSeconds(TOKEN_REFRESH_INTERVAL).isAfter(issueTime);
  }

}

