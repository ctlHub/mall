package com.mall.entity.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 商品属性查询结果
 *
 * @author 李重辰
 * @date 2020/10/16 9:55
 */
@JsonInclude
@Data
public class GmcGoodsAttributeResult {
  @ApiModelProperty("属性code")
  private String code;
  @ApiModelProperty("属性名称")
  private String name;
  @ApiModelProperty("属性值")
  private String value = "";
}
