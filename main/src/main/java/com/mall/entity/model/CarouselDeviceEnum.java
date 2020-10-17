package com.mall.entity.model;

/**
 * 首页上方轮播图
 * UI设备类型枚举类
 *
 * @author 李重辰
 * @date 2020/9/28 14:01
 */
public enum CarouselDeviceEnum {
    PC(0),
    PHONE(1);
    int code;

    public int getCode() {
        return code;
    }

    CarouselDeviceEnum(int code) {
        this.code = code;
    }
}
