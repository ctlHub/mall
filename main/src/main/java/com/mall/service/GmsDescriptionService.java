package com.mall.service;

import com.mall.common.utils.ModelUtils;
import com.mall.common.utils.ThreadLocalUtil;
import com.mall.dao.GmsGoodsDao;
import com.mall.dao.GmsGoodsDescriptionDao;
import com.mall.entity.dto.GmsGoodsDescParam;
import com.mall.entity.model.UsedEnum;
import com.mall.mbg.mapper.GmsGoodsDescriptionMapper;
import com.mall.mbg.model.GmsGoodsDescription;
import com.mall.mbg.model.GmsGoodsDescriptionExample;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * 商品描述Service
 *
 * @author 李重辰
 * @date 2020/9/23 16:47
 */
@Service
public class GmsDescriptionService {

  @Resource
  GmsGoodsDescriptionMapper goodsDescriptionMapper;

  @Resource
  GmsGoodsDescriptionDao goodsDescriptionDao;

  @Resource
  GmsGoodsDao goodsDao;

  /**
   * 查询商品描述图片 for admin
   */
  public List<GmsGoodsDescription> list(String code) {
    GmsGoodsDescriptionExample goodsDescriptionExample = new GmsGoodsDescriptionExample();
    goodsDescriptionExample.createCriteria().andMerchantIdEqualTo(ThreadLocalUtil.getMerchant()).andGoodsIdEqualTo(code);
    return goodsDescriptionMapper.selectByExampleWithBLOBs(goodsDescriptionExample);
  }

  /**
   * 查询商品描述图片 for app
   */
  public List<String> listDescriptionContentForApp(String code) {
    return goodsDescriptionDao.listDescriptionContent(ThreadLocalUtil.getMerchant(), code);
  }

  @Transactional(rollbackFor = RuntimeException.class)
  public Integer insert(GmsGoodsDescParam goodsDescParam) {
    goodsDescParam.setStatus(UsedEnum.ENABLE.getId());
    GmsGoodsDescription goodsDescription = new GmsGoodsDescription();
    BeanUtils.copyProperties(goodsDescParam, goodsDescription);
    ModelUtils.setCreateAndUpdateInfo(goodsDescription);
    int insert = goodsDescriptionMapper.insert(goodsDescription);
    goodsDao.updateFileNum(goodsDescParam.getMerchantId(), goodsDescParam.getGoodsId(), insert);
    return insert;
  }

  public Integer delete(String code, String goodsCode) {
    GmsGoodsDescriptionExample example = new GmsGoodsDescriptionExample();
    example.createCriteria().andIdEqualTo(code);
    int delete = goodsDescriptionMapper.deleteByExample(example);
    goodsDao.updateFileNum(ThreadLocalUtil.getMerchant(), goodsCode, Math.negateExact(delete));
    return delete;
  }

  public List<GmsGoodsDescription> get(String code) {
    GmsGoodsDescriptionExample example = new GmsGoodsDescriptionExample();
    example.createCriteria().andIdEqualTo(code);
    return goodsDescriptionMapper.selectByExampleWithBLOBs(example);
  }

}
