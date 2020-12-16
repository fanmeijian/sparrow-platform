package com.ywsoft.standalone.framework.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ywsoft.standalone.framework.entity.SwdSysrole;
import com.ywsoft.standalone.framework.entity.SwdSysroleDataPermission;
import com.ywsoft.standalone.framework.entity.SwdSysroleDataPermissionPK;

public interface SysroleDataPermissionRepository extends JpaRepository<SwdSysroleDataPermission, SwdSysroleDataPermissionPK> {

	@Query("SELECT s FROM SwdSysrole s WHERE s.id IN (SELECT b.id.sysroleId FROM SwdSysroleDataPermission b WHERE b.id.model=?1 AND b.id.pkey = ?2 AND b.id.permission = ?3)")
	List<SwdSysrole> findByIdModelAndIdPkeyAndIdPermission(String model, String pkey, String permission);

}
