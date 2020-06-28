package com.sesame;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

import com.HttpClient.CustomHttpClient;
import com.util.DialogUtils;

import com.listview.CustomListViewAdapter;
import com.listview.RowItem;

public class PasswordsList extends Activity
{
	String result[];
	String res="",response = "",deviceIMEI = "";;
	int eventId =0; String dname="";
	String surveyId="",qnLabel="",pass="",qnShort="",userid="",username="",password="";
	
	ListView listView;
	RowItem rowItem;
	List<RowItem> rowItems;
	
	//Feedback Dialog Parameters
	 Dialog dialog=null;
	 AlertDialog.Builder feedBackDialog;
	 LinearLayout feedBackLayout;
	Button backbtn;
	 SessionManager session;
	
	 Map<String,String> map = null;
	
	//Called when the activity is first created. //
    @Override
    public void onCreate(Bundle savedInstanceState) 
    {
    	if (android.os.Build.VERSION.SDK_INT > 9) {
    	    StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
    	    StrictMode.setThreadPolicy(policy);
    	}
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_feedback_qn_list);
        backbtn=(Button) findViewById(R.id.backbtn);
        
        backbtn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intentSignUP=new Intent(getApplicationContext(),HomeScreen.class);
    			startActivity(intentSignUP);
				
			}
		});
        
        try 
        {
        	session = new SessionManager(getApplicationContext());
    		

    		HashMap<String, String> user1 = session.getUserDetails();

    	
    		String userid1 = user1.get(SessionManager.KEY_NAME);
    		
			String response = null;
			try 
			{
				ArrayList<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
				nameValuePairs.add(new BasicNameValuePair("Userid", userid1));
				
				response = CustomHttpClient.executeHttpPost(Global.URL+"speechsms/ViewPasswords",nameValuePairs);
        	    res=response.toString();
        	    
        	    res = res.trim();
        	    
        	    System.out.println("passwords List Response :\n"+res);
        	    
        	    if(res.equals("No passwords Found !!!!!"))
        	    {
        	    	DialogUtils.displayErrorDialog(PasswordsList.this, "No Passwords Found!!!!!", "Thank You..");
					Toast.makeText(getApplicationContext(), "No Passwords Found !!!!!", Toast.LENGTH_LONG).show();
					
        	    }
        	    else
        	    {
        	    	
        	    }
               
			}
			catch (Exception e)
			{
				System.out.println("Something Went Wrong While getting the Passwords List: ");
				e.printStackTrace();
			}
			
		
			
        	
            result = res.split("~");
           
            rowItems = new ArrayList<RowItem>();
            
            System.out.println("Passwords List : "+Arrays.toString(result));
            for(int i=0;i<result.length;i++)
 	        {
 	        	String str = result[i].trim();
 	        	String[] qnInfo = str.split("`");
 	        	if(qnInfo.length == 4)
 	        	{
	 	        	eventId = Integer.parseInt(qnInfo[0].trim());
	 	        	dname = qnInfo[1].trim();
	 	        	pass = qnInfo[2].trim();
	 	        	userid = qnInfo[3].trim();
	 	        	
	 	        	qnLabel = "Domain Name " + dname+""; 
	 	        	

            		if(pass.length() > 40)
            		{
            			qnShort = pass.substring(0,40);
            			qnShort = qnShort+"...";
            		}
            		else
            		{
            			qnShort = pass;
            		}
            		
	           		 rowItem = new RowItem(eventId,dname,pass,userid);
       	             rowItems.add(rowItem);
	 	        	
 	        	}
 	        	
 	        }
            
            listView = (ListView) findViewById(R.id.list);
  	        CustomListViewAdapter adapter = new CustomListViewAdapter(this,R.layout.list_item, rowItems);
  	        listView.setAdapter(adapter);
  	        
  	        //Triggering The Onclick Action On List View
	 	  
  	        listView.setOnItemClickListener(new OnItemClickListener() 
	 	    {
	
				public void onItemClick(AdapterView<?> parent, View view, int position,long id) 
				{
					rowItem = rowItems.get(position);
					eventId = rowItem.getId();
					dname = rowItem.getQnNumber();
					pass = rowItem.getImageName();
					userid = rowItem.getSurveyId();
					
					
					showDialog(0);
					
				}
			});
 	    
            	
            	
		} 
        catch (Exception e) 
        {
			System.out.println("Something Went Wrong In FeedBackQnList Activity :");
			e.printStackTrace();
		}
        
    }//
    
    protected Dialog onCreateDialog(int id) 
    {
        switch(id) 
        {
            //Feedback Dialog
            case 0 :
            	
        	feedBackDialog = new AlertDialog.Builder(PasswordsList.this);
        	feedBackDialog.setTitle("Password Details of Domain :"+dname);
        	feedBackDialog.setIcon(R.drawable.add);
        	
        	feedBackLayout = new LinearLayout(PasswordsList.this);
        	feedBackLayout.setOrientation(LinearLayout.VERTICAL);
    		
        	TextView surveyIdLabel = new TextView(PasswordsList.this);
        	surveyIdLabel.setTextSize(17);
        	surveyIdLabel.setText(surveyId);
        	
        	TextView qnLabel = new TextView(PasswordsList.this);
        	qnLabel.setTextSize(17);
        	qnLabel.setText("Domain Name : "+dname+".");
        	
        	TextView qnDetailsLbl = new TextView(PasswordsList.this);
        	qnDetailsLbl.setTextSize(17);
        	qnDetailsLbl.setText("Password :"+pass);
        	
        	TextView qnDetailsLbl2 = new TextView(PasswordsList.this);
        	qnDetailsLbl2.setTextSize(17);
        	qnDetailsLbl2.setText("User ID :"+userid);
        	
        	feedBackLayout.addView(surveyIdLabel);
        	feedBackLayout.addView(qnLabel);
        	feedBackLayout.addView(qnDetailsLbl);
        	feedBackLayout.addView(qnDetailsLbl2);
        	
        	
        	
        	feedBackDialog.setView(feedBackLayout);
        	
        	feedBackDialog.setPositiveButton("Delete",new DialogInterface.OnClickListener() {
    			
    		public void onClick(DialogInterface dialog, int which)
    		{
    			System.out.println("Delete place");
    			System.out.println("ID :"+surveyId);
    			System.out.println("Domain :"+dname); 
    			System.out.println("UserID :"+userid);
    			System.out.println("Password :"+pass);
    			
    			
    			ArrayList<NameValuePair> postParameters = new ArrayList<NameValuePair>();
				postParameters.add(new BasicNameValuePair("event_id",new Integer(eventId).toString()));
				postParameters.add(new BasicNameValuePair("dname",dname));
				postParameters.add(new BasicNameValuePair("userid",userid));
				postParameters.add(new BasicNameValuePair("pass",pass));
				String response = null;
				try 
				{
					response = CustomHttpClient.executeHttpPost(Global.URL+"speechsms/deletePasswords.jsp",postParameters);
	        	    res=response.toString();
	        	    
	        	    res = res.trim();
	        	    
	        	    
	        	    System.out.println("Feedback Count Response :\n"+res);
	        	    
	        	    if(res.equals("True"))
	        	    {
	        	    	Intent intentSignUP=new Intent(getApplicationContext(),PasswordsList.class);
	        			startActivity(intentSignUP);
	        	    }
	        	    System.out.println("Feedback Count : \n"+map);
	        	   
	               
				}
				catch (Exception e)
				{
					System.out.println("Something Went Wrong While getting the Feedback Count : ");
					e.printStackTrace();
				}
    			
    			
    			
    		}
    		});
        	
        	
        	feedBackDialog.setNegativeButton("Cancel",new DialogInterface.OnClickListener() {
    			
        		public void onClick(DialogInterface dialog, int which)
        		{
        			Toast.makeText(getApplicationContext(),"The Process is canceled successfully.",Toast.LENGTH_LONG).show();
        			
        		}
        		});
    		
        	feedBackDialog.show();
            break;
    	      		
    	    default:
        		dialog = null;
        		break;
        }
    return dialog;
     }
}
