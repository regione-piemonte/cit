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

/*PROTECTED REGION ID(R771857322) ENABLED START*/
import it.csi.sigit.sigitwebn.util.enumutil.SiNoEnum;
import it.csi.sigit.sigitwebn.business.*;
import it.csi.sigit.sigitwebn.business.manager.SigitMgr;
import it.csi.sigit.sigitwebn.business.manager.ValidationMgr;
import it.csi.sigit.sigitwebn.business.manager.util.ManagerException;
/*PROTECTED REGION END*/

public class CPBECpRicercaSanzione {

	/**  */
	protected static final Logger log = //NOSONAR  Reason:EIAS 
			Logger.getLogger(Constants.APPLICATION_CODE + ".business"); //NOSONAR  Reason:EIAS

	//////////////////////////////////////////////////////////////////////////////
	/// Costanti identificative degli Application Data
	//////////////////////////////////////////////////////////////////////////////

	// ApplicationData: [ricercaSanzioni, scope:USER_SESSION]
	public static final String APPDATA_RICERCASANZIONI_CODE = "appDataricercaSanzioni";

	// ApplicationData: [elencoStatiSanzione, scope:USER_SESSION]
	public static final String APPDATA_ELENCOSTATISANZIONE_CODE = "appDataelencoStatiSanzione";

	// ApplicationData: [elencoSiNo, scope:USER_SESSION]
	public static final String APPDATA_ELENCOSINO_CODE = "appDataelencoSiNo";

	// ApplicationData: [elencoRespSanzione, scope:USER_SESSION]
	public static final String APPDATA_ELENCORESPSANZIONE_CODE = "appDataelencoRespSanzione";

	// ApplicationData: [utenteLoggato, scope:USER_SESSION]
	public static final String APPDATA_UTENTELOGGATO_CODE = "appDatautenteLoggato";

	// ApplicationData: [paginaChiamante, scope:USER_SESSION]
	public static final String APPDATA_PAGINACHIAMANTE_CODE = "appDatapaginaChiamante";

	//////////////////////////////////////////////////////////////////////////////
	/// Metodi associati alla U.I.
	//////////////////////////////////////////////////////////////////////////////

	// nome del content panel associato al bean
	public static final String CPNAME = "cpRicercaSanzione";

	/** 
	 * Restituisce il tab correntemente visibile in un determinato tab set
	 */
	private String getCurrentTab(Map session, String tabSetName) {
		String value = (String) session.get(CPNAME + "_" + tabSetName + "_selectedMultiPanel");
		return value;
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo ricercaSanzioni definito in un ExecCommand del
	 * ContentPanel cpRicercaSanzione
	 */
	public ExecResults ricercaSanzioni(

			it.csi.sigit.sigitwebn.dto.gestisci_sanzioni.CpRicercaSanzioneModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String RICERCASANZIONI_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String RICERCASANZIONI_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-1712559243) ENABLED START*/

			try {
				getValidationMgr().validazioneFormaleRicercaSanzioni(theModel.getAppDataricercaSanzioni());
				result.setResultCode(RICERCASANZIONI_OUTCOME_CODE__OK);

			} catch (ManagerException ex) {

				Validator.gestisciEccezione(result, ex);
			}

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::ricercaSanzioni] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo annullaRicerca definito in un ExecCommand del
	 * ContentPanel cpRicercaSanzione
	 */
	public ExecResults annullaRicerca(

			it.csi.sigit.sigitwebn.dto.gestisci_sanzioni.CpRicercaSanzioneModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String ANNULLARICERCA_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R285325543) ENABLED START*/
			try {
				resetRicerca(theModel);

				result.setResultCode(ANNULLARICERCA_OUTCOME_CODE__OK);
			} catch (ManagerException ex) {
				Validator.gestisciEccezione(result, ex);
			}

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::annullaRicerca] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo gestisciIndietroRicercaSanzioni definito in un ExecCommand del
	 * ContentPanel cpRicercaSanzione
	 */
	public ExecResults gestisciIndietroRicercaSanzioni(

			it.csi.sigit.sigitwebn.dto.gestisci_sanzioni.CpRicercaSanzioneModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GESTISCIINDIETRORICERCASANZIONI_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String GESTISCIINDIETRORICERCASANZIONI_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R953622554) ENABLED START*/
			try {
				resetRicerca(theModel);

				result.setResultCode(GESTISCIINDIETRORICERCASANZIONI_OUTCOME_CODE__OK);
			} catch (ManagerException ex) {
				Validator.gestisciEccezione(result, ex);
			}

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::gestisciIndietroRicercaSanzioni] Errore occorso nell'esecuzione del metodo:" + e,
					e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo isRuoloAbilitato definito in un ExecCommand del
	 * ContentPanel cpRicercaSanzione
	 */
	public ExecResults isRuoloAbilitato(

			it.csi.sigit.sigitwebn.dto.gestisci_sanzioni.CpRicercaSanzioneModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String ISRUOLOABILITATO_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-2024828855) ENABLED START*/
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
	 * Implementazione del metodo caricaRicerca definito in un ExecCommand del
	 * ContentPanel cpRicercaSanzione
	 */
	public ExecResults caricaRicerca(

			it.csi.sigit.sigitwebn.dto.gestisci_sanzioni.CpRicercaSanzioneModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String CARICARICERCA_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String CARICARICERCA_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-184922813) ENABLED START*/
			try {
				resetRicerca(theModel);

				result.setResultCode(CARICARICERCA_OUTCOME_CODE__OK);
			} catch (ManagerException ex) {
				Validator.gestisciEccezione(result, ex);
			}
			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::caricaRicerca] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	//////////////////////////////////////////////////////////////////////////////
	/// Metodi statici per il reset delle tabelle
	//////////////////////////////////////////////////////////////////////////////

	//////////////////////////////////////////////////////////////////////////////
	/// Property aggiuntive del bean
	//////////////////////////////////////////////////////////////////////////////
	/*PROTECTED REGION ID(R-1635254012) ENABLED START*/

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

	private void resetRicerca(it.csi.sigit.sigitwebn.dto.gestisci_sanzioni.CpRicercaSanzioneModel theModel)
			throws ManagerException {
		String cfLoggato = theModel.getAppDatautenteLoggato().getCodiceFiscale();

		theModel.setAppDataricercaSanzioni(new RicercaSanzioni());

		//viene caricata la lista degli ispettori attivi e non
		theModel.setAppDataelencoRespSanzione(getSigitMgr().getElencoCaricatori());

		for (CodeDescription elem : theModel.getAppDataelencoRespSanzione()) {
			if (elem.getCode().equals(cfLoggato)) {

				theModel.getAppDataricercaSanzioni().setCfUtenteResponsabile(cfLoggato);
				break;
			}
		}

		theModel.setAppDataelencoSiNo(GenericUtil.getComboValues(SiNoEnum.class.getName()));
		theModel.setAppDataelencoStatiSanzione(getSigitMgr().getElencoStatiSanzione());

	}
	/*PROTECTED REGION END*/
}
