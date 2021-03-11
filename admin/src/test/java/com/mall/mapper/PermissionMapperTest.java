package com.mall.mapper;

import com.mall.common.model.Permission;
import com.mall.security.MyWithMockUser;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author tanghao
 * @date 2020/11/10 10:05
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class PermissionMapperTest {

  private final static long MERCHANT_ID = 1L;

  @Resource
  private PermissionMapper permissionMapper;

  @Test
  @MyWithMockUser
  public void test() {
    List<Permission> bizPermissionList = permissionMapper.getPermissionsByMerchantId(MERCHANT_ID);
    Assert.assertNotEquals(0, bizPermissionList.size());
  }

}