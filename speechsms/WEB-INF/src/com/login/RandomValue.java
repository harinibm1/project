package com.login;

import java.math.BigInteger;
import java.util.Random;

public class RandomValue {
	
	          
	
		
	public static String  otpValue()
	{
		
		String values[] = new String[] { "1235","3456","2222","9997","8855","4445","3345","4485","3214","8765","9876","8976","6521","7612","5511","1254","3956","1188","6633"};
		Random random = new Random();
		
		int num=random.nextInt(values.length);
		return values[num];
		
	}
	
	public static String  AESKeyValue()
	{
		
		String values[] = new String[] { "123abc45222aes55","678abc91123abc45","222aes55999sea77","999sea77888lll55","888lll55222aes55","444ccc45449jjj45","333kkk45999sea77","449jjj45444ccc45"};
		Random random = new Random();
		
		int num=random.nextInt(values.length);
		return values[num];
		
	}
	
}
