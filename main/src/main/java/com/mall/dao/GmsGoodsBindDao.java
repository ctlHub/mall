package com.mall.dao;

import com.mall.mbg.model.GmsGoods;

import java.util.List;

/**
 * 商品绑定自定义Dao
 *
 * @author 李重辰
 * @date 2020/10/9 10:46
 */
public interface GmsGoodsBindDao {
    List<GmsGoods> get(String corpNo, String primaryGoodsCode);
}
