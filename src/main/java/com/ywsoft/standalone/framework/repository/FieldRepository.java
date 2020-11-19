package com.ywsoft.standalone.framework.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.ywsoft.standalone.framework.entity.SwdField;
import com.ywsoft.standalone.framework.entity.SwdFieldPK;

public interface FieldRepository extends JpaRepository<SwdField, SwdFieldPK> {

	@Modifying
	@Query("DELETE FROM SwdField s WHERE s.id.model=?1")
	void deleteByModel(String model);
}
