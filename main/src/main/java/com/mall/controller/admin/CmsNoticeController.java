package com.mall.controller.admin;

import com.mall.common.api.CommonResult;
import com.mall.config.DataSetJsonRequestParam;
import com.mall.mbg.model.CmsNotice;
import com.mall.service.CmsNoticeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 公告管理Controller
 *
 * @author 李重辰
 * @date 2020/9/28 17:04
 */
@RestController
@Api(tags = "公告管理")
@RequestMapping("/notice")
public class CmsNoticeController {

  private final CmsNoticeService noticeService;

  public CmsNoticeController(CmsNoticeService cmsNoticeService) {
    this.noticeService = cmsNoticeService;
  }

  @ApiOperation("公告同步")
  @PostMapping(value = "/sync")
  public CommonResult<Integer> sync(@DataSetJsonRequestParam(value = "notice", type = CmsNotice.class) List<CmsNotice> noticeList) {
    int count = noticeService.sync(noticeList);
    return CommonResult.success(count);
  }

  @ApiOperation("删除公告")
  @PostMapping(value = "/delete")
  public CommonResult<Integer> delete(@RequestBody CmsNotice cmsNotice) {
    int delete = noticeService.delete(cmsNotice);
    return CommonResult.success(delete);
  }

}
