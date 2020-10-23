package com.ywsoft.standalone.framework.repository;

import org.springframework.data.repository.CrudRepository;

import com.ywsoft.standalone.framework.entity.SwdFlowNo;
import com.ywsoft.standalone.framework.entity.SwdFlowNoPK;

public interface FlowNoRepository extends CrudRepository<SwdFlowNo, SwdFlowNoPK> {

}
