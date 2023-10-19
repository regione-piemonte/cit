package it.csi.sigit.sigitwebn.business.risultato_ricerca_accertamenti;

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

/*PROTECTED REGION ID(R-1413946439) ENABLED START*/
import it.csi.sigit.sigitwebn.business.manager.SigitMgr;
import it.csi.sigit.sigitwebn.business.manager.ValidationMgr;
import it.csi.sigit.sigitwebn.business.manager.DbMgr;
import it.csi.sigit.sigitwebn.business.manager.ServiziMgr;
import it.csi.sigit.sigitwebn.business.manager.util.DbManagerException;
import it.csi.sigit.sigitwebn.business.manager.util.ManagerException;
import it.csi.sigit.sigitwebn.business.manager.util.ServiceException;

/*PROTECTED REGION END*/

public class CPBECpRisRicercaAccertamenti {

	/**  */
	protected static final Logger log = //NOSONAR  Reason:EIAS 
			Logger.getLogger(Constants.APPLICATION_CODE + ".business"); //NOSONAR  Reason:EIAS

	//////////////////////////////////////////////////////////////////////////////
	/// Costanti identificative degli Application Data
	//////////////////////////////////////////////////////////////////////////////

	// ApplicationData: [utenteLoggato, scope:USER_SESSION]
	public static final String APPDATA_UTENTELOGGATO_CODE = "appDatautenteLoggato";

	// ApplicationData: [paginaChiamante, scope:USER_SESSION]
	public static final String APPDATA_PAGINACHIAMANTE_CODE = "appDatapaginaChiamante";

	// ApplicationData: [messaggioDinamico, scope:USER_SESSION]
	public static final String APPDATA_MESSAGGIODINAMICO_CODE = "appDatamessaggioDinamico";

	// ApplicationData: [elencoAccertamenti, scope:USER_SESSION]
	public static final String APPDATA_ELENCOACCERTAMENTI_CODE = "appDataelencoAccertamenti";

	// ApplicationData: [idAccertamentoSelezionato, scope:USER_SESSION]
	public static final String APPDATA_IDACCERTAMENTOSELEZIONATO_CODE = "appDataidAccertamentoSelezionato";

	// ApplicationData: [ricercaAccertamento, scope:USER_SESSION]
	public static final String APPDATA_RICERCAACCERTAMENTO_CODE = "appDataricercaAccertamento";

	// ApplicationData: [elencoTipoAnomalie, scope:USER_SESSION]
	public static final String APPDATA_ELENCOTIPOANOMALIE_CODE = "appDataelencoTipoAnomalie";

	// ApplicationData: [elencoStatoAccertamento, scope:USER_SESSION]
	public static final String APPDATA_ELENCOSTATOACCERTAMENTO_CODE = "appDataelencoStatoAccertamento";

	// ApplicationData: [elencoValidatori, scope:USER_SESSION]
	public static final String APPDATA_ELENCOVALIDATORI_CODE = "appDataelencoValidatori";

	// ApplicationData: [elencoProvincePiemonteIstat, scope:USER_SESSION]
	public static final String APPDATA_ELENCOPROVINCEPIEMONTEISTAT_CODE = "appDataelencoProvincePiemonteIstat";

	//////////////////////////////////////////////////////////////////////////////
	/// Metodi associati alla U.I.
	//////////////////////////////////////////////////////////////////////////////

	// nome del content panel associato al bean
	public static final String CPNAME = "cpRisRicercaAccertamenti";

	/** 
	 * Restituisce il tab correntemente visibile in un determinato tab set
	 */
	private String getCurrentTab(Map session, String tabSetName) {
		String value = (String) session.get(CPNAME + "_" + tabSetName + "_selectedMultiPanel");
		return value;
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo gestisciModificaAccertamento definito in un ExecCommand del
	 * ContentPanel cpRisRicercaAccertamenti
	 */
	public ExecResults gestisciModificaAccertamento(

			it.csi.sigit.sigitwebn.dto.risultato_ricerca_accertamenti.CpRisRicercaAccertamentiModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GESTISCIMODIFICAACCERTAMENTO_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String GESTISCIMODIFICAACCERTAMENTO_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-945444715) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			try {
				getValidationMgr().checkSelezioneElemento(theModel.getAppDataidAccertamentoSelezionato());

				theModel.setAppDatapaginaChiamante(Constants.PAG_ELENCO_VERIFICHE);

				result.setResultCode(GESTISCIMODIFICAACCERTAMENTO_OUTCOME_CODE__OK);
			} catch (ManagerException ex) {
				Validator.gestisciEccezione(result, ex);
			}

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::gestisciModificaAccertamento] Errore occorso nell'esecuzione del metodo:" + e,
					e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo isRuoloAbilitato definito in un ExecCommand del
	 * ContentPanel cpRisRicercaAccertamenti
	 */
	public ExecResults isRuoloAbilitato(

			it.csi.sigit.sigitwebn.dto.risultato_ricerca_accertamenti.CpRisRicercaAccertamentiModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String ISRUOLOABILITATO_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R1118521434) ENABLED START*/
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
	 * Implementazione del metodo caricaScheda definito in un ExecCommand del
	 * ContentPanel cpRisRicercaAccertamenti
	 */
	public ExecResults caricaScheda(

			it.csi.sigit.sigitwebn.dto.risultato_ricerca_accertamenti.CpRisRicercaAccertamentiModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String CARICASCHEDA_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R779427429) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			log.debug("Stampo la ricerca accertamenti: " + (theModel.getAppDataricercaAccertamento()));
			if (theModel.getAppDataricercaAccertamento() == null) {
				// provengo dalla verifica, devo creare una ricerca fittizia (con CF)
				creaRicerca(theModel);
			}

			// provengo dalla ricerca
			List<Accertamento> risultatoRicerca = getSigitMgr().getElencoAccertamentiByFilter(
					MapDto.mapToRicercaAccertamentoFilter(theModel.getAppDataricercaAccertamento()),
					ConvertUtil.convertIdDescriptionsInMap(theModel.getAppDataelencoStatoAccertamento()),
					ConvertUtil.convertCodeDescriptionsInMap(theModel.getAppDataelencoTipoAnomalie()),
					ConvertUtil.convertCodeDescriptionsInMap(theModel.getAppDataelencoProvincePiemonteIstat()));

			theModel.setAppDataelencoAccertamenti((ArrayList<Accertamento>) risultatoRicerca);

			gestioneMsgRicerca(theModel, result);

			//			theModel.setAppDataidAccertamentoSelezionato(null);
			//
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
	 * permette di resettare lo stato di paginazione della tabella widg_tbRisultatoRicercaAccertamenti
	 */
	public static void resetClearStatus_widg_tbRisultatoRicercaAccertamenti(java.util.Map session) {
		session.put("cpRisRicercaAccertamenti_tbRisultatoRicercaAccertamenti_clearStatus", Boolean.TRUE);
	}

	//////////////////////////////////////////////////////////////////////////////
	/// Property aggiuntive del bean
	//////////////////////////////////////////////////////////////////////////////
	/*PROTECTED REGION ID(R579752667) ENABLED START*/
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

	private ServiziMgr serviziMgr;

	public ServiziMgr getServiziMgr() {
		return serviziMgr;
	}

	public void setServiziMgr(ServiziMgr serviziMgr) {
		this.serviziMgr = serviziMgr;
	}

	private void creaRicerca(
			it.csi.sigit.sigitwebn.dto.risultato_ricerca_accertamenti.CpRisRicercaAccertamentiModel theModel)
			throws ManagerException, ServiceException {

		theModel.setAppDataelencoValidatori(getSigitMgr().getElencoValidatoriIdPf(false));

		if (theModel.getAppDataelencoStatoAccertamento() == null
				|| theModel.getAppDataelencoStatoAccertamento().isEmpty()) {
			//viene popolata la lista dei tipi di verifica
			theModel.setAppDataelencoStatoAccertamento(getSigitMgr().getElencoStatoAccertamento());
		}

		if (theModel.getAppDataelencoTipoAnomalie() == null || theModel.getAppDataelencoTipoAnomalie().isEmpty()) {
			//viene popolata la lista dei tipi di anomalia
			theModel.setAppDataelencoTipoAnomalie(getSigitMgr().getElencoTipoAnomalie());
		}

		log.debug("SONO SUL RESET: theModel.getAppDataricercaAccertamento(): "
				+ theModel.getAppDataricercaAccertamento());

		//il form di ricerca presenta di default il CF utente caricatore impostato a quello dell'utente collegato
		if (theModel.getAppDataricercaAccertamento() == null) {
			theModel.setAppDataricercaAccertamento(new RicercaAccertamento());
			//			theModel.getAppDataricercaAccertamento().setCfUtente(theModel.getAppDatautenteLoggato().getCodiceFiscale());
		}

		if (theModel.getAppDataelencoValidatori() != null) {
			for (CodeDescription validatore : theModel.getAppDataelencoValidatori()) {
				if (validatore.getDescription().contains(theModel.getAppDatautenteLoggato().getCodiceFiscale())) {
					theModel.getAppDataricercaAccertamento().setIdValidatore(validatore.getCode());
					break;
				}
			}
		}

		if (theModel.getAppDataelencoProvincePiemonteIstat() == null
				|| theModel.getAppDataelencoProvincePiemonteIstat().isEmpty()) {
			theModel.setAppDataelencoProvincePiemonteIstat(getServiziMgr().getListaIstatProvincePiemonte());
		}

	}

	private void gestioneMsgRicerca(
			it.csi.sigit.sigitwebn.dto.risultato_ricerca_accertamenti.CpRisRicercaAccertamentiModel theModel,
			ExecResults result) throws DbManagerException {
		Integer maxNumRighe = getDbMgr().cercaConfigValueNumerico(Constants.MAX_RIGHE);
		log.debug("MAX num righe da visualizzare = " + maxNumRighe);
		ArrayList<Accertamento> risRicAccertamentiList = theModel.getAppDataelencoAccertamenti();
		if (risRicAccertamentiList != null && risRicAccertamentiList.size() == maxNumRighe)
			result.getGlobalMessages()
					.add(Messages.MSG_RISULTATI_RICERCA.replaceFirst("##value##", maxNumRighe.toString()));
	}

	/*PROTECTED REGION END*/
}
