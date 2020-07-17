package io.casestudy.productsearch.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.casestudy.productsearch.model.Attribute;
import io.casestudy.productsearch.service.AttributeService;

/**
 * 
 * @author jghosh
 * This class is the entry point for all incoming Requests for Product Attribute data retrieval from database
 */
@RestController
public class AttributeController {

	@Autowired
	private AttributeService attributeService;
	
	@RequestMapping("/attributes")
	public ResponseEntity<List<Attribute>> getAllAttributes(){
		return attributeService.getAllAttributeList();
		
	}
}
