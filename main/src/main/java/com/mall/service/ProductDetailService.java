package com.mall.service;

import com.google.gson.Gson;
import com.mall.common.exception.GoodsNotExistException;
import com.mall.common.utils.ThreadLocalUtil;
import com.mall.config.resulthander.ProductDetailResultHandle;
import com.mall.dao.ProductDetailDao;
import com.mall.entity.dto.ProductDetailGoodsDetailVO;
import com.mall.entity.model.ClassifyEnum;
import com.mall.mbg.mapper.GmsGoodsAndEshopMapper;
import com.mall.mbg.mapper.GmsGoodsMapper;
import com.mall.mbg.model.GmsGoods;
import com.mall.mbg.model.GmsGoodsAndEshop;
import com.mall.mbg.model.GmsGoodsAndEshopExample;
import com.mall.mbg.model.GmsGoodsExample;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 商品详情界面查询Service
 *
 * @author 李重辰
 * @date 2020/9/23 10:31
 */
@Service
public class ProductDetailService {

    @Resource
    private ProductDetailDao productDetailDao;

    @Resource
    private GmsGoodsMapper goodsMapper;

    @Resource
    private Gson gson;
    @Resource
    private GmsGoodsAndEshopMapper goodsAndEshopMapper;

    /**
     * 根据料号查询商品详情
     *
     * @param code 料号
     */
    public ProductDetailGoodsDetailVO getGoodsDetail(String code) {
        String corpNo = ThreadLocalUtil.getMerchant();
        ProductDetailResultHandle resultHandle = new ProductDetailResultHandle(gson);
        // 获取主商品详情信息
        productDetailDao.getGoodsDetail(corpNo, code, resultHandle);
        ProductDetailGoodsDetailVO goodsDetail = resultHandle.getProductDetailGoodsDetailVO();
        if (null == goodsDetail) {
            throw new GoodsNotExistException(code);
        }
        // 查询商品子项商品信息
        GmsGoodsExample goodsExample = new GmsGoodsExample();
        goodsExample.createCriteria().andMerchantIdEqualTo(corpNo).andMarqueEqualTo(code).andClassifyEqualTo(ClassifyEnum.child.getId());
        List<GmsGoods> gmsGoods = goodsMapper.selectByExample(goodsExample);
        goodsDetail.setChildGoods(gmsGoods);
        return goodsDetail;
    }

    /**
     * 根据商品料号获得电商平台链接
     */
    public List<GmsGoodsAndEshop> getEshop(String code) {
        GmsGoodsAndEshopExample goodsAndEshopExample = new GmsGoodsAndEshopExample();
        goodsAndEshopExample.createCriteria().andMerchantIdEqualTo(ThreadLocalUtil.getMerchant()).andGoodsIdEqualTo(code).andStatusEqualTo(1);
        return goodsAndEshopMapper.selectByExample(goodsAndEshopExample);
    }

}
