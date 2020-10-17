package com.mall.entity.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import com.mall.mbg.model.GmsTag;

/**
 * @author 李重辰
 * @date 2020/9/9 10:29
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class GmsTagSearchParam extends GmsTag {
    /**
     * 模糊查询
     */
    private String searchText;

    /**
     * 记录条数
     */
    private Integer maxRecord;
}
