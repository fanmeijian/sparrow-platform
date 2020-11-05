package com.ywsoft.standalone.framework.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.ywsoft.standalone.framework.entity.SwdGroupUser;
import com.ywsoft.standalone.framework.entity.SwdGroupUserPK;
import com.ywsoft.standalone.framework.entity.SwdUser;

public interface GroupUserRepository extends CrudRepository<SwdGroupUser, SwdGroupUserPK> {
	
	@Query("SELECT s FROM SwdUser s, SwdGroupUser t WHERE s.username = t.id.username AND t.id.groupId = ?1")
	List<SwdUser> findByGroupId(String id);
}
