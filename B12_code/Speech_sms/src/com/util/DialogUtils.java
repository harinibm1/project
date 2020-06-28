package com.util;

import com.sesame.R;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.util.Linkify;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public abstract class DialogUtils 
{

   
    public static void displayErrorDialog(Context context, String title, String message) 
    {
        new AlertDialog.Builder(context)
        .setTitle(title)
        .setMessage(message)
        .setIcon(R.drawable.error)
        .setPositiveButton("OK", new DialogInterface.OnClickListener() 
        {
            public void onClick(DialogInterface dialog, int whichButton) {}
        })
        .show();
    }
    
    public static void displaySuccessDialog(Context context, String title, String message) 
    {
        new AlertDialog.Builder(context)
        .setTitle(title)
        .setMessage(message)
        .setIcon(R.drawable.sucess)
        .setPositiveButton("OK", new DialogInterface.OnClickListener() 
        {
            public void onClick(DialogInterface dialog, int whichButton) {}
        })
        .show();
    }
    
    public static void displayInfoDialog(Context context, String title, String message) 
    {
        new AlertDialog.Builder(context)
        .setTitle(title)
        .setMessage(message)
        .setIcon(R.drawable.info)
        .setPositiveButton("OK", new DialogInterface.OnClickListener() 
        {
            public void onClick(DialogInterface dialog, int whichButton) {}
        })
        .show();
    }
     
}