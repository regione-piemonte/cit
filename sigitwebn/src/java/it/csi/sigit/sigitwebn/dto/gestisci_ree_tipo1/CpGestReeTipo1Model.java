package it.csi.sigit.sigitwebn.dto.gestisci_ree_tipo1;

import java.util.*;
import it.csi.sigit.sigitwebn.dto.*;
import it.csi.sigit.sigitwebn.dto.accesso.*;
import it.csi.sigit.sigitwebn.dto.codici_impianto.*;
import it.csi.sigit.sigitwebn.dto.common.*;
import it.csi.sigit.sigitwebn.dto.impianto.*;
import it.csi.sigit.sigitwebn.dto.main.*;
import it.csi.sigit.sigitwebn.dto.bollini.*;
import it.csi.sigit.sigitwebn.dto.allegati.*;
import it.csi.sigit.sigitwebn.dto.subentro.*;
import it.csi.sigit.sigitwebn.dto.delega.*;
import it.csi.sigit.sigitwebn.dto.terzoresponsabile.*;
import it.csi.sigit.sigitwebn.dto.ispezioni.*;
import it.csi.sigit.sigitwebn.dto.distributori.*;
import it.csi.sigit.sigitwebn.dto.incarico.*;
import it.csi.sigit.sigitwebn.dto.impresa.*;
import it.csi.sigit.sigitwebn.dto.documentazione.*;
import it.csi.sigit.sigitwebn.dto.libretto.*;
import it.csi.sigit.sigitwebn.dto.ree.*;
import it.csi.sigit.sigitwebn.dto.verifica.*;
import it.csi.sigit.sigitwebn.dto.accertamento.*;
import it.csi.sigit.sigitwebn.dto.azioni.*;
import it.csi.sigit.sigitwebn.dto.sanzioni.*;
import it.csi.sigit.sigitwebn.dto.rappprova.*;
import it.csi.sigit.sigitwebn.dto.back_office.*;
import it.csi.sigit.sigitwebn.dto.userws.*;

import it.csi.sigit.sigitwebn.presentation.uiutils.*;
import flexjson.JSON;
import com.opensymphony.xwork2.conversion.annotations.*;
import com.opensymphony.xwork2.validator.annotations.*;

/**
 * Questo DTO incapsula tutto il contenuto informativo necessario all'esecuzione della
 * logica di business associata alla Schermata [cpGestReeTipo1]
 */
@Validation
public class CpGestReeTipo1Model extends BaseSessionAwareDTO {

	// il serial version uid e' fisso in quanto la classe in oggetto e' serializzabile
	// solo per la clusterizzazione della sessione web e non viene scambiata con altre
	// componenti.
	private static final long serialVersionUID = 1L;

	////////////////////////////////////////////////////////////////////
	/// application data
	////////////////////////////////////////////////////////////////////

	/**
	 * imposta il valore dell' ApplicationData 'appDatautenteLoggato'
	 * @param value
	 * @generated
	 */

	public void setAppDatautenteLoggato(it.csi.sigit.sigitwebn.dto.main.UtenteLoggato value) {
		getSession().put("appDatautenteLoggato", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDatautenteLoggato'
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.dto.main.UtenteLoggato getAppDatautenteLoggato() {
		return (it.csi.sigit.sigitwebn.dto.main.UtenteLoggato) (getSession().get("appDatautenteLoggato"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDatareeMenuTree'
	 * @param value
	 * @generated
	 */

	public void setAppDatareeMenuTree(it.csi.custom.component.tree.base.TreeNode value) {
		getSession().put("appDatareeMenuTree", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDatareeMenuTree'
	 * @generated
	 */
	public it.csi.custom.component.tree.base.TreeNode getAppDatareeMenuTree() {
		return (it.csi.custom.component.tree.base.TreeNode) (getSession().get("appDatareeMenuTree"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataidentificativoImpianto'
	 * @param value
	 * @generated
	 */

	public void setAppDataidentificativoImpianto(it.csi.sigit.sigitwebn.dto.impianto.IdentificativoImpianto value) {
		getSession().put("appDataidentificativoImpianto", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataidentificativoImpianto'
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.dto.impianto.IdentificativoImpianto getAppDataidentificativoImpianto() {
		return (it.csi.sigit.sigitwebn.dto.impianto.IdentificativoImpianto) (getSession()
				.get("appDataidentificativoImpianto"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataallegato'
	 * @param value
	 * @generated
	 */

	public void setAppDataallegato(it.csi.sigit.sigitwebn.dto.allegati.DettaglioAllegato value) {
		getSession().put("appDataallegato", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataallegato'
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.dto.allegati.DettaglioAllegato getAppDataallegato() {
		return (it.csi.sigit.sigitwebn.dto.allegati.DettaglioAllegato) (getSession().get("appDataallegato"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDatareeTipo1'
	 * @param value
	 * @generated
	 */

	public void setAppDatareeTipo1(it.csi.sigit.sigitwebn.dto.ree.Tipo1 value) {
		getSession().put("appDatareeTipo1", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDatareeTipo1'
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.dto.ree.Tipo1 getAppDatareeTipo1() {
		return (it.csi.sigit.sigitwebn.dto.ree.Tipo1) (getSession().get("appDatareeTipo1"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataprogressivoSelezionato'
	 * @param value
	 * @generated
	 */

	public void setAppDataprogressivoSelezionato(java.lang.Integer value) {
		getSession().put("appDataprogressivoSelezionato", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataprogressivoSelezionato'
	 * @generated
	 */
	public java.lang.Integer getAppDataprogressivoSelezionato() {
		return (java.lang.Integer) (getSession().get("appDataprogressivoSelezionato"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDatatipo1BConsumiSelezionati'
	 * @param value
	 * @generated
	 */

	public void setAppDatatipo1BConsumiSelezionati(java.util.ArrayList<java.lang.String> value) {
		getSession().put("appDatatipo1BConsumiSelezionati", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDatatipo1BConsumiSelezionati'
	 * @generated
	 */
	public java.util.ArrayList<java.lang.String> getAppDatatipo1BConsumiSelezionati() {
		return (java.util.ArrayList<java.lang.String>) (getSession().get("appDatatipo1BConsumiSelezionati"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDatatipo1BConsumiDaCancellare'
	 * @param value
	 * @generated
	 */

	public void setAppDatatipo1BConsumiDaCancellare(java.util.ArrayList<java.lang.Integer> value) {
		getSession().put("appDatatipo1BConsumiDaCancellare", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDatatipo1BConsumiDaCancellare'
	 * @generated
	 */
	public java.util.ArrayList<java.lang.Integer> getAppDatatipo1BConsumiDaCancellare() {
		return (java.util.ArrayList<java.lang.Integer>) (getSession().get("appDatatipo1BConsumiDaCancellare"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataelencoConsumiTipo1B'
	 * @param value
	 * @generated
	 */

	public void setAppDataelencoConsumiTipo1B(java.util.ArrayList<it.csi.sigit.sigitwebn.dto.ree.Tipo1Consumo> value) {
		getSession().put("appDataelencoConsumiTipo1B", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataelencoConsumiTipo1B'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.sigit.sigitwebn.dto.ree.Tipo1Consumo> getAppDataelencoConsumiTipo1B() {
		return (java.util.ArrayList<it.csi.sigit.sigitwebn.dto.ree.Tipo1Consumo>) (getSession()
				.get("appDataelencoConsumiTipo1B"));
	}

	////////////////////////////////////////////////////////////////////
	/// campi per widget semplici
	////////////////////////////////////////////////////////////////////

}
