package com.ywsoft.standalone.framework.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.ywsoft.standalone.framework.entity.SwdLevel;
import com.ywsoft.standalone.framework.entity.SwdOrganization;

public interface LevelRepository extends JpaRepository<SwdLevel, String> {
	Page<SwdLevel> findBySwdOrganization(SwdOrganization organization,Pageable p);
}
