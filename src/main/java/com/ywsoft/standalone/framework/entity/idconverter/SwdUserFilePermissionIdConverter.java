package com.ywsoft.standalone.framework.entity.idconverter;

import java.io.Serializable;

import org.springframework.data.rest.webmvc.spi.BackendIdConverter;
import org.springframework.stereotype.Component;

import com.ywsoft.standalone.framework.entity.SwdUserFile;
import com.ywsoft.standalone.framework.entity.SwdUserFilePK;

@Component
public class SwdUserFilePermissionIdConverter implements BackendIdConverter {

	@Override
	public boolean supports(Class<?> delimiter) {
		return SwdUserFile.class.equals(delimiter);
	}

	@Override
	public Serializable fromRequestId(String id, Class<?> entityType) {
	    String[] parts = id.split(",");
	    SwdUserFilePK pk = new SwdUserFilePK();
	    pk.setFileId(parts[0]);
	    pk.setPermission(parts[1]);
	    pk.setUsername(parts[2]);

	    return pk;
	}

	@Override
	public String toRequestId(Serializable id, Class<?> entityType) {
		SwdUserFilePK pk = (SwdUserFilePK)id;
	    return String.format("%s,%s,%s", pk.getFileId(),pk.getPermission(),pk.getUsername());
	}

}
