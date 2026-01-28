/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2021
 *******************************************************************************/
package it.csi.sigit.sigitext.business.dao.sigitextdao.dao.filter;

import java.math.BigDecimal;
import java.sql.Date;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class FiltroRicercaPfPg implements java.io.Serializable {

	/// Field [idRuolo]
	private String idRuolo = null;

	/**
	 * imposta il valore del campo [idRuolo]
	 * @param val
	 * @generated
	 */

	public void setIdRuolo(String val) {
		idRuolo = val;
	}

	/**
	 * legge il valore del campo [idRuolo]
	 * @generated
	 */
	public String getIdRuolo() {
		return idRuolo;
	}

	private List<Integer> idRuoloList = new ArrayList<Integer>();

	
	
	public List<Integer> getIdRuoloList() {
		return idRuoloList;
	}

	public void setIdRuoloList(List<Integer> idRuoloList) {
		this.idRuoloList = idRuoloList;
	}

	public void addIdRuoloList(Integer idRuolo) {
		this.idRuoloList.add(idRuolo);
	}
	
	/// Field [codiceImpianto]
	private String codiceImpianto = null;

	/**
	 * imposta il valore del campo [codiceImpianto]
	 * @param val
	 * @generated
	 */

	public void setCodiceImpianto(String val) {
		codiceImpianto = val;
	}

	/**
	 * legge il valore del campo [codiceImpianto]
	 * @generated
	 */
	public String getCodiceImpianto() {
		return codiceImpianto;
	}

	
	private BigDecimal idPersonaFisica = null;

	
	public BigDecimal getIdPersonaFisica() {
		return idPersonaFisica;
	}

	public void setIdPersonaFisica(BigDecimal idPersonaFisica) {
		this.idPersonaFisica = idPersonaFisica;
	}

	private BigDecimal idPersonaGiuridica = null;

	
	
	public BigDecimal getIdPersonaGiuridica() {
		return idPersonaGiuridica;
	}

	public void setIdPersonaGiuridica(BigDecimal idPersonaGiuridica) {
		this.idPersonaGiuridica = idPersonaGiuridica;
	}

	private boolean isEscludiDataOdierna = false;
	
	public boolean getIsEscludiDataOdierna() {
		return isEscludiDataOdierna;
	}

	public void setIsEscludiDataOdierna(boolean isEscludiDataOdierna) {
		this.isEscludiDataOdierna = isEscludiDataOdierna;
	}

	private Date inData = new Date(Instant.now().toEpochMilli());

	public Date getInData() {
		return inData;
	}

	public void setInData(Date inData) {
		this.inData = inData;
	}

	// il serial version uid e' fisso in quanto la classe in oggetto e' serializzabile
	// solo per la clusterizzazione della sessione web e non viene scambiata con altre
	// componenti.
	private static final long serialVersionUID = 1L;

	/**
	 * Costruttore vuoto del DTO.
	 * @generated
	 */
	public FiltroRicercaPfPg() {
		super();

	}

	/**
	 * @generated
	 */
	public String toString() {
		/*PROTECTED REGION ID(R2070315721) ENABLED START*/
		/// inserire qui la logica desiderata per la rappresenatazione a stringa
		return super.toString();
		/*PROTECTED REGION END*/
	}
}
