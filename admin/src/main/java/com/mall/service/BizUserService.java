package com.mall.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.mall.model.BizUser;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @author ctlLab
 * @date 2020-11-07
 */
public interface BizUserService extends IService<BizUser>, UserDetailsService {

}
