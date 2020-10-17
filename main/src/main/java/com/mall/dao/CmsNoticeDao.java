package com.mall.dao;

import com.mall.mbg.model.CmsNotice;

import java.util.List;

/**
 * 公告管理自定义dao
 *
 * @author 李重辰
 * @date 2020/9/28 17:09
 */
public interface CmsNoticeDao {

    /**
     * 批量同步商品资料
     */
    int sync(List<CmsNotice> noticeList);

}
