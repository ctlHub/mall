package com.mall.common.exception;

/**
 * 类别属性不存在
 *
 * @author 李重辰
 * @date 2020/10/16 11:01
 */
public class AttributeNotExistException extends NotExistException {
  public AttributeNotExistException(Object message) {
    super(message);
  }

  @Override
  protected String getType() {
    return "类别属性";
  }
}
