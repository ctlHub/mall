package com.mall.common.api;

/**
 * 通用返回对象
 *
 * @param <T>
 */
public class CommonResult<T> {
  private long code;
  private boolean result;
  private String message;
  private T data;

  protected CommonResult() {
  }

  protected CommonResult(long code, boolean result, String message, T data) {
    this.code = code;
    this.result = result;
    this.message = message;
    this.data = data;
  }

  /**
   * 成功返回结果
   *
   * @param data 获取的数据
   */
  public static <T> CommonResult<T> success(T data) {
    return new CommonResult<T>(ResultCode.SUCCESS.getId(), true, ResultCode.SUCCESS.getMessage(), data);
  }

  /**
   * 成功返回结果
   *
   * @param data    获取的数据
   * @param message 提示信息
   */
  public static <T> CommonResult<T> success(T data, String message) {
    return new CommonResult<T>(ResultCode.SUCCESS.getId(), true, message, data);
  }

  /**
   * 失败返回结果
   *
   * @param errorCode 错误码
   */
  public static <T> CommonResult<T> failed(IErrorCode errorCode) {
    return new CommonResult<T>(errorCode.getId(), false, errorCode.getMessage(), null);
  }

  /**
   * 失败返回结果
   *
   * @param errorCode 错误码
   * @param message   错误信息
   */
  public static <T> CommonResult<T> failed(IErrorCode errorCode, String message) {
    return new CommonResult<T>(errorCode.getId(), false, message, null);
  }

  /**
   * 失败返回结果
   *
   * @param message 提示信息
   */
  public static <T> CommonResult<T> failed(String message) {
    return new CommonResult<T>(ResultCode.FAILED.getId(), false, message, null);
  }

  /**
   * 失败返回结果
   */
  public static <T> CommonResult<T> failed() {
    return failed(ResultCode.FAILED);
  }

  /**
   * 参数验证失败返回结果
   */
  public static <T> CommonResult<T> validateFailed() {
    return failed(ResultCode.VALIDATE_FAILED);
  }

  /**
   * 参数验证失败返回结果
   *
   * @param message 提示信息
   */
  public static <T> CommonResult<T> validateFailed(String message) {
    return new CommonResult<T>(ResultCode.VALIDATE_FAILED.getId(), false, message, null);
  }

  public long getId() {
    return code;
  }

  public void setCode(long code) {
    this.code = code;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public T getData() {
    return data;
  }

  public void setData(T data) {
    this.data = data;
  }
}
