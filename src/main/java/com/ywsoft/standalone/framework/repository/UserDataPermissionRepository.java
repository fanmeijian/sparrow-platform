package com.ywsoft.standalone.framework.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ywsoft.standalone.framework.entity.SwdUserDataPermission;
import com.ywsoft.standalone.framework.entity.SwdUserDataPermissionPK;

public interface UserDataPermissionRepository extends JpaRepository<SwdUserDataPermission, SwdUserDataPermissionPK> {

}
