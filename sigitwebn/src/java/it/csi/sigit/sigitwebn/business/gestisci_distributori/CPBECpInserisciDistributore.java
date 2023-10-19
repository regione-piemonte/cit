package it.csi.sigit.sigitwebn.business.gestisci_distributori;

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

/*PROTECTED REGION ID(R32740879) ENABLED START*/
import it.csi.sigit.sigitwebn.business.manager.ServiziMgr;
import it.csi.sigit.sigitwebn.business.manager.SigitMgr;
import it.csi.sigit.sigitwebn.business.manager.DbMgr;
import it.csi.sigit.sigitwebn.business.manager.ValidationMgr;
import it.csi.sigit.sigitwebn.business.manager.util.ManagerException;
import it.csi.sigit.sigitwebn.business.manager.util.Message;
import it.csi.sigit.sigitwebn.business.manager.util.ServiceException;
import it.csi.sigit.sigitwebn.business.manager.util.ValidationManagerException;

/*PROTECTED REGION END*/

public class CPBECpInserisciDistributore {

	/**  */
	protected static final Logger log = //NOSONAR  Reason:EIAS 
			Logger.getLogger(Constants.APPLICATION_CODE + ".business"); //NOSONAR  Reason:EIAS

	//////////////////////////////////////////////////////////////////////////////
	/// Costanti identificative degli Application Data
	//////////////////////////////////////////////////////////////////////////////

	// ApplicationData: [dettaglioImportDistributori, scope:USER_SESSION]
	public static final String APPDATA_DETTAGLIOIMPORTDISTRIBUTORI_CODE = "appDatadettaglioImportDistributori";

	// ApplicationData: [distributori, scope:USER_SESSION]
	public static final String APPDATA_DISTRIBUTORI_CODE = "appDatadistributori";

	// ApplicationData: [elencoErroriImport, scope:USER_SESSION]
	public static final String APPDATA_ELENCOERRORIIMPORT_CODE = "appDataelencoErroriImport";

	// ApplicationData: [elencoImportDistributori, scope:USER_SESSION]
	public static final String APPDATA_ELENCOIMPORTDISTRIBUTORI_CODE = "appDataelencoImportDistributori";

	// ApplicationData: [idFileInviatoSelez, scope:USER_SESSION]
	public static final String APPDATA_IDFILEINVIATOSELEZ_CODE = "appDataidFileInviatoSelez";

	// ApplicationData: [elencoSiglaRea, scope:USER_SESSION]
	public static final String APPDATA_ELENCOSIGLAREA_CODE = "appDataelencoSiglaRea";

	// ApplicationData: [utenteLoggato, scope:USER_SESSION]
	public static final String APPDATA_UTENTELOGGATO_CODE = "appDatautenteLoggato";

	// ApplicationData: [elencoTipoContrattoDistrib, scope:USER_SESSION]
	public static final String APPDATA_ELENCOTIPOCONTRATTODISTRIB_CODE = "appDataelencoTipoContrattoDistrib";

	// ApplicationData: [distributoreManuale, scope:USER_SESSION]
	public static final String APPDATA_DISTRIBUTOREMANUALE_CODE = "appDatadistributoreManuale";

	// ApplicationData: [elencoIndirizziFornitura, scope:USER_SESSION]
	public static final String APPDATA_ELENCOINDIRIZZIFORNITURA_CODE = "appDataelencoIndirizziFornitura";

	// ApplicationData: [elencoIndirizziFatturazione, scope:USER_SESSION]
	public static final String APPDATA_ELENCOINDIRIZZIFATTURAZIONE_CODE = "appDataelencoIndirizziFatturazione";

	// ApplicationData: [elencoTipoCategoria, scope:USER_SESSION]
	public static final String APPDATA_ELENCOTIPOCATEGORIA_CODE = "appDataelencoTipoCategoria";

	// ApplicationData: [elencoTipoCombustibile, scope:USER_SESSION]
	public static final String APPDATA_ELENCOTIPOCOMBUSTIBILE_CODE = "appDataelencoTipoCombustibile";

	// ApplicationData: [elencoUnitaMisura, scope:USER_SESSION]
	public static final String APPDATA_ELENCOUNITAMISURA_CODE = "appDataelencoUnitaMisura";

	// ApplicationData: [elencoProvince, scope:USER_SESSION]
	public static final String APPDATA_ELENCOPROVINCE_CODE = "appDataelencoProvince";

	// ApplicationData: [elencoComuni, scope:USER_SESSION]
	public static final String APPDATA_ELENCOCOMUNI_CODE = "appDataelencoComuni";

	// ApplicationData: [elencoComuniFatturazione, scope:USER_SESSION]
	public static final String APPDATA_ELENCOCOMUNIFATTURAZIONE_CODE = "appDataelencoComuniFatturazione";

	//////////////////////////////////////////////////////////////////////////////
	/// Metodi associati alla U.I.
	//////////////////////////////////////////////////////////////////////////////

	// nome del content panel associato al bean
	public static final String CPNAME = "cpInserisciDistributore";

	public static final String MULTIPANEL_MPFATTURAZIONE = "mpFatturazione";
	public static final String MPI_MPFATTURAZIONE_FPFATTURAZIONE = CPNAME + "_" + MULTIPANEL_MPFATTURAZIONE + "_"
			+ "fpFatturazione";

	/** 
	 * Restituisce il tab correntemente visibile in un determinato tab set
	 */
	private String getCurrentTab(Map session, String tabSetName) {
		String value = (String) session.get(CPNAME + "_" + tabSetName + "_selectedMultiPanel");
		return value;
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo loadComuniFornitura definito in un ExecCommand del
	 * ContentPanel cpInserisciDistributore
	 */
	public ExecResults loadComuniFornitura(

			it.csi.sigit.sigitwebn.dto.gestisci_distributori.CpInserisciDistributoreModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String LOADCOMUNIFORNITURA_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-1496205747) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			recuperaComuniFornitura(theModel);

			// impostazione del result code 
			result.setResultCode(LOADCOMUNIFORNITURA_OUTCOME_CODE__OK);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::loadComuniFornitura] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo cercaIndirizzoFornitura definito in un ExecCommand del
	 * ContentPanel cpInserisciDistributore
	 */
	public ExecResults cercaIndirizzoFornitura(

			it.csi.sigit.sigitwebn.dto.gestisci_distributori.CpInserisciDistributoreModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String CERCAINDIRIZZOFORNITURA_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String CERCAINDIRIZZOFORNITURA_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R743257880) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			try {
				DistributoreMan distributoreMan = theModel.getAppDatadistributoreManuale();

				getValidationMgr().verificaRicercaIndirizzoDistributoreFornitura(distributoreMan);

				theModel.setAppDataelencoIndirizziFornitura(getServiziMgr()
						.getListaVieValide(distributoreMan.getIndirizzoForn(), distributoreMan.getIdComuneForn()));

				//impianto.getLogicaVisual().setIsImpiantoIndConfermato(true);

				// impostazione del result code 
				result.setResultCode(CERCAINDIRIZZOFORNITURA_OUTCOME_CODE__OK);

			} catch (ManagerException ex) {
				log.debug("\n\n\n##################### INTERCETTO L'eccezione");
				Validator.gestisciEccezione(result, ex);

			}

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::cercaIndirizzoFornitura] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo nuovaRicercaIndirizzoForn definito in un ExecCommand del
	 * ContentPanel cpInserisciDistributore
	 */
	public ExecResults nuovaRicercaIndirizzoForn(

			it.csi.sigit.sigitwebn.dto.gestisci_distributori.CpInserisciDistributoreModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String NUOVARICERCAINDIRIZZOFORN_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R1569690013) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			DistributoreMan distributoreMan = theModel.getAppDatadistributoreManuale();

			distributoreMan.setIndirizzoForn(null);
			distributoreMan.setIndirizzoNoStradForn(null);

			// impostazione del result code 
			result.setResultCode(NUOVARICERCAINDIRIZZOFORN_OUTCOME_CODE__OK);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::nuovaRicercaIndirizzoForn] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo gestIndirizzoFatturazione definito in un ExecCommand del
	 * ContentPanel cpInserisciDistributore
	 */
	public ExecResults gestIndirizzoFatturazione(

			it.csi.sigit.sigitwebn.dto.gestisci_distributori.CpInserisciDistributoreModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GESTINDIRIZZOFATTURAZIONE_OUTCOME_CODE__VISUALIZZA = //NOSONAR  Reason:EIAS
				"VISUALIZZA"; //NOSONAR  Reason:EIAS
		final String GESTINDIRIZZOFATTURAZIONE_OUTCOME_CODE__NASCONDI = //NOSONAR  Reason:EIAS
				"NASCONDI"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R1300054383) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			DistributoreMan distributoreMan = theModel.getAppDatadistributoreManuale();

			if (distributoreMan != null
					&& ConvertUtil.convertToBooleanAllways(distributoreMan.getFlgFatturazioneUguale())) {

				// pulisco i campi
				distributoreMan.setFlgImpresaFatt(null);
				distributoreMan.setCognomeFatt(null);
				distributoreMan.setNomeFatt(null);
				distributoreMan.setCfPivaFatt(null);
				distributoreMan.setIdProvinciaFatt(null);
				distributoreMan.setIdComuneFatt(null);
				distributoreMan.setIndirizzoFatt(null);
				distributoreMan.setIdIndirizzoFatt(null);
				distributoreMan.setIndirizzoNoStradFatt(null);
				distributoreMan.setIndirizzoCivicoFatt(null);
				distributoreMan.setIndirizzoCapFatt(null);

				theModel.setAppDataelencoComuniFatturazione(new ArrayList<CodeDescription>());

				// impostazione del result code 
				result.setResultCode(GESTINDIRIZZOFATTURAZIONE_OUTCOME_CODE__NASCONDI);

			} else {
				// impostazione del result code 
				result.setResultCode(GESTINDIRIZZOFATTURAZIONE_OUTCOME_CODE__VISUALIZZA);
			}

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::gestIndirizzoFatturazione] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo gestIndirizzoFatturazioneEstero definito in un ExecCommand del
	 * ContentPanel cpInserisciDistributore
	 */
	public ExecResults gestIndirizzoFatturazioneEstero(

			it.csi.sigit.sigitwebn.dto.gestisci_distributori.CpInserisciDistributoreModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GESTINDIRIZZOFATTURAZIONEESTERO_OUTCOME_CODE__ITALIANO = //NOSONAR  Reason:EIAS
				"ITALIANO"; //NOSONAR  Reason:EIAS
		final String GESTINDIRIZZOFATTURAZIONEESTERO_OUTCOME_CODE__ESTERO = //NOSONAR  Reason:EIAS
				"ESTERO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-978007437) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			DistributoreMan distributoreMan = theModel.getAppDatadistributoreManuale();

			if (distributoreMan != null
					&& ConvertUtil.convertToBooleanAllways(distributoreMan.getFlgIndirizzoFattEstero())) {

				// pulisco i campi
				distributoreMan.setIdProvinciaFatt(null);
				distributoreMan.setIdComuneFatt(null);
				distributoreMan.setIndirizzoFatt(null);
				distributoreMan.setIdIndirizzoFatt(null);
				distributoreMan.setIndirizzoNoStradFatt(null);

				result.setResultCode(GESTINDIRIZZOFATTURAZIONEESTERO_OUTCOME_CODE__ESTERO);

			} else {
				distributoreMan.setIndirizzoNoStradFatt(null);

				result.setResultCode(GESTINDIRIZZOFATTURAZIONEESTERO_OUTCOME_CODE__ITALIANO);

			}

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::gestIndirizzoFatturazioneEstero] Errore occorso nell'esecuzione del metodo:" + e,
					e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo loadComuniFatturazione definito in un ExecCommand del
	 * ContentPanel cpInserisciDistributore
	 */
	public ExecResults loadComuniFatturazione(

			it.csi.sigit.sigitwebn.dto.gestisci_distributori.CpInserisciDistributoreModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String LOADCOMUNIFATTURAZIONE_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R189806153) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			recuperaComuniFatturazione(theModel);

			// impostazione del result code 
			result.setResultCode(LOADCOMUNIFATTURAZIONE_OUTCOME_CODE__OK);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::loadComuniFatturazione] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo cercaIndirizzoFatturazione definito in un ExecCommand del
	 * ContentPanel cpInserisciDistributore
	 */
	public ExecResults cercaIndirizzoFatturazione(

			it.csi.sigit.sigitwebn.dto.gestisci_distributori.CpInserisciDistributoreModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String CERCAINDIRIZZOFATTURAZIONE_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String CERCAINDIRIZZOFATTURAZIONE_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-1971257954) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			try {
				DistributoreMan distributoreMan = theModel.getAppDatadistributoreManuale();

				getValidationMgr().verificaRicercaIndirizzoDistributoreFatturazione(distributoreMan);

				theModel.setAppDataelencoIndirizziFatturazione(getServiziMgr()
						.getListaVieValide(distributoreMan.getIndirizzoFatt(), distributoreMan.getIdComuneFatt()));

				//impianto.getLogicaVisual().setIsImpiantoIndConfermato(true);

				// impostazione del result code 
				result.setResultCode(CERCAINDIRIZZOFATTURAZIONE_OUTCOME_CODE__OK);

			} catch (ManagerException ex) {
				log.debug("\n\n\n##################### INTERCETTO L'eccezione");
				Validator.gestisciEccezione(result, ex);

			}

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::cercaIndirizzoFatturazione] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo nuovaRicercaIndirizzoFatt definito in un ExecCommand del
	 * ContentPanel cpInserisciDistributore
	 */
	public ExecResults nuovaRicercaIndirizzoFatt(

			it.csi.sigit.sigitwebn.dto.gestisci_distributori.CpInserisciDistributoreModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String NUOVARICERCAINDIRIZZOFATT_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R591964071) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			DistributoreMan distributoreMan = theModel.getAppDatadistributoreManuale();

			distributoreMan.setIndirizzoFatt(null);
			distributoreMan.setIndirizzoNoStradFatt(null);

			// impostazione del result code 
			result.setResultCode(NUOVARICERCAINDIRIZZOFATT_OUTCOME_CODE__OK);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::nuovaRicercaIndirizzoFatt] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo salvaDistributoreManuale definito in un ExecCommand del
	 * ContentPanel cpInserisciDistributore
	 */
	public ExecResults salvaDistributoreManuale(

			it.csi.sigit.sigitwebn.dto.gestisci_distributori.CpInserisciDistributoreModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String SALVADISTRIBUTOREMANUALE_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String SALVADISTRIBUTOREMANUALE_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R1725142900) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			try {
				Distributore distributore = theModel.getAppDatadistributori();

				DistributoreMan distributoreMan = theModel.getAppDatadistributoreManuale();

				log.debug("isDebugEnabled: " + log.isDebugEnabled());

				if (log.isDebugEnabled())
					GenericUtil.stampa(distributoreMan, true, 3);

				getValidationMgr().validazioneFormaleSalvaDistributore(distributoreMan);

				getDbMgr().salvaDistributoreManuale(distributoreMan, distributore,
						theModel.getAppDataelencoIndirizziFornitura(), theModel.getAppDataelencoIndirizziFatturazione(),
						theModel.getAppDatautenteLoggato().getCodiceFiscale());

				theModel.getSession().put(Constants.SESSIONE_VAR_MESSAGGE,
						new Message(Messages.INFO_SALVATAGGIO_CORRETTO, Message.INFO));

				// impostazione del result code 
				result.setResultCode(SALVADISTRIBUTOREMANUALE_OUTCOME_CODE__OK);

				// modifica degli attributi del model (che verranno propagati allo strato
				// di presentation). si puo' agire anche direttamente sull'attributo "session".
			} catch (ManagerException ex) {

				Validator.gestisciEccezione(result, ex);

			}
			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::salvaDistributoreManuale] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo isRuoloAbilitato definito in un ExecCommand del
	 * ContentPanel cpInserisciDistributore
	 */
	public ExecResults isRuoloAbilitato(

			it.csi.sigit.sigitwebn.dto.gestisci_distributori.CpInserisciDistributoreModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String ISRUOLOABILITATO_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-1535713468) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			UtenteLoggato utente = theModel.getAppDatautenteLoggato();

			String descrizioneRuolo = utente.getRuolo().getDescRuolo();

			if (descrizioneRuolo.equals(Constants.RUOLO_SUPER)
					|| descrizioneRuolo.equals(Constants.RUOLO_DISTRIBUTORE)) {
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
	 * Implementazione del metodo gestCombobox definito in un ExecCommand del
	 * ContentPanel cpInserisciDistributore
	 */
	public ExecResults gestCombobox(

			it.csi.sigit.sigitwebn.dto.gestisci_distributori.CpInserisciDistributoreModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GESTCOMBOBOX_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-1952631824) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			if (theModel.getAppDataelencoTipoContrattoDistrib() == null
					|| theModel.getAppDataelencoTipoContrattoDistrib().isEmpty()) {
				theModel.setAppDataelencoTipoContrattoDistrib(getSigitMgr().getListTipoContrattoDistrib());
			}

			if (theModel.getAppDataelencoTipoCategoria() == null
					|| theModel.getAppDataelencoTipoCategoria().isEmpty()) {
				theModel.setAppDataelencoTipoCategoria(getSigitMgr().getListCategoriaUtil());
			}

			if (theModel.getAppDataelencoTipoCombustibile() == null
					|| theModel.getAppDataelencoTipoCombustibile().isEmpty()) {
				theModel.setAppDataelencoTipoCombustibile(getSigitMgr().cercaElencoCombustibili());
			}

			if (theModel.getAppDataelencoUnitaMisura() == null || theModel.getAppDataelencoUnitaMisura().isEmpty()) {
				theModel.setAppDataelencoUnitaMisura(getSigitMgr().getListUnitaMisura());
			}

			ArrayList<CodeDescription> comuniVuoti = new ArrayList<CodeDescription>();

			theModel.setAppDataelencoComuni(comuniVuoti);

			theModel.setAppDataelencoComuniFatturazione(comuniVuoti);

			// impostazione del result code 
			result.setResultCode(GESTCOMBOBOX_OUTCOME_CODE__OK);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::gestCombobox] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo isInserimentoDistributore definito in un ExecCommand del
	 * ContentPanel cpInserisciDistributore
	 */
	public ExecResults isInserimentoDistributore(

			it.csi.sigit.sigitwebn.dto.gestisci_distributori.CpInserisciDistributoreModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String ISINSERIMENTODISTRIBUTORE_OUTCOME_CODE__INSERIMENTO = //NOSONAR  Reason:EIAS
				"INSERIMENTO"; //NOSONAR  Reason:EIAS
		final String ISINSERIMENTODISTRIBUTORE_OUTCOME_CODE__DETTAGLIO_CARICAMENTO_MANUALE = //NOSONAR  Reason:EIAS
				"DETTAGLIO_CARICAMENTO_MANUALE"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-1458537003) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			if (theModel.getAppDatadistributoreManuale() != null) {
				recuperaComuniFornitura(theModel);
				if (!ConvertUtil
						.convertToBooleanAllways(theModel.getAppDatadistributoreManuale().getFlgFatturazioneUguale())
						&& theModel.getAppDatadistributoreManuale().getIdProvinciaFatt() != null) {
					recuperaComuniFatturazione(theModel);
				}
				result.setResultCode(ISINSERIMENTODISTRIBUTORE_OUTCOME_CODE__DETTAGLIO_CARICAMENTO_MANUALE);
			} else {
				result.setResultCode(ISINSERIMENTODISTRIBUTORE_OUTCOME_CODE__INSERIMENTO);
			}

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::isInserimentoDistributore] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo gestInserimentoDistributore definito in un ExecCommand del
	 * ContentPanel cpInserisciDistributore
	 */
	public ExecResults gestInserimentoDistributore(

			it.csi.sigit.sigitwebn.dto.gestisci_distributori.CpInserisciDistributoreModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GESTINSERIMENTODISTRIBUTORE_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-1877521686) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			// Pulisco i campi
			theModel.setAppDatadistributoreManuale(new DistributoreMan());

			// impostazione del result code 
			result.setResultCode(GESTINSERIMENTODISTRIBUTORE_OUTCOME_CODE__OK);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::gestInserimentoDistributore] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo mostraFatturazioneDettaglioCaricamentoManuale definito in un ExecCommand del
	 * ContentPanel cpInserisciDistributore
	 */
	public ExecResults mostraFatturazioneDettaglioCaricamentoManuale(

			it.csi.sigit.sigitwebn.dto.gestisci_distributori.CpInserisciDistributoreModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String MOSTRAFATTURAZIONEDETTAGLIOCARICAMENTOMANUALE_OUTCOME_CODE__MOSTRA = //NOSONAR  Reason:EIAS
				"MOSTRA"; //NOSONAR  Reason:EIAS
		final String MOSTRAFATTURAZIONEDETTAGLIOCARICAMENTOMANUALE_OUTCOME_CODE__NASCONDI = //NOSONAR  Reason:EIAS
				"NASCONDI"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R1556905216) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			if (ConvertUtil
					.convertToBooleanAllways(theModel.getAppDatadistributoreManuale().getFlgFatturazioneUguale())) {
				result.setResultCode(MOSTRAFATTURAZIONEDETTAGLIOCARICAMENTOMANUALE_OUTCOME_CODE__NASCONDI);
			} else {
				result.setResultCode(MOSTRAFATTURAZIONEDETTAGLIOCARICAMENTOMANUALE_OUTCOME_CODE__MOSTRA);
			}

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error(
					"[BackEndFacade::mostraFatturazioneDettaglioCaricamentoManuale] Errore occorso nell'esecuzione del metodo:"
							+ e,
					e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	//////////////////////////////////////////////////////////////////////////////
	/// Metodi statici per il reset delle tabelle
	//////////////////////////////////////////////////////////////////////////////

	//////////////////////////////////////////////////////////////////////////////
	/// Property aggiuntive del bean
	//////////////////////////////////////////////////////////////////////////////
	/*PROTECTED REGION ID(R330764991) ENABLED START*/
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

	private ArrayList<CodeDescription> recuperaComuni(String idProvSel) throws ServiceException {

		ArrayList<CodeDescription> comuniLoc = new ArrayList<CodeDescription>();

		if (GenericUtil.isNotNullOrEmpty(idProvSel)) {

			// Localizzazione COMUNE 
			log.debug("STAMPO idProvSelLoc: " + idProvSel);

			comuniLoc = (ArrayList<CodeDescription>) getServiziMgr().getListaComuniByIstatProvincia(idProvSel);

		}

		return comuniLoc;
	}

	private void recuperaComuniFornitura(
			it.csi.sigit.sigitwebn.dto.gestisci_distributori.CpInserisciDistributoreModel theModel)
			throws ServiceException {
		ArrayList<CodeDescription> comuniLoc = recuperaComuni(
				theModel.getAppDatadistributoreManuale().getIdProvinciaForn());

		theModel.setAppDataelencoComuni(comuniLoc);
	}

	private void recuperaComuniFatturazione(
			it.csi.sigit.sigitwebn.dto.gestisci_distributori.CpInserisciDistributoreModel theModel)
			throws ServiceException {
		ArrayList<CodeDescription> comuniLoc = recuperaComuni(
				theModel.getAppDatadistributoreManuale().getIdProvinciaFatt());

		theModel.setAppDataelencoComuniFatturazione(comuniLoc);
	}

	/*PROTECTED REGION END*/
}
