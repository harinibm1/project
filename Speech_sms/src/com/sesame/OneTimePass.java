package com.sesame;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import com.HttpClient.CustomHttpClient;
import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class OneTimePass extends Activity
{
	
	String onetimepass="";
	
	EditText otp;
	String output1="";
	String result="";
	Button submit;
	TextView textView;
	
	 
	 String response = "";
	 
	 String c = "Valid User";
		String c1 = "InValid User";
	 
	 
	//Called when the activity is first created. 
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.onetimepass);
		
		
		
		
		otp = (EditText) findViewById(R.id.otp);
		
		submit = (Button) findViewById(R.id.submit);
		
		textView = (TextView) findViewById(R.id.validate);
		
	
		submit.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
			
				
				onetimepass = otp.getText().toString();
				
				
				if(onetimepass.equals(""))
				{
						Toast.makeText(getApplicationContext(), "Please,Enter Your One Time Password", Toast.LENGTH_LONG).show();
						return;
				}
				
				else
				{
					
					 BufferedReader in = null;
					
						System.out.println("Add Data");
						ArrayList<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
						
						nameValuePairs.add(new BasicNameValuePair("OTP", onetimepass));
						
						
						// Execute HTTP Post Request
						 try
						 {
							response = CustomHttpClient.executeHttpPost(Global.URL+"speechsms/checkotp.jsp", nameValuePairs);
							System.out.println("Output "+response.trim());
							
							if(response.trim().equalsIgnoreCase(c.trim()))
							{
								Toast.makeText(getApplicationContext(), "Get Into Your Home Page", Toast.LENGTH_LONG).show();
								Intent intent = new Intent(getApplicationContext(), Login1.class);
								startActivity(intent);
							}
							
							else if(response.trim().equalsIgnoreCase(c1.trim()))
							{
								Toast.makeText(getApplicationContext(), "InValid One Time Pass", Toast.LENGTH_LONG).show();
								Intent i = new Intent(getApplicationContext(), OneTimePass.class);
								startActivity(i);
							}
							
							otp.setText("");
							
						 
						 
						 } 
						 catch (Exception e)
						 {
							
							e.printStackTrace();
							textView.setText(e.toString());
						}
						
						
					
				}
				
			
					
					
	 
				} 
				
			
		});
	}
	

	
	
	
    
}

