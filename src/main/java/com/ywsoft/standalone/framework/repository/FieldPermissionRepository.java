package com.ywsoft.standalone.framework.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ywsoft.standalone.framework.entity.SwdFieldPermission;
import com.ywsoft.standalone.framework.entity.SwdFieldPermissionPK;

public interface FieldPermissionRepository extends JpaRepository<SwdFieldPermission, SwdFieldPermissionPK> {
	List<SwdFieldPermission> findByIdModelAndIdPermission(String model,String permission);
}
