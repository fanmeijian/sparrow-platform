package com.ywsoft.standalone.framework.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.ywsoft.standalone.framework.entity.SwdOrganization;
import com.ywsoft.standalone.framework.entity.ext.OrganizationExt;
import com.ywsoft.standalone.framework.repository.OrganizationRelationRepository;
import com.ywsoft.standalone.framework.repository.OrganizationRepository;

/***
 * 
 * @author fanmj
 * 
 * 组织服务，包含了所有关于组织的设置服务
 *
 */
@RestController
public class OrganizationService {
	@Autowired
	OrganizationRelationRepository organizationRelationRepository;
	@Autowired
	OrganizationRepository organizationRepository;
	
	/**
	 * 获取关联组织列表
	 * @param organizationId
	 * @return
	 */
	@GetMapping("/relatedOrganization/{organizationId}")
	public ApiResponse getRelatedOrganizations(@PathVariable(name="organizationId") String organizationId) {
		Optional<SwdOrganization> optional = organizationRepository.findById(organizationId);
		if(optional.isEmpty()) return HttpBusinessStatusCode.ORGANIZATION_NOT_FOUND;
		OrganizationExt organizationExt = new OrganizationExt(optional.get());
		organizationTree(organizationExt);
		organizationTreeSource(organizationExt);
		return ApiResponseFactory.getNormalReponse(organizationExt);
	}
	
	
	private void organizationTree(OrganizationExt organizationExt) {
		organizationRelationRepository.findByTargetIdExt(organizationExt.getId()).forEach(o->{
			organizationExt.getSources().add(o);
			o.setTargetExt(null);
			organizationTree(o.getOrganizationExt());
		});
	}
	
	private void organizationTreeSource(OrganizationExt organizationExt) {
		organizationRelationRepository.findByOrganizationIdExt(organizationExt.getId()).forEach(o->{
			organizationExt.getTargets().add(o);
			o.setOrganizationExt(null);
			organizationTreeSource(o.getTargetExt());
		});
	}
	

}
