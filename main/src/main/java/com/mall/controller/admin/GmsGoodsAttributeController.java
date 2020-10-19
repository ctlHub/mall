package com.mall.controller.admin;

import com.mall.common.api.CommonResult;
import com.mall.entity.dto.GmcGoodsAttributeResult;
import com.mall.entity.dto.GmsGoodsAttributeParam;
import com.mall.mbg.model.GmsGoodsAndAttribute;
import com.mall.service.GmsGoodsAttributeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

/**
 * 商品属性管理接口
 *
 * @author 李重辰
 * @date 2020/10/16 9:42
 */
@RestController
@Api(tags = "商品属性管理")
@RequestMapping("/goodsAttr")
public class GmsGoodsAttributeController {

  private final GmsGoodsAttributeService goodsAttributeService;

  public GmsGoodsAttributeController(GmsGoodsAttributeService goodsAttributeService) {
    this.goodsAttributeService = goodsAttributeService;
  }

  /**
   * 入参 商品编号和Class1的名称
   */
  @ApiOperation("根据商品编号查询商品属性")
  @PostMapping("/list")
  public CommonResult<List<GmcGoodsAttributeResult>> list(@Valid @RequestBody GmsGoodsAttributeParam goodsAttributeParam) {
    List<GmcGoodsAttributeResult> attributeList = goodsAttributeService.list(goodsAttributeParam);
    return CommonResult.success(attributeList);
  }

  @ApiOperation(value = "保存商品属性", notes = "对应属性如果有值则更新，无值则新增")
  @PostMapping("/save")
  public CommonResult<Integer> save(@RequestBody List<GmsGoodsAndAttribute> goodsAndAttributeList) {
    Integer count = goodsAttributeService.save(goodsAndAttributeList);
    return CommonResult.success(count);
  }
}
