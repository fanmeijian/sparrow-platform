package com.ywsoft.standalone.framework.entity.idconverter;

import java.io.Serializable;

import org.springframework.data.rest.webmvc.spi.BackendIdConverter;
import org.springframework.stereotype.Component;

import com.ywsoft.standalone.framework.entity.SwdUserFieldPermission;
import com.ywsoft.standalone.framework.entity.SwdUserFieldPermissionPK;

@Component
public class SwdUserFieldPermissionIdConverter implements BackendIdConverter {

	@Override
	public boolean supports(Class<?> delimiter) {
		return SwdUserFieldPermission.class.equals(delimiter);
	}

	@Override
	public Serializable fromRequestId(String id, Class<?> entityType) {
	    String[] parts = id.split(",");
	    SwdUserFieldPermissionPK pk = new SwdUserFieldPermissionPK();
	    pk.setModel(parts[0]);
	    pk.setField(parts[1]);
	    pk.setPermission(parts[2]);
	    pk.setUsername(parts[3]);
	    return pk;
	}

	@Override
	public String toRequestId(Serializable id, Class<?> entityType) {
		SwdUserFieldPermissionPK pk = (SwdUserFieldPermissionPK)id;
	    return String.format("%s,%s,%s,%s", pk.getModel(),pk.getField(),pk.getPermission(),pk.getUsername());
	}

}
