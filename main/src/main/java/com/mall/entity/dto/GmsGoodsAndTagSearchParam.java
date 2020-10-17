package com.mall.entity.dto;

import lombok.Data;

/**
 * @author 李重辰
 * @date 2020/9/18 10:08
 */
@Data
public class GmsGoodsAndTagSearchParam {
    /**
     * 商品查询条件
     * <p>
     * 支持品名，规格，料号 模糊匹配
     */
    private String goodsSearch;

    /**
     * 标签查询条件
     * <p>
     * 支持名称，类型 模糊匹配
     */
    private String tagSearch;

    /**
     * 最大载入笔数条数
     */
    private Integer maxRecord;
}
