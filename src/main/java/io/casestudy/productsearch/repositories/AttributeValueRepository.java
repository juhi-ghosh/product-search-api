package io.casestudy.productsearch.repositories;

import org.springframework.data.repository.CrudRepository;

import io.casestudy.productsearch.model.AttributeValue;

/**
 * 
 * @author jghosh
 * This class is a AttributeValue Repository used to query the in memory H2 database for all kinds of Product Attribute Values related data search
 *
 */
public interface AttributeValueRepository  extends CrudRepository<AttributeValue, Integer>{

}
