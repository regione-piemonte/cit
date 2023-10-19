package it.csi.sigit.sigitwebn.dto.risultato_ricerca_completa_impianti;

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
 * logica di business associata alla Schermata [cpRisRicCompImpianto]
 */
@Validation
public class CpRisRicCompImpiantoModel extends BaseSessionAwareDTO {

	// il serial version uid e' fisso in quanto la classe in oggetto e' serializzabile
	// solo per la clusterizzazione della sessione web e non viene scambiata con altre
	// componenti.
	private static final long serialVersionUID = 1L;

	////////////////////////////////////////////////////////////////////
	/// application data
	////////////////////////////////////////////////////////////////////

	/**
	 * imposta il valore dell' ApplicationData 'appDatarisultatoRicercaImpianti'
	 * @param value
	 * @generated
	 */

	public void setAppDatarisultatoRicercaImpianti(
			java.util.ArrayList<it.csi.sigit.sigitwebn.dto.impianto.RisultatoRicImpianto> value) {
		getSession().put("appDatarisultatoRicercaImpianti", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDatarisultatoRicercaImpianti'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.sigit.sigitwebn.dto.impianto.RisultatoRicImpianto> getAppDatarisultatoRicercaImpianti() {
		return (java.util.ArrayList<it.csi.sigit.sigitwebn.dto.impianto.RisultatoRicImpianto>) (getSession()
				.get("appDatarisultatoRicercaImpianti"));
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
	 * imposta il valore dell' ApplicationData 'appDataaggiornaElencoImpianti'
	 * @param value
	 * @generated
	 */

	public void setAppDataaggiornaElencoImpianti(java.lang.Boolean value) {
		getSession().put("appDataaggiornaElencoImpianti", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataaggiornaElencoImpianti'
	 * @generated
	 */
	public java.lang.Boolean getAppDataaggiornaElencoImpianti() {
		return (java.lang.Boolean) (getSession().get("appDataaggiornaElencoImpianti"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataimpianto'
	 * @param value
	 * @generated
	 */

	public void setAppDataimpianto(it.csi.sigit.sigitwebn.dto.impianto.Impianto value) {
		getSession().put("appDataimpianto", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataimpianto'
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.dto.impianto.Impianto getAppDataimpianto() {
		return (it.csi.sigit.sigitwebn.dto.impianto.Impianto) (getSession().get("appDataimpianto"));
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
	 * imposta il valore dell' ApplicationData 'appDataricercaImpianti'
	 * @param value
	 * @generated
	 */

	public void setAppDataricercaImpianti(it.csi.sigit.sigitwebn.dto.impianto.RicercaImpianti value) {
		getSession().put("appDataricercaImpianti", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataricercaImpianti'
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.dto.impianto.RicercaImpianti getAppDataricercaImpianti() {
		return (it.csi.sigit.sigitwebn.dto.impianto.RicercaImpianti) (getSession().get("appDataricercaImpianti"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDatapaginaChiamanteImp'
	 * @param value
	 * @generated
	 */

	public void setAppDatapaginaChiamanteImp(java.lang.String value) {
		getSession().put("appDatapaginaChiamanteImp", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDatapaginaChiamanteImp'
	 * @generated
	 */
	public java.lang.String getAppDatapaginaChiamanteImp() {
		return (java.lang.String) (getSession().get("appDatapaginaChiamanteImp"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataisAbilitazioneDatiAllegato'
	 * @param value
	 * @generated
	 */

	public void setAppDataisAbilitazioneDatiAllegato(java.lang.Boolean value) {
		getSession().put("appDataisAbilitazioneDatiAllegato", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataisAbilitazioneDatiAllegato'
	 * @generated
	 */
	public java.lang.Boolean getAppDataisAbilitazioneDatiAllegato() {
		return (java.lang.Boolean) (getSession().get("appDataisAbilitazioneDatiAllegato"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataresponsabile'
	 * @param value
	 * @generated
	 */

	public void setAppDataresponsabile(it.csi.sigit.sigitwebn.dto.impianto.Responsabile value) {
		getSession().put("appDataresponsabile", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataresponsabile'
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.dto.impianto.Responsabile getAppDataresponsabile() {
		return (it.csi.sigit.sigitwebn.dto.impianto.Responsabile) (getSession().get("appDataresponsabile"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataelencoResponsabili'
	 * @param value
	 * @generated
	 */

	public void setAppDataelencoResponsabili(
			java.util.ArrayList<it.csi.sigit.sigitwebn.dto.impianto.RisultatoRicResponsabile> value) {
		getSession().put("appDataelencoResponsabili", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataelencoResponsabili'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.sigit.sigitwebn.dto.impianto.RisultatoRicResponsabile> getAppDataelencoResponsabili() {
		return (java.util.ArrayList<it.csi.sigit.sigitwebn.dto.impianto.RisultatoRicResponsabile>) (getSession()
				.get("appDataelencoResponsabili"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataelencoResponsabiliTemp'
	 * @param value
	 * @generated
	 */

	public void setAppDataelencoResponsabiliTemp(
			java.util.ArrayList<it.csi.sigit.sigitwebn.dto.impianto.Responsabile> value) {
		getSession().put("appDataelencoResponsabiliTemp", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataelencoResponsabiliTemp'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.sigit.sigitwebn.dto.impianto.Responsabile> getAppDataelencoResponsabiliTemp() {
		return (java.util.ArrayList<it.csi.sigit.sigitwebn.dto.impianto.Responsabile>) (getSession()
				.get("appDataelencoResponsabiliTemp"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataelencoManutentori'
	 * @param value
	 * @generated
	 */

	public void setAppDataelencoManutentori(
			java.util.ArrayList<it.csi.sigit.sigitwebn.dto.impianto.RisultatoRicManutentore> value) {
		getSession().put("appDataelencoManutentori", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataelencoManutentori'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.sigit.sigitwebn.dto.impianto.RisultatoRicManutentore> getAppDataelencoManutentori() {
		return (java.util.ArrayList<it.csi.sigit.sigitwebn.dto.impianto.RisultatoRicManutentore>) (getSession()
				.get("appDataelencoManutentori"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDatadataRevocaResponsabileOld'
	 * @param value
	 * @generated
	 */

	public void setAppDatadataRevocaResponsabileOld(java.lang.String value) {
		getSession().put("appDatadataRevocaResponsabileOld", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDatadataRevocaResponsabileOld'
	 * @generated
	 */
	public java.lang.String getAppDatadataRevocaResponsabileOld() {
		return (java.lang.String) (getSession().get("appDatadataRevocaResponsabileOld"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDatamessaggioDinamico'
	 * @param value
	 * @generated
	 */

	public void setAppDatamessaggioDinamico(java.lang.String value) {
		getSession().put("appDatamessaggioDinamico", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDatamessaggioDinamico'
	 * @generated
	 */
	public java.lang.String getAppDatamessaggioDinamico() {
		return (java.lang.String) (getSession().get("appDatamessaggioDinamico"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataidImpiantoRevoca'
	 * @param value
	 * @generated
	 */

	public void setAppDataidImpiantoRevoca(java.lang.String value) {
		getSession().put("appDataidImpiantoRevoca", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataidImpiantoRevoca'
	 * @generated
	 */
	public java.lang.String getAppDataidImpiantoRevoca() {
		return (java.lang.String) (getSession().get("appDataidImpiantoRevoca"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataelencoDettaglioTerzoResponsabile'
	 * @param value
	 * @generated
	 */

	public void setAppDataelencoDettaglioTerzoResponsabile(
			java.util.ArrayList<it.csi.sigit.sigitwebn.dto.terzoresponsabile.DettaglioTerzoResponsabile> value) {
		getSession().put("appDataelencoDettaglioTerzoResponsabile", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataelencoDettaglioTerzoResponsabile'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.sigit.sigitwebn.dto.terzoresponsabile.DettaglioTerzoResponsabile> getAppDataelencoDettaglioTerzoResponsabile() {
		return (java.util.ArrayList<it.csi.sigit.sigitwebn.dto.terzoresponsabile.DettaglioTerzoResponsabile>) (getSession()
				.get("appDataelencoDettaglioTerzoResponsabile"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDatarisultatoRicercaImpiantiSelez'
	 * @param value
	 * @generated
	 */

	public void setAppDatarisultatoRicercaImpiantiSelez(
			it.csi.sigit.sigitwebn.dto.impianto.RisultatoRicImpianto value) {
		getSession().put("appDatarisultatoRicercaImpiantiSelez", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDatarisultatoRicercaImpiantiSelez'
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.dto.impianto.RisultatoRicImpianto getAppDatarisultatoRicercaImpiantiSelez() {
		return (it.csi.sigit.sigitwebn.dto.impianto.RisultatoRicImpianto) (getSession()
				.get("appDatarisultatoRicercaImpiantiSelez"));
	}

	////////////////////////////////////////////////////////////////////
	/// campi per widget semplici
	////////////////////////////////////////////////////////////////////

	// Table tbRisultatoRicImp

	private java.lang.String widgTbRisultatoRicImp;

	public void setWidg_tbRisultatoRicImp(java.lang.String value) {
		widgTbRisultatoRicImp = value;
	}

	public java.lang.String getWidg_tbRisultatoRicImp() {
		return widgTbRisultatoRicImp;
	}

}
