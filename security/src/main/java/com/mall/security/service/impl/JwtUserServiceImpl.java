package com.mall.security.service.impl;

import com.mall.common.model.JwtUserDetail;
import com.mall.common.model.Permission;
import com.mall.security.mapper.SecurityMapper;
import com.mall.security.service.JwtUserService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 从数据库中加载用户信息
 *
 * @author 李重辰
 * @date 2020/11/28 22:18
 */
@Service
public class JwtUserServiceImpl implements JwtUserService {

  @Resource
  private SecurityMapper securityMapper;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    JwtUserDetail user = securityMapper.getUserByAdminUser(username);
    if (null != user) {
      return user;
    }
    user = securityMapper.getUserByBizUser(username);
    if (null != user) {
      return user;
    }
    user = securityMapper.getUserByCustomer(username);
    if (null != user) {
      //1.roleIdList:用户所有角色ID集合
      List<Long> roleIdList = securityMapper.getRolesByUserId(user.getId());
      if (!CollectionUtils.isEmpty(roleIdList)) {
        //2.permissionIdList:用户所有权限ID集合
        List<Long> permissionIdList = securityMapper.getPermissionsByRoles(roleIdList);
        if (!CollectionUtils.isEmpty(permissionIdList)) {
          //3.permissionList:用户所有权限集合
          List<Permission> permissionList = securityMapper.getPermissionsByIds(permissionIdList);
          //4.将权限对象中的url和method放入JwtUserDetail对象中的权限中
          user.setResourceList(permissionList.stream()
              .map(ele -> ele.getUrl() + ":" + ele.getMethod())
              .collect(Collectors.toList()));
        }
      }
    }
    return user;
  }

}
