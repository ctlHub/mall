package com.mall.entity.dto;

import lombok.Data;

import java.util.List;

/**
 * 首页轮播图显示
 *
 * @author 李重辰
 * @date 2020/9/22 9:05
 */
@Data
public class IndexCarouselVO {
    private Integer switchTime;
    private List<String> imgList;
}
