package com.ywsoft.standalone.framework.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.ywsoft.standalone.framework.entity.SwdUserSysrole;
import com.ywsoft.standalone.framework.entity.SwdUserSysrolePK;

public interface UserSysroleRepository extends JpaRepository<SwdUserSysrole, SwdUserSysrolePK> {
	Page<SwdUserSysrole> findByIdUsername(String username,Pageable p);
}
