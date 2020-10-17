package com.mall.mbg.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.mall.mbg.model.CmsIndexCarousel;
import com.mall.mbg.model.CmsIndexCarouselExample;

public interface CmsIndexCarouselMapper {
    long countByExample(CmsIndexCarouselExample example);

    int deleteByExample(CmsIndexCarouselExample example);

    int deleteByPrimaryKey(Integer uid);

    int insert(CmsIndexCarousel record);

    int insertSelective(CmsIndexCarousel record);

    List<CmsIndexCarousel> selectByExample(CmsIndexCarouselExample example);

    CmsIndexCarousel selectByPrimaryKey(Integer uid);

    int updateByExampleSelective(@Param("record") CmsIndexCarousel record, @Param("example") CmsIndexCarouselExample example);

    int updateByExample(@Param("record") CmsIndexCarousel record, @Param("example") CmsIndexCarouselExample example);

    int updateByPrimaryKeySelective(CmsIndexCarousel record);

    int updateByPrimaryKey(CmsIndexCarousel record);
}