package it.csi.sigit.sigitwebn.business.elenco_documenti_impianti;

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

/*PROTECTED REGION ID(R-294979833) ENABLED START*/
import java.io.File;
import java.io.FileReader;

import it.csi.sigit.sigitwebn.business.dao.sigitwebn.filter.ImportDocumentoFilter;
import it.csi.sigit.sigitwebn.business.manager.DbMgr;
import it.csi.sigit.sigitwebn.business.manager.ServiziMgr;
import it.csi.sigit.sigitwebn.business.manager.SigitMgr;
import it.csi.sigit.sigitwebn.business.manager.ValidationMgr;
import it.csi.sigit.sigitwebn.business.manager.util.ManagerException;
import it.csi.sigit.sigitwebn.business.manager.util.Message;
import it.csi.sigit.sigitwebn.business.manager.util.ValidationManagerException;
/*PROTECTED REGION END*/

public class CPBECpElencoDocumentiImpianti {

	/**  */
	protected static final Logger log = //NOSONAR  Reason:EIAS 
			Logger.getLogger(Constants.APPLICATION_CODE + ".business"); //NOSONAR  Reason:EIAS

	//////////////////////////////////////////////////////////////////////////////
	/// Costanti identificative degli Application Data
	//////////////////////////////////////////////////////////////////////////////

	// ApplicationData: [utenteLoggato, scope:USER_SESSION]
	public static final String APPDATA_UTENTELOGGATO_CODE = "appDatautenteLoggato";

	// ApplicationData: [elencoAllegatiPerImpianto, scope:USER_SESSION]
	public static final String APPDATA_ELENCOALLEGATIPERIMPIANTO_CODE = "appDataelencoAllegatiPerImpianto";

	// ApplicationData: [idAllegatoImpiantoSelezionato, scope:USER_SESSION]
	public static final String APPDATA_IDALLEGATOIMPIANTOSELEZIONATO_CODE = "appDataidAllegatoImpiantoSelezionato";

	// ApplicationData: [identificativoImpiantoAllegato, scope:USER_SESSION]
	public static final String APPDATA_IDENTIFICATIVOIMPIANTOALLEGATO_CODE = "appDataidentificativoImpiantoAllegato";

	// ApplicationData: [codiceImpiantoAllegato, scope:USER_SESSION]
	public static final String APPDATA_CODICEIMPIANTOALLEGATO_CODE = "appDatacodiceImpiantoAllegato";

	// ApplicationData: [idImpiantoSelez, scope:USER_SESSION]
	public static final String APPDATA_IDIMPIANTOSELEZ_CODE = "appDataidImpiantoSelez";

	// ApplicationData: [paginaChiamanteImp, scope:USER_SESSION]
	public static final String APPDATA_PAGINACHIAMANTEIMP_CODE = "appDatapaginaChiamanteImp";

	// ApplicationData: [allegato, scope:USER_SESSION]
	public static final String APPDATA_ALLEGATO_CODE = "appDataallegato";

	// ApplicationData: [gestioneAllegatiImpianto, scope:USER_SESSION]
	public static final String APPDATA_GESTIONEALLEGATIIMPIANTO_CODE = "appDatagestioneAllegatiImpianto";

	// ApplicationData: [elencoTipiDocumentoProfilati, scope:USER_SESSION]
	public static final String APPDATA_ELENCOTIPIDOCUMENTOPROFILATI_CODE = "appDataelencoTipiDocumentoProfilati";

	// ApplicationData: [isAbilitazioneDatiAllegato, scope:USER_SESSION]
	public static final String APPDATA_ISABILITAZIONEDATIALLEGATO_CODE = "appDataisAbilitazioneDatiAllegato";

	// ApplicationData: [messaggioDinamico, scope:USER_SESSION]
	public static final String APPDATA_MESSAGGIODINAMICO_CODE = "appDatamessaggioDinamico";

	// ApplicationData: [elencoProvince, scope:USER_SESSION]
	public static final String APPDATA_ELENCOPROVINCE_CODE = "appDataelencoProvince";

	// ApplicationData: [aggiornaElencoAllegati, scope:USER_SESSION]
	public static final String APPDATA_AGGIORNAELENCOALLEGATI_CODE = "appDataaggiornaElencoAllegati";

	// ApplicationData: [elencoApparecchiature, scope:USER_SESSION]
	public static final String APPDATA_ELENCOAPPARECCHIATURE_CODE = "appDataelencoApparecchiature";

	// ApplicationData: [elencoTipiCombustibile, scope:USER_SESSION]
	public static final String APPDATA_ELENCOTIPICOMBUSTIBILE_CODE = "appDataelencoTipiCombustibile";

	// ApplicationData: [dettaglioElencoAllegati, scope:USER_SESSION]
	public static final String APPDATA_DETTAGLIOELENCOALLEGATI_CODE = "appDatadettaglioElencoAllegati";

	// ApplicationData: [paginaChiamanteAllegati, scope:USER_SESSION]
	public static final String APPDATA_PAGINACHIAMANTEALLEGATI_CODE = "appDatapaginaChiamanteAllegati";

	// ApplicationData: [aggiornaElencoDocumenti, scope:USER_SESSION]
	public static final String APPDATA_AGGIORNAELENCODOCUMENTI_CODE = "appDataaggiornaElencoDocumenti";

	// ApplicationData: [documento, scope:USER_SESSION]
	public static final String APPDATA_DOCUMENTO_CODE = "appDatadocumento";

	// ApplicationData: [elencoDocumenti, scope:USER_SESSION]
	public static final String APPDATA_ELENCODOCUMENTI_CODE = "appDataelencoDocumenti";

	// ApplicationData: [elencoTipiDocumentazione, scope:USER_SESSION]
	public static final String APPDATA_ELENCOTIPIDOCUMENTAZIONE_CODE = "appDataelencoTipiDocumentazione";

	// ApplicationData: [idDocumentoSelezionato, scope:USER_SESSION]
	public static final String APPDATA_IDDOCUMENTOSELEZIONATO_CODE = "appDataidDocumentoSelezionato";

	// ApplicationData: [paginaChiamanteDocumenti, scope:USER_SESSION]
	public static final String APPDATA_PAGINACHIAMANTEDOCUMENTI_CODE = "appDatapaginaChiamanteDocumenti";

	// ApplicationData: [identificativoImpianto, scope:USER_SESSION]
	public static final String APPDATA_IDENTIFICATIVOIMPIANTO_CODE = "appDataidentificativoImpianto";

	// ApplicationData: [identificativoIspezione, scope:USER_SESSION]
	public static final String APPDATA_IDENTIFICATIVOISPEZIONE_CODE = "appDataidentificativoIspezione";

	// ApplicationData: [rigaSelezionata, scope:USER_SESSION]
	public static final String APPDATA_RIGASELEZIONATA_CODE = "appDatarigaSelezionata";

	// ApplicationData: [listaLibretti, scope:USER_SESSION]
	public static final String APPDATA_LISTALIBRETTI_CODE = "appDatalistaLibretti";

	// ApplicationData: [elencoAllegatiIsp, scope:USER_SESSION]
	public static final String APPDATA_ELENCOALLEGATIISP_CODE = "appDataelencoAllegatiIsp";

	// ApplicationData: [idAllegatoSelezionato, scope:USER_SESSION]
	public static final String APPDATA_IDALLEGATOSELEZIONATO_CODE = "appDataidAllegatoSelezionato";

	//////////////////////////////////////////////////////////////////////////////
	/// Metodi associati alla U.I.
	//////////////////////////////////////////////////////////////////////////////

	// nome del content panel associato al bean
	public static final String CPNAME = "cpElencoDocumentiImpianti";

	public static final String MULTIPANEL_MPDATIISPEZIONE = "mpDatiIspezione";
	public static final String MPI_MPDATIISPEZIONE_FPDATIISPEZIONE = CPNAME + "_" + MULTIPANEL_MPDATIISPEZIONE + "_"
			+ "fpDatiIspezione";

	public static final String MULTIPANEL_MPDATIDOCUMENTO = "mpDatiDocumento";
	public static final String MPI_MPDATIDOCUMENTO_FPDATIDOCUMENTO = CPNAME + "_" + MULTIPANEL_MPDATIDOCUMENTO + "_"
			+ "fpDatiDocumento";

	public static final String MULTIPANEL_MPELENCOLIBRETTICONS = "mpElencoLibrettiCons";
	public static final String MPI_MPELENCOLIBRETTICONS_FPELENCOLIBRETTICONSOLIDATO = CPNAME + "_"
			+ MULTIPANEL_MPELENCOLIBRETTICONS + "_" + "fpElencoLibrettiConsolidato";

	/** 
	 * Restituisce il tab correntemente visibile in un determinato tab set
	 */
	private String getCurrentTab(Map session, String tabSetName) {
		String value = (String) session.get(CPNAME + "_" + tabSetName + "_selectedMultiPanel");
		return value;
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo visualizzaDocumento definito in un ExecCommand del
	 * ContentPanel cpElencoDocumentiImpianti
	 */
	public ExecResults visualizzaDocumento(

			it.csi.sigit.sigitwebn.dto.elenco_documenti_impianti.CpElencoDocumentiImpiantiModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String VISUALIZZADOCUMENTO_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String VISUALIZZADOCUMENTO_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R863635208) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			try {
				Integer idDocumentoSelezionato = theModel.getAppDataidDocumentoSelezionato();
				log.debug(" DOCUMENTI ----> VISUALIZZA DOCUMENTO ------------> idDocumentoSelezionato: "
						+ idDocumentoSelezionato);
				Ruolo ruoloUtente = theModel.getAppDatautenteLoggato().getRuolo();

				//se non lo hanno selezionato questo metodo mi blocca
				getValidationMgr().checkSelezioneElemento(ConvertUtil.convertToString(idDocumentoSelezionato));

				Documento documentoSelez = GenericUtil.getDocumentoById(idDocumentoSelezionato,
						theModel.getAppDataelencoDocumenti());

				if (ruoloUtente.getDescRuolo().equalsIgnoreCase(Constants.RUOLO_SUPER)
						|| documentoSelez.getDescStatoDocumento().equals(Constants.DESC_STATO_DOC_ATTIVO)) {

					theModel.getSession().put(Constants.SESSIONE_VAR_DOCUMENTO_SELEZIONATO, documentoSelez);

					//theModel.getSession().put(Constants.SESSIONE_VAR_ID_DOCUMENTO, idDocumentoSelezionato);

					result.setResultCode(VISUALIZZADOCUMENTO_OUTCOME_CODE__OK);
				} else {
					result.getGlobalErrors().add("Documento cancellato");
					result.setResultCode(VISUALIZZADOCUMENTO_OUTCOME_CODE__KO);
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
			log.error("[BackEndFacade::visualizzaDocumento] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo inserisciDocumento definito in un ExecCommand del
	 * ContentPanel cpElencoDocumentiImpianti
	 */
	public ExecResults inserisciDocumento(

			it.csi.sigit.sigitwebn.dto.elenco_documenti_impianti.CpElencoDocumentiImpiantiModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String INSERISCIDOCUMENTO_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String INSERISCIDOCUMENTO_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-716150741) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			theModel.setAppDatadocumento(null);

			// impostazione del result code 
			result.setResultCode(INSERISCIDOCUMENTO_OUTCOME_CODE__OK);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::inserisciDocumento] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo eliminaDocumento definito in un ExecCommand del
	 * ContentPanel cpElencoDocumentiImpianti
	 */
	public ExecResults eliminaDocumento(

			it.csi.sigit.sigitwebn.dto.elenco_documenti_impianti.CpElencoDocumentiImpiantiModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String ELIMINADOCUMENTO_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String ELIMINADOCUMENTO_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-1905405711) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			try {

				Integer idADocumentoSelezionato = theModel.getAppDataidDocumentoSelezionato();
				log.debug(" BEPPE ----> ELIMINA DOCUMENTO ------------> idADocumentoSelezionato: "
						+ idADocumentoSelezionato);

				//controllo che abbiano selezionato un allegato
				getValidationMgr().checkSelezioneElemento(ConvertUtil.convertToString(idADocumentoSelezionato));

				Ruolo ruoloUtente = theModel.getAppDatautenteLoggato().getRuolo();

				//				DettaglioAllegato dettaglioAllegato = this.getDbMgr()
				//						.getDettaglioAllegatoById(idAllegatoSelezionato);

				getValidationMgr().validazioneFormaleEliminaDocumento(idADocumentoSelezionato,
						ruoloUtente.getDescRuolo());

				//theModel.setAppDataisAbilitazioneDatiAllegato(false);
				//lo spedisco a una maschera di conferma

				Message msg = new Message(Messages.C004);
				theModel.setAppDatamessaggioDinamico(ReplaceSpecialCharUtils.sanitize(msg.getText())); 

				// impostazione del result code 
				result.setResultCode(ELIMINADOCUMENTO_OUTCOME_CODE__OK);

			} catch (ManagerException ex) { 

				Validator.gestisciEccezione(result, ex);
			}

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::eliminaDocumento] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo gestAltroDoc definito in un ExecCommand del
	 * ContentPanel cpElencoDocumentiImpianti
	 */
	public ExecResults gestAltroDoc(

			it.csi.sigit.sigitwebn.dto.elenco_documenti_impianti.CpElencoDocumentiImpiantiModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GESTALTRODOC_OUTCOME_CODE__VISUALIZZA = //NOSONAR  Reason:EIAS
				"VISUALIZZA"; //NOSONAR  Reason:EIAS
		final String GESTALTRODOC_OUTCOME_CODE__NASCONDI = //NOSONAR  Reason:EIAS
				"NASCONDI"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R593885411) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			Documento documento = theModel.getAppDatadocumento();

			if (GenericUtil.isNotNullOrEmpty(documento.getIdTipoDocumento())
					&& (documento.getIdTipoDocumento().intValue() == Constants.ID_TIPO_DOC_ALTRO_DOC || documento
							.getIdTipoDocumento().intValue() == Constants.ID_TIPO_DOC_ALTRO_DOC_ISPEZIONI)) {
				// impostazione del result code 
				result.setResultCode(GESTALTRODOC_OUTCOME_CODE__VISUALIZZA);
			} else {
				// impostazione del result code 
				result.setResultCode(GESTALTRODOC_OUTCOME_CODE__NASCONDI);
			}

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::gestAltroDoc] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo chiudiDatiDocumento definito in un ExecCommand del
	 * ContentPanel cpElencoDocumentiImpianti
	 */
	public ExecResults chiudiDatiDocumento(

			it.csi.sigit.sigitwebn.dto.elenco_documenti_impianti.CpElencoDocumentiImpiantiModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String CHIUDIDATIDOCUMENTO_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R2107353368) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			// impostazione del result code 
			result.setResultCode(CHIUDIDATIDOCUMENTO_OUTCOME_CODE__OK);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::chiudiDatiDocumento] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo caricaDocumento definito in un ExecCommand del
	 * ContentPanel cpElencoDocumentiImpianti
	 */
	public ExecResults caricaDocumento(

			it.csi.sigit.sigitwebn.dto.elenco_documenti_impianti.CpElencoDocumentiImpiantiModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String CARICADOCUMENTO_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String CARICADOCUMENTO_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R922763939) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			try {

				UtenteLoggato utenteLoggato = theModel.getAppDatautenteLoggato();

				getValidationMgr().validazioneFormaleCaricaDocumento(theModel.getAppDatadocumento());

				String impiantoInSessione = theModel.getAppDataidImpiantoSelez();

				log.debug("inizio import xml");
				File file = theModel.getWidg_fuUploadDoc();
				if (file == null) {
					throw new ValidationManagerException(new Message("Selezionare un file"));

				} else {

					log.debug("STAMPO LA LUNGHEZZA DEL FILE: " + file.length());
					log.debug("STAMPO Integer.MAX_VALUE: " + Integer.MAX_VALUE);

					log.debug("elaborazione file");
					String nomeFile = theModel.getWidg_fuUploadDocFileName();

					if (file == null || !nomeFile.toUpperCase().endsWith(".PDF")) {

						throw new ValidationManagerException(new Message(Messages.S096, Constants.ESTENSIONE_PDF));

					} else if (nomeFile.length() > Constants.MAX_NOME_FILE_LEN) {
						throw new ValidationManagerException(
								new Message(Messages.S160, ConvertUtil.convertToString(Constants.MAX_NOME_FILE_LEN)));

					}

					Integer maxMB = getDbMgr().cercaConfigValueNumerico(Constants.MAX_MB_DOC);
					Integer maxByte = GenericUtil.getByteToMb(maxMB);

					if (file.length() > maxByte) {
						throw new ValidationManagerException(
								new Message(Messages.S156, ConvertUtil.convertToString(maxMB)));
					}

					ImportDocumentoFilter docFilter = new ImportDocumentoFilter();
					docFilter.setFile(file);
					docFilter.setCodImpianto(ReplaceSpecialCharUtils.sanitize(impiantoInSessione));
					docFilter.setContentType(ReplaceSpecialCharUtils.sanitize(theModel.getWidg_fuUploadDocContentType()));
					docFilter.setIdTipoDocumento(theModel.getAppDatadocumento().getIdTipoDocumento());
					docFilter.setNomeFile(ReplaceSpecialCharUtils.sanitize(theModel.getWidg_fuUploadDocFileName()));

					DettaglioIspezione ispezione = theModel.getAppDataidentificativoIspezione();

					if (ispezione != null) {
						docFilter.setIdImpRuoloPfpg(ispezione.getIdIspezione());
					}

					getSigitMgr().inserisciDocumento(docFilter, theModel.getAppDatadocumento().getDescAltroDoc(),
							utenteLoggato.getCodiceFiscale());

					result.getGlobalMessages().add("Documento importato correttamente");

					//theModel.setAppDataaggiornaElencoDocumenti(true);

					// Ricarico i documenti
					caricaElencoDocumenti(theModel);

					result.setResultCode(CARICADOCUMENTO_OUTCOME_CODE__OK);
				}
			} catch (ManagerException ex) {

				//getDbMgr().deleteImportLibretto(idImpianto);

				Validator.gestisciEccezione(result, ex);

			}
			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::caricaDocumento] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo visualizzaLibretto definito in un ExecCommand del
	 * ContentPanel cpElencoDocumentiImpianti
	 */
	public ExecResults visualizzaLibretto(

			it.csi.sigit.sigitwebn.dto.elenco_documenti_impianti.CpElencoDocumentiImpiantiModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String VISUALIZZALIBRETTO_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String VISUALIZZALIBRETTO_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R2111978821) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			try {
				String idLibrettoSelezionato = theModel.getAppDatarigaSelezionata();
				log.debug(" LIBRETTI ----> VISUALIZZA DOCUMENTO ------------> idLibrettoSelezionato: "
						+ idLibrettoSelezionato);

				//se non lo hanno selezionato questo metodo mi blocca
				getValidationMgr().checkSelezioneElemento(idLibrettoSelezionato);

				Documento documentoSelez = GenericUtil.getDocumentoById(idLibrettoSelezionato,
						theModel.getAppDatalistaLibretti());

				if (log.isDebugEnabled())
					GenericUtil.stampa(documentoSelez, true, 3);

				theModel.getSession().put(Constants.SESSIONE_VAR_DOCUMENTO_SELEZIONATO, documentoSelez);

				result.setResultCode(VISUALIZZALIBRETTO_OUTCOME_CODE__OK);
			} catch (ManagerException ex) {

				Validator.gestisciEccezione(result, ex);
			}

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
	 * Implementazione del metodo visualizzaDettaglioAllegatoPerImpianto definito in un ExecCommand del
	 * ContentPanel cpElencoDocumentiImpianti
	 */
	public ExecResults visualizzaDettaglioAllegatoPerImpianto(

			it.csi.sigit.sigitwebn.dto.elenco_documenti_impianti.CpElencoDocumentiImpiantiModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String VISUALIZZADETTAGLIOALLEGATOPERIMPIANTO_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String VISUALIZZADETTAGLIOALLEGATOPERIMPIANTO_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R1125865950) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			Integer idAllegatoSelezionato = theModel.getAppDataidAllegatoImpiantoSelezionato();

			try {
				Ruolo ruolo = theModel.getAppDatautenteLoggato().getRuolo();

				getValidationMgr().checkSelezioneElemento(ConvertUtil.convertToString(idAllegatoSelezionato));
				boolean storico = true;
				getValidationMgr().validazioneFormaleDettaglioAllegato(idAllegatoSelezionato, ruolo, storico);

				//metto in sessione
				theModel.getSession().put(Constants.SESSIONE_VAR_ID_ALLEGATO,
						ConvertUtil.convertToString(idAllegatoSelezionato));
				theModel.getSession().put(Constants.SESSIONE_VAR_ID_IMPIANTO, theModel.getAppDataidImpiantoSelez());

				// impostazione del result code 
				result.setResultCode(VISUALIZZADETTAGLIOALLEGATOPERIMPIANTO_OUTCOME_CODE__OK);

			} catch (ManagerException mgrEx) {
				Validator.gestisciEccezione(result, mgrEx);
			}

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error(
					"[BackEndFacade::visualizzaDettaglioAllegatoPerImpianto] Errore occorso nell'esecuzione del metodo:"
							+ e,
					e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo tornaPaginaChiamante definito in un ExecCommand del
	 * ContentPanel cpElencoDocumentiImpianti
	 */
	public ExecResults tornaPaginaChiamante(

			it.csi.sigit.sigitwebn.dto.elenco_documenti_impianti.CpElencoDocumentiImpiantiModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String TORNAPAGINACHIAMANTE_OUTCOME_CODE__RIS_RIC_IMPIANTO = //NOSONAR  Reason:EIAS
				"RIS_RIC_IMPIANTO"; //NOSONAR  Reason:EIAS
		final String TORNAPAGINACHIAMANTE_OUTCOME_CODE__GEST_IMPIANTO = //NOSONAR  Reason:EIAS
				"GEST_IMPIANTO"; //NOSONAR  Reason:EIAS
		final String TORNAPAGINACHIAMANTE_OUTCOME_CODE__GEST_IMPIANTO_RESP = //NOSONAR  Reason:EIAS
				"GEST_IMPIANTO_RESP"; //NOSONAR  Reason:EIAS
		final String TORNAPAGINACHIAMANTE_OUTCOME_CODE__RIS_RIC_AVZ_IMPIANTI = //NOSONAR  Reason:EIAS
				"RIS_RIC_AVZ_IMPIANTI"; //NOSONAR  Reason:EIAS
		final String TORNAPAGINACHIAMANTE_OUTCOME_CODE__GEST_ISPEZIONI = //NOSONAR  Reason:EIAS
				"GEST_ISPEZIONI"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R1311043574) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			String paginaChiamante = theModel.getAppDatapaginaChiamanteDocumenti();

			if (Constants.PAG_GEST_IMPIANTI.equals(paginaChiamante))
				result.setResultCode(TORNAPAGINACHIAMANTE_OUTCOME_CODE__GEST_IMPIANTO);
			else if (Constants.PAG_RIS_RIC_AVZ_IMPIANTI.equals(paginaChiamante))
				result.setResultCode(TORNAPAGINACHIAMANTE_OUTCOME_CODE__RIS_RIC_AVZ_IMPIANTI);
			else if (Constants.PAG_RIS_RIC_IMPIANTI.equals(paginaChiamante))
				result.setResultCode(TORNAPAGINACHIAMANTE_OUTCOME_CODE__RIS_RIC_IMPIANTO);
			else if (Constants.PAG_GEST_IMPIANTI_RESP.equals(paginaChiamante))
				result.setResultCode(TORNAPAGINACHIAMANTE_OUTCOME_CODE__GEST_IMPIANTO_RESP);
			else if (Constants.PAG_GEST_ISPEZIONI.equals(paginaChiamante))
				result.setResultCode(TORNAPAGINACHIAMANTE_OUTCOME_CODE__GEST_ISPEZIONI);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::tornaPaginaChiamante] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo salvaEliminaDocumento definito in un ExecCommand del
	 * ContentPanel cpElencoDocumentiImpianti
	 */
	public ExecResults salvaEliminaDocumento(

			it.csi.sigit.sigitwebn.dto.elenco_documenti_impianti.CpElencoDocumentiImpiantiModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String SALVAELIMINADOCUMENTO_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String SALVAELIMINADOCUMENTO_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-1341870504) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			try {
				Integer idAllegatoSelezionato = theModel.getAppDataidDocumentoSelezionato();

				getSigitMgr().eliminaDocumentoAggiuntivo(idAllegatoSelezionato,
						theModel.getAppDatautenteLoggato().getCodiceFiscale());

				theModel.getSession().put(Constants.SESSIONE_VAR_MESSAGGE,
						new Message(Messages.INFO_ELIMINAZIONE_CORRETTA, Message.INFO));

				result.getGlobalMessages().add(Messages.INFO_ELIMINAZIONE_CORRETTA);

				theModel.setAppDataaggiornaElencoDocumenti(true);
				theModel.setAppDataidDocumentoSelezionato(null);
				theModel.setAppDatamessaggioDinamico(null);

				result.setResultCode(SALVAELIMINADOCUMENTO_OUTCOME_CODE__OK);

			} catch (ManagerException ex) {

				theModel.getSession().put(Constants.SESSIONE_VAR_MESSAGGE,
						new Message(Messages.ERROR_RECUPERO_SERVIZIO, Message.ERROR));

				Validator.gestisciEccezione(result, ex);
			}

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::salvaEliminaDocumento] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo isRuoloAbilitato definito in un ExecCommand del
	 * ContentPanel cpElencoDocumentiImpianti
	 */
	public ExecResults isRuoloAbilitato(

			it.csi.sigit.sigitwebn.dto.elenco_documenti_impianti.CpElencoDocumentiImpiantiModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String ISRUOLOABILITATO_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-1818071220) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			String descRuolo = theModel.getAppDatautenteLoggato().getRuolo().getDescRuolo();

			if (descRuolo.equals(Constants.RUOLO_IMPRESA) || descRuolo.equals(Constants.RUOLO_RESPONSABILE)
					|| descRuolo.equals(Constants.RUOLO_RESPONSABILE_IMPRESA)
					|| descRuolo.equals(Constants.RUOLO_PROPRIETARIO)
					|| descRuolo.equals(Constants.RUOLO_PROPRIETARIO_IMPRESA)
					|| descRuolo.equals(Constants.RUOLO_3RESPONSABILE) || descRuolo.equals(Constants.RUOLO_SUPER)
					|| descRuolo.equals(Constants.RUOLO_VALIDATORE) || descRuolo.equals(Constants.RUOLO_ISPETTORE)
					|| descRuolo.equals(Constants.RUOLO_CONSULTATORE)) {
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
	 * Implementazione del metodo inizializzaElencoDocumenti definito in un ExecCommand del
	 * ContentPanel cpElencoDocumentiImpianti
	 */
	public ExecResults inizializzaElencoDocumenti(

			it.csi.sigit.sigitwebn.dto.elenco_documenti_impianti.CpElencoDocumentiImpiantiModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String INIZIALIZZAELENCODOCUMENTI_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String INIZIALIZZAELENCODOCUMENTI_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R1905692600) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			String paginaChiamante = theModel.getAppDatapaginaChiamanteDocumenti();

			if (!Constants.PAG_GEST_ISPEZIONI.equals(paginaChiamante)) {
				// Se non e' ispezione, per sicurezza tolgo l'ispezione (eventuale) dalla sessione. Altrimenti crea al salvataggio collega il DOC all'ispezione
				theModel.setAppDataidentificativoIspezione(null);
			}

			Integer idTipoDoc = null;

			if (Constants.PAG_GEST_IMPIANTI.equals(paginaChiamante))
				idTipoDoc = Constants.ID_TIPO_DOC_AGG_ALTRA_DOC;
			else if (Constants.PAG_RIS_RIC_AVZ_IMPIANTI.equals(paginaChiamante))
				idTipoDoc = Constants.ID_TIPO_DOC_AGG_ALTRA_DOC;
			else if (Constants.PAG_RIS_RIC_IMPIANTI.equals(paginaChiamante))
				idTipoDoc = Constants.ID_TIPO_DOC_AGG_ALTRA_DOC;
			else if (Constants.PAG_GEST_IMPIANTI_RESP.equals(paginaChiamante))
				idTipoDoc = Constants.ID_TIPO_DOC_AGG_ALTRA_DOC;
			else if (Constants.PAG_GEST_ISPEZIONI.equals(paginaChiamante))
				idTipoDoc = Constants.ID_TIPO_DOC_AGG_ISPEZIONI;

			caricaElencoDocumenti(theModel);

			theModel.setAppDataelencoTipiDocumentazione(getSigitMgr().cercaElencoTipiDocumentazione(idTipoDoc));

			// impostazione del result code 
			result.setResultCode(INIZIALIZZAELENCODOCUMENTI_OUTCOME_CODE__OK);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::inizializzaElencoDocumenti] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo gestioneVisBottoniInit definito in un ExecCommand del
	 * ContentPanel cpElencoDocumentiImpianti
	 */
	public ExecResults gestioneVisBottoniInit(

			it.csi.sigit.sigitwebn.dto.elenco_documenti_impianti.CpElencoDocumentiImpiantiModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GESTIONEVISBOTTONIINIT_OUTCOME_CODE__VISUALIZZA = //NOSONAR  Reason:EIAS
				"VISUALIZZA"; //NOSONAR  Reason:EIAS
		final String GESTIONEVISBOTTONIINIT_OUTCOME_CODE__NASCONDI = //NOSONAR  Reason:EIAS
				"NASCONDI"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-1933265525) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			ArrayList<Documento> documenti = theModel.getAppDataelencoDocumenti();

			if (documenti != null && documenti.size() > 0) {
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
	 * Implementazione del metodo isVisualizzaBtnVisualizzaDoc definito in un ExecCommand del
	 * ContentPanel cpElencoDocumentiImpianti
	 */
	public ExecResults isVisualizzaBtnVisualizzaDoc(

			it.csi.sigit.sigitwebn.dto.elenco_documenti_impianti.CpElencoDocumentiImpiantiModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String ISVISUALIZZABTNVISUALIZZADOC_OUTCOME_CODE__SI = //NOSONAR  Reason:EIAS
				"SI"; //NOSONAR  Reason:EIAS
		final String ISVISUALIZZABTNVISUALIZZADOC_OUTCOME_CODE__NO = //NOSONAR  Reason:EIAS
				"NO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R1980770958) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			/*
			UtenteLoggato utente = theModel.getAppDatautenteLoggato();
			
			String descrizioneRuolo = utente.getRuolo().getDescRuolo();
			
			log.debug(" isVisualizzaBtnVisualizzaDoc ---> descrizioneRuolo: "
					+ descrizioneRuolo);
			
			if (descrizioneRuolo.equals(Constants.RUOLO_CONSULTATORE)) {
				// impostazione del result code 
				result.setResultCode(ISVISUALIZZABTNVISUALIZZADOC_OUTCOME_CODE__NO);
			} else {
				// impostazione del result code 
				result.setResultCode(ISVISUALIZZABTNVISUALIZZADOC_OUTCOME_CODE__SI);
			}
			 */

			// E' visibile a tutti
			result.setResultCode(ISVISUALIZZABTNVISUALIZZADOC_OUTCOME_CODE__SI);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::isVisualizzaBtnVisualizzaDoc] Errore occorso nell'esecuzione del metodo:" + e,
					e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo isVisualizzaBtnEliminaDoc definito in un ExecCommand del
	 * ContentPanel cpElencoDocumentiImpianti
	 */
	public ExecResults isVisualizzaBtnEliminaDoc(

			it.csi.sigit.sigitwebn.dto.elenco_documenti_impianti.CpElencoDocumentiImpiantiModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String ISVISUALIZZABTNELIMINADOC_OUTCOME_CODE__SI = //NOSONAR  Reason:EIAS
				"SI"; //NOSONAR  Reason:EIAS
		final String ISVISUALIZZABTNELIMINADOC_OUTCOME_CODE__NO = //NOSONAR  Reason:EIAS
				"NO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R1681486947) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			UtenteLoggato utente = theModel.getAppDatautenteLoggato();

			String descrizioneRuolo = utente.getRuolo().getDescRuolo();

			log.debug(" isVisualizzaBtnEliminaDoc ---> descrizioneRuolo: " + descrizioneRuolo);
			String paginaChiamante = theModel.getAppDatapaginaChiamanteDocumenti();

			if (descrizioneRuolo.equals(Constants.RUOLO_VALIDATORE)) {
				if (Constants.PAG_GEST_ISPEZIONI.equals(paginaChiamante)) {

					result.setResultCode(ISVISUALIZZABTNELIMINADOC_OUTCOME_CODE__NO);

				} else {
					result.setResultCode(ISVISUALIZZABTNELIMINADOC_OUTCOME_CODE__SI);

				}
			} else if (descrizioneRuolo.equals(Constants.RUOLO_CONSULTATORE)
					|| descrizioneRuolo.equals(Constants.RUOLO_PROPRIETARIO)
					|| descrizioneRuolo.equals(Constants.RUOLO_PROPRIETARIO_IMPRESA)) {
				// impostazione del result code 
				result.setResultCode(ISVISUALIZZABTNELIMINADOC_OUTCOME_CODE__NO);
			} else {
				// impostazione del result code 
				result.setResultCode(ISVISUALIZZABTNELIMINADOC_OUTCOME_CODE__SI);
			}

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::isVisualizzaBtnEliminaDoc] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo isVisualizzaBtnInserisciDoc definito in un ExecCommand del
	 * ContentPanel cpElencoDocumentiImpianti
	 */
	public ExecResults isVisualizzaBtnInserisciDoc(

			it.csi.sigit.sigitwebn.dto.elenco_documenti_impianti.CpElencoDocumentiImpiantiModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String ISVISUALIZZABTNINSERISCIDOC_OUTCOME_CODE__SI = //NOSONAR  Reason:EIAS
				"SI"; //NOSONAR  Reason:EIAS
		final String ISVISUALIZZABTNINSERISCIDOC_OUTCOME_CODE__NO = //NOSONAR  Reason:EIAS
				"NO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R1037838749) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			UtenteLoggato utente = theModel.getAppDatautenteLoggato();

			String descrizioneRuolo = utente.getRuolo().getDescRuolo();

			log.debug(" isVisualizzaBtnInserisciDoc ---> descrizioneRuolo: " + descrizioneRuolo);

			String paginaChiamante = theModel.getAppDatapaginaChiamanteDocumenti();

			if (descrizioneRuolo.equals(Constants.RUOLO_VALIDATORE)) {
				if (Constants.PAG_GEST_ISPEZIONI.equals(paginaChiamante)) {

					result.setResultCode(ISVISUALIZZABTNINSERISCIDOC_OUTCOME_CODE__NO);

				} else {
					result.setResultCode(ISVISUALIZZABTNINSERISCIDOC_OUTCOME_CODE__SI);

				}
			} else if (descrizioneRuolo.equals(Constants.RUOLO_CONSULTATORE)
					|| descrizioneRuolo.equals(Constants.RUOLO_PROPRIETARIO)
					|| descrizioneRuolo.equals(Constants.RUOLO_PROPRIETARIO_IMPRESA)) {
				// impostazione del result code 
				result.setResultCode(ISVISUALIZZABTNINSERISCIDOC_OUTCOME_CODE__NO);
			} else {
				// impostazione del result code 
				result.setResultCode(ISVISUALIZZABTNINSERISCIDOC_OUTCOME_CODE__SI);
			}

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::isVisualizzaBtnInserisciDoc] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo gestioneVisIspezioni definito in un ExecCommand del
	 * ContentPanel cpElencoDocumentiImpianti
	 */
	public ExecResults gestioneVisIspezioni(

			it.csi.sigit.sigitwebn.dto.elenco_documenti_impianti.CpElencoDocumentiImpiantiModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GESTIONEVISISPEZIONI_OUTCOME_CODE__VISUALIZZA = //NOSONAR  Reason:EIAS
				"VISUALIZZA"; //NOSONAR  Reason:EIAS
		final String GESTIONEVISISPEZIONI_OUTCOME_CODE__NASCONDI = //NOSONAR  Reason:EIAS
				"NASCONDI"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-952001348) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			String paginaChiamante = theModel.getAppDatapaginaChiamanteDocumenti();

			if (Constants.PAG_GEST_ISPEZIONI.equals(paginaChiamante)) {
				// impostazione del result code 
				result.setResultCode(GESTIONEVISISPEZIONI_OUTCOME_CODE__VISUALIZZA);
			} else {
				// impostazione del result code 
				result.setResultCode(GESTIONEVISISPEZIONI_OUTCOME_CODE__NASCONDI);
			}

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::gestioneVisIspezioni] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo gestisciVisElencoLibretti definito in un ExecCommand del
	 * ContentPanel cpElencoDocumentiImpianti
	 */
	public ExecResults gestisciVisElencoLibretti(

			it.csi.sigit.sigitwebn.dto.elenco_documenti_impianti.CpElencoDocumentiImpiantiModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GESTISCIVISELENCOLIBRETTI_OUTCOME_CODE__VISUALIZZA = //NOSONAR  Reason:EIAS
				"VISUALIZZA"; //NOSONAR  Reason:EIAS
		final String GESTISCIVISELENCOLIBRETTI_OUTCOME_CODE__NASCONDI = //NOSONAR  Reason:EIAS
				"NASCONDI"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R1672398918) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			UtenteLoggato utenteLoggato = theModel.getAppDatautenteLoggato();
			String descrizioneRuolo = utenteLoggato.getRuolo().getDescRuolo();

			if (descrizioneRuolo.equals(Constants.RUOLO_SUPER) || descrizioneRuolo.equals(Constants.RUOLO_ISPETTORE)
					|| descrizioneRuolo.equals(Constants.RUOLO_VALIDATORE)
					|| descrizioneRuolo.equals(Constants.RUOLO_CONSULTATORE)) {

				caricaElencoLibrettiConsolidati(theModel);
				// impostazione del result code 
				result.setResultCode(GESTISCIVISELENCOLIBRETTI_OUTCOME_CODE__VISUALIZZA);
			} else {
				// impostazione del result code 
				result.setResultCode(GESTISCIVISELENCOLIBRETTI_OUTCOME_CODE__NASCONDI);
			}

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::gestisciVisElencoLibretti] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo inizializzaElencoAllegatiREE definito in un ExecCommand del
	 * ContentPanel cpElencoDocumentiImpianti
	 */
	public ExecResults inizializzaElencoAllegatiREE(

			it.csi.sigit.sigitwebn.dto.elenco_documenti_impianti.CpElencoDocumentiImpiantiModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String INIZIALIZZAELENCOALLEGATIREE_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String INIZIALIZZAELENCOALLEGATIREE_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-1394580313) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			String codiceImpianto = theModel.getAppDataidImpiantoSelez();
			UtenteLoggato utenteLoggato = theModel.getAppDatautenteLoggato();
			AllegatiPerImpianto allegatiPerImpianto;
			allegatiPerImpianto = this.getSigitMgr().cercaStoricoAllegatiPerCodiceImpianto(codiceImpianto);
			if (allegatiPerImpianto != null) {
				theModel.setAppDataidentificativoImpianto(allegatiPerImpianto.getIdentificativoImpianto());
				theModel.setAppDataelencoAllegatiPerImpianto(allegatiPerImpianto.getListaAllegati());
			} else {
				theModel.setAppDataelencoAllegatiPerImpianto(new ArrayList<DettaglioAllegato>());
				theModel.setAppDataidentificativoImpianto(new IdentificativoImpianto());
			}
			// impostazione del result code 
			result.setResultCode(INIZIALIZZAELENCOALLEGATIREE_OUTCOME_CODE__OK);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::inizializzaElencoAllegatiREE] Errore occorso nell'esecuzione del metodo:" + e,
					e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo aggiornaDatiPagina definito in un ExecCommand del
	 * ContentPanel cpElencoDocumentiImpianti
	 */
	public ExecResults aggiornaDatiPagina(

			it.csi.sigit.sigitwebn.dto.elenco_documenti_impianti.CpElencoDocumentiImpiantiModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String AGGIORNADATIPAGINA_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String AGGIORNADATIPAGINA_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R1252078014) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			try {

				result.setResultCode(AGGIORNADATIPAGINA_OUTCOME_CODE__KO);
				Message msg = (Message) theModel.getSession().get(Constants.SESSIONE_VAR_MESSAGGE);
				if (msg != null) {
					if (msg.getType() == Message.ERROR)
						result.getGlobalErrors().add(msg.getText());
					else
						result.getGlobalMessages().add(msg.getText());

					theModel.getSession().remove(Constants.SESSIONE_VAR_MESSAGGE);
				}

				//devo riaggiornare la lista dei documenti

				log.debug("aggiornaDatiPagina - theModel.getAppDataaggiornaElencoDocumenti(): "
						+ theModel.getAppDataaggiornaElencoDocumenti());

				if (theModel.getAppDataaggiornaElencoDocumenti()) {

					caricaElencoDocumenti(theModel);

					// impostazione del result code 
					result.setResultCode(AGGIORNADATIPAGINA_OUTCOME_CODE__OK);
				} else {
					result.setResultCode(AGGIORNADATIPAGINA_OUTCOME_CODE__KO);
				}
			} catch (ManagerException ex) {
				log.debug("catturato eccezione ");
				Validator.gestisciEccezione(result, ex);
			}

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

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo gestioneVisBottoniRef definito in un ExecCommand del
	 * ContentPanel cpElencoDocumentiImpianti
	 */
	public ExecResults gestioneVisBottoniRef(

			it.csi.sigit.sigitwebn.dto.elenco_documenti_impianti.CpElencoDocumentiImpiantiModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GESTIONEVISBOTTONIREF_OUTCOME_CODE__VISUALIZZA = //NOSONAR  Reason:EIAS
				"VISUALIZZA"; //NOSONAR  Reason:EIAS
		final String GESTIONEVISBOTTONIREF_OUTCOME_CODE__NASCONDI = //NOSONAR  Reason:EIAS
				"NASCONDI"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R325784170) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			ArrayList<Documento> documenti = theModel.getAppDataelencoDocumenti();

			if (documenti != null && documenti.size() > 0) {
				// impostazione del result code 
				result.setResultCode(GESTIONEVISBOTTONIREF_OUTCOME_CODE__VISUALIZZA);
			} else {
				// impostazione del result code 
				result.setResultCode(GESTIONEVISBOTTONIREF_OUTCOME_CODE__NASCONDI);
			}

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::gestioneVisBottoniRef] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo isVisualizzaBtnVisualizzaDocRef definito in un ExecCommand del
	 * ContentPanel cpElencoDocumentiImpianti
	 */
	public ExecResults isVisualizzaBtnVisualizzaDocRef(

			it.csi.sigit.sigitwebn.dto.elenco_documenti_impianti.CpElencoDocumentiImpiantiModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String ISVISUALIZZABTNVISUALIZZADOCREF_OUTCOME_CODE__SI = //NOSONAR  Reason:EIAS
				"SI"; //NOSONAR  Reason:EIAS
		final String ISVISUALIZZABTNVISUALIZZADOCREF_OUTCOME_CODE__NO = //NOSONAR  Reason:EIAS
				"NO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R923009847) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			//E' visibile a tutti
			result.setResultCode(ISVISUALIZZABTNVISUALIZZADOCREF_OUTCOME_CODE__SI);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::isVisualizzaBtnVisualizzaDocRef] Errore occorso nell'esecuzione del metodo:" + e,
					e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo isVisualizzaBtnEliminaDocRef definito in un ExecCommand del
	 * ContentPanel cpElencoDocumentiImpianti
	 */
	public ExecResults isVisualizzaBtnEliminaDocRef(

			it.csi.sigit.sigitwebn.dto.elenco_documenti_impianti.CpElencoDocumentiImpiantiModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String ISVISUALIZZABTNELIMINADOCREF_OUTCOME_CODE__SI = //NOSONAR  Reason:EIAS
				"SI"; //NOSONAR  Reason:EIAS
		final String ISVISUALIZZABTNELIMINADOCREF_OUTCOME_CODE__NO = //NOSONAR  Reason:EIAS
				"NO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R1305144642) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			UtenteLoggato utente = theModel.getAppDatautenteLoggato();

			String descrizioneRuolo = utente.getRuolo().getDescRuolo();

			log.debug(" isVisualizzaBtnEliminaDocRef ---> descrizioneRuolo: " + descrizioneRuolo);

			String paginaChiamante = theModel.getAppDatapaginaChiamanteDocumenti();

			if (descrizioneRuolo.equals(Constants.RUOLO_VALIDATORE)) {
				if (Constants.PAG_GEST_ISPEZIONI.equals(paginaChiamante)) {
					result.setResultCode(ISVISUALIZZABTNELIMINADOCREF_OUTCOME_CODE__NO);
				} else {
					result.setResultCode(ISVISUALIZZABTNELIMINADOCREF_OUTCOME_CODE__SI);
				}
			} else if (descrizioneRuolo.equals(Constants.RUOLO_CONSULTATORE)
					|| descrizioneRuolo.equals(Constants.RUOLO_PROPRIETARIO)
					|| descrizioneRuolo.equals(Constants.RUOLO_PROPRIETARIO_IMPRESA)) {
				// impostazione del result code 
				result.setResultCode(ISVISUALIZZABTNELIMINADOCREF_OUTCOME_CODE__NO);
			} else {
				// impostazione del result code 
				result.setResultCode(ISVISUALIZZABTNELIMINADOCREF_OUTCOME_CODE__SI);
			}

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::isVisualizzaBtnEliminaDocRef] Errore occorso nell'esecuzione del metodo:" + e,
					e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	//////////////////////////////////////////////////////////////////////////////
	/// Metodi statici per il reset delle tabelle
	//////////////////////////////////////////////////////////////////////////////

	/**
	 * permette di resettare lo stato di paginazione della tabella widg_tblElencoDocumenti
	 */
	public static void resetClearStatus_widg_tblElencoDocumenti(java.util.Map session) {
		session.put("cpElencoDocumentiImpianti_tblElencoDocumenti_clearStatus", Boolean.TRUE);
	}

	/**
	 * permette di resettare lo stato di paginazione della tabella widg_tbArchivioElencoLibrettiConsolidatiStorico
	 */
	public static void resetClearStatus_widg_tbArchivioElencoLibrettiConsolidatiStorico(java.util.Map session) {
		session.put("cpElencoDocumentiImpianti_tbArchivioElencoLibrettiConsolidatiStorico_clearStatus", Boolean.TRUE);
	}

	/**
	 * permette di resettare lo stato di paginazione della tabella widg_tblStoricoREE
	 */
	public static void resetClearStatus_widg_tblStoricoREE(java.util.Map session) {
		session.put("cpElencoDocumentiImpianti_tblStoricoREE_clearStatus", Boolean.TRUE);
	}

	//////////////////////////////////////////////////////////////////////////////
	/// Property aggiuntive del bean
	//////////////////////////////////////////////////////////////////////////////
	/*PROTECTED REGION ID(R-641650809) ENABLED START*/
	//// inserire qui le property che si vogliono iniettare in questo bean (es. dao, proxy di pd, ...) 

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

	private void caricaElencoDocumenti(
			it.csi.sigit.sigitwebn.dto.elenco_documenti_impianti.CpElencoDocumentiImpiantiModel theModel)
			throws ManagerException {

		try {
			log.debug("Carico l'elenco dei documenti");

			String codiceImpianto = theModel.getAppDataidImpiantoSelez();

			ArrayList<Documento> documenti;

			String paginaChiamante = theModel.getAppDatapaginaChiamanteDocumenti();

			//			boolean isIspezione = false;
			//
			//			if (Constants.PAG_GEST_ISPEZIONI.equals(paginaChiamante)) {
			//				isIspezione = true;
			//			}

			documenti = getSigitMgr().cercaDocumentiPerCodiceImpianto(codiceImpianto);

			if (documenti != null) {
				theModel.setAppDataelencoDocumenti(documenti);
			}
			resetClearStatus_widg_tblElencoDocumenti(theModel.getSession());
			theModel.setAppDataaggiornaElencoDocumenti(false);

			log.debug("CaricaElencoAllegati: END");
		} catch (ManagerException e) {
			log.error("Errore: ", e);
			throw e;
		}

	}

	private void caricaElencoLibrettiConsolidati(
			it.csi.sigit.sigitwebn.dto.elenco_documenti_impianti.CpElencoDocumentiImpiantiModel theModel)
			throws ManagerException {

		try {
			log.debug("CaricaElencoLibrettiConsolidati: START");

			String codiceImpianto = theModel.getAppDataidImpiantoSelez();

			ArrayList<LibrettoDett> librettiCons = getSigitMgr()
					.cercaStoricoLibrettiConsolidatiNonBozza(codiceImpianto);

			if (librettiCons != null) {
				theModel.setAppDatalistaLibretti(librettiCons);
			}

			log.debug("CaricaElencoLibrettiConsolidati: END");
		} catch (ManagerException e) {
			log.error("Errore: ", e);
			throw e;
		}

	}

	/*PROTECTED REGION END*/
}
