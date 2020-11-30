package com.mall.security.mapper;

import com.mall.common.model.JwtUserDetail;

/**
 * 用户信息处理mapper
 *
 * @author 李重辰
 * @date 2020/11/29 1:06
 */
public interface UserDetailMapper {

  /**
   * 获取平台管理后台的用户
   *
   * @param name 用户名/手机号码
   * @return 通用user对象
   */
  JwtUserDetail getUserByAdminUser(String name);

  /**
   * 获取商家管理后台的用户
   *
   * @param name 用户名/手机号码
   * @return 通用user对象
   */
  JwtUserDetail getUserByBizUser(String name);

  /**
   * 获取Customer
   *
   * @param name 用户名/手机号码
   * @return 通用user对象
   */
  JwtUserDetail getUserByCustomer(String name);
}
