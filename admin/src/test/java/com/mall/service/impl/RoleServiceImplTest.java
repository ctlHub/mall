package com.mall.service.impl;

import com.mall.common.model.Role;
import com.mall.security.MyWithMockUser;
import com.mall.service.RoleService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
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
public class RoleServiceImplTest {

  @Autowired
  private RoleService roleService;

  @Test
  @MyWithMockUser
  public void list() {
    List<Role> bizRoleList = roleService.list();
    Assert.notEmpty(bizRoleList, "无权限数据");
  }

  @Test
  @MyWithMockUser
  public void getOne() {
    Role role = roleService.getById(775402379755073536L);
    Assert.notNull(role, "角色id不存在");
  }

  @Test
  @MyWithMockUser
  public void create() {
    Role bizRole = new Role();
    bizRole.setName("ROLE_CUSTOMER");
    bizRole.setNameZh("客户");
    bizRole.setDescription("客户");
    boolean isSave = roleService.save(bizRole);
    Assert.isTrue(isSave, "添加角色失败");
  }

}