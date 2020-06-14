// Copyright (C) 2012 Shane Tully 
//
// This program is free software: you can redistribute it and/or modify
// it under the terms of the GNU Lesser General Public License as published by
// the Free Software Foundation, either version 3 of the License, or
// (at your option) any later version.
// 
// This program is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
// GNU Lesser General Public License for more details.
// 
// You should have received a copy of the GNU Lesser General Public License
// along with this program.  If not, see <http://www.gnu.org/licenses/>.

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