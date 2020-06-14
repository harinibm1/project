// Decompiled by DJ v3.2.2.67 Copyright 2002 Atanas Neshkov  Date: 07/03/2011 11:50:32 AM
// Home Page : http://members.fortunecity.com/neshkov/dj.html  - Check often for new version!
// Decompiler options: packimports(3) 
// Source File Name:   Send_SMS_Service.java

package com.util;
import java.io.*;
import java.net.*;

public class Send_SMS_Service
{

    public Send_SMS_Service()
    {
    }

    public static boolean sendSMS(String mobilenumber, String message)
    {
        boolean flag = true;
        try
        {
        	String postData = "";
		    String retval = "";
		    String User = "blrstore";
		    String passwd = "dhscvs123";
		    String sid = "dhs";
		    String mtype = "N";
		    String DR = "Y";
		    
		    
		    postData = (new StringBuilder(String.valueOf(postData))).append("User=").append(URLEncoder.encode(User, "UTF-8")).append("&passwd=").append(passwd).append("&mobilenumber=").append(mobilenumber).append("&message=").append(URLEncoder.encode(message, "UTF-8")).append("&sid=").append(sid).append("&mtype=").append(mtype).append("&DR=").append(DR).toString();
		    System.out.println("PostDatas: "+postData);
		   
		    URL url = new URL("http://smscountry.com/SMSCwebservice.asp");
		    System.out.println("URL: "+url);
		    
		    HttpURLConnection urlconnection = (HttpURLConnection)url.openConnection();
		    urlconnection.setRequestMethod("POST");
		    
		    urlconnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
		    urlconnection.setDoOutput(true);
		    OutputStreamWriter out = new OutputStreamWriter(urlconnection.getOutputStream());
		    out.write(postData);
		    out.close();
		    BufferedReader in = new BufferedReader(new InputStreamReader(urlconnection.getInputStream()));
		    String decodedString;
		    while((decodedString = in.readLine()) != null) 
		        retval = (new StringBuilder(String.valueOf(retval))).append(decodedString).toString();
		    in.close();
		    System.out.println(retval);
		    
		 
        }
        catch(Exception e)
        {
            System.out.println(e);
            flag = false;
        }
        return flag;
    }

    public static void main(String args[])
        throws Exception
    {
        boolean flag = sendSMS("9886692401", "This is test sms from Praveen DHS");
        if(flag)
            System.out.println("SMS Sent Successfully !");
        else
            System.out.println("SMS Sent Failure !");
    }
}