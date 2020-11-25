package com.ywsoft.standalone.framework.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ywsoft.standalone.framework.entity.SwdFieldPermission;
import com.ywsoft.standalone.framework.entity.SwdFieldPermissionPK;

public interface FieldPermissionRepository extends JpaRepository<SwdFieldPermission, SwdFieldPermissionPK> {

}
