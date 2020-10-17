package com.mall.mbg.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.mall.mbg.model.GmsGoods;
import com.mall.mbg.model.GmsGoodsExample;

public interface GmsGoodsMapper {
    long countByExample(GmsGoodsExample example);

    int deleteByExample(GmsGoodsExample example);

    int deleteByPrimaryKey(Integer uid);

    int insert(GmsGoods record);

    int insertSelective(GmsGoods record);

    List<GmsGoods> selectByExampleWithBLOBs(GmsGoodsExample example);

    List<GmsGoods> selectByExample(GmsGoodsExample example);

    GmsGoods selectByPrimaryKey(Integer uid);

    int updateByExampleSelective(@Param("record") GmsGoods record, @Param("example") GmsGoodsExample example);

    int updateByExampleWithBLOBs(@Param("record") GmsGoods record, @Param("example") GmsGoodsExample example);

    int updateByExample(@Param("record") GmsGoods record, @Param("example") GmsGoodsExample example);

    int updateByPrimaryKeySelective(GmsGoods record);

    int updateByPrimaryKeyWithBLOBs(GmsGoods record);

    int updateByPrimaryKey(GmsGoods record);
}