package com.mall.service;

import com.mall.common.utils.ModelUtils;
import com.mall.common.utils.ThreadLocalUtil;
import com.mall.dao.GmsGoodsAttributeDao;
import com.mall.entity.dto.GmcGoodsAttributeResult;
import com.mall.entity.dto.GmsGoodsAttributeParam;
import com.mall.mbg.mapper.GcmCategoryMapper;
import com.mall.mbg.model.GmsGoodsAndAttribute;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 商品属性管理Service
 *
 * @author 李重辰
 * @date 2020/10/16 9:52
 */
@Service
public class GmsGoodsAttributeService {

    private final MmsMerchantService merchantService;
    @Resource
    private GmsGoodsAttributeDao gmsGoodsAttributeDao;
    @Resource
    private GcmCategoryMapper categoryMapper;

    public GmsGoodsAttributeService(MmsMerchantService merchantService) {
        this.merchantService = merchantService;
    }

    /**
     * 属性：有值则显示，无值则不显示
     *
     * @param goodsCode 料号
     * @return 属性的code，属性的name，属性的值
     */
    public List<GmcGoodsAttributeResult> listForApp(String goodsCode) {
        return gmsGoodsAttributeDao.listForApp(goodsCode);
    }

    /**
     * 根据查询商品当前的属性值
     * 商品没有设置属性值时，也取出来属性名称
     *
     * @param goodsAttributeParam 商品code和大类名称
     * @return 属性的code，属性的name，属性的值
     */
    public List<GmcGoodsAttributeResult> list(GmsGoodsAttributeParam goodsAttributeParam) {
        // 根据类别名称和行业名称查类别代码
        String categoryId = goodsAttributeParam.getClass1();
        // 根据类别代码和商品代码查商品属性信息
        return gmsGoodsAttributeDao.list(categoryId, goodsAttributeParam.getGoodsId());
    }

    /**
     * 已经存在则更新，不存在则新增
     *
     * @return 成功的记录数
     */
    public Integer save(List<GmsGoodsAndAttribute> goodsAndAttributeList) {
        goodsAndAttributeList.forEach(modelObject -> {
            modelObject.setMerchantId(ThreadLocalUtil.getMerchant());
            ModelUtils.setCreateAndUpdateInfo(modelObject);
        });
        List<GmsGoodsAndAttribute> attributeList = goodsAndAttributeList.stream().filter(goodsAndAttribute -> {
            String value = goodsAndAttribute.getValue();
            return !StringUtils.isEmpty(value);
        }).collect(Collectors.toList());
        return gmsGoodsAttributeDao.save(attributeList);
    }

}
