package io.casestudy.productsearch.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import io.casestudy.productsearch.model.Product;

/**
 * 
 * @author jghosh
 * This class is a Product Repository used to query the in memory H2 database for all kinds of Product related data search
 *
 */
public interface ProductRepository extends CrudRepository<Product, Integer> {

	public Product findBySku(String sku);

	@Query(value = "SELECT PRODUCT.NAME, PRODUCT.SKU, ATTRIBUTE_VALUE.DATA, COUNT(PRODUCT.PRODUCT_ID)"
			+ " NumberOfFilteredProducts FROM ((PRODUCT INNER JOIN ATTRIBUTE_VALUE ON PRODUCT.PRODUCT_ID = ATTRIBUTE_VALUE.PRODUCT_ID) "
			+ "INNER JOIN ATTRIBUTE ON ATTRIBUTE_VALUE.ATTRIBUTE_ID = ATTRIBUTE.ATTRIBUTE_ID) GROUP BY ATTRIBUTE_VALUE.DATA, PRODUCT.NAME, PRODUCT.SKU"
			+ " HAVING ATTRIBUTE.NAME = ?1", nativeQuery = true)
	public List<Object> findProductGroupsByAttribute(String attribute);
	
	@Query(value = "SELECT PRODUCT.NAME, PRODUCT.SKU, ATTRIBUTE_VALUE.DATA, COUNT(PRODUCT.PRODUCT_ID) "
			+ "FROM ((PRODUCT INNER JOIN ATTRIBUTE_VALUE ON PRODUCT.PRODUCT_ID = ATTRIBUTE_VALUE.PRODUCT_ID) "
			+ "INNER JOIN ATTRIBUTE ON ATTRIBUTE_VALUE.ATTRIBUTE_ID = ATTRIBUTE.ATTRIBUTE_ID) WHERE PRODUCT.QUANTITY>0 "
			+ "GROUP BY ATTRIBUTE_VALUE.DATA, PRODUCT.NAME, PRODUCT.SKU HAVING ATTRIBUTE.NAME='Seller' AND ATTRIBUTE_VALUE.DATA=?1", nativeQuery = true)
	public List<Object> findAvailableProductBySeller(String sellerName);
}
