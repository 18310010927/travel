package com.travelcc.utils;

import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class EncryptionUtils {

	// 加密解密测试，data为明文，key为密钥
	// private static final String key="9859832798641329";
	private static final String key = "N6AG2WHLH7QUNARG";

	/**
	 * 加密方法
	 * 
	 * @param data
	 * @throws Exception
	 */
	public static String encryption(String data) throws Exception {

		byte[] dataBytes = data.getBytes();

		byte[] keyBytes = key.getBytes();

		// 设置密钥及初始化向量（空白）

		IvParameterSpec iv = new IvParameterSpec(new byte[16]);

		SecretKey k = new SecretKeySpec(keyBytes, 0, keyBytes.length, "AES");

		// AES加密及BASE64编码

		Cipher c = Cipher.getInstance("AES/CBC/PKCS5Padding");

		c.init(Cipher.ENCRYPT_MODE, k, iv);

		byte[] encryptedBytes = c.doFinal(dataBytes);

		String encryptedString = Base64.getEncoder().encodeToString(encryptedBytes);

		System.out.println(encryptedString);
		return encryptedString;

	}

	/**
	 * 解密方法
	 * 
	 * @param data
	 * @return
	 * @throws Exception
	 */
	public static String deciphering(String data) throws Exception {
		byte[] dataBytes = data.getBytes();

		byte[] keyBytes = key.getBytes();
		// 设置密钥及初始化向量（空白）

		IvParameterSpec iv = new IvParameterSpec(new byte[16]);

		SecretKey k = new SecretKeySpec(keyBytes, 0, keyBytes.length, "AES");
		// AES加密及BASE64解码

		Cipher c = Cipher.getInstance("AES/CBC/PKCS5Padding");

		c.init(Cipher.DECRYPT_MODE, k, iv);

		String decryptedString = new String(c.doFinal(Base64.getMimeDecoder().decode(data)));
		// 修改Base64.getDecoder().decode(payload)
		// to==>Base64.getMimeDecoder().decode(data)

		System.out.println(decryptedString);
		return decryptedString;
	}

}