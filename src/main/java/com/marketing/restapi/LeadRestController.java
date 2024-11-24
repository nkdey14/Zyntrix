package com.marketing.restapi;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.marketing.entity.Lead;
import com.marketing.repository.LeadRepository;

@RestController
@RequestMapping("/api/leads")
public class LeadRestController {

	@Autowired
	private LeadRepository leadRepo;
	
	//http://localhost:8084/api/leads
	@GetMapping
	public List<Lead> getAllLeadsInfo() {
		
		List<Lead> leads = leadRepo.findAll();
		
		return leads;
	}
	
	//http://localhost:8084/api/leads
	@PostMapping
	public void saveLeadInfo(@RequestBody Lead l) {
		
		leadRepo.save(l);
	}
	
	//http://localhost:8084/api/leads
	@DeleteMapping("/{id}")
	public void deleteLeadInfo(@PathVariable long id) {
		
		leadRepo.deleteById(id);
	}
	
//	@PutMapping
//	public void updateLeadInfo(@RequestBody Lead l) {
//		
//		leadRepo.save(l);
//	}
	
	// Approach - 2 of updating record
	
	@PutMapping("/{id}")
	public void updateLeadInfo(@PathVariable long id, @RequestBody Lead l) {
		
		Lead lead = leadRepo.findById(id).get();
		
		lead.setFirstName(l.getFirstName());
		lead.setLastName(l.getLastName());
		lead.setGender(l.getGender());
		lead.setEmail(l.getEmail());
		lead.setMobile(l.getMobile());
		lead.setCity(l.getCity());
		
		leadRepo.save(lead);
	}
}
