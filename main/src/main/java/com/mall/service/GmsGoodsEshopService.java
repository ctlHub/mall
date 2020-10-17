package com.mall.service;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import com.mall.common.utils.ModelUtils;
import com.mall.common.utils.ThreadLocalUtil;
import com.mall.entity.dto.GmsGoodsEshopParam;
import com.mall.entity.model.UsedEnum;
import com.mall.mbg.mapper.GmsGoodsAndEshopMapper;
import com.mall.mbg.model.GmsGoodsAndEshop;
import com.mall.mbg.model.GmsGoodsAndEshopExample;

import javax.annotation.Resource;
import java.util.List;

/**
 * 商品与电商平台链接绑定Service
 *
 * @author 李重辰
 * @date 2020/9/25 17:22
 */
@Service
public class GmsGoodsEshopService {

    @Resource
    GmsGoodsAndEshopMapper mapper;

    public List<GmsGoodsAndEshop> listByGoodsCode(GmsGoodsAndEshop goodsEshop) {
        GmsGoodsAndEshopExample example = new GmsGoodsAndEshopExample();
        GmsGoodsAndEshopExample.Criteria criteria = example.createCriteria()
                .andCorpNoEqualTo(ThreadLocalUtil.getCorpNo())
                .andGoodsCodeEqualTo(goodsEshop.getGoodsCode());
        Integer eshopType = goodsEshop.getEshopType();
        if (null != eshopType) {
            criteria.andEshopTypeEqualTo(eshopType);
        }
        return mapper.selectByExample(example);
    }

    public Integer insert(GmsGoodsEshopParam goodsEshopParam) {
        GmsGoodsAndEshop goodsAndEshop = new GmsGoodsAndEshop();
        BeanUtils.copyProperties(goodsEshopParam, goodsAndEshop);
        GmsGoodsAndEshopExample eshopExample = getGmsGoodsAndEshopExample(goodsAndEshop);
        List<GmsGoodsAndEshop> gmsGoodsAndEshop = mapper.selectByExample(eshopExample);
        if (!CollectionUtils.isEmpty(gmsGoodsAndEshop)) {
            return 0;
        }
        ModelUtils.setCreateAndUpdateInfo(goodsAndEshop);
        goodsAndEshop.setStatus(UsedEnum.ENABLE.getCode());
        return mapper.insert(goodsAndEshop);
    }

    public Integer update(GmsGoodsEshopParam goodsEshopParam) {
        GmsGoodsAndEshop goodsAndEshop = new GmsGoodsAndEshop();
        BeanUtils.copyProperties(goodsEshopParam, goodsAndEshop);
        ModelUtils.setUpdateInfo(goodsAndEshop);
        GmsGoodsAndEshopExample eshopExample = getGmsGoodsAndEshopExample(goodsAndEshop);
        return mapper.updateByExampleSelective(goodsAndEshop, eshopExample);
    }

    /**
     * 通用查询条件
     */
    private GmsGoodsAndEshopExample getGmsGoodsAndEshopExample(GmsGoodsAndEshop goodsAndEshop) {
        GmsGoodsAndEshopExample eshopExample = new GmsGoodsAndEshopExample();
        eshopExample.createCriteria().
                andCorpNoEqualTo(goodsAndEshop.getCorpNo()).
                andGoodsCodeEqualTo(goodsAndEshop.getGoodsCode()).
                andEshopTypeEqualTo(goodsAndEshop.getEshopType());
        return eshopExample;
    }
}
