package com.ywsoft.standalone.framework.entity.idconverter;

import java.io.Serializable;

import org.springframework.data.rest.webmvc.spi.BackendIdConverter;
import org.springframework.stereotype.Component;

import com.ywsoft.standalone.framework.entity.SwdSysroleFieldPermission;
import com.ywsoft.standalone.framework.entity.SwdSysroleFieldPermissionPK;

@Component
public class SwdSysroleFieldPermissionIdConverter implements BackendIdConverter {

	@Override
	public boolean supports(Class<?> delimiter) {
		return SwdSysroleFieldPermission.class.equals(delimiter);
	}

	@Override
	public Serializable fromRequestId(String id, Class<?> entityType) {
	    String[] parts = id.split(",");
	    SwdSysroleFieldPermissionPK pk = new SwdSysroleFieldPermissionPK();
	    pk.setModel(parts[0]);
	    pk.setField(parts[1]);
	    pk.setPermission(parts[2]);
	    pk.setSysroleId(parts[3]);
	    return pk;
	}

	@Override
	public String toRequestId(Serializable id, Class<?> entityType) {
		SwdSysroleFieldPermissionPK pk = (SwdSysroleFieldPermissionPK)id;
	    return String.format("%s,%s,%s,%s", pk.getModel(),pk.getField(),pk.getPermission(),pk.getSysroleId());
	}

}
