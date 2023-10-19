package it.csi.sigit.sigitweba.business.dao.sigitweba.qbe;

import it.csi.sigit.sigitweba.business.dao.sigitweba.dao.*;
import it.csi.sigit.sigitweba.business.dao.sigitweba.dto.*;
import it.csi.sigit.sigitweba.business.dao.qbe.*;
import it.csi.sigit.sigitweba.business.dao.sigitweba.exceptions.*;
import java.io.Serializable;
import java.util.*;

/**
 * Classe utilizzata dal framework di QBE (Query By Example).
 * Rappresenta l'esempio corrispondente al DTO [SigitDDmDto].
 * Contiene:
 * - una property di tipo FieldCheck per ogni property del DTO: 
 *   deve essere valorizzata per definire il constraint che l'esempio
 *   pone relativamente a quella property (es. range tra 1 e 100).
 * Combinando opportunamente i check e gli esempi (positivi e negativi)
 * e' possibile costruire query complesse
 * @generated
 */
public class SigitDDmExample extends AbstractExample {

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitweba.business.dao.qbe.FieldChk tipoDm372008;

	/**
	 * @generated
	 */
	public void setTipoDm372008(it.csi.sigit.sigitweba.business.dao.qbe.FieldChk chk) {
		tipoDm372008 = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitweba.business.dao.qbe.FieldChk getTipoDm372008() {
		return tipoDm372008;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitweba.business.dao.qbe.FieldChk desTipoDm372008;

	/**
	 * @generated
	 */
	public void setDesTipoDm372008(it.csi.sigit.sigitweba.business.dao.qbe.FieldChk chk) {
		desTipoDm372008 = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitweba.business.dao.qbe.FieldChk getDesTipoDm372008() {
		return desTipoDm372008;
	}

}
