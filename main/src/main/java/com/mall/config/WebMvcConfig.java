package com.mall.config;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonParser;
import com.google.gson.JsonSerializer;
import com.mall.common.api.ApiPathProperties;
import com.mall.common.api.ApiRestController;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.GsonHttpMessageConverter;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import springfox.documentation.spring.web.json.Json;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Collection;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

  @Resource
  private ApiPathProperties apiPathProperties;
  @Resource
  private GsonBuilder gsonBuilder;

  @Override
  public void addResourceHandlers(ResourceHandlerRegistry registry) {
    registry.addResourceHandler("/static/**");
  }

  @Override
  public void addInterceptors(InterceptorRegistry registry) {
    registry.addInterceptor(new CorpNoHandlerInterceptor()).addPathPatterns("/**").
        excludePathPatterns("/", "/user/login", "/index", "/static/**", "/webjars/**");
  }

  @Override
  public void configurePathMatch(PathMatchConfigurer configurer) {
    configurer.addPathPrefix(apiPathProperties.getGlobalPrefix(), c -> c.isAnnotationPresent(ApiRestController.class));
  }

  @Bean
  public HttpMessageConverters customConverters() {
    Gson gson = gsonBuilder.registerTypeAdapter(Json.class, (JsonSerializer<Json>) (src, typeOfSrc, context) -> JsonParser.parseString(src.value())).create();
    Collection<HttpMessageConverter<?>> messageConverters = new ArrayList<>();
    GsonHttpMessageConverter gsonHttpMessageConverter = new GsonHttpMessageConverter();
    gsonHttpMessageConverter.setGson(gson);
    messageConverters.add(gsonHttpMessageConverter);
    return new HttpMessageConverters(true, messageConverters);
  }
}