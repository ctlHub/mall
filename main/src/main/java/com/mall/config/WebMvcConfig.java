package com.mall.config;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonParser;
import com.google.gson.JsonSerializer;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.GsonHttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import springfox.documentation.spring.web.json.Json;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Collection;

/**
 * @author Themaner
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

  @Resource
  private GsonBuilder gsonBuilder;

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