package it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto;

import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.*;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.exceptions.*;
import java.io.Serializable;
import java.util.*;

/**
 * DTO specifico della query modellata nel finder rappProvaByIdIspezione.
 * @generated
 */
public class SigitTAllegatoRappProvaByIdIspezioneDto implements Serializable {

	/*	 
	 * @generated
	 */
	private java.sql.Date alleDataControllo;

	/**
	 * @generated
	 */
	public void setAlleDataControllo(java.sql.Date val) {

		if (val != null) {
			alleDataControllo = new java.sql.Date(val.getTime());
		} else {
			alleDataControllo = null;
		}

	}
	/**
	 * @generated
	 */
	public java.sql.Date getAlleDataControllo() {

		if (alleDataControllo != null) {
			return new java.sql.Date(alleDataControllo.getTime());
		} else {
			return null;
		}

	}

	/*	 
	 * @generated
	 */
	private java.math.BigDecimal alleIdAllegato;

	/**
	 * @generated
	 */
	public void setAlleIdAllegato(java.math.BigDecimal val) {

		alleIdAllegato = val;

	}
	/**
	 * @generated
	 */
	public java.math.BigDecimal getAlleIdAllegato() {

		return alleIdAllegato;

	}

	/*	 
	 * @generated
	 */
	private java.math.BigDecimal alleFkTipoDocumento;

	/**
	 * @generated
	 */
	public void setAlleFkTipoDocumento(java.math.BigDecimal val) {

		alleFkTipoDocumento = val;

	}
	/**
	 * @generated
	 */
	public java.math.BigDecimal getAlleFkTipoDocumento() {

		return alleFkTipoDocumento;

	}

	/*	 
	 * @generated
	 */
	private String docDesTipoDocumento;

	/**
	 * @generated
	 */
	public void setDocDesTipoDocumento(String val) {

		docDesTipoDocumento = val;

	}
	/**
	 * @generated
	 */
	public String getDocDesTipoDocumento() {

		return docDesTipoDocumento;

	}

	/*	 
	 * @generated
	 */
	private String srDesStatoRapp;

	/**
	 * @generated
	 */
	public void setSrDesStatoRapp(String val) {

		srDesStatoRapp = val;

	}
	/**
	 * @generated
	 */
	public String getSrDesStatoRapp() {

		return srDesStatoRapp;

	}

	/*	 
	 * @generated
	 */
	private String alleFOsservazioni;

	/**
	 * @generated
	 */
	public void setAlleFOsservazioni(String val) {

		alleFOsservazioni = val;

	}
	/**
	 * @generated
	 */
	public String getAlleFOsservazioni() {

		return alleFOsservazioni;

	}

	/*	 
	 * @generated
	 */
	private String alleFRaccomandazioni;

	/**
	 * @generated
	 */
	public void setAlleFRaccomandazioni(String val) {

		alleFRaccomandazioni = val;

	}
	/**
	 * @generated
	 */
	public String getAlleFRaccomandazioni() {

		return alleFRaccomandazioni;

	}

	/*	 
	 * @generated
	 */
	private String alleFPrescrizioni;

	/**
	 * @generated
	 */
	public void setAlleFPrescrizioni(String val) {

		alleFPrescrizioni = val;

	}
	/**
	 * @generated
	 */
	public String getAlleFPrescrizioni() {

		return alleFPrescrizioni;

	}

	/*	 
	 * @generated
	 */
	private String alleElencoApparecchiature;

	/**
	 * @generated
	 */
	public void setAlleElencoApparecchiature(String val) {

		alleElencoApparecchiature = val;

	}
	/**
	 * @generated
	 */
	public String getAlleElencoApparecchiature() {

		return alleElencoApparecchiature;

	}

	/*	 
	 * @generated
	 */
	private String alleUidIndexFirmato;

	/**
	 * @generated
	 */
	public void setAlleUidIndexFirmato(String val) {

		alleUidIndexFirmato = val;

	}
	/**
	 * @generated
	 */
	public String getAlleUidIndexFirmato() {

		return alleUidIndexFirmato;

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
