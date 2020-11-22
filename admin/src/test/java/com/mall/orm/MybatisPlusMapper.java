package com.mall.orm;

import com.mall.model.BizRole;
import org.apache.ibatis.annotations.Mapper;

/**
 * MybatisPlus，高级功能测试mapper
 *
 * @author 李重辰
 * @date 2020/11/19 19:32
 */
@Mapper
interface MybatisPlusMapper {

  /**
   * 根据ID查已经被逻辑删除的BizRole
   *
   * @param id id
   */
  BizRole listDeletedBizRoleById(Long id);
}
