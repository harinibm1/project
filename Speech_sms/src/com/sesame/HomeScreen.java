/**
 @Author : Amutha
 Date : Oct 8, 2013
 File : HomeScreen.java
 Package : com.example.trafficsyatem
*/

package com.sesame;

import java.util.HashMap;
import java.util.Locale;


import com.util.RandomValue;
import com.util.Send_SMS_Service;




import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.telephony.SmsManager;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;
 
public class HomeScreen extends Activity 
{
	SessionManager session;
	private Button mail;
	private Button batry;
	private Button rem;
	private TextToSpeech t1;
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);
      
        session = new SessionManager(getApplicationContext());
        // session.checkLogin();
        
        HashMap<String, String> user = session.getUserDetails();
        
        // name
        String name = user.get(SessionManager.KEY_NAME);
        
        mail =  (Button)findViewById(R.id.btn_Mail);
        batry = (Button)findViewById(R.id.btn_battery);
       rem=  (Button)findViewById(R.id.btn_rem);
       
        String pass = user.get(SessionManager.KEY_PWD);
        t1=new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {

			@Override
			public void onInit(int status) {
				
				if(status != TextToSpeech.ERROR) {
		               t1.setLanguage(Locale.UK);
		            }
			}
		
			
		});
        // email
        //String email = user.get(SessionManager.KEY_EMAIL);
        System.out.println("=================================");
        System.out.println("UserName "+name+" pass :"+pass);
        System.out.println("=================================");
        //session.createLoginSession(name,pass,null,null);
        mail.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				String s= "Clicked On Mail";
				   t1.speak(s, TextToSpeech.QUEUE_FLUSH, null);
				Intent i = new Intent(getApplicationContext(),Sendvoicemail.class);
				startActivity(i);
			}
		});
        
        batry.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				String s1= "Clicked On battery";
				   t1.speak(s1, TextToSpeech.QUEUE_FLUSH, null);
				Intent i1 = new Intent(getApplicationContext(),Battery.class);
				startActivity(i1);
				
			}
		});
        rem.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				String s2= "Clicked On Reminder";
				   t1.speak(s2, TextToSpeech.QUEUE_FLUSH, null);
				Intent i1 = new Intent(getApplicationContext(),ReminderListActivity.class);
				startActivity(i1);
				
			}
		});
    }
     
    // Initiating Menu XML file (menu.xml)
    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.main, menu);
        return true;
    }
     
    /**
     * Event Handling for Individual menu item selected
     * Identify single menu item by it's id
     * */
    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
         
        switch (item.getItemId())
        {
        case R.id.profile:
            // Single menu item is selected do something
            // Ex: launching new activity/screen or show alert message
            Toast.makeText(HomeScreen.this, "User Selected Profile", Toast.LENGTH_SHORT).show();
            Intent i = new Intent(getApplicationContext(), Profile.class);
            startActivity(i);
            return true;
            
      /*  case R.id.battery:
            // Single menu item is selected do something
            // Ex: launching new activity/screen or show alert message
       
            Intent ib = new Intent(getApplicationContext(), Battery.class);
            startActivity(ib);
            return true;*/
   /*     case R.id.sms:
            // Single menu item is selected do something
            // Ex: launching new activity/screen or show alert message
            Toast.makeText(HomeScreen.this, "User Selected Voice SMS", Toast.LENGTH_SHORT).show();
            Intent i6 = new Intent(getApplicationContext(), Sendvoicesms.class);
            startActivity(i6);
            return true;*/
      /*  case R.id.mail:
            // Single menu item is selected do something
            // Ex: launching new activity/screen or show alert message
            Toast.makeText(HomeScreen.this, "User Selected Voice MAIL", Toast.LENGTH_SHORT).show();
            Intent i7 = new Intent(getApplicationContext(), Sendvoicemail.class);
            startActivity(i7);
            return true;
 */
        case R.id.voice_password:
            // Single menu item is selected do something
            // Ex: launching new activity/screen or show alert message
            Toast.makeText(HomeScreen.this, "User Selected Voice Password", Toast.LENGTH_SHORT).show();
            Intent i1 = new Intent(getApplicationContext(), Voiceprocess.class);
            startActivity(i1);
            return true;
 
        case R.id.master_password:
            // Single menu item is selected do something
            // Ex: launching new activity/screen or show alert message
            Toast.makeText(HomeScreen.this, "User Selected Master Password", Toast.LENGTH_SHORT).show();
            Intent i2 = new Intent(getApplicationContext(), UsingMasterPass.class);
            startActivity(i2);
            return true;
 
        case R.id.master_pass:
            // Single menu item is selected do something
            // Ex: launching new activity/screen or show alert message
        	
        { final Context context = this;
        
        session = new SessionManager(getApplicationContext());
		// session.checkLogin();

		HashMap<String, String> user1 = session.getUserDetails();

		// name
		final String userpno = user1.get(SessionManager.KEY_PHONE);
        
        	AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context
    				);

    			// set title
    			alertDialogBuilder.setTitle("Are You Sure");

    			// set dialog message
    			alertDialogBuilder
    				.setMessage("To Change Master Password..!")
    				.setCancelable(false)
    				.setPositiveButton("Yes",new DialogInterface.OnClickListener() {
    					public void onClick(DialogInterface dialog,int id) {
    						System.out.println("yes block :"+userpno);
    						
    						String otp=RandomValue.otpValue();
    						String msg="Your OTP Number is :"+otp;
    						//boolean flag=Send_SMS_Service.sendSMS(userpno, msg);
    						boolean flag=	 sendSMS(userpno, msg);
    						System.out.println(msg);
    						if(flag)
    						{
    							Bundle bundle = new Bundle();  
    							bundle.putString("otp", otp);
    							Toast.makeText(HomeScreen.this, " OTPSent Successfully...", Toast.LENGTH_SHORT).show();
    							Intent i3 = new Intent(getApplicationContext(), OTPCheck.class);
    							i3.putExtras(bundle);
    							startActivity(i3);
    						}else
    						{
    							Toast.makeText(HomeScreen.this, "OOP'S Problem With OTPSending", Toast.LENGTH_SHORT).show();
    							Intent i3 = new Intent(getApplicationContext(), HomeScreen.class);
    				            startActivity(i3);
    						}
    					}
    				  })
    				.setNegativeButton("No",new DialogInterface.OnClickListener() {
    					public void onClick(DialogInterface dialog,int id) {
    						System.out.println("no block "+userpno);
    						dialog.cancel();
    					}
    				});

    				// create alert dialog
    				AlertDialog alertDialog = alertDialogBuilder.create();

    				// show it
    				alertDialog.show();
    				 
        }
        	
          /*  Toast.makeText(HomeScreen.this, "User Selected Master Password Settings", Toast.LENGTH_SHORT).show();
            Intent i3 = new Intent(getApplicationContext(), Profile.class);
            startActivity(i3);*/
            return true;
 
       /* case R.id.rem_dt:
            Toast.makeText(HomeScreen.this, "////////////", Toast.LENGTH_SHORT).show();
            Intent int2 = new Intent(getApplicationContext(), ReminderListActivity.class);
            startActivity(int2);
            return true;*/
            
        case R.id.changepass:
            Toast.makeText(HomeScreen.this, "User Selected Change Password", Toast.LENGTH_SHORT).show();
            Intent intent2 = new Intent(getApplicationContext(), ChangePassword.class);
            startActivity(intent2);
            return true;
            
        case R.id.logout:
            Toast.makeText(HomeScreen.this, "User have Logged Out Successfully", Toast.LENGTH_SHORT).show();
            Intent intent3 = new Intent(getApplicationContext(), MainPage.class);
            startActivity(intent3);
            return true;
 
       
 
        default:
            return super.onOptionsItemSelected(item);
        }
    }   
    
    @Override
	public void onBackPressed()
	{
		Intent intent1 = new Intent(this,HomeScreen.class);
		startActivity(intent1);
		
	}
    
    public boolean sendSMS(String phoneNumber, String message) {
	    SmsManager sms = SmsManager.getDefault();
	    boolean flag=true;
	    System.out.println("phonenumner is>>>>>>>>>>>>>>>>>>"+phoneNumber);
	    
	    System.out.println("message>>>>>>>>>>>>>>>>>>"+message);
	    sms.sendTextMessage(phoneNumber, null, message, null, null);
	    
	    Toast.makeText(getApplicationContext(),	" SMS Sent Successfully",Toast.LENGTH_SHORT).show();
		return flag;
	}
 
}











