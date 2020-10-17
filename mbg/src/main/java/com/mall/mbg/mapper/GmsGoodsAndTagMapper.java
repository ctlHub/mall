package com.mall.mbg.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.mall.mbg.model.GmsGoodsAndTag;
import com.mall.mbg.model.GmsGoodsAndTagExample;

public interface GmsGoodsAndTagMapper {
    long countByExample(GmsGoodsAndTagExample example);

    int deleteByExample(GmsGoodsAndTagExample example);

    int deleteByPrimaryKey(Integer uid);

    int insert(GmsGoodsAndTag record);

    int insertSelective(GmsGoodsAndTag record);

    List<GmsGoodsAndTag> selectByExample(GmsGoodsAndTagExample example);

    GmsGoodsAndTag selectByPrimaryKey(Integer uid);

    int updateByExampleSelective(@Param("record") GmsGoodsAndTag record, @Param("example") GmsGoodsAndTagExample example);

    int updateByExample(@Param("record") GmsGoodsAndTag record, @Param("example") GmsGoodsAndTagExample example);

    int updateByPrimaryKeySelective(GmsGoodsAndTag record);

    int updateByPrimaryKey(GmsGoodsAndTag record);
}