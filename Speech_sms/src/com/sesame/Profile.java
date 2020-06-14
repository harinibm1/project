package com.sesame;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import com.HttpClient.CustomHttpClient;



import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class Profile extends Activity
{
	SessionManager session;
	TextView userid,username,umobile;
	
	Button goback;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.profile);
		
		userid =(TextView) findViewById(R.id.id);
		username =(TextView) findViewById(R.id.name);
		
		umobile =(TextView) findViewById(R.id.mobile);
		goback = (Button) findViewById(R.id.back);
		
		goback.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v)
			{
				Intent i = new Intent(getApplicationContext(), HomeScreen.class);
				startActivity(i);
				
			}
		});
		
		session = new SessionManager(getApplicationContext());
	

		HashMap<String, String> user1 = session.getUserDetails();

	
		String userid1 = user1.get(SessionManager.KEY_NAME);
		
		try
	  	{
	  	
		String response = null;
		
		
		ArrayList<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
		nameValuePairs.add(new BasicNameValuePair("Userid", userid1));
		
		 response = CustomHttpClient.executeHttpPost(Global.URL+"speechsms/getuser.jsp", nameValuePairs);
		

	    String result = response.trim();
		System.out.println("Output From Android "+result);
		
		String[] getdata = result.split("~");
		System.out.println("Length "+getdata.length);
		
		userid.setText(getdata[0]);
		username.setText(getdata[1]);
		
		umobile.setText(getdata[2]);
		
		
	  	}
		catch(Exception e)
	  	{
	  		
	  		e.printStackTrace();
	  		System.out.println("First Spinner Exception"+e);
	  	}
		
		
	}

}
