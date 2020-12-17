package com.ywsoft.standalone.framework.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.ywsoft.standalone.framework.entity.SwdGroupUser;
import com.ywsoft.standalone.framework.entity.SwdGroupUserPK;

public interface GroupUserRepository extends JpaRepository<SwdGroupUser, SwdGroupUserPK> {
	
	Page<SwdGroupUser> findByIdGroupId(String groupId,Pageable p);

}
