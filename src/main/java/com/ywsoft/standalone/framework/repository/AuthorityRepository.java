package com.ywsoft.standalone.framework.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.ywsoft.standalone.framework.entity.SwdAuthority;

public interface AuthorityRepository extends CrudRepository<SwdAuthority, String>,JpaRepository<SwdAuthority, String> {
	
	@Query("SELECT s.swdAuthorities FROM SwdUser s WHERE s.username=?1")
	List<SwdAuthority>findByUsername(String sername);
	
//	@Query("SELECT r.swdAuthorities FROM SwdSysrole r WHERE r.id IN (SELECT ur.swdSysroles.id FROM SwdUser ur WHERE ur.username=?1)")
//	List<SwdAuthority>findBySysroleId(String sysroleId);
}
