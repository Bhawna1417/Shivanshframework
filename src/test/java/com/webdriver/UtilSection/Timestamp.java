package com.webdriver.UtilSection;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Timestamp 
{

	public static String current_timestamp() throws Exception
	{
		String generated_timestamp = null;
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("ddMMMyy_hhmmss");
		Date date = new Date();
		generated_timestamp = dateFormat.format(date);
		System.out.println(generated_timestamp);
		return generated_timestamp;
	}
	
	public static String getDate() throws Exception
	{
		String generated_timestamp = null;
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("ddMMyy");
		Date date = new Date();
		generated_timestamp = dateFormat.format(date);
		System.out.println(generated_timestamp);
		return generated_timestamp;
	}
}
