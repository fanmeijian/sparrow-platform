package com.ywsoft.standalone.framework.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ywsoft.standalone.framework.entity.SwdGroup;
import com.ywsoft.standalone.framework.entity.SwdSubGroup;
import com.ywsoft.standalone.framework.entity.SwdSubGroupPK;
import com.ywsoft.standalone.framework.entity.ext.GroupExt;

public interface SubGroupRepository extends JpaRepository<SwdSubGroup, SwdSubGroupPK> {
//	@Query("SELECT s FROM SwdGroup s, SwdSubGroup t WHERE s.id = t.id.subGroupId AND t.id.groupId = ?1")
//	Page<SwdGroup> findByGroupId(String id,Pageable p);
//	
//	
//	@Query("SELECT new com.ywsoft.standalone.framework.entity.ext.GroupExt(s) FROM SwdGroup s, SwdSubGroup t WHERE s.id = t.id.subGroupId AND t.id.groupId = ?1")
//	List<GroupExt> findByGroupId(String id);
	
	Page<SwdSubGroup> findByIdGroupId(String groupId, Pageable p);
	
}
