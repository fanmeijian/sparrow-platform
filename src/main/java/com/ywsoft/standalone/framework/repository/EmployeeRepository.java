package com.ywsoft.standalone.framework.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ywsoft.standalone.framework.entity.SwdEmployee;

public interface EmployeeRepository extends JpaRepository<SwdEmployee, String> {

}
