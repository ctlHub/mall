package com.mall.controller.admin;

import com.mall.common.api.CommonResult;
import com.mall.common.validate.UpdateGroup;
import com.mall.entity.dto.GmsGoodsEshopParam;
import com.mall.mbg.model.GmsGoodsAndEshop;
import com.mall.service.GmsGoodsEshopService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 商品与电商平台商品绑定的controller
 *
 * @author 李重辰
 * @date 2020/9/25 17:19
 */
@RestController
@Api(tags = "商品与电商平台商品绑定管理")
@RequestMapping("/eshop")
public class GmsGoodsEshopController {

  private final GmsGoodsEshopService goodsEshopService;

  public GmsGoodsEshopController(GmsGoodsEshopService goodsEshopService) {
    this.goodsEshopService = goodsEshopService;
  }

  @ApiOperation("根据料号列举商品与电商平台绑定记录")
  @PostMapping("/listByGoodsId")
  public CommonResult<List<GmsGoodsAndEshop>> listByGoodsId(@RequestBody GmsGoodsAndEshop goodsEshop) {
    List<GmsGoodsAndEshop> goodsAndEshopList = goodsEshopService.listByGoodsId(goodsEshop);
    return CommonResult.success(goodsAndEshopList);
  }

  @ApiOperation("新增一条绑定记录")
  @PostMapping("/insert")
  public CommonResult<Integer> insert(@RequestBody @Validated GmsGoodsEshopParam eshop) {
    Integer insert = goodsEshopService.insert(eshop);
    return insert == 1 ? CommonResult.success(insert) : CommonResult.failed("该平台已经存在绑定链接");
  }

  @ApiOperation("更新绑定记录")
  @PostMapping("/update")
  public CommonResult<Integer> update(@RequestBody @Validated(UpdateGroup.class) GmsGoodsEshopParam eshop) {
    Integer insert = goodsEshopService.update(eshop);
    return insert == 1 ? CommonResult.success(insert) : CommonResult.failed("该平台已经存在绑定链接");
  }

}
