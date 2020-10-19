package com.mall.common.exception;

/**
 * 标签不存在异常类
 *
 * @author 李重辰
 * @date 2020/9/17 14:05
 */
public class TagNotExistException extends NotExistException {

  public TagNotExistException(String goodsCode) {
    super(goodsCode);
  }

  @Override
  protected String getType() {
    return "标签";
  }
}
