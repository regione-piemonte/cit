package it.csi.sigit.sigitwebn.dto.gestisci_libretto_scheda4;

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
 * logica di business associata alla Schermata [cpGestLibScheda4Impresa]
 */
@Validation
public class CpGestLibScheda4ImpresaModel extends BaseSessionAwareDTO {

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
	 * imposta il valore dell' ApplicationData 'appDataelencoImprese'
	 * @param value
	 * @generated
	 */

	public void setAppDataelencoImprese(
			java.util.ArrayList<it.csi.sigit.sigitwebn.dto.accesso.PersonaGiuridica> value) {
		getSession().put("appDataelencoImprese", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataelencoImprese'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.sigit.sigitwebn.dto.accesso.PersonaGiuridica> getAppDataelencoImprese() {
		return (java.util.ArrayList<it.csi.sigit.sigitwebn.dto.accesso.PersonaGiuridica>) (getSession()
				.get("appDataelencoImprese"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataidImpresaSelezionata'
	 * @param value
	 * @generated
	 */

	public void setAppDataidImpresaSelezionata(java.lang.Integer value) {
		getSession().put("appDataidImpresaSelezionata", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataidImpresaSelezionata'
	 * @generated
	 */
	public java.lang.Integer getAppDataidImpresaSelezionata() {
		return (java.lang.Integer) (getSession().get("appDataidImpresaSelezionata"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataricercaImprese'
	 * @param value
	 * @generated
	 */

	public void setAppDataricercaImprese(it.csi.sigit.sigitwebn.dto.impresa.RicercaImprese value) {
		getSession().put("appDataricercaImprese", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataricercaImprese'
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.dto.impresa.RicercaImprese getAppDataricercaImprese() {
		return (it.csi.sigit.sigitwebn.dto.impresa.RicercaImprese) (getSession().get("appDataricercaImprese"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataelencoSiglaRea'
	 * @param value
	 * @generated
	 */

	public void setAppDataelencoSiglaRea(java.util.ArrayList<it.csi.sigit.sigitwebn.dto.common.CodeDescription> value) {
		getSession().put("appDataelencoSiglaRea", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataelencoSiglaRea'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.sigit.sigitwebn.dto.common.CodeDescription> getAppDataelencoSiglaRea() {
		return (java.util.ArrayList<it.csi.sigit.sigitwebn.dto.common.CodeDescription>) (getSession()
				.get("appDataelencoSiglaRea"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDatacomponenteGT'
	 * @param value
	 * @generated
	 */

	public void setAppDatacomponenteGT(it.csi.sigit.sigitwebn.dto.libretto.ComponenteGT value) {
		getSession().put("appDatacomponenteGT", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDatacomponenteGT'
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.dto.libretto.ComponenteGT getAppDatacomponenteGT() {
		return (it.csi.sigit.sigitwebn.dto.libretto.ComponenteGT) (getSession().get("appDatacomponenteGT"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDatalistaStoricoComponentiGT'
	 * @param value
	 * @generated
	 */

	public void setAppDatalistaStoricoComponentiGT(
			java.util.ArrayList<it.csi.sigit.sigitwebn.dto.libretto.ComponenteGT> value) {
		getSession().put("appDatalistaStoricoComponentiGT", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDatalistaStoricoComponentiGT'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.sigit.sigitwebn.dto.libretto.ComponenteGT> getAppDatalistaStoricoComponentiGT() {
		return (java.util.ArrayList<it.csi.sigit.sigitwebn.dto.libretto.ComponenteGT>) (getSession()
				.get("appDatalistaStoricoComponentiGT"));
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
	 * imposta il valore dell' ApplicationData 'appDatacomponenteGF'
	 * @param value
	 * @generated
	 */

	public void setAppDatacomponenteGF(it.csi.sigit.sigitwebn.dto.libretto.ComponenteGF value) {
		getSession().put("appDatacomponenteGF", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDatacomponenteGF'
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.dto.libretto.ComponenteGF getAppDatacomponenteGF() {
		return (it.csi.sigit.sigitwebn.dto.libretto.ComponenteGF) (getSession().get("appDatacomponenteGF"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDatalistaComponentiGF'
	 * @param value
	 * @generated
	 */

	public void setAppDatalistaComponentiGF(
			java.util.ArrayList<it.csi.sigit.sigitwebn.dto.libretto.ComponenteGF> value) {
		getSession().put("appDatalistaComponentiGF", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDatalistaComponentiGF'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.sigit.sigitwebn.dto.libretto.ComponenteGF> getAppDatalistaComponentiGF() {
		return (java.util.ArrayList<it.csi.sigit.sigitwebn.dto.libretto.ComponenteGF>) (getSession()
				.get("appDatalistaComponentiGF"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDatalistaStoricoComponentiGF'
	 * @param value
	 * @generated
	 */

	public void setAppDatalistaStoricoComponentiGF(
			java.util.ArrayList<it.csi.sigit.sigitwebn.dto.libretto.ComponenteGF> value) {
		getSession().put("appDatalistaStoricoComponentiGF", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDatalistaStoricoComponentiGF'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.sigit.sigitwebn.dto.libretto.ComponenteGF> getAppDatalistaStoricoComponentiGF() {
		return (java.util.ArrayList<it.csi.sigit.sigitwebn.dto.libretto.ComponenteGF>) (getSession()
				.get("appDatalistaStoricoComponentiGF"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDatacomponenteSC'
	 * @param value
	 * @generated
	 */

	public void setAppDatacomponenteSC(it.csi.sigit.sigitwebn.dto.libretto.ComponenteSC value) {
		getSession().put("appDatacomponenteSC", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDatacomponenteSC'
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.dto.libretto.ComponenteSC getAppDatacomponenteSC() {
		return (it.csi.sigit.sigitwebn.dto.libretto.ComponenteSC) (getSession().get("appDatacomponenteSC"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDatalistaComponentiSC'
	 * @param value
	 * @generated
	 */

	public void setAppDatalistaComponentiSC(
			java.util.ArrayList<it.csi.sigit.sigitwebn.dto.libretto.ComponenteSC> value) {
		getSession().put("appDatalistaComponentiSC", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDatalistaComponentiSC'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.sigit.sigitwebn.dto.libretto.ComponenteSC> getAppDatalistaComponentiSC() {
		return (java.util.ArrayList<it.csi.sigit.sigitwebn.dto.libretto.ComponenteSC>) (getSession()
				.get("appDatalistaComponentiSC"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDatalistaStoricoComponentiSC'
	 * @param value
	 * @generated
	 */

	public void setAppDatalistaStoricoComponentiSC(
			java.util.ArrayList<it.csi.sigit.sigitwebn.dto.libretto.ComponenteSC> value) {
		getSession().put("appDatalistaStoricoComponentiSC", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDatalistaStoricoComponentiSC'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.sigit.sigitwebn.dto.libretto.ComponenteSC> getAppDatalistaStoricoComponentiSC() {
		return (java.util.ArrayList<it.csi.sigit.sigitwebn.dto.libretto.ComponenteSC>) (getSession()
				.get("appDatalistaStoricoComponentiSC"));
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

	////////////////////////////////////////////////////////////////////
	/// campi per widget semplici
	////////////////////////////////////////////////////////////////////

}
