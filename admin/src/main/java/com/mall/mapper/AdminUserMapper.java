package com.mall.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mall.common.model.Role;
import com.mall.model.AdminUser;

import java.util.List;

/**
 * <p>
 * 用户表 Mapper 接口
 * </p>
 *
 * @author ctlL
 * * @date 2020-11-07ab
 */
public interface AdminUserMapper extends BaseMapper<AdminUser> {

  /**
   * 查询某个用户的所有角色
   *
   * @param id 用户id
   * @return 角色集合
   */
  List<Role> getRolesById(Long id);

}
