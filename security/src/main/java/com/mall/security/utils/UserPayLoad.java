package com.mall.security.utils;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

/**
 * 用户信息的Jwt负载对象
 *
 * @author 李重辰
 * @date 2020/11/23 1:08
 */
@Data
public class UserPayLoad {
  private String username;
  private Collection<? extends GrantedAuthority> authorities;

  public UserPayLoad(String username, Collection<? extends GrantedAuthority> authorities) {
    this.username = username;
    this.authorities = authorities;
  }
}
