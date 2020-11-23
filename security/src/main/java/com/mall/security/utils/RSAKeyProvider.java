package com.mall.security.utils;

import com.mall.common.api.RsaKeyProperties;

import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;

/**
 * RSA秘钥提供器
 *
 * @author 李重辰
 * @date 2020/11/23 1:22
 */
@SuppressWarnings("AlibabaClassNamingShouldBeCamel")
public class RSAKeyProvider implements com.auth0.jwt.interfaces.RSAKeyProvider {

  private final RsaKeyProperties rsaKeyProperties;

  public RSAKeyProvider(RsaKeyProperties rsaKeyProperties) {
    this.rsaKeyProperties = rsaKeyProperties;
  }

  @Override
  public RSAPublicKey getPublicKeyById(String keyId) {
    return rsaKeyProperties.getPublicKey();
  }

  @Override
  public RSAPrivateKey getPrivateKey() {
    return rsaKeyProperties.getPrivateKey();
  }

  @Override
  public String getPrivateKeyId() {
    return "ctlHub";
  }
}
