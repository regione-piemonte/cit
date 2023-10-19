/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2021
 *******************************************************************************/
package it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto;

import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.*;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.exceptions.*;
import java.io.Serializable;
import java.util.*;

/**
 * DTO specifico della query modellata nel finder verificaAllegatoSelezionato.
 * @generated
 */
public class SigitRRuoloTipodocVerificaAllegatoSelezionatoDto
		implements
			Serializable {

	/*	 
	 * @generated
	 */
	private java.math.BigDecimal idRuolo;

	/**
	 * @generated
	 */
	public void setIdRuolo(java.math.BigDecimal val) {
		idRuolo = val;
	}
	/**
	 * @generated
	 */
	public java.math.BigDecimal getIdRuolo() {
		return idRuolo;
	}

	/*	 
	 * @generated
	 */
	private java.math.BigDecimal idTipoDocumento;

	/**
	 * @generated
	 */
	public void setIdTipoDocumento(java.math.BigDecimal val) {
		idTipoDocumento = val;
	}
	/**
	 * @generated
	 */
	public java.math.BigDecimal getIdTipoDocumento() {
		return idTipoDocumento;
	}

	/**
	 * Method 'equals'
	 * 
	 * @param _other
	 * @return boolean
	 * @generated
	 */
	public boolean equals(Object _other) {
		return super.equals(_other);
	}

	/**
	 * Method 'hashCode'
	 * 
	 * @return int
	 * @generated
	 */
	public int hashCode() {
		return super.hashCode();
	}

}
