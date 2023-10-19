package it.csi.sigit.sigitwebn.business.dao.sigitwebn.qbe;

import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.*;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.*;
import it.csi.sigit.sigitwebn.business.dao.qbe.*;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.exceptions.*;
import java.io.Serializable;
import java.util.*;

/**
 * Classe utilizzata dal framework di QBE (Query By Example).
 * Rappresenta l'esempio corrispondente al DTO [SigitTUserWsDto].
 * Contiene:
 * - una property di tipo FieldCheck per ogni property del DTO: 
 *   deve essere valorizzata per definire il constraint che l'esempio
 *   pone relativamente a quella property (es. range tra 1 e 100).
 * Combinando opportunamente i check e gli esempi (positivi e negativi)
 * e' possibile costruire query complesse
 * @generated
 */
public class SigitTUserWsExample extends AbstractExample {

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk idUserWs;

	/**
	 * @generated
	 */
	public void setIdUserWs(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		idUserWs = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getIdUserWs() {
		return idUserWs;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk userWs;

	/**
	 * @generated
	 */
	public void setUserWs(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		userWs = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getUserWs() {
		return userWs;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk pwdWs;

	/**
	 * @generated
	 */
	public void setPwdWs(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		pwdWs = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getPwdWs() {
		return pwdWs;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk dtCreazioneToken;

	/**
	 * @generated
	 */
	public void setDtCreazioneToken(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		dtCreazioneToken = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getDtCreazioneToken() {
		return dtCreazioneToken;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk dtScadenzaToken;

	/**
	 * @generated
	 */
	public void setDtScadenzaToken(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		dtScadenzaToken = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getDtScadenzaToken() {
		return dtScadenzaToken;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk token;

	/**
	 * @generated
	 */
	public void setToken(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		token = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getToken() {
		return token;
	}

}
