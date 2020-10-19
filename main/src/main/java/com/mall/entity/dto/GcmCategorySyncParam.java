package com.mall.entity.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * 商品分类同步参数dto
 *
 * @author 李重辰
 * @date 2020/10/15 11:20
 */
@Data
public class GcmCategorySyncParam {
    private static final long serialVersionUID = -1811024399548438049L;
    @ApiModelProperty(value = "类型名称")
    private String name;
    @ApiModelProperty(value = "创建人")
    private String appUser;
    @ApiModelProperty(value = "创建时间")
    private Date appDate;
    @ApiModelProperty(value = "更新人")
    private String updateUser;
    @ApiModelProperty(value = "更新时间")
    private Date updateDate;
}
