package com.util;

import java.math.BigInteger;
import java.util.Random;

public class RandomValue {
	
	               /*Random Value Generation*/
	
		
	public static String  otpValue()
	{
		
		String values[] = new String[] { "1235","3456","2222","9997","8855","4445","3345","4485","3214","8765","9876","8976","6521","7612","5511","1254","3956","1188","6633"};
		Random random = new Random();
		
		int num=random.nextInt(values.length);
		//int n=random(values);
		//int m=random(values);
		//System.out.println("Ramdom Position Of Array :" +num +" Ramdom Array Value Of prime  : "+values[num]);
		return values[num];
		
	}
	
	
	
}
