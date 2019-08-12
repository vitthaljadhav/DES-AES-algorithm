package com.info;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class AESAloEnc {

	public static void main(String[] args)
    {
        try
        {
            new AESAloEnc();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
   
    private AESAloEnc() throws NoSuchAlgorithmException
    {
        KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
        keyGenerator.init(256);
        SecretKey secretKey = keyGenerator.generateKey();
        byte[] aesKey = secretKey.getEncoded();
       
        String plainText = "Phantasm Technologies";
        System.out.println("Plain text: " + plainText);
       
        byte[] encryptedTextBytes = encrypt(plainText.getBytes(), aesKey);
        String encryptedText = Base64.getEncoder().encodeToString(encryptedTextBytes);
        System.out.println("Encrypted text: " + encryptedText);
       
        byte[] decryptedTextBytes = decrypt(Base64.getDecoder().decode(encryptedText), aesKey);
        String decryptedText = new String(decryptedTextBytes);
        System.out.println("Decrypted text: " + decryptedText);
    }
   
    private byte[] encrypt(byte[] bytesToEncrypt, byte[] key)
    {
        try
        {
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
           
            SecretKeySpec secretKeySpec = new SecretKeySpec(key, "AES");
           
            byte[] iv = new byte[16];
            SecureRandom secureRandom = new SecureRandom();
            secureRandom.nextBytes(iv);
            IvParameterSpec ivParameterSpec = new IvParameterSpec(iv);
           
            cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec, ivParameterSpec);
           
            byte[] cipherFinal = cipher.doFinal(bytesToEncrypt);
            byte[] encryptedBytes = new byte[cipherFinal.length + iv.length];
           
            for (int i = 0; i < iv.length; i++)
            {
                encryptedBytes[i] = iv[i];
            }
           
            for (int i = 0; i < cipherFinal.length; i++)
            {
                encryptedBytes[i + 16] = cipherFinal[i];
            }
           
            return encryptedBytes;
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return null;
        }
    }
   
    private byte[] decrypt(byte[] bytesToDecrypt, byte[] key)
    {
        try
        {
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
           
            SecretKeySpec secretKeySpec = new SecretKeySpec(key, "AES");
           
            byte[] iv = new byte[16];
           
            for (int i = 0; i < iv.length; i++)
            {
                iv[i] = bytesToDecrypt[i];
            }
           
            IvParameterSpec ivParameterSpec = new IvParameterSpec(iv);
           
            cipher.init(Cipher.DECRYPT_MODE, secretKeySpec, ivParameterSpec);
           
            byte[] cipherDecryptBytes = new byte[bytesToDecrypt.length - iv.length];
           
            for (int i = 0; i < cipherDecryptBytes.length; i++)
            {
                cipherDecryptBytes[i] = bytesToDecrypt[i + 16];
            }
           
            return cipher.doFinal(cipherDecryptBytes);
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return null;
        }
    }
}
