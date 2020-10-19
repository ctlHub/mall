package com.mall.service;

import com.mall.common.exception.AttributeNotExistException;
import com.mall.common.utils.ModelUtils;
import com.mall.common.utils.SnowflakeIdGenerator;
import com.mall.entity.dto.GcmCategoryAttributeParam;
import com.mall.mbg.mapper.GcmCategoryAttributeMapper;
import com.mall.mbg.mapper.GmsGoodsAndAttributeMapper;
import com.mall.mbg.model.GcmCategoryAttribute;
import com.mall.mbg.model.GcmCategoryAttributeExample;
import com.mall.mbg.model.GmsGoodsAndAttributeExample;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author 李重辰
 * @date 2020/10/15 13:47
 */
@Service
public class GcmCateGoryAttributeService {

    @Resource
    private GcmCategoryAttributeMapper categoryAttributeMapper;
    @Resource
    private GmsGoodsAndAttributeMapper goodsAndAttributeMapper;

    /**
     * 查类别下有哪些属性
     */
    public List<GcmCategoryAttribute> list(GcmCategoryAttributeParam categoryAttributeParam) {
        String categoryId = categoryAttributeParam.getCategoryId();
        GcmCategoryAttributeExample categoryAttributeExample = new GcmCategoryAttributeExample();
        GcmCategoryAttributeExample.Criteria criteria = categoryAttributeExample.createCriteria();
        criteria.andCategoryIdEqualTo(categoryId);
        String attributeName = categoryAttributeParam.getName();
        if (!StringUtils.isEmpty(attributeName)) {
            criteria.andNameLike("%" + attributeName + "%");
        }
        return categoryAttributeMapper.selectByExample(categoryAttributeExample);
    }

    public String create(GcmCategoryAttributeParam categoryAttributeParam) {
        String categoryId = categoryAttributeParam.getCategoryId();
        GcmCategoryAttribute categoryAttribute = new GcmCategoryAttribute();
        BeanUtils.copyProperties(categoryAttributeParam, categoryAttribute);
        categoryAttribute.setCategoryId(categoryId);
        categoryAttribute.setId(SnowflakeIdGenerator.genId());
        ModelUtils.setCreateAndUpdateInfo(categoryAttribute);
        repeatValidate(categoryAttribute);
        categoryAttributeMapper.insert(categoryAttribute);
        return categoryAttribute.getId();
    }

    public Integer update(GcmCategoryAttributeParam categoryAttributeParam) {
        String categoryId = categoryAttributeParam.getCategoryId();
        GcmCategoryAttributeExample categoryAttributeExample = new GcmCategoryAttributeExample();
        categoryAttributeExample.createCriteria()
                .andIdEqualTo(categoryAttributeParam.getId());
        GcmCategoryAttribute categoryAttribute = new GcmCategoryAttribute();
        BeanUtils.copyProperties(categoryAttributeParam, categoryAttribute);
        ModelUtils.setUpdateInfo(categoryAttribute);
        categoryAttribute.setCategoryId(categoryId);
        repeatValidate(categoryAttribute);
        return categoryAttributeMapper.updateByExampleSelective(categoryAttribute, categoryAttributeExample);
    }

    public Integer delete(String attributeCode) {
        GmsGoodsAndAttributeExample goodsAttributeExample = new GmsGoodsAndAttributeExample();
        goodsAttributeExample.createCriteria().andAttributeIdEqualTo(attributeCode);
        // 如果有商品设置过了这个属性则不能删除
        long count = goodsAndAttributeMapper.countByExample(goodsAttributeExample);
        if (count > 0) {
            throw new RuntimeException(String.format("属性【%s】已经被使用，删除失败", attributeCode));
        }
        // 删除商品类别中的属性
        GcmCategoryAttributeExample categoryAttributeExample = new GcmCategoryAttributeExample();
        categoryAttributeExample.createCriteria()
                .andIdEqualTo(attributeCode);
        return categoryAttributeMapper.deleteByExample(categoryAttributeExample);
    }

    /**
     * 根据属性代码查询属性详情
     */
    public GcmCategoryAttribute get(String attrCode) {
        GcmCategoryAttributeExample attributeExample = new GcmCategoryAttributeExample();
        attributeExample.createCriteria()
                .andIdEqualTo(attrCode);
        List<GcmCategoryAttribute> categoryAttributeList = categoryAttributeMapper.selectByExample(attributeExample);
        if (CollectionUtils.isEmpty(categoryAttributeList)) {
            throw new AttributeNotExistException(attrCode);
        }
        return categoryAttributeList.get(0);
    }

    /**
     * 如果分类编号 + 属性名称已经存在，则throw异常
     */
    private void repeatValidate(GcmCategoryAttribute gcmCategoryAttribute) {
        String attributeName = gcmCategoryAttribute.getName();
        String categoryId = gcmCategoryAttribute.getCategoryId();
        GcmCategoryAttributeExample categoryAttributeExample = new GcmCategoryAttributeExample();
        categoryAttributeExample.createCriteria()
                .andCategoryIdEqualTo(categoryId)
                .andNameEqualTo(attributeName);
        List<GcmCategoryAttribute> categoryAttributeList = categoryAttributeMapper.selectByExample(categoryAttributeExample);
        if (!CollectionUtils.isEmpty(categoryAttributeList)) {
            throw new RuntimeException(String.format("属性【%s】已经存在", attributeName));
        }
    }
}
