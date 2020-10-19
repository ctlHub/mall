package com.mall.common.utils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Date;

/**
 * 实体类工具类
 *
 * @author 李重辰
 * @date 2020/10/14 16:09
 */
public class ModelUtils {

  /**
   * 设置实体类的appUser，appDate，updateUser，updateDate
   *
   * @param modelObject 实体类对象
   */
  public static void setCreateAndUpdateInfo(Object modelObject) {
    setCreateInfo(modelObject);
    setUpdateInfo(modelObject);
  }

  /**
   * 设置实体类的appUser，appDate
   *
   * @param modelObject 实体类对象
   */
  public static void setCreateInfo(Object modelObject) {
    Method setAppUser;
    Method setAppDate;
    try {
      setAppUser = modelObject.getClass().getMethod("setAppUser", String.class);
      setAppUser.invoke(modelObject, ThreadLocalUtil.getUserCode());
      setAppDate = modelObject.getClass().getMethod("setAppDate", Date.class);
      setAppDate.invoke(modelObject, new Date());
    } catch (NoSuchMethodException | IllegalAccessException e) {
      e.printStackTrace();
    } catch (InvocationTargetException e) {
      if (e.getTargetException() instanceof RuntimeException) {
        throw (RuntimeException) e.getTargetException();
      }
    }
  }

  /**
   * 设置实体类的updateUser，updateDate
   *
   * @param modelObject 实体类对象
   */
  public static void setUpdateInfo(Object modelObject) {
    Method setUpdateUser;
    Method setUpdateDate;
    try {
      setUpdateUser = modelObject.getClass().getMethod("setUpdateUser", String.class);
      setUpdateUser.invoke(modelObject, ThreadLocalUtil.getUserCode());
      setUpdateDate = modelObject.getClass().getMethod("setUpdateDate", Date.class);
      setUpdateDate.invoke(modelObject, new Date());
    } catch (NoSuchMethodException | IllegalAccessException e) {
      e.printStackTrace();
    } catch (InvocationTargetException e) {
      if (e.getTargetException() instanceof RuntimeException) {
        throw (RuntimeException) e.getTargetException();
      }
    }
  }
}
