package it.csi.sigit.sigitwebn.business.gestisci_accertamento;

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

/*PROTECTED REGION ID(R2118934711) ENABLED START*/
import it.csi.sigit.sigitwebn.business.manager.SigitMgr;
import it.csi.sigit.sigitwebn.business.manager.ValidationMgr;
import it.csi.sigit.sigitwebn.business.manager.DbMgr;
import it.csi.sigit.sigitwebn.business.manager.db.DbAzioneMgr;
import it.csi.sigit.sigitwebn.business.manager.util.ManagerException;
import it.csi.sigit.sigitwebn.business.manager.util.Message;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.SigitTDocAzioneDto;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.SigitTImpiantoDto;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.SigitTIspezione2018Dto;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.SigitVRicercaImpiantiDto;

/*PROTECTED REGION END*/

public class CPBECpDettaglioAccertamento {

	/**  */
	protected static final Logger log = //NOSONAR  Reason:EIAS 
			Logger.getLogger(Constants.APPLICATION_CODE + ".business"); //NOSONAR  Reason:EIAS

	//////////////////////////////////////////////////////////////////////////////
	/// Costanti identificative degli Application Data
	//////////////////////////////////////////////////////////////////////////////

	// ApplicationData: [utenteLoggato, scope:USER_SESSION]
	public static final String APPDATA_UTENTELOGGATO_CODE = "appDatautenteLoggato";

	// ApplicationData: [accertamento, scope:USER_SESSION]
	public static final String APPDATA_ACCERTAMENTO_CODE = "appDataaccertamento";

	// ApplicationData: [elencoTipoAnomalie, scope:USER_SESSION]
	public static final String APPDATA_ELENCOTIPOANOMALIE_CODE = "appDataelencoTipoAnomalie";

	// ApplicationData: [elencoAzioni, scope:USER_SESSION]
	public static final String APPDATA_ELENCOAZIONI_CODE = "appDataelencoAzioni";

	// ApplicationData: [sveglia, scope:USER_SESSION]
	public static final String APPDATA_SVEGLIA_CODE = "appDatasveglia";

	// ApplicationData: [idTipoAzione, scope:USER_SESSION]
	public static final String APPDATA_IDTIPOAZIONE_CODE = "appDataidTipoAzione";

	// ApplicationData: [idAzioneSelezionata, scope:USER_SESSION]
	public static final String APPDATA_IDAZIONESELEZIONATA_CODE = "appDataidAzioneSelezionata";

	// ApplicationData: [verifica, scope:USER_SESSION]
	public static final String APPDATA_VERIFICA_CODE = "appDataverifica";

	// ApplicationData: [idVerificaSelezionata, scope:USER_SESSION]
	public static final String APPDATA_IDVERIFICASELEZIONATA_CODE = "appDataidVerificaSelezionata";

	// ApplicationData: [messaggioDinamico, scope:USER_SESSION]
	public static final String APPDATA_MESSAGGIODINAMICO_CODE = "appDatamessaggioDinamico";

	// ApplicationData: [idAccertamentoSelezionato, scope:USER_SESSION]
	public static final String APPDATA_IDACCERTAMENTOSELEZIONATO_CODE = "appDataidAccertamentoSelezionato";

	// ApplicationData: [elencoStatoAccertamento, scope:USER_SESSION]
	public static final String APPDATA_ELENCOSTATOACCERTAMENTO_CODE = "appDataelencoStatoAccertamento";

	// ApplicationData: [elencoIspezioniAccertamento, scope:USER_SESSION]
	public static final String APPDATA_ELENCOISPEZIONIACCERTAMENTO_CODE = "appDataelencoIspezioniAccertamento";

	// ApplicationData: [idIspezioneSelezionato, scope:USER_SESSION]
	public static final String APPDATA_IDISPEZIONESELEZIONATO_CODE = "appDataidIspezioneSelezionato";

	// ApplicationData: [idSanzioneSelezionata, scope:USER_SESSION]
	public static final String APPDATA_IDSANZIONESELEZIONATA_CODE = "appDataidSanzioneSelezionata";

	// ApplicationData: [elencoTipoConclusione, scope:USER_SESSION]
	public static final String APPDATA_ELENCOTIPOCONCLUSIONE_CODE = "appDataelencoTipoConclusione";

	// ApplicationData: [elencoStatiIspezione, scope:USER_SESSION]
	public static final String APPDATA_ELENCOSTATIISPEZIONE_CODE = "appDataelencoStatiIspezione";

	// ApplicationData: [elencoStatiSanzione, scope:USER_SESSION]
	public static final String APPDATA_ELENCOSTATISANZIONE_CODE = "appDataelencoStatiSanzione";

	// ApplicationData: [paginaChiamante, scope:USER_SESSION]
	public static final String APPDATA_PAGINACHIAMANTE_CODE = "appDatapaginaChiamante";

	// ApplicationData: [Ispezione2018, scope:USER_SESSION]
	public static final String APPDATA_ISPEZIONE2018_CODE = "appDataIspezione2018";

	// ApplicationData: [datiInserimentoSanzione, scope:USER_SESSION]
	public static final String APPDATA_DATIINSERIMENTOSANZIONE_CODE = "appDatadatiInserimentoSanzione";

	// ApplicationData: [paginaChiamanteDettaglioSanzione, scope:USER_SESSION]
	public static final String APPDATA_PAGINACHIAMANTEDETTAGLIOSANZIONE_CODE = "appDatapaginaChiamanteDettaglioSanzione";

	// ApplicationData: [elencoSanzioni, scope:USER_SESSION]
	public static final String APPDATA_ELENCOSANZIONI_CODE = "appDataelencoSanzioni";

	//////////////////////////////////////////////////////////////////////////////
	/// Metodi associati alla U.I.
	//////////////////////////////////////////////////////////////////////////////

	// nome del content panel associato al bean
	public static final String CPNAME = "cpDettaglioAccertamento";

	/** 
	 * Restituisce il tab correntemente visibile in un determinato tab set
	 */
	private String getCurrentTab(Map session, String tabSetName) {
		String value = (String) session.get(CPNAME + "_" + tabSetName + "_selectedMultiPanel");
		return value;
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo salvaDettaglioAccertamento definito in un ExecCommand del
	 * ContentPanel cpDettaglioAccertamento
	 */
	public ExecResults salvaDettaglioAccertamento(

			it.csi.sigit.sigitwebn.dto.gestisci_accertamento.CpDettaglioAccertamentoModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String SALVADETTAGLIOACCERTAMENTO_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String SALVADETTAGLIOACCERTAMENTO_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R1523294124) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:
			try {
				getValidationMgr().validazioneFormaleAccertamento(theModel.getAppDataaccertamento());

				Map<String, String> mappaTipoAnomalieVerifica = ConvertUtil
						.convertCodeDescriptionsInMap(theModel.getAppDataelencoTipoAnomalie());

				//salvataggio del dato note
				getSigitMgr().salvaAccertamento(theModel.getAppDataaccertamento(), mappaTipoAnomalieVerifica,
						theModel.getAppDatautenteLoggato());

				caricaAzioni(theModel);

				result.getGlobalMessages().add(Messages.INFO_INSERIMENTO_CORRETTO);
				result.setResultCode(SALVADETTAGLIOACCERTAMENTO_OUTCOME_CODE__OK);
			} catch (ManagerException ex) {
				Validator.gestisciEccezione(result, ex);
			}
			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::salvaDettaglioAccertamento] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo preparaAperturaNuovaIspezione definito in un ExecCommand del
	 * ContentPanel cpDettaglioAccertamento
	 */
	public ExecResults preparaAperturaNuovaIspezione(

			it.csi.sigit.sigitwebn.dto.gestisci_accertamento.CpDettaglioAccertamentoModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String PREPARAAPERTURANUOVAISPEZIONE_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-1563148352) ENABLED START*/
			//inizializzazione dell'ispezione a partire dall'accertamento
			Ispezione2018 nuovaIspezione = new Ispezione2018();
			nuovaIspezione.setIdVerifica(Constants.DATO_NON_DISPONIBILE_S);
			nuovaIspezione.setIdAccertamento(ReplaceSpecialCharUtils.sanitize(theModel.getAppDataidAccertamentoSelezionato()));
			nuovaIspezione.setIdentificativoIspezione(null);
			nuovaIspezione.setCodiceImpianto(ReplaceSpecialCharUtils.sanitize(theModel.getAppDataaccertamento().getCodiceImpianto()));

			if (GenericUtil.isNotNullOrEmpty(theModel.getAppDataaccertamento().getCodiceImpianto())) {
				Impianto imp = getDbMgr().cercaImpiantoById(theModel.getAppDataaccertamento().getCodiceImpianto());
				nuovaIspezione.setCodIstatProv(ReplaceSpecialCharUtils.sanitize(GenericUtil.getCodIstatProvByCodIstatComune(imp.getImpLocIdComune())));
				nuovaIspezione.setCodIstatCom(ReplaceSpecialCharUtils.sanitize(imp.getImpLocIdComune()));
			}

			nuovaIspezione.setLocalizzazioneImpianto(ReplaceSpecialCharUtils.sanitize(theModel.getAppDataaccertamento().getIndirizzoImpianto()));
			nuovaIspezione.setDataCreazione(DateUtil.getDataCorrenteFormat());
			nuovaIspezione.setIdStatoIspezione(ConvertUtil.convertToString(Constants.ID_STATO_ISPEZIONE_BOZZA));
			nuovaIspezione.setDescrizioneStato(Constants.STATO_MODULO_BOZZA);
			theModel.setAppDataIspezione2018(nuovaIspezione);

			//			theModel.setAppDataProvenienzaDettaglioIspezione2018("ACCERTAMENTO");
			theModel.setAppDatapaginaChiamante(Constants.PAG_ELENCO_ACCERTAMENTI);

			result.setResultCode(PREPARAAPERTURANUOVAISPEZIONE_OUTCOME_CODE__OK);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::preparaAperturaNuovaIspezione] Errore occorso nell'esecuzione del metodo:" + e,
					e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo visualizzaIspezione definito in un ExecCommand del
	 * ContentPanel cpDettaglioAccertamento
	 */
	public ExecResults visualizzaIspezione(

			it.csi.sigit.sigitwebn.dto.gestisci_accertamento.CpDettaglioAccertamentoModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String VISUALIZZAISPEZIONE_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String VISUALIZZAISPEZIONE_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R1068070484) ENABLED START*/

			try {

				getValidationMgr().checkSelezioneElemento(
						ConvertUtil.convertToString(theModel.getAppDataidIspezioneSelezionato()));

				Ispezione2018 ispezioneEsistente = new Ispezione2018();

				// Quando entrero' nel dettaglio ispezione verra' caricato l'oggetto completo
				ispezioneEsistente.setIdentificativoIspezione(
						ConvertUtil.convertToString(theModel.getAppDataidIspezioneSelezionato()));

				/*
				Ispezione2018 ispezioneEsistente = getSigitMgr().caricaIspezioneDaId(ConvertUtil.convertToString(theModel.getAppDataidIspezioneSelezionato()), 
						true, false);
				*/
				/*
				Ispezione2018 ispezioneEsistente = new Ispezione2018();
				ispezioneEsistente.setIdAccertamento(theModel.getAppDataidAccertamentoSelezionato());
				ispezioneEsistente.setIdVerifica("0");
				ispezioneEsistente.setIdentificativoIspezione(
				ConvertUtil.convertToString(theModel.getAppDataidIspezioneSelezionato()));
				ispezioneEsistente.setCodiceImpianto(theModel.getAppDataaccertamento().getCodiceImpianto());
				
				if (GenericUtil.isNotNullOrEmpty(theModel.getAppDataverifica().getCodiceImpianto())) {
				Impianto imp = getDbMgr().cercaImpiantoById(theModel.getAppDataverifica().getCodiceImpianto());
				ispezioneEsistente
				.setCodIstatProv(GenericUtil.getCodIstatProvByCodIstatComune(imp.getImpLocIdComune()));
				}
				
				ispezioneEsistente.setLocalizzazioneImpianto(theModel.getAppDataaccertamento().getIndirizzoImpianto());
				 */

				theModel.setAppDataIspezione2018(ispezioneEsistente);

				//			theModel.setAppDataProvenienzaDettaglioIspezione2018("ACCERTAMENTO");
				theModel.setAppDatapaginaChiamante(Constants.PAG_ELENCO_ACCERTAMENTI);

				// impostazione del result code 
				result.setResultCode(VISUALIZZAISPEZIONE_OUTCOME_CODE__OK);
			} catch (ManagerException ex) {
				Validator.gestisciEccezione(result, ex);
			}

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
	 * Implementazione del metodo avviaSanzione definito in un ExecCommand del
	 * ContentPanel cpDettaglioAccertamento
	 */
	public ExecResults avviaSanzione(

			it.csi.sigit.sigitwebn.dto.gestisci_accertamento.CpDettaglioAccertamentoModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String AVVIASANZIONE_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String AVVIASANZIONE_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-1749459548) ENABLED START*/

			//viene preparata la nuova sanzione
			DatiInserimentoSanzione nuovaSanzione = new DatiInserimentoSanzione();
			nuovaSanzione.setAccertamentoAssociato(ReplaceSpecialCharUtils.sanitize(theModel.getAppDataidAccertamentoSelezionato()));
			theModel.setAppDatadatiInserimentoSanzione(nuovaSanzione);
 
			// impostazione del result code 
			result.setResultCode(AVVIASANZIONE_OUTCOME_CODE__OK);

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::avviaSanzione] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo visualizzaSanzione definito in un ExecCommand del
	 * ContentPanel cpDettaglioAccertamento
	 */
	public ExecResults visualizzaSanzione(

			it.csi.sigit.sigitwebn.dto.gestisci_accertamento.CpDettaglioAccertamentoModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String VISUALIZZASANZIONE_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String VISUALIZZASANZIONE_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R1718442005) ENABLED START*/

			try {

				getValidationMgr().checkSelezioneElemento(
						ConvertUtil.convertToString(theModel.getAppDataidSanzioneSelezionata()));

				theModel.setAppDatapaginaChiamanteDettaglioSanzione("ACCERTAMENTO");

				//viene inizializzato l'oggetto che verra' caricato nel content panel successivo
				DatiInserimentoSanzione sanzioneEsistente = new DatiInserimentoSanzione();
				sanzioneEsistente.setIdSanzione(theModel.getAppDataidSanzioneSelezionata());
				theModel.setAppDatadatiInserimentoSanzione(sanzioneEsistente);

				result.setResultCode(VISUALIZZASANZIONE_OUTCOME_CODE__OK);

			} catch (ManagerException ex) {

				Validator.gestisciEccezione(result, ex);
			}

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::visualizzaSanzione] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo downloadFile definito in un ExecCommand del
	 * ContentPanel cpDettaglioAccertamento
	 */
	public ExecResults downloadFile(

			it.csi.sigit.sigitwebn.dto.gestisci_accertamento.CpDettaglioAccertamentoModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String DOWNLOADFILE_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String DOWNLOADFILE_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R355527040) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

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
	 * ContentPanel cpDettaglioAccertamento
	 */
	public ExecResults inserisciAzione(

			it.csi.sigit.sigitwebn.dto.gestisci_accertamento.CpDettaglioAccertamentoModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String INSERISCIAZIONE_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String INSERISCIAZIONE_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R567527027) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:
			theModel.setAppDataidTipoAzione(Constants.ID_TIPO_AZIONE_ACCERTAMENTO);
			theModel.setAppDataidAzioneSelezionata(null);
			result.setResultCode(INSERISCIAZIONE_OUTCOME_CODE__OK);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

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
	 * ContentPanel cpDettaglioAccertamento
	 */
	public ExecResults impostaNuovaSveglia(

			it.csi.sigit.sigitwebn.dto.gestisci_accertamento.CpDettaglioAccertamentoModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String IMPOSTANUOVASVEGLIA_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R1839133419) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			theModel.setAppDataidAzioneSelezionata(theModel.getAppDataidAccertamentoSelezionato());
			theModel.setAppDataidTipoAzione(Constants.ID_TIPO_AZIONE_ACCERTAMENTO);

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
	 * Implementazione del metodo visualizzaVerifica definito in un ExecCommand del
	 * ContentPanel cpDettaglioAccertamento
	 */
	public ExecResults visualizzaVerifica(

			it.csi.sigit.sigitwebn.dto.gestisci_accertamento.CpDettaglioAccertamentoModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String VISUALIZZAVERIFICA_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-224198523) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			theModel.setAppDataidVerificaSelezionata(theModel.getAppDataaccertamento().getIdVerifica());

			// impostazione del result code 
			result.setResultCode(VISUALIZZAVERIFICA_OUTCOME_CODE__OK);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::visualizzaVerifica] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo concludiAccertamento definito in un ExecCommand del
	 * ContentPanel cpDettaglioAccertamento
	 */
	public ExecResults concludiAccertamento(

			it.csi.sigit.sigitwebn.dto.gestisci_accertamento.CpDettaglioAccertamentoModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String CONCLUDIACCERTAMENTO_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String CONCLUDIACCERTAMENTO_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R393356383) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			try {

				// RECUPERO NUOVAMENTE L'ACCERTAMENTO - cos� sono sicuro che abbia salvato il tipo anomalia
				Accertamento accertamento = getSigitMgr().getAccertamentoDaId(
						theModel.getAppDataidAccertamentoSelezionato(),
						ConvertUtil.convertIdDescriptionsInMap(theModel.getAppDataelencoStatoAccertamento()),
						ConvertUtil.convertIdDescriptionsInMap(theModel.getAppDataelencoTipoConclusione()));

				//CONTROLLO SULLA PRESENZA DI OGGETTI COLLEGATI ALLA VERIFICA
				getValidationMgr().validazioneConcludiAccertamento(accertamento);

				Map<String, String> mappaTipoAnomalieVerifica = ConvertUtil
						.convertCodeDescriptionsInMap(theModel.getAppDataelencoTipoAnomalie());
				if (mappaTipoAnomalieVerifica != null) {
					accertamento.setDescTipoAnomalia(mappaTipoAnomalieVerifica.get(ReplaceSpecialCharUtils.sanitize(accertamento.getIdTipoAnomalia())));
				}

				//accertamento = theModel.getAppDataaccertamento();
				accertamento.setIdTipoConferma(Constants.ID_TIPO_CONFERMA_CONCLUDI);
				theModel.setAppDataaccertamento(accertamento);

				result.setResultCode(CONCLUDIACCERTAMENTO_OUTCOME_CODE__OK);
			} catch (ManagerException ex) {

				Validator.gestisciEccezione(result, ex);
			}

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::concludiAccertamento] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo gestisciAnnullaAccertamento definito in un ExecCommand del
	 * ContentPanel cpDettaglioAccertamento
	 */
	public ExecResults gestisciAnnullaAccertamento(

			it.csi.sigit.sigitwebn.dto.gestisci_accertamento.CpDettaglioAccertamentoModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GESTISCIANNULLAACCERTAMENTO_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String GESTISCIANNULLAACCERTAMENTO_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-2076618336) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			try {
				//CONTROLLO SULLA PRESENZA DI OGGETTI COLLEGATI ALLA VERIFICA
				getValidationMgr().validazioneAnnullaAccertamento(theModel.getAppDataaccertamento());

				Message msg = new Message(Messages.C008_2, theModel.getAppDataidAccertamentoSelezionato());
				theModel.setAppDatamessaggioDinamico(msg.getText());

				result.setResultCode(GESTISCIANNULLAACCERTAMENTO_OUTCOME_CODE__OK);
			} catch (ManagerException ex) {

				Validator.gestisciEccezione(result, ex);
			}

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::gestisciAnnullaAccertamento] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo sbloccaAccertamento definito in un ExecCommand del
	 * ContentPanel cpDettaglioAccertamento
	 */
	public ExecResults sbloccaAccertamento(

			it.csi.sigit.sigitwebn.dto.gestisci_accertamento.CpDettaglioAccertamentoModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String SBLOCCAACCERTAMENTO_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String SBLOCCAACCERTAMENTO_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-213425041) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			try {
				UtenteLoggato utente = theModel.getAppDatautenteLoggato();

				//CONTROLLO LESISTENZA DEL COD IMPIANTO E SEQUESTO E' BLOCCATO
				getValidationMgr().validazioneSbloccaNomina3R(theModel.getAppDataaccertamento());

				getSigitMgr().sbloccaNomina3R(theModel.getAppDataaccertamento().getIdentificativo(),
						theModel.getAppDataaccertamento().getCodiceImpianto(), utente);

				caricaAzioni(theModel);

				/*
				// Rileggo le azioni
				Azione azioneFiltro = new Azione();
				azioneFiltro.setFkAzione(
						ConvertUtil.convertToInteger(theModel.getAppDataaccertamento().getIdentificativo()));
				
				theModel.setAppDataelencoAzioni((ArrayList<Azione>) getSigitMgr()
						.cercaAzioniByFiltro(Constants.ID_TIPO_AZIONE_ACCERTAMENTO, azioneFiltro, true));
				*/

				result.getGlobalMessages().add(Messages.MSG_AGGIORNAMENTO_CORRETTO);

				result.setResultCode(SBLOCCAACCERTAMENTO_OUTCOME_CODE__OK);
			} catch (ManagerException ex) {

				Validator.gestisciEccezione(result, ex);
			}

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::sbloccaAccertamento] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo associaAccertamento definito in un ExecCommand del
	 * ContentPanel cpDettaglioAccertamento
	 */
	public ExecResults associaAccertamento(

			it.csi.sigit.sigitwebn.dto.gestisci_accertamento.CpDettaglioAccertamentoModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String ASSOCIAACCERTAMENTO_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String ASSOCIAACCERTAMENTO_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-1474499855) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			Accertamento accertamento = theModel.getAppDataaccertamento();
			accertamento.setIdTipoConferma(Constants.ID_TIPO_CONFERMA_ASSOCIA);

			theModel.setAppDataaccertamento(accertamento);
			// impostazione del result code 
			result.setResultCode(ASSOCIAACCERTAMENTO_OUTCOME_CODE__OK);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::associaAccertamento] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo associaCodiceImpianto definito in un ExecCommand del
	 * ContentPanel cpDettaglioAccertamento
	 */
	public ExecResults associaCodiceImpianto(

			it.csi.sigit.sigitwebn.dto.gestisci_accertamento.CpDettaglioAccertamentoModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String ASSOCIACODICEIMPIANTO_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String ASSOCIACODICEIMPIANTO_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-2089658609) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			Accertamento accertamento = theModel.getAppDataaccertamento();
			accertamento.setIdTipoConferma(Constants.ID_TIPO_CONFERMA_ASSOCIA_IMP);

			log.debug("Ho premuto associaCodiceImpianto!!!");

			theModel.setAppDataaccertamento(accertamento);

			// impostazione del result code 
			result.setResultCode(ASSOCIACODICEIMPIANTO_OUTCOME_CODE__OK);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::associaCodiceImpianto] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo gestisciIndietro definito in un ExecCommand del
	 * ContentPanel cpDettaglioAccertamento
	 */
	public ExecResults gestisciIndietro(

			it.csi.sigit.sigitwebn.dto.gestisci_accertamento.CpDettaglioAccertamentoModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GESTISCIINDIETRO_OUTCOME_CODE__RICERCA_ACCERTAMENTI = //NOSONAR  Reason:EIAS
				"RICERCA_ACCERTAMENTI"; //NOSONAR  Reason:EIAS
		final String GESTISCIINDIETRO_OUTCOME_CODE__ELENCO_SVEGLIE = //NOSONAR  Reason:EIAS
				"ELENCO_SVEGLIE"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R873612607) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			String paginaChiamante = theModel.getAppDatapaginaChiamante();

			if (Constants.PAG_ELENCO_SVEGLIE.equals(paginaChiamante)) {
				result.setResultCode(GESTISCIINDIETRO_OUTCOME_CODE__ELENCO_SVEGLIE);
			} else {
				result.setResultCode(GESTISCIINDIETRO_OUTCOME_CODE__RICERCA_ACCERTAMENTI);
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
	 * Implementazione del metodo annullaAccertamento definito in un ExecCommand del
	 * ContentPanel cpDettaglioAccertamento
	 */
	public ExecResults annullaAccertamento(

			it.csi.sigit.sigitwebn.dto.gestisci_accertamento.CpDettaglioAccertamentoModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String ANNULLAACCERTAMENTO_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String ANNULLAACCERTAMENTO_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R1842198321) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			getSigitMgr().annullaAccertamento(theModel.getAppDataaccertamento().getIdentificativo(),
					theModel.getAppDatautenteLoggato());

			//VIENE RICARICATA LA VERIFICA A PARTIRE DALL'ID
			Accertamento accertamento = getSigitMgr().getAccertamentoDaId(
					theModel.getAppDataaccertamento().getIdentificativo(),
					ConvertUtil.convertIdDescriptionsInMap(theModel.getAppDataelencoStatoAccertamento()),
					ConvertUtil.convertIdDescriptionsInMap(theModel.getAppDataelencoTipoConclusione()));

			theModel.setAppDataaccertamento(accertamento);

			UtenteLoggato utente = theModel.getAppDatautenteLoggato();

			theModel.getSession().put(Constants.SESSIONE_VAR_MESSAGGE,
					new Message(Messages.INFO_ANNULLAMENTO_ACCERTAMENTO_CORRETTO,
							utente.getDenominazione() + " (" + utente.getCodiceFiscale() + ")"));

			/*
			result.getGlobalMessages().add(new Message(Messages.INFO_ANNULLAMENTO_ACCERTAMENTO_CORRETTO,
					utente.getDenominazione() + " (" + utente.getCodiceFiscale() + ")").getText());
			*/

			// impostazione del result code 
			result.setResultCode(ANNULLAACCERTAMENTO_OUTCOME_CODE__OK);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::annullaAccertamento] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo isRuoloAbilitato definito in un ExecCommand del
	 * ContentPanel cpDettaglioAccertamento
	 */
	public ExecResults isRuoloAbilitato(

			it.csi.sigit.sigitwebn.dto.gestisci_accertamento.CpDettaglioAccertamentoModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String ISRUOLOABILITATO_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R233467804) ENABLED START*/
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
	 * Implementazione del metodo gestisciAbilitazione definito in un ExecCommand del
	 * ContentPanel cpDettaglioAccertamento
	 */
	public ExecResults gestisciAbilitazione(

			it.csi.sigit.sigitwebn.dto.gestisci_accertamento.CpDettaglioAccertamentoModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GESTISCIABILITAZIONE_OUTCOME_CODE__DISABILITA = //NOSONAR  Reason:EIAS
				"DISABILITA"; //NOSONAR  Reason:EIAS
		final String GESTISCIABILITAZIONE_OUTCOME_CODE__ABILITA = //NOSONAR  Reason:EIAS
				"ABILITA"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-981209680) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			UtenteLoggato utente = theModel.getAppDatautenteLoggato();

			// impostazione del result code 
			// se il ruolo utente non appartiene a questo set, il form � in editing
			if (GenericUtil.checkValidRole(utente, Arrays.asList(Constants.RUOLO_SUPER, Constants.RUOLO_VALIDATORE),
					false, true)) {
				result.setResultCode(GESTISCIABILITAZIONE_OUTCOME_CODE__ABILITA);
			} else {
				result.setResultCode(GESTISCIABILITAZIONE_OUTCOME_CODE__DISABILITA);
			}

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::gestisciAbilitazione] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo caricaDettaglioAccertamento definito in un ExecCommand del
	 * ContentPanel cpDettaglioAccertamento
	 */
	public ExecResults caricaDettaglioAccertamento(

			it.csi.sigit.sigitwebn.dto.gestisci_accertamento.CpDettaglioAccertamentoModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String CARICADETTAGLIOACCERTAMENTO_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String CARICADETTAGLIOACCERTAMENTO_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R358249638) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			try {

				GenericUtil.gestisciMessaggioSessione(theModel, result);

				if (theModel.getAppDataelencoTipoAnomalie() == null) {
					theModel.setAppDataelencoTipoAnomalie(getSigitMgr().getElencoTipoAnomalie());
				}

				if (theModel.getAppDataelencoStatoAccertamento() == null) {
					theModel.setAppDataelencoStatoAccertamento(getSigitMgr().getElencoStatoAccertamento());
				}

				if (theModel.getAppDataelencoTipoConclusione() == null) {
					theModel.setAppDataelencoTipoConclusione(getSigitMgr().getElencoTipoConclusioni());
				}

				//VIENE CARICATA LA VERIFICA A PARTIRE DALL'ID
				Accertamento accertamento = getSigitMgr().getAccertamentoDaId(
						theModel.getAppDataidAccertamentoSelezionato(),
						ConvertUtil.convertIdDescriptionsInMap(theModel.getAppDataelencoStatoAccertamento()),
						ConvertUtil.convertIdDescriptionsInMap(theModel.getAppDataelencoTipoConclusione()));

				theModel.setAppDataaccertamento(accertamento);
				List<SigitTImpiantoDto> impainti = getDbMgr().getSigitTImpiantoDao()
						.findByAccertamentoIstatComune(accertamento.getCodIstatCom());
				if (impainti != null && impainti.size() != 0) {
					theModel.getAppDataaccertamento().setDenomComune(impainti.get(0).getDenominazioneComune());
				}
				caricaAzioni(theModel);

				/*
				//viene ricercata la lista delle azioni collegate alla verifica
				Azione azioneFiltro = new Azione();
				azioneFiltro.setFkAzione(ConvertUtil.convertToInteger(accertamento.getIdentificativo()));
				
				theModel.setAppDataelencoAzioni((ArrayList<Azione>) getSigitMgr()
						.cercaAzioniByFiltro(Constants.ID_TIPO_AZIONE_ACCERTAMENTO, azioneFiltro, true));
				*/

				if (theModel.getAppDataelencoStatiIspezione() == null) {
					theModel.setAppDataelencoStatiIspezione(getSigitMgr().getElencoStatiISpezione());
				}

				if (theModel.getAppDataelencoStatiSanzione() == null) {
					theModel.setAppDataelencoStatiSanzione(getSigitMgr().getElencoStatiSanzione());
				}

				theModel.setAppDataelencoIspezioniAccertamento(
						getSigitMgr().getIspezioniByIdAccertamento(accertamento.getIdentificativo(),
								ConvertUtil.convertIdDescriptionsInMap(theModel.getAppDataelencoStatiIspezione())));

				theModel.setAppDataelencoSanzioni(
						getSigitMgr().getSanzioniByIdAccertamento(accertamento.getIdentificativo(),
								ConvertUtil.convertIdDescriptionsInMap(theModel.getAppDataelencoStatiSanzione())));
				//				theModel.setAppDataelencoSanzioniAccertamento(
				//						getSigitMgr().getSanzioniByIdAccertamento(accertamento.getIdentificativo(),
				//								ConvertUtil.convertIdDescriptionsInMap(theModel.getAppDataelencoStatiSanzione())));

				result.setResultCode(CARICADETTAGLIOACCERTAMENTO_OUTCOME_CODE__OK);
			} catch (ManagerException ex) {
				Validator.gestisciEccezione(result, ex);
			}

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::caricaDettaglioAccertamento] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo aggiornaDatiPagina definito in un ExecCommand del
	 * ContentPanel cpDettaglioAccertamento
	 */
	public ExecResults aggiornaDatiPagina(

			it.csi.sigit.sigitwebn.dto.gestisci_accertamento.CpDettaglioAccertamentoModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String AGGIORNADATIPAGINA_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R1391091214) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			GenericUtil.gestisciMessaggioSessione(theModel, result);

			/*
			Message msg = (Message) theModel.getSession().get(Constants.SESSIONE_VAR_MESSAGGE);
			if (msg != null) {
				if (msg.getType() == Message.ERROR)
					result.getGlobalErrors().add(msg.getText());
				else
					result.getGlobalMessages().add(msg.getText());
			
				theModel.getSession().remove(Constants.SESSIONE_VAR_MESSAGGE);
			}
			*/

			// impostazione del result code 
			result.setResultCode(AGGIORNADATIPAGINA_OUTCOME_CODE__OK);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::aggiornaDatiPagina] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	//////////////////////////////////////////////////////////////////////////////
	/// Metodi statici per il reset delle tabelle
	//////////////////////////////////////////////////////////////////////////////

	/**
	 * permette di resettare lo stato di paginazione della tabella widg_tbIspezioni
	 */
	public static void resetClearStatus_widg_tbIspezioni(java.util.Map session) {
		session.put("cpDettaglioAccertamento_tbIspezioni_clearStatus", Boolean.TRUE);
	}

	/**
	 * permette di resettare lo stato di paginazione della tabella widg_tbSanzioni
	 */
	public static void resetClearStatus_widg_tbSanzioni(java.util.Map session) {
		session.put("cpDettaglioAccertamento_tbSanzioni_clearStatus", Boolean.TRUE);
	}

	/**
	 * permette di resettare lo stato di paginazione della tabella widg_tbAzioni
	 */
	public static void resetClearStatus_widg_tbAzioni(java.util.Map session) {
		session.put("cpDettaglioAccertamento_tbAzioni_clearStatus", Boolean.TRUE);
	}

	//////////////////////////////////////////////////////////////////////////////
	/// Property aggiuntive del bean
	//////////////////////////////////////////////////////////////////////////////
	/*PROTECTED REGION ID(R1954440983) ENABLED START*/
	//// inserire qui le property che si vogliono iniettare in questo bean (es. dao, proxy di pd, ...) 

	private SigitMgr sigitMgr;

	public SigitMgr getSigitMgr() {
		return sigitMgr;
	}

	public void setSigitMgr(SigitMgr sigitMgr) {
		this.sigitMgr = sigitMgr;
	}

	private DbAzioneMgr dbAzioneMgr;

	public DbAzioneMgr getDbAzioneMgr() {
		return dbAzioneMgr;
	}

	public void setDbAzioneMgr(DbAzioneMgr dbAzioneMgr) {
		this.dbAzioneMgr = dbAzioneMgr;
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

	public static boolean isAssociaImpiantoAbilitato(
			it.csi.sigit.sigitwebn.dto.gestisci_accertamento.CpDettaglioAccertamentoModel theModel) {
		return isUtenteAbilitatoAssociaImp(theModel.getAppDatautenteLoggato())
				&& theModel.getAppDataaccertamento() != null
				&& theModel.getAppDataaccertamento().getIdentificativo() != null
				&& theModel.getAppDataaccertamento().getCodiceImpianto() == null && theModel.getAppDataaccertamento()
						.getIdStatoAccertamento() == Constants.ID_STATO_ACCERTAMENTO_IN_CORSO;
	}

	private void caricaAzioni(it.csi.sigit.sigitwebn.dto.gestisci_accertamento.CpDettaglioAccertamentoModel theModel)
			throws ManagerException {

		// Rileggo le azioni
		Azione azioneFiltro = new Azione();
		azioneFiltro.setFkAzione(ConvertUtil.convertToInteger(theModel.getAppDataaccertamento().getIdentificativo()));

		theModel.setAppDataelencoAzioni((ArrayList<Azione>) getSigitMgr()
				.cercaAzioniByFiltro(Constants.ID_TIPO_AZIONE_ACCERTAMENTO, azioneFiltro, true));

	}

	public static boolean isIspezioneAvviabile(
			it.csi.sigit.sigitwebn.dto.gestisci_accertamento.CpDettaglioAccertamentoModel theModel) {
		List<IspezioneAccertamento> ispezioni = theModel.getAppDataelencoIspezioniAccertamento();
		Accertamento accertamento = theModel.getAppDataaccertamento();
		if (accertamento != null && accertamento.getIdentificativo() != null
				&& accertamento.getIdStatoAccertamento() == Constants.ID_STATO_ACCERTAMENTO_IN_CORSO) {

			if (ispezioni == null || ispezioni.isEmpty()) {
				return true;
			}

			for (IspezioneAccertamento ispezione : ispezioni) {
				if ("BOZZA".equalsIgnoreCase(ispezione.getDescStatoIspezione())) {
					return false;
				}
			}

			return true;
		} else {
			return false;
		}

	}

	public static boolean isUtenteAbilitatoAssociaImp(UtenteLoggato utenteLoggato) {

		log.debug("GenericUtil.isUtenteAbilitatoAssociaImp? : " + utenteLoggato.getCodiceFiscale());

		String descrizioneRuolo = utenteLoggato.getRuolo().getDescRuolo();

		if (descrizioneRuolo.equals(Constants.RUOLO_VALIDATORE) || descrizioneRuolo.equals(Constants.RUOLO_SUPER)) {

			log.debug("GenericUtil.isUtenteAbilitatoRapProva? - POSSO");
			return true;
		} else {

			log.debug("GenericUtil.isUtenteAbilitatoRapProva? - NON POSSO");
			return false;
		}
	}

	public static boolean isCampoAccertamentoEditabile(
			it.csi.sigit.sigitwebn.dto.gestisci_accertamento.CpDettaglioAccertamentoModel theModel) {

		if (theModel.getAppDataaccertamento() != null
				&& theModel.getAppDataaccertamento().getIdStatoAccertamento() != null
				&& Constants.ID_STATO_ACCERTAMENTO_IN_CORSO != theModel.getAppDataaccertamento()
						.getIdStatoAccertamento()) {
			//se l'accertamento esiste ed ha uno stato diverso da IN CORSO, i campi, indipendentemente dall'utente loggato, e' disabilitato
			return false;

		} else {
			UtenteLoggato utente = theModel.getAppDatautenteLoggato();

			return GenericUtil.checkValidRole(utente, Arrays.asList(Constants.RUOLO_SUPER, Constants.RUOLO_VALIDATORE),
					false, true);
		}

	}

	public static boolean isUtenteAbilitatoSalvaAccertamento(
			it.csi.sigit.sigitwebn.dto.gestisci_accertamento.CpDettaglioAccertamentoModel theModel) {

		if (theModel.getAppDataaccertamento() != null
				&& theModel.getAppDataaccertamento().getIdStatoAccertamento() != null
				&& Constants.ID_STATO_ACCERTAMENTO_IN_CORSO != theModel.getAppDataaccertamento()
						.getIdStatoAccertamento()) {
			//se l'accertamento esiste ed ha uno stato diverso da IN CORSO, il salva, indipendentemente dall'utente loggato, e' disabilitato
			return false;

		} else {
			UtenteLoggato utente = theModel.getAppDatautenteLoggato();

			return GenericUtil.checkValidRole(utente, Arrays.asList(Constants.RUOLO_SUPER, Constants.RUOLO_VALIDATORE),
					false, true);
		}
	}

	/*PROTECTED REGION END*/
}
