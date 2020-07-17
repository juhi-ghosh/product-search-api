package io.casestudy.productsearch.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import io.casestudy.productsearch.model.AttributeValue;
import io.casestudy.productsearch.repositories.AttributeValueRepository;

/**
 * 
 * @author jghosh
 * This class is the Service implementation that has the business logic for 
 * manipulation of incoming requests and outgoing data responses from the DB for any Product Attribute Value
 */
@Service
public class AttributeValueService {

	@Autowired
	private AttributeValueRepository attributeValueRepository;
	
	public ResponseEntity<List<AttributeValue>> getAllAttributeValueList() {
		return ResponseEntity.ok().body((List<AttributeValue>) attributeValueRepository.findAll());
	}

}
