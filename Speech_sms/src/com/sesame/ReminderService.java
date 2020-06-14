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
		
	/*	Notification note=new Notification(android.R.drawable.stat_sys_warning, getString(R.string.notify_new_task_message), System.currentTimeMillis());
		note.setLatestEventInfo(this, getString(R.string.notify_new_task_title), getString(R.string.notify_new_task_message), pi);
		note.defaults |= Notification.DEFAULT_SOUND; 
		note.flags |= Notification.FLAG_AUTO_CANCEL; */
		builder.setContentIntent(pi);  
		builder.setAutoCancel(true);
		builder.setLights(Color.BLUE, 500, 500);
		long[] pattern = {500,500,500,500,500,500,500,500,500};
		builder.setVibrate(pattern);
		builder.setStyle(new NotificationCompat.InboxStyle());
		// An issue could occur if user ever enters over 2,147,483,647 tasks. (Max int value). 
		// I highly doubt this will ever happen. But is good to note. 
		
		mgr.notify(1, builder.build());
		/*int id = (int)((long)rowId);
		mgr.notify(id, note); */
		Uri alarmSound = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
		builder.setSound(alarmSound);
		
	}
}
