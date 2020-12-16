package com.ywsoft.standalone.framework.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ywsoft.standalone.framework.entity.SwdUserDataPermission;
import com.ywsoft.standalone.framework.entity.SwdUserDataPermissionPK;

public interface UserDataPermissionRepository extends JpaRepository<SwdUserDataPermission, SwdUserDataPermissionPK> {

	List<SwdUserDataPermission> findByIdUsername(String username);
	
	List<SwdUserDataPermission> findByIdModelAndIdPkeyAndIdPermission(String model, String pkey, String permission);
}
