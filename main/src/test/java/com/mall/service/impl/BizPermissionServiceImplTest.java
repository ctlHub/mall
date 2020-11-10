package com.mall.service.impl;

import com.mall.common.utils.SnowflakeIdGenerator;
import com.mall.model.BizPermission;
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

  private static final Long MERCHANT_ID = 1L;

    @Autowired
    private BizPermissionService bizPermissionService;

  @Test
  public void create() {
    BizPermission bizPermission = new BizPermission();
    bizPermission.setId(SnowflakeIdGenerator.genLongId());
    bizPermission.setName("权限管理");
    bizPermission.setLevel("1");
    bizPermission.setMerchantId(MERCHANT_ID);
    bizPermission.setUrl("/mall/business/permission");
    boolean isSave = bizPermissionService.save(bizPermission);
    Assert.isTrue(isSave, "权限保存失败");
  }

}