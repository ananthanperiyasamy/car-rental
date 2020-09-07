package com.cts.rental.service.Impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cts.rental.exception.UserDefinedException;
import com.cts.rental.model.Product;
import com.cts.rental.model.ProductResponse;
import com.cts.rental.repository.ProductRepository;
import com.cts.rental.service.WarHouseService;

/**
 * @author Ananthan
 * This impl class used to connect mongoRepository class
 */
@Component
public class WarHouseServiceImpl implements WarHouseService{
	
	@Autowired private ProductRepository  productRepository;

	/**
	 * the method used to fetch all car from warhouse
	 * 
	 */
	@Override
	public List<ProductResponse> getListOfProducts() {
		List<Product>  products = productRepository.findAll();
		List<ProductResponse> productsResponse = new ArrayList<>();
		if(!products.isEmpty()) {
			for(Product product : products) {
				ProductResponse productRest = new ProductResponse();
				productRest.setId(product.getId());
				productRest.setName(product.getName());
				productRest.setLocation(product.getLocation());
				productRest.setCars(product.getCar());
				productsResponse.add(productRest);
			}
		}
		return productsResponse;
	}

	/**
	 * the method used to fetch more details about particular car
	 */
	@Override
	public ProductResponse getDetailsOfProduct(String id) {
		Product product = productRepository.findById(id);
		ProductResponse productResponse = new ProductResponse();
		if(product != null) {
			productResponse.setId(product.getId());
			productResponse.setName(product.getName());
			productResponse.setLocation(product.getLocation());
			productResponse.setCars(product.getCar());
		}
		return productResponse;
	}

	/**
	 * this method used to save added new car details in mongodb
	 */
	@Override
	public void save(Product product) {
		try {
			productRepository.save(product);
		}
		catch (Exception e) {
			throw new UserDefinedException(e);
		}
	}
}
