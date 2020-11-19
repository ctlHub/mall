package com.mall.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.mall.model.BizUser;
import com.mall.security.MyWithMockUser;
import com.mall.service.BizUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.Assert;

/**
 * @author tanghao
 * @date 2020/11/9 16:55
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class BizUserServiceImplTest {

  @Autowired
  private BizUserService bizUserService;

  @Test
  @MyWithMockUser
  public void create() {
    BizUser bizUser = new BizUser();
    bizUser.setUsername("zhangsan");
    bizUser.setNickName("张三");
    String password = "123456";
    BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
    bizUser.setPassword(bCryptPasswordEncoder.encode(password));
    boolean isSave = bizUserService.save(bizUser);
    Assert.isTrue(isSave, "用户添加失败");
  }

  @Test
  public void selectOne() {
    LambdaQueryWrapper<BizUser> lambdaQueryWrapper = new LambdaQueryWrapper<>();
    lambdaQueryWrapper.eq(BizUser::getUsername, "tom");
    BizUser bizUser = bizUserService.getOne(lambdaQueryWrapper);
    Assert.notNull(bizUser, "用户名不存在");
  }

}