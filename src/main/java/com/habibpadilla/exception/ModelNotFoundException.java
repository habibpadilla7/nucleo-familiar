package com.habibpadilla.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ModelNotFoundException extends RuntimeException {


	/**
	 * 
	 */
	private static final long serialVersionUID = -2450715230688955930L;

	public ModelNotFoundException(String mensaje) {
		super(mensaje);

	}
	

}
