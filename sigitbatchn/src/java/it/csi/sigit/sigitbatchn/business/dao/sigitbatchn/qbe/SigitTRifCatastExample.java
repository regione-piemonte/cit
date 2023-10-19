package it.csi.sigit.sigitbatchn.business.dao.sigitbatchn.qbe;

import it.csi.sigit.sigitbatchn.business.dao.sigitbatchn.dao.*;
import it.csi.sigit.sigitbatchn.business.dao.sigitbatchn.dto.*;
import it.csi.sigit.sigitbatchn.business.dao.qbe.*;
import it.csi.sigit.sigitbatchn.business.dao.sigitbatchn.exceptions.*;
import java.io.Serializable;
import java.util.*;

/**
 * Classe utilizzata dal framework di QBE (Query By Example).
 * Rappresenta l'esempio corrispondente al DTO [SigitTRifCatastDto].
 * Contiene:
 * - una property di tipo FieldCheck per ogni property del DTO: 
 *   deve essere valorizzata per definire il constraint che l'esempio
 *   pone relativamente a quella property (es. range tra 1 e 100).
 * Combinando opportunamente i check e gli esempi (positivi e negativi)
 * e' possibile costruire query complesse
 * @generated
 */
public class SigitTRifCatastExample extends AbstractExample {

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitbatchn.business.dao.qbe.FieldChk idRifCatast;

	/**
	 * @generated
	 */
	public void setIdRifCatast(it.csi.sigit.sigitbatchn.business.dao.qbe.FieldChk chk) {
		idRifCatast = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitbatchn.business.dao.qbe.FieldChk getIdRifCatast() {
		return idRifCatast;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitbatchn.business.dao.qbe.FieldChk fkDatoDistrib;

	/**
	 * @generated
	 */
	public void setFkDatoDistrib(it.csi.sigit.sigitbatchn.business.dao.qbe.FieldChk chk) {
		fkDatoDistrib = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitbatchn.business.dao.qbe.FieldChk getFkDatoDistrib() {
		return fkDatoDistrib;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitbatchn.business.dao.qbe.FieldChk sezione;

	/**
	 * @generated
	 */
	public void setSezione(it.csi.sigit.sigitbatchn.business.dao.qbe.FieldChk chk) {
		sezione = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitbatchn.business.dao.qbe.FieldChk getSezione() {
		return sezione;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitbatchn.business.dao.qbe.FieldChk foglio;

	/**
	 * @generated
	 */
	public void setFoglio(it.csi.sigit.sigitbatchn.business.dao.qbe.FieldChk chk) {
		foglio = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitbatchn.business.dao.qbe.FieldChk getFoglio() {
		return foglio;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitbatchn.business.dao.qbe.FieldChk particella;

	/**
	 * @generated
	 */
	public void setParticella(it.csi.sigit.sigitbatchn.business.dao.qbe.FieldChk chk) {
		particella = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitbatchn.business.dao.qbe.FieldChk getParticella() {
		return particella;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitbatchn.business.dao.qbe.FieldChk subalterno;

	/**
	 * @generated
	 */
	public void setSubalterno(it.csi.sigit.sigitbatchn.business.dao.qbe.FieldChk chk) {
		subalterno = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitbatchn.business.dao.qbe.FieldChk getSubalterno() {
		return subalterno;
	}

}
