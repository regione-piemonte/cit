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
 * Data transfer object relativo al DAO SigitTAllRespTxtDao.
 * @generated
 */
public class SigitTAllRespTxtDto implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * store della proprieta' associata alla colonna DATA_CONTROLLO
	 * @generated
	 */
	private java.sql.Date _dataControllo;

	/**
	 * Imposta il valore della proprieta' dataControllo associata alla
	 * colonna DATA_CONTROLLO.
	 * @generated
	 */
	public void setDataControllo(java.sql.Date val) {
		_dataControllo = val;
	}

	/**
	 * Legge il valore della proprieta' dataControllo associata alla
	 * @generated
	 */
	public java.sql.Date getDataControllo() {
		return _dataControllo;
	}

	/**
	 * store della proprieta' associata alla colonna ID_IMP_RUOLO_PFPG
	 * @generated
	 */
	private java.math.BigDecimal _idImpRuoloPfpg;

	/**
	 * Imposta il valore della proprieta' idImpRuoloPfpg associata alla
	 * colonna ID_IMP_RUOLO_PFPG.
	 * @generated
	 */
	public void setIdImpRuoloPfpg(java.math.BigDecimal val) {
		_idImpRuoloPfpg = val;
	}

	/**
	 * Legge il valore della proprieta' idImpRuoloPfpg associata alla
	 * @generated
	 */
	public java.math.BigDecimal getIdImpRuoloPfpg() {
		return _idImpRuoloPfpg;
	}

	/**
	 * store della proprieta' associata alla colonna ID_ALLEGATO
	 * @generated
	 */
	private java.math.BigDecimal _idAllegato;

	/**
	 * Imposta il valore della proprieta' idAllegato associata alla
	 * colonna ID_ALLEGATO.
	 * @generated
	 */
	public void setIdAllegato(java.math.BigDecimal val) {
		_idAllegato = val;
	}

	/**
	 * Legge il valore della proprieta' idAllegato associata alla
	 * @generated
	 */
	public java.math.BigDecimal getIdAllegato() {
		return _idAllegato;
	}

	/**
	 * store della proprieta' associata alla colonna XML_ALLEGATO
	 * @generated
	 */
	private String _xmlAllegato;

	/**
	 * Imposta il valore della proprieta' xmlAllegato associata alla
	 * colonna XML_ALLEGATO.
	 * @generated
	 */
	public void setXmlAllegato(String val) {
		_xmlAllegato = val;
	}

	/**
	 * Legge il valore della proprieta' xmlAllegato associata alla
	 * @generated
	 */
	public String getXmlAllegato() {
		return _xmlAllegato;
	}

	/**
	 * Crea una istanza di SigitTAllRespTxtPk a partire dal valore dei campi chiave del DTO
	 * 
	 * @return SigitTAllRespTxtPk
	 * @generated
	 */
	public SigitTAllRespTxtPk createPk() {
		return new SigitTAllRespTxtPk(_dataControllo, _idImpRuoloPfpg,
				_idAllegato);
	}

}
