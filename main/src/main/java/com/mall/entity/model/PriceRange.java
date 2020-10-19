package com.mall.entity.model;

import lombok.Data;

/**
 * 商品的价格范围
 * 对应goods表中的option中的dataSet的head部分
 *
 * @author 李重辰
 * @date 2020/9/23 10:48
 */
@Data
public class PriceRange {
    /**
     * 最大进货价
     */
    private Double maxInUp;
    /**
     * 最小进货价
     */
    private Double minInUp;
    /**
     * 最大零售价
     */
    private Double maxListUp;
    /**
     * 最小零售价
     */
    private Double minListUp;
    /**
     * 最大批发价
     */
    private Double maxOutUp2;
    /**
     * 最小批发价
     */
    private Double minOutUp2;
    /**
     * 最大出厂价
     */
    private Double maxOutUp;
    /**
     * 最小出厂价
     */
    private Double minOutUp;
    /**
     * 最大会员价
     */
    private Double maxVipUp;
    /**
     * 最小会员价
     */
    private Double minVipUp;
}
