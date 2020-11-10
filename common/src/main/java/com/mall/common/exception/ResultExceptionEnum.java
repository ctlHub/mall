package com.mall.common.exception;

import lombok.Getter;

/**
 * @author tanghao
 * @date 2020/11/10 11:35
 */
@Getter
public enum ResultExceptionEnum {
  /**
   * 传参不正确
   */
  PARAM_ERROR(1, "参数不正确"),

  USERNAME_NOT_EXIST(10, "用户名不存在"),
  ;

  private final Integer code;

  private final String message;

  ResultExceptionEnum(Integer code, String message) {
    this.code = code;
    this.message = message;
  }
}
