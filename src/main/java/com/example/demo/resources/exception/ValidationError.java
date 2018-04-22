package com.example.demo.resources.exception;

import java.util.ArrayList;
import java.util.List;

public class ValidationError extends StandardError {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<FieldMessage> errors = new ArrayList<>();

	public ValidationError(Integer status, String msg, Long timestamp) {
		super(status, msg, timestamp);
	}


	/**
	 * @return the errors
	 */
	public List<FieldMessage> getErrors() {
		return errors;
	}


	/**
	 * @param erros
	 *            the list to set
	 */
	public void addError(String name, String message) {
		errors.add(new FieldMessage(name, message));
	}

}
