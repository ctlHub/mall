package com.mall.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mall.common.model.Permission;

import java.util.List;

/**
 * <p>
 * 权限表 Mapper 接口
 * </p>
 *
 * @author ctlLab
 * @date 2020-11-07
 */
public interface PermissionMapper extends BaseMapper<Permission> {

  /**
   * 查询商家所有权限集合，每个集合中包含该集合对应的所有权限
   *
   * @param merchantId 商家id
   * @return 权限集合
   */
  List<Permission> getPermissionsByMerchantId(long merchantId);

}
