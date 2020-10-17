package com.mall.dao;

import org.apache.ibatis.session.ResultHandler;
import com.mall.entity.dto.ProductDetailGoodsDetailVO;

/**
 * @author 李重辰
 * @date 2020/9/23 10:32
 */
public interface ProductDetailDao {
    void getGoodsDetail(String corpNo, String code, ResultHandler<ProductDetailGoodsDetailVO> resultHandler);
}
