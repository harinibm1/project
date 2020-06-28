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
		    String User = "abc";
		    String passwd = "abc123";
		    String sid = "abc";
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
        boolean flag = sendSMS("9786786543", "TEST SMS");
        if(flag)
            System.out.println("SMS Sent Successfully !");
        else
            System.out.println("SMS Sent Failure !");
    }
}