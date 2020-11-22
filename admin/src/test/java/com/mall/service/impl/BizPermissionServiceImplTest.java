package com.mall.service.impl;

import com.mall.model.BizPermission;
import com.mall.security.MyWithMockUser;
import com.mall.service.BizPermissionService;
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
public class BizPermissionServiceImplTest {

  @Autowired
  private BizPermissionService bizPermissionService;

  @Test
  @MyWithMockUser
  public void create() {
    BizPermission bizPermission = new BizPermission();
    bizPermission.setName("权限管理1");
    bizPermission.setLevel("1");
    bizPermission.setUrl("/mall/business/permission");
    boolean isSave = bizPermissionService.save(bizPermission);
    Assert.isTrue(isSave, "权限保存失败");
  }

}