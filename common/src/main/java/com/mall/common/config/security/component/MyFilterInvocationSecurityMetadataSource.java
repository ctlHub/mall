package com.mall.common.config.security.component;

import com.mall.common.model.JwtUserDetail;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * 自定义过滤的安全源数据，从mysql数据获取数据匹配
 *
 * @author tanghao
 * @date 2020/11/7 16:28
 */
@Component
public class MyFilterInvocationSecurityMetadataSource implements FilterInvocationSecurityMetadataSource {

  /**
   * ant风格路径匹配器
   */
  private final AntPathMatcher antPathMatcher = new AntPathMatcher();

  @Override
  public Collection<ConfigAttribute> getAttributes(Object object) throws IllegalArgumentException {

    // 获取当前用户请求得url
    FilterInvocation filterInvocation = (FilterInvocation) object;
    String reqMethod = filterInvocation.getHttpRequest().getMethod();
    String reqUrl = filterInvocation.getRequestUrl();

    List<String> permissionList = new ArrayList<>();
    Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    if (principal instanceof JwtUserDetail) {
      JwtUserDetail userDetail = (JwtUserDetail) principal;
      List<String> resourceList = userDetail.getResourceList();
      for (String resource : resourceList) {
        if (antPathMatcher.match(reqUrl + ":" + reqMethod, resource)) {
          permissionList.add(resource);
        }
      }
    }
    if (CollectionUtils.isEmpty(permissionList)) {
      return SecurityConfig.createList("ROLE_def");
    }
    //返回访问路径所需要的所有角色
    return SecurityConfig.createList(permissionList.toArray(new String[0]));
  }

  @Override
  public Collection<ConfigAttribute> getAllConfigAttributes() {
    return null;
  }

  @Override
  public boolean supports(Class<?> aClass) {
    return true;
  }
}
