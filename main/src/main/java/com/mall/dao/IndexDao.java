package com.mall.dao;

import com.mall.entity.dto.IndexBrandVO;
import com.mall.entity.dto.IndexClassVO;

import java.util.List;

/**
 * 首页查询自定义服务
 *
 * @author 李重辰
 * @date 2020/9/21 18:35
 */
public interface IndexDao {

  /**
   * 查询大类
   */
  List<IndexClassVO> listClass(String corpNo);

  /**
   * 根据大类查询子类
   */
  List<IndexClassVO> listSubClass(String corpNo, String className);

  List<IndexBrandVO> listBrand(String corpNo);
}
