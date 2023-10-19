package it.csi.sigit.sigitwebn.business.dao.sigitwebn.qbe;

import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.*;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.*;
import it.csi.sigit.sigitwebn.business.dao.qbe.*;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.exceptions.*;
import java.io.Serializable;
import java.util.*;

/**
 * Classe utilizzata dal framework di QBE (Query By Example).
 * Rappresenta l'esempio corrispondente al DTO [SigitTRappControlloDto].
 * Contiene:
 * - una property di tipo FieldCheck per ogni property del DTO: 
 *   deve essere valorizzata per definire il constraint che l'esempio
 *   pone relativamente a quella property (es. range tra 1 e 100).
 * Combinando opportunamente i check e gli esempi (positivi e negativi)
 * e' possibile costruire query complesse
 * @generated
 */
public class SigitTRappControlloExample extends AbstractExample {

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk idRapportoControllo;

	/**
	 * @generated
	 */
	public void setIdRapportoControllo(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		idRapportoControllo = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getIdRapportoControllo() {
		return idRapportoControllo;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk fkAllegato;

	/**
	 * @generated
	 */
	public void setFkAllegato(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		fkAllegato = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getFkAllegato() {
		return fkAllegato;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk noteUfficio;

	/**
	 * @generated
	 */
	public void setNoteUfficio(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		noteUfficio = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getNoteUfficio() {
		return noteUfficio;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk flgLocaleOk;

	/**
	 * @generated
	 */
	public void setFlgLocaleOk(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		flgLocaleOk = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getFlgLocaleOk() {
		return flgLocaleOk;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk flgAerazioneOk;

	/**
	 * @generated
	 */
	public void setFlgAerazioneOk(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		flgAerazioneOk = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getFlgAerazioneOk() {
		return flgAerazioneOk;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk flgAerazioneLibera;

	/**
	 * @generated
	 */
	public void setFlgAerazioneLibera(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		flgAerazioneLibera = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getFlgAerazioneLibera() {
		return flgAerazioneLibera;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk flgAssenzaFugheGas;

	/**
	 * @generated
	 */
	public void setFlgAssenzaFugheGas(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		flgAssenzaFugheGas = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getFlgAssenzaFugheGas() {
		return flgAssenzaFugheGas;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk flgEvacuazioneFumi;

	/**
	 * @generated
	 */
	public void setFlgEvacuazioneFumi(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		flgEvacuazioneFumi = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getFlgEvacuazioneFumi() {
		return flgEvacuazioneFumi;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk flgRapportoControllo;

	/**
	 * @generated
	 */
	public void setFlgRapportoControllo(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		flgRapportoControllo = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getFlgRapportoControllo() {
		return flgRapportoControllo;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk flgCertificazione;

	/**
	 * @generated
	 */
	public void setFlgCertificazione(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		flgCertificazione = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getFlgCertificazione() {
		return flgCertificazione;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk flgPraticaIspesl;

	/**
	 * @generated
	 */
	public void setFlgPraticaIspesl(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		flgPraticaIspesl = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getFlgPraticaIspesl() {
		return flgPraticaIspesl;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk flgCertPrevIncendi;

	/**
	 * @generated
	 */
	public void setFlgCertPrevIncendi(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		flgCertPrevIncendi = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getFlgCertPrevIncendi() {
		return flgCertPrevIncendi;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk flgCentraletermica;

	/**
	 * @generated
	 */
	public void setFlgCentraletermica(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		flgCentraletermica = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getFlgCentraletermica() {
		return flgCentraletermica;
	}

}
