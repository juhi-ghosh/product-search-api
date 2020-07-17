package io.casestudy.productsearch.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.casestudy.productsearch.model.Product;
import io.casestudy.productsearch.service.ProductService;

/**
 * 
 * @author jghosh
 * This class is the entry point for all incoming Requests for Product data from database
 */
@RestController
public class ProductController {

	@Autowired
	private ProductService service;

	/**
	 * 
	 * @return List<Product> All the products stored in the database
	 */
	@RequestMapping("/products")
	public ResponseEntity<List<Product>> getAllProducts() {
		return service.getAllProductList();
	}
	
	/**
	 * This function is handling the queries - 
	 * 1.	Group by brand / client
	 * 2.	Group by price
	 * 3.	Group by Color
	 * 4.	Group by Size
	 * @param attribute
	 * @return List<Object>
	 */
	@RequestMapping("/products/group/{attribute}")
	public ResponseEntity<List<Object>> getProductsGroupByAttribute(@PathVariable String attribute) {
		return service.filterProductsGroupByAttribute(attribute);
	}
	
	/**
	 * This function is handling the queries - 
	 * 6. Available number of product by seller
	 * @param sellerName
	 * @return List<Object> All Products that are available having Quantity > 0 and Seller Name as given
	 */
	@RequestMapping("/products/available/Seller/{sellerName}")
	public ResponseEntity<List<Object>> getAvailableProductsBySeller(@PathVariable String sellerName) {
		return service.filterAvailableProductsBySeller(sellerName);
	}
	
	/**
	 * 
	 * @param sku
	 * @return Product A single Product with the matching value for SKU
	 */
	@RequestMapping("/product/{sku}")
	public ResponseEntity<Product> getProductsBySKU(@PathVariable String sku) {
		return service.getProductsBySKU(sku);
	}
}
