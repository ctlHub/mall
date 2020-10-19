package com.mall.controller.admin;

import com.mall.common.api.CommonResult;
import com.mall.common.validate.CreateGroup;
import com.mall.common.validate.DeleteGroup;
import com.mall.common.validate.UpdateGroup;
import com.mall.entity.dto.GcmCategoryAttributeParam;
import com.mall.mbg.model.GcmCategoryAttribute;
import com.mall.service.GcmCateGoryAttributeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.util.StringUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Collections;
import java.util.List;

/**
 * 行业属性管理Controller
 *
 * @author 李重辰
 * @date 2020/10/15 13:36
 */
@RestController
@Api(tags = "商品分类属性管理")
@RequestMapping("/categoryAttr")
public class GcmCateGoryAttributeController {

    private final GcmCateGoryAttributeService cateGoryAttributeService;

    public GcmCateGoryAttributeController(GcmCateGoryAttributeService cateGoryAttributeService) {
        this.cateGoryAttributeService = cateGoryAttributeService;
    }

    @ApiOperation("根据地藤大类代码查大类有哪些属性")
    @PostMapping("/list")
    public CommonResult<List<GcmCategoryAttribute>> list(@RequestBody @Valid GcmCategoryAttributeParam categoryAttributeParam) {
        List<GcmCategoryAttribute> categoryAttributeList = cateGoryAttributeService.list(categoryAttributeParam);
        return CommonResult.success(categoryAttributeList);
    }

    @ApiOperation("查询某一属性的详情信息")
    @PostMapping("/get")
    public CommonResult<List<GcmCategoryAttribute>> get(@RequestParam("attrCode") String attrCode) {
        GcmCategoryAttribute categoryAttributeList = cateGoryAttributeService.get(attrCode);
        return CommonResult.success(Collections.singletonList(categoryAttributeList));
    }

    /**
     * 传入地藤大类代码和属性名称
     */
    @ApiOperation("新增")
    @PostMapping("/create")
    public CommonResult<String> create(@RequestBody @Validated(CreateGroup.class) GcmCategoryAttributeParam categoryAttributeParam) {
        String attrCode = cateGoryAttributeService.create(categoryAttributeParam);
        return StringUtils.isEmpty(attrCode) ? CommonResult.failed(String.format("新增失败:%s", categoryAttributeParam.toString())) : CommonResult.success(attrCode);
    }

    @ApiOperation("修改")
    @PostMapping("/update")
    public CommonResult<Integer> update(@RequestBody @Validated(UpdateGroup.class) GcmCategoryAttributeParam categoryAttributeParam) {
        Integer update = cateGoryAttributeService.update(categoryAttributeParam);
        return 1 == update ? CommonResult.success(1) : CommonResult.failed();
    }

    @ApiOperation(value = "删除", notes = "如果该属性与商品已经绑定过了，则不能删除")
    @PostMapping("/delete")
    public CommonResult<Integer> delete(@RequestBody @Validated(DeleteGroup.class) GcmCategoryAttributeParam categoryAttributeParam) {
        String attributeCode = categoryAttributeParam.getId();
        Integer delete = cateGoryAttributeService.delete(attributeCode);
        return 1 == delete ? CommonResult.success(1) : CommonResult.failed();
    }
}
