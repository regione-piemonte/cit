package it.csi.sigit.sigitwebn.business.ricerca_accertamenti;

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

/*PROTECTED REGION ID(R-1204289999) ENABLED START*/
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.*;
import it.csi.sigit.sigitwebn.util.*;
import it.csi.sigit.sigitwebn.business.*;
import it.csi.sigit.sigitwebn.business.manager.ServiziMgr;
import it.csi.sigit.sigitwebn.business.manager.SigitMgr;
import it.csi.sigit.sigitwebn.business.manager.ValidationMgr;
import it.csi.sigit.sigitwebn.business.manager.util.ManagerException;
import it.csi.sigit.sigitwebn.business.manager.util.ServiceException;
import it.csi.sigit.sigitwebn.dto.ricerca_accertamenti.CpRicercaAccertamentiModel;
/*PROTECTED REGION END*/

public class CPBECpRicercaAccertamenti {

	/**  */
	protected static final Logger log = //NOSONAR  Reason:EIAS 
			Logger.getLogger(Constants.APPLICATION_CODE + ".business"); //NOSONAR  Reason:EIAS

	//////////////////////////////////////////////////////////////////////////////
	/// Costanti identificative degli Application Data
	//////////////////////////////////////////////////////////////////////////////

	// ApplicationData: [utenteLoggato, scope:USER_SESSION]
	public static final String APPDATA_UTENTELOGGATO_CODE = "appDatautenteLoggato";

	// ApplicationData: [elencoVerifiche, scope:USER_SESSION]
	public static final String APPDATA_ELENCOVERIFICHE_CODE = "appDataelencoVerifiche";

	// ApplicationData: [idVerificaSelezionata, scope:USER_SESSION]
	public static final String APPDATA_IDVERIFICASELEZIONATA_CODE = "appDataidVerificaSelezionata";

	// ApplicationData: [elencoTipiVerifica, scope:USER_SESSION]
	public static final String APPDATA_ELENCOTIPIVERIFICA_CODE = "appDataelencoTipiVerifica";

	// ApplicationData: [elencoSiglaBollini, scope:USER_SESSION]
	public static final String APPDATA_ELENCOSIGLABOLLINI_CODE = "appDataelencoSiglaBollini";

	// ApplicationData: [ricercaAccertamento, scope:USER_SESSION]
	public static final String APPDATA_RICERCAACCERTAMENTO_CODE = "appDataricercaAccertamento";

	// ApplicationData: [elencoTipoAnomalie, scope:USER_SESSION]
	public static final String APPDATA_ELENCOTIPOANOMALIE_CODE = "appDataelencoTipoAnomalie";

	// ApplicationData: [elencoTipoConclusione, scope:USER_SESSION]
	public static final String APPDATA_ELENCOTIPOCONCLUSIONE_CODE = "appDataelencoTipoConclusione";

	// ApplicationData: [elencoProvincePiemonte, scope:USER_SESSION]
	public static final String APPDATA_ELENCOPROVINCEPIEMONTE_CODE = "appDataelencoProvincePiemonte";

	// ApplicationData: [elencoStatoAccertamento, scope:USER_SESSION]
	public static final String APPDATA_ELENCOSTATOACCERTAMENTO_CODE = "appDataelencoStatoAccertamento";

	// ApplicationData: [elencoValidatori, scope:USER_SESSION]
	public static final String APPDATA_ELENCOVALIDATORI_CODE = "appDataelencoValidatori";

	// ApplicationData: [elencoProvincePiemonteIstat, scope:USER_SESSION]
	public static final String APPDATA_ELENCOPROVINCEPIEMONTEISTAT_CODE = "appDataelencoProvincePiemonteIstat";

	// ApplicationData: [elencoComuniPiemonteIstat, scope:USER_SESSION]
	public static final String APPDATA_ELENCOCOMUNIPIEMONTEISTAT_CODE = "appDataelencoComuniPiemonteIstat";

	//////////////////////////////////////////////////////////////////////////////
	/// Metodi associati alla U.I.
	//////////////////////////////////////////////////////////////////////////////

	// nome del content panel associato al bean
	public static final String CPNAME = "cpRicercaAccertamenti";

	/** 
	 * Restituisce il tab correntemente visibile in un determinato tab set
	 */
	private String getCurrentTab(Map session, String tabSetName) {
		String value = (String) session.get(CPNAME + "_" + tabSetName + "_selectedMultiPanel");
		return value;
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo loadComuni definito in un ExecCommand del
	 * ContentPanel cpRicercaAccertamenti
	 */
	public ExecResults loadComuni(

			it.csi.sigit.sigitwebn.dto.ricerca_accertamenti.CpRicercaAccertamentiModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String LOADCOMUNI_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R599342005) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			// impostazione del result code 
			result.setResultCode(LOADCOMUNI_OUTCOME_CODE__OK);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::loadComuni] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo ricercaAccertamento definito in un ExecCommand del
	 * ContentPanel cpRicercaAccertamenti
	 */
	public ExecResults ricercaAccertamento(

			it.csi.sigit.sigitwebn.dto.ricerca_accertamenti.CpRicercaAccertamentiModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String RICERCAACCERTAMENTO_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String RICERCAACCERTAMENTO_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-1899994559) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			try {

				getValidationMgr().validazioneFormaleRicercaAccertamenti(theModel.getAppDataricercaAccertamento());

				result.setResultCode(RICERCAACCERTAMENTO_OUTCOME_CODE__OK);

			} catch (ManagerException ex) {

				Validator.gestisciEccezione(result, ex);
				result.setResultCode(RICERCAACCERTAMENTO_OUTCOME_CODE__KO);
			}

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::ricercaAccertamento] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo pulisciCampi definito in un ExecCommand del
	 * ContentPanel cpRicercaAccertamenti
	 */
	public ExecResults pulisciCampi(

			it.csi.sigit.sigitwebn.dto.ricerca_accertamenti.CpRicercaAccertamentiModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String PULISCICAMPI_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-483312551) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			//RESET DEL FORM DI RICERCA
			RicercaAccertamento nuovaRicerca = new RicercaAccertamento();

			theModel.setAppDataricercaAccertamento(nuovaRicerca);

			//IMPOSTAZIONE DEI DEFAULT SUL FORM
			resetRicerca(theModel);

			// impostazione del result code 
			result.setResultCode(PULISCICAMPI_OUTCOME_CODE__OK);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::pulisciCampi] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo preparaFormRicerca definito in un ExecCommand del
	 * ContentPanel cpRicercaAccertamenti
	 */
	public ExecResults preparaFormRicerca(

			it.csi.sigit.sigitwebn.dto.ricerca_accertamenti.CpRicercaAccertamentiModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String PREPARAFORMRICERCA_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-1198537606) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			resetRicerca(theModel);

			// impostazione del result code 
			result.setResultCode(PREPARAFORMRICERCA_OUTCOME_CODE__OK);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::preparaFormRicerca] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo isRuoloAbilitato definito in un ExecCommand del
	 * ContentPanel cpRicercaAccertamenti
	 */
	public ExecResults isRuoloAbilitato(

			it.csi.sigit.sigitwebn.dto.ricerca_accertamenti.CpRicercaAccertamentiModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String ISRUOLOABILITATO_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R1429532386) ENABLED START*/
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
	 * Implementazione del metodo gestisciAbilRuoloEnte definito in un ExecCommand del
	 * ContentPanel cpRicercaAccertamenti
	 */
	public ExecResults gestisciAbilRuoloEnte(

			it.csi.sigit.sigitwebn.dto.ricerca_accertamenti.CpRicercaAccertamentiModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GESTISCIABILRUOLOENTE_OUTCOME_CODE__RUOLO_PA_PROVINCIA = //NOSONAR  Reason:EIAS
				"RUOLO_PA_PROVINCIA"; //NOSONAR  Reason:EIAS
		final String GESTISCIABILRUOLOENTE_OUTCOME_CODE__RUOLO_PA_COMUNE = //NOSONAR  Reason:EIAS
				"RUOLO_PA_COMUNE"; //NOSONAR  Reason:EIAS
		final String GESTISCIABILRUOLOENTE_OUTCOME_CODE__RUOLO_ALTRO = //NOSONAR  Reason:EIAS
				"RUOLO_ALTRO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R1168139992) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			// impostazione del result code

			result = gestisciAbilRuoloRef(theModel, GESTISCIABILRUOLOENTE_OUTCOME_CODE__RUOLO_PA_PROVINCIA,
					GESTISCIABILRUOLOENTE_OUTCOME_CODE__RUOLO_PA_COMUNE,
					GESTISCIABILRUOLOENTE_OUTCOME_CODE__RUOLO_ALTRO);
			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::gestisciAbilRuoloEnte] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo gestisciComboGeo definito in un ExecCommand del
	 * ContentPanel cpRicercaAccertamenti
	 */
	public ExecResults gestisciComboGeo(

			it.csi.sigit.sigitwebn.dto.ricerca_accertamenti.CpRicercaAccertamentiModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GESTISCICOMBOGEO_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R1382736984) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			gestisciComboDtCatasto(theModel);

			// impostazione del result code 
			result.setResultCode(GESTISCICOMBOGEO_OUTCOME_CODE__OK);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::gestisciComboGeo] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	//////////////////////////////////////////////////////////////////////////////
	/// Metodi statici per il reset delle tabelle
	//////////////////////////////////////////////////////////////////////////////

	//////////////////////////////////////////////////////////////////////////////
	/// Property aggiuntive del bean
	//////////////////////////////////////////////////////////////////////////////
	/*PROTECTED REGION ID(R-20762979) ENABLED START*/
	//// inserire qui le property che si vogliono iniettare in questo bean (es. dao, proxy di pd, ...) 

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

	private void resetRicerca(it.csi.sigit.sigitwebn.dto.ricerca_accertamenti.CpRicercaAccertamentiModel theModel)
			throws ManagerException, ServiceException {

		if (theModel.getAppDataelencoStatoAccertamento() == null
				|| theModel.getAppDataelencoStatoAccertamento().isEmpty()) {
			//viene popolata la lista dei tipi di verifica
			theModel.setAppDataelencoStatoAccertamento(getSigitMgr().getElencoStatoAccertamento());
		}

		theModel.setAppDataelencoValidatori(getSigitMgr().getElencoValidatoriIdPf(false));

		if (theModel.getAppDataelencoTipoAnomalie() == null || theModel.getAppDataelencoTipoAnomalie().isEmpty()) {
			//viene popolata la lista dei tipi di anomalia
			theModel.setAppDataelencoTipoAnomalie(getSigitMgr().getElencoTipoAnomalie());
		}

		if (theModel.getAppDataelencoTipoConclusione() == null
				|| theModel.getAppDataelencoTipoConclusione().isEmpty()) {
			//viene popolata la lista dei tipi di conclusione
			theModel.setAppDataelencoTipoConclusione(getSigitMgr().getElencoTipoConclusioni());
		}

		if (theModel.getAppDataelencoProvincePiemonteIstat() == null
				|| theModel.getAppDataelencoProvincePiemonteIstat().isEmpty()) {
			theModel.setAppDataelencoProvincePiemonteIstat(getServiziMgr().getListaIstatProvincePiemonte());
		}

		theModel.setAppDataelencoComuniPiemonteIstat(new ArrayList<>());

		log.debug("SONO SUL RESET: theModel.getAppDataricercaAccertamento(): "
				+ theModel.getAppDataricercaAccertamento());

		//il form di ricerca presenta di default il CF utente caricatore impostato a quello dell'utente collegato
		if (theModel.getAppDataricercaAccertamento() == null) {
			theModel.setAppDataricercaAccertamento(new RicercaAccertamento());
		}

		if (theModel.getAppDataelencoValidatori() != null) {
			for (CodeDescription validatore : theModel.getAppDataelencoValidatori()) {
				if (validatore.getDescription().contains(theModel.getAppDatautenteLoggato().getCodiceFiscale())) {
					theModel.getAppDataricercaAccertamento().setIdValidatore(validatore.getCode());
					break;
				}
			}
		}

		if (theModel.getAppDataelencoProvincePiemonte() == null
				|| theModel.getAppDataelencoProvincePiemonte().isEmpty()) {
			theModel.setAppDataelencoProvincePiemonte(getServiziMgr().getListaProvincePiemonte());
		}

	}

	private ExecResults gestisciAbilRuoloRef(CpRicercaAccertamentiModel theModel, String codRetRuoloPaProvincia,
			String codRetRuoloPaComune, String codRetAltro) throws ServiceException, BEException, ManagerException {
		ExecResults result = new ExecResults();

		UtenteLoggato utenteLog = theModel.getAppDatautenteLoggato();

		if (log.isDebugEnabled())
			GenericUtil.stampa(utenteLog, true, 2);

		RicercaAccertamento ricAcc = theModel.getAppDataricercaAccertamento();

		if (ricAcc == null) {
			ricAcc = new RicercaAccertamento();
		}

		String descRuolo = utenteLog.getRuolo().getDescRuolo();

		String istatAbilitazione = utenteLog.getRuolo().getIstatAbilitazione();

		if ((descRuolo.equals(Constants.RUOLO_CONSULTATORE) || descRuolo.equals(Constants.RUOLO_VALIDATORE)
				|| descRuolo.equals(Constants.RUOLO_ISPETTORE)) && istatAbilitazione.length() > 2) {

			ArrayList<CodeDescription> comuni = getSigitMgr().impostaProvinciaSuRicercaAccertamenti(ricAcc,
					istatAbilitazione);
			log.debug("-------------" + comuni + "--------------");
			theModel.setAppDataelencoComuniPiemonteIstat(comuni);

			result.setResultCode(codRetRuoloPaProvincia);

			if (istatAbilitazione.length() > 5) {
				getSigitMgr().impostaComuneSuRicercaAccertamenti(theModel.getAppDataelencoComuniPiemonteIstat(), ricAcc,
						istatAbilitazione);

				result.setResultCode(codRetRuoloPaComune);
			}

		} else {
			result.setResultCode(codRetAltro);
		}

		theModel.setAppDataricercaAccertamento(ricAcc);

		return result;
	}

	private void gestisciComboDtCatasto(CpRicercaAccertamentiModel theModel) throws BEException {

		log.debug("[BackEndFacade::gestisciComboDtCatasto] BEGIN");

		try {
			RicercaAccertamento ricercaAcc = theModel.getAppDataricercaAccertamento();
			ArrayList<CodeDescription> comuni = new ArrayList<CodeDescription>();

			if (ricercaAcc != null) {
				String istatProvincia = ricercaAcc.getIstatProvincia();

				log.debug("STAMPO idProvSel: " + istatProvincia);

				if (GenericUtil.isNotNullOrEmpty(istatProvincia)) {
					comuni = (ArrayList<CodeDescription>) getServiziMgr()
							.getListaComuniByIstatProvincia(istatProvincia);
				}
			}
			theModel.setAppDataelencoComuniPiemonteIstat(comuni);
		} catch (ServiceException e) {
			//throw new ManagerException(e, new Message(Messages.ERROR_SERVIZIO_NON_RAGGIUNGIBILE));
			throw new BEException("Errore in getComuni della provincia:" + e, e);

		} finally {
			log.debug("[BackEndFacade::gestisciComboDtCatasto] END");

		}
	}

	/*PROTECTED REGION END*/
}
