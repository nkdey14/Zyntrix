package com.marketing.util;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
//import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class EmailServiceImpl {
	
	@Autowired
    private JavaMailSender mailSender;
	
	public void sendSimpleEmail(String email, String subject, String content) {
		
		SimpleMailMessage mailMessage = new SimpleMailMessage();
		
		mailMessage.setTo(email);
		mailMessage.setSubject(subject);
		mailMessage.setText(content);
		
		mailSender.send(mailMessage);
	}

	public void sendEmailWithAttachment(String to, String subject, String body, MultipartFile attachment) throws Exception {
	    MimeMessage message = mailSender.createMimeMessage();
	    MimeMessageHelper helper = new MimeMessageHelper(message, true);

	    helper.setTo(to);
	    helper.setSubject(subject);
	    helper.setText(body, true);
	    helper.setFrom("your-email@gmail.com");

	    if (attachment != null) {
	        helper.addAttachment(attachment.getOriginalFilename(), attachment);
	    }

	    mailSender.send(message);
	}

}
