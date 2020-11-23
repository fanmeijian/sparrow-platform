package com.ywsoft.standalone.framework.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.ywsoft.standalone.framework.entity.ext.UnitExt;
import com.ywsoft.standalone.framework.repository.OrganizationRepository;
import com.ywsoft.standalone.framework.repository.UnitRepository;

@RestController
public class UnitService {

	@Autowired
	UnitRepository unitRepository;

	@Autowired
	OrganizationRepository organizationRepository;

	@GetMapping("/unitTree/{organizationId}")
	public ApiResponse unitTree(@PathVariable(name = "organizationId") String organizationId) {
		List<UnitExt> unitExts = unitRepository.getByParentAndOrganization(null, organizationId);
		unitExts.forEach(unitExt -> {
			unitTree(unitExt);
		});
		return ApiResponseFactory.getNormalReponse(unitExts);
	}

	private void unitTree(UnitExt unitExt) {
		String organizationId = unitExt.getSwdOrganization().getId();
		unitExt.setSwdOrganization(null);
		unitRepository.getByParentAndOrganization(unitExt.getId(), organizationId).forEach(unitExtChild -> {
			unitExt.getChildren().add(unitExtChild);
			unitTree(unitExtChild);
		});
	}
}
