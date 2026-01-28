/*
 *
 *  * ******************************************************************************
 *  *  SPDX-License-Identifier: EUPL-1.2
 *  *  Copyright Regione Piemonte - 2021
 *  * *****************************************************************************
 *
 */

package it.csi.citpwa.exception;

public class SvistaException extends RuntimeException {
	
	public SvistaException() {
		super();
	}

	public SvistaException(String message) {
		super(message);
	}
	
	public SvistaException(String message, Throwable cause) {
		super(message, cause);
	}
}
