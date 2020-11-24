package com.ywsoft.standalone.framework.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ywsoft.standalone.framework.entity.SwdSysroleAuthority;
import com.ywsoft.standalone.framework.entity.SwdSysroleAuthorityPK;

public interface SysroleAuthorityRepository extends JpaRepository<SwdSysroleAuthority, SwdSysroleAuthorityPK> {
//	@Query("SELECT s FROM ")
}
