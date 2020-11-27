package com.ywsoft.standalone.framework.repository;

import java.math.BigInteger;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.ywsoft.standalone.framework.DataPermissionInterface;
import com.ywsoft.standalone.framework.entity.SwdMenu;


public interface MenuRepository extends JpaRepository<SwdMenu, String> {

	List<SwdMenu> findByParentId(BigInteger i);
	
	@Query("SELECT DISTINCT s FROM SwdMenu s "
			+ "WHERE s.id IN (SELECT um.id.menuId FROM SwdUserMenu um WHERE um.id.username = ?1) "
			+ "OR s.id IN (SELECT rm.id.menuId FROM SwdSysroleMenu rm WHERE rm.id.sysroleId IN "
			+ "(SELECT us.id.sysroleId FROM SwdUserSysrole us WHERE us.id.username = ?1))")
	List<SwdMenu> findByUser(String username);

}
