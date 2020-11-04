package com.mall.mbg;

import com.baomidou.mybatisplus.generator.config.INameConvert;
import com.baomidou.mybatisplus.generator.config.po.TableField;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

/**
 * 表名和字段名转化，在生成model前将表名前的模块前缀去除
 * 例如：u_biz_user ---> biz_user
 *
 * @author 李重辰
 * @date 2020/11/1 19:41
 */
public class MpNameConvert implements INameConvert {
  @Override
  public String entityNameConvert(TableInfo tableInfo) {
    String entityName = tableInfo.getName();
    tableInfo.setConvert(true);
    int i = entityName.indexOf("_") + 1;
    return NamingStrategy.capitalFirst(processName(entityName.substring(i)));
  }

  @Override
  public String propertyNameConvert(TableField field) {
    return processName(field.getName());
  }

  /**
   * 下划线转驼峰
   */
  private String processName(String name) {
    return NamingStrategy.underlineToCamel(name);
  }

}
