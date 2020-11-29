package com.mall.security.filter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.mall.security.entity.JwtUserDetail;
import lombok.SneakyThrows;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Map;

/**
 * 对前台使用post方式ajax的登录信息进行效验
 *
 * @author 李重辰
 * @date 2020/11/19 23:15
 */
public class JsonLoginFilter extends UsernamePasswordAuthenticationFilter {

  private final Gson gson;

  public JsonLoginFilter(Gson gson) {
    super();
    this.gson = gson;
  }

  @SneakyThrows
  @Override
  public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
    if (!HttpMethod.POST.matches(request.getMethod())) {
      throw new AuthenticationServiceException(
          "Authentication method not supported: " + request.getMethod());
    }
    InputStreamReader reader = new InputStreamReader(request.getInputStream(), StandardCharsets.UTF_8);
    Map<String, String> paramMap = gson.fromJson(reader, new TypeToken<Map<String, String>>() {
    }.getType());
    JwtUserDetail user = new JwtUserDetail();
    user.setUsername(paramMap.get("username").trim());
    user.setPassword(paramMap.get("password"));
    // 从 JwtUserServiceImpl.loadUserByUsername 方法获取用户信息并进行验证
    UsernamePasswordAuthenticationToken authRequest = new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword());
    return this.getAuthenticationManager().authenticate(authRequest);
  }

}

