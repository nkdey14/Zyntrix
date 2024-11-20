package com.marketing.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.marketing.dto.LeadDto;
import com.marketing.entity.Lead;
import com.marketing.services.LeadService;
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
	
	// Fetching All Leads Records from DB
	
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

//	    model.addAttribute("lead", l);
	    
	    model.addAttribute("msg", "Lead Saved Successfully!!");

	    List<Lead> leads = leadService.getAllLeads();
	    model.addAttribute("leads", leads);
	    return "listLeads";
	}

	// Approach - 2 of Saving a New Record
	
/*	@RequestMapping("/saveLead")
	public String saveLeadInfo(LeadDto dto, Model model) {
		
		Lead l = new Lead();
		
		l.setId(dto.getId());
		l.setFirstName(dto.getFirstName());
		l.setLastName(dto.getLastName());
		l.setGender(dto.getGender());
		l.setEmail(dto.getEmail());
		l.setMobile(dto.getMobile());
		l.setCity(dto.getCity());
		
		leadService.saveLeadInfo(l);
		
		model.addAttribute("lead", l);
		
		model.addAttribute("msg","Lead Saved Successfully!!");
		
		List<Lead> leads = leadService.getAllLeads();
		model.addAttribute("leads", leads);
		return "listLeads";
	}
*/
	// Feature to Delete Lead Info
	
	@RequestMapping("/deleteLead")
	public String deleteLeadInfo(@RequestParam("id") long id, Model model) {
		
		leadService.deleteLeadDetails(id);
		model.addAttribute("msg", "Lead Details Deleted Successfully!!");
		List<Lead> leads = leadService.getAllLeads();
		model.addAttribute("leads", leads);
		return "listLeads";
	}
	
	// Fetching Lead Info
	
	@RequestMapping("/updateLead")
	public String getLeadDetails(@RequestParam("id") long id, Model model) {
		
		Lead lead = leadService.getLeadInfo(id);
		
		model.addAttribute("lead", lead);
		
		return "updateLead";
	}
	
	// Updating Lead Details
	
	@RequestMapping("/updateLeadData")
	public String updateLeadInfo(LeadDto dto, Model model) {
		
		Lead l = new Lead();
		
		l.setId(dto.getId());
		l.setFirstName(dto.getFirstName());
		l.setLastName(dto.getLastName());
		l.setGender(dto.getGender());
		l.setEmail(dto.getEmail());
		l.setMobile(dto.getMobile());
		l.setCity(dto.getCity());
		
		leadService.saveLeadInfo(l);
		
		model.addAttribute("msg","Lead Details Updated Successfully!!");
		
		List<Lead> leads = leadService.getAllLeads();
		model.addAttribute("leads", leads);
		return "listLeads";

	}
	
	// Integrated iText Pdf API 
	
	@RequestMapping("/exportToPdf")
	public void exportLeadToPdf(@RequestParam("id") long id, HttpServletResponse response) throws Exception {
	
	    Lead lead = leadService.getLeadInfo(id);

	    // Set response properties for PDF download
	    response.setContentType("application/pdf");
	    response.setHeader("Content-Disposition", "attachment; filename=lead_" + lead.getFirstName() + "_" + lead.getLastName() + ".pdf");

	    // Create a document instance
	    Document document = new Document();

	    // Create PDF writer instance
	    PdfWriter.getInstance(document, response.getOutputStream());

	    // Open the document
	    document.open();

	    // Add content to the PDF
	    document.add(new Paragraph("==================== Lead Details ====================="));
	    document.add(new Paragraph("First Name: " + lead.getFirstName()));
	    document.add(new Paragraph("Last Name: " + lead.getLastName()));
	    document.add(new Paragraph("Gender: " + lead.getGender()));
	    document.add(new Paragraph("Email: " + lead.getEmail()));
	    document.add(new Paragraph("Mobile: " + lead.getMobile()));
	    document.add(new Paragraph("City: " + lead.getCity()));

	    // Close the document
	    document.close();
	}
	
	@RequestMapping("/leadInfo")
	public String showLeadInfo(@RequestParam("id") long id, Model model) {
		
		Lead l = leadService.getLeadInfo(id);
		
		model.addAttribute("lead", l);
		
		return "leadInfo";
	}

}
