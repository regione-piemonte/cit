package it.csi.sigit.sigitwebn.business.gestisci_azioni;

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

/*PROTECTED REGION ID(R-170665615) ENABLED START*/
import it.csi.sigit.sigitwebn.business.manager.DbMgr;
import it.csi.sigit.sigitwebn.business.manager.SigitMgr;
import it.csi.sigit.sigitwebn.business.manager.ValidationMgr;
import it.csi.sigit.sigitwebn.business.manager.util.ManagerException;

/*PROTECTED REGION END*/

public class CPBECpElencoSveglie {

	/**  */
	protected static final Logger log = //NOSONAR  Reason:EIAS 
			Logger.getLogger(Constants.APPLICATION_CODE + ".business"); //NOSONAR  Reason:EIAS

	//////////////////////////////////////////////////////////////////////////////
	/// Costanti identificative degli Application Data
	//////////////////////////////////////////////////////////////////////////////

	// ApplicationData: [utenteLoggato, scope:USER_SESSION]
	public static final String APPDATA_UTENTELOGGATO_CODE = "appDatautenteLoggato";

	// ApplicationData: [ricercaSveglie, scope:USER_SESSION]
	public static final String APPDATA_RICERCASVEGLIE_CODE = "appDataricercaSveglie";

	// ApplicationData: [elencoSveglieAccertamento, scope:USER_SESSION]
	public static final String APPDATA_ELENCOSVEGLIEACCERTAMENTO_CODE = "appDataelencoSveglieAccertamento";

	// ApplicationData: [elencoSveglieAccertamentoNonAss, scope:USER_SESSION]
	public static final String APPDATA_ELENCOSVEGLIEACCERTAMENTONONASS_CODE = "appDataelencoSveglieAccertamentoNonAss";

	// ApplicationData: [elencoSveglieIspezione, scope:USER_SESSION]
	public static final String APPDATA_ELENCOSVEGLIEISPEZIONE_CODE = "appDataelencoSveglieIspezione";

	// ApplicationData: [elencoSveglieIspezioneNonAss, scope:USER_SESSION]
	public static final String APPDATA_ELENCOSVEGLIEISPEZIONENONASS_CODE = "appDataelencoSveglieIspezioneNonAss";

	// ApplicationData: [elencoSveglieSanzione, scope:USER_SESSION]
	public static final String APPDATA_ELENCOSVEGLIESANZIONE_CODE = "appDataelencoSveglieSanzione";

	// ApplicationData: [elencoSveglieVerifica, scope:USER_SESSION]
	public static final String APPDATA_ELENCOSVEGLIEVERIFICA_CODE = "appDataelencoSveglieVerifica";

	// ApplicationData: [idAccertamentoSelezionato, scope:USER_SESSION]
	public static final String APPDATA_IDACCERTAMENTOSELEZIONATO_CODE = "appDataidAccertamentoSelezionato";

	// ApplicationData: [idVerificaSelezionata, scope:USER_SESSION]
	public static final String APPDATA_IDVERIFICASELEZIONATA_CODE = "appDataidVerificaSelezionata";

	// ApplicationData: [idIspezioneSelezionato, scope:USER_SESSION]
	public static final String APPDATA_IDISPEZIONESELEZIONATO_CODE = "appDataidIspezioneSelezionato";

	// ApplicationData: [idSanzioneSelezionata, scope:USER_SESSION]
	public static final String APPDATA_IDSANZIONESELEZIONATA_CODE = "appDataidSanzioneSelezionata";

	// ApplicationData: [idAccertamentoNonAssSelezionato, scope:USER_SESSION]
	public static final String APPDATA_IDACCERTAMENTONONASSSELEZIONATO_CODE = "appDataidAccertamentoNonAssSelezionato";

	// ApplicationData: [idIspezioneNonAssSelezionato, scope:USER_SESSION]
	public static final String APPDATA_IDISPEZIONENONASSSELEZIONATO_CODE = "appDataidIspezioneNonAssSelezionato";

	// ApplicationData: [idAccertamentoAssSelezionato, scope:USER_SESSION]
	public static final String APPDATA_IDACCERTAMENTOASSSELEZIONATO_CODE = "appDataidAccertamentoAssSelezionato";

	// ApplicationData: [paginaChiamante, scope:USER_SESSION]
	public static final String APPDATA_PAGINACHIAMANTE_CODE = "appDatapaginaChiamante";

	// ApplicationData: [Ispezione2018, scope:USER_SESSION]
	public static final String APPDATA_ISPEZIONE2018_CODE = "appDataIspezione2018";

	// ApplicationData: [paginaChiamanteDettaglioSanzione, scope:USER_SESSION]
	public static final String APPDATA_PAGINACHIAMANTEDETTAGLIOSANZIONE_CODE = "appDatapaginaChiamanteDettaglioSanzione";

	//////////////////////////////////////////////////////////////////////////////
	/// Metodi associati alla U.I.
	//////////////////////////////////////////////////////////////////////////////

	// nome del content panel associato al bean
	public static final String CPNAME = "cpElencoSveglie";

	/** 
	 * Restituisce il tab correntemente visibile in un determinato tab set
	 */
	private String getCurrentTab(Map session, String tabSetName) {
		String value = (String) session.get(CPNAME + "_" + tabSetName + "_selectedMultiPanel");
		return value;
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo cercaUtente definito in un ExecCommand del
	 * ContentPanel cpElencoSveglie
	 */
	public ExecResults cercaUtente(

			it.csi.sigit.sigitwebn.dto.gestisci_azioni.CpElencoSveglieModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String CERCAUTENTE_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String CERCAUTENTE_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-1961113657) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			try {
				getValidationMgr().validazioneFormaleCercaUtenteElencoSveglie(theModel.getAppDataricercaSveglie());

				PersonaFisica pf = getDbMgr().cercaPersonaFisicaByCF(theModel.getAppDataricercaSveglie().getCfUtente());

				theModel.getAppDataricercaSveglie().setDenomUtente(pf.getDenominazione());

				cercaSveglie(theModel);

				// impostazione del result code 
				result.setResultCode(CERCAUTENTE_OUTCOME_CODE__OK);
			} catch (ManagerException ex) {
				Validator.gestisciEccezione(result, ex);
			}
			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::cercaUtente] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo nuovaRicercaUtente definito in un ExecCommand del
	 * ContentPanel cpElencoSveglie
	 */
	public ExecResults nuovaRicercaUtente(

			it.csi.sigit.sigitwebn.dto.gestisci_azioni.CpElencoSveglieModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String NUOVARICERCAUTENTE_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String NUOVARICERCAUTENTE_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-2112049779) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			// impostazione del result code 
			result.setResultCode(NUOVARICERCAUTENTE_OUTCOME_CODE__OK);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::nuovaRicercaUtente] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo visualizzaVerifica definito in un ExecCommand del
	 * ContentPanel cpElencoSveglie
	 */
	public ExecResults visualizzaVerifica(

			it.csi.sigit.sigitwebn.dto.gestisci_azioni.CpElencoSveglieModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String VISUALIZZAVERIFICA_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String VISUALIZZAVERIFICA_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-839331061) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			try {

				log.debug("##### visualizzaVerifica: " + theModel.getAppDataidVerificaSelezionata());

				getValidationMgr().checkSelezioneElemento(theModel.getAppDataidVerificaSelezionata());

				theModel.setAppDatapaginaChiamante(Constants.PAG_ELENCO_SVEGLIE);
				//theModel.setAppDatapaginaChiamanteDettaglioSanzione("SVEGLIE");

				result.setResultCode(VISUALIZZAVERIFICA_OUTCOME_CODE__OK);
			} catch (ManagerException ex) {
				Validator.gestisciEccezione(result, ex);
			}

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::visualizzaVerifica] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo visualizzaAccertamento definito in un ExecCommand del
	 * ContentPanel cpElencoSveglie
	 */
	public ExecResults visualizzaAccertamento(

			it.csi.sigit.sigitwebn.dto.gestisci_azioni.CpElencoSveglieModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String VISUALIZZAACCERTAMENTO_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String VISUALIZZAACCERTAMENTO_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R1533113372) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			try {

				log.debug("##### visualizzaAccertamento: " + theModel.getAppDataidAccertamentoAssSelezionato());

				getValidationMgr().checkSelezioneElemento(theModel.getAppDataidAccertamentoAssSelezionato());

				theModel.setAppDatapaginaChiamante(Constants.PAG_ELENCO_SVEGLIE);

				theModel.setAppDataidAccertamentoSelezionato(theModel.getAppDataidAccertamentoAssSelezionato());

				result.setResultCode(VISUALIZZAACCERTAMENTO_OUTCOME_CODE__OK);
			} catch (ManagerException ex) {
				Validator.gestisciEccezione(result, ex);
			}

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::visualizzaAccertamento] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo visualizzaIspezione definito in un ExecCommand del
	 * ContentPanel cpElencoSveglie
	 */
	public ExecResults visualizzaIspezione(

			it.csi.sigit.sigitwebn.dto.gestisci_azioni.CpElencoSveglieModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String VISUALIZZAISPEZIONE_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String VISUALIZZAISPEZIONE_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-821169010) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			try {

				log.debug("##### visualizzaIspezione: " + theModel.getAppDataidIspezioneSelezionato());

				getValidationMgr().checkSelezioneElemento(theModel.getAppDataidIspezioneSelezionato());

				theModel.setAppDatapaginaChiamante(Constants.PAG_ELENCO_SVEGLIE);

				Ispezione2018 ispezioneEsistente = new Ispezione2018();
				ispezioneEsistente.setIdentificativoIspezione(
						ConvertUtil.convertToString(theModel.getAppDataidIspezioneSelezionato()));

				theModel.setAppDataIspezione2018(ispezioneEsistente);

				result.setResultCode(VISUALIZZAISPEZIONE_OUTCOME_CODE__OK);
			} catch (ManagerException ex) {
				Validator.gestisciEccezione(result, ex);
			}

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::visualizzaIspezione] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo visualizzaSanzione definito in un ExecCommand del
	 * ContentPanel cpElencoSveglie
	 */
	public ExecResults visualizzaSanzione(

			it.csi.sigit.sigitwebn.dto.gestisci_azioni.CpElencoSveglieModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String VISUALIZZASANZIONE_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String VISUALIZZASANZIONE_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R1103309467) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			try {

				log.debug("##### visualizzaSanzione: " + theModel.getAppDataidSanzioneSelezionata());

				getValidationMgr().checkSelezioneElemento(theModel.getAppDataidSanzioneSelezionata());

				//theModel.setAppDatapaginaChiamante(Constants.PAG_ELENCO_SVEGLIE);
				theModel.setAppDatapaginaChiamanteDettaglioSanzione("SVEGLIE");

				Ispezione2018 ispezioneEsistente = new Ispezione2018();
				ispezioneEsistente.setIdentificativoIspezione(
						ConvertUtil.convertToString(theModel.getAppDataidIspezioneSelezionato()));

				theModel.setAppDataIspezione2018(ispezioneEsistente);

				result.setResultCode(VISUALIZZASANZIONE_OUTCOME_CODE__OK);
			} catch (ManagerException ex) {
				Validator.gestisciEccezione(result, ex);
			}

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::visualizzaSanzione] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo visualizzaAccertamentoNonAss definito in un ExecCommand del
	 * ContentPanel cpElencoSveglie
	 */
	public ExecResults visualizzaAccertamentoNonAss(

			it.csi.sigit.sigitwebn.dto.gestisci_azioni.CpElencoSveglieModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String VISUALIZZAACCERTAMENTONONASS_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String VISUALIZZAACCERTAMENTONONASS_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R555401224) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			try {

				log.debug(
						"##### visualizzaAccertamentoNonAss: " + theModel.getAppDataidAccertamentoNonAssSelezionato());

				getValidationMgr().checkSelezioneElemento(theModel.getAppDataidAccertamentoNonAssSelezionato());

				theModel.setAppDatapaginaChiamante(Constants.PAG_ELENCO_SVEGLIE);

				theModel.setAppDataidAccertamentoSelezionato(theModel.getAppDataidAccertamentoNonAssSelezionato());

				result.setResultCode(VISUALIZZAACCERTAMENTONONASS_OUTCOME_CODE__OK);
			} catch (ManagerException ex) {
				Validator.gestisciEccezione(result, ex);
			}
			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::visualizzaAccertamentoNonAss] Errore occorso nell'esecuzione del metodo:" + e,
					e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo visualizzaIspezioneNonAss definito in un ExecCommand del
	 * ContentPanel cpElencoSveglie
	 */
	public ExecResults visualizzaIspezioneNonAss(

			it.csi.sigit.sigitwebn.dto.gestisci_azioni.CpElencoSveglieModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String VISUALIZZAISPEZIONENONASS_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String VISUALIZZAISPEZIONENONASS_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-806509830) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			try {

				log.debug("##### visualizzaIspezioneNonAss: " + theModel.getAppDataidIspezioneNonAssSelezionato());

				getValidationMgr().checkSelezioneElemento(theModel.getAppDataidIspezioneNonAssSelezionato());

				theModel.setAppDatapaginaChiamante(Constants.PAG_ELENCO_SVEGLIE);

				Ispezione2018 ispezioneEsistente = new Ispezione2018();
				ispezioneEsistente.setIdentificativoIspezione(
						ConvertUtil.convertToString(theModel.getAppDataidIspezioneNonAssSelezionato()));

				theModel.setAppDataIspezione2018(ispezioneEsistente);

				result.setResultCode(VISUALIZZAISPEZIONENONASS_OUTCOME_CODE__OK);
			} catch (ManagerException ex) {
				Validator.gestisciEccezione(result, ex);
			}

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::visualizzaIspezioneNonAss] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo isRuoloAbilitato definito in un ExecCommand del
	 * ContentPanel cpElencoSveglie
	 */
	public ExecResults isRuoloAbilitato(

			it.csi.sigit.sigitwebn.dto.gestisci_azioni.CpElencoSveglieModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String ISRUOLOABILITATO_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-75551838) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			UtenteLoggato utente = theModel.getAppDatautenteLoggato();

			if (GenericUtil.isRuoloAbilitatoAccessoRicercaSveglie(utente)) {
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
	 * Implementazione del metodo gestisciUtente definito in un ExecCommand del
	 * ContentPanel cpElencoSveglie
	 */
	public ExecResults gestisciUtente(

			it.csi.sigit.sigitwebn.dto.gestisci_azioni.CpElencoSveglieModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GESTISCIUTENTE_OUTCOME_CODE__LETTURA = //NOSONAR  Reason:EIAS
				"LETTURA"; //NOSONAR  Reason:EIAS
		final String GESTISCIUTENTE_OUTCOME_CODE__SCRITTURA = //NOSONAR  Reason:EIAS
				"SCRITTURA"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R1150582146) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			UtenteLoggato utente = theModel.getAppDatautenteLoggato();

			RicercaSveglie ricSveglie = new RicercaSveglie();
			ricSveglie.setCfUtente(utente.getCodiceFiscale());
			ricSveglie.setDenomUtente(utente.getDenominazione());

			theModel.setAppDataricercaSveglie(ricSveglie);

			if (utente.getRuolo().getDescRuolo().equalsIgnoreCase(Constants.RUOLO_SUPER)) {
				// se e' super puo' modificare il codice fiscale con cui cercare le sveglie
				result.setResultCode(GESTISCIUTENTE_OUTCOME_CODE__SCRITTURA);
			} else {
				// se NON e' super puo' cercare solo le sue sveglie
				result.setResultCode(GESTISCIUTENTE_OUTCOME_CODE__LETTURA);
			}

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::gestisciUtente] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo preparaElencoSveglie definito in un ExecCommand del
	 * ContentPanel cpElencoSveglie
	 */
	public ExecResults preparaElencoSveglie(

			it.csi.sigit.sigitwebn.dto.gestisci_azioni.CpElencoSveglieModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String PREPARAELENCOSVEGLIE_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String PREPARAELENCOSVEGLIE_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R1046370918) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			cercaSveglie(theModel);

			// impostazione del result code 
			result.setResultCode(PREPARAELENCOSVEGLIE_OUTCOME_CODE__OK);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::preparaElencoSveglie] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	//////////////////////////////////////////////////////////////////////////////
	/// Metodi statici per il reset delle tabelle
	//////////////////////////////////////////////////////////////////////////////

	/**
	 * permette di resettare lo stato di paginazione della tabella widg_tbVerifiche
	 */
	public static void resetClearStatus_widg_tbVerifiche(java.util.Map session) {
		session.put("cpElencoSveglie_tbVerifiche_clearStatus", Boolean.TRUE);
	}

	/**
	 * permette di resettare lo stato di paginazione della tabella widg_tbAccertamento
	 */
	public static void resetClearStatus_widg_tbAccertamento(java.util.Map session) {
		session.put("cpElencoSveglie_tbAccertamento_clearStatus", Boolean.TRUE);
	}

	/**
	 * permette di resettare lo stato di paginazione della tabella widg_tbIspezione
	 */
	public static void resetClearStatus_widg_tbIspezione(java.util.Map session) {
		session.put("cpElencoSveglie_tbIspezione_clearStatus", Boolean.TRUE);
	}

	/**
	 * permette di resettare lo stato di paginazione della tabella widg_tbSanzione
	 */
	public static void resetClearStatus_widg_tbSanzione(java.util.Map session) {
		session.put("cpElencoSveglie_tbSanzione_clearStatus", Boolean.TRUE);
	}

	/**
	 * permette di resettare lo stato di paginazione della tabella widg_tbAccertamentoNonAss
	 */
	public static void resetClearStatus_widg_tbAccertamentoNonAss(java.util.Map session) {
		session.put("cpElencoSveglie_tbAccertamentoNonAss_clearStatus", Boolean.TRUE);
	}

	/**
	 * permette di resettare lo stato di paginazione della tabella widg_tbIspezioneNonAss
	 */
	public static void resetClearStatus_widg_tbIspezioneNonAss(java.util.Map session) {
		session.put("cpElencoSveglie_tbIspezioneNonAss_clearStatus", Boolean.TRUE);
	}

	//////////////////////////////////////////////////////////////////////////////
	/// Property aggiuntive del bean
	//////////////////////////////////////////////////////////////////////////////
	/*PROTECTED REGION ID(R2106693917) ENABLED START*/
	//// inserire qui le property che si vogliono iniettare in questo bean (es. dao, proxy di pd, ...)
	private SigitMgr sigitMgr;

	public SigitMgr getSigitMgr() {
		return sigitMgr;
	}

	public void setSigitMgr(SigitMgr sigitMgr) {
		this.sigitMgr = sigitMgr;
	}

	private DbMgr dbMgr;

	public DbMgr getDbMgr() {
		return dbMgr;
	}

	public void setDbMgr(DbMgr dbMgr) {
		this.dbMgr = dbMgr;
	}

	private ValidationMgr validationMgr;

	public ValidationMgr getValidationMgr() {
		return validationMgr;
	}

	public void setValidationMgr(ValidationMgr validationMgr) {
		this.validationMgr = validationMgr;
	}

	public enum RicercaCampoAccertamentoEnum {
		RICERCA_IMPIANTO
	}

	private void cercaSveglie(it.csi.sigit.sigitwebn.dto.gestisci_azioni.CpElencoSveglieModel theModel)
			throws ManagerException {
		theModel.setAppDataelencoSveglieVerifica(getSigitMgr().getSveglieByCfUtente(Constants.ID_TIPO_AZIONE_VERIFICA,
				theModel.getAppDataricercaSveglie().getCfUtente()));

		theModel.setAppDataelencoSveglieAccertamento(getSigitMgr().getSveglieByCfUtente(
				Constants.ID_TIPO_AZIONE_ACCERTAMENTO, theModel.getAppDataricercaSveglie().getCfUtente()));

		theModel.setAppDataelencoSveglieAccertamentoNonAss(
				getSigitMgr().getSveglieByCfUtente(Constants.ID_TIPO_AZIONE_ACCERTAMENTO, null));

		theModel.setAppDataelencoSveglieIspezione(getSigitMgr().getSveglieByCfUtente(Constants.ID_TIPO_AZIONE_ISPEZIONE,
				theModel.getAppDataricercaSveglie().getCfUtente()));

		theModel.setAppDataelencoSveglieIspezioneNonAss(
				getSigitMgr().getSveglieByCfUtente(Constants.ID_TIPO_AZIONE_ISPEZIONE, null));

		theModel.setAppDataelencoSveglieSanzione(getSigitMgr().getSveglieByCfUtente(Constants.ID_TIPO_AZIONE_SANZIONE,
				theModel.getAppDataricercaSveglie().getCfUtente()));

	}
	/*PROTECTED REGION END*/
}
