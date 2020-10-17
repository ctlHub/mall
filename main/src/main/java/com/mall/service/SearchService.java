package com.mall.service;

import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;
import com.mall.common.utils.ThreadLocalUtil;
import com.mall.dao.GmsGoodsDao;
import com.mall.entity.dto.GmsGoodsSearchParam;
import com.mall.entity.dto.GmsGoodsSearchResult;
import com.mall.mbg.mapper.CmsNoticeMapper;
import com.mall.mbg.model.CmsNotice;
import com.mall.mbg.model.CmsNoticeExample;

import javax.annotation.Resource;
import java.util.List;

/**
 * 前端查询实现类
 *
 * @author 李重辰
 * @date 2020/9/23 17:36
 */
@Service
public class SearchService {

    @Resource
    private GmsGoodsDao goodsDao;

    @Resource
    private CmsNoticeMapper noticeMapper;

    /**
     * 查询符合条件的所有商品
     */
    public List<GmsGoodsSearchResult> listGoods(GmsGoodsSearchParam goodsSearchParam, Integer pageNum, Integer pageSize) {
        String corpNo = ThreadLocalUtil.getCorpNo();
        PageHelper.startPage(pageNum, pageSize);
        @SuppressWarnings("unchecked")
        List<GmsGoodsSearchResult> goodsList = (List<GmsGoodsSearchResult>) goodsDao.selectBySearchText(corpNo, goodsSearchParam);
        return GoodsUtil.appendImgFromMongoDb(corpNo, goodsList);
    }

    public List<CmsNotice> listNotice(Integer pageNum, Integer pageSize) {
        CmsNoticeExample noticeExample = new CmsNoticeExample();
        noticeExample.createCriteria()
                .andCorpNoEqualTo(ThreadLocalUtil.getCorpNo())
                .andStatusNotEqualTo(1);
        noticeExample.setOrderByClause("status_ desc, uid_ desc");
        PageHelper.startPage(pageNum, pageSize);
        return noticeMapper.selectByExample(noticeExample);
    }
}
