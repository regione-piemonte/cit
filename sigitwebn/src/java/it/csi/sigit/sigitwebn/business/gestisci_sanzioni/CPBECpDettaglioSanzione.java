package it.csi.sigit.sigitwebn.business.gestisci_sanzioni;

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

/*PROTECTED REGION ID(R-35761930) ENABLED START*/
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.SigitTDocAzioneDto;
import it.csi.sigit.sigitwebn.business.manager.DbMgr;
import it.csi.sigit.sigitwebn.business.manager.SigitMgr;
import it.csi.sigit.sigitwebn.business.manager.ValidationMgr;
import it.csi.sigit.sigitwebn.business.manager.db.DbAzioneMgr;
import it.csi.sigit.sigitwebn.business.manager.util.ManagerException;
import it.csi.sigit.sigitwebn.business.manager.util.ValidationManagerException;
/*PROTECTED REGION END*/

public class CPBECpDettaglioSanzione {

	/**  */
	protected static final Logger log = //NOSONAR  Reason:EIAS 
			Logger.getLogger(Constants.APPLICATION_CODE + ".business"); //NOSONAR  Reason:EIAS

	//////////////////////////////////////////////////////////////////////////////
	/// Costanti identificative degli Application Data
	//////////////////////////////////////////////////////////////////////////////

	// ApplicationData: [utenteLoggato, scope:USER_SESSION]
	public static final String APPDATA_UTENTELOGGATO_CODE = "appDatautenteLoggato";

	// ApplicationData: [sanzione, scope:USER_SESSION]
	public static final String APPDATA_SANZIONE_CODE = "appDatasanzione";

	// ApplicationData: [idSanzioneSelezionata, scope:USER_SESSION]
	public static final String APPDATA_IDSANZIONESELEZIONATA_CODE = "appDataidSanzioneSelezionata";

	// ApplicationData: [elencoAzioni, scope:USER_SESSION]
	public static final String APPDATA_ELENCOAZIONI_CODE = "appDataelencoAzioni";

	// ApplicationData: [idAzioneSelezionata, scope:USER_SESSION]
	public static final String APPDATA_IDAZIONESELEZIONATA_CODE = "appDataidAzioneSelezionata";

	// ApplicationData: [idTipoAzione, scope:USER_SESSION]
	public static final String APPDATA_IDTIPOAZIONE_CODE = "appDataidTipoAzione";

	// ApplicationData: [Ispezione2018, scope:USER_SESSION]
	public static final String APPDATA_ISPEZIONE2018_CODE = "appDataIspezione2018";

	// ApplicationData: [idAccertamentoSelezionato, scope:USER_SESSION]
	public static final String APPDATA_IDACCERTAMENTOSELEZIONATO_CODE = "appDataidAccertamentoSelezionato";

	// ApplicationData: [elencoStatiSanzione, scope:USER_SESSION]
	public static final String APPDATA_ELENCOSTATISANZIONE_CODE = "appDataelencoStatiSanzione";

	// ApplicationData: [paginaChiamanteDettaglioSanzione, scope:USER_SESSION]
	public static final String APPDATA_PAGINACHIAMANTEDETTAGLIOSANZIONE_CODE = "appDatapaginaChiamanteDettaglioSanzione";

	// ApplicationData: [datiInserimentoSanzione, scope:USER_SESSION]
	public static final String APPDATA_DATIINSERIMENTOSANZIONE_CODE = "appDatadatiInserimentoSanzione";

	// ApplicationData: [elencoIspettori, scope:USER_SESSION]
	public static final String APPDATA_ELENCOISPETTORI_CODE = "appDataelencoIspettori";

	// ApplicationData: [elencoValidatori, scope:USER_SESSION]
	public static final String APPDATA_ELENCOVALIDATORI_CODE = "appDataelencoValidatori";

	// ApplicationData: [dataPagamento, scope:USER_SESSION]
	public static final String APPDATA_DATAPAGAMENTO_CODE = "appDatadataPagamento";

	// ApplicationData: [motivoAnnullamentoSanzione, scope:USER_SESSION]
	public static final String APPDATA_MOTIVOANNULLAMENTOSANZIONE_CODE = "appDatamotivoAnnullamentoSanzione";

	//////////////////////////////////////////////////////////////////////////////
	/// Metodi associati alla U.I.
	//////////////////////////////////////////////////////////////////////////////

	// nome del content panel associato al bean
	public static final String CPNAME = "cpDettaglioSanzione";

	public static final String MULTIPANEL_MPAZIONISANZIONE = "mpAzioniSanzione";
	public static final String MPI_MPAZIONISANZIONE_FPPAGAMENTO = CPNAME + "_" + MULTIPANEL_MPAZIONISANZIONE + "_"
			+ "fpPagamento";
	public static final String MPI_MPAZIONISANZIONE_FPASSEGNAA = CPNAME + "_" + MULTIPANEL_MPAZIONISANZIONE + "_"
			+ "fpAssegnaA";
	public static final String MPI_MPAZIONISANZIONE_FPANNULLAMENTO = CPNAME + "_" + MULTIPANEL_MPAZIONISANZIONE + "_"
			+ "fpAnnullamento";

	/** 
	 * Restituisce il tab correntemente visibile in un determinato tab set
	 */
	private String getCurrentTab(Map session, String tabSetName) {
		String value = (String) session.get(CPNAME + "_" + tabSetName + "_selectedMultiPanel");
		return value;
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo preparaSalvataggioSanzione definito in un ExecCommand del
	 * ContentPanel cpDettaglioSanzione
	 */
	public ExecResults preparaSalvataggioSanzione(

			it.csi.sigit.sigitwebn.dto.gestisci_sanzioni.CpDettaglioSanzioneModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String PREPARASALVATAGGIOSANZIONE_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String PREPARASALVATAGGIOSANZIONE_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R1375885429) ENABLED START*/
			try {
				//l'unica info che viene di fatto modificata sono le note
				Sanzione sanzione = theModel.getAppDatasanzione();

				getSigitMgr().salvaSanzioneDaDettaglio(sanzione);

				// impostazione del result code 
				result.setResultCode(PREPARASALVATAGGIOSANZIONE_OUTCOME_CODE__OK);
			} catch (ManagerException e) {
				Validator.gestisciEccezione(result, e);
			}

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::preparaSalvataggioSanzione] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo downloadFile definito in un ExecCommand del
	 * ContentPanel cpDettaglioSanzione
	 */
	public ExecResults downloadFile(

			it.csi.sigit.sigitwebn.dto.gestisci_sanzioni.CpDettaglioSanzioneModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String DOWNLOADFILE_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String DOWNLOADFILE_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R1354804193) ENABLED START*/

			//si recupera il documento in base a quanto scritto nell'idRiga
			log.debug("STAMPO LA RIGA SELEZIONATA: *" + theModel.getIdRiga() + "*");
			log.debug("STAMPO LA COLONNA SELEZIONATA: *" + theModel.getIdColonna() + "*");

			Integer idDocumento = ConvertUtil.convertToInteger(theModel.getIdRiga());
			SigitTDocAzioneDto documentoDb = getDbAzioneMgr().cercaDocAzioneById(idDocumento);

			Documento documentoInSessione = new Documento();
			documentoInSessione.setUidIndex(documentoDb.getUidIndex());
			documentoInSessione.setNomeDocOrig(documentoDb.getNomeDocOriginale());

			theModel.getSession().put(Constants.SESSIONE_VAR_DOCUMENTO_SELEZIONATO, documentoInSessione);

			// impostazione del result code 
			result.setResultCode(DOWNLOADFILE_OUTCOME_CODE__OK);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::downloadFile] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo inserisciAzione definito in un ExecCommand del
	 * ContentPanel cpDettaglioSanzione
	 */
	public ExecResults inserisciAzione(

			it.csi.sigit.sigitwebn.dto.gestisci_sanzioni.CpDettaglioSanzioneModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String INSERISCIAZIONE_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String INSERISCIAZIONE_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R1614863474) ENABLED START*/

			theModel.setAppDataidTipoAzione(Constants.ID_TIPO_AZIONE_SANZIONE);
			theModel.setAppDataidAzioneSelezionata(null);
			result.setResultCode(INSERISCIAZIONE_OUTCOME_CODE__OK);

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::inserisciAzione] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo impostaNuovaSveglia definito in un ExecCommand del
	 * ContentPanel cpDettaglioSanzione
	 */
	public ExecResults impostaNuovaSveglia(

			it.csi.sigit.sigitwebn.dto.gestisci_sanzioni.CpDettaglioSanzioneModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String IMPOSTANUOVASVEGLIA_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-477957782) ENABLED START*/
			theModel.setAppDataidAzioneSelezionata(
					ConvertUtil.convertToString(theModel.getAppDatasanzione().getIdSanzione()));
			theModel.setAppDataidTipoAzione(Constants.ID_TIPO_AZIONE_SANZIONE);

			// impostazione del result code 
			result.setResultCode(IMPOSTANUOVASVEGLIA_OUTCOME_CODE__OK);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::impostaNuovaSveglia] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo visualizzaAccertamento definito in un ExecCommand del
	 * ContentPanel cpDettaglioSanzione
	 */
	public ExecResults visualizzaAccertamento(

			it.csi.sigit.sigitwebn.dto.gestisci_sanzioni.CpDettaglioSanzioneModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String VISUALIZZAACCERTAMENTO_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-1429122633) ENABLED START*/

			Sanzione sanzione = theModel.getAppDatasanzione();
			theModel.setAppDataidAccertamentoSelezionato(sanzione.getAccertamentoAssociato());
			result.setResultCode(VISUALIZZAACCERTAMENTO_OUTCOME_CODE__OK);
			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::visualizzaAccertamento] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo visualizzaIspezione definito in un ExecCommand del
	 * ContentPanel cpDettaglioSanzione
	 */
	public ExecResults visualizzaIspezione(

			it.csi.sigit.sigitwebn.dto.gestisci_sanzioni.CpDettaglioSanzioneModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String VISUALIZZAISPEZIONE_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-1249020717) ENABLED START*/

			Sanzione sanzione = theModel.getAppDatasanzione();

			Ispezione2018 ispezioneEsistente = new Ispezione2018();
			ispezioneEsistente.setIdentificativoIspezione(sanzione.getIspezioneAssociata());

			theModel.setAppDataIspezione2018(ispezioneEsistente);
			result.setResultCode(VISUALIZZAISPEZIONE_OUTCOME_CODE__OK);

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::visualizzaIspezione] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo notificaSanzione definito in un ExecCommand del
	 * ContentPanel cpDettaglioSanzione
	 */
	public ExecResults notificaSanzione(

			it.csi.sigit.sigitwebn.dto.gestisci_sanzioni.CpDettaglioSanzioneModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String NOTIFICASANZIONE_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String NOTIFICASANZIONE_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R242937943) ENABLED START*/

			//viene inizializzato l'oggetto che verra' caricato nel content panel successivo
			DatiInserimentoSanzione sanzioneEsistente = new DatiInserimentoSanzione();
			sanzioneEsistente.setIdSanzione(theModel.getAppDatasanzione().getIdSanzione());
			theModel.setAppDatadatiInserimentoSanzione(sanzioneEsistente);

			// impostazione del result code 
			result.setResultCode(NOTIFICASANZIONE_OUTCOME_CODE__OK);

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::notificaSanzione] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo preparaAnnullamentoSanzione definito in un ExecCommand del
	 * ContentPanel cpDettaglioSanzione
	 */
	public ExecResults preparaAnnullamentoSanzione(

			it.csi.sigit.sigitwebn.dto.gestisci_sanzioni.CpDettaglioSanzioneModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String PREPARAANNULLAMENTOSANZIONE_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String PREPARAANNULLAMENTOSANZIONE_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R1160468917) ENABLED START*/

			theModel.setAppDatamotivoAnnullamentoSanzione(null);

			result.setResultCode(PREPARAANNULLAMENTOSANZIONE_OUTCOME_CODE__OK);

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::preparaAnnullamentoSanzione] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo preparaAssegnazione definito in un ExecCommand del
	 * ContentPanel cpDettaglioSanzione
	 */
	public ExecResults preparaAssegnazione(

			it.csi.sigit.sigitwebn.dto.gestisci_sanzioni.CpDettaglioSanzioneModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String PREPARAASSEGNAZIONE_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String PREPARAASSEGNAZIONE_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-802530545) ENABLED START*/

			//in base al tipo di provenienza della sanzione verrà popolata la lista dei validatori o degli ispettori
			Sanzione sanzione = theModel.getAppDatasanzione();

			try {

				if (sanzione.getAccertamentoAssociato() != null
						&& !Constants.DATO_NON_DISPONIBILE_S.equals(sanzione.getAccertamentoAssociato())) {
					//trattandosi di accertamento subentrano i validatori
					theModel.setAppDataelencoValidatori(getSigitMgr().getElencoValidatoriIdPf(true));
				} else if (sanzione.getIspezioneAssociata() != null
						&& !Constants.DATO_NON_DISPONIBILE_S.equals(sanzione.getIspezioneAssociata())) {
					// trattandosi di ispezione subentrano gli ispettori
					theModel.setAppDataelencoIspettori(getSigitMgr().getElencoIspettoriIdPf(true));
				}

				// impostazione del result code 
				result.setResultCode(PREPARAASSEGNAZIONE_OUTCOME_CODE__OK);
			} catch (ManagerException e) {
				Validator.gestisciEccezione(result, e);
			}

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::preparaAssegnazione] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo preparaConfermaPagamento definito in un ExecCommand del
	 * ContentPanel cpDettaglioSanzione
	 */
	public ExecResults preparaConfermaPagamento(

			it.csi.sigit.sigitwebn.dto.gestisci_sanzioni.CpDettaglioSanzioneModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String PREPARACONFERMAPAGAMENTO_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String PREPARACONFERMAPAGAMENTO_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-1559439609) ENABLED START*/
			try {

				Sanzione sanzione = theModel.getAppDatasanzione();
				getValidationMgr().validaPagamentoSanzione(theModel.getAppDatadataPagamento(),
						sanzione.getDataComunicazione());
				//una volta superata la validazione si procede al salvataggio vero e proprio dell'operazione

				getSigitMgr().pagaSanzioneTrans(theModel.getAppDatadataPagamento(), sanzione.getIdSanzione(),
						theModel.getAppDatautenteLoggato());

				Sanzione sanzioneNew = getSigitMgr().getSanzionePerDettaglioDaId(sanzione.getIdSanzione(),
						ConvertUtil.convertIdDescriptionsInMap(theModel.getAppDataelencoStatiSanzione()));

				theModel.setAppDatasanzione(sanzioneNew);

				//dopo il caricamento della sanzione occorre caricare eventuali elenchi
				caricaAzioni(theModel);

				result.setResultCode(PREPARACONFERMAPAGAMENTO_OUTCOME_CODE__OK);
			} catch (ManagerException e) {
				Validator.gestisciEccezione(result, e);
			}

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::preparaConfermaPagamento] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo preparaAnnullaPagamento definito in un ExecCommand del
	 * ContentPanel cpDettaglioSanzione
	 */
	public ExecResults preparaAnnullaPagamento(

			it.csi.sigit.sigitwebn.dto.gestisci_sanzioni.CpDettaglioSanzioneModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String PREPARAANNULLAPAGAMENTO_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-1691156265) ENABLED START*/
			//viene semplicemente resettato l'appdata del pagamento
			theModel.setAppDatadataPagamento(null);

			// impostazione del result code 
			result.setResultCode(PREPARAANNULLAPAGAMENTO_OUTCOME_CODE__OK);

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::preparaAnnullaPagamento] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo preparaConfermaAssegnazione definito in un ExecCommand del
	 * ContentPanel cpDettaglioSanzione
	 */
	public ExecResults preparaConfermaAssegnazione(

			it.csi.sigit.sigitwebn.dto.gestisci_sanzioni.CpDettaglioSanzioneModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String PREPARACONFERMAASSEGNAZIONE_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String PREPARACONFERMAASSEGNAZIONE_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R1150256490) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			try {

				ValidationManagerException ex = new ValidationManagerException();
				boolean isValidatore = false;
				//si verifica che ci sia la selezione del responsabile
				Sanzione sanzione = theModel.getAppDatasanzione();
				if (sanzione.getAccertamentoAssociato() != null
						&& !Constants.DATO_NON_DISPONIBILE_S.equals(sanzione.getAccertamentoAssociato())) {
					isValidatore = true;
					if (GenericUtil.isNullOrEmpty(sanzione.getIdValidatoreScelto())) {
						ex.addFieldRequired(APPDATA_SANZIONE_CODE + ".idValidatoreScelto");
						throw ex;
					}
				}

				if (sanzione.getIspezioneAssociata() != null
						&& !Constants.DATO_NON_DISPONIBILE_S.equals(sanzione.getIspezioneAssociata())) {
					if (GenericUtil.isNullOrEmpty(sanzione.getIdIspettoreScelto())) {
						ex.addFieldRequired(APPDATA_SANZIONE_CODE + ".idIspettoreScelto");
						throw ex;
					}
				}

				//				Map<String, String> mappaResponsabili = ConvertUtil.convertCodeDescriptionsInMap(
				//						isValidatore ? theModel.getAppDataelencoValidatori() : theModel.getAppDataelencoIspettori());

				String infoEmail = getSigitMgr().associaSanzioneTrans(isValidatore, sanzione,
						theModel.getAppDatautenteLoggato());

				theModel.setAppDatasanzione(getSigitMgr().getSanzionePerDettaglioDaId(sanzione.getIdSanzione(),
						ConvertUtil.convertIdDescriptionsInMap(theModel.getAppDataelencoStatiSanzione())));

				caricaAzioni(theModel);

				result.getGlobalMessages().add(Messages.MSG_AGGIORNAMENTO_CORRETTO + infoEmail);

				result.setResultCode(PREPARACONFERMAASSEGNAZIONE_OUTCOME_CODE__OK);

			} catch (ManagerException e) {
				Validator.gestisciEccezione(result, e);
			}

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::preparaConfermaAssegnazione] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo preparaAnnullaAssegnazione definito in un ExecCommand del
	 * ContentPanel cpDettaglioSanzione
	 */
	public ExecResults preparaAnnullaAssegnazione(

			it.csi.sigit.sigitwebn.dto.gestisci_sanzioni.CpDettaglioSanzioneModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String PREPARAANNULLAASSEGNAZIONE_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-1515501158) ENABLED START*/
			//vengono resettate le scelte eventualmente fatte tra validatore/ispettore

			theModel.getAppDatasanzione().setIdIspettoreScelto(null);
			theModel.getAppDatasanzione().setIdValidatoreScelto(null);

			result.setResultCode(PREPARAANNULLAASSEGNAZIONE_OUTCOME_CODE__OK);

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::preparaAnnullaAssegnazione] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo annullaSanzione definito in un ExecCommand del
	 * ContentPanel cpDettaglioSanzione
	 */
	public ExecResults annullaSanzione(

			it.csi.sigit.sigitwebn.dto.gestisci_sanzioni.CpDettaglioSanzioneModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String ANNULLASANZIONE_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String ANNULLASANZIONE_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R1073436207) ENABLED START*/
			try {
				//si controlla che ci sia stato il settaggio del motivo annullamento
				Sanzione sanzione = theModel.getAppDatasanzione();
				ValidationManagerException vex = new ValidationManagerException();
				if (GenericUtil.isNullOrEmpty(theModel.getAppDatamotivoAnnullamentoSanzione())) {

					vex.addFieldRequired(APPDATA_MOTIVOANNULLAMENTOSANZIONE_CODE);

				} else {
					ValidationMgr.checkAsciiStringMaxLength(theModel.getAppDatamotivoAnnullamentoSanzione(), 1000,
							APPDATA_MOTIVOANNULLAMENTOSANZIONE_CODE, vex);
				}

				if (!vex.getFieldList().isEmpty()) {
					throw vex;
				}

				sanzione.setDescMotivoAnnullamento(theModel.getAppDatamotivoAnnullamentoSanzione());

				boolean isValidatore = sanzione.getAccertamentoAssociato() != null
						&& !Constants.DATO_NON_DISPONIBILE_S.equals(sanzione.getAccertamentoAssociato());

				//dopo aver superato il controllo si può procedere con l'annullamento vero e proprio
				getSigitMgr().annullaSanzioneTrans(isValidatore, sanzione, theModel.getAppDatautenteLoggato());

				Sanzione sanzioneNew = getSigitMgr().getSanzionePerDettaglioDaId(sanzione.getIdSanzione(),
						ConvertUtil.convertIdDescriptionsInMap(theModel.getAppDataelencoStatiSanzione()));

				theModel.setAppDatasanzione(sanzioneNew);

				//dopo il caricamento della sanzione occorre caricare eventuali elenchi
				caricaAzioni(theModel);

				result.setResultCode(ANNULLASANZIONE_OUTCOME_CODE__OK);
			} catch (ManagerException e) {
				Validator.gestisciEccezione(result, e);
			}

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::annullaSanzione] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo resettaDatiAnnullamentoSanzione definito in un ExecCommand del
	 * ContentPanel cpDettaglioSanzione
	 */
	public ExecResults resettaDatiAnnullamentoSanzione(

			it.csi.sigit.sigitwebn.dto.gestisci_sanzioni.CpDettaglioSanzioneModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String RESETTADATIANNULLAMENTOSANZIONE_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-1546499126) ENABLED START*/

			theModel.setAppDatamotivoAnnullamentoSanzione(null);

			// impostazione del result code 
			result.setResultCode(RESETTADATIANNULLAMENTOSANZIONE_OUTCOME_CODE__OK);

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::resettaDatiAnnullamentoSanzione] Errore occorso nell'esecuzione del metodo:" + e,
					e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo gestisciIndietroRisultatoRicercaSanzioni definito in un ExecCommand del
	 * ContentPanel cpDettaglioSanzione
	 */
	public ExecResults gestisciIndietroRisultatoRicercaSanzioni(

			it.csi.sigit.sigitwebn.dto.gestisci_sanzioni.CpDettaglioSanzioneModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GESTISCIINDIETRORISULTATORICERCASANZIONI_OUTCOME_CODE__ACCERTAMENTO = //NOSONAR  Reason:EIAS
				"ACCERTAMENTO"; //NOSONAR  Reason:EIAS
		final String GESTISCIINDIETRORISULTATORICERCASANZIONI_OUTCOME_CODE__ISPEZIONE = //NOSONAR  Reason:EIAS
				"ISPEZIONE"; //NOSONAR  Reason:EIAS
		final String GESTISCIINDIETRORISULTATORICERCASANZIONI_OUTCOME_CODE__RICERCA = //NOSONAR  Reason:EIAS
				"RICERCA"; //NOSONAR  Reason:EIAS
		final String GESTISCIINDIETRORISULTATORICERCASANZIONI_OUTCOME_CODE__SVEGLIE = //NOSONAR  Reason:EIAS
				"SVEGLIE"; //NOSONAR  Reason:EIAS
		final String GESTISCIINDIETRORISULTATORICERCASANZIONI_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-1060955959) ENABLED START*/

			Sanzione sanzione = theModel.getAppDatasanzione();

			if ("ACCERTAMENTO".equals(theModel.getAppDatapaginaChiamanteDettaglioSanzione())) {
				theModel.setAppDataidAccertamentoSelezionato(sanzione.getAccertamentoAssociato());
			}

			if ("ISPEZIONE".equals(theModel.getAppDatapaginaChiamanteDettaglioSanzione())) {
				Ispezione2018 ispezioneEsistente = new Ispezione2018();
				ispezioneEsistente.setIdentificativoIspezione(sanzione.getIspezioneAssociata());
				theModel.setAppDataIspezione2018(ispezioneEsistente);
			}

			result.setResultCode(theModel.getAppDatapaginaChiamanteDettaglioSanzione());

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error(
					"[BackEndFacade::gestisciIndietroRisultatoRicercaSanzioni] Errore occorso nell'esecuzione del metodo:"
							+ e,
					e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo isRuoloAbilitato definito in un ExecCommand del
	 * ContentPanel cpDettaglioSanzione
	 */
	public ExecResults isRuoloAbilitato(

			it.csi.sigit.sigitwebn.dto.gestisci_sanzioni.CpDettaglioSanzioneModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String ISRUOLOABILITATO_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-1658840707) ENABLED START*/
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
	 * Implementazione del metodo caricaDettaglioSanzione definito in un ExecCommand del
	 * ContentPanel cpDettaglioSanzione
	 */
	public ExecResults caricaDettaglioSanzione(

			it.csi.sigit.sigitwebn.dto.gestisci_sanzioni.CpDettaglioSanzioneModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String CARICADETTAGLIOSANZIONE_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R1112057636) ENABLED START*/

			try {

				if (theModel.getAppDataelencoStatiSanzione() == null
						|| theModel.getAppDataelencoStatiSanzione().isEmpty()) {
					theModel.setAppDataelencoStatiSanzione(getSigitMgr().getElencoStatiSanzione());
				}

				//viene recuperata la sanzione a partire dall'id
				Integer idSanzione = theModel.getAppDataidSanzioneSelezionata();
				Sanzione sanzione = getSigitMgr().getSanzionePerDettaglioDaId(idSanzione,
						ConvertUtil.convertIdDescriptionsInMap(theModel.getAppDataelencoStatiSanzione()));

				theModel.setAppDatasanzione(sanzione);

				//dopo il caricamento della sanzione occorre caricare eventuali elenchi
				caricaAzioni(theModel);

				theModel.setAppDatadataPagamento(null);

				result.setResultCode(CARICADETTAGLIOSANZIONE_OUTCOME_CODE__OK);
			} catch (ManagerException ex) {

				Validator.gestisciEccezione(result, ex);

			}

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::caricaDettaglioSanzione] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	//////////////////////////////////////////////////////////////////////////////
	/// Metodi statici per il reset delle tabelle
	//////////////////////////////////////////////////////////////////////////////

	/**
	 * permette di resettare lo stato di paginazione della tabella widg_tbAzioniSvolte
	 */
	public static void resetClearStatus_widg_tbAzioniSvolte(java.util.Map session) {
		session.put("cpDettaglioSanzione_tbAzioniSvolte_clearStatus", Boolean.TRUE);
	}

	//////////////////////////////////////////////////////////////////////////////
	/// Property aggiuntive del bean
	//////////////////////////////////////////////////////////////////////////////
	/*PROTECTED REGION ID(R926025976) ENABLED START*/
	private DbMgr dbMgr;

	public DbMgr getDbMgr() {
		return dbMgr;
	}

	public void setDbMgr(DbMgr dbMgr) {
		this.dbMgr = dbMgr;
	}

	private DbAzioneMgr dbAzioneMgr;

	public DbAzioneMgr getDbAzioneMgr() {
		return dbAzioneMgr;
	}

	public void setDbAzioneMgr(DbAzioneMgr dbAzioneMgr) {
		this.dbAzioneMgr = dbAzioneMgr;
	}

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

	private void caricaAzioni(it.csi.sigit.sigitwebn.dto.gestisci_sanzioni.CpDettaglioSanzioneModel theModel)
			throws ManagerException {

		// Rileggo le azioni
		Azione azioneFiltro = new Azione();
		azioneFiltro.setFkAzione(theModel.getAppDatasanzione().getIdSanzione());

		theModel.setAppDataelencoAzioni((ArrayList<Azione>) getSigitMgr()
				.cercaAzioniByFiltro(Constants.ID_TIPO_AZIONE_SANZIONE, azioneFiltro, true));

	}

	public static boolean isCampoAccertamentoEditabile(
			it.csi.sigit.sigitwebn.dto.gestisci_sanzioni.CpDettaglioSanzioneModel theModel) {

		UtenteLoggato utente = theModel.getAppDatautenteLoggato();

		log.debug("theModel.getAppDatasanzione().getIdSanzione(): " + theModel.getAppDatasanzione().getIdSanzione());
		log.debug("theModel.getAppDatasanzione().getIdStatoSanzione(): "
				+ theModel.getAppDatasanzione().getIdStatoSanzione());
		log.debug("passo 1: "
				+ (theModel.getAppDatasanzione() == null || theModel.getAppDatasanzione().getIdSanzione() == null
						|| ConvertUtil.convertToString(Constants.ID_STATO_SANZIONE_BOZZA)
								.equals(theModel.getAppDatasanzione().getIdStatoSanzione())
						|| ConvertUtil.convertToString(Constants.ID_STATO_SANZIONE_COMUNICATA)
								.equals(theModel.getAppDatasanzione().getIdStatoSanzione())));

		log.debug("passo 2: " + GenericUtil.checkValidRole(utente,
				Arrays.asList(Constants.RUOLO_VALIDATORE, Constants.RUOLO_SUPER, Constants.RUOLO_ISPETTORE), false,
				true));

		log.debug("passo 1 NEW: " + (theModel.getAppDatasanzione() == null
				|| theModel.getAppDatasanzione().getIdSanzione() == null
				|| Constants.ID_STATO_SANZIONE_BOZZA == theModel.getAppDatasanzione().getIdStatoSanzione()
				|| Constants.ID_STATO_SANZIONE_COMUNICATA == theModel.getAppDatasanzione().getIdStatoSanzione()));

		boolean prova = ((theModel.getAppDatasanzione() == null || theModel.getAppDatasanzione().getIdSanzione() == null
				|| ConvertUtil.convertToString(Constants.ID_STATO_SANZIONE_BOZZA)
						.equals(theModel.getAppDatasanzione().getIdStatoSanzione())
				|| ConvertUtil.convertToString(Constants.ID_STATO_SANZIONE_COMUNICATA)
						.equals(theModel.getAppDatasanzione().getIdStatoSanzione()))
				&& GenericUtil.checkValidRole(utente,
						Arrays.asList(Constants.RUOLO_VALIDATORE, Constants.RUOLO_SUPER, Constants.RUOLO_ISPETTORE),
						false, true));

		log.debug("### LA SANZIONE E' MODIFICABILE: " + prova);

		return ((theModel.getAppDatasanzione() == null || theModel.getAppDatasanzione().getIdSanzione() == null
				|| Constants.ID_STATO_SANZIONE_BOZZA == theModel.getAppDatasanzione().getIdStatoSanzione()
				|| Constants.ID_STATO_SANZIONE_COMUNICATA == theModel.getAppDatasanzione().getIdStatoSanzione())
				&& GenericUtil.checkValidRole(utente,
						Arrays.asList(Constants.RUOLO_VALIDATORE, Constants.RUOLO_SUPER, Constants.RUOLO_ISPETTORE),
						false, true));

	}

	public static boolean isUtenteAbilitatoOperazioneSanzione(
			it.csi.sigit.sigitwebn.dto.gestisci_sanzioni.CpDettaglioSanzioneModel theModel) {

		UtenteLoggato utente = theModel.getAppDatautenteLoggato();

		return (theModel.getAppDatasanzione() == null || (theModel.getAppDatasanzione().getIdSanzione() == null
				|| Constants.ID_STATO_SANZIONE_BOZZA == theModel.getAppDatasanzione().getIdStatoSanzione()
				|| Constants.ID_STATO_SANZIONE_COMUNICATA == theModel.getAppDatasanzione().getIdStatoSanzione())
				&& GenericUtil.checkValidRole(utente,
						Arrays.asList(Constants.RUOLO_VALIDATORE, Constants.RUOLO_SUPER, Constants.RUOLO_ISPETTORE),
						false, true));
	}

	public static boolean isSanzioneInStatoBozza(
			it.csi.sigit.sigitwebn.dto.gestisci_sanzioni.CpDettaglioSanzioneModel theModel) {
		return isSanzioneInStato(theModel, Constants.ID_STATO_SANZIONE_BOZZA);
	}

	public static boolean isSanzioneInStatoNotificata(
			it.csi.sigit.sigitwebn.dto.gestisci_sanzioni.CpDettaglioSanzioneModel theModel) {
		return isSanzioneInStato(theModel, Constants.ID_STATO_SANZIONE_COMUNICATA);
	}

	private static boolean isSanzioneInStato(
			it.csi.sigit.sigitwebn.dto.gestisci_sanzioni.CpDettaglioSanzioneModel theModel, Integer... stati) {

		Sanzione sanzioneCorrente = theModel.getAppDatasanzione();
		if (sanzioneCorrente == null) {
			return false;
		}

		if (stati == null || stati.length == 0) {
			return false;
		}

		for (Integer stato : stati) {
			if (stato.equals(sanzioneCorrente.getIdStatoSanzione())) {
				return true;
			}
		}

		return false;
	}

	/*PROTECTED REGION END*/
}
