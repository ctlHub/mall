package com.mall.component;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * @author tanghao
 * @date 2020/11/16 12:28
 */
@Component
public class MyMetaObjectHandler implements MetaObjectHandler {

  @Override
  public void insertFill(MetaObject metaObject) {
    this.strictInsertFill(metaObject, "createTime", LocalDateTime::now, LocalDateTime.class);
  }

  @Override
  public void updateFill(MetaObject metaObject) {
    this.strictUpdateFill(metaObject, "updateTime", LocalDateTime::now, LocalDateTime.class);
  }
}
