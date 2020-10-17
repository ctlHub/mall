package com.mall.mbg.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.mall.mbg.model.MmsMerchant;
import com.mall.mbg.model.MmsMerchantExample;

public interface MmsMerchantMapper {
    long countByExample(MmsMerchantExample example);

    int deleteByExample(MmsMerchantExample example);

    int deleteByPrimaryKey(Integer uid);

    int insert(MmsMerchant record);

    int insertSelective(MmsMerchant record);

    List<MmsMerchant> selectByExample(MmsMerchantExample example);

    MmsMerchant selectByPrimaryKey(Integer uid);

    int updateByExampleSelective(@Param("record") MmsMerchant record, @Param("example") MmsMerchantExample example);

    int updateByExample(@Param("record") MmsMerchant record, @Param("example") MmsMerchantExample example);

    int updateByPrimaryKeySelective(MmsMerchant record);

    int updateByPrimaryKey(MmsMerchant record);
}