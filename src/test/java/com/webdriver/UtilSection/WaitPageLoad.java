package com.webdriver.UtilSection;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitPageLoad 
{

	public static String WaitforPageLoad(WebDriver driver) throws Exception
	{	
		
		String Expected = null;
		
		boolean current_page_displayed = true;
		
		int counter = 0;
		
		//final String current = null; 
		
		
		
		do
		{
			counter++;
			final String current = driver.getTitle();
			try
			{
				
				ExpectedCondition<Boolean> pagechanged=new ExpectedCondition<Boolean>(){
				    public Boolean apply(    WebDriver d){
				      return !d.getTitle().toLowerCase().equals(current);
				    }
				  }
				;
				
				
				WebDriverWait wait=new WebDriverWait(driver,15);
				 System.out.println(counter); System.out.println(Timestamp.current_timestamp());
				  wait.until(pagechanged);
				  
				 
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			
			Expected = driver.getTitle();
			
			if(Expected.toLowerCase().contains(current))
			{
				current_page_displayed = true;
			}
			
			if(counter==30)
			{								
				throw new RuntimeException("Waiting for page load, done 30 times, hence throwing Exception");
			}			
			
		}while(current_page_displayed && counter<=30);
		
		return Expected;
	}
}
