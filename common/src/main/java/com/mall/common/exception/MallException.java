package com.mall.common.exception;

/**
 * @author tanghao
 * @date 2020/11/10 11:37
 */
public class MallException extends RuntimeException {
  private final Integer code;

  private String message;

  public MallException(ResultExceptionEnum resultEnum) {
    super(resultEnum.getMessage());
    this.code = resultEnum.getCode();
  }

  public MallException(Integer code, String message) {
    super(message);
    this.code = code;
  }
}
