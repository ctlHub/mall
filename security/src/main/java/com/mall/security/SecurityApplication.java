package com.mall.security;

import com.mall.common.model.RsaKeyProperties;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

/**
 * 认证服务启动类
 *
 * @author 李重辰
 * @date 2020/11/19 22:29
 */
@MapperScan("com.mall.security.mapper")
@SpringBootApplication
@EnableConfigurationProperties(RsaKeyProperties.class)
public class SecurityApplication {

  public static void main(String[] args) {
    SpringApplication.run(SecurityApplication.class, args);
  }

}
