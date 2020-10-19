package com.mall.dao;

import com.mall.entity.dto.GmsGoodsSearchParam;
import com.mall.entity.dto.GmsGoodsSearchResult;
import com.mall.mbg.model.GmsGoods;
import com.mall.mbg.model.GmsGoodsExample;

import java.util.List;

/**
 * 商品管理自定义Dao
 *
 * @author 李重辰
 * @date 2020/9/7 14:40
 */
public interface GmsGoodsDao {

  /**
   * 批量同步商品资料
   */
  int syncList(List<GmsGoods> goodsList);

  /**
   * 更新商品上下架状态
   */
  int updateGoodsSellStatus(String corpNo, Boolean sellStatus, List<String> codeList);

  List<? extends GmsGoods> selectBySearchText(String corpNo, GmsGoodsSearchParam searchParam);

  int updateVirtualStock(String corpNo, List<GmsGoods> goodsList);

  List<GmsGoodsSearchResult> selectByExample(GmsGoodsExample example);

  int updateFileNum(String corpNo, String code, Integer var);

  /**
   * 根据参数查询商品信息，但是排除料号等于参数中的料号的结果
   * 不查询型号商品，即 classify <> 1
   *
   * @param searchParam 查询参数
   */
  List<GmsGoods> searchByParamExcludeCode(String corpNo, GmsGoodsSearchParam searchParam, List<String> SecondaryGoodsId);
}
