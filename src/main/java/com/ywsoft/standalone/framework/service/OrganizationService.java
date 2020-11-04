package com.ywsoft.standalone.framework.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ywsoft.standalone.framework.entity.SwdOrganizationRelation;
import com.ywsoft.standalone.framework.entity.SwdOrganizationRelationPK;
import com.ywsoft.standalone.framework.repository.OrganizationRelationRepository;


@RestController
public class OrganizationService {
	@Autowired
	OrganizationRelationRepository organizationRelationRepository;
	
	/**
	 * 创建组织关系
	 * @param swdOrganizationRelation
	 * @return
	 */
	@PostMapping("/organizationRelation")
	public SwdOrganizationRelation makeRelation(@RequestBody SwdOrganizationRelation swdOrganizationRelation) {
		return organizationRelationRepository.save(swdOrganizationRelation);
	}
	
	@GetMapping("/relatedOrganization/{organizationId}")
	public List<SwdOrganizationRelation> getRelatedOrganizations(@PathVariable(name="organizationId") String organizationId) {
		return organizationRelationRepository.findByOganizationId(organizationId);
	}
	
	@DeleteMapping("/relatedOrganization")
	public void delRelatedOrganization(@RequestBody SwdOrganizationRelationPK id) {
		organizationRelationRepository.deleteById(id);
	}
	
	@PutMapping("/organizationRelation")
	public SwdOrganizationRelation updateRelation(@RequestBody SwdOrganizationRelation swdOrganizationRelation) {
		return organizationRelationRepository.save(swdOrganizationRelation);
	}
}
