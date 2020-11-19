package com.ywsoft.standalone.framework.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ywsoft.standalone.framework.entity.SwdFlowNo;
import com.ywsoft.standalone.framework.entity.SwdFlowNoPK;

public interface FlowNoRepository extends JpaRepository<SwdFlowNo, SwdFlowNoPK> {

}
