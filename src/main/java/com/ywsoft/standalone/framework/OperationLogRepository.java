package com.ywsoft.standalone.framework;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ywsoft.standalone.framework.entity.SwdOperationLog;

/***
 * 
 * @author fanmj
 * 
 * 不能放repository包里面，因为会出现日志类循环调用的死循环。因此只能放根包里
 *
 */

public interface OperationLogRepository extends JpaRepository<SwdOperationLog, String> {

}
