package com.mall.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.oas.annotations.EnableOpenApi;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * 启用Swagger文档
 *
 * @author 李重辰
 * @date 2020/10/10 9:01
 */
@EnableOpenApi
@Configuration
public class SwaggerConfig {

  /**
   * 创建API应用
   * apiInfo() 增加API相关信息
   * 通过select()函数返回一个ApiSelectorBuilder实例,用来控制哪些接口暴露给Swagger来展现，
   * 本例采用指定扫描的包路径来定义指定要建立API的目录。
   */
  @Bean
  public Docket adminDoc() {
    return new Docket(DocumentationType.OAS_30)
        .groupName("admin")
        .apiInfo(apiInfo("管理后台接口 for 地藤管家", "1.1"))
        .useDefaultResponseMessages(true)
        .forCodeGeneration(false)
        .select()
        .apis(RequestHandlerSelectors.basePackage("com.mall.controller"))
        .paths(PathSelectors.any())
        .build();
  }

  /**
   * 创建该API的基本信息（这些基本信息会展现在文档页面中）
   * 访问地址：http://ip:port/swagger-ui/index.html
   */
  private ApiInfo apiInfo(String title, String version) {
    return new ApiInfoBuilder()
        .title(title)
        .description("接口返回数据描述请根据Schema查询")
        .contact(new Contact("李重辰", "", "themaner@dingtalk.com"))
        .version(version)
        .build();
  }
}