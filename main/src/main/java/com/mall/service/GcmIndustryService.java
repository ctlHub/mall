package com.mall.service;

import org.springframework.stereotype.Service;
import com.mall.common.utils.ModelUtils;
import com.mall.common.utils.SnowflakeIdGenerator;
import com.mall.dao.GcmIndustryDao;
import com.mall.mbg.model.GcmIndustry;

import javax.annotation.Resource;
import java.util.List;

/**
 * 行业管理Service
 *
 * @author 李重辰
 * @date 2020/10/15 9:56
 */
@Service
public class GcmIndustryService {

    @Resource
    private GcmIndustryDao industryDao;

    public Integer sync(List<GcmIndustry> list) {
        list.forEach((industry) -> {
            industry.setCode(SnowflakeIdGenerator.genId());
            ModelUtils.setCreateAndUpdateInfo(industry);
        });
        return industryDao.sync(list);
    }

}
