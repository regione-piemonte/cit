package it.csi.sigit.sigitwebn.dto.gestisci_libretto_scheda6;

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
 * logica di business associata alla Schermata [cpGestLibScheda6]
 */
@Validation
public class CpGestLibScheda6Model extends BaseSessionAwareDTO {

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
	 * imposta il valore dell' ApplicationData 'appDataelencoTipoDistribuzione'
	 * @param value
	 * @generated
	 */

	public void setAppDataelencoTipoDistribuzione(
			java.util.ArrayList<it.csi.sigit.sigitwebn.dto.common.CodeDescription> value) {
		getSession().put("appDataelencoTipoDistribuzione", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataelencoTipoDistribuzione'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.sigit.sigitwebn.dto.common.CodeDescription> getAppDataelencoTipoDistribuzione() {
		return (java.util.ArrayList<it.csi.sigit.sigitwebn.dto.common.CodeDescription>) (getSession()
				.get("appDataelencoTipoDistribuzione"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataelencoPresenteAssente'
	 * @param value
	 * @generated
	 */

	public void setAppDataelencoPresenteAssente(
			java.util.ArrayList<it.csi.sigit.sigitwebn.dto.common.CodeDescription> value) {
		getSession().put("appDataelencoPresenteAssente", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataelencoPresenteAssente'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.sigit.sigitwebn.dto.common.CodeDescription> getAppDataelencoPresenteAssente() {
		return (java.util.ArrayList<it.csi.sigit.sigitwebn.dto.common.CodeDescription>) (getSession()
				.get("appDataelencoPresenteAssente"));
	}

	/**
	 * @generated
	 */
	private java.util.ArrayList<java.lang.String> appDatarigheSelezionate = new java.util.ArrayList<java.lang.String>();

	/**
	 * imposta il valore dell' ApplicationData 'appDatarigheSelezionate'
	 * @param value
	 * @generated
	 */

	public void setAppDatarigheSelezionate(java.util.ArrayList<java.lang.String> value) {
		appDatarigheSelezionate = value;
	}

	/**
	 * legge il valore dell' ApplicationData 'appDatarigheSelezionate'
	 * @generated
	 */
	public java.util.ArrayList<java.lang.String> getAppDatarigheSelezionate() {
		return appDatarigheSelezionate;
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDatasistemaDistribuzione'
	 * @param value
	 * @generated
	 */

	public void setAppDatasistemaDistribuzione(it.csi.sigit.sigitwebn.dto.libretto.SistemiDistribuzione value) {
		getSession().put("appDatasistemaDistribuzione", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDatasistemaDistribuzione'
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.dto.libretto.SistemiDistribuzione getAppDatasistemaDistribuzione() {
		return (it.csi.sigit.sigitwebn.dto.libretto.SistemiDistribuzione) (getSession()
				.get("appDatasistemaDistribuzione"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataelencoApertoChiuso'
	 * @param value
	 * @generated
	 */

	public void setAppDataelencoApertoChiuso(
			java.util.ArrayList<it.csi.sigit.sigitwebn.dto.common.CodeDescription> value) {
		getSession().put("appDataelencoApertoChiuso", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataelencoApertoChiuso'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.sigit.sigitwebn.dto.common.CodeDescription> getAppDataelencoApertoChiuso() {
		return (java.util.ArrayList<it.csi.sigit.sigitwebn.dto.common.CodeDescription>) (getSession()
				.get("appDataelencoApertoChiuso"));
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
	 * imposta il valore dell' ApplicationData 'appDatalistaComponentiVX'
	 * @param value
	 * @generated
	 */

	public void setAppDatalistaComponentiVX(
			java.util.ArrayList<it.csi.sigit.sigitwebn.dto.libretto.ComponenteVX> value) {
		getSession().put("appDatalistaComponentiVX", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDatalistaComponentiVX'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.sigit.sigitwebn.dto.libretto.ComponenteVX> getAppDatalistaComponentiVX() {
		return (java.util.ArrayList<it.csi.sigit.sigitwebn.dto.libretto.ComponenteVX>) (getSession()
				.get("appDatalistaComponentiVX"));
	}

	////////////////////////////////////////////////////////////////////
	/// campi per widget semplici
	////////////////////////////////////////////////////////////////////

}
