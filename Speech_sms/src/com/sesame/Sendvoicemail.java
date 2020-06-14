package com.sesame;

import java.util.ArrayList;
import java.util.Locale;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import com.HttpClient.CustomHttpClient;




import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.speech.tts.TextToSpeech;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class Sendvoicemail extends Activity {

	private EditText etText;
	private EditText etSub;
	private EditText etBody;
	private ImageButton sendsms;
	private ImageButton btnSpeak1;
	private ImageButton btnSpeak2;
	private ImageButton btnSpeak3;
    private final int REQ_CODE_SPEECH_INPUT = 100;
	
    private final int REQ_CODE_SPEECH_INPUT1 = 101;
    
    private final int REQ_CODE_SPEECH_INPUT2= 102;
	private String response;
	private ImageButton sendmail;
	private String etText1;
	private TextToSpeech t1;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_sendvoicemail);
		
		etText= (EditText)findViewById(R.id.et_to);
		

		etSub= (EditText)findViewById(R.id.et_sub);
		etBody= (EditText)findViewById(R.id.et_body);
		sendmail = (ImageButton) findViewById(R.id.buttonSend);
        btnSpeak1 = (ImageButton) findViewById(R.id.buttonspeak);
        btnSpeak2 = (ImageButton) findViewById(R.id.imageView1);
        btnSpeak3 = (ImageButton) findViewById(R.id.imageView2);
		  getActionBar().hide();
		
		  t1=new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {

				@Override
				public void onInit(int status) {
					
					if(status != TextToSpeech.ERROR) {
			               t1.setLanguage(Locale.UK);
			            }
				}
			
				
			});

		  btnSpeak1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				System.out.println("its came inside btnspk");
                promptSpeechInput();
			}
		});
		  
		  btnSpeak2.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
			
				 promptSpeechInput1();
			}
		});
		  btnSpeak3.setOnClickListener(new OnClickListener() {
			
			  
			  
			@Override
			public void onClick(View v) {
				
				 promptSpeechInput2();
			}
		});
		  sendmail.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				
				String s = "Sending Your Mail";
				 t1.speak(s, TextToSpeech.QUEUE_FLUSH, null);
				String 	to = etText.getText().toString().trim();
		      
		           to = to.replaceAll(" ",""); 	
		           String 	sub = etSub.getText().toString();
		           String 	body = etBody.getText().toString();
		     
		            	   sendMail(to,sub,body);
		            	

		       			Intent intentSignUP=new Intent(Sendvoicemail.this,HomeScreen.class);
		       			startActivity(intentSignUP);
			}
		});
		  
	}

	protected void sendMail(String to, String sub, String body) {
		
		try {

			ArrayList<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
			nameValuePairs.add(new BasicNameValuePair("To", to));
			nameValuePairs.add(new BasicNameValuePair("subj", sub));
			nameValuePairs.add(new BasicNameValuePair("text", body));

			response = CustomHttpClient.executeHttpPost(Global.URL1
					+ "mail.jsp", nameValuePairs);
			boolean b = Boolean.parseBoolean(response);
			System.out.println("---------------------" + response);
			 Toast.makeText(getApplicationContext(),
			"Mail Sent :" + b, Toast.LENGTH_LONG).show();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	

	protected void promptSpeechInput2() {
		
		   Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
	        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,
	                RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
	        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault());
	        intent.putExtra(RecognizerIntent.EXTRA_PROMPT,
	                getString(R.string.speech_prompt));
	        try {
	            startActivityForResult(intent, REQ_CODE_SPEECH_INPUT2);
	        } catch (ActivityNotFoundException a) {
	            Toast.makeText(getApplicationContext(),
	                    getString(R.string.speech_not_supported),
	                    Toast.LENGTH_SHORT).show();
	        }
	}

	protected void promptSpeechInput1() {
		
		 Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
	        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,
	                RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
	        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault());
	        intent.putExtra(RecognizerIntent.EXTRA_PROMPT,
	                getString(R.string.speech_prompt));
	        try {
	            startActivityForResult(intent, REQ_CODE_SPEECH_INPUT1);
	        } catch (ActivityNotFoundException a) {
	            Toast.makeText(getApplicationContext(),
	                    getString(R.string.speech_not_supported),
	                    Toast.LENGTH_SHORT).show();
	        }
	}

	protected void promptSpeechInput() {
		
		Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,
                RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault());
        intent.putExtra(RecognizerIntent.EXTRA_PROMPT,
                getString(R.string.speech_prompt));
        try {
            startActivityForResult(intent, REQ_CODE_SPEECH_INPUT);
        } catch (ActivityNotFoundException a) {
            Toast.makeText(getApplicationContext(),
                    getString(R.string.speech_not_supported),
                    Toast.LENGTH_SHORT).show();
        }
	}
@Override
protected void onActivityResult(int requestCode, int resultCode, Intent data) {

	
	
	super.onActivityResult(requestCode, resultCode, data);
	
	  switch (requestCode) {
      case REQ_CODE_SPEECH_INPUT1: {
          if (resultCode == RESULT_OK && null != data) {

              ArrayList<String> result = data
                      .getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
              etText.setText(result.get(0).trim());
          }
          break;
      }
      case REQ_CODE_SPEECH_INPUT: {
          if (resultCode == RESULT_OK && null != data) {

              ArrayList<String> result = data
                      .getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
             
              etSub.setText(result.get(0));
          }
          break;
      }
      case REQ_CODE_SPEECH_INPUT2: {
          if (resultCode == RESULT_OK && null != data) {

              ArrayList<String> result = data
                      .getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
              etBody.setText(result.get(0));
          }
          break;
      }
      }
}
}
