package com.mall.controller.app;

import com.github.pagehelper.PageInfo;
import com.mall.common.api.CommonResult;
import com.mall.entity.dto.GmsGoodsSearchParam;
import com.mall.entity.dto.GmsGoodsSearchResult;
import com.mall.mbg.model.CmsNotice;
import com.mall.service.SearchService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 前端查询接口
 *
 * @author 李重辰
 * @date 2020/9/23 17:34
 */
@RestController
@RequestMapping("/search")
@Api(tags = "查询接口")
public class SearchController {
    final SearchService searchService;

    public SearchController(SearchService searchService) {
        this.searchService = searchService;
    }

    @ApiOperation(value = "根据参数分页查询商品信息",
            notes = "desc和spec支持模糊匹配，searchText支持code_、desc_、spec、py_code、barcode、old_barcode、id_code、box_code等栏位模糊匹配")
    @PostMapping("")
    public CommonResult<PageInfo<GmsGoodsSearchResult>> listGoods(@RequestBody GmsGoodsSearchParam goodsSearchParam,
                                                                  @ApiParam("页码") @RequestParam(value = "pn", defaultValue = "1") Integer pageNum,
                                                                  @ApiParam("一页数据量") @RequestParam(value = "ps", defaultValue = "50") Integer pageSize,
                                                                  @ApiParam("导航栏显示几页") @RequestParam(value = "nav", defaultValue = "10") Integer navigatePages) {
        List<GmsGoodsSearchResult> goods = searchService.listGoods(goodsSearchParam, pageNum, pageSize);
        PageInfo<GmsGoodsSearchResult> pageInfo = new PageInfo<>(goods, navigatePages);
        return CommonResult.success(pageInfo);
    }

    @ApiOperation(value = "分页查询新闻公告")
    @GetMapping("/listNotice")
    public CommonResult<PageInfo<CmsNotice>> listNotice(@ApiParam("页码") @RequestParam(value = "pn", defaultValue = "1") Integer pageNum,
                                                        @ApiParam("一页数据量") @RequestParam(value = "ps", defaultValue = "50") Integer pageSize,
                                                        @ApiParam("导航栏显示几页") @RequestParam(value = "nav", defaultValue = "10") Integer navigatePages) {
        List<CmsNotice> notices = searchService.listNotice(pageNum, pageSize);
        PageInfo<CmsNotice> pageInfo = new PageInfo<>(notices, navigatePages);
        return CommonResult.success(pageInfo);
    }
}
