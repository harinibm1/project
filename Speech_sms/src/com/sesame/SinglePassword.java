package com.sesame;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class SinglePassword extends Activity
{
	TextView txt1,txt2,txt3;
	Button btn;
@Override
protected void onCreate(Bundle savedInstanceState) {
	// TODO Auto-generated method stub
	super.onCreate(savedInstanceState);
	setContentView(R.layout.view_singlepass);
	
	Bundle bundle = getIntent().getExtras();

	//Extract the data…
	String pass = bundle.getString("pass");  
	String[] data=pass.split("~");
	
	txt1=(TextView) findViewById(R.id.dname);
	txt2=(TextView) findViewById(R.id.uid);
	txt3=(TextView) findViewById(R.id.upassword);
	btn=(Button) findViewById(R.id.btn);
	
	txt1.setText(data[0]);
	txt2.setText(data[2]);
	txt3.setText(data[1]);
	btn.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			Intent i = new Intent(getApplicationContext(), HomeScreen.class);
			startActivity(i);
			
		}
	});
}
}
