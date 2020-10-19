package com.mall.service;

import com.mall.common.utils.ModelUtils;
import com.mall.common.utils.ThreadLocalUtil;
import com.mall.mbg.mapper.CmsIndexSalesAdMapper;
import com.mall.mbg.model.CmsIndexSalesAd;
import com.mall.mbg.model.CmsIndexSalesAdExample;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.List;

/**
 * 首页促销图维护Servic
 *
 * @author 李重辰
 * @date 2020/9/28 10:34
 */
@Service
public class CmsIndexSalesAdService {

    @Resource
    CmsIndexSalesAdMapper indexSalesAdMapper;

    public List<CmsIndexSalesAd> list(Integer salesStatus) {
        CmsIndexSalesAdExample indexSalesAdExample = new CmsIndexSalesAdExample();
        CmsIndexSalesAdExample.Criteria criteria = indexSalesAdExample.createCriteria()
                .andMerchantIdEqualTo(ThreadLocalUtil.getMerchant());
        if (salesStatus != null) {
            criteria.andSalesStatusEqualTo(salesStatus);
        }
        return indexSalesAdMapper.selectByExample(indexSalesAdExample);
    }

    /**
     * 已经存在就update 否则 save
     */
    public Integer save(CmsIndexSalesAd indexSalesAd) {
        int count;
        CmsIndexSalesAdExample indexSalesAdExample = new CmsIndexSalesAdExample();
        indexSalesAdExample.createCriteria()
                .andMerchantIdEqualTo(indexSalesAd.getMerchantId())
                .andSalesStatusEqualTo(indexSalesAd.getSalesStatus());
        List<CmsIndexSalesAd> cmsIndexSalesAds = indexSalesAdMapper.selectByExample(indexSalesAdExample);
        ModelUtils.setUpdateInfo(indexSalesAd);
        if (CollectionUtils.isEmpty(cmsIndexSalesAds)) {
            ModelUtils.setCreateInfo(indexSalesAd);
            count = indexSalesAdMapper.insert(indexSalesAd);
        } else {
            count = indexSalesAdMapper.updateByExampleSelective(indexSalesAd, indexSalesAdExample);
        }
        return count;
    }

    public Integer delete(Integer salesStatus) {
        CmsIndexSalesAdExample indexSalesAdExample = new CmsIndexSalesAdExample();
        indexSalesAdExample.createCriteria()
                .andMerchantIdEqualTo(ThreadLocalUtil.getMerchant())
                .andSalesStatusEqualTo(salesStatus);
        return indexSalesAdMapper.deleteByExample(indexSalesAdExample);
    }
}
