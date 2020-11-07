package com.mall.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mall.mapper.BizUserMapper;
import com.mall.model.BizUser;
import com.mall.service.BizUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
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
public class BizUserServiceImpl extends ServiceImpl<BizUserMapper, BizUser> implements BizUserService {

    @Autowired
    private BizUserMapper bizUserMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        QueryWrapper<BizUser> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username", username);
        BizUser bizUser = bizUserMapper.selectOne(queryWrapper);
        if (null == bizUser) {
            throw new UsernameNotFoundException("用户名不存在！");
        }
        bizUser.setRoleList(bizUserMapper.getRolesById(bizUser.getId()));
        return bizUser;
    }
}
