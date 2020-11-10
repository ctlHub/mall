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
    http.authorizeRequests()
        .withObjectPostProcessor(new ObjectPostProcessor<FilterSecurityInterceptor>() {
          @Override
          public <O extends FilterSecurityInterceptor> O postProcess(O object) {
            object.setSecurityMetadataSource(myFilterInvocationSecurityMetadataSource);
            object.setAccessDecisionManager(myAccessDecisionManager);
            return object;
          }
        })
        .and().formLogin().permitAll()
        .and().csrf().disable();
  }

  @Bean
  PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }

}
