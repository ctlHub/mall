package com.mall.service;

import com.mall.common.api.CommonResult;
import com.mall.common.utils.ModelUtils;
import com.mall.common.utils.SnowflakeIdGenerator;
import com.mall.common.utils.ThreadLocalUtil;
import com.mall.dao.GmsTagDao;
import com.mall.entity.dto.GmsTagParam;
import com.mall.entity.dto.GmsTagSearchParam;
import com.mall.mbg.mapper.GmsGoodsAndTagMapper;
import com.mall.mbg.mapper.GmsTagMapper;
import com.mall.mbg.model.GmsGoodsAndTagExample;
import com.mall.mbg.model.GmsTag;
import com.mall.mbg.model.GmsTagExample;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author 李重辰
 * @date 2020/9/14 11:36
 */
@Service
public class GmsTagService {

    @Resource
    GmsTagMapper gmsTagMapper;
    @Resource
    GmsGoodsAndTagMapper gmsGoodsAndTagMapper;
    @Resource
    GmsTagDao gmsTagDao;

    public int update(GmsTagParam gmsTagParam) {
        GmsTag gmsTag = new GmsTag();
        BeanUtils.copyProperties(gmsTagParam, gmsTag);
        tagExistValidate(gmsTag);
        GmsTagExample example = new GmsTagExample();
        GmsTagExample.Criteria criteria = example.createCriteria();
        criteria.andMerchantIdEqualTo(gmsTag.getMerchantId());
        criteria.andIdEqualTo(gmsTag.getId());
        ModelUtils.setUpdateInfo(gmsTag);
        return gmsTagMapper.updateByExampleSelective(gmsTag, example);
    }

    public List<GmsTag> listTag(GmsTagSearchParam gmsTagSearchParam) {
        return gmsTagDao.selectBySearchText(ThreadLocalUtil.getMerchant(), gmsTagSearchParam);
    }

    public List<GmsTag> listTagByType(GmsTag gmsTag) {
        GmsTagExample tagExample = new GmsTagExample();
        tagExample.createCriteria()
                .andMerchantIdEqualTo(ThreadLocalUtil.getMerchant())
                .andTypeEqualTo(gmsTag.getType());
        if (!StringUtils.isEmpty(gmsTag.getType())) {
            GmsTagExample.Criteria criteria2 = tagExample.createCriteria();
            criteria2.andMerchantIdEqualTo(ThreadLocalUtil.getMerchant());
            criteria2.andTypeEqualTo("");
            tagExample.or(criteria2);
        }
        tagExample.setOrderByClause("type desc");
        return gmsTagMapper.selectByExample(tagExample);
    }

    @Transactional(rollbackFor = RuntimeException.class)
    public int delete(String tagCode) {
        GmsTagExample tagExample = new GmsTagExample();
        GmsTagExample.Criteria tagCriteria = tagExample.createCriteria();
        tagCriteria.andMerchantIdEqualTo(ThreadLocalUtil.getMerchant());
        tagCriteria.andIdEqualTo(tagCode);
        gmsTagMapper.deleteByExample(tagExample);

        GmsGoodsAndTagExample goodsAndTagExample = new GmsGoodsAndTagExample();
        GmsGoodsAndTagExample.Criteria tagExampleCriteria = goodsAndTagExample.createCriteria();
        tagExampleCriteria.andMerchantIdEqualTo(ThreadLocalUtil.getMerchant());
        tagExampleCriteria.andTagIdEqualTo(tagCode);
        return gmsGoodsAndTagMapper.deleteByExample(goodsAndTagExample);
    }

    public CommonResult<String> create(GmsTagParam gmsTagParam) {
        GmsTag tag = new GmsTag();
        BeanUtils.copyProperties(gmsTagParam, tag);
        tag.setId(SnowflakeIdGenerator.genId());
        tagExistValidate(tag);
        ModelUtils.setCreateAndUpdateInfo(tag);
        int insert = gmsTagMapper.insert(tag);
        if (insert == 1) {
            return CommonResult.success(tag.getId());
        }
        return CommonResult.failed();
    }

    private void tagExistValidate(GmsTag gmsTag) {
        GmsTagExample tagExample = new GmsTagExample();
        tagExample.createCriteria().andMerchantIdEqualTo(gmsTag.getMerchantId()).andNameEqualTo(gmsTag.getName());
        List<GmsTag> gmsTagList = gmsTagMapper.selectByExample(tagExample);
        if (!gmsTagList.isEmpty() & !gmsTagList.get(0).getId().equals(gmsTag.getId())) {
            throw new RuntimeException("Tag " + gmsTag.getName() + " already exist.");
        }
    }

}
