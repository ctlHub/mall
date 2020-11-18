package com.mall.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.mall.mapper.BizUserMapper;
import com.mall.model.BizRole;
import com.mall.model.BizUser;
import com.mall.service.BizRoleService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.util.Assert;

import java.util.List;

/**
 * @author tanghao
 * @date 2020/11/9 16:12
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@WebAppConfiguration
public class BizRoleServiceImplTest {

  private static final Long MERCHANT_ID = 1L;

  @Autowired
  private BizRoleService bizRoleService;

  @Autowired
  private BizUserMapper bizUserMapper;

  @Test
  public void list() {
    LambdaQueryWrapper<BizRole> lambdaQueryWrapper = new LambdaQueryWrapper<>();
    lambdaQueryWrapper.eq(BizRole::getMerchantId, MERCHANT_ID);
    List<BizRole> bizRoleList = bizRoleService.list(lambdaQueryWrapper);
    Assert.notEmpty(bizRoleList, "无权限数据");
  }

  @Test
  public void getOne() {
    BizRole bizRole = bizRoleService.getById(1);
    Assert.notNull(bizRole, "角色id不存在");
  }

  @Test
  public void create() {
    BizRole bizRole = new BizRole();
    bizRole.setName("ROLE_admin");
    bizRole.setNameZh("管理员");
    bizRole.setDescription("商家管理员");
    bizRole.setMerchantId(MERCHANT_ID);
    boolean isSave = bizRoleService.save(bizRole);
    Assert.isTrue(isSave, "添加角色失败");
  }

  @Test
  public void optimisticLock() {
    BizRole bizRole = new BizRole();
    bizRole.setId(1L);
    bizRole.setDescription("商家普通用户");
    bizRole.setVersion(0);
    bizRoleService.updateById(bizRole);

    BizRole result = bizRoleService.getById(1L);
    Assert.isTrue(result.getVersion() == 1, "更新角色失败");
  }

  @Test
  public void logicDelete() {
    boolean isUpdate = bizRoleService.removeById(1L);
    Assert.isTrue(isUpdate, "删除角色失败");
  }

  @Before
  public void setUser() {
    System.out.println("start~~~~~~~~~~");
    LambdaQueryWrapper<BizUser> lambdaQueryWrapper = Wrappers.lambdaQuery();
    lambdaQueryWrapper.eq(BizUser::getUsername, "tom");
    BizUser bizUser = bizUserMapper.selectOne(lambdaQueryWrapper);
    if (null == bizUser) {
      throw new UsernameNotFoundException("用户名不存在！");
    }
    bizUser.setRoleList(bizUserMapper.getRolesById(bizUser.getId()));

    Authentication auth =
        new UsernamePasswordAuthenticationToken(bizUser, bizUser.getPassword(), bizUser.getAuthorities());
    System.out.println("用户信息:" + auth);
    SecurityContext context = SecurityContextHolder.createEmptyContext();
    context.setAuthentication(auth);
  }

  /**
   * 多租户测试
   */
  @Test
  @WithMockUser(username = "tom", roles = {"ADMIN"})
  public void tenant() {
    List<BizRole> bizRoleList = bizRoleService.list();
    System.out.println(bizRoleList);
    Assert.notEmpty(bizRoleList, "无权限数据");
  }

}