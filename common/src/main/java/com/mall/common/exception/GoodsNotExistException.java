package com.mall.common.exception;

/**
 * 商品不存在异常类
 *
 * @author 李重辰
 * @date 2020/9/17 14:05
 */
public class GoodsNotExistException extends NotExistException {

  public GoodsNotExistException(String goodsCode) {
    super(goodsCode);
  }

  @Override
  protected String getType() {
    return "商品";
  }

}
