package it.csi.sigit.sigitwebn.dto.gestisci_libretto_aggiornamenti;

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
 * logica di business associata alla Schermata [cpGestLibAggiornamenti]
 */
@Validation
public class CpGestLibAggiornamentiModel extends BaseSessionAwareDTO {

	// il serial version uid e' fisso in quanto la classe in oggetto e' serializzabile
	// solo per la clusterizzazione della sessione web e non viene scambiata con altre
	// componenti.
	private static final long serialVersionUID = 1L;

	////////////////////////////////////////////////////////////////////
	/// application data
	////////////////////////////////////////////////////////////////////

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
	 * imposta il valore dell' ApplicationData 'appDatacontrolloLibretto'
	 * @param value
	 * @generated
	 */

	public void setAppDatacontrolloLibretto(it.csi.sigit.sigitwebn.dto.libretto.ControlloLibretto value) {
		getSession().put("appDatacontrolloLibretto", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDatacontrolloLibretto'
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.dto.libretto.ControlloLibretto getAppDatacontrolloLibretto() {
		return (it.csi.sigit.sigitwebn.dto.libretto.ControlloLibretto) (getSession().get("appDatacontrolloLibretto"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDatalistaLibretti'
	 * @param value
	 * @generated
	 */

	public void setAppDatalistaLibretti(java.util.ArrayList<it.csi.sigit.sigitwebn.dto.libretto.LibrettoDett> value) {
		getSession().put("appDatalistaLibretti", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDatalistaLibretti'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.sigit.sigitwebn.dto.libretto.LibrettoDett> getAppDatalistaLibretti() {
		return (java.util.ArrayList<it.csi.sigit.sigitwebn.dto.libretto.LibrettoDett>) (getSession()
				.get("appDatalistaLibretti"));
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
	 * imposta il valore dell' ApplicationData 'appDataelencoVerifiche'
	 * @param value
	 * @generated
	 */

	public void setAppDataelencoVerifiche(java.util.ArrayList<it.csi.sigit.sigitwebn.dto.verifica.Verifica> value) {
		getSession().put("appDataelencoVerifiche", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataelencoVerifiche'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.sigit.sigitwebn.dto.verifica.Verifica> getAppDataelencoVerifiche() {
		return (java.util.ArrayList<it.csi.sigit.sigitwebn.dto.verifica.Verifica>) (getSession()
				.get("appDataelencoVerifiche"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataelencoAccertamenti'
	 * @param value
	 * @generated
	 */

	public void setAppDataelencoAccertamenti(
			java.util.ArrayList<it.csi.sigit.sigitwebn.dto.accertamento.Accertamento> value) {
		getSession().put("appDataelencoAccertamenti", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataelencoAccertamenti'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.sigit.sigitwebn.dto.accertamento.Accertamento> getAppDataelencoAccertamenti() {
		return (java.util.ArrayList<it.csi.sigit.sigitwebn.dto.accertamento.Accertamento>) (getSession()
				.get("appDataelencoAccertamenti"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataelencoTipiVerifica'
	 * @param value
	 * @generated
	 */

	public void setAppDataelencoTipiVerifica(
			java.util.ArrayList<it.csi.sigit.sigitwebn.dto.common.IdDescription> value) {
		getSession().put("appDataelencoTipiVerifica", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataelencoTipiVerifica'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.sigit.sigitwebn.dto.common.IdDescription> getAppDataelencoTipiVerifica() {
		return (java.util.ArrayList<it.csi.sigit.sigitwebn.dto.common.IdDescription>) (getSession()
				.get("appDataelencoTipiVerifica"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataelencoStatoAccertamento'
	 * @param value
	 * @generated
	 */

	public void setAppDataelencoStatoAccertamento(
			java.util.ArrayList<it.csi.sigit.sigitwebn.dto.common.IdDescription> value) {
		getSession().put("appDataelencoStatoAccertamento", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataelencoStatoAccertamento'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.sigit.sigitwebn.dto.common.IdDescription> getAppDataelencoStatoAccertamento() {
		return (java.util.ArrayList<it.csi.sigit.sigitwebn.dto.common.IdDescription>) (getSession()
				.get("appDataelencoStatoAccertamento"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataelencoTipoAnomalie'
	 * @param value
	 * @generated
	 */

	public void setAppDataelencoTipoAnomalie(
			java.util.ArrayList<it.csi.sigit.sigitwebn.dto.common.CodeDescription> value) {
		getSession().put("appDataelencoTipoAnomalie", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataelencoTipoAnomalie'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.sigit.sigitwebn.dto.common.CodeDescription> getAppDataelencoTipoAnomalie() {
		return (java.util.ArrayList<it.csi.sigit.sigitwebn.dto.common.CodeDescription>) (getSession()
				.get("appDataelencoTipoAnomalie"));
	}

	////////////////////////////////////////////////////////////////////
	/// campi per widget semplici
	////////////////////////////////////////////////////////////////////

	// Table tbVerifiche

	private java.lang.String widgTbVerifiche;

	public void setWidg_tbVerifiche(java.lang.String value) {
		widgTbVerifiche = value;
	}

	public java.lang.String getWidg_tbVerifiche() {
		return widgTbVerifiche;
	}

	// Table tbAccertamenti

	private java.lang.String widgTbAccertamenti;

	public void setWidg_tbAccertamenti(java.lang.String value) {
		widgTbAccertamenti = value;
	}

	public java.lang.String getWidg_tbAccertamenti() {
		return widgTbAccertamenti;
	}

}
