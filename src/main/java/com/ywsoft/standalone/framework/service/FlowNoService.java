package com.ywsoft.standalone.framework.service;

import java.math.BigInteger;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import javax.websocket.server.PathParam;

import org.mvel2.MVEL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.ywsoft.standalone.framework.entity.SwdFlowNo;
import com.ywsoft.standalone.framework.entity.SwdFlowNoPK;
import com.ywsoft.standalone.framework.repository.FlowNoRepository;

import javassist.expr.NewArray;


@RestController
public class FlowNoService {

	@Autowired
	FlowNoRepository flowNoRepository;
	
	
	@GetMapping("/api/flowNo/{appId}/{code}")
	public String flowNo(@PathVariable(name = "appId") String appId,@PathVariable(name = "code") String code) {
		
		SwdFlowNoPK flowNoPK = new SwdFlowNoPK();
		flowNoPK.setAppId(appId);
		flowNoPK.setCode(code);
		
		return getFlowNo(flowNoPK);
	}
	
	private synchronized String getFlowNo(SwdFlowNoPK flowNoPK) {
		SwdFlowNo swdFlowNo = flowNoRepository.findById(flowNoPK).orElse(null);
		if(swdFlowNo==null) {
			return "{'msg':'尚未设置编号规则'}";
		}else {
			//锁定读和序列化执行代码
			synchronized (swdFlowNo) {
				Map<String,Object> map =new HashMap<String, Object>();
				map.put("sequenceNo", swdFlowNo.getSequenceNo());
				map.put("YEAR", Calendar.getInstance().get(Calendar.YEAR));
				int month = Calendar.getInstance().get(Calendar.MONTH)+1;
				int day = Calendar.getInstance().get(Calendar.DAY_OF_MONTH);
				map.put("MONTH", month<10?"0"+ String.valueOf(month):month);
				map.put("DAY", day<10?"0"+String.valueOf(day):day);
				String noString= MVEL.evalToString(swdFlowNo.getEl(),map);
				swdFlowNo.setSequenceNo(swdFlowNo.getSequenceNo().add(BigInteger.ONE));
				flowNoRepository.save(swdFlowNo);
				return noString;
			}
		}
	}
	
	
}
