package com.cts.rental.exception;

/**
 * @author Ananthan
 * This is user defined exception class which throw to frontend when runtime exception occurred
 */
public class UserDefinedException extends RuntimeException {

	private static final long serialVersionUID = -7122580594386704131L;

	private String EXCEPTION_DETAILS = "Runtime exception occurred while processinfg data in mongoDB";

	public UserDefinedException(Exception e) {
		super(e);
	}

	public String getCode() {
		return EXCEPTION_DETAILS;
	}
	
}
