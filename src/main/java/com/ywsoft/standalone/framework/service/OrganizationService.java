package com.ywsoft.standalone.framework.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ywsoft.standalone.framework.entity.SwdOrganization;
import com.ywsoft.standalone.framework.entity.SwdOrganizationRelation;
import com.ywsoft.standalone.framework.entity.SwdOrganizationRelationPK;
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
	 * 创建组织关系
	 * @param swdOrganizationRelation
	 * @return
	 */
	@PostMapping("/organizationRelation")
	public SwdOrganizationRelation makeRelation(@RequestBody SwdOrganizationRelation swdOrganizationRelation) {
		return organizationRelationRepository.save(swdOrganizationRelation);
	}
	
	
	@DeleteMapping("/organizationRelation")
	public void delRelation(@RequestBody SwdOrganizationRelationPK id) {
		organizationRelationRepository.deleteById(id);
	}
	
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
	

	
	/**
	 * 删除组织
	 * @param id
	 */
	@DeleteMapping("/relatedOrganization")
	public void delRelatedOrganization(@RequestBody SwdOrganizationRelationPK id) {
		organizationRelationRepository.deleteById(id);
	}
	
	
	/**
	 * 更新组织
	 * @param swdOrganizationRelation
	 * @return
	 */
	@PutMapping("/organizationRelation")
	public SwdOrganizationRelation updateRelation(@RequestBody SwdOrganizationRelation swdOrganizationRelation) {
		return organizationRelationRepository.save(swdOrganizationRelation);
	}
	
	/**
	 * 员工树
	 */
	@GetMapping("/employeeTree")
	public void employeeTree() {
		
	}
	
	/**
	 * 岗位树
	 */
	@GetMapping("/roleTree")
	public void roleTree() {
		
	}
	
	/**
	 * 职级树
	 */
	@GetMapping("/levelTree")
	public void levelTree() {
		
	}
	
	/**
	 * 组织大树,含所有人员任职的岗位、职级、所在部门、公司
	 */
	@GetMapping("/organizationTree")
	public void organizationTree() {
		
	}
}
