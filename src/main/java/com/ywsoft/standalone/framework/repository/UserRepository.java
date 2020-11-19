package com.ywsoft.standalone.framework.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ywsoft.standalone.framework.entity.SwdAuthority;
import com.ywsoft.standalone.framework.entity.SwdSysrole;
import com.ywsoft.standalone.framework.entity.SwdUser;

public interface UserRepository extends JpaRepository<SwdUser, String> {
	@Query("SELECT s.swdAuthorities FROM SwdUser s WHERE s.username = ?1")
	List<SwdAuthority> userAuthorities(String username);

	@Query("SELECT s.swdSysroles FROM SwdUser s WHERE s.username = ?1")
	List<SwdSysrole> userSysroles(String username);
}
