package com.mall.security;

import com.mall.model.BizRole;
import com.mall.model.BizUser;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.test.context.support.WithSecurityContextFactory;

import java.util.ArrayList;
import java.util.List;

/**
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

    List<BizRole> roleList = new ArrayList<>();
    for (String role : myWithMockUser.role()) {
      BizRole bizRole = new BizRole();
      bizRole.setName(role);
      roleList.add(bizRole);
    }
    principal.setRoleList(roleList);
    Authentication auth =
        new UsernamePasswordAuthenticationToken(principal, "password", principal.getAuthorities());
    context.setAuthentication(auth);
    return context;
  }
}
