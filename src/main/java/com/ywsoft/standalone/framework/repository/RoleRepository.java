package com.ywsoft.standalone.framework.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ywsoft.standalone.framework.entity.SwdRole;

public interface RoleRepository extends JpaRepository<SwdRole, String> {

}
