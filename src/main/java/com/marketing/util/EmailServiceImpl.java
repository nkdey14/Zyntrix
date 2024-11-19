package com.marketing.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class EmailServiceImpl implements EmailService {
	
	@Autowired
    private JavaMailSender mailSender;

	@Override
	public void sendEmail(String to, String subject, String message) {
		
		SimpleMailMessage msg = new SimpleMailMessage();
		
		msg.setTo(to);
		msg.setSubject(subject);
		msg.setText(message);
		msg.setFrom("im.pandey264@gmail.com");
		
		mailSender.send(msg);

	}

}
