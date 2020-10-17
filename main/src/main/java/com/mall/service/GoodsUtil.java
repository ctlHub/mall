package com.mall.service;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;
import com.mall.entity.dto.GmsGoodsSearchResult;
import com.mall.entity.model.MongoPartInfo;
import com.mall.mbg.model.GmsGoods;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 商品查询公共方法类
 *
 * @author 李重辰
 * @date 2020/9/24 10:39
 */
@Component
public class GoodsUtil {

    @Resource
    private MongoTemplate mongoTemplate;

    private static MongoTemplate staticMongoTemplate;

    @PostConstruct
    public void init() {
        staticMongoTemplate = mongoTemplate;
    }

    /**
     * 将商品资料的图片中MongoDB中取出追加到GmsGoodsSearchResult中
     *
     * @param corpNo    帐套代码
     * @param goodsList 商品集合
     * @return 包含图片的GmsGoodsSearchResult流
     */
    public static List<GmsGoodsSearchResult> appendImgFromMongoDb(String corpNo, List<GmsGoodsSearchResult> goodsList) {
        List<String> collect = goodsList.stream().map(GmsGoods::getCode).collect(Collectors.toList());
        Query query = new Query(Criteria.where("corpNo_").is(corpNo).and("partCode_").in(collect));
        List<MongoPartInfo> mongoPartInfoList = staticMongoTemplate.find(query, MongoPartInfo.class);
        Map<String, MongoPartInfo> mongoPartInfoMap = mongoPartInfoList.stream().collect(Collectors.toMap(MongoPartInfo::getPartCode, partInfo -> partInfo));
        goodsList.forEach(goods -> {
            MongoPartInfo mongoPartInfo = mongoPartInfoMap.get(goods.getCode());
            if (null != mongoPartInfo) {
                goods.setIconImage(mongoPartInfo.getIconImage());
                goods.setMainImages(mongoPartInfo.getMainImages());
                goods.setOtherImages(mongoPartInfo.getOtherImages());
            }
        });
        return goodsList;
    }
}
