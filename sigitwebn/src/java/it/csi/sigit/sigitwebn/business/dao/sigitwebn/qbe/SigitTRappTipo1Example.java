package it.csi.sigit.sigitwebn.business.dao.sigitwebn.qbe;

import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.*;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.*;
import it.csi.sigit.sigitwebn.business.dao.qbe.*;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.exceptions.*;
import java.io.Serializable;
import java.util.*;

/**
 * Classe utilizzata dal framework di QBE (Query By Example).
 * Rappresenta l'esempio corrispondente al DTO [SigitTRappTipo1Dto].
 * Contiene:
 * - una property di tipo FieldCheck per ogni property del DTO: 
 *   deve essere valorizzata per definire il constraint che l'esempio
 *   pone relativamente a quella property (es. range tra 1 e 100).
 * Combinando opportunamente i check e gli esempi (positivi e negativi)
 * e' possibile costruire query complesse
 * @generated
 */
public class SigitTRappTipo1Example extends AbstractExample {

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
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk dFlgLocaleIntIdoneo;

	/**
	 * @generated
	 */
	public void setDFlgLocaleIntIdoneo(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		dFlgLocaleIntIdoneo = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getDFlgLocaleIntIdoneo() {
		return dFlgLocaleIntIdoneo;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk dFlgGenExtIdoneo;

	/**
	 * @generated
	 */
	public void setDFlgGenExtIdoneo(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		dFlgGenExtIdoneo = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getDFlgGenExtIdoneo() {
		return dFlgGenExtIdoneo;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk dFlgApertureLibere;

	/**
	 * @generated
	 */
	public void setDFlgApertureLibere(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		dFlgApertureLibere = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getDFlgApertureLibere() {
		return dFlgApertureLibere;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk dFlgApertureAdeg;

	/**
	 * @generated
	 */
	public void setDFlgApertureAdeg(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		dFlgApertureAdeg = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getDFlgApertureAdeg() {
		return dFlgApertureAdeg;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk dFlgScaricoIdoneo;

	/**
	 * @generated
	 */
	public void setDFlgScaricoIdoneo(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		dFlgScaricoIdoneo = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getDFlgScaricoIdoneo() {
		return dFlgScaricoIdoneo;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk dFlgTempAmbFunz;

	/**
	 * @generated
	 */
	public void setDFlgTempAmbFunz(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		dFlgTempAmbFunz = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getDFlgTempAmbFunz() {
		return dFlgTempAmbFunz;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk dFlgAssenzaPerdComb;

	/**
	 * @generated
	 */
	public void setDFlgAssenzaPerdComb(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		dFlgAssenzaPerdComb = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getDFlgAssenzaPerdComb() {
		return dFlgAssenzaPerdComb;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk dFlgIdoTenImpInt;

	/**
	 * @generated
	 */
	public void setDFlgIdoTenImpInt(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		dFlgIdoTenImpInt = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getDFlgIdoTenImpInt() {
		return dFlgIdoTenImpInt;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk fFlgAdozioneValvoleTerm;

	/**
	 * @generated
	 */
	public void setFFlgAdozioneValvoleTerm(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		fFlgAdozioneValvoleTerm = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getFFlgAdozioneValvoleTerm() {
		return fFlgAdozioneValvoleTerm;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk fFlgIsolamenteRete;

	/**
	 * @generated
	 */
	public void setFFlgIsolamenteRete(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		fFlgIsolamenteRete = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getFFlgIsolamenteRete() {
		return fFlgIsolamenteRete;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk fFlgAdozSistTrattamH2o;

	/**
	 * @generated
	 */
	public void setFFlgAdozSistTrattamH2o(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		fFlgAdozSistTrattamH2o = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getFFlgAdozSistTrattamH2o() {
		return fFlgAdozSistTrattamH2o;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk fFlgSostituzSistRegolaz;

	/**
	 * @generated
	 */
	public void setFFlgSostituzSistRegolaz(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		fFlgSostituzSistRegolaz = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getFFlgSostituzSistRegolaz() {
		return fFlgSostituzSistRegolaz;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk cFlgTrattClimaNonRich;

	/**
	 * @generated
	 */
	public void setCFlgTrattClimaNonRich(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		cFlgTrattClimaNonRich = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getCFlgTrattClimaNonRich() {
		return cFlgTrattClimaNonRich;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk cFlgTrattAcsNonRichiesto;

	/**
	 * @generated
	 */
	public void setCFlgTrattAcsNonRichiesto(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		cFlgTrattAcsNonRichiesto = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getCFlgTrattAcsNonRichiesto() {
		return cFlgTrattAcsNonRichiesto;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk idStelle;

	/**
	 * @generated
	 */
	public void setIdStelle(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		idStelle = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getIdStelle() {
		return idStelle;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk idTipo1b;

	/**
	 * @generated
	 */
	public void setIdTipo1b(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		idTipo1b = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getIdTipo1b() {
		return idTipo1b;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk idAriaComburente;

	/**
	 * @generated
	 */
	public void setIdAriaComburente(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		idAriaComburente = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getIdAriaComburente() {
		return idAriaComburente;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk idControlloAria;

	/**
	 * @generated
	 */
	public void setIdControlloAria(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		idControlloAria = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getIdControlloAria() {
		return idControlloAria;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk idTipoCaricCombu;

	/**
	 * @generated
	 */
	public void setIdTipoCaricCombu(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		idTipoCaricCombu = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getIdTipoCaricCombu() {
		return idTipoCaricCombu;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk d1bFlgPuliziaCamino;

	/**
	 * @generated
	 */
	public void setD1bFlgPuliziaCamino(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		d1bFlgPuliziaCamino = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getD1bFlgPuliziaCamino() {
		return d1bFlgPuliziaCamino;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk e1bFlgCaldaia;

	/**
	 * @generated
	 */
	public void setE1bFlgCaldaia(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		e1bFlgCaldaia = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getE1bFlgCaldaia() {
		return e1bFlgCaldaia;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk e1bFlgStufa;

	/**
	 * @generated
	 */
	public void setE1bFlgStufa(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		e1bFlgStufa = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getE1bFlgStufa() {
		return e1bFlgStufa;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk e1bFlgStufaAccumulo;

	/**
	 * @generated
	 */
	public void setE1bFlgStufaAccumulo(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		e1bFlgStufaAccumulo = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getE1bFlgStufaAccumulo() {
		return e1bFlgStufaAccumulo;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk e1bFlgTermocucina;

	/**
	 * @generated
	 */
	public void setE1bFlgTermocucina(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		e1bFlgTermocucina = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getE1bFlgTermocucina() {
		return e1bFlgTermocucina;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk e1bFlgCaminettoAperto;

	/**
	 * @generated
	 */
	public void setE1bFlgCaminettoAperto(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		e1bFlgCaminettoAperto = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getE1bFlgCaminettoAperto() {
		return e1bFlgCaminettoAperto;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk e1bFlgCaminettoChiuso;

	/**
	 * @generated
	 */
	public void setE1bFlgCaminettoChiuso(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		e1bFlgCaminettoChiuso = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getE1bFlgCaminettoChiuso() {
		return e1bFlgCaminettoChiuso;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk e1bFlgInsertoCaminetto;

	/**
	 * @generated
	 */
	public void setE1bFlgInsertoCaminetto(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		e1bFlgInsertoCaminetto = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getE1bFlgInsertoCaminetto() {
		return e1bFlgInsertoCaminetto;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk e1bFlgStufaAssemblata;

	/**
	 * @generated
	 */
	public void setE1bFlgStufaAssemblata(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		e1bFlgStufaAssemblata = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getE1bFlgStufaAssemblata() {
		return e1bFlgStufaAssemblata;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk e1bFlgStufaPellet;

	/**
	 * @generated
	 */
	public void setE1bFlgStufaPellet(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		e1bFlgStufaPellet = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getE1bFlgStufaPellet() {
		return e1bFlgStufaPellet;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk e1bFlgMarcaturaCe;

	/**
	 * @generated
	 */
	public void setE1bFlgMarcaturaCe(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		e1bFlgMarcaturaCe = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getE1bFlgMarcaturaCe() {
		return e1bFlgMarcaturaCe;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk e1bFlgPlaccaCamino;

	/**
	 * @generated
	 */
	public void setE1bFlgPlaccaCamino(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		e1bFlgPlaccaCamino = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getE1bFlgPlaccaCamino() {
		return e1bFlgPlaccaCamino;
	}

}
