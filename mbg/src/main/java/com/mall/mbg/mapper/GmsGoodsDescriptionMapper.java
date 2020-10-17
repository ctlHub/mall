package com.mall.mbg.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.mall.mbg.model.GmsGoodsDescription;
import com.mall.mbg.model.GmsGoodsDescriptionExample;

public interface GmsGoodsDescriptionMapper {
    long countByExample(GmsGoodsDescriptionExample example);

    int deleteByExample(GmsGoodsDescriptionExample example);

    int deleteByPrimaryKey(Integer uid);

    int insert(GmsGoodsDescription record);

    int insertSelective(GmsGoodsDescription record);

    List<GmsGoodsDescription> selectByExampleWithBLOBs(GmsGoodsDescriptionExample example);

    List<GmsGoodsDescription> selectByExample(GmsGoodsDescriptionExample example);

    GmsGoodsDescription selectByPrimaryKey(Integer uid);

    int updateByExampleSelective(@Param("record") GmsGoodsDescription record, @Param("example") GmsGoodsDescriptionExample example);

    int updateByExampleWithBLOBs(@Param("record") GmsGoodsDescription record, @Param("example") GmsGoodsDescriptionExample example);

    int updateByExample(@Param("record") GmsGoodsDescription record, @Param("example") GmsGoodsDescriptionExample example);

    int updateByPrimaryKeySelective(GmsGoodsDescription record);

    int updateByPrimaryKeyWithBLOBs(GmsGoodsDescription record);

    int updateByPrimaryKey(GmsGoodsDescription record);
}