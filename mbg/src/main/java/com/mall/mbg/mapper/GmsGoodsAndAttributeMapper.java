package com.mall.mbg.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.mall.mbg.model.GmsGoodsAndAttribute;
import com.mall.mbg.model.GmsGoodsAndAttributeExample;

public interface GmsGoodsAndAttributeMapper {
    long countByExample(GmsGoodsAndAttributeExample example);

    int deleteByExample(GmsGoodsAndAttributeExample example);

    int deleteByPrimaryKey(Long uid);

    int insert(GmsGoodsAndAttribute record);

    int insertSelective(GmsGoodsAndAttribute record);

    List<GmsGoodsAndAttribute> selectByExample(GmsGoodsAndAttributeExample example);

    GmsGoodsAndAttribute selectByPrimaryKey(Long uid);

    int updateByExampleSelective(@Param("record") GmsGoodsAndAttribute record, @Param("example") GmsGoodsAndAttributeExample example);

    int updateByExample(@Param("record") GmsGoodsAndAttribute record, @Param("example") GmsGoodsAndAttributeExample example);

    int updateByPrimaryKeySelective(GmsGoodsAndAttribute record);

    int updateByPrimaryKey(GmsGoodsAndAttribute record);
}