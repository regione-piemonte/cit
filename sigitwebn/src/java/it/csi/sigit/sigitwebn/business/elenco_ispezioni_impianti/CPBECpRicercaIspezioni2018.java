package it.csi.sigit.sigitwebn.business.elenco_ispezioni_impianti;

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

/*PROTECTED REGION ID(R942813178) ENABLED START*/
import it.csi.sigit.sigitwebn.business.manager.SigitMgr;
import it.csi.sigit.sigitwebn.business.manager.ServiziMgr;
import it.csi.sigit.sigitwebn.business.manager.ValidationMgr;
import it.csi.sigit.sigitwebn.business.manager.util.ManagerException;
import it.csi.sigit.sigitwebn.business.manager.util.ServiceException;
import it.csi.sigit.sigitwebn.dto.elenco_ispezioni_impianti.CpRicercaIspezioni2018Model;
/*PROTECTED REGION END*/

public class CPBECpRicercaIspezioni2018 {

	/**  */
	protected static final Logger log = //NOSONAR  Reason:EIAS 
			Logger.getLogger(Constants.APPLICATION_CODE + ".business"); //NOSONAR  Reason:EIAS

	//////////////////////////////////////////////////////////////////////////////
	/// Costanti identificative degli Application Data
	//////////////////////////////////////////////////////////////////////////////

	// ApplicationData: [RicercaIspezioni2018, scope:USER_SESSION]
	public static final String APPDATA_RICERCAISPEZIONI2018_CODE = "appDataRicercaIspezioni2018";

	// ApplicationData: [idIspezioneSelezionato, scope:USER_SESSION]
	public static final String APPDATA_IDISPEZIONESELEZIONATO_CODE = "appDataidIspezioneSelezionato";

	// ApplicationData: [elencoStatiIspezione, scope:USER_SESSION]
	public static final String APPDATA_ELENCOSTATIISPEZIONE_CODE = "appDataelencoStatiIspezione";

	// ApplicationData: [utenteLoggato, scope:USER_SESSION]
	public static final String APPDATA_UTENTELOGGATO_CODE = "appDatautenteLoggato";

	// ApplicationData: [elencoIspettori, scope:USER_SESSION]
	public static final String APPDATA_ELENCOISPETTORI_CODE = "appDataelencoIspettori";

	// ApplicationData: [elencoPositivoNegativo, scope:USER_SESSION]
	public static final String APPDATA_ELENCOPOSITIVONEGATIVO_CODE = "appDataelencoPositivoNegativo";

	// ApplicationData: [elencoProvincePiemonteIstat, scope:USER_SESSION]
	public static final String APPDATA_ELENCOPROVINCEPIEMONTEISTAT_CODE = "appDataelencoProvincePiemonteIstat";

	// ApplicationData: [elencoComuniPiemonteIstat, scope:USER_SESSION]
	public static final String APPDATA_ELENCOCOMUNIPIEMONTEISTAT_CODE = "appDataelencoComuniPiemonteIstat";

	//////////////////////////////////////////////////////////////////////////////
	/// Metodi associati alla U.I.
	//////////////////////////////////////////////////////////////////////////////

	// nome del content panel associato al bean
	public static final String CPNAME = "cpRicercaIspezioni2018";

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
	 * ContentPanel cpRicercaIspezioni2018
	 */
	public ExecResults loadComuni(

			it.csi.sigit.sigitwebn.dto.elenco_ispezioni_impianti.CpRicercaIspezioni2018Model theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String LOADCOMUNI_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-649069556) ENABLED START*/
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
	 * Implementazione del metodo ricercaIspezioni definito in un ExecCommand del
	 * ContentPanel cpRicercaIspezioni2018
	 */
	public ExecResults ricercaIspezioni(

			it.csi.sigit.sigitwebn.dto.elenco_ispezioni_impianti.CpRicercaIspezioni2018Model theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String RICERCAISPEZIONI_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String RICERCAISPEZIONI_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-789477860) ENABLED START*/
			try {

				getValidationMgr().validazioneFormaleRicercaIspezioni(theModel.getAppDataRicercaIspezioni2018());

				//invocazione del servizio di ricerca

				result.setResultCode(RICERCAISPEZIONI_OUTCOME_CODE__OK);

			} catch (ManagerException ex) {

				Validator.gestisciEccezione(result, ex);
				result.setResultCode(RICERCAISPEZIONI_OUTCOME_CODE__KO);
			}

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::ricercaIspezioni] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo annullaRicerca definito in un ExecCommand del
	 * ContentPanel cpRicercaIspezioni2018
	 */
	public ExecResults annullaRicerca(

			it.csi.sigit.sigitwebn.dto.elenco_ispezioni_impianti.CpRicercaIspezioni2018Model theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String ANNULLARICERCA_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-491739497) ENABLED START*/

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
	 * Implementazione del metodo gestisciIndietroRicercaIspezioni definito in un ExecCommand del
	 * ContentPanel cpRicercaIspezioni2018
	 */
	public ExecResults gestisciIndietroRicercaIspezioni(

			it.csi.sigit.sigitwebn.dto.elenco_ispezioni_impianti.CpRicercaIspezioni2018Model theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GESTISCIINDIETRORICERCAISPEZIONI_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String GESTISCIINDIETRORICERCAISPEZIONI_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R293864983) ENABLED START*/

			try {
				resetRicerca(theModel);

				result.setResultCode(GESTISCIINDIETRORICERCAISPEZIONI_OUTCOME_CODE__OK);
			} catch (ManagerException ex) {
				Validator.gestisciEccezione(result, ex);
			}

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error(
					"[BackEndFacade::gestisciIndietroRicercaIspezioni] Errore occorso nell'esecuzione del metodo:" + e,
					e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo isRuoloAbilitato definito in un ExecCommand del
	 * ContentPanel cpRicercaIspezioni2018
	 */
	public ExecResults isRuoloAbilitato(

			it.csi.sigit.sigitwebn.dto.elenco_ispezioni_impianti.CpRicercaIspezioni2018Model theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String ISRUOLOABILITATO_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-1460022791) ENABLED START*/
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
	 * Implementazione del metodo preparaRicercaIspezioni definito in un ExecCommand del
	 * ContentPanel cpRicercaIspezioni2018
	 */
	public ExecResults preparaRicercaIspezioni(

			it.csi.sigit.sigitwebn.dto.elenco_ispezioni_impianti.CpRicercaIspezioni2018Model theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String PREPARARICERCAISPEZIONI_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String PREPARARICERCAISPEZIONI_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-1829244465) ENABLED START*/
			try {
				resetRicerca(theModel);

				result.setResultCode(PREPARARICERCAISPEZIONI_OUTCOME_CODE__OK);
			} catch (ManagerException ex) {
				Validator.gestisciEccezione(result, ex);
			}

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::preparaRicercaIspezioni] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo gestisciAbilRuoloEnte definito in un ExecCommand del
	 * ContentPanel cpRicercaIspezioni2018
	 */
	public ExecResults gestisciAbilRuoloEnte(

			it.csi.sigit.sigitwebn.dto.elenco_ispezioni_impianti.CpRicercaIspezioni2018Model theModel

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
			/*PROTECTED REGION ID(R800119329) ENABLED START*/
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
	 * ContentPanel cpRicercaIspezioni2018
	 */
	public ExecResults gestisciComboGeo(

			it.csi.sigit.sigitwebn.dto.elenco_ispezioni_impianti.CpRicercaIspezioni2018Model theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GESTISCICOMBOGEO_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-1506818193) ENABLED START*/
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
	/*PROTECTED REGION ID(R15133626) ENABLED START*/
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

	private ServiziMgr serviziMgr;

	public ServiziMgr getServiziMgr() {
		return serviziMgr;
	}

	public void setServiziMgr(ServiziMgr serviziMgr) {
		this.serviziMgr = serviziMgr;
	}

	private void resetRicerca(it.csi.sigit.sigitwebn.dto.elenco_ispezioni_impianti.CpRicercaIspezioni2018Model theModel)
			throws ManagerException, ServiceException {
		String idPersonaFisica = theModel.getAppDatautenteLoggato().getIdPersonaFisica();

		theModel.setAppDataRicercaIspezioni2018(new RicercaIspezioni2018());

		//viene caricata la lista degli ispettori attivi e non
		theModel.setAppDataelencoIspettori(getSigitMgr().getElencoIspettoriIdPf(false));

		theModel.setAppDataidIspezioneSelezionato(null);

		for (CodeDescription elem : theModel.getAppDataelencoIspettori()) {
			if (elem.getCode().equals(idPersonaFisica)) {

				theModel.getAppDataRicercaIspezioni2018().setIdIspettore(ConvertUtil.convertToInteger(idPersonaFisica));
				break;
			}
		}

		if (theModel.getAppDataelencoProvincePiemonteIstat() == null
				|| theModel.getAppDataelencoProvincePiemonteIstat().isEmpty()) {
			theModel.setAppDataelencoProvincePiemonteIstat(getServiziMgr().getListaIstatProvincePiemonte());
		}

		theModel.setAppDataelencoComuniPiemonteIstat(new ArrayList<>());

		//viene caricata la lista della combo esito
		theModel.setAppDataelencoPositivoNegativo(GenericUtil.getComboPositivoNegativo());

		theModel.setAppDataelencoStatiIspezione(getSigitMgr().getElencoStatiISpezione());

	}

	private ExecResults gestisciAbilRuoloRef(CpRicercaIspezioni2018Model theModel, String codRetRuoloPaProvincia,
			String codRetRuoloPaComune, String codRetAltro) throws ServiceException, BEException, ManagerException {
		ExecResults result = new ExecResults();

		UtenteLoggato utenteLog = theModel.getAppDatautenteLoggato();

		if (log.isDebugEnabled())
			GenericUtil.stampa(utenteLog, true, 2);

		RicercaIspezioni2018 ricIspez = theModel.getAppDataRicercaIspezioni2018();

		if (ricIspez == null) {
			ricIspez = new RicercaIspezioni2018();
		}

		String descRuolo = utenteLog.getRuolo().getDescRuolo();

		String istatAbilitazione = utenteLog.getRuolo().getIstatAbilitazione();

		if ((descRuolo.equals(Constants.RUOLO_CONSULTATORE) || descRuolo.equals(Constants.RUOLO_VALIDATORE)
				|| descRuolo.equals(Constants.RUOLO_ISPETTORE)) && istatAbilitazione.length() > 2) {

			ArrayList<CodeDescription> comuni = getSigitMgr().impostaProvinciaSuRicercaIspezioni(ricIspez,
					istatAbilitazione);
			log.debug("-------------" + comuni + "--------------");
			theModel.setAppDataelencoComuniPiemonteIstat(comuni);

			result.setResultCode(codRetRuoloPaProvincia);

			if (istatAbilitazione.length() > 5) {
				getSigitMgr().impostaComuneSuRicercaIspezioni(theModel.getAppDataelencoComuniPiemonteIstat(), ricIspez,
						istatAbilitazione);

				result.setResultCode(codRetRuoloPaComune);
			}

		} else {
			result.setResultCode(codRetAltro);
		}

		theModel.setAppDataRicercaIspezioni2018(ricIspez);

		return result;
	}

	private void gestisciComboDtCatasto(CpRicercaIspezioni2018Model theModel) throws BEException {

		log.debug("[BackEndFacade::gestisciComboDtCatasto] BEGIN");

		try {
			RicercaIspezioni2018 ricercaAcc = theModel.getAppDataRicercaIspezioni2018();
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
