package com.mall.security.service.impl;

import com.mall.common.model.JwtUserDetail;
import com.mall.security.mapper.UserDetailMapper;
import com.mall.security.service.JwtUserService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 从数据库中加载用户信息
 *
 * @author 李重辰
 * @date 2020/11/28 22:18
 */
@Service
public class JwtUserServiceImpl implements JwtUserService {

  @Resource
  private UserDetailMapper mapper;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    // TODO: 2020/11/29 18:03 将用户的角色信息或者权限信息在此时添加到JwtUserDetail对象l中
    JwtUserDetail user = mapper.getUserByAdminUser(username);
    if (null != user) {
      return user;
    }
    user = mapper.getUserByBizUser(username);
    if (null != user) {
      return user;
    }
    user = mapper.getUserByCustomer(username);
    return user;
  }

}
