package com.marketing.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import com.marketing.entity.Lead;

public interface LeadService {

	public void saveLeadInfo(Lead l);

	public List<Lead> getAllLeads();

	public void deleteLeadDetails(long id);

	public Lead getLeadInfo(long id);

	public Page<Lead> getAllLeadsPaginated(PageRequest of);

}
