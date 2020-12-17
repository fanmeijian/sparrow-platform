package com.ywsoft.standalone.framework.entity.idconverter;

import java.io.Serializable;

import org.springframework.data.rest.webmvc.spi.BackendIdConverter;
import org.springframework.stereotype.Component;

import com.ywsoft.standalone.framework.entity.SwdSubGroup;
import com.ywsoft.standalone.framework.entity.SwdSubGroupPK;

@Component
public class SwdSubGroupIdConverter implements BackendIdConverter {

	@Override
	public boolean supports(Class<?> delimiter) {
		return SwdSubGroup.class.equals(delimiter);
	}

	@Override
	public Serializable fromRequestId(String id, Class<?> entityType) {
	    String[] parts = id.split(",");
	    SwdSubGroupPK pk = new SwdSubGroupPK();
	    pk.setGroupId(parts[0]);
	    pk.setSubGroupId(parts[1]);
	    return pk;
	}

	@Override
	public String toRequestId(Serializable id, Class<?> entityType) {
		SwdSubGroupPK pk = (SwdSubGroupPK)id;
	    return String.format("%s,%s", pk.getGroupId(),pk.getSubGroupId());
	}

}
