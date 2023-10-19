package it.csi.sigit.sigitbatchn.business.dao.sigitbatchn.qbe;

import it.csi.sigit.sigitbatchn.business.dao.sigitbatchn.dao.*;
import it.csi.sigit.sigitbatchn.business.dao.sigitbatchn.dto.*;
import it.csi.sigit.sigitbatchn.business.dao.qbe.*;
import it.csi.sigit.sigitbatchn.business.dao.sigitbatchn.exceptions.*;
import java.io.Serializable;
import java.util.*;

/**
 * Classe utilizzata dal framework di QBE (Query By Example).
 * Rappresenta l'esempio corrispondente al DTO [SigitDUnitaMisuraDto].
 * Contiene:
 * - una property di tipo FieldCheck per ogni property del DTO: 
 *   deve essere valorizzata per definire il constraint che l'esempio
 *   pone relativamente a quella property (es. range tra 1 e 100).
 * Combinando opportunamente i check e gli esempi (positivi e negativi)
 * e' possibile costruire query complesse
 * @generated
 */
public class SigitDUnitaMisuraExample extends AbstractExample {

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitbatchn.business.dao.qbe.FieldChk idUnitaMisura;

	/**
	 * @generated
	 */
	public void setIdUnitaMisura(it.csi.sigit.sigitbatchn.business.dao.qbe.FieldChk chk) {
		idUnitaMisura = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitbatchn.business.dao.qbe.FieldChk getIdUnitaMisura() {
		return idUnitaMisura;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitbatchn.business.dao.qbe.FieldChk desUnitaMisura;

	/**
	 * @generated
	 */
	public void setDesUnitaMisura(it.csi.sigit.sigitbatchn.business.dao.qbe.FieldChk chk) {
		desUnitaMisura = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitbatchn.business.dao.qbe.FieldChk getDesUnitaMisura() {
		return desUnitaMisura;
	}

}
