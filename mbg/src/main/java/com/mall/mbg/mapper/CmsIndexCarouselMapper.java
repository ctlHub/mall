package com.mall.mbg.mapper;

import com.mall.mbg.model.CmsIndexCarousel;
import com.mall.mbg.model.CmsIndexCarouselExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CmsIndexCarouselMapper {
  long countByExample(CmsIndexCarouselExample example);

  int deleteByExample(CmsIndexCarouselExample example);

  int deleteByPrimaryKey(String id);

  int insert(CmsIndexCarousel record);

  int insertSelective(CmsIndexCarousel record);

  List<CmsIndexCarousel> selectByExample(CmsIndexCarouselExample example);

  CmsIndexCarousel selectByPrimaryKey(String id);

  int updateByExampleSelective(@Param("record") CmsIndexCarousel record, @Param("example") CmsIndexCarouselExample example);

  int updateByExample(@Param("record") CmsIndexCarousel record, @Param("example") CmsIndexCarouselExample example);

  int updateByPrimaryKeySelective(CmsIndexCarousel record);

  int updateByPrimaryKey(CmsIndexCarousel record);
}