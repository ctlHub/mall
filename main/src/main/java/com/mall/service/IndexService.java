package com.mall.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import com.mall.common.utils.ThreadLocalUtil;
import com.mall.dao.GmsGoodsDao;
import com.mall.dao.IndexDao;
import com.mall.entity.dto.GmsGoodsSearchParam;
import com.mall.entity.dto.GmsGoodsSearchResult;
import com.mall.entity.dto.IndexBrandVO;
import com.mall.entity.dto.IndexCarouselVO;
import com.mall.entity.dto.IndexClassVO;
import com.mall.entity.dto.IndexGoodsBlock;
import com.mall.entity.dto.IndexNoticeVO;
import com.mall.entity.model.CarouselDeviceEnum;
import com.mall.entity.model.MongoPartInfo;
import com.mall.mbg.mapper.CmsIndexCarouselMapper;
import com.mall.mbg.mapper.CmsIndexSalesAdMapper;
import com.mall.mbg.mapper.CmsNoticeMapper;
import com.mall.mbg.model.CmsIndexCarousel;
import com.mall.mbg.model.CmsIndexCarouselExample;
import com.mall.mbg.model.CmsIndexSalesAd;
import com.mall.mbg.model.CmsIndexSalesAdExample;
import com.mall.mbg.model.CmsNoticeExample;
import com.mall.mbg.model.GmsGoodsExample;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static com.mall.entity.model.SaleStatusEnum.promotion;

/**
 * 首页显示Service
 *
 * @author 李重辰
 * @date 2020/9/21 17:18
 */
@Slf4j
@Service
public class IndexService {

    @Resource
    private IndexDao indexDao;

    /**
     * 首页获取商品大类
     */
    public List<IndexClassVO> listClass() {
        return indexDao.listClass(ThreadLocalUtil.getCorpNo());
    }

    /**
     * 首页获取商品子类
     */
    public List<IndexClassVO> listSubClass(String className) {
        return indexDao.listSubClass(ThreadLocalUtil.getCorpNo(), className);
    }

    @Resource
    private CmsIndexCarouselMapper carouselMapper;

    /**
     * 获取首页轮播图
     */
    public IndexCarouselVO listCarousel(Integer device) {
        int defaultDevice = CarouselDeviceEnum.PC.getCode();
        if (!StringUtils.isEmpty(device)) {
            defaultDevice = device;
        }
        CmsIndexCarouselExample example = new CmsIndexCarouselExample();
        CmsIndexCarouselExample.Criteria criteria = example.createCriteria();
        criteria.andCorpNoEqualTo(ThreadLocalUtil.getCorpNo());
        criteria.andDeviceEqualTo((byte) defaultDevice);
        List<String> imgList = carouselMapper.selectByExample(example).stream().map(CmsIndexCarousel::getImgUrl).collect(Collectors.toList());

        IndexCarouselVO indexCarouselVO = new IndexCarouselVO();
        indexCarouselVO.setSwitchTime(3000);
        indexCarouselVO.setImgList(imgList);
        return indexCarouselVO;
    }

    /**
     * 购物车商品数量
     */
    public Integer countCart() {
        return 5;
    }

    /**
     * 收藏数量
     */
    public Integer countCollect() {
        return 8;
    }

    @Resource
    private CmsNoticeMapper noticeMapper;

    /**
     * 获取首页公告
     */
    public List<IndexNoticeVO> listNotice() {
        List<IndexNoticeVO> noticeList = new ArrayList<>();
        CmsNoticeExample noticeExample = new CmsNoticeExample();
        noticeExample.createCriteria()
                .andCorpNoEqualTo(ThreadLocalUtil.getCorpNo())
                .andStatusNotEqualTo(1);
        noticeExample.setOrderByClause("status_ desc, uid_ desc");
        noticeMapper.selectByExample(noticeExample).forEach((cmsNotice) -> {
            IndexNoticeVO noticeVO = new IndexNoticeVO();
            noticeVO.setNoticeId(cmsNotice.getUid().toString());
            noticeVO.setTitle(cmsNotice.getTitle());
            noticeList.add(noticeVO);
        });
        return noticeList;
    }

    /**
     * 获取当前帐套下的品牌信息
     */
    public List<IndexBrandVO> listBrand() {
        return indexDao.listBrand(ThreadLocalUtil.getCorpNo());
    }

    @Resource
    private CmsIndexSalesAdMapper indexSalesAdMapper;

    @Resource
    private GmsGoodsDao goodsDao;

    public IndexGoodsBlock getGoodsBlock(Integer saleStatus) {
        String corpNo = ThreadLocalUtil.getCorpNo();
        IndexGoodsBlock indexGoodsBlock = new IndexGoodsBlock();
        // 促销的图片
        CmsIndexSalesAd indexTagAdImg = getCmsIndexSalesAd(saleStatus, corpNo);
        indexGoodsBlock.setCmsIndexSalesAd(indexTagAdImg);
        // 商品信息
        GmsGoodsSearchParam param = new GmsGoodsSearchParam();
        param.setSalesStatus(saleStatus);
        @SuppressWarnings("unchecked")
        List<GmsGoodsSearchResult> goodsList = (List<GmsGoodsSearchResult>) goodsDao.selectBySearchText(corpNo, param);
        GoodsUtil.appendImgFromMongoDb(corpNo, goodsList);
        indexGoodsBlock.setGoodsList(goodsList);
        return indexGoodsBlock;
    }

    @Resource
    private MongoTemplate mongoTemplate;

    public IndexGoodsBlock getPromotionGoodsBlockFromMongoDb(Integer saleStatus) {
        String corpNo = ThreadLocalUtil.getCorpNo();
        IndexGoodsBlock indexGoodsBlock = new IndexGoodsBlock();
        // 促销图片
        CmsIndexSalesAd indexTagAdImg = getCmsIndexSalesAd(saleStatus, corpNo);
        indexGoodsBlock.setCmsIndexSalesAd(indexTagAdImg);
        // 商品信息
        List<GmsGoodsSearchResult> gmsGoods = getGmsGoodsSearchResults(corpNo);
        indexGoodsBlock.setGoodsList(gmsGoods);
        return indexGoodsBlock;
    }

    /**
     * 从MongoDB和MySQL中获取商品信息并整合到GmsGoodsSearchResult中
     *
     * @param corpNo 帐套代码
     * @return 查询结果集
     */
    private List<GmsGoodsSearchResult> getGmsGoodsSearchResults(String corpNo) {
        // 从MongoDB中找到sales_大于0的商品料号，即促销
        Query query = new Query();
        query.addCriteria(Criteria.where("corpNo_").is(corpNo).and("sales_").gt(0));
        List<MongoPartInfo> mongoPartInfoList = mongoTemplate.find(query, MongoPartInfo.class);
        if (mongoPartInfoList.isEmpty()) {
            return Collections.emptyList();
        }
        Map<String, MongoPartInfo> partInfoMap = mongoPartInfoList.stream().collect(Collectors.toMap((MongoPartInfo::getPartCode), partInfo -> partInfo));
        List<String> codeList = mongoPartInfoList.stream().map(MongoPartInfo::getPartCode).collect(Collectors.toList());
        // 根据以上料号在MySQL中查到商品信息
        GmsGoodsExample example = new GmsGoodsExample();
        example.createCriteria().andCorpNoEqualTo(corpNo).andCodeIn(codeList);
        List<GmsGoodsSearchResult> gmsGoods = goodsDao.selectByExample(example);
        gmsGoods = gmsGoods.stream().peek(result -> {
            MongoPartInfo partInfo = partInfoMap.get(result.getCode());
            if (null != partInfo) {
                result.setIconImage(partInfo.getIconImage());
                result.setMainImages(partInfo.getMainImages());
                result.setOtherImages(partInfo.getOtherImages());
            }
            result.setSalesStatus(promotion.getCode());
        }).collect(Collectors.toList());
        return gmsGoods;
    }

    /**
     * 获得促销类别的宣传图
     *
     * @param saleStatus 促销类型code
     * @param corpNo     帐套
     * @return 促销图地址
     */
    private CmsIndexSalesAd getCmsIndexSalesAd(Integer saleStatus, String corpNo) {
        CmsIndexSalesAdExample indexTagAdImgExample = new CmsIndexSalesAdExample();
        indexTagAdImgExample.createCriteria().andCorpNoEqualTo(corpNo).andSalesStatusEqualTo(saleStatus);
        List<CmsIndexSalesAd> cmsIndexSalesAd = indexSalesAdMapper.selectByExample(indexTagAdImgExample);
        if (cmsIndexSalesAd.isEmpty()) {
            return null;
        }
        return cmsIndexSalesAd.get(0);
    }

}
