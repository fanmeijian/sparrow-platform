package com.ywsoft.standalone.framework.entity.idconverter;

import java.io.Serializable;

import org.springframework.data.rest.webmvc.spi.BackendIdConverter;
import org.springframework.stereotype.Component;

import com.ywsoft.standalone.framework.entity.SwdUserDataPermission;
import com.ywsoft.standalone.framework.entity.SwdUserDataPermissionPK;

@Component
public class SwdUserPermissionIdConverter implements BackendIdConverter {

	@Override
	public boolean supports(Class<?> delimiter) {
		return SwdUserDataPermission.class.equals(delimiter);
	}

	@Override
	public Serializable fromRequestId(String id, Class<?> entityType) {
		
	    String[] parts = id.split(",");
	    SwdUserDataPermissionPK pk = new SwdUserDataPermissionPK();
	    pk.setModel(parts[0]);
	    pk.setPkey(parts[1]);
	    pk.setPermission(parts[2]);
	    pk.setUsername(parts[3]);
	    return pk;
	}

	@Override
	public String toRequestId(Serializable id, Class<?> entityType) {
		
		SwdUserDataPermissionPK pk = (SwdUserDataPermissionPK)id;
	    return String.format("%s,%s,%s,%s", pk.getModel(),pk.getPkey(),pk.getPermission(),pk.getUsername());
	}

}
