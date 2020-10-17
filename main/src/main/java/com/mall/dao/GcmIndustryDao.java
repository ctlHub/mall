package com.mall.dao;

import com.mall.mbg.model.GcmIndustry;

import java.util.List;

/**
 * 行业管理自定义Dao
 *
 * @author 李重辰
 * @date 2020/10/15 9:59
 */
public interface GcmIndustryDao {

    /**
     * 批量同步行业
     */
    int sync(List<GcmIndustry> gcmIndustryList);
}
