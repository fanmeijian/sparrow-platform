package com.ywsoft.standalone.framework.repository;

import org.springframework.data.repository.CrudRepository;

import com.ywsoft.standalone.framework.entity.SwdApp;

public interface AppRepository extends CrudRepository<SwdApp, String> {

}
