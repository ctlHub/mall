package com.mall.common.utils;

import org.junit.jupiter.api.Test;
import org.springframework.core.io.ClassPathResource;

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
    System.out.println(s);
  }

  @Test
  void generateKey() throws IOException, NoSuchAlgorithmException {
    String secret = "ctlHub";
    String privateKeyPath = "E:\\Idea-workspace\\mall\\security\\src\\main\\resources\\id_key_rsa.pri";
    String publicKeyPath = "E:\\Idea-workspace\\mall\\common\\src\\main\\resources\\id_key_rsa.pub";
    RsaUtils.generateKey(publicKeyPath, privateKeyPath, secret, 0);
  }
}