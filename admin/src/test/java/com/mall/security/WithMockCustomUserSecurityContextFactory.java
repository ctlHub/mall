package com.mall.security;

import com.mall.model.BizUser;
import com.mall.model.Role;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.test.context.support.WithSecurityContextFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * 解析{@link MyWithMockUser}注解,向SecurityContext中添加用户信息
 *
 * @author tanghao
 * @date 2020/11/18 13:43
 */
public class WithMockCustomUserSecurityContextFactory implements WithSecurityContextFactory<MyWithMockUser> {

  @Override
  public SecurityContext createSecurityContext(MyWithMockUser myWithMockUser) {
    SecurityContext context = SecurityContextHolder.createEmptyContext();

    BizUser principal = new BizUser();
    principal.setId(myWithMockUser.id());
    principal.setMerchantId(myWithMockUser.merchant());
    principal.setUsername(myWithMockUser.username());

    List<Role> roleList = new ArrayList<>();
    for (String role : myWithMockUser.role()) {
      Role bizRole = new Role();
      bizRole.setName(role);
      roleList.add(bizRole);
    }
    principal.setRoleList(roleList);
    Authentication auth = new UsernamePasswordAuthenticationToken(principal, "password", principal.getAuthorities());
    context.setAuthentication(auth);
    return context;
  }
}
