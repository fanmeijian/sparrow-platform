package com.ywsoft.standalone.framework.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ywsoft.standalone.framework.entity.SwdDict;

public interface DictRepository extends JpaRepository<SwdDict, String> {

}
