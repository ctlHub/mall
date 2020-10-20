package com.mall.common.utils;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

/**
 * 参数加密解密工具类
 *
 * @author 李重辰
 * @date 2020/9/25 11:20
 */
public class CryptoUtil {

    private final static String AES = "AES";

    /**
     * AES 字符串对称加密
     *
     * @param src 原文
     * @param key 秘钥
     * @return 密文
     */
    public static String aesEncrypt(String src, String key) {
        byte[] result = new byte[0];
        try {
            SecretKeySpec keySpec = getSecretKeySpec(key);
            // 初始化加密器
            Cipher cipher = Cipher.getInstance(AES);
            cipher.init(Cipher.ENCRYPT_MODE, keySpec);
            //加密
            byte[] byteContent = src.getBytes(StandardCharsets.UTF_8);
            result = cipher.doFinal(byteContent);
        } catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException | IllegalBlockSizeException | BadPaddingException e) {
            e.printStackTrace();
        }
        return parseByte2HexStr(result);
    }

    /**
     * AES 解密
     *
     * @param src 密文
     * @param key 秘钥
     * @return 原文
     */
    public static String aesDecrypt(String src, String key) {
        byte[] result1 = new byte[0];
        try {
            // 初始化解密器
            SecretKeySpec keySpec = getSecretKeySpec(key);
            Cipher cipher = Cipher.getInstance(AES);
            cipher.init(Cipher.DECRYPT_MODE, keySpec);
            //解密
            byte[] decryptFrom = parseHexStr2Byte(src);
            if (decryptFrom != null) {
                result1 = cipher.doFinal(decryptFrom);
            }
        } catch (NoSuchAlgorithmException | NoSuchPaddingException | BadPaddingException | IllegalBlockSizeException | InvalidKeyException e) {
            e.printStackTrace();
        }
        return new String(result1);
    }

    /**
     * 预配置
     */
    private static SecretKeySpec getSecretKeySpec(String key) throws NoSuchAlgorithmException {
        SecureRandom random = SecureRandom.getInstance("SHA1PRNG");
        random.setSeed(key.getBytes());
        KeyGenerator keyGenerator = KeyGenerator.getInstance(AES);
        keyGenerator.init(128, random);
        SecretKey secretKey = keyGenerator.generateKey();
        byte[] enCodeFormat = secretKey.getEncoded();
        return new SecretKeySpec(enCodeFormat, AES);
    }

    /**
     * 二进制转换成16进制，加密后的字节数组不能直接转换为字符串
     */
    private static String parseByte2HexStr(byte[] buf) {
        StringBuilder sb = new StringBuilder();
        for (byte b : buf) {
            String hex = Integer.toHexString(b & 0xFF);
            if (hex.length() == 1) {
                hex = '0' + hex;
            }
            sb.append(hex.toUpperCase());
        }
        return sb.toString();
    }

    /**
     * 16进制转换成二进制
     */
    private static byte[] parseHexStr2Byte(String hexStr) {
        if (hexStr.length() < 1) {
            return null;
        }
        byte[] result = new byte[hexStr.length() / 2];
        for (int i = 0; i < hexStr.length() / 2; i++) {
            int high = Integer.parseInt(hexStr.substring(i * 2, i * 2 + 1), 16);
            int low = Integer.parseInt(hexStr.substring(i * 2 + 1, i * 2 + 2), 16);
            result[i] = (byte) (high * 16 + low);
        }
        return result;
    }

}
