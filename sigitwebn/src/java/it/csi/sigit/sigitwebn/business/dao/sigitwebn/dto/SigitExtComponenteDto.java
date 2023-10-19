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
 * Data transfer object relativo al DAO SigitTComp4Dao.
 * @generated
 */
public class SigitExtComponenteDto implements Serializable {

	private static final long serialVersionUID = 1L;

	
	/**
	 * store della proprieta' associata alla colonna ID_R_COMP4_MANUT
	 * @generated
	 */
	private java.math.BigDecimal _idRComp4Manut;

	/**
	 * Imposta il valore della proprieta' idRComp4Manut associata alla
	 * colonna ID_R_COMP4_MANUT.
	 * @generated
	 */
	public void setIdRComp4Manut(java.math.BigDecimal val) {
		_idRComp4Manut = val;
	}

	/**
	 * Legge il valore della proprieta' idRComp4Manut associata alla
	 * @generated
	 */
	public java.math.BigDecimal getIdRComp4Manut() {
		return _idRComp4Manut;
	}

	
	
	/**
	 * store della proprieta' associata alla colonna FK_PERSONA_GIURIDICA
	 * @generated
	 */
	private java.math.BigDecimal _fkPersonaGiuridica;

	/**
	 * Imposta il valore della proprieta' fkPersonaGiuridica associata alla
	 * colonna FK_PERSONA_GIURIDICA.
	 * @generated
	 */
	public void setFkPersonaGiuridica(java.math.BigDecimal val) {
		_fkPersonaGiuridica = val;
	}

	/**
	 * Legge il valore della proprieta' fkPersonaGiuridica associata alla
	 * @generated
	 */
	public java.math.BigDecimal getFkPersonaGiuridica() {
		return _fkPersonaGiuridica;
	}


	/**
	 * store della proprieta' associata alla colonna ID_TIPO_COMPONENTE
	 * @generated
	 */
	private String _idTipoComponente;

	/**
	 * Imposta il valore della proprieta' idTipoComponente associata alla
	 * colonna ID_TIPO_COMPONENTE.
	 * @generated
	 */
	public void setIdTipoComponente(String val) {
		_idTipoComponente = val;
	}

	/**
	 * Legge il valore della proprieta' idTipoComponente associata alla
	 * @generated
	 */
	public String getIdTipoComponente() {
		return _idTipoComponente;
	}

	/**
	 * store della proprieta' associata alla colonna PROGRESSIVO
	 * @generated
	 */
	private java.math.BigDecimal _progressivo;

	/**
	 * Imposta il valore della proprieta' progressivo associata alla
	 * colonna PROGRESSIVO.
	 * @generated
	 */
	public void setProgressivo(java.math.BigDecimal val) {
		_progressivo = val;
	}

	/**
	 * Legge il valore della proprieta' progressivo associata alla
	 * @generated
	 */
	public java.math.BigDecimal getProgressivo() {
		return _progressivo;
	}

	/**
	 * store della proprieta' associata alla colonna DES_MARCA
	 * @generated
	 */
	private String _desMarca;

	/**
	 * Imposta il valore della proprieta' desMarca associata alla
	 * colonna DES_MARCA.
	 * @generated
	 */
	public void setDesMarca(String val) {
		_desMarca = val;
	}

	/**
	 * Legge il valore della proprieta' desMarca associata alla
	 * @generated
	 */
	public String getDesMarca() {
		return _desMarca;
	}

	/**
	 * store della proprieta' associata alla colonna MODELLO
	 * @generated
	 */
	private String _modello;

	/**
	 * Imposta il valore della proprieta' modello associata alla
	 * colonna MODELLO.
	 * @generated
	 */
	public void setModello(String val) {
		_modello = val;
	}

	/**
	 * Legge il valore della proprieta' modello associata alla
	 * @generated
	 */
	public String getModello() {
		return _modello;
	}


}
