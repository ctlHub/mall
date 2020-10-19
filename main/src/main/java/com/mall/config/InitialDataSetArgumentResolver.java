package com.mall.config;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;

import java.util.LinkedList;
import java.util.List;

/**
 * 初始化将自定义的DataSetJsonArgumentResolver注入到RequestMappingHandlerAdapter中
 *
 * @author 李重辰
 * @date 2020/9/8 10:22
 */
@Component
public class InitialDataSetArgumentResolver implements ApplicationContextAware {

  @Override
  public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
    RequestMappingHandlerAdapter handlerAdapter = applicationContext.getBean(RequestMappingHandlerAdapter.class);
    List<HandlerMethodArgumentResolver> argumentResolvers = handlerAdapter.getArgumentResolvers();
    List<HandlerMethodArgumentResolver> resolvers = new LinkedList<>();
    resolvers.add(new DataSetJsonArgumentResolver());
    assert argumentResolvers != null;
    resolvers.addAll(argumentResolvers);
    handlerAdapter.setArgumentResolvers(resolvers);
  }

}