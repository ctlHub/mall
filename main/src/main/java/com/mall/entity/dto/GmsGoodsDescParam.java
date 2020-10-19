package com.mall.entity.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

/**
 * 商品描述新增修改参数类
 *
 * @author 李重辰
 * @date 2020/9/27 16:08
 */
@Data
public class GmsGoodsDescParam {

    /**
     * 主键UID
     */
    private Integer uid;

    /**
     * 账套代码
     */
    @NotEmpty
    private String merchantId;

    /**
     * 商品料号
     */
    @NotEmpty
    private String goodsId;

    /**
     * Description唯一id
     */
    private String code;

    /**
     * 启用状态
     */
    private Integer status;

    /**
     * 说明标题
     */
    private String title;

    /**
     * 内容
     */
    private String content;

}
