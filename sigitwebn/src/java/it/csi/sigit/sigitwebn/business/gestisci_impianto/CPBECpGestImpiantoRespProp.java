package it.csi.sigit.sigitwebn.business.gestisci_impianto;

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

/*PROTECTED REGION ID(R347177965) ENABLED START*/
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.SigitRPfPgDelegaDto;
import it.csi.sigit.sigitwebn.business.manager.DbMgr;
import it.csi.sigit.sigitwebn.business.manager.ServiziMgr;
import it.csi.sigit.sigitwebn.business.manager.SigitMgr;
import it.csi.sigit.sigitwebn.business.manager.ValidationMgr;
import it.csi.sigit.sigitwebn.business.manager.util.DbManagerException;
import it.csi.sigit.sigitwebn.business.manager.util.ManagerException;
import it.csi.sigit.sigitwebn.business.manager.util.Message;
import it.csi.sigit.sigitwebn.business.manager.util.ServiceException;
import it.csi.sigit.sigitwebn.business.manager.util.ValidationManagerException;

/*PROTECTED REGION END*/

public class CPBECpGestImpiantoRespProp {

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

	// ApplicationData: [idResponsabileSelez, scope:USER_SESSION]
	public static final String APPDATA_IDRESPONSABILESELEZ_CODE = "appDataidResponsabileSelez";

	// ApplicationData: [elencoManutentori, scope:USER_SESSION]
	public static final String APPDATA_ELENCOMANUTENTORI_CODE = "appDataelencoManutentori";

	// ApplicationData: [elencoResponsabili, scope:USER_SESSION]
	public static final String APPDATA_ELENCORESPONSABILI_CODE = "appDataelencoResponsabili";

	// ApplicationData: [elencoResponsabiliTemp, scope:USER_SESSION]
	public static final String APPDATA_ELENCORESPONSABILITEMP_CODE = "appDataelencoResponsabiliTemp";

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

	// ApplicationData: [provenienza, scope:USER_SESSION]
	public static final String APPDATA_PROVENIENZA_CODE = "appDataprovenienza";

	// ApplicationData: [identificativoImpianto, scope:USER_SESSION]
	public static final String APPDATA_IDENTIFICATIVOIMPIANTO_CODE = "appDataidentificativoImpianto";

	// ApplicationData: [paginaChiamanteDocumenti, scope:USER_SESSION]
	public static final String APPDATA_PAGINACHIAMANTEDOCUMENTI_CODE = "appDatapaginaChiamanteDocumenti";

	// ApplicationData: [paginaChiamante, scope:USER_SESSION]
	public static final String APPDATA_PAGINACHIAMANTE_CODE = "appDatapaginaChiamante";

	//////////////////////////////////////////////////////////////////////////////
	/// Metodi associati alla U.I.
	//////////////////////////////////////////////////////////////////////////////

	// nome del content panel associato al bean
	public static final String CPNAME = "cpGestImpiantoRespProp";

	public static final String MULTIPANEL_MPRESPPROP = "mpRespProp";
	public static final String MPI_MPRESPPROP_FPGESTIMPIANTORESPONSABILETITOLO = CPNAME + "_" + MULTIPANEL_MPRESPPROP
			+ "_" + "fpGestImpiantoResponsabileTitolo";
	public static final String MPI_MPRESPPROP_FPGESTIMPIANTOPROPRIETARIOTITOLO = CPNAME + "_" + MULTIPANEL_MPRESPPROP
			+ "_" + "fpGestImpiantoProprietarioTitolo";

	public static final String MULTIPANEL_MPRESPONSABILE = "mpResponsabile";
	public static final String MPI_MPRESPONSABILE_FPRESPPROP = CPNAME + "_" + MULTIPANEL_MPRESPONSABILE + "_"
			+ "fpRespProp";

	public static final String MULTIPANEL_MPRESPONSABILITROVATITEMP = "mpresponsabiliTrovatiTemp";
	public static final String MPI_MPRESPONSABILITROVATITEMP_FUNRESPONSABILITEMP = CPNAME + "_"
			+ MULTIPANEL_MPRESPONSABILITROVATITEMP + "_" + "FunResponsabiliTemp";

	/** 
	 * Restituisce il tab correntemente visibile in un determinato tab set
	 */
	private String getCurrentTab(Map session, String tabSetName) {
		String value = (String) session.get(CPNAME + "_" + tabSetName + "_selectedMultiPanel");
		return value;
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo gestLogicaIsImpresa definito in un ExecCommand del
	 * ContentPanel cpGestImpiantoRespProp
	 */
	public ExecResults gestLogicaIsImpresa(

			it.csi.sigit.sigitwebn.dto.gestisci_impianto.CpGestImpiantoRespPropModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GESTLOGICAISIMPRESA_OUTCOME_CODE__SI = //NOSONAR  Reason:EIAS
				"SI"; //NOSONAR  Reason:EIAS
		final String GESTLOGICAISIMPRESA_OUTCOME_CODE__NO = //NOSONAR  Reason:EIAS
				"NO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-195640823) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			Responsabile responsabile = theModel.getAppDataresponsabile();

			if (responsabile.getFlgImpresa()) {

				theModel.getAppDataresponsabile().setNome(null);

				settaListaRuoloResponsabile(theModel, Constants.RUOLO_RESPONSABILE_IMPRESA);

				// impostazione del result code 
				result.setResultCode(GESTLOGICAISIMPRESA_OUTCOME_CODE__SI);
			} else {

				theModel.getAppDataresponsabile().setIdSiglaRea(null);
				theModel.getAppDataresponsabile().setNumeroRea(null);

				settaListaRuoloResponsabile(theModel, Constants.RUOLO_RESPONSABILE);

				// impostazione del result code 
				result.setResultCode(GESTLOGICAISIMPRESA_OUTCOME_CODE__NO);
			}

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::gestLogicaIsImpresa] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo cercaResponsabile definito in un ExecCommand del
	 * ContentPanel cpGestImpiantoRespProp
	 */
	public ExecResults cercaResponsabile(

			it.csi.sigit.sigitwebn.dto.gestisci_impianto.CpGestImpiantoRespPropModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String CERCARESPONSABILE_OUTCOME_CODE__OK_SINGOLO = //NOSONAR  Reason:EIAS
				"OK_SINGOLO"; //NOSONAR  Reason:EIAS
		final String CERCARESPONSABILE_OUTCOME_CODE__OK_MULTIPLO = //NOSONAR  Reason:EIAS
				"OK_MULTIPLO"; //NOSONAR  Reason:EIAS
		final String CERCARESPONSABILE_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-996470785) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			try {

				getValidationMgr().verificaRicercaResponsabile(theModel.getAppDataresponsabile());

				ArrayList<Responsabile> responsabili = getSigitMgr()
						.cercaResponsabiliByCodReaCodFiscaleDenominazione(theModel.getAppDataresponsabile());

				//GenericUtil.stampaVO(responsabile);

				if (responsabili != null && !responsabili.isEmpty()) {
					//Responsabili responsabile = theModel.getAppDataresponsabili();

					if (responsabili.size() == 1) {
						// Se ho trovato un solo elemento lo setto direttamente
						Responsabile responsabile = responsabili.get(0);

						impostaResponsabile(theModel, responsabile);

						// impostazione del result code
						result.setResultCode(CERCARESPONSABILE_OUTCOME_CODE__OK_SINGOLO);
					} else {
						// Se ho trovato piu' di un elemento devo visualizzare la tabella per far scegliere all'utente quello corretto

						theModel.setAppDataidResponsabileSelez(null);
						theModel.setAppDataelencoResponsabiliTemp(responsabili);
						result.setResultCode(CERCARESPONSABILE_OUTCOME_CODE__OK_MULTIPLO);

					}

				} else {
					result.getGlobalErrors().add(Messages.I003);

					result.setResultCode(CERCARESPONSABILE_OUTCOME_CODE__KO);
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
			log.error("[BackEndFacade::cercaResponsabile] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo gestLogicaTipoIndirizzoResponsabileCercato definito in un ExecCommand del
	 * ContentPanel cpGestImpiantoRespProp
	 */
	public ExecResults gestLogicaTipoIndirizzoResponsabileCercato(

			it.csi.sigit.sigitwebn.dto.gestisci_impianto.CpGestImpiantoRespPropModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GESTLOGICATIPOINDIRIZZORESPONSABILECERCATO_OUTCOME_CODE__NAZIONALE = //NOSONAR  Reason:EIAS
				"NAZIONALE"; //NOSONAR  Reason:EIAS
		final String GESTLOGICATIPOINDIRIZZORESPONSABILECERCATO_OUTCOME_CODE__ESTERO = //NOSONAR  Reason:EIAS
				"ESTERO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R1850903418) ENABLED START*/

			return gestisciLogicaTipoIndirizzo(theModel,
					GESTLOGICATIPOINDIRIZZORESPONSABILECERCATO_OUTCOME_CODE__NAZIONALE,
					GESTLOGICATIPOINDIRIZZORESPONSABILECERCATO_OUTCOME_CODE__ESTERO, result);

			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error(
					"[BackEndFacade::gestLogicaTipoIndirizzoResponsabileCercato] Errore occorso nell'esecuzione del metodo:"
							+ e,
					e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo gestisciLogicaResponsabileCercato definito in un ExecCommand del
	 * ContentPanel cpGestImpiantoRespProp
	 */
	public ExecResults gestisciLogicaResponsabileCercato(

			it.csi.sigit.sigitwebn.dto.gestisci_impianto.CpGestImpiantoRespPropModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GESTISCILOGICARESPONSABILECERCATO_OUTCOME_CODE__ABILITA_RESP = //NOSONAR  Reason:EIAS
				"ABILITA_RESP"; //NOSONAR  Reason:EIAS
		final String GESTISCILOGICARESPONSABILECERCATO_OUTCOME_CODE__ABILITA_RESP_LIM = //NOSONAR  Reason:EIAS
				"ABILITA_RESP_LIM"; //NOSONAR  Reason:EIAS
		final String GESTISCILOGICARESPONSABILECERCATO_OUTCOME_CODE__ABILITA_RESP_PG_ACCR = //NOSONAR  Reason:EIAS
				"ABILITA_RESP_PG_ACCR"; //NOSONAR  Reason:EIAS
		final String GESTISCILOGICARESPONSABILECERCATO_OUTCOME_CODE__ABILITA_RESP_PF_NO_ACCR = //NOSONAR  Reason:EIAS
				"ABILITA_RESP_PF_NO_ACCR"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-2069145072) ENABLED START*/

			return gestisciLogicaResponsabileSelezionato(theModel,
					GESTISCILOGICARESPONSABILECERCATO_OUTCOME_CODE__ABILITA_RESP,
					GESTISCILOGICARESPONSABILECERCATO_OUTCOME_CODE__ABILITA_RESP_LIM,
					GESTISCILOGICARESPONSABILECERCATO_OUTCOME_CODE__ABILITA_RESP_PG_ACCR,
					GESTISCILOGICARESPONSABILECERCATO_OUTCOME_CODE__ABILITA_RESP_PF_NO_ACCR, result);

			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error(
					"[BackEndFacade::gestisciLogicaResponsabileCercato] Errore occorso nell'esecuzione del metodo:" + e,
					e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo nuovaRicercaResponsabile definito in un ExecCommand del
	 * ContentPanel cpGestImpiantoRespProp
	 */
	public ExecResults nuovaRicercaResponsabile(

			it.csi.sigit.sigitwebn.dto.gestisci_impianto.CpGestImpiantoRespPropModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String NUOVARICERCARESPONSABILE_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String NUOVARICERCARESPONSABILE_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R1178673357) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			Responsabile responsabile = new Responsabile();

			Responsabile responsabileOld = theModel.getAppDataresponsabile();

			responsabile.setFlgResponsabile(responsabileOld.getFlgResponsabile());
			responsabile.setFlgImpresa(responsabileOld.getFlgImpresa());

			theModel.setAppDataresponsabile(responsabile);

			theModel.getAppDataimpianto().getLogicaVisual().setIsResponsabileIndConfermato(false);

			// impostazione del result code 
			result.setResultCode(NUOVARICERCARESPONSABILE_OUTCOME_CODE__OK);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::nuovaRicercaResponsabile] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo gestTipoIndirizzo definito in un ExecCommand del
	 * ContentPanel cpGestImpiantoRespProp
	 */
	public ExecResults gestTipoIndirizzo(

			it.csi.sigit.sigitwebn.dto.gestisci_impianto.CpGestImpiantoRespPropModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GESTTIPOINDIRIZZO_OUTCOME_CODE__NAZIONALE = //NOSONAR  Reason:EIAS
				"NAZIONALE"; //NOSONAR  Reason:EIAS
		final String GESTTIPOINDIRIZZO_OUTCOME_CODE__ESTERO = //NOSONAR  Reason:EIAS
				"ESTERO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-1450921873) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			return gestisciLogicaTipoIndirizzo(theModel, GESTTIPOINDIRIZZO_OUTCOME_CODE__NAZIONALE,
					GESTTIPOINDIRIZZO_OUTCOME_CODE__ESTERO, result);
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::gestTipoIndirizzo] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo gestIndirizzoConf definito in un ExecCommand del
	 * ContentPanel cpGestImpiantoRespProp
	 */
	public ExecResults gestIndirizzoConf(

			it.csi.sigit.sigitwebn.dto.gestisci_impianto.CpGestImpiantoRespPropModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GESTINDIRIZZOCONF_OUTCOME_CODE__SI = //NOSONAR  Reason:EIAS
				"SI"; //NOSONAR  Reason:EIAS
		final String GESTINDIRIZZOCONF_OUTCOME_CODE__NO = //NOSONAR  Reason:EIAS
				"NO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R1294502487) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			Responsabile responsabile = theModel.getAppDataresponsabile();

			if (GenericUtil.isNotNullOrEmpty(responsabile.getIdIndirizzo())
					|| GenericUtil.isNotNullOrEmpty(responsabile.getIndirizzoNoStrad())) {

				result.setResultCode(GESTINDIRIZZOCONF_OUTCOME_CODE__SI);

			} else {
				result.setResultCode(GESTINDIRIZZOCONF_OUTCOME_CODE__NO);

			}

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

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
	 * ContentPanel cpGestImpiantoRespProp
	 */
	public ExecResults loadComuniResp(

			it.csi.sigit.sigitwebn.dto.gestisci_impianto.CpGestImpiantoRespPropModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String LOADCOMUNIRESP_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-1583943415) ENABLED START*/
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
	 * ContentPanel cpGestImpiantoRespProp
	 */
	public ExecResults cercaIndirizzoResp(

			it.csi.sigit.sigitwebn.dto.gestisci_impianto.CpGestImpiantoRespPropModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String CERCAINDIRIZZORESP_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String CERCAINDIRIZZORESP_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R202808414) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			try {
				Responsabile responsabile = theModel.getAppDataresponsabile();

				getValidationMgr().verificaRicercaIndirizzoResponsabile(responsabile);

				theModel.setAppDataelencoIndirizziResp(
						getServiziMgr().getListaVieValide(responsabile.getIndirizzo(), responsabile.getIdComune()));
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
	 * ContentPanel cpGestImpiantoRespProp
	 */
	public ExecResults nuovaRicercaIndirizzoResp(

			it.csi.sigit.sigitwebn.dto.gestisci_impianto.CpGestImpiantoRespPropModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String NUOVARICERCAINDIRIZZORESP_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String NUOVARICERCAINDIRIZZORESP_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-1087199920) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			Responsabile responsabile = theModel.getAppDataresponsabile();

			responsabile.setIdIndirizzo(null);
			responsabile.setIndirizzo(null);
			responsabile.setIndirizzoNoStrad(null);
			responsabile.setIndirizzoSitad(null);

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
	 * Implementazione del metodo salvaResponsabile definito in un ExecCommand del
	 * ContentPanel cpGestImpiantoRespProp
	 */
	public ExecResults salvaResponsabile(

			it.csi.sigit.sigitwebn.dto.gestisci_impianto.CpGestImpiantoRespPropModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String SALVARESPONSABILE_OUTCOME_CODE__OK_IMPIANTO = //NOSONAR  Reason:EIAS
				"OK_IMPIANTO"; //NOSONAR  Reason:EIAS
		final String SALVARESPONSABILE_OUTCOME_CODE__OK_IMPIANTO_RESP = //NOSONAR  Reason:EIAS
				"OK_IMPIANTO_RESP"; //NOSONAR  Reason:EIAS
		final String SALVARESPONSABILE_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-798155004) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			try {
				Responsabile responsabile = theModel.getAppDataresponsabile();

				boolean isInserimento = GenericUtil.isNullOrEmpty(responsabile.getIdImpResp());

				//Boolean isResponsabileCercato = theModel.getAppDataimpianto().getLogicaVisual().getIsResponsabileCercato();

				getValidationMgr().validazioneFormaleSalvaResponsabile(responsabile, responsabile.getFlgResponsabile());

				//				ArrayList<RisultatoRicResponsabile> responsabiliList = theModel
				//						.getAppDataelencoResponsabili();

				if (responsabile.getFlgResponsabile()) {
					// Queste verifiche non le devo fare se sto inserendo un proprietario (esplicito)
					ArrayList<RisultatoRicResponsabile> responsabiliList = getDbMgr()
							.cercaResponsabiliByIdImpianto(theModel.getAppDataimpianto().getImpId());

					getValidationMgr().verificaDateResponsabile(responsabile, responsabiliList,
							theModel.getAppDataimpianto().getImpCodImpianto());
				}

				if (!responsabile.getFlgIndirizzoEst()) {
					String descComune = GenericUtil.getDescriptionByCod(responsabile.getIdComune(),
							theModel.getAppDataelencoComuniResp());
					String descProvincia = GenericUtil.getDescriptionByCod(responsabile.getIdProvincia(),
							theModel.getAppDataelencoProvince());

					// Vuol dire che il comune/provincia non esiste più, quindi l'utente ne deve impostare un altro
					if (GenericUtil.isNullOrEmpty(descProvincia) || GenericUtil.isNullOrEmpty(descComune)) {
						log.debug("descProvincia: " + descProvincia);
						log.debug("descComune: " + descComune);
						log.debug("Rilancio l'eccezione!!!!!");
						throw new ValidationManagerException(new Message(Messages.ERROR_UPDATE_PROV_COM));
					}

					responsabile.setDescComune(ReplaceSpecialCharUtils.sanitize(descComune));
					responsabile.setDescProvincia(ReplaceSpecialCharUtils.sanitize(descProvincia));

					if (GenericUtil.isNotNullOrEmpty(responsabile.getIdIndirizzo())) {
						String descIndirizzoSitad = GenericUtil.getDescriptionByCod(responsabile.getIdIndirizzo(),
								theModel.getAppDataelencoIndirizziResp());
						responsabile.setIndirizzoSitad(ReplaceSpecialCharUtils.sanitize(descIndirizzoSitad));
					}
				}

				if (log.isDebugEnabled())
					GenericUtil.stampa(responsabile, true, 3);

				responsabile = getDbMgr().salvaResponsabileTrans(responsabile,
						ReplaceSpecialCharUtils.sanitize(theModel.getAppDataimpianto().getImpCodImpianto()),
						ReplaceSpecialCharUtils.sanitize(theModel.getAppDatautenteLoggato().getCodiceFiscale()));

				theModel.setAppDataresponsabile(responsabile);

				// Siccome ho fatto un inserimento/modifica, aggiorno la tabella responsabili
				settaResponsabiliList(theModel);

				if (isInserimento) {
					theModel.getSession().put(Constants.SESSIONE_VAR_MESSAGGE,
							new Message(Messages.INFO_INSERIMENTO_CORRETTO, Message.INFO));
					//result.getGlobalMessages().add(Messages.INFO_INSERIMENTO_CORRETTO);
				} else {
					theModel.getSession().put(Constants.SESSIONE_VAR_MESSAGGE,
							new Message(Messages.INFO_MODIFICA_CORRETTA, Message.INFO));
					//result.getGlobalMessages().add(Messages.INFO_MODIFICA_CORRETTA);
				}

				// Devo capire dove devo entrare
				String pagChiamante = theModel.getAppDatapaginaChiamanteImp();

				if (pagChiamante.equals(Constants.PAG_GEST_IMPIANTI)) {
					// impostazione del result code 
					result.setResultCode(SALVARESPONSABILE_OUTCOME_CODE__OK_IMPIANTO);
				} else if (pagChiamante.equals(Constants.PAG_GEST_IMPIANTI_RESP)) {
					// impostazione del result code 
					result.setResultCode(SALVARESPONSABILE_OUTCOME_CODE__OK_IMPIANTO_RESP);
				} else {
					// Non dovrebbe succedere, nel caso lo mando di default a GEST_IMPIANTI
					result.setResultCode(SALVARESPONSABILE_OUTCOME_CODE__OK_IMPIANTO);
				}

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
			log.error("[BackEndFacade::salvaResponsabile] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo impostaResponsabile definito in un ExecCommand del
	 * ContentPanel cpGestImpiantoRespProp
	 */
	public ExecResults impostaResponsabile(

			it.csi.sigit.sigitwebn.dto.gestisci_impianto.CpGestImpiantoRespPropModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String IMPOSTARESPONSABILE_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String IMPOSTARESPONSABILE_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-613036048) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			String idResponsabileSelez = theModel.getAppDataidResponsabileSelez();

			try {
				getValidationMgr().checkSelezioneElemento(idResponsabileSelez);

				ArrayList<Responsabile> responsabiliList = theModel.getAppDataelencoResponsabiliTemp();

				for (Responsabile responsabile : responsabiliList) {

					if (responsabile.getIdResponsabile().intValue() == ConvertUtil.convertToInteger(idResponsabileSelez)
							.intValue()) {
						// Ho trovato il responsabile selezionato

						impostaResponsabile(theModel, responsabile);

						// impostazione del result code 
						result.setResultCode(IMPOSTARESPONSABILE_OUTCOME_CODE__OK);
					}
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
			log.error("[BackEndFacade::impostaResponsabile] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo gestLogicaTipoIndirizzoResponsabileImpostato definito in un ExecCommand del
	 * ContentPanel cpGestImpiantoRespProp
	 */
	public ExecResults gestLogicaTipoIndirizzoResponsabileImpostato(

			it.csi.sigit.sigitwebn.dto.gestisci_impianto.CpGestImpiantoRespPropModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GESTLOGICATIPOINDIRIZZORESPONSABILEIMPOSTATO_OUTCOME_CODE__NAZIONALE = //NOSONAR  Reason:EIAS
				"NAZIONALE"; //NOSONAR  Reason:EIAS
		final String GESTLOGICATIPOINDIRIZZORESPONSABILEIMPOSTATO_OUTCOME_CODE__ESTERO = //NOSONAR  Reason:EIAS
				"ESTERO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-1210949013) ENABLED START*/

			return gestisciLogicaTipoIndirizzo(theModel,
					GESTLOGICATIPOINDIRIZZORESPONSABILEIMPOSTATO_OUTCOME_CODE__NAZIONALE,
					GESTLOGICATIPOINDIRIZZORESPONSABILEIMPOSTATO_OUTCOME_CODE__ESTERO, result);

			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error(
					"[BackEndFacade::gestLogicaTipoIndirizzoResponsabileImpostato] Errore occorso nell'esecuzione del metodo:"
							+ e,
					e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo gestisciLogicaResponsabileImpostato definito in un ExecCommand del
	 * ContentPanel cpGestImpiantoRespProp
	 */
	public ExecResults gestisciLogicaResponsabileImpostato(

			it.csi.sigit.sigitwebn.dto.gestisci_impianto.CpGestImpiantoRespPropModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GESTISCILOGICARESPONSABILEIMPOSTATO_OUTCOME_CODE__ABILITA_RESP = //NOSONAR  Reason:EIAS
				"ABILITA_RESP"; //NOSONAR  Reason:EIAS
		final String GESTISCILOGICARESPONSABILEIMPOSTATO_OUTCOME_CODE__ABILITA_RESP_LIM = //NOSONAR  Reason:EIAS
				"ABILITA_RESP_LIM"; //NOSONAR  Reason:EIAS
		final String GESTISCILOGICARESPONSABILEIMPOSTATO_OUTCOME_CODE__ABILITA_RESP_PG_ACCR = //NOSONAR  Reason:EIAS
				"ABILITA_RESP_PG_ACCR"; //NOSONAR  Reason:EIAS
		final String GESTISCILOGICARESPONSABILEIMPOSTATO_OUTCOME_CODE__ABILITA_RESP_PF_NO_ACCR = //NOSONAR  Reason:EIAS
				"ABILITA_RESP_PF_NO_ACCR"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-1691229311) ENABLED START*/

			return gestisciLogicaResponsabileSelezionato(theModel,
					GESTISCILOGICARESPONSABILEIMPOSTATO_OUTCOME_CODE__ABILITA_RESP,
					GESTISCILOGICARESPONSABILEIMPOSTATO_OUTCOME_CODE__ABILITA_RESP_LIM,
					GESTISCILOGICARESPONSABILEIMPOSTATO_OUTCOME_CODE__ABILITA_RESP_PG_ACCR,
					GESTISCILOGICARESPONSABILEIMPOSTATO_OUTCOME_CODE__ABILITA_RESP_PF_NO_ACCR, result);

			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::gestisciLogicaResponsabileImpostato] Errore occorso nell'esecuzione del metodo:"
					+ e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo gestisciIndietro definito in un ExecCommand del
	 * ContentPanel cpGestImpiantoRespProp
	 */
	public ExecResults gestisciIndietro(

			it.csi.sigit.sigitwebn.dto.gestisci_impianto.CpGestImpiantoRespPropModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GESTISCIINDIETRO_OUTCOME_CODE__IMPIANTO = //NOSONAR  Reason:EIAS
				"IMPIANTO"; //NOSONAR  Reason:EIAS
		final String GESTISCIINDIETRO_OUTCOME_CODE__IMPIANTO_RESP = //NOSONAR  Reason:EIAS
				"IMPIANTO_RESP"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-316174519) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			String pagChiamante = theModel.getAppDatapaginaChiamanteImp();

			if (pagChiamante.equals(Constants.PAG_GEST_IMPIANTI)) {
				// impostazione del result code 
				result.setResultCode(GESTISCIINDIETRO_OUTCOME_CODE__IMPIANTO);
			} else if (pagChiamante.equals(Constants.PAG_GEST_IMPIANTI_RESP)) {
				// impostazione del result code 
				result.setResultCode(GESTISCIINDIETRO_OUTCOME_CODE__IMPIANTO_RESP);
			} else {
				// Non dovrebbe succedere, nel caso lo mando di default a GEST_IMPIANTI
				result.setResultCode(GESTISCIINDIETRO_OUTCOME_CODE__IMPIANTO);
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
	 * Implementazione del metodo isRuoloAbilitato definito in un ExecCommand del
	 * ContentPanel cpGestImpiantoRespProp
	 */
	public ExecResults isRuoloAbilitato(

			it.csi.sigit.sigitwebn.dto.gestisci_impianto.CpGestImpiantoRespPropModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String ISRUOLOABILITATO_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-956319322) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			String descRuolo = theModel.getAppDatautenteLoggato().getRuolo().getDescRuolo();

			if (descRuolo.equals(Constants.RUOLO_IMPRESA) || descRuolo.equals(Constants.RUOLO_RESPONSABILE)
					|| descRuolo.equals(Constants.RUOLO_RESPONSABILE_IMPRESA)
					|| descRuolo.equals(Constants.RUOLO_3RESPONSABILE) || descRuolo.equals(Constants.RUOLO_SUPER)
					|| descRuolo.equals(Constants.RUOLO_VALIDATORE) || descRuolo.equals(Constants.RUOLO_ISPETTORE)) {
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
	 * ContentPanel cpGestImpiantoRespProp
	 */
	public ExecResults gestLogicaIngresso(

			it.csi.sigit.sigitwebn.dto.gestisci_impianto.CpGestImpiantoRespPropModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GESTLOGICAINGRESSO_OUTCOME_CODE__PROPRIETARIO = //NOSONAR  Reason:EIAS
				"PROPRIETARIO"; //NOSONAR  Reason:EIAS
		final String GESTLOGICAINGRESSO_OUTCOME_CODE__RESPONSABILE = //NOSONAR  Reason:EIAS
				"RESPONSABILE"; //NOSONAR  Reason:EIAS
		final String GESTLOGICAINGRESSO_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R1528199250) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			try {
				Impianto impianto = theModel.getAppDataimpianto();
				if (impianto != null && GenericUtil.isNotNullOrEmpty(impianto.getImpId())) {

					ArrayList<RisultatoRicResponsabile> responsabiliList = getDbMgr()
							.cercaResponsabiliByIdImpianto(impianto.getImpId());

					theModel.setAppDataelencoResponsabili(responsabiliList);

					ArrayList<RisultatoRicManutentore> manutentoriList = getDbMgr()
							.cercaManutentoriByIdImpiantoNew(impianto.getImpId());

					log.debug("@@@PRIMA del settaggio manutentoriList (2): " + manutentoriList);

					theModel.setAppDataelencoManutentori(manutentoriList);

				} else if (impianto.getLogicaVisual() != null
						&& impianto.getLogicaVisual().getCaso() == Constants.COD_CASO_E) {
					log.debug("pulizia elenchi");

					log.debug("@@@PRIMA del settaggio manutentoriList (3): " + null);

					theModel.setAppDataelencoResponsabili(null);
					theModel.setAppDataelencoManutentori(null);
				}

				Responsabile responsabile = theModel.getAppDataresponsabile();

				if (ConvertUtil.convertToBooleanAllways(responsabile.getFlgResponsabile())) {
					// impostazione del result code 
					result.setResultCode(GESTLOGICAINGRESSO_OUTCOME_CODE__RESPONSABILE);
				} else {
					// impostazione del result code 
					result.setResultCode(GESTLOGICAINGRESSO_OUTCOME_CODE__PROPRIETARIO);
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
			log.error("[BackEndFacade::gestLogicaIngresso] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo gestLogicaIsImpresaEnter definito in un ExecCommand del
	 * ContentPanel cpGestImpiantoRespProp
	 */
	public ExecResults gestLogicaIsImpresaEnter(

			it.csi.sigit.sigitwebn.dto.gestisci_impianto.CpGestImpiantoRespPropModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GESTLOGICAISIMPRESAENTER_OUTCOME_CODE__SI = //NOSONAR  Reason:EIAS
				"SI"; //NOSONAR  Reason:EIAS
		final String GESTLOGICAISIMPRESAENTER_OUTCOME_CODE__NO = //NOSONAR  Reason:EIAS
				"NO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R1414391287) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			Responsabile responsabile = theModel.getAppDataresponsabile();

			if (responsabile.getFlgImpresa()) {

				theModel.getAppDataresponsabile().setNome(null);

				settaListaRuoloResponsabile(theModel, Constants.RUOLO_RESPONSABILE_IMPRESA);

				log.debug("Sono entrato - e' un'impresa (da spostare il controllo)");

				// impostazione del result code 
				result.setResultCode(GESTLOGICAISIMPRESAENTER_OUTCOME_CODE__SI);
			} else {

				theModel.getAppDataresponsabile().setIdSiglaRea(null);
				theModel.getAppDataresponsabile().setNumeroRea(null);

				settaListaRuoloResponsabile(theModel, Constants.RUOLO_RESPONSABILE);

				// impostazione del result code 
				result.setResultCode(GESTLOGICAISIMPRESAENTER_OUTCOME_CODE__NO);
			}

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::gestLogicaIsImpresaEnter] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo gestLogicaTipoIndirizzo definito in un ExecCommand del
	 * ContentPanel cpGestImpiantoRespProp
	 */
	public ExecResults gestLogicaTipoIndirizzo(

			it.csi.sigit.sigitwebn.dto.gestisci_impianto.CpGestImpiantoRespPropModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GESTLOGICATIPOINDIRIZZO_OUTCOME_CODE__NAZIONALE = //NOSONAR  Reason:EIAS
				"NAZIONALE"; //NOSONAR  Reason:EIAS
		final String GESTLOGICATIPOINDIRIZZO_OUTCOME_CODE__ESTERO = //NOSONAR  Reason:EIAS
				"ESTERO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-1710510894) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			return gestisciLogicaTipoIndirizzo(theModel, GESTLOGICATIPOINDIRIZZO_OUTCOME_CODE__NAZIONALE,
					GESTLOGICATIPOINDIRIZZO_OUTCOME_CODE__ESTERO, result);

			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::gestLogicaTipoIndirizzo] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo gestisciLogicaResponsabileSelez definito in un ExecCommand del
	 * ContentPanel cpGestImpiantoRespProp
	 */
	public ExecResults gestisciLogicaResponsabileSelez(

			it.csi.sigit.sigitwebn.dto.gestisci_impianto.CpGestImpiantoRespPropModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GESTISCILOGICARESPONSABILESELEZ_OUTCOME_CODE__ABILITA_RESP = //NOSONAR  Reason:EIAS
				"ABILITA_RESP"; //NOSONAR  Reason:EIAS
		final String GESTISCILOGICARESPONSABILESELEZ_OUTCOME_CODE__ABILITA_RESP_LIM = //NOSONAR  Reason:EIAS
				"ABILITA_RESP_LIM"; //NOSONAR  Reason:EIAS
		final String GESTISCILOGICARESPONSABILESELEZ_OUTCOME_CODE__ABILITA_RESP_PG_ACCR = //NOSONAR  Reason:EIAS
				"ABILITA_RESP_PG_ACCR"; //NOSONAR  Reason:EIAS
		final String GESTISCILOGICARESPONSABILESELEZ_OUTCOME_CODE__ABILITA_RESP_PF_NO_ACCR = //NOSONAR  Reason:EIAS
				"ABILITA_RESP_PF_NO_ACCR"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-343416278) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			return gestisciLogicaResponsabileSelezionato(theModel,
					GESTISCILOGICARESPONSABILESELEZ_OUTCOME_CODE__ABILITA_RESP,
					GESTISCILOGICARESPONSABILESELEZ_OUTCOME_CODE__ABILITA_RESP_LIM,
					GESTISCILOGICARESPONSABILESELEZ_OUTCOME_CODE__ABILITA_RESP_PG_ACCR,
					GESTISCILOGICARESPONSABILESELEZ_OUTCOME_CODE__ABILITA_RESP_PF_NO_ACCR, result);
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::gestisciLogicaResponsabileSelez] Errore occorso nell'esecuzione del metodo:" + e,
					e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	//////////////////////////////////////////////////////////////////////////////
	/// Metodi statici per il reset delle tabelle
	//////////////////////////////////////////////////////////////////////////////

	/**
	 * permette di resettare lo stato di paginazione della tabella widg_tbResponsabiliTrovatiTemp
	 */
	public static void resetClearStatus_widg_tbResponsabiliTrovatiTemp(java.util.Map session) {
		session.put("cpGestImpiantoRespProp_tbResponsabiliTrovatiTemp_clearStatus", Boolean.TRUE);
	}

	//////////////////////////////////////////////////////////////////////////////
	/// Property aggiuntive del bean
	//////////////////////////////////////////////////////////////////////////////
	/*PROTECTED REGION ID(R-2043597081) ENABLED START*/
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

	private void settaComuneVieResponsabile(
			it.csi.sigit.sigitwebn.dto.gestisci_impianto.CpGestImpiantoRespPropModel theModel,
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

	private ArrayList<CodeDescription> recuperaComuni(String idProvSel) throws ServiceException {

		ArrayList<CodeDescription> comuniLoc = new ArrayList<CodeDescription>();

		if (GenericUtil.isNotNullOrEmpty(idProvSel)) {

			// Localizzazione COMUNE 
			log.debug("STAMPO idProvSelLoc: " + idProvSel);

			comuniLoc = (ArrayList<CodeDescription>) getServiziMgr().getListaComuniByIstatProvincia(idProvSel);

		}

		return comuniLoc;
	}

	private void settaResponsabiliList(
			it.csi.sigit.sigitwebn.dto.gestisci_impianto.CpGestImpiantoRespPropModel theModel)
			throws DbManagerException {

		ArrayList<RisultatoRicResponsabile> responsabiliList = getDbMgr()
				.cercaResponsabiliByIdImpianto(theModel.getAppDataimpianto().getImpId());

		theModel.setAppDataelencoResponsabili(responsabiliList);

	}

	private void settaListaRuoloResponsabile(
			it.csi.sigit.sigitwebn.dto.gestisci_impianto.CpGestImpiantoRespPropModel theModel, String descRuoloFunz)
			throws DbManagerException {
		ArrayList<CodeDescription> titoliResp = getDbMgr().cercaListaRuoloByDescRuoloFunzionale(descRuoloFunz);
		theModel.setAppDataelencoTitoli(titoliResp);
	}

	private ExecResults gestisciLogicaResponsabileSelezionato(
			it.csi.sigit.sigitwebn.dto.gestisci_impianto.CpGestImpiantoRespPropModel theModel,
			final String OUTCOME_CODE__ABILITA_RESP, final String OUTCOME_CODE__ABILITA_RESP_LIM,
			final String OUTCOME_CODE__ABILITA_RESP_PG_ACCR, final String OUTCOME_CODE__ABILITA_RESP_PF_NO_ACCR,
			ExecResults result) {
		Responsabile responsabile = theModel.getAppDataresponsabile();

		if (log.isDebugEnabled())
			GenericUtil.stampa(responsabile, true, 3);

		if (responsabile != null && GenericUtil.isNotNullOrEmpty(responsabile.getIdResponsabile())) {

			if (!ConvertUtil.convertToBooleanAllways(responsabile.getFlgAccreditato())
					&& !ConvertUtil.convertToBooleanAllways(responsabile.getFlgImpresa())) {
				result.setResultCode(OUTCOME_CODE__ABILITA_RESP_PF_NO_ACCR);

				log.debug("IL MANUTENTORE NON E' PASSATO DALL'ACCREDITAMENTO ED E' UNA PF");
			} else if (ConvertUtil.convertToBooleanAllways(responsabile.getFlgAccreditato())
					&& ConvertUtil.convertToBooleanAllways(responsabile.getFlgImpresa())) {
				// impostazione del result code 
				result.setResultCode(OUTCOME_CODE__ABILITA_RESP_PG_ACCR);
			} else {
				// impostazione del result code 
				result.setResultCode(OUTCOME_CODE__ABILITA_RESP_LIM);
			}

		} else {
			result.setResultCode(OUTCOME_CODE__ABILITA_RESP);
		}
		log.debug("****** " + result.getResultCode() + " ******");

		// modifica degli attributi del model (che verranno propagati allo strato
		// di presentation). si puo' agire anche direttamente sull'attributo "session".

		result.setModel(theModel);
		return result;
	}

	private ExecResults gestisciLogicaTipoIndirizzo(
			it.csi.sigit.sigitwebn.dto.gestisci_impianto.CpGestImpiantoRespPropModel theModel,
			final String OUTCOME_CODE__NAZIONALE, final String OUTCOME_CODE__ESTERO, ExecResults result) {
		Responsabile responsabile = theModel.getAppDataresponsabile();

		if (ConvertUtil.convertToBooleanAllways(responsabile.getFlgIndirizzoEst())) {
			// impostazione del result code 
			result.setResultCode(OUTCOME_CODE__ESTERO);
		} else {
			// impostazione del result code 
			result.setResultCode(OUTCOME_CODE__NAZIONALE);
		}

		// modifica degli attributi del model (che verranno propagati allo strato
		// di presentation). si puo' agire anche direttamente sull'attributo "session".

		result.setModel(theModel);
		return result;
	}

	private void impostaResponsabile(it.csi.sigit.sigitwebn.dto.gestisci_impianto.CpGestImpiantoRespPropModel theModel,
			Responsabile responsabile) throws ServiceException, DbManagerException {
		if (log.isDebugEnabled())
			GenericUtil.stampa(responsabile, true, 3);

		Responsabile responsabileOld = theModel.getAppDataresponsabile();

		responsabile.setFlgResponsabile(responsabileOld.getFlgResponsabile());
		responsabile.setDataInizioResp(responsabileOld.getDataInizioResp());

		if (responsabile.getFlgImpresa()) {

			List<SigitRPfPgDelegaDto> deleghePG = getSigitMgr().cercaDelegheAccreditoAByidPersonaGiuridica(
					ConvertUtil.convertToBigDecimal(responsabile.getIdResponsabile()));

			responsabile.setFlgAccreditato(deleghePG != null && deleghePG.size() > 0);

			settaListaRuoloResponsabile(theModel, Constants.RUOLO_RESPONSABILE_IMPRESA);

		} else {
			PersonaFisica pf = getDbMgr().cercaPersonaFisicaById(responsabile.getIdResponsabile());

			responsabile.setFlgAccreditato(pf.getFlgAccreditato());

			settaListaRuoloResponsabile(theModel, Constants.RUOLO_RESPONSABILE);
		}

		theModel.setAppDataresponsabile(responsabile);

		if (!responsabile.getFlgIndirizzoEst()) {
			settaComuneVieResponsabile(theModel, responsabile);

			theModel.getAppDataimpianto().getLogicaVisual().setIsResponsabileIndConfermato(true);
		}

		log.debug("responsabile.getIdResponsabile() " + responsabile.getIdResponsabile());

		if (log.isDebugEnabled())
			GenericUtil.stampa(responsabile, false, 2);
	}

	/*PROTECTED REGION END*/
}
