package com.webdriver.UtilSection;

import org.apache.log4j.Logger;

import java.lang.reflect.Array;

public class QuantityErrorMessage 
{
	public static int Error_message(String message_displayed,int quantity,Logger log) throws Exception
	{
		
		int maxstockallowed = 1;
		
		String msg = message_displayed.trim();
		
		String[] error = msg.split(" ");
		
		int length = Array.getLength(error);
		
		if(error[0].toLowerCase().contains("max"))
		{	
			maxstockallowed = Integer.parseInt(error[length-1]);
			
			log.info("Error message obtained for max quantity selection. Hence selecting max quantity as " + maxstockallowed);
		}
		
		for(int i=0; i<length;i++)
		{
			if(error[i].toLowerCase().contains("sufficient"))
			{
				maxstockallowed = 1;
				
				log.info("Error message obtained for insufficient quantity "
						+ "available in stock. Hence selecting max quantity as " + maxstockallowed);
			}
		}
				
		return maxstockallowed;
	}
}