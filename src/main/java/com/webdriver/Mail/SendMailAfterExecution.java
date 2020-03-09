package com.webdriver.Mail;

import com.webdriver.Data.DataSetCollectors;
import com.webdriver.UtilSection.Timestamp;

public class SendMailAfterExecution {
	static MailServer sendMail = new MailServer();

	//public static void SendMailAfterSuiteExecution(String userdir, DataSetCollectors data) 			throws Exception {
		
		public static void SendMailAfterSuiteExecution(String userdir)
				throws Exception {

		MailBody.SetContent();

		String filename = userdir + "\\Command line test.pdf";

		String subject = "Test Execution @" + Timestamp.current_timestamp();

		System.out.println(subject);

		String body = MailBody.getMailbody();

		//ArrayList<String> recipients = data.getEmaillist();

		/*sendMail.SendPDFReportByMail("automation.akeo@gmail.com",
				"Mail@Akeo", recipients, subject, body, filename);*/
		
		sendMail.SendPDFReportByMail("automation.akeo@gmail.com",
				"Mail@Akeo", "shivansh@akeo.no", subject, body, filename);
	}
}