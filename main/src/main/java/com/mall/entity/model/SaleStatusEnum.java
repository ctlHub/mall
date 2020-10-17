package com.mall.entity.model;

/**
 * 商品促销类型枚举类
 *
 * @author 李重辰
 * @date 2020/9/24 15:22
 */
public enum SaleStatusEnum {
  topView(98, "置顶"),
  newProduct(1, "新品"),
  hot(2, "热销"),
  specialOffer(3, "特价"),
  classic(4, "经典"),
  promotion(99, "促销");
  private int code;
  private String name;

  SaleStatusEnum(int code, String name) {
    this.code = code;
    this.name = name;
  }

  public int getId() {
    return code;
  }

  public void setCode(int code) {
    this.code = code;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

}
