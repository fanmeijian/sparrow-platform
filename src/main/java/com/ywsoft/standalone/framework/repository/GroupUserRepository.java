package com.ywsoft.standalone.framework.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ywsoft.standalone.framework.entity.SwdGroupUser;
import com.ywsoft.standalone.framework.entity.SwdGroupUserPK;
import com.ywsoft.standalone.framework.entity.SwdUser;

public interface GroupUserRepository extends JpaRepository<SwdGroupUser, SwdGroupUserPK> {
	
	@Query("SELECT s FROM SwdUser s, SwdGroupUser t WHERE s.username = t.id.username AND t.id.groupId = ?1")
	Page<SwdUser> findByGroupId(String id,Pageable p);

}
