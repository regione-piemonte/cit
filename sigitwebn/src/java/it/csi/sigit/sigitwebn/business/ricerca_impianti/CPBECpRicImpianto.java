package it.csi.sigit.sigitwebn.business.ricerca_impianti;

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

/*PROTECTED REGION ID(R-438208249) ENABLED START*/
import it.csi.sigit.sigitwebn.business.manager.DbMgr;
import it.csi.sigit.sigitwebn.business.manager.ServiziMgr;
import it.csi.sigit.sigitwebn.business.manager.SigitMgr;
import it.csi.sigit.sigitwebn.business.manager.ValidationMgr;
import it.csi.sigit.sigitwebn.business.manager.util.DbManagerException;
import it.csi.sigit.sigitwebn.business.manager.util.ManagerException;
import it.csi.sigit.sigitwebn.business.manager.util.ServiceException;
import it.csi.sigit.sigitwebn.dto.ricerca_impianti.CpRicImpiantoModel;

import org.apache.commons.beanutils.PropertyUtils;

/*PROTECTED REGION END*/

public class CPBECpRicImpianto {

	/**  */
	protected static final Logger log = //NOSONAR  Reason:EIAS 
			Logger.getLogger(Constants.APPLICATION_CODE + ".business"); //NOSONAR  Reason:EIAS

	//////////////////////////////////////////////////////////////////////////////
	/// Costanti identificative degli Application Data
	//////////////////////////////////////////////////////////////////////////////

	// ApplicationData: [elencoComuni, scope:USER_SESSION]
	public static final String APPDATA_ELENCOCOMUNI_CODE = "appDataelencoComuni";

	// ApplicationData: [elencoProvince, scope:USER_SESSION]
	public static final String APPDATA_ELENCOPROVINCE_CODE = "appDataelencoProvince";

	// ApplicationData: [elencoSiglaRea, scope:USER_SESSION]
	public static final String APPDATA_ELENCOSIGLAREA_CODE = "appDataelencoSiglaRea";

	// ApplicationData: [ricercaImpianti, scope:USER_SESSION]
	public static final String APPDATA_RICERCAIMPIANTI_CODE = "appDataricercaImpianti";

	// ApplicationData: [utenteLoggato, scope:USER_SESSION]
	public static final String APPDATA_UTENTELOGGATO_CODE = "appDatautenteLoggato";

	// ApplicationData: [risultatoRicercaImpianti, scope:USER_SESSION]
	public static final String APPDATA_RISULTATORICERCAIMPIANTI_CODE = "appDatarisultatoRicercaImpianti";

	// ApplicationData: [aggiornaElencoImpianti, scope:USER_SESSION]
	public static final String APPDATA_AGGIORNAELENCOIMPIANTI_CODE = "appDataaggiornaElencoImpianti";

	// ApplicationData: [elencoProvincePiemonte, scope:USER_SESSION]
	public static final String APPDATA_ELENCOPROVINCEPIEMONTE_CODE = "appDataelencoProvincePiemonte";

	// ApplicationData: [idImpiantoSelez, scope:USER_SESSION]
	public static final String APPDATA_IDIMPIANTOSELEZ_CODE = "appDataidImpiantoSelez";

	// ApplicationData: [idResponsabileSelez, scope:USER_SESSION]
	public static final String APPDATA_IDRESPONSABILESELEZ_CODE = "appDataidResponsabileSelez";

	// ApplicationData: [provenienza, scope:USER_SESSION]
	public static final String APPDATA_PROVENIENZA_CODE = "appDataprovenienza";

	// ApplicationData: [impianto, scope:USER_SESSION]
	public static final String APPDATA_IMPIANTO_CODE = "appDataimpianto";

	// ApplicationData: [elencoStatoImpianto, scope:USER_SESSION]
	public static final String APPDATA_ELENCOSTATOIMPIANTO_CODE = "appDataelencoStatoImpianto";

	//////////////////////////////////////////////////////////////////////////////
	/// Metodi associati alla U.I.
	//////////////////////////////////////////////////////////////////////////////

	// nome del content panel associato al bean
	public static final String CPNAME = "cpRicImpianto";

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
	 * ContentPanel cpRicImpianto
	 */
	public ExecResults loadComuni(

			it.csi.sigit.sigitwebn.dto.ricerca_impianti.CpRicImpiantoModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String LOADCOMUNI_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R2038272415) ENABLED START*/
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
	 * Implementazione del metodo ricercaCompletaImpianto definito in un ExecCommand del
	 * ContentPanel cpRicImpianto
	 */
	public ExecResults ricercaCompletaImpianto(

			it.csi.sigit.sigitwebn.dto.ricerca_impianti.CpRicImpiantoModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String RICERCACOMPLETAIMPIANTO_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String RICERCACOMPLETAIMPIANTO_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-791756269) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			try {
				RicercaImpianti ricImpianti = theModel.getAppDataricercaImpianti();

				// Risetto i dati di default, questo lo faccio per sicurezza, in modo che se qualcuno modifica via web i dati di default, qui vengono reimpostati
				UtenteLoggato utenteLog = theModel.getAppDatautenteLoggato();

				String descRuolo = utenteLog.getRuolo().getDescRuolo();

				if (descRuolo.equals(Constants.RUOLO_IMPRESA)) {

					//theModel.setAppDataricercaImpianti(ricImpianti);

					getValidationMgr().validazioneFormaleRicercaCompletaImpianti(ricImpianti);
					//
					//					RicercaImpianti ricComplImpianti = new RicercaImpianti();
					//
					//					PropertyUtils.copyProperties(ricComplImpianti, ricImpianti);
					//
					//					ricComplImpianti.setCfImpresa(null);
					//					ricComplImpianti.setIdSiglaRea(null);
					//					ricComplImpianti.setNumeroRea(null);

					//theModel.setAppDataaggiornaElencoImpianti(true);

					//					ArrayList<RisultatoRicImpianto> risRicCodImpiantoList = getSigitMgr()
					//							.cercaElencoImpianti(
					//									ricComplImpianti,
					//									theModel.getAppDatautenteLoggato()
					//											.getRuolo().getDescRuolo());
					//
					//					theModel.setAppDatarisultatoRicercaImpianti(risRicCodImpiantoList);

					//theModel.setAppDataaggiornaElencoImpianti(false);
					//					resetClearStatus_widg_tbRisultatoRicImp(theModel
					//							.getSession());

					// impostazione del result code 
					result.setResultCode(RICERCACOMPLETAIMPIANTO_OUTCOME_CODE__OK);

				} else {
					// Non dovrebbe mai succedere
					result.setResultCode(RICERCACOMPLETAIMPIANTO_OUTCOME_CODE__KO);
				}

			} catch (ManagerException ex) {
				Validator.gestisciEccezione(result, ex);
			}

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::ricercaCompletaImpianto] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo ricercaImpianto definito in un ExecCommand del
	 * ContentPanel cpRicImpianto
	 */
	public ExecResults ricercaImpianto(

			it.csi.sigit.sigitwebn.dto.ricerca_impianti.CpRicImpiantoModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String RICERCAIMPIANTO_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String RICERCAIMPIANTO_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-390638008) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:
			try {
				RicercaImpianti ricImpianti = theModel.getAppDataricercaImpianti();

				// Risetto i dati di default, questo lo faccio per sicurezza, in modo che se qualcuno modifica via web i dati di default, qui vengono reimpostati
				UtenteLoggato utenteLog = theModel.getAppDatautenteLoggato();

				String descRuolo = utenteLog.getRuolo().getDescRuolo();

				if (descRuolo.equals(Constants.RUOLO_IMPRESA)) {

					ricImpianti.setCfImpresa(ReplaceSpecialCharUtils.sanitize(utenteLog.getRuolo().getCodiceFiscale()));
					ricImpianti.setIdSiglaRea(ReplaceSpecialCharUtils.sanitize(utenteLog.getRuolo().getSiglaRea()));
					ricImpianti
							.setNumeroRea(ConvertUtil.convertToUDTPositiveInteger(utenteLog.getRuolo().getNumeroRea()));

				} else if (descRuolo.equals(Constants.RUOLO_RESPONSABILE)) {
					ricImpianti.setCfResponsabile(ReplaceSpecialCharUtils.sanitize(utenteLog.getCodiceFiscale()));
				} else if (descRuolo.equals(Constants.RUOLO_PROPRIETARIO)) {
					ricImpianti.setCfProprietario(ReplaceSpecialCharUtils.sanitize(utenteLog.getCodiceFiscale()));
				} else if (descRuolo.equals(Constants.RUOLO_RESPONSABILE_IMPRESA)) {
					ricImpianti.setCfResponsabile(ReplaceSpecialCharUtils.sanitize(utenteLog.getRuolo().getCodiceFiscale()));
				} else if (descRuolo.equals(Constants.RUOLO_PROPRIETARIO_IMPRESA)) {
					ricImpianti.setCfProprietario(ReplaceSpecialCharUtils.sanitize(utenteLog.getRuolo().getCodiceFiscale()));
				} else if (descRuolo.equals(Constants.RUOLO_3RESPONSABILE)) {
					ricImpianti.setCf3Responsabile(ReplaceSpecialCharUtils.sanitize(utenteLog.getRuolo().getCodiceFiscale()));

				}

				theModel.setAppDataricercaImpianti(ricImpianti);

				getValidationMgr().validazioneFormaleRicercaImpianti(ricImpianti);

				theModel.setAppDataaggiornaElencoImpianti(true);

				// impostazione del result code 
				result.setResultCode(RICERCAIMPIANTO_OUTCOME_CODE__OK);

			} catch (ManagerException ex) {
				Validator.gestisciEccezione(result, ex);
			}

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::ricercaImpianto] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo pulisciCampi definito in un ExecCommand del
	 * ContentPanel cpRicImpianto
	 */
	public ExecResults pulisciCampi(

			it.csi.sigit.sigitwebn.dto.ricerca_impianti.CpRicImpiantoModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String PULISCICAMPI_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-650657853) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			UtenteLoggato utenteLog = theModel.getAppDatautenteLoggato();

			if (log.isDebugEnabled())
				GenericUtil.stampa(utenteLog, true, 2);

			RicercaImpianti ricImp = new RicercaImpianti();

			String descRuolo = utenteLog.getRuolo().getDescRuolo();

			String istatAbilitazione = utenteLog.getRuolo().getIstatAbilitazione();

			ArrayList<CodeDescription> comuni = new ArrayList<CodeDescription>();
			theModel.setAppDataelencoComuni(comuni);

			if (descRuolo.equals(Constants.RUOLO_IMPRESA)) {

				ricImp.setCfImpresa(ReplaceSpecialCharUtils.sanitize(utenteLog.getRuolo().getCodiceFiscale()));
				ricImp.setIdSiglaRea(ReplaceSpecialCharUtils.sanitize(utenteLog.getRuolo().getSiglaRea()));
				ricImp.setNumeroRea(ConvertUtil.convertToUDTPositiveInteger(utenteLog.getRuolo().getNumeroRea()));

			} else if (descRuolo.equals(Constants.RUOLO_RESPONSABILE)) {
				ricImp.setCfResponsabile(ReplaceSpecialCharUtils.sanitize(utenteLog.getCodiceFiscale()));
			} else if (descRuolo.equals(Constants.RUOLO_RESPONSABILE_IMPRESA)) {
				ricImp.setCfResponsabile(ReplaceSpecialCharUtils.sanitize(utenteLog.getRuolo().getCodiceFiscale()));
			} else if (descRuolo.equals(Constants.RUOLO_3RESPONSABILE)) {
				ricImp.setCf3Responsabile(ReplaceSpecialCharUtils.sanitize(utenteLog.getRuolo().getCodiceFiscale()));
			} else if ((descRuolo.equals(Constants.RUOLO_CONSULTATORE) || descRuolo.equals(Constants.RUOLO_VALIDATORE)
					|| descRuolo.equals(Constants.RUOLO_ISPETTORE)) && istatAbilitazione.length() > 2) {

				comuni = getSigitMgr().impostaProvinciaSuRicercaImpianti(ricImp, istatAbilitazione);
				theModel.setAppDataelencoComuni(comuni);

				if (istatAbilitazione.length() > 5) {
					getSigitMgr().impostaComuneSuRicercaImpianti(theModel.getAppDataelencoComuni(), ricImp,
							istatAbilitazione);
				}
			}

			theModel.setAppDataricercaImpianti(ricImp);

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
	 * Implementazione del metodo gestInserisciImpianto definito in un ExecCommand del
	 * ContentPanel cpRicImpianto
	 */
	public ExecResults gestInserisciImpianto(

			it.csi.sigit.sigitwebn.dto.ricerca_impianti.CpRicImpiantoModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GESTINSERISCIIMPIANTO_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String GESTINSERISCIIMPIANTO_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R1079940499) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			Impianto impianto = new Impianto();

			LogicaVisualizzazione logica = new LogicaVisualizzazione();
			logica.setCaso(Constants.COD_CASO_A);

			Ruolo ruolo = theModel.getAppDatautenteLoggato().getRuolo();
			//logica.setIsPrimoIngresso(true);
			impianto.setLogicaVisual(logica);

			if (!ruolo.getDescRuolo().equalsIgnoreCase(Constants.RUOLO_VALIDATORE)
					&& !ruolo.getDescRuolo().equalsIgnoreCase(Constants.RUOLO_SUPER)
					&& !ruolo.getDescRuolo().equalsIgnoreCase(Constants.RUOLO_ISPETTORE)) {
				impianto.setInstCf(ReplaceSpecialCharUtils.sanitize(ruolo.getCodiceFiscale()));
				impianto.setInstIdSiglaRea(ReplaceSpecialCharUtils.sanitize(ruolo.getSiglaRea()));
				impianto.setInstNumeroRea(ConvertUtil.convertToUDTPositiveInteger(ruolo.getNumeroRea()));
				impianto.setInstImpresa(ReplaceSpecialCharUtils.sanitize(ruolo.getDenomDitta()));
				impianto.setInstId(ruolo.getIdPersonaGiuridica());

				//impianto.setLibIsModifica(ConvertUtil.convertToString(false));
			}

			impianto.setImpIdStatoImp(ConvertUtil.convertToString(Constants.ID_STATO_IMP_VALIDO));
			impianto.setImpIdStatoImpOld(ConvertUtil.convertToString(Constants.ID_STATO_IMP_VALIDO));
			impianto.setImpDataDismissioneOld(DateUtil.getDataCorrenteFormat());
			impianto.setImpMotivazione(Constants.MOTIVAZIONE_STATO_IMPIANTO_DEFAULT);
			impianto.setImpMotivazioneOld(Constants.MOTIVAZIONE_STATO_IMPIANTO_DEFAULT);

			theModel.setAppDataprovenienza(Constants.PAG_RIC_IMPIANTI);

			theModel.setAppDataimpianto(impianto);

			// impostazione del result code 
			result.setResultCode(GESTINSERISCIIMPIANTO_OUTCOME_CODE__OK);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::gestInserisciImpianto] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo gestInserisciImpiantoResp definito in un ExecCommand del
	 * ContentPanel cpRicImpianto
	 */
	public ExecResults gestInserisciImpiantoResp(

			it.csi.sigit.sigitwebn.dto.ricerca_impianti.CpRicImpiantoModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GESTINSERISCIIMPIANTORESP_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R1297711139) ENABLED START*/

			Impianto impianto = new Impianto();

			LogicaVisualizzazione logica = new LogicaVisualizzazione();
			logica.setCaso(Constants.COD_CASO_A);

			Ruolo ruolo = theModel.getAppDatautenteLoggato().getRuolo();
			impianto.setLogicaVisual(logica);

			impianto.setImpIdStatoImp(ConvertUtil.convertToString(Constants.ID_STATO_IMP_VALIDO));
			impianto.setImpIdStatoImpOld(ConvertUtil.convertToString(Constants.ID_STATO_IMP_VALIDO));
			impianto.setImpDataDismissione(DateUtil.getDataCorrenteFormat());
			impianto.setImpMotivazione(Constants.MOTIVAZIONE_STATO_IMPIANTO_DEFAULT);
			impianto.setImpMotivazioneOld(Constants.MOTIVAZIONE_STATO_IMPIANTO_DEFAULT);
			impianto.setVisuProprietario(true);

			theModel.setAppDataimpianto(impianto);

			// impostazione del result code 
			result.setResultCode(GESTINSERISCIIMPIANTORESP_OUTCOME_CODE__OK);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::gestInserisciImpiantoResp] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo initRicercaImpianto definito in un ExecCommand del
	 * ContentPanel cpRicImpianto
	 */
	public ExecResults initRicercaImpianto(

			it.csi.sigit.sigitwebn.dto.ricerca_impianti.CpRicImpiantoModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String INITRICERCAIMPIANTO_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R996576120) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			//			ArrayList<CodeDescription> comuni = new ArrayList<CodeDescription>();
			//			theModel.setAppDataelencoComuni(comuni);
			// impostazione del result code 
			result.setResultCode(INITRICERCAIMPIANTO_OUTCOME_CODE__OK);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::initRicercaImpianto] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo isRuoloAbilitato definito in un ExecCommand del
	 * ContentPanel cpRicImpianto
	 */
	public ExecResults isRuoloAbilitato(

			it.csi.sigit.sigitwebn.dto.ricerca_impianti.CpRicImpiantoModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String ISRUOLOABILITATO_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R337096012) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			UtenteLoggato utenteLoggato = theModel.getAppDatautenteLoggato();

			if (GenericUtil.isRuoloAbilitatoAccessoImpianti(utenteLoggato)) {
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
	 * Implementazione del metodo gestisciAbilRuoloEnt definito in un ExecCommand del
	 * ContentPanel cpRicImpianto
	 */
	public ExecResults gestisciAbilRuoloEnt(

			it.csi.sigit.sigitwebn.dto.ricerca_impianti.CpRicImpiantoModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GESTISCIABILRUOLOENT_OUTCOME_CODE__RUOLO_PG = //NOSONAR  Reason:EIAS
				"RUOLO_PG"; //NOSONAR  Reason:EIAS
		final String GESTISCIABILRUOLOENT_OUTCOME_CODE__RUOLO_RESPONSABILE = //NOSONAR  Reason:EIAS
				"RUOLO_RESPONSABILE"; //NOSONAR  Reason:EIAS
		final String GESTISCIABILRUOLOENT_OUTCOME_CODE__RUOLO_PROPRIETARIO = //NOSONAR  Reason:EIAS
				"RUOLO_PROPRIETARIO"; //NOSONAR  Reason:EIAS
		final String GESTISCIABILRUOLOENT_OUTCOME_CODE__RUOLO_3RESPONSABILE = //NOSONAR  Reason:EIAS
				"RUOLO_3RESPONSABILE"; //NOSONAR  Reason:EIAS
		final String GESTISCIABILRUOLOENT_OUTCOME_CODE__RUOLO_PA_PROVINCIA = //NOSONAR  Reason:EIAS
				"RUOLO_PA_PROVINCIA"; //NOSONAR  Reason:EIAS
		final String GESTISCIABILRUOLOENT_OUTCOME_CODE__RUOLO_PA_COMUNE = //NOSONAR  Reason:EIAS
				"RUOLO_PA_COMUNE"; //NOSONAR  Reason:EIAS
		final String GESTISCIABILRUOLOENT_OUTCOME_CODE__RUOLO_ALTRO = //NOSONAR  Reason:EIAS
				"RUOLO_ALTRO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R1025927365) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			result = gestisciAbilRuoloRef(theModel, GESTISCIABILRUOLOENT_OUTCOME_CODE__RUOLO_PG,
					GESTISCIABILRUOLOENT_OUTCOME_CODE__RUOLO_RESPONSABILE,
					GESTISCIABILRUOLOENT_OUTCOME_CODE__RUOLO_3RESPONSABILE,
					GESTISCIABILRUOLOENT_OUTCOME_CODE__RUOLO_PA_PROVINCIA,
					GESTISCIABILRUOLOENT_OUTCOME_CODE__RUOLO_PA_COMUNE, GESTISCIABILRUOLOENT_OUTCOME_CODE__RUOLO_ALTRO,
					GESTISCIABILRUOLOENT_OUTCOME_CODE__RUOLO_PROPRIETARIO);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::gestisciAbilRuoloEnt] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo isVisualizzaBtnInserisciImpianto definito in un ExecCommand del
	 * ContentPanel cpRicImpianto
	 */
	public ExecResults isVisualizzaBtnInserisciImpianto(

			it.csi.sigit.sigitwebn.dto.ricerca_impianti.CpRicImpiantoModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String ISVISUALIZZABTNINSERISCIIMPIANTO_OUTCOME_CODE__VISUALIZZA = //NOSONAR  Reason:EIAS
				"VISUALIZZA"; //NOSONAR  Reason:EIAS
		final String ISVISUALIZZABTNINSERISCIIMPIANTO_OUTCOME_CODE__NASCONDI = //NOSONAR  Reason:EIAS
				"NASCONDI"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-1332582018) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			Ruolo ruoloUtLog = theModel.getAppDatautenteLoggato().getRuolo();
			if (ruoloUtLog.getDescRuolo().equalsIgnoreCase(Constants.RUOLO_IMPRESA)
					|| ruoloUtLog.getDescRuolo().equalsIgnoreCase(Constants.RUOLO_VALIDATORE)
					|| ruoloUtLog.getDescRuolo().equalsIgnoreCase(Constants.RUOLO_SUPER)
					|| ruoloUtLog.getDescRuolo().equalsIgnoreCase(Constants.RUOLO_ISPETTORE)) {
				// impostazione del result code 
				result.setResultCode(ISVISUALIZZABTNINSERISCIIMPIANTO_OUTCOME_CODE__VISUALIZZA);
			} else {
				// impostazione del result code 
				result.setResultCode(ISVISUALIZZABTNINSERISCIIMPIANTO_OUTCOME_CODE__NASCONDI);
			}

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error(
					"[BackEndFacade::isVisualizzaBtnInserisciImpianto] Errore occorso nell'esecuzione del metodo:" + e,
					e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo isVisualizzaBtnInserisciImpiantoResp definito in un ExecCommand del
	 * ContentPanel cpRicImpianto
	 */
	public ExecResults isVisualizzaBtnInserisciImpiantoResp(

			it.csi.sigit.sigitwebn.dto.ricerca_impianti.CpRicImpiantoModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String ISVISUALIZZABTNINSERISCIIMPIANTORESP_OUTCOME_CODE__VISUALIZZA = //NOSONAR  Reason:EIAS
				"VISUALIZZA"; //NOSONAR  Reason:EIAS
		final String ISVISUALIZZABTNINSERISCIIMPIANTORESP_OUTCOME_CODE__NASCONDI = //NOSONAR  Reason:EIAS
				"NASCONDI"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R375088782) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			Ruolo ruoloUtLog = theModel.getAppDatautenteLoggato().getRuolo();
			if (ruoloUtLog.getDescRuolo().equalsIgnoreCase(Constants.RUOLO_RESPONSABILE)
					|| ruoloUtLog.getDescRuolo().equalsIgnoreCase(Constants.RUOLO_RESPONSABILE_IMPRESA)) {
				// impostazione del result code
				result.setResultCode(ISVISUALIZZABTNINSERISCIIMPIANTORESP_OUTCOME_CODE__VISUALIZZA);
			} else {
				// impostazione del result code
				result.setResultCode(ISVISUALIZZABTNINSERISCIIMPIANTORESP_OUTCOME_CODE__NASCONDI);
			}

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::isVisualizzaBtnInserisciImpiantoResp] Errore occorso nell'esecuzione del metodo:"
					+ e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo gestisciComboStati definito in un ExecCommand del
	 * ContentPanel cpRicImpianto
	 */
	public ExecResults gestisciComboStati(

			it.csi.sigit.sigitwebn.dto.ricerca_impianti.CpRicImpiantoModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GESTISCICOMBOSTATI_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-909014466) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			// impostazione del result code 
			theModel.setAppDataelencoStatoImpianto(getDbMgr().cercaListaStatiImpianto());

			result.setResultCode(GESTISCICOMBOSTATI_OUTCOME_CODE__OK);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::gestisciComboStati] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo gestisciComboGeo definito in un ExecCommand del
	 * ContentPanel cpRicImpianto
	 */
	public ExecResults gestisciComboGeo(

			it.csi.sigit.sigitwebn.dto.ricerca_impianti.CpRicImpiantoModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GESTISCICOMBOGEO_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R290300610) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			gestisciComboDtCatasto(theModel);
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

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo gestisciLogicaResetVis definito in un ExecCommand del
	 * ContentPanel cpRicImpianto
	 */
	public ExecResults gestisciLogicaResetVis(

			it.csi.sigit.sigitwebn.dto.ricerca_impianti.CpRicImpiantoModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GESTISCILOGICARESETVIS_OUTCOME_CODE__SI = //NOSONAR  Reason:EIAS
				"SI"; //NOSONAR  Reason:EIAS
		final String GESTISCILOGICARESETVIS_OUTCOME_CODE__NO = //NOSONAR  Reason:EIAS
				"NO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-2050091183) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			if (theModel.getAppDataricercaImpianti() == null) {

				// impostazione del result code 
				result.setResultCode(GESTISCILOGICARESETVIS_OUTCOME_CODE__SI);
			} else {
				// impostazione del result code 
				result.setResultCode(GESTISCILOGICARESETVIS_OUTCOME_CODE__NO);
			}

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::gestisciLogicaResetVis] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo gestisciAbilRuoloRef definito in un ExecCommand del
	 * ContentPanel cpRicImpianto
	 */
	public ExecResults gestisciAbilRuoloRef(

			it.csi.sigit.sigitwebn.dto.ricerca_impianti.CpRicImpiantoModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GESTISCIABILRUOLOREF_OUTCOME_CODE__RUOLO_PG = //NOSONAR  Reason:EIAS
				"RUOLO_PG"; //NOSONAR  Reason:EIAS
		final String GESTISCIABILRUOLOREF_OUTCOME_CODE__RUOLO_RESPONSABILE = //NOSONAR  Reason:EIAS
				"RUOLO_RESPONSABILE"; //NOSONAR  Reason:EIAS
		final String GESTISCIABILRUOLOREF_OUTCOME_CODE__RUOLO_PROPRIETARIO = //NOSONAR  Reason:EIAS
				"RUOLO_PROPRIETARIO"; //NOSONAR  Reason:EIAS
		final String GESTISCIABILRUOLOREF_OUTCOME_CODE__RUOLO_3RESPONSABILE = //NOSONAR  Reason:EIAS
				"RUOLO_3RESPONSABILE"; //NOSONAR  Reason:EIAS
		final String GESTISCIABILRUOLOREF_OUTCOME_CODE__RUOLO_PA_PROVINCIA = //NOSONAR  Reason:EIAS
				"RUOLO_PA_PROVINCIA"; //NOSONAR  Reason:EIAS
		final String GESTISCIABILRUOLOREF_OUTCOME_CODE__RUOLO_PA_COMUNE = //NOSONAR  Reason:EIAS
				"RUOLO_PA_COMUNE"; //NOSONAR  Reason:EIAS
		final String GESTISCIABILRUOLOREF_OUTCOME_CODE__RUOLO_ALTRO = //NOSONAR  Reason:EIAS
				"RUOLO_ALTRO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-1885748707) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			result = gestisciAbilRuoloRef(theModel, GESTISCIABILRUOLOREF_OUTCOME_CODE__RUOLO_PG,
					GESTISCIABILRUOLOREF_OUTCOME_CODE__RUOLO_RESPONSABILE,
					GESTISCIABILRUOLOREF_OUTCOME_CODE__RUOLO_3RESPONSABILE,
					GESTISCIABILRUOLOREF_OUTCOME_CODE__RUOLO_PA_PROVINCIA,
					GESTISCIABILRUOLOREF_OUTCOME_CODE__RUOLO_PA_COMUNE, GESTISCIABILRUOLOREF_OUTCOME_CODE__RUOLO_ALTRO,
					GESTISCIABILRUOLOREF_OUTCOME_CODE__RUOLO_PROPRIETARIO);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::gestisciAbilRuoloRef] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	//////////////////////////////////////////////////////////////////////////////
	/// Metodi statici per il reset delle tabelle
	//////////////////////////////////////////////////////////////////////////////

	//////////////////////////////////////////////////////////////////////////////
	/// Property aggiuntive del bean
	//////////////////////////////////////////////////////////////////////////////
	/*PROTECTED REGION ID(R1158486279) ENABLED START*/
	//// inserire qui le property che si vogliono iniettare in questo bean (es. dao, proxy di pd, ...) 

	/*
	private HttpSession session;
	
	public HttpSession getSession() {
		return session;
	}
	
	public void setSession(HttpSession session) {
		this.session = session;
	}*/

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

	private DbMgr dbMgr;

	public DbMgr getDbMgr() {
		return dbMgr;
	}

	public void setDbMgr(DbMgr dbMgr) {
		this.dbMgr = dbMgr;
	}

	private void gestisciComboDtCatasto(CpRicImpiantoModel theModel) throws BEException {

		log.debug("[BackEndFacade::gestisciComboDtCatasto] BEGIN");

		try {
			RicercaImpianti imp = theModel.getAppDataricercaImpianti();
			ArrayList<CodeDescription> comuni = new ArrayList<CodeDescription>();

			if (imp != null) {
				String idProvSel = imp.getIdProvincia();

				log.debug("STAMPO idProvSel: " + idProvSel);

				if (GenericUtil.isNotNullOrEmpty(idProvSel)) {
					comuni = (ArrayList<CodeDescription>) getServiziMgr().getListaComuniByIstatProvincia(idProvSel);
				}
			}
			theModel.setAppDataelencoComuni(comuni);
		} catch (ServiceException e) {
			//throw new ManagerException(e, new Message(Messages.ERROR_SERVIZIO_NON_RAGGIUNGIBILE));
			throw new BEException("Errore in getComuni della provincia:" + e, e);

		} finally {
			log.debug("[BackEndFacade::gestisciComboDtCatasto] END");

		}
	}

	private ExecResults gestisciAbilRuoloRef(CpRicImpiantoModel theModel, String codRetPG, String codRetRESPONSABILE,
			String codRet3RESPONSABILE, String codRetRuoloPaProvincia, String codRetRuoloPaComune, String codRetAltro,
			String codRetPROPRIETARIO) throws ServiceException, BEException, ManagerException {
		ExecResults result = new ExecResults();

		UtenteLoggato utenteLog = theModel.getAppDatautenteLoggato();

		if (log.isDebugEnabled())
			GenericUtil.stampa(utenteLog, true, 2);

		RicercaImpianti ricImp = theModel.getAppDataricercaImpianti();

		if (ricImp == null) {
			ricImp = new RicercaImpianti();
			ricImp.setIdStatoImp(ConvertUtil.convertToString(Constants.ID_STATO_IMPIANTO_ATTIVO));
		}

		String descRuolo = utenteLog.getRuolo().getDescRuolo();

		String istatAbilitazione = utenteLog.getRuolo().getIstatAbilitazione();

		if (descRuolo.equals(Constants.RUOLO_IMPRESA)) {
			ricImp.setCfImpresa(utenteLog.getRuolo().getCodiceFiscale());
			ricImp.setIdSiglaRea(utenteLog.getRuolo().getSiglaRea());
			ricImp.setNumeroRea(ConvertUtil.convertToUDTPositiveInteger(utenteLog.getRuolo().getNumeroRea()));
			result.setResultCode(codRetPG);
		} else if (descRuolo.equals(Constants.RUOLO_RESPONSABILE)) {
			ricImp.setCfResponsabile(utenteLog.getCodiceFiscale());
			result.setResultCode(codRetRESPONSABILE);
		} else if (descRuolo.equals(Constants.RUOLO_PROPRIETARIO)) {
			ricImp.setCfProprietario(utenteLog.getCodiceFiscale());
			result.setResultCode(codRetPROPRIETARIO);
		} else if (descRuolo.equals(Constants.RUOLO_RESPONSABILE_IMPRESA)) {
			ricImp.setCfResponsabile(utenteLog.getRuolo().getCodiceFiscale());
			result.setResultCode(codRetRESPONSABILE);
		} else if (descRuolo.equals(Constants.RUOLO_PROPRIETARIO_IMPRESA)) {
			ricImp.setCfProprietario(utenteLog.getRuolo().getCodiceFiscale());
			result.setResultCode(codRetPROPRIETARIO);
		} else if (descRuolo.equals(Constants.RUOLO_3RESPONSABILE)) {
			ricImp.setCf3Responsabile(utenteLog.getRuolo().getCodiceFiscale());
			result.setResultCode(codRet3RESPONSABILE);
		} else if ((descRuolo.equals(Constants.RUOLO_CONSULTATORE) || descRuolo.equals(Constants.RUOLO_VALIDATORE)
				|| descRuolo.equals(Constants.RUOLO_ISPETTORE)) && istatAbilitazione.length() > 2) {

			ArrayList<CodeDescription> comuni = getSigitMgr().impostaProvinciaSuRicercaImpianti(ricImp,
					istatAbilitazione);
			theModel.setAppDataelencoComuni(comuni);

			result.setResultCode(codRetRuoloPaProvincia);

			if (istatAbilitazione.length() > 5) {
				getSigitMgr().impostaComuneSuRicercaImpianti(theModel.getAppDataelencoComuni(), ricImp,
						istatAbilitazione);

				result.setResultCode(codRetRuoloPaComune);
			}

		} else {
			result.setResultCode(codRetAltro);
		}

		theModel.setAppDataricercaImpianti(ricImp);

		return result;
	}

	protected Map session;

	public Map getSession() {
		return session;
	}

	public void setSession(Map session) {
		this.session = session;
	}

	/*PROTECTED REGION END*/
}
