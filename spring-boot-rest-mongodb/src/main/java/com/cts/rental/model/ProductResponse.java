package com.cts.rental.model;

public class ProductResponse {

	private String id;
	
	private String name;
	
	private Location location;
	
	private Car cars;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public Car getCars() {
		return cars;
	}

	public void setCars(Car cars) {
		this.cars = cars;
	}
}
