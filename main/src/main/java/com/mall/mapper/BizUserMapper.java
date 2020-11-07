package com.mall.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mall.model.BizRole;
import com.mall.model.BizUser;

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

    List<BizRole> getRolesById(Long id);

}
