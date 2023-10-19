package it.csi.sigit.sigitwebn.business.dao.sigitwebn.qbe;

import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.*;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.*;
import it.csi.sigit.sigitwebn.business.dao.qbe.*;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.exceptions.*;
import java.io.Serializable;
import java.util.*;

/**
 * Classe utilizzata dal framework di QBE (Query By Example).
 * Rappresenta l'esempio corrispondente al DTO [SigitVPfPgDto].
 * Contiene:
 * - una property di tipo FieldCheck per ogni property del DTO: 
 *   deve essere valorizzata per definire il constraint che l'esempio
 *   pone relativamente a quella property (es. range tra 1 e 100).
 * Combinando opportunamente i check e gli esempi (positivi e negativi)
 * e' possibile costruire query complesse
 * @generated
 */
public class SigitVPfPgExample extends AbstractExample {

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk idPersona;

	/**
	 * @generated
	 */
	public void setIdPersona(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		idPersona = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getIdPersona() {
		return idPersona;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk pfPg;

	/**
	 * @generated
	 */
	public void setPfPg(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		pfPg = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getPfPg() {
		return pfPg;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk nome;

	/**
	 * @generated
	 */
	public void setNome(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		nome = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getNome() {
		return nome;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk denominazione;

	/**
	 * @generated
	 */
	public void setDenominazione(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		denominazione = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getDenominazione() {
		return denominazione;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk siglaRea;

	/**
	 * @generated
	 */
	public void setSiglaRea(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		siglaRea = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getSiglaRea() {
		return siglaRea;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk numeroRea;

	/**
	 * @generated
	 */
	public void setNumeroRea(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		numeroRea = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getNumeroRea() {
		return numeroRea;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk codiceFiscale;

	/**
	 * @generated
	 */
	public void setCodiceFiscale(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		codiceFiscale = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getCodiceFiscale() {
		return codiceFiscale;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk fkL2;

	/**
	 * @generated
	 */
	public void setFkL2(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		fkL2 = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getFkL2() {
		return fkL2;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk indirizzoSitad;

	/**
	 * @generated
	 */
	public void setIndirizzoSitad(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		indirizzoSitad = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getIndirizzoSitad() {
		return indirizzoSitad;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk indirizzoNonTrovato;

	/**
	 * @generated
	 */
	public void setIndirizzoNonTrovato(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		indirizzoNonTrovato = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getIndirizzoNonTrovato() {
		return indirizzoNonTrovato;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk siglaProv;

	/**
	 * @generated
	 */
	public void setSiglaProv(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		siglaProv = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getSiglaProv() {
		return siglaProv;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk istatComune;

	/**
	 * @generated
	 */
	public void setIstatComune(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		istatComune = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getIstatComune() {
		return istatComune;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk comune;

	/**
	 * @generated
	 */
	public void setComune(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		comune = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getComune() {
		return comune;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk provincia;

	/**
	 * @generated
	 */
	public void setProvincia(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		provincia = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getProvincia() {
		return provincia;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk civico;

	/**
	 * @generated
	 */
	public void setCivico(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		civico = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getCivico() {
		return civico;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk cap;

	/**
	 * @generated
	 */
	public void setCap(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		cap = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getCap() {
		return cap;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk email;

	/**
	 * @generated
	 */
	public void setEmail(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		email = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getEmail() {
		return email;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk dataInizioAttivita;

	/**
	 * @generated
	 */
	public void setDataInizioAttivita(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		dataInizioAttivita = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getDataInizioAttivita() {
		return dataInizioAttivita;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk dataCessazione;

	/**
	 * @generated
	 */
	public void setDataCessazione(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		dataCessazione = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getDataCessazione() {
		return dataCessazione;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk flgIndirizzoEstero;

	/**
	 * @generated
	 */
	public void setFlgIndirizzoEstero(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		flgIndirizzoEstero = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getFlgIndirizzoEstero() {
		return flgIndirizzoEstero;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk statoEstero;

	/**
	 * @generated
	 */
	public void setStatoEstero(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		statoEstero = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getStatoEstero() {
		return statoEstero;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk cittaEstero;

	/**
	 * @generated
	 */
	public void setCittaEstero(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		cittaEstero = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getCittaEstero() {
		return cittaEstero;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk indirizzoEstero;

	/**
	 * @generated
	 */
	public void setIndirizzoEstero(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		indirizzoEstero = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getIndirizzoEstero() {
		return indirizzoEstero;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk capEstero;

	/**
	 * @generated
	 */
	public void setCapEstero(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		capEstero = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getCapEstero() {
		return capEstero;
	}

}
