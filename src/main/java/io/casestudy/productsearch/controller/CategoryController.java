package io.casestudy.productsearch.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.casestudy.productsearch.model.Category;
import io.casestudy.productsearch.service.CategoryService;

/**
 * 
 * @author jghosh
 * This class is the entry point for all incoming Requests for Product Category details data retrieval from database
 */
@RestController
public class CategoryController {

	@Autowired
	private CategoryService service;
	
	@RequestMapping("/categories")
	public ResponseEntity<List<Category>> getAllCategories(){
		return service.getAllCategoryList();
		
	}
}
