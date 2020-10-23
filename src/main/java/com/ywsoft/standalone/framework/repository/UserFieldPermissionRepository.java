package com.ywsoft.standalone.framework.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.ywsoft.standalone.framework.entity.SwdUserFieldPermission;
import com.ywsoft.standalone.framework.entity.SwdUserFieldPermissionPK;

public interface UserFieldPermissionRepository extends CrudRepository<SwdUserFieldPermission, SwdUserFieldPermissionPK> {

	@Query("SELECT s FROM SwdUserFieldPermission s WHERE s.id.username=?1 AND s.id.model=?2")
	List<SwdUserFieldPermission> findByUsernameAndModel(String username, String model);

	@Query("SELECT s FROM SwdUserFieldPermission s WHERE s.id.username=?1 AND s.id.model=?2 AND s.id.field=?3")
	List<SwdUserFieldPermission> findByUsernameAndModelAndField(String username, String model, String field);

	@Query("SELECT s FROM SwdUserFieldPermission s WHERE s.id.model=?1 AND s.id.field=?2")
	List<SwdUserFieldPermission> findByModelAndField(String model,String field);
	
	@Query("SELECT s FROM SwdUserFieldPermission s WHERE s.id.model=?1")
	List<SwdUserFieldPermission> findByModel(String model);
	
}
