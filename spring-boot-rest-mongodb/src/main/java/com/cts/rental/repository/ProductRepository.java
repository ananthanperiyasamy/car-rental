package com.cts.rental.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.cts.rental.model.Product;

/**
 * @author Ananthan
 * This repository class connect mongodb and fetch data
 */
public interface ProductRepository extends MongoRepository<Product, Long> {

	public Product findById(String id);
	public Long deleteById(String id);
}
