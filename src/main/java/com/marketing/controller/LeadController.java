package com.marketing.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.marketing.dto.LeadDto;
import com.marketing.entity.Lead;
import com.marketing.repository.LeadRepository;
import com.marketing.services.LeadService;
import com.marketing.util.EmailService;

@Controller
public class LeadController {

	//Handler Methods
	//http://localhost:8084/leadRegistration
	@Autowired
	private LeadService leadService;
	
	@Autowired
	private EmailService emailService;
	
	
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
	public String saveLeadInfo(@ModelAttribute("lead") Lead l, Model model) {
		
//		System.out.println(l.getId());
//		System.out.println(l.getFirstName());
//		System.out.println(l.getLastName());
//		System.out.println(l.getGender());
//		System.out.println(l.getEmail());
//		System.out.println(l.getMobile());
//		System.out.println(l.getCity());
		
		leadService.saveLeadInfo(l);
		
		emailService.sendEmail(l.getEmail(), "Welcome User!", "Hi,\n\nRegistration Successful!\n\nThanks & Regards,\n\nMarketing Support Team\nNK Solutions Pvt. Ltd.");
		
		model.addAttribute("lead", l);
		
		model.addAttribute("msg","Lead Saved Successfully!!");
		
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
