package it.csi.sigit.sigitwebn.business.dao.sigitwebn.qbe;

import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.*;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.*;
import it.csi.sigit.sigitwebn.business.dao.qbe.*;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.exceptions.*;
import java.io.Serializable;
import java.util.*;

/**
 * Classe utilizzata dal framework di QBE (Query By Example).
 * Rappresenta l'esempio corrispondente al DTO [SigitDTipoCaricCombuDto].
 * Contiene:
 * - una property di tipo FieldCheck per ogni property del DTO: 
 *   deve essere valorizzata per definire il constraint che l'esempio
 *   pone relativamente a quella property (es. range tra 1 e 100).
 * Combinando opportunamente i check e gli esempi (positivi e negativi)
 * e' possibile costruire query complesse
 * @generated
 */
public class SigitDTipoCaricCombuExample extends AbstractExample {

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
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk descTipoCaricCombu;

	/**
	 * @generated
	 */
	public void setDescTipoCaricCombu(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		descTipoCaricCombu = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getDescTipoCaricCombu() {
		return descTipoCaricCombu;
	}

}
