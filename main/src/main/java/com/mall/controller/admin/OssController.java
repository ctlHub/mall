package com.mall.controller.admin;

import com.google.gson.Gson;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.mall.common.api.ApiRestController;
import com.mall.common.api.CommonResult;
import com.mall.common.api.OssProperties;
import com.mall.common.utils.CryptoUtil;

/**
 * Oss配置查询接口
 *
 * @author 李重辰
 * @date 2020/9/25 10:03
 */
@ApiRestController
@Api(tags = "OSS配置查询")
@RequestMapping("/oss")
public class OssController {

    private final OssProperties ossProperties;

    public OssController(OssProperties ossProperties, Gson gson) {
        this.ossProperties = ossProperties;
        this.gson = gson;
    }

    private final Gson gson;

    @ApiOperation("获取OSS配置参数，结果集是AES对称加密的字符串")
    @PostMapping("getProperties")
    public CommonResult<String> getProperties() {
        ossProperties.setEndpoint("https://" + ossProperties.getEndpoint());
        String properties = gson.toJson(ossProperties);
        String ossProperties = CryptoUtil.aesEncrypt(properties, "ossProperties");
        return CommonResult.success(ossProperties);
    }

}
