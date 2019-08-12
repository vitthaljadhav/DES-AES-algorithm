package com.info;

import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

class AESencrypt {

	private static final String ALG = "AES";
	private static final byte[] keyValue = new byte[] { 't', 'h', 'e', 'g', 'r', 'a', 't', 'e', 'm', 'a', 'r', 'a', 't',
			'h', 'a' };

	public static byte[] encrypt(byte[] data) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
		Key key = generateKey();
		Cipher cipher = Cipher.getInstance(ALG);
        cipher.init(Cipher.ENCRYPT_MODE,key);
          byte[] encVal = cipher.doFinal(data);	
		return encVal;
	}
	
	public static byte[] decrypt(byte[] encryptData) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, GeneralSecurityException {
		
		Key key = generateKey();
	    Cipher cipher = Cipher.getInstance(ALG);
		cipher.init(Cipher.DECRYPT_MODE, key);
		byte[] decrptData = cipher.doFinal(encryptData);
	    return decrptData;
		
	}

	private static Key generateKey() {
		Key key = new SecretKeySpec(keyValue, ALG);
		return key;
	}
}

public class EnCrptArrayUsingDESAlo {
	public static void main(String[] args) throws Exception, NoSuchAlgorithmException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException {

		byte[] arrays =new byte[] {127,-128,0};
	 	byte[] encryptData = AESencrypt.encrypt(arrays);
	    byte[] decryptData = AESencrypt.decrypt(encryptData); 

		System.out.println("Plain Text :" + arrays);
		System.out.println("Encrypt Data: " + encryptData);
		System.out.println("Decrpt Data :" +new String(decryptData));
	}
}
