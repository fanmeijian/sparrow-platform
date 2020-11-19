package com.ywsoft.standalone.framework.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ywsoft.standalone.framework.entity.SwdGroup;
import com.ywsoft.standalone.framework.entity.SwdSubGroup;
import com.ywsoft.standalone.framework.entity.SwdSubGroupPK;

public interface SubGroupRepository extends JpaRepository<SwdSubGroup, SwdSubGroupPK> {
	@Query("SELECT s FROM SwdGroup s, SwdSubGroup t WHERE s.id = t.id.subGroupId AND t.id.groupId = ?1")
	List<SwdGroup> findByGroupId(String id);
}
