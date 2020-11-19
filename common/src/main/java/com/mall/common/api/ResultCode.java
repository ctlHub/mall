package com.mall.common.api;

/**
 * 常用API操作码
 *
 * @author 李重辰
 */
public enum ResultCode implements IErrorCode {
  /**
   * 操作成功
   */
  SUCCESS(200, "操作成功"),
  /**
   * 操作失败
   */
  FAILED(500, "操作失败"),
  /**
   * 参数检验失败
   */
  VALIDATE_FAILED(499, "参数检验失败"),
  /**
   * 结果集为空
   */
  EMPTY(444, "结果集为空");
  private final long code;
  private final String message;

  ResultCode(long code, String message) {
    this.code = code;
    this.message = message;
  }

  @Override
  public long getId() {
    return code;
  }

  @Override
  public String getMessage() {
    return message;
  }
}
