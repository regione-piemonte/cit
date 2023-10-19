package it.csi.sigit.sigitwebn.dto.gestisci_libretto_scheda4_6;

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
 * logica di business associata alla Schermata [cpGestLibScheda4_6Dett]
 */
@Validation
public class CpGestLibScheda4_6DettModel extends BaseSessionAwareDTO {

	// il serial version uid e' fisso in quanto la classe in oggetto e' serializzabile
	// solo per la clusterizzazione della sessione web e non viene scambiata con altre
	// componenti.
	private static final long serialVersionUID = 1L;

	////////////////////////////////////////////////////////////////////
	/// application data
	////////////////////////////////////////////////////////////////////

	/**
	 * imposta il valore dell' ApplicationData 'appDatapaginaChiamante'
	 * @param value
	 * @generated
	 */

	public void setAppDatapaginaChiamante(java.lang.String value) {
		getSession().put("appDatapaginaChiamante", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDatapaginaChiamante'
	 * @generated
	 */
	public java.lang.String getAppDatapaginaChiamante() {
		return (java.lang.String) (getSession().get("appDatapaginaChiamante"));
	}

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
	 * imposta il valore dell' ApplicationData 'appDatacomponenteCG'
	 * @param value
	 * @generated
	 */

	public void setAppDatacomponenteCG(it.csi.sigit.sigitwebn.dto.libretto.ComponenteCG value) {
		getSession().put("appDatacomponenteCG", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDatacomponenteCG'
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.dto.libretto.ComponenteCG getAppDatacomponenteCG() {
		return (it.csi.sigit.sigitwebn.dto.libretto.ComponenteCG) (getSession().get("appDatacomponenteCG"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataelencoFabbricante'
	 * @param value
	 * @generated
	 */

	public void setAppDataelencoFabbricante(
			java.util.ArrayList<it.csi.sigit.sigitwebn.dto.common.CodeDescription> value) {
		getSession().put("appDataelencoFabbricante", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataelencoFabbricante'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.sigit.sigitwebn.dto.common.CodeDescription> getAppDataelencoFabbricante() {
		return (java.util.ArrayList<it.csi.sigit.sigitwebn.dto.common.CodeDescription>) (getSession()
				.get("appDataelencoFabbricante"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDatalibrettoMenuTree'
	 * @param value
	 * @generated
	 */

	public void setAppDatalibrettoMenuTree(it.csi.custom.component.tree.base.TreeNode value) {
		getSession().put("appDatalibrettoMenuTree", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDatalibrettoMenuTree'
	 * @generated
	 */
	public it.csi.custom.component.tree.base.TreeNode getAppDatalibrettoMenuTree() {
		return (it.csi.custom.component.tree.base.TreeNode) (getSession().get("appDatalibrettoMenuTree"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataisNuovoComponente'
	 * @param value
	 * @generated
	 */

	public void setAppDataisNuovoComponente(java.lang.Boolean value) {
		getSession().put("appDataisNuovoComponente", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataisNuovoComponente'
	 * @generated
	 */
	public java.lang.Boolean getAppDataisNuovoComponente() {
		return (java.lang.Boolean) (getSession().get("appDataisNuovoComponente"));
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
	 * imposta il valore dell' ApplicationData 'appDataidImpiantoSelez'
	 * @param value
	 * @generated
	 */

	public void setAppDataidImpiantoSelez(java.lang.String value) {
		getSession().put("appDataidImpiantoSelez", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataidImpiantoSelez'
	 * @generated
	 */
	public java.lang.String getAppDataidImpiantoSelez() {
		return (java.lang.String) (getSession().get("appDataidImpiantoSelez"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDatalistaComponentiCG'
	 * @param value
	 * @generated
	 */

	public void setAppDatalistaComponentiCG(
			java.util.ArrayList<it.csi.sigit.sigitwebn.dto.libretto.ComponenteCG> value) {
		getSession().put("appDatalistaComponentiCG", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDatalistaComponentiCG'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.sigit.sigitwebn.dto.libretto.ComponenteCG> getAppDatalistaComponentiCG() {
		return (java.util.ArrayList<it.csi.sigit.sigitwebn.dto.libretto.ComponenteCG>) (getSession()
				.get("appDatalistaComponentiCG"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataelencoTipoCombustibili'
	 * @param value
	 * @generated
	 */

	public void setAppDataelencoTipoCombustibili(
			java.util.ArrayList<it.csi.sigit.sigitwebn.dto.common.CodeDescription> value) {
		getSession().put("appDataelencoTipoCombustibili", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataelencoTipoCombustibili'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.sigit.sigitwebn.dto.common.CodeDescription> getAppDataelencoTipoCombustibili() {
		return (java.util.ArrayList<it.csi.sigit.sigitwebn.dto.common.CodeDescription>) (getSession()
				.get("appDataelencoTipoCombustibili"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDatalistaStoricoComponentiCG'
	 * @param value
	 * @generated
	 */

	public void setAppDatalistaStoricoComponentiCG(
			java.util.ArrayList<it.csi.sigit.sigitwebn.dto.libretto.ComponenteCG> value) {
		getSession().put("appDatalistaStoricoComponentiCG", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDatalistaStoricoComponentiCG'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.sigit.sigitwebn.dto.libretto.ComponenteCG> getAppDatalistaStoricoComponentiCG() {
		return (java.util.ArrayList<it.csi.sigit.sigitwebn.dto.libretto.ComponenteCG>) (getSession()
				.get("appDatalistaStoricoComponentiCG"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDatarigaSelezionata'
	 * @param value
	 * @generated
	 */

	public void setAppDatarigaSelezionata(java.lang.String value) {
		getSession().put("appDatarigaSelezionata", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDatarigaSelezionata'
	 * @generated
	 */
	public java.lang.String getAppDatarigaSelezionata() {
		return (java.lang.String) (getSession().get("appDatarigaSelezionata"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataeditabilitaByRee'
	 * @param value
	 * @generated
	 */

	public void setAppDataeditabilitaByRee(java.lang.String value) {
		getSession().put("appDataeditabilitaByRee", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataeditabilitaByRee'
	 * @generated
	 */
	public java.lang.String getAppDataeditabilitaByRee() {
		return (java.lang.String) (getSession().get("appDataeditabilitaByRee"));
	}

	////////////////////////////////////////////////////////////////////
	/// campi per widget semplici
	////////////////////////////////////////////////////////////////////

	// Table tbSostituzioni

	private java.lang.String widgTbSostituzioni;

	public void setWidg_tbSostituzioni(java.lang.String value) {
		widgTbSostituzioni = value;
	}

	public java.lang.String getWidg_tbSostituzioni() {
		return widgTbSostituzioni;
	}

}
