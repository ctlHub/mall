package com.mall.mbg.mapper;

import com.mall.mbg.model.GcmCategoryAttribute;
import com.mall.mbg.model.GcmCategoryAttributeExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GcmCategoryAttributeMapper {
    long countByExample(GcmCategoryAttributeExample example);

    int deleteByExample(GcmCategoryAttributeExample example);

    int deleteByPrimaryKey(String id);

    int insert(GcmCategoryAttribute record);

    int insertSelective(GcmCategoryAttribute record);

    List<GcmCategoryAttribute> selectByExample(GcmCategoryAttributeExample example);

    GcmCategoryAttribute selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") GcmCategoryAttribute record, @Param("example") GcmCategoryAttributeExample example);

    int updateByExample(@Param("record") GcmCategoryAttribute record, @Param("example") GcmCategoryAttributeExample example);

    int updateByPrimaryKeySelective(GcmCategoryAttribute record);

    int updateByPrimaryKey(GcmCategoryAttribute record);
}