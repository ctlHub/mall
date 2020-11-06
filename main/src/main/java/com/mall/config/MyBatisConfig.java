package com.mall.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * MyBatis配置类
 *
 * @author 李重辰
 * @date 2020/4/12 11:03
 */
@Configuration
@EnableTransactionManagement
@MapperScan({"com.mall.mbg.mapper", "com.mall.dao", "com.mall.mapper"})
public class MyBatisConfig {
}
