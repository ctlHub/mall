package com.mall.mbg.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.mall.mbg.model.GmsGoodsAndEshop;
import com.mall.mbg.model.GmsGoodsAndEshopExample;

public interface GmsGoodsAndEshopMapper {
    long countByExample(GmsGoodsAndEshopExample example);

    int deleteByExample(GmsGoodsAndEshopExample example);

    int deleteByPrimaryKey(Integer uid);

    int insert(GmsGoodsAndEshop record);

    int insertSelective(GmsGoodsAndEshop record);

    List<GmsGoodsAndEshop> selectByExample(GmsGoodsAndEshopExample example);

    GmsGoodsAndEshop selectByPrimaryKey(Integer uid);

    int updateByExampleSelective(@Param("record") GmsGoodsAndEshop record, @Param("example") GmsGoodsAndEshopExample example);

    int updateByExample(@Param("record") GmsGoodsAndEshop record, @Param("example") GmsGoodsAndEshopExample example);

    int updateByPrimaryKeySelective(GmsGoodsAndEshop record);

    int updateByPrimaryKey(GmsGoodsAndEshop record);
}