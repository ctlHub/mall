package com.mall.mbg.mapper;

import com.mall.mbg.model.MmsMerchant;
import com.mall.mbg.model.MmsMerchantExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MmsMerchantMapper {
  long countByExample(MmsMerchantExample example);

  int deleteByExample(MmsMerchantExample example);

  int deleteByPrimaryKey(String id);

  int insert(MmsMerchant record);

  int insertSelective(MmsMerchant record);

  List<MmsMerchant> selectByExample(MmsMerchantExample example);

  MmsMerchant selectByPrimaryKey(String id);

  int updateByExampleSelective(@Param("record") MmsMerchant record, @Param("example") MmsMerchantExample example);

  int updateByExample(@Param("record") MmsMerchant record, @Param("example") MmsMerchantExample example);

  int updateByPrimaryKeySelective(MmsMerchant record);

  int updateByPrimaryKey(MmsMerchant record);
}