package com.sesame;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class PasswordOptions extends Activity
{
	Button btnView,btnAdd;
@Override
protected void onCreate(Bundle savedInstanceState) {
	
	super.onCreate(savedInstanceState);
	
	setContentView(R.layout.passwordoptions);

    

    // Get The Refference Of Buttons
	btnView=(Button)findViewById(R.id.viewpass);
	btnAdd=(Button)findViewById(R.id.addpass);

   // Set OnClick Listener on SignUp button 
	btnAdd.setOnClickListener(new View.OnClickListener() {
	public void onClick(View v) {
		

		// Create Intent for SignUpActivity  abd Start The Activity
		System.out.println("add passwords");
		Intent intentSignUP=new Intent(getApplicationContext(),AddPasswords.class);
		startActivity(intentSignUP);
		}
	});
   
   
   
   
   
// Set OnClick Listener on Log In button 
	btnView.setOnClickListener(new View.OnClickListener() {
	public void onClick(View v) {
	

		// Create Intent for SignUpActivity and Start The Activity
		System.out.println("view password");
		
		Intent intentSignUP=new Intent(getApplicationContext(),PasswordsList.class);
		startActivity(intentSignUP);
		}
	});
}
	
	
	

}
