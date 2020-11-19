package com.ywsoft.standalone.framework.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ywsoft.standalone.framework.entity.SwdOrganization;

public interface OrganizationRepository extends JpaRepository<SwdOrganization,String> {

}
