package com.mall.controller.admin;

import com.mall.common.api.CommonResult;
import com.mall.mbg.model.CmsIndexCarousel;
import com.mall.service.CmsCarouselService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotEmpty;
import java.util.List;

/**
 * 首页广告图维护Controller
 *
 * @author 李重辰
 * @date 2020/9/28 9:47
 */
@RestController
@Api(tags = "首页轮播图管理")
@RequestMapping("/carousel")
public class CmsIndexCarouselController {

  final CmsCarouselService carouselService;

  public CmsIndexCarouselController(CmsCarouselService carouselService) {
    this.carouselService = carouselService;
  }

  @ApiOperation(value = "获取所有首页轮播图", notes = "传入imgCode可以获得对应的图片详细信息")
  @PostMapping("/list")
  public CommonResult<List<CmsIndexCarousel>> list(@ApiParam(name = "imgCode", value = "图片编号")
                                                   @RequestParam(required = false) String imgCode) {
    return CommonResult.success(carouselService.list(imgCode));
  }

  @ApiOperation("新增一张轮播图")
  @PostMapping("/insert")
  public CommonResult<Integer> insert(@RequestBody CmsIndexCarousel indexCarousel) {
    return CommonResult.success(carouselService.insert(indexCarousel));
  }

  @ApiOperation("删除一张轮播图")
  @PostMapping("/delete")
  public CommonResult<Integer> delete(@ApiParam(name = "imgCode", value = "图片编号")
                                      @RequestParam @NotEmpty String imgCode) {
    return CommonResult.success(carouselService.delete(imgCode));
  }

}
