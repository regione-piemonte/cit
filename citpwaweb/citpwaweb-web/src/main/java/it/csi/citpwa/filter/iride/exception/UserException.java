/*
 *
 *  * ******************************************************************************
 *  *  SPDX-License-Identifier: EUPL-1.2
 *  *  Copyright Regione Piemonte - 2021
 *  * *****************************************************************************
 *
 */

package it.csi.citpwa.filter.iride.exception;

public class UserException extends CSIException
{
    /**
	 * 
	 */
	private static final long serialVersionUID = 4937176416355674021L;

	public UserException(final String msg) {
        super(msg);
    }
    
    public UserException(final String msg, final String nestedClass, final String nestedMsg) {
        super(msg, nestedClass, nestedMsg);
    }
    
    public UserException(final String msg, final String nestedClass, final String nestedMsg, final String stackTrace) {
        super(msg, nestedClass, nestedMsg, stackTrace);
    }
    
    public UserException(final String msg, final Throwable nested) {
        super(msg, nested);
    }
}