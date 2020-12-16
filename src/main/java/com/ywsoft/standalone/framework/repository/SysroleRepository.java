package com.ywsoft.standalone.framework.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.ywsoft.standalone.framework.entity.SwdSysrole;
import com.ywsoft.standalone.framework.entity.SwdUser;

public interface SysroleRepository extends JpaRepository<SwdSysrole, String>{

	Page<SwdSysrole> findByNameContaining(String name,Pageable p);
}
