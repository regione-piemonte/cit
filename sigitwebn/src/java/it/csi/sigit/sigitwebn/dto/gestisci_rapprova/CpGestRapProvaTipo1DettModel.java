package it.csi.sigit.sigitwebn.dto.gestisci_rapprova;

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
 * logica di business associata alla Schermata [cpGestRapProvaTipo1Dett]
 */
@Validation
public class CpGestRapProvaTipo1DettModel extends BaseSessionAwareDTO {

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
	 * imposta il valore dell' ApplicationData 'appDataricaricaPagina'
	 * @param value
	 * @generated
	 */

	public void setAppDataricaricaPagina(java.lang.Boolean value) {
		getSession().put("appDataricaricaPagina", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataricaricaPagina'
	 * @generated
	 */
	public java.lang.Boolean getAppDataricaricaPagina() {
		return (java.lang.Boolean) (getSession().get("appDataricaricaPagina"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataElencoModalitaEvacuazione'
	 * @param value
	 * @generated
	 */

	public void setAppDataElencoModalitaEvacuazione(
			java.util.ArrayList<it.csi.sigit.sigitwebn.dto.common.CodeDescription> value) {
		getSession().put("appDataElencoModalitaEvacuazione", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataElencoModalitaEvacuazione'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.sigit.sigitwebn.dto.common.CodeDescription> getAppDataElencoModalitaEvacuazione() {
		return (java.util.ArrayList<it.csi.sigit.sigitwebn.dto.common.CodeDescription>) (getSession()
				.get("appDataElencoModalitaEvacuazione"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataelencoModuliRappProva'
	 * @param value
	 * @generated
	 */

	public void setAppDataelencoModuliRappProva(
			java.util.ArrayList<it.csi.sigit.sigitwebn.dto.common.CodeDescription> value) {
		getSession().put("appDataelencoModuliRappProva", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataelencoModuliRappProva'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.sigit.sigitwebn.dto.common.CodeDescription> getAppDataelencoModuliRappProva() {
		return (java.util.ArrayList<it.csi.sigit.sigitwebn.dto.common.CodeDescription>) (getSession()
				.get("appDataelencoModuliRappProva"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDatamoduloSelezionatoRappProva'
	 * @param value
	 * @generated
	 */

	public void setAppDatamoduloSelezionatoRappProva(java.lang.String value) {
		getSession().put("appDatamoduloSelezionatoRappProva", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDatamoduloSelezionatoRappProva'
	 * @generated
	 */
	public java.lang.String getAppDatamoduloSelezionatoRappProva() {
		return (java.lang.String) (getSession().get("appDatamoduloSelezionatoRappProva"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataprogressivoSelezionatoRappProva'
	 * @param value
	 * @generated
	 */

	public void setAppDataprogressivoSelezionatoRappProva(java.lang.Integer value) {
		getSession().put("appDataprogressivoSelezionatoRappProva", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataprogressivoSelezionatoRappProva'
	 * @generated
	 */
	public java.lang.Integer getAppDataprogressivoSelezionatoRappProva() {
		return (java.lang.Integer) (getSession().get("appDataprogressivoSelezionatoRappProva"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataTipoGTDett'
	 * @param value
	 * @generated
	 */

	public void setAppDataTipoGTDett(it.csi.sigit.sigitwebn.dto.rappprova.TipoGTDett value) {
		getSession().put("appDataTipoGTDett", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataTipoGTDett'
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.dto.rappprova.TipoGTDett getAppDataTipoGTDett() {
		return (it.csi.sigit.sigitwebn.dto.rappprova.TipoGTDett) (getSession().get("appDataTipoGTDett"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataTipoGTDettModulo'
	 * @param value
	 * @generated
	 */

	public void setAppDataTipoGTDettModulo(it.csi.sigit.sigitwebn.dto.rappprova.TipoGTDettModulo value) {
		getSession().put("appDataTipoGTDettModulo", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataTipoGTDettModulo'
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.dto.rappprova.TipoGTDettModulo getAppDataTipoGTDettModulo() {
		return (it.csi.sigit.sigitwebn.dto.rappprova.TipoGTDettModulo) (getSession().get("appDataTipoGTDettModulo"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataelencoClassDPR'
	 * @param value
	 * @generated
	 */

	public void setAppDataelencoClassDPR(java.util.ArrayList<it.csi.sigit.sigitwebn.dto.common.IdDescription> value) {
		getSession().put("appDataelencoClassDPR", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataelencoClassDPR'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.sigit.sigitwebn.dto.common.IdDescription> getAppDataelencoClassDPR() {
		return (java.util.ArrayList<it.csi.sigit.sigitwebn.dto.common.IdDescription>) (getSession()
				.get("appDataelencoClassDPR"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataelencoFrequenzaManut'
	 * @param value
	 * @generated
	 */

	public void setAppDataelencoFrequenzaManut(
			java.util.ArrayList<it.csi.sigit.sigitwebn.dto.common.IdDescription> value) {
		getSession().put("appDataelencoFrequenzaManut", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataelencoFrequenzaManut'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.sigit.sigitwebn.dto.common.IdDescription> getAppDataelencoFrequenzaManut() {
		return (java.util.ArrayList<it.csi.sigit.sigitwebn.dto.common.IdDescription>) (getSession()
				.get("appDataelencoFrequenzaManut"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataElencoO2CO2'
	 * @param value
	 * @generated
	 */

	public void setAppDataElencoO2CO2(java.util.ArrayList<it.csi.sigit.sigitwebn.dto.common.CodeDescription> value) {
		getSession().put("appDataElencoO2CO2", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataElencoO2CO2'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.sigit.sigitwebn.dto.common.CodeDescription> getAppDataElencoO2CO2() {
		return (java.util.ArrayList<it.csi.sigit.sigitwebn.dto.common.CodeDescription>) (getSession()
				.get("appDataElencoO2CO2"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataElencoIndiceFumosita'
	 * @param value
	 * @generated
	 */

	public void setAppDataElencoIndiceFumosita(
			java.util.ArrayList<it.csi.sigit.sigitwebn.dto.common.CodeDescription> value) {
		getSession().put("appDataElencoIndiceFumosita", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataElencoIndiceFumosita'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.sigit.sigitwebn.dto.common.CodeDescription> getAppDataElencoIndiceFumosita() {
		return (java.util.ArrayList<it.csi.sigit.sigitwebn.dto.common.CodeDescription>) (getSession()
				.get("appDataElencoIndiceFumosita"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataElencoSufficienteNonSufficiente'
	 * @param value
	 * @generated
	 */

	public void setAppDataElencoSufficienteNonSufficiente(
			java.util.ArrayList<it.csi.sigit.sigitwebn.dto.common.CodeDescription> value) {
		getSession().put("appDataElencoSufficienteNonSufficiente", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataElencoSufficienteNonSufficiente'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.sigit.sigitwebn.dto.common.CodeDescription> getAppDataElencoSufficienteNonSufficiente() {
		return (java.util.ArrayList<it.csi.sigit.sigitwebn.dto.common.CodeDescription>) (getSession()
				.get("appDataElencoSufficienteNonSufficiente"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataElencoRegolareIrregolare'
	 * @param value
	 * @generated
	 */

	public void setAppDataElencoRegolareIrregolare(
			java.util.ArrayList<it.csi.sigit.sigitwebn.dto.common.CodeDescription> value) {
		getSession().put("appDataElencoRegolareIrregolare", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataElencoRegolareIrregolare'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.sigit.sigitwebn.dto.common.CodeDescription> getAppDataElencoRegolareIrregolare() {
		return (java.util.ArrayList<it.csi.sigit.sigitwebn.dto.common.CodeDescription>) (getSession()
				.get("appDataElencoRegolareIrregolare"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDatarapProvaMenuTree'
	 * @param value
	 * @generated
	 */

	public void setAppDatarapProvaMenuTree(it.csi.custom.component.tree.base.TreeNode value) {
		getSession().put("appDatarapProvaMenuTree", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDatarapProvaMenuTree'
	 * @generated
	 */
	public it.csi.custom.component.tree.base.TreeNode getAppDatarapProvaMenuTree() {
		return (it.csi.custom.component.tree.base.TreeNode) (getSession().get("appDatarapProvaMenuTree"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataallegatoIsp'
	 * @param value
	 * @generated
	 */

	public void setAppDataallegatoIsp(it.csi.sigit.sigitwebn.dto.allegati.DettaglioAllegato value) {
		getSession().put("appDataallegatoIsp", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataallegatoIsp'
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.dto.allegati.DettaglioAllegato getAppDataallegatoIsp() {
		return (it.csi.sigit.sigitwebn.dto.allegati.DettaglioAllegato) (getSession().get("appDataallegatoIsp"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataIspezione2018'
	 * @param value
	 * @generated
	 */

	public void setAppDataIspezione2018(it.csi.sigit.sigitwebn.dto.ispezioni.Ispezione2018 value) {
		getSession().put("appDataIspezione2018", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataIspezione2018'
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.dto.ispezioni.Ispezione2018 getAppDataIspezione2018() {
		return (it.csi.sigit.sigitwebn.dto.ispezioni.Ispezione2018) (getSession().get("appDataIspezione2018"));
	}

	////////////////////////////////////////////////////////////////////
	/// campi per widget semplici
	////////////////////////////////////////////////////////////////////

}
