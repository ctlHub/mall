package com.mall.service;

import com.mall.common.utils.ModelUtils;
import com.mall.common.utils.SnowflakeIdGenerator;
import com.mall.common.utils.ThreadLocalUtil;
import com.mall.mbg.mapper.CmsIndexCarouselMapper;
import com.mall.mbg.model.CmsIndexCarousel;
import com.mall.mbg.model.CmsIndexCarouselExample;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.List;

/**
 * 首页Carousel图片管理Service
 * <p>
 * carry sale
 *
 * @author 李重辰
 * @date 2020/9/28 9:50
 */
@Service
public class CmsCarouselService {

  @Resource
  CmsIndexCarouselMapper carouselMapper;

  public List<CmsIndexCarousel> list(String imgCode) {
    CmsIndexCarouselExample example = new CmsIndexCarouselExample();
    CmsIndexCarouselExample.Criteria criteria = example.createCriteria();
    criteria.andMerchantIdEqualTo(ThreadLocalUtil.getMerchant());
    if (!StringUtils.isEmpty(imgCode)) {
      criteria.andIdEqualTo(imgCode);
    }
    return carouselMapper.selectByExample(example);
  }

  public Integer insert(CmsIndexCarousel indexCarousel) {
    ModelUtils.setCreateAndUpdateInfo(indexCarousel);
    indexCarousel.setId(SnowflakeIdGenerator.genId());
    return carouselMapper.insert(indexCarousel);
  }

  public Integer delete(String imgCode) {
    CmsIndexCarouselExample example = new CmsIndexCarouselExample();
    CmsIndexCarouselExample.Criteria criteria = example.createCriteria();
    criteria.andMerchantIdEqualTo(ThreadLocalUtil.getMerchant());
    criteria.andIdEqualTo(imgCode);
    return carouselMapper.deleteByExample(example);
  }
}
