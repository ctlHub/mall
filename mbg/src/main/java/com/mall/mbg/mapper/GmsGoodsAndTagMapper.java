package com.mall.mbg.mapper;

import com.mall.mbg.model.GmsGoodsAndTag;
import com.mall.mbg.model.GmsGoodsAndTagExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GmsGoodsAndTagMapper {
  long countByExample(GmsGoodsAndTagExample example);

  int deleteByExample(GmsGoodsAndTagExample example);

  int deleteByPrimaryKey(String id);

  int insert(GmsGoodsAndTag record);

  int insertSelective(GmsGoodsAndTag record);

  List<GmsGoodsAndTag> selectByExample(GmsGoodsAndTagExample example);

  GmsGoodsAndTag selectByPrimaryKey(String id);

  int updateByExampleSelective(@Param("record") GmsGoodsAndTag record, @Param("example") GmsGoodsAndTagExample example);

  int updateByExample(@Param("record") GmsGoodsAndTag record, @Param("example") GmsGoodsAndTagExample example);

  int updateByPrimaryKeySelective(GmsGoodsAndTag record);

  int updateByPrimaryKey(GmsGoodsAndTag record);
}