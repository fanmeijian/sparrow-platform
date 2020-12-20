package com.ywsoft.standalone.framework.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.ignite.IgniteCheckedException;
import org.apache.ignite.marshaller.Marshaller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ywsoft.standalone.framework.OperationLogRepository;
import com.ywsoft.standalone.framework.entity.SwdOperationLog;
import com.ywsoft.standalone.framework.entity.ext.OperationLog;


@RestController
public class MyLogService {
	@Autowired
	OperationLogRepository operationLogRepository;
	
	@Autowired
	Marshaller marshaller;
	
	@GetMapping("/api/opLogs")
	
	public Page<SwdOperationLog> opLogs(@PageableDefault Pageable p){ 
		List<OperationLog> operationLogs= new ArrayList<OperationLog>();
		Page<SwdOperationLog> swdOperationLog = operationLogRepository.findAll(p);
		swdOperationLog.forEach(o-> {
			OperationLog operationLog=new OperationLog(o);
			try {
//				operationLog.setParams(marshaller.unmarshal(o.getModelBytearray(), null));
				o.setParams(marshaller.unmarshal(o.getModelBytearray(), null));
			} catch (IgniteCheckedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			operationLogs.add(operationLog);
		});
		return swdOperationLog;
	}
}
