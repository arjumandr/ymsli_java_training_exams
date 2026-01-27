package com.traineeApp.dao;

import jakarta.persistence.PersistenceException;

public class PWrapperException extends PersistenceException {
	private static final long serialVersionUID = 1L;

	public PWrapperException(String msg) {
		super(msg);
	}

	public PWrapperException(String msg, Throwable cause) {
		super(msg, cause);
	}
}
