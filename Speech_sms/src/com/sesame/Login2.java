package com.sesame;

import java.io.BufferedReader;
import java.util.ArrayList;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import com.HttpClient.CustomHttpClient;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.telephony.TelephonyManager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class Login2 extends Activity
{
	
	String userName="", passWord="";
	EditText username, password;
	String output1="";
	String result="";
	Button login;
	TextView textView;
	 SessionManager session;
	 
	 String response = "";
	 String server = "";
	 String serveruid = "";
	 String serverpass = "";
	 
	 String c = "Valid User";
		String c1 = "InValid User";
	 

	 
	//Called when the activity is first created. 
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.recovery);
		
		if (android.os.Build.VERSION.SDK_INT > 9) {
			StrictMode.ThreadPolicy policy = 
			        new StrictMode.ThreadPolicy.Builder().permitAll().build();
			StrictMode.setThreadPolicy(policy);
			}
		session = new SessionManager(getApplicationContext());
		
		
		username = (EditText) findViewById(R.id.loginid);
		password = (EditText) findViewById(R.id.password);
		login = (Button) findViewById(R.id.login);
		
		textView = (TextView) findViewById(R.id.exception);
		
	
		login.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				
				userName = username.getText().toString();
				passWord = password.getText().toString();
				
				 
				
				
				if(userName.equals(""))
				{
						Toast.makeText(getApplicationContext(), "Please,Enter User Id", Toast.LENGTH_LONG).show();
						return;
				}
				if(passWord.equals(""))
				{
						Toast.makeText(getApplicationContext(), "Please,Enter User Password", Toast.LENGTH_LONG).show();
						return;
				}
				else
				{
					
					TelephonyManager tm = (TelephonyManager)getSystemService(Context.TELEPHONY_SERVICE);
					String device_id = tm.getDeviceId();
					
					 BufferedReader in = null;
					
						System.out.println("Add Data");
						ArrayList<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
						
						nameValuePairs.add(new BasicNameValuePair("Name", userName));
						nameValuePairs.add(new BasicNameValuePair("Pass", passWord));
						nameValuePairs.add(new BasicNameValuePair("imei", device_id));
					
						
						
						// Execute HTTP Post Request
						 try
						 {
							response = CustomHttpClient.executeHttpPost(Global.URL+"speechsms/checkuser2.jsp", nameValuePairs);
							System.out.println("Output "+response.trim());
							 
							if(response.trim().equals(""))
							{
								Toast.makeText(getApplicationContext(), "InValid User", Toast.LENGTH_LONG).show();
								Intent i = new Intent(getApplicationContext(), Login1.class);
								startActivity(i);
							}else 							
										{
								Bundle bundle = new Bundle();
								Intent intent = new Intent(getApplicationContext(), OneTimePass2.class);
								bundle.putString("userid", userName);
								intent.putExtras(bundle);
								startActivity(intent);
							}
							
							 
						
							username.setText("");
							password.setText("");
						 
						 
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

