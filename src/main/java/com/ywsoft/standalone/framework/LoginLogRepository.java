package com.ywsoft.standalone.framework;

import org.springframework.data.repository.CrudRepository;

import com.ywsoft.standalone.framework.entity.SwdLoginLog;

public interface LoginLogRepository extends CrudRepository<SwdLoginLog, String> {

}
