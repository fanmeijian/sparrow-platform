package com.ywsoft.standalone.framework.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ywsoft.standalone.framework.entity.SwdUserMenu;
import com.ywsoft.standalone.framework.entity.SwdUserMenuPK;

public interface UserMenuRepository extends JpaRepository<SwdUserMenu, SwdUserMenuPK> {

}
