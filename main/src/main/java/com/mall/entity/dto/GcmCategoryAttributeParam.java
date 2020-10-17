package com.mall.entity.dto;

import com.mall.common.validate.CreateGroup;
import com.mall.common.validate.DeleteGroup;
import com.mall.common.validate.UpdateGroup;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;

/**
 * 大类属性管理参数
 *
 * @author 李重辰
 * @date 2020/10/15 13:48
 */
@Data
public class GcmCategoryAttributeParam {

  @ApiModelProperty("类别code")
  @NotEmpty(groups = {CreateGroup.class})
  private String categoryId;

  @ApiModelProperty(value = "属性code")
  @NotEmpty(groups = {UpdateGroup.class, DeleteGroup.class})
  private String id;

  @NotEmpty(groups = {UpdateGroup.class, CreateGroup.class})
  @ApiModelProperty(value = "属性的名称")
  private String name;

  @ApiModelProperty(value = "备注")
  private String remark;

}
