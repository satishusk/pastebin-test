package com.example.postebintest.service.generator.identifier;

import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class HashGenerator implements IdentifierGenerator {
  private final MessageDigest md5;

  public HashGenerator() {
    try {
      md5 = MessageDigest.getInstance("MD5");
    } catch (NoSuchAlgorithmException e) {
      throw new RuntimeException(e);
    }
  }

  @Override
  public String generate(SharedSessionContractImplementor sharedSessionContractImplementor, Object o) {
    String hashcodeStr = String.valueOf(requiredHashcode(o).hashCode());
    byte[] hashcodeStrBytes = hashcodeStr.getBytes(StandardCharsets.UTF_8);
    byte[] generatedHash = md5.digest(hashcodeStrBytes);
    return hexView(generatedHash);
  }

  private Object requiredHashcode(Object o) {
    if (o == null) {
      o = new Object() {
        @Override
        public int hashCode() {
          return 0;
        }
      };
    }
    return o;
  }

  private String hexView(byte[] bytes) {
    StringBuilder builder = new StringBuilder();
    for (byte b : bytes) {
      builder.append(hexView(b));
    }
    return builder.toString();
  }

  private String hexView(byte b) {
    return Integer.toHexString((b & 0xFF) | 0x100).substring(1, 3);
  }
}
