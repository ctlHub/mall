package com.mall.entity.dto;

import com.mall.common.validate.UpdateGroup;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * 标签新增修改参数类
 *
 * @author 李重辰
 * @date 2020/9/9 10:29
 */
@Data
public class GmsTagParam {

    /**
     * 企业编号
     */
    @NotEmpty
    private String corpNo;

    /**
     * 标签代码（雪花Long）
     */
    @NotNull(groups = UpdateGroup.class)
    private String code;

    /**
     * 标签名称
     */
    @NotEmpty
    private String name;

    /**
     * 标签类型(选大类)
     */
    private String type;

    /**
     * 备注
     */
    private String remark;

}

