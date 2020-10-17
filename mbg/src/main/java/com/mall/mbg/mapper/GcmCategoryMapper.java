package com.mall.mbg.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.mall.mbg.model.GcmCategory;
import com.mall.mbg.model.GcmCategoryExample;

public interface GcmCategoryMapper {
    long countByExample(GcmCategoryExample example);

    int deleteByExample(GcmCategoryExample example);

    int deleteByPrimaryKey(Long uid);

    int insert(GcmCategory record);

    int insertSelective(GcmCategory record);

    List<GcmCategory> selectByExample(GcmCategoryExample example);

    GcmCategory selectByPrimaryKey(Long uid);

    int updateByExampleSelective(@Param("record") GcmCategory record, @Param("example") GcmCategoryExample example);

    int updateByExample(@Param("record") GcmCategory record, @Param("example") GcmCategoryExample example);

    int updateByPrimaryKeySelective(GcmCategory record);

    int updateByPrimaryKey(GcmCategory record);
}