package com.mall.security;

import com.mall.mapper.BizPermissionMapper;
import com.mall.model.BizPermission;
import com.mall.model.BizRole;
import com.mall.model.BizUser;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
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

  @Resource
  private BizPermissionMapper bizPermissionMapper;

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

    List<BizPermission> permissionList = new ArrayList<>();
    Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    if (principal instanceof BizUser) {
      BizUser bizUser = (BizUser) principal;
      permissionList = bizPermissionMapper.getPermissionsByMerchantId(bizUser.getMerchantId());
    }
    List<BizRole> roleList = new ArrayList<>();
    for (BizPermission permission : permissionList) {
      // 路径匹配，请求方法匹配
      boolean pass = antPathMatcher.match(permission.getUrl(), reqUrl) && (reqMethod.equals(permission.getMethod()) || null == permission.getMethod());
      if (pass) {
        roleList.addAll(permission.getRoleList());
      }
    }
    if (CollectionUtils.isEmpty(roleList)) {
      return SecurityConfig.createList("ROLE_def");
    }
    //返回访问路径所需要的所有角色
    return SecurityConfig.createList(roleList.stream()
        .map(BizRole::getName)
        .toArray(String[]::new));
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
