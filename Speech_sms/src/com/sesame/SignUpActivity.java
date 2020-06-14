package com.sesame;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import com.HttpClient.CustomHttpClient;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.telephony.SmsManager;
import android.telephony.TelephonyManager;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class SignUpActivity extends Activity {
	EditText userid, pass, username, usergender, mast_pass, userphone,cpass,userphone2;
	Button btnCreateAccount;
	String valid_name = null;
	TextView exception;
	RadioGroup rg;
	RadioButton rb;

	String st = "True";
	String st1 = "False";
	
	String response="";

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		if (android.os.Build.VERSION.SDK_INT > 9)
		{
	  	    StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
	  	    StrictMode.setThreadPolicy(policy);
	  	}
		
		setContentView(R.layout.register);

		

	

		exception = (TextView) findViewById(R.id.validate);
		userid = (EditText) findViewById(R.id.loginid);
		pass = (EditText) findViewById(R.id.password);
		username = (EditText) findViewById(R.id.name);
		
		

		mast_pass = (EditText) findViewById(R.id.mast_pass); 
		userphone = (EditText) findViewById(R.id.mobile);
		userphone2 = (EditText) findViewById(R.id.mobile2);
		cpass = (EditText) findViewById(R.id.cpassword);

		
		username.addTextChangedListener(new TextWatcher()
		{

			@Override
			public void onTextChanged(CharSequence s, int start, int before,
					int count) {
			

			}

			@Override
			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {
				

			}

			@Override
			public void afterTextChanged(Editable s) {
			
				Is_Valid_Person_Name(username);
			}
		});

		

		btnCreateAccount = (Button) findViewById(R.id.reg);

		btnCreateAccount.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {

				
				String id = userid.getText().toString();
				String password = pass.getText().toString();
				String name = username.getText().toString();
				String mastpass = mast_pass.getText().toString();
				
				
				String phone = userphone.getText().toString();
				String phone2 = userphone2.getText().toString();
				String confiempass = cpass.getText().toString();

				System.out.println("Datas :" + id + "." + password + "." + name
						+ "." + "." + "." + phone); 

				
				
				Pattern pattern = Pattern.compile("\\d{10}");
				 Matcher matcher = pattern.matcher(phone);
				 
				if ("".equals(id)) {
					Toast.makeText(getApplicationContext(),
							"Please Enter User Id", Toast.LENGTH_LONG).show();
					return;
				}
				if ("".equals(password)) {
					Toast.makeText(getApplicationContext(),
							"Please Enter Password", Toast.LENGTH_LONG).show();
					return;
				}
				if ("".equals(confiempass)) {
					Toast.makeText(getApplicationContext(),
							"Please Enter Confirm Password", Toast.LENGTH_LONG).show();
					return;
				}
				if (name.equals("")) {
					Toast.makeText(getApplicationContext(),
							"Please Enter Name", Toast.LENGTH_LONG).show();
					return;
				}
				if (mastpass.equals("")) {
					Toast.makeText(getApplicationContext(),
							"Please Enter Master Password", Toast.LENGTH_LONG).show();
					return;
				}
				
				
				if (phone.equals(""))
				{
					Toast.makeText(getApplicationContext(),
							"Please,Enter Valid Mobile Number",
							Toast.LENGTH_LONG).show();
					return;
				}
				if (!matcher.matches()) 
				{
					Toast.makeText(getApplicationContext(),
							"Please,Enter Valid Mobile Number",
							Toast.LENGTH_LONG).show();
				}

				if(!(password.trim().equals(confiempass)))
				{
					Toast.makeText(getApplicationContext(),"Mismatch Both Password",Toast.LENGTH_LONG).show();
				}
				
				else {
					try {
						
						System.out.println("Start to Send");
						
						TelephonyManager tm = (TelephonyManager)getSystemService(Context.TELEPHONY_SERVICE);
						String device_id = tm.getDeviceId();

						ArrayList<NameValuePair> postParameters = new ArrayList<NameValuePair>();
						postParameters.add(new BasicNameValuePair("Id", id
								.trim()));
						postParameters.add(new BasicNameValuePair("Pass",
								password.trim()));
						postParameters.add(new BasicNameValuePair("Name", name
								.trim()));
						postParameters.add(new BasicNameValuePair("mastpass", mastpass
								.trim()));
						
						postParameters.add(new BasicNameValuePair("Mobile",
								phone.trim()));
						postParameters.add(new BasicNameValuePair("imei",
								device_id.trim()));
						postParameters.add(new BasicNameValuePair("Mobile2",
								phone2.trim()));
						

						System.out.println("List Of data :" + postParameters
								+ "Size :" + postParameters.size());

			 response = CustomHttpClient.executeHttpPost(Global.URL
								+ "speechsms/newuser.jsp", postParameters);
						

						System.out.println("Response :" + response.trim());
						
						
					
		 
		 
		 

						if(response.trim().equals("UserExist"))
						{
							Toast.makeText(getApplicationContext(),"User Already Exist ",Toast.LENGTH_LONG).show();
						}
						else
						{
							
				    String data[]=	response.trim().split("~");
				   String response1=		data[0];
				 
				 System.out.println("response1>>in android>>>>>>>>>>>>>>>>>>>>>>>>>"+response1);
				 String otpp=		data[1];
				 System.out.println("otp is>>in android>>>>>>>>>>>>>>>>>>>>>>>>>"+otpp.trim());
				 
				 
				 String otpmessage="Dear  "+name.trim()+" your OTP is "+otpp.trim();
				 
				   sendSMS(phone.trim(), otpmessage.trim());
					
						
						Toast.makeText(getApplicationContext(),
								"You have Registered Successfully  ",
								Toast.LENGTH_LONG).show();
						Intent i = new Intent(getApplicationContext(),
								MainPage.class);
						startActivity(i);
						
						
						}

					} catch (Exception e) {

						exception.setText(e.toString());
					}

					userid.setText("");
					pass.setText("");
					username.setText("");
					cpass.setText("");

					
					userphone.setText("");

				}

			}
		});

	}
	 public void sendSMS(String phoneNumber, String message) {
		    SmsManager sms = SmsManager.getDefault();
		    
		    System.out.println("phonenumner is>>>>>>>>>>>>>>>>>>"+phoneNumber);
		    
		    System.out.println("message>>>>>>>>>>>>>>>>>>"+message);
		    sms.sendTextMessage(phoneNumber, null, message, null, null);
		    
		    Toast.makeText(getApplicationContext(),	" SMS Sent Successfully",Toast.LENGTH_SHORT).show();
		}

	public void Is_Valid_Person_Name(EditText edt) throws NumberFormatException {
		if (edt.getText().toString().length() <= 0) {
			edt.setError("Accept Alphabets Only.");
			valid_name = null;
		} else if (!edt.getText().toString().matches("[a-zA-Z ]+")) {
			edt.setError("Accept Alphabets Only.");
			valid_name = null;
		} else {
			valid_name = edt.getText().toString();
		}

	}

}