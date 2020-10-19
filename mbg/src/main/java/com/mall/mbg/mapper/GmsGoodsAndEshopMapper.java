package com.mall.mbg.mapper;

import com.mall.mbg.model.GmsGoodsAndEshop;
import com.mall.mbg.model.GmsGoodsAndEshopExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GmsGoodsAndEshopMapper {
  long countByExample(GmsGoodsAndEshopExample example);

  int deleteByExample(GmsGoodsAndEshopExample example);

  int deleteByPrimaryKey(String id);

  int insert(GmsGoodsAndEshop record);

  int insertSelective(GmsGoodsAndEshop record);

  List<GmsGoodsAndEshop> selectByExample(GmsGoodsAndEshopExample example);

  GmsGoodsAndEshop selectByPrimaryKey(String id);

  int updateByExampleSelective(@Param("record") GmsGoodsAndEshop record, @Param("example") GmsGoodsAndEshopExample example);

  int updateByExample(@Param("record") GmsGoodsAndEshop record, @Param("example") GmsGoodsAndEshopExample example);

  int updateByPrimaryKeySelective(GmsGoodsAndEshop record);

  int updateByPrimaryKey(GmsGoodsAndEshop record);
}