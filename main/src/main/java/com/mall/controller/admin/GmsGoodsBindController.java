package com.mall.controller.admin;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import com.mall.common.api.ApiRestController;
import com.mall.common.api.CommonResult;
import com.mall.entity.dto.GmsGoodsSearchParam;
import com.mall.mbg.model.GmsGoods;
import com.mall.mbg.model.GmsGoodsBind;
import com.mall.service.GmsGoodsBindService;

import java.util.List;

/**
 * 商品绑定后台管理接口
 *
 * @author 李重辰
 * @date 2020/10/9 10:33
 */
@ApiRestController
@Api(tags = "商品绑定管理")
@RequestMapping("/bind")
public class GmsGoodsBindController {

    private final GmsGoodsBindService goodsBindService;

    public GmsGoodsBindController(GmsGoodsBindService goodsBindService) {
        this.goodsBindService = goodsBindService;
    }

    @ApiOperation("根据主料号查询绑定的商品信息")
    @PostMapping("/get")
    public CommonResult<List<GmsGoods>> get(@RequestBody GmsGoodsBind gmsGoodsBind) {
        return CommonResult.success(goodsBindService.get(gmsGoodsBind.getPrimaryGoodsCode()));
    }

    @ApiOperation(value = "列出可以绑定的商品", notes = "排除已经和当前料号绑定过的商品，和型号商品")
    @PostMapping("/listBindableGoods")
    public CommonResult<List<GmsGoods>> listBindableGoods(@RequestBody GmsGoodsSearchParam gmsGoodsSearchParam) {
        return CommonResult.success(goodsBindService.listBindableGoods(gmsGoodsSearchParam));
    }

    @ApiOperation("新增一条商品的绑定记录")
    @PostMapping("/insert")
    public CommonResult<Integer> insert(@RequestBody List<GmsGoodsBind> bindMap) {
        int count = goodsBindService.insert(bindMap);
        return CommonResult.success(count);
    }

    @ApiOperation("删除一条商品的绑定记录")
    @PostMapping("/delete")
    public CommonResult<Integer> delete(@RequestBody List<GmsGoodsBind> bindMap) {
        int count = goodsBindService.delete(bindMap);
        return CommonResult.success(count);
    }

}
