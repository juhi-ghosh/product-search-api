package io.casestudy.productsearch.repositories;

import org.springframework.data.repository.CrudRepository;

import io.casestudy.productsearch.model.Category;

/**
 * 
 * @author jghosh
 * This class is a Category Repository used to query the in memory H2 database for all kinds of Product Category related data search
 *
 */
public interface CategoryRepository extends CrudRepository<Category, Integer>{

}
