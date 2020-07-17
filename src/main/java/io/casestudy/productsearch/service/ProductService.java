package io.casestudy.productsearch.service;

import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import io.casestudy.productsearch.model.AttributeValue;
import io.casestudy.productsearch.model.Product;
import io.casestudy.productsearch.repositories.ProductRepository;

/**
 * 
 * @author jghosh
 * This class is the Service implementation that has the business logic for 
 * manipulation of incoming requests and outgoing data responses from the DB for any Product
 */
@Service
public class ProductService {

	@Autowired
	private ProductRepository repository;
	
	/**
	 * 
	 * @return List<Product> All the products stored in the database
	 */
	public ResponseEntity<List<Product>> getAllProductList() {		
		return ResponseEntity.ok().body((List<Product>) repository.findAll());
	}

	/**
	 * 
	 * @param sku
	 * @return Product A single Product with the matching value for SKU
	 */
	public ResponseEntity<Product> getProductsBySKU(String sku) {	
		Product product = repository.findBySku(sku);
		
		product.setAttributeValue(new HashSet<AttributeValue>());
		return ResponseEntity.ok().body(product);
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
	public ResponseEntity<List<Object>> filterProductsGroupByAttribute(String attribute) {	
		return ResponseEntity.ok().body(repository.findProductGroupsByAttribute(attribute));
	}

	/**
	 * This function is handling the queries - 
	 * 6. Available number of product by seller
	 * @param sellerName
	 * @return List<Object> All Products that are available having Quantity > 0 and Seller Name as given
	 */
	public ResponseEntity<List<Object>> filterAvailableProductsBySeller(String sellerName) {
		return ResponseEntity.ok().body(repository.findAvailableProductBySeller(sellerName));
	}

}
