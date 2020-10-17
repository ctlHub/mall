package com.mall.entity.dto;

import com.mall.mbg.model.GmsGoods;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 查询商品与标签查询绑定关系的结果集
 *
 * @author 李重辰
 * @date 2020/9/18 11:50
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class GmsGoodsAndTagListResult extends GmsGoods {
  private String tagCode;
  private String tagName;
  private String tagType;
}
