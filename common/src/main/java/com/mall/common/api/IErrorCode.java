package com.mall.common.api;

/**
 * 封装API的错误码
 *
 * @author 李重辰
 */
public interface IErrorCode {
  /**
   * 返回错误码
   *
   * @return 错误编码
   */
  long getId();

  /**
   * 返回错误消息
   *
   * @return 错误消息
   */
  String getMessage();
}
