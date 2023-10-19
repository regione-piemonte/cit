package it.csi.sigit.sigitweba.business.dao.sigitweba.dto;

import it.csi.sigit.sigitweba.business.dao.sigitweba.dao.*;
import it.csi.sigit.sigitweba.business.dao.sigitweba.exceptions.*;
import java.io.Serializable;
import java.util.*;

/**
 * DTO specifico della query modellata nel finder byCodiceFiscalePF.
 * @generated
 */
public class SigitRPfPgDelegaByCodiceFiscalePFDto implements Serializable {

	/*	 
	 * @generated
	 */
	private java.math.BigDecimal aIdPersonaFisica;

	/**
	 * @generated
	 */
	public void setAIdPersonaFisica(java.math.BigDecimal val) {

		aIdPersonaFisica = val;

	}
	/**
	 * @generated
	 */
	public java.math.BigDecimal getAIdPersonaFisica() {

		return aIdPersonaFisica;

	}

	/*	 
	 * @generated
	 */
	private java.math.BigDecimal aIdPersonaGiuridica;

	/**
	 * @generated
	 */
	public void setAIdPersonaGiuridica(java.math.BigDecimal val) {

		aIdPersonaGiuridica = val;

	}
	/**
	 * @generated
	 */
	public java.math.BigDecimal getAIdPersonaGiuridica() {

		return aIdPersonaGiuridica;

	}

	/*	 
	 * @generated
	 */
	private String aFlgDelega;

	/**
	 * @generated
	 */
	public void setAFlgDelega(String val) {

		aFlgDelega = val;

	}
	/**
	 * @generated
	 */
	public String getAFlgDelega() {

		return aFlgDelega;

	}

	/*	 
	 * @generated
	 */
	private java.sql.Date aDataInizio;

	/**
	 * @generated
	 */
	public void setADataInizio(java.sql.Date val) {

		if (val != null) {
			aDataInizio = new java.sql.Date(val.getTime());
		} else {
			aDataInizio = null;
		}

	}
	/**
	 * @generated
	 */
	public java.sql.Date getADataInizio() {

		if (aDataInizio != null) {
			return new java.sql.Date(aDataInizio.getTime());
		} else {
			return null;
		}

	}

	/*	 
	 * @generated
	 */
	private java.sql.Date aDataFine;

	/**
	 * @generated
	 */
	public void setADataFine(java.sql.Date val) {

		if (val != null) {
			aDataFine = new java.sql.Date(val.getTime());
		} else {
			aDataFine = null;
		}

	}
	/**
	 * @generated
	 */
	public java.sql.Date getADataFine() {

		if (aDataFine != null) {
			return new java.sql.Date(aDataFine.getTime());
		} else {
			return null;
		}

	}

	/*	 
	 * @generated
	 */
	private String bDenominazione;

	/**
	 * @generated
	 */
	public void setBDenominazione(String val) {

		bDenominazione = val;

	}
	/**
	 * @generated
	 */
	public String getBDenominazione() {

		return bDenominazione;

	}

	/*	 
	 * @generated
	 */
	private String bCodiceFiscale;

	/**
	 * @generated
	 */
	public void setBCodiceFiscale(String val) {

		bCodiceFiscale = val;

	}
	/**
	 * @generated
	 */
	public String getBCodiceFiscale() {

		return bCodiceFiscale;

	}

	/*	 
	 * @generated
	 */
	private String bIndirizzoSitad;

	/**
	 * @generated
	 */
	public void setBIndirizzoSitad(String val) {

		bIndirizzoSitad = val;

	}
	/**
	 * @generated
	 */
	public String getBIndirizzoSitad() {

		return bIndirizzoSitad;

	}

	/*	 
	 * @generated
	 */
	private String bIndirizzoNonTrovato;

	/**
	 * @generated
	 */
	public void setBIndirizzoNonTrovato(String val) {

		bIndirizzoNonTrovato = val;

	}
	/**
	 * @generated
	 */
	public String getBIndirizzoNonTrovato() {

		return bIndirizzoNonTrovato;

	}

	/*	 
	 * @generated
	 */
	private String bSiglaProv;

	/**
	 * @generated
	 */
	public void setBSiglaProv(String val) {

		bSiglaProv = val;

	}
	/**
	 * @generated
	 */
	public String getBSiglaProv() {

		return bSiglaProv;

	}

	/*	 
	 * @generated
	 */
	private String bIstatComune;

	/**
	 * @generated
	 */
	public void setBIstatComune(String val) {

		bIstatComune = val;

	}
	/**
	 * @generated
	 */
	public String getBIstatComune() {

		return bIstatComune;

	}

	/*	 
	 * @generated
	 */
	private String bComune;

	/**
	 * @generated
	 */
	public void setBComune(String val) {

		bComune = val;

	}
	/**
	 * @generated
	 */
	public String getBComune() {

		return bComune;

	}

	/*	 
	 * @generated
	 */
	private String bProvincia;

	/**
	 * @generated
	 */
	public void setBProvincia(String val) {

		bProvincia = val;

	}
	/**
	 * @generated
	 */
	public String getBProvincia() {

		return bProvincia;

	}

	/*	 
	 * @generated
	 */
	private String bCivico;

	/**
	 * @generated
	 */
	public void setBCivico(String val) {

		bCivico = val;

	}
	/**
	 * @generated
	 */
	public String getBCivico() {

		return bCivico;

	}

	/*	 
	 * @generated
	 */
	private String bCap;

	/**
	 * @generated
	 */
	public void setBCap(String val) {

		bCap = val;

	}
	/**
	 * @generated
	 */
	public String getBCap() {

		return bCap;

	}

	/*	 
	 * @generated
	 */
	private String bEmail;

	/**
	 * @generated
	 */
	public void setBEmail(String val) {

		bEmail = val;

	}
	/**
	 * @generated
	 */
	public String getBEmail() {

		return bEmail;

	}

	/*	 
	 * @generated
	 */
	private java.sql.Date bDataInizioAttivita;

	/**
	 * @generated
	 */
	public void setBDataInizioAttivita(java.sql.Date val) {

		if (val != null) {
			bDataInizioAttivita = new java.sql.Date(val.getTime());
		} else {
			bDataInizioAttivita = null;
		}

	}
	/**
	 * @generated
	 */
	public java.sql.Date getBDataInizioAttivita() {

		if (bDataInizioAttivita != null) {
			return new java.sql.Date(bDataInizioAttivita.getTime());
		} else {
			return null;
		}

	}

	/*	 
	 * @generated
	 */
	private java.sql.Date bDataCessazione;

	/**
	 * @generated
	 */
	public void setBDataCessazione(java.sql.Date val) {

		if (val != null) {
			bDataCessazione = new java.sql.Date(val.getTime());
		} else {
			bDataCessazione = null;
		}

	}
	/**
	 * @generated
	 */
	public java.sql.Date getBDataCessazione() {

		if (bDataCessazione != null) {
			return new java.sql.Date(bDataCessazione.getTime());
		} else {
			return null;
		}

	}

	/*	 
	 * @generated
	 */
	private String bSiglaRea;

	/**
	 * @generated
	 */
	public void setBSiglaRea(String val) {

		bSiglaRea = val;

	}
	/**
	 * @generated
	 */
	public String getBSiglaRea() {

		return bSiglaRea;

	}

	/*	 
	 * @generated
	 */
	private java.math.BigDecimal bNumeroRea;

	/**
	 * @generated
	 */
	public void setBNumeroRea(java.math.BigDecimal val) {

		bNumeroRea = val;

	}
	/**
	 * @generated
	 */
	public java.math.BigDecimal getBNumeroRea() {

		return bNumeroRea;

	}

	/*	 
	 * @generated
	 */
	private java.math.BigDecimal bFlgAmministratore;

	/**
	 * @generated
	 */
	public void setBFlgAmministratore(java.math.BigDecimal val) {

		bFlgAmministratore = val;

	}
	/**
	 * @generated
	 */
	public java.math.BigDecimal getBFlgAmministratore() {

		return bFlgAmministratore;

	}

	/*	 
	 * @generated
	 */
	private java.math.BigDecimal bFlgTerzoResponsabile;

	/**
	 * @generated
	 */
	public void setBFlgTerzoResponsabile(java.math.BigDecimal val) {

		bFlgTerzoResponsabile = val;

	}
	/**
	 * @generated
	 */
	public java.math.BigDecimal getBFlgTerzoResponsabile() {

		return bFlgTerzoResponsabile;

	}

	/*	 
	 * @generated
	 */
	private java.math.BigDecimal bFlgDistributore;

	/**
	 * @generated
	 */
	public void setBFlgDistributore(java.math.BigDecimal val) {

		bFlgDistributore = val;

	}
	/**
	 * @generated
	 */
	public java.math.BigDecimal getBFlgDistributore() {

		return bFlgDistributore;

	}

	/*	 
	 * @generated
	 */
	private java.math.BigDecimal bFlgCat;

	/**
	 * @generated
	 */
	public void setBFlgCat(java.math.BigDecimal val) {

		bFlgCat = val;

	}
	/**
	 * @generated
	 */
	public java.math.BigDecimal getBFlgCat() {

		return bFlgCat;

	}

	/*	 
	 * @generated
	 */
	private java.math.BigDecimal ruoloAccred;

	/**
	 * @generated
	 */
	public void setRuoloAccred(java.math.BigDecimal val) {

		ruoloAccred = val;

	}
	/**
	 * @generated
	 */
	public java.math.BigDecimal getRuoloAccred() {

		return ruoloAccred;

	}

	/*	 
	 * @generated
	 */
	private String tipoDm;

	/**
	 * @generated
	 */
	public void setTipoDm(String val) {

		tipoDm = val;

	}
	/**
	 * @generated
	 */
	public String getTipoDm() {

		return tipoDm;

	}

	/*	 
	 * @generated
	 */
	private java.math.BigDecimal bFkL2;

	/**
	 * @generated
	 */
	public void setBFkL2(java.math.BigDecimal val) {

		bFkL2 = val;

	}
	/**
	 * @generated
	 */
	public java.math.BigDecimal getBFkL2() {

		return bFkL2;

	}

	/*	 
	 * @generated
	 */
	private java.math.BigDecimal bFlgIndirizzoEstero;

	/**
	 * @generated
	 */
	public void setBFlgIndirizzoEstero(java.math.BigDecimal val) {

		bFlgIndirizzoEstero = val;

	}
	/**
	 * @generated
	 */
	public java.math.BigDecimal getBFlgIndirizzoEstero() {

		return bFlgIndirizzoEstero;

	}

	/*	 
	 * @generated
	 */
	private String bStatoEstero;

	/**
	 * @generated
	 */
	public void setBStatoEstero(String val) {

		bStatoEstero = val;

	}
	/**
	 * @generated
	 */
	public String getBStatoEstero() {

		return bStatoEstero;

	}

	/*	 
	 * @generated
	 */
	private String bCittaEstero;

	/**
	 * @generated
	 */
	public void setBCittaEstero(String val) {

		bCittaEstero = val;

	}
	/**
	 * @generated
	 */
	public String getBCittaEstero() {

		return bCittaEstero;

	}

	/*	 
	 * @generated
	 */
	private String bIndirizzoEstero;

	/**
	 * @generated
	 */
	public void setBIndirizzoEstero(String val) {

		bIndirizzoEstero = val;

	}
	/**
	 * @generated
	 */
	public String getBIndirizzoEstero() {

		return bIndirizzoEstero;

	}

	/*	 
	 * @generated
	 */
	private String bCapEstero;

	/**
	 * @generated
	 */
	public void setBCapEstero(String val) {

		bCapEstero = val;

	}
	/**
	 * @generated
	 */
	public String getBCapEstero() {

		return bCapEstero;

	}

	/*	 
	 * @generated
	 */
	private Integer bFkStatoPg;

	/**
	 * @generated
	 */
	public void setBFkStatoPg(Integer val) {

		bFkStatoPg = val;

	}
	/**
	 * @generated
	 */
	public Integer getBFkStatoPg() {

		return bFkStatoPg;

	}

	/*	 
	 * @generated
	 */
	private String dDesStatoPg;

	/**
	 * @generated
	 */
	public void setDDesStatoPg(String val) {

		dDesStatoPg = val;

	}
	/**
	 * @generated
	 */
	public String getDDesStatoPg() {

		return dDesStatoPg;

	}

	/*	 
	 * @generated
	 */
	private java.math.BigDecimal bFlgDm37Letterac;

	/**
	 * @generated
	 */
	public void setBFlgDm37Letterac(java.math.BigDecimal val) {

		bFlgDm37Letterac = val;

	}
	/**
	 * @generated
	 */
	public java.math.BigDecimal getBFlgDm37Letterac() {

		return bFlgDm37Letterac;

	}

	/*	 
	 * @generated
	 */
	private java.math.BigDecimal bFlgDm37Letterad;

	/**
	 * @generated
	 */
	public void setBFlgDm37Letterad(java.math.BigDecimal val) {

		bFlgDm37Letterad = val;

	}
	/**
	 * @generated
	 */
	public java.math.BigDecimal getBFlgDm37Letterad() {

		return bFlgDm37Letterad;

	}

	/*	 
	 * @generated
	 */
	private java.math.BigDecimal bFlgDm37Letterae;

	/**
	 * @generated
	 */
	public void setBFlgDm37Letterae(java.math.BigDecimal val) {

		bFlgDm37Letterae = val;

	}
	/**
	 * @generated
	 */
	public java.math.BigDecimal getBFlgDm37Letterae() {

		return bFlgDm37Letterae;

	}

	/*	 
	 * @generated
	 */
	private java.math.BigDecimal bFlgFgas;

	/**
	 * @generated
	 */
	public void setBFlgFgas(java.math.BigDecimal val) {

		bFlgFgas = val;

	}
	/**
	 * @generated
	 */
	public java.math.BigDecimal getBFlgFgas() {

		return bFlgFgas;

	}

	/*	 
	 * @generated
	 */
	private java.math.BigDecimal bFlgConduttore;

	/**
	 * @generated
	 */
	public void setBFlgConduttore(java.math.BigDecimal val) {

		bFlgConduttore = val;

	}
	/**
	 * @generated
	 */
	public java.math.BigDecimal getBFlgConduttore() {

		return bFlgConduttore;

	}

	/*	 
	 * @generated
	 */
	private java.math.BigDecimal bFlgSoggIncaricato;

	/**
	 * @generated
	 */
	public void setBFlgSoggIncaricato(java.math.BigDecimal val) {

		bFlgSoggIncaricato = val;

	}
	/**
	 * @generated
	 */
	public java.math.BigDecimal getBFlgSoggIncaricato() {

		return bFlgSoggIncaricato;

	}

	/*	 
	 * @generated
	 */
	private String bDelegaSoggIncaricato;

	/**
	 * @generated
	 */
	public void setBDelegaSoggIncaricato(String val) {

		bDelegaSoggIncaricato = val;

	}
	/**
	 * @generated
	 */
	public String getBDelegaSoggIncaricato() {

		return bDelegaSoggIncaricato;

	}

	/*	 
	 * @generated
	 */
	private String bPec;

	/**
	 * @generated
	 */
	public void setBPec(String val) {

		bPec = val;

	}
	/**
	 * @generated
	 */
	public String getBPec() {

		return bPec;

	}

	/*	 
	 * @generated
	 */
	private String bTelefono;

	/**
	 * @generated
	 */
	public void setBTelefono(String val) {

		bTelefono = val;

	}
	/**
	 * @generated
	 */
	public String getBTelefono() {

		return bTelefono;

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
