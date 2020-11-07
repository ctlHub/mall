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

    List<BizPermission> getPermissionList(String bizId);

}
