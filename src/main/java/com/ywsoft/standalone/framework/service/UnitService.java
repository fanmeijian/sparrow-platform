package com.ywsoft.standalone.framework.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ywsoft.standalone.framework.entity.SwdUnit;
import com.ywsoft.standalone.framework.repository.OrganizationRepository;
import com.ywsoft.standalone.framework.repository.UnitRepository;

@RestController
public class UnitService {

	@Autowired
	UnitRepository unitRepository;
	
	@Autowired
	OrganizationRepository organizationRepository;
	
	@GetMapping("/unit")
	public Iterable<SwdUnit> units(){
		return unitRepository.findAll();
	}
	
	@PostMapping("/unit")
	public SwdUnit newUnit(@RequestBody SwdUnit unit) {
		return unitRepository.save(unit);
	}
}
