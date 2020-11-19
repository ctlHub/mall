package com.mall.security.filter;

import com.google.gson.Gson;
import lombok.SneakyThrows;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Collection;

/**
 * 对JWT形式发送的登录信息进行效验
 *
 * @author 李重辰
 * @date 2020/11/19 23:15
 */
public class JwtLoginFilter extends UsernamePasswordAuthenticationFilter {

  public JwtLoginFilter(Gson gson) {
    super();
    this.gson = gson;
  }

  private final Gson gson;

  @SneakyThrows
  @Override
  public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
    if (!HttpMethod.POST.matches(request.getMethod())) {
      throw new AuthenticationServiceException(
          "Authentication method not supported: " + request.getMethod());
    }
    InputStreamReader reader = new InputStreamReader(request.getInputStream(), StandardCharsets.UTF_8);
    UserDetail user = gson.fromJson(reader, UserDetail.class);
    user.username = user.username.trim();

    UsernamePasswordAuthenticationToken authRequest = new UsernamePasswordAuthenticationToken(
        user.username, user.password);
    return this.getAuthenticationManager().authenticate(authRequest);
  }

  static class UserDetail implements UserDetails {

    private static final long serialVersionUID = 9220031891328185424L;
    private String username;
    private String password;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
      return null;
    }

    public void setUsername(String username) {
      this.username = username;
    }

    public void setPassword(String password) {
      this.password = password;
    }

    @Override
    public String getPassword() {
      return password;
    }

    @Override
    public String getUsername() {
      return username;
    }

    @Override
    public boolean isAccountNonExpired() {
      return true;
    }

    @Override
    public boolean isAccountNonLocked() {
      return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
      return true;
    }

    @Override
    public boolean isEnabled() {
      return true;
    }
  }
}

