package com.example.applications.mailing;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

@Component
public class SMTPMail {
	@Autowired
	private JavaMailSender jmailsend;
	
	public void sendEmailTo(String to,String sub,String msg) throws MessagingException {
	
		MimeMessage messages = jmailsend.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(messages,true);
		helper.setSubject(sub);
		helper.setText(msg);
		helper.setTo(to);
		
		jmailsend.send(messages);
		
	}

}
