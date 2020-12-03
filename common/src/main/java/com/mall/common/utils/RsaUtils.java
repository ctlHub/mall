package com.mall.common.utils;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

/**
 * RAS密码获取工具
 *
 * @author 李重辰
 * @date 2020/11/23 1:12
 */
public class RsaUtils {

  private static final int DEFAULT_KEY_SIZE = 2048;

  /**
   * 从文件中读取公钥
   *
   * @param filename 公钥保存路径，相对于classpath
   * @return 公钥对象
   */
  public static PublicKey getPublicKey(String filename) throws IOException, InvalidKeySpecException, NoSuchAlgorithmException {
    Resource classPathResource = new ClassPathResource(filename);
    InputStream inputStream = classPathResource.getInputStream();
    return getPublicKey(inputStream.readAllBytes());
  }

  /**
   * 从文件中读取密钥
   *
   * @param filename 私钥保存路径，相对于classpath
   * @return 私钥对象
   */
  public static PrivateKey getPrivateKey(String filename) throws IOException, InvalidKeySpecException, NoSuchAlgorithmException {
    Resource classPathResource = new ClassPathResource(filename);
    return getPrivateKey(Files.readAllBytes(classPathResource.getFile().toPath()));
  }

  /**
   * 获取公钥
   *
   * @param bytes 公钥的字节形式
   */
  private static PublicKey getPublicKey(byte[] bytes) throws NoSuchAlgorithmException, InvalidKeySpecException {
    bytes = Base64.getDecoder().decode(bytes);
    X509EncodedKeySpec spec = new X509EncodedKeySpec(bytes);
    KeyFactory factory = KeyFactory.getInstance("RSA");
    return factory.generatePublic(spec);
  }

  /**
   * 获取密钥
   *
   * @param bytes 私钥的字节形式
   */
  private static PrivateKey getPrivateKey(byte[] bytes) throws NoSuchAlgorithmException, InvalidKeySpecException {
    bytes = Base64.getDecoder().decode(bytes);
    PKCS8EncodedKeySpec spec = new PKCS8EncodedKeySpec(bytes);
    KeyFactory factory = KeyFactory.getInstance("RSA");
    return factory.generatePrivate(spec);
  }

  /**
   * 根据密文，生存rsa公钥和私钥,并写入指定文件
   *
   * @param publicKeyFilename  公钥文件路径
   * @param privateKeyFilename 私钥文件路径
   * @param secret             生成密钥的密文
   */
  static void generateKey(String publicKeyFilename, String privateKeyFilename, String secret, int keySize) throws NoSuchAlgorithmException, IOException {
    KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
    SecureRandom secureRandom = new SecureRandom(secret.getBytes());
    keyPairGenerator.initialize(Math.max(keySize, DEFAULT_KEY_SIZE), secureRandom);
    KeyPair keyPair = keyPairGenerator.genKeyPair();
    // 获取公钥并写出
    byte[] publicKeyBytes = keyPair.getPublic().getEncoded();
    publicKeyBytes = Base64.getEncoder().encode(publicKeyBytes);
    writeFile(publicKeyFilename, publicKeyBytes);
    // 获取私钥并写出
    byte[] privateKeyBytes = keyPair.getPrivate().getEncoded();
    privateKeyBytes = Base64.getEncoder().encode(privateKeyBytes);
    writeFile(privateKeyFilename, privateKeyBytes);
  }

  private static byte[] readFile(String fileName) throws IOException {
    return Files.readAllBytes(new File(fileName).toPath());
  }

  private static void writeFile(String destPath, byte[] bytes) throws IOException {
    File dest = new File(destPath);
    if (!dest.exists()) {
      //noinspection ResultOfMethodCallIgnored
      dest.createNewFile();
    }
    Files.write(dest.toPath(), bytes);
  }

}