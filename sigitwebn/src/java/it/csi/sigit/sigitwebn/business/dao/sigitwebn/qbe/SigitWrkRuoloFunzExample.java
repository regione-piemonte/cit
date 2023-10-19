package it.csi.sigit.sigitwebn.business.dao.sigitwebn.qbe;

import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.*;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.*;
import it.csi.sigit.sigitwebn.business.dao.qbe.*;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.exceptions.*;
import java.io.Serializable;
import java.util.*;

/**
 * Classe utilizzata dal framework di QBE (Query By Example).
 * Rappresenta l'esempio corrispondente al DTO [SigitWrkRuoloFunzDto].
 * Contiene:
 * - una property di tipo FieldCheck per ogni property del DTO: 
 *   deve essere valorizzata per definire il constraint che l'esempio
 *   pone relativamente a quella property (es. range tra 1 e 100).
 * Combinando opportunamente i check e gli esempi (positivi e negativi)
 * e' possibile costruire query complesse
 * @generated
 */
public class SigitWrkRuoloFunzExample extends AbstractExample {

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk ruolo;

	/**
	 * @generated
	 */
	public void setRuolo(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		ruolo = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getRuolo() {
		return ruolo;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk flgAcqBollino;

	/**
	 * @generated
	 */
	public void setFlgAcqBollino(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		flgAcqBollino = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getFlgAcqBollino() {
		return flgAcqBollino;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk flgAcqCodImp;

	/**
	 * @generated
	 */
	public void setFlgAcqCodImp(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		flgAcqCodImp = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getFlgAcqCodImp() {
		return flgAcqCodImp;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk flgAcqBollTrans;

	/**
	 * @generated
	 */
	public void setFlgAcqBollTrans(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		flgAcqBollTrans = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getFlgAcqBollTrans() {
		return flgAcqBollTrans;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk flgImpianto;

	/**
	 * @generated
	 */
	public void setFlgImpianto(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		flgImpianto = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getFlgImpianto() {
		return flgImpianto;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk flgAllegato;

	/**
	 * @generated
	 */
	public void setFlgAllegato(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		flgAllegato = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getFlgAllegato() {
		return flgAllegato;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk flgConsultazione;

	/**
	 * @generated
	 */
	public void setFlgConsultazione(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		flgConsultazione = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getFlgConsultazione() {
		return flgConsultazione;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk flgIspezione;

	/**
	 * @generated
	 */
	public void setFlgIspezione(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		flgIspezione = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getFlgIspezione() {
		return flgIspezione;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk flgImportMassAllegato;

	/**
	 * @generated
	 */
	public void setFlgImportMassAllegato(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		flgImportMassAllegato = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getFlgImportMassAllegato() {
		return flgImportMassAllegato;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk flgSubentro;

	/**
	 * @generated
	 */
	public void setFlgSubentro(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		flgSubentro = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getFlgSubentro() {
		return flgSubentro;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk flgDelega;

	/**
	 * @generated
	 */
	public void setFlgDelega(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		flgDelega = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getFlgDelega() {
		return flgDelega;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk flg3responsabile;

	/**
	 * @generated
	 */
	public void setFlg3responsabile(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		flg3responsabile = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getFlg3responsabile() {
		return flg3responsabile;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk flgRicAvzImpianti;

	/**
	 * @generated
	 */
	public void setFlgRicAvzImpianti(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		flgRicAvzImpianti = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getFlgRicAvzImpianti() {
		return flgRicAvzImpianti;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk flgDistributori;

	/**
	 * @generated
	 */
	public void setFlgDistributori(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		flgDistributori = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getFlgDistributori() {
		return flgDistributori;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk flgIncarichiCat;

	/**
	 * @generated
	 */
	public void setFlgIncarichiCat(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		flgIncarichiCat = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getFlgIncarichiCat() {
		return flgIncarichiCat;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk flgImpresa;

	/**
	 * @generated
	 */
	public void setFlgImpresa(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		flgImpresa = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getFlgImpresa() {
		return flgImpresa;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk flgExpXmlModol;

	/**
	 * @generated
	 */
	public void setFlgExpXmlModol(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		flgExpXmlModol = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getFlgExpXmlModol() {
		return flgExpXmlModol;
	}

}
