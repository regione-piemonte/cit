/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2021
 *******************************************************************************/
/*
 * 
 */
package it.csi.sigit.sigitweba.util;


import org.apache.log4j.Logger;


/**
 * The Class SecurityUtil.
 */
public class SecurityUtil {

	private static final String REGEX_ELENCO_CARATTERI_AMMESSI = "[^A-Za-z0-9àèéìòù'@.&]";
	
	/** The log. */
	protected static Logger log = Logger.getLogger(Constants.APPLICATION_CODE);

	public static String sanitize(String input) {
		if (input == null) {
            return null;
        }
        return input.replaceAll(REGEX_ELENCO_CARATTERI_AMMESSI, "");		
	}
}