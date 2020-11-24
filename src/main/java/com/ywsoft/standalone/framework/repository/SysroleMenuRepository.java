package com.ywsoft.standalone.framework.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ywsoft.standalone.framework.entity.SwdSysroleMenu;
import com.ywsoft.standalone.framework.entity.SwdSysroleMenuPK;

public interface SysroleMenuRepository extends JpaRepository<SwdSysroleMenu, SwdSysroleMenuPK> {

}
