package com.mall.entity.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

/**
 * 商品图片路径
 *
 * @author 李重辰
 * @date 2020/9/22 20:51
 */
@Document(collection = "test_partInfo")
@Data
public class MongoPartInfo {
    @Id
    private String id;
    @Field("corpNo_")
    private String corpNo;
    @Field("iconImage_")
    private String iconImage;
    @Field("mainImages_")
    private List<String> mainImages;
    @Field("otherImages_")
    private List<String> otherImages;
    @Field("partCode_")
    private String partCode;
    @Field("sales_")
    private Integer sales;
}
