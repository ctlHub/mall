package com.mall.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.mall.common.utils.SnowflakeIdGenerator;
import com.mall.model.BizRole;
import com.mall.service.BizRoleService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.Assert;

import java.util.List;

/**
 * @author tanghao
 * @date 2020/11/9 16:12
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class BizRoleServiceImplTest {

  private static final Long MERCHANT_ID = 1L;

  @Autowired
  private BizRoleService bizRoleService;

  @Test
  public void list() {
    QueryWrapper<BizRole> queryWrapper = new QueryWrapper<>();
    queryWrapper.eq("merchant_id", MERCHANT_ID);
    List<BizRole> bizRoleList = bizRoleService.list(queryWrapper);
    Assert.notEmpty(bizRoleList, "无权限数据");
    bizRoleList.forEach(System.out::println);
  }

  @Test
  public void getOne() {
    BizRole bizRole = bizRoleService.getById(1);
    Assert.notNull(bizRole, "角色id不存在");
  }

  @Test
  public void create() {
    BizRole bizRole = new BizRole();
    bizRole.setId(SnowflakeIdGenerator.genLongId());
    bizRole.setName("ROLE_admin");
    bizRole.setNameZh("管理员");
    bizRole.setDescription("商家管理员");
    bizRole.setMerchantId(MERCHANT_ID);
    boolean isSave = bizRoleService.save(bizRole);
    Assert.isTrue(isSave, "添加角色失败");
  }

}