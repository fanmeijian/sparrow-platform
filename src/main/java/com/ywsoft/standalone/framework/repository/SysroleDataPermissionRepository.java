package com.ywsoft.standalone.framework.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ywsoft.standalone.framework.entity.SwdSysroleDataPermission;
import com.ywsoft.standalone.framework.entity.SwdSysroleDataPermissionPK;

public interface SysroleDataPermissionRepository extends JpaRepository<SwdSysroleDataPermission, SwdSysroleDataPermissionPK> {

}
