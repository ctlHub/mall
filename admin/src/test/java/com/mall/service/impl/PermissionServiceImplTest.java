package com.mall.service.impl;

import com.mall.model.Permission;
import com.mall.security.MyWithMockUser;
import com.mall.service.PermissionService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.Assert;

/**
 * @author tanghao
 * @date 2020/11/9 17:13
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class PermissionServiceImplTest {

  @Autowired
  private PermissionService bizPermissionService;

  @Test
  @MyWithMockUser
  public void create() {
    Permission bizPermission = new Permission();
    bizPermission.setName("权限管理1");
    bizPermission.setLevel("1");
    bizPermission.setUrl("/mall/business/permission");
    boolean isSave = bizPermissionService.save(bizPermission);
    Assert.isTrue(isSave, "权限保存失败");
  }

}