package com.traineeMgmt.exception;

public class TraineeNotFoundException extends RuntimeException{
	private static final long serialVersionUID = 1L;

	public TraineeNotFoundException(String msg) {
		super(msg);
	}
}
