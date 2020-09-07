package com.cts.rental.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Ananthan
 * POJO class 
 */
@Getter 
@Setter 
@AllArgsConstructor
public class Car {
	
	private String location;
	
	private List<Vehicles> vehicles;

	public String getLocation() {
		return location;
	}

	public List<Vehicles> getVehicles() {
		return vehicles;
	}
}


