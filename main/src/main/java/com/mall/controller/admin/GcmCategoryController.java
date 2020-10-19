package com.mall.controller.admin;

import com.mall.common.api.CommonResult;
import com.mall.config.DataSetJsonRequestParam;
import com.mall.entity.dto.GcmCategorySyncParam;
import com.mall.service.GcmCategoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 行业大类Controller
 *
 * @author 李重辰
 * @date 2020/10/15 9:54
 */
@RestController
@Api(tags = "商品分类管理")
@RequestMapping("/category")
public class GcmCategoryController {

    private final GcmCategoryService gcmCategoryService;

    public GcmCategoryController(GcmCategoryService gcmCategoryService) {
        this.gcmCategoryService = gcmCategoryService;
    }

    @ApiOperation(value = "大类同步接口", notes = "请传入 行业名称:industryName 和 大类代码:classCode 和 大类名称:name;参数名称\"category\" 请求体eg--> category = dataSet.getJson()")
    @PostMapping("/sync")
    public CommonResult<Integer> sync(@DataSetJsonRequestParam(value = "category", type = GcmCategorySyncParam.class) List<GcmCategorySyncParam> gcmCategoryList) {
        Integer sync = gcmCategoryService.sync(gcmCategoryList);
        return CommonResult.success(sync);
    }
}
