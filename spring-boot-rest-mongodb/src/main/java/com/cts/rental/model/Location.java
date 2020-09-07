package com.cts.rental.model;

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
public class Location {
	
	private String latitude;
	
	private String longitude;

	
	public String getLatitude() {
		return this.latitude;
	}
	
	public String getLongitude() {
		return this.longitude;
	}

}
