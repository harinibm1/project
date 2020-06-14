package com.sesame;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import com.HttpClient.CustomHttpClient;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.speech.RecognizerIntent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;



public class Voiceprocess extends Activity {
private static final int REQUEST_CODE = 1234;
Button Start;
TextView Speech;
Dialog match_text_dialog;
ListView textlist;
ArrayList<String> matches_text;
String response = "";
SessionManager session;
String s=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Start = (Button)findViewById(R.id.start_reg);
        Speech = (TextView)findViewById(R.id.speech);
        session = new SessionManager(getApplicationContext());
       
   	    Start.setOnClickListener(new OnClickListener() {
        @Override
     	 public void onClick(View v) {
        	
        	
			
        	if(isConnected())
        	{
        	
    			
        	 Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
         	 intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,
         	 RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
         	 startActivityForResult(intent, REQUEST_CODE);
        			 }
        	else{
        		Toast.makeText(getApplicationContext(), "Plese Connect to Internet", Toast.LENGTH_LONG).show();
        	}}
        
        });   
}
    public  boolean isConnected()
    { 
    	ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
    NetworkInfo net = cm.getActiveNetworkInfo();
    if (net!=null && net.isAvailable() && net.isConnected()) {
        return true;
    } else {
        return false; 
    }
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
     if (requestCode == REQUEST_CODE && resultCode == RESULT_OK) {
    	    
     match_text_dialog = new Dialog(Voiceprocess.this);
     match_text_dialog.setContentView(R.layout.dialog_matches_frag);
     match_text_dialog.setTitle("Select Matching Text");
     textlist = (ListView)match_text_dialog.findViewById(R.id.list);
     matches_text = data
		     .getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
     ArrayAdapter<String> adapter =    new ArrayAdapter<String>(this,
    	     android.R.layout.simple_list_item_1, matches_text);
     textlist.setAdapter(adapter);
     textlist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
     @Override
     public void onItemClick(AdapterView<?> parent, View view,
                             int position, long id) {
    	 Speech.setText("You have said " +matches_text.get(position));
    	 
    	 
    	  s=matches_text.get(position);
    	  match_text_dialog.hide();
    	  
    	 HashMap<String, String> user1 = session.getUserDetails();
    	 String userid1 = user1.get(SessionManager.KEY_NAME);
    	 System.out.println("Add Data");
			ArrayList<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
			
			nameValuePairs.add(new BasicNameValuePair("word", s));
			nameValuePairs.add(new BasicNameValuePair("name", userid1));
			
			
			 try
			 {
				response = CustomHttpClient.executeHttpPost(Global.URL+"speechsms/getSinglePassword.jsp", nameValuePairs);
				System.out.println("Output "+response.trim());
				
				
				if(response.trim().equals("nopassword"))
				{
					Toast.makeText(getApplicationContext(), "No Password Found Please Try Again...!", 500).show();
					
					Intent intent = new Intent(getApplicationContext(), Voiceprocess.class);
					startActivity(intent);
				}else
				{
					 Bundle bundle = new Bundle();  
					bundle.putString("pass", response);
					Intent intent = new Intent(getApplicationContext(), SinglePassword.class);
					intent.putExtras(bundle);
					startActivity(intent);
				}
				
				
			 
			 } 
			 catch (Exception e)
			 {
				
				e.printStackTrace();
				
			}
			
    	 
    	 
    	 
    	 
     }
 });
     match_text_dialog.show();
     
     }
     super.onActivityResult(requestCode, resultCode, data);
    }
}