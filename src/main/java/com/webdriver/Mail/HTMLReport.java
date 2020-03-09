package com.webdriver.Mail;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimeZone;

public class HTMLReport 
{
	 private PrintWriter f_out;
	    private String      outputDir = "D:////";
	
	    public static String msg = null;
	    
	 public void Check()
	 {
		 try
	        {
	            f_out = createWriter(outputDir);
	        } catch (IOException e)
	        {
	            e.printStackTrace();
	        }

	        startHtmlPage(f_out);
	        
	        endHtmlPage(f_out);

	        f_out.flush();
	        f_out.close();
	        
	       
	 }
	
	
	 private PrintWriter createWriter(String outdir) throws IOException
	    {
	        new File(outdir).mkdirs();
	        return new PrintWriter(new BufferedWriter(
	                new FileWriter(new File(outputDir, "T1.html"))));
	    }

	    /** Starts HTML Stream */
	    private void startHtmlPage(PrintWriter out)
	    {
	        out.println("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.1//EN http://www.w3.org/TR/xhtml11/DTD/xhtml11.dtd\">");
	        out.println("<html xmlns=\"http://www.w3.org/1999/xhtml\">");
	        out.println("<head>");
	        out.println("<title>My Company QA Automation Test Results Summary</title>");
	        out.println("</head>");
	        out.println("<body><div style=\"margin:0 auto; padding:15px; min-height:450px; min-width: 450px; height:auto;\">"
	                + "<div style=\"height:auto; background: #ded;padding:20px;box-shadow: 0 10px 6px -6px #777 \">"
	                + "<h1 style=\"background-color: #93b874; color: white; text-align: center; font-family: Georgia;\">My Company QA Automation Report</h1>");

	        Calendar currentdate = Calendar.getInstance();
	        String strdate = null;
	        DateFormat formatter = new SimpleDateFormat("dd-MM-yyyy hh:mm a z");
	        strdate = formatter.format(currentdate.getTime());

	        TimeZone obj = TimeZone.getTimeZone("IST");

	        formatter.setTimeZone(obj);
	        strdate = formatter.format(currentdate.getTime());

	        out.println("<br/><div align=\"right\">Report generated on: " + strdate + "</div><br/><br/>");

	        out.flush();
	    }

	    /** Finishes HTML Stream */
	    private void endHtmlPage(PrintWriter out)
	    {
	        out.println("<br/><br/><div align=\"right\"> &copy; <a href=\"http://www.mycompany.com\">2014 My Company Ltd.</a></div>");
	        out.println("</body></html>");
	    }
}
