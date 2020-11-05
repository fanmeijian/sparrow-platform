package com.ywsoft.standalone.framework.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.ywsoft.standalone.framework.entity.SwdOrganization;

public interface OrganizationRepository extends CrudRepository<SwdOrganization, String>,JpaRepository<SwdOrganization,String> {

}
