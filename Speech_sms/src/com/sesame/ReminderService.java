package com.sesame;


import com.sesame.R;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Color;
import android.media.RingtoneManager;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

public class ReminderService extends WakeReminderIntentService {

	public ReminderService() {
		super("ReminderService");
			}

	@Override
	void doReminderWork(Intent intent) {
		Log.d("ReminderService", "Doing work.");
		Long rowId = intent.getExtras().getLong(RemindersDbAdapter.KEY_ROWID);
		 
		NotificationManager mgr = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);
		NotificationCompat.Builder builder =  
		        new NotificationCompat.Builder(this)  
		        .setSmallIcon(R.drawable.ic_launcher)  
		        .setContentTitle("Task Reminder!! ")  
		        .setContentText("A task needs to be reviewed!!");  
			
		Intent notificationIntent = new Intent(this, ReminderEditActivity.class); 
		notificationIntent.putExtra(RemindersDbAdapter.KEY_ROWID, rowId); 
		
		PendingIntent pi = PendingIntent.getActivity(this, 0, notificationIntent, PendingIntent.FLAG_ONE_SHOT); 
		
	
		builder.setContentIntent(pi);  
		builder.setAutoCancel(true);
		builder.setLights(Color.BLUE, 500, 500);
		long[] pattern = {500,500,500,500,500,500,500,500,500};
		builder.setVibrate(pattern);
		builder.setStyle(new NotificationCompat.InboxStyle());
		
		
		mgr.notify(1, builder.build());
		
		Uri alarmSound = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
		builder.setSound(alarmSound);
		
	}
}
