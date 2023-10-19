package it.csi.sigit.sigitwebn.business.risultato_ricerca_verifiche;

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

/*PROTECTED REGION ID(R1260712476) ENABLED START*/
import it.csi.sigit.sigitwebn.business.manager.DbMgr;
import it.csi.sigit.sigitwebn.business.manager.ServiziMgr;
import it.csi.sigit.sigitwebn.business.manager.SigitMgr;
import it.csi.sigit.sigitwebn.business.manager.ValidationMgr;
import it.csi.sigit.sigitwebn.business.manager.util.DbManagerException;
import it.csi.sigit.sigitwebn.business.manager.util.ManagerException;
import it.csi.sigit.sigitwebn.business.manager.util.Message;
import it.csi.sigit.sigitwebn.business.manager.util.ServiceException;

/*PROTECTED REGION END*/

public class CPBECpRisRicercaVerifiche {

	/**  */
	protected static final Logger log = //NOSONAR  Reason:EIAS 
			Logger.getLogger(Constants.APPLICATION_CODE + ".business"); //NOSONAR  Reason:EIAS

	//////////////////////////////////////////////////////////////////////////////
	/// Costanti identificative degli Application Data
	//////////////////////////////////////////////////////////////////////////////

	// ApplicationData: [elencoVerifiche, scope:USER_SESSION]
	public static final String APPDATA_ELENCOVERIFICHE_CODE = "appDataelencoVerifiche";

	// ApplicationData: [idVerificaSelezionata, scope:USER_SESSION]
	public static final String APPDATA_IDVERIFICASELEZIONATA_CODE = "appDataidVerificaSelezionata";

	// ApplicationData: [utenteLoggato, scope:USER_SESSION]
	public static final String APPDATA_UTENTELOGGATO_CODE = "appDatautenteLoggato";

	// ApplicationData: [paginaChiamante, scope:USER_SESSION]
	public static final String APPDATA_PAGINACHIAMANTE_CODE = "appDatapaginaChiamante";

	// ApplicationData: [messaggioDinamico, scope:USER_SESSION]
	public static final String APPDATA_MESSAGGIODINAMICO_CODE = "appDatamessaggioDinamico";

	// ApplicationData: [elencoTipiVerifica, scope:USER_SESSION]
	public static final String APPDATA_ELENCOTIPIVERIFICA_CODE = "appDataelencoTipiVerifica";

	// ApplicationData: [ricercaVerifica, scope:USER_SESSION]
	public static final String APPDATA_RICERCAVERIFICA_CODE = "appDataricercaVerifica";

	// ApplicationData: [elencoValidatoriVerifica, scope:USER_SESSION]
	public static final String APPDATA_ELENCOVALIDATORIVERIFICA_CODE = "appDataelencoValidatoriVerifica";

	//////////////////////////////////////////////////////////////////////////////
	/// Metodi associati alla U.I.
	//////////////////////////////////////////////////////////////////////////////

	// nome del content panel associato al bean
	public static final String CPNAME = "cpRisRicercaVerifiche";

	/** 
	 * Restituisce il tab correntemente visibile in un determinato tab set
	 */
	private String getCurrentTab(Map session, String tabSetName) {
		String value = (String) session.get(CPNAME + "_" + tabSetName + "_selectedMultiPanel");
		return value;
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo gestisciInserisciVerifica definito in un ExecCommand del
	 * ContentPanel cpRisRicercaVerifiche
	 */
	public ExecResults gestisciInserisciVerifica(

			it.csi.sigit.sigitwebn.dto.risultato_ricerca_verifiche.CpRisRicercaVerificheModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GESTISCIINSERISCIVERIFICA_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String GESTISCIINSERISCIVERIFICA_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R701147382) ENABLED START*/
			theModel.setAppDataidVerificaSelezionata(null);
			result.setResultCode(GESTISCIINSERISCIVERIFICA_OUTCOME_CODE__OK);
			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::gestisciInserisciVerifica] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo gestisciModificaVerifica definito in un ExecCommand del
	 * ContentPanel cpRisRicercaVerifiche
	 */
	public ExecResults gestisciModificaVerifica(

			it.csi.sigit.sigitwebn.dto.risultato_ricerca_verifiche.CpRisRicercaVerificheModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GESTISCIMODIFICAVERIFICA_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String GESTISCIMODIFICAVERIFICA_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R460496449) ENABLED START*/

			try {
				getValidationMgr().checkSelezioneElemento(theModel.getAppDataidVerificaSelezionata());

				theModel.setAppDatapaginaChiamante(Constants.PAG_ELENCO_VERIFICHE);

				result.setResultCode(GESTISCIMODIFICAVERIFICA_OUTCOME_CODE__OK);
			} catch (ManagerException ex) {
				Validator.gestisciEccezione(result, ex);
			}

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::gestisciModificaVerifica] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo gestisciEliminaVerifica definito in un ExecCommand del
	 * ContentPanel cpRisRicercaVerifiche
	 */
	public ExecResults gestisciEliminaVerifica(

			it.csi.sigit.sigitwebn.dto.risultato_ricerca_verifiche.CpRisRicercaVerificheModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GESTISCIELIMINAVERIFICA_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String GESTISCIELIMINAVERIFICA_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R1132908656) ENABLED START*/
			try {
				getValidationMgr().checkSelezioneElemento(theModel.getAppDataidVerificaSelezionata());
				//CONTROLLO SULLA PRESENZA DI OGGETTI COLLEGATI ALLA VERIFICA
				getValidationMgr().validazioneEliminaVerifica(theModel.getAppDataidVerificaSelezionata());

				Message msg = new Message(Messages.C008, theModel.getAppDataidVerificaSelezionata());
				theModel.setAppDatamessaggioDinamico(msg.getText());

				result.setResultCode(GESTISCIELIMINAVERIFICA_OUTCOME_CODE__OK);
			} catch (ManagerException ex) {

				Validator.gestisciEccezione(result, ex);
			}

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::gestisciEliminaVerifica] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo eliminaVerifica definito in un ExecCommand del
	 * ContentPanel cpRisRicercaVerifiche
	 */
	public ExecResults eliminaVerifica(

			it.csi.sigit.sigitwebn.dto.risultato_ricerca_verifiche.CpRisRicercaVerificheModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String ELIMINAVERIFICA_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String ELIMINAVERIFICA_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R1902582657) ENABLED START*/
			try {
				//SUPERATA LA VALIDAZIONE VIENE ESEGUITA L'ELIMINAZION
				getSigitMgr().eliminaVerificaById(theModel.getAppDataidVerificaSelezionata());
				theModel.getSession().put(Constants.SESSIONE_VAR_MESSAGGE,
						new Message(Messages.INFO_ELIMINAZIONE_CORRETTA, Message.INFO));
				GenericUtil.gestisciMessaggioSessione(theModel, result);

				if (theModel.getAppDataelencoVerifiche() != null) {
					List<Verifica> nuovaLista = new ArrayList<Verifica>();
					for (Verifica verifica : theModel.getAppDataelencoVerifiche()) {
						if (!verifica.getIdentificativo().equals(theModel.getAppDataidVerificaSelezionata())) {
							nuovaLista.add(verifica);
						}
					}
					theModel.setAppDataelencoVerifiche((ArrayList<Verifica>) nuovaLista);
				}
				theModel.setAppDataidVerificaSelezionata(null);

				result.setResultCode(ELIMINAVERIFICA_OUTCOME_CODE__OK);

			} catch (ManagerException ex) {

				Validator.gestisciEccezione(result, ex);
			}

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::eliminaVerifica] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo isRuoloAbilitato definito in un ExecCommand del
	 * ContentPanel cpRisRicercaVerifiche
	 */
	public ExecResults isRuoloAbilitato(

			it.csi.sigit.sigitwebn.dto.risultato_ricerca_verifiche.CpRisRicercaVerificheModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String ISRUOLOABILITATO_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-1823848553) ENABLED START*/
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
	 * Implementazione del metodo gestisciAbilitazione definito in un ExecCommand del
	 * ContentPanel cpRisRicercaVerifiche
	 */
	public ExecResults gestisciAbilitazione(

			it.csi.sigit.sigitwebn.dto.risultato_ricerca_verifiche.CpRisRicercaVerificheModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GESTISCIABILITAZIONE_OUTCOME_CODE__ABILITA = //NOSONAR  Reason:EIAS
				"ABILITA"; //NOSONAR  Reason:EIAS
		final String GESTISCIABILITAZIONE_OUTCOME_CODE__DISABILITA = //NOSONAR  Reason:EIAS
				"DISABILITA"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R1727090731) ENABLED START*/
			UtenteLoggato utente = theModel.getAppDatautenteLoggato();

			// impostazione del result code 
			// se il ruolo utente non appartiene a questo set, il form è in editing
			if (GenericUtil.checkValidRole(utente,
					Arrays.asList(Constants.RUOLO_SUPER, Constants.RUOLO_VALIDATORE, Constants.RUOLO_ISPETTORE), false,
					true)) {
				result.setResultCode(GESTISCIABILITAZIONE_OUTCOME_CODE__ABILITA);
			} else {
				result.setResultCode(GESTISCIABILITAZIONE_OUTCOME_CODE__DISABILITA);
			}

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::gestisciAbilitazione] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo caricaScheda definito in un ExecCommand del
	 * ContentPanel cpRisRicercaVerifiche
	 */
	public ExecResults caricaScheda(

			it.csi.sigit.sigitwebn.dto.risultato_ricerca_verifiche.CpRisRicercaVerificheModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String CARICASCHEDA_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-1538833374) ENABLED START*/

			log.debug("Stampo la ricerca accertamenti: " + (theModel.getAppDataricercaVerifica()));
			if (theModel.getAppDataricercaVerifica() == null) {
				// provengo dall'accertamento, devo creare una ricerca fittizia (con CF)
				creaRicerca(theModel);
			}

			List<Verifica> risultatoRicerca = getSigitMgr().getElencoVerificheByFilter(
					MapDto.mapToRicercaVerificaFilter(theModel.getAppDataricercaVerifica()),
					ConvertUtil.convertIdDescriptionsInMap(theModel.getAppDataelencoTipiVerifica()));

			theModel.setAppDataelencoVerifiche((ArrayList<Verifica>) risultatoRicerca);

			gestioneMsgRicerca(theModel, result);

			theModel.setAppDataidVerificaSelezionata(null);
			result.setResultCode(CARICASCHEDA_OUTCOME_CODE__OK);
			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::caricaScheda] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	//////////////////////////////////////////////////////////////////////////////
	/// Metodi statici per il reset delle tabelle
	//////////////////////////////////////////////////////////////////////////////

	/**
	 * permette di resettare lo stato di paginazione della tabella widg_tbRisultatoRicercaVerifiche
	 */
	public static void resetClearStatus_widg_tbRisultatoRicercaVerifiche(java.util.Map session) {
		session.put("cpRisRicercaVerifiche_tbRisultatoRicercaVerifiche_clearStatus", Boolean.TRUE);
	}

	//////////////////////////////////////////////////////////////////////////////
	/// Property aggiuntive del bean
	//////////////////////////////////////////////////////////////////////////////
	/*PROTECTED REGION ID(R-482857262) ENABLED START*/

	private DbMgr dbMgr;

	public DbMgr getDbMgr() {
		return dbMgr;
	}

	public void setDbMgr(DbMgr dbMgr) {
		this.dbMgr = dbMgr;
	}

	private SigitMgr sigitMgr;

	public SigitMgr getSigitMgr() {
		return sigitMgr;
	}

	public void setSigitMgr(SigitMgr sigitMgr) {
		this.sigitMgr = sigitMgr;
	}

	private ServiziMgr serviziMgr;

	public ServiziMgr getServiziMgr() {
		return serviziMgr;
	}

	public void setServiziMgr(ServiziMgr serviziMgr) {
		this.serviziMgr = serviziMgr;
	}

	private ValidationMgr validationMgr;

	public ValidationMgr getValidationMgr() {
		return validationMgr;
	}

	public void setValidationMgr(ValidationMgr validationMgr) {
		this.validationMgr = validationMgr;
	}

	private void creaRicerca(it.csi.sigit.sigitwebn.dto.risultato_ricerca_verifiche.CpRisRicercaVerificheModel theModel)
			throws ManagerException, ServiceException {

		theModel.setAppDataelencoValidatoriVerifica(getSigitMgr().getElencoValidatoriIdPf(false));

		if (theModel.getAppDataelencoTipiVerifica() == null || theModel.getAppDataelencoTipiVerifica().isEmpty()) {
			//viene popolata la lista dei tipi di verifica
			theModel.setAppDataelencoTipiVerifica(getSigitMgr().getElencoTipoVerifiche());
		}

		//il form di ricerca presenta di default il CF utente caricatore impostato a quello dell'utente collegato
		if (theModel.getAppDataricercaVerifica() == null) {
			theModel.setAppDataricercaVerifica(new RicercaVerifica());
		}

		if (theModel.getAppDataelencoValidatoriVerifica() != null) {
			for (CodeDescription validatore : theModel.getAppDataelencoValidatoriVerifica()) {
				if (validatore.getDescription().contains(theModel.getAppDatautenteLoggato().getCodiceFiscale())) {
					theModel.getAppDataricercaVerifica().setIdValidatore(validatore.getCode());
					break;
				}
			}
		}

	}

	private void gestioneMsgRicerca(
			it.csi.sigit.sigitwebn.dto.risultato_ricerca_verifiche.CpRisRicercaVerificheModel theModel,
			ExecResults result) throws DbManagerException {
		Integer maxNumRighe = getDbMgr().cercaConfigValueNumerico(Constants.MAX_RIGHE);
		log.debug("MAX num righe da visualizzare = " + maxNumRighe);
		ArrayList<Verifica> risRicVerificheList = theModel.getAppDataelencoVerifiche();
		if (risRicVerificheList != null && risRicVerificheList.size() == maxNumRighe)
			result.getGlobalMessages()
					.add(Messages.MSG_RISULTATI_RICERCA.replaceFirst("##value##", maxNumRighe.toString()));
	}
	/*PROTECTED REGION END*/
}
