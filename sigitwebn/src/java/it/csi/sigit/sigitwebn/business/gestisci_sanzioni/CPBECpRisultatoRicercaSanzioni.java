package it.csi.sigit.sigitwebn.business.gestisci_sanzioni;

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

import org.apache.log4j.*;
import it.csi.sigit.sigitwebn.util.*;
import it.csi.sigit.sigitwebn.business.*;

/*PROTECTED REGION ID(R766657453) ENABLED START*/
import it.csi.sigit.sigitwebn.business.manager.SigitMgr;
import it.csi.sigit.sigitwebn.business.manager.ValidationMgr;
import it.csi.sigit.sigitwebn.business.manager.util.ManagerException;

/*PROTECTED REGION END*/

public class CPBECpRisultatoRicercaSanzioni {

	/**  */
	protected static final Logger log = //NOSONAR  Reason:EIAS 
			Logger.getLogger(Constants.APPLICATION_CODE + ".business"); //NOSONAR  Reason:EIAS

	//////////////////////////////////////////////////////////////////////////////
	/// Costanti identificative degli Application Data
	//////////////////////////////////////////////////////////////////////////////

	// ApplicationData: [utenteLoggato, scope:USER_SESSION]
	public static final String APPDATA_UTENTELOGGATO_CODE = "appDatautenteLoggato";

	// ApplicationData: [idSanzioneSelezionata, scope:USER_SESSION]
	public static final String APPDATA_IDSANZIONESELEZIONATA_CODE = "appDataidSanzioneSelezionata";

	// ApplicationData: [elencoRisultatiRicercaSanzioni, scope:USER_SESSION]
	public static final String APPDATA_ELENCORISULTATIRICERCASANZIONI_CODE = "appDataelencoRisultatiRicercaSanzioni";

	// ApplicationData: [elencoStatiSanzione, scope:USER_SESSION]
	public static final String APPDATA_ELENCOSTATISANZIONE_CODE = "appDataelencoStatiSanzione";

	// ApplicationData: [ricercaSanzioni, scope:USER_SESSION]
	public static final String APPDATA_RICERCASANZIONI_CODE = "appDataricercaSanzioni";

	// ApplicationData: [paginaChiamanteDettaglioSanzione, scope:USER_SESSION]
	public static final String APPDATA_PAGINACHIAMANTEDETTAGLIOSANZIONE_CODE = "appDatapaginaChiamanteDettaglioSanzione";

	//////////////////////////////////////////////////////////////////////////////
	/// Metodi associati alla U.I.
	//////////////////////////////////////////////////////////////////////////////

	// nome del content panel associato al bean
	public static final String CPNAME = "cpRisultatoRicercaSanzioni";

	/** 
	 * Restituisce il tab correntemente visibile in un determinato tab set
	 */
	private String getCurrentTab(Map session, String tabSetName) {
		String value = (String) session.get(CPNAME + "_" + tabSetName + "_selectedMultiPanel");
		return value;
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo preparaAperturaDettaglioSanzione definito in un ExecCommand del
	 * ContentPanel cpRisultatoRicercaSanzioni
	 */
	public ExecResults preparaAperturaDettaglioSanzione(

			it.csi.sigit.sigitwebn.dto.gestisci_sanzioni.CpRisultatoRicercaSanzioniModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String PREPARAAPERTURADETTAGLIOSANZIONE_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String PREPARAAPERTURADETTAGLIOSANZIONE_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-1983972197) ENABLED START*/
			try {

				getValidationMgr().checkSelezioneElemento(theModel.getAppDataidSanzioneSelezionata());

				theModel.setAppDatapaginaChiamanteDettaglioSanzione("RICERCA");

				result.setResultCode(PREPARAAPERTURADETTAGLIOSANZIONE_OUTCOME_CODE__OK);

			} catch (ManagerException ex) {

				Validator.gestisciEccezione(result, ex);
			}

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error(
					"[BackEndFacade::preparaAperturaDettaglioSanzione] Errore occorso nell'esecuzione del metodo:" + e,
					e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo gestisciIndietroRisultatoRicercaSanzioni definito in un ExecCommand del
	 * ContentPanel cpRisultatoRicercaSanzioni
	 */
	public ExecResults gestisciIndietroRisultatoRicercaSanzioni(

			it.csi.sigit.sigitwebn.dto.gestisci_sanzioni.CpRisultatoRicercaSanzioniModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GESTISCIINDIETRORISULTATORICERCASANZIONI_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String GESTISCIINDIETRORISULTATORICERCASANZIONI_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-844491214) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			// impostazione del result code 
			result.setResultCode(GESTISCIINDIETRORISULTATORICERCASANZIONI_OUTCOME_CODE__OK);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error(
					"[BackEndFacade::gestisciIndietroRisultatoRicercaSanzioni] Errore occorso nell'esecuzione del metodo:"
							+ e,
					e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo isRuoloAbilitato definito in un ExecCommand del
	 * ContentPanel cpRisultatoRicercaSanzioni
	 */
	public ExecResults isRuoloAbilitato(

			it.csi.sigit.sigitwebn.dto.gestisci_sanzioni.CpRisultatoRicercaSanzioniModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String ISRUOLOABILITATO_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-1880129050) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			UtenteLoggato utente = theModel.getAppDatautenteLoggato();

			if (GenericUtil.isUtenteAbilitatoRicercaVerificheAccertamentiIspezioniSanzioni(utente)) {
				result.setResultCode(ISRUOLOABILITATO_OUTCOME_CODE__OK);
			} else {
				GenericUtil.redirectToNotAllowedPage();
			}

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::isRuoloAbilitato] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo mostraRisultatoRicercaSanzioni definito in un ExecCommand del
	 * ContentPanel cpRisultatoRicercaSanzioni
	 */
	public ExecResults mostraRisultatoRicercaSanzioni(

			it.csi.sigit.sigitwebn.dto.gestisci_sanzioni.CpRisultatoRicercaSanzioniModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String MOSTRARISULTATORICERCASANZIONI_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String MOSTRARISULTATORICERCASANZIONI_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R284291557) ENABLED START*/

			try {
				if (theModel.getAppDataelencoStatiSanzione() == null
						|| theModel.getAppDataelencoStatiSanzione().isEmpty()) {
					theModel.setAppDataelencoStatiSanzione(getSigitMgr().getElencoStatiSanzione());
				}

				List<RisultatoRicerca> listaRisultati = getSigitMgr().getSanzioniDaRicerca(
						theModel.getAppDataricercaSanzioni(),
						ConvertUtil.convertIdDescriptionsInMap(theModel.getAppDataelencoStatiSanzione()));
				theModel.setAppDataelencoRisultatiRicercaSanzioni((ArrayList<RisultatoRicerca>) listaRisultati);
				result.setResultCode(MOSTRARISULTATORICERCASANZIONI_OUTCOME_CODE__OK);
			} catch (ManagerException ex) {
				Validator.gestisciEccezione(result, ex);
			}

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::mostraRisultatoRicercaSanzioni] Errore occorso nell'esecuzione del metodo:" + e,
					e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	//////////////////////////////////////////////////////////////////////////////
	/// Metodi statici per il reset delle tabelle
	//////////////////////////////////////////////////////////////////////////////

	/**
	 * permette di resettare lo stato di paginazione della tabella widg_tbRisultatiRicerca
	 */
	public static void resetClearStatus_widg_tbRisultatiRicerca(java.util.Map session) {
		session.put("cpRisultatoRicercaSanzioni_tbRisultatiRicerca_clearStatus", Boolean.TRUE);
	}

	//////////////////////////////////////////////////////////////////////////////
	/// Property aggiuntive del bean
	//////////////////////////////////////////////////////////////////////////////
	/*PROTECTED REGION ID(R694080935) ENABLED START*/
	private SigitMgr sigitMgr;

	public SigitMgr getSigitMgr() {
		return sigitMgr;
	}

	public void setSigitMgr(SigitMgr sigitMgr) {
		this.sigitMgr = sigitMgr;
	}

	private ValidationMgr validationMgr;

	public ValidationMgr getValidationMgr() {
		return validationMgr;
	}

	public void setValidationMgr(ValidationMgr validationMgr) {
		this.validationMgr = validationMgr;
	}
	/*PROTECTED REGION END*/
}
