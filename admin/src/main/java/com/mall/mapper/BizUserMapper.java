package com.mall.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mall.model.BizUser;
import com.mall.model.Role;

import java.util.List;

/**
 * <p>
 * 用户表 Mapper 接口
 * </p>
 *
 * @author ctlLab
 * @date 2020-11-07
 */
public interface BizUserMapper extends BaseMapper<BizUser> {

  /**
   * 查询某个用户的所有角色
   *
   * @param id 用户id
   * @return 角色集合
   */
  List<Role> getRolesById(Long id);

}
