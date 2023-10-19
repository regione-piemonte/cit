package it.csi.sigit.sigitweba.business.dao.sigitweba.qbe;

import it.csi.sigit.sigitweba.business.dao.sigitweba.dao.*;
import it.csi.sigit.sigitweba.business.dao.sigitweba.dto.*;
import it.csi.sigit.sigitweba.business.dao.qbe.*;
import it.csi.sigit.sigitweba.business.dao.sigitweba.exceptions.*;
import java.io.Serializable;
import java.util.*;

/**
 * Classe utilizzata dal framework di QBE (Query By Example).
 * Rappresenta l'esempio corrispondente al DTO [SigitDRuoloAccredDto].
 * Contiene:
 * - una property di tipo FieldCheck per ogni property del DTO: 
 *   deve essere valorizzata per definire il constraint che l'esempio
 *   pone relativamente a quella property (es. range tra 1 e 100).
 * Combinando opportunamente i check e gli esempi (positivi e negativi)
 * e' possibile costruire query complesse
 * @generated
 */
public class SigitDRuoloAccredExample extends AbstractExample {

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitweba.business.dao.qbe.FieldChk idRuoloAccred;

	/**
	 * @generated
	 */
	public void setIdRuoloAccred(it.csi.sigit.sigitweba.business.dao.qbe.FieldChk chk) {
		idRuoloAccred = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitweba.business.dao.qbe.FieldChk getIdRuoloAccred() {
		return idRuoloAccred;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitweba.business.dao.qbe.FieldChk desRuoloAccred;

	/**
	 * @generated
	 */
	public void setDesRuoloAccred(it.csi.sigit.sigitweba.business.dao.qbe.FieldChk chk) {
		desRuoloAccred = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitweba.business.dao.qbe.FieldChk getDesRuoloAccred() {
		return desRuoloAccred;
	}

}
