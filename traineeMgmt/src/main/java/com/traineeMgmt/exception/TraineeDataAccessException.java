package com.traineeMgmt.exception;

public class TraineeDataAccessException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public TraineeDataAccessException(String msg, Throwable cause) {
        super(msg, cause);
    }
}

