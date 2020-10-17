package com.mall.mbg.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.mall.mbg.model.CmsNotice;
import com.mall.mbg.model.CmsNoticeExample;

public interface CmsNoticeMapper {
    long countByExample(CmsNoticeExample example);

    int deleteByExample(CmsNoticeExample example);

    int deleteByPrimaryKey(Long uid);

    int insert(CmsNotice record);

    int insertSelective(CmsNotice record);

    List<CmsNotice> selectByExampleWithBLOBs(CmsNoticeExample example);

    List<CmsNotice> selectByExample(CmsNoticeExample example);

    CmsNotice selectByPrimaryKey(Long uid);

    int updateByExampleSelective(@Param("record") CmsNotice record, @Param("example") CmsNoticeExample example);

    int updateByExampleWithBLOBs(@Param("record") CmsNotice record, @Param("example") CmsNoticeExample example);

    int updateByExample(@Param("record") CmsNotice record, @Param("example") CmsNoticeExample example);

    int updateByPrimaryKeySelective(CmsNotice record);

    int updateByPrimaryKeyWithBLOBs(CmsNotice record);

    int updateByPrimaryKey(CmsNotice record);
}