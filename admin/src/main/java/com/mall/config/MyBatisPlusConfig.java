package com.mall.config;

import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.handler.TenantLineHandler;
import com.baomidou.mybatisplus.extension.plugins.inner.OptimisticLockerInnerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.TenantLineInnerInterceptor;
import com.mall.model.AdminUser;
import net.sf.jsqlparser.expression.Expression;
import net.sf.jsqlparser.expression.LongValue;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * MybatisPlus插件配置
 *
 * @author tanghao
 * @date 2020/11/14 9:39
 */
@Configuration
@EnableTransactionManagement
@MapperScan({"com.mall.mapper", "com.mall.orm"})
public class MyBatisPlusConfig {

  /**
   * 插件配置
   */
  @Bean
  public MybatisPlusInterceptor mybatisPlusInterceptor() {
    MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
    // 多租户
    TenantLineInnerInterceptor tenantLineInnerInterceptor = new TenantLineInnerInterceptor();
    tenantLineInnerInterceptor.setTenantLineHandler(new TenantLineHandler() {
      @Override
      public Expression getTenantId() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof AdminUser) {
          AdminUser bizUser = (AdminUser) principal;
          return new LongValue(bizUser.getMerchantId());
        }
        return null;
      }

      @Override
      public String getTenantIdColumn() {
        return "merchant_id";
      }

      @Override
      public boolean ignoreTable(String tableName) {
        return "u_biz_user".equals(tableName);
      }
    });
    interceptor.addInnerInterceptor(tenantLineInnerInterceptor);
    //乐观锁
    interceptor.addInnerInterceptor(new OptimisticLockerInnerInterceptor());
    return interceptor;
  }

///  sql性能规范配置，影响性能
//   开发测试时可以加上，约束sql查询规范，比如查询必须使用到索引，表连接规范等等
//  /**
//   * sql性能规范配置,只针对开发环境与测试环境
//   */
//  @Bean
//  public MybatisPlusInterceptor illegalSqlInnerInterceptor() {
//    MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
//    IllegalSQLInnerInterceptor illegalSqlInnerInterceptor = new IllegalSQLInnerInterceptor();
//    interceptor.addInnerInterceptor(illegalSqlInnerInterceptor);
//    return interceptor;
//  }

}
