package com.mall.common.api;

import com.mall.common.utils.RsaUtils;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;

/**
 * RSA秘钥配置类
 *
 * @author 李重辰
 * @date 2020/11/23 23:55
 */
@Configuration(proxyBeanMethods = false)
@ConfigurationProperties(prefix = "rsa.key")
public class RsaKeyProperties {

  private String pubKeyFile;
  private String priKeyFile;
  private RSAPublicKey publicKey;
  private RSAPrivateKey privateKey;

  public RsaKeyProperties() {
  }

  private String getPubKeyFile() {
    return pubKeyFile;
  }

  public void setPubKeyFile(String pubKeyFile) {
    this.pubKeyFile = pubKeyFile;
  }

  private String getPriKeyFile() {
    return priKeyFile;
  }

  public void setPriKeyFile(String priKeyFile) {
    this.priKeyFile = priKeyFile;
  }

  public RSAPublicKey getPublicKey() {
    return publicKey;
  }

  private void setPublicKey(RSAPublicKey publicKey) {
    this.publicKey = publicKey;
  }

  public RSAPrivateKey getPrivateKey() {
    return privateKey;
  }

  private void setPrivateKey(RSAPrivateKey privateKey) {
    this.privateKey = privateKey;
  }

  @PostConstruct
  public void createRsaKey() throws Exception {
    publicKey = (RSAPublicKey) RsaUtils.getPublicKey(pubKeyFile);
    privateKey = (RSAPrivateKey) RsaUtils.getPrivateKey(priKeyFile);
  }

}
