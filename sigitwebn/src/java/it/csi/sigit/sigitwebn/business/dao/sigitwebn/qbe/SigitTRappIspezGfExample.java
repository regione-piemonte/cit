package it.csi.sigit.sigitwebn.business.dao.sigitwebn.qbe;

import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.*;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.*;
import it.csi.sigit.sigitwebn.business.dao.qbe.*;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.exceptions.*;
import java.io.Serializable;
import java.util.*;

/**
 * Classe utilizzata dal framework di QBE (Query By Example).
 * Rappresenta l'esempio corrispondente al DTO [SigitTRappIspezGfDto].
 * Contiene:
 * - una property di tipo FieldCheck per ogni property del DTO: 
 *   deve essere valorizzata per definire il constraint che l'esempio
 *   pone relativamente a quella property (es. range tra 1 e 100).
 * Combinando opportunamente i check e gli esempi (positivi e negativi)
 * e' possibile costruire query complesse
 * @generated
 */
public class SigitTRappIspezGfExample extends AbstractExample {

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk idAllegato;

	/**
	 * @generated
	 */
	public void setIdAllegato(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		idAllegato = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getIdAllegato() {
		return idAllegato;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk s1cFlgReeInviato;

	/**
	 * @generated
	 */
	public void setS1cFlgReeInviato(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		s1cFlgReeInviato = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getS1cFlgReeInviato() {
		return s1cFlgReeInviato;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk s1cFlgReeBollino;

	/**
	 * @generated
	 */
	public void setS1cFlgReeBollino(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		s1cFlgReeBollino = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getS1cFlgReeBollino() {
		return s1cFlgReeBollino;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk s1cSiglaBollino;

	/**
	 * @generated
	 */
	public void setS1cSiglaBollino(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		s1cSiglaBollino = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getS1cSiglaBollino() {
		return s1cSiglaBollino;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk s1cNumBollino;

	/**
	 * @generated
	 */
	public void setS1cNumBollino(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		s1cNumBollino = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getS1cNumBollino() {
		return s1cNumBollino;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk s1eDtPrimaInstallazione;

	/**
	 * @generated
	 */
	public void setS1eDtPrimaInstallazione(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		s1eDtPrimaInstallazione = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getS1eDtPrimaInstallazione() {
		return s1eDtPrimaInstallazione;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk s1ePotTermicaMaxKw;

	/**
	 * @generated
	 */
	public void setS1ePotTermicaMaxKw(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		s1ePotTermicaMaxKw = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getS1ePotTermicaMaxKw() {
		return s1ePotTermicaMaxKw;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk s1lDenomDelegato;

	/**
	 * @generated
	 */
	public void setS1lDenomDelegato(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		s1lDenomDelegato = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getS1lDenomDelegato() {
		return s1lDenomDelegato;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk s1lFlgDelega;

	/**
	 * @generated
	 */
	public void setS1lFlgDelega(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		s1lFlgDelega = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getS1lFlgDelega() {
		return s1lFlgDelega;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk s2eFlgTrattH2oNonRich;

	/**
	 * @generated
	 */
	public void setS2eFlgTrattH2oNonRich(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		s2eFlgTrattH2oNonRich = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getS2eFlgTrattH2oNonRich() {
		return s2eFlgTrattH2oNonRich;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk s3aFlgLocaleIntIdoneo;

	/**
	 * @generated
	 */
	public void setS3aFlgLocaleIntIdoneo(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		s3aFlgLocaleIntIdoneo = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getS3aFlgLocaleIntIdoneo() {
		return s3aFlgLocaleIntIdoneo;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk s3bFlgLineeElettrIdonee;

	/**
	 * @generated
	 */
	public void setS3bFlgLineeElettrIdonee(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		s3bFlgLineeElettrIdonee = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getS3bFlgLineeElettrIdonee() {
		return s3bFlgLineeElettrIdonee;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk s3cFlgVentilazAdeguate;

	/**
	 * @generated
	 */
	public void setS3cFlgVentilazAdeguate(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		s3cFlgVentilazAdeguate = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getS3cFlgVentilazAdeguate() {
		return s3cFlgVentilazAdeguate;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk s3dFlgCoibentazioniIdonee;

	/**
	 * @generated
	 */
	public void setS3dFlgCoibentazioniIdonee(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		s3dFlgCoibentazioniIdonee = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getS3dFlgCoibentazioniIdonee() {
		return s3dFlgCoibentazioniIdonee;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk s4aFlgLibImpPresente;

	/**
	 * @generated
	 */
	public void setS4aFlgLibImpPresente(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		s4aFlgLibImpPresente = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getS4aFlgLibImpPresente() {
		return s4aFlgLibImpPresente;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk s4bFlgLibCompilato;

	/**
	 * @generated
	 */
	public void setS4bFlgLibCompilato(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		s4bFlgLibCompilato = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getS4bFlgLibCompilato() {
		return s4bFlgLibCompilato;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk s4cFlgConformitaPresente;

	/**
	 * @generated
	 */
	public void setS4cFlgConformitaPresente(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		s4cFlgConformitaPresente = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getS4cFlgConformitaPresente() {
		return s4cFlgConformitaPresente;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk s4dFlgLibUsoPresente;

	/**
	 * @generated
	 */
	public void setS4dFlgLibUsoPresente(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		s4dFlgLibUsoPresente = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getS4dFlgLibUsoPresente() {
		return s4dFlgLibUsoPresente;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk s5aFlgSostituzMacchineReg;

	/**
	 * @generated
	 */
	public void setS5aFlgSostituzMacchineReg(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		s5aFlgSostituzMacchineReg = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getS5aFlgSostituzMacchineReg() {
		return s5aFlgSostituzMacchineReg;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk s5aFlgSostituzSistemiReg;

	/**
	 * @generated
	 */
	public void setS5aFlgSostituzSistemiReg(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		s5aFlgSostituzSistemiReg = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getS5aFlgSostituzSistemiReg() {
		return s5aFlgSostituzSistemiReg;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk s5aFlgIsolamReteDistrib;

	/**
	 * @generated
	 */
	public void setS5aFlgIsolamReteDistrib(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		s5aFlgIsolamReteDistrib = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getS5aFlgIsolamReteDistrib() {
		return s5aFlgIsolamReteDistrib;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk s5aFlgIsolamCanaliDistrib;

	/**
	 * @generated
	 */
	public void setS5aFlgIsolamCanaliDistrib(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		s5aFlgIsolamCanaliDistrib = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getS5aFlgIsolamCanaliDistrib() {
		return s5aFlgIsolamCanaliDistrib;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk s5bFlgNoIntervConv;

	/**
	 * @generated
	 */
	public void setS5bFlgNoIntervConv(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		s5bFlgNoIntervConv = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getS5bFlgNoIntervConv() {
		return s5bFlgNoIntervConv;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk s5bFlgRelazDettaglio;

	/**
	 * @generated
	 */
	public void setS5bFlgRelazDettaglio(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		s5bFlgRelazDettaglio = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getS5bFlgRelazDettaglio() {
		return s5bFlgRelazDettaglio;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk s5bFlgRelazDettaglioSucc;

	/**
	 * @generated
	 */
	public void setS5bFlgRelazDettaglioSucc(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		s5bFlgRelazDettaglioSucc = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getS5bFlgRelazDettaglioSucc() {
		return s5bFlgRelazDettaglioSucc;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk s5bFlgValutazNonEseguita;

	/**
	 * @generated
	 */
	public void setS5bFlgValutazNonEseguita(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		s5bFlgValutazNonEseguita = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getS5bFlgValutazNonEseguita() {
		return s5bFlgValutazNonEseguita;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk s5bMotivoRelazNonEseg;

	/**
	 * @generated
	 */
	public void setS5bMotivoRelazNonEseg(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		s5bMotivoRelazNonEseg = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getS5bMotivoRelazNonEseg() {
		return s5bMotivoRelazNonEseg;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk s5cFlgDimensCorretto;

	/**
	 * @generated
	 */
	public void setS5cFlgDimensCorretto(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		s5cFlgDimensCorretto = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getS5cFlgDimensCorretto() {
		return s5cFlgDimensCorretto;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk s5cFlgDimensNonControll;

	/**
	 * @generated
	 */
	public void setS5cFlgDimensNonControll(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		s5cFlgDimensNonControll = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getS5cFlgDimensNonControll() {
		return s5cFlgDimensNonControll;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk s5cFlgDimensRelazSucces;

	/**
	 * @generated
	 */
	public void setS5cFlgDimensRelazSucces(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		s5cFlgDimensRelazSucces = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getS5cFlgDimensRelazSucces() {
		return s5cFlgDimensRelazSucces;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk dataUltMod;

	/**
	 * @generated
	 */
	public void setDataUltMod(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		dataUltMod = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getDataUltMod() {
		return dataUltMod;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk utenteUltMod;

	/**
	 * @generated
	 */
	public void setUtenteUltMod(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		utenteUltMod = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getUtenteUltMod() {
		return utenteUltMod;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk s1cDataRee;

	/**
	 * @generated
	 */
	public void setS1cDataRee(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		s1cDataRee = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getS1cDataRee() {
		return s1cDataRee;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk s5cFlgDimensNonCorretto;

	/**
	 * @generated
	 */
	public void setS5cFlgDimensNonCorretto(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		s5cFlgDimensNonCorretto = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getS5cFlgDimensNonCorretto() {
		return s5cFlgDimensNonCorretto;
	}

}
