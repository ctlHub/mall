package com.mall.entity.model;

import com.mall.common.exception.NotExistException;

/**
 * 商品类别，对应classify字段
 *
 * @author 李重辰
 * @date 2020/9/27 8:54
 */
public enum ClassifyEnum {

    /**
     * 普通商品
     */
    normal(0),

    /**
     * 型号商品
     */
    optional(1),

    /**
     * 子项商品
     */
    child(2);

    int code;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    ClassifyEnum(int code) {
        this.code = code;
    }

    public static ClassifyEnum getClassifyEnumByCode(int code) {
        for (ClassifyEnum classifyEnum : ClassifyEnum.values()) {
            if (code == classifyEnum.getCode()) {
                return classifyEnum;
            }
        }
        throw new NotExistException(code) {
            @Override
            protected String getType() {
                return "Classify";
            }
        };
    }
}
