package com.webdriver.Mail;

import java.util.ArrayList;

public class MailBody 
{
	
	public static String mailbody = null;
	
	public static ArrayList<String> detail = new ArrayList<String>();

	/**
	 * @return the detail
	 */
	public static ArrayList<String> getDetail() {
		return detail;
	}

	/**
	 * @param detail the detail to set
	 */
	public static void setDetail(ArrayList<String> detail) {
		MailBody.detail = detail;
	}

	/**
	 * @return the mailbody
	 */
	public static String getMailbody() {
		return mailbody;
	}

	/**
	 * @param mailbody the mailbody to set
	 */
	public static void setMailbody(String mailbody) {
		MailBody.mailbody = mailbody;
	}
	
	public static void SetContent() throws Exception
	{
		
		ArrayList<String> temp = getDetail();
		
		String text = "Hi";
		
		int size = temp.size();
		
		for(int i=0;i<size;i++)
		{
			String str = temp.get(i);
			
			str = str.replaceAll("\n", "<br />");
			
			text += str;
		}
		
//		String text = temp.toString();
//		
//		text = text.replaceAll("[\\[\\]]", "");
//		
		setMailbody(text);
		
	}

}