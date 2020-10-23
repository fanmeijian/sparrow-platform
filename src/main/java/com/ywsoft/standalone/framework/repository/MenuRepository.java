package com.ywsoft.standalone.framework.repository;

import java.math.BigInteger;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.ywsoft.standalone.framework.DataPermission;
import com.ywsoft.standalone.framework.entity.SwdMenu;


public interface MenuRepository extends CrudRepository<SwdMenu, String>,JpaRepository<SwdMenu, String> {

	List<SwdMenu> findByParentId(BigInteger i);

}
