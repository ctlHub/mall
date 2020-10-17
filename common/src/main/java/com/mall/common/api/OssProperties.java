package com.mall.common.api;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StringUtils;

import javax.annotation.PostConstruct;

/**
 * OSS属性配置类
 *
 * @author 李重辰
 * @date 2020/9/25 9:01
 */
@Data
@Configuration(proxyBeanMethods = false)
@ConfigurationProperties(prefix = "alibaba.oss")
public class OssProperties {
    private String endpoint;
    private String accessKeyId;
    private String accessKeySecret;
    private String bucketName;
    private String site;

    @PostConstruct
    public void init() {
        if (StringUtils.isEmpty(site)) {
            this.site = "https://" + getBucketName() + "." + getEndpoint();
        }
    }
}
