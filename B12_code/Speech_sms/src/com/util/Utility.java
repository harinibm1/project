package com.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Utility 
{
	
	public static boolean isEventDateAfterFeedbackLastDate(String eventDate,String feedBackDate)
	{
		boolean flag = false;
		
		try 
		{
			SimpleDateFormat sf = new SimpleDateFormat("dd-MM-yyyy");
			
			Date date1 = sf.parse(eventDate);
			Date date2 = sf.parse(feedBackDate);
			
			flag = date1.after(date2);
		} 
		catch (Exception e) 
		{
			System.out.println(e);
		}
		return flag;
	}
	
	public static String ValidateName(String name)
    {
	   	String msg="valid";
	   	Pattern pattern = Pattern.compile("\\d[0-9]*"); 
	    Matcher matcher = pattern.matcher(name);
	 
	    if (matcher.matches()) 
	    {
	          System.out.println("Numbers Are not Allowed in Name");
	          msg="Numbers Are not Allowed in Name.";
	          
	    } else 
	    {
	          System.out.println("Name is valid.");
	    }
	   	return msg;
    }
	
	
	public static String ValidatePassword(String password)
    {
	   	String msg="valid";
	   if(password.length()<=5)
	   {
		   msg="Password must be greater than 5 characters.";
	   }
	   	return msg;
    }
	
	
	public static int ValidateMobileNumber(String number)
    {
	   	 int flag=0;
	   	 
	   	Pattern pattern = Pattern.compile("\\d{10}"); 
	    Matcher matcher = pattern.matcher(number);
	    if (matcher.matches()) 
	    {
	          System.out.println("Mobile Number Valid");
	          
	    } else 
	    {
	          System.out.println("Mobile Number must be number & in the form XXXXXXXXXX");
	          flag=1;
	    }
	   	return flag;
    }
	
	public static int ValidatePhoneNumber(String number)
    {
	   	 int flag=0;
	   
	   	Pattern pattern = Pattern.compile("\\d{3}-\\d{7}"); 
	    Matcher matcher = pattern.matcher(number);
	    if (matcher.matches()) 
	    {
	          System.out.println("Phone Number Valid");
	          
	    } else 
	    {
	          System.out.println("Phone Number must be number & in the form XXXXXXXXXX");
	          flag=1;
	    }
	   	return flag;
    }
	
   
	
	 public static int Validate_EmailID(String email)
     {
    	int flag=0;
    	
    	 String at="@";
    	 String dot=".";
    	 String com="com";
    	 String str="#$%^&*!+=/\\}]{[~`?/<>,"; 
    	 String str1="0123456789@.";
    	 String str2=".com";
    	 String str3=".co.in";
    	 String str4=".org";
    	 
         int count=0;
         int count1=0;
         int l=email.length();
         
         if(email.indexOf(at)==-1)
         {
           flag=1;
         }
         
         if(email.indexOf(dot)==-1)
         {
        	 flag=1;
         }
         
         // Special Characters are not allowed in email
         for(int i=0;i<l;i++)
         {
            for(int j=0;j<str.length();j++)
            {
                if(email.charAt(i)==str.charAt(j))
                {
                   flag=1;
                }
            }
          }
         
         //First Character of email should not be numeric.
         for(int i=0;i<str1.length();i++)
         {
              if(email.charAt(0)==str1.charAt(i))
              {
                  flag=1;
              }
        }
         
         // "@" should be allowed only once
         for(int i=0;i<l;i++)
         {
             if(email.charAt(i)==at.charAt(0))
             {
                  count=count+1;
             }
        }
         
        if(count>1)
        {
        	flag=1;
        }
        
        if((email.lastIndexOf(str2)==-1)&&(email.lastIndexOf(str2)==-1)&&(email.lastIndexOf(str3)==-1))
        {
        	flag=1;
        }
    	
    	return flag;
     }
	 
	 // Getting The Date and Time 
	 
	 public static String getDate()
		{
			String date="";
			try
			{
				Calendar currentDate = Calendar.getInstance();
				SimpleDateFormat formatter1=new SimpleDateFormat("dd-MM-yyyy");
				date = formatter1.format(currentDate.getTime());
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
			return date;
		}
		public static String getTime()
		{
			String time="";
			try
			{
				Calendar currentDate = Calendar.getInstance();
				SimpleDateFormat formatter1=new SimpleDateFormat("HH:mm:ss");
				time = formatter1.format(currentDate.getTime());
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
			return time;
		}
		public static String getDay()
		{
			String day="";
			try
			{
				Calendar currentDate = Calendar.getInstance();
				int no=currentDate.get(Calendar.DAY_OF_WEEK);
				if(no==1)
					day="Sunday";
				else if(no==2)
					day="Monday";
				else if(no==3)
					day="TUESDAY";
				else if(no==4)
					day="WEDNESDAY";
				else if(no==5)
					day="THURSDAY";
				else if(no==6)
					day="FRIDAY";
				else if(no==7)
					day="SATURDAY";
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
			return day;
		}
		
		public static boolean isInteger(String s)
		{  
			Scanner scanner = new Scanner(s);  
			if (scanner.hasNextInt()) 
			{  
			  return true;
			}
			else 
			{
			  return false;
			}
		}
}
