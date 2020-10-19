package com.mall.service;

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
import com.mall.mbg.mapper.CmsIndexCarouselMapper;
import com.mall.mbg.mapper.CmsIndexSalesAdMapper;
import com.mall.mbg.mapper.CmsNoticeMapper;
import com.mall.mbg.model.CmsIndexCarousel;
import com.mall.mbg.model.CmsIndexCarouselExample;
import com.mall.mbg.model.CmsIndexSalesAd;
import com.mall.mbg.model.CmsIndexSalesAdExample;
import com.mall.mbg.model.CmsNoticeExample;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
    @Resource
    private CmsIndexCarouselMapper carouselMapper;
    @Resource
    private CmsNoticeMapper noticeMapper;
    @Resource
    private CmsIndexSalesAdMapper indexSalesAdMapper;
    @Resource
    private GmsGoodsDao goodsDao;

    /**
     * 首页获取商品大类
     */
    public List<IndexClassVO> listClass() {
        return indexDao.listClass(ThreadLocalUtil.getMerchant());
    }

    /**
     * 首页获取商品子类
     */
    public List<IndexClassVO> listSubClass(String className) {
        return indexDao.listSubClass(ThreadLocalUtil.getMerchant(), className);
    }

    /**
     * 获取首页轮播图
     */
    public IndexCarouselVO listCarousel(Integer device) {
        int defaultDevice = CarouselDeviceEnum.PC.getId();
        if (!StringUtils.isEmpty(device)) {
            defaultDevice = device;
        }
        CmsIndexCarouselExample example = new CmsIndexCarouselExample();
        CmsIndexCarouselExample.Criteria criteria = example.createCriteria();
        criteria.andMerchantIdEqualTo(ThreadLocalUtil.getMerchant());
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

    /**
     * 获取首页公告
     */
    public List<IndexNoticeVO> listNotice() {
        List<IndexNoticeVO> noticeList = new ArrayList<>();
        CmsNoticeExample noticeExample = new CmsNoticeExample();
        noticeExample.createCriteria()
                .andMerchantIdEqualTo(ThreadLocalUtil.getMerchant())
                .andStatusNotEqualTo(1);
        noticeExample.setOrderByClause("status_ desc, uid_ desc");
        noticeMapper.selectByExample(noticeExample).forEach((cmsNotice) -> {
            IndexNoticeVO noticeVO = new IndexNoticeVO();
            noticeVO.setNoticeId(cmsNotice.getId().toString());
            noticeVO.setTitle(cmsNotice.getTitle());
            noticeList.add(noticeVO);
        });
        return noticeList;
    }

    /**
     * 获取当前帐套下的品牌信息
     */
    public List<IndexBrandVO> listBrand() {
        return indexDao.listBrand(ThreadLocalUtil.getMerchant());
    }

    public IndexGoodsBlock getGoodsBlock(Integer saleStatus) {
        String corpNo = ThreadLocalUtil.getMerchant();
        IndexGoodsBlock indexGoodsBlock = new IndexGoodsBlock();
        // 促销的图片
        CmsIndexSalesAd indexTagAdImg = getCmsIndexSalesAd(saleStatus, corpNo);
        indexGoodsBlock.setCmsIndexSalesAd(indexTagAdImg);
        // 商品信息
        GmsGoodsSearchParam param = new GmsGoodsSearchParam();
        param.setSalesStatus(saleStatus);
        @SuppressWarnings("unchecked")
        List<GmsGoodsSearchResult> goodsList = (List<GmsGoodsSearchResult>) goodsDao.selectBySearchText(corpNo, param);
        indexGoodsBlock.setGoodsList(goodsList);
        return indexGoodsBlock;
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
        indexTagAdImgExample.createCriteria().andMerchantIdEqualTo(corpNo).andSalesStatusEqualTo(saleStatus);
        List<CmsIndexSalesAd> cmsIndexSalesAd = indexSalesAdMapper.selectByExample(indexTagAdImgExample);
        if (cmsIndexSalesAd.isEmpty()) {
            return null;
        }
        return cmsIndexSalesAd.get(0);
    }

}
