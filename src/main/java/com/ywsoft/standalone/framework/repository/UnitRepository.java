package com.ywsoft.standalone.framework.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ywsoft.standalone.framework.entity.SwdUnit;

public interface UnitRepository extends JpaRepository<SwdUnit, String> {

}
