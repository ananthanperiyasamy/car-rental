package com.cts.rental.model;

/**
 * @author Ananthan
 * POJO class 
 */
public class Vehicles {

	private String make;
	
	private String model;
	
	private long year_model;
	
	private String price;
	
	private boolean licensed;
	
	private String date_added;

	public String getMake() {
		return make;
	}

	public String getModel() {
		return model;
	}

	public long getYear_model() {
		return year_model;
	}

	public String getPrice() {
		return price;
	}

	public boolean isLicensed() {
		return licensed;
	}

	public String getDate_added() {
		return date_added;
	}
}
