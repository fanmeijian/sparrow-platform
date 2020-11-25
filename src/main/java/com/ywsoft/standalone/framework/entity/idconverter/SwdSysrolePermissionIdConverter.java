package com.ywsoft.standalone.framework.entity.idconverter;

import java.io.Serializable;

import org.springframework.data.rest.webmvc.spi.BackendIdConverter;
import org.springframework.stereotype.Component;

import com.ywsoft.standalone.framework.entity.SwdSysroleDataPermission;
import com.ywsoft.standalone.framework.entity.SwdSysroleDataPermissionPK;

@Component
public class SwdSysrolePermissionIdConverter implements BackendIdConverter {

	@Override
	public boolean supports(Class<?> delimiter) {
		return SwdSysroleDataPermission.class.equals(delimiter);
	}

	@Override
	public Serializable fromRequestId(String id, Class<?> entityType) {
		
	    String[] parts = id.split(",");
	    SwdSysroleDataPermissionPK pk = new SwdSysroleDataPermissionPK();
	    pk.setModel(parts[0]);
	    pk.setPkey(parts[1]);
	    pk.setPermission(parts[2]);
	    pk.setSysroleId(parts[3]);
	    return pk;
	}

	@Override
	public String toRequestId(Serializable id, Class<?> entityType) {
		
		SwdSysroleDataPermissionPK pk = (SwdSysroleDataPermissionPK)id;
	    return String.format("%s,%s,%s,%s", pk.getModel(),pk.getPkey(),pk.getPermission(),pk.getSysroleId());
	}

}
