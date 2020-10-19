package com.mall.common.exception;

/**
 * 当数据库中效验商品不存在或**不存在时请抛出继承该接口的异常，并在子类中重写getType方法指定类型
 *
 * @author 李重辰
 * @date 2020/9/17 14:13
 */
public abstract class NotExistException extends RuntimeException {

  private static final long serialVersionUID = 1172126364306415352L;

  protected NotExistException(Object message) {
    super(String.valueOf(message));
  }

  protected abstract String getType();
}
