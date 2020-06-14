package com.sesame;

import java.io.BufferedReader;
import java.util.ArrayList;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import com.HttpClient.CustomHttpClient;


import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainPage extends Activity 
{
	Button btnSignIn,btnSignUp,btnRecovery;
	

	String c = "Valid User";
	String c1 = "InValid User";
	
	 SessionManager session;
	 
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
	     super.onCreate(savedInstanceState);
	     setContentView(R.layout.main);

	    

	     // Get The Refference Of Buttons
	     btnSignIn=(Button)findViewById(R.id.login);
	     btnSignUp=(Button)findViewById(R.id.reg);
	     btnRecovery=(Button)findViewById(R.id.passrecovery);

	    // Set OnClick Listener on SignUp button 
	    btnSignUp.setOnClickListener(new View.OnClickListener() {
		public void onClick(View v) {
			// TODO Auto-generated method stub

			/// Create Intent for SignUpActivity  abd Start The Activity
			System.out.println("New User");
			Intent intentSignUP=new Intent(getApplicationContext(),SignUpActivity.class);
			startActivity(intentSignUP);
			}
		});
	    
	    
	    
	    
	    
	 // Set OnClick Listener on Log In button 
	    btnSignIn.setOnClickListener(new View.OnClickListener() {
		public void onClick(View v) {
			// TODO Auto-generated method stub

			/// Create Intent for SignUpActivity  abd Start The Activity
			System.out.println("User Login");
			
			Intent intentSignUP=new Intent(MainPage.this,Login1.class);
			startActivity(intentSignUP);
			}
		});
	    btnRecovery.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				// TODO Auto-generated method stub

				/// Create Intent for SignUpActivity  abd Start The Activity
				System.out.println("User Login");
				
				Intent intentSignUP=new Intent(MainPage.this,Login2.class);
				startActivity(intentSignUP);
				}
			});
	}
	
	
}