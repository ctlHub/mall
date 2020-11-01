package com.mall.mbg;

import com.baomidou.mybatisplus.core.toolkit.ArrayUtils;
import com.baomidou.mybatisplus.generator.config.INameConvert;
import com.baomidou.mybatisplus.generator.config.po.TableField;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

/**
 * @author 李重辰
 * @date 2020/11/1 19:41
 */
public class MpNameConvert implements INameConvert {
  @Override
  public String entityNameConvert(TableInfo tableInfo) {
    String entityName = tableInfo.getName();
    int i = entityName.indexOf("_") + 1;
    return NamingStrategy.capitalFirst(processName(entityName.substring(i)));
  }

  @Override
  public String propertyNameConvert(TableField field) {
    return processName(field.getName());
  }

  private String processName(String name) {
    String propertyName;
    // 下划线转驼峰
    propertyName = NamingStrategy.underlineToCamel(name);
    return propertyName;
  }

}
