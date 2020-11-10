package com.mall.mapper;

import com.mall.model.BizPermission;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @author tanghao
 * @date 2020/11/10 10:05
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class BizPermissionMapperTest {

  private final static long BIZ_ID = 1L;

  private final BizPermissionMapper bizPermissionMapper;

  public BizPermissionMapperTest(BizPermissionMapper bizPermissionMapper) {
    this.bizPermissionMapper = bizPermissionMapper;
  }

  @Test
  public void test() {
    List<BizPermission> bizPermissionList = bizPermissionMapper.getPermissionsByMerchantId(BIZ_ID);
    bizPermissionList.forEach(System.out::println);
    Assert.assertNotEquals(0, bizPermissionList.size());
  }

}