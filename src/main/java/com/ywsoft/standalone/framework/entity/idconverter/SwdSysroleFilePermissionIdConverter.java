package com.ywsoft.standalone.framework.entity.idconverter;

import java.io.Serializable;

import org.springframework.data.rest.webmvc.spi.BackendIdConverter;
import org.springframework.stereotype.Component;

import com.ywsoft.standalone.framework.entity.SwdSysroleFile;
import com.ywsoft.standalone.framework.entity.SwdSysroleFilePK;

@Component
public class SwdSysroleFilePermissionIdConverter implements BackendIdConverter {

	@Override
	public boolean supports(Class<?> delimiter) {
		return SwdSysroleFile.class.equals(delimiter);
	}

	@Override
	public Serializable fromRequestId(String id, Class<?> entityType) {
	    String[] parts = id.split(",");
	    SwdSysroleFilePK pk = new SwdSysroleFilePK();
	    pk.setFileId(parts[0]);
	    pk.setPermission(parts[1]);
	    pk.setSysroleId(parts[2]);

	    return pk;
	}

	@Override
	public String toRequestId(Serializable id, Class<?> entityType) {
		SwdSysroleFilePK pk = (SwdSysroleFilePK)id;
	    return String.format("%s,%s,%s", pk.getFileId(),pk.getPermission(),pk.getSysroleId());
	}

}
