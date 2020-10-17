package com.mall.service;

import com.google.gson.Gson;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
import com.mall.common.exception.GoodsNotExistException;
import com.mall.common.utils.ThreadLocalUtil;
import com.mall.config.resulthander.ProductDetailResultHandle;
import com.mall.dao.ProductDetailDao;
import com.mall.entity.dto.ProductDetailGoodsDetailVO;
import com.mall.entity.model.ClassifyEnum;
import com.mall.entity.model.MongoPartInfo;
import com.mall.mbg.mapper.GmsGoodsAndEshopMapper;
import com.mall.mbg.mapper.GmsGoodsMapper;
import com.mall.mbg.model.GmsGoods;
import com.mall.mbg.model.GmsGoodsAndEshop;
import com.mall.mbg.model.GmsGoodsAndEshopExample;
import com.mall.mbg.model.GmsGoodsExample;

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
    private MongoTemplate mongoTemplate;

    @Resource
    private Gson gson;

    /**
     * 根据料号查询商品详情
     *
     * @param code 料号
     */
    public ProductDetailGoodsDetailVO getGoodsDetail(String code) {
        String corpNo = ThreadLocalUtil.getCorpNo();
        ProductDetailResultHandle resultHandle = new ProductDetailResultHandle(gson);
        // 获取主商品详情信息
        productDetailDao.getGoodsDetail(corpNo, code, resultHandle);
        ProductDetailGoodsDetailVO goodsDetail = resultHandle.getProductDetailGoodsDetailVO();
        if (null == goodsDetail) {
            throw new GoodsNotExistException(code);
        }
        // 查询商品子项商品信息
        GmsGoodsExample goodsExample = new GmsGoodsExample();
        goodsExample.createCriteria().andCorpNoEqualTo(corpNo).andMarqueEqualTo(code).andClassifyEqualTo(ClassifyEnum.child.getCode());
        List<GmsGoods> gmsGoods = goodsMapper.selectByExample(goodsExample);
        goodsDetail.setChildGoods(gmsGoods);
        // 从MongoDB获得商品图片
        Query query = new Query(Criteria.where("corpNo_").is(corpNo).and("partCode_").is(code));
        MongoPartInfo partInfo = mongoTemplate.findOne(query, MongoPartInfo.class);
        if (null != partInfo) {
            goodsDetail.setIconImage(partInfo.getIconImage());
            goodsDetail.setMainImages(partInfo.getMainImages());
            goodsDetail.setOtherImages(partInfo.getOtherImages());
        }
        return goodsDetail;
    }

    @Resource
    private GmsGoodsAndEshopMapper goodsAndEshopMapper;

    /**
     * 根据商品料号获得电商平台链接
     */
    public List<GmsGoodsAndEshop> getEshop(String code) {
        GmsGoodsAndEshopExample goodsAndEshopExample = new GmsGoodsAndEshopExample();
        goodsAndEshopExample.createCriteria().andCorpNoEqualTo(ThreadLocalUtil.getCorpNo()).andGoodsCodeEqualTo(code).andStatusEqualTo(1);
        return goodsAndEshopMapper.selectByExample(goodsAndEshopExample);
    }

}
