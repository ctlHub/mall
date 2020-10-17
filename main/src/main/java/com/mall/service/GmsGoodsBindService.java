package com.mall.service;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.mall.common.utils.ModelUtils;
import com.mall.common.utils.ThreadLocalUtil;
import com.mall.dao.GmsGoodsBindDao;
import com.mall.dao.GmsGoodsDao;
import com.mall.entity.dto.GmsGoodsSearchParam;
import com.mall.entity.dto.GmsGoodsSearchResult;
import com.mall.mbg.mapper.GmsGoodsBindMapper;
import com.mall.mbg.model.GmsGoods;
import com.mall.mbg.model.GmsGoodsBind;
import com.mall.mbg.model.GmsGoodsBindExample;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 商品绑定Service
 *
 * @author 李重辰
 * @date 2020/10/9 10:45
 */
@Service
public class GmsGoodsBindService {

    @Resource
    private GmsGoodsBindDao gmsGoodsBindDao;

    @Resource
    private GmsGoodsBindMapper gmsGoodsBindMapper;

    @Resource
    private GmsGoodsDao gmsGoodsDao;

    public List<GmsGoods> get(String primaryGoodsCode) {
        return gmsGoodsBindDao.get(ThreadLocalUtil.getCorpNo(), primaryGoodsCode);
    }

    public List<GmsGoodsSearchResult> getForApp(String primaryGoodsCode) {
        List<GmsGoods> goodsList = gmsGoodsBindDao.get(ThreadLocalUtil.getCorpNo(), primaryGoodsCode);
        List<GmsGoodsSearchResult> goodsResultList = new ArrayList<>(goodsList.size());
        goodsList.forEach(gmsGoods -> {
            GmsGoodsSearchResult goodsResult = new GmsGoodsSearchResult();
            BeanUtils.copyProperties(gmsGoods, goodsResult);
            goodsResultList.add(goodsResult);
        });
        GoodsUtil.appendImgFromMongoDb(ThreadLocalUtil.getCorpNo(), goodsResultList);
        return goodsResultList;
    }

    public List<GmsGoods> listBindableGoods(GmsGoodsSearchParam searchParam) {
        String corpNo = ThreadLocalUtil.getCorpNo();
        // 排除已经和当前料号绑定过的商品
        GmsGoodsBindExample bindSelectExample = new GmsGoodsBindExample();
        GmsGoodsBindExample.Criteria criteria = bindSelectExample.createCriteria();
        criteria.andCorpNoEqualTo(corpNo);
        criteria.andPrimaryGoodsCodeEqualTo(searchParam.getCode());
        List<GmsGoodsBind> gmsGoodsBinds = gmsGoodsBindMapper.selectByExample(bindSelectExample);
        List<String> secondaryGoodsCodeList = gmsGoodsBinds.stream().map(GmsGoodsBind::getSecondaryGoodsCode).collect(Collectors.toList());
        return gmsGoodsDao.searchByParamExcludeCode(corpNo, searchParam, secondaryGoodsCodeList);
    }

    @Transactional(rollbackFor = RuntimeException.class)
    public int insert(List<GmsGoodsBind> bindMap) {
        String corpNo = ThreadLocalUtil.getCorpNo();
        List<String> secondaryGoodsList = new ArrayList<>(bindMap.size());
        // 判断将要绑定的商品是否已经绑定过了
        GmsGoodsBindExample bindSelectExample = new GmsGoodsBindExample();
        GmsGoodsBindExample.Criteria criteria = bindSelectExample.createCriteria();
        criteria.andCorpNoEqualTo(corpNo);
        criteria.andPrimaryGoodsCodeEqualTo(bindMap.get(0).getPrimaryGoodsCode());
        bindMap.forEach((goodsBind) -> secondaryGoodsList.add(goodsBind.getSecondaryGoodsCode()));
        criteria.andSecondaryGoodsCodeIn(secondaryGoodsList);
        List<GmsGoodsBind> gmsGoodsBinds = gmsGoodsBindMapper.selectByExample(bindSelectExample);
        if (!gmsGoodsBinds.isEmpty()) {
            throw new RuntimeException("商品已经绑定过了，不允许重复绑定" + gmsGoodsBinds.stream().map(GmsGoodsBind::getSecondaryGoodsCode).collect(Collectors.toList()));
        }
        // 绑定商品
        bindMap.forEach(gmsGoodsBind -> {
            gmsGoodsBind.setCorpNo(corpNo);
            ModelUtils.setCreateAndUpdateInfo(gmsGoodsBind);
            gmsGoodsBindMapper.insert(gmsGoodsBind);
        });
        return bindMap.size();
    }

    public int delete(List<GmsGoodsBind> bindMap) {
        List<String> secondaryGoodsList = new ArrayList<>(bindMap.size());
        bindMap.forEach((goodsBind) -> secondaryGoodsList.add(goodsBind.getSecondaryGoodsCode()));
        GmsGoodsBindExample bindDeleteExample = new GmsGoodsBindExample();
        bindDeleteExample.createCriteria()
                .andCorpNoEqualTo(ThreadLocalUtil.getCorpNo())
                .andPrimaryGoodsCodeEqualTo(bindMap.get(0).getPrimaryGoodsCode())
                .andSecondaryGoodsCodeIn(secondaryGoodsList);
        return gmsGoodsBindMapper.deleteByExample(bindDeleteExample);
    }
}
