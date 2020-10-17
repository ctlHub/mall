package com.mall.service;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import com.mall.common.utils.SnowflakeIdGenerator;
import com.mall.dao.GcmCategoryDao;
import com.mall.entity.dto.GcmCategorySyncParam;
import com.mall.mbg.mapper.GcmCategoryMapper;
import com.mall.mbg.mapper.GcmIndustryMapper;
import com.mall.mbg.model.GcmCategory;
import com.mall.mbg.model.GcmCategoryExample;
import com.mall.mbg.model.GcmIndustry;
import com.mall.mbg.model.GcmIndustryExample;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * 商品分类同步Service
 *
 * @author 李重辰
 * @date 2020/10/15 9:56
 */
@Service
public class GcmCategoryService {

    @Resource
    private GcmCategoryDao categoryDao;

    @Resource
    private GcmCategoryMapper categoryMapper;

    @Resource
    private GcmIndustryMapper industryMapper;

    /**
     * 地藤管家会传递行业名称、大类代码、大类名称
     * 数据表要存的是分类名称和行业代码(去行业基础表查询)和分类编号(我们生成)
     */
    @Transactional(rollbackFor = RuntimeException.class)
    public Integer sync(List<GcmCategorySyncParam> categoryParamList) {
        List<GcmCategory> categoryList = new ArrayList<>(categoryParamList.size());
        categoryParamList.forEach(syncParam -> {
            //1. 根据行业名称去行业基础表中取行业代码，如果没有，则提示先同步行业
            String industryName = syncParam.getIndustry();
            String industryCode = getIndustryCode(industryName);
            GcmCategory category = new GcmCategory();
            BeanUtils.copyProperties(syncParam, category);
            category.setIndustryCode(industryCode);
            //2. 用自己生成分类编号覆盖参数中传递过来的地藤的大类代码，将地藤的大类代码存到GcmCategory.ditengClassCode中
            category.setDitengClassCode(syncParam.getCode());
            category.setCode(SnowflakeIdGenerator.genId());
            categoryList.add(category);
        });
        return categoryDao.sync(categoryList);
    }

    public List<GcmCategory> list(String industryName) {
        String industryCode = getIndustryCode(industryName);
        GcmCategoryExample categoryExample = new GcmCategoryExample();
        categoryExample.createCriteria().andIndustryCodeEqualTo(industryCode);
        return categoryMapper.selectByExample(categoryExample);
    }

    private String getIndustryCode(String industryName) {
        GcmIndustryExample example = new GcmIndustryExample();
        example.createCriteria().andNameEqualTo(industryName);
        List<GcmIndustry> gcmIndustries = industryMapper.selectByExample(example);
        if (CollectionUtils.isEmpty(gcmIndustries)) {
            throw new RuntimeException(String.format("行业【%s】不存在，请先同步行业", gcmIndustries));
        }
        return gcmIndustries.get(0).getCode();
    }
}
