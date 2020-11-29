package com.mall.security.config;

import com.google.gson.Gson;
import com.mall.common.model.RsaKeyProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * 配置Security认证方式，使用JWT
 *
 * @author 李重辰
 * @date 2020/11/28 22:01
 */
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

  private final RsaKeyProperties rsaKeyProperties;
  private final Gson gson;
  private final UserDetailsService jwtUserService;

  public WebSecurityConfig(RsaKeyProperties rsaKeyProperties, Gson gson, UserDetailsService jwtUserService) {
    this.rsaKeyProperties = rsaKeyProperties;
    this.gson = gson;
    this.jwtUserService = jwtUserService;
  }

  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }

  @Override
  protected void configure(AuthenticationManagerBuilder auth) {
    auth.authenticationProvider(daoAuthenticationProvider()).authenticationProvider(jwtAuthenticationProvider());
  }

  @Bean("daoAuthenticationProvider")
  protected AuthenticationProvider daoAuthenticationProvider() {
    //这里会默认使用BCryptPasswordEncoder比对加密后的密码，注意要跟createUser时保持一致
    DaoAuthenticationProvider daoProvider = new DaoAuthenticationProvider();
    daoProvider.setUserDetailsService(userDetailsService());
    return daoProvider;
  }

  @Bean("jwtAuthenticationProvider")
  protected AuthenticationProvider jwtAuthenticationProvider() {
    return new JwtAuthenticationProvider(rsaKeyProperties, gson);
  }

  @Override
  protected UserDetailsService userDetailsService() {
    return jwtUserService;
  }

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http.csrf().disable()
        .formLogin().disable()
        .sessionManagement().disable()
//        .cors()
//        .and()
        // 配置Json登录认证处理器，并指定成功后的处理器
        .apply(new JsonLoginConfigurer<>(gson))
        .loginSuccessHandler(new JwtLoginSuccessHandle(rsaKeyProperties, gson))
        .and()
        //添加token的filter
        .apply(new JwtLoginConfigurer<>()).tokenValidSuccessHandler(jwtRefreshSuccessHandler()).permissiveRequestUrls("/logout")
        .and()
//        .apply(new JwtLoginConfigurer<>()).tokenValidSuccessHandler(jwtRefreshSuccessHandler()).permissiveRequestUrls("/logout")
//        .and()
//        .logout()
////		        .logoutUrl("/logout")   //默认就是"/logout"
//        .addLogoutHandler(tokenClearLogoutHandler())
//        .logoutSuccessHandler(new HttpStatusReturningLogoutSuccessHandler())
        .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
  }

  @Bean
  protected JwtRefreshSuccessHandler jwtRefreshSuccessHandler() {
    return new JwtRefreshSuccessHandler(rsaKeyProperties, gson);
  }

}
