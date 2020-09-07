package com.cts.rental.model;

import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

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
@XmlRootElement
@Document(collection = "product")
public class Product {

	@Id
	private String id;
	
	private String name;
	
	private Location location;
	
	private Car cars;
	
	public String getName() {
		return this.name;
	}
	
	public String getId() {
		return this.id;
	}
	
	public Location getLocation() {
		return this.location;
	}
	
	public Car getCar() {
		return this.cars;
	}
}
