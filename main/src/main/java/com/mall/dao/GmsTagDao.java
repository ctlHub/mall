package com.mall.dao;

import com.mall.entity.dto.GmsTagSearchParam;
import com.mall.mbg.model.GmsTag;

import java.util.List;

/**
 * 标签管理自定义Dao
 *
 * @author 李重辰
 * @date 2020/9/14 19:03
 */
public interface GmsTagDao {
    List<GmsTag> selectBySearchText(String corpNo, GmsTagSearchParam searchParam);
}
