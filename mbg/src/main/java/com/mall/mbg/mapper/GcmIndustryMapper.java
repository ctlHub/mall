package com.mall.mbg.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.mall.mbg.model.GcmIndustry;
import com.mall.mbg.model.GcmIndustryExample;

public interface GcmIndustryMapper {
    long countByExample(GcmIndustryExample example);

    int deleteByExample(GcmIndustryExample example);

    int deleteByPrimaryKey(Long uid);

    int insert(GcmIndustry record);

    int insertSelective(GcmIndustry record);

    List<GcmIndustry> selectByExample(GcmIndustryExample example);

    GcmIndustry selectByPrimaryKey(Long uid);

    int updateByExampleSelective(@Param("record") GcmIndustry record, @Param("example") GcmIndustryExample example);

    int updateByExample(@Param("record") GcmIndustry record, @Param("example") GcmIndustryExample example);

    int updateByPrimaryKeySelective(GcmIndustry record);

    int updateByPrimaryKey(GcmIndustry record);
}