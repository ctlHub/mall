package com.mall.entity.dto;

import com.mall.common.validate.UpdateGroup;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * 商品电商平台绑定 新增修改参数类
 *
 * @author 李重辰
 * @date 2020/9/27 16:08
 */
@Data
public class GmsGoodsEshopParam {
  /**
   * 主键UID
   */
  private Integer uid;

  /**
   * 账套代码
   */
  @NotEmpty
  private String corpNo;

  /**
   * 商品料号
   */
  @NotEmpty
  private String goodsCode;

  /**
   * 启用状态
   */
  @NotNull(groups = UpdateGroup.class)
  private Integer status;

  /**
   * 电商平台类型
   */
  private Integer eshopType;

  /**
   * 电商平台名称
   */
  @NotEmpty
  private String eshopName;

  /**
   * 商品在电商平台的链接
   */
  @NotEmpty
  private String eshopGoodsUrl;

}
