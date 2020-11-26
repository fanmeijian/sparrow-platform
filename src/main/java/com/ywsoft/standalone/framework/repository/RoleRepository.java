package com.ywsoft.standalone.framework.repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;

import com.ywsoft.standalone.framework.DataPermissionInterface;
import com.ywsoft.standalone.framework.entity.SwdRole;

public interface RoleRepository extends JpaRepository<SwdRole, String> {
	
	Page<SwdRole> findBySwdOrganizationId(String organizationId,Pageable p);
	
	/**
	 * 数据权限的例子
	 */
//	@PreAuthorize("hasPermission(#id,'com.ywsoft.standalone.framework.entity.SwdRole','READ')")
//	@DataPermissionInterface(path = "", permission = "READ")
//	Optional<SwdRole> findById(String id);
	
}
