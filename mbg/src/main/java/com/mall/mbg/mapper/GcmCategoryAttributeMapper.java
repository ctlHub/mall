package com.mall.mbg.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.mall.mbg.model.GcmCategoryAttribute;
import com.mall.mbg.model.GcmCategoryAttributeExample;

public interface GcmCategoryAttributeMapper {
    long countByExample(GcmCategoryAttributeExample example);

    int deleteByExample(GcmCategoryAttributeExample example);

    int deleteByPrimaryKey(Long uid);

    int insert(GcmCategoryAttribute record);

    int insertSelective(GcmCategoryAttribute record);

    List<GcmCategoryAttribute> selectByExample(GcmCategoryAttributeExample example);

    GcmCategoryAttribute selectByPrimaryKey(Long uid);

    int updateByExampleSelective(@Param("record") GcmCategoryAttribute record, @Param("example") GcmCategoryAttributeExample example);

    int updateByExample(@Param("record") GcmCategoryAttribute record, @Param("example") GcmCategoryAttributeExample example);

    int updateByPrimaryKeySelective(GcmCategoryAttribute record);

    int updateByPrimaryKey(GcmCategoryAttribute record);
}