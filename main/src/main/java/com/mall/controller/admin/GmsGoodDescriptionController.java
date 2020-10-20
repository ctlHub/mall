package com.mall.controller.admin;

import com.mall.common.api.CommonResult;
import com.mall.common.utils.SnowflakeIdGenerator;
import com.mall.entity.dto.GmsGoodsDescParam;
import com.mall.mbg.model.GmsGoodsDescription;
import com.mall.service.GmsDescriptionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.util.StringUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 商品描述图片Controller
 *
 * @author 李重辰
 * @date 2020/9/27 15:19
 */
@RestController
@Api(tags = "商品描述图片维护")
@RequestMapping("/desc")
public class GmsGoodDescriptionController {

  private final GmsDescriptionService gmsDescriptionService;

  public GmsGoodDescriptionController(GmsDescriptionService gmsDescriptionService) {
    this.gmsDescriptionService = gmsDescriptionService;
  }

  @ApiOperation("根据料号查询相关商品图片")
  @PostMapping("/list")
  public CommonResult<List<GmsGoodsDescription>> list(@RequestParam String goodsCode) {
    if (StringUtils.isEmpty(goodsCode)) {
      return CommonResult.validateFailed("料号不允许为空");
    }
    List<GmsGoodsDescription> gmsGoodsDescriptions = gmsDescriptionService.list(goodsCode);
    return CommonResult.success(gmsGoodsDescriptions);
  }

  @ApiOperation("根据图片code查询说明的详细内容")
  @PostMapping("/get")
  public CommonResult<List<GmsGoodsDescription>> get(@RequestParam String code) {
    if (StringUtils.isEmpty(code)) {
      return CommonResult.validateFailed("描述编号不允许为空");
    }
    List<GmsGoodsDescription> gmsGoodsDescriptions = gmsDescriptionService.get(code);
    return gmsGoodsDescriptions == null ? CommonResult.failed() : CommonResult.success(gmsGoodsDescriptions);
  }

  @ApiOperation(value = "根据料号为某一商品新增一条说明信息", notes = "同步更新商品资料档中的fileNum栏位")
  @PostMapping("/insert")
  public CommonResult<String> insert(@RequestBody @Validated GmsGoodsDescParam goodsDescParam) {
    String descId = SnowflakeIdGenerator.genId();
    goodsDescParam.setCode(descId);
    Integer insert = gmsDescriptionService.insert(goodsDescParam);
    return insert == 1 ? CommonResult.success(descId) : CommonResult.failed();
  }

  @ApiOperation(value = "根据说明code删除一条说明信息", notes = "同步更新商品资料档中的fileNum栏位")
  @PostMapping("/delete")
  public CommonResult<Integer> delete(@RequestParam String code, @RequestParam String goodsCode) {
    Integer delete = gmsDescriptionService.delete(code, goodsCode);
    return CommonResult.success(delete);
  }

}
