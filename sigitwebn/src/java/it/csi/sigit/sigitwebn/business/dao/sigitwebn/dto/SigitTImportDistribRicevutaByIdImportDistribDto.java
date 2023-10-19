package it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto;

import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.*;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.exceptions.*;
import java.io.Serializable;
import java.util.*;

/**
 * DTO specifico della query modellata nel finder ricevutaByIdImportDistrib.
 * @generated
 */
public class SigitTImportDistribRicevutaByIdImportDistribDto implements Serializable {

	/*	 
	 * @generated
	 */
	private Integer idIdImportDistrib;

	/**
	 * @generated
	 */
	public void setIdIdImportDistrib(Integer val) {

		idIdImportDistrib = val;

	}
	/**
	 * @generated
	 */
	public Integer getIdIdImportDistrib() {

		return idIdImportDistrib;

	}

	/*	 
	 * @generated
	 */
	private java.sql.Timestamp idDataInizioElab;

	/**
	 * @generated
	 */
	public void setIdDataInizioElab(java.sql.Timestamp val) {

		if (val != null) {
			idDataInizioElab = new java.sql.Timestamp(val.getTime());
		} else {
			idDataInizioElab = null;
		}

	}
	/**
	 * @generated
	 */
	public java.sql.Timestamp getIdDataInizioElab() {

		if (idDataInizioElab != null) {
			return new java.sql.Timestamp(idDataInizioElab.getTime());
		} else {
			return null;
		}

	}

	/*	 
	 * @generated
	 */
	private java.sql.Timestamp idDataFineElab;

	/**
	 * @generated
	 */
	public void setIdDataFineElab(java.sql.Timestamp val) {

		if (val != null) {
			idDataFineElab = new java.sql.Timestamp(val.getTime());
		} else {
			idDataFineElab = null;
		}

	}
	/**
	 * @generated
	 */
	public java.sql.Timestamp getIdDataFineElab() {

		if (idDataFineElab != null) {
			return new java.sql.Timestamp(idDataFineElab.getTime());
		} else {
			return null;
		}

	}

	/*	 
	 * @generated
	 */
	private String idNomeFileImport;

	/**
	 * @generated
	 */
	public void setIdNomeFileImport(String val) {

		idNomeFileImport = val;

	}
	/**
	 * @generated
	 */
	public String getIdNomeFileImport() {

		return idNomeFileImport;

	}

	/*	 
	 * @generated
	 */
	private java.math.BigDecimal idAnnoRiferimento;

	/**
	 * @generated
	 */
	public void setIdAnnoRiferimento(java.math.BigDecimal val) {

		idAnnoRiferimento = val;

	}
	/**
	 * @generated
	 */
	public java.math.BigDecimal getIdAnnoRiferimento() {

		return idAnnoRiferimento;

	}

	/*	 
	 * @generated
	 */
	private String sdDesStatoDistrib;

	/**
	 * @generated
	 */
	public void setSdDesStatoDistrib(String val) {

		sdDesStatoDistrib = val;

	}
	/**
	 * @generated
	 */
	public String getSdDesStatoDistrib() {

		return sdDesStatoDistrib;

	}

	/*	 
	 * @generated
	 */
	private java.sql.Timestamp idDataAnnullamento;

	/**
	 * @generated
	 */
	public void setIdDataAnnullamento(java.sql.Timestamp val) {

		if (val != null) {
			idDataAnnullamento = new java.sql.Timestamp(val.getTime());
		} else {
			idDataAnnullamento = null;
		}

	}
	/**
	 * @generated
	 */
	public java.sql.Timestamp getIdDataAnnullamento() {

		if (idDataAnnullamento != null) {
			return new java.sql.Timestamp(idDataAnnullamento.getTime());
		} else {
			return null;
		}

	}

	/*	 
	 * @generated
	 */
	private String pgSiglaRea;

	/**
	 * @generated
	 */
	public void setPgSiglaRea(String val) {

		pgSiglaRea = val;

	}
	/**
	 * @generated
	 */
	public String getPgSiglaRea() {

		return pgSiglaRea;

	}

	/*	 
	 * @generated
	 */
	private java.math.BigDecimal pgNumeroRea;

	/**
	 * @generated
	 */
	public void setPgNumeroRea(java.math.BigDecimal val) {

		pgNumeroRea = val;

	}
	/**
	 * @generated
	 */
	public java.math.BigDecimal getPgNumeroRea() {

		return pgNumeroRea;

	}

	/*	 
	 * @generated
	 */
	private String pgComune;

	/**
	 * @generated
	 */
	public void setPgComune(String val) {

		pgComune = val;

	}
	/**
	 * @generated
	 */
	public String getPgComune() {

		return pgComune;

	}

	/*	 
	 * @generated
	 */
	private String pgSiglaProv;

	/**
	 * @generated
	 */
	public void setPgSiglaProv(String val) {

		pgSiglaProv = val;

	}
	/**
	 * @generated
	 */
	public String getPgSiglaProv() {

		return pgSiglaProv;

	}

	/*	 
	 * @generated
	 */
	private String pgIndirizzoSitad;

	/**
	 * @generated
	 */
	public void setPgIndirizzoSitad(String val) {

		pgIndirizzoSitad = val;

	}
	/**
	 * @generated
	 */
	public String getPgIndirizzoSitad() {

		return pgIndirizzoSitad;

	}

	/*	 
	 * @generated
	 */
	private String pgIndirizzoNonTrovato;

	/**
	 * @generated
	 */
	public void setPgIndirizzoNonTrovato(String val) {

		pgIndirizzoNonTrovato = val;

	}
	/**
	 * @generated
	 */
	public String getPgIndirizzoNonTrovato() {

		return pgIndirizzoNonTrovato;

	}

	/*	 
	 * @generated
	 */
	private String pgCivico;

	/**
	 * @generated
	 */
	public void setPgCivico(String val) {

		pgCivico = val;

	}
	/**
	 * @generated
	 */
	public String getPgCivico() {

		return pgCivico;

	}

	/*	 
	 * @generated
	 */
	private String pgDenominazione;

	/**
	 * @generated
	 */
	public void setPgDenominazione(String val) {

		pgDenominazione = val;

	}
	/**
	 * @generated
	 */
	public String getPgDenominazione() {

		return pgDenominazione;

	}

	/*	 
	 * @generated
	 */
	private String pgCodiceFiscale;

	/**
	 * @generated
	 */
	public void setPgCodiceFiscale(String val) {

		pgCodiceFiscale = val;

	}
	/**
	 * @generated
	 */
	public String getPgCodiceFiscale() {

		return pgCodiceFiscale;

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
