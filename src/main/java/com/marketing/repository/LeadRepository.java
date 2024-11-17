package com.marketing.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.marketing.entity.Lead;

public interface LeadRepository extends JpaRepository<Lead, Long> {

}
