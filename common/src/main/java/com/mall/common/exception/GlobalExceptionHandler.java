package com.mall.common.exception;

import com.mall.common.api.CommonResult;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.ValidationException;
import java.util.List;

/**
 * 全局异常处理
 *
 * @author 李重辰
 * @date 2020/9/14 14:13
 */
@ControllerAdvice
public class GlobalExceptionHandler {

  @ResponseBody
  @ExceptionHandler(value = {IllegalArgumentException.class, ValidationException.class, MissRequiredParamException.class})
  public CommonResult<?> paramValidException(RuntimeException e) {
    return CommonResult.validateFailed(e.getMessage());
  }

  @ResponseBody
  @ExceptionHandler(value = NotExistException.class)
  public CommonResult<?> paramValidException(NotExistException e) {
    return CommonResult.failed(e.getType() + "【" + e.getMessage() + "】" + "不存在");
  }

  @ResponseBody
  @ExceptionHandler(value = RuntimeException.class)
  public CommonResult<?> handleValidException(RuntimeException e) {
    return CommonResult.failed(e.getMessage());
  }

  @ResponseBody
  @ExceptionHandler(value = MethodArgumentNotValidException.class)
  public CommonResult<?> paramValidException(MethodArgumentNotValidException e) {
    return getCommonResult(e.getBindingResult());
  }

  @ResponseBody
  @ExceptionHandler(value = BindException.class)
  public CommonResult<?> handleValidException(BindException e) {
    return getCommonResult(e.getBindingResult());
  }

  private CommonResult<?> getCommonResult(BindingResult bindingResult2) {
    StringBuilder message = new StringBuilder();
    if (bindingResult2.hasErrors()) {
      List<FieldError> fieldErrors = bindingResult2.getFieldErrors();
      fieldErrors.forEach((fieldError) -> message.append(fieldError.getField()).append(fieldError.getDefaultMessage()).append(";"));
    }
    return CommonResult.validateFailed(message.toString());
  }
}
