package com.ywsoft.standalone.framework.entity.idconverter;

import java.io.Serializable;

import org.springframework.data.rest.webmvc.spi.BackendIdConverter;
import org.springframework.stereotype.Component;

import com.ywsoft.standalone.framework.entity.SwdOrganizationRelation;
import com.ywsoft.standalone.framework.entity.SwdOrganizationRelationPK;

@Component
public class SwdOrganizationRelationIdConverter implements BackendIdConverter {

	@Override
	public boolean supports(Class<?> delimiter) {
		return SwdOrganizationRelation.class.equals(delimiter);
	}

	@Override
	public Serializable fromRequestId(String id, Class<?> entityType) {
	    String[] parts = id.split(",");
	    SwdOrganizationRelationPK pk = new SwdOrganizationRelationPK();
	    pk.setOrganizationId(parts[0]);
	    pk.setTartgetId(parts[1]);
	    return pk;
	}

	@Override
	public String toRequestId(Serializable id, Class<?> entityType) {
		SwdOrganizationRelationPK pk = (SwdOrganizationRelationPK)id;
	    return String.format("%s,%s", pk.getOrganizationId(),pk.getTargetId());
	}

}
