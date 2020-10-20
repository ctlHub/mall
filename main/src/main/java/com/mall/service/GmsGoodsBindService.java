package com.mall.service;

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
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

  public List<GmsGoods> get(String PrimaryGoodsId) {
    return gmsGoodsBindDao.get(ThreadLocalUtil.getMerchant(), PrimaryGoodsId);
  }

  public List<GmsGoodsSearchResult> getForApp(String PrimaryGoodsId) {
    List<GmsGoods> goodsList = gmsGoodsBindDao.get(ThreadLocalUtil.getMerchant(), PrimaryGoodsId);
    List<GmsGoodsSearchResult> goodsResultList = new ArrayList<>(goodsList.size());
    goodsList.forEach(gmsGoods -> {
      GmsGoodsSearchResult goodsResult = new GmsGoodsSearchResult();
      BeanUtils.copyProperties(gmsGoods, goodsResult);
      goodsResultList.add(goodsResult);
    });
    return goodsResultList;
  }

  public List<GmsGoods> listBindableGoods(GmsGoodsSearchParam searchParam) {
    String corpNo = ThreadLocalUtil.getMerchant();
    // 排除已经和当前料号绑定过的商品
    GmsGoodsBindExample bindSelectExample = new GmsGoodsBindExample();
    GmsGoodsBindExample.Criteria criteria = bindSelectExample.createCriteria();
    criteria.andMerchantIdEqualTo(corpNo);
    criteria.andPrimaryGoodsIdEqualTo(searchParam.getId());
    List<GmsGoodsBind> gmsGoodsBinds = gmsGoodsBindMapper.selectByExample(bindSelectExample);
    List<String> secondaryGoodsIdList = gmsGoodsBinds.stream().map(GmsGoodsBind::getSecondaryGoodsId).collect(Collectors.toList());
    return gmsGoodsDao.searchByParamExcludeCode(corpNo, searchParam, secondaryGoodsIdList);
  }

  @Transactional(rollbackFor = RuntimeException.class)
  public int insert(List<GmsGoodsBind> bindMap) {
    String corpNo = ThreadLocalUtil.getMerchant();
    List<String> secondaryGoodsList = new ArrayList<>(bindMap.size());
    // 判断将要绑定的商品是否已经绑定过了
    GmsGoodsBindExample bindSelectExample = new GmsGoodsBindExample();
    GmsGoodsBindExample.Criteria criteria = bindSelectExample.createCriteria();
    criteria.andMerchantIdEqualTo(corpNo);
    criteria.andPrimaryGoodsIdEqualTo(bindMap.get(0).getPrimaryGoodsId());
    bindMap.forEach((goodsBind) -> secondaryGoodsList.add(goodsBind.getSecondaryGoodsId()));
    criteria.andSecondaryGoodsIdIn(secondaryGoodsList);
    List<GmsGoodsBind> gmsGoodsBinds = gmsGoodsBindMapper.selectByExample(bindSelectExample);
    if (!gmsGoodsBinds.isEmpty()) {
      throw new RuntimeException("商品已经绑定过了，不允许重复绑定" + gmsGoodsBinds.stream().map(GmsGoodsBind::getSecondaryGoodsId).collect(Collectors.toList()));
    }
    // 绑定商品
    bindMap.forEach(gmsGoodsBind -> {
      gmsGoodsBind.setMerchantId(corpNo);
      ModelUtils.setCreateAndUpdateInfo(gmsGoodsBind);
      gmsGoodsBindMapper.insert(gmsGoodsBind);
    });
    return bindMap.size();
  }

  public int delete(List<GmsGoodsBind> bindMap) {
    List<String> secondaryGoodsList = new ArrayList<>(bindMap.size());
    bindMap.forEach((goodsBind) -> secondaryGoodsList.add(goodsBind.getSecondaryGoodsId()));
    GmsGoodsBindExample bindDeleteExample = new GmsGoodsBindExample();
    bindDeleteExample.createCriteria()
        .andMerchantIdEqualTo(ThreadLocalUtil.getMerchant())
        .andPrimaryGoodsIdEqualTo(bindMap.get(0).getPrimaryGoodsId())
        .andSecondaryGoodsIdIn(secondaryGoodsList);
    return gmsGoodsBindMapper.deleteByExample(bindDeleteExample);
  }
}
