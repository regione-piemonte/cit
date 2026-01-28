/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2021
 *******************************************************************************/
package it.csi.citpwa.model.enums;

import java.math.BigDecimal;

public enum TipoStatoDistributoreEnum {
	NULL(new BigDecimal(0),""),
	DA_ELABORARE(new BigDecimal(1),"Da elaborare"),
	INVIATO(new BigDecimal(2),"Inviato"),
	SOSTITUITO(new BigDecimal(4),"Sostituito"),
	ELIMINATO(new BigDecimal(5),"Eliminato"),
	RIFIUTATO_SCARTATO(new BigDecimal(3),"Rifiutato/scartato");

	public final BigDecimal id;
	public final String tipoStatoDistirbutoreDesc;

	private TipoStatoDistributoreEnum(BigDecimal id, String tipoStatoDistirbutoreDesc) {
		this.tipoStatoDistirbutoreDesc = tipoStatoDistirbutoreDesc;
		this.id = id;
	}
	
	public static TipoStatoDistributoreEnum valueOfLabel(String tipoStatoDistirbutoreDesc) {
	    for (TipoStatoDistributoreEnum tipoSttoDistributore : values()) {
	        if (tipoSttoDistributore.tipoStatoDistirbutoreDesc.equals(tipoStatoDistirbutoreDesc)) {
	            return tipoSttoDistributore;
	        }
	    }
	    return null;
	}

	public static TipoStatoDistributoreEnum valueOfId(BigDecimal id) {
		for (TipoStatoDistributoreEnum tipoSttoDistributore : values()) {
			if (tipoSttoDistributore.id.equals(id)) {
				return tipoSttoDistributore;
			}
		}
		return NULL;
	}

	public String getTipoStatoDistirbutoreDesc() {
		return tipoStatoDistirbutoreDesc;
	}
}
