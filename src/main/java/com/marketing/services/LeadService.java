package com.marketing.services;

import java.util.List;

import com.marketing.entity.Lead;

public interface LeadService {

	public void saveLeadInfo(Lead l);

	public List<Lead> getAllLeads();

	public void deleteLeadDetails(long id);

}
