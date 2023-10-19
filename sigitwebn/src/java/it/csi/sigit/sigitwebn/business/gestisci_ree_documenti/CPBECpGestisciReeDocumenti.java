package it.csi.sigit.sigitwebn.business.gestisci_ree_documenti;

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

/*PROTECTED REGION ID(R254975385) ENABLED START*/
import java.io.File;
import it.csi.custom.component.tree.base.TreeNode;
import it.csi.custom.component.tree.base.TreeNodeBase;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.filter.ImportDocumentoFilter;
import it.csi.sigit.sigitwebn.business.manager.DbMgr;
import it.csi.sigit.sigitwebn.business.manager.ServiziMgr;
import it.csi.sigit.sigitwebn.business.manager.SigitMgr;
import it.csi.sigit.sigitwebn.business.manager.ValidationMgr;
import it.csi.sigit.sigitwebn.business.manager.util.ManagerException;
import it.csi.sigit.sigitwebn.business.manager.util.Message;
import it.csi.sigit.sigitwebn.business.manager.util.ValidationManagerException;

/*PROTECTED REGION END*/

public class CPBECpGestisciReeDocumenti {

	/**  */
	protected static final Logger log = //NOSONAR  Reason:EIAS 
			Logger.getLogger(Constants.APPLICATION_CODE + ".business"); //NOSONAR  Reason:EIAS

	//////////////////////////////////////////////////////////////////////////////
	/// Costanti identificative degli Application Data
	//////////////////////////////////////////////////////////////////////////////

	// ApplicationData: [utenteLoggato, scope:USER_SESSION]
	public static final String APPDATA_UTENTELOGGATO_CODE = "appDatautenteLoggato";

	// ApplicationData: [idAllegatoImpiantoSelezionato, scope:USER_SESSION]
	public static final String APPDATA_IDALLEGATOIMPIANTOSELEZIONATO_CODE = "appDataidAllegatoImpiantoSelezionato";

	// ApplicationData: [identificativoImpiantoAllegato, scope:USER_SESSION]
	public static final String APPDATA_IDENTIFICATIVOIMPIANTOALLEGATO_CODE = "appDataidentificativoImpiantoAllegato";

	// ApplicationData: [paginaChiamanteImp, scope:USER_SESSION]
	public static final String APPDATA_PAGINACHIAMANTEIMP_CODE = "appDatapaginaChiamanteImp";

	// ApplicationData: [allegato, scope:USER_SESSION]
	public static final String APPDATA_ALLEGATO_CODE = "appDataallegato";

	// ApplicationData: [gestioneAllegatiImpianto, scope:USER_SESSION]
	public static final String APPDATA_GESTIONEALLEGATIIMPIANTO_CODE = "appDatagestioneAllegatiImpianto";

	// ApplicationData: [messaggioDinamico, scope:USER_SESSION]
	public static final String APPDATA_MESSAGGIODINAMICO_CODE = "appDatamessaggioDinamico";

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

	// ApplicationData: [idDocumentoSelezionato, scope:USER_SESSION]
	public static final String APPDATA_IDDOCUMENTOSELEZIONATO_CODE = "appDataidDocumentoSelezionato";

	// ApplicationData: [paginaChiamanteDocumenti, scope:USER_SESSION]
	public static final String APPDATA_PAGINACHIAMANTEDOCUMENTI_CODE = "appDatapaginaChiamanteDocumenti";

	// ApplicationData: [reeMenuTree, scope:USER_SESSION]
	public static final String APPDATA_REEMENUTREE_CODE = "appDatareeMenuTree";

	// ApplicationData: [identificativoImpianto, scope:USER_SESSION]
	public static final String APPDATA_IDENTIFICATIVOIMPIANTO_CODE = "appDataidentificativoImpianto";

	// ApplicationData: [progressivoSelezionato, scope:USER_SESSION]
	public static final String APPDATA_PROGRESSIVOSELEZIONATO_CODE = "appDataprogressivoSelezionato";

	//////////////////////////////////////////////////////////////////////////////
	/// Metodi associati alla U.I.
	//////////////////////////////////////////////////////////////////////////////

	// nome del content panel associato al bean
	public static final String CPNAME = "cpGestisciReeDocumenti";

	public static final String MULTIPANEL_MPDATIDOCUMENTO = "mpDatiDocumento";
	public static final String MPI_MPDATIDOCUMENTO_FPDATIDOCUMENTO = CPNAME + "_" + MULTIPANEL_MPDATIDOCUMENTO + "_"
			+ "fpDatiDocumento";

	/** 
	 * Restituisce il tab correntemente visibile in un determinato tab set
	 */
	private String getCurrentTab(Map session, String tabSetName) {
		String value = (String) session.get(CPNAME + "_" + tabSetName + "_selectedMultiPanel");
		return value;
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo onTreeClick definito in un ExecCommand del
	 * ContentPanel cpGestisciReeDocumenti
	 */
	public ExecResults onTreeClick(

			it.csi.sigit.sigitwebn.dto.gestisci_ree_documenti.CpGestisciReeDocumentiModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String ONTREECLICK_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		final String ONTREECLICK_OUTCOME_CODE__TIPO1_SEZIONE_ABCDF = //NOSONAR  Reason:EIAS
				"TIPO1_SEZIONE_ABCDF"; //NOSONAR  Reason:EIAS
		final String ONTREECLICK_OUTCOME_CODE__TIPO1_SEZIONE_E = //NOSONAR  Reason:EIAS
				"TIPO1_SEZIONE_E"; //NOSONAR  Reason:EIAS
		final String ONTREECLICK_OUTCOME_CODE__TIPO2_SEZIONE_ABCDF = //NOSONAR  Reason:EIAS
				"TIPO2_SEZIONE_ABCDF"; //NOSONAR  Reason:EIAS
		final String ONTREECLICK_OUTCOME_CODE__TIPO2_SEZIONE_E = //NOSONAR  Reason:EIAS
				"TIPO2_SEZIONE_E"; //NOSONAR  Reason:EIAS
		final String ONTREECLICK_OUTCOME_CODE__TIPO3_SEZIONE_ABCDF = //NOSONAR  Reason:EIAS
				"TIPO3_SEZIONE_ABCDF"; //NOSONAR  Reason:EIAS
		final String ONTREECLICK_OUTCOME_CODE__TIPO3_SEZIONE_E = //NOSONAR  Reason:EIAS
				"TIPO3_SEZIONE_E"; //NOSONAR  Reason:EIAS
		final String ONTREECLICK_OUTCOME_CODE__TIPO4_SEZIONE_ABCDF = //NOSONAR  Reason:EIAS
				"TIPO4_SEZIONE_ABCDF"; //NOSONAR  Reason:EIAS
		final String ONTREECLICK_OUTCOME_CODE__TIPO4_SEZIONE_E = //NOSONAR  Reason:EIAS
				"TIPO4_SEZIONE_E"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-650263221) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			String ret = null;

			String clickedNodeId = theModel.getIdNodo();

			log.debug("Ho premuto theModel.getAppDatareeMenuTree(): " + theModel.getAppDatareeMenuTree());
			log.debug("Ho premuto clickedNodeId: " + clickedNodeId);

			// recupero il nodo corrispondente all'ID
			TreeNode clickedNode = theModel.getAppDatareeMenuTree().getChildren(clickedNodeId);

			log.debug("HO PREMUTO il NODO: CLICKED NODE: " + clickedNodeId + " ("
					+ (clickedNode != null ? clickedNode.getDescription() : "") + ")");

			if (clickedNodeId != null) {
				ret = ONTREECLICK_OUTCOME_CODE__KO;
				String progr = null;

				if (clickedNodeId.equals("F-tipo1")) {
					// impostazione del result code 
					ret = ONTREECLICK_OUTCOME_CODE__TIPO1_SEZIONE_ABCDF;
				} else if (clickedNodeId.startsWith(Constants.PREFIX_ID_NODO_TIPO_1_E)) {
					// impostazione del result code 
					ret = ONTREECLICK_OUTCOME_CODE__TIPO1_SEZIONE_E;

					// devo salvare il progressivo
					progr = clickedNodeId.substring(Constants.PREFIX_ID_NODO_TIPO_1_E.length());

				} else if (clickedNodeId.equals("F-tipo2")) {
					// impostazione del result code 
					ret = ONTREECLICK_OUTCOME_CODE__TIPO2_SEZIONE_ABCDF;
				} else if (clickedNodeId.startsWith(Constants.PREFIX_ID_NODO_TIPO_2_E)) {
					// impostazione del result code 
					ret = ONTREECLICK_OUTCOME_CODE__TIPO2_SEZIONE_E;

					// devo salvare il progressivo
					progr = clickedNodeId.substring(Constants.PREFIX_ID_NODO_TIPO_2_E.length());

				} else if (clickedNodeId.equals("F-tipo3")) {
					// impostazione del result code 
					ret = ONTREECLICK_OUTCOME_CODE__TIPO3_SEZIONE_ABCDF;
				} else if (clickedNodeId.startsWith(Constants.PREFIX_ID_NODO_TIPO_3_E)) {
					// impostazione del result code 
					ret = ONTREECLICK_OUTCOME_CODE__TIPO3_SEZIONE_E;

					// devo salvare il progressivo
					progr = clickedNodeId.substring(Constants.PREFIX_ID_NODO_TIPO_3_E.length());

				} else if (clickedNodeId.equals("F-tipo4")) {
					// impostazione del result code 
					ret = ONTREECLICK_OUTCOME_CODE__TIPO4_SEZIONE_ABCDF;
				} else if (clickedNodeId.startsWith(Constants.PREFIX_ID_NODO_TIPO_4_E)) {
					// impostazione del result code 
					ret = ONTREECLICK_OUTCOME_CODE__TIPO4_SEZIONE_E;

					// devo salvare il progressivo
					progr = clickedNodeId.substring(Constants.PREFIX_ID_NODO_TIPO_4_E.length());

				}

				if (progr != null) {
					log.debug("Il progressivo trovato e': " + progr);
					theModel.setAppDataprogressivoSelezionato(ConvertUtil.convertToInteger(progr));
				}
			}

			log.debug("Stampo il resultCod - cpGestReeTipo1: " + ret);

			result.setResultCode(ret);

			// Setto la pagina in cui sto andando, mi servirà nel caso ci sia necessità di ricaricare la pagina con un messaggio (es. invia allegato)
			theModel.getSession().put(Constants.SESSIONE_VAR_ALLEGATO_SEZIONE, ret);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::onTreeClick] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo visualizzaDocumento definito in un ExecCommand del
	 * ContentPanel cpGestisciReeDocumenti
	 */
	public ExecResults visualizzaDocumento(

			it.csi.sigit.sigitwebn.dto.gestisci_ree_documenti.CpGestisciReeDocumentiModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String VISUALIZZADOCUMENTO_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String VISUALIZZADOCUMENTO_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R386919706) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			try {
				Integer idDocumentoSelezionato = theModel.getAppDataidDocumentoSelezionato();
				log.debug(" DOCUMENTI ----> VISUALIZZA DOCUMENTO ------------> idDocumentoSelezionato: "
						+ idDocumentoSelezionato);

				//se non lo hanno selezionato questo metodo mi blocca
				getValidationMgr().checkSelezioneElemento(ConvertUtil.convertToString(idDocumentoSelezionato));

				Documento documentoSelez = GenericUtil.getDocumentoById(idDocumentoSelezionato,
						theModel.getAppDataelencoDocumenti());

				theModel.getSession().put(Constants.SESSIONE_VAR_DOCUMENTO_SELEZIONATO, documentoSelez);

				//				theModel.getSession().put(Constants.SESSIONE_VAR_ID_DOCUMENTO, idDocumentoSelezionato);

				result.setResultCode(VISUALIZZADOCUMENTO_OUTCOME_CODE__OK);
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
	 * ContentPanel cpGestisciReeDocumenti
	 */
	public ExecResults inserisciDocumento(

			it.csi.sigit.sigitwebn.dto.gestisci_ree_documenti.CpGestisciReeDocumentiModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String INSERISCIDOCUMENTO_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String INSERISCIDOCUMENTO_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R792491993) ENABLED START*/
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
	 * ContentPanel cpGestisciReeDocumenti
	 */
	public ExecResults eliminaDocumento(

			it.csi.sigit.sigitwebn.dto.gestisci_ree_documenti.CpGestisciReeDocumentiModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String ELIMINADOCUMENTO_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String ELIMINADOCUMENTO_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R567669791) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			try {

				Integer idADocumentoSelezionato = theModel.getAppDataidDocumentoSelezionato();
				log.debug(" BEPPE ----> ELIMINA DOCUMENTO ------------> idADocumentoSelezionato: "
						+ idADocumentoSelezionato);

				//controllo che abbiano selezionato un allegato
				getValidationMgr().checkSelezioneElemento(ConvertUtil.convertToString(idADocumentoSelezionato));

				if (!GenericUtil.isDocCancellabile(idADocumentoSelezionato, theModel.getAppDataelencoDocumenti())) {
					throw new ValidationManagerException(new Message(Messages.S180));

				}

				//				Ruolo ruoloUtente = theModel.getAppDatautenteLoggato().getRuolo();

				//				DettaglioAllegato dettaglioAllegato = this.getDbMgr()
				//						.getDettaglioAllegatoById(idAllegatoSelezionato);

				//				getValidationMgr().validazioneFormaleEliminaDocumento(idADocumentoSelezionato,
				//						ruoloUtente.getDescRuolo());

				//theModel.setAppDataisAbilitazioneDatiAllegato(false);
				//lo spedisco a una maschera di conferma

				//				Message msg = new Message(Messages.C004);
				//				theModel.setAppDatamessaggioDinamico(msg.getText());

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
	 * Implementazione del metodo tornaPaginaChiamante definito in un ExecCommand del
	 * ContentPanel cpGestisciReeDocumenti
	 */
	public ExecResults tornaPaginaChiamante(

			it.csi.sigit.sigitwebn.dto.gestisci_ree_documenti.CpGestisciReeDocumentiModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String TORNAPAGINACHIAMANTE_OUTCOME_CODE__ELENCO_ALLEGATI_IMPIANTO = //NOSONAR  Reason:EIAS
				"ELENCO_ALLEGATI_IMPIANTO"; //NOSONAR  Reason:EIAS
		final String TORNAPAGINACHIAMANTE_OUTCOME_CODE__RISULTATO_RICERCA_ALLEGATI = //NOSONAR  Reason:EIAS
				"RISULTATO_RICERCA_ALLEGATI"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-582235100) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			result.setResultCode(GenericUtil.gestisciTreeReeIndietro(theModel.getAppDataallegato().getArrivoDa()));

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
	 * Implementazione del metodo chiudiDatiDocumento definito in un ExecCommand del
	 * ContentPanel cpGestisciReeDocumenti
	 */
	public ExecResults chiudiDatiDocumento(

			it.csi.sigit.sigitwebn.dto.gestisci_ree_documenti.CpGestisciReeDocumentiModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String CHIUDIDATIDOCUMENTO_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R1630637866) ENABLED START*/
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
	 * ContentPanel cpGestisciReeDocumenti
	 */
	public ExecResults caricaDocumento(

			it.csi.sigit.sigitwebn.dto.gestisci_ree_documenti.CpGestisciReeDocumentiModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String CARICADOCUMENTO_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String CARICADOCUMENTO_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R1972371893) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			try {

				UtenteLoggato utenteLoggato = theModel.getAppDatautenteLoggato();

				getValidationMgr().validazioneFormaleCaricaDocumentoRee(theModel.getAppDatadocumento());

				DettaglioAllegato allegato = theModel.getAppDataallegato();

				String idAllegato = allegato.getIdAllegato();

				if (log.isDebugEnabled())
					GenericUtil.stampa(allegato, true, 3);

				log.debug("inizio import xml");
				File file = theModel.getWidg_fuUploadDoc();
				if (file == null) {
					throw new ValidationManagerException(new Message("Selezionare un file"));

				} else {

					log.debug("STAMPO LA LUNGHEZZA DEL FILE: " + file.length());
					log.debug("STAMPO Integer.MAX_VALUE: " + Integer.MAX_VALUE);

					log.debug("elaborazione file");
					String nomeFile = theModel.getWidg_fuUploadDocFileName();

					// BEPPE - Ho commentato queste righe di codice perche' ricevo un'eccezione
					// E' da SCOMMENTARE!!!!!
					//if (false) // Questo if non serve, bisogna scommentare quello sopra (2 righe)
					String mimeTypeFile = getSigitMgr().getMimeTypeFile(file);
					if (!getValidationMgr().checkMimeTypeDocumento(mimeTypeFile)) {
						throw new ValidationManagerException(new Message(Messages.S095));
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
					docFilter.setCodImpianto(allegato.getCodiceImpianto());
					docFilter.setIdAllegato(idAllegato);
					docFilter.setContentType(theModel.getWidg_fuUploadDocContentType());
					//					docFilter.setIdTipoDocumento(theModel.getAppDatadocumento().getIdTipoDocumento());
					docFilter.setNomeFile(theModel.getWidg_fuUploadDocFileName());
					docFilter.setDescrizione(theModel.getAppDatadocumento().getDescAltroDoc());

					//					DettaglioIspezione ispezione = theModel.getAppDataidentificativoIspezione();
					//
					//					if (ispezione != null) {
					//						docFilter.setIdImpRuoloPfpg(ispezione.getIdIspezione());
					//					}

					getSigitMgr().inserisciDocumentoAllegato(docFilter, true, utenteLoggato.getCodiceFiscale());

					result.getGlobalMessages().add(Messages.INFO_DOCUMENTO_IMPORTATO_CORRETTAMENTE);

					//theModel.setAppDataaggiornaElencoDocumenti(true);

					// Ricarico i documenti
					caricaElencoDocumenti(theModel);

					result.setResultCode(CARICADOCUMENTO_OUTCOME_CODE__OK);
				}
			} catch (ManagerException ex) {

				//getDbMgr().deleteImportLibretto(idImpianto);

				Validator.gestisciEccezione(result, ex);

			}

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

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
	 * Implementazione del metodo salvaEliminaDocumento definito in un ExecCommand del
	 * ContentPanel cpGestisciReeDocumenti
	 */
	public ExecResults salvaEliminaDocumento(

			it.csi.sigit.sigitwebn.dto.gestisci_ree_documenti.CpGestisciReeDocumentiModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String SALVAELIMINADOCUMENTO_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String SALVAELIMINADOCUMENTO_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R96032746) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			try {
				Integer idDocumentoSelezionato = theModel.getAppDataidDocumentoSelezionato();

				getSigitMgr().eliminaDocumentoAllegato(idDocumentoSelezionato,
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
	 * ContentPanel cpGestisciReeDocumenti
	 */
	public ExecResults isRuoloAbilitato(

			it.csi.sigit.sigitwebn.dto.gestisci_ree_documenti.CpGestisciReeDocumentiModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String ISRUOLOABILITATO_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R655004282) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			UtenteLoggato utente = theModel.getAppDatautenteLoggato();

			if (GenericUtil.isRuoloAbilitatoAccessoDocumentazioneReeWEB(utente)) {
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
	 * ContentPanel cpGestisciReeDocumenti
	 */
	public ExecResults inizializzaElencoDocumenti(

			it.csi.sigit.sigitwebn.dto.gestisci_ree_documenti.CpGestisciReeDocumentiModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String INIZIALIZZAELENCODOCUMENTI_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String INIZIALIZZAELENCODOCUMENTI_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-393801370) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			caricaElencoDocumenti(theModel);

			/*
			if (theModel.getAppDatareeMenuTree() == null) {
				// Vuol dire che NON arrivo dalla modifica REE, quindi NOn devo visualizzare il menu dei REE 
				// Devo settare il menu vuoto
				TreeNode root = new TreeNodeBase("root", "root", false);
				// aggiungo il tree al modello
				theModel.setAppDatareeMenuTree(root);
			}
			*/

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
	 * ContentPanel cpGestisciReeDocumenti
	 */
	public ExecResults gestioneVisBottoniInit(

			it.csi.sigit.sigitwebn.dto.gestisci_ree_documenti.CpGestisciReeDocumentiModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GESTIONEVISBOTTONIINIT_OUTCOME_CODE__VISUALIZZA = //NOSONAR  Reason:EIAS
				"VISUALIZZA"; //NOSONAR  Reason:EIAS
		final String GESTIONEVISBOTTONIINIT_OUTCOME_CODE__NASCONDI = //NOSONAR  Reason:EIAS
				"NASCONDI"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-307937735) ENABLED START*/
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
	 * ContentPanel cpGestisciReeDocumenti
	 */
	public ExecResults isVisualizzaBtnVisualizzaDoc(

			it.csi.sigit.sigitwebn.dto.gestisci_ree_documenti.CpGestisciReeDocumentiModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String ISVISUALIZZABTNVISUALIZZADOC_OUTCOME_CODE__SI = //NOSONAR  Reason:EIAS
				"SI"; //NOSONAR  Reason:EIAS
		final String ISVISUALIZZABTNVISUALIZZADOC_OUTCOME_CODE__NO = //NOSONAR  Reason:EIAS
				"NO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-219744068) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

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
	 * ContentPanel cpGestisciReeDocumenti
	 */
	public ExecResults isVisualizzaBtnEliminaDoc(

			it.csi.sigit.sigitwebn.dto.gestisci_ree_documenti.CpGestisciReeDocumentiModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String ISVISUALIZZABTNELIMINADOC_OUTCOME_CODE__SI = //NOSONAR  Reason:EIAS
				"SI"; //NOSONAR  Reason:EIAS
		final String ISVISUALIZZABTNELIMINADOC_OUTCOME_CODE__NO = //NOSONAR  Reason:EIAS
				"NO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R360383733) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			UtenteLoggato utente = theModel.getAppDatautenteLoggato();

			if (GenericUtil.isUtenteAbilitatoModRee(utente)) {
				result.setResultCode(ISVISUALIZZABTNELIMINADOC_OUTCOME_CODE__SI);
			} else {
				// impostazione del result code 
				result.setResultCode(ISVISUALIZZABTNELIMINADOC_OUTCOME_CODE__NO);
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
	 * ContentPanel cpGestisciReeDocumenti
	 */
	public ExecResults isVisualizzaBtnInserisciDoc(

			it.csi.sigit.sigitwebn.dto.gestisci_ree_documenti.CpGestisciReeDocumentiModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String ISVISUALIZZABTNINSERISCIDOC_OUTCOME_CODE__SI = //NOSONAR  Reason:EIAS
				"SI"; //NOSONAR  Reason:EIAS
		final String ISVISUALIZZABTNINSERISCIDOC_OUTCOME_CODE__NO = //NOSONAR  Reason:EIAS
				"NO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-1526997585) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			UtenteLoggato utente = theModel.getAppDatautenteLoggato();

			if (GenericUtil.isUtenteAbilitatoModRee(utente)) {
				result.setResultCode(ISVISUALIZZABTNINSERISCIDOC_OUTCOME_CODE__SI);
			} else {
				// impostazione del result code 
				result.setResultCode(ISVISUALIZZABTNINSERISCIDOC_OUTCOME_CODE__NO);
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
	 * Implementazione del metodo caricaMenuTipo definito in un ExecCommand del
	 * ContentPanel cpGestisciReeDocumenti
	 */
	public ExecResults caricaMenuTipo(

			it.csi.sigit.sigitwebn.dto.gestisci_ree_documenti.CpGestisciReeDocumentiModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String CARICAMENUTIPO_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-478436164) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			DettaglioAllegato allegato = theModel.getAppDataallegato();

			//theModel.getAppDatareeTipo1();

			//<s:if test="%{appDataallegato != null && appDataallegato.idStatoRapporto == 0}">

			if (log.isDebugEnabled())
				GenericUtil.stampa(allegato, true, 3);

			if (theModel.getAppDatareeMenuTree() == null) {

				// creo il nodo root del tree
				TreeNode root = new TreeNodeBase("root", "root", false);

				// Creo l'alberatura solo se sono in BOZZA
				if (allegato.getIdStatoRapporto().intValue() == Constants.ID_STATO_RAPPORTO_BOZZA) {
					// Devo capire che tipo di REE e' stato selezionato
					int idTipoDoc = ConvertUtil.convertToInteger(allegato.getIdTipoAllegato());

					String idTipo = null;
					String tipoComp = null;
					String prefixNodo = null;

					if (allegato.getIdTipoAllegato().equals(Constants.ALLEGATO_TIPO_1)
							|| allegato.getIdTipoAllegato().equals(Constants.ALLEGATO_TIPO_1B)) {
						idTipo = "1";
						tipoComp = Constants.TIPO_COMPONENTE_GT;
						prefixNodo = Constants.PREFIX_ID_NODO_TIPO_1_E;
					} else if (allegato.getIdTipoAllegato().equals(Constants.ALLEGATO_TIPO_2)) {
						idTipo = "2";
						tipoComp = Constants.TIPO_COMPONENTE_GF;
						prefixNodo = Constants.PREFIX_ID_NODO_TIPO_2_E;
					} else if (allegato.getIdTipoAllegato().equals(Constants.ALLEGATO_TIPO_3)) {
						idTipo = "3";
						tipoComp = Constants.TIPO_COMPONENTE_SC;
						prefixNodo = Constants.PREFIX_ID_NODO_TIPO_3_E;
					} else if (allegato.getIdTipoAllegato().equals(Constants.ALLEGATO_TIPO_4)) {
						idTipo = "4";
						tipoComp = Constants.TIPO_COMPONENTE_CG;
						prefixNodo = Constants.PREFIX_ID_NODO_TIPO_4_E;
					}

					// Aggiungo la cartella "Libretto"
					String librettoNodeId = "R-tipo" + idTipo;
					TreeNodeBase libNode = new TreeNodeBase(librettoNodeId,
							"REE Rapporto di Efficienza Energetica Tipo " + idTipo, false);
					libNode.setOpened(true);
					root.getChildren().add(libNode);

					/////////////////////////////////////////////////////
					// REE tipo 1

					// Aggiungo la sottoscheda (foglio)
					TreeNodeBase sottoSchedaNode = new TreeNodeBase("F-tipo" + idTipo, Constants.LABEL_SEZIONE_ABCDF,
							true);
					root.getChildren(librettoNodeId).getChildren().add(sottoSchedaNode);
					//allegato.getElencoApparecchiature()
					// Devo ciclare per tutte le componenti selezionate
					List<String> idCompProgressiviList = allegato.getIdApparecchiatureFunz();
					for (String idCompProgressivo : idCompProgressiviList) {
						//					sottoSchedaNode = new TreeNodeBase(Constants.PREFIX_ID_NODO_TIPO_1_E + idCompProgressivo,
						//							Constants.LABEL_SEZIONE_E + " - " + Constants.TIPO_COMPONENTE_GT + "-" + idCompProgressivo, true);

						sottoSchedaNode = new TreeNodeBase(prefixNodo + idCompProgressivo,
								GenericUtil.getDescSezioneEComp(tipoComp, idCompProgressivo), true);

						root.getChildren(librettoNodeId).getChildren().add(sottoSchedaNode);
					}

					// Setto la pagina in cui sto andando, mi servirà nel caso ci sia necessità di ricaricare la pagina con un messaggio (es. invia allegato)
					theModel.getSession().put(Constants.SESSIONE_VAR_ALLEGATO_SEZIONE, "SEZIONE_ABCDF");

				}

				// aggiungo il tree al modello
				theModel.setAppDatareeMenuTree(root);

			}

			// impostazione del result code 
			result.setResultCode(CARICAMENUTIPO_OUTCOME_CODE__OK);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::caricaMenuTipo] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo aggiornaDatiPagina definito in un ExecCommand del
	 * ContentPanel cpGestisciReeDocumenti
	 */
	public ExecResults aggiornaDatiPagina(

			it.csi.sigit.sigitwebn.dto.gestisci_ree_documenti.CpGestisciReeDocumentiModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String AGGIORNADATIPAGINA_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String AGGIORNADATIPAGINA_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-1534246548) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			try {

				/*
				result.setResultCode(AGGIORNADATIPAGINA_OUTCOME_CODE__KO);
				Message msg = (Message) theModel.getSession().get(Constants.SESSIONE_VAR_MESSAGGE);
				if (msg != null) {
					if (msg.getType() == Message.ERROR)
						result.getGlobalErrors().add(msg.getText());
					else
						result.getGlobalMessages().add(msg.getText());
				
					theModel.getSession().remove(Constants.SESSIONE_VAR_MESSAGGE);
				}
				*/
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
	 * ContentPanel cpGestisciReeDocumenti
	 */
	public ExecResults gestioneVisBottoniRef(

			it.csi.sigit.sigitwebn.dto.gestisci_ree_documenti.CpGestisciReeDocumentiModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GESTIONEVISBOTTONIREF_OUTCOME_CODE__VISUALIZZA = //NOSONAR  Reason:EIAS
				"VISUALIZZA"; //NOSONAR  Reason:EIAS
		final String GESTIONEVISBOTTONIREF_OUTCOME_CODE__NASCONDI = //NOSONAR  Reason:EIAS
				"NASCONDI"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R1763687420) ENABLED START*/
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
	 * Implementazione del metodo gestisciMsg definito in un ExecCommand del
	 * ContentPanel cpGestisciReeDocumenti
	 */
	public ExecResults gestisciMsg(

			it.csi.sigit.sigitwebn.dto.gestisci_ree_documenti.CpGestisciReeDocumentiModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GESTISCIMSG_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-713937564) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			GenericUtil.gestisciMessaggioSessione(theModel, result);

			// impostazione del result code 
			result.setResultCode(GESTISCIMSG_OUTCOME_CODE__OK);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::gestisciMsg] Errore occorso nell'esecuzione del metodo:" + e, e);
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
		session.put("cpGestisciReeDocumenti_tblElencoDocumenti_clearStatus", Boolean.TRUE);
	}

	//////////////////////////////////////////////////////////////////////////////
	/// Property aggiuntive del bean
	//////////////////////////////////////////////////////////////////////////////
	/*PROTECTED REGION ID(R-71588421) ENABLED START*/
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
			it.csi.sigit.sigitwebn.dto.gestisci_ree_documenti.CpGestisciReeDocumentiModel theModel)
			throws ManagerException {

		try {
			log.debug("Carico l'elenco dei documenti");

			DettaglioAllegato allegato = theModel.getAppDataallegato();

			String idAllegato = allegato.getIdAllegato();

			log.debug("caricaElencoDocumenti - idAllegato: " + idAllegato);

			ArrayList<Documento> documenti;

			documenti = getSigitMgr().cercaDocumentiPerIdAllegato(idAllegato);

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

	/*PROTECTED REGION END*/
}
