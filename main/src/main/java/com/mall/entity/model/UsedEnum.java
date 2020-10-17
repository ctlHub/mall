package com.mall.entity.model;

/**
 * 通用枚举类
 * 某记录的当前状态
 *
 * @author 李重辰
 * @date 2020/9/27 15:14
 */
public enum UsedEnum {

    /**
     * 禁用/停用
     */
    DISABLE(0),

    /**
     * 启用
     */
    ENABLE(1);
    int code;

    UsedEnum(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
