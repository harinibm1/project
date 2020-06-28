package com.util;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import java.security.*;
	import sun.misc.*;

	public class AES_CBC_encryption_Decryption {
	    
	     private static final String ALGO = "AES";
	    private static final byte[] keyValue = 
	        new byte[] { 'T', 'h', 'e', 'B', 'e', 's', 't',
	'S', 'e', 'c', 'r','e', 't', 'K', 'e', 'y' };

	public static String encrypt(String Data) throws Exception {
	        Key key = generateKey();
	        Cipher c = Cipher.getInstance(ALGO);
	        c.init(Cipher.ENCRYPT_MODE, key);
	        byte[] encVal = c.doFinal(Data.getBytes());
	       // System.out.println("/////"+c);
	        String encryptedValue = new BASE64Encoder().encode(encVal);
	        return encryptedValue;
	    }

	    public static String decrypt(String encryptedData) throws Exception {
	        Key key = generateKey();
	        Cipher c = Cipher.getInstance(ALGO);
	        c.init(Cipher.DECRYPT_MODE, key);
	        byte[] decordedValue = new BASE64Decoder().decodeBuffer(encryptedData);
	        byte[] decValue = c.doFinal(decordedValue);
	        String decryptedValue = new String(decValue);
	        return decryptedValue;
	    }
	    public static Key generateKey() throws Exception {
	        Key key = new SecretKeySpec(keyValue, ALGO);
	       // System.out.println("key is :"+key);
	        return key;
	}
	    public static void main(String[] args) throws Exception {
			AES_CBC_encryption_Decryption a=new AES_CBC_encryption_Decryption();
			String txt="test";
			
			String b=a.encrypt(txt);
			System.out.println("enc :"+b);
			String b1=a.decrypt(b);
			System.out.println("decrypt is :"+b1);
			
		}

	}
