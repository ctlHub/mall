package com.mall.controller.admin;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import com.mall.common.api.ApiRestController;
import com.mall.common.api.CommonResult;
import com.mall.config.DataSetJsonRequestParam;
import com.mall.entity.dto.GmsGoodsSearchParam;
import com.mall.entity.dto.GoodsLowerShelfUpdateParam;
import com.mall.mbg.model.GmsGoods;
import com.mall.service.GmsGoodsService;

import java.util.List;

/**
 * 商品管理Controller
 *
 * @author 李重辰
 * @date 2020/9/7 14:16
 */
@ApiRestController
@Api(tags = "商品管理")
@RequestMapping("/goods")
public class GmsGoodsController {

    private final GmsGoodsService gmsGoodsService;

    public GmsGoodsController(GmsGoodsService goodsService) {
        this.gmsGoodsService = goodsService;
    }

    @ApiOperation("将地藤管家商品资料同步过来")
    @PostMapping(value = "/syncGoods")
    public CommonResult<Integer> syncGoods(@DataSetJsonRequestParam(value = "goods", type = GmsGoods.class) List<GmsGoods> goodsList) {
        int count = gmsGoodsService.syncGoods(goodsList);
        return CommonResult.success(count);
    }

    @ApiOperation("更新商品上下架的状态")
    @PostMapping(value = "/updateGoodsSellStatus")
    public CommonResult<Integer> updateGoodsSellStatus(@Validated @RequestBody GoodsLowerShelfUpdateParam dto) {
        int count = gmsGoodsService.updateGoodsSellStatus(dto);
        return CommonResult.success(count);
    }

    @ApiOperation("根据参数查询商品资料")
    @PostMapping("/listGoods")
    public CommonResult<List<GmsGoods>> listGoods(@RequestBody GmsGoodsSearchParam goodsSearchParam) {
        List<GmsGoods> goods = gmsGoodsService.listGoods(goodsSearchParam);
        return CommonResult.success(goods);
    }

    @ApiOperation("更新虚拟库存")
    @PostMapping("/updateVirtualStock")
    public CommonResult<Integer> updateVirtualStock(@RequestBody List<GmsGoods> params) {
        int count = gmsGoodsService.updateVirtualStock(params);
        return CommonResult.success(count);
    }

}
