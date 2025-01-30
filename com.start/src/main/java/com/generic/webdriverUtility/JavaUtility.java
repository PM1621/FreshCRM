package com.generic.webdriverUtility;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class JavaUtility {
	public int getRandomNumber()
	{
		Random random=new Random();
		int randomnum=random.nextInt(5000);
		return randomnum;
	}
	
	public String getSystemDateYYYYMMDD()
	{
		Date date=new Date();
		
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		String actDate=sdf.format(date);
		return actDate;
		
	}
	
	public String getRequiredBeforeAfterDate(int days)
	{
		
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		
		Calendar cal=Calendar.getInstance();
		cal.add(Calendar.DAY_OF_MONTH,days);
		String daterequired=sdf.format(cal.getTime());
		return daterequired;
		
		}

}
