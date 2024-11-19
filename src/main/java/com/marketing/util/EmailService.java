package com.marketing.util;

import org.springframework.web.multipart.MultipartFile;

public interface EmailService {

	public void sendEmailWithAttachment(String to, String subject, String body, MultipartFile attachment);
}
