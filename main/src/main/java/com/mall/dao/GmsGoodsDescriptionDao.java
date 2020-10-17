package com.mall.dao;

import java.util.List;

/**
 * 商品描述表自定义Dao
 *
 * @author 李重辰
 * @date 2020/9/23 17:12
 */
public interface GmsGoodsDescriptionDao {

    List<String> listDescriptionContent(String corpNo, String code);
}
