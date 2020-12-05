package com.mall.common.utils;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.core.io.ClassPathResource;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.nio.file.Files;
import java.security.NoSuchAlgorithmException;

/**
 * RSA加密工具测试类 {@link RsaUtils}
 *
 * @author 李重辰
 * @date 2020/11/23 23:18
 */
public class RSAUtilsTest {

  @Test
  void testGetPublicKey() throws IOException {
    ClassPathResource classPathResource = new ClassPathResource("id_key_rsa.pub");
    String s = Files.readString(classPathResource.getFile().toPath());
    Assertions.assertTrue(StringUtils.hasText(s), "公钥读取失败");
  }

  /**
   * 只有在需要重新生成RSA密钥时，才运行该方法
   */
  public void generateKey() throws IOException, NoSuchAlgorithmException {
    String secret = "ctlHub";
    String privateKeyPath = "C:\\my-learn\\mall\\security\\src\\main\\resources\\id_key_rsa.pri";
    String publicKeyPath = "C:\\my-learn\\mall\\common\\src\\main\\resources\\id_key_rsa.pub";
    RsaUtils.generateKey(publicKeyPath, privateKeyPath, secret, 0);
  }
}