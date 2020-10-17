package com.mall.dao;

import com.mall.entity.dto.GmsGoodsAndTagListResult;
import com.mall.entity.dto.GmsGoodsAndTagSearchParam;
import com.mall.mbg.model.GmsGoodsAndTag;
import com.mall.mbg.model.GmsTag;

import java.util.List;

/**
 * 商品and标签自定义Dao
 *
 * @author 李重辰
 * @date 2020/9/16 19:32
 */
public interface GmsGoodsAndTagDao {
    int cancelBind(String corpNo, List<GmsGoodsAndTag> goodsAndTagList);

    List<GmsTag> listTagByGoodsCode(String corpNo, String goodsCode);

    List<GmsGoodsAndTagListResult> listGoodsAndTag(String corpNo, GmsGoodsAndTagSearchParam searchParam);
}
