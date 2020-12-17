package com.mall.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mall.mapper.AdminUserMapper;
import com.mall.model.AdminUser;
import com.mall.service.UserService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author ctlLab
 * @date 2020-11-07
 */
@Service
public class UserServiceImpl extends ServiceImpl<AdminUserMapper, AdminUser> implements UserService {

}
