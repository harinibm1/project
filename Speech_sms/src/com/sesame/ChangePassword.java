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
import android.widget.EditText;
import android.widget.Toast;

public class ChangePassword extends Activity
{
	String current_pass = "", new_pass = "", loginu = "", confirmpa = "";
	EditText c_pass, new_password, con_pass, user;
	String output1 = "";
	String result = "";
	Button change;
	String pass = "";
	String response="";
	SessionManager session;
	
	boolean b =false;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
	
		super.onCreate(savedInstanceState);
		setContentView(R.layout.changepass);

		session = new SessionManager(getApplicationContext());
		

		HashMap<String, String> user1 = session.getUserDetails();

	
		String name2 = user1.get(SessionManager.KEY_NAME);
		pass = user1.get(SessionManager.KEY_PWD);

		c_pass = (EditText) findViewById(R.id.current_pass);
		new_password = (EditText) findViewById(R.id.new_password);
		con_pass = (EditText) findViewById(R.id.confirm_password);
		user = (EditText) findViewById(R.id.loginuser);

		user.setText(name2);
		user.setEnabled(false);

		change = (Button) findViewById(R.id.login);

		change.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v)
			{
				
				current_pass = c_pass.getText().toString();
				new_pass = new_password.getText().toString();
				confirmpa = con_pass.getText().toString();
				loginu = user.getText().toString();
				
				ArrayList<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
				nameValuePairs.add(new BasicNameValuePair("CurrentPass", current_pass));
				nameValuePairs.add(new BasicNameValuePair("NewPass",new_pass));
				nameValuePairs.add(new BasicNameValuePair("ConfirmPass", confirmpa));
				nameValuePairs.add(new BasicNameValuePair("loginUser",loginu));

				System.out.println("All Values " + current_pass + "."+ new_pass + "." + confirmpa + "." + loginu);
				

				if ((current_pass.equals("") || current_pass.length() == 0)&& (new_pass.equals(""))&& (confirmpa.equals("") || confirmpa.length() == 0))
				{
					Toast.makeText(getApplicationContext(),	" Please Enter All the Fields ",Toast.LENGTH_SHORT).show();
					
				}
			
				else if("".equals(current_pass))
				{
					
					Toast.makeText(getApplicationContext(),	" Please Enter Current Password ",Toast.LENGTH_SHORT).show();
				}
				else if("".equals(new_pass))
				{
					Toast.makeText(getApplicationContext(),	" Please Enter New Password ",Toast.LENGTH_SHORT).show();
				}
				else if("".equals(confirmpa))
				{
					
					Toast.makeText(getApplicationContext(),	" Please Enter Confirm Password ",Toast.LENGTH_SHORT).show();
				}
				else if(!new_pass.equals(confirmpa))
				{
					
					Toast.makeText(getApplicationContext(),	" New Password and Confirm Password Mismatch ",Toast.LENGTH_SHORT).show();
				}

				else if ( (current_pass.length() > 0)&& ( new_pass.length() > 0 )&& ( confirmpa.length() > 0 )&& ( loginu.length() > 0 )) 
				{

					try {
						
				
						
						response = CustomHttpClient.executeHttpPost(Global.URL+"speechsms/changepass.jsp", nameValuePairs);

						String result1 = response.trim();
						System.out.println("Output From Fine Dest " + result1);

						if (result1.equals("True"))
						{
							Toast.makeText(getApplicationContext(),"Password Changed Successfully",
									Toast.LENGTH_LONG).show();
							Intent intent = new Intent(getApplicationContext(),
									HomeScreen.class);
							startActivity(intent);
						} else
						{

							Toast.makeText(getApplicationContext(),
									"Current Password Mismatch",
									Toast.LENGTH_LONG).show();
							Intent intent1 = new Intent(
									getApplicationContext(), ChangePassword.class);
							startActivity(intent1);
						}

					} catch (Exception e)
					{
						
						Toast.makeText(getApplicationContext()," Exception "+e,Toast.LENGTH_LONG).show();
					}

					c_pass.setText("");
					new_password.setText("");
					con_pass.setText("");
					user.setText("");

				}
				
				else
				{
					
					Toast.makeText(getApplicationContext(),	"Password Chk",
							Toast.LENGTH_LONG).show();
				}
			}
		});

	}

}

