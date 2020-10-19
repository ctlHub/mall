package com.mall.controller.admin;

import com.mall.common.api.CommonResult;
import com.mall.common.validate.UpdateGroup;
import com.mall.entity.dto.GmsTagParam;
import com.mall.entity.dto.GmsTagSearchParam;
import com.mall.mbg.model.GmsTag;
import com.mall.service.GmsTagService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * 标签管理Controller
 *
 * @author 李重辰
 * @date 2020/9/14 11:36
 */
@RestController
@Api(tags = "标签管理")
@RequestMapping("/tag")
public class GmsTagController {

  private final GmsTagService gmsTagService;

  public GmsTagController(GmsTagService gmsTagService) {
    this.gmsTagService = gmsTagService;
  }

  @ApiOperation("创建新的标签")
  @PostMapping("/create")
  public CommonResult<String> create(@Validated @RequestBody GmsTagParam gmsTag) {
    return gmsTagService.create(gmsTag);
  }

  @ApiOperation(value = "根据标签code删除一个已经存在的标签", notes = "和商品的绑定记录也会被删除")
  @PostMapping("/delete")
  public CommonResult<Integer> delete(@NotNull String tagCode) {
    int i = gmsTagService.delete(tagCode);
    return CommonResult.success(i);
  }

  @ApiOperation("更新标签信息")
  @PostMapping("/update")
  public CommonResult<Integer> update(@Validated(UpdateGroup.class) @RequestBody GmsTagParam gmsTag) {
    int i = gmsTagService.update(gmsTag);
    return CommonResult.success(i);
  }

  @ApiOperation(value = "根据参数和查询条件，查询符合条件的标签", notes = "searchText支持name,type,remark等栏位模糊匹配")
  @PostMapping("/listTag")
  public CommonResult<List<GmsTag>> listTag(@RequestBody GmsTagSearchParam gmsTagSearchParam) {
    List<GmsTag> gmsTags = gmsTagService.listTag(gmsTagSearchParam);
    return CommonResult.success(gmsTags);
  }

  @ApiOperation("根据标签类型查询标签")
  @PostMapping("/listTagByType")
  public CommonResult<List<GmsTag>> listTagByType(@RequestBody GmsTag gmsTag) {
    List<GmsTag> gmsTags = gmsTagService.listTagByType(gmsTag);
    return CommonResult.success(gmsTags);
  }
}
