package io.casestudy.productsearch.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.casestudy.productsearch.model.AttributeValue;
import io.casestudy.productsearch.service.AttributeValueService;

/**
 * 
 * @author jghosh
 * This class is the entry point for all incoming Requests for Product Attribute Values data retrieval from database
 */
@RestController
public class AttributeValueController {

	@Autowired
	private AttributeValueService service;
	
	@RequestMapping("/values")
	public ResponseEntity<List<AttributeValue>> getAllAttributeValues(){
		return service.getAllAttributeValueList();
		
	}
}
