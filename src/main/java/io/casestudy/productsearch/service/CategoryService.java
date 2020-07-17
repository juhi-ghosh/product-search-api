package io.casestudy.productsearch.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import io.casestudy.productsearch.model.Category;
import io.casestudy.productsearch.repositories.CategoryRepository;

/**
 * 
 * @author jghosh
 * This class is the Service implementation that has the business logic for 
 * manipulation of incoming requests and outgoing data responses from the DB for any Product Category
 */
@Service
public class CategoryService {

	@Autowired
	private CategoryRepository repository;

	public ResponseEntity<List<Category>> getAllCategoryList() {
		
		return ResponseEntity.ok().body((List<Category>) repository.findAll());
	}

}
