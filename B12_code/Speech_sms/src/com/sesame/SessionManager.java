package com.sesame;

import java.util.HashMap;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
 
public class SessionManager
{
   
    SharedPreferences pref;
     
    
    Editor editor;
     
 
    Context _context;
     
  
    int PRIVATE_MODE = 0;
     
   
    private static final String PREF_NAME = "AndroidLogin";
     
  
    private static final String IS_LOGIN = "IsLoggedIn";
     
   
    public static final String KEY_NAME = "name";
    public static final String KEY_DATE = "date";
    public static final String KEY_AMOUNT = "amount";
    public static final String KEY_KEY = "ukey";
    public static final String KEY_PWD = "pwd";
    public static final String KEY_SERVER = "server";
    public static final String KEY_SERVERUID = "serveruid";
    public static final String KEY_SERVERPASS = "serverpass";
    public static final String KEY_PHONE = "phone";
    
     
  
    public static final String KEY_EMAIL = "pwd";
     

    public SessionManager(Context context)
    {
        this._context = context;
        pref = _context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = pref.edit();
    }
     
    /**
     * Create login session
     * */
    public void createLoginSession(String name,String pwd,String pno,String ukey)
    {
    	System.out.println("============================");
    	System.out.println("name :"+name +" pass :"+pwd+" pno :"+pno);
    	System.out.println("============================");
        
        editor.putBoolean(IS_LOGIN, true);
         
        
        editor.putString(KEY_NAME, name);
        
       
         
        
         
        editor.putString(KEY_PWD, pwd);
        editor.putString(KEY_PHONE, pno);
        editor.putString(KEY_KEY, ukey);
        
        
       
        
       
        editor.commit();
    }   
    
    public void createOutputSession(String name,String date,String amount)
    {
    	
    	System.out.println("UserN "+name+"Date "+date+"Amount "+amount);
       
        editor.putBoolean(IS_LOGIN, true);
         
     
        editor.putString(KEY_NAME, name);
        editor.putString(KEY_DATE, date);
        editor.putString(KEY_AMOUNT, amount);
         
        
        editor.commit();
    }   
     
    
     
  
    public HashMap<String, String> getUserDetails(){
        HashMap<String, String> user = new HashMap<String, String>();
     
        user.put(KEY_NAME, pref.getString(KEY_NAME, null));
        user.put(KEY_PWD, pref.getString(KEY_PWD, null));
        user.put(KEY_PHONE, pref.getString(KEY_PHONE, null));
        user.put(KEY_KEY, pref.getString(KEY_KEY, null));
        return user;
    }
    
    public HashMap<String, String> getUserDetails1()
    {
        HashMap<String, String> user1 = new HashMap<String, String>(); 
       
        user1.put(KEY_NAME, pref.getString(KEY_NAME, null));
         
       
       user1.put(KEY_DATE, pref.getString(KEY_DATE, null));
        user1.put(KEY_AMOUNT, pref.getString(KEY_AMOUNT, null));
         
       
        return user1;
    }
     
    public void logoutUser()
    {
       
        editor.clear();
        editor.commit();
    }
    
  
    public boolean isLoggedIn(){
        return pref.getBoolean(IS_LOGIN, false);
    }
}