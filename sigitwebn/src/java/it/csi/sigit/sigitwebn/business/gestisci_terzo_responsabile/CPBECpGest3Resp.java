package it.csi.sigit.sigitwebn.business.gestisci_terzo_responsabile;

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

/*PROTECTED REGION ID(R-307874540) ENABLED START*/
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.SigitTLibrettoDto;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.SigitVAllegatiComponentiDto;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.SigitVRicerca3ResponsabileByFkPgPfRowDto;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.SigitVRicerca3ResponsabileDto;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.SigitVTotImpiantoDto;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.filter.ContrattoFilter;
import it.csi.sigit.sigitwebn.business.manager.ConnectorMgr;
import it.csi.sigit.sigitwebn.business.manager.DbMgr;
import it.csi.sigit.sigitwebn.business.manager.ServiziMgr;
import it.csi.sigit.sigitwebn.business.manager.SigitMgr;
import it.csi.sigit.sigitwebn.business.manager.ValidationMgr;
import it.csi.sigit.sigitwebn.business.manager.util.DbManagerException;
import it.csi.sigit.sigitwebn.business.manager.util.ManagerException;
import it.csi.sigit.sigitwebn.business.manager.util.Message;
import it.csi.sigit.sigitwebn.business.manager.util.ValidationManagerException;

/*PROTECTED REGION END*/

public class CPBECpGest3Resp {

	/**  */
	protected static final Logger log = //NOSONAR  Reason:EIAS 
			Logger.getLogger(Constants.APPLICATION_CODE + ".business"); //NOSONAR  Reason:EIAS

	//////////////////////////////////////////////////////////////////////////////
	/// Costanti identificative degli Application Data
	//////////////////////////////////////////////////////////////////////////////

	// ApplicationData: [elencoSiglaRea, scope:USER_SESSION]
	public static final String APPDATA_ELENCOSIGLAREA_CODE = "appDataelencoSiglaRea";

	// ApplicationData: [elencoComuni, scope:USER_SESSION]
	public static final String APPDATA_ELENCOCOMUNI_CODE = "appDataelencoComuni";

	// ApplicationData: [elencoProvincePiemonte, scope:USER_SESSION]
	public static final String APPDATA_ELENCOPROVINCEPIEMONTE_CODE = "appDataelencoProvincePiemonte";

	// ApplicationData: [utenteLoggato, scope:USER_SESSION]
	public static final String APPDATA_UTENTELOGGATO_CODE = "appDatautenteLoggato";

	// ApplicationData: [impianto, scope:USER_SESSION]
	public static final String APPDATA_IMPIANTO_CODE = "appDataimpianto";

	// ApplicationData: [elencoIndirizzi3Resp, scope:USER_SESSION]
	public static final String APPDATA_ELENCOINDIRIZZI3RESP_CODE = "appDataelencoIndirizzi3Resp";

	// ApplicationData: [terzoResponsabile, scope:USER_SESSION]
	public static final String APPDATA_TERZORESPONSABILE_CODE = "appDataterzoResponsabile";

	// ApplicationData: [elencoResponsabiliImpianto, scope:USER_SESSION]
	public static final String APPDATA_ELENCORESPONSABILIIMPIANTO_CODE = "appDataelencoResponsabiliImpianto";

	// ApplicationData: [messaggioDinamico, scope:USER_SESSION]
	public static final String APPDATA_MESSAGGIODINAMICO_CODE = "appDatamessaggioDinamico";

	// ApplicationData: [elencoApp3Responsabile, scope:USER_SESSION]
	public static final String APPDATA_ELENCOAPP3RESPONSABILE_CODE = "appDataelencoApp3Responsabile";

	// ApplicationData: [dettaglioTerzoResponsabile, scope:USER_SESSION]
	public static final String APPDATA_DETTAGLIOTERZORESPONSABILE_CODE = "appDatadettaglioTerzoResponsabile";

	// ApplicationData: [paginaChiamante, scope:USER_SESSION]
	public static final String APPDATA_PAGINACHIAMANTE_CODE = "appDatapaginaChiamante";

	//////////////////////////////////////////////////////////////////////////////
	/// Metodi associati alla U.I.
	//////////////////////////////////////////////////////////////////////////////

	// nome del content panel associato al bean
	public static final String CPNAME = "cpGest3Resp";

	public static final String MULTIPANEL_MPRESPONSABILIIMP = "mpResponsabiliImp";
	public static final String MPI_MPRESPONSABILIIMP_FPRESPIMP2 = CPNAME + "_" + MULTIPANEL_MPRESPONSABILIIMP + "_"
			+ "fpRespImp2";

	/** 
	 * Restituisce il tab correntemente visibile in un determinato tab set
	 */
	private String getCurrentTab(Map session, String tabSetName) {
		String value = (String) session.get(CPNAME + "_" + tabSetName + "_selectedMultiPanel");
		return value;
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo cercaInstallatore definito in un ExecCommand del
	 * ContentPanel cpGest3Resp
	 */
	public ExecResults cercaInstallatore(

			it.csi.sigit.sigitwebn.dto.gestisci_terzo_responsabile.CpGest3RespModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String CERCAINSTALLATORE_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String CERCAINSTALLATORE_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R2117824047) ENABLED START*/

			try {
				TerzoResponsabile responsabile = theModel.getAppDataterzoResponsabile();

				if (log.isDebugEnabled())
					GenericUtil.stampa(responsabile, false, 2);

				getValidationMgr().verificaManutentore(responsabile.getRespImpCf(), responsabile.getRespImpIdSiglaRea(),
						responsabile.getRespImpNumeroRea(), ConstantsField.GESTISCI_3_RESPONSABILE_RESP_IMP_CF,
						ConstantsField.GESTISCI_3_RESPONSABILE_RESP_IMP_SIGLA_REA,
						ConstantsField.GESTISCI_3_RESPONSABILE_RESP_IMP_NUM_REA);

				PersonaGiuridica installatore = getSigitMgr().cercaPersonaGiuridica(responsabile.getRespImpCf(),
						responsabile.getRespImpIdSiglaRea(), responsabile.getRespImpNumeroRea(), false);

				if (installatore != null) {
					if (!installatore.getFlgTerzoResponsabile()) {
						result.setResultCode(CERCAINSTALLATORE_OUTCOME_CODE__KO);
						result.getGlobalErrors().add(Messages.S084);
					} else {
						responsabile.setRespImpCf(installatore.getCodiceFiscale());
						responsabile.setRespImpIdSiglaRea(installatore.getSiglaRea());
						responsabile.setRespImpNumeroRea(installatore.getNumeroRea());
						responsabile.setRespImpImpresa(installatore.getDenominazione());
						responsabile.setRespImpId(installatore.getIdPersonaGiuridica());

						log.debug("STAMPO L'iD IMPRESA: " + responsabile.getRespImpId());
						result.setResultCode(CERCAINSTALLATORE_OUTCOME_CODE__OK);
					}
				} else {
					result.setResultCode(CERCAINSTALLATORE_OUTCOME_CODE__KO);
					result.getGlobalErrors().add(Messages.I003);
				}
			} catch (ManagerException ex) {
				Validator.gestisciEccezione(result, ex);
			}

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::cercaInstallatore] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo nuovaRicercaInstallatore definito in un ExecCommand del
	 * ContentPanel cpGest3Resp
	 */
	public ExecResults nuovaRicercaInstallatore(

			it.csi.sigit.sigitwebn.dto.gestisci_terzo_responsabile.CpGest3RespModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String NUOVARICERCAINSTALLATORE_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String NUOVARICERCAINSTALLATORE_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-1625362737) ENABLED START*/
			theModel.getAppDataterzoResponsabile().setRespImpId(null);
			theModel.getAppDataterzoResponsabile().setRespImpCf(null);
			theModel.getAppDataterzoResponsabile().setRespImpIdSiglaRea(null);
			theModel.getAppDataterzoResponsabile().setRespImpImpresa(null);
			theModel.getAppDataterzoResponsabile().setRespImpNumeroRea(null);

			result.setResultCode(NUOVARICERCAINSTALLATORE_OUTCOME_CODE__OK);
			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::nuovaRicercaInstallatore] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo loadComuniImp definito in un ExecCommand del
	 * ContentPanel cpGest3Resp
	 */
	public ExecResults loadComuniImp(

			it.csi.sigit.sigitwebn.dto.gestisci_terzo_responsabile.CpGest3RespModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String LOADCOMUNIIMP_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-136658054) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:
			ArrayList<CodeDescription> comuniLoc = new ArrayList<CodeDescription>();

			if (GenericUtil.isNotNullOrEmpty(theModel.getAppDataterzoResponsabile().getImpLocIdProvincia())) {
				comuniLoc = getServiziMgr()
						.getListaComuniByIstatProvincia(theModel.getAppDataterzoResponsabile().getImpLocIdProvincia());
			}

			//			ArrayList<CodeDescription> comuniLoc = recuperaComuni(theModel
			//					.getAppDataterzoResponsabile().getImpLocIdProvincia());

			theModel.setAppDataelencoComuni(comuniLoc);
			// impostazione del result code 
			result.setResultCode(LOADCOMUNIIMP_OUTCOME_CODE__OK);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::loadComuniImp] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo cercaIndirizzoImp definito in un ExecCommand del
	 * ContentPanel cpGest3Resp
	 */
	public ExecResults cercaIndirizzoImp(

			it.csi.sigit.sigitwebn.dto.gestisci_terzo_responsabile.CpGest3RespModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String CERCAINDIRIZZOIMP_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String CERCAINDIRIZZOIMP_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-22532603) ENABLED START*/

			try {
				TerzoResponsabile responsabile = theModel.getAppDataterzoResponsabile();

				getValidationMgr().verificaRicercaIndirizzo3Responsabile(responsabile);

				theModel.setAppDataelencoIndirizzi3Resp(getServiziMgr()
						.getListaVieValide(responsabile.getImpLocIndirizzo(), responsabile.getImpLocIdComune()));

				log.debug("IsImpLocIndConfermato - cercaIndirizzoImp: "
						+ theModel.getAppDataterzoResponsabile().getIsImpLocIndConfermato());

				responsabile.setIsImpLocIndConfermato(true);
				result.setResultCode(CERCAINDIRIZZOIMP_OUTCOME_CODE__OK);

			} catch (ManagerException ex) {
				Validator.gestisciEccezione(result, ex);
			}

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::cercaIndirizzoImp] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo nuovaRicercaIndirizzoImp definito in un ExecCommand del
	 * ContentPanel cpGest3Resp
	 */
	public ExecResults nuovaRicercaIndirizzoImp(

			it.csi.sigit.sigitwebn.dto.gestisci_terzo_responsabile.CpGest3RespModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String NUOVARICERCAINDIRIZZOIMP_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R529247909) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			//theModel.getAppDataterzoResponsabile().setIsImpLocIndConfermato(false);

			theModel.getAppDataterzoResponsabile().setImpLocIdIndirizzo(null);
			theModel.getAppDataterzoResponsabile().setImpLocIndirizzoNoStrad(null);
			theModel.getAppDataterzoResponsabile().setImpLocDesIndirizzo(null);
			theModel.getAppDataterzoResponsabile().setImpLocDesComune(null);

			// impostazione del result code 
			result.setResultCode(NUOVARICERCAINDIRIZZOIMP_OUTCOME_CODE__OK);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::nuovaRicercaIndirizzoImp] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo verificaImpianto definito in un ExecCommand del
	 * ContentPanel cpGest3Resp
	 */
	public ExecResults verificaImpianto(

			it.csi.sigit.sigitwebn.dto.gestisci_terzo_responsabile.CpGest3RespModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String VERIFICAIMPIANTO_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String VERIFICAIMPIANTO_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R238463995) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			try {
				TerzoResponsabile responsabile = theModel.getAppDataterzoResponsabile();

				if (!responsabile.getImpLocIdIndirizzo().equals(Constants.DATO_NON_DISPONIBILE_S) 
						&& responsabile.getImpLocIndirizzoSitad() == null) {
					ArrayList<CodeDescription> elencoIndirizzi = theModel.getAppDataelencoIndirizzi3Resp();
					for (CodeDescription indirizzo : elencoIndirizzi) {
						if (indirizzo.getCode().equals(responsabile.getImpLocIdIndirizzo())) {
							responsabile.setImpLocIndirizzoSitad(indirizzo.getDescription());
							break;
						}
					}
				}
				
				String msgOK = getValidationMgr().verificaImpianto3Responsabile(responsabile,
						theModel.getAppDatautenteLoggato().getRuolo().getDescRuolo());

				if (msgOK != null) {
					result.getGlobalMessages().add(msgOK);
				}
				log.debug("Civico impianto: " + responsabile.getImpLocCivico());
				//impostazione campo responsabile attivo
				ArrayList<RisultatoRicResponsabile> storicoResponsabili = getDbMgr()
						.cercaResponsabiliByIdImpianto(ConvertUtil.convertToInteger(responsabile.getImpCodImpianto()));
				if (storicoResponsabili != null) {
					log.debug("responsabili trovati: " + storicoResponsabili.size());
					theModel.setAppDataelencoResponsabiliImpianto(storicoResponsabili);
					/*					responsabile.setImpIdRuoloResp(ConvertUtil
					 .convertToInteger(respAttivo.getIdRuolo()));
					 responsabile.setImpIdRespAttivo(ConvertUtil
					 .convertToString(respAttivo.getIdPersonaFisica()));
					 String nome = "";
					 if (GenericUtil.isNotNullOrEmpty(respAttivo.getNome())) {
					 nome = respAttivo.getNome() + " ";
					 }
					 String denominazione = nome + respAttivo.getDenominazione();
					 responsabile.setImpRespDenominazione(denominazione);
					 responsabile.setImpRespDescRuolo(respAttivo.getDesRuolo());
					 responsabile.setImpLocDesIndirizzo(GenericUtil
					 .getDescriptionByCod(
					 responsabile.getImpLocIdIndirizzo(),
					 theModel.getAppDataelencoIndirizzi3Resp()));
					 responsabile.setImpLocDesComune(GenericUtil
					 .getDescriptionByCod(
					 responsabile.getImpLocIdComune(),
					 theModel.getAppDataelencoComuni()));
					 responsabile.setImpRespDenominazioneRuolo(denominazione
					 + " (" + respAttivo.getDesRuolo() + ")");*/

					responsabile.setIsImpCodImpiantoConfermato(true);
				}
				result.setResultCode(VERIFICAIMPIANTO_OUTCOME_CODE__OK);

			} catch (ManagerException ex) {
				Validator.gestisciEccezione(result, ex);
			}

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::verificaImpianto] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo nuovaRicercaImpianto definito in un ExecCommand del
	 * ContentPanel cpGest3Resp
	 */
	public ExecResults nuovaRicercaImpianto(

			it.csi.sigit.sigitwebn.dto.gestisci_terzo_responsabile.CpGest3RespModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String NUOVARICERCAIMPIANTO_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R1082853118) ENABLED START*/
			result.setResultCode(NUOVARICERCAIMPIANTO_OUTCOME_CODE__OK);
			theModel.setAppDataelencoResponsabiliImpianto(new ArrayList<RisultatoRicResponsabile>());
			theModel.getAppDataterzoResponsabile().setIsImpLocIndConfermato(false);
			theModel.getAppDataterzoResponsabile().setImpCodImpianto(null);
			theModel.getAppDataterzoResponsabile().setImpLocCivico(null);
			theModel.getAppDataterzoResponsabile().setImpLocDesComune(null);
			theModel.getAppDataterzoResponsabile().setImpLocDesIndirizzo(null);
			theModel.getAppDataterzoResponsabile().setImpLocIdComune(null);
			theModel.getAppDataterzoResponsabile().setImpLocIdIndirizzo(null);
			theModel.getAppDataterzoResponsabile().setImpLocIdProvincia(null);
			theModel.getAppDataterzoResponsabile().setImpLocIndirizzo(null);
			theModel.getAppDataterzoResponsabile().setImpLocIndirizzoNoStrad(null);
			theModel.setAppDataelencoIndirizzi3Resp(new ArrayList<CodeDescription>());
			theModel.getAppDataterzoResponsabile().setImpLocIndirizzoSitad(null);
			theModel.getAppDataterzoResponsabile().setImpFlgBloccoNomina(null);
			theModel.getAppDataterzoResponsabile().setIsImpCodImpiantoConfermato(false);

			log.debug("IsImpLocIndConfermato - nuovaRicercaImpianto: "
					+ theModel.getAppDataterzoResponsabile().getIsImpLocIndConfermato());

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::nuovaRicercaImpianto] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo effettuaSalvataggioResponsabile definito in un ExecCommand del
	 * ContentPanel cpGest3Resp
	 */
	public ExecResults effettuaSalvataggioResponsabile(

			it.csi.sigit.sigitwebn.dto.gestisci_terzo_responsabile.CpGest3RespModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String EFFETTUASALVATAGGIORESPONSABILE_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String EFFETTUASALVATAGGIORESPONSABILE_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-1198467356) ENABLED START*/

			TerzoResponsabile responsabile = theModel.getAppDataterzoResponsabile();
			UtenteLoggato utente = theModel.getAppDatautenteLoggato();
			try {

				boolean error = false;
				result.setResultCode(EFFETTUASALVATAGGIORESPONSABILE_OUTCOME_CODE__KO);

				log.debug("PASSO 1");

				getValidationMgr().validazioneFormale3Responsabile(responsabile);
				//1)	se UTENTE_RUOLO = "VALIDATORE" o "SUPER" verificare che l'utente abbia eseguito preventivamente la ricerca 
				// (sezione'3responsabile' pulsante 'cerca') del terzo responsabile. Se no emettere il messaggio S085
				String descRuoloUtente = utente.getRuolo().getDescRuolo();
				if (descRuoloUtente.equalsIgnoreCase(Constants.RUOLO_SUPER)
						|| descRuoloUtente.equalsIgnoreCase(Constants.RUOLO_VALIDATORE)) {
					if (GenericUtil.isNullOrEmpty(responsabile.getRespImpImpresa())) {
						result.getGlobalErrors().add(Messages.S085);
						error = true;
					}
				}
				log.debug("PASSO 2: " + error);

				if (!error) {

					log.debug("PASSO 3");

					PersonaGiuridica pgTerzoResp = getDbMgr().cercaPersonaGiuridicaById(responsabile.getRespImpId());

					log.debug("PASSO 3.1");
					//2)verificare che l'impresa al punto 1) sia abilitata alla terza responsabilita' (SIGIT_T_PERSONA_GIURIDICA.flg_terzo_responsabile), 
					//se no emettere il messaggio S146 (se possibile indicare anche i dati dell'impresa- Codice REA+ PIVA)
					if (!ConvertUtil.convertToBooleanAllways(pgTerzoResp.getFlgTerzoResponsabile())) {

						log.debug("PASSO 4");

						throw new ValidationManagerException(
								new Message(Messages.S146, pgTerzoResp.getCodiceRea(), pgTerzoResp.getCodiceFiscale()));

					} else if (pgTerzoResp.getIdStatoPg().intValue() == Constants.ID_STATO_IMPRESA_SOSPESA
							|| pgTerzoResp.getIdStatoPg().intValue() == Constants.ID_STATO_IMPRESA_RADIATA) {
						//3) verificare che lo stato dell'impresa terzo responsabile (SIGIT_T_PERSONA_GIURIDICA.fk_stato_pg) 
						//definita al punto 1) sia diverso da RADIATO o SOSPESO. In caso negativo emettere il messaggio S147
						//(se possibile indicare anche i dati dell'impresa- Codice REA+ PIVA)
						log.debug("PASSO 5");

						log.debug("ERRORE: pgTerzoResp.getCodiceRea()" + pgTerzoResp.getCodiceRea());
						log.debug("ERRORE: pgTerzoResp.getCodiceFiscale()" + pgTerzoResp.getCodiceFiscale());

						throw new ValidationManagerException(
								new Message(Messages.S147, pgTerzoResp.getCodiceRea(), pgTerzoResp.getCodiceFiscale()));

					} else if (!DateUtil.checkDateOrderIsPresents(responsabile.getDataInizioContratto(),
							pgTerzoResp.getDataCessazione(), false)) {
						// Si sta inserendo una data inizio contratto successiva alla data cessazione della ditta
						throw new ValidationManagerException(new Message(Messages.S161, pgTerzoResp.getCodiceRea(),
								pgTerzoResp.getCodiceFiscale(), pgTerzoResp.getDataCessazione()));
					} else {

						log.debug("PASSO 6");

						//individuare responsabile attivo alla data
						SigitVTotImpiantoDto respAttivoInData = getDbMgr().cercaResponsabileAttivoAllaDataImpianto(
								ConvertUtil.convertToInteger(responsabile.getImpCodImpianto()),
								ConvertUtil.convertToSqlDate(responsabile.getDataInizioContratto()));

						log.debug("PASSO 6.1");

						if (respAttivoInData == null) {
							//8)	verificare che alla data di inizio validita' del contratto (data_inizio) esista un responsabile valido attivo. 
							//Se non c'e' emettere il messaggio S089
							log.debug("Nessun responsabile attivo trovato per il: "
									+ responsabile.getDataInizioContratto());
							result.getGlobalErrors().add(Messages.S089);

							log.debug("PASSO 7");

							error = true;
						} else {
							//10)il sistema verifica se esiste un blocco sulla nomina della terza responsabilita'
							//(SIGIT_T_IMPIANTO.flg_blocco_nomina_3R); se c'e' emettere il messaggio 
							//'Non e' possibile procedere con la nomina della terza responsabilità in quanto c'e' un accertamento in corso sull'impianto stesso'
							//DCOSTA controllo 10: VERIFICA SUL BLOCCO DELLA NOMINA DEL TERZO RESPONSABILE
							if (ConvertUtil.convertToBooleanAllways(responsabile.getImpFlgBloccoNomina())) {
								throw new ValidationManagerException(new Message(Messages.S163_1));
							}

							//11)	verificare se esiste gia' un terzo responsabile attivo sull'impianto indicato per il periodo temporale indicato. 
							//Se esiste emettere il messaggio S090
							//DCOSTA controllo 11: VERIFICA SULLA PRESENZA DI UN TERZO RESPONSABILE ATTIVO SULL'IMPIANTO PER IL PERIODO INDICATO
							SigitVRicerca3ResponsabileByFkPgPfRowDto terzoRespAttivo = null;
							if (responsabile.getFlgTacitoRinnovo()) {
								terzoRespAttivo = getDbMgr().cerca3ResponsabileByPfPgDataFine(null,
										responsabile.getImpCodImpianto(), false, responsabile.getDataInizioContratto(),
										null, null);

							} else {
								terzoRespAttivo = getDbMgr().cerca3ResponsabileByPfPgDataFine(null,
										responsabile.getImpCodImpianto(), false, responsabile.getDataInizioContratto(),
										responsabile.getDataFineContratto(), null);

							}

							if (terzoRespAttivo != null && terzoRespAttivo.getDataInizioContratto() != null) {

								String message = Messages.S090;
								if (GenericUtil.isNotNullOrEmpty(terzoRespAttivo.getDenominazioneResp())) {
									message += " denominazione responsabile " + terzoRespAttivo.getDenominazioneResp();
								}
								if (GenericUtil.isNotNullOrEmpty(terzoRespAttivo.getDenominazione3Resp())) {
									message += ", denominazione 3R " + terzoRespAttivo.getDenominazione3Resp();
								}

								if (GenericUtil.isNotNullOrEmpty(terzoRespAttivo.getDataInizioContratto())) {
									message += ", data inizio contratto "
											+ ConvertUtil.convertToString(terzoRespAttivo.getDataInizioContratto());
								}

								if (GenericUtil.isNotNullOrEmpty(terzoRespAttivo.getDataCessazione())) {
									message += ", data cessazione contratto "
											+ ConvertUtil.convertToString(terzoRespAttivo.getDataCessazione());
								} else {
									message += ", data fine contratto "
											+ ConvertUtil.convertToString(terzoRespAttivo.getDataFineContratto());
								}

								/*
								Date dataFine = GenericUtil.isNotNullOrEmpty(terzoRespAttivo.getDataCessazione())
										? terzoRespAttivo.getDataCessazione()
										: terzoRespAttivo.getDataFineContratto();
								if (GenericUtil.isNotNullOrEmpty(dataFine)) {
									message += ", data fine contratto "
											+ ConvertUtil.convertToString(terzoRespAttivo.getDataFineContratto());
								}
								
								if (terzoRespAttivo.getFlgTacitoRinnovo() != null) {
									message += ", tacito rinnovo "
											+ ConvertUtil.convertToStringSiNo(terzoRespAttivo.getFlgTacitoRinnovo());
								}
								*/

								throw new ValidationManagerException(new Message(message));

							}

							//controllo 12 (esistono REE inviati nel periodo indicato? se si dare errore)
							Integer contaREEInviati = getSigitMgr().verificaREENomina3Resp(
									responsabile.getImpCodImpianto(), responsabile.getDataInizioContratto(),
									responsabile.getDataFineContratto());

							if (contaREEInviati > 0) {
								throw new ValidationManagerException(new Message(Messages.ERRORE_PRESENZA_REE_INVIATI));
							}

							/*
							if (responsabile.getFlgTacitoRinnovo()) {
								//Se flag_tacito_rinnovo (a video) checkato -> verificare che non esitano contratti con validita' superiore alla 'data inizio'
								SigitVRicerca3ResponsabileByFkPgPfRowDto contrattoValido = getDbMgr()
										.cerca3ResponsabileByPfPgDataFine(null, responsabile.getImpCodImpianto(), null,
												responsabile.getDataInizioContratto(), null);
								if (contrattoValido != null && contrattoValido.getDataInizioContratto() != null) {
									throw new ValidationManagerException(new Message("errore tacito rinnovo"));
								}
							}
							*/

							// devo verificare che esista un libretto in stato consolidato
							List<SigitTLibrettoDto> librettoDtoList = getDbMgr().cercaLibrettoByStato(
									responsabile.getImpCodImpianto(), Constants.ID_STATO_LIBRETTO_CONSOLIDATO);

							if (librettoDtoList == null || librettoDtoList.size() == 0) {
								throw new ValidationManagerException(new Message(Messages.S163));
							}

							//trovato rsponsabile attivo valido
							responsabile.setImpIdRespAttivo(
									ConvertUtil.convertToString(respAttivoInData.getIdPersonaFisica()));
							responsabile.setImpIdRuoloResp(respAttivoInData.getIdRuolo().intValue());
							responsabile.setImpLocDesIndirizzo(GenericUtil.getDescriptionByCod(
									ReplaceSpecialCharUtils.sanitize(responsabile.getImpLocIdIndirizzo())
									, theModel.getAppDataelencoIndirizzi3Resp()));
							responsabile.setImpLocDesComune(GenericUtil.getDescriptionByCod(
									ReplaceSpecialCharUtils.sanitize(responsabile.getImpLocIdComune())
									, theModel.getAppDataelencoComuni()));
							responsabile.setImpRespDescRuolo(ReplaceSpecialCharUtils.sanitize( 
									respAttivoInData.getDesRuolo().toUpperCase()));
							responsabile.setImpRespDenominazione(
									ReplaceSpecialCharUtils.sanitize(respAttivoInData.getDenominazione()));

							log.debug("PASSO 8");

						}

						log.debug("PASSO 9");

						if (!error) {

							log.debug("PASSO 10");

							if (responsabile.getImpLocIdIndirizzo() != null) {
								responsabile.setImpLocDesIndirizzo(
										GenericUtil.getDescriptionByCod(
												ReplaceSpecialCharUtils.sanitize(responsabile.getImpLocIdIndirizzo()),
												theModel.getAppDataelencoIndirizzi3Resp()));
							}
							DettaglioTerzoResponsabile dettTerzoResp = MapDto
									.mapToDettaglioTerzoResponsabile(responsabile, respAttivoInData);
							theModel.setAppDatadettaglioTerzoResponsabile(dettTerzoResp);

							log.debug("PASSO 11");

							// Devo recuperare le apparecchiature
							ArrayList<CodeDescription> elencoApp = getSigitMgr()
									.cercaElencoApparecchiatureTerzoResp(responsabile);

							if (elencoApp != null && !elencoApp.isEmpty()) {

								theModel.setAppDataelencoApp3Responsabile(elencoApp);
								theModel.setAppDatapaginaChiamante(Constants.ARRIVO_DA_GESTIONE_3RESP);

								result.setResultCode(EFFETTUASALVATAGGIORESPONSABILE_OUTCOME_CODE__OK);
							} else {
								result.getGlobalErrors().add(Messages.S145);
								result.setResultCode(EFFETTUASALVATAGGIORESPONSABILE_OUTCOME_CODE__KO);
							}

							log.debug("PASSO 12");

						}
					}
				}
			} catch (ManagerException ex) {
				log.debug("Errore: " + ex.getMessage());
				Validator.gestisciEccezione(result, ex);
			}

			log.debug("PASSO 13");

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::effettuaSalvataggioResponsabile] Errore occorso nell'esecuzione del metodo:" + e,
					e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo isRuoloAbilitato definito in un ExecCommand del
	 * ContentPanel cpGest3Resp
	 */
	public ExecResults isRuoloAbilitato(

			it.csi.sigit.sigitwebn.dto.gestisci_terzo_responsabile.CpGest3RespModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String ISRUOLOABILITATO_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-1624525409) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			UtenteLoggato utente = theModel.getAppDatautenteLoggato();

			if (GenericUtil.isRuoloAbilitatoAccessoNomina3Responsabile(utente)) {
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
	 * Implementazione del metodo gestisciProvenienza definito in un ExecCommand del
	 * ContentPanel cpGest3Resp
	 */
	public ExecResults gestisciProvenienza(

			it.csi.sigit.sigitwebn.dto.gestisci_terzo_responsabile.CpGest3RespModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GESTISCIPROVENIENZA_OUTCOME_CODE__NUOVA = //NOSONAR  Reason:EIAS
				"NUOVA"; //NOSONAR  Reason:EIAS
		final String GESTISCIPROVENIENZA_OUTCOME_CODE__INDIETRO = //NOSONAR  Reason:EIAS
				"INDIETRO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R1489909625) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			String prov = theModel.getAppDatapaginaChiamante();

			log.debug("STAMPO LA PROVENIENZA!!!!: " + prov);

			if (prov != null && prov.equals(Constants.ARRIVO_DA_MENU)) {

				String msg = theModel.getAppDatamessaggioDinamico();

				if (GenericUtil.isNotNullOrEmpty(msg)) {
					result.getGlobalMessages().add(msg);

					theModel.setAppDatamessaggioDinamico(null);
				}

				// impostazione del result code 
				result.setResultCode(GESTISCIPROVENIENZA_OUTCOME_CODE__NUOVA);
			} else {
				// impostazione del result code 
				result.setResultCode(GESTISCIPROVENIENZA_OUTCOME_CODE__INDIETRO);
			}

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::gestisciProvenienza] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo gestLogicaImpRespEnt definito in un ExecCommand del
	 * ContentPanel cpGest3Resp
	 */
	public ExecResults gestLogicaImpRespEnt(

			it.csi.sigit.sigitwebn.dto.gestisci_terzo_responsabile.CpGest3RespModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GESTLOGICAIMPRESPENT_OUTCOME_CODE__ABILITA = //NOSONAR  Reason:EIAS
				"ABILITA"; //NOSONAR  Reason:EIAS
		final String GESTLOGICAIMPRESPENT_OUTCOME_CODE__DISABILITA = //NOSONAR  Reason:EIAS
				"DISABILITA"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-1859305546) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			result = gestLogicaImpResp(theModel, GESTLOGICAIMPRESPENT_OUTCOME_CODE__ABILITA,
					GESTLOGICAIMPRESPENT_OUTCOME_CODE__DISABILITA);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::gestLogicaImpRespEnt] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo gestisciLogicaResetVis definito in un ExecCommand del
	 * ContentPanel cpGest3Resp
	 */
	public ExecResults gestisciLogicaResetVis(

			it.csi.sigit.sigitwebn.dto.gestisci_terzo_responsabile.CpGest3RespModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GESTISCILOGICARESETVIS_OUTCOME_CODE__SI = //NOSONAR  Reason:EIAS
				"SI"; //NOSONAR  Reason:EIAS
		final String GESTISCILOGICARESETVIS_OUTCOME_CODE__NO = //NOSONAR  Reason:EIAS
				"NO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-899590812) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			if (theModel.getAppDataterzoResponsabile() == null) {

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
	 * Implementazione del metodo gestLogicaImpRespRef definito in un ExecCommand del
	 * ContentPanel cpGest3Resp
	 */
	public ExecResults gestLogicaImpRespRef(

			it.csi.sigit.sigitwebn.dto.gestisci_terzo_responsabile.CpGest3RespModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GESTLOGICAIMPRESPREF_OUTCOME_CODE__ABILITA = //NOSONAR  Reason:EIAS
				"ABILITA"; //NOSONAR  Reason:EIAS
		final String GESTLOGICAIMPRESPREF_OUTCOME_CODE__DISABILITA = //NOSONAR  Reason:EIAS
				"DISABILITA"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-476014322) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			result = gestLogicaImpResp(theModel, GESTLOGICAIMPRESPREF_OUTCOME_CODE__ABILITA,
					GESTLOGICAIMPRESPREF_OUTCOME_CODE__DISABILITA);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::gestLogicaImpRespRef] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	//////////////////////////////////////////////////////////////////////////////
	/// Metodi statici per il reset delle tabelle
	//////////////////////////////////////////////////////////////////////////////

	/**
	 * permette di resettare lo stato di paginazione della tabella widg_tbRespImpianto3Resp
	 */
	public static void resetClearStatus_widg_tbRespImpianto3Resp(java.util.Map session) {
		session.put("cpGest3Resp_tbRespImpianto3Resp_clearStatus", Boolean.TRUE);
	}

	//////////////////////////////////////////////////////////////////////////////
	/// Property aggiuntive del bean
	//////////////////////////////////////////////////////////////////////////////
	/*PROTECTED REGION ID(R468509978) ENABLED START*/
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

	private ConnectorMgr connectorMgr;

	public ConnectorMgr getConnectorMgr() {
		return connectorMgr;
	}

	public void setConnectorMgr(ConnectorMgr connectorMgr) {
		this.connectorMgr = connectorMgr;
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

	private ExecResults gestLogicaImpResp(
			it.csi.sigit.sigitwebn.dto.gestisci_terzo_responsabile.CpGest3RespModel theModel, String codAbilita,
			String codDisabilita) throws DbManagerException {
		ExecResults result = new ExecResults();

		Ruolo ruolo = theModel.getAppDatautenteLoggato().getRuolo();
		log.debug("RUOLO: " + ruolo.getDescRuolo());
		TerzoResponsabile resp = new TerzoResponsabile();
		if (ruolo.getDescRuolo().equalsIgnoreCase(Constants.RUOLO_SUPER)
				|| ruolo.getDescRuolo().equalsIgnoreCase(Constants.RUOLO_VALIDATORE)) {
			result.setResultCode(codAbilita);
		} else {

			//impostiamo i valori del terzo responsabile (sola lettura)
			result.setResultCode(codDisabilita);

			log.debug("caricamento dati terzo responsabile");
			resp.setRespImpId(ruolo.getIdPersonaGiuridica());
			resp.setRespImpIdSiglaRea(ruolo.getSiglaRea());
			resp.setRespImpNumeroRea(ConvertUtil.convertToUDTPositiveInteger(ruolo.getNumeroRea()));
			resp.setRespImpCf(ruolo.getCodiceFiscale());
			resp.setRespImpImpresa(ruolo.getDenomDitta());

			if (log.isDebugEnabled())
				GenericUtil.stampa(resp, true, 3);

		}
		theModel.setAppDataterzoResponsabile(resp);
		theModel.setAppDataelencoComuni(new ArrayList<CodeDescription>());

		return result;
	}

	/*PROTECTED REGION END*/
}
