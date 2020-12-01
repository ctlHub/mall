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
public class AdminApplication extends SpringBootServletInitializer {

  public static void main(String[] args) {
    SpringApplication.run(AdminApplication.class, args);
  }

  @Override
  protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
    return builder.sources(AdminApplication.class);
  }

}
