package com.ywsoft.standalone.framework.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ywsoft.standalone.framework.entity.SwdApp;

public interface AppRepository extends JpaRepository<SwdApp, String> {

}
