package it.csi.sigit.sigitbatchn.business.dao.sigitbatchn.qbe;

import it.csi.sigit.sigitbatchn.business.dao.sigitbatchn.dao.*;
import it.csi.sigit.sigitbatchn.business.dao.sigitbatchn.dto.*;
import it.csi.sigit.sigitbatchn.business.dao.qbe.*;
import it.csi.sigit.sigitbatchn.business.dao.sigitbatchn.exceptions.*;
import java.io.Serializable;
import java.util.*;

/**
 * Classe utilizzata dal framework di QBE (Query By Example).
 * Rappresenta l'esempio corrispondente al DTO [SigitWrkLogMemoTuDto].
 * Contiene:
 * - una property di tipo FieldCheck per ogni property del DTO: 
 *   deve essere valorizzata per definire il constraint che l'esempio
 *   pone relativamente a quella property (es. range tra 1 e 100).
 * Combinando opportunamente i check e gli esempi (positivi e negativi)
 * e' possibile costruire query complesse
 * @generated
 */
public class SigitWrkLogMemoTuExample extends AbstractExample {

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitbatchn.business.dao.qbe.FieldChk idLogMemoPtu;

	/**
	 * @generated
	 */
	public void setIdLogMemoPtu(it.csi.sigit.sigitbatchn.business.dao.qbe.FieldChk chk) {
		idLogMemoPtu = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitbatchn.business.dao.qbe.FieldChk getIdLogMemoPtu() {
		return idLogMemoPtu;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitbatchn.business.dao.qbe.FieldChk dtLogMemoPtu;

	/**
	 * @generated
	 */
	public void setDtLogMemoPtu(it.csi.sigit.sigitbatchn.business.dao.qbe.FieldChk chk) {
		dtLogMemoPtu = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitbatchn.business.dao.qbe.FieldChk getDtLogMemoPtu() {
		return dtLogMemoPtu;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitbatchn.business.dao.qbe.FieldChk noteLogMemoPtu;

	/**
	 * @generated
	 */
	public void setNoteLogMemoPtu(it.csi.sigit.sigitbatchn.business.dao.qbe.FieldChk chk) {
		noteLogMemoPtu = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitbatchn.business.dao.qbe.FieldChk getNoteLogMemoPtu() {
		return noteLogMemoPtu;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitbatchn.business.dao.qbe.FieldChk messaggioLogMemoPtu;

	/**
	 * @generated
	 */
	public void setMessaggioLogMemoPtu(it.csi.sigit.sigitbatchn.business.dao.qbe.FieldChk chk) {
		messaggioLogMemoPtu = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitbatchn.business.dao.qbe.FieldChk getMessaggioLogMemoPtu() {
		return messaggioLogMemoPtu;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitbatchn.business.dao.qbe.FieldChk esitoLogMemoPtu;

	/**
	 * @generated
	 */
	public void setEsitoLogMemoPtu(it.csi.sigit.sigitbatchn.business.dao.qbe.FieldChk chk) {
		esitoLogMemoPtu = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitbatchn.business.dao.qbe.FieldChk getEsitoLogMemoPtu() {
		return esitoLogMemoPtu;
	}

}
