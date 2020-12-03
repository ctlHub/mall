package com.mall.common.config.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.exceptions.JWTDecodeException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.RequestHeaderRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;
import org.springframework.util.Assert;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * JWT 认证过滤器
 *
 * @author 李重辰
 * @date 2020/11/24 23:54
 */
public class JwtAuthenticationFilter extends OncePerRequestFilter {

  private final RequestMatcher requiresAuthenticationRequestMatcher;
  private List<RequestMatcher> permissiveRequestMatchers;
  private AuthenticationManager authenticationManager;

  private AuthenticationSuccessHandler successHandler = new SavedRequestAwareAuthenticationSuccessHandler();
  private AuthenticationFailureHandler failureHandler = new SimpleUrlAuthenticationFailureHandler();

  JwtAuthenticationFilter() {
    this.requiresAuthenticationRequestMatcher = new RequestHeaderRequestMatcher("Authorization");
  }

  @Override
  public void afterPropertiesSet() {
    Assert.notNull(authenticationManager, "authenticationManager must be specified");
    Assert.notNull(successHandler, "AuthenticationSuccessHandler must be specified");
    Assert.notNull(failureHandler, "AuthenticationFailureHandler must be specified");
  }

  private String getJwtToken(HttpServletRequest request) {
    String authInfo = request.getHeader("Authorization");
    return StringUtils.removeStart(authInfo, "Bearer ");
  }

  @Override
  protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
      throws ServletException, IOException {
    // 如果没有携带token，则直接放过，交给后面的拦截器去处理（权限控制等）
    if (!requiresAuthentication(request, response)) {
      filterChain.doFilter(request, response);
      return;
    }
    Authentication authResult = null;
    AuthenticationException failed = null;
    try {
      String token = getJwtToken(request);
      if (StringUtils.isNotBlank(token)) {
        JwtAuthenticationToken authToken = new JwtAuthenticationToken(JWT.decode(token));
        authResult = this.getAuthenticationManager().authenticate(authToken);
      } else {
        failed = new InsufficientAuthenticationException("JWT is Empty");
      }
    } catch (JWTDecodeException e) {
      logger.error("JWT format error", e);
      failed = new InsufficientAuthenticationException("JWT format error", null);
    } catch (InternalAuthenticationServiceException e) {
      logger.error("An internal error occurred while trying to authenticate the user.", null);
      failed = e;
    } catch (AuthenticationException e) {
      // Authentication failed
      failed = e;
    }
    if (authResult != null) {
      successfulAuthentication(request, response, filterChain, authResult);
    } else if (!permissiveRequest(request)) {
      unsuccessfulAuthentication(request, response, failed);
      return;
    }

    filterChain.doFilter(request, response);
  }

  private void unsuccessfulAuthentication(HttpServletRequest request,
                                          HttpServletResponse response, AuthenticationException failed)
      throws IOException, ServletException {
    SecurityContextHolder.clearContext();
    failureHandler.onAuthenticationFailure(request, response, failed);
  }

  private void successfulAuthentication(HttpServletRequest request,
                                        HttpServletResponse response, FilterChain chain, Authentication authResult)
      throws IOException, ServletException {
    SecurityContextHolder.getContext().setAuthentication(authResult);
    successHandler.onAuthenticationSuccess(request, response, authResult);
  }

  private AuthenticationManager getAuthenticationManager() {
    return authenticationManager;
  }

  public void setAuthenticationManager(AuthenticationManager authenticationManager) {
    this.authenticationManager = authenticationManager;
  }

  private boolean requiresAuthentication(HttpServletRequest request,
                                         HttpServletResponse response) {
    return requiresAuthenticationRequestMatcher.matches(request);
  }

  private boolean permissiveRequest(HttpServletRequest request) {
    if (permissiveRequestMatchers == null) {
      return false;
    }
    for (RequestMatcher permissiveMatcher : permissiveRequestMatchers) {
      if (permissiveMatcher.matches(request)) {
        return true;
      }
    }
    return false;
  }

  public void setPermissiveUrl(String... urls) {
    if (permissiveRequestMatchers == null) {
      permissiveRequestMatchers = new ArrayList<>();
    }
    for (String url : urls) {
      permissiveRequestMatchers.add(new AntPathRequestMatcher(url));
    }
  }

  public void setAuthenticationSuccessHandler(
      AuthenticationSuccessHandler successHandler) {
    Assert.notNull(successHandler, "successHandler cannot be null");
    this.successHandler = successHandler;
  }

  public void setAuthenticationFailureHandler(
      AuthenticationFailureHandler failureHandler) {
    Assert.notNull(failureHandler, "failureHandler cannot be null");
    this.failureHandler = failureHandler;
  }

  protected AuthenticationSuccessHandler getSuccessHandler() {
    return successHandler;
  }

  protected AuthenticationFailureHandler getFailureHandler() {
    return failureHandler;
  }

}
