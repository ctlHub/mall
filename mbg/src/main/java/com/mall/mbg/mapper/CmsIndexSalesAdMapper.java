package com.mall.mbg.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.mall.mbg.model.CmsIndexSalesAd;
import com.mall.mbg.model.CmsIndexSalesAdExample;

public interface CmsIndexSalesAdMapper {
    long countByExample(CmsIndexSalesAdExample example);

    int deleteByExample(CmsIndexSalesAdExample example);

    int deleteByPrimaryKey(Integer uid);

    int insert(CmsIndexSalesAd record);

    int insertSelective(CmsIndexSalesAd record);

    List<CmsIndexSalesAd> selectByExample(CmsIndexSalesAdExample example);

    CmsIndexSalesAd selectByPrimaryKey(Integer uid);

    int updateByExampleSelective(@Param("record") CmsIndexSalesAd record, @Param("example") CmsIndexSalesAdExample example);

    int updateByExample(@Param("record") CmsIndexSalesAd record, @Param("example") CmsIndexSalesAdExample example);

    int updateByPrimaryKeySelective(CmsIndexSalesAd record);

    int updateByPrimaryKey(CmsIndexSalesAd record);
}