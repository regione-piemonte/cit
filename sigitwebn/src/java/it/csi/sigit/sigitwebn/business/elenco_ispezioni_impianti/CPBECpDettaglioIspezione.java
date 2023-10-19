package it.csi.sigit.sigitwebn.business.elenco_ispezioni_impianti;

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

/*PROTECTED REGION ID(R34341047) ENABLED START*/
import it.csi.sigit.sigitwebn.business.manager.DbMgr;
import it.csi.sigit.sigitwebn.business.manager.ServiziMgr;
import it.csi.sigit.sigitwebn.business.manager.SigitMgr;
import it.csi.sigit.sigitwebn.business.manager.ValidationMgr;
import it.csi.sigit.sigitwebn.business.manager.util.ManagerException;
import it.csi.sigit.sigitwebn.business.manager.util.Message;
import it.csi.sigit.sigitwebn.business.manager.util.ValidationManagerException;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.SigitTDocAggiuntivaDto;

/*PROTECTED REGION END*/

public class CPBECpDettaglioIspezione {

	/**  */
	protected static final Logger log = //NOSONAR  Reason:EIAS 
			Logger.getLogger(Constants.APPLICATION_CODE + ".business"); //NOSONAR  Reason:EIAS

	//////////////////////////////////////////////////////////////////////////////
	/// Costanti identificative degli Application Data
	//////////////////////////////////////////////////////////////////////////////

	// ApplicationData: [utenteLoggato, scope:USER_SESSION]
	public static final String APPDATA_UTENTELOGGATO_CODE = "appDatautenteLoggato";

	// ApplicationData: [elencoAllegatiIsp, scope:USER_SESSION]
	public static final String APPDATA_ELENCOALLEGATIISP_CODE = "appDataelencoAllegatiIsp";

	// ApplicationData: [ispezione, scope:USER_SESSION]
	public static final String APPDATA_ISPEZIONE_CODE = "appDataispezione";

	// ApplicationData: [allegatoIsp, scope:USER_SESSION]
	public static final String APPDATA_ALLEGATOISP_CODE = "appDataallegatoIsp";

	// ApplicationData: [identificativoImpianto, scope:USER_SESSION]
	public static final String APPDATA_IDENTIFICATIVOIMPIANTO_CODE = "appDataidentificativoImpianto";

	// ApplicationData: [idAllegatoIspSelezionato, scope:USER_SESSION]
	public static final String APPDATA_IDALLEGATOISPSELEZIONATO_CODE = "appDataidAllegatoIspSelezionato";

	// ApplicationData: [elencoTipiDocumentoProfilatiIsp, scope:USER_SESSION]
	public static final String APPDATA_ELENCOTIPIDOCUMENTOPROFILATIISP_CODE = "appDataelencoTipiDocumentoProfilatiIsp";

	// ApplicationData: [elencoTipiCombustibileIsp, scope:USER_SESSION]
	public static final String APPDATA_ELENCOTIPICOMBUSTIBILEISP_CODE = "appDataelencoTipiCombustibileIsp";

	// ApplicationData: [elencoApparecchiatureIsp, scope:USER_SESSION]
	public static final String APPDATA_ELENCOAPPARECCHIATUREISP_CODE = "appDataelencoApparecchiatureIsp";

	// ApplicationData: [messaggioDinamico, scope:USER_SESSION]
	public static final String APPDATA_MESSAGGIODINAMICO_CODE = "appDatamessaggioDinamico";

	// ApplicationData: [idIspezioneImpiantoSelezionato, scope:USER_SESSION]
	public static final String APPDATA_IDISPEZIONEIMPIANTOSELEZIONATO_CODE = "appDataidIspezioneImpiantoSelezionato";

	// ApplicationData: [aggiornaElencoIspezioniAllegati, scope:USER_SESSION]
	public static final String APPDATA_AGGIORNAELENCOISPEZIONIALLEGATI_CODE = "appDataaggiornaElencoIspezioniAllegati";

	// ApplicationData: [RicercaApparecchiatureRappProva, scope:USER_SESSION]
	public static final String APPDATA_RICERCAAPPARECCHIATURERAPPPROVA_CODE = "appDataRicercaApparecchiatureRappProva";

	//////////////////////////////////////////////////////////////////////////////
	/// Metodi associati alla U.I.
	//////////////////////////////////////////////////////////////////////////////

	// nome del content panel associato al bean
	public static final String CPNAME = "cpDettaglioIspezione";

	public static final String MULTIPANEL_MPDATIALLEGATO = "mpDatiAllegato";
	public static final String MPI_MPDATIALLEGATO_FPDATIRAPPORTO = CPNAME + "_" + MULTIPANEL_MPDATIALLEGATO + "_"
			+ "fpDatiRapporto";

	/** 
	 * Restituisce il tab correntemente visibile in un determinato tab set
	 */
	private String getCurrentTab(Map session, String tabSetName) {
		String value = (String) session.get(CPNAME + "_" + tabSetName + "_selectedMultiPanel");
		return value;
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo inserisciRapportoProva definito in un ExecCommand del
	 * ContentPanel cpDettaglioIspezione
	 */
	public ExecResults inserisciRapportoProva(

			it.csi.sigit.sigitwebn.dto.elenco_ispezioni_impianti.CpDettaglioIspezioneModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String INSERISCIRAPPORTOPROVA_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String INSERISCIRAPPORTOPROVA_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-1419587964) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:
			try {

				Integer idIspezioneSelezionata = theModel.getAppDataidIspezioneImpiantoSelezionato();

				log.debug(" ISPEZIONI ----> Inserisci rapporto prova ------------> idIspezioneSelezionata: "
						+ idIspezioneSelezionata);

				//se non lo hanno selezionato questo metodo mi blocca
				//getValidationMgr().checkSelezioneElemento(ConvertUtil.convertToString(idIspezioneSelezionata));

				DettaglioIspezione dettaglioIspezione = getDbMgr().getDettaglioIspezioneById(idIspezioneSelezionata);

				if (dettaglioIspezione.getIdStatoIspezione().intValue() != Constants.ID_STATO_ISPEZIONE_BOZZA) {
					throw new ValidationManagerException(new Message(Messages.S116));
					//				} else if (getSigitMgr().isPresenteLibrettoBozza(dettaglioIspezione.getCodiceImpianto())) {
					//					throw new ValidationManagerException(new Message(Messages.S055));
				} else if (GenericUtil.isNotNullOrEmpty(dettaglioIspezione.getIdAllegato())) {
					throw new ValidationManagerException(new Message(Messages.S117));
				} else {
					//vado a ripulire di alcuni dati che magari il DettaglioAllegato si tiene in sessione se passo da modifica
					DettaglioAllegato dettaglio = new DettaglioAllegato();

					dettaglio.setDataControllo(ReplaceSpecialCharUtils.sanitize(dettaglioIspezione.getDataIspezione()));
					dettaglio.setCodiceImpianto(ReplaceSpecialCharUtils.sanitize(dettaglioIspezione.getCodiceImpianto()));
					dettaglio.setSiglaBollino(Constants.SIGLA_BOLLINO_RP);
					theModel.setAppDataallegatoIsp(dettaglio);

					// vado a caricare la combo dei tipi documenti
					precaricaCombo(theModel);

					result.setResultCode(INSERISCIRAPPORTOPROVA_OUTCOME_CODE__OK);
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
			log.error("[BackEndFacade::inserisciRapportoProva] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo modificaRappProva definito in un ExecCommand del
	 * ContentPanel cpDettaglioIspezione
	 */
	public ExecResults modificaRappProva(

			it.csi.sigit.sigitwebn.dto.elenco_ispezioni_impianti.CpDettaglioIspezioneModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String MODIFICARAPPPROVA_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String MODIFICARAPPPROVA_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-439422253) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			try {
				Integer idIspezioneSelezionata = theModel.getAppDataidIspezioneImpiantoSelezionato();
				log.debug(" ISPEZIONI ----> MODIFICA ALLEGATO ------------> idIspezioneSelezionata: "
						+ idIspezioneSelezionata);

				//se non lo hanno selezionato questo metodo mi blocca
				getValidationMgr().checkSelezioneElemento(ConvertUtil.convertToString(idIspezioneSelezionata));

				DettaglioIspezione dettaglioIspezione = getDbMgr().getDettaglioIspezioneById(idIspezioneSelezionata);

				if (dettaglioIspezione.getIdStatoIspezione().intValue() != Constants.ID_STATO_ISPEZIONE_BOZZA) {
					throw new ValidationManagerException(new Message(Messages.S116));
					//				} else if (getSigitMgr().isPresenteLibrettoBozza(dettaglioIspezione.getCodiceImpianto())) {
					//					throw new ValidationManagerException(new Message(Messages.S055));
				} else if (GenericUtil.isNullOrEmpty(dettaglioIspezione.getIdAllegato())) {
					throw new ValidationManagerException(new Message(Messages.S121));
				}
				//				else if (dettaglioIspezione.getIdStatoAllegato().intValue() != Constants.ID_STATO_RAPPORTO_BOZZA)
				//				{
				//					throw new ValidationManagerException(new Message(
				//							Messages.S040));
				//				}
				else {

					DettaglioAllegato allegato = getDbMgr()
							.getDettaglioAllegatoById(dettaglioIspezione.getIdAllegato());

					allegato.setCodiceImpianto(ReplaceSpecialCharUtils.sanitize(dettaglioIspezione.getCodiceImpianto()));

					theModel.setAppDataallegatoIsp(allegato);

					precaricaCombo(theModel);

				}

				result.setResultCode(MODIFICARAPPPROVA_OUTCOME_CODE__OK);
			} catch (ManagerException ex) {

				Validator.gestisciEccezione(result, ex);
			}

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::modificaRappProva] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo visualizzaRappProva definito in un ExecCommand del
	 * ContentPanel cpDettaglioIspezione
	 */
	public ExecResults visualizzaRappProva(

			it.csi.sigit.sigitwebn.dto.elenco_ispezioni_impianti.CpDettaglioIspezioneModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String VISUALIZZARAPPPROVA_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String VISUALIZZARAPPPROVA_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-1025231453) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			try {
				Integer idIspezioneSelezionata = theModel.getAppDataidIspezioneImpiantoSelezionato();
				log.debug(" ISPEZIONI ----> ANNULLA ISPEZIONI ------------> idIspezioneSelezionata: "
						+ idIspezioneSelezionata);

				//se non lo hanno selezionato questo metodo mi blocca
				getValidationMgr().checkSelezioneElemento(ConvertUtil.convertToString(idIspezioneSelezionata));

				DettaglioIspezione dettaglioIspezione = getDbMgr().getDettaglioIspezioneById(idIspezioneSelezionata);

				/*
				if (dettaglioIspezione.getIdStatoIspezione().intValue() != Constants.ID_STATO_ISPEZIONE_BOZZA) {
					throw new ValidationManagerException(new Message(
							Messages.S116));
				} 
				else if (getSigitMgr().isPresenteLibrettoBozza(
						dettaglioIspezione.getCodiceImpianto())) {
					throw new ValidationManagerException(new Message(
							Messages.S055));
				} 
				else
				 */
				if (GenericUtil.isNullOrEmpty(dettaglioIspezione.getIdAllegato())) {
					throw new ValidationManagerException(new Message(Messages.S121));
				} else if (dettaglioIspezione.getIdStatoAllegato().intValue() != Constants.ID_STATO_RAPPORTO_INVIATO
						&& dettaglioIspezione.getIdStatoAllegato().intValue() != Constants.ID_STATO_RAPPORTO_RESPINTO)

				{
					throw new ValidationManagerException(new Message(Messages.S041));
				} else {

					theModel.getSession().put(Constants.SESSIONE_VAR_ID_ALLEGATO,
							ConvertUtil.convertToString(dettaglioIspezione.getIdAllegato()));

					theModel.getSession().put(Constants.SESSIONE_VAR_ID_IMPIANTO,
							dettaglioIspezione.getCodiceImpianto());

					DettaglioAllegato allegato = getDbMgr()
							.getDettaglioAllegatoById(dettaglioIspezione.getIdAllegato());

					theModel.setAppDataallegatoIsp(allegato);
				}

				result.setResultCode(VISUALIZZARAPPPROVA_OUTCOME_CODE__OK);
			} catch (ManagerException ex) {
				Validator.gestisciEccezione(result, ex);
			}

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::visualizzaRappProva] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo annullaRappProva definito in un ExecCommand del
	 * ContentPanel cpDettaglioIspezione
	 */
	public ExecResults annullaRappProva(

			it.csi.sigit.sigitwebn.dto.elenco_ispezioni_impianti.CpDettaglioIspezioneModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String ANNULLARAPPPROVA_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String ANNULLARAPPPROVA_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R768938216) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			try {
				Integer idIspezioneSelezionata = theModel.getAppDataidIspezioneImpiantoSelezionato();
				log.debug(" ISPEZIONI ----> ANNULLA ALLEGATO ------------> idIspezioneSelezionata: "
						+ idIspezioneSelezionata);

				//se non lo hanno selezionato questo metodo mi blocca
				getValidationMgr().checkSelezioneElemento(ConvertUtil.convertToString(idIspezioneSelezionata));

				DettaglioIspezione dettaglioIspezione = getDbMgr().getDettaglioIspezioneById(idIspezioneSelezionata);

				if (dettaglioIspezione.getIdStatoIspezione().intValue() != Constants.ID_STATO_ISPEZIONE_BOZZA) {
					throw new ValidationManagerException(new Message(Messages.S116));
					//				} 
					//				else if (getSigitMgr().isPresenteLibrettoBozza(dettaglioIspezione.getCodiceImpianto())) {
					//					throw new ValidationManagerException(new Message(Messages.S055));
				} else if (GenericUtil.isNullOrEmpty(dettaglioIspezione.getIdAllegato())) {
					throw new ValidationManagerException(new Message(Messages.S121));
				}
				//				else if (dettaglioIspezione.getIdStatoAllegato().intValue() != Constants.ID_STATO_RAPPORTO_BOZZA)
				//				{
				//					throw new ValidationManagerException(new Message(
				//							Messages.S040));
				//				}
				else {

					DettaglioAllegato allegato = getDbMgr()
							.getDettaglioAllegatoById(dettaglioIspezione.getIdAllegato());

					allegato.setCodiceImpianto(ReplaceSpecialCharUtils.sanitize(dettaglioIspezione.getCodiceImpianto()));

					theModel.setAppDataallegatoIsp(allegato);

					//lo spedisco a una maschera di conferma
					Message msg = new Message(Messages.C004);
					theModel.setAppDatamessaggioDinamico(ReplaceSpecialCharUtils.sanitize(msg.getText()));

				}

				result.setResultCode(ANNULLARAPPPROVA_OUTCOME_CODE__OK);
			} catch (ManagerException ex) {

				Validator.gestisciEccezione(result, ex);
			}

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::annullaRappProva] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo visualizzaRicevutaRappProva definito in un ExecCommand del
	 * ContentPanel cpDettaglioIspezione
	 */
	public ExecResults visualizzaRicevutaRappProva(

			it.csi.sigit.sigitwebn.dto.elenco_ispezioni_impianti.CpDettaglioIspezioneModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String VISUALIZZARICEVUTARAPPPROVA_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String VISUALIZZARICEVUTARAPPPROVA_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R1217241800) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			Integer idIspezioneSelezionata = theModel.getAppDataidIspezioneImpiantoSelezionato();
			log.debug(" ISPEZIONI ----> RICEVUTA ALLEGATO ------------> idIspezioneSelezionata: "
					+ idIspezioneSelezionata);

			try {
				//se non lo hanno selezionato questo metodo mi blocca
				getValidationMgr().checkSelezioneElemento(ConvertUtil.convertToString(idIspezioneSelezionata));

				DettaglioIspezione dettaglioIspezione = getDbMgr().getDettaglioIspezioneById(idIspezioneSelezionata);

				if (dettaglioIspezione.getIdStatoIspezione().intValue() != Constants.ID_STATO_ISPEZIONE_CONSOLIDATO) {
					throw new ValidationManagerException(new Message(Messages.S047));
				} else if (GenericUtil.isNullOrEmpty(dettaglioIspezione.getIdAllegato())) {
					throw new ValidationManagerException(new Message(Messages.S121));
				} else {
					getValidationMgr().validazioneFormaleStampaRicevutaAllegato(dettaglioIspezione.getIdAllegato(),
							theModel.getAppDatautenteLoggato().getRuolo().getDescRuolo(),
							theModel.getAppDatautenteLoggato().getRuolo().getIdPersonaGiuridica());

					theModel.getSession().put(Constants.SESSIONE_VAR_ID_ALLEGATO,
							ConvertUtil.convertToString(dettaglioIspezione.getIdAllegato()));

					//				theModel.getSession().put(
					//						Constants.SESSIONE_VAR_ACTION_PAGE_BACK,
					//						Constants.RETURN_PAGE_ELENCO_ALLEGATI_IMPIANTO_DA_PDF);

					log.debug("DEVO APRIRE IL PDF");

					// impostazione del result code 
					result.setResultCode(VISUALIZZARICEVUTARAPPPROVA_OUTCOME_CODE__OK);
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
			log.error("[BackEndFacade::visualizzaRicevutaRappProva] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo documentazioneAllegatoIspPerImpianto definito in un ExecCommand del
	 * ContentPanel cpDettaglioIspezione
	 */
	public ExecResults documentazioneAllegatoIspPerImpianto(

			it.csi.sigit.sigitwebn.dto.elenco_ispezioni_impianti.CpDettaglioIspezioneModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String DOCUMENTAZIONEALLEGATOISPPERIMPIANTO_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String DOCUMENTAZIONEALLEGATOISPPERIMPIANTO_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R1691410590) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			// impostazione del result code 
			result.setResultCode(DOCUMENTAZIONEALLEGATOISPPERIMPIANTO_OUTCOME_CODE__OK);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::documentazioneAllegatoIspPerImpianto] Errore occorso nell'esecuzione del metodo:"
					+ e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo tornaPaginaChiamante definito in un ExecCommand del
	 * ContentPanel cpDettaglioIspezione
	 */
	public ExecResults tornaPaginaChiamante(

			it.csi.sigit.sigitwebn.dto.elenco_ispezioni_impianti.CpDettaglioIspezioneModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String TORNAPAGINACHIAMANTE_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R481339462) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			// impostazione del result code 
			result.setResultCode(TORNAPAGINACHIAMANTE_OUTCOME_CODE__OK);

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
	 * Implementazione del metodo cercaComboPerAllegato definito in un ExecCommand del
	 * ContentPanel cpDettaglioIspezione
	 */
	public ExecResults cercaComboPerAllegato(

			it.csi.sigit.sigitwebn.dto.elenco_ispezioni_impianti.CpDettaglioIspezioneModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String CERCACOMBOPERALLEGATO_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String CERCACOMBOPERALLEGATO_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R1311892702) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			try {
				DettaglioAllegato allegato = theModel.getAppDataallegatoIsp();
				//getValidationMgr().validazioneFormaleDatiAllegatoIspCerca(allegato);

				// Per sapere quali apparecchiature devo capire il idTipoAllegato partendo dall'idTipoRapProva
				String idTipoRapProva = theModel.getAppDataallegatoIsp().getIdTipoRapProva();
				String idTipoAllegato = null;

				if (GenericUtil.isNotNullOrEmpty(idTipoRapProva)) {

					if (idTipoRapProva.equals(Constants.RAPP_PROVA_ALLEGATO_TIPO_1)) {
						idTipoAllegato = Constants.ALLEGATO_TIPO_1;
					} else if (idTipoRapProva.equals(Constants.RAPP_PROVA_ALLEGATO_TIPO_1)) {
						idTipoAllegato = Constants.ALLEGATO_TIPO_2;
					}

					theModel.getAppDataallegatoIsp().setIdTipoAllegato(idTipoAllegato);
				}

				caricaCombo(theModel);

				// impostazione del result code 
				result.setResultCode(CERCACOMBOPERALLEGATO_OUTCOME_CODE__OK);

				// modifica degli attributi del model (che verranno propagati allo strato
				// di presentation). si puo' agire anche direttamente sull'attributo "session".
			} catch (Exception e) {
				log.error(
						"[BackEndFacade::caricaElencoApparecchiatureByComb] Errore occorso nell'esecuzione del metodo:"
								+ e,
						e);
				throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
			}

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::cercaComboPerAllegato] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo ricercaElencoApparecchiuature definito in un ExecCommand del
	 * ContentPanel cpDettaglioIspezione
	 */
	public ExecResults ricercaElencoApparecchiuature(

			it.csi.sigit.sigitwebn.dto.elenco_ispezioni_impianti.CpDettaglioIspezioneModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String RICERCAELENCOAPPARECCHIUATURE_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String RICERCAELENCOAPPARECCHIUATURE_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-87096435) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			// impostazione del result code 
			result.setResultCode(RICERCAELENCOAPPARECCHIUATURE_OUTCOME_CODE__OK);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::ricercaElencoApparecchiuature] Errore occorso nell'esecuzione del metodo:" + e,
					e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo resettaRicercaElencoApparecchiuature definito in un ExecCommand del
	 * ContentPanel cpDettaglioIspezione
	 */
	public ExecResults resettaRicercaElencoApparecchiuature(

			it.csi.sigit.sigitwebn.dto.elenco_ispezioni_impianti.CpDettaglioIspezioneModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String RESETTARICERCAELENCOAPPARECCHIUATURE_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String RESETTARICERCAELENCOAPPARECCHIUATURE_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-636172711) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			// impostazione del result code 
			result.setResultCode(RESETTARICERCAELENCOAPPARECCHIUATURE_OUTCOME_CODE__OK);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::resettaRicercaElencoApparecchiuature] Errore occorso nell'esecuzione del metodo:"
					+ e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo caricaElencoApparecchiatureByComb definito in un ExecCommand del
	 * ContentPanel cpDettaglioIspezione
	 */
	public ExecResults caricaElencoApparecchiatureByComb(

			it.csi.sigit.sigitwebn.dto.elenco_ispezioni_impianti.CpDettaglioIspezioneModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String CARICAELENCOAPPARECCHIATUREBYCOMB_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String CARICAELENCOAPPARECCHIATUREBYCOMB_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R1283808970) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			log.debug("ENTRO in caricaElencoApparecchiatureByComb");

			// Ricarico solo la combo delle apparecchiature
			theModel.setAppDataelencoApparecchiatureIsp(
					getSigitMgr().cercaElencoApparecchiature(theModel.getAppDataallegatoIsp()));

			// impostazione del result code 
			result.setResultCode(CARICAELENCOAPPARECCHIATUREBYCOMB_OUTCOME_CODE__OK);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error(
					"[BackEndFacade::caricaElencoApparecchiatureByComb] Errore occorso nell'esecuzione del metodo:" + e,
					e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo ripulisciDatiAllegato definito in un ExecCommand del
	 * ContentPanel cpDettaglioIspezione
	 */
	public ExecResults ripulisciDatiAllegato(

			it.csi.sigit.sigitwebn.dto.elenco_ispezioni_impianti.CpDettaglioIspezioneModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String RIPULISCIDATIALLEGATO_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R397369897) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			// impostazione del result code 
			result.setResultCode(RIPULISCIDATIALLEGATO_OUTCOME_CODE__OK);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::ripulisciDatiAllegato] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo chiudiDatiAllegato definito in un ExecCommand del
	 * ContentPanel cpDettaglioIspezione
	 */
	public ExecResults chiudiDatiAllegato(

			it.csi.sigit.sigitwebn.dto.elenco_ispezioni_impianti.CpDettaglioIspezioneModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String CHIUDIDATIALLEGATO_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-768338813) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			// impostazione del result code 
			result.setResultCode(CHIUDIDATIALLEGATO_OUTCOME_CODE__OK);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::chiudiDatiAllegato] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo gestisciRappProvaWeb definito in un ExecCommand del
	 * ContentPanel cpDettaglioIspezione
	 */
	public ExecResults gestisciRappProvaWeb(

			it.csi.sigit.sigitwebn.dto.elenco_ispezioni_impianti.CpDettaglioIspezioneModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GESTISCIRAPPPROVAWEB_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String GESTISCIRAPPPROVAWEB_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-1471937334) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:
			DettaglioAllegato dettaglioAllegato = theModel.getAppDataallegatoIsp();
			Ruolo profiloUtente = theModel.getAppDatautenteLoggato().getRuolo();

			if (log.isDebugEnabled())
				GenericUtil.stampa(dettaglioAllegato, true, 3);

			try {

				log.debug("FRAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA CODICE IMPIANTO : "
						+ dettaglioAllegato.getCodiceImpianto());
				log.debug("FRAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA RUOLO UTENTE : " + profiloUtente.getDescRuolo());

				//				Integer fkManutentore = ConvertUtil
				//						.convertToInteger(GenericUtil
				//								.getFkManutentore(dettaglioAllegato
				//										.getIdApparecchiature().get(0)));

				Integer fkManutentore = null;
				if (GenericUtil.isNullOrEmpty(dettaglioAllegato.getIdAllegato())) {
					//se sono in inserimento ... in modifica bypasso questi controlli
					//controllo se i campi obbligatori sono stati valorizzati
					getValidationMgr().validazioneFormaleDatiAllegatoIsp(dettaglioAllegato);

					fkManutentore = ConvertUtil.convertToInteger(
							GenericUtil.getFkManutentore(dettaglioAllegato.getIdApparecchiature().get(0)));

					// recupero il manutentore (siccome apprtengono tutti allo stesso manutentore, prendo il primo
					String manutApp = dettaglioAllegato.getIdApparecchiature().get(0);

					dettaglioAllegato.setIdPersonaGiuridica(
							ConvertUtil.convertToInteger(GenericUtil.getFkManutentore(manutApp)));

					// Se sono in inserimento devo ripulire l'id
					// Devo ripulire l'id della combo apparecchiature (e' comp4mnaut#fKManut#progressivo), devo recupero il com4manut
					dettaglioAllegato
							.setIdCom4Manut(GenericUtil.recuperaComp4Manut(dettaglioAllegato.getIdApparecchiature()));

					if (log.isDebugEnabled())
						GenericUtil.stampa(dettaglioAllegato, true, 3);

					// Devo ripulire l'id della combo apparecchiature (e' comp4mnaut#fKManut#progressivo), devo recupero il progressivo
					dettaglioAllegato.setIdApparecchiature(
							GenericUtil.recuperaProgressivo(dettaglioAllegato.getIdApparecchiature()));

				} else {
					fkManutentore = dettaglioAllegato.getIdPersonaGiuridica();

					if (Constants.RUOLO_IMPRESA.equalsIgnoreCase(profiloUtente.getDescRuolo())) {

						if (profiloUtente.getIdPersonaGiuridica() != fkManutentore.intValue()) {
							throw new ManagerException(new Message(Messages.S044));
						}
					}
				}

				PersonaGiuridica personaGiuridica = getDbMgr().cercaPersonaGiuridicaById(fkManutentore);

				//controllo se il manutentore loggato non abbia l'attivita' cessata
				getValidationMgr().verificaDataCessazioneAttivita(dettaglioAllegato.getDataControllo(),
						personaGiuridica.getDataCessazione());

				//setto a BOZZA l'allegato che si sta per aprire (se ha passato tutti i controlli precedenti)
				dettaglioAllegato.setIdStatoRapporto(Constants.ID_STATO_RAPPORTO_BOZZA);
				//setto il codice fiscale dell'utente loggato
				dettaglioAllegato.setCodFiscaleUtenteLoggato(
						ReplaceSpecialCharUtils.sanitize(theModel.getAppDatautenteLoggato().getCodiceFiscale()));
				//setto il flagControlloBozza a false(0) perche' se e' null va in eccezione quando cerco di inviarlo
				dettaglioAllegato.setFlagControlloBozza(Constants.FLAG_CONTROLLO_BOZZA_ALLEGATO_FALSE);
				//setto da dove sto arrivando
				dettaglioAllegato.setArrivoDa(Constants.ARRIVO_DA_IMPIANTO_ISP);

				dettaglioAllegato.setCodiceBollino(MapDto.costruisciCodiceBollino(dettaglioAllegato.getSiglaBollino(),
						ConvertUtil.convertToBigDecimal(dettaglioAllegato.getNumeroBollinoVerde())));
				log.debug("BEPPE - prima di mettere in sessione: " + dettaglioAllegato);

				log.debug("Stampo ");

				//rimetto in sessione l'oggetto dettaglio allegato per la action showAllegatoNow
				theModel.getSession().put(Constants.SESSIONE_VAR_DETT_ALLEGATO, dettaglioAllegato);

				theModel.setAppDataallegatoIsp(dettaglioAllegato);

				theModel.setAppDataaggiornaElencoIspezioniAllegati(true);

				if (log.isDebugEnabled())
					GenericUtil.stampa(dettaglioAllegato, true, 3);

				result.setResultCode(GESTISCIRAPPPROVAWEB_OUTCOME_CODE__OK);
				/*
				// DEVO COPIARE I CONTROLLI DI GENERAZIONE ALLEGATO
				if (Constants.RAPP_PROVA_ALLEGATO_TIPO_1.equals(dettaglioAllegato.getIdTipoAllegato()))
					result.setResultCode(GESTISCIRAPPPROVAWEB_OUTCOME_CODE__TIPO1);
				if (Constants.RAPP_PROVA_ALLEGATO_TIPO_2.equals(dettaglioAllegato.getIdTipoAllegato()))
					result.setResultCode(GESTISCIRAPPPROVAWEB_OUTCOME_CODE__TIPO2);
				*/

			} catch (ManagerException ex) {
				//log.debug("Errore: ", ex);
				Validator.gestisciEccezione(result, ex);
			}

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::gestisciRappProvaWeb] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo salvaAnnullaRappProva definito in un ExecCommand del
	 * ContentPanel cpDettaglioIspezione
	 */
	public ExecResults salvaAnnullaRappProva(

			it.csi.sigit.sigitwebn.dto.elenco_ispezioni_impianti.CpDettaglioIspezioneModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String SALVAANNULLARAPPPROVA_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String SALVAANNULLARAPPPROVA_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R117628847) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			try {
				Integer idIspezioneSelezionata = theModel.getAppDataidIspezioneImpiantoSelezionato();

				DettaglioIspezione dettaglioIspezione = getDbMgr().getDettaglioIspezioneById(idIspezioneSelezionata);

				getSigitMgr().eliminaAllegato(ConvertUtil.convertToString(dettaglioIspezione.getIdAllegato()),
						theModel.getAppDatautenteLoggato().getCodiceFiscale());

				/*
				IdentificativoImpiantoAllegato identificativo = theModel
						.getAppDataidentificativoImpiantoAllegato();
				
				AllegatiPerImpianto allegati = this.getSigitMgr()
						.cercaAllegatiPerCodiceImpianto(
								identificativo.getCodiceImpianto());
				
				if (allegati != null && allegati.getListaAllegati() != null) {
					theModel.setAppDataelencoAllegatiPerImpianto(allegati
							.getListaAllegati());
				} else {
					theModel.setAppDataelencoAllegatiPerImpianto(new ArrayList<DettaglioAllegato>());
				}
				
				 */

				//theModel.setAppDataaggiornaElencoAllegati(true);

				//				theModel.getSession().put(
				//						Constants.SESSIONE_VAR_MESSAGGE,
				//						new Message(Messages.INFO_ELIMINAZIONE_CORRETTA,
				//								Message.INFO));

				result.getGlobalMessages().add(Messages.INFO_ELIMINAZIONE_CORRETTA);

				//theModel.setAppDataaggiornaElencoIspezioni(true);
				//theModel.setAppDataidIspezioneImpiantoSelezionato(null);

				result.setResultCode(SALVAANNULLARAPPPROVA_OUTCOME_CODE__OK);

			} catch (ManagerException ex) {
 
				//result.getGlobalErrors().add(Messages.ERROR_RECUPERO_SERVIZIO);

				//				theModel.getSession().put(
				//						Constants.SESSIONE_VAR_MESSAGGE,
				//						new Message(Messages.ERROR_RECUPERO_SERVIZIO,
				//								Message.ERROR));

				Validator.gestisciEccezione(result, ex);
			}

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::salvaAnnullaRappProva] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo inizializzaElencoRappProva definito in un ExecCommand del
	 * ContentPanel cpDettaglioIspezione
	 */
	public ExecResults inizializzaElencoRappProva(

			it.csi.sigit.sigitwebn.dto.elenco_ispezioni_impianti.CpDettaglioIspezioneModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String INIZIALIZZAELENCORAPPPROVA_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String INIZIALIZZAELENCORAPPPROVA_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R1478365357) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			//dcosta: si procede al caricamento dei dati dell'ispezione
			Integer idIspezioneSelezionata = theModel.getAppDataidIspezioneImpiantoSelezionato();
			log.debug(" ISPEZIONI ----> INIZIALIZZA ELENCO RAPP PRVOVA ------------> idIspezioneSelezionata: "
					+ idIspezioneSelezionata);

			DettaglioIspezione dettaglioIspezione = getDbMgr().getDettaglioIspezioneById(idIspezioneSelezionata);

			theModel.setAppDataispezione(dettaglioIspezione);

			caricaElencoAllegati(theModel);

			// impostazione del result code 
			result.setResultCode(INIZIALIZZAELENCORAPPPROVA_OUTCOME_CODE__OK);

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::inizializzaElencoRappProva] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo gestioneVisBottoniInit definito in un ExecCommand del
	 * ContentPanel cpDettaglioIspezione
	 */
	public ExecResults gestioneVisBottoniInit(

			it.csi.sigit.sigitwebn.dto.elenco_ispezioni_impianti.CpDettaglioIspezioneModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GESTIONEVISBOTTONIINIT_OUTCOME_CODE__VISUALIZZA = //NOSONAR  Reason:EIAS
				"VISUALIZZA"; //NOSONAR  Reason:EIAS
		final String GESTIONEVISBOTTONIINIT_OUTCOME_CODE__NASCONDI = //NOSONAR  Reason:EIAS
				"NASCONDI"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-415000101) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			// impostazione del result code 
			result.setResultCode(GESTIONEVISBOTTONIINIT_OUTCOME_CODE__VISUALIZZA);

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
	 * Implementazione del metodo isAutorizzatoBtn definito in un ExecCommand del
	 * ContentPanel cpDettaglioIspezione
	 */
	public ExecResults isAutorizzatoBtn(

			it.csi.sigit.sigitwebn.dto.elenco_ispezioni_impianti.CpDettaglioIspezioneModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String ISAUTORIZZATOBTN_OUTCOME_CODE__SI = //NOSONAR  Reason:EIAS
				"SI"; //NOSONAR  Reason:EIAS
		final String ISAUTORIZZATOBTN_OUTCOME_CODE__NO = //NOSONAR  Reason:EIAS
				"NO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R1140872148) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			// impostazione del result code 
			result.setResultCode(ISAUTORIZZATOBTN_OUTCOME_CODE__SI);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::isAutorizzatoBtn] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo isDatiPresenti definito in un ExecCommand del
	 * ContentPanel cpDettaglioIspezione
	 */
	public ExecResults isDatiPresenti(

			it.csi.sigit.sigitwebn.dto.elenco_ispezioni_impianti.CpDettaglioIspezioneModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String ISDATIPRESENTI_OUTCOME_CODE__SI = //NOSONAR  Reason:EIAS
				"SI"; //NOSONAR  Reason:EIAS
		final String ISDATIPRESENTI_OUTCOME_CODE__NO = //NOSONAR  Reason:EIAS
				"NO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R706929210) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			// impostazione del result code 
			result.setResultCode(ISDATIPRESENTI_OUTCOME_CODE__SI);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::isDatiPresenti] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo aggiornaDatiPagina definito in un ExecCommand del
	 * ContentPanel cpDettaglioIspezione
	 */
	public ExecResults aggiornaDatiPagina(

			it.csi.sigit.sigitwebn.dto.elenco_ispezioni_impianti.CpDettaglioIspezioneModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String AGGIORNADATIPAGINA_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String AGGIORNADATIPAGINA_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R308198926) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

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

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo gestioneVisBottoniRef definito in un ExecCommand del
	 * ContentPanel cpDettaglioIspezione
	 */
	public ExecResults gestioneVisBottoniRef(

			it.csi.sigit.sigitwebn.dto.elenco_ispezioni_impianti.CpDettaglioIspezioneModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GESTIONEVISBOTTONIREF_OUTCOME_CODE__VISUALIZZA = //NOSONAR  Reason:EIAS
				"VISUALIZZA"; //NOSONAR  Reason:EIAS
		final String GESTIONEVISBOTTONIREF_OUTCOME_CODE__NASCONDI = //NOSONAR  Reason:EIAS
				"NASCONDI"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R374760474) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			// impostazione del result code 
			result.setResultCode(GESTIONEVISBOTTONIREF_OUTCOME_CODE__VISUALIZZA);

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
	 * Implementazione del metodo isVisualizzaBtnModificaIspezioneRef definito in un ExecCommand del
	 * ContentPanel cpDettaglioIspezione
	 */
	public ExecResults isVisualizzaBtnModificaIspezioneRef(

			it.csi.sigit.sigitwebn.dto.elenco_ispezioni_impianti.CpDettaglioIspezioneModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String ISVISUALIZZABTNMODIFICAISPEZIONEREF_OUTCOME_CODE__SI = //NOSONAR  Reason:EIAS
				"SI"; //NOSONAR  Reason:EIAS
		final String ISVISUALIZZABTNMODIFICAISPEZIONEREF_OUTCOME_CODE__NO = //NOSONAR  Reason:EIAS
				"NO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-1021012713) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			// impostazione del result code 
			result.setResultCode(ISVISUALIZZABTNMODIFICAISPEZIONEREF_OUTCOME_CODE__SI);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::isVisualizzaBtnModificaIspezioneRef] Errore occorso nell'esecuzione del metodo:"
					+ e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo isVisualizzaBtnConsolidaIspezioneRef definito in un ExecCommand del
	 * ContentPanel cpDettaglioIspezione
	 */
	public ExecResults isVisualizzaBtnConsolidaIspezioneRef(

			it.csi.sigit.sigitwebn.dto.elenco_ispezioni_impianti.CpDettaglioIspezioneModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String ISVISUALIZZABTNCONSOLIDAISPEZIONEREF_OUTCOME_CODE__SI = //NOSONAR  Reason:EIAS
				"SI"; //NOSONAR  Reason:EIAS
		final String ISVISUALIZZABTNCONSOLIDAISPEZIONEREF_OUTCOME_CODE__NO = //NOSONAR  Reason:EIAS
				"NO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R640192107) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			// impostazione del result code 
			result.setResultCode(ISVISUALIZZABTNCONSOLIDAISPEZIONEREF_OUTCOME_CODE__SI);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::isVisualizzaBtnConsolidaIspezioneRef] Errore occorso nell'esecuzione del metodo:"
					+ e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo isVisualizzaBtnAnnullaIspezioneRef definito in un ExecCommand del
	 * ContentPanel cpDettaglioIspezione
	 */
	public ExecResults isVisualizzaBtnAnnullaIspezioneRef(

			it.csi.sigit.sigitwebn.dto.elenco_ispezioni_impianti.CpDettaglioIspezioneModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String ISVISUALIZZABTNANNULLAISPEZIONEREF_OUTCOME_CODE__SI = //NOSONAR  Reason:EIAS
				"SI"; //NOSONAR  Reason:EIAS
		final String ISVISUALIZZABTNANNULLAISPEZIONEREF_OUTCOME_CODE__NO = //NOSONAR  Reason:EIAS
				"NO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R561924854) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			// impostazione del result code 
			result.setResultCode(ISVISUALIZZABTNANNULLAISPEZIONEREF_OUTCOME_CODE__SI);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::isVisualizzaBtnAnnullaIspezioneRef] Errore occorso nell'esecuzione del metodo:"
					+ e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo isVisualizzaBtnInserisciAllegatoRef definito in un ExecCommand del
	 * ContentPanel cpDettaglioIspezione
	 */
	public ExecResults isVisualizzaBtnInserisciAllegatoRef(

			it.csi.sigit.sigitwebn.dto.elenco_ispezioni_impianti.CpDettaglioIspezioneModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String ISVISUALIZZABTNINSERISCIALLEGATOREF_OUTCOME_CODE__SI = //NOSONAR  Reason:EIAS
				"SI"; //NOSONAR  Reason:EIAS
		final String ISVISUALIZZABTNINSERISCIALLEGATOREF_OUTCOME_CODE__NO = //NOSONAR  Reason:EIAS
				"NO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R2085219499) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			// impostazione del result code 
			result.setResultCode(ISVISUALIZZABTNINSERISCIALLEGATOREF_OUTCOME_CODE__SI);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::isVisualizzaBtnInserisciAllegatoRef] Errore occorso nell'esecuzione del metodo:"
					+ e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo isVisualizzaBtnModificaAllegatoRef definito in un ExecCommand del
	 * ContentPanel cpDettaglioIspezione
	 */
	public ExecResults isVisualizzaBtnModificaAllegatoRef(

			it.csi.sigit.sigitwebn.dto.elenco_ispezioni_impianti.CpDettaglioIspezioneModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String ISVISUALIZZABTNMODIFICAALLEGATOREF_OUTCOME_CODE__SI = //NOSONAR  Reason:EIAS
				"SI"; //NOSONAR  Reason:EIAS
		final String ISVISUALIZZABTNMODIFICAALLEGATOREF_OUTCOME_CODE__NO = //NOSONAR  Reason:EIAS
				"NO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R478812908) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			// impostazione del result code 
			result.setResultCode(ISVISUALIZZABTNMODIFICAALLEGATOREF_OUTCOME_CODE__SI);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::isVisualizzaBtnModificaAllegatoRef] Errore occorso nell'esecuzione del metodo:"
					+ e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo isVisualizzaBtnDettaglioAllegatoRef definito in un ExecCommand del
	 * ContentPanel cpDettaglioIspezione
	 */
	public ExecResults isVisualizzaBtnDettaglioAllegatoRef(

			it.csi.sigit.sigitwebn.dto.elenco_ispezioni_impianti.CpDettaglioIspezioneModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String ISVISUALIZZABTNDETTAGLIOALLEGATOREF_OUTCOME_CODE__SI = //NOSONAR  Reason:EIAS
				"SI"; //NOSONAR  Reason:EIAS
		final String ISVISUALIZZABTNDETTAGLIOALLEGATOREF_OUTCOME_CODE__NO = //NOSONAR  Reason:EIAS
				"NO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R1906559115) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			// impostazione del result code 
			result.setResultCode(ISVISUALIZZABTNDETTAGLIOALLEGATOREF_OUTCOME_CODE__SI);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::isVisualizzaBtnDettaglioAllegatoRef] Errore occorso nell'esecuzione del metodo:"
					+ e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo isVisualizzaBtnAnnullaAllegatoRef definito in un ExecCommand del
	 * ContentPanel cpDettaglioIspezione
	 */
	public ExecResults isVisualizzaBtnAnnullaAllegatoRef(

			it.csi.sigit.sigitwebn.dto.elenco_ispezioni_impianti.CpDettaglioIspezioneModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String ISVISUALIZZABTNANNULLAALLEGATOREF_OUTCOME_CODE__SI = //NOSONAR  Reason:EIAS
				"SI"; //NOSONAR  Reason:EIAS
		final String ISVISUALIZZABTNANNULLAALLEGATOREF_OUTCOME_CODE__NO = //NOSONAR  Reason:EIAS
				"NO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-717050579) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			// impostazione del result code 
			result.setResultCode(ISVISUALIZZABTNANNULLAALLEGATOREF_OUTCOME_CODE__SI);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error(
					"[BackEndFacade::isVisualizzaBtnAnnullaAllegatoRef] Errore occorso nell'esecuzione del metodo:" + e,
					e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo isVisualizzaBtnRicevutaAllegatoRef definito in un ExecCommand del
	 * ContentPanel cpDettaglioIspezione
	 */
	public ExecResults isVisualizzaBtnRicevutaAllegatoRef(

			it.csi.sigit.sigitwebn.dto.elenco_ispezioni_impianti.CpDettaglioIspezioneModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String ISVISUALIZZABTNRICEVUTAALLEGATOREF_OUTCOME_CODE__SI = //NOSONAR  Reason:EIAS
				"SI"; //NOSONAR  Reason:EIAS
		final String ISVISUALIZZABTNRICEVUTAALLEGATOREF_OUTCOME_CODE__NO = //NOSONAR  Reason:EIAS
				"NO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-1102529495) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			// impostazione del result code 
			result.setResultCode(ISVISUALIZZABTNRICEVUTAALLEGATOREF_OUTCOME_CODE__SI);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::isVisualizzaBtnRicevutaAllegatoRef] Errore occorso nell'esecuzione del metodo:"
					+ e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo aggiornaDatiPaginaRef definito in un ExecCommand del
	 * ContentPanel cpDettaglioIspezione
	 */
	public ExecResults aggiornaDatiPaginaRef(

			it.csi.sigit.sigitwebn.dto.elenco_ispezioni_impianti.CpDettaglioIspezioneModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String AGGIORNADATIPAGINAREF_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String AGGIORNADATIPAGINAREF_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-754794569) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			// impostazione del result code 
			result.setResultCode(AGGIORNADATIPAGINAREF_OUTCOME_CODE__OK);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::aggiornaDatiPaginaRef] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	//////////////////////////////////////////////////////////////////////////////
	/// Metodi statici per il reset delle tabelle
	//////////////////////////////////////////////////////////////////////////////

	/**
	 * permette di resettare lo stato di paginazione della tabella widg_tblElencoRappProva
	 */
	public static void resetClearStatus_widg_tblElencoRappProva(java.util.Map session) {
		session.put("cpDettaglioIspezione_tblElencoRappProva_clearStatus", Boolean.TRUE);
	}

	//////////////////////////////////////////////////////////////////////////////
	/// Property aggiuntive del bean
	//////////////////////////////////////////////////////////////////////////////
	/*PROTECTED REGION ID(R-541585763) ENABLED START*/
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

	private void precaricaCombo(it.csi.sigit.sigitwebn.dto.elenco_ispezioni_impianti.CpDettaglioIspezioneModel theModel)
			throws BEException {
		try {

			log.debug("theModel.getAppDataallegatoIsp().getCodiceImpianto(): "
					+ theModel.getAppDataallegatoIsp().getCodiceImpianto());

			theModel.setAppDataelencoTipiDocumentoProfilatiIsp(getDbMgr().cercaListaTipiDocumentoRapProva());

			theModel.setAppDataelencoTipiCombustibileIsp(new ArrayList<CodeDescription>());
			theModel.setAppDataelencoApparecchiatureIsp(new ArrayList<CodeDescription>());
			//theModel.setAppDataelencoNumeroBollinoVerdeIsp(new ArrayList<CodeDescription>());

		} catch (ManagerException e) {
			throw new BEException("Errore in CpElencoAllegatiImpiantiModel per il metodo  precaricaCombo:" + e, e);
		}

	}

	private void caricaCombo(it.csi.sigit.sigitwebn.dto.elenco_ispezioni_impianti.CpDettaglioIspezioneModel theModel)
			throws BEException {

		try {

			//			theModel.setAppDataelencoTipiDocumentoProfilatiIsp(
			//					getDbMgr().cercaListaTipiDocumentoRapProva());

			theModel.setAppDataelencoTipiCombustibileIsp(
					getSigitMgr().cercaElencoCombustibili(theModel.getAppDataallegatoIsp().getIdTipoAllegato()));

			theModel.setAppDataelencoApparecchiatureIsp(
					getSigitMgr().cercaElencoApparecchiature(theModel.getAppDataallegatoIsp()));

			//carico la combo dei numero bollini in base all'utente loggato
			/*
			if (theModel.getAppDataallegatoIsp().getIdTipoAllegato() != null) {
				theModel.setAppDataelencoNumeroBollinoVerdeIsp(getSigitMgr()
						.cercaElencoNumeriBollinoVerde(
								null,
			
								ConvertUtil.convertToInteger(theModel
										.getAppDataallegatoIsp()
										.getIdTipoAllegato()),
			
								ConvertUtil.convertToInteger(theModel
										.getAppDataallegatoIsp()
										.getCodiceImpianto()),
								theModel.getAppDataallegatoIsp()
										.getIdAllegato()));
			}
			 */

			//			
			//			else {
			//				theModel.setAppDataelencoNumeroBollinoVerdeIsp(getSigitMgr()
			//						.cercaElencoNumeriBollinoVerde(
			//								utenteLoggato,
			//								null,
			//								ConvertUtil.convertToInteger(theModel
			//										.getAppDataallegatoIsp()
			//										.getCodiceImpianto()),
			//								theModel.getAppDataallegatoIsp()
			//										.getIdAllegato()));
			//			}

		} catch (ManagerException e) {
			throw new BEException("Errore in CpElencoAllegatiImpiantiModel per il metodo  precaricaCombo:" + e, e);
		}
	}

	private void caricaElencoAllegati(
			it.csi.sigit.sigitwebn.dto.elenco_ispezioni_impianti.CpDettaglioIspezioneModel theModel)
			throws ManagerException {

		try {
			log.debug("Carico l'elenco degli allegato");

			String codiceImpianto = theModel.getAppDataispezione().getCodiceImpianto();

			//			String codiceImpianto = theModel.getAppDataidentificativoImpianto().getCodiceImpianto();
			Integer idIspezioneSelezionata = theModel.getAppDataidIspezioneImpiantoSelezionato();

			ArrayList<DettaglioAllegato> elencoAllegati = getSigitMgr()
					.cercaRappProvaPerIdIspezione(idIspezioneSelezionata);

			if (codiceImpianto != null) {
				theModel.setAppDataelencoAllegatiIsp(elencoAllegati);
			}
			resetClearStatus_widg_tblElencoRappProva(theModel.getSession());
			//			theModel.setAppDataaggiornaElencoIspezioni(false);

			log.debug("CaricaElencoAllegati: END");
		} catch (ManagerException e) {
			log.error("Errore: ", e);
			throw e;
		}

	}
	/*PROTECTED REGION END*/
}
