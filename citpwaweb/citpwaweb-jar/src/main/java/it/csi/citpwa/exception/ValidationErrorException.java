/*
 *
 *  * ******************************************************************************
 *  *  SPDX-License-Identifier: EUPL-1.2
 *  *  Copyright Regione Piemonte - 2021
 *  * *****************************************************************************
 *
 */
package it.csi.citpwa.exception;

public class ValidationErrorException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public ValidationErrorException() {
		super();
	}

	public ValidationErrorException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public ValidationErrorException(String message, Throwable cause) {
		super(message, cause);
	}

	public ValidationErrorException(String message) {
		super(message);
	}

	public ValidationErrorException(Throwable cause) {
		super(cause);
	}

}
