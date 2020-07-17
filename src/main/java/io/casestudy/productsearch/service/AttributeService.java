package io.casestudy.productsearch.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import io.casestudy.productsearch.model.Attribute;
import io.casestudy.productsearch.repositories.AttributeRepository;

/**
 * 
 * @author jghosh
 * This class is the Service implementation that has the business logic for 
 * manipulation of incoming requests and outgoing data responses from the DB for any Product Attribute
 */
@Service
public class AttributeService {

	@Autowired
	private AttributeRepository attributeRepository;

	public ResponseEntity<List<Attribute>> getAllAttributeList() {

		return ResponseEntity.ok().body((List<Attribute>) attributeRepository.findAll());
	}

}
