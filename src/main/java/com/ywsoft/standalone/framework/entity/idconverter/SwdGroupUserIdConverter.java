package com.ywsoft.standalone.framework.entity.idconverter;

import java.io.Serializable;

import org.springframework.data.rest.webmvc.spi.BackendIdConverter;
import org.springframework.stereotype.Component;

import com.ywsoft.standalone.framework.entity.SwdGroupUser;
import com.ywsoft.standalone.framework.entity.SwdGroupUserPK;

@Component
public class SwdGroupUserIdConverter implements BackendIdConverter {

	@Override
	public boolean supports(Class<?> delimiter) {
		return SwdGroupUser.class.equals(delimiter);
	}

	@Override
	public Serializable fromRequestId(String id, Class<?> entityType) {
	    String[] parts = id.split(",");
	    SwdGroupUserPK pk = new SwdGroupUserPK();
	    pk.setGroupId(parts[0]);
	    pk.setUsername(parts[1]);
	    return pk;
	}

	@Override
	public String toRequestId(Serializable id, Class<?> entityType) {
		SwdGroupUserPK pk = (SwdGroupUserPK)id;
	    return String.format("%s,%s", pk.getGroupId(),pk.getUsername());
	}

}
