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

/*PROTECTED REGION ID(R-1306029902) ENABLED START*/
import java.io.File;
import it.csi.sigit.sigitwebn.business.manager.ConnectorMgr;
import it.csi.sigit.sigitwebn.business.manager.DbMgr;
import it.csi.sigit.sigitwebn.business.manager.ServiziMgr;
import it.csi.sigit.sigitwebn.business.manager.SigitMgr;
import it.csi.sigit.sigitwebn.business.manager.ValidationMgr;
import it.csi.sigit.sigitwebn.business.manager.db.DbAzioneMgr;
import it.csi.sigit.sigitwebn.business.manager.util.ManagerException;
import it.csi.sigit.sigitwebn.business.manager.util.Message;
import it.csi.sigit.sigitwebn.business.manager.util.ValidationManagerException;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.SigitTDocAzioneDto;
import it.csi.sigit.sigitwebn.dto.ispezioni.RicercaImpiantoDaAssociare;
import it.csi.sigit.sigitwebn.util.mail.ResultInvioMail;
import it.csi.sigit.sigitwebn.dto.elenco_ispezioni_impianti.CpDettaglioIspezione2018Model;
import it.csi.sigit.sigitwebn.business.manager.util.ServiceException;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.SigitTImpiantoDto;

/*PROTECTED REGION END*/

public class CPBECpDettaglioIspezione2018 {

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

	// ApplicationData: [Ispezione2018, scope:USER_SESSION]
	public static final String APPDATA_ISPEZIONE2018_CODE = "appDataIspezione2018";

	// ApplicationData: [elencoIspettori, scope:USER_SESSION]
	public static final String APPDATA_ELENCOISPETTORI_CODE = "appDataelencoIspettori";

	// ApplicationData: [elencoSanzioni, scope:USER_SESSION]
	public static final String APPDATA_ELENCOSANZIONI_CODE = "appDataelencoSanzioni";

	// ApplicationData: [idSanzioneSelezionata, scope:USER_SESSION]
	public static final String APPDATA_IDSANZIONESELEZIONATA_CODE = "appDataidSanzioneSelezionata";

	// ApplicationData: [elencoAllegatiIsp, scope:USER_SESSION]
	public static final String APPDATA_ELENCOALLEGATIISP_CODE = "appDataelencoAllegatiIsp";

	// ApplicationData: [idAllegatoIspSelezionato, scope:USER_SESSION]
	public static final String APPDATA_IDALLEGATOISPSELEZIONATO_CODE = "appDataidAllegatoIspSelezionato";

	// ApplicationData: [elencoAzioni, scope:USER_SESSION]
	public static final String APPDATA_ELENCOAZIONI_CODE = "appDataelencoAzioni";

	// ApplicationData: [idAzioneSelezionata, scope:USER_SESSION]
	public static final String APPDATA_IDAZIONESELEZIONATA_CODE = "appDataidAzioneSelezionata";

	// ApplicationData: [idTipoAzione, scope:USER_SESSION]
	public static final String APPDATA_IDTIPOAZIONE_CODE = "appDataidTipoAzione";

	// ApplicationData: [idVerificaSelezionata, scope:USER_SESSION]
	public static final String APPDATA_IDVERIFICASELEZIONATA_CODE = "appDataidVerificaSelezionata";

	// ApplicationData: [idAccertamentoSelezionato, scope:USER_SESSION]
	public static final String APPDATA_IDACCERTAMENTOSELEZIONATO_CODE = "appDataidAccertamentoSelezionato";

	// ApplicationData: [ConclusioneIspezione2018, scope:USER_SESSION]
	public static final String APPDATA_CONCLUSIONEISPEZIONE2018_CODE = "appDataConclusioneIspezione2018";

	// ApplicationData: [IspettoreScelto, scope:USER_SESSION]
	public static final String APPDATA_ISPETTORESCELTO_CODE = "appDataIspettoreScelto";

	// ApplicationData: [RicercaImpiantoDaAssociare, scope:USER_SESSION]
	public static final String APPDATA_RICERCAIMPIANTODAASSOCIARE_CODE = "appDataRicercaImpiantoDaAssociare";

	// ApplicationData: [idIspezioneSelezionato, scope:USER_SESSION]
	public static final String APPDATA_IDISPEZIONESELEZIONATO_CODE = "appDataidIspezioneSelezionato";

	// ApplicationData: [allegatoIsp, scope:USER_SESSION]
	public static final String APPDATA_ALLEGATOISP_CODE = "appDataallegatoIsp";

	// ApplicationData: [paginaChiamante, scope:USER_SESSION]
	public static final String APPDATA_PAGINACHIAMANTE_CODE = "appDatapaginaChiamante";

	// ApplicationData: [elencoSecondiIspettori, scope:USER_SESSION]
	public static final String APPDATA_ELENCOSECONDIISPETTORI_CODE = "appDataelencoSecondiIspettori";

	// ApplicationData: [aggiornaDati, scope:USER_SESSION]
	public static final String APPDATA_AGGIORNADATI_CODE = "appDataaggiornaDati";

	// ApplicationData: [idImpiantoSelez, scope:USER_SESSION]
	public static final String APPDATA_IDIMPIANTOSELEZ_CODE = "appDataidImpiantoSelez";

	// ApplicationData: [datiInserimentoSanzione, scope:USER_SESSION]
	public static final String APPDATA_DATIINSERIMENTOSANZIONE_CODE = "appDatadatiInserimentoSanzione";

	// ApplicationData: [paginaChiamanteDettaglioSanzione, scope:USER_SESSION]
	public static final String APPDATA_PAGINACHIAMANTEDETTAGLIOSANZIONE_CODE = "appDatapaginaChiamanteDettaglioSanzione";

	// ApplicationData: [elencoStatiSanzione, scope:USER_SESSION]
	public static final String APPDATA_ELENCOSTATISANZIONE_CODE = "appDataelencoStatiSanzione";

	// ApplicationData: [elencoComuniPiemonteIstat, scope:USER_SESSION]
	public static final String APPDATA_ELENCOCOMUNIPIEMONTEISTAT_CODE = "appDataelencoComuniPiemonteIstat";

	// ApplicationData: [elencoProvincePiemonteIstat, scope:USER_SESSION]
	public static final String APPDATA_ELENCOPROVINCEPIEMONTEISTAT_CODE = "appDataelencoProvincePiemonteIstat";

	// ApplicationData: [azioneCodImpianto, scope:USER_SESSION]
	public static final String APPDATA_AZIONECODIMPIANTO_CODE = "appDataazioneCodImpianto";

	//////////////////////////////////////////////////////////////////////////////
	/// Metodi associati alla U.I.
	//////////////////////////////////////////////////////////////////////////////

	// nome del content panel associato al bean
	public static final String CPNAME = "cpDettaglioIspezione2018";

	public static final String MULTIPANEL_MPELENCHI = "mpElenchi";
	public static final String MPI_MPELENCHI_FPELENCHI = CPNAME + "_" + MULTIPANEL_MPELENCHI + "_" + "fpElenchi";

	public static final String MULTIPANEL_MPUPLOADRAPPPROVAFIRMATO = "mpUploadRappProvaFirmato";
	public static final String MPI_MPUPLOADRAPPPROVAFIRMATO_FPUPLOADRAPPPROVAFIRMATO = CPNAME + "_"
			+ MULTIPANEL_MPUPLOADRAPPPROVAFIRMATO + "_" + "fpUploadRappProvaFirmato";

	public static final String MULTIPANEL_MPAZIONIISPEZIONE = "mpAzioniIspezione";
	public static final String MPI_MPAZIONIISPEZIONE_FPCONCLUDIISPEZIONE = CPNAME + "_" + MULTIPANEL_MPAZIONIISPEZIONE
			+ "_" + "fpConcludiIspezione";
	public static final String MPI_MPAZIONIISPEZIONE_FPASSEGNAISPEZIONE = CPNAME + "_" + MULTIPANEL_MPAZIONIISPEZIONE
			+ "_" + "fpAssegnaIspezione";
	public static final String MPI_MPAZIONIISPEZIONE_FPASSOCIACODICEIMPIANTO = CPNAME + "_"
			+ MULTIPANEL_MPAZIONIISPEZIONE + "_" + "fpAssociaCodiceImpianto";

	/** 
	 * Restituisce il tab correntemente visibile in un determinato tab set
	 */
	private String getCurrentTab(Map session, String tabSetName) {
		String value = (String) session.get(CPNAME + "_" + tabSetName + "_selectedMultiPanel");
		return value;
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo loadComuni definito in un ExecCommand del
	 * ContentPanel cpDettaglioIspezione2018
	 */
	public ExecResults loadComuni(

			it.csi.sigit.sigitwebn.dto.elenco_ispezioni_impianti.CpDettaglioIspezione2018Model theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String LOADCOMUNI_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-500176300) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			// impostazione del result code 
			result.setResultCode(LOADCOMUNI_OUTCOME_CODE__OK);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::loadComuni] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo salvaIspezione definito in un ExecCommand del
	 * ContentPanel cpDettaglioIspezione2018
	 */
	public ExecResults salvaIspezione(

			it.csi.sigit.sigitwebn.dto.elenco_ispezioni_impianti.CpDettaglioIspezione2018Model theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String SALVAISPEZIONE_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String SALVAISPEZIONE_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		final String SALVAISPEZIONE_OUTCOME_CODE__OK_OLD = //NOSONAR  Reason:EIAS
				"OK_OLD"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R807726554) ENABLED START*/

			//il salva viene invocato o in fase di creazione dell'ispezione o in fase di modifica
			Ispezione2018 ispezione = theModel.getAppDataIspezione2018();
			log.debug("###################################");
			log.debug("CPBECpDettaglioIspezione2018.salvaIspezione");

			if (log.isDebugEnabled())
				GenericUtil.stampa(ispezione, true, 3);

			try {
				getValidationMgr().validazioneSalvaIspezione(ispezione);
				if (GenericUtil.isNotNullOrEmpty(ispezione.getCodIstatProv())) {
					if (ispezione.getIdentificativoIspezione() == null) {
						//inserimento ispezione
						Ispezione2018 ispezioneNew = getSigitMgr().inserisciIspezione(ispezione);

						// Devo inviare la mail agli ispettori
						ResultInvioMail resultInvioMail = getServiziMgr().sendMailInserisciIspezione(ispezioneNew);

						String msg = GenericUtil.getMsgFormatterHtml(resultInvioMail,
								Messages.MSG_AGGIORNAMENTO_CORRETTO);

						theModel.setAppDataIspezione2018(ispezioneNew);
						//inserimento messaggio di salvataggio
						//result.getGlobalMessages().add(Messages.INFO_INSERIMENTO_CORRETTO);

						theModel.getSession().put(Constants.SESSIONE_VAR_MESSAGGE, new Message(msg, Message.INFO));

						theModel.setAppDataidIspezioneSelezionato(
								ConvertUtil.convertToInteger(ispezioneNew.getIdentificativoIspezione()));
					} else {
						//modifica ispezione
						getSigitMgr().modificaIspezioneDaDettaglio(ispezione, theModel.getAppDatautenteLoggato());

						theModel.getSession().put(Constants.SESSIONE_VAR_MESSAGGE,
								new Message(Messages.MSG_AGGIORNAMENTO_CORRETTO, Message.INFO));
						//result.getGlobalMessages().add(Messages.INFO_MODIFICA_CORRETTA);

					}

					caricaIspezione(theModel);

					//impostazioni per il refresh della pagina
					theModel.setAppDataaggiornaDati(Boolean.TRUE);

					theModel.setAppDatamessaggioDinamico(null);

					log.debug("Stampo result.getGlobalMessages(): " + result.getGlobalMessages());

					result.setResultCode(SALVAISPEZIONE_OUTCOME_CODE__OK);
				} else {
					result.getGlobalErrors().add("Inserire la provincia di competenza");
					result.setResultCode(SALVAISPEZIONE_OUTCOME_CODE__KO);
				}
			} catch (ManagerException ex) {

				Validator.gestisciEccezione(result, ex);
			}
			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::salvaIspezione] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo avviaSanzione definito in un ExecCommand del
	 * ContentPanel cpDettaglioIspezione2018
	 */
	public ExecResults avviaSanzione(

			it.csi.sigit.sigitwebn.dto.elenco_ispezioni_impianti.CpDettaglioIspezione2018Model theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String AVVIASANZIONE_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String AVVIASANZIONE_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-1010995937) ENABLED START*/

			//viene preparata la nuova sanzione
			DatiInserimentoSanzione nuovaSanzione = new DatiInserimentoSanzione();
			nuovaSanzione
					.setIspezioneAssociata(ConvertUtil.convertToString(theModel.getAppDataidIspezioneSelezionato()));
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
	 * ContentPanel cpDettaglioIspezione2018
	 */
	public ExecResults visualizzaSanzione(

			it.csi.sigit.sigitwebn.dto.elenco_ispezioni_impianti.CpDettaglioIspezione2018Model theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String VISUALIZZASANZIONE_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String VISUALIZZASANZIONE_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-2021737094) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			try {

				getValidationMgr().checkSelezioneElemento(
						ConvertUtil.convertToString(theModel.getAppDataidSanzioneSelezionata()));

				theModel.setAppDatapaginaChiamanteDettaglioSanzione("ISPEZIONE");

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
	 * Implementazione del metodo preparaDownloadRappProvaFirmato definito in un ExecCommand del
	 * ContentPanel cpDettaglioIspezione2018
	 */
	public ExecResults preparaDownloadRappProvaFirmato(

			it.csi.sigit.sigitwebn.dto.elenco_ispezioni_impianti.CpDettaglioIspezione2018Model theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String PREPARADOWNLOADRAPPPROVAFIRMATO_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String PREPARADOWNLOADRAPPPROVAFIRMATO_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-1530253585) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			Integer rappProvaSelezionato = ConvertUtil.convertToInteger(theModel.getIdRiga());

			theModel.getSession().put(Constants.SESSIONE_VAR_ID_ALLEGATO,
					ConvertUtil.convertToString(rappProvaSelezionato));

			// impostazione del result code 
			result.setResultCode(PREPARADOWNLOADRAPPPROVAFIRMATO_OUTCOME_CODE__OK);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::preparaDownloadRappProvaFirmato] Errore occorso nell'esecuzione del metodo:" + e,
					e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo inserisciRapProva definito in un ExecCommand del
	 * ContentPanel cpDettaglioIspezione2018
	 */
	public ExecResults inserisciRapProva(

			it.csi.sigit.sigitwebn.dto.elenco_ispezioni_impianti.CpDettaglioIspezione2018Model theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String INSERISCIRAPPROVA_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String INSERISCIRAPPROVA_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R270380141) ENABLED START*/

			//viene settata l'ispezione selezionata
			Ispezione2018 ispezione = theModel.getAppDataIspezione2018();

			//setta l'idIspezioneSelezionato che verra' usata nella pagina di inizializzazione dell'allegato
			theModel.setAppDataidIspezioneSelezionato(
					ConvertUtil.convertToInteger(ispezione.getIdentificativoIspezione()));
			theModel.setAppDataidAllegatoIspSelezionato(null);

			DettaglioAllegato nuovoAllegato = new DettaglioAllegato();
			nuovoAllegato.setArrivoDa(Constants.ARRIVO_DA_IMPIANTO_ISP);

			theModel.setAppDataallegatoIsp(nuovoAllegato);

			try {
				if (GenericUtil.isNullOrEmpty(ispezione.getIdIspezIspet())) {
					throw new ValidationManagerException(new Message(Messages.ERRORE_ISPEZIONE_NO_ISPETTORE_AZIONE,
							"inserire un rapporto di prova"));
				}

				getValidationMgr().verificaLibrettoPerRapportiProva(ispezione.getCodiceImpianto());

				result.setResultCode(INSERISCIRAPPROVA_OUTCOME_CODE__OK);
			} catch (ManagerException e) {
				Validator.gestisciEccezione(result, e);
			}

			result.setModel(theModel);
			return result;

			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::inserisciRapProva] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo modificaRapProva definito in un ExecCommand del
	 * ContentPanel cpDettaglioIspezione2018
	 */
	public ExecResults modificaRapProva(

			it.csi.sigit.sigitwebn.dto.elenco_ispezioni_impianti.CpDettaglioIspezione2018Model theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String MODIFICARAPPROVA_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String MODIFICARAPPROVA_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-1031021046) ENABLED START*/
			try {
				//prima si verifica se e' stato selezionato o no il rapporto di prova da modificare
				Integer rappProvaSelezionato = theModel.getAppDataidAllegatoIspSelezionato();
				getValidationMgr().checkSelezioneElemento(ConvertUtil.convertToString(rappProvaSelezionato));

				//il sistema verifica lo stato del rapporto di prova (sara' modificabile solo se si trova nello stato bozza)
				DettaglioAllegato allegato = getDbMgr().getDettaglioAllegatoById(rappProvaSelezionato);
				//allegato.setIdIspezione2018(theModel.getAppDataidIspezioneSelezionato());

				if (!allegato.getIdStatoRapporto().equals(Constants.ID_STATO_RAPPORTO_BOZZA)) {
					throw new ValidationManagerException(new Message(Messages.S040_RAPP_PROVA));
				}

				allegato.setCodFiscaleUtenteLoggato(
						ReplaceSpecialCharUtils.sanitize(theModel.getAppDatautenteLoggato().getCodiceFiscale()));

				allegato.setFlagControlloBozza(Constants.FLAG_CONTROLLO_BOZZA_ALLEGATO_FALSE);

				allegato.setArrivoDa(Constants.ARRIVO_DA_IMPIANTO_ISP);

				allegato.setCodiceBollino(MapDto.costruisciCodiceBollino(allegato.getSiglaBollino(),
						ConvertUtil.convertToBigDecimal(allegato.getNumeroBollinoVerde())));

				theModel.setAppDataallegatoIsp(allegato);

				//rimetto in sessione l'oggetto dettaglio allegato per la action showRappProvaNow che genera con IText
				theModel.getSession().put(Constants.SESSIONE_VAR_DETT_ALLEGATO, allegato);

				result.setResultCode(MODIFICARAPPROVA_OUTCOME_CODE__OK);
			} catch (ManagerException ex) {

				Validator.gestisciEccezione(result, ex);
			}

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::modificaRapProva] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo dettaglioRapProva definito in un ExecCommand del
	 * ContentPanel cpDettaglioIspezione2018
	 */
	public ExecResults dettaglioRapProva(

			it.csi.sigit.sigitwebn.dto.elenco_ispezioni_impianti.CpDettaglioIspezione2018Model theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String DETTAGLIORAPPROVA_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String DETTAGLIORAPPROVA_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R2132040845) ENABLED START*/
			try {
				//prima si verifica se e' stato selezionato o no il rapporto di prova da modificare
				Integer rappProvaSelezionato = theModel.getAppDataidAllegatoIspSelezionato();
				getValidationMgr().checkSelezioneElemento(ConvertUtil.convertToString(rappProvaSelezionato));

				//il sistema verifica lo stato del rapporto di prova (sara' visualizzabile solo se si trova nello stato diverso da bozza)
				DettaglioAllegato allegato = getDbMgr().getDettaglioAllegatoById(rappProvaSelezionato);
				allegato.setIdIspezione2018(theModel.getAppDataidIspezioneSelezionato());
				allegato.setArrivoDa(Constants.ARRIVO_DA_IMPIANTO_ISP);

				if (allegato.getIdStatoRapporto().equals(Constants.ID_STATO_RAPPORTO_BOZZA)) {
					throw new ValidationManagerException(new Message(Messages.S041_RAPP_PROVA));
				}

				theModel.getSession().put(Constants.SESSIONE_VAR_ID_ALLEGATO,
						ConvertUtil.convertToString(rappProvaSelezionato));

				theModel.getSession().put(Constants.SESSIONE_VAR_ID_IMPIANTO, allegato.getCodiceImpianto());

				theModel.setAppDataallegatoIsp(allegato);

				result.setResultCode(DETTAGLIORAPPROVA_OUTCOME_CODE__OK);
			} catch (ManagerException ex) {

				Validator.gestisciEccezione(result, ex);
			}

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::dettaglioRapProva] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo annullaRapProva definito in un ExecCommand del
	 * ContentPanel cpDettaglioIspezione2018
	 */
	public ExecResults annullaRapProva(

			it.csi.sigit.sigitwebn.dto.elenco_ispezioni_impianti.CpDettaglioIspezione2018Model theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String ANNULLARAPPROVA_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String ANNULLARAPPROVA_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R986483563) ENABLED START*/
			try {
				//validazione della selezione
				Integer rappProvaSelezionato = theModel.getAppDataidAllegatoIspSelezionato();
				getValidationMgr().checkSelezioneElemento(ConvertUtil.convertToString(rappProvaSelezionato));

				//il sistema verifica lo stato dell'ispezione: se in stato consolidato errore
				Ispezione2018 ispezione = getSigitMgr().caricaIspezioneDaId(
						ConvertUtil.convertToString(theModel.getAppDataidIspezioneSelezionato()), false, false);

				if (ConvertUtil.convertToInteger(ispezione.getIdStatoIspezione())
						.equals(Constants.ID_STATO_ISPEZIONE_CONSOLIDATO)) {
					throw new ValidationManagerException(new Message(Messages.S045_RAPP_PROVA));
				}

				//il sistema verifica lo stato del rapp di prova: se RESPINTO - > errore
				DettaglioAllegato allegato = getDbMgr().getDettaglioAllegatoById(rappProvaSelezionato);

				if (allegato.getIdStatoRapporto().equals(Constants.ID_STATO_RAPPORTO_RESPINTO)) {
					throw new ValidationManagerException(new Message(Messages.S045_RAPP_PROVA_2));
				}
				//se BOZZA/INVIATO -> viene visualizzata la dialog
				Message msg = new Message(Messages.C004);
				theModel.setAppDatamessaggioDinamico(ReplaceSpecialCharUtils.sanitize(msg.getText()));

				result.setResultCode(ANNULLARAPPROVA_OUTCOME_CODE__OK);

			} catch (ManagerException e) {
				Validator.gestisciEccezione(result, e);
			}

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::annullaRapProva] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo preparaInvioRapProva definito in un ExecCommand del
	 * ContentPanel cpDettaglioIspezione2018
	 */
	public ExecResults preparaInvioRapProva(

			it.csi.sigit.sigitwebn.dto.elenco_ispezioni_impianti.CpDettaglioIspezione2018Model theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String PREPARAINVIORAPPROVA_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String PREPARAINVIORAPPROVA_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-1512647682) ENABLED START*/
			try {
				//prima si verifica se e' stato selezionato o no il rapporto di prova da modificare
				Integer rappProvaSelezionato = theModel.getAppDataidAllegatoIspSelezionato();
				getValidationMgr().checkSelezioneElemento(ConvertUtil.convertToString(rappProvaSelezionato));

				getValidationMgr().isRappProvaInviabile(rappProvaSelezionato);

				//se BOZZA/INVIATO -> viene visualizzata la dialog
				Message msg = new Message(Messages.C003, "Rapporto di prova");
				theModel.setAppDatamessaggioDinamico(msg.getText());

				result.setResultCode(PREPARAINVIORAPPROVA_OUTCOME_CODE__OK);
			} catch (ManagerException ex) {

				Validator.gestisciEccezione(result, ex);
			}

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::preparaInvioRapProva] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo preparaUploadRappProvaFirmato definito in un ExecCommand del
	 * ContentPanel cpDettaglioIspezione2018
	 */
	public ExecResults preparaUploadRappProvaFirmato(

			it.csi.sigit.sigitwebn.dto.elenco_ispezioni_impianti.CpDettaglioIspezione2018Model theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String PREPARAUPLOADRAPPPROVAFIRMATO_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String PREPARAUPLOADRAPPPROVAFIRMATO_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-2089187562) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			try {

				Integer rappProvaSelezionato = theModel.getAppDataidAllegatoIspSelezionato();

				getValidationMgr().checkSelezioneElemento(ConvertUtil.convertToString(rappProvaSelezionato));

				DettaglioAllegato allegato = getDbMgr().getDettaglioAllegatoById(rappProvaSelezionato);

				if (!allegato.getIdStatoRapporto().equals(Constants.ID_STATO_RAPPORTO_INVIATO)) {
					throw new ValidationManagerException(
							new Message(Messages.ERROR_STATO_RAPP_PROVA_UPLOAD_DOCUMENTO_FIRMATO));
				}

				theModel.setAppDataallegatoIsp(allegato);

				result.setResultCode(PREPARAUPLOADRAPPPROVAFIRMATO_OUTCOME_CODE__OK);

			} catch (ManagerException ex) {

				Validator.gestisciEccezione(result, ex);
			}

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::preparaUploadRappProvaFirmato] Errore occorso nell'esecuzione del metodo:" + e,
					e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo uploadRappProvaFirmato definito in un ExecCommand del
	 * ContentPanel cpDettaglioIspezione2018
	 */
	public ExecResults uploadRappProvaFirmato(

			it.csi.sigit.sigitwebn.dto.elenco_ispezioni_impianti.CpDettaglioIspezione2018Model theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String UPLOADRAPPPROVAFIRMATO_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String UPLOADRAPPPROVAFIRMATO_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-303623373) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			try {

				File file = theModel.getWidg_fuUploadRappProvaFirmato();
				if (file != null) {

					String nomeFile = theModel.getWidg_fuUploadRappProvaFirmatoFileName();
					String contType = theModel.getWidg_fuUploadRappProvaFirmatoContentType();

					getValidationMgr().validazioneFormaleFileRappProvaFirmato(file, nomeFile, contType);

					getSigitMgr().uploadRapportoProvaFirmato(theModel.getAppDataallegatoIsp(), file, nomeFile,
							theModel.getAppDatautenteLoggato());

					caricaAllegati(theModel);

					result.getGlobalMessages().add(Messages.INFO_DOCUMENTO_IMPORTATO_CORRETTAMENTE);

					result.setResultCode(UPLOADRAPPPROVAFIRMATO_OUTCOME_CODE__OK);
				} else {

					throw new ValidationManagerException(new Message(Messages.FILE_NON_SELEZIONATO));
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
			log.error("[BackEndFacade::uploadRappProvaFirmato] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo downloadFile definito in un ExecCommand del
	 * ContentPanel cpDettaglioIspezione2018
	 */
	public ExecResults downloadFile(

			it.csi.sigit.sigitwebn.dto.elenco_ispezioni_impianti.CpDettaglioIspezione2018Model theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String DOWNLOADFILE_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String DOWNLOADFILE_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-1560314203) ENABLED START*/

			log.debug("STAMPO LA RIGA SELEZIONATA: *" + theModel.getIdRiga() + "*");
			log.debug("STAMPO LA COLONNA SELEZIONATA: *" + theModel.getIdColonna() + "*");

			Integer idDocumento = ConvertUtil.convertToInteger(theModel.getIdRiga());
			SigitTDocAzioneDto documentoDb = getDbAzioneMgr().cercaDocAzioneById(idDocumento);

			Documento documentoInSessione = new Documento();
			documentoInSessione.setUidIndex(documentoDb.getUidIndex());
			documentoInSessione.setNomeDocOrig(documentoDb.getNomeDocOriginale());

			theModel.getSession().put(Constants.SESSIONE_VAR_DOCUMENTO_SELEZIONATO, documentoInSessione);

			result.setResultCode(DOWNLOADFILE_OUTCOME_CODE__OK);

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
	 * ContentPanel cpDettaglioIspezione2018
	 */
	public ExecResults inserisciAzione(

			it.csi.sigit.sigitwebn.dto.elenco_ispezioni_impianti.CpDettaglioIspezione2018Model theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String INSERISCIAZIONE_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String INSERISCIAZIONE_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R1561453358) ENABLED START*/
			theModel.setAppDataidTipoAzione(Constants.ID_TIPO_AZIONE_ISPEZIONE);
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
	 * ContentPanel cpDettaglioIspezione2018
	 */
	public ExecResults impostaNuovaSveglia(

			it.csi.sigit.sigitwebn.dto.elenco_ispezioni_impianti.CpDettaglioIspezione2018Model theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String IMPOSTANUOVASVEGLIA_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R1857698342) ENABLED START*/

			theModel.setAppDataidAzioneSelezionata(theModel.getAppDataIspezione2018().getIdentificativoIspezione());
			theModel.setAppDataidTipoAzione(Constants.ID_TIPO_AZIONE_ISPEZIONE);

			result.setResultCode(IMPOSTANUOVASVEGLIA_OUTCOME_CODE__OK);

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
	 * ContentPanel cpDettaglioIspezione2018
	 */
	public ExecResults visualizzaVerifica(

			it.csi.sigit.sigitwebn.dto.elenco_ispezioni_impianti.CpDettaglioIspezione2018Model theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String VISUALIZZAVERIFICA_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R330589674) ENABLED START*/
			theModel.setAppDataidVerificaSelezionata(theModel.getAppDataIspezione2018().getIdVerifica());

			result.setResultCode(VISUALIZZAVERIFICA_OUTCOME_CODE__OK);

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
	 * Implementazione del metodo visualizzaAccertamento definito in un ExecCommand del
	 * ContentPanel cpDettaglioIspezione2018
	 */
	public ExecResults visualizzaAccertamento(

			it.csi.sigit.sigitwebn.dto.elenco_ispezioni_impianti.CpDettaglioIspezione2018Model theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String VISUALIZZAACCERTAMENTO_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R1632272251) ENABLED START*/

			theModel.setAppDataidAccertamentoSelezionato(theModel.getAppDataIspezione2018().getIdAccertamento());
			result.setResultCode(VISUALIZZAACCERTAMENTO_OUTCOME_CODE__OK);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

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
	 * Implementazione del metodo preparaConcludiIspezione definito in un ExecCommand del
	 * ContentPanel cpDettaglioIspezione2018
	 */
	public ExecResults preparaConcludiIspezione(

			it.csi.sigit.sigitwebn.dto.elenco_ispezioni_impianti.CpDettaglioIspezione2018Model theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String PREPARACONCLUDIISPEZIONE_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String PREPARACONCLUDIISPEZIONE_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R1826039651) ENABLED START*/
			try {
				getValidationMgr().validazionePraparaConcludiIspezione(theModel.getAppDataIspezione2018(),
						theModel.getAppDataelencoAllegatiIsp());

				//viene svuotato il set di dati per la conclusione
				ConclusioneIspezione2018 concludiIsp = new ConclusioneIspezione2018();
				// riporto le note, l'utente le potra' modificare
				concludiIsp.setNote(ReplaceSpecialCharUtils.sanitize(theModel.getAppDataIspezione2018().getNote()));
				theModel.setAppDataConclusioneIspezione2018(concludiIsp);

				result.setResultCode(PREPARACONCLUDIISPEZIONE_OUTCOME_CODE__OK);

			} catch (ManagerException ex) {
				Validator.gestisciEccezione(result, ex);
			}

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::preparaConcludiIspezione] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo preparaAnnullamentoIspezione definito in un ExecCommand del
	 * ContentPanel cpDettaglioIspezione2018
	 */
	public ExecResults preparaAnnullamentoIspezione(

			it.csi.sigit.sigitwebn.dto.elenco_ispezioni_impianti.CpDettaglioIspezione2018Model theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String PREPARAANNULLAMENTOISPEZIONE_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String PREPARAANNULLAMENTOISPEZIONE_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R1762947960) ENABLED START*/
			try {

				//e' possibile annullare le ispezioni se non ci sono sanzioni valide ad essa associate
				getValidationMgr().validazioneAnnullaIspezione(theModel.getAppDataIspezione2018());

				Message msg = new Message(Messages.C005,
						theModel.getAppDataIspezione2018().getIdentificativoIspezione());
				theModel.setAppDatamessaggioDinamico(ReplaceSpecialCharUtils.sanitize(msg.getText()));

				//				Message msg = new Message(Messages.MSG_CONFERMA_ANNULLA_ISPEZIONE);
				//				theModel.setAppDatamessaggioDinamico(msg.getText());
				//
				result.setResultCode(PREPARAANNULLAMENTOISPEZIONE_OUTCOME_CODE__OK);

			} catch (ManagerException ex) {
				Validator.gestisciEccezione(result, ex);
			}

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::preparaAnnullamentoIspezione] Errore occorso nell'esecuzione del metodo:" + e,
					e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo assegnaA definito in un ExecCommand del
	 * ContentPanel cpDettaglioIspezione2018
	 */
	public ExecResults assegnaA(

			it.csi.sigit.sigitwebn.dto.elenco_ispezioni_impianti.CpDettaglioIspezione2018Model theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String ASSEGNAA_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String ASSEGNAA_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-955756418) ENABLED START*/

			//si controlla se l'elenco dei possibili ispettori risulta popolato
			theModel.setAppDataelencoIspettori(getSigitMgr().getElencoIspettoriIdPf(true));

			result.setResultCode(ASSEGNAA_OUTCOME_CODE__OK);

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::assegnaA] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo preparaAssociazioneCodiceImpianto definito in un ExecCommand del
	 * ContentPanel cpDettaglioIspezione2018
	 */
	public ExecResults preparaAssociazioneCodiceImpianto(

			it.csi.sigit.sigitwebn.dto.elenco_ispezioni_impianti.CpDettaglioIspezione2018Model theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String PREPARAASSOCIAZIONECODICEIMPIANTO_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R175823178) ENABLED START*/

			//viene svuotato l'appdata usato per l'associazione
			RicercaImpiantoDaAssociare ricercaImpianto = new RicercaImpiantoDaAssociare();
			ricercaImpianto.setCodiceImpianto(null);
			ricercaImpianto.setResponsabile(null);
			ricercaImpianto.setRicercaEseguita(false);
			ricercaImpianto.setUbicazione(null);

			theModel.setAppDataRicercaImpiantoDaAssociare(ricercaImpianto);

			result.setResultCode(PREPARAASSOCIAZIONECODICEIMPIANTO_OUTCOME_CODE__OK);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error(
					"[BackEndFacade::preparaAssociazioneCodiceImpianto] Errore occorso nell'esecuzione del metodo:" + e,
					e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo preparaDialogConclusioneIspezione definito in un ExecCommand del
	 * ContentPanel cpDettaglioIspezione2018
	 */
	public ExecResults preparaDialogConclusioneIspezione(

			it.csi.sigit.sigitwebn.dto.elenco_ispezioni_impianti.CpDettaglioIspezione2018Model theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String PREPARADIALOGCONCLUSIONEISPEZIONE_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String PREPARADIALOGCONCLUSIONEISPEZIONE_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R45439154) ENABLED START*/
			//vengono prima controllati i dati del form per la conclusione
			try {
				//ConclusioneIspezione2018 input = theModel.getAppDataConclusioneIspezione2018();

				getValidationMgr().validazioneConfermaConcludiIspezione(theModel.getAppDataConclusioneIspezione2018());

				/*
				ValidationManagerException validationEx = new ValidationManagerException();
				
				if (GenericUtil.isNullOrEmpty(input.getEnteCompetente())) {
					validationEx.addFieldRequired(APPDATA_CONCLUSIONEISPEZIONE2018_CODE + ".enteCompetente");
				}
				
				if (GenericUtil.isNullOrEmpty(input.getFlgEsito())) {
					validationEx.addFieldRequired(APPDATA_CONCLUSIONEISPEZIONE2018_CODE + ".flgEsito");
				}
				
				if (validationEx.getFieldList().size() > 0) {
					throw validationEx;
				}
				 */
				//				Message msg = new Message(
				//						"Si conferma la conclusione dell'ispezione? Eventuali Rapporti Di Prova in stato BOZZA verranno eliminati");
				Message msg = new Message("Si conferma la conclusione dell'ispezione?");
				theModel.setAppDatamessaggioDinamico(ReplaceSpecialCharUtils.sanitize(msg.getText()));

				// impostazione del result code 
				result.setResultCode(PREPARADIALOGCONCLUSIONEISPEZIONE_OUTCOME_CODE__OK);

			} catch (ManagerException e) {
				Validator.gestisciEccezione(result, e);
			}

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error(
					"[BackEndFacade::preparaDialogConclusioneIspezione] Errore occorso nell'esecuzione del metodo:" + e,
					e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo confermaAssegnazioneIspezione definito in un ExecCommand del
	 * ContentPanel cpDettaglioIspezione2018
	 */
	public ExecResults confermaAssegnazioneIspezione(

			it.csi.sigit.sigitwebn.dto.elenco_ispezioni_impianti.CpDettaglioIspezione2018Model theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String CONFERMAASSEGNAZIONEISPEZIONE_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String CONFERMAASSEGNAZIONEISPEZIONE_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R1308870013) ENABLED START*/
			try {
				//validazione sull'ispettore selezionato
				if (GenericUtil.isNullOrEmpty(theModel.getAppDataIspettoreScelto())) {
					ValidationManagerException ex = new ValidationManagerException();
					ex.addFieldRequired(CPBECpDettaglioIspezione2018.APPDATA_ISPETTORESCELTO_CODE);
					throw ex;
				}

				if (theModel.getAppDataIspettoreScelto()
						.equals(ConvertUtil.convertToString(theModel.getAppDataIspezione2018().getIdPfIspettore()))) {
					throw new ValidationManagerException(new Message(Messages.ERRORE_ISPEZIONE_ISPETTORE_UGUALE));
				}

				//				XXX
				//				BEPPE
				//				theModel.getAppDataIspezione2018().getDescrizioneIspettore()IdentificativoIspezione().

				//nell'appdata e' contenuto l'id della pf dell'ispettore scelto. dato il codice_impianto, l'id della persona da cercare e il ruolo ispettore
				//si cerca la riga ATTIVA (con datafine null) corrispondente nella tabella r_imp_ruolo_pf_pg 
				String infoEmail = getSigitMgr().associaIspezione(
						ReplaceSpecialCharUtils
								.sanitize(theModel.getAppDataIspezione2018().getIdentificativoIspezione()),
						ReplaceSpecialCharUtils.sanitize(theModel.getAppDataIspettoreScelto()),
						theModel.getAppDatautenteLoggato());

				//una volta terminata l'assegnazione viene ricaricato il dettaglio dell'ispezione
				theModel.setAppDataIspezione2018(getSigitMgr().caricaIspezioneDaId(
						theModel.getAppDataIspezione2018().getIdentificativoIspezione(), true, true));

				caricaAzioni(theModel);

				result.getGlobalMessages().add(Messages.MSG_AGGIORNAMENTO_CORRETTO + infoEmail);

				/*
				theModel.getSession().put(Constants.SESSIONE_VAR_MESSAGGE,
						new Message(Messages.MSG_AGGIORNAMENTO_CORRETTO + infoEmail, Message.INFO));
				
				GenericUtil.gestisciMessaggioSessione(theModel, result);
				*/
				log.debug("Stampo result.getGlobalMessages(): " + result.getGlobalMessages());

				result.setResultCode(CONFERMAASSEGNAZIONEISPEZIONE_OUTCOME_CODE__OK);

			} catch (ManagerException ex) {

				Validator.gestisciEccezione(result, ex);
			}

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::confermaAssegnazioneIspezione] Errore occorso nell'esecuzione del metodo:" + e,
					e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo cercaCodiceImpiantoDaAssociare definito in un ExecCommand del
	 * ContentPanel cpDettaglioIspezione2018
	 */
	public ExecResults cercaCodiceImpiantoDaAssociare(

			it.csi.sigit.sigitwebn.dto.elenco_ispezioni_impianti.CpDettaglioIspezione2018Model theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String CERCACODICEIMPIANTODAASSOCIARE_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String CERCACODICEIMPIANTODAASSOCIARE_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R886738604) ENABLED START*/
			try {

				getValidationMgr().validazioneFormaleAssociaCodiceImpiantoIspezione(
						theModel.getAppDataRicercaImpiantoDaAssociare());

				/*
				if (theModel.getAppDataRicercaImpiantoDaAssociare() == null || GenericUtil
						.isNullOrEmpty(theModel.getAppDataRicercaImpiantoDaAssociare().getCodiceImpianto())) {
					ValidationManagerException ex = new ValidationManagerException();
					ex.addFieldRequired(
							CPBECpDettaglioIspezione2018.APPDATA_RICERCAIMPIANTODAASSOCIARE_CODE + ".codiceImpianto");
					throw ex;
				}
				*/

				getSigitMgr().ricercaImpiantoPerIspezione(theModel.getAppDataRicercaImpiantoDaAssociare());

				// impostazione del result code 
				result.setResultCode(CERCACODICEIMPIANTODAASSOCIARE_OUTCOME_CODE__OK);
			} catch (ManagerException ex) {
				Validator.gestisciEccezione(result, ex);
			}

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::cercaCodiceImpiantoDaAssociare] Errore occorso nell'esecuzione del metodo:" + e,
					e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo resettaRicercaCodiceImpiantoDaAssociare definito in un ExecCommand del
	 * ContentPanel cpDettaglioIspezione2018
	 */
	public ExecResults resettaRicercaCodiceImpiantoDaAssociare(

			it.csi.sigit.sigitwebn.dto.elenco_ispezioni_impianti.CpDettaglioIspezione2018Model theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String RESETTARICERCACODICEIMPIANTODAASSOCIARE_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-1067678049) ENABLED START*/

			//deve essere resettato l'appdata della ricerca dell'impianto
			RicercaImpiantoDaAssociare ricercaImpianto = theModel.getAppDataRicercaImpiantoDaAssociare();
			ricercaImpianto.setCodiceImpianto(null);
			ricercaImpianto.setResponsabile(null);
			ricercaImpianto.setRicercaEseguita(false);
			ricercaImpianto.setUbicazione(null);
			result.setResultCode(RESETTARICERCACODICEIMPIANTODAASSOCIARE_OUTCOME_CODE__OK);

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error(
					"[BackEndFacade::resettaRicercaCodiceImpiantoDaAssociare] Errore occorso nell'esecuzione del metodo:"
							+ e,
					e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo confermaAssociazioneCodiceImpianto definito in un ExecCommand del
	 * ContentPanel cpDettaglioIspezione2018
	 */
	public ExecResults confermaAssociazioneCodiceImpianto(

			it.csi.sigit.sigitwebn.dto.elenco_ispezioni_impianti.CpDettaglioIspezione2018Model theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String CONFERMAASSOCIAZIONECODICEIMPIANTO_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String CONFERMAASSOCIAZIONECODICEIMPIANTO_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R191042818) ENABLED START*/
			try {
				RicercaImpiantoDaAssociare ricerca = theModel.getAppDataRicercaImpiantoDaAssociare();
				Ispezione2018 ispezione = theModel.getAppDataIspezione2018();

				getSigitMgr().associaImpiantoAdIspezione(ricerca.getCodiceImpianto(), ricerca.getCodIstatProv(),
						ispezione.getIdentificativoIspezione(), theModel.getAppDatautenteLoggato());

				//impostazioni per il refresh della pagina
				theModel.setAppDataaggiornaDati(Boolean.TRUE);

				theModel.setAppDatamessaggioDinamico(null);

				theModel.getSession().put(Constants.SESSIONE_VAR_MESSAGGE,
						new Message(Messages.MSG_AGGIORNAMENTO_CORRETTO, Message.INFO));

				result.setResultCode(CONFERMAASSOCIAZIONECODICEIMPIANTO_OUTCOME_CODE__OK);

			} catch (ManagerException ex) {
				Validator.gestisciEccezione(result, ex);
			}

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::confermaAssociazioneCodiceImpianto] Errore occorso nell'esecuzione del metodo:"
					+ e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo gestisciIndietro definito in un ExecCommand del
	 * ContentPanel cpDettaglioIspezione2018
	 */
	public ExecResults gestisciIndietro(

			it.csi.sigit.sigitwebn.dto.elenco_ispezioni_impianti.CpDettaglioIspezione2018Model theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GESTISCIINDIETRO_OUTCOME_CODE__VERIFICA = //NOSONAR  Reason:EIAS
				"VERIFICA"; //NOSONAR  Reason:EIAS
		final String GESTISCIINDIETRO_OUTCOME_CODE__ACCERTAMENTO = //NOSONAR  Reason:EIAS
				"ACCERTAMENTO"; //NOSONAR  Reason:EIAS
		final String GESTISCIINDIETRO_OUTCOME_CODE__RICERCA = //NOSONAR  Reason:EIAS
				"RICERCA"; //NOSONAR  Reason:EIAS
		final String GESTISCIINDIETRO_OUTCOME_CODE__SVEGLIE = //NOSONAR  Reason:EIAS
				"SVEGLIE"; //NOSONAR  Reason:EIAS
		final String GESTISCIINDIETRO_OUTCOME_CODE__SCHEDA_13 = //NOSONAR  Reason:EIAS
				"SCHEDA_13"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R1620557796) ENABLED START*/

			//sulla base dell'origine dell'ispezione si capisce a quale form ritornare
			Ispezione2018 ispezione = theModel.getAppDataIspezione2018();

			//se l'identificativo dell'ispezione e' not null vuol dire che l'ispezione e' stata creata
			//quindi l'origine puo' essere recuperata in maniera sicura da db
			//			if (GenericUtil.isNotNullOrEmpty(ispezione.getIdentificativoIspezione())
			//					&& !"0".equals(ispezione.getIdentificativoIspezione())) {
			//				Integer origine = getSigitMgr().getDbIspezioneMgr().getOrigineIspezioneDaDb(null,
			//						ConvertUtil.convertToInteger(ispezione.getIdentificativoIspezione()));
			//				if (Constants.ID_TIPO_AZIONE_ACCERTAMENTO == origine) {
			//					result.setResultCode(GESTISCIINDIETRO_OUTCOME_CODE__ACCERTAMENTO);
			//				} else {
			//					result.setResultCode(GESTISCIINDIETRO_OUTCOME_CODE__VERIFICA);
			//				}
			//			} else if (isIspezioneDaAccertamento(theModel)) {
			//				result.setResultCode(GESTISCIINDIETRO_OUTCOME_CODE__ACCERTAMENTO);
			//			} else if (isIspezioneDaVerifica(theModel)) {
			//				result.setResultCode(GESTISCIINDIETRO_OUTCOME_CODE__VERIFICA);
			//			}

			if (Constants.PAG_ELENCO_VERIFICHE.equals(theModel.getAppDatapaginaChiamante())) {
				theModel.setAppDataidVerificaSelezionata(ispezione.getIdVerifica());
				result.setResultCode(GESTISCIINDIETRO_OUTCOME_CODE__VERIFICA);
			}

			if (Constants.PAG_ELENCO_ACCERTAMENTI.equals(theModel.getAppDatapaginaChiamante())) {
				theModel.setAppDataidAccertamentoSelezionato(ispezione.getIdAccertamento());
				result.setResultCode(GESTISCIINDIETRO_OUTCOME_CODE__ACCERTAMENTO);
			}

			if (Constants.PAG_ELENCO_ISPEZIONI.equals(theModel.getAppDatapaginaChiamante())) {
				result.setResultCode(GESTISCIINDIETRO_OUTCOME_CODE__RICERCA);
			}

			if (Constants.PAG_ELENCO_SVEGLIE.equals(theModel.getAppDatapaginaChiamante())) {
				result.setResultCode(GESTISCIINDIETRO_OUTCOME_CODE__SVEGLIE);
			}

			if (Constants.PAG_SCHEDA_13.equals(theModel.getAppDatapaginaChiamante())) {
				theModel.setAppDataidImpiantoSelez(theModel.getAppDataIspezione2018().getCodiceImpianto());
				result.setResultCode(GESTISCIINDIETRO_OUTCOME_CODE__SCHEDA_13);
			}

			theModel.setAppDatapaginaChiamante(null);

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
	 * Implementazione del metodo salvaInvioRappProva definito in un ExecCommand del
	 * ContentPanel cpDettaglioIspezione2018
	 */
	public ExecResults salvaInvioRappProva(

			it.csi.sigit.sigitwebn.dto.elenco_ispezioni_impianti.CpDettaglioIspezione2018Model theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String SALVAINVIORAPPPROVA_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String SALVAINVIORAPPPROVA_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R327019092) ENABLED START*/

			DettaglioAllegato dettaglioAllegato = getDbMgr()
					.getDettaglioAllegatoById(theModel.getAppDataidAllegatoIspSelezionato());

			log.debug("prima dell'invio");

			UtenteLoggato utenteLoggato = theModel.getAppDatautenteLoggato();
			log.debug("utenteLoggato: " + utenteLoggato);

			// Recupero l'utente loggato per capire se e' un CAT
			Ruolo ruoloUtente = utenteLoggato.getRuolo();

			getConnectorMgr().inviaRappProvaTrans(dettaglioAllegato, ruoloUtente.getIdPgCat(),
					ReplaceSpecialCharUtils.sanitize(utenteLoggato.getCodiceFiscale()));

			log.debug("dopo l'invio");

			// BUG - devo verificare che l'allegano non sia gia' in stato INVIATO, l'utente potrebbe aver fatto F5

			String msg = Messages.INFO_ALLEGATO_RAPP_PROVA_INVIATO_CORRETTAMENTE;

			if (getValidationMgr().isImpiantoSenzaValvoleTermostatiche(dettaglioAllegato.getDataControllo(),
					ConvertUtil.convertToBigDecimal(dettaglioAllegato.getCodiceImpianto()), true)) {
				msg += Messages.INFO_ALLEGATO_INVIATO_IMP_NON_VALVOLE;
			}

			theModel.getSession().put(Constants.SESSIONE_VAR_MESSAGGE, new Message(msg, Message.INFO));

			// ricarico l'elenco dei rapporti di prova
			ArrayList<DettaglioAllegato> elencoAllegati = getSigitMgr().cercaRappProvaPerIdIspezione(
					ConvertUtil.convertToInteger(theModel.getAppDataIspezione2018().getIdentificativoIspezione()));

			theModel.setAppDataelencoAllegatiIsp(elencoAllegati);

			// pulisco questo campo, altrimenti poi viene visualizzato sull'elenco
			theModel.setAppDatamessaggioDinamico(null);

			result.setResultCode(SALVAINVIORAPPPROVA_OUTCOME_CODE__OK);

			result.setModel(theModel);
			return result;

			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::salvaInvioRappProva] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo annullaInvioRappProva definito in un ExecCommand del
	 * ContentPanel cpDettaglioIspezione2018
	 */
	public ExecResults annullaInvioRappProva(

			it.csi.sigit.sigitwebn.dto.elenco_ispezioni_impianti.CpDettaglioIspezione2018Model theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String ANNULLAINVIORAPPPROVA_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R507456112) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			// impostazione del result code 
			result.setResultCode(ANNULLAINVIORAPPPROVA_OUTCOME_CODE__OK);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::annullaInvioRappProva] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo salvaAnnullaRappProva definito in un ExecCommand del
	 * ContentPanel cpDettaglioIspezione2018
	 */
	public ExecResults salvaAnnullaRappProva(

			it.csi.sigit.sigitwebn.dto.elenco_ispezioni_impianti.CpDettaglioIspezione2018Model theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String SALVAANNULLARAPPPROVA_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String SALVAANNULLARAPPPROVA_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R1723442218) ENABLED START*/

			UtenteLoggato loggato = theModel.getAppDatautenteLoggato();

			//ricerca allegato da eliminare
			for (DettaglioAllegato allegato : theModel.getAppDataelencoAllegatiIsp()) {
				if (allegato.getIdAllegato()
						.equals(ConvertUtil.convertToString(theModel.getAppDataidAllegatoIspSelezionato()))) {
					getSigitMgr().eliminaAllegatoRappProva(
							ConvertUtil.convertToString(theModel.getAppDataidAllegatoIspSelezionato()),
							loggato.getCodiceFiscale(),
							Constants.RAPP_PROVA_ALLEGATO_TIPO_1.equals(allegato.getIdTipoAllegato())
									? Constants.TIPO_COMPONENTE_GT
									: Constants.TIPO_COMPONENTE_GF);
					break;
				}
			}

			//eliminazione dalla lista mostrata
			List<DettaglioAllegato> nuovaLista = new ArrayList<DettaglioAllegato>();
			for (DettaglioAllegato dettaglioOld : theModel.getAppDataelencoAllegatiIsp()) {
				if (!dettaglioOld.getIdAllegato()
						.equals(ConvertUtil.convertToString(theModel.getAppDataidAllegatoIspSelezionato()))) {
					nuovaLista.add(dettaglioOld);
				}
			}

			theModel.setAppDataelencoAllegatiIsp((ArrayList<DettaglioAllegato>) nuovaLista);

			theModel.setAppDataidAllegatoIspSelezionato(null);

			// impostazione del result code 
			result.setResultCode(SALVAANNULLARAPPPROVA_OUTCOME_CODE__OK);

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
	 * Implementazione del metodo confermaConclusioneIspezione definito in un ExecCommand del
	 * ContentPanel cpDettaglioIspezione2018
	 */
	public ExecResults confermaConclusioneIspezione(

			it.csi.sigit.sigitwebn.dto.elenco_ispezioni_impianti.CpDettaglioIspezione2018Model theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String CONFERMACONCLUSIONEISPEZIONE_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String CONFERMACONCLUSIONEISPEZIONE_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R966996690) ENABLED START*/
			try {
				//getValidationMgr().validazioneConfermaConcludiIspezione(theModel.getAppDataConclusioneIspezione2018());

				getConnectorMgr().concludiIspezione2018(theModel.getAppDataIspezione2018(),
						theModel.getAppDataConclusioneIspezione2018(), theModel.getAppDatautenteLoggato(),
						theModel.getAppDataelencoAllegatiIsp());

				theModel.setAppDataaggiornaDati(Boolean.TRUE);

				theModel.setAppDatamessaggioDinamico(null);

				theModel.getSession().put(Constants.SESSIONE_VAR_MESSAGGE,
						new Message(Messages.MSG_AGGIORNAMENTO_CORRETTO, Message.INFO));

				result.setResultCode(CONFERMACONCLUSIONEISPEZIONE_OUTCOME_CODE__OK);

			} catch (ManagerException ex) {
				Validator.gestisciEccezione(result, ex);
			}

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::confermaConclusioneIspezione] Errore occorso nell'esecuzione del metodo:" + e,
					e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo annullaIspezione definito in un ExecCommand del
	 * ContentPanel cpDettaglioIspezione2018
	 */
	public ExecResults annullaIspezione(

			it.csi.sigit.sigitwebn.dto.elenco_ispezioni_impianti.CpDettaglioIspezione2018Model theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String ANNULLAISPEZIONE_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String ANNULLAISPEZIONE_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R892013630) ENABLED START*/

			try {

				getConnectorMgr().annullaIspezione2018(theModel.getAppDataIspezione2018(),
						theModel.getAppDatautenteLoggato(), theModel.getAppDataelencoAllegatiIsp());

				theModel.setAppDataaggiornaDati(Boolean.TRUE);

				theModel.setAppDatamessaggioDinamico(null);

				theModel.getSession().put(Constants.SESSIONE_VAR_MESSAGGE,
						new Message(Messages.MSG_AGGIORNAMENTO_CORRETTO, Message.INFO));

				result.setResultCode(ANNULLAISPEZIONE_OUTCOME_CODE__OK);
			} catch (ManagerException ex) {
				Validator.gestisciEccezione(result, ex);
			}

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::annullaIspezione] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo isRuoloAbilitato definito in un ExecCommand del
	 * ContentPanel cpDettaglioIspezione2018
	 */
	public ExecResults isRuoloAbilitato(

			it.csi.sigit.sigitwebn.dto.elenco_ispezioni_impianti.CpDettaglioIspezione2018Model theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String ISRUOLOABILITATO_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R980412993) ENABLED START*/
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
	 * Implementazione del metodo preparaIspezione definito in un ExecCommand del
	 * ContentPanel cpDettaglioIspezione2018
	 */
	public ExecResults preparaIspezione(

			it.csi.sigit.sigitwebn.dto.elenco_ispezioni_impianti.CpDettaglioIspezione2018Model theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String PREPARAISPEZIONE_OUTCOME_CODE__OK_INSERIMENTO = //NOSONAR  Reason:EIAS
				"OK_INSERIMENTO"; //NOSONAR  Reason:EIAS
		final String PREPARAISPEZIONE_OUTCOME_CODE__OK_DETTAGLIO = //NOSONAR  Reason:EIAS
				"OK_DETTAGLIO"; //NOSONAR  Reason:EIAS
		final String PREPARAISPEZIONE_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R1357944596) ENABLED START*/
			//il metodo deve apprendere se si sta aprendo il form per una nuova ispezione o il dettaglio di una pre-esistente

			log.debug("preparaIspezione - getIdentificativoIspezione"
					+ theModel.getAppDataIspezione2018().getIdentificativoIspezione());

			if (theModel.getAppDataIspezione2018().getIdentificativoIspezione() != null) {
				caricaIspezione(theModel);
				log.debug("preparaIspezione - DETTAGLIO");
				result.setResultCode(PREPARAISPEZIONE_OUTCOME_CODE__OK_DETTAGLIO);

			} else {
				log.debug("preparaIspezione - INSERIMENTO");

				theModel.setAppDataelencoComuniPiemonteIstat(new ArrayList<>());

				if (theModel.getAppDataelencoProvincePiemonteIstat() == null
						|| theModel.getAppDataelencoProvincePiemonteIstat().isEmpty()) {
					theModel.setAppDataelencoProvincePiemonteIstat(getServiziMgr().getListaIstatProvincePiemonte());
				}
				result.setResultCode(PREPARAISPEZIONE_OUTCOME_CODE__OK_INSERIMENTO);
			}

			GenericUtil.gestisciMessaggioSessione(theModel, result);

			theModel.setAppDataaggiornaDati(Boolean.FALSE);
			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::preparaIspezione] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo gestisciAbilRuoloEnte definito in un ExecCommand del
	 * ContentPanel cpDettaglioIspezione2018
	 */
	public ExecResults gestisciAbilRuoloEnte(

			it.csi.sigit.sigitwebn.dto.elenco_ispezioni_impianti.CpDettaglioIspezione2018Model theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GESTISCIABILRUOLOENTE_OUTCOME_CODE__RUOLO_PA_PROVINCIA = //NOSONAR  Reason:EIAS
				"RUOLO_PA_PROVINCIA"; //NOSONAR  Reason:EIAS
		final String GESTISCIABILRUOLOENTE_OUTCOME_CODE__RUOLO_PA_COMUNE = //NOSONAR  Reason:EIAS
				"RUOLO_PA_COMUNE"; //NOSONAR  Reason:EIAS
		final String GESTISCIABILRUOLOENTE_OUTCOME_CODE__RUOLO_ALTRO = //NOSONAR  Reason:EIAS
				"RUOLO_ALTRO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-2027508007) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			// impostazione del result code
			if (GenericUtil.isNullOrEmpty(theModel.getAppDataIspezione2018().getCodiceImpianto())) {
				result = gestisciAbilRuoloRef(theModel, GESTISCIABILRUOLOENTE_OUTCOME_CODE__RUOLO_PA_PROVINCIA,
						GESTISCIABILRUOLOENTE_OUTCOME_CODE__RUOLO_PA_COMUNE,
						GESTISCIABILRUOLOENTE_OUTCOME_CODE__RUOLO_ALTRO);
			} else {
				SigitTImpiantoDto imp = sigitMgr
						.getImpiantoByCodice(theModel.getAppDataIspezione2018().getCodiceImpianto());
				theModel.setAppDataelencoComuniPiemonteIstat(getServiziMgr().getListaComuniByIstatProvincia(
						GenericUtil.getCodIstatProvByCodIstatComune(imp.getIstatComune())));
				theModel.setAppDataelencoProvincePiemonteIstat(getServiziMgr().getListaIstatProvincePiemonte());
				theModel.getAppDataIspezione2018().setCodIstatCom(imp.getIstatComune());
				theModel.getAppDataIspezione2018()
						.setCodIstatProv(GenericUtil.getCodIstatProvByCodIstatComune(imp.getIstatComune()));
				result.setResultCode(GESTISCIABILRUOLOENTE_OUTCOME_CODE__RUOLO_PA_COMUNE);
			}

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::gestisciAbilRuoloEnte] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo gestisciRicaricaPagina definito in un ExecCommand del
	 * ContentPanel cpDettaglioIspezione2018
	 */
	public ExecResults gestisciRicaricaPagina(

			it.csi.sigit.sigitwebn.dto.elenco_ispezioni_impianti.CpDettaglioIspezione2018Model theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GESTISCIRICARICAPAGINA_OUTCOME_CODE__RICARICA = //NOSONAR  Reason:EIAS
				"RICARICA"; //NOSONAR  Reason:EIAS
		final String GESTISCIRICARICAPAGINA_OUTCOME_CODE__NON_RICARICA = //NOSONAR  Reason:EIAS
				"NON_RICARICA"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-32675606) ENABLED START*/

			Boolean isRicarica = theModel.getAppDataaggiornaDati();
			log.debug("###################################");
			log.debug("gestisciRicaricaPagina - isRicarica: " + isRicarica);
			log.debug("gestisciRicaricaPagina - ConvertUtil.convertToBooleanAllways(isRicarica): "
					+ ConvertUtil.convertToBooleanAllways(isRicarica));

			if (ConvertUtil.convertToBooleanAllways(isRicarica)) {
				caricaIspezione(theModel);

				theModel.setAppDataaggiornaDati(Boolean.FALSE);

				result.setResultCode(GESTISCIRICARICAPAGINA_OUTCOME_CODE__RICARICA);
			} else {
				result.setResultCode(GESTISCIRICARICAPAGINA_OUTCOME_CODE__NON_RICARICA);
			}

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::gestisciRicaricaPagina] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo gestisciMsg definito in un ExecCommand del
	 * ContentPanel cpDettaglioIspezione2018
	 */
	public ExecResults gestisciMsg(

			it.csi.sigit.sigitwebn.dto.elenco_ispezioni_impianti.CpDettaglioIspezione2018Model theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GESTISCIMSG_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-144124611) ENABLED START*/
			GenericUtil.gestisciMessaggioSessione(theModel, result);

			result.setResultCode(GESTISCIMSG_OUTCOME_CODE__OK);

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::gestisciMsg] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo gestisciComboGeo definito in un ExecCommand del
	 * ContentPanel cpDettaglioIspezione2018
	 */
	public ExecResults gestisciComboGeo(

			it.csi.sigit.sigitwebn.dto.elenco_ispezioni_impianti.CpDettaglioIspezione2018Model theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GESTISCICOMBOGEO_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R933617591) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:
			gestisciComboDtCatasto(theModel);
			// impostazione del result code 
			result.setResultCode(GESTISCICOMBOGEO_OUTCOME_CODE__OK);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::gestisciComboGeo] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	//////////////////////////////////////////////////////////////////////////////
	/// Metodi statici per il reset delle tabelle
	//////////////////////////////////////////////////////////////////////////////

	/**
	 * permette di resettare lo stato di paginazione della tabella widg_tbSazioni
	 */
	public static void resetClearStatus_widg_tbSazioni(java.util.Map session) {
		session.put("cpDettaglioIspezione2018_tbSazioni_clearStatus", Boolean.TRUE);
	}

	/**
	 * permette di resettare lo stato di paginazione della tabella widg_tbRapportiProva
	 */
	public static void resetClearStatus_widg_tbRapportiProva(java.util.Map session) {
		session.put("cpDettaglioIspezione2018_tbRapportiProva_clearStatus", Boolean.TRUE);
	}

	/**
	 * permette di resettare lo stato di paginazione della tabella widg_tbAzioniSvolte
	 */
	public static void resetClearStatus_widg_tbAzioniSvolte(java.util.Map session) {
		session.put("cpDettaglioIspezione2018_tbAzioniSvolte_clearStatus", Boolean.TRUE);
	}

	//////////////////////////////////////////////////////////////////////////////
	/// Property aggiuntive del bean
	//////////////////////////////////////////////////////////////////////////////
	/*PROTECTED REGION ID(R-1409198270) ENABLED START*/
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

	private ConnectorMgr connectorMgr;

	public ConnectorMgr getConnectorMgr() {
		return connectorMgr;
	}

	public void setConnectorMgr(ConnectorMgr connectorMgr) {
		this.connectorMgr = connectorMgr;
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

	private ServiziMgr serviziMgr;

	public ServiziMgr getServiziMgr() {
		return serviziMgr;
	}

	public void setServiziMgr(ServiziMgr serviziMgr) {
		this.serviziMgr = serviziMgr;
	}

	private void caricaAzioni(
			it.csi.sigit.sigitwebn.dto.elenco_ispezioni_impianti.CpDettaglioIspezione2018Model theModel)
			throws ManagerException {

		// Rileggo le azioni
		Azione azioneFiltro = new Azione();
		azioneFiltro.setFkAzione(
				ConvertUtil.convertToInteger(theModel.getAppDataIspezione2018().getIdentificativoIspezione()));

		theModel.setAppDataelencoAzioni((ArrayList<Azione>) getSigitMgr()
				.cercaAzioniByFiltro(Constants.ID_TIPO_AZIONE_ISPEZIONE, azioneFiltro, true));

	}

	public static boolean isCampoIspezioneEditabile(
			it.csi.sigit.sigitwebn.dto.elenco_ispezioni_impianti.CpDettaglioIspezione2018Model theModel) {

		//il salva e' abilitato se si ha ruolo validatore e l'ispezione non e' stata ancora creata oppure con ruolo super/ispettore 
		String descrizioneRuolo = theModel.getAppDatautenteLoggato().getRuolo().getDescRuolo();

		if (theModel.getAppDataIspezione2018() != null
				&& theModel.getAppDataIspezione2018().getIdStatoIspezione() != null
				&& !ConvertUtil.convertToString(Constants.ID_STATO_ISPEZIONE_BOZZA)
						.equals(theModel.getAppDataIspezione2018().getIdStatoIspezione())) {
			//se l'ispezione esiste ed ha uno stato diverso da BOZZA, il salva, indipendentemente dall'utente loggato, e' disabilitato
			return false;
		}

		if (descrizioneRuolo.equals(Constants.RUOLO_VALIDATORE) && (theModel.getAppDataIspezione2018() == null
				|| GenericUtil.isNullOrEmpty(theModel.getAppDataIspezione2018().getIdentificativoIspezione()))) {
			return true;
		} else {
			return isUtenteAbilitatoRappProva(theModel);
		}
	}

	public static boolean isUtenteAbilitatoSalvaIspezione(
			it.csi.sigit.sigitwebn.dto.elenco_ispezioni_impianti.CpDettaglioIspezione2018Model theModel) {
		//il salva e' abilitato se si ha ruolo validatore e l'ispezione non e' stata ancora creata oppure con ruolo super/ispettore 
		String descrizioneRuolo = theModel.getAppDatautenteLoggato().getRuolo().getDescRuolo();

		if (theModel.getAppDataIspezione2018() != null
				&& theModel.getAppDataIspezione2018().getIdStatoIspezione() != null
				&& !ConvertUtil.convertToString(Constants.ID_STATO_ISPEZIONE_BOZZA)
						.equals(theModel.getAppDataIspezione2018().getIdStatoIspezione())) {
			//se l'ispezione esiste ed ha uno stato diverso da BOZZA, il salva, indipendentemente dall'utente loggato, e' disabilitato
			return false;
		}

		if (descrizioneRuolo.equals(Constants.RUOLO_VALIDATORE) && (theModel.getAppDataIspezione2018() == null
				|| GenericUtil.isNullOrEmpty(theModel.getAppDataIspezione2018().getIdentificativoIspezione()))) {
			return true;
		} else {
			return isUtenteAbilitatoRappProva(theModel);
		}
	}

	public static boolean isUtenteAbilitatoRappProva(
			it.csi.sigit.sigitwebn.dto.elenco_ispezioni_impianti.CpDettaglioIspezione2018Model theModel) {
		return GenericUtil.isUtenteAbilitatoRapProva(theModel.getAppDatautenteLoggato());
	}

	public static boolean isAzioneIspezioneAbilitata(
			it.csi.sigit.sigitwebn.dto.elenco_ispezioni_impianti.CpDettaglioIspezione2018Model theModel) {
		return GenericUtil.isUtenteAbilitatoRapProva(theModel.getAppDatautenteLoggato())
				&& theModel.getAppDataIspezione2018() != null && ConvertUtil.convertToInteger(
						theModel.getAppDataIspezione2018().getIdStatoIspezione()) == Constants.ID_STATO_ISPEZIONE_BOZZA;
	}

	public static boolean isAzioneIspezioneConsolidataAbilitata(
			it.csi.sigit.sigitwebn.dto.elenco_ispezioni_impianti.CpDettaglioIspezione2018Model theModel) {
		return GenericUtil.isUtenteAbilitatoVisualizzaRapProva(theModel.getAppDatautenteLoggato())
				&& theModel.getAppDataIspezione2018() != null
				&& (ConvertUtil.convertToInteger(
						theModel.getAppDataIspezione2018().getIdStatoIspezione()) == Constants.ID_STATO_ISPEZIONE_BOZZA
						|| ConvertUtil.convertToInteger(theModel.getAppDataIspezione2018()
								.getIdStatoIspezione()) == Constants.ID_STATO_ISPEZIONE_CONSOLIDATO);
	}

	public static boolean isAssociaImpiantoAbilitato(
			it.csi.sigit.sigitwebn.dto.elenco_ispezioni_impianti.CpDettaglioIspezione2018Model theModel) {
		//l'associazione dell'impianto e' possibile fintanto che non ci sono rapporti di prova associati
		return GenericUtil.isUtenteAbilitatoRapProva(theModel.getAppDatautenteLoggato())
				&& theModel.getAppDataIspezione2018() != null
				&& ConvertUtil.convertToInteger(
						theModel.getAppDataIspezione2018().getIdStatoIspezione()) == Constants.ID_STATO_ISPEZIONE_BOZZA
				&& (theModel.getAppDataelencoAllegatiIsp() == null || theModel.getAppDataelencoAllegatiIsp().isEmpty());
	}

	public static boolean isInserisciRappProvaAbilitato(
			it.csi.sigit.sigitwebn.dto.elenco_ispezioni_impianti.CpDettaglioIspezione2018Model theModel) {
		return GenericUtil.isUtenteAbilitatoRapProva(theModel.getAppDatautenteLoggato())
				&& theModel.getAppDataIspezione2018() != null
				&& ConvertUtil.convertToInteger(
						theModel.getAppDataIspezione2018().getIdStatoIspezione()) == Constants.ID_STATO_ISPEZIONE_BOZZA
				&& !GenericUtil.isNullOrEmpty(theModel.getAppDataIspezione2018().getCodiceImpianto());
	}

	public static boolean isAzioneRappProvaAbilitato(
			it.csi.sigit.sigitwebn.dto.elenco_ispezioni_impianti.CpDettaglioIspezione2018Model theModel) {
		return isAzioneIspezioneAbilitata(theModel)
				&& !GenericUtil.isNullOrEmpty(theModel.getAppDataIspezione2018().getCodiceImpianto())
				&& theModel.getAppDataelencoAllegatiIsp() != null && !theModel.getAppDataelencoAllegatiIsp().isEmpty();
	}

	public static boolean isDettRappProvaAbilitato(
			it.csi.sigit.sigitwebn.dto.elenco_ispezioni_impianti.CpDettaglioIspezione2018Model theModel) {
		return isAzioneIspezioneConsolidataAbilitata(theModel)
				&& !GenericUtil.isNullOrEmpty(theModel.getAppDataIspezione2018().getCodiceImpianto())
				&& theModel.getAppDataelencoAllegatiIsp() != null && !theModel.getAppDataelencoAllegatiIsp().isEmpty();
	}

	public static boolean isAssegnaAAbilitato(
			it.csi.sigit.sigitwebn.dto.elenco_ispezioni_impianti.CpDettaglioIspezione2018Model theModel) {
		return GenericUtil.isUtenteAbilitatoRapProva(theModel.getAppDatautenteLoggato())
				&& theModel.getAppDataIspezione2018() != null && ConvertUtil.convertToInteger(
						theModel.getAppDataIspezione2018().getIdStatoIspezione()) == Constants.ID_STATO_ISPEZIONE_BOZZA;
	}

	public static boolean isIspezioneDaVerifica(
			it.csi.sigit.sigitwebn.dto.elenco_ispezioni_impianti.CpDettaglioIspezione2018Model theModel) {
		Ispezione2018 ispezione = theModel.getAppDataIspezione2018();
		return ispezione != null && ispezione.getIdVerifica() != null
				&& !Constants.DATO_NON_DISPONIBILE_S.equals(ispezione.getIdVerifica());
	}

	public static boolean isIspezioneDaAccertamento(
			it.csi.sigit.sigitwebn.dto.elenco_ispezioni_impianti.CpDettaglioIspezione2018Model theModel) {
		Ispezione2018 ispezione = theModel.getAppDataIspezione2018();
		return ispezione != null && ispezione.getIdAccertamento() != null
				&& !Constants.DATO_NON_DISPONIBILE_S.equals(ispezione.getIdAccertamento());
	}

	private void caricaIspezione(
			it.csi.sigit.sigitwebn.dto.elenco_ispezioni_impianti.CpDettaglioIspezione2018Model theModel)
			throws ManagerException, ServiceException {
		Ispezione2018 ispezione = theModel.getAppDataIspezione2018();
		//viene costruito il dettaglio a partire da una ispezione pre-esistente
		theModel.setAppDataIspezione2018(
				getSigitMgr().caricaIspezioneDaId(ispezione.getIdentificativoIspezione(), true, true));
		Ispezione2018 isp = theModel.getAppDataIspezione2018();
		if (isp != null && GenericUtil.isNotNullOrEmpty(isp.getCodIstatProv()))
			theModel.setAppDataelencoComuniPiemonteIstat(
					serviziMgr.getListaComuniByIstatProvincia(isp.getCodIstatProv()));
		//nel dettaglio ispezione vengono caricate anche:
		//combo secondo ispettore
		theModel.setAppDataelencoSecondiIspettori(getSigitMgr().getElencoIspettoriCfPf(true));

		//elenco delle sanzioni
		if (theModel.getAppDataelencoStatiSanzione() == null || theModel.getAppDataelencoStatiSanzione().isEmpty()) {
			theModel.setAppDataelencoStatiSanzione(getSigitMgr().getElencoStatiSanzione());
		}

		theModel.setAppDataelencoSanzioni(getSigitMgr().getSanzioniByIdIspezione(ispezione.getIdentificativoIspezione(),
				ConvertUtil.convertIdDescriptionsInMap(theModel.getAppDataelencoStatiSanzione())));

		if (isp.getCodiceImpianto() != null && !isp.getCodiceImpianto().equals("")) {
			theModel.setAppDataazioneCodImpianto(isp.getCodiceImpianto());
		}

		log.debug("Stampo ispezione.getIdentificativoIspezione(): " + ispezione.getIdentificativoIspezione());
		//elenco dei rapporti di prova
		caricaAllegati(theModel);

		theModel.setAppDataidAllegatoIspSelezionato(null);

		//elenco delle azioni
		caricaAzioni(theModel);
	}

	private void caricaAllegati(
			it.csi.sigit.sigitwebn.dto.elenco_ispezioni_impianti.CpDettaglioIspezione2018Model theModel)
			throws ManagerException {

		ArrayList<DettaglioAllegato> elencoAllegati = getSigitMgr().cercaRappProvaPerIdIspezione(
				ConvertUtil.convertToInteger(theModel.getAppDataIspezione2018().getIdentificativoIspezione()));

		theModel.setAppDataelencoAllegatiIsp(elencoAllegati);

		theModel.setAppDataallegatoIsp(null);
	}

	public static boolean isInserisciAzioneAbilitato(
			it.csi.sigit.sigitwebn.dto.elenco_ispezioni_impianti.CpDettaglioIspezione2018Model theModel) {
		return GenericUtil.isUtenteAbilitatoRapProva(theModel.getAppDatautenteLoggato())
				&& theModel.getAppDataIspezione2018() != null && ConvertUtil.convertToInteger(
						theModel.getAppDataIspezione2018().getIdStatoIspezione()) == Constants.ID_STATO_ISPEZIONE_BOZZA;
	}

	public static boolean isGestisciSvegliaAbilitato(
			it.csi.sigit.sigitwebn.dto.elenco_ispezioni_impianti.CpDettaglioIspezione2018Model theModel) {
		return GenericUtil.isUtenteAbilitatoRapProva(theModel.getAppDatautenteLoggato())
				&& theModel.getAppDataIspezione2018() != null && ConvertUtil.convertToInteger(
						theModel.getAppDataIspezione2018().getIdStatoIspezione()) == Constants.ID_STATO_ISPEZIONE_BOZZA;
	}

	public static boolean isAvviaSanzioneAbilitata(
			it.csi.sigit.sigitwebn.dto.elenco_ispezioni_impianti.CpDettaglioIspezione2018Model theModel) {
		return GenericUtil.isUtenteAbilitatoRapProva(theModel.getAppDatautenteLoggato())
				&& theModel.getAppDataIspezione2018() != null && ConvertUtil.convertToInteger(
						theModel.getAppDataIspezione2018().getIdStatoIspezione()) == Constants.ID_STATO_ISPEZIONE_BOZZA;
	}

	public static boolean isConcludiIspezioneAbilitato(
			it.csi.sigit.sigitwebn.dto.elenco_ispezioni_impianti.CpDettaglioIspezione2018Model theModel) {
		return GenericUtil.isUtenteAbilitatoRapProva(theModel.getAppDatautenteLoggato())
				&& theModel.getAppDataIspezione2018() != null
				&& ConvertUtil.convertToInteger(
						theModel.getAppDataIspezione2018().getIdStatoIspezione()) == Constants.ID_STATO_ISPEZIONE_BOZZA
				&& !GenericUtil.isNullOrEmpty(theModel.getAppDataIspezione2018().getCodiceImpianto());
	}

	public static boolean isAnnullaIspezioneAbilitata(
			it.csi.sigit.sigitwebn.dto.elenco_ispezioni_impianti.CpDettaglioIspezione2018Model theModel) {
		return GenericUtil.isUtenteAbilitatoRapProva(theModel.getAppDatautenteLoggato())
				&& theModel.getAppDataIspezione2018() != null && ConvertUtil.convertToInteger(theModel
						.getAppDataIspezione2018().getIdStatoIspezione()) != Constants.ID_STATO_ISPEZIONE_ANNULLATO;
	}

	private ExecResults gestisciAbilRuoloRef(CpDettaglioIspezione2018Model theModel, String codRetRuoloPaProvincia,
			String codRetRuoloPaComune, String codRetAltro) throws ServiceException, BEException, ManagerException {
		ExecResults result = new ExecResults();

		UtenteLoggato utenteLog = theModel.getAppDatautenteLoggato();

		if (log.isDebugEnabled())
			GenericUtil.stampa(utenteLog, true, 2);

		Ispezione2018 ispez = theModel.getAppDataIspezione2018();

		if (ispez == null) {
			ispez = new Ispezione2018();
		}

		String descRuolo = utenteLog.getRuolo().getDescRuolo();

		String istatAbilitazione = utenteLog.getRuolo().getIstatAbilitazione();

		if ((descRuolo.equals(Constants.RUOLO_CONSULTATORE) || descRuolo.equals(Constants.RUOLO_VALIDATORE)
				|| descRuolo.equals(Constants.RUOLO_ISPETTORE)) && istatAbilitazione.length() > 2) {

			ArrayList<CodeDescription> comuni = getSigitMgr().impostaProvinciaSuDettaglioIspezioni(ispez,
					istatAbilitazione);
			log.debug("-------------" + comuni + "--------------");
			theModel.setAppDataelencoComuniPiemonteIstat(comuni);

			result.setResultCode(codRetRuoloPaProvincia);

			if (istatAbilitazione.length() > 5) {
				getSigitMgr().impostaComuneSuDettaglioIspezioni(theModel.getAppDataelencoComuniPiemonteIstat(), ispez,
						istatAbilitazione);

				result.setResultCode(codRetRuoloPaComune);
			}

		} else {
			result.setResultCode(codRetAltro);
		}

		theModel.setAppDataIspezione2018(ispez);

		return result;
	}

	private void gestisciComboDtCatasto(CpDettaglioIspezione2018Model theModel) throws BEException {

		log.debug("[BackEndFacade::gestisciComboDtCatasto] BEGIN");

		try {
			Ispezione2018 ispez = theModel.getAppDataIspezione2018();
			ArrayList<CodeDescription> comuni = new ArrayList<CodeDescription>();

			if (ispez != null) {
				String istatProvincia = ispez.getCodIstatProv();

				log.debug("STAMPO idProvSel: " + istatProvincia);

				if (GenericUtil.isNotNullOrEmpty(istatProvincia)) {
					comuni = (ArrayList<CodeDescription>) getServiziMgr()
							.getListaComuniByIstatProvincia(istatProvincia);
				}
			}
			theModel.setAppDataelencoComuniPiemonteIstat(comuni);
		} catch (ServiceException e) {
			//throw new ManagerException(e, new Message(Messages.ERROR_SERVIZIO_NON_RAGGIUNGIBILE));
			throw new BEException("Errore in getComuni della provincia:" + e, e);

		} finally {
			log.debug("[BackEndFacade::gestisciComboDtCatasto] END");

		}
	}

	/*PROTECTED REGION END*/
}
