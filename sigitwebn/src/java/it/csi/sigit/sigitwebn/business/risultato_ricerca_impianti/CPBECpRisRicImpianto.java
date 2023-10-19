package it.csi.sigit.sigitwebn.business.risultato_ricerca_impianti;

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

/*PROTECTED REGION ID(R1011115663) ENABLED START*/
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.SigitVRicerca3ResponsabileDto;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.SigitVRicercaAllegatiDto;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.SigitVTotImpiantoDto;
import it.csi.sigit.sigitwebn.business.gestisci_verifica.CPBECpGestVerifica.TipoVerificaEnum;
import it.csi.sigit.sigitwebn.business.manager.DbMgr;
import it.csi.sigit.sigitwebn.business.manager.SigitMgr;
import it.csi.sigit.sigitwebn.business.manager.ValidationMgr;
import it.csi.sigit.sigitwebn.business.manager.util.DbManagerException;
import it.csi.sigit.sigitwebn.business.manager.util.ManagerException;
import it.csi.sigit.sigitwebn.business.manager.util.Message;
import it.csi.sigit.sigitwebn.business.manager.util.ServiceException;
import it.csi.sigit.sigitwebn.dto.ExecResults;
import it.csi.sigit.sigitwebn.dto.accesso.Ruolo;
import it.csi.sigit.sigitwebn.dto.main.UtenteLoggato;
import it.csi.sigit.sigitwebn.dto.risultato_ricerca_impianti.CpRisRicImpiantoModel;
import it.csi.sigit.sigitwebn.util.Constants;
import it.csi.sigit.sigitwebn.util.ConvertUtil;
import it.csi.sigit.sigitwebn.util.DateUtil;
import it.csi.sigit.sigitwebn.util.GenericUtil;
import it.csi.sigit.sigitwebn.util.Messages;
import it.csi.sigit.sigitwebn.util.Validator;
import it.csi.sigit.sigitwebn.util.mail.ResultInvioMail;

import java.math.BigDecimal;
/*PROTECTED REGION END*/

public class CPBECpRisRicImpianto {

	/**  */
	protected static final Logger log = //NOSONAR  Reason:EIAS 
			Logger.getLogger(Constants.APPLICATION_CODE + ".business"); //NOSONAR  Reason:EIAS

	//////////////////////////////////////////////////////////////////////////////
	/// Costanti identificative degli Application Data
	//////////////////////////////////////////////////////////////////////////////

	// ApplicationData: [risultatoRicercaImpianti, scope:USER_SESSION]
	public static final String APPDATA_RISULTATORICERCAIMPIANTI_CODE = "appDatarisultatoRicercaImpianti";

	// ApplicationData: [idImpiantoSelez, scope:USER_SESSION]
	public static final String APPDATA_IDIMPIANTOSELEZ_CODE = "appDataidImpiantoSelez";

	// ApplicationData: [aggiornaElencoImpianti, scope:USER_SESSION]
	public static final String APPDATA_AGGIORNAELENCOIMPIANTI_CODE = "appDataaggiornaElencoImpianti";

	// ApplicationData: [impianto, scope:USER_SESSION]
	public static final String APPDATA_IMPIANTO_CODE = "appDataimpianto";

	// ApplicationData: [utenteLoggato, scope:USER_SESSION]
	public static final String APPDATA_UTENTELOGGATO_CODE = "appDatautenteLoggato";

	// ApplicationData: [ricercaImpianti, scope:USER_SESSION]
	public static final String APPDATA_RICERCAIMPIANTI_CODE = "appDataricercaImpianti";

	// ApplicationData: [paginaChiamanteImp, scope:USER_SESSION]
	public static final String APPDATA_PAGINACHIAMANTEIMP_CODE = "appDatapaginaChiamanteImp";

	// ApplicationData: [isAbilitazioneDatiAllegato, scope:USER_SESSION]
	public static final String APPDATA_ISABILITAZIONEDATIALLEGATO_CODE = "appDataisAbilitazioneDatiAllegato";

	// ApplicationData: [responsabile, scope:USER_SESSION]
	public static final String APPDATA_RESPONSABILE_CODE = "appDataresponsabile";

	// ApplicationData: [elencoResponsabili, scope:USER_SESSION]
	public static final String APPDATA_ELENCORESPONSABILI_CODE = "appDataelencoResponsabili";

	// ApplicationData: [elencoResponsabiliTemp, scope:USER_SESSION]
	public static final String APPDATA_ELENCORESPONSABILITEMP_CODE = "appDataelencoResponsabiliTemp";

	// ApplicationData: [elencoManutentori, scope:USER_SESSION]
	public static final String APPDATA_ELENCOMANUTENTORI_CODE = "appDataelencoManutentori";

	// ApplicationData: [dataRevocaResponsabileOld, scope:USER_SESSION]
	public static final String APPDATA_DATAREVOCARESPONSABILEOLD_CODE = "appDatadataRevocaResponsabileOld";

	// ApplicationData: [messaggioDinamico, scope:USER_SESSION]
	public static final String APPDATA_MESSAGGIODINAMICO_CODE = "appDatamessaggioDinamico";

	// ApplicationData: [idImpiantoRevoca, scope:USER_SESSION]
	public static final String APPDATA_IDIMPIANTOREVOCA_CODE = "appDataidImpiantoRevoca";

	// ApplicationData: [elencoDettaglioTerzoResponsabile, scope:USER_SESSION]
	public static final String APPDATA_ELENCODETTAGLIOTERZORESPONSABILE_CODE = "appDataelencoDettaglioTerzoResponsabile";

	// ApplicationData: [risultatoRicercaImpiantiSelez, scope:USER_SESSION]
	public static final String APPDATA_RISULTATORICERCAIMPIANTISELEZ_CODE = "appDatarisultatoRicercaImpiantiSelez";

	// ApplicationData: [aggiornaElencoDocumenti, scope:USER_SESSION]
	public static final String APPDATA_AGGIORNAELENCODOCUMENTI_CODE = "appDataaggiornaElencoDocumenti";

	// ApplicationData: [paginaChiamanteDocumenti, scope:USER_SESSION]
	public static final String APPDATA_PAGINACHIAMANTEDOCUMENTI_CODE = "appDatapaginaChiamanteDocumenti";

	// ApplicationData: [identificativoImpianto, scope:USER_SESSION]
	public static final String APPDATA_IDENTIFICATIVOIMPIANTO_CODE = "appDataidentificativoImpianto";

	// ApplicationData: [paginaChiamante, scope:USER_SESSION]
	public static final String APPDATA_PAGINACHIAMANTE_CODE = "appDatapaginaChiamante";

	// ApplicationData: [idAllegatoImpiantoSelezionato, scope:USER_SESSION]
	public static final String APPDATA_IDALLEGATOIMPIANTOSELEZIONATO_CODE = "appDataidAllegatoImpiantoSelezionato";

	// ApplicationData: [verifica, scope:USER_SESSION]
	public static final String APPDATA_VERIFICA_CODE = "appDataverifica";

	// ApplicationData: [provenienza, scope:USER_SESSION]
	public static final String APPDATA_PROVENIENZA_CODE = "appDataprovenienza";

	// ApplicationData: [elencoTipoImpianto, scope:USER_SESSION]
	public static final String APPDATA_ELENCOTIPOIMPIANTO_CODE = "appDataelencoTipoImpianto";

	//////////////////////////////////////////////////////////////////////////////
	/// Metodi associati alla U.I.
	//////////////////////////////////////////////////////////////////////////////

	// nome del content panel associato al bean
	public static final String CPNAME = "cpRisRicImpianto";

	/** 
	 * Restituisce il tab correntemente visibile in un determinato tab set
	 */
	private String getCurrentTab(Map session, String tabSetName) {
		String value = (String) session.get(CPNAME + "_" + tabSetName + "_selectedMultiPanel");
		return value;
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo gestInserisciImpianto definito in un ExecCommand del
	 * ContentPanel cpRisRicImpianto
	 */
	public ExecResults gestInserisciImpianto(

			it.csi.sigit.sigitwebn.dto.risultato_ricerca_impianti.CpRisRicImpiantoModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GESTINSERISCIIMPIANTO_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String GESTINSERISCIIMPIANTO_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-565481701) ENABLED START*/
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
			impianto.setImpDataAssegnazione(DateUtil.getDataCorrenteFormat());
			impianto.setImpDataDismissione(DateUtil.getDataCorrenteFormat());
			impianto.setImpDataDismissioneOld(DateUtil.getDataCorrenteFormat());
			impianto.setImpMotivazione(Constants.MOTIVAZIONE_STATO_IMPIANTO_DEFAULT);
			impianto.setImpMotivazioneOld(Constants.MOTIVAZIONE_STATO_IMPIANTO_DEFAULT);
			impianto.setVisuProprietario(true);

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
	 * ContentPanel cpRisRicImpianto
	 */
	public ExecResults gestInserisciImpiantoResp(

			it.csi.sigit.sigitwebn.dto.risultato_ricerca_impianti.CpRisRicImpiantoModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GESTINSERISCIIMPIANTORESP_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String GESTINSERISCIIMPIANTORESP_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R246306219) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			Impianto impianto = new Impianto();

			LogicaVisualizzazione logica = new LogicaVisualizzazione();
			logica.setCaso(Constants.COD_CASO_A);

			Ruolo ruolo = theModel.getAppDatautenteLoggato().getRuolo();
			//logica.setIsPrimoIngresso(true);
			impianto.setLogicaVisual(logica);

			//			impianto.setInstCf(ruolo.getCodiceFiscale());
			//			impianto.setInstIdSiglaRea(ruolo.getSiglaRea());
			//			impianto.setInstNumeroRea(ConvertUtil
			//					.convertToUDTPositiveInteger(ruolo.getNumeroRea()));
			//			impianto.setInstImpresa(ruolo.getDenomDitta());
			//			impianto.setInstId(ruolo.getIdPersonaGiuridica());

			//impianto.setLibIsModifica(ConvertUtil.convertToString(false));

			impianto.setImpIdStatoImp(ConvertUtil.convertToString(Constants.ID_STATO_IMP_VALIDO));
			impianto.setImpIdStatoImpOld(ConvertUtil.convertToString(Constants.ID_STATO_IMP_VALIDO));
			impianto.setImpDataAssegnazione(DateUtil.getDataCorrenteFormat());
			impianto.setImpDataDismissione(DateUtil.getDataCorrenteFormat());
			impianto.setImpDataDismissioneOld(DateUtil.getDataCorrenteFormat());
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
	 * Implementazione del metodo gestModificaImpianto definito in un ExecCommand del
	 * ContentPanel cpRisRicImpianto
	 */
	public ExecResults gestModificaImpianto(

			it.csi.sigit.sigitwebn.dto.risultato_ricerca_impianti.CpRisRicImpiantoModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GESTMODIFICAIMPIANTO_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String GESTMODIFICAIMPIANTO_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-1085690816) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			String idImpiantoSelez = theModel.getAppDataidImpiantoSelez();

			try {
				getValidationMgr().checkSelezioneElemento(ReplaceSpecialCharUtils.sanitize(idImpiantoSelez));

				Impianto impianto = getDbMgr().cercaImpiantoById(ReplaceSpecialCharUtils.sanitize(idImpiantoSelez));

				impianto.setLogicaVisual(GenericUtil.setLogicaVisualizzazione(impianto));

				//impianto.getLogicaVisual().setIsBotInsModLibrettoVisibile(true);
				impianto.getLogicaVisual().setIsImpiantoIndConfermato(true);

				theModel.setAppDataimpianto(impianto);

				// impostazione del result code 
				result.setResultCode(GESTMODIFICAIMPIANTO_OUTCOME_CODE__OK);

				// modifica degli attributi del model (che verranno propagati allo strato
				// di presentation). si puo' agire anche direttamente sull'attributo "session".
			} catch (ManagerException ex) {
				Validator.gestisciEccezione(result, ex);
			}
			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::gestModificaImpianto] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo gestModificaImpiantoResp definito in un ExecCommand del
	 * ContentPanel cpRisRicImpianto
	 */
	public ExecResults gestModificaImpiantoResp(

			it.csi.sigit.sigitwebn.dto.risultato_ricerca_impianti.CpRisRicImpiantoModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GESTMODIFICAIMPIANTORESP_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String GESTMODIFICAIMPIANTORESP_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-1638959024) ENABLED START*/
			String idImpiantoSelez = theModel.getAppDataidImpiantoSelez();

			try {
				getValidationMgr().checkSelezioneElemento(idImpiantoSelez);

				if (Constants.RUOLO_3RESPONSABILE
						.equalsIgnoreCase(theModel.getAppDatautenteLoggato().getRuolo().getDescRuolo())) {
					RisultatoRicImpianto impSelez = null;
					for (RisultatoRicImpianto imp : theModel.getAppDatarisultatoRicercaImpianti()) {
						if (idImpiantoSelez.equals(imp.getCodiceImpianto()))
							impSelez = imp;
					}
					if (GenericUtil.isNullOrEmpty(impSelez.getDenomResponsabile()))
						throw new ManagerException(new Message(Messages.S152));

				}

				Impianto impianto = getDbMgr().cercaImpiantoById(idImpiantoSelez);

				impianto.setLogicaVisual(GenericUtil.setLogicaVisualizzazione(impianto));

				//impianto.getLogicaVisual().setIsBotInsModLibrettoVisibile(true);
				impianto.getLogicaVisual().setIsImpiantoIndConfermato(true);

				theModel.setAppDataimpianto(impianto);

				result.setResultCode(GESTMODIFICAIMPIANTORESP_OUTCOME_CODE__OK);
			} catch (ManagerException ex) {
				log.error("Errore: ", ex);
				Validator.gestisciEccezione(result, ex);
			}
			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::gestModificaImpiantoResp] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo gestVisualizzaImpianto definito in un ExecCommand del
	 * ContentPanel cpRisRicImpianto
	 */
	public ExecResults gestVisualizzaImpianto(

			it.csi.sigit.sigitwebn.dto.risultato_ricerca_impianti.CpRisRicImpiantoModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GESTVISUALIZZAIMPIANTO_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String GESTVISUALIZZAIMPIANTO_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-1338291920) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			String idImpiantoSelez = theModel.getAppDataidImpiantoSelez();

			try {
				getValidationMgr().checkSelezioneElemento(idImpiantoSelez);

				Impianto impianto = getDbMgr().cercaImpiantoById(idImpiantoSelez);

				LogicaVisualizzazione logica = new LogicaVisualizzazione();
				logica.setCaso(Constants.COD_CASO_C);
				logica.setIsImpiantoIndConfermato(true);

				//				logica.setIsBotVisLibrettoVisibile(GenericUtil
				//						.isNotNullOrEmpty(impianto.getLibDataRilascio()));

				impianto.setLogicaVisual(logica);

				theModel.setAppDataimpianto(impianto);

				// impostazione del result code 
				result.setResultCode(GESTVISUALIZZAIMPIANTO_OUTCOME_CODE__OK);

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
			log.error("[BackEndFacade::gestVisualizzaImpianto] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo gestEliminaImpianto definito in un ExecCommand del
	 * ContentPanel cpRisRicImpianto
	 */
	public ExecResults gestEliminaImpianto(

			it.csi.sigit.sigitwebn.dto.risultato_ricerca_impianti.CpRisRicImpiantoModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GESTELIMINAIMPIANTO_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String GESTELIMINAIMPIANTO_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-560843947) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			String idImpiantoSelez = theModel.getAppDataidImpiantoSelez();

			try {
				getValidationMgr().checkSelezioneElemento(idImpiantoSelez);

				getValidationMgr().verificaEliminaImpianto(idImpiantoSelez);

				Message msg = new Message(Messages.C002);
				msg.replacePlaceholder(idImpiantoSelez);
				theModel.setAppDatamessaggioDinamico(msg.getText());

				// impostazione del result code 
				result.setResultCode(GESTELIMINAIMPIANTO_OUTCOME_CODE__OK);

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
			log.error("[BackEndFacade::gestEliminaImpianto] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo gestRapportoControllo definito in un ExecCommand del
	 * ContentPanel cpRisRicImpianto
	 */
	public ExecResults gestRapportoControllo(

			it.csi.sigit.sigitwebn.dto.risultato_ricerca_impianti.CpRisRicImpiantoModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GESTRAPPORTOCONTROLLO_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String GESTRAPPORTOCONTROLLO_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R737118776) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			String idImpiantoSelez = theModel.getAppDataidImpiantoSelez();

			try {
				getValidationMgr().checkSelezioneElemento(idImpiantoSelez);
				theModel.setAppDatapaginaChiamanteImp(Constants.PAG_RIS_RIC_IMPIANTI);
				theModel.setAppDataisAbilitazioneDatiAllegato(false);
				log.debug("risultato ricerca impianti  nel bottone gestRapportoControllo --> idImpiantoSelezionato: "
						+ idImpiantoSelez);

				// impostazione del result code 
				result.setResultCode(GESTRAPPORTOCONTROLLO_OUTCOME_CODE__OK);
			} catch (ManagerException ex) {

				Validator.gestisciEccezione(result, ex);
			}

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
	 * Implementazione del metodo gestAvviaVerifica definito in un ExecCommand del
	 * ContentPanel cpRisRicImpianto
	 */
	public ExecResults gestAvviaVerifica(

			it.csi.sigit.sigitwebn.dto.risultato_ricerca_impianti.CpRisRicImpiantoModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GESTAVVIAVERIFICA_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String GESTAVVIAVERIFICA_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R553258507) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			String idImpiantoSelez = theModel.getAppDataidImpiantoSelez();

			try {
				getValidationMgr().checkSelezioneElemento(idImpiantoSelez);
				theModel.setAppDatapaginaChiamante(Constants.PAG_RIS_RIC_IMPIANTI);

				//theModel.setAppDataisAbilitazioneDatiAllegato(false);
				log.debug("risultato ricerca impianti  nel bottone gestAvviaVerifica --> idImpiantoSelezionato: "
						+ idImpiantoSelez);

				UtenteLoggato utente = theModel.getAppDatautenteLoggato();

				Verifica verifica = new Verifica();
				verifica.setTipoVerifica(TipoVerificaEnum.IMPIANTO.getIdDb());
				verifica.setCodiceImpianto(ReplaceSpecialCharUtils.sanitize(idImpiantoSelez));
				verifica.setIdAllegato(Constants.DATO_NON_DISPONIBILE_S);
				verifica.setIdDatoDistributore(Constants.DATO_NON_DISPONIBILE_S);
				verifica.setCfUtenteCaricamento(ReplaceSpecialCharUtils.sanitize(utente.getCodiceFiscale()));
				verifica.setDenomUtenteCaricamento(ReplaceSpecialCharUtils.sanitize(utente.getDenominazione()));
				verifica.setEseguitoDa(ReplaceSpecialCharUtils.sanitize(utente.getDenominazione()) + " (" + ReplaceSpecialCharUtils.sanitize(utente.getCodiceFiscale()) + ")");
				verifica.setDataCaricamento(DateUtil.getDataCorrenteFormat());

				IdentificativoImpianto getIdentificativoImpianto = getIdentificativoImpianto(theModel);

				String msgConferma = "Vuoi creare una verifica sull'IMPIANTO "
						+ getIdentificativoImpianto.getCodiceImpianto() + " "
						+ getIdentificativoImpianto.getUbicazione() + "?";

				theModel.setAppDatamessaggioDinamico(ReplaceSpecialCharUtils.sanitize(msgConferma));

				theModel.setAppDataverifica(verifica);

				// impostazione del result code 
				result.setResultCode(GESTAVVIAVERIFICA_OUTCOME_CODE__OK);
			} catch (ManagerException ex) {

				Validator.gestisciEccezione(result, ex);
			}

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::gestAvviaVerifica] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo gestIspezione definito in un ExecCommand del
	 * ContentPanel cpRisRicImpianto
	 */
	public ExecResults gestIspezione(

			it.csi.sigit.sigitwebn.dto.risultato_ricerca_impianti.CpRisRicImpiantoModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GESTISPEZIONE_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String GESTISPEZIONE_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R1110390355) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			String idImpiantoSelez = theModel.getAppDataidImpiantoSelez();

			try {
				getValidationMgr().checkSelezioneElemento(idImpiantoSelez);
				theModel.setAppDatapaginaChiamanteImp(Constants.PAG_RIS_RIC_IMPIANTI);
				//theModel.setAppDataisAbilitazioneDatiAllegato(false);
				log.debug("risultato ricerca impianti  nel bottone gestIspezione --> idImpiantoSelezionato: "
						+ idImpiantoSelez);

				// impostazione del result code 
				result.setResultCode(GESTISPEZIONE_OUTCOME_CODE__OK);
			} catch (ManagerException ex) {

				Validator.gestisciEccezione(result, ex);
			}

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::gestIspezione] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo gestDocumentazione definito in un ExecCommand del
	 * ContentPanel cpRisRicImpianto
	 */
	public ExecResults gestDocumentazione(

			it.csi.sigit.sigitwebn.dto.risultato_ricerca_impianti.CpRisRicImpiantoModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GESTDOCUMENTAZIONE_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String GESTDOCUMENTAZIONE_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-2002735428) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			String idImpiantoSelez = theModel.getAppDataidImpiantoSelez();

			try {
				getValidationMgr().checkSelezioneElemento(idImpiantoSelez);

				theModel.setAppDataidentificativoImpianto(getIdentificativoImpianto(theModel));

				theModel.setAppDatapaginaChiamanteDocumenti(Constants.PAG_RIS_RIC_IMPIANTI);

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
	 * ContentPanel cpRisRicImpianto
	 */
	public ExecResults gestLibrettoWeb(

			it.csi.sigit.sigitwebn.dto.risultato_ricerca_impianti.CpRisRicImpiantoModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GESTLIBRETTOWEB_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String GESTLIBRETTOWEB_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R39308526) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			String idImpiantoSelez = theModel.getAppDataidImpiantoSelez();

			try {
				getValidationMgr().checkSelezioneElemento(idImpiantoSelez);

				theModel.setAppDataidentificativoImpianto(getIdentificativoImpianto(theModel));

				theModel.setAppDatapaginaChiamante(Constants.PAG_RIS_RIC_IMPIANTI);

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
	 * Implementazione del metodo eliminaImpianto definito in un ExecCommand del
	 * ContentPanel cpRisRicImpianto
	 */
	public ExecResults eliminaImpianto(

			it.csi.sigit.sigitwebn.dto.risultato_ricerca_impianti.CpRisRicImpiantoModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String ELIMINAIMPIANTO_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String ELIMINAIMPIANTO_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-27903754) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			// Elimina fisicamente l'impianto

			String idImpiantoSelez = theModel.getAppDataidImpiantoSelez();

			try {

				ResultInvioMail resultInvioMail = getSigitMgr().eliminaImpianto(idImpiantoSelez,
						theModel.getAppDatautenteLoggato().getCodiceFiscale());

				// PROVA DA TOGLIERE
				//ResultInvioMail resultInvioMail = new ResultInvioMail();

				String msg = GenericUtil.getMsgFormatterHtml(resultInvioMail, Messages.INFO_ELIMINAZIONE_CORRETTA);

				/*
				String msg = Messages.INFO_ELIMINAZIONE_CORRETTA;
				
				if (resultInvioMail != null) {
				
					if (resultInvioMail.isPresentsOK()) {
						msg.concat("\n" + Messages.INFO_INDIRIZZI_MAIL_OK);
						msg.concat(resultInvioMail.getFormatDestinatariOK());
					}
				
					if (resultInvioMail.isPresentsKO()) {
						msg.concat("\n" + Messages.INFO_INDIRIZZI_MAIL_KO);
						msg.concat(resultInvioMail.getFormatDestinatariKO());
					}
					
						theModel.getSession().put(
								Constants.SESSIONE_VAR_MESSAGGE,
								new Message(msg,
										Message.INFO));
				}
				 */

				theModel.getSession().put(Constants.SESSIONE_VAR_MESSAGGE, new Message(msg, Message.INFO));

				//
				//				theModel.getSession().put(
				//						Constants.SESSIONE_VAR_MESSAGGE,
				//						new Message(Messages.INFO_ELIMINAZIONE_CORRETTA,
				//								Message.INFO));
				//
				//				result.getGlobalMessages().add(
				//						Messages.INFO_ELIMINAZIONE_CORRETTA);

				//				getSigitMgr().gestisciMessaggioInvioMail(result,
				//						resultInvioMail);

				// Ricerco nuovamente gli impianti
				ArrayList<RisultatoRicImpianto> risRicCodImpiantoList = getSigitMgr().cercaElencoImpianti(
						theModel.getAppDataricercaImpianti(),
						theModel.getAppDatautenteLoggato().getRuolo().getDescRuolo());

				theModel.setAppDatarisultatoRicercaImpianti(risRicCodImpiantoList);

				gestioneMsgRicerca(theModel, result);
				theModel.setAppDataidImpiantoSelez(null);

				// impostazione del result code 
				result.setResultCode(ELIMINAIMPIANTO_OUTCOME_CODE__OK);

				// modifica degli attributi del model (che verranno propagati allo strato
				// di presentation). si puo' agire anche direttamente sull'attributo "session".
			} catch (ManagerException ex) {
				theModel.getSession().put(Constants.SESSIONE_VAR_MESSAGGE,
						new Message(Messages.ERROR_RECUPERO_SERVIZIO, Message.ERROR));

				Validator.gestisciEccezione(result, ex);
			}
			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::eliminaImpianto] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo gestioneVisBottoni definito in un ExecCommand del
	 * ContentPanel cpRisRicImpianto
	 */
	public ExecResults gestioneVisBottoni(

			it.csi.sigit.sigitwebn.dto.risultato_ricerca_impianti.CpRisRicImpiantoModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GESTIONEVISBOTTONI_OUTCOME_CODE__VISUALIZZA = //NOSONAR  Reason:EIAS
				"VISUALIZZA"; //NOSONAR  Reason:EIAS
		final String GESTIONEVISBOTTONI_OUTCOME_CODE__NASCONDI = //NOSONAR  Reason:EIAS
				"NASCONDI"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R228209075) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			ArrayList<RisultatoRicImpianto> elencoImpianti = theModel.getAppDatarisultatoRicercaImpianti();

			if (elencoImpianti != null && elencoImpianti.size() > 0) {
				// impostazione del result code 
				result.setResultCode(GESTIONEVISBOTTONI_OUTCOME_CODE__VISUALIZZA);
			} else {
				// impostazione del result code 
				result.setResultCode(GESTIONEVISBOTTONI_OUTCOME_CODE__NASCONDI);
			}

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::gestioneVisBottoni] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo isRuoloAbilitato definito in un ExecCommand del
	 * ContentPanel cpRisRicImpianto
	 */
	public ExecResults isRuoloAbilitato(

			it.csi.sigit.sigitwebn.dto.risultato_ricerca_impianti.CpRisRicImpiantoModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String ISRUOLOABILITATO_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-849674556) ENABLED START*/
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
	 * Implementazione del metodo gestioneAggElenco definito in un ExecCommand del
	 * ContentPanel cpRisRicImpianto
	 */
	public ExecResults gestioneAggElenco(

			it.csi.sigit.sigitwebn.dto.risultato_ricerca_impianti.CpRisRicImpiantoModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GESTIONEAGGELENCO_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String GESTIONEAGGELENCO_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R355430347) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:
			try {
				log.debug("gestioneAggElenco - START");

				if (theModel.getAppDataaggiornaElencoImpianti() != null
						&& theModel.getAppDataaggiornaElencoImpianti()) {

					ArrayList<RisultatoRicImpianto> risRicCodImpiantoList = null;

					risRicCodImpiantoList = getSigitMgr().ricercaElencoImpiantiWS(theModel.getAppDataricercaImpianti(),
							theModel.getAppDatautenteLoggato());

					theModel.setAppDatarisultatoRicercaImpianti(risRicCodImpiantoList);

					theModel.setAppDataaggiornaElencoImpianti(false);

					resetClearStatus_widg_tbRisultatoRicImp(theModel.getSession());
				}
				gestioneMsgRicerca(theModel, result);
				result.setResultCode(GESTIONEAGGELENCO_OUTCOME_CODE__OK);
				log.debug("gestioneAggElenco - END");
			} catch (ManagerException ex) {

				Validator.gestisciEccezione(result, ex);

			} catch (ServiceException ex) {
				result.getGlobalErrors().add(ex.getMessage());
				result.setResultCode(GESTIONEAGGELENCO_OUTCOME_CODE__KO);
			}
			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::gestioneAggElenco] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo gestioneVisBottoniInit definito in un ExecCommand del
	 * ContentPanel cpRisRicImpianto
	 */
	public ExecResults gestioneVisBottoniInit(

			it.csi.sigit.sigitwebn.dto.risultato_ricerca_impianti.CpRisRicImpiantoModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GESTIONEVISBOTTONIINIT_OUTCOME_CODE__VISUALIZZA = //NOSONAR  Reason:EIAS
				"VISUALIZZA"; //NOSONAR  Reason:EIAS
		final String GESTIONEVISBOTTONIINIT_OUTCOME_CODE__NASCONDI = //NOSONAR  Reason:EIAS
				"NASCONDI"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R58837763) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			ArrayList<RisultatoRicImpianto> elencoImpianti = theModel.getAppDatarisultatoRicercaImpianti();

			if (elencoImpianti != null && elencoImpianti.size() > 0) {
				// impostazione del result code 
				result.setResultCode(GESTIONEVISBOTTONIINIT_OUTCOME_CODE__VISUALIZZA);
			} else {
				// impostazione del result code 
				result.setResultCode(GESTIONEVISBOTTONIINIT_OUTCOME_CODE__NASCONDI);
			}

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::gestioneVisBottoniInit] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo isVisualizzaBtnModificaImpianto definito in un ExecCommand del
	 * ContentPanel cpRisRicImpianto
	 */
	public ExecResults isVisualizzaBtnModificaImpianto(

			it.csi.sigit.sigitwebn.dto.risultato_ricerca_impianti.CpRisRicImpiantoModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String ISVISUALIZZABTNMODIFICAIMPIANTO_OUTCOME_CODE__VISUALIZZA = //NOSONAR  Reason:EIAS
				"VISUALIZZA"; //NOSONAR  Reason:EIAS
		final String ISVISUALIZZABTNMODIFICAIMPIANTO_OUTCOME_CODE__NASCONDI = //NOSONAR  Reason:EIAS
				"NASCONDI"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-87496443) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			Ruolo ruoloUtLog = theModel.getAppDatautenteLoggato().getRuolo();
			if (ruoloUtLog.getDescRuolo().equalsIgnoreCase(Constants.RUOLO_IMPRESA)
					|| ruoloUtLog.getDescRuolo().equalsIgnoreCase(Constants.RUOLO_VALIDATORE)
					|| ruoloUtLog.getDescRuolo().equalsIgnoreCase(Constants.RUOLO_SUPER)
					|| ruoloUtLog.getDescRuolo().equalsIgnoreCase(Constants.RUOLO_ISPETTORE)) {
				// impostazione del result code 
				result.setResultCode(ISVISUALIZZABTNMODIFICAIMPIANTO_OUTCOME_CODE__VISUALIZZA);
			} else {
				// impostazione del result code 
				result.setResultCode(ISVISUALIZZABTNMODIFICAIMPIANTO_OUTCOME_CODE__NASCONDI);
			}
			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::isVisualizzaBtnModificaImpianto] Errore occorso nell'esecuzione del metodo:" + e,
					e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo isVisualizzaBtnModificaImpiantoResp definito in un ExecCommand del
	 * ContentPanel cpRisRicImpianto
	 */
	public ExecResults isVisualizzaBtnModificaImpiantoResp(

			it.csi.sigit.sigitwebn.dto.risultato_ricerca_impianti.CpRisRicImpiantoModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String ISVISUALIZZABTNMODIFICAIMPIANTORESP_OUTCOME_CODE__VISUALIZZA = //NOSONAR  Reason:EIAS
				"VISUALIZZA"; //NOSONAR  Reason:EIAS
		final String ISVISUALIZZABTNMODIFICAIMPIANTORESP_OUTCOME_CODE__NASCONDI = //NOSONAR  Reason:EIAS
				"NASCONDI"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R1521011349) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			Ruolo ruoloUtLog = theModel.getAppDatautenteLoggato().getRuolo();
			if (ruoloUtLog.getDescRuolo().equalsIgnoreCase(Constants.RUOLO_RESPONSABILE)
					|| ruoloUtLog.getDescRuolo().equalsIgnoreCase(Constants.RUOLO_RESPONSABILE_IMPRESA)
					|| ruoloUtLog.getDescRuolo().equalsIgnoreCase(Constants.RUOLO_3RESPONSABILE)) {
				// impostazione del result code 
				result.setResultCode(ISVISUALIZZABTNMODIFICAIMPIANTORESP_OUTCOME_CODE__VISUALIZZA);
			} else {
				// impostazione del result code 
				result.setResultCode(ISVISUALIZZABTNMODIFICAIMPIANTORESP_OUTCOME_CODE__NASCONDI);
			}

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::isVisualizzaBtnModificaImpiantoResp] Errore occorso nell'esecuzione del metodo:"
					+ e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo isVisualizzaBtnVisualizzaImpianto definito in un ExecCommand del
	 * ContentPanel cpRisRicImpianto
	 */
	public ExecResults isVisualizzaBtnVisualizzaImpianto(

			it.csi.sigit.sigitwebn.dto.risultato_ricerca_impianti.CpRisRicImpiantoModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String ISVISUALIZZABTNVISUALIZZAIMPIANTO_OUTCOME_CODE__VISUALIZZA = //NOSONAR  Reason:EIAS
				"VISUALIZZA"; //NOSONAR  Reason:EIAS
		final String ISVISUALIZZABTNVISUALIZZAIMPIANTO_OUTCOME_CODE__NASCONDI = //NOSONAR  Reason:EIAS
				"NASCONDI"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R148793525) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			// impostazione del result code 
			result.setResultCode(ISVISUALIZZABTNVISUALIZZAIMPIANTO_OUTCOME_CODE__VISUALIZZA);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error(
					"[BackEndFacade::isVisualizzaBtnVisualizzaImpianto] Errore occorso nell'esecuzione del metodo:" + e,
					e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo isVisualizzaBtnEliminaImpianto definito in un ExecCommand del
	 * ContentPanel cpRisRicImpianto
	 */
	public ExecResults isVisualizzaBtnEliminaImpianto(

			it.csi.sigit.sigitwebn.dto.risultato_ricerca_impianti.CpRisRicImpiantoModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String ISVISUALIZZABTNELIMINAIMPIANTO_OUTCOME_CODE__VISUALIZZA = //NOSONAR  Reason:EIAS
				"VISUALIZZA"; //NOSONAR  Reason:EIAS
		final String ISVISUALIZZABTNELIMINAIMPIANTO_OUTCOME_CODE__NASCONDI = //NOSONAR  Reason:EIAS
				"NASCONDI"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R25545200) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			Ruolo ruoloUtLog = theModel.getAppDatautenteLoggato().getRuolo();
			if (ruoloUtLog.getDescRuolo().equalsIgnoreCase(Constants.RUOLO_IMPRESA)
					|| ruoloUtLog.getDescRuolo().equalsIgnoreCase(Constants.RUOLO_VALIDATORE)
					|| ruoloUtLog.getDescRuolo().equalsIgnoreCase(Constants.RUOLO_SUPER)
					|| ruoloUtLog.getDescRuolo().equalsIgnoreCase(Constants.RUOLO_ISPETTORE)) {
				// impostazione del result code 
				result.setResultCode(ISVISUALIZZABTNELIMINAIMPIANTO_OUTCOME_CODE__VISUALIZZA);
			} else {
				// impostazione del result code 
				result.setResultCode(ISVISUALIZZABTNELIMINAIMPIANTO_OUTCOME_CODE__NASCONDI);
			}
			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::isVisualizzaBtnEliminaImpianto] Errore occorso nell'esecuzione del metodo:" + e,
					e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo isVisualizzaBtnRapportiImpianto definito in un ExecCommand del
	 * ContentPanel cpRisRicImpianto
	 */
	public ExecResults isVisualizzaBtnRapportiImpianto(

			it.csi.sigit.sigitwebn.dto.risultato_ricerca_impianti.CpRisRicImpiantoModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String ISVISUALIZZABTNRAPPORTIIMPIANTO_OUTCOME_CODE__VISUALIZZA = //NOSONAR  Reason:EIAS
				"VISUALIZZA"; //NOSONAR  Reason:EIAS
		final String ISVISUALIZZABTNRAPPORTIIMPIANTO_OUTCOME_CODE__NASCONDI = //NOSONAR  Reason:EIAS
				"NASCONDI"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R1568650598) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			// impostazione del result code 
			result.setResultCode(ISVISUALIZZABTNRAPPORTIIMPIANTO_OUTCOME_CODE__VISUALIZZA);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::isVisualizzaBtnRapportiImpianto] Errore occorso nell'esecuzione del metodo:" + e,
					e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo isVisualizzaBtnIspezioniImpianto definito in un ExecCommand del
	 * ContentPanel cpRisRicImpianto
	 */
	public ExecResults isVisualizzaBtnIspezioniImpianto(

			it.csi.sigit.sigitwebn.dto.risultato_ricerca_impianti.CpRisRicImpiantoModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String ISVISUALIZZABTNISPEZIONIIMPIANTO_OUTCOME_CODE__VISUALIZZA = //NOSONAR  Reason:EIAS
				"VISUALIZZA"; //NOSONAR  Reason:EIAS
		final String ISVISUALIZZABTNISPEZIONIIMPIANTO_OUTCOME_CODE__NASCONDI = //NOSONAR  Reason:EIAS
				"NASCONDI"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R360725925) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			Ruolo ruoloUtLog = theModel.getAppDatautenteLoggato().getRuolo();
			if (ruoloUtLog.getDescRuolo().equalsIgnoreCase(Constants.RUOLO_ISPETTORE)
					|| ruoloUtLog.getDescRuolo().equalsIgnoreCase(Constants.RUOLO_CONSULTATORE)
					|| ruoloUtLog.getDescRuolo().equalsIgnoreCase(Constants.RUOLO_VALIDATORE)
					|| ruoloUtLog.getDescRuolo().equalsIgnoreCase(Constants.RUOLO_SUPER)) {
				// impostazione del result code 
				result.setResultCode(ISVISUALIZZABTNISPEZIONIIMPIANTO_OUTCOME_CODE__VISUALIZZA);
			} else {
				// impostazione del result code 
				result.setResultCode(ISVISUALIZZABTNISPEZIONIIMPIANTO_OUTCOME_CODE__NASCONDI);
			}
			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error(
					"[BackEndFacade::isVisualizzaBtnIspezioniImpianto] Errore occorso nell'esecuzione del metodo:" + e,
					e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo isVisualizzaBtnInserisciImpianto definito in un ExecCommand del
	 * ContentPanel cpRisRicImpianto
	 */
	public ExecResults isVisualizzaBtnInserisciImpianto(

			it.csi.sigit.sigitwebn.dto.risultato_ricerca_impianti.CpRisRicImpiantoModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String ISVISUALIZZABTNINSERISCIIMPIANTO_OUTCOME_CODE__VISUALIZZA = //NOSONAR  Reason:EIAS
				"VISUALIZZA"; //NOSONAR  Reason:EIAS
		final String ISVISUALIZZABTNINSERISCIIMPIANTO_OUTCOME_CODE__NASCONDI = //NOSONAR  Reason:EIAS
				"NASCONDI"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R313772790) ENABLED START*/
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
	 * ContentPanel cpRisRicImpianto
	 */
	public ExecResults isVisualizzaBtnInserisciImpiantoResp(

			it.csi.sigit.sigitwebn.dto.risultato_ricerca_impianti.CpRisRicImpiantoModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String ISVISUALIZZABTNINSERISCIIMPIANTORESP_OUTCOME_CODE__VISUALIZZA = //NOSONAR  Reason:EIAS
				"VISUALIZZA"; //NOSONAR  Reason:EIAS
		final String ISVISUALIZZABTNINSERISCIIMPIANTORESP_OUTCOME_CODE__NASCONDI = //NOSONAR  Reason:EIAS
				"NASCONDI"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-578860026) ENABLED START*/
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
	 * Implementazione del metodo gestioneMessaggio definito in un ExecCommand del
	 * ContentPanel cpRisRicImpianto
	 */
	public ExecResults gestioneMessaggio(

			it.csi.sigit.sigitwebn.dto.risultato_ricerca_impianti.CpRisRicImpiantoModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GESTIONEMESSAGGIO_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-73867143) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			Message msg = (Message) theModel.getSession().get(Constants.SESSIONE_VAR_MESSAGGE);

			if (msg != null && msg.isInfoMessage()) {
				result.getGlobalMessages().add(msg.getText());
				theModel.getSession().remove(Constants.SESSIONE_VAR_MESSAGGE);
			} else if (msg != null && msg.isErrorMessage()) {

				result.getGlobalErrors().add(msg.getText());
				theModel.getSession().remove(Constants.SESSIONE_VAR_MESSAGGE);
			}

			// impostazione del result code 
			result.setResultCode(GESTIONEMESSAGGIO_OUTCOME_CODE__OK);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::gestioneMessaggio] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	//////////////////////////////////////////////////////////////////////////////
	/// Metodi statici per il reset delle tabelle
	//////////////////////////////////////////////////////////////////////////////

	/**
	 * permette di resettare lo stato di paginazione della tabella widg_tbRisultatoRicImp
	 */
	public static void resetClearStatus_widg_tbRisultatoRicImp(java.util.Map session) {
		session.put("cpRisRicImpianto_tbRisultatoRicImp_clearStatus", Boolean.TRUE);
	}

	//////////////////////////////////////////////////////////////////////////////
	/// Property aggiuntive del bean
	//////////////////////////////////////////////////////////////////////////////
	/*PROTECTED REGION ID(R363289413) ENABLED START*/
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

	private void gestioneMsgRicerca(CpRisRicImpiantoModel theModel, ExecResults result) throws DbManagerException {
		Integer maxNumRighe = getDbMgr().cercaConfigValueNumerico(Constants.MAX_RIGHE);
		log.debug("MAX num righe da visualizzare = " + maxNumRighe);
		ArrayList<RisultatoRicImpianto> risRicImpiantoList = theModel.getAppDatarisultatoRicercaImpianti();
		if (risRicImpiantoList != null && risRicImpiantoList.size() == maxNumRighe)
			result.getGlobalMessages()
					.add(Messages.MSG_RISULTATI_RICERCA.replaceFirst("##value##", maxNumRighe.toString()));
	}

	private IdentificativoImpianto getIdentificativoImpianto(CpRisRicImpiantoModel theModel) {
		IdentificativoImpianto identificativo = new IdentificativoImpianto();

		String idImpiantoSelez = theModel.getAppDataidImpiantoSelez();

		ArrayList<RisultatoRicImpianto> risRicCodImpiantoList = theModel.getAppDatarisultatoRicercaImpianti();

		for (RisultatoRicImpianto risultatoRicImpianto : risRicCodImpiantoList) {

			if (risultatoRicImpianto.getCodiceImpianto().equals(idImpiantoSelez)) {

				identificativo.setCodiceImpianto(ReplaceSpecialCharUtils.sanitize(risultatoRicImpianto.getCodiceImpianto()));
				identificativo.setUbicazione(ReplaceSpecialCharUtils.sanitize(risultatoRicImpianto.getDescIndirizzoCompleto()));
				identificativo.setResponsabile(ReplaceSpecialCharUtils.sanitize(risultatoRicImpianto.getDenomResponsabile()));

				theModel.setAppDataidentificativoImpianto(identificativo);
				break;
			}
		}

		return identificativo;

	}

	/*PROTECTED REGION END*/
}
