package com.mall.controller.admin;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.mall.common.api.ApiRestController;
import com.mall.common.api.CommonResult;
import com.mall.config.DataSetJsonRequestParam;
import com.mall.entity.dto.GcmCategorySyncParam;
import com.mall.mbg.model.GcmCategory;
import com.mall.service.GcmCategoryService;

import java.util.List;

/**
 * 行业大类Controller
 *
 * @author 李重辰
 * @date 2020/10/15 9:54
 */
@ApiRestController
@Api(tags = "商品分类管理")
@RequestMapping("/category")
public class GcmCategoryController {

    private final GcmCategoryService gcmCategoryService;

    public GcmCategoryController(GcmCategoryService gcmCategoryService) {
        this.gcmCategoryService = gcmCategoryService;
    }

    @ApiOperation(value = "大类同步接口", notes = "请传入 行业名称:industryName 和 大类代码:ditengClassCode 和 大类名称:name;参数名称\"category\" 请求体eg--> category = dataSet.getJson()")
    @PostMapping("/sync")
    public CommonResult<Integer> sync(@DataSetJsonRequestParam(value = "category", type = GcmCategorySyncParam.class) List<GcmCategorySyncParam> gcmCategoryList) {
        Integer sync = gcmCategoryService.sync(gcmCategoryList);
        return CommonResult.success(sync);
    }

    @ApiOperation("查询某个行业下有哪些大类")
    @PostMapping("/list")
    public CommonResult<List<GcmCategory>> list(@RequestParam("industry") String industryName) {
        List<GcmCategory> categoryList = gcmCategoryService.list(industryName);
        return CommonResult.success(categoryList);
    }
}
