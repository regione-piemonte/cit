package it.csi.sigit.sigitweba.business.dao.sigitweba.qbe;

import it.csi.sigit.sigitweba.business.dao.sigitweba.dao.*;
import it.csi.sigit.sigitweba.business.dao.sigitweba.dto.*;
import it.csi.sigit.sigitweba.business.dao.qbe.*;
import it.csi.sigit.sigitweba.business.dao.sigitweba.exceptions.*;
import java.io.Serializable;
import java.util.*;

/**
 * Classe utilizzata dal framework di QBE (Query By Example).
 * Rappresenta l'esempio corrispondente al DTO [SigitTFormazioneDto].
 * Contiene:
 * - una property di tipo FieldCheck per ogni property del DTO: 
 *   deve essere valorizzata per definire il constraint che l'esempio
 *   pone relativamente a quella property (es. range tra 1 e 100).
 * Combinando opportunamente i check e gli esempi (positivi e negativi)
 * e' possibile costruire query complesse
 * @generated
 */
public class SigitTFormazioneExample extends AbstractExample {

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitweba.business.dao.qbe.FieldChk dataCorso;

	/**
	 * @generated
	 */
	public void setDataCorso(it.csi.sigit.sigitweba.business.dao.qbe.FieldChk chk) {
		dataCorso = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitweba.business.dao.qbe.FieldChk getDataCorso() {
		return dataCorso;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitweba.business.dao.qbe.FieldChk idPersonaFisica;

	/**
	 * @generated
	 */
	public void setIdPersonaFisica(it.csi.sigit.sigitweba.business.dao.qbe.FieldChk chk) {
		idPersonaFisica = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitweba.business.dao.qbe.FieldChk getIdPersonaFisica() {
		return idPersonaFisica;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitweba.business.dao.qbe.FieldChk desCorso;

	/**
	 * @generated
	 */
	public void setDesCorso(it.csi.sigit.sigitweba.business.dao.qbe.FieldChk chk) {
		desCorso = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitweba.business.dao.qbe.FieldChk getDesCorso() {
		return desCorso;
	}

}
