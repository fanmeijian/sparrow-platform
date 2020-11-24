package com.ywsoft.standalone.framework.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ywsoft.standalone.framework.entity.SwdUserAuthority;
import com.ywsoft.standalone.framework.entity.SwdUserAuthorityPK;

public interface UserAuthorityRepository extends JpaRepository<SwdUserAuthority, SwdUserAuthorityPK> {

}
