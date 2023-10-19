/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2021
 *******************************************************************************/
package it.csi.sigit.sigitwebn.util;

import java.util.Date;

import org.apache.commons.lang3.ObjectUtils;

public class MainTest {

	public static void main(String[] args) {

		boolean ok =  GenericUtil.isNumeroDecimaleValido("1254", null, null, true);
		
		if (ok) {
			System.out.println("OK");
		}
		else {
			System.out.println("KO");
		}
		
		
	}

}
