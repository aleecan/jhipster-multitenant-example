package com.mikado.mikadosaas.resource.util;

import java.util.LinkedHashMap;

/**
 * To create json response.
 *
 * @author cis
 *
 * @param <T>
 */
public class ResponseDTO extends LinkedHashMap<String, Object> {

	/**
	 *
	 */
	private static final long serialVersionUID = -745498896399615347L;

	public static final String DATA_STR = "data";
	public static final String MESSAGE_STR = "message";
	public static final String ERROR_STR = "error";

	public ResponseDTO(boolean error, String message, Object object) {
		this.put(ERROR_STR, error);
		this.put(MESSAGE_STR, message);
		this.put(DATA_STR, object);
	}

	public ResponseDTO(boolean error, String message) {
		this.put(ERROR_STR, error);
		this.put(MESSAGE_STR, message);
	}

	public void putData(Object object) {
		if (object != null) {
			this.put(DATA_STR, object);
		}
	}

	public void putMessage(String object) {
		this.put(MESSAGE_STR, object);
	}

	public void putError(boolean object) {
		this.put(DATA_STR, object);
	}
}
