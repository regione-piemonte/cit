package it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto;

import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.*;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.exceptions.*;
import java.io.Serializable;
import java.util.*;

/**
 * DTO specifico della query modellata nel finder ByExample.
 * @generated
 */
public class SigitRPfRuoloPaByExampleDto implements Serializable {

	/*	 
	 * @generated
	 */
	private Integer rpaIdRuoloPa;

	/**
	 * @generated
	 */
	public void setRpaIdRuoloPa(Integer val) {

		rpaIdRuoloPa = val;

	}
	/**
	 * @generated
	 */
	public Integer getRpaIdRuoloPa() {

		return rpaIdRuoloPa;

	}

	/*	 
	 * @generated
	 */
	private String drDesRuoloPa;

	/**
	 * @generated
	 */
	public void setDrDesRuoloPa(String val) {

		drDesRuoloPa = val;

	}
	/**
	 * @generated
	 */
	public String getDrDesRuoloPa() {

		return drDesRuoloPa;

	}

	/*	 
	 * @generated
	 */
	private String rpaIstatAbilitazione;

	/**
	 * @generated
	 */
	public void setRpaIstatAbilitazione(String val) {

		rpaIstatAbilitazione = val;

	}
	/**
	 * @generated
	 */
	public String getRpaIstatAbilitazione() {

		return rpaIstatAbilitazione;

	}

	/*	 
	 * @generated
	 */
	private String abMailComunicazione;

	/**
	 * @generated
	 */
	public void setAbMailComunicazione(String val) {

		abMailComunicazione = val;

	}
	/**
	 * @generated
	 */
	public String getAbMailComunicazione() {

		return abMailComunicazione;

	}

	/*	 
	 * @generated
	 */
	private java.math.BigDecimal pfIdPersonaFisica;

	/**
	 * @generated
	 */
	public void setPfIdPersonaFisica(java.math.BigDecimal val) {

		pfIdPersonaFisica = val;

	}
	/**
	 * @generated
	 */
	public java.math.BigDecimal getPfIdPersonaFisica() {

		return pfIdPersonaFisica;

	}

	/*	 
	 * @generated
	 */
	private String pfCognome;

	/**
	 * @generated
	 */
	public void setPfCognome(String val) {

		pfCognome = val;

	}
	/**
	 * @generated
	 */
	public String getPfCognome() {

		return pfCognome;

	}

	/*	 
	 * @generated
	 */
	private String pfNome;

	/**
	 * @generated
	 */
	public void setPfNome(String val) {

		pfNome = val;

	}
	/**
	 * @generated
	 */
	public String getPfNome() {

		return pfNome;

	}

	/*	 
	 * @generated
	 */
	private String pfCodiceFiscale;

	/**
	 * @generated
	 */
	public void setPfCodiceFiscale(String val) {

		pfCodiceFiscale = val;

	}
	/**
	 * @generated
	 */
	public String getPfCodiceFiscale() {

		return pfCodiceFiscale;

	}

	/*	 
	 * @generated
	 */
	private java.sql.Date rpaDataInizio;

	/**
	 * @generated
	 */
	public void setRpaDataInizio(java.sql.Date val) {

		if (val != null) {
			rpaDataInizio = new java.sql.Date(val.getTime());
		} else {
			rpaDataInizio = null;
		}

	}
	/**
	 * @generated
	 */
	public java.sql.Date getRpaDataInizio() {

		if (rpaDataInizio != null) {
			return new java.sql.Date(rpaDataInizio.getTime());
		} else {
			return null;
		}

	}

	/*	 
	 * @generated
	 */
	private java.sql.Date rpaDataFine;

	/**
	 * @generated
	 */
	public void setRpaDataFine(java.sql.Date val) {

		if (val != null) {
			rpaDataFine = new java.sql.Date(val.getTime());
		} else {
			rpaDataFine = null;
		}

	}
	/**
	 * @generated
	 */
	public java.sql.Date getRpaDataFine() {

		if (rpaDataFine != null) {
			return new java.sql.Date(rpaDataFine.getTime());
		} else {
			return null;
		}

	}

	/*	 
	 * @generated
	 */
	private String rpaNote;

	/**
	 * @generated
	 */
	public void setRpaNote(String val) {

		rpaNote = val;

	}
	/**
	 * @generated
	 */
	public String getRpaNote() {

		return rpaNote;

	}

	/*	 
	 * @generated
	 */
	private String rpaDescAbilitazione;

	/**
	 * @generated
	 */
	public void setRpaDescAbilitazione(String val) {

		rpaDescAbilitazione = val;

	}
	/**
	 * @generated
	 */
	public String getRpaDescAbilitazione() {

		return rpaDescAbilitazione;

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
