package com.mall.security.utils;

import org.springframework.core.io.ClassPathResource;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;

/**
 * @author 李重辰
 * @date 2020/11/23 1:22
 */
@SuppressWarnings("AlibabaClassNamingShouldBeCamel")
public class RSAKeyProvider implements com.auth0.jwt.interfaces.RSAKeyProvider {

  @Override
  public RSAPublicKey getPublicKeyById(String keyId) {
    PublicKey publicKey = null;
    ClassPathResource classPathResource = new ClassPathResource("id_key_rsa.pub");
    Path path = Paths.get(classPathResource.getPath());
    byte[] bytes;
    try {
      bytes = Files.readAllBytes(path);
      publicKey = RsaUtils.getPublicKey(bytes);
    } catch (Exception e) {
      e.printStackTrace();
    }
    return (RSAPublicKey) publicKey;
  }

  @Override
  public RSAPrivateKey getPrivateKey() {
    PrivateKey privateKey = null;
    ClassPathResource classPathResource = new ClassPathResource("application.properties");
    Path path = Paths.get(classPathResource.getPath());
    byte[] bytes;
    try {
      bytes = Files.readAllBytes(path);
      privateKey = RsaUtils.getPrivateKey(bytes);
    } catch (Exception e) {
      e.printStackTrace();
    }
    return (RSAPrivateKey) privateKey;
  }

  @Override
  public String getPrivateKeyId() {
    return "ctlHub";
  }
}
