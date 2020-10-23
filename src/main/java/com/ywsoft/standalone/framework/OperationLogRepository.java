package com.ywsoft.standalone.framework;

import org.springframework.data.repository.CrudRepository;

import com.ywsoft.standalone.framework.entity.SwdOperationLog;

public interface OperationLogRepository extends CrudRepository<SwdOperationLog, String> {

}
