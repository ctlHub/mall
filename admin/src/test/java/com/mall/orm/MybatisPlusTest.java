package com.mall.orm;

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
  private BizRoleService bizRoleService;

  @Resource
  private MybatisPlusMapper mybatisPlusMapper;

  /**
   * 多租户
   */
  @Test
  @MyWithMockUser
  public void tenant() {
    List<BizRole> bizRoleList = bizRoleService.list();
    Assert.notEmpty(bizRoleList, "无权限数据");
  }

  @Test
  @MyWithMockUser
  public void logicDelete() {
    Long id = 123413365652243104L;
    BizRole byId = bizRoleService.getById(id);
    Assert.isInstanceOf(BizRole.class, byId, "角色不存在");
    boolean isUpdate = bizRoleService.removeById(id);
    Assert.isTrue(isUpdate, "删除角色失败");
    BizRole bizRole = mybatisPlusMapper.listDeletedBizRoleById(id);
    Assert.notNull(bizRole, "逻辑删除失败，被物理删除了");
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
}
