package com.mall.service;

import com.mall.common.exception.NotExistException;
import com.mall.common.utils.ThreadLocalUtil;
import com.mall.mbg.mapper.CmsNoticeMapper;
import com.mall.mbg.model.CmsNotice;
import com.mall.mbg.model.CmsNoticeExample;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.List;

/**
 * 新闻公告页面Service
 *
 * @author 李重辰
 * @date 2020/10/12 11:16
 */
@Service
public class NoticeDetailService {

    @Resource
    CmsNoticeMapper cmsNoticeMapper;

    public CmsNotice get(String id) {
        CmsNoticeExample example = new CmsNoticeExample();
        example.createCriteria().andMerchantIdEqualTo(ThreadLocalUtil.getMerchant()).andIdEqualTo(id);
        List<CmsNotice> cmsNotices = cmsNoticeMapper.selectByExampleWithBLOBs(example);
        if (CollectionUtils.isEmpty(cmsNotices)) {
            throw new NotExistException(id) {
                @Override
                protected String getType() {
                    return "新闻公告";
                }
            };
        }
        return cmsNotices.get(0);
    }
}
