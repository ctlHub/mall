package com.mall.service.impl;

import com.mall.model.BizRole;
import com.mall.security.MyWithMockUser;
import com.mall.service.BizRoleService;
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
public class BizRoleServiceImplTest {

  @Autowired
  private BizRoleService bizRoleService;

  @Test
  @MyWithMockUser
  public void list() {
    List<BizRole> bizRoleList = bizRoleService.list();
    Assert.notEmpty(bizRoleList, "无权限数据");
  }

  @Test
  @MyWithMockUser
  public void getOne() {
    BizRole bizRole = bizRoleService.getById(775402379755073536L);
    Assert.notNull(bizRole, "角色id不存在");
  }

  @Test
  @MyWithMockUser
  public void create() {
    BizRole bizRole = new BizRole();
    bizRole.setName("ROLE_CUSTOMER");
    bizRole.setNameZh("客户");
    bizRole.setDescription("客户");
    boolean isSave = bizRoleService.save(bizRole);
    Assert.isTrue(isSave, "添加角色失败");
  }

  @Test
  @MyWithMockUser
  public void optimisticLock() {
    BizRole bizRole = new BizRole();
    bizRole.setId(775402379755073536L);
    bizRole.setDescription("商家普通用户");
    bizRole.setVersion(0);
    bizRoleService.updateById(bizRole);

    BizRole result = bizRoleService.getById(775402379755073536L);
    Assert.isTrue(result.getVersion() == 1, "更新角色失败");
  }

  @Test
  @MyWithMockUser
  public void logicDelete() {
    boolean isUpdate = bizRoleService.removeById(778640886187372544L);
    Assert.isTrue(isUpdate, "删除角色失败");
  }

  /**
   * 多租户测试
   */
  @Test
  @MyWithMockUser
  public void tenant() {
    List<BizRole> bizRoleList = bizRoleService.list();
    System.out.println(bizRoleList);
    Assert.notEmpty(bizRoleList, "无权限数据");
  }

}