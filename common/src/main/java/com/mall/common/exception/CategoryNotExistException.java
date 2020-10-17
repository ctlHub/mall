package com.mall.common.exception;

/**
 * 商品类别不存在
 *
 * @author 李重辰
 * @date 2020/10/16 11:01
 */
public class CategoryNotExistException extends NotExistException {
    public CategoryNotExistException(Object message) {
        super(message);
    }

    @Override
    protected String getType() {
        return "商品类别";
    }
}
