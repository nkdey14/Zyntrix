package com.marketing.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.marketing.dto.LeadDto;
import com.marketing.entity.Lead;
import com.marketing.repository.LeadRepository;
import com.marketing.services.LeadService;
import com.marketing.util.EmailService;
import com.marketing.util.EmailServiceImpl;

@Controller
public class LeadController {

	//Handler Methods
	//http://localhost:8084/leadRegistration
	@Autowired
	private LeadService leadService;
	
	@Autowired
	private EmailServiceImpl emailService;
	
	
	@RequestMapping("/leadRegistration")
	public String viewLeadRegistrationPage() {
		
		return "newLead";
	}
	
	@RequestMapping("/listAllleads")
	public String viewAllLeads(Model model) {
		
		List<Lead> leads = leadService.getAllLeads();
		model.addAttribute("leads", leads);
		return "listLeads";
	}
	
	// Approach - 1 of Saving a New Record
	
	@RequestMapping("/saveLead")
	public String saveLeadInfo(@ModelAttribute("lead") Lead l, Model model, MultipartFile welcomeAttachment) {

	    leadService.saveLeadInfo(l);

	    // Compose an HTML email body
	    String emailBody = "<html>"
	            + "<body>"
	            + "<h3>Hi " + l.getFirstName() + ",</h3>"
	            + "<p>Welcome to <b>NK Solutions Pvt. Ltd.</b>!</p>"
	            + "<p>Your registration was successful.</p>"
	            + "<p>We are excited to have you on board and look forward to working with you.</p>"
	            + "<br>"
	            + "<p><b>Thanks & Regards,</b></p>"
	            + "<p>Marketing Support Team</p>"
	            + "<p>NK Solutions Pvt. Ltd.</p>"
	            + "</body>"
	            + "</html>";

	    // Send the email with an attachment
	    try {
	        emailService.sendEmailWithAttachment(
	                l.getEmail(),
	                "Welcome to Zyntrix!!",
	                emailBody,
	                welcomeAttachment
	        );
	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    model.addAttribute("lead", l);
	    model.addAttribute("msg", "Lead Saved Successfully!!");

	    List<Lead> leads = leadService.getAllLeads();
	    model.addAttribute("leads", leads);
	    return "listLeads";
	}

	// Approach - 2 of Saving a New Record
	
//	@RequestMapping("/saveLead")
//	public String saveLeadInfo(LeadDto dto, Model model) {
//		
//		Lead l = new Lead();
//		
//		l.setId(dto.getId());
//		l.setFirstName(dto.getFirstName());
//		l.setLastName(dto.getLastName());
//		l.setGender(dto.getGender());
//		l.setEmail(dto.getEmail());
//		l.setMobile(dto.getMobile());
//		l.setCity(dto.getCity());
//		
//		leadService.saveLeadInfo(l);
//		
//		model.addAttribute("lead", l);
//		
//		model.addAttribute("msg","Lead Saved Successfully!!");
//		
//		List<Lead> leads = leadService.getAllLeads();
//		model.addAttribute("leads", leads);
//		return "listLeads";
//	}

	
	@RequestMapping("/deleteLead")
	public String deleteLeadInfo(@RequestParam("id") long id, Model model) {
		
		leadService.deleteLeadDetails(id);
		model.addAttribute("msg", "Lead Details Deleted Successfully!!");
		List<Lead> leads = leadService.getAllLeads();
		model.addAttribute("leads", leads);
		return "listLeads";
	}
}
