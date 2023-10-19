/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2021
 *******************************************************************************/
package it.csi.citpwa.model.enums;

public enum TipoImportAllegatoEnum {
	ALLEGATOII("3","allegatoII"),
	ALLEGATOIIB("14","allegatoIIB"),
	ALLEGATOIII("4","allegatoIII"),
	ALLEGATOIV("5","allegatoIV"),
	ALLEGATOV("6","allegatoV"),
	MANUT_GT("10","manutGT"),
	MANUT_GF("11","manutGF"),
	MANUT_SC("12","manutSC"),
	MANUT_CG("13","manutCG");
	
	public final String id;
	public final String tipoImportLabel;
	
	private TipoImportAllegatoEnum(String id,String tipoImportLabel) {
		this.tipoImportLabel = tipoImportLabel;
		this.id = id;
	}
	
	public static TipoImportAllegatoEnum valueOfLabel(String tipoImportLabel) {
	    for (TipoImportAllegatoEnum tipoImport : values()) {
	        if (tipoImport.tipoImportLabel.equals(tipoImportLabel)) {
	            return tipoImport;
	        }
	    }
	    return null;
	}

	public static TipoImportAllegatoEnum valueOfId(String id) {
		for (TipoImportAllegatoEnum tipoImport : values()) {
			if (tipoImport.id.equals(id)) {
				return tipoImport;
			}
		}
		return null;
	}
}
