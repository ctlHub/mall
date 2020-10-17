package com.mall.mbg.mapper;

import com.mall.mbg.model.GmsGoods;
import com.mall.mbg.model.GmsGoodsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GmsGoodsMapper {
    long countByExample(GmsGoodsExample example);

    int deleteByExample(GmsGoodsExample example);

    int deleteByPrimaryKey(String id);

    int insert(GmsGoods record);

    int insertSelective(GmsGoods record);

    List<GmsGoods> selectByExampleWithBLOBs(GmsGoodsExample example);

    List<GmsGoods> selectByExample(GmsGoodsExample example);

    GmsGoods selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") GmsGoods record, @Param("example") GmsGoodsExample example);

    int updateByExampleWithBLOBs(@Param("record") GmsGoods record, @Param("example") GmsGoodsExample example);

    int updateByExample(@Param("record") GmsGoods record, @Param("example") GmsGoodsExample example);

    int updateByPrimaryKeySelective(GmsGoods record);

    int updateByPrimaryKeyWithBLOBs(GmsGoods record);

    int updateByPrimaryKey(GmsGoods record);
}