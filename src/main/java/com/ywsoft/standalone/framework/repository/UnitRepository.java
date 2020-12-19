package com.ywsoft.standalone.framework.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ywsoft.standalone.framework.entity.SwdUnit;
import com.ywsoft.standalone.framework.entity.ext.UnitExt;

public interface UnitRepository extends JpaRepository<SwdUnit, String> {
	
	@Query("SELECT new com.ywsoft.standalone.framework.entity.ext.UnitExt(s) FROM SwdUnit s WHERE (?1 IS null OR s.parentId = ?1) AND s.swdOrganization.id = ?2")
	List<UnitExt> getByParentAndOrganization(String parentId,String organizationId);
	
	Page<SwdUnit> findBySwdOrganizationId(String organizationId, Pageable p);
	
}
