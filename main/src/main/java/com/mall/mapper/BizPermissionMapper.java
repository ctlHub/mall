package com.mall.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mall.model.BizPermission;

import java.util.List;

/**
 * <p>
 * 权限表 Mapper 接口
 * </p>
 *
 * @author ctlLab
 * @date 2020-11-07
 */
public interface BizPermissionMapper extends BaseMapper<BizPermission> {

  /**
   * 查询商家所有权限集合，每个集合中包含该集合对应的所有权限
   *
   * @param bizId
   * @return
   */
  List<BizPermission> getPermissionsByBizId(long bizId);

}
