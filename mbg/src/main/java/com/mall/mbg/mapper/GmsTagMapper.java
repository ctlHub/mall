package com.mall.mbg.mapper;

import com.mall.mbg.model.GmsTag;
import com.mall.mbg.model.GmsTagExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GmsTagMapper {
    long countByExample(GmsTagExample example);

    int deleteByExample(GmsTagExample example);

    int deleteByPrimaryKey(String id);

    int insert(GmsTag record);

    int insertSelective(GmsTag record);

    List<GmsTag> selectByExample(GmsTagExample example);

    GmsTag selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") GmsTag record, @Param("example") GmsTagExample example);

    int updateByExample(@Param("record") GmsTag record, @Param("example") GmsTagExample example);

    int updateByPrimaryKeySelective(GmsTag record);

    int updateByPrimaryKey(GmsTag record);
}