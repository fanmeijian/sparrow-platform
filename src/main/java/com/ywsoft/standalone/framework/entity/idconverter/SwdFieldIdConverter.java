package com.ywsoft.standalone.framework.entity.idconverter;

import java.io.Serializable;

import org.springframework.data.rest.webmvc.spi.BackendIdConverter;
import org.springframework.stereotype.Component;

import com.ywsoft.standalone.framework.entity.SwdFieldPermission;
import com.ywsoft.standalone.framework.entity.SwdFieldPermissionPK;

@Component
public class SwdFieldIdConverter implements BackendIdConverter {

	@Override
	public boolean supports(Class<?> delimiter) {
		return SwdFieldPermission.class.equals(delimiter);
	}

	@Override
	public Serializable fromRequestId(String id, Class<?> entityType) {
		
	    String[] parts = id.split(",");
	    SwdFieldPermissionPK pk = new SwdFieldPermissionPK();
	    pk.setModel(parts[0]);
	    pk.setField(parts[1]);
	    return pk;
	}

	@Override
	public String toRequestId(Serializable id, Class<?> entityType) {
		
		SwdFieldPermissionPK pk = (SwdFieldPermissionPK)id;
	    return String.format("%s,%s", pk.getModel(),pk.getField());
	}

}
