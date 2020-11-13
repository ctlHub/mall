package com.mall.config;

import com.mall.security.MyAccessDecisionManager;
import com.mall.security.MyFilterInvocationSecurityMetadataSource;
import com.mall.service.BizUserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.ObjectPostProcessor;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

/**
 * @author tanghao
 * @date 2020/11/7 15:57
 */
@Configuration
public class MySecurityConfig extends WebSecurityConfigurerAdapter {

  private final BizUserService bizUserService;

  private final MyFilterInvocationSecurityMetadataSource myFilterInvocationSecurityMetadataSource;

  private final MyAccessDecisionManager myAccessDecisionManager;

  public MySecurityConfig(BizUserService bizUserService, MyFilterInvocationSecurityMetadataSource myFilterInvocationSecurityMetadataSource, MyAccessDecisionManager myAccessDecisionManager) {
    this.bizUserService = bizUserService;
    this.myFilterInvocationSecurityMetadataSource = myFilterInvocationSecurityMetadataSource;
    this.myAccessDecisionManager = myAccessDecisionManager;
  }

  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    auth.userDetailsService(bizUserService);
  }

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http.cors().configurationSource(CorsConfigurationSource()).and()
        .authorizeRequests()
        .withObjectPostProcessor(new ObjectPostProcessor<FilterSecurityInterceptor>() {
          @Override
          public <O extends FilterSecurityInterceptor> O postProcess(O object) {
            object.setSecurityMetadataSource(myFilterInvocationSecurityMetadataSource);
            object.setAccessDecisionManager(myAccessDecisionManager);
            return object;
          }
        })
        //.and().formLogin().successForwardUrl("/bizUser/list/1").permitAll()
        .and().formLogin().defaultSuccessUrl("/bizUser/list/1").permitAll()
        .and().csrf().disable();
  }

  @Bean
  PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }

  private CorsConfigurationSource CorsConfigurationSource() {
    CorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
    CorsConfiguration corsConfiguration = new CorsConfiguration();
    //同源配置，*表示任何请求都视为同源，若需指定ip和端口可以改为如“localhost：8080”，多个以“，”分隔；
    corsConfiguration.addAllowedOrigin("*");
    //header，允许哪些header，本案中使用的是token，此处可将*替换为token；
    corsConfiguration.addAllowedHeader("*");
    //允许的请求方法，PSOT、GET等
    corsConfiguration.addAllowedMethod("*");
    //配置允许跨域访问的url
    ((UrlBasedCorsConfigurationSource) source).registerCorsConfiguration("/**", corsConfiguration);
    return source;
  }
}
