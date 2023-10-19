package it.csi.sigit.sigitwebn.business.dao.sigitwebn.qbe;

import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.*;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.*;
import it.csi.sigit.sigitwebn.business.dao.qbe.*;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.exceptions.*;
import java.io.Serializable;
import java.util.*;

/**
 * Classe utilizzata dal framework di QBE (Query By Example).
 * Rappresenta l'esempio corrispondente al DTO [SigitTDatoDistribDto].
 * Contiene:
 * - una property di tipo FieldCheck per ogni property del DTO: 
 *   deve essere valorizzata per definire il constraint che l'esempio
 *   pone relativamente a quella property (es. range tra 1 e 100).
 * Combinando opportunamente i check e gli esempi (positivi e negativi)
 * e' possibile costruire query complesse
 * @generated
 */
public class SigitTDatoDistribExample extends AbstractExample {

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk idDatoDistrib;

	/**
	 * @generated
	 */
	public void setIdDatoDistrib(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		idDatoDistrib = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getIdDatoDistrib() {
		return idDatoDistrib;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk fkTipoContratto;

	/**
	 * @generated
	 */
	public void setFkTipoContratto(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		fkTipoContratto = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getFkTipoContratto() {
		return fkTipoContratto;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk fkImportDistrib;

	/**
	 * @generated
	 */
	public void setFkImportDistrib(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		fkImportDistrib = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getFkImportDistrib() {
		return fkImportDistrib;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk fkCategoriaUtil;

	/**
	 * @generated
	 */
	public void setFkCategoriaUtil(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		fkCategoriaUtil = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getFkCategoriaUtil() {
		return fkCategoriaUtil;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk fkCombustibile;

	/**
	 * @generated
	 */
	public void setFkCombustibile(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		fkCombustibile = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getFkCombustibile() {
		return fkCombustibile;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk codiceAssenzaCatast;

	/**
	 * @generated
	 */
	public void setCodiceAssenzaCatast(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		codiceAssenzaCatast = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getCodiceAssenzaCatast() {
		return codiceAssenzaCatast;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk fkUnitaMisura;

	/**
	 * @generated
	 */
	public void setFkUnitaMisura(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		fkUnitaMisura = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getFkUnitaMisura() {
		return fkUnitaMisura;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk flgPfPg;

	/**
	 * @generated
	 */
	public void setFlgPfPg(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		flgPfPg = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getFlgPfPg() {
		return flgPfPg;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk cognomeDenom;

	/**
	 * @generated
	 */
	public void setCognomeDenom(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		cognomeDenom = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getCognomeDenom() {
		return cognomeDenom;
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
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk cfPiva;

	/**
	 * @generated
	 */
	public void setCfPiva(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		cfPiva = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getCfPiva() {
		return cfPiva;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk annoRif;

	/**
	 * @generated
	 */
	public void setAnnoRif(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		annoRif = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getAnnoRif() {
		return annoRif;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk nrMesiFattur;

	/**
	 * @generated
	 */
	public void setNrMesiFattur(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		nrMesiFattur = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getNrMesiFattur() {
		return nrMesiFattur;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk dug;

	/**
	 * @generated
	 */
	public void setDug(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		dug = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getDug() {
		return dug;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk indirizzo;

	/**
	 * @generated
	 */
	public void setIndirizzo(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		indirizzo = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getIndirizzo() {
		return indirizzo;
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
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk podPdr;

	/**
	 * @generated
	 */
	public void setPodPdr(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		podPdr = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getPodPdr() {
		return podPdr;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk consumoAnno;

	/**
	 * @generated
	 */
	public void setConsumoAnno(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		consumoAnno = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getConsumoAnno() {
		return consumoAnno;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk consumoMensile;

	/**
	 * @generated
	 */
	public void setConsumoMensile(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		consumoMensile = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getConsumoMensile() {
		return consumoMensile;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk meseRiferimento;

	/**
	 * @generated
	 */
	public void setMeseRiferimento(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		meseRiferimento = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getMeseRiferimento() {
		return meseRiferimento;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk consumoGiornaliero;

	/**
	 * @generated
	 */
	public void setConsumoGiornaliero(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		consumoGiornaliero = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getConsumoGiornaliero() {
		return consumoGiornaliero;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk giornoRiferimento;

	/**
	 * @generated
	 */
	public void setGiornoRiferimento(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		giornoRiferimento = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getGiornoRiferimento() {
		return giornoRiferimento;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk volumetria;

	/**
	 * @generated
	 */
	public void setVolumetria(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		volumetria = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getVolumetria() {
		return volumetria;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk flgPfPgFatt;

	/**
	 * @generated
	 */
	public void setFlgPfPgFatt(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		flgPfPgFatt = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getFlgPfPgFatt() {
		return flgPfPgFatt;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk cognomeDenomFatt;

	/**
	 * @generated
	 */
	public void setCognomeDenomFatt(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		cognomeDenomFatt = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getCognomeDenomFatt() {
		return cognomeDenomFatt;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk nomeFatt;

	/**
	 * @generated
	 */
	public void setNomeFatt(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		nomeFatt = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getNomeFatt() {
		return nomeFatt;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk cfPivaFatt;

	/**
	 * @generated
	 */
	public void setCfPivaFatt(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		cfPivaFatt = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getCfPivaFatt() {
		return cfPivaFatt;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk dugFatt;

	/**
	 * @generated
	 */
	public void setDugFatt(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		dugFatt = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getDugFatt() {
		return dugFatt;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk indirizzoFatt;

	/**
	 * @generated
	 */
	public void setIndirizzoFatt(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		indirizzoFatt = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getIndirizzoFatt() {
		return indirizzoFatt;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk civicoFatt;

	/**
	 * @generated
	 */
	public void setCivicoFatt(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		civicoFatt = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getCivicoFatt() {
		return civicoFatt;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk capFatt;

	/**
	 * @generated
	 */
	public void setCapFatt(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		capFatt = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getCapFatt() {
		return capFatt;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk istatComuneFatt;

	/**
	 * @generated
	 */
	public void setIstatComuneFatt(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		istatComuneFatt = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getIstatComuneFatt() {
		return istatComuneFatt;
	}

}
