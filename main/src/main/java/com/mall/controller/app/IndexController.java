package com.mall.controller.app;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.mall.common.api.ApiRestController;
import com.mall.common.api.CommonResult;
import com.mall.common.api.ResultCode;
import com.mall.entity.dto.IndexBrandVO;
import com.mall.entity.dto.IndexCarouselVO;
import com.mall.entity.dto.IndexClassVO;
import com.mall.entity.dto.IndexGoodsBlock;
import com.mall.entity.dto.IndexNoticeVO;
import com.mall.mbg.model.MmsMerchant;
import com.mall.service.IndexService;
import com.mall.service.MmsMerchantService;

import java.util.List;

import static com.mall.entity.model.SaleStatusEnum.promotion;

/**
 * 首页
 *
 * @author 李重辰
 * @date 2020/9/21 17:14
 */
@ApiRestController
@RequestMapping("/index")
@Api(tags = "首页")
public class IndexController {

    private final IndexService indexService;

    public IndexController(IndexService indexService, MmsMerchantService mmsMerchantService) {
        this.indexService = indexService;
        this.mmsMerchantService = mmsMerchantService;
    }

    @ApiOperation("商品类别")
    @GetMapping("/class")
    public CommonResult<List<IndexClassVO>> listClass() {
        List<IndexClassVO> indexClassResults = indexService.listClass();
        return CommonResult.success(indexClassResults);
    }

    @ApiOperation("根据大类查询子类")
    @GetMapping("/subClass/{className}")
    public CommonResult<List<IndexClassVO>> subClass(@PathVariable String className) {
        List<IndexClassVO> indexClassResults = indexService.listSubClass(className);
        return CommonResult.success(indexClassResults);
    }

    @ApiOperation("首页轮播图")
    @GetMapping("/listCarousel")
    public CommonResult<IndexCarouselVO> listCarousel(@RequestParam(required = false) Integer device) {
        IndexCarouselVO indexCarouselVO = indexService.listCarousel(device);
        return CommonResult.success(indexCarouselVO);
    }

    @ApiOperation("购物车当前商品数量")
    @GetMapping("/countCart")
    public CommonResult<Integer> countShopCartNum() {
        Integer goodsNum = indexService.countCart();
        return CommonResult.success(goodsNum);
    }

    @ApiOperation("收藏夹当前商品数量")
    @GetMapping("/countCollect")
    public CommonResult<Integer> collectionNum() {
        Integer collectNum = indexService.countCollect();
        return CommonResult.success(collectNum);
    }

    @ApiOperation("查询公告")
    @GetMapping("/listNotice")
    public CommonResult<List<IndexNoticeVO>> listNotice() {
        List<IndexNoticeVO> noticeList = indexService.listNotice();
        return CommonResult.success(noticeList);
    }

    @ApiOperation("列举品牌")
    @GetMapping("/listBrand")
    public CommonResult<List<IndexBrandVO>> listBrand() {
        List<IndexBrandVO> brandList = indexService.listBrand();
        return CommonResult.success(brandList);
    }

    private final MmsMerchantService mmsMerchantService;

    @ApiOperation("列举所有商家讯息")
    @GetMapping("/listMerchant")
    public CommonResult<List<MmsMerchant>> listMerchant() {
        List<MmsMerchant> merchantList = mmsMerchantService.listMerchant();
        return CommonResult.success(merchantList);
    }

    @ApiOperation("获得当前帐套的商家信息")
    @GetMapping("/getMerchant")
    public CommonResult<MmsMerchant> getMerchant() {
        MmsMerchant merchant = mmsMerchantService.getMerchant();
        return CommonResult.success(merchant);
    }

    @ApiOperation("查询某一促销块的中的商品信息")
    @GetMapping("/getGoodsBlock")
    public CommonResult<IndexGoodsBlock> getGoodsBlock(@RequestParam Integer saleStatus) {
        // 如果是促销则去另一个服务
        IndexGoodsBlock indexGoodsBlock;
        if (promotion.getCode() == saleStatus) {
            indexGoodsBlock = indexService.getPromotionGoodsBlockFromMongoDb(saleStatus);
        } else {
            indexGoodsBlock = indexService.getGoodsBlock(saleStatus);
        }
        if (CollectionUtils.isEmpty(indexGoodsBlock.getGoodsList())) {
            return CommonResult.failed(ResultCode.EMPTY, "无相关商品");
        }
        return CommonResult.success(indexGoodsBlock);
    }
}
