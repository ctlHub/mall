package com.mall.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.mall.common.utils.SnowflakeIdGenerator;
import com.mall.model.BizUser;
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

    private static final Long BIZID = 1L;

    @Autowired
    private BizUserService bizUserService;

    @Test
    public void create() {
        BizUser bizUser = new BizUser();
        bizUser.setId(SnowflakeIdGenerator.genLongId());
        bizUser.setUsername("zhagnsan");
        bizUser.setNickName("张三");
        String password = "123456";
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        bizUser.setPassword(bCryptPasswordEncoder.encode(password));
        bizUser.setBizId(BIZID);
        Boolean isSave = bizUserService.save(bizUser);
        Assert.isTrue(isSave, "用户添加失败");
    }

    @Test
    public void selectOne() {
        QueryWrapper<BizUser> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username", "zhangsan");
        BizUser bizUser = bizUserService.getOne(queryWrapper);
        System.out.println(bizUser);
    }

}