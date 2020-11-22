package com.mall.component;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import com.mall.common.model.UserDetail;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * 自定义自动填充控制器实现类
 *
 * @author tanghao
 * @date 2020/11/16 12:28
 */
@Component
public class MyMetaObjectHandler implements MetaObjectHandler {

  @Override
  public void insertFill(MetaObject metaObject) {
    this.strictInsertFill(metaObject, "createTime", LocalDateTime::now, LocalDateTime.class);
    Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    UserDetail user = (UserDetail) principal;
    this.strictInsertFill(metaObject, "createUserId", user::getId, Long.class);
  }

  @Override
  public void updateFill(MetaObject metaObject) {
    this.strictUpdateFill(metaObject, "updateTime", LocalDateTime::now, LocalDateTime.class);
    Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    UserDetail user = (UserDetail) principal;
    this.strictInsertFill(metaObject, "updateUserId", user::getId, Long.class);
  }
}
