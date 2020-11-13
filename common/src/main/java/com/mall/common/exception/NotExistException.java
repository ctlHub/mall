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

  /**
   * user/product/等
   * 由{@link GlobalExceptionHandler#paramValidException(com.mall.common.exception.NotExistException)}捕获
   * 最终输出：user【message】 不存在
   * @return notExist的类型
   */
  protected abstract String getType();
}
