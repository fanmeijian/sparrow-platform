package com.ywsoft.standalone.framework.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.ywsoft.standalone.framework.entity.SwdAuthority;
import com.ywsoft.standalone.framework.entity.SwdSysrole;

public interface SysroleRepository extends CrudRepository<SwdSysrole, String> ,JpaRepository<SwdSysrole, String>{

}
