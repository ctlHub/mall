package com.mall.mbg.mapper;

import com.mall.mbg.model.GmsGoodsBind;
import com.mall.mbg.model.GmsGoodsBindExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GmsGoodsBindMapper {
    long countByExample(GmsGoodsBindExample example);

    int deleteByExample(GmsGoodsBindExample example);

    int deleteByPrimaryKey(String id);

    int insert(GmsGoodsBind record);

    int insertSelective(GmsGoodsBind record);

    List<GmsGoodsBind> selectByExample(GmsGoodsBindExample example);

    GmsGoodsBind selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") GmsGoodsBind record, @Param("example") GmsGoodsBindExample example);

    int updateByExample(@Param("record") GmsGoodsBind record, @Param("example") GmsGoodsBindExample example);

    int updateByPrimaryKeySelective(GmsGoodsBind record);

    int updateByPrimaryKey(GmsGoodsBind record);
}