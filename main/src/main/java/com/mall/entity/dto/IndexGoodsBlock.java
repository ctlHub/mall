package com.mall.entity.dto;

import com.mall.mbg.model.CmsIndexSalesAd;
import lombok.Data;

import java.util.List;

/**
 * 首页商品展示块，根据标签查询商品
 *
 * @author 李重辰
 * @date 2020/9/22 15:06
 */
@Data
public class IndexGoodsBlock {
  private CmsIndexSalesAd cmsIndexSalesAd;
  private List<GmsGoodsSearchResult> goodsList;
}
