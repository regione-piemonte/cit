package it.csi.sigit.sigitwebn.business.ricerca_impianti_graffatura;

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

/*PROTECTED REGION ID(R-1937756596) ENABLED START*/
import it.csi.sigit.sigitwebn.business.manager.DbMgr;
import it.csi.sigit.sigitwebn.business.manager.ServiziMgr;
import it.csi.sigit.sigitwebn.business.manager.SigitMgr;
import it.csi.sigit.sigitwebn.business.manager.ValidationMgr;
import it.csi.sigit.sigitwebn.business.manager.util.DbManagerException;
import it.csi.sigit.sigitwebn.business.manager.util.ManagerException;
import it.csi.sigit.sigitwebn.business.manager.util.ServiceException;
import it.csi.sigit.sigitwebn.dto.ricerca_impianti.CpRicImpiantoModel;
import it.csi.sigit.sigitwebn.dto.ricerca_impianti_graffatura.CpRicImpiantoGraffaturaModel;
/*PROTECTED REGION END*/

public class CPBECpRicImpiantoGraffatura {

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

	// ApplicationData: [impiantoApprofondito, scope:USER_SESSION]
	public static final String APPDATA_IMPIANTOAPPROFONDITO_CODE = "appDataimpiantoApprofondito";

	//////////////////////////////////////////////////////////////////////////////
	/// Metodi associati alla U.I.
	//////////////////////////////////////////////////////////////////////////////

	// nome del content panel associato al bean
	public static final String CPNAME = "cpRicImpiantoGraffatura";

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
	 * ContentPanel cpRicImpiantoGraffatura
	 */
	public ExecResults loadComuni(

			it.csi.sigit.sigitwebn.dto.ricerca_impianti_graffatura.CpRicImpiantoGraffaturaModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String LOADCOMUNI_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R694548986) ENABLED START*/
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
	 * Implementazione del metodo ricercaImpianto definito in un ExecCommand del
	 * ContentPanel cpRicImpiantoGraffatura
	 */
	public ExecResults ricercaImpianto(

			it.csi.sigit.sigitwebn.dto.ricerca_impianti_graffatura.CpRicImpiantoGraffaturaModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String RICERCAIMPIANTO_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String RICERCAIMPIANTO_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-48697651) ENABLED START*/
			try {
				RicercaImpianti ricImpianti = theModel.getAppDataricercaImpianti();

				// Risetto i dati di default, questo lo faccio per sicurezza, in modo che se qualcuno modifica via web i dati di default, qui vengono reimpostati
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
	 * Implementazione del metodo initRicercaImpianto definito in un ExecCommand del
	 * ContentPanel cpRicImpiantoGraffatura
	 */
	public ExecResults initRicercaImpianto(

			it.csi.sigit.sigitwebn.dto.ricerca_impianti_graffatura.CpRicImpiantoGraffaturaModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String INITRICERCAIMPIANTO_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-1668392579) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:
			theModel.setAppDataricercaImpianti(new RicercaImpianti());
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
	 * ContentPanel cpRicImpiantoGraffatura
	 */
	public ExecResults isRuoloAbilitato(

			it.csi.sigit.sigitwebn.dto.ricerca_impianti_graffatura.CpRicImpiantoGraffaturaModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String ISRUOLOABILITATO_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-1947654809) ENABLED START*/
			UtenteLoggato utenteLoggato = theModel.getAppDatautenteLoggato();

			if (GenericUtil.isRuoloAbilitatoAccessoImpianti(utenteLoggato)) {
				result.setResultCode(ISRUOLOABILITATO_OUTCOME_CODE__OK);
			} else {
				GenericUtil.redirectToNotAllowedPage();
			}
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
	 * Implementazione del metodo gestisciComboStati definito in un ExecCommand del
	 * ContentPanel cpRicImpiantoGraffatura
	 */
	public ExecResults gestisciComboStati(

			it.csi.sigit.sigitwebn.dto.ricerca_impianti_graffatura.CpRicImpiantoGraffaturaModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GESTISCICOMBOSTATI_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-1826265191) ENABLED START*/
			theModel.setAppDataelencoStatoImpianto(getDbMgr().cercaListaStatiImpianto());

			result.setResultCode(GESTISCICOMBOSTATI_OUTCOME_CODE__OK);

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
	 * ContentPanel cpRicImpiantoGraffatura
	 */
	public ExecResults gestisciComboGeo(

			it.csi.sigit.sigitwebn.dto.ricerca_impianti_graffatura.CpRicImpiantoGraffaturaModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GESTISCICOMBOGEO_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-1994450211) ENABLED START*/
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
	 * ContentPanel cpRicImpiantoGraffatura
	 */
	public ExecResults gestisciLogicaResetVis(

			it.csi.sigit.sigitwebn.dto.ricerca_impianti_graffatura.CpRicImpiantoGraffaturaModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GESTISCILOGICARESETVIS_OUTCOME_CODE__SI = //NOSONAR  Reason:EIAS
				"SI"; //NOSONAR  Reason:EIAS
		final String GESTISCILOGICARESETVIS_OUTCOME_CODE__NO = //NOSONAR  Reason:EIAS
				"NO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-1662136532) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:
			result.setResultCode(GESTISCILOGICARESETVIS_OUTCOME_CODE__SI);
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

	//////////////////////////////////////////////////////////////////////////////
	/// Metodi statici per il reset delle tabelle
	//////////////////////////////////////////////////////////////////////////////

	//////////////////////////////////////////////////////////////////////////////
	/// Property aggiuntive del bean
	//////////////////////////////////////////////////////////////////////////////
	/*PROTECTED REGION ID(R853488994) ENABLED START*/

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

	private void gestisciComboDtCatasto(CpRicImpiantoGraffaturaModel theModel) throws BEException {

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

	private ExecResults gestisciAbilRuoloRef(CpRicImpiantoGraffaturaModel theModel, String codRetPG,
			String codRetRESPONSABILE, String codRet3RESPONSABILE, String codRetRuoloPaProvincia,
			String codRetRuoloPaComune, String codRetAltro, String codRetPROPRIETARIO)
			throws ServiceException, BEException, ManagerException {
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
	//// inserire qui le property che si vogliono iniettare in questo bean (es. dao, proxy di pd, ...) 
	/*PROTECTED REGION END*/
}
