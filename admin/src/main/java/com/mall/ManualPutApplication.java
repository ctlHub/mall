package com.mall;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * @author ctlHub
 */
@EnableConfigurationProperties
@SpringBootApplication
public class ManualPutApplication extends SpringBootServletInitializer {

  public static void main(String[] args) {
    SpringApplication.run(ManualPutApplication.class, args);
  }

  @Override
  protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
    return builder.sources(ManualPutApplication.class);
  }

}
