package com.mall.common.exception;

/**
 * 自定义异常类请继承自RuntimeException
 * Spring声明式事务默认在抛出unchecked异常（RuntimeException）或者Error才回滚事务。其他异常不会触发回滚事务
 *
 * @author 李重辰
 * @date 2020/9/14 15:17
 */
public class MissRequiredParamException extends RuntimeException {
  public MissRequiredParamException() {
    super();
  }

  public MissRequiredParamException(String message) {
    super(message);
  }

  public MissRequiredParamException(Throwable cause) {
    super(cause);
  }

  public MissRequiredParamException(String message, Throwable cause) {
    super(message, cause);
  }
}
