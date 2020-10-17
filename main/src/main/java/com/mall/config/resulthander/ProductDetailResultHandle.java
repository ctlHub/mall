package com.mall.config.resulthander;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.mall.entity.dto.ProductDetailGoodsDetailVO;
import com.mall.entity.model.Child;
import com.mall.entity.model.ClassifyEnum;
import com.mall.entity.model.Optional;
import com.mall.entity.model.PriceRange;
import org.apache.ibatis.session.ResultContext;
import org.apache.ibatis.session.ResultHandler;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * 商品详情查询结果处理类，将查询到的option进行拆分，封装到型号和子项信息中
 *
 * @author 李重辰
 * @date 2020/9/26 23:09
 */
public class ProductDetailResultHandle implements ResultHandler<ProductDetailGoodsDetailVO> {

  private final static String HEAD = "head";
  private final static String DATE_SET = "dataset";
  final Gson gson;
  private ProductDetailGoodsDetailVO productDetailGoodsDetailVO;

  public ProductDetailResultHandle(Gson gson) {
    this.gson = gson;
  }

  @Override
  public void handleResult(ResultContext<? extends ProductDetailGoodsDetailVO> resultContext) {
    productDetailGoodsDetailVO = resultContext.getResultObject();
    String option = productDetailGoodsDetailVO.getOptional();
    if (!StringUtils.isEmpty(option)) {
      Map<String, Object> map = gson.fromJson(option, new TypeToken<Map<String, Object>>() {
      }.getType());
      // 根据classify判断是型号商品还是子项商品
      Integer classify = productDetailGoodsDetailVO.getClassify();
      ClassifyEnum anEnum = ClassifyEnum.getClassifyEnumByCode(classify);
      switch (anEnum) {
        case optional:
          setOptionList(map);
          break;
        case child:
          setChildList(map);
          break;
        default:
      }
    }
  }

  /**
   * 从option_字段中解析子项商品信息，并且添加到VO对象中
   */
  private void setChildList(Map<String, Object> optionMap) {
    List<Child> childList = new ArrayList<>();
    @SuppressWarnings("unchecked")
    List<List<String>> itemList = (List<List<String>>) optionMap.get(DATE_SET);
    for (int i = 1; i < itemList.size(); i++) {
      List<String> item = itemList.get(i);
      Child child = new Child();
      child.setName(item.get(0));
      child.setValue(item.get(1));
      childList.add(child);
    }
    productDetailGoodsDetailVO.setChildList(childList);
  }

  /**
   * 添加型号商品信息
   */
  private void setOptionList(Map<String, Object> optionMap) {
    // set型号商品价格范围
    PriceRange priceRange = new PriceRange();
    initPriceRange(optionMap, priceRange);
    productDetailGoodsDetailVO.setPriceRange(priceRange);

    List<Optional> optionalList = new ArrayList<>();
    @SuppressWarnings("unchecked")
    List<List<String>> itemList = (List<List<String>>) optionMap.get(DATE_SET);
    for (int i = 1; i < itemList.size(); i++) {
      List<String> stringList = itemList.get(i);
      Optional optional = new Optional();
      for (int j = 0; j < stringList.size(); j++) {
        if (j == 0) {
          optional.setName(stringList.get(j));
          continue;
        }
        if (j == 1) {
          String optionStr = stringList.get(j);
          String[] split = optionStr.split(",");
          optional.setOption(Arrays.asList(split));
          continue;
        }
        if (j == 2) {
          optional.setDefault_(stringList.get(j));
        }
      }
      optionalList.add(optional);
    }
    productDetailGoodsDetailVO.setOptionList(optionalList);
  }

  /**
   * 为型号商品的价格范围赋值
   */
  private void initPriceRange(Map<String, Object> optionMap, PriceRange priceRange) {
    @SuppressWarnings("unchecked")
    Map<String, Double> head = (Map<String, Double>) optionMap.get(HEAD);
    if (head == null) {
      return;
    }
    priceRange.setMaxInUp(head.get("MaxInUP_"));
    priceRange.setMaxListUp(head.get("MaxListUP_"));
    priceRange.setMaxOutUp(head.get("MaxOutUP_"));
    priceRange.setMaxOutUp2(head.get("MaxOutUP2_"));
    priceRange.setMaxVipUp(head.get("MaxVipUP_"));
    priceRange.setMinInUp(head.get("MinInUP_"));
    priceRange.setMinListUp(head.get("MinListUP_"));
    priceRange.setMinOutUp(head.get("MinOutUP_"));
    priceRange.setMinOutUp2(head.get("MinOutUP2_"));
    priceRange.setMinVipUp(head.get("MinVipUP_"));
  }

  public ProductDetailGoodsDetailVO getProductDetailGoodsDetailVO() {
    return productDetailGoodsDetailVO;
  }
}
