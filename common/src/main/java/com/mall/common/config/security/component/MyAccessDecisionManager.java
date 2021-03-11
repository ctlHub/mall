package com.mall.common.config.security.component;

import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.Collection;

/**
 * 自定义访问决策管理器
 *
 * @author tanghao
 * @date 2020/11/7 16:48
 */
@Component
public class MyAccessDecisionManager implements AccessDecisionManager {
  @Override
  public void decide(Authentication authentication, Object object, Collection<ConfigAttribute> configAttributes) throws AccessDeniedException, InsufficientAuthenticationException {
    // configAttributes里存放着MyFilterInvocationSecurityMetadataSource过滤出来的角色
    for (ConfigAttribute configAttribute : configAttributes) {
      // 请求的url在数据库中没有对应的角色
      if ("ROLE_def".equals(configAttribute.getAttribute())) {
        // 判断是否登录，判断是否是匿名用户
        if (authentication instanceof AnonymousAuthenticationToken) {
          throw new AccessDeniedException("未登录，不可访问！");
        } else {
          return;
        }
      }

      // 请求url有对应的角色
      // authentication中存放了登录用户的所有信息
      Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
      for (GrantedAuthority grantedAuthority : authorities) {
        // grantedAuthority.getAuthority() 账户拥有的权限
        // configAttribute.getAttribute() 路径需要的角色
        if (grantedAuthority.getAuthority().equals(configAttribute.getAttribute())) {
          return;
        }
      }
    }
    throw new AccessDeniedException("无权访问！");
  }

  @Override
  public boolean supports(ConfigAttribute configAttribute) {
    return true;
  }

  @Override
  public boolean supports(Class<?> aClass) {
    return true;
  }
}
