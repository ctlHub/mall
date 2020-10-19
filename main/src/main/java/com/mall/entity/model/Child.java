package com.mall.entity.model;

import lombok.Data;

/**
 * 子项商品选择
 * <p>
 * 对应goods表中的option中的dataSet的body部分（当不存在head时）
 *
 * @author 李重辰
 * @date 2020/9/23 14:00
 */
@Data
public class Child {
  private String name;
  private String value;
}
