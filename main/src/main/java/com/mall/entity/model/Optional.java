package com.mall.entity.model;

import lombok.Data;

import java.util.List;

/**
 * 商品的型号
 * <p>
 * 对应goods表中的option中的dataSet的body部分（当存在head时）
 *
 * @author 李重辰
 * @date 2020/9/23 10:49
 */
@Data
public class Optional {
    private String name;
    private List<String> option;
    private String default_;
}
