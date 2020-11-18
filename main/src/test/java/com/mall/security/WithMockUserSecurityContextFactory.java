package com.mall.security;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.mall.mapper.BizUserMapper;
import com.mall.model.BizUser;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.security.test.context.support.WithSecurityContextFactory;
import org.springframework.stereotype.Component;

/**
 * @author tanghao
 * @date 2020/11/16 18:04
 */
@Component
public class WithMockUserSecurityContextFactory implements WithSecurityContextFactory<WithMockUser> {

  private final BizUserMapper bizUserMapper;

  public WithMockUserSecurityContextFactory(BizUserMapper bizUserMapper) {
    this.bizUserMapper = bizUserMapper;
  }

  @Override
  public SecurityContext createSecurityContext(WithMockUser withUser) {
    String username = withUser.username();

    QueryWrapper<BizUser> queryWrapper = new QueryWrapper<>();
    queryWrapper.eq("username", username);
    BizUser bizUser = bizUserMapper.selectOne(queryWrapper);
    if (null == bizUser) {
      throw new UsernameNotFoundException("用户名不存在！");
    }
    bizUser.setRoleList(bizUserMapper.getRolesById(bizUser.getId()));

    Authentication auth =
        new UsernamePasswordAuthenticationToken(bizUser, bizUser.getPassword(), bizUser.getAuthorities());
    System.out.println("用户信息:" + auth);
    SecurityContext context = SecurityContextHolder.createEmptyContext();
    context.setAuthentication(auth);
    return context;
  }
}
