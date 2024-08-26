package com.ruoyi.common.utils;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang3.StringUtils;

import javax.crypto.Cipher;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.security.SecureRandom;

public class AesGcmUtil {

    private static final int AES_KEY_SIZE = 256; // AES密钥大小，可以是128、192或256位
    private static final int GCM_TAG_LENGTH = 128; // GCM标签长度，通常为128位
    private static final int IV_LENGTH = 12; // 非随机初始化向量（IV）长度

    static final String SERVE_COMMON_RESULT_E_KEY = "2l6qWF^ToG%PI5yP";

    public static String decrypt(String data) {
        return new String(decrypt(Base64.decodeBase64(data), SERVE_COMMON_RESULT_E_KEY.getBytes(StandardCharsets.UTF_8)), StandardCharsets.UTF_8);
    }

    public static String encrypt(String data) {
        if (StringUtils.isEmpty(data)) {
            return null;
        }
        return Base64.encodeBase64String(encrypt(data.getBytes(StandardCharsets.UTF_8), SERVE_COMMON_RESULT_E_KEY.getBytes(StandardCharsets.UTF_8)));
    }

    /**
     * 使用AES-GCM加密数据
     *
     * @param data 待加密的数据
     * @param key  加密密钥
     * @return 加密后的数据，包含IV、密文和认证标签
     */
    public static byte[] encrypt(byte[] data, byte[] key) {
        try {
            // 生成一个随机的IV
            SecureRandom secureRandom = new SecureRandom();
            byte[] iv = new byte[IV_LENGTH];
            secureRandom.nextBytes(iv);

            SecretKeySpec secretKeySpec = new SecretKeySpec(key, "AES");
            Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");

            // 设置GCM参数，包括IV和标签长度
            GCMParameterSpec gcmParameterSpec = new GCMParameterSpec(GCM_TAG_LENGTH, iv);
            cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec, gcmParameterSpec);

            // 执行加密
            byte[] encryptedData = cipher.doFinal(data);

            // 将IV添加到密文前面
            ByteBuffer byteBuffer = ByteBuffer.allocate(IV_LENGTH + encryptedData.length);
            byteBuffer.put(iv);
            byteBuffer.put(encryptedData);
            return byteBuffer.array();
        } catch (Exception e) {
            throw new RuntimeException("加密失败", e);
        }
    }

    /**
     * 使用AES-GCM解密数据
     *
     * @param data 包含IV、密文和认证标签的加密数据
     * @param key  解密密钥
     * @return 解密后的原始数据
     */
    public static byte[] decrypt(byte[] data, byte[] key) {
        try {
            SecretKeySpec keySpec = new SecretKeySpec(key, "AES");
            ByteBuffer buffer = ByteBuffer.wrap(data);
            byte[] iv = new byte[IV_LENGTH];
            buffer.get(iv);
            GCMParameterSpec gcmParameterSpec = new GCMParameterSpec(GCM_TAG_LENGTH, iv);

            Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
            cipher.init(Cipher.DECRYPT_MODE, keySpec, gcmParameterSpec);

            return cipher.doFinal(buffer.array(), IV_LENGTH, buffer.limit() - IV_LENGTH);
        } catch (Exception e) {
            throw new RuntimeException("解密失败", e);
        }
    }
}