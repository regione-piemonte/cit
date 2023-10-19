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
 * logica di business associata alla Schermata [cpGestRapProvaTipo2Dett]
 */
@Validation
public class CpGestRapProvaTipo2DettModel extends BaseSessionAwareDTO {

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
	 * imposta il valore dell' ApplicationData 'appDataelencoCircuitiRappProva'
	 * @param value
	 * @generated
	 */

	public void setAppDataelencoCircuitiRappProva(
			java.util.ArrayList<it.csi.sigit.sigitwebn.dto.common.CodeDescription> value) {
		getSession().put("appDataelencoCircuitiRappProva", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataelencoCircuitiRappProva'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.sigit.sigitwebn.dto.common.CodeDescription> getAppDataelencoCircuitiRappProva() {
		return (java.util.ArrayList<it.csi.sigit.sigitwebn.dto.common.CodeDescription>) (getSession()
				.get("appDataelencoCircuitiRappProva"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDatacircuitoSelezionatoRappProva'
	 * @param value
	 * @generated
	 */

	public void setAppDatacircuitoSelezionatoRappProva(java.lang.String value) {
		getSession().put("appDatacircuitoSelezionatoRappProva", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDatacircuitoSelezionatoRappProva'
	 * @generated
	 */
	public java.lang.String getAppDatacircuitoSelezionatoRappProva() {
		return (java.lang.String) (getSession().get("appDatacircuitoSelezionatoRappProva"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataTipoGFDett'
	 * @param value
	 * @generated
	 */

	public void setAppDataTipoGFDett(it.csi.sigit.sigitwebn.dto.rappprova.TipoGFDett value) {
		getSession().put("appDataTipoGFDett", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataTipoGFDett'
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.dto.rappprova.TipoGFDett getAppDataTipoGFDett() {
		return (it.csi.sigit.sigitwebn.dto.rappprova.TipoGFDett) (getSession().get("appDataTipoGFDett"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataTipoGFDettCircuito'
	 * @param value
	 * @generated
	 */

	public void setAppDataTipoGFDettCircuito(it.csi.sigit.sigitwebn.dto.rappprova.TipoGFDettCircuito value) {
		getSession().put("appDataTipoGFDettCircuito", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataTipoGFDettCircuito'
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.dto.rappprova.TipoGFDettCircuito getAppDataTipoGFDettCircuito() {
		return (it.csi.sigit.sigitwebn.dto.rappprova.TipoGFDettCircuito) (getSession()
				.get("appDataTipoGFDettCircuito"));
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
