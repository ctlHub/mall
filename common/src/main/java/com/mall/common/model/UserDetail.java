package com.mall.common.model;

import org.springframework.security.core.userdetails.UserDetails;

/**
 * 通用User接口
 *
 * @author 李重辰
 * @date 2020/11/22 23:42
 */
public interface UserDetail extends UserDetails {

  /**
   * set用户名
   *
   * @param username 用户名
   */
  void setUsername(String username);

  /**
   * 获得用户ID
   *
   * @return user表ID字段
   */
  Long getId();
}
