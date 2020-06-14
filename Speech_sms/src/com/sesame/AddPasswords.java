package com.sesame;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import com.HttpClient.CustomHttpClient;
import com.util.RandomValue;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddPasswords extends Activity
{
	EditText txt1,txt2,txt3,txt4;
	Button btn;
	SessionManager session;
@Override
protected void onCreate(Bundle savedInstanceState) {
	// TODO Auto-generated method stub
	super.onCreate(savedInstanceState);
	setContentView(R.layout.add_passwords);
	txt1=(EditText) findViewById(R.id.dname);
	txt2=(EditText) findViewById(R.id.uid);
	txt3=(EditText) findViewById(R.id.u_password);
	txt4=(EditText) findViewById(R.id.confirm_password);
	btn=(Button) findViewById(R.id.addbtn);
	final Context context = this;
	btn.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			
			String dname=null;
			String uid=null;
			String upass=null;
			String cpass=null;
			try{
				
				dname=txt1.getText().toString();
				uid=txt2.getText().toString();
				upass=txt3.getText().toString();
				cpass=txt4.getText().toString();
				
				
				
                 System.out.println("All Values " + dname + "."+ uid + "." + upass + "." + cpass);
				

				if ((dname.equals("") || upass.length() == 0)&& (upass.equals(""))&& (cpass.equals("") || cpass.length() == 0))
				{
					Toast.makeText(getApplicationContext(),	" Please Enter All the Fields ",Toast.LENGTH_SHORT).show();
					
				}
			
				else if("".equals(dname))
				{
					
					Toast.makeText(getApplicationContext(),	" Please Enter Domain Name ",Toast.LENGTH_SHORT).show();
				}
				else if("".equals(uid))
				{
					Toast.makeText(getApplicationContext(),	" Please Enter User ID ",Toast.LENGTH_SHORT).show();
				}
				else if("".equals(cpass))
				{
					Toast.makeText(getApplicationContext(),	" Please Enter Confirm Password ",Toast.LENGTH_SHORT).show();
				}
				else if("".equals(upass))
				{
					
					Toast.makeText(getApplicationContext(),	" Please Enter Password ",Toast.LENGTH_SHORT).show();
				}
				else if(!upass.equals(cpass))
				{
					
					Toast.makeText(getApplicationContext(),	" Password and Confirm Password Mismatch ",Toast.LENGTH_SHORT).show();
				}

				else if ( (upass.length() > 0)&& ( cpass.length() > 0 )&& ( uid.length() > 0 )&& ( dname.length() > 0 )) 
				{

					try {
						session = new SessionManager(getApplicationContext());
						// session.checkLogin();

						HashMap<String, String> user1 = session.getUserDetails();

						// name
						String name2 = user1.get(SessionManager.KEY_NAME);
						
						ArrayList<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
						nameValuePairs.add(new BasicNameValuePair("dname", dname));
						nameValuePairs.add(new BasicNameValuePair("uid",uid));
						nameValuePairs.add(new BasicNameValuePair("upass", upass));
						nameValuePairs.add(new BasicNameValuePair("loginUser",name2));

						
						
					   String response = CustomHttpClient.executeHttpPost(Global.URL+"speechsms/addPasswords.jsp", nameValuePairs);

						String result1 = response.trim();
						System.out.println("Output From Fine Dest " + result1);

						if (result1.equals("True"))
						{
							
							AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context
				    				);

				    			// set title
				    			alertDialogBuilder.setTitle("ADD More");

				    			// set dialog message
				    			alertDialogBuilder
				    				.setMessage("Do You Want ADD More Password..!")
				    				.setCancelable(false)
				    				.setPositiveButton("Yes",new DialogInterface.OnClickListener() {
				    					public void onClick(DialogInterface dialog,int id) {
				    						System.out.println("yes block :");
				    						
				    						
				    						
				    							
				    							
				    							Intent i3 = new Intent(getApplicationContext(), AddPasswords.class);
				    							
				    							startActivity(i3);
				    						
				    							
				    						
				    					}
				    				  })
				    				.setNegativeButton("No",new DialogInterface.OnClickListener() {
				    					public void onClick(DialogInterface dialog,int id) {
				    						System.out.println("no block ");
				    						
				    						
			    							Intent i3 = new Intent(getApplicationContext(), HomeScreen.class);
			    				            startActivity(i3);
				    						
				    						dialog.cancel();
				    					}
				    				});

				    				// create alert dialog
				    				AlertDialog alertDialog = alertDialogBuilder.create();

				    				// show it
				    				alertDialog.show();
				        	
						} else
						{

							Toast.makeText(getApplicationContext(),
									"OOP'S Problem With Adding Passwords...",
									Toast.LENGTH_LONG).show();
							Intent intent1 = new Intent(
									getApplicationContext(), AddPasswords.class);
							startActivity(intent1);
						}

					} catch (Exception e)
					{
						
						Toast.makeText(getApplicationContext()," Exception "+e,Toast.LENGTH_LONG).show();
					}

					txt1.setText("");
					txt2.setText("");
					txt3.setText("");
					txt4.setText("");

				}
				
				else
				{
					
					Toast.makeText(getApplicationContext(),	"Password Chk",
							Toast.LENGTH_LONG).show();
				}
				
				
			}catch (Exception e) {
				e.printStackTrace();
			}
			
			
			
			
			
		}
	});
	
}
}
