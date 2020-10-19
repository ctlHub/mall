package com.mall.mbg.mapper;

import com.mall.mbg.model.GmsGoodsAndAttribute;
import com.mall.mbg.model.GmsGoodsAndAttributeExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GmsGoodsAndAttributeMapper {
    long countByExample(GmsGoodsAndAttributeExample example);

    int deleteByExample(GmsGoodsAndAttributeExample example);

    int deleteByPrimaryKey(String id);

    int insert(GmsGoodsAndAttribute record);

    int insertSelective(GmsGoodsAndAttribute record);

    List<GmsGoodsAndAttribute> selectByExample(GmsGoodsAndAttributeExample example);

    GmsGoodsAndAttribute selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") GmsGoodsAndAttribute record, @Param("example") GmsGoodsAndAttributeExample example);

    int updateByExample(@Param("record") GmsGoodsAndAttribute record, @Param("example") GmsGoodsAndAttributeExample example);

    int updateByPrimaryKeySelective(GmsGoodsAndAttribute record);

    int updateByPrimaryKey(GmsGoodsAndAttribute record);
}