package com.mall.entity.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * 更新商品上架状态方法，参数封装
 *
 * @author 李重辰
 * @date 2020/9/8 17:26
 */
@Data
public class GoodsLowerShelfUpdateParam {
    @NotEmpty(message = "帐套代码不允许为空")
    private String merchantId;
    @NotNull
    private Boolean lowerShelf;
    @NotEmpty
    private List<String> codes;
}
