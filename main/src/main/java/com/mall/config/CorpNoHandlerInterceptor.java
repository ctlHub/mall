package com.mall.config;

import com.mall.common.utils.ThreadLocalUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.HandlerMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;

@Slf4j
public class CorpNoHandlerInterceptor implements HandlerInterceptor {

  @Override
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
    initParamToThreadLocal(request, "corpNo");
    initParamToThreadLocal(request, "userCode");
    return true;
  }

  /**
   * 将从request中获到的变量set到ThreadLocal中
   *
   * @param request HttpServletRequest
   * @param param   参数名称
   */
  private void initParamToThreadLocal(HttpServletRequest request, String param) {
    String paramValue = getParamValue(request, param);
    if (StringUtils.isEmpty(paramValue)) {
      return;
    }
    try {
      Class<?> threadLocalUtil = Class.forName("com.mall.common.utils.ThreadLocalUtil");
      // 将Param转化为首字母大写，与threadLocalUtil中的set方法相对应
      param = param.substring(0, 1).toUpperCase() + param.substring(1);
      Method method = threadLocalUtil.getMethod("set" + param, String.class);
      method.invoke(null, paramValue);
    } catch (ClassNotFoundException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
      e.printStackTrace();
    }
  }

  /**
   * 从路径变量或者url参数中获取变量值
   *
   * @param request HttpServletRequest
   * @param param   参数的名称
   * @return 参数的值，如果参数不存在，则返回null
   */
  private String getParamValue(HttpServletRequest request, String param) {
    String value = null;
    Map<?, ?> pathVariables = (Map<?, ?>) request.getAttribute(HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE);
    if (pathVariables != null && pathVariables.size() > 0) {
      value = (String) pathVariables.get(param);
    }
    if (StringUtils.isEmpty(value)) {
      value = request.getParameter(param);
    }
    return value;
  }

  @Override
  public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
    ThreadLocalUtil.remove();
  }

}