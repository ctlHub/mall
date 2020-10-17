package com.mall.mbg.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.mall.mbg.model.GmsTag;
import com.mall.mbg.model.GmsTagExample;

public interface GmsTagMapper {
    long countByExample(GmsTagExample example);

    int deleteByExample(GmsTagExample example);

    int deleteByPrimaryKey(Integer uid);

    int insert(GmsTag record);

    int insertSelective(GmsTag record);

    List<GmsTag> selectByExample(GmsTagExample example);

    GmsTag selectByPrimaryKey(Integer uid);

    int updateByExampleSelective(@Param("record") GmsTag record, @Param("example") GmsTagExample example);

    int updateByExample(@Param("record") GmsTag record, @Param("example") GmsTagExample example);

    int updateByPrimaryKeySelective(GmsTag record);

    int updateByPrimaryKey(GmsTag record);
}