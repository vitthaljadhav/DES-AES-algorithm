package com.info;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

public class DESALOEnc {
	 public static void main(String []s)
	 {
	  
	  try
	  {
	   String st="going to Encrypted Mode";
	   System.out.println("Real String : "+ st); 
	   byte str[]=st.getBytes();
	   Cipher c=Cipher.getInstance("DES");
	   KeyGenerator kg=KeyGenerator.getInstance("DES");
	   SecretKey sk=kg.generateKey();
	   
	   //ENCRYPT_MODE
	   c.init(Cipher.ENCRYPT_MODE,sk);
	   byte ct[]=c.doFinal(str);
	   System.out.println("ENCRYPT_MODE DATA : "+ new String(ct));
	   
	      
	   //DECRYPT_MODE
	   c.init(Cipher.DECRYPT_MODE,sk);
	   byte ct1[]=c.doFinal(ct);
	   System.out.println("DECRYPT_MODE DATA : "+ new String(ct1));
	   
	   
	  }
	  catch(Exception e)
	  {
	   System.out.println(e);
	  }
	 }
}
