package com.android.Mail;

import java.util.ArrayList;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Authenticator;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.apache.log4j.Logger;

public class MailServer {
	/**
	 * Send email using java
	 * 
	 * @param FromAddress
	 * @param Password
	 * @param recipients
	 * @param MailSubject
	 * @param body
	 */
	public void SendPDFReportByMail(final String FromAddress,
			final String Password, ArrayList<String> Recipients,
			String MailSubject, String body, String PDFFilePath) {
		Logger log = Logger.getLogger("Mail Server");
		log.info("Sending PDF Report by Mail After Suite Execution with screenshots attached");

		// Applying new Properties
		Properties props = new Properties();

		final String smtp_connection = "SSL"; // Use 'TLS' or 'SSL' connection

		String host = "smtp.gmail.com";
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.user", FromAddress);
		props.put("mail.smtp.password", Password);
		props.put("mail.smtp.auth", "true");

		if (smtp_connection.equals("TLS")) {
			props.put("mail.smtp.starttls.enable", "true");
			props.put("mail.smtp.port", "587");
		} else {
			props.put("mail.smtp.socketFactory.port", "465");
			props.put("mail.smtp.socketFactory.class",
					"javax.net.ssl.SSLSocketFactory");
			props.put("mail.smtp.port", "465");
		}

		Session session = Session.getInstance(props, new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(FromAddress, Password);
			}
		});

		MimeMessage message = new MimeMessage(session);

		try {
			log.info("Creating user session...");

			// Set from address
			message.setFrom(new InternetAddress(FromAddress));

			for (int i = 0; i < Recipients.size(); i++) {
				message.addRecipients(Message.RecipientType.TO,
						InternetAddress.parse(Recipients.get(i)));
			}

			// Set subject
			message.setSubject(MailSubject);

			BodyPart messageBodyPart = new MimeBodyPart();
			messageBodyPart.setContent(body, "text/html; charset=utf-8");
			log.info("Message body and subject set...");

			Multipart multipart = new MimeMultipart();
			multipart.addBodyPart(messageBodyPart);

			if (PDFFilePath != null) {
				messageBodyPart = new MimeBodyPart();
				String filename = PDFFilePath;
				log.info("Ataching the PDF Report generated....");

				DataSource source = new FileDataSource(filename);
				messageBodyPart.setDataHandler(new DataHandler(source));
				messageBodyPart.setFileName(filename);
				multipart.addBodyPart(messageBodyPart);
			}

			message.setContent(multipart);
			// Transport.send(message);

			Transport transport = session.getTransport("smtp");

			transport.connect(host, FromAddress, Password);
			transport.sendMessage(message, message.getAllRecipients());
			transport.close();
			log.info("Mail successfully delivered....");

		}

		catch (AddressException ae) {

			ae.printStackTrace();

		}

		catch (MessagingException me) {

			log.error("Some Exception while sending mail...");
			log.error("Exception message/body: " + me);

		}

	}

}