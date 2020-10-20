package com.mall.controller.admin;

import com.mall.common.api.CommonResult;
import com.mall.entity.dto.GmsGoodsAndTagListResult;
import com.mall.entity.dto.GmsGoodsAndTagSearchParam;
import com.mall.mbg.model.GmsGoodsAndTag;
import com.mall.mbg.model.GmsTag;
import com.mall.service.GmsGoodsTagService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * 商品标签绑定Controller
 *
 * @author 李重辰
 * @date 2020/9/16 19:21
 */
@RestController
@Api(tags = "商品标签绑定管理")
@RequestMapping("/goodsTag")
public class GmsGoodsTagController {

  private final GmsGoodsTagService gmsGoodsTagService;

  public GmsGoodsTagController(GmsGoodsTagService gmsGoodsTagService) {
    this.gmsGoodsTagService = gmsGoodsTagService;
  }

  @ApiOperation("根据料号建立绑定关系，支持批量绑定")
  @PostMapping("/bind")
  public CommonResult<Integer> bind(@RequestBody List<GmsGoodsAndTag> params) {
    int count = gmsGoodsTagService.bind(params);
    return CommonResult.success(count);
  }

  @ApiOperation("取消标签绑定")
  @PostMapping("/cancelBind")
  public CommonResult<Integer> cancelBind(@RequestBody List<GmsGoodsAndTag> params) {
    int count = gmsGoodsTagService.cancelBind(params);
    return CommonResult.success(count);
  }

  @ApiOperation("查某一料号对应的商品绑定了哪些标签")
  @PostMapping("/listTag")
  public CommonResult<List<GmsTag>> listTag(@RequestBody Map<String, String> goodsCodeMap) {
    String goodsCode = goodsCodeMap.values().toArray(new String[1])[0];
    List<GmsTag> gmsTags = gmsGoodsTagService.listTag(goodsCode);
    return CommonResult.success(gmsTags);
  }

  @ApiOperation(value = "根据商品信息和标签信息，查询商品绑定了哪些标签", notes = "只查有绑定关系的")
  @PostMapping("/listGoodsAndTag")
  public CommonResult<List<GmsGoodsAndTagListResult>> listGoodsAndTag(@RequestBody GmsGoodsAndTagSearchParam searchParam) {
    List<GmsGoodsAndTagListResult> searchResults = gmsGoodsTagService.listGoodsAndTag(searchParam);
    return CommonResult.success(searchResults);
  }
}