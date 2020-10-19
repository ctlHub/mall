package com.mall.common.api;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 接口路径前缀配置
 *
 * @author 李重辰
 * @date 2020/9/21 16:46
 */
@Component
@ConfigurationProperties(prefix = "api.path")
@Data
public class ApiPathProperties {

  String globalPrefix = "api";

}