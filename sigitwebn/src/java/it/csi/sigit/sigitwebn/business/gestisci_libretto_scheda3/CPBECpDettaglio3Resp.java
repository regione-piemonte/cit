package it.csi.sigit.sigitwebn.business.gestisci_libretto_scheda3;

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

/*PROTECTED REGION ID(R974382764) ENABLED START*/
import it.csi.sigit.sigitwebn.business.manager.util.Message;
import it.csi.sigit.sigitwebn.business.manager.util.ValidationManagerException;
import it.csi.sigit.sigitwebn.business.manager.ConnectorMgr;
import it.csi.sigit.sigitwebn.business.manager.DbMgr;
import it.csi.sigit.sigitwebn.business.manager.SigitMgr;
import it.csi.sigit.sigitwebn.business.manager.ValidationMgr;
import org.apache.log4j.*;
import it.csi.sigit.sigitwebn.util.*;
import it.csi.sigit.sigitwebn.business.*;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.SigitRContr2019AutodichiarByExampleExtendedDto;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.SigitVRicerca3ResponsabileByFkPgPfRowDto;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.filter.DocumentoContrattoDto;
import it.csi.sigit.sigitwebn.business.manager.util.ManagerException;

import java.io.File;
import java.util.*;
/*PROTECTED REGION END*/

public class CPBECpDettaglio3Resp {

	/**  */
	protected static final Logger log = //NOSONAR  Reason:EIAS 
			Logger.getLogger(Constants.APPLICATION_CODE + ".business"); //NOSONAR  Reason:EIAS

	//////////////////////////////////////////////////////////////////////////////
	/// Costanti identificative degli Application Data
	//////////////////////////////////////////////////////////////////////////////

	// ApplicationData: [utenteLoggato, scope:USER_SESSION]
	public static final String APPDATA_UTENTELOGGATO_CODE = "appDatautenteLoggato";

	// ApplicationData: [messaggioDinamico, scope:USER_SESSION]
	public static final String APPDATA_MESSAGGIODINAMICO_CODE = "appDatamessaggioDinamico";

	// ApplicationData: [paginaChiamante, scope:USER_SESSION]
	public static final String APPDATA_PAGINACHIAMANTE_CODE = "appDatapaginaChiamante";

	// ApplicationData: [librettoMenuTree, scope:USER_SESSION]
	public static final String APPDATA_LIBRETTOMENUTREE_CODE = "appDatalibrettoMenuTree";

	// ApplicationData: [identificativoImpianto, scope:USER_SESSION]
	public static final String APPDATA_IDENTIFICATIVOIMPIANTO_CODE = "appDataidentificativoImpianto";

	// ApplicationData: [elencoIdSelezionati, scope:USER_ACTION]
	public static final String APPDATA_ELENCOIDSELEZIONATI_CODE = "appDataelencoIdSelezionati";

	// ApplicationData: [elencoAutodichiarazioni, scope:USER_SESSION]
	public static final String APPDATA_ELENCOAUTODICHIARAZIONI_CODE = "appDataelencoAutodichiarazioni";

	// ApplicationData: [idContrattoSelez, scope:USER_SESSION]
	public static final String APPDATA_IDCONTRATTOSELEZ_CODE = "appDataidContrattoSelez";

	// ApplicationData: [idDocContrattoSelez, scope:USER_SESSION]
	public static final String APPDATA_IDDOCCONTRATTOSELEZ_CODE = "appDataidDocContrattoSelez";

	// ApplicationData: [elencoDocContratti, scope:USER_SESSION]
	public static final String APPDATA_ELENCODOCCONTRATTI_CODE = "appDataelencoDocContratti";

	// ApplicationData: [dettaglioTerzoResponsabile, scope:USER_SESSION]
	public static final String APPDATA_DETTAGLIOTERZORESPONSABILE_CODE = "appDatadettaglioTerzoResponsabile";

	// ApplicationData: [nuovoDocContratto, scope:USER_SESSION]
	public static final String APPDATA_NUOVODOCCONTRATTO_CODE = "appDatanuovoDocContratto";

	// ApplicationData: [prorogaTerzoResponsabile, scope:USER_SESSION]
	public static final String APPDATA_PROROGATERZORESPONSABILE_CODE = "appDataprorogaTerzoResponsabile";

	//////////////////////////////////////////////////////////////////////////////
	/// Metodi associati alla U.I.
	//////////////////////////////////////////////////////////////////////////////

	// nome del content panel associato al bean
	public static final String CPNAME = "cpDettaglio3Resp";

	public static final String MULTIPANEL_MPPROROGA = "mpProroga";
	public static final String MPI_MPPROROGA_FPPROROGA = CPNAME + "_" + MULTIPANEL_MPPROROGA + "_" + "fpProroga";

	public static final String MULTIPANEL_MPINSERIMENTODOCUMENTO = "mpInserimentoDocumento";
	public static final String MPI_MPINSERIMENTODOCUMENTO_FPINSDOCUMENTO = CPNAME + "_"
			+ MULTIPANEL_MPINSERIMENTODOCUMENTO + "_" + "fpInsDocumento";

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
	 * ContentPanel cpDettaglio3Resp
	 */
	public ExecResults onTreeClick(

			it.csi.sigit.sigitwebn.dto.gestisci_libretto_scheda3.CpDettaglio3RespModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String ONTREECLICK_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String ONTREECLICK_OUTCOME_CODE__SCHEDA1_EXTRA = //NOSONAR  Reason:EIAS
				"SCHEDA1_EXTRA"; //NOSONAR  Reason:EIAS
		final String ONTREECLICK_OUTCOME_CODE__SCHEDA1 = //NOSONAR  Reason:EIAS
				"SCHEDA1"; //NOSONAR  Reason:EIAS
		final String ONTREECLICK_OUTCOME_CODE__SCHEDA2 = //NOSONAR  Reason:EIAS
				"SCHEDA2"; //NOSONAR  Reason:EIAS
		final String ONTREECLICK_OUTCOME_CODE__SCHEDA3 = //NOSONAR  Reason:EIAS
				"SCHEDA3"; //NOSONAR  Reason:EIAS
		final String ONTREECLICK_OUTCOME_CODE__SCHEDA4_1 = //NOSONAR  Reason:EIAS
				"SCHEDA4_1"; //NOSONAR  Reason:EIAS
		final String ONTREECLICK_OUTCOME_CODE__SCHEDA4_2 = //NOSONAR  Reason:EIAS
				"SCHEDA4_2"; //NOSONAR  Reason:EIAS
		final String ONTREECLICK_OUTCOME_CODE__SCHEDA4_3 = //NOSONAR  Reason:EIAS
				"SCHEDA4_3"; //NOSONAR  Reason:EIAS
		final String ONTREECLICK_OUTCOME_CODE__SCHEDA4_4 = //NOSONAR  Reason:EIAS
				"SCHEDA4_4"; //NOSONAR  Reason:EIAS
		final String ONTREECLICK_OUTCOME_CODE__SCHEDA4_5 = //NOSONAR  Reason:EIAS
				"SCHEDA4_5"; //NOSONAR  Reason:EIAS
		final String ONTREECLICK_OUTCOME_CODE__SCHEDA4_6 = //NOSONAR  Reason:EIAS
				"SCHEDA4_6"; //NOSONAR  Reason:EIAS
		final String ONTREECLICK_OUTCOME_CODE__SCHEDA4_7 = //NOSONAR  Reason:EIAS
				"SCHEDA4_7"; //NOSONAR  Reason:EIAS
		final String ONTREECLICK_OUTCOME_CODE__SCHEDA4_8 = //NOSONAR  Reason:EIAS
				"SCHEDA4_8"; //NOSONAR  Reason:EIAS
		final String ONTREECLICK_OUTCOME_CODE__SCHEDA5_1SR = //NOSONAR  Reason:EIAS
				"SCHEDA5_1SR"; //NOSONAR  Reason:EIAS
		final String ONTREECLICK_OUTCOME_CODE__SCHEDA5_1VR = //NOSONAR  Reason:EIAS
				"SCHEDA5_1VR"; //NOSONAR  Reason:EIAS
		final String ONTREECLICK_OUTCOME_CODE__SCHEDA5_2 = //NOSONAR  Reason:EIAS
				"SCHEDA5_2"; //NOSONAR  Reason:EIAS
		final String ONTREECLICK_OUTCOME_CODE__SCHEDA6_4 = //NOSONAR  Reason:EIAS
				"SCHEDA6_4"; //NOSONAR  Reason:EIAS
		final String ONTREECLICK_OUTCOME_CODE__SCHEDA6 = //NOSONAR  Reason:EIAS
				"SCHEDA6"; //NOSONAR  Reason:EIAS
		final String ONTREECLICK_OUTCOME_CODE__SCHEDA7 = //NOSONAR  Reason:EIAS
				"SCHEDA7"; //NOSONAR  Reason:EIAS
		final String ONTREECLICK_OUTCOME_CODE__SCHEDA8 = //NOSONAR  Reason:EIAS
				"SCHEDA8"; //NOSONAR  Reason:EIAS
		final String ONTREECLICK_OUTCOME_CODE__SCHEDA9_1 = //NOSONAR  Reason:EIAS
				"SCHEDA9_1"; //NOSONAR  Reason:EIAS
		final String ONTREECLICK_OUTCOME_CODE__SCHEDA9_2 = //NOSONAR  Reason:EIAS
				"SCHEDA9_2"; //NOSONAR  Reason:EIAS
		final String ONTREECLICK_OUTCOME_CODE__SCHEDA9_3 = //NOSONAR  Reason:EIAS
				"SCHEDA9_3"; //NOSONAR  Reason:EIAS
		final String ONTREECLICK_OUTCOME_CODE__SCHEDA9_4 = //NOSONAR  Reason:EIAS
				"SCHEDA9_4"; //NOSONAR  Reason:EIAS
		final String ONTREECLICK_OUTCOME_CODE__SCHEDA9_5 = //NOSONAR  Reason:EIAS
				"SCHEDA9_5"; //NOSONAR  Reason:EIAS
		final String ONTREECLICK_OUTCOME_CODE__SCHEDA9_6 = //NOSONAR  Reason:EIAS
				"SCHEDA9_6"; //NOSONAR  Reason:EIAS
		final String ONTREECLICK_OUTCOME_CODE__SCHEDA10 = //NOSONAR  Reason:EIAS
				"SCHEDA10"; //NOSONAR  Reason:EIAS
		final String ONTREECLICK_OUTCOME_CODE__SCHEDA12 = //NOSONAR  Reason:EIAS
				"SCHEDA12"; //NOSONAR  Reason:EIAS
		final String ONTREECLICK_OUTCOME_CODE__SCHEDA13 = //NOSONAR  Reason:EIAS
				"SCHEDA13"; //NOSONAR  Reason:EIAS
		final String ONTREECLICK_OUTCOME_CODE__SCHEDA14_1 = //NOSONAR  Reason:EIAS
				"SCHEDA14_1"; //NOSONAR  Reason:EIAS
		final String ONTREECLICK_OUTCOME_CODE__SCHEDA14_2 = //NOSONAR  Reason:EIAS
				"SCHEDA14_2"; //NOSONAR  Reason:EIAS
		final String ONTREECLICK_OUTCOME_CODE__SCHEDA14_3 = //NOSONAR  Reason:EIAS
				"SCHEDA14_3"; //NOSONAR  Reason:EIAS
		final String ONTREECLICK_OUTCOME_CODE__SCHEDA14_4 = //NOSONAR  Reason:EIAS
				"SCHEDA14_4"; //NOSONAR  Reason:EIAS
		final String ONTREECLICK_OUTCOME_CODE__SCHEDA15 = //NOSONAR  Reason:EIAS
				"SCHEDA15"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-489614690) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			result.setResultCode(
					GenericUtil.gestisciTreeClick(theModel.getIdNodo(), theModel.getAppDatalibrettoMenuTree()));

			// Setto la pagina in cui sto andando, mi servir� nel caso ci sia necessit� di ricaricare la pagina con un messaggio (es. consolida libretto)
			theModel.getSession().put(Constants.SESSIONE_VAR_LIBRETTO_SCHEDA, result.getResultCode());

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
	 * Implementazione del metodo prorogaTerzaResp definito in un ExecCommand del
	 * ContentPanel cpDettaglio3Resp
	 */
	public ExecResults prorogaTerzaResp(

			it.csi.sigit.sigitwebn.dto.gestisci_libretto_scheda3.CpDettaglio3RespModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String PROROGATERZARESP_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		final String PROROGATERZARESP_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R1126003643) ENABLED START*/

			try {
				getValidationMgr().validazioneFormaleProrogaPre(theModel.getAppDatadettaglioTerzoResponsabile(),
						theModel.getAppDatautenteLoggato());

				theModel.setAppDataprorogaTerzoResponsabile(new ProrogaTerzoResponsabile());

				result.setResultCode(PROROGATERZARESP_OUTCOME_CODE__OK);

			} catch (ManagerException ex) {

				Validator.gestisciEccezione(result, ex);

			}

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::prorogaTerzaResp] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo prorogaContratto definito in un ExecCommand del
	 * ContentPanel cpDettaglio3Resp
	 */
	public ExecResults prorogaContratto(

			it.csi.sigit.sigitwebn.dto.gestisci_libretto_scheda3.CpDettaglio3RespModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String PROROGACONTRATTO_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String PROROGACONTRATTO_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R715428613) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			try {
				DettaglioTerzoResponsabile dettaglioResp = theModel.getAppDatadettaglioTerzoResponsabile();
				ProrogaTerzoResponsabile proroga = theModel.getAppDataprorogaTerzoResponsabile();

				getValidationMgr().validazioneFormaleProrogaPost(proroga, dettaglioResp);
				//						dettaglioResp.getDataFineContratto(), dettaglioResp.getDataRevoca());

				//dopo la validazione sintattica segue il controllo sulla presenza degli allegati + presenza di altri contratti
				Integer contaREEInviati = getSigitMgr().verificaREENomina3Resp(dettaglioResp.getCodImpianto(),
						dettaglioResp.getDataFineContratto(), proroga.getDataFineContratto());

				// Questo meccanismo va bene in caso di primo aricamento, ma nel caso di proroga devo fare la verifica dalla vecchia data fine contratto alla nuova data fine contratto 
				//				Integer contaREEInviati = getSigitMgr().verificaREENomina3Resp(dettaglioResp.getCodImpianto(),
				//						dettaglioResp.getDataInizioContratto(), proroga.getDataFineContratto());

				if (contaREEInviati > 0) {
					throw new ValidationManagerException(new Message(Messages.ERRORE_PRESENZA_REE_INVIATI));
				}

				//presenza di altri contratti?
				SigitVRicerca3ResponsabileByFkPgPfRowDto terzoRespAttivo = getSigitMgr().contaContratti2019ByFilter(
						proroga.getFlgTacitoRinnovo(), dettaglioResp.getCodImpianto(),
						dettaglioResp.getDataInizioContratto(), proroga.getDataFineContratto(),
						dettaglioResp.getIdContratto());

				if (terzoRespAttivo != null && terzoRespAttivo.getDataInizioContratto() != null) {
					throw new ValidationManagerException(new Message(Messages.S090));
				}

				//se tutti i controlli sono andati a buon fine si passa alla parte di salvataggio
				//viene invocato prima un metodo per salvare i dati in SIGIT_T_AZIONE_COTRATTO ( con descrizione Proroga nomina terza responsabilit� impianto [codice_impianto])
				//e per sostituire le informazioni sulla tabella CONTRATTO_2019
				//viene poi invocato un secondo metodo per l'invio della mail al terzo responsabile e al responsabile dell'impianto
				String infoEmail = getConnectorMgr().proroga3Responsabile2019(dettaglioResp, proroga,
						theModel.getAppDatautenteLoggato());

				dettaglioResp.setDataFineContratto(ReplaceSpecialCharUtils.sanitize(proroga.getDataFineContratto()));
				dettaglioResp.setDescTacitoRinnovo(ConvertUtil.convertToBooleanAllways(proroga.getFlgTacitoRinnovo())
						? Constants.LABEL_SI
						: Constants.LABEL_NO);
				theModel.setAppDatadettaglioTerzoResponsabile(dettaglioResp);

				StringBuffer msgFinal = new StringBuffer();
				msgFinal.append(Messages.INFO_SALVATAGGIO_CORRETTO);
				msgFinal.append(Constants.VALUE_ENTER_HTML);
				msgFinal.append(infoEmail);

				result.getGlobalMessages().add(msgFinal.toString());

				result.setResultCode(PROROGACONTRATTO_OUTCOME_CODE__OK);
			} catch (ManagerException ex) {

				Validator.gestisciEccezione(result, ex);

			}
			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::prorogaContratto] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo gestisciChiudiProroga definito in un ExecCommand del
	 * ContentPanel cpDettaglio3Resp
	 */
	public ExecResults gestisciChiudiProroga(

			it.csi.sigit.sigitwebn.dto.gestisci_libretto_scheda3.CpDettaglio3RespModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GESTISCICHIUDIPROROGA_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String GESTISCICHIUDIPROROGA_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-1854059318) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			// impostazione del result code 
			result.setResultCode(GESTISCICHIUDIPROROGA_OUTCOME_CODE__OK);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::gestisciChiudiProroga] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo visualizzaDocumento definito in un ExecCommand del
	 * ContentPanel cpDettaglio3Resp
	 */
	public ExecResults visualizzaDocumento(

			it.csi.sigit.sigitwebn.dto.gestisci_libretto_scheda3.CpDettaglio3RespModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String VISUALIZZADOCUMENTO_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String VISUALIZZADOCUMENTO_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-2060044435) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:
			try {
				Integer idDocumentoSelezionato = theModel.getAppDataidDocContrattoSelez();

				log.debug(" DOCUMENTI ----> VISUALIZZA DOCUMENTO ------------> idDocumentoSelezionato: "
						+ idDocumentoSelezionato);

				//se non lo hanno selezionato questo metodo mi blocca
				getValidationMgr().checkSelezioneElemento(ConvertUtil.convertToString(idDocumentoSelezionato));

				//dalla lista di documenti mi recupero le informazioni per il download
				for (DocContratto docInLista : theModel.getAppDataelencoDocContratti()) {
					if (docInLista.getIdDocContratto().equals(idDocumentoSelezionato)) {
						Documento documentoInSessione = new Documento();
						documentoInSessione.setUidIndex(ReplaceSpecialCharUtils.sanitize(docInLista.getUidIndex()));
						documentoInSessione.setNomeDocOrig(ReplaceSpecialCharUtils.sanitize(docInLista.getNomeDocumento()));
						theModel.getSession().put(Constants.SESSIONE_VAR_DOCUMENTO_SELEZIONATO, documentoInSessione);

						break;
					}
				}

				// impostazione del result code 
				result.setResultCode(VISUALIZZADOCUMENTO_OUTCOME_CODE__OK);

			} catch (ManagerException ex) {

				Validator.gestisciEccezione(result, ex);
			}

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
	 * ContentPanel cpDettaglio3Resp
	 */
	public ExecResults inserisciDocumento(

			it.csi.sigit.sigitwebn.dto.gestisci_libretto_scheda3.CpDettaglio3RespModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String INSERISCIDOCUMENTO_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String INSERISCIDOCUMENTO_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R852104998) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			try {
				DettaglioTerzoResponsabile dettaglioResp = theModel.getAppDatadettaglioTerzoResponsabile();

				UtenteLoggato utente = theModel.getAppDatautenteLoggato();

				if (utente.getRuolo().getDescRuolo().equalsIgnoreCase(Constants.RUOLO_3RESPONSABILE)
						&& !utente.getRuolo().getCodiceFiscale().equalsIgnoreCase(dettaglioResp.getCodiceFiscale())) {
					throw new ValidationManagerException(new Message(Messages.ERROR_CONTRATTO_NO_COMPETENZA));
				}

				// impostazione del result code 
				result.setResultCode(INSERISCIDOCUMENTO_OUTCOME_CODE__OK);
			} catch (ManagerException ex) {

				Validator.gestisciEccezione(result, ex);
			}

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
	 * ContentPanel cpDettaglio3Resp
	 */
	public ExecResults eliminaDocumento(

			it.csi.sigit.sigitwebn.dto.gestisci_libretto_scheda3.CpDettaglio3RespModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String ELIMINADOCUMENTO_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String ELIMINADOCUMENTO_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R250413740) ENABLED START*/
			try {
				Integer idADocumentoSelezionato = theModel.getAppDataidDocContrattoSelez();
				log.debug(" BEPPE ----> ELIMINA DOCUMENTO ------------> idADocumentoSelezionato: "
						+ idADocumentoSelezionato);

				//controllo che abbiano selezionato un allegato
				getValidationMgr().checkSelezioneElemento(ConvertUtil.convertToString(idADocumentoSelezionato));

				DettaglioTerzoResponsabile dettaglioResp = theModel.getAppDatadettaglioTerzoResponsabile();

				UtenteLoggato utente = theModel.getAppDatautenteLoggato();

				if (utente.getRuolo().getDescRuolo().equalsIgnoreCase(Constants.RUOLO_3RESPONSABILE)
						&& !utente.getRuolo().getCodiceFiscale().equalsIgnoreCase(dettaglioResp.getCodiceFiscale())) {
					throw new ValidationManagerException(new Message(Messages.ERROR_CONTRATTO_NO_COMPETENZA));
				}

				getSigitMgr().eliminaDocContratto(utente.getCodiceFiscale(), idADocumentoSelezionato);

				//viene ricaricata la lista per aggiornare la tabella
				theModel.setAppDataelencoDocContratti((ArrayList<DocContratto>) getSigitMgr()
						.recuperaDocContratti(theModel.getAppDataidContrattoSelez()));

				result.setResultCode(ELIMINADOCUMENTO_OUTCOME_CODE__OK);
			} catch (ManagerException ex) {

				Validator.gestisciEccezione(result, ex);
				//result.setResultCode(ELIMINADOCUMENTO_OUTCOME_CODE__KO);
			}

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
	 * Implementazione del metodo uploadFile definito in un ExecCommand del
	 * ContentPanel cpDettaglio3Resp
	 */
	public ExecResults uploadFile(

			it.csi.sigit.sigitwebn.dto.gestisci_libretto_scheda3.CpDettaglio3RespModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String UPLOADFILE_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String UPLOADFILE_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R586010578) ENABLED START*/
			log.debug("inizio upload file");
			try {
				if (GenericUtil.isNullOrEmpty(theModel.getAppDatanuovoDocContratto().getDescrizione())) {
					//la descrizione e' obbligatoria
					ValidationManagerException ex = new ValidationManagerException();
					ex.addFieldRequired(APPDATA_NUOVODOCCONTRATTO_CODE + ".descrizione");
					throw ex;
				} else {
					
					DettaglioTerzoResponsabile dettaglioResp = theModel.getAppDatadettaglioTerzoResponsabile();
					
					DocumentoContrattoDto docFilter = new DocumentoContrattoDto();
					docFilter.setCodImpianto(dettaglioResp.getCodImpianto());
					docFilter.setDescrizione(ReplaceSpecialCharUtils.sanitize(
							theModel.getAppDatanuovoDocContratto().getDescrizione()));

					File file = theModel.getWidg_fuUpload();
					if (file != null) {
						log.debug("elaborazione file");
						String nomeFile = theModel.getWidg_fuUploadFileName();
						String contType = theModel.getWidg_fuUploadContentType();
						String mimeTypeFile = getSigitMgr().getMimeTypeFile(file);

						if (!getValidationMgr().checkMimeTypeDocumento(mimeTypeFile)) {
							throw new ValidationManagerException(new Message(Messages.S095));
						} else if (nomeFile.length() > Constants.MAX_NOME_FILE_LEN) {
							throw new ValidationManagerException(new Message(Messages.S160,
									ConvertUtil.convertToString(Constants.MAX_NOME_FILE_LEN)));

						}

						Integer maxMB = getDbMgr().cercaConfigValueNumerico(Constants.MAX_MB_DOC);
						Integer maxByte = GenericUtil.getByteToMb(maxMB);

						if (file.length() > maxByte) {
							throw new ValidationManagerException(
									new Message(Messages.S156, ConvertUtil.convertToString(maxMB)));
						}

						docFilter.setContentType(ReplaceSpecialCharUtils.sanitize(contType));
						docFilter.setFile(file);
						docFilter.setNomeFile(ReplaceSpecialCharUtils.sanitize(nomeFile));

					}

					//il doc contratto viene inserito sempre per via della descrizione
					DocContratto documentoAggiunto = getSigitMgr().inserisciDocContratto(
							theModel.getAppDataidContrattoSelez(), docFilter, theModel.getAppDatautenteLoggato());

					if (theModel.getAppDataelencoDocContratti() == null) {
						theModel.setAppDataelencoDocContratti(new ArrayList<DocContratto>());
					}

					theModel.getAppDataelencoDocContratti().add(documentoAggiunto);

					theModel.getSession().put(Constants.SESSIONE_VAR_MESSAGGE,
							new Message(Messages.INFO_DOCUMENTO_IMPORTATO_CORRETTAMENTE, Message.INFO));

					result.setResultCode(UPLOADFILE_OUTCOME_CODE__OK);

				}
			} catch (ManagerException ex) {

				Validator.gestisciEccezione(result, ex);

			}

			result.setModel(theModel);
			return result;

			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::uploadFile] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo gestisciChiudi definito in un ExecCommand del
	 * ContentPanel cpDettaglio3Resp
	 */
	public ExecResults gestisciChiudi(

			it.csi.sigit.sigitwebn.dto.gestisci_libretto_scheda3.CpDettaglio3RespModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GESTISCICHIUDI_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String GESTISCICHIUDI_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R785567146) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:
			theModel.setAppDatanuovoDocContratto(null);

			// impostazione del result code 
			result.setResultCode(GESTISCICHIUDI_OUTCOME_CODE__OK);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::gestisciChiudi] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo gestisciIndietroDettaglio3Resp definito in un ExecCommand del
	 * ContentPanel cpDettaglio3Resp
	 */
	public ExecResults gestisciIndietroDettaglio3Resp(

			it.csi.sigit.sigitwebn.dto.gestisci_libretto_scheda3.CpDettaglio3RespModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GESTISCIINDIETRODETTAGLIO3RESP_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String GESTISCIINDIETRODETTAGLIO3RESP_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-716812782) ENABLED START*/
			// impostazione del result code 
			result.setResultCode(GESTISCIINDIETRODETTAGLIO3RESP_OUTCOME_CODE__OK);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::gestisciIndietroDettaglio3Resp] Errore occorso nell'esecuzione del metodo:" + e,
					e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo isRuoloAbilitato definito in un ExecCommand del
	 * ContentPanel cpDettaglio3Resp
	 */
	public ExecResults isRuoloAbilitato(

			it.csi.sigit.sigitwebn.dto.gestisci_libretto_scheda3.CpDettaglio3RespModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String ISRUOLOABILITATO_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R337748231) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			UtenteLoggato utente = theModel.getAppDatautenteLoggato();

			if (GenericUtil.isUtenteAutorLibWebScheda3(utente)) {
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
	 * Implementazione del metodo caricaDettaglio3Resp definito in un ExecCommand del
	 * ContentPanel cpDettaglio3Resp
	 */
	public ExecResults caricaDettaglio3Resp(

			it.csi.sigit.sigitwebn.dto.gestisci_libretto_scheda3.CpDettaglio3RespModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String CARICADETTAGLIO3RESP_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String CARICADETTAGLIO3RESP_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R978051044) ENABLED START*/
			try {
				Integer idContrattoSelez = theModel.getAppDataidContrattoSelez();
				//dettaglio caricato dalla scheda 3
				DettaglioTerzoResponsabile dettaglioInElenco = theModel.getAppDatadettaglioTerzoResponsabile();
				//vengono recuperate le autodichiarazioni del contratto

				//settaggio dell'elenco delle autodichiarazioni di nomina
				List<SigitRContr2019AutodichiarByExampleExtendedDto> listaAutodichiarazioni = getDbMgr()
						.cercaListaAutodichiarazioniContrattoExended(idContrattoSelez, null, "N");
				String autodichiarazioneString = "";
				if (listaAutodichiarazioni != null && listaAutodichiarazioni.size() > 0) {
					for (SigitRContr2019AutodichiarByExampleExtendedDto autodichiarazione : listaAutodichiarazioni) {
						autodichiarazioneString += autodichiarazione.getDesAutodichiarazione() + "\n";
					}
				}

				dettaglioInElenco.setElencoAutodichiarazioni(autodichiarazioneString);

				//settaggio dell'elenco delle autodichiarazioni di cessazione
				listaAutodichiarazioni = getDbMgr().cercaListaAutodichiarazioniContrattoExended(idContrattoSelez, null,
						"C");
				autodichiarazioneString = "";
				if (listaAutodichiarazioni != null && listaAutodichiarazioni.size() > 0) {
					for (SigitRContr2019AutodichiarByExampleExtendedDto autodichiarazione : listaAutodichiarazioni) {
						autodichiarazioneString += autodichiarazione.getDesAutodichiarazione() + "\n";
					}
				}

				dettaglioInElenco.setElencoAutodichiarazioniDecadenza(autodichiarazioneString);

				//vengono caricati i documenti mostrati in tabella
				theModel.setAppDataelencoDocContratti(
						(ArrayList<DocContratto>) getSigitMgr().recuperaDocContratti(idContrattoSelez));

			} catch (ManagerException ex) {
				Validator.gestisciEccezione(result, ex);
			}

			// impostazione del result code 
			result.setResultCode(CARICADETTAGLIO3RESP_OUTCOME_CODE__OK);

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::caricaDettaglio3Resp] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo isDecadenza definito in un ExecCommand del
	 * ContentPanel cpDettaglio3Resp
	 */
	public ExecResults isDecadenza(

			it.csi.sigit.sigitwebn.dto.gestisci_libretto_scheda3.CpDettaglio3RespModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String ISDECADENZA_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String ISDECADENZA_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-472762530) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			DettaglioTerzoResponsabile dettaglioInElenco = theModel.getAppDatadettaglioTerzoResponsabile();

			if (Constants.ID_TIPO_CESSAZIONE_DECADENZA.equals(dettaglioInElenco.getIdTipoCessazione())) {
				// impostazione del result code 
				result.setResultCode(ISDECADENZA_OUTCOME_CODE__OK);
			} else {
				// impostazione del result code 
				result.setResultCode(ISDECADENZA_OUTCOME_CODE__KO);
			}

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::isDecadenza] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	//////////////////////////////////////////////////////////////////////////////
	/// Metodi statici per il reset delle tabelle
	//////////////////////////////////////////////////////////////////////////////

	/**
	 * permette di resettare lo stato di paginazione della tabella widg_tbDocContratti
	 */
	public static void resetClearStatus_widg_tbDocContratti(java.util.Map session) {
		session.put("cpDettaglio3Resp_tbDocContratti_clearStatus", Boolean.TRUE);
	}

	//////////////////////////////////////////////////////////////////////////////
	/// Property aggiuntive del bean
	//////////////////////////////////////////////////////////////////////////////
	/*PROTECTED REGION ID(R1270155784) ENABLED START*/
	//// inserire qui le property che si vogliono iniettare in questo bean (es. dao, proxy di pd, ...) 

	private DbMgr dbMgr;

	public DbMgr getDbMgr() {
		return dbMgr;
	}

	public void setDbMgr(DbMgr dbMgr) {
		this.dbMgr = dbMgr;
	}

	private SigitMgr sigitMgr;

	public SigitMgr getSigitMgr() {
		return sigitMgr;
	}

	public void setSigitMgr(SigitMgr sigitMgr) {
		this.sigitMgr = sigitMgr;
	}

	private ConnectorMgr connectorMgr;

	public ConnectorMgr getConnectorMgr() {
		return connectorMgr;
	}

	public void setConnectorMgr(ConnectorMgr connectorMgr) {
		this.connectorMgr = connectorMgr;
	}

	private ValidationMgr validationMgr;

	public ValidationMgr getValidationMgr() {
		return validationMgr;
	}

	public void setValidationMgr(ValidationMgr validationMgr) {
		this.validationMgr = validationMgr;
	}

	/*PROTECTED REGION END*/
}
