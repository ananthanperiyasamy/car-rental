package com.cts.rental.service;

import java.util.List;
import java.util.Map;

import com.cts.rental.model.Product;
import com.cts.rental.model.ProductResponse;

public interface WarHouseService {

	public List<ProductResponse> getListOfProducts();

	public ProductResponse getDetailsOfProduct(String id);

	public void save(Product product);

}
