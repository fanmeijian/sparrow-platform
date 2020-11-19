package com.ywsoft.standalone.framework.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ywsoft.standalone.framework.entity.SwdSysroleFieldPermission;
import com.ywsoft.standalone.framework.entity.SwdSysroleFieldPermissionPK;

public interface SysroleFieldPermissionRepository extends JpaRepository<SwdSysroleFieldPermission, SwdSysroleFieldPermissionPK> {

}
