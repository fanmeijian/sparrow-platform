package com.ywsoft.standalone.framework.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ywsoft.standalone.framework.entity.SwdLevel;

public interface LevelRepository extends JpaRepository<SwdLevel, String> {

}
