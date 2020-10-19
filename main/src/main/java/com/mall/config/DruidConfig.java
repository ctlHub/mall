package com.mall.config;

import com.alibaba.druid.support.http.ResourceServlet;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * 配置Druid的监控
 *
 * @author 李重辰
 * @date 2020/4/12 11:03
 */
@Configuration
public class DruidConfig {

    /**
     * 1. 配置一个管理后台的Servlet
     */
    @Bean
    public ServletRegistrationBean<StatViewServlet> statViewServlet() {
        ServletRegistrationBean<StatViewServlet> registrationBean = new ServletRegistrationBean<>(new StatViewServlet(), "/druid/*");
        Map<String, String> params = new HashMap<>(16);
        params.put(ResourceServlet.PARAM_NAME_USERNAME, "admin");
        params.put(ResourceServlet.PARAM_NAME_PASSWORD, "123456");
        // 默认允许所有IP登录
        params.put(ResourceServlet.PARAM_NAME_ALLOW, "");
        registrationBean.setInitParameters(params);
        return registrationBean;
    }

    /**
     * 2、配置一个监控的filter
     */
    public FilterRegistrationBean<WebStatFilter> webStatFilter() {
        FilterRegistrationBean<WebStatFilter> registrationBean = new FilterRegistrationBean<>();
        registrationBean.setFilter(new WebStatFilter());
        registrationBean.setUrlPatterns(Collections.singletonList("/*"));
        Map<String, String> params = new HashMap<>(16);
        params.put(WebStatFilter.PARAM_NAME_EXCLUSIONS, "*.js,*.css,/druid/*");
        registrationBean.setInitParameters(params);
        return registrationBean;
    }
}
