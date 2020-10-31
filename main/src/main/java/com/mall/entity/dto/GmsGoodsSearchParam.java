package com.mall.entity.dto;

import com.mall.mbg.model.GmsGoods;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author 李重辰
 * @date 2020/9/9 10:29
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class GmsGoodsSearchParam extends GmsGoods {
  /**
   * 模糊查询
   */
  private String searchText;

  /**
   * 记录条数
   */
  private Integer maxRecord;
}