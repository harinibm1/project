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

public class UsingMasterPass extends Activity
{
	EditText txt;
	Button btn;
	String response="";
	String mstpass="";
	SessionManager session;
	String pass = "";
	String name2="";
@Override
protected void onCreate(Bundle savedInstanceState) {
	// TODO Auto-generated method stub
	super.onCreate(savedInstanceState);
	setContentView(R.layout.using_master_pass);
	
	txt=(EditText) findViewById(R.id.master_password);
	btn=(Button) findViewById(R.id.mast_btn);
	
	session = new SessionManager(getApplicationContext());
	// session.checkLogin();

	HashMap<String, String> user1 = session.getUserDetails();

	// name
	name2 = user1.get(SessionManager.KEY_NAME);
	pass = user1.get(SessionManager.KEY_PWD);
	btn.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View v) {
		
		    mstpass=txt.getText().toString();
			System.out.println("mast Pass :"+mstpass);
			
			ArrayList<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
			nameValuePairs.add(new BasicNameValuePair("MastPass", mstpass));
			nameValuePairs.add(new BasicNameValuePair("uid", name2));
			nameValuePairs.add(new BasicNameValuePair("upass", pass));
			

			
			

			if ((mstpass.equals("")))
			{
				Toast.makeText(getApplicationContext(),	" Please Enter Master Password ",Toast.LENGTH_SHORT).show();
				
			}else if ( (mstpass.length() > 0)) 
			{

				try {
					
					// HttpPost httppost = new HttpPost("http://122.166.104.51:8000/Traffic_System/changepass.jsp");
					
					response = CustomHttpClient.executeHttpPost(Global.URL+"speechsms/usingMasterpass.jsp", nameValuePairs);

					String result1 = response.trim();
					System.out.println("Output From Fine Dest " + result1);

					if (result1.equals("True"))
					{
						Toast.makeText(getApplicationContext(),"Password Matched Successfully",
								Toast.LENGTH_LONG).show();
						Intent intent = new Intent(getApplicationContext(),
								PasswordOptions.class);
						startActivity(intent);
					} else
					{

						Toast.makeText(getApplicationContext(),
								"Master Password Mismatch",
								Toast.LENGTH_LONG).show();
						Intent intent1 = new Intent(
								getApplicationContext(), UsingMasterPass.class);
						startActivity(intent1);
					}

				} catch (Exception e)
				{
					
					Toast.makeText(getApplicationContext()," Exception "+e,Toast.LENGTH_LONG).show();
				}

				txt.setText("");
				

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
