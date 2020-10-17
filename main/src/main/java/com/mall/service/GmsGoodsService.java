package com.mall.service;

import org.springframework.stereotype.Service;
import com.mall.common.utils.ThreadLocalUtil;
import com.mall.dao.GmsGoodsDao;
import com.mall.entity.dto.GmsGoodsSearchParam;
import com.mall.entity.dto.GoodsLowerShelfUpdateParam;
import com.mall.mbg.model.GmsGoods;

import javax.annotation.Resource;
import java.util.List;

/**
 * 商品管理Service
 *
 * @author 李重辰
 * @date 2020/9/7 14:17
 */
@Service
public class GmsGoodsService {

    @Resource
    private GmsGoodsDao goodsDao;

    /**
     * 将goodsList中的商品信息存入goods表，如果有则更新，没有则新增
     */
    public int syncGoods(List<GmsGoods> goodsList) {
        return goodsDao.syncList(goodsList);
    }

    /**
     * 更新商品上下架的状态
     */
    public int updateGoodsSellStatus(GoodsLowerShelfUpdateParam dto) {
        // TODO: 2020/10/14 16:52 更新updateUser，和updateDate
        return goodsDao.updateGoodsSellStatus(dto.getCorpNo(), dto.getLowerShelf(), dto.getCodes());
    }

    /**
     * 查询符合条件的所有商品
     */
    public List<GmsGoods> listGoods(GmsGoodsSearchParam goodsSearchParam) {
        @SuppressWarnings("unchecked")
        List<GmsGoods> gmsGoods = (List<GmsGoods>) goodsDao.selectBySearchText(ThreadLocalUtil.getCorpNo(), goodsSearchParam);
        return gmsGoods;
    }

    /**
     * 批量更新商品虚拟库存
     */
    public int updateVirtualStock(List<GmsGoods> goodsList) {
        return goodsDao.updateVirtualStock(ThreadLocalUtil.getCorpNo(), goodsList);
    }
}
