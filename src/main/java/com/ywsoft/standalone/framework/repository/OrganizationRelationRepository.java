package com.ywsoft.standalone.framework.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ywsoft.standalone.framework.entity.SwdOrganizationRelation;
import com.ywsoft.standalone.framework.entity.SwdOrganizationRelationPK;
import com.ywsoft.standalone.framework.entity.ext.OrganizationRelationExt;

public interface OrganizationRelationRepository
		extends JpaRepository<SwdOrganizationRelation, SwdOrganizationRelationPK> {

	@Query("SELECT s FROM SwdOrganizationRelation s WHERE s.id.organizationId = ?1")
	List<SwdOrganizationRelation> findByOganizationId(String organizationId);

	//往下找关系
	@Query("SELECT new com.ywsoft.standalone.framework.entity.ext.OrganizationRelationExt(s,t,r.relation) "
			+ "FROM SwdOrganization s, SwdOrganization t,SwdOrganizationRelation r "
			+ "WHERE r.id.organizationId = ?1 "
			+ "AND s.id = r.id.organizationId "
			+ "AND t.id = r.id.targetId")
	List<OrganizationRelationExt> findByOrganizationIdExt(String organizationId);
	
	//往上找关系
	@Query("SELECT new com.ywsoft.standalone.framework.entity.ext.OrganizationRelationExt(s,t,r.relation) "
			+ "FROM SwdOrganization s, SwdOrganization t,SwdOrganizationRelation r "
			+ "WHERE r.id.targetId = ?1 "
			+ "AND s.id = r.id.organizationId "
			+ "AND t.id = r.id.targetId")
	List<OrganizationRelationExt> findByTargetIdExt(String targetId);
}
