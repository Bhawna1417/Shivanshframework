package com.webdriver.TestCaseBase;


public class URLLoader extends LoadPropertyFiles
{

	public URLLoader(String location) {
		super(location);
		// TODO Auto-generated constructor stub
	}

	public static String baseUrl(String string)
	{		
		return ReadPropertiesEnv(AkeoSanityTestBase.getUserdir(), string);		
		
	}
	
}