package io.casestudy.productsearch.repositories;
import org.springframework.data.repository.CrudRepository;

import io.casestudy.productsearch.model.Attribute;

/**
 * 
 * @author jghosh
 * This class is a Attribute Repository used to query the in memory H2 database for all kinds of Product Attribute related data search
 *
 */
public interface AttributeRepository extends CrudRepository<Attribute, Integer>{

}
