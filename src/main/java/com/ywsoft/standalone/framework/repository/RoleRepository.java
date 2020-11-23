package com.ywsoft.standalone.framework.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.ywsoft.standalone.framework.entity.SwdOrganization;
import com.ywsoft.standalone.framework.entity.SwdRole;

public interface RoleRepository extends JpaRepository<SwdRole, String> {
	Page<SwdRole> findBySwdOrganization(SwdOrganization organization,Pageable p);
}
