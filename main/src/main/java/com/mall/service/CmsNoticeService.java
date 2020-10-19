package com.mall.service;

import com.mall.common.utils.ThreadLocalUtil;
import com.mall.dao.CmsNoticeDao;
import com.mall.mbg.mapper.CmsNoticeMapper;
import com.mall.mbg.model.CmsNotice;
import com.mall.mbg.model.CmsNoticeExample;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 公告管理Service
 *
 * @author 李重辰
 * @date 2020/9/28 17:05
 */
@Service
public class CmsNoticeService {

    @Resource
    CmsNoticeDao cmsNoticeDao;

    @Resource
    CmsNoticeMapper noticeMapper;

    /**
     * 将noticeList中的公告信息存入CmsNotice表，如果有则更新，没有则新增
     */
    public int sync(List<CmsNotice> noticeList) {
        return cmsNoticeDao.sync(noticeList);
    }

    public int delete(CmsNotice gmsNotice) {
        CmsNoticeExample noticeExample = new CmsNoticeExample();
        noticeExample.createCriteria().andMerchantIdEqualTo(ThreadLocalUtil.getMerchant()).andTitleEqualTo(gmsNotice.getTitle());
        return noticeMapper.deleteByExample(noticeExample);
    }

}
