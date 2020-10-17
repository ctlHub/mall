package com.mall.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.mall.common.exception.GoodsNotExistException;
import com.mall.common.exception.TagNotExistException;
import com.mall.common.utils.ModelUtils;
import com.mall.dao.GmsGoodsAndTagDao;
import com.mall.entity.dto.GmsGoodsAndTagListResult;
import com.mall.entity.dto.GmsGoodsAndTagSearchParam;
import com.mall.mbg.mapper.GmsGoodsAndTagMapper;
import com.mall.mbg.mapper.GmsGoodsMapper;
import com.mall.mbg.mapper.GmsTagMapper;
import com.mall.mbg.model.GmsGoodsAndTag;
import com.mall.mbg.model.GmsGoodsExample;
import com.mall.mbg.model.GmsTag;
import com.mall.mbg.model.GmsTagExample;

import javax.annotation.Resource;
import java.util.List;

import static com.mall.common.utils.ThreadLocalUtil.getCorpNo;

/**
 * 商品标签管理Service
 *
 * @author 李重辰
 * @date 2020/9/16 19:23
 */
@Service
public class GmsGoodsTagService {

    @Resource
    GmsGoodsAndTagDao gmsGoodsAndTagDao;

    @Resource
    GmsGoodsAndTagMapper goodsAndTagMapper;

    @Resource
    GmsGoodsMapper goodsMapper;

    @Resource
    GmsTagMapper gmsTagMapper;

    @Transactional(rollbackFor = RuntimeException.class)
    public int bind(List<GmsGoodsAndTag> params) {
        for (GmsGoodsAndTag gm : params) {
            String goodsCode = gm.getGoodsCode();
            String corpNo = getCorpNo();
            String tagCode = gm.getTagCode();
            // 判断商品编号是否存在
            GmsGoodsExample goodsExample = new GmsGoodsExample();
            goodsExample.createCriteria().
                    andCorpNoEqualTo(corpNo).
                    andCodeEqualTo(goodsCode);
            long goodsCount = goodsMapper.countByExample(goodsExample);
            if (goodsCount < 1) {
                throw new GoodsNotExistException(goodsCode);
            }
            // 判断标签是否存在
            GmsTagExample tagExample = new GmsTagExample();
            tagExample.createCriteria().
                    andCorpNoEqualTo(corpNo).
                    andCodeEqualTo(tagCode);
            long tagCount = gmsTagMapper.countByExample(tagExample);
            if (tagCount < 1) {
                throw new TagNotExistException(tagCode);
            }
            ModelUtils.setCreateAndUpdateInfo(gm);
            gm.setCorpNo(corpNo);
            goodsAndTagMapper.insert(gm);
        }
        return params.size();
    }

    public int cancelBind(List<GmsGoodsAndTag> params) {
        return gmsGoodsAndTagDao.cancelBind(getCorpNo(), params);
    }

    public List<GmsTag> listTag(String goodsCode) {
        return gmsGoodsAndTagDao.listTagByGoodsCode(getCorpNo(), goodsCode);
    }

    /**
     * 根据商品信息和标签信息，查询商品绑定了哪些标签
     * 只查有绑定关系的
     */
    public List<GmsGoodsAndTagListResult> listGoodsAndTag(GmsGoodsAndTagSearchParam searchParam) {
        return gmsGoodsAndTagDao.listGoodsAndTag(getCorpNo(), searchParam);
    }

}
