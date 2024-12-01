package com.marketing.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.marketing.entity.Lead;
import com.marketing.repository.LeadRepository;

@Service
public class LeadServiceImpl implements LeadService {

	@Autowired
	private LeadRepository leadRepo;
	
	@Override
	public void saveLeadInfo(Lead l) {
		leadRepo.save(l);
	}

	@Override
	public List<Lead> getAllLeads() {
		List<Lead> leads = leadRepo.findAll();
		return leads;
	}

	@Override
	public void deleteLeadDetails(long id) {
		leadRepo.deleteById(id);
		
	}

	@Override
	public Lead getLeadInfo(long id) {
		return leadRepo.findById(id).get();
		
	}

	@Override
	public Page<Lead> getAllLeadsPaginated(PageRequest pageRequest) {
		
        return leadRepo.findAll(pageRequest);
    }

}
