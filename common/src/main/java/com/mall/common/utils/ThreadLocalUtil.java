package com.mall.common.utils;

import com.mall.common.exception.MissRequiredParamException;

import java.util.Optional;

/**
 * 操作当前线程的线程变量
 * <p>
 * 注意：
 * 1. 务必执行remove方法
 * 2. set方法的命名格式务必为 set + 参数首字母大写的驼峰命名；以便于在{@linkplain com.mall.config.CorpNoHandlerInterceptor}中使用反射初始化
 * eg：参数名称为 userCode，set方法应该为setUserCode(String userCode)
 *
 * @author 李重辰
 * @date 2020/9/12 16:26
 */
public class ThreadLocalUtil {
    private static final ThreadLocal<String> CORP_NO = new ThreadLocal<>();
    private static final ThreadLocal<String> USER_CODE = new ThreadLocal<>();

    public static void setMerchantId(String cropNo) {
        CORP_NO.set(cropNo);
    }

    public static void setUserCode(String userCode) {
        USER_CODE.set(userCode);
    }

    public static String getMerchant() {
        return Optional.ofNullable(CORP_NO.get()).orElseThrow(() -> new MissRequiredParamException("帐套代码不允许为空"));
    }

    public static String getUserCode() {
        return Optional.ofNullable(USER_CODE.get()).orElseThrow(() -> new MissRequiredParamException("用户代码不允许为空"));
    }

    /**
     * 务必在remove方法中清理执行所有ThreadLocal的remove方法
     */
    public static void remove() {
        CORP_NO.remove();
        USER_CODE.remove();
    }
}
