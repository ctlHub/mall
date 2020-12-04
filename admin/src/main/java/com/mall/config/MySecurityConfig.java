package com.mall.config;

import com.google.gson.Gson;
import com.mall.common.config.security.JwtAuthenticationProvider;
import com.mall.common.config.security.JwtLoginConfigurer;
import com.mall.common.config.security.JwtRefreshSuccessHandler;
import com.mall.common.model.RsaKeyProperties;
import com.mall.security.MyAccessDecisionManager;
import com.mall.security.MyFilterInvocationSecurityMetadataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.ObjectPostProcessor;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
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

  private final MyFilterInvocationSecurityMetadataSource myFilterInvocationSecurityMetadataSource;

  private final MyAccessDecisionManager myAccessDecisionManager;

  private final RsaKeyProperties rsaKeyProperties;

  private final Gson gson;

  public MySecurityConfig(MyFilterInvocationSecurityMetadataSource myFilterInvocationSecurityMetadataSource,
                          MyAccessDecisionManager myAccessDecisionManager,
                          RsaKeyProperties rsaKeyProperties,
                          Gson gson) {
    this.myFilterInvocationSecurityMetadataSource = myFilterInvocationSecurityMetadataSource;
    this.myAccessDecisionManager = myAccessDecisionManager;
    this.rsaKeyProperties = rsaKeyProperties;
    this.gson = gson;
  }
//
//  @Override
//  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//    auth.userDetailsService(bizUserService);
//  }

  @Override
  public void configure(WebSecurity web) {
    web.ignoring().antMatchers("/swagger-ui/**", "/webjars/**", "/swagger-resources/**", "/v3/**");
  }

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http.cors().configurationSource(corsConfigurationSource()).and()
        .authorizeRequests()
        .withObjectPostProcessor(new ObjectPostProcessor<FilterSecurityInterceptor>() {
          @Override
          public <O extends FilterSecurityInterceptor> O postProcess(O object) {
            object.setSecurityMetadataSource(myFilterInvocationSecurityMetadataSource);
            object.setAccessDecisionManager(myAccessDecisionManager);
            return object;
          }
        })
        .anyRequest().authenticated()
//        .and().formLogin().defaultSuccessUrl("/bizUser/list").permitAll()
        .and()
        //添加token的filter
        .apply(new JwtLoginConfigurer<>()).tokenValidSuccessHandler(jwtRefreshSuccessHandler())
        .permissiveRequestUrls("/logout")
        .and().csrf().disable();
  }

  @Bean
  PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }

  private CorsConfigurationSource corsConfigurationSource() {
    UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
    CorsConfiguration corsConfiguration = new CorsConfiguration();
    //同源配置，*表示任何请求都视为同源，若需指定ip和端口可以改为如“localhost：8080”，多个以“，”分隔；
    corsConfiguration.addAllowedOrigin("*");
    //header，允许哪些header，本案中使用的是token，此处可将*替换为token；
    corsConfiguration.addAllowedHeader("*");
    //允许的请求方法，POST、GET等
    corsConfiguration.addAllowedMethod("*");
    //配置允许跨域访问的url
    source.registerCorsConfiguration("/**", corsConfiguration);
    return source;
  }

  @Bean
  protected JwtRefreshSuccessHandler jwtRefreshSuccessHandler() {
    return new JwtRefreshSuccessHandler(rsaKeyProperties, gson);
  }

  @Bean("jwtAuthenticationProvider")
  protected AuthenticationProvider jwtAuthenticationProvider() {
    return new JwtAuthenticationProvider(rsaKeyProperties, gson);
  }

}
