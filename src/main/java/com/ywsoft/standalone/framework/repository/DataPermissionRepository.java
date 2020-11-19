package com.ywsoft.standalone.framework.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ywsoft.standalone.framework.entity.SwdDataPermission;
import com.ywsoft.standalone.framework.entity.SwdDataPermissionPK;

public interface DataPermissionRepository extends JpaRepository<SwdDataPermission, SwdDataPermissionPK> {

}
