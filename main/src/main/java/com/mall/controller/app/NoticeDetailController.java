package com.mall.controller.app;

import com.mall.common.api.CommonResult;
import com.mall.mbg.model.CmsNotice;
import com.mall.service.NoticeDetailService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 新闻公告列表页面和详情页面接口
 *
 * @author 李重辰
 * @date 2020/10/12 11:13
 */
@RestController
@RequestMapping("/notice")
@Api(tags = "新闻公告前端接口")
public class NoticeDetailController {

  final NoticeDetailService noticeDetailService;

  public NoticeDetailController(NoticeDetailService noticeDetailService) {
    this.noticeDetailService = noticeDetailService;
  }

  @ApiOperation("查询公告")
  @GetMapping("/get")
  public CommonResult<CmsNotice> get(String id) {
    return CommonResult.success(noticeDetailService.get(id));
  }

}
