package com.mall.controller.admin;

import com.mall.common.api.CommonResult;
import com.mall.mbg.model.CmsIndexSalesAd;
import com.mall.service.CmsIndexSalesAdService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 首页促销图维护Controller
 *
 * @author 李重辰
 * @date 2020/9/28 9:47
 */
@RestController
@Api(tags = "首页促销图片管理")
@RequestMapping("/indexSalesAd")
public class CmsIndexSalesAdController {

    final CmsIndexSalesAdService salesAdService;

    public CmsIndexSalesAdController(CmsIndexSalesAdService salesAdService) {
        this.salesAdService = salesAdService;
    }

    @ApiOperation(value = "查询所有的促销图", notes = "salesStatus如果有值则查询特定促销类型的促销图")
    @PostMapping("/list")
    public CommonResult<List<CmsIndexSalesAd>> list(@RequestParam(required = false) Integer salesStatus) {
        return CommonResult.success(salesAdService.list(salesStatus));
    }

    @ApiOperation("新增促销类别的宣传图")
    @PostMapping("/save")
    public CommonResult<Integer> save(@RequestBody CmsIndexSalesAd indexSalesAd) {
        Integer save = salesAdService.save(indexSalesAd);
        return save == 1 ? CommonResult.success(save) : CommonResult.failed();
    }

    @ApiOperation("删除某一促销类别的宣传图")
    @PostMapping("/delete")
    public CommonResult<Integer> delete(@ApiParam(required = true, value = "促销类型代码") @RequestParam Integer salesStatus) {
        Integer delete = salesAdService.delete(salesStatus);
        return delete == 1 ? CommonResult.success(delete) : CommonResult.failed();
    }

}
