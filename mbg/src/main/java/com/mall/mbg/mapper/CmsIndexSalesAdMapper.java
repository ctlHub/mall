package com.mall.mbg.mapper;

import com.mall.mbg.model.CmsIndexSalesAd;
import com.mall.mbg.model.CmsIndexSalesAdExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CmsIndexSalesAdMapper {
    long countByExample(CmsIndexSalesAdExample example);

    int deleteByExample(CmsIndexSalesAdExample example);

    int deleteByPrimaryKey(String id);

    int insert(CmsIndexSalesAd record);

    int insertSelective(CmsIndexSalesAd record);

    List<CmsIndexSalesAd> selectByExample(CmsIndexSalesAdExample example);

    CmsIndexSalesAd selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") CmsIndexSalesAd record, @Param("example") CmsIndexSalesAdExample example);

    int updateByExample(@Param("record") CmsIndexSalesAd record, @Param("example") CmsIndexSalesAdExample example);

    int updateByPrimaryKeySelective(CmsIndexSalesAd record);

    int updateByPrimaryKey(CmsIndexSalesAd record);
}