package com.cts.rental.controller;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.rental.model.Product;
import com.cts.rental.service.WarHouseService;


/**
 * @author Ananthan
 * This controller class have listed services
 * list out all cars - api/products - GET
 * get details of a car - api/product/{id} - GET
 * save new car - api/product - PUT
 */
@RestController
@RequestMapping("/api")
public class WarHouseController {
	
	private static final Logger logger = LoggerFactory.getLogger(WarHouseController.class);
	
	@Autowired private WarHouseService warHouseService;
	
	/**
	 * This method will list out all available cars in all warehouse
	 */
	@GetMapping(value = "/products")
	public Response getAllProducts() {
		try {
			return Response.status(Status.OK.getStatusCode()).entity(warHouseService.getListOfProducts()).build();
		} catch (Exception e) {
			logger.error("Exception occurred while getting list of cars from warhouse "+ e.fillInStackTrace());
			return Response.status(Status.INTERNAL_SERVER_ERROR.getStatusCode()).entity(e).build();
		}
	}
	
	/**
	 * This method will provide more info about selected car
	 */
	@GetMapping(value = "/product/{id}")
	public Response findProduct(@PathVariable String id) {
		try {
			return Response.status(Status.OK.getStatusCode()).entity(warHouseService.getDetailsOfProduct(id)).build();
		} catch (Exception e) {
			logger.error("Exception occurred while getting details of particular cars from warhouse "+ e.fillInStackTrace());
			return  Response.status(Status.INTERNAL_SERVER_ERROR.getStatusCode()).entity(e).build();
		}
	}
	
	/**
	 * This method used to add product/car in warehouse
	 */
	@PutMapping(value = "/product")
	public Response saveProduct(@RequestBody Product product) {
		try {
			warHouseService.save(product);
		} catch (Exception e) {
			logger.error("Exception occurred while getting details of particular cars from warhouse "+ e.fillInStackTrace());
			return Response.status(Status.INTERNAL_SERVER_ERROR.getStatusCode()).entity(product).build();
		}
	    return Response.status(Status.OK.getStatusCode()).entity(product).build();
	}
	

}
