package com.mall.security;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.mall.model.BizPermission;
import com.mall.model.BizRole;
import com.mall.service.BizPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
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
    AntPathMatcher antPathMatcher = new AntPathMatcher();

    @Autowired
    private BizPermissionService bizPermissionService;

    @Override
    public Collection<ConfigAttribute> getAttributes(Object object) throws IllegalArgumentException {

        //获取当前用户请求得url
        FilterInvocation filterInvocation = (FilterInvocation) object;
        String reqMethod = filterInvocation.getHttpRequest().getMethod();
        String reqUrl = filterInvocation.getRequestUrl();
        System.out.println("请求连接:" + reqUrl + "--请求方法:" + reqMethod);
        //TODO bizId商家id传递方式 cookie？
        String bizId = filterInvocation.getHttpRequest().getParameter("bizId");
        QueryWrapper<BizPermission> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("biz_id", bizId);
        List<BizPermission> permissionList = bizPermissionService.list(queryWrapper);
        List<BizRole> roleList = new ArrayList<>();
        for (BizPermission permission : permissionList) {
            //路径匹配，请求方法匹配
            if (antPathMatcher.match(permission.getUrl(), reqUrl) &&
                    (reqMethod.equals(permission.getMethod()) || null == permission.getMethod())) {
                roleList.addAll(permission.getRoleList());
            }
        }
        if (CollectionUtils.isEmpty(roleList)) {
            return SecurityConfig.createList("ROLE_def");
        }
        //返回访问路径所需要的所有角色
        return SecurityConfig.createList(roleList.stream()
                .map(ele -> ele.getName())
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
