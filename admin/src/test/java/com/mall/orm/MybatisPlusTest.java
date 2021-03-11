package com.mall.orm;

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

import javax.annotation.Resource;
import java.util.List;

/**
 * MybatisPlus框架高级功能测试
 *
 * @author 李重辰
 * @date 2020/11/19 19:18
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@WebAppConfiguration
public class MybatisPlusTest {

  @Autowired
  private RoleService roleService;

  @Resource
  private MybatisPlusMapper mybatisPlusMapper;

  /**
   * 多租户
   */
  @Test
  @MyWithMockUser
  public void tenant() {
    List<Role> roleList = roleService.list();
    Assert.notEmpty(roleList, "无权限数据");
  }

  @Test
  @MyWithMockUser
  public void logicDelete() {
    Long id = 123413365652243104L;
    Role byId = roleService.getById(id);
    Assert.isInstanceOf(Role.class, byId, "角色不存在");
    boolean isUpdate = roleService.removeById(id);
    Assert.isTrue(isUpdate, "删除角色失败");
    Role role = mybatisPlusMapper.listDeletedRoleById(id);
    Assert.notNull(role, "逻辑删除失败，被物理删除了");
  }

  @Test
  @MyWithMockUser
  public void optimisticLock() {
    Role role = new Role();
    role.setId(775402379755073536L);
    role.setDescription("商家普通用户");
    role.setVersion(0);
    roleService.updateById(role);

    Role result = roleService.getById(775402379755073536L);
    Assert.isTrue(result.getVersion() == 1, "更新角色失败");
  }
}
