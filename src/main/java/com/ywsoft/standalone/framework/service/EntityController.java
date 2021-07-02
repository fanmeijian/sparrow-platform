package com.ywsoft.standalone.framework.service;

import java.util.Map;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EntityController {

	
	@Autowired
	private ApplicationContext applicationContext;
	
	@GetMapping("/entities")
	public Map<String,Object> allEntities(){
		Map<String,Object> beans = applicationContext.getBeansWithAnnotation(Table.class);
		
//		AnnotationUtils.(Entity.class, null);
		
		return beans;
	}
	
}
