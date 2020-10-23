package com.ywsoft.standalone.framework.repository;

import org.springframework.data.repository.CrudRepository;

import com.ywsoft.standalone.framework.entity.SwdDataPermission;
import com.ywsoft.standalone.framework.entity.SwdDataPermissionPK;

public interface DataPermissionRepository extends CrudRepository<SwdDataPermission, SwdDataPermissionPK> {

}
