package com.sesame;

import java.io.BufferedReader;

import java.util.ArrayList;
import java.util.Locale;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import com.HttpClient.CustomHttpClient;
import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.speech.RecognizerIntent;
import android.telephony.TelephonyManager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;


public class Login1 extends Activity
{
	
	String userName="", passWord="";
	EditText username, password;
	String output1="";
	String result="";
	Button login;
	TextView textView;
	 SessionManager session;
	  private final int REQ_CODE_SPEECH_INPUT1 = 101;
	    
	    private final int REQ_CODE_SPEECH_INPUT2= 102;
	 String response = "";
	 String server = "";
	 String serveruid = "";
	 String serverpass = "";
	 
	 String c = "Valid User";
		String c1 = "InValid User";
		private ImageButton btnSpeak2;
		private ImageButton btnSpeak3;
	 
	//Called when the activity is first created. 
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login);
		
		if (android.os.Build.VERSION.SDK_INT > 9) {
			StrictMode.ThreadPolicy policy = 
			        new StrictMode.ThreadPolicy.Builder().permitAll().build();
			StrictMode.setThreadPolicy(policy);
			}
		session = new SessionManager(getApplicationContext());
		
		// UI elements gets bind in form of Java Objects
		username = (EditText) findViewById(R.id.loginid);
		password = (EditText) findViewById(R.id.password);
		login = (Button) findViewById(R.id.login);
		 btnSpeak2 = (ImageButton) findViewById(R.id.imageView1);
	        btnSpeak3 = (ImageButton) findViewById(R.id.imageView2);
		textView = (TextView) findViewById(R.id.exception);
		
		 btnSpeak2.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
				
					 promptSpeechInput1();
				}
			});
			  btnSpeak3.setOnClickListener(new OnClickListener() {
				
				  
				  
				@Override
				public void onClick(View v) {
					
					 promptSpeechInput2();
				}
			});
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
					;
						
						
						// Execute HTTP Post Request
						 try
						 {
							response = CustomHttpClient.executeHttpPost(Global.URL+"speechsms/checkuser.jsp", nameValuePairs);
							System.out.println("Output "+response.trim());
							 
							if(response.trim().equals(""))
							{
								Toast.makeText(getApplicationContext(), "InValid User", Toast.LENGTH_LONG).show();
								Intent i = new Intent(getApplicationContext(), Login1.class);
								startActivity(i);
							}else 							
							if(response.trim().equals("pending"))
							{
								Intent intent = new Intent(getApplicationContext(), OneTimePass.class);
								startActivity(intent);
							}
							
							 
							else if(response.trim().equalsIgnoreCase(c1.trim()))
							{
								Toast.makeText(getApplicationContext(), "InValid User", Toast.LENGTH_LONG).show();
								Intent i = new Intent(getApplicationContext(), Login1.class);
								startActivity(i);
							}else
							{
								System.out.println("==================");
								System.out.println("ukey :"+response);
								
								System.out.println("=================="); 
								
							
								String[] data=response.split("~");
								
								session.createLoginSession(userName,passWord,data[0],data[1]);
								
								Toast.makeText(getApplicationContext(), "User Logged In Successfully", Toast.LENGTH_LONG).show();
								Intent intent = new Intent(getApplicationContext(), HomeScreen.class);
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

	protected void promptSpeechInput2() {
		Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,
                RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault());
        intent.putExtra(RecognizerIntent.EXTRA_PROMPT,
                getString(R.string.speech_prompt));
        try {
            startActivityForResult(intent, REQ_CODE_SPEECH_INPUT2);
        } catch (ActivityNotFoundException a) {
            Toast.makeText(getApplicationContext(),
                    getString(R.string.speech_not_supported),
                    Toast.LENGTH_SHORT).show();
        }
		
	}

	protected void promptSpeechInput1() {
		Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,
                RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault());
        intent.putExtra(RecognizerIntent.EXTRA_PROMPT,
                getString(R.string.speech_prompt));
        try {
            startActivityForResult(intent, REQ_CODE_SPEECH_INPUT1);
        } catch (ActivityNotFoundException a) {
            Toast.makeText(getApplicationContext(),
                    getString(R.string.speech_not_supported),
                    Toast.LENGTH_SHORT).show();
        }
		
	}
	
@Override
protected void onActivityResult(int requestCode, int resultCode, Intent data) {
	// TODO Auto-generated method stub
	super.onActivityResult(requestCode, resultCode, data);
	
	switch (requestCode) {
   
    case REQ_CODE_SPEECH_INPUT1: {
        if (resultCode == RESULT_OK && null != data) {

            ArrayList<String> result = data
                    .getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
           
            username.setText(result.get(0));
        }
        break;
    }
    case REQ_CODE_SPEECH_INPUT2: {
        if (resultCode == RESULT_OK && null != data) {

            ArrayList<String> result = data
                    .getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
            password.setText(result.get(0));
        }
        break;
    }
}
	
}
	
    
}

