package com.mall.entity.dto;

import com.mall.entity.model.Child;
import com.mall.entity.model.Optional;
import com.mall.entity.model.PriceRange;
import com.mall.mbg.model.GmsGoods;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * 商品详情页面商品详情VO
 *
 * @author 李重辰
 * @date 2020/9/23 10:35
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class ProductDetailGoodsDetailVO extends GmsGoods {

    /**
     * 型号商品价格范围
     */
    private PriceRange priceRange;

    /**
     * 型号商品选择
     */
    private List<Optional> optionList;

    /**
     * 子项商品选择
     */
    private List<Child> childList;

    /**
     * 子项商品信息
     */
    private List<GmsGoods> childGoods;

    private String iconImage;
    private List<String> mainImages;
    private List<String> otherImages;
}
