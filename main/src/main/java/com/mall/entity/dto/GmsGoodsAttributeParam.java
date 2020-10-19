package com.mall.entity.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;

/**
 * 商品属性管理接口参数
 *
 * @author 李重辰
 * @date 2020/10/16 9:50
 */
@Data
public class GmsGoodsAttributeParam {

    @ApiModelProperty("商品编号")
    @NotEmpty
    private String goodsId;

    @ApiModelProperty("大类名称")
    @NotEmpty
    private String class1;
}
