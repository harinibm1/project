package com.sesame;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import com.HttpClient.CustomHttpClient;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class OTPCheck extends Activity
{
	private EditText result;
	String pass=null;
	EditText txt1,txt2,txt3;
	Button btn;
	String currpass="";
	String newpass="";
	String conpass="";
	SessionManager session;
	 String name ;
	 String uname;
@Override
protected void onCreate(Bundle savedInstanceState) {
	
	super.onCreate(savedInstanceState);
	setContentView(R.layout.change_masterpass);
	final Context context = this;
	// get prompts.xml view
	LayoutInflater li = LayoutInflater.from(context);
	View promptsView = li.inflate(R.layout.prompts, null);

	AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
			context);

	// set prompts.xml to alertdialog builder
	alertDialogBuilder.setView(promptsView);

	final EditText userInput = (EditText) promptsView.findViewById(R.id.editTextDialogUserInput);

	// set dialog message
	alertDialogBuilder
		.setCancelable(false)
		.setPositiveButton("OK",
		  new DialogInterface.OnClickListener() {
		    public void onClick(DialogInterface dialog,int id) {
			// get user input and set it to result
		
		    	String otp=userInput.getText().toString();
		    	System.out.println("OTP is :"+otp);
		    	
		    	Bundle bundle = getIntent().getExtras();

		    
		    	 pass = bundle.getString("otp");
			
		    	
		    	if(pass.equals(otp))
		    	{
		    		txt1=(EditText) findViewById(R.id.current_pass);
		    		txt2=(EditText) findViewById(R.id.new_password);
		    		txt3=(EditText) findViewById(R.id.confirm_password);
		    		btn=(Button) findViewById(R.id.changebtn);
		    		
		    		 session = new SessionManager(getApplicationContext());
		    	   
		    	        
		    	        HashMap<String, String> user = session.getUserDetails();
		    	        
		    	       
		    	         name = user.get(SessionManager.KEY_KEY);
		    	         uname=user.get(SessionManager.KEY_NAME);
		    	         System.out.println("uname in otp check>>>>>>>>>>>>>>>>>>>>>>"+uname);
		    		
		    		btn.setOnClickListener(new OnClickListener() {
						
						@Override
						public void onClick(View v) {
							
							currpass=txt1.getText().toString();
							System.out.println("current password is >>>>>>>>>>>>>>>>>>>>>"+currpass);
				    		newpass=txt2.getText().toString();
				    		
				    		System.out.println("newpass >>>>>>>>>>>>>>>>>>>>>"+newpass);
				    		conpass=txt3.getText().toString();
				    		System.out.println("conpass >>>>>>>>>>>>>>>>>>>>>"+conpass);

							if ((currpass.equals("") || newpass.length() == 0)&& (newpass.equals(""))&& (conpass.equals("") || conpass.length() == 0))
							{
								Toast.makeText(getApplicationContext(),	" Please Enter All the Fields ",Toast.LENGTH_SHORT).show();
								
							}
						
							else if("".equals(currpass))
							{
								
								Toast.makeText(getApplicationContext(),	" Please Enter Current Password ",Toast.LENGTH_SHORT).show();
							}
							else if("".equals(newpass))
							{
								Toast.makeText(getApplicationContext(),	" Please Enter New Password ",Toast.LENGTH_SHORT).show();
							}
							else if("".equals(conpass))
							{
								
								Toast.makeText(getApplicationContext(),	" Please Enter Confirm Password ",Toast.LENGTH_SHORT).show();
							}
							else if(!newpass.equals(conpass))
							{
								
								Toast.makeText(getApplicationContext(),	" New Password and Confirm Password Mismatch ",Toast.LENGTH_SHORT).show();
							}
							else if(!currpass.equals(name))
							{
								
								Toast.makeText(getApplicationContext(),	" Old Master and New Master Password Mismatch ",Toast.LENGTH_SHORT).show();
							}


							else if ( (currpass.length() > 0)&& ( conpass.length() > 0 )&& ( newpass.length() > 0 )) 
							{

								try {
									
									
									
									ArrayList<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
									nameValuePairs.add(new BasicNameValuePair("uid", uname));
									nameValuePairs.add(new BasicNameValuePair("mastpass", conpass));
									String response = CustomHttpClient.executeHttpPost(Global.URL+"speechsms/mast_changepass.jsp", nameValuePairs);

									String result1 = response.trim();
									System.out.println("Output From Fine Dest " + result1);

									if (result1.equals("True"))
									{
										Toast.makeText(getApplicationContext(),"Master Password Changed Successfully",
												Toast.LENGTH_LONG).show();
										Intent intent = new Intent(getApplicationContext(),
												HomeScreen.class);
										startActivity(intent);
									} else
									{

										Toast.makeText(getApplicationContext(),"Master Password Changed Successfully",
												Toast.LENGTH_LONG).show();
										Intent intent = new Intent(getApplicationContext(),
												HomeScreen.class);
									}

								} catch (Exception e)
								{
									
									Toast.makeText(getApplicationContext()," Exception "+e,Toast.LENGTH_LONG).show();
								}

								txt1.setText("");
								txt2.setText("");
								txt3.setText("");
								

							}
							
						}
					});
		    		
		    	}else
		    	{
		    		Toast.makeText(OTPCheck.this, "OTP Verification Failed....!", Toast.LENGTH_SHORT).show();
		    		Bundle bundle1 = new Bundle();  
					bundle1.putString("otp", pass);
					Intent i3 = new Intent(getApplicationContext(), OTPCheck.class);
					i3.putExtras(bundle1);
		            startActivity(i3);
		    	}
		    	
		    }
		  })
		.setNegativeButton("Cancel",
		  new DialogInterface.OnClickListener() {
		    public void onClick(DialogInterface dialog,int id) { 
			dialog.cancel();
			
			Toast.makeText(OTPCheck.this, "OTP Verification Canceled....!", Toast.LENGTH_SHORT).show();
			Intent i3 = new Intent(getApplicationContext(), HomeScreen.class);
            startActivity(i3);
			
		    }
		  });

	
	AlertDialog alertDialog = alertDialogBuilder.create();


	alertDialog.show();

	
}
}
