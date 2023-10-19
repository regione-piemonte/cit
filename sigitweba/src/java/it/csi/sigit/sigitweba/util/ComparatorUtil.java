/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2021
 *******************************************************************************/
package it.csi.sigit.sigitweba.util;


import it.csi.sigit.sigitweba.dto.common.CodeDescription;

import java.util.Comparator;

public class ComparatorUtil {
	
	public static Comparator<CodeDescription> compare(){
		Comparator<CodeDescription> result = new Comparator<CodeDescription>() {
			
			public int compare(CodeDescription o1, CodeDescription o2) {
				if(o1.getDescription()==null || o2.getDescription()==null)
					return 0;
				return o1.getDescription().compareToIgnoreCase(o2.getDescription());
			}
		};
		return result;
	}
}
