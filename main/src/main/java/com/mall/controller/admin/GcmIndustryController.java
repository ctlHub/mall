package com.mall.controller.admin;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.mall.common.api.ApiRestController;
import com.mall.common.api.CommonResult;
import com.mall.config.DataSetJsonRequestParam;
import com.mall.mbg.model.GcmIndustry;
import com.mall.service.GcmIndustryService;

import java.util.List;

/**
 * 行业管理
 *
 * @author 李重辰
 * @date 2020/10/15 11:03
 */
@ApiRestController
@Api(tags = "行业管理")
@RequestMapping("/industry")
public class GcmIndustryController {

    private final GcmIndustryService industryService;

    public GcmIndustryController(GcmIndustryService industryService) {
        this.industryService = industryService;
    }

    /**
     * 地藤管家，行业大类同步接口 partClass
     */
    @ApiOperation(value = "行业同步", notes = "一个list中存放大类名称，参数名为\"industry\"；请求体eg--> industry = dataSet.getJson()")
    @PostMapping("/sync")
    public CommonResult<Integer> sync(@DataSetJsonRequestParam(value = "industry", type = GcmIndustry.class) List<GcmIndustry> industryList) {
        Integer sync = industryService.sync(industryList);
        return CommonResult.success(sync);
    }
}
