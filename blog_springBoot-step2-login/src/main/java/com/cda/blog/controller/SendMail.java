package com.cda.blog.controller;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendMail {
	public static void sendMail(String mailTo, String token) {
		final String mailFrom = "guiserras@gmail.com";
		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com");
		//SMTP Host
		props.put("mail.smtp.socketFactory.port", "465");
		//SSL Port
		props.put("mail.smtp.socketFactory.class",
				"javax.net.ssl.SSLSocketFactory"); //SSL
		//Factory Class
		props.put("mail.smtp.auth", "true"); //Enabling
		//SMTP Authentication
		props.put("mail.smtp.port", "465"); //SMTP Port
		Session session = Session.getInstance(props,
				new Authenticator() {
			protected PasswordAuthentication
			getPasswordAuthentication() {
				return new
						PasswordAuthentication("guiserras@gmail.com",
								"qfknfyqamhcrofkq");
			}
		}
				);
		try {
			Message msg = new MimeMessage(session);
			msg.setFrom(new InternetAddress(mailFrom));
			msg.setRecipients(Message.RecipientType.TO,
					InternetAddress.parse(mailTo));
			msg.setSubject("Blog article");
			msg.setText("Ceci est un test");
			msg.setContent("<a href='http://localhost:8080/regitrationConfirm?token="+token+"'>un lien </a>", "text/html; charset=utf-8");
			Transport.send(msg);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e);
			System.out.println("KOOOOOOKKkKKKKKKKKKkk");
		}
	}
}
