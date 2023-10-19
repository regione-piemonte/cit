package it.csi.sigit.sigitext.business.dao.sigitextdao.dto;

import java.io.Serializable;

/**
 * DTO specifico della query modellata nel finder findByPf.
 * @generated
 */
public class SigitRPfPgDelegaFindByPfDto implements Serializable {

	/*	 
	 * @generated
	 */
	private java.math.BigDecimal pfpgdelegaIdPersonaFisica;

	/**
	 * @generated
	 */
	public void setPfPgDelegaIdPersonaFisica(java.math.BigDecimal val) {

		pfpgdelegaIdPersonaFisica = val;

	}
	/**
	 * @generated
	 */
	public java.math.BigDecimal getPfPgDelegaIdPersonaFisica() {

		return pfpgdelegaIdPersonaFisica;

	}

	/*	 
	 * @generated
	 */
	private java.math.BigDecimal pgIdPersonaGiuridica;

	/**
	 * @generated
	 */
	public void setPgIdPersonaGiuridica(java.math.BigDecimal val) {

		pgIdPersonaGiuridica = val;

	}
	/**
	 * @generated
	 */
	public java.math.BigDecimal getPgIdPersonaGiuridica() {

		return pgIdPersonaGiuridica;

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
	private java.sql.Date pgDataCessazione;

	/**
	 * @generated
	 */
	public void setPgDataCessazione(java.sql.Date val) {

		if (val != null) {
			pgDataCessazione = new java.sql.Date(val.getTime());
		} else {
			pgDataCessazione = null;
		}

	}
	/**
	 * @generated
	 */
	public java.sql.Date getPgDataCessazione() {

		if (pgDataCessazione != null) {
			return new java.sql.Date(pgDataCessazione.getTime());
		} else {
			return null;
		}

	}

	/*	 
	 * @generated
	 */
	private Integer pgFkStatoPg;

	/**
	 * @generated
	 */
	public void setPgFkStatoPg(Integer val) {

		pgFkStatoPg = val;

	}
	/**
	 * @generated
	 */
	public Integer getPgFkStatoPg() {

		return pgFkStatoPg;

	}

	/*	 
	 * @generated
	 */
	private String statopgDesStatoPg;

	/**
	 * @generated
	 */
	public void setStatoPgDesStatoPg(String val) {

		statopgDesStatoPg = val;

	}
	/**
	 * @generated
	 */
	public String getStatoPgDesStatoPg() {

		return statopgDesStatoPg;

	}

	/*	 
	 * @generated
	 */
	private java.math.BigDecimal pgFlgDm37Letterac;

	/**
	 * @generated
	 */
	public void setPgFlgDm37Letterac(java.math.BigDecimal val) {

		pgFlgDm37Letterac = val;

	}
	/**
	 * @generated
	 */
	public java.math.BigDecimal getPgFlgDm37Letterac() {

		return pgFlgDm37Letterac;

	}

	/*	 
	 * @generated
	 */
	private java.math.BigDecimal pgFlgAmministratore;

	/**
	 * @generated
	 */
	public void setPgFlgAmministratore(java.math.BigDecimal val) {

		pgFlgAmministratore = val;

	}
	/**
	 * @generated
	 */
	public java.math.BigDecimal getPgFlgAmministratore() {

		return pgFlgAmministratore;

	}

	/*	 
	 * @generated
	 */
	private java.math.BigDecimal pgFlgSoggIncaricato;

	/**
	 * @generated
	 */
	public void setPgFlgSoggIncaricato(java.math.BigDecimal val) {

		pgFlgSoggIncaricato = val;

	}
	/**
	 * @generated
	 */
	public java.math.BigDecimal getPgFlgSoggIncaricato() {

		return pgFlgSoggIncaricato;

	}

	/*	 
	 * @generated
	 */
	private java.math.BigDecimal pgFlgTerzoResponsabile;

	/**
	 * @generated
	 */
	public void setPgFlgTerzoResponsabile(java.math.BigDecimal val) {

		pgFlgTerzoResponsabile = val;

	}
	/**
	 * @generated
	 */
	public java.math.BigDecimal getPgFlgTerzoResponsabile() {

		return pgFlgTerzoResponsabile;

	}

	/*	 
	 * @generated
	 */
	private java.math.BigDecimal pgFlgDistributore;

	/**
	 * @generated
	 */
	public void setPgFlgDistributore(java.math.BigDecimal val) {

		pgFlgDistributore = val;

	}
	/**
	 * @generated
	 */
	public java.math.BigDecimal getPgFlgDistributore() {

		return pgFlgDistributore;

	}

	/*	 
	 * @generated
	 */
	private java.math.BigDecimal pgFlgCat;

	/**
	 * @generated
	 */
	public void setPgFlgCat(java.math.BigDecimal val) {

		pgFlgCat = val;

	}
	/**
	 * @generated
	 */
	public java.math.BigDecimal getPgFlgCat() {

		return pgFlgCat;
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
