package com.mall.entity.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import com.mall.mbg.model.GmsGoods;

import java.util.List;

/**
 * 商品查询结果集
 *
 * @author 李重辰
 * @date 2020/9/18 8:20
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class GmsGoodsSearchResult extends GmsGoods {
    /**
     * 商品标签
     */
    private String tagArray;
    private String iconImage;
    private List<String> mainImages;
    private List<String> otherImages;
}
