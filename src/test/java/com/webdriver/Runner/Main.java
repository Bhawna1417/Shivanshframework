package com.webdriver.Runner;

import org.testng.ITestNGListener;
import org.testng.TestNG;

import com.webdriver.Reporting.AkeoSanityListener;
import com.webdriver.Reporting.AkeoSanityReporter;
import com.webdriver.TestCases.TCAkeoTech;

public class Main {

	public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        
        String fileName = args[0];
        
        System.out.println(fileName);
        
        //String context = " ";

        //
       String context = System.getProperty("myvar"); 
        
        System.out.println(context);
        
        if(context != null)
        {
        	
        	System.out.println("hI");
        	
        	
        		System.out.println(context);
        	RunAkeoTech();
        }
        /*else
        {
        	System.out.println("NULL");
        }*/
    }
	
	@SuppressWarnings("rawtypes")
	public static void RunAkeoTech()
	{
		AkeoSanityListener listener = new AkeoSanityListener();

		AkeoSanityReporter reporter = new AkeoSanityReporter();

		TestNG testng = new TestNG();

		// Class[] classList = new Class[] { TC01.class };

		Class[] classList = new Class[] { TCAkeoTech.class};

		testng.setDefaultSuiteName("suite");
		testng.setTestClasses(classList);

		testng.addListener((ITestNGListener) listener);

		testng.addListener((ITestNGListener) reporter);
		// testng.setThreadCount(1);
		testng.setGroupByInstances(true);

		testng.run();
	}
	
}
