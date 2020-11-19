package com.ywsoft.standalone.framework.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ywsoft.standalone.framework.entity.SwdOrganizationRelation;
import com.ywsoft.standalone.framework.entity.SwdOrganizationRelationPK;

public interface OrganizationRelationRepository extends JpaRepository<SwdOrganizationRelation, SwdOrganizationRelationPK> {
	
	@Query("SELECT s FROM SwdOrganizationRelation s WHERE s.id.organizationId = ?1")
	List<SwdOrganizationRelation> findByOganizationId(String organizationId);
}
