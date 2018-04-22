package com.example.demo.resources.exception;

import java.io.Serializable;

public class FieldMessage implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String fieldName;
	private String fieldMessage;

	/**
	 * 
	 */
	public FieldMessage() {
		super();
	}

	/**
	 * @param fieldName
	 * @param fieldMessage
	 */
	public FieldMessage(String fieldName, String fieldMessage) {
		super();
		this.fieldName = fieldName;
		this.fieldMessage = fieldMessage;
	}

	/**
	 * @return the fieldName
	 */
	public String getFieldName() {
		return fieldName;
	}

	/**
	 * @param fieldName
	 *            the fieldName to set
	 */
	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}

	/**
	 * @return the fieldMessage
	 */
	public String getFieldMessage() {
		return fieldMessage;
	}

	/**
	 * @param fieldMessage
	 *            the fieldMessage to set
	 */
	public void setFieldMessage(String fieldMessage) {
		this.fieldMessage = fieldMessage;
	}

}
