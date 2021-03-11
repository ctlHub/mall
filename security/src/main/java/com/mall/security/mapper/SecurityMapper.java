package com.mall.security.mapper;

import com.mall.common.model.JwtUserDetail;
import com.mall.common.model.Permission;

import java.util.List;

/**
 * 认证服务mapper
 *
 * @author tanghao
 * @date 2020/12/11 14:21
 */
public interface SecurityMapper {

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

  /**
   * 获取用户所有角色Id
   *
   * @param userId 用户Id
   * @return 权限集合
   */
  List<Long> getRolesByUserId(Long userId);

  /**
   * 角色集合对应的权限集合
   *
   * @param roleIdList 角色Id集合
   * @return 权限Id集合
   */
  List<Long> getPermissionsByRoles(List<Long> roleIdList);

  /**
   * 根据权限Id集合查询权限
   *
   * @param permissionIdList 权限ID集合
   * @return 权限集合
   */
  List<Permission> getPermissionsByIds(List<Long> permissionIdList);
}
