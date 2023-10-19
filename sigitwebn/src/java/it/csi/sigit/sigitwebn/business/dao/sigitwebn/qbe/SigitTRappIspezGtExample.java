package it.csi.sigit.sigitwebn.business.dao.sigitwebn.qbe;

import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.*;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.*;
import it.csi.sigit.sigitwebn.business.dao.qbe.*;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.exceptions.*;
import java.io.Serializable;
import java.util.*;

/**
 * Classe utilizzata dal framework di QBE (Query By Example).
 * Rappresenta l'esempio corrispondente al DTO [SigitTRappIspezGtDto].
 * Contiene:
 * - una property di tipo FieldCheck per ogni property del DTO: 
 *   deve essere valorizzata per definire il constraint che l'esempio
 *   pone relativamente a quella property (es. range tra 1 e 100).
 * Combinando opportunamente i check e gli esempi (positivi e negativi)
 * e' possibile costruire query complesse
 * @generated
 */
public class SigitTRappIspezGtExample extends AbstractExample {

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
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk s1ePotFocolareKw;

	/**
	 * @generated
	 */
	public void setS1ePotFocolareKw(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		s1ePotFocolareKw = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getS1ePotFocolareKw() {
		return s1ePotFocolareKw;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk s1ePotUtileKw;

	/**
	 * @generated
	 */
	public void setS1ePotUtileKw(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		s1ePotUtileKw = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getS1ePotUtileKw() {
		return s1ePotUtileKw;
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
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk s2b1FlgTermoContab;

	/**
	 * @generated
	 */
	public void setS2b1FlgTermoContab(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		s2b1FlgTermoContab = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getS2b1FlgTermoContab() {
		return s2b1FlgTermoContab;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk s2b2FlgUni10200;

	/**
	 * @generated
	 */
	public void setS2b2FlgUni10200(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		s2b2FlgUni10200 = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getS2b2FlgUni10200() {
		return s2b2FlgUni10200;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk s2fFlgTrattClimaNonRich;

	/**
	 * @generated
	 */
	public void setS2fFlgTrattClimaNonRich(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		s2fFlgTrattClimaNonRich = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getS2fFlgTrattClimaNonRich() {
		return s2fFlgTrattClimaNonRich;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk s2fFlgTrattAcsNonRich;

	/**
	 * @generated
	 */
	public void setS2fFlgTrattAcsNonRich(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		s2fFlgTrattAcsNonRich = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getS2fFlgTrattAcsNonRich() {
		return s2fFlgTrattAcsNonRich;
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
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk s3bFlgGenExtIdoneo;

	/**
	 * @generated
	 */
	public void setS3bFlgGenExtIdoneo(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		s3bFlgGenExtIdoneo = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getS3bFlgGenExtIdoneo() {
		return s3bFlgGenExtIdoneo;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk s3cFlgVentilazSuff;

	/**
	 * @generated
	 */
	public void setS3cFlgVentilazSuff(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		s3cFlgVentilazSuff = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getS3cFlgVentilazSuff() {
		return s3cFlgVentilazSuff;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk s3dFlgEvacFumiIdoneo;

	/**
	 * @generated
	 */
	public void setS3dFlgEvacFumiIdoneo(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		s3dFlgEvacFumiIdoneo = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getS3dFlgEvacFumiIdoneo() {
		return s3dFlgEvacFumiIdoneo;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk s3eFlgCartelliPresenti;

	/**
	 * @generated
	 */
	public void setS3eFlgCartelliPresenti(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		s3eFlgCartelliPresenti = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getS3eFlgCartelliPresenti() {
		return s3eFlgCartelliPresenti;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk s3fFlgEstinzPresenti;

	/**
	 * @generated
	 */
	public void setS3fFlgEstinzPresenti(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		s3fFlgEstinzPresenti = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getS3fFlgEstinzPresenti() {
		return s3fFlgEstinzPresenti;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk s3gFlgInterrGenPresenti;

	/**
	 * @generated
	 */
	public void setS3gFlgInterrGenPresenti(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		s3gFlgInterrGenPresenti = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getS3gFlgInterrGenPresenti() {
		return s3gFlgInterrGenPresenti;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk s3hFlgRubinPresente;

	/**
	 * @generated
	 */
	public void setS3hFlgRubinPresente(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		s3hFlgRubinPresente = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getS3hFlgRubinPresente() {
		return s3hFlgRubinPresente;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk s3iFlgAssenzaPerdComb;

	/**
	 * @generated
	 */
	public void setS3iFlgAssenzaPerdComb(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		s3iFlgAssenzaPerdComb = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getS3iFlgAssenzaPerdComb() {
		return s3iFlgAssenzaPerdComb;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk s3jFlgTempAmbFunz;

	/**
	 * @generated
	 */
	public void setS3jFlgTempAmbFunz(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		s3jFlgTempAmbFunz = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getS3jFlgTempAmbFunz() {
		return s3jFlgTempAmbFunz;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk s3kFlgDm1121975;

	/**
	 * @generated
	 */
	public void setS3kFlgDm1121975(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		s3kFlgDm1121975 = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getS3kFlgDm1121975() {
		return s3kFlgDm1121975;
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
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk s4eFlgPraticaVvfPresente;

	/**
	 * @generated
	 */
	public void setS4eFlgPraticaVvfPresente(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		s4eFlgPraticaVvfPresente = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getS4eFlgPraticaVvfPresente() {
		return s4eFlgPraticaVvfPresente;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk s4fFlgPraticaInailPresente;

	/**
	 * @generated
	 */
	public void setS4fFlgPraticaInailPresente(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		s4fFlgPraticaInailPresente = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getS4fFlgPraticaInailPresente() {
		return s4fFlgPraticaInailPresente;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk s4gFlgDm121975;

	/**
	 * @generated
	 */
	public void setS4gFlgDm121975(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		s4gFlgDm121975 = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getS4gFlgDm121975() {
		return s4gFlgDm121975;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk s4gMatricolaDm1121975;

	/**
	 * @generated
	 */
	public void setS4gMatricolaDm1121975(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		s4gMatricolaDm1121975 = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getS4gMatricolaDm1121975() {
		return s4gMatricolaDm1121975;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk s5aFlgAdozioneValvoleTerm;

	/**
	 * @generated
	 */
	public void setS5aFlgAdozioneValvoleTerm(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		s5aFlgAdozioneValvoleTerm = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getS5aFlgAdozioneValvoleTerm() {
		return s5aFlgAdozioneValvoleTerm;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk s5aFlgIsolamenteRete;

	/**
	 * @generated
	 */
	public void setS5aFlgIsolamenteRete(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		s5aFlgIsolamenteRete = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getS5aFlgIsolamenteRete() {
		return s5aFlgIsolamenteRete;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk s5aFlgAdozSistTrattamH2o;

	/**
	 * @generated
	 */
	public void setS5aFlgAdozSistTrattamH2o(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		s5aFlgAdozSistTrattamH2o = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getS5aFlgAdozSistTrattamH2o() {
		return s5aFlgAdozSistTrattamH2o;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk s5aFlgSostituzSistRegolaz;

	/**
	 * @generated
	 */
	public void setS5aFlgSostituzSistRegolaz(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		s5aFlgSostituzSistRegolaz = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getS5aFlgSostituzSistRegolaz() {
		return s5aFlgSostituzSistRegolaz;
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
