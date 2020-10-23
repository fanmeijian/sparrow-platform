package com.ywsoft.standalone.framework.repository;

import org.springframework.data.repository.CrudRepository;

import com.ywsoft.standalone.framework.entity.SwdGroup;

public interface GroupRepository extends CrudRepository<SwdGroup, String> {

}
