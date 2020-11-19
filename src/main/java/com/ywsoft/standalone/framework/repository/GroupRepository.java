package com.ywsoft.standalone.framework.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ywsoft.standalone.framework.entity.SwdGroup;

public interface GroupRepository extends JpaRepository<SwdGroup, String> {

}
