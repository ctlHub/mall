package com.mall.dao;

import com.mall.entity.dto.GmcGoodsAttributeResult;
import com.mall.mbg.model.GmsGoodsAndAttribute;

import java.util.List;

/**
 * 商品属性查询Dao
 *
 * @author 李重辰
 * @date 2020/10/16 10:28
 */
public interface GmsGoodsAttributeDao {

    /**
     * 已知大类code和商品编号，查商品属性
     * gcm_category_attribute left join gms_goods_and_attribute
     *
     * @param cateGoryCode 类别Code
     * @param goodsCode    商品code
     * @return 商品属性的code, name和value
     */
    List<GmcGoodsAttributeResult> list(String cateGoryCode, String goodsCode);

    /**
     * 已知商品编号，查商品属性
     * gms_goods_and_attribute inner join gcm_category_attribute
     *
     * @param goodsCode 商品code
     * @return 商品属性的code, name和value
     */
    List<GmcGoodsAttributeResult> listForApp(String goodsCode);

    Integer save(List<GmsGoodsAndAttribute> goodsAndAttributeList);
}
