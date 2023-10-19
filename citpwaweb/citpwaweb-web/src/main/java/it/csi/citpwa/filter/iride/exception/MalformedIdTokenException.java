/*
 *
 *  * ******************************************************************************
 *  *  SPDX-License-Identifier: EUPL-1.2
 *  *  Copyright Regione Piemonte - 2021
 *  * *****************************************************************************
 *
 */

package it.csi.citpwa.filter.iride.exception;

public class MalformedIdTokenException extends UserException
{
    /**
	 * 
	 */
	private static final long serialVersionUID = 7345814567604723077L;

	public MalformedIdTokenException() {
        super("");
    }
    
    public MalformedIdTokenException(final String msg) {
        super(msg);
    }
}