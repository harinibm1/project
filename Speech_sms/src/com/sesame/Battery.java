package com.sesame;

import java.util.Locale;



import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.wifi.WifiManager;
import android.os.BatteryManager;
import android.os.Bundle;
import android.os.StrictMode;
import android.speech.tts.TextToSpeech;
import android.text.format.Formatter;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class Battery extends Activity {
	private Context mContext;
	String response;
	public static int level;

	private TextView mTextViewInfo;
	private TextView mTextViewPercentage;
	private ProgressBar mProgressBar;
	private int mProgressStatus = 0;
	private BroadcastReceiver mBatInfoReceiver = new BroadcastReceiver() {// Broadcast
																			// Receivers
																			// simply
																			// respond
																			// to
																			// broadcast
																			// messages
																			// from
																			// other
																			// applications
																			// or
																			// from
																			// the
																			// system
																			// itself.
		public void onReceive(Context ctxt, Intent intent) {
			int scale = intent.getIntExtra(BatteryManager.EXTRA_SCALE, -1);// EXTRA_SCALE--
																			// max
																			// battery
																			// level

			mTextViewInfo.setText("Battery Scale : " + scale);

			level = intent.getIntExtra(BatteryManager.EXTRA_LEVEL, -1);// EXTRA_LEVEL
																		// --
																		// current
																		// battery
																		// level
			mTextViewInfo.setText(mTextViewInfo.getText()
					+ "\nBattery Level : " + level);
			float percentage = level / (float) scale;
			mProgressStatus = (int) ((percentage) * 100);
			mTextViewPercentage.setText("The Battery Level is" + mProgressStatus + "%");
			mTextViewInfo.setText(mTextViewInfo.getText() + "\nPercentage : "
					+ mProgressStatus + "%");
			mProgressBar.setProgress(mProgressStatus);

		}
	};

	private TextView imei1;

	private TextView sim;

	private TextView ip;

	private TextView tvDeviceFingetPrint;
	Button btn;
	private Button save;
	protected Context context;
	private Button listen;
	private TextToSpeech t1;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_battery);
		listen = (Button) findViewById(R.id.btn);
		if (android.os.Build.VERSION.SDK_INT > 9) {
		    StrictMode.ThreadPolicy policy = 
		    new StrictMode.ThreadPolicy.Builder().permitAll().build();      
		        StrictMode.setThreadPolicy(policy);
		 }
		t1=new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {

			@Override
			public void onInit(int status) {
				
				if(status != TextToSpeech.ERROR) {
		               t1.setLanguage(Locale.UK);
		            }
			}
		
			
		});
		listen.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				
				String toSpeak = mTextViewPercentage.getText().toString();
	            Toast.makeText(getApplicationContext(), toSpeak,Toast.LENGTH_SHORT).show();
	            t1.speak(toSpeak, TextToSpeech.QUEUE_FLUSH, null);
				
				
			}
		});

	

		mContext = getApplicationContext();
		IntentFilter iFilter = new IntentFilter(Intent.ACTION_BATTERY_CHANGED);// ACTION_BATTERY_CHANGED--provides
																				// a
																				// method
																				// for
																				// querying
																				// battery
																				// and
																				// charging
																				// properties
		mContext.registerReceiver(mBatInfoReceiver, iFilter);// IntentFilter--by
																// declaring an
																// intent filter
																// for an
																// activity, you
																// make it
																// possible for
																// other apps to
																// directly
																// start your
																// activity with
																// a certain
																// kind of
																// intent.
		mTextViewInfo = (TextView) findViewById(R.id.tv_info);
		mTextViewPercentage = (TextView) findViewById(R.id.tv_percentage);
		mProgressBar = (ProgressBar) findViewById(R.id.pb);
		
		
	
		
		
		}

	}

