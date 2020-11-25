package com.ywsoft.standalone.framework.entity.idconverter;

import java.io.Serializable;

import org.springframework.data.rest.webmvc.spi.BackendIdConverter;
import org.springframework.stereotype.Component;

import com.ywsoft.standalone.framework.entity.SwdDataPermission;
import com.ywsoft.standalone.framework.entity.SwdDataPermissionPK;

@Component
public class SwdDataPermissionIdConverter implements BackendIdConverter {

	@Override
	public boolean supports(Class<?> delimiter) {
		return SwdDataPermission.class.equals(delimiter);
	}

	@Override
	public Serializable fromRequestId(String id, Class<?> entityType) {
		
	    String[] parts = id.split(",");
	    SwdDataPermissionPK pk = new SwdDataPermissionPK();
	    pk.setModel(parts[0]);
	    pk.setPkey(parts[1]);
	    pk.setPermission(parts[2]);
	    return pk;
	}

	@Override
	public String toRequestId(Serializable id, Class<?> entityType) {
		
		SwdDataPermissionPK pk = (SwdDataPermissionPK)id;
	    return String.format("%s,%s,%s", pk.getModel(),pk.getPkey(),pk.getPermission());
	}

}
