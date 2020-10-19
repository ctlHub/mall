package com.mall.controller.app;

import com.mall.common.api.CommonResult;
import com.mall.common.api.ResultCode;
import com.mall.entity.dto.GmcGoodsAttributeResult;
import com.mall.entity.dto.GmsGoodsSearchResult;
import com.mall.entity.dto.ProductDetailGoodsDetailVO;
import com.mall.mbg.model.GmsGoodsAndEshop;
import com.mall.service.GmsDescriptionService;
import com.mall.service.GmsGoodsAttributeService;
import com.mall.service.GmsGoodsBindService;
import com.mall.service.ProductDetailService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotEmpty;
import java.util.List;

/**
 * 商品详情页Controller
 *
 * @author 李重辰
 * @date 2020/9/23 10:30
 */
@RestController
@RequestMapping("/productDetail")
@Api(tags = "商品详情页")
@Validated
public class ProductDetailController {

  private final ProductDetailService productDetailService;
  private final GmsDescriptionService gmsDescriptionService;
  private final GmsGoodsAttributeService goodsAttributeService;
  private final GmsGoodsBindService goodsBindService;

  public ProductDetailController(ProductDetailService productDetailService, GmsDescriptionService gmsDescriptionService, GmsGoodsAttributeService goodsAttributeService, GmsGoodsBindService goodsBindService) {
    this.productDetailService = productDetailService;
    this.gmsDescriptionService = gmsDescriptionService;
    this.goodsAttributeService = goodsAttributeService;
    this.goodsBindService = goodsBindService;
  }

  @ApiOperation("获取商品详情")
  @GetMapping("/getGoodsDetail")
  public CommonResult<ProductDetailGoodsDetailVO> getGoodsDetail(@ApiParam("料号") @RequestParam @NotEmpty String code) {
    ProductDetailGoodsDetailVO goodsDetail = productDetailService.getGoodsDetail(code);
    return CommonResult.success(goodsDetail);
  }

  @ApiOperation("获取商品对应电商平台绑定的地址")
  @GetMapping("/listEshop")
  public CommonResult<List<GmsGoodsAndEshop>> listEshop(@ApiParam("料号") @RequestParam @NotEmpty String code) {
    List<GmsGoodsAndEshop> goodsAndEshopList = productDetailService.getEshop(code);
    if (goodsAndEshopList.size() == 0) {
      return CommonResult.failed(ResultCode.EMPTY);
    }
    return CommonResult.success(goodsAndEshopList);
  }

  @ApiOperation("查询商品说明图片地址")
  @GetMapping("/listDescription")
  public CommonResult<List<String>> listDescription(@ApiParam("料号") @RequestParam @NotEmpty String code) {
    List<String> imageList = gmsDescriptionService.listDescriptionContentForApp(code);
    if (imageList.size() == 0) {
      return CommonResult.failed(ResultCode.EMPTY);
    }
    return CommonResult.success(imageList);
  }

  @ApiOperation("查询商品属性")
  @GetMapping("/listAttr")
  public CommonResult<List<GmcGoodsAttributeResult>> listAttr(@ApiParam("料号") @RequestParam @NotEmpty String code) {
    return CommonResult.success(goodsAttributeService.listForApp(code));
  }

  @ApiOperation("查询绑定的商品（配件关联商品）")
  @GetMapping("/listBindGoods")
  public CommonResult<List<GmsGoodsSearchResult>> listBindGoods(@ApiParam("料号") @RequestParam @NotEmpty String code) {
    List<GmsGoodsSearchResult> goodsList = goodsBindService.getForApp(code);
    return CommonResult.success(goodsList);
  }
}
