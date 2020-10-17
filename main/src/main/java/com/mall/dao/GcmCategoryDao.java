package com.mall.dao;

import com.mall.mbg.model.GcmCategory;

import java.util.List;

/**
 * 商品分类管理自定义Dao
 *
 * @author 李重辰
 * @date 2020/10/15 9:59
 */
public interface GcmCategoryDao {

    /**
     * 批量同步商品分类
     */
    int sync(List<GcmCategory> gcmCategoryList);
}
