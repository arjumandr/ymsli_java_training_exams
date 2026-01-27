package com.traineeApp.dao;

import java.sql.SQLException;

public class DaoException extends SQLException {
	private static final long serialVersionUID = 1L;

	public DaoException(String msg) {
		super(msg);
	}

	public DaoException(String msg, Throwable cause) {
		super(msg, cause);
	}
}
