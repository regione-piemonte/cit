/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2021
 *******************************************************************************/
package it.csi.sigit.sigitbatchn.business.manager.util;


public class ServiceException extends ManagerException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7583376730326946211L;
	
	protected Throwable throwable;
	
	
	/**
	 * Inizializza un'istanza della classe
	 * 
	 * @param cause Causa dell'eccezione
	 * @param msg Messaggio associato all'eccezione
	 */
	public ServiceException(Throwable cause, Message msg) {
		super(cause, msg);
	}
	
	public ServiceException(Message msg){
		super(msg);
	}
	
}
