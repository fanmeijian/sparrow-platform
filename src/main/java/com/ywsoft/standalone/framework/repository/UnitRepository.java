package com.ywsoft.standalone.framework.repository;

import org.springframework.data.repository.CrudRepository;

import com.ywsoft.standalone.framework.entity.SwdUnit;

public interface UnitRepository extends CrudRepository<SwdUnit, String> {

}
