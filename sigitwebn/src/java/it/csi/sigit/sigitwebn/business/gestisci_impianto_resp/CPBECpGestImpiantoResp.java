package it.csi.sigit.sigitwebn.business.gestisci_impianto_resp;

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

/*PROTECTED REGION ID(R1668455120) ENABLED START*/
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.SigitTPersonaGiuridicaDto;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.SigitVRicercaAllegatiDto;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.SigitVTotImpiantoDto;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.filter.FiltroRicercaAllegati;
import it.csi.sigit.sigitwebn.business.manager.DbMgr;
import it.csi.sigit.sigitwebn.business.manager.ServiziMgr;
import it.csi.sigit.sigitwebn.business.manager.SigitMgr;
import it.csi.sigit.sigitwebn.business.manager.ValidationMgr;
import it.csi.sigit.sigitwebn.business.manager.util.DbManagerException;
import it.csi.sigit.sigitwebn.business.manager.util.ManagerException;
import it.csi.sigit.sigitwebn.business.manager.util.ServiceException;
import it.csi.sigit.sigitwebn.business.manager.util.Message;
import it.csi.sigit.sigitwebn.business.manager.util.ValidationManagerException;

/*PROTECTED REGION END*/

public class CPBECpGestImpiantoResp {

	/**  */
	protected static final Logger log = //NOSONAR  Reason:EIAS 
			Logger.getLogger(Constants.APPLICATION_CODE + ".business"); //NOSONAR  Reason:EIAS

	//////////////////////////////////////////////////////////////////////////////
	/// Costanti identificative degli Application Data
	//////////////////////////////////////////////////////////////////////////////

	// ApplicationData: [impianto, scope:USER_SESSION]
	public static final String APPDATA_IMPIANTO_CODE = "appDataimpianto";

	// ApplicationData: [utenteLoggato, scope:USER_SESSION]
	public static final String APPDATA_UTENTELOGGATO_CODE = "appDatautenteLoggato";

	// ApplicationData: [elencoStatoImpianto, scope:USER_SESSION]
	public static final String APPDATA_ELENCOSTATOIMPIANTO_CODE = "appDataelencoStatoImpianto";

	// ApplicationData: [elencoIndirizzi, scope:USER_SESSION]
	public static final String APPDATA_ELENCOINDIRIZZI_CODE = "appDataelencoIndirizzi";

	// ApplicationData: [elencoComuni, scope:USER_SESSION]
	public static final String APPDATA_ELENCOCOMUNI_CODE = "appDataelencoComuni";

	// ApplicationData: [elencoComuniResp, scope:USER_SESSION]
	public static final String APPDATA_ELENCOCOMUNIRESP_CODE = "appDataelencoComuniResp";

	// ApplicationData: [elencoIndirizziResp, scope:USER_SESSION]
	public static final String APPDATA_ELENCOINDIRIZZIRESP_CODE = "appDataelencoIndirizziResp";

	// ApplicationData: [elencoTitoli, scope:USER_SESSION]
	public static final String APPDATA_ELENCOTITOLI_CODE = "appDataelencoTitoli";

	// ApplicationData: [responsabile, scope:USER_SESSION]
	public static final String APPDATA_RESPONSABILE_CODE = "appDataresponsabile";

	// ApplicationData: [elencoProvince, scope:USER_SESSION]
	public static final String APPDATA_ELENCOPROVINCE_CODE = "appDataelencoProvince";

	// ApplicationData: [elencoSiglaRea, scope:USER_SESSION]
	public static final String APPDATA_ELENCOSIGLAREA_CODE = "appDataelencoSiglaRea";

	// ApplicationData: [elencoProvincePiemonte, scope:USER_SESSION]
	public static final String APPDATA_ELENCOPROVINCEPIEMONTE_CODE = "appDataelencoProvincePiemonte";

	// ApplicationData: [paginaChiamanteImp, scope:USER_SESSION]
	public static final String APPDATA_PAGINACHIAMANTEIMP_CODE = "appDatapaginaChiamanteImp";

	// ApplicationData: [isAbilitazioneDatiAllegato, scope:USER_SESSION]
	public static final String APPDATA_ISABILITAZIONEDATIALLEGATO_CODE = "appDataisAbilitazioneDatiAllegato";

	// ApplicationData: [aggiornaElencoImpianti, scope:USER_SESSION]
	public static final String APPDATA_AGGIORNAELENCOIMPIANTI_CODE = "appDataaggiornaElencoImpianti";

	// ApplicationData: [idImpiantoSelez, scope:USER_SESSION]
	public static final String APPDATA_IDIMPIANTOSELEZ_CODE = "appDataidImpiantoSelez";

	// ApplicationData: [identificativoImpianto, scope:USER_SESSION]
	public static final String APPDATA_IDENTIFICATIVOIMPIANTO_CODE = "appDataidentificativoImpianto";

	// ApplicationData: [paginaChiamanteDocumenti, scope:USER_SESSION]
	public static final String APPDATA_PAGINACHIAMANTEDOCUMENTI_CODE = "appDatapaginaChiamanteDocumenti";

	// ApplicationData: [paginaChiamante, scope:USER_SESSION]
	public static final String APPDATA_PAGINACHIAMANTE_CODE = "appDatapaginaChiamante";

	// ApplicationData: [elencoImpiantiGraffati, scope:USER_SESSION]
	public static final String APPDATA_ELENCOIMPIANTIGRAFFATI_CODE = "appDataelencoImpiantiGraffati";

	//////////////////////////////////////////////////////////////////////////////
	/// Metodi associati alla U.I.
	//////////////////////////////////////////////////////////////////////////////

	// nome del content panel associato al bean
	public static final String CPNAME = "cpGestImpiantoResp";

	/** 
	 * Restituisce il tab correntemente visibile in un determinato tab set
	 */
	private String getCurrentTab(Map session, String tabSetName) {
		String value = (String) session.get(CPNAME + "_" + tabSetName + "_selectedMultiPanel");
		return value;
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo preparaAperturaApprofondisciImpianto definito in un ExecCommand del
	 * ContentPanel cpGestImpiantoResp
	 */
	public ExecResults preparaAperturaApprofondisciImpianto(

			it.csi.sigit.sigitwebn.dto.gestisci_impianto_resp.CpGestImpiantoRespModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String PREPARAAPERTURAAPPROFONDISCIIMPIANTO_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String PREPARAAPERTURAAPPROFONDISCIIMPIANTO_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R896679080) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			// impostazione del result code 
			result.setResultCode(PREPARAAPERTURAAPPROFONDISCIIMPIANTO_OUTCOME_CODE__OK);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::preparaAperturaApprofondisciImpianto] Errore occorso nell'esecuzione del metodo:"
					+ e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo verificaCodiceImpianto definito in un ExecCommand del
	 * ContentPanel cpGestImpiantoResp
	 */
	public ExecResults verificaCodiceImpianto(

			it.csi.sigit.sigitwebn.dto.gestisci_impianto_resp.CpGestImpiantoRespModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String VERIFICACODICEIMPIANTO_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String VERIFICACODICEIMPIANTO_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-1567901332) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			try {

				getValidationMgr().verificaCodiceImpiantoIdentificazioneResp(theModel.getAppDataimpianto());

				/*
				List<SigitTCodiceImpByCodiceImpiantoDto> codiceList = getDbMgr().cercaCodiceImpianto(
						ConvertUtil.convertToInteger(theModel.getAppDataimpianto().getImpCodImpianto()));
				
				log.debug("DATA RITIRO: *" + ConvertUtil.convertToString(codiceList.get(0).getDataTransazione()) + "*");
				
				log.debug("DATA ASSEGNAZIONE: *" + theModel.getAppDataimpianto().getImpDataAssegnazione() + "*");
				
				if (!DateUtil.checkDateOrder(ConvertUtil.convertToString(codiceList.get(0).getDataTransazione()),
						theModel.getAppDataimpianto().getImpDataAssegnazione(), true)) {
				
					theModel.getAppDataimpianto().setImpDataAssegnazione(
							ConvertUtil.convertToString(codiceList.get(0).getDataTransazione()));
				
					result.getGlobalMessages().add(Messages.INFO_COD_IMPIANTO_VERIFICATO_NO_DATA_ASS);
				
				} else {
					result.getGlobalMessages().add(Messages.INFO_COD_IMPIANTO_VERIFICATO);
				}
				*/
				result.setResultCode(VERIFICACODICEIMPIANTO_OUTCOME_CODE__OK);

			} catch (ManagerException ex) {
				Validator.gestisciEccezione(result, ex);
			}

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::verificaCodiceImpianto] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo gestLogicaCodImpMotiv definito in un ExecCommand del
	 * ContentPanel cpGestImpiantoResp
	 */
	public ExecResults gestLogicaCodImpMotiv(

			it.csi.sigit.sigitwebn.dto.gestisci_impianto_resp.CpGestImpiantoRespModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GESTLOGICACODIMPMOTIV_OUTCOME_CODE__ABILITA = //NOSONAR  Reason:EIAS
				"ABILITA"; //NOSONAR  Reason:EIAS
		final String GESTLOGICACODIMPMOTIV_OUTCOME_CODE__DISABILITA = //NOSONAR  Reason:EIAS
				"DISABILITA"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-214631804) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			Impianto impianto = theModel.getAppDataimpianto();
			if (GenericUtil.isNotNullOrEmpty(impianto.getImpIdStatoImp())
					&& ConvertUtil.convertToInteger(impianto.getImpIdStatoImp()).intValue() != ConvertUtil
							.convertToInteger(impianto.getImpIdStatoImpOld()).intValue()) {
				// Sono in inserimento o modifica
				log.debug("***ABILITA_MOTIVAZIONE***\n\n");

				// Pulisco i campi che eventualmente erano valorizzati
				impianto.setImpDataDismissione(null);
				impianto.setImpMotivazione(null);

				// impostazione del result code 
				result.setResultCode(GESTLOGICACODIMPMOTIV_OUTCOME_CODE__ABILITA);

			} else {

				// Pulisco i campi che eventualmente erano valorizzati
				impianto.setImpDataDismissione(impianto.getImpDataDismissioneOld());
				impianto.setImpMotivazione(impianto.getImpMotivazioneOld());

				if (GenericUtil.isNotNullOrEmpty(impianto.getImpId())) {
					log.debug("***DISABILITA_MOTIVAZIONE***\n\n");
					// impostazione del result code 
					result.setResultCode(GESTLOGICACODIMPMOTIV_OUTCOME_CODE__DISABILITA);
				} else {

					log.debug("***ABILITA_MOTIVAZIONE (primo accesso) ***\n\n");
					// impostazione del result code 
					result.setResultCode(GESTLOGICACODIMPMOTIV_OUTCOME_CODE__ABILITA);
				}

			}

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::gestLogicaCodImpMotiv] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo loadComuniImp definito in un ExecCommand del
	 * ContentPanel cpGestImpiantoResp
	 */
	public ExecResults loadComuniImp(

			it.csi.sigit.sigitwebn.dto.gestisci_impianto_resp.CpGestImpiantoRespModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String LOADCOMUNIIMP_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-177180874) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			ArrayList<CodeDescription> comuniLoc = recuperaComuni(theModel.getAppDataimpianto().getImpLocIdProvincia());

			//			ArrayList<CodeDescription> comuniLoc = recuperaComuni(theModel
			//					.getAppDataimpianto().getImpLocIdProvincia());

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
	 * ContentPanel cpGestImpiantoResp
	 */
	public ExecResults cercaIndirizzoImp(

			it.csi.sigit.sigitwebn.dto.gestisci_impianto_resp.CpGestImpiantoRespModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String CERCAINDIRIZZOIMP_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String CERCAINDIRIZZOIMP_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-1647731775) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			try {
				Impianto impianto = theModel.getAppDataimpianto();

				getValidationMgr().verificaRicercaIndirizzoIdentificazioneImpianto(impianto);

				theModel.setAppDataelencoIndirizzi(
						getServiziMgr().getListaVieValide(ReplaceSpecialCharUtils.sanitize(impianto.getImpLocIndirizzo()), 
								ReplaceSpecialCharUtils.sanitize(impianto.getImpLocIdComune())));
				//				setVisibilitaIndirizzoImpianto(theModel);

				impianto.getLogicaVisual().setIsImpiantoIndConfermato(true);

				// impostazione del result code 
				result.setResultCode(CERCAINDIRIZZOIMP_OUTCOME_CODE__OK);

			} catch (ManagerException ex) {

				log.debug("##################### INTERCETTO L'eccezione");
				Validator.gestisciEccezione(result, ex);

			}

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

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
	 * ContentPanel cpGestImpiantoResp
	 */
	public ExecResults nuovaRicercaIndirizzoImp(

			it.csi.sigit.sigitwebn.dto.gestisci_impianto_resp.CpGestImpiantoRespModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String NUOVARICERCAINDIRIZZOIMP_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-1832741527) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			theModel.getAppDataimpianto().getLogicaVisual().setIsImpiantoIndConfermato(false);

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
	 * Implementazione del metodo cessaProprietario definito in un ExecCommand del
	 * ContentPanel cpGestImpiantoResp
	 */
	public ExecResults cessaProprietario(

			it.csi.sigit.sigitwebn.dto.gestisci_impianto_resp.CpGestImpiantoRespModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String CESSAPROPRIETARIO_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String CESSAPROPRIETARIO_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-435866802) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			try {
				Impianto impianto = theModel.getAppDataimpianto();

				getValidationMgr().verificaCessaProprietario(impianto.getProprietario());

				getSigitMgr().cessaProprietario(impianto.getProprietario(), theModel.getAppDatautenteLoggato());

				result.getGlobalMessages().add(Messages.INFO_MODIFICA_CORRETTA);

				// Ripulisco il proprietario
				impianto.setProprietario(null);
				theModel.setAppDataimpianto(impianto);

				// impostazione del result code 
				result.setResultCode(CESSAPROPRIETARIO_OUTCOME_CODE__OK);

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
			log.error("[BackEndFacade::cessaProprietario] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo inserisciProprietario definito in un ExecCommand del
	 * ContentPanel cpGestImpiantoResp
	 */
	public ExecResults inserisciProprietario(
 
			it.csi.sigit.sigitwebn.dto.gestisci_impianto_resp.CpGestImpiantoRespModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String INSERISCIPROPRIETARIO_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String INSERISCIPROPRIETARIO_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R670988290) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			Impianto impiantoDB = getDbMgr()
					.cercaImpiantoById(ConvertUtil.convertToString(theModel.getAppDataimpianto().getImpId()));

			Responsabile responsabile = new Responsabile();
			responsabile.setFlgImpresa(false);
			responsabile.setFlgResponsabile(false);

			responsabile.setIdProvincia(ReplaceSpecialCharUtils.sanitize(impiantoDB.getImpLocIdProvincia()));
			responsabile.setIdComune(ReplaceSpecialCharUtils.sanitize(impiantoDB.getImpLocIdComune()));
			responsabile.setIdIndirizzo(ReplaceSpecialCharUtils.sanitize(impiantoDB.getImpLocIdIndirizzo()));
			responsabile.setIndirizzoSitad(ReplaceSpecialCharUtils.sanitize(impiantoDB.getImpLocIndirizzoSitad()));
			responsabile.setIndirizzoNoStrad(ReplaceSpecialCharUtils.sanitize(impiantoDB.getImpLocIndirizzoNoStrad()));

			responsabile.setCivico(ReplaceSpecialCharUtils.sanitize(impiantoDB.getImpLocCivico()));

			settaComuneVieResponsabile(theModel, responsabile);

			theModel.setAppDataresponsabile(responsabile);

			//settaListaRuoloResponsabile(theModel, Constants.RUOLO_RESPONSABILE);

			theModel.getAppDataimpianto().getLogicaVisual().setIsResponsabileIndConfermato(true);

			theModel.setAppDatapaginaChiamanteImp(Constants.PAG_GEST_IMPIANTI_RESP);

			// impostazione del result code 
			result.setResultCode(INSERISCIPROPRIETARIO_OUTCOME_CODE__OK);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::inserisciProprietario] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo gestTipoIndirizzo definito in un ExecCommand del
	 * ContentPanel cpGestImpiantoResp
	 */
	public ExecResults gestTipoIndirizzo(

			it.csi.sigit.sigitwebn.dto.gestisci_impianto_resp.CpGestImpiantoRespModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GESTTIPOINDIRIZZO_OUTCOME_CODE__NAZIONALE = //NOSONAR  Reason:EIAS
				"NAZIONALE"; //NOSONAR  Reason:EIAS
		final String GESTTIPOINDIRIZZO_OUTCOME_CODE__ESTERO = //NOSONAR  Reason:EIAS
				"ESTERO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R1979294034) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			Responsabile responsabile = theModel.getAppDataresponsabile();

			if (ConvertUtil.convertToBooleanAllways(responsabile.getFlgIndirizzoEst())) {
				// impostazione del result code 
				result.setResultCode(GESTTIPOINDIRIZZO_OUTCOME_CODE__ESTERO);
			} else {
				// impostazione del result code 
				result.setResultCode(GESTTIPOINDIRIZZO_OUTCOME_CODE__NAZIONALE);
			}

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::gestTipoIndirizzo] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo gestIndirizzoConf definito in un ExecCommand del
	 * ContentPanel cpGestImpiantoResp
	 */
	public ExecResults gestIndirizzoConf(

			it.csi.sigit.sigitwebn.dto.gestisci_impianto_resp.CpGestImpiantoRespModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GESTINDIRIZZOCONF_OUTCOME_CODE__SI = //NOSONAR  Reason:EIAS
				"SI"; //NOSONAR  Reason:EIAS
		final String GESTINDIRIZZOCONF_OUTCOME_CODE__NO = //NOSONAR  Reason:EIAS
				"NO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R429751098) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			if (theModel.getAppDataimpianto().getLogicaVisual() != null && ConvertUtil.convertToBooleanAllways(
					theModel.getAppDataimpianto().getLogicaVisual().getIsResponsabileIndConfermato())) {
				// impostazione del result code 
				result.setResultCode(GESTINDIRIZZOCONF_OUTCOME_CODE__SI);
			} else {
				// impostazione del result code 
				result.setResultCode(GESTINDIRIZZOCONF_OUTCOME_CODE__NO);
			}

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::gestIndirizzoConf] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo loadComuniResp definito in un ExecCommand del
	 * ContentPanel cpGestImpiantoResp
	 */
	public ExecResults loadComuniResp(

			it.csi.sigit.sigitwebn.dto.gestisci_impianto_resp.CpGestImpiantoRespModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String LOADCOMUNIRESP_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R1802724102) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			ArrayList<CodeDescription> comuniLoc = recuperaComuni(theModel.getAppDataresponsabile().getIdProvincia());

			theModel.setAppDataelencoComuniResp(comuniLoc);

			// impostazione del result code 
			result.setResultCode(LOADCOMUNIRESP_OUTCOME_CODE__OK);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::loadComuniResp] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo cercaIndirizzoResp definito in un ExecCommand del
	 * ContentPanel cpGestImpiantoResp
	 */
	public ExecResults cercaIndirizzoResp(

			it.csi.sigit.sigitwebn.dto.gestisci_impianto_resp.CpGestImpiantoRespModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String CERCAINDIRIZZORESP_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String CERCAINDIRIZZORESP_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-834680869) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			try {
				Responsabile responsabile = theModel.getAppDataresponsabile();

				getValidationMgr().verificaRicercaIndirizzoResponsabile(responsabile);

				theModel.setAppDataelencoIndirizziResp(
						getServiziMgr().getListaVieValide(ReplaceSpecialCharUtils.sanitize(responsabile.getIndirizzo())
								, ReplaceSpecialCharUtils.sanitize(responsabile.getIdComune())));
				//				setVisibilitaIndirizzoImpianto(theModel);

				theModel.getAppDataimpianto().getLogicaVisual().setIsResponsabileIndConfermato(true);

				// impostazione del result code 
				result.setResultCode(CERCAINDIRIZZORESP_OUTCOME_CODE__OK);

			} catch (ManagerException ex) {

				Validator.gestisciEccezione(result, ex);

			}

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::cercaIndirizzoResp] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo nuovaRicercaIndirizzoResp definito in un ExecCommand del
	 * ContentPanel cpGestImpiantoResp
	 */
	public ExecResults nuovaRicercaIndirizzoResp(

			it.csi.sigit.sigitwebn.dto.gestisci_impianto_resp.CpGestImpiantoRespModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String NUOVARICERCAINDIRIZZORESP_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String NUOVARICERCAINDIRIZZORESP_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R2019951411) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			theModel.getAppDataimpianto().getLogicaVisual().setIsResponsabileIndConfermato(false);

			// impostazione del result code 
			result.setResultCode(NUOVARICERCAINDIRIZZORESP_OUTCOME_CODE__OK);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::nuovaRicercaIndirizzoResp] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo salvaImpiano definito in un ExecCommand del
	 * ContentPanel cpGestImpiantoResp
	 */
	public ExecResults salvaImpiano(

			it.csi.sigit.sigitwebn.dto.gestisci_impianto_resp.CpGestImpiantoRespModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String SALVAIMPIANO_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String SALVAIMPIANO_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-1108426865) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			Impianto impianto = theModel.getAppDataimpianto();
			boolean isInserimento = impianto.getImpId() == null;

			try {
				UtenteLoggato utenteLoggato = theModel.getAppDatautenteLoggato();

				Ruolo ruoloUtente = utenteLoggato.getRuolo();

				if (isInserimento) {
					// SONO IN INSERIMENTO

					if (GenericUtil.isNotNullOrEmpty(impianto.getImpCodImpianto())) {

						// se l'utente indica il codice impianto lo verifico, altrimenti gliene viene assegnato uno di default
						getValidationMgr().verificaCodiceImpiantoIdentificazione(impianto.getImpCodImpianto());

						// prima utilizzava questo metodo, forse posso usare lo stesso dell'impianto
						//getValidationMgr().verificaCodiceImpiantoIdentificazioneResp(impianto);

					}

					/*
					List<SigitTCodiceImpByCodiceImpiantoDto> codiceList = getDbMgr().cercaCodiceImpianto(
							ConvertUtil.convertToInteger(theModel.getAppDataimpianto().getImpCodImpianto()));
					log.debug("DATA RITIRO: *" + ConvertUtil.convertToString(codiceList.get(0).getDataTransazione())
							+ "*");
					log.debug("DATA ASSEGNAZIONE: *" + theModel.getAppDataimpianto().getImpDataAssegnazione() + "*");
					
					if (!DateUtil.checkDateOrder(ConvertUtil.convertToString(codiceList.get(0).getDataTransazione()),
							theModel.getAppDataimpianto().getImpDataAssegnazione(), true)) {
					
						impianto.setImpDataAssegnazione(
								ConvertUtil.convertToString(codiceList.get(0).getDataTransazione()));
					}
					*/

					// Bug 27/08/2015
					//impianto.setInstId(ConvertUtil.convertToInteger(codiceList.get(0).getIdPersonaGiuridica()));

					getValidationMgr().validazioneFormaleSalvaImpianto(impianto, true, ruoloUtente.getDescRuolo());

					/*
					SigitTPersonaGiuridicaDto installatore = getDbMgr()
							.cercaSigitTPersonaGiuridicaAcqCodImpianto(impianto.getImpCodImpianto());
					impianto.setInstCf(installatore.getCodiceFiscale());
					impianto.setInstIdSiglaRea(installatore.getSiglaRea());
					impianto.setInstNumeroRea(ConvertUtil.convertToUDTPositiveInteger(installatore.getNumeroRea()));
					impianto.setInstImpresa(installatore.getDenominazione());
					impianto.setInstId(ConvertUtil.convertToInteger(installatore.getIdPersonaGiuridica()));
					*/
				} else {
					// SONO IN MODIFICA
					// se siamo nel caso di modifica impianto (Caso B) verificare se vi e' stata una modifica anche dell'ubicazione dell'impianto, 
					// verificare la presenza di almeno un libretto in stato CONSOLIDATO. 
					// Se presente la modifica di questa informazione e' possibile solo per il profilo "VALIDATORE" e "SUPER"; 
					// per tutti gli altri profili tale modifica non puo' essere possibile: emettere quindi il messaggio S027

					getValidationMgr().validazioneFormaleSalvaImpianto(impianto, true, ruoloUtente.getDescRuolo());

					//					if (!(utenteLoggato.getRuolo().getDescRuolo()
					//							.equalsIgnoreCase(Constants.RUOLO_SUPER) || utenteLoggato
					//							.getRuolo().getDescRuolo()
					//							.equalsIgnoreCase(Constants.RUOLO_VALIDATORE))) {
					getValidationMgr().verificaModificaUbicazioneImpiantoIdentificazione(impianto);
					//					}

				}

				String descComune = GenericUtil.getDescriptionByCod(impianto.getImpLocIdComune(),
						theModel.getAppDataelencoComuni());
				String descProvincia = GenericUtil.getDescriptionByCod(impianto.getImpLocIdProvincia(),
						theModel.getAppDataelencoProvince());
				impianto.setImpLocDescComune(ReplaceSpecialCharUtils.sanitize(descComune));
				impianto.setImpLocDescProvincia(ReplaceSpecialCharUtils.sanitize(descProvincia));

				if (GenericUtil.isNotNullOrEmpty(impianto.getImpLocIdIndirizzo())) {
					String descIndirizzoSitad = GenericUtil.getDescriptionByCod(impianto.getImpLocIdIndirizzo(),
							theModel.getAppDataelencoIndirizzi());

					impianto.setImpLocIndirizzoSitad(ReplaceSpecialCharUtils.sanitize(descIndirizzoSitad));
				}

				Responsabile responsabile = theModel.getAppDataresponsabile();

				getValidationMgr().validazioneFormaleSalvaResponsabile(responsabile, true);

				getValidationMgr().verificaDateResponsabile(responsabile,
						theModel.getAppDataimpianto().getImpCodImpianto());

				String descComuneResp = GenericUtil.getDescriptionByCod(responsabile.getIdComune(),
						theModel.getAppDataelencoComuniResp());
				String descProvinciaResp = GenericUtil.getDescriptionByCod(responsabile.getIdProvincia(),
						theModel.getAppDataelencoProvince());
				responsabile.setDescComune(ReplaceSpecialCharUtils.sanitize(descComuneResp));
				responsabile.setDescProvincia(ReplaceSpecialCharUtils.sanitize(descProvinciaResp));
				responsabile.setFlgResponsabile(true);

				if (GenericUtil.isNotNullOrEmpty(responsabile.getIdIndirizzo())) {
					String descIndirizzoSitad = GenericUtil.getDescriptionByCod(responsabile.getIdIndirizzo(),
							theModel.getAppDataelencoIndirizziResp());
					responsabile.setIndirizzoSitad(ReplaceSpecialCharUtils.sanitize(descIndirizzoSitad));
				}

				if (log.isDebugEnabled())
					GenericUtil.stampa(responsabile, true, 3);

				//				responsabile = getDbMgr().salvaResponsabile(responsabile,
				//						theModel.getAppDataimpianto().getImpCodImpianto(),
				//						theModel.getAppDatautenteLoggato().getCodiceFiscale());

				getSigitMgr().aggiungiCoordinateAdImpianto(impianto);

				impianto = getDbMgr().salvaImpiantoResponsabile(impianto, responsabile, utenteLoggato);

				// Setto all'old il nuovo stato impianto, cosi' nel caso del salvaggio riesco a capire se e' stato modificato
				impianto.setImpIdStatoImpOld(ReplaceSpecialCharUtils.sanitize(impianto.getImpIdStatoImp()));
				impianto.setImpDataDismissioneOld(ReplaceSpecialCharUtils.sanitize(impianto.getImpDataDismissione()));
				impianto.setImpMotivazioneOld(ReplaceSpecialCharUtils.sanitize(impianto.getImpMotivazione()));

				if (isInserimento) {

					if (theModel.getAppDataimpianto().getLogicaVisual().getCaso().intValue() == Constants.COD_CASO_A) {
						// Siccome ho inserito passo dal CASO_A al CASO_B (modifica)
						theModel.getAppDataimpianto().getLogicaVisual().setCaso(Constants.COD_CASO_B);
					}

					theModel.setAppDataimpianto(impianto);

					result.getGlobalMessages().add(Messages.INFO_INSERIMENTO_CORRETTO);

				} else {
					// SONO IN MODIFICA

					result.getGlobalMessages().add(Messages.INFO_MODIFICA_CORRETTA);

				}

				// impostazione del result code 
				result.setResultCode(SALVAIMPIANO_OUTCOME_CODE__OK);

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
			log.error("[BackEndFacade::salvaImpiano] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo visualizzaLibretto definito in un ExecCommand del
	 * ContentPanel cpGestImpiantoResp
	 */
	public ExecResults visualizzaLibretto(

			it.csi.sigit.sigitwebn.dto.gestisci_impianto_resp.CpGestImpiantoRespModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String VISUALIZZALIBRETTO_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String VISUALIZZALIBRETTO_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R289375388) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			String idImpianto = ConvertUtil.convertToString(theModel.getAppDataimpianto().getImpId());

			// Setto in sessione le variabili che servono per creare il libretto
			theModel.getSession().put(Constants.SESSIONE_VAR_ID_IMPIANTO, idImpianto);

			// impostazione del result code 
			result.setResultCode(VISUALIZZALIBRETTO_OUTCOME_CODE__OK);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::visualizzaLibretto] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo gestRapportoControllo definito in un ExecCommand del
	 * ContentPanel cpGestImpiantoResp
	 */
	public ExecResults gestRapportoControllo(

			it.csi.sigit.sigitwebn.dto.gestisci_impianto_resp.CpGestImpiantoRespModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GESTRAPPORTOCONTROLLO_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String GESTRAPPORTOCONTROLLO_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R886182905) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			theModel.setAppDatapaginaChiamanteImp(Constants.PAG_GEST_IMPIANTI_RESP);
			theModel.setAppDataisAbilitazioneDatiAllegato(false);
			log.debug("FRAAAAAAAAAAAAAA---> CODICE IMPIANTO: " + theModel.getAppDataimpianto().getImpCodImpianto());
			theModel.setAppDataidImpiantoSelez(theModel.getAppDataimpianto().getImpCodImpianto());

			// impostazione del result code 
			result.setResultCode(GESTRAPPORTOCONTROLLO_OUTCOME_CODE__OK);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::gestRapportoControllo] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo gestDocumentazione definito in un ExecCommand del
	 * ContentPanel cpGestImpiantoResp
	 */
	public ExecResults gestDocumentazione(

			it.csi.sigit.sigitwebn.dto.gestisci_impianto_resp.CpGestImpiantoRespModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GESTDOCUMENTAZIONE_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String GESTDOCUMENTAZIONE_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R1848337563) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			try {

				Impianto impianto = theModel.getAppDataimpianto();

				theModel.setAppDataidImpiantoSelez(ReplaceSpecialCharUtils.sanitize(impianto.getImpCodImpianto()));

				IdentificativoImpianto identificativo = getSigitMgr()
						.cercaIdentificativoImpianto(impianto.getImpCodImpianto());

				theModel.setAppDataidentificativoImpianto(identificativo);

				theModel.setAppDatapaginaChiamanteDocumenti(Constants.PAG_GEST_IMPIANTI_RESP);

				// impostazione del result code 
				result.setResultCode(GESTDOCUMENTAZIONE_OUTCOME_CODE__OK);
			} catch (ManagerException ex) {

				Validator.gestisciEccezione(result, ex);
			}

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::gestDocumentazione] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo gestLibrettoWeb definito in un ExecCommand del
	 * ContentPanel cpGestImpiantoResp
	 */
	public ExecResults gestLibrettoWeb(

			it.csi.sigit.sigitwebn.dto.gestisci_impianto_resp.CpGestImpiantoRespModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GESTLIBRETTOWEB_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String GESTLIBRETTOWEB_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R1666251631) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			try {

				Impianto impianto = theModel.getAppDataimpianto();

				theModel.setAppDataidImpiantoSelez(ReplaceSpecialCharUtils.sanitize(impianto.getImpCodImpianto()));

				IdentificativoImpianto identificativo = getSigitMgr()
						.cercaIdentificativoImpianto(ReplaceSpecialCharUtils.sanitize(impianto.getImpCodImpianto()));

				theModel.setAppDataidentificativoImpianto(identificativo);

				theModel.setAppDatapaginaChiamante(Constants.PAG_GEST_IMPIANTI_RESP);

				// impostazione del result code 
				result.setResultCode(GESTLIBRETTOWEB_OUTCOME_CODE__OK);
			} catch (ManagerException ex) {

				Validator.gestisciEccezione(result, ex);
			}

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::gestLibrettoWeb] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo gestAggLibretto definito in un ExecCommand del
	 * ContentPanel cpGestImpiantoResp
	 */
	public ExecResults gestAggLibretto(

			it.csi.sigit.sigitwebn.dto.gestisci_impianto_resp.CpGestImpiantoRespModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GESTAGGLIBRETTO_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String GESTAGGLIBRETTO_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-405212908) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			// impostazione del result code 
			result.setResultCode(GESTAGGLIBRETTO_OUTCOME_CODE__OK);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::gestAggLibretto] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo gestisciIndietro definito in un ExecCommand del
	 * ContentPanel cpGestImpiantoResp
	 */
	public ExecResults gestisciIndietro(

			it.csi.sigit.sigitwebn.dto.gestisci_impianto_resp.CpGestImpiantoRespModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GESTISCIINDIETRO_OUTCOME_CODE__IMPIANTO = //NOSONAR  Reason:EIAS
				"IMPIANTO"; //NOSONAR  Reason:EIAS
		final String GESTISCIINDIETRO_OUTCOME_CODE__SUBENTRO = //NOSONAR  Reason:EIAS
				"SUBENTRO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-1313901050) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			if (theModel.getAppDataimpianto().getLogicaVisual() == null)
				result.setResultCode(GESTISCIINDIETRO_OUTCOME_CODE__IMPIANTO);
			else {
				Integer logica = theModel.getAppDataimpianto().getLogicaVisual().getCaso();

				if (logica == Constants.COD_CASO_E) {
					// impostazione del result code 
					result.setResultCode(GESTISCIINDIETRO_OUTCOME_CODE__SUBENTRO);
				} else {
					theModel.setAppDataaggiornaElencoImpianti(true);

					// impostazione del result code 
					result.setResultCode(GESTISCIINDIETRO_OUTCOME_CODE__IMPIANTO);
				}
			}

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::gestisciIndietro] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo gestisciComboInit definito in un ExecCommand del
	 * ContentPanel cpGestImpiantoResp
	 */
	public ExecResults gestisciComboInit(

			it.csi.sigit.sigitwebn.dto.gestisci_impianto_resp.CpGestImpiantoRespModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GESTISCICOMBOINIT_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R1151029182) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			log.debug("SONO IN IMPIANTO!!!!");

			ArrayList<CodeDescription> statoImpianto = theModel.getAppDataelencoStatoImpianto();

			if (log.isDebugEnabled())
				GenericUtil.stampa(statoImpianto, true, 2);

			if (statoImpianto == null) {
				statoImpianto = getDbMgr().cercaListaStatiImpianto();
				theModel.setAppDataelencoStatoImpianto(statoImpianto);
			}

			/*
			ArrayList<CodeDescription> titoliResp = theModel
					.getAppDataelencoTitoli();
			
			if (titoliResp == null) {
				titoliResp = getDbMgr().cercaListaRuoloByDescRuoloFunzionale(Constants.RUOLO_RESPONSABILE);
				theModel.setAppDataelencoTitoli(titoliResp);
			}
			 */

			ArrayList<CodeDescription> comuniResp = new ArrayList<CodeDescription>();

			theModel.setAppDataelencoComuniResp(comuniResp);

			ArrayList<CodeDescription> indResp = new ArrayList<CodeDescription>();

			theModel.setAppDataelencoIndirizziResp(indResp);

			// impostazione del result code 
			result.setResultCode(GESTISCICOMBOINIT_OUTCOME_CODE__OK);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::gestisciComboInit] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo isRuoloAbilitato definito in un ExecCommand del
	 * ContentPanel cpGestImpiantoResp
	 */
	public ExecResults isRuoloAbilitato(

			it.csi.sigit.sigitwebn.dto.gestisci_impianto_resp.CpGestImpiantoRespModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String ISRUOLOABILITATO_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-1954045853) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			String descRuolo = theModel.getAppDatautenteLoggato().getRuolo().getDescRuolo();

			if (descRuolo.equals(Constants.RUOLO_RESPONSABILE) || descRuolo.equals(Constants.RUOLO_RESPONSABILE_IMPRESA)
					|| descRuolo.equals(Constants.RUOLO_3RESPONSABILE)) {
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
	 * Implementazione del metodo gestLogicaIngresso definito in un ExecCommand del
	 * ContentPanel cpGestImpiantoResp
	 */
	public ExecResults gestLogicaIngresso(

			it.csi.sigit.sigitwebn.dto.gestisci_impianto_resp.CpGestImpiantoRespModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GESTLOGICAINGRESSO_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String GESTLOGICAINGRESSO_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R490709967) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			try {
				Impianto impianto = theModel.getAppDataimpianto();

				//				settaListaRuoloResponsabile(theModel,
				//						Constants.RUOLO_RESPONSABILE);

				UtenteLoggato utenteLog = theModel.getAppDatautenteLoggato();

				LogicaVisualizzazione logica = impianto.getLogicaVisual();

				Responsabile responsabile = null;

				if (impianto != null && GenericUtil.isNotNullOrEmpty(impianto.getImpId())) {

					//					ArrayList<RisultatoRicResponsabile> responsabiliList = getDbMgr()
					//							.cercaResponsabiliByIdImpianto(impianto.getImpId());
					//
					//					theModel.setAppDataelencoResponsabili(responsabiliList);
					//
					//					ArrayList<RisultatoRicManutentore> manutentoriList = getDbMgr()
					//							.cercaManutentoriByIdImpianto(impianto.getImpId());
					//
					//					theModel.setAppDataelencoManutentori(manutentoriList);

					// Nel caso in cui arrivo dall'inseirmento/modifica proprietario
					Message msg = (Message) theModel.getSession().get(Constants.SESSIONE_VAR_MESSAGGE);

					log.debug("Stampo il messaggio: " + msg);

					if (msg != null) {
						log.debug("messaggio in sessione: " + msg.getType() + ", " + msg.getText());
						if (msg.getType() == Message.ERROR)
							result.getGlobalErrors().add(msg.getText());
						else
							result.getGlobalMessages().add(msg.getText());

						theModel.getSession().remove(Constants.SESSIONE_VAR_MESSAGGE);

						// Carico il proprietario eventualmente inserito
						impianto.setProprietario(
								getDbMgr().getProprietarioImpianto(ConvertUtil.convertToString(impianto.getImpId())));

					}
				}

				if (logica.getCaso() == Constants.COD_CASO_A) {
					Responsabile responsabileFilter = new Responsabile();

					if (utenteLog.getRuolo().getDescRuolo().equals(Constants.RUOLO_RESPONSABILE_IMPRESA)) {

						responsabileFilter.setCodiceFiscale(utenteLog.getRuolo().getCodiceFiscale());
						responsabileFilter.setIdSiglaRea(utenteLog.getRuolo().getSiglaRea());
						responsabileFilter.setNumeroRea(
								ConvertUtil.convertToUDTPositiveInteger(utenteLog.getRuolo().getNumeroRea()));
						responsabileFilter.setFlgImpresa(true);

					} else if (utenteLog.getRuolo().getDescRuolo().equals(Constants.RUOLO_RESPONSABILE)) {

						responsabileFilter.setCodiceFiscale(utenteLog.getCodiceFiscale());
						responsabileFilter.setFlgImpresa(false);

					}

					ArrayList<Responsabile> responsabili = getSigitMgr()
							.cercaResponsabiliByCodReaCodFiscaleDenominazione(responsabileFilter);

					if (responsabili != null && !responsabili.isEmpty() && responsabili.size() == 1) {
						//Responsabili responsabile = theModel.getAppDataresponsabili();

						// Se ho trovato un solo elemento lo setto direttamente
						responsabile = responsabili.get(0);
						responsabile.setDataInizioResp(null);

						if (log.isDebugEnabled())
							GenericUtil.stampa(responsabile, true, 3);

						// impostazione del result code
						result.setResultCode(GESTLOGICAINGRESSO_OUTCOME_CODE__OK);

					} else {
						result.getGlobalErrors().add(Messages.I003);

						// impostazione del result code
						result.setResultCode(GESTLOGICAINGRESSO_OUTCOME_CODE__KO);
					}

				} else if (logica.getCaso() == Constants.COD_CASO_B) {

					responsabile = getSigitMgr().cercaResponsabileAttivoByIdImpianto(impianto.getImpId());

					// impostazione del result code
					result.setResultCode(GESTLOGICAINGRESSO_OUTCOME_CODE__OK);
				}

				if (responsabile != null) {

					if (ConvertUtil.convertToBooleanAllways(responsabile.getFlgImpresa())) {
						settaListaRuoloResponsabile(theModel, Constants.RUOLO_RESPONSABILE_IMPRESA);
					} else {
						settaListaRuoloResponsabile(theModel, Constants.RUOLO_RESPONSABILE);
					}

					settaComuneVieResponsabile(theModel, responsabile);

					theModel.setAppDataresponsabile(responsabile);

					// Se true, vuol dire che il responsabile ha l'indirizzo impostato
					theModel.getAppDataimpianto().getLogicaVisual()
							.setIsResponsabileIndConfermato(GenericUtil.isNotNullOrEmpty(responsabile.getIdComune()));
				}

				// impostazione del result code 
				result.setResultCode(GESTLOGICAINGRESSO_OUTCOME_CODE__OK);
			} catch (ManagerException ex) {

				Validator.gestisciEccezione(result, ex);

			}

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::gestLogicaIngresso] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo gestisciVisualizzazione definito in un ExecCommand del
	 * ContentPanel cpGestImpiantoResp
	 */
	public ExecResults gestisciVisualizzazione(

			it.csi.sigit.sigitwebn.dto.gestisci_impianto_resp.CpGestImpiantoRespModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GESTISCIVISUALIZZAZIONE_OUTCOME_CODE__REGISTRAZIONE = //NOSONAR  Reason:EIAS
				"REGISTRAZIONE"; //NOSONAR  Reason:EIAS
		final String GESTISCIVISUALIZZAZIONE_OUTCOME_CODE__VISUALIZZAZIONE = //NOSONAR  Reason:EIAS
				"VISUALIZZAZIONE"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-1603467363) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			Integer logica = theModel.getAppDataimpianto().getLogicaVisual().getCaso();
			if (logica == Constants.COD_CASO_A || logica == Constants.COD_CASO_B || logica == Constants.COD_CASO_E) {
				// Sono in inserimento o modifica o subentro

				log.debug("***REGISTRAZIONE***\n\n");

				// impostazione del result code 
				result.setResultCode(GESTISCIVISUALIZZAZIONE_OUTCOME_CODE__REGISTRAZIONE);
			} else {
				log.debug("***VISUALIZZAZIONE***\n\n");

				// impostazione del result code 
				result.setResultCode(GESTISCIVISUALIZZAZIONE_OUTCOME_CODE__VISUALIZZAZIONE);
			}
			log.debug("****** " + result.getResultCode() + " ******");

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::gestisciVisualizzazione] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo gestLogicaCodImp definito in un ExecCommand del
	 * ContentPanel cpGestImpiantoResp
	 */
	public ExecResults gestLogicaCodImp(

			it.csi.sigit.sigitwebn.dto.gestisci_impianto_resp.CpGestImpiantoRespModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GESTLOGICACODIMP_OUTCOME_CODE__ABILITA_COD_IMP = //NOSONAR  Reason:EIAS
				"ABILITA_COD_IMP"; //NOSONAR  Reason:EIAS
		final String GESTLOGICACODIMP_OUTCOME_CODE__DISABILITA_COD_IMP = //NOSONAR  Reason:EIAS
				"DISABILITA_COD_IMP"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-1086515083) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			LogicaVisualizzazione logica = theModel.getAppDataimpianto().getLogicaVisual();

			if (logica.getCaso() == Constants.COD_CASO_A) {
				// Sono in inserimento
				log.debug("***ABILITA_COD_IMP***\n\n");
				// impostazione del result code 
				result.setResultCode(GESTLOGICACODIMP_OUTCOME_CODE__ABILITA_COD_IMP);
			} else {
				log.debug("***DISABILITA_COD_IMP***\n\n");
				// impostazione del result code 
				result.setResultCode(GESTLOGICACODIMP_OUTCOME_CODE__DISABILITA_COD_IMP);
			}

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::gestLogicaCodImp] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo gestLogicaCodImpDataAss definito in un ExecCommand del
	 * ContentPanel cpGestImpiantoResp
	 */
	public ExecResults gestLogicaCodImpDataAss(

			it.csi.sigit.sigitwebn.dto.gestisci_impianto_resp.CpGestImpiantoRespModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GESTLOGICACODIMPDATAASS_OUTCOME_CODE__ABILITA_COD_IMP_DATA = //NOSONAR  Reason:EIAS
				"ABILITA_COD_IMP_DATA"; //NOSONAR  Reason:EIAS
		final String GESTLOGICACODIMPDATAASS_OUTCOME_CODE__DISABILITA_COD_IMP_DATA = //NOSONAR  Reason:EIAS
				"DISABILITA_COD_IMP_DATA"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-1463385844) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			// QUESTO METODO NON VIENE PIU' RICHIAMATO

			LogicaVisualizzazione logica = theModel.getAppDataimpianto().getLogicaVisual();

			if (logica.getCaso() == Constants.COD_CASO_A || logica.getCaso() == Constants.COD_CASO_E) {
				// Sono in inserimento
				log.debug("***ABILITA_COD_IMP_DATA***\n\n");
				// impostazione del result code 
				result.setResultCode(GESTLOGICACODIMPDATAASS_OUTCOME_CODE__ABILITA_COD_IMP_DATA);
			} else {
				log.debug("***DISABILITA_COD_IMP_DATA***\n\n");
				// impostazione del result code 
				result.setResultCode(GESTLOGICACODIMPDATAASS_OUTCOME_CODE__DISABILITA_COD_IMP_DATA);
			}

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::gestLogicaCodImpDataAss] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo gestAbilLogicaImpLocIndirizzo definito in un ExecCommand del
	 * ContentPanel cpGestImpiantoResp
	 */
	public ExecResults gestAbilLogicaImpLocIndirizzo(

			it.csi.sigit.sigitwebn.dto.gestisci_impianto_resp.CpGestImpiantoRespModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GESTABILLOGICAIMPLOCINDIRIZZO_OUTCOME_CODE__ABILITA_IMP_IND_CERCATO = //NOSONAR  Reason:EIAS
				"ABILITA_IMP_IND_CERCATO"; //NOSONAR  Reason:EIAS
		final String GESTABILLOGICAIMPLOCINDIRIZZO_OUTCOME_CODE__ABILITA_IMP_IND_NON_CERCATO = //NOSONAR  Reason:EIAS
				"ABILITA_IMP_IND_NON_CERCATO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-269632647) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			Boolean isImpiantoIndConfermato = theModel.getAppDataimpianto().getLogicaVisual()
					.getIsImpiantoIndConfermato();
			if (isImpiantoIndConfermato != null && isImpiantoIndConfermato) {

				// impostazione del result code 
				result.setResultCode(GESTABILLOGICAIMPLOCINDIRIZZO_OUTCOME_CODE__ABILITA_IMP_IND_CERCATO);
			} else {
				// impostazione del result code 
				result.setResultCode(GESTABILLOGICAIMPLOCINDIRIZZO_OUTCOME_CODE__ABILITA_IMP_IND_NON_CERCATO);
			}

			log.debug("****** " + result.getResultCode() + " ******");

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::gestAbilLogicaImpLocIndirizzo] Errore occorso nell'esecuzione del metodo:" + e,
					e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo gestLogicaSalvaImp definito in un ExecCommand del
	 * ContentPanel cpGestImpiantoResp
	 */
	public ExecResults gestLogicaSalvaImp(

			it.csi.sigit.sigitwebn.dto.gestisci_impianto_resp.CpGestImpiantoRespModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GESTLOGICASALVAIMP_OUTCOME_CODE__VISUALIZZA_BOT_SALVA_IMP = //NOSONAR  Reason:EIAS
				"VISUALIZZA_BOT_SALVA_IMP"; //NOSONAR  Reason:EIAS
		final String GESTLOGICASALVAIMP_OUTCOME_CODE__NASCONDI_BOT_SALVA_IMP = //NOSONAR  Reason:EIAS
				"NASCONDI_BOT_SALVA_IMP"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R742530502) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			Impianto impianto = theModel.getAppDataimpianto();
			Integer logica = impianto.getLogicaVisual().getCaso();

			if (log.isDebugEnabled())
				GenericUtil.stampa(impianto, true, 3);

			if ((logica == Constants.COD_CASO_A || logica == Constants.COD_CASO_B || logica == Constants.COD_CASO_E)) {
				// impostazione del result code 
				result.setResultCode(GESTLOGICASALVAIMP_OUTCOME_CODE__VISUALIZZA_BOT_SALVA_IMP);
			} else {
				// impostazione del result code 
				result.setResultCode(GESTLOGICASALVAIMP_OUTCOME_CODE__NASCONDI_BOT_SALVA_IMP);
			}

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::gestLogicaSalvaImp] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo gestisciLogicaImpPresenteInit definito in un ExecCommand del
	 * ContentPanel cpGestImpiantoResp
	 */
	public ExecResults gestisciLogicaImpPresenteInit(

			it.csi.sigit.sigitwebn.dto.gestisci_impianto_resp.CpGestImpiantoRespModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GESTISCILOGICAIMPPRESENTEINIT_OUTCOME_CODE__PRESENTE = //NOSONAR  Reason:EIAS
				"PRESENTE"; //NOSONAR  Reason:EIAS
		final String GESTISCILOGICAIMPPRESENTEINIT_OUTCOME_CODE__NON_PRESENTE = //NOSONAR  Reason:EIAS
				"NON_PRESENTE"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R677695673) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			Impianto impianto = theModel.getAppDataimpianto();

			log.debug("\n\n gestisciLogicaImpPresenteInit STAMPO l'impianto.getImpId(): " + impianto.getImpId());

			if (GenericUtil.isNotNullOrEmpty(impianto.getImpId())) {
				// impostazione del result code 
				result.setResultCode(GESTISCILOGICAIMPPRESENTEINIT_OUTCOME_CODE__PRESENTE);

			} else {
				// impostazione del result code 
				result.setResultCode(GESTISCILOGICAIMPPRESENTEINIT_OUTCOME_CODE__NON_PRESENTE);

			}

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::gestisciLogicaImpPresenteInit] Errore occorso nell'esecuzione del metodo:" + e,
					e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo gestLogicaBotRappControlloInit definito in un ExecCommand del
	 * ContentPanel cpGestImpiantoResp
	 */
	public ExecResults gestLogicaBotRappControlloInit(

			it.csi.sigit.sigitwebn.dto.gestisci_impianto_resp.CpGestImpiantoRespModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GESTLOGICABOTRAPPCONTROLLOINIT_OUTCOME_CODE__VISUALIZZA = //NOSONAR  Reason:EIAS
				"VISUALIZZA"; //NOSONAR  Reason:EIAS
		final String GESTLOGICABOTRAPPCONTROLLOINIT_OUTCOME_CODE__NASCONDI = //NOSONAR  Reason:EIAS
				"NASCONDI"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R1119206159) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			if (getSigitMgr().isPresenteLibretto(theModel.getAppDataimpianto().getImpCodImpianto())) {
				// impostazione del result code 
				result.setResultCode(GESTLOGICABOTRAPPCONTROLLOINIT_OUTCOME_CODE__VISUALIZZA);
			} else {
				// impostazione del result code 
				result.setResultCode(GESTLOGICABOTRAPPCONTROLLOINIT_OUTCOME_CODE__NASCONDI);
			}

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::gestLogicaBotRappControlloInit] Errore occorso nell'esecuzione del metodo:" + e,
					e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo gestVisLogicaImpLocIndirizzo definito in un ExecCommand del
	 * ContentPanel cpGestImpiantoResp
	 */
	public ExecResults gestVisLogicaImpLocIndirizzo(

			it.csi.sigit.sigitwebn.dto.gestisci_impianto_resp.CpGestImpiantoRespModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GESTVISLOGICAIMPLOCINDIRIZZO_OUTCOME_CODE__VISUALIZZA_IMP_IND_CERCATO = //NOSONAR  Reason:EIAS
				"VISUALIZZA_IMP_IND_CERCATO"; //NOSONAR  Reason:EIAS
		final String GESTVISLOGICAIMPLOCINDIRIZZO_OUTCOME_CODE__VISUALIZZA_IMP_IND_NON_CERCATO = //NOSONAR  Reason:EIAS
				"VISUALIZZA_IMP_IND_NON_CERCATO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R1211625941) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			Boolean isImpiantoIndConfermato = theModel.getAppDataimpianto().getLogicaVisual()
					.getIsImpiantoIndConfermato();
			if (isImpiantoIndConfermato != null && isImpiantoIndConfermato) {

				Impianto impianto = theModel.getAppDataimpianto();
				if (GenericUtil.isNotNullOrEmpty(impianto.getImpLocIdIndirizzo())) {

					ArrayList<CodeDescription> vie = new ArrayList<CodeDescription>();

					CodeDescription via = new CodeDescription();
					via.setCode(impianto.getImpLocIdIndirizzo());
					via.setDescription(impianto.getImpLocIndirizzoSitad());

					vie.add(via);

					theModel.setAppDataelencoIndirizzi(vie);

				} else {
					theModel.setAppDataelencoIndirizzi(new ArrayList<CodeDescription>());
				}

				// impostazione del result code 
				result.setResultCode(GESTVISLOGICAIMPLOCINDIRIZZO_OUTCOME_CODE__VISUALIZZA_IMP_IND_CERCATO);
			} else {
				// impostazione del result code 
				result.setResultCode(GESTVISLOGICAIMPLOCINDIRIZZO_OUTCOME_CODE__VISUALIZZA_IMP_IND_NON_CERCATO);
			}

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::gestVisLogicaImpLocIndirizzo] Errore occorso nell'esecuzione del metodo:" + e,
					e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo gestTipoIndirizzoEnt definito in un ExecCommand del
	 * ContentPanel cpGestImpiantoResp
	 */
	public ExecResults gestTipoIndirizzoEnt(

			it.csi.sigit.sigitwebn.dto.gestisci_impianto_resp.CpGestImpiantoRespModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GESTTIPOINDIRIZZOENT_OUTCOME_CODE__NAZIONALE = //NOSONAR  Reason:EIAS
				"NAZIONALE"; //NOSONAR  Reason:EIAS
		final String GESTTIPOINDIRIZZOENT_OUTCOME_CODE__ESTERO = //NOSONAR  Reason:EIAS
				"ESTERO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-1509651301) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			Responsabile responsabile = theModel.getAppDataresponsabile();

			if (ConvertUtil.convertToBooleanAllways(responsabile.getFlgIndirizzoEst())) {
				// impostazione del result code 
				result.setResultCode(GESTTIPOINDIRIZZOENT_OUTCOME_CODE__ESTERO);
			} else {
				// impostazione del result code 
				result.setResultCode(GESTTIPOINDIRIZZOENT_OUTCOME_CODE__NAZIONALE);
			}

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::gestTipoIndirizzoEnt] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo gestAbilLogicaRespIndirizzoEnt definito in un ExecCommand del
	 * ContentPanel cpGestImpiantoResp
	 */
	public ExecResults gestAbilLogicaRespIndirizzoEnt(

			it.csi.sigit.sigitwebn.dto.gestisci_impianto_resp.CpGestImpiantoRespModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GESTABILLOGICARESPINDIRIZZOENT_OUTCOME_CODE__ABILITA_RESP_IND_CERCATO = //NOSONAR  Reason:EIAS
				"ABILITA_RESP_IND_CERCATO"; //NOSONAR  Reason:EIAS
		final String GESTABILLOGICARESPINDIRIZZOENT_OUTCOME_CODE__ABILITA_RESP_IND_NON_CERCATO = //NOSONAR  Reason:EIAS
				"ABILITA_RESP_IND_NON_CERCATO"; //NOSONAR  Reason:EIAS
		final String GESTABILLOGICARESPINDIRIZZOENT_OUTCOME_CODE__DISABILITA_RESP_IND = //NOSONAR  Reason:EIAS
				"DISABILITA_RESP_IND"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R298758872) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			Responsabile responsabile = theModel.getAppDataresponsabile();

			if (responsabile != null && ConvertUtil.convertToBooleanAllways(responsabile.getFlgAccreditato())
					&& ConvertUtil.convertToBooleanAllways(responsabile.getFlgImpresa())) {

				// E' da disabilitare la ricerca per indirizzo (manutentore e' una persona giuridica con flgInstallatore e/o flgManutentore e/o flgAmministratore)
				// impostazione del result code 
				result.setResultCode(GESTABILLOGICARESPINDIRIZZOENT_OUTCOME_CODE__DISABILITA_RESP_IND);
			} else {

				if (theModel.getAppDataimpianto().getLogicaVisual() != null && ConvertUtil.convertToBooleanAllways(
						theModel.getAppDataimpianto().getLogicaVisual().getIsResponsabileIndConfermato())) {
					// impostazione del result code 
					result.setResultCode(GESTABILLOGICARESPINDIRIZZOENT_OUTCOME_CODE__ABILITA_RESP_IND_CERCATO);
				} else {
					// impostazione del result code 
					result.setResultCode(GESTABILLOGICARESPINDIRIZZOENT_OUTCOME_CODE__ABILITA_RESP_IND_NON_CERCATO);
				}
			}

			log.debug("****** " + result.getResultCode() + " ******");
			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session"

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::gestAbilLogicaRespIndirizzoEnt] Errore occorso nell'esecuzione del metodo:" + e,
					e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo gestisciComboImpComuni definito in un ExecCommand del
	 * ContentPanel cpGestImpiantoResp
	 */
	public ExecResults gestisciComboImpComuni(

			it.csi.sigit.sigitwebn.dto.gestisci_impianto_resp.CpGestImpiantoRespModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GESTISCICOMBOIMPCOMUNI_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-626086353) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			ArrayList<CodeDescription> comuniLoc = recuperaComuni(theModel.getAppDataimpianto().getImpLocIdProvincia());

			theModel.setAppDataelencoComuni(comuniLoc);

			result.setResultCode(GESTISCICOMBOIMPCOMUNI_OUTCOME_CODE__OK);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::gestisciComboImpComuni] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo gestLogicaBotVisLibrettoInit definito in un ExecCommand del
	 * ContentPanel cpGestImpiantoResp
	 */
	public ExecResults gestLogicaBotVisLibrettoInit(

			it.csi.sigit.sigitwebn.dto.gestisci_impianto_resp.CpGestImpiantoRespModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GESTLOGICABOTVISLIBRETTOINIT_OUTCOME_CODE__VISUALIZZA = //NOSONAR  Reason:EIAS
				"VISUALIZZA"; //NOSONAR  Reason:EIAS
		final String GESTLOGICABOTVISLIBRETTOINIT_OUTCOME_CODE__NASCONDI = //NOSONAR  Reason:EIAS
				"NASCONDI"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-827329783) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			if (getSigitMgr().isPresenteLibretto(theModel.getAppDataimpianto().getImpCodImpianto())) {
				// impostazione del result code 
				result.setResultCode(GESTLOGICABOTVISLIBRETTOINIT_OUTCOME_CODE__VISUALIZZA);
			} else {
				// impostazione del result code 
				result.setResultCode(GESTLOGICABOTVISLIBRETTOINIT_OUTCOME_CODE__NASCONDI);
			}

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::gestLogicaBotVisLibrettoInit] Errore occorso nell'esecuzione del metodo:" + e,
					e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo gestLogicaImpresaEnte definito in un ExecCommand del
	 * ContentPanel cpGestImpiantoResp
	 */
	public ExecResults gestLogicaImpresaEnte(

			it.csi.sigit.sigitwebn.dto.gestisci_impianto_resp.CpGestImpiantoRespModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GESTLOGICAIMPRESAENTE_OUTCOME_CODE__SI = //NOSONAR  Reason:EIAS
				"SI"; //NOSONAR  Reason:EIAS
		final String GESTLOGICAIMPRESAENTE_OUTCOME_CODE__NO = //NOSONAR  Reason:EIAS
				"NO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R1334411496) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:
			Responsabile responsabile = theModel.getAppDataresponsabile();

			if (responsabile.getFlgImpresa()) {

				theModel.getAppDataresponsabile().setNome(null);

				settaListaRuoloResponsabile(theModel, Constants.RUOLO_RESPONSABILE_IMPRESA);

				log.debug("Sono entrato - e' un'impresa (da spostare il controllo)");

				// impostazione del result code
				result.setResultCode(GESTLOGICAIMPRESAENTE_OUTCOME_CODE__SI);
			} else {

				theModel.getAppDataresponsabile().setIdSiglaRea(null);
				theModel.getAppDataresponsabile().setNumeroRea(null);

				settaListaRuoloResponsabile(theModel, Constants.RUOLO_RESPONSABILE);

				// impostazione del result code
				result.setResultCode(GESTLOGICAIMPRESAENTE_OUTCOME_CODE__NO);
			}
			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::gestLogicaImpresaEnte] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo gestisciLogicaImpPresente definito in un ExecCommand del
	 * ContentPanel cpGestImpiantoResp
	 */
	public ExecResults gestisciLogicaImpPresente(

			it.csi.sigit.sigitwebn.dto.gestisci_impianto_resp.CpGestImpiantoRespModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GESTISCILOGICAIMPPRESENTE_OUTCOME_CODE__PRESENTE = //NOSONAR  Reason:EIAS
				"PRESENTE"; //NOSONAR  Reason:EIAS
		final String GESTISCILOGICAIMPPRESENTE_OUTCOME_CODE__NON_PRESENTE = //NOSONAR  Reason:EIAS
				"NON_PRESENTE"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R1948287593) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			Impianto impianto = theModel.getAppDataimpianto();

			if (log.isDebugEnabled())
				GenericUtil.stampa(impianto, true, 3);

			log.debug("######## VERIFICO gestisciLogicaImpPresente");
			log.debug("######## VERIFICO gestisciLogicaImpPresente");

			if (GenericUtil.isNotNullOrEmpty(impianto.getImpId())) {
				// impostazione del result code 
				result.setResultCode(GESTISCILOGICAIMPPRESENTE_OUTCOME_CODE__PRESENTE);

				log.debug("#### PRESENTE ####");

			} else {
				// impostazione del result code 
				result.setResultCode(GESTISCILOGICAIMPPRESENTE_OUTCOME_CODE__NON_PRESENTE);

				log.debug("#### NON PRESENTE ####");

			}

			log.debug("****** " + result.getResultCode() + " ******");

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::gestisciLogicaImpPresente] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo gestLogicaBotVisLibretto definito in un ExecCommand del
	 * ContentPanel cpGestImpiantoResp
	 */
	public ExecResults gestLogicaBotVisLibretto(

			it.csi.sigit.sigitwebn.dto.gestisci_impianto_resp.CpGestImpiantoRespModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GESTLOGICABOTVISLIBRETTO_OUTCOME_CODE__VISUALIZZA = //NOSONAR  Reason:EIAS
				"VISUALIZZA"; //NOSONAR  Reason:EIAS
		final String GESTLOGICABOTVISLIBRETTO_OUTCOME_CODE__NASCONDI = //NOSONAR  Reason:EIAS
				"NASCONDI"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R1668893881) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			if (getSigitMgr().isPresenteLibretto(theModel.getAppDataimpianto().getImpCodImpianto())) {
				// impostazione del result code 
				result.setResultCode(GESTLOGICABOTVISLIBRETTO_OUTCOME_CODE__VISUALIZZA);
			} else {
				// impostazione del result code 
				result.setResultCode(GESTLOGICABOTVISLIBRETTO_OUTCOME_CODE__NASCONDI);
			}

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::gestLogicaBotVisLibretto] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo gestTipoIndirizzoAft definito in un ExecCommand del
	 * ContentPanel cpGestImpiantoResp
	 */
	public ExecResults gestTipoIndirizzoAft(

			it.csi.sigit.sigitwebn.dto.gestisci_impianto_resp.CpGestImpiantoRespModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GESTTIPOINDIRIZZOAFT_OUTCOME_CODE__NAZIONALE = //NOSONAR  Reason:EIAS
				"NAZIONALE"; //NOSONAR  Reason:EIAS
		final String GESTTIPOINDIRIZZOAFT_OUTCOME_CODE__ESTERO = //NOSONAR  Reason:EIAS
				"ESTERO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R1598947095) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			Responsabile responsabile = theModel.getAppDataresponsabile();

			if (ConvertUtil.convertToBooleanAllways(responsabile.getFlgIndirizzoEst())) {
				// impostazione del result code 
				result.setResultCode(GESTTIPOINDIRIZZOAFT_OUTCOME_CODE__ESTERO);
			} else {
				// impostazione del result code 
				result.setResultCode(GESTTIPOINDIRIZZOAFT_OUTCOME_CODE__NAZIONALE);
			}

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::gestTipoIndirizzoAft] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo gestAbilLogicaRespIndirizzo definito in un ExecCommand del
	 * ContentPanel cpGestImpiantoResp
	 */
	public ExecResults gestAbilLogicaRespIndirizzo(

			it.csi.sigit.sigitwebn.dto.gestisci_impianto_resp.CpGestImpiantoRespModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GESTABILLOGICARESPINDIRIZZO_OUTCOME_CODE__ABILITA_RESP_IND_CERCATO = //NOSONAR  Reason:EIAS
				"ABILITA_RESP_IND_CERCATO"; //NOSONAR  Reason:EIAS
		final String GESTABILLOGICARESPINDIRIZZO_OUTCOME_CODE__ABILITA_RESP_IND_NON_CERCATO = //NOSONAR  Reason:EIAS
				"ABILITA_RESP_IND_NON_CERCATO"; //NOSONAR  Reason:EIAS
		final String GESTABILLOGICARESPINDIRIZZO_OUTCOME_CODE__DISABILITA_RESP_IND = //NOSONAR  Reason:EIAS
				"DISABILITA_RESP_IND"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R275409973) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			Responsabile responsabile = theModel.getAppDataresponsabile();

			if (responsabile != null && ConvertUtil.convertToBooleanAllways(responsabile.getFlgAccreditato())
					&& ConvertUtil.convertToBooleanAllways(responsabile.getFlgImpresa())) {

				// E' da disabilitare la ricerca per indirizzo (manutentore e' una persona giuridica con flgInstallatore e/o flgManutentore e/o flgAmministratore)
				// impostazione del result code 
				result.setResultCode(GESTABILLOGICARESPINDIRIZZO_OUTCOME_CODE__DISABILITA_RESP_IND);
			} else {

				if (theModel.getAppDataimpianto().getLogicaVisual() != null && ConvertUtil.convertToBooleanAllways(
						theModel.getAppDataimpianto().getLogicaVisual().getIsResponsabileIndConfermato())) {
					// impostazione del result code 
					result.setResultCode(GESTABILLOGICARESPINDIRIZZO_OUTCOME_CODE__ABILITA_RESP_IND_CERCATO);
				} else {
					// impostazione del result code 
					result.setResultCode(GESTABILLOGICARESPINDIRIZZO_OUTCOME_CODE__ABILITA_RESP_IND_NON_CERCATO);
				}
			}

			log.debug("****** " + result.getResultCode() + " ******");
			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::gestAbilLogicaRespIndirizzo] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo gestLogicaBotInsModLibretto definito in un ExecCommand del
	 * ContentPanel cpGestImpiantoResp
	 */
	public ExecResults gestLogicaBotInsModLibretto(

			it.csi.sigit.sigitwebn.dto.gestisci_impianto_resp.CpGestImpiantoRespModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GESTLOGICABOTINSMODLIBRETTO_OUTCOME_CODE__VISUALIZZA = //NOSONAR  Reason:EIAS
				"VISUALIZZA"; //NOSONAR  Reason:EIAS
		final String GESTLOGICABOTINSMODLIBRETTO_OUTCOME_CODE__NASCONDI = //NOSONAR  Reason:EIAS
				"NASCONDI"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-1696042979) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			if (theModel.getAppDataimpianto() != null
					&& GenericUtil.isNotNullOrEmpty(theModel.getAppDataimpianto().getImpId())) {
				// impostazione del result code 
				result.setResultCode(GESTLOGICABOTINSMODLIBRETTO_OUTCOME_CODE__VISUALIZZA);
			} else {
				// impostazione del result code 
				result.setResultCode(GESTLOGICABOTINSMODLIBRETTO_OUTCOME_CODE__NASCONDI);
			}

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::gestLogicaBotInsModLibretto] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo aggiornaDatiPagina definito in un ExecCommand del
	 * ContentPanel cpGestImpiantoResp
	 */
	public ExecResults aggiornaDatiPagina(

			it.csi.sigit.sigitwebn.dto.gestisci_impianto_resp.CpGestImpiantoRespModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String AGGIORNADATIPAGINA_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-570525419) ENABLED START*/

			Message msg = (Message) theModel.getSession().get(Constants.SESSIONE_VAR_MESSAGGE);
			if (msg != null) {
				log.debug("messaggio in sessione: " + msg.getType() + ", " + msg.getText());
				if (msg.getType() == Message.ERROR)
					result.getGlobalErrors().add(msg.getText());
				else
					result.getGlobalMessages().add(msg.getText());

				theModel.getSession().remove(Constants.SESSIONE_VAR_MESSAGGE);

				//aggiornare impianto con i dati del libretto
				Impianto impiantoInSessione = theModel.getAppDataimpianto();
				if (impiantoInSessione != null && GenericUtil.isNotNullOrEmpty(impiantoInSessione.getImpId())) {

					String codImpianto = impiantoInSessione.getImpCodImpianto();
					if (codImpianto != null) {

						LogicaVisualizzazione logicaVis = impiantoInSessione.getLogicaVisual();

						Impianto impianto = getDbMgr().cercaImpiantoById(codImpianto);

						impianto.setLogicaVisual(logicaVis);

						theModel.setAppDataimpianto(impianto);
						//						ArrayList<RisultatoRicManutentore> manutentoriList = getDbMgr()
						//								.cercaManutentoriByIdImpianto(
						//										impianto.getImpId());
						//						theModel.setAppDataelencoManutentori(manutentoriList);
					}
				}
			}
			result.setResultCode(AGGIORNADATIPAGINA_OUTCOME_CODE__OK);
			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::aggiornaDatiPagina] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo gestLogicaBotVisLibrettoRefresh definito in un ExecCommand del
	 * ContentPanel cpGestImpiantoResp
	 */
	public ExecResults gestLogicaBotVisLibrettoRefresh(

			it.csi.sigit.sigitwebn.dto.gestisci_impianto_resp.CpGestImpiantoRespModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GESTLOGICABOTVISLIBRETTOREFRESH_OUTCOME_CODE__VISUALIZZA = //NOSONAR  Reason:EIAS
				"VISUALIZZA"; //NOSONAR  Reason:EIAS
		final String GESTLOGICABOTVISLIBRETTOREFRESH_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R581811812) ENABLED START*/

			if (getSigitMgr().isPresenteLibretto(theModel.getAppDataimpianto().getImpCodImpianto())) {
				result.setResultCode(GESTLOGICABOTVISLIBRETTOREFRESH_OUTCOME_CODE__VISUALIZZA);
			} else {
				result.setResultCode(GESTLOGICABOTVISLIBRETTOREFRESH_OUTCOME_CODE__KO);
			}
			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::gestLogicaBotVisLibrettoRefresh] Errore occorso nell'esecuzione del metodo:" + e,
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
	/*PROTECTED REGION ID(R-2102343004) ENABLED START*/
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

	private ArrayList<CodeDescription> recuperaComuni(String idProvSel) throws ServiceException {

		ArrayList<CodeDescription> comuniLoc = new ArrayList<CodeDescription>();

		if (GenericUtil.isNotNullOrEmpty(idProvSel)) {

			// Localizzazione COMUNE 
			log.debug("STAMPO idProvSelLoc: " + idProvSel);

			comuniLoc = (ArrayList<CodeDescription>) getServiziMgr().getListaComuniByIstatProvincia(idProvSel);

		}

		return comuniLoc;
	}

	private void settaComuneVieResponsabile(
			it.csi.sigit.sigitwebn.dto.gestisci_impianto_resp.CpGestImpiantoRespModel theModel,
			Responsabile responsabile) throws ServiceException {
		if (GenericUtil.isNotNullOrEmpty(responsabile.getIdIndirizzo())) {

			ArrayList<CodeDescription> vie = new ArrayList<CodeDescription>();

			CodeDescription via = new CodeDescription();
			via.setCode(responsabile.getIdIndirizzo());
			via.setDescription(responsabile.getIndirizzoSitad());

			vie.add(via);

			theModel.setAppDataelencoIndirizziResp(vie);

		} else {
			theModel.setAppDataelencoIndirizziResp(new ArrayList<CodeDescription>());
		}

		if (GenericUtil.isNotNullOrEmpty(responsabile.getIdProvincia())) {
			theModel.setAppDataelencoComuniResp(
					getServiziMgr().getListaComuniByIstatProvincia(responsabile.getIdProvincia()));

		} else {
			theModel.setAppDataelencoComuniResp(new ArrayList<CodeDescription>());
		}
	}

	private void settaListaRuoloResponsabile(
			it.csi.sigit.sigitwebn.dto.gestisci_impianto_resp.CpGestImpiantoRespModel theModel, String descRuoloFunz)
			throws DbManagerException {
		ArrayList<CodeDescription> titoliResp = getDbMgr().cercaListaRuoloByDescRuoloFunzionale(descRuoloFunz);
		theModel.setAppDataelencoTitoli(titoliResp);
	}

	/*PROTECTED REGION END*/
}
