package com.marketing.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.marketing.dto.EmailDto;
import com.marketing.util.EmailServiceImpl;

@Controller
public class EmailController {
	
	@Autowired
	private EmailServiceImpl emailService;

	@RequestMapping("/sendEmail")
	public String getEmailInfo(@RequestParam String email, Model model) {
		
		model.addAttribute("email", email);
		
		return "composeEmail";
	}
	
	@RequestMapping("/composeEmail")
	public String sendEmail(EmailDto emailDto, Model model) {
		
		emailService.sendSimpleEmail(emailDto.getEmail(), emailDto.getSubject(), emailDto.getContent());
		
		model.addAttribute("msg", "Email Sent Successfully!!");
		
		return "composeEmail";
	}
}
