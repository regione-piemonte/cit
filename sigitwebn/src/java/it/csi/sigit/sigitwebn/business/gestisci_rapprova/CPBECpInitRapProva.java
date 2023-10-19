package it.csi.sigit.sigitwebn.business.gestisci_rapprova;

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

/*PROTECTED REGION ID(R1317774237) ENABLED START*/
import it.csi.sigit.sigitwebn.business.manager.ConnectorMgr;
import it.csi.sigit.sigitwebn.business.manager.DbMgr;
import it.csi.sigit.sigitwebn.business.manager.SigitMgr;
import it.csi.sigit.sigitwebn.business.manager.ValidationMgr;
import it.csi.sigit.sigitwebn.business.manager.util.ManagerException;
import it.csi.sigit.sigitwebn.business.manager.util.Message;
import it.csi.sigit.sigitwebn.business.manager.util.ValidationManagerException;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.SigitRIspezIspetDto;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.filter.ImportFileSuper;
import java.io.File;

/*PROTECTED REGION END*/

public class CPBECpInitRapProva {

	/**  */
	protected static final Logger log = //NOSONAR  Reason:EIAS 
			Logger.getLogger(Constants.APPLICATION_CODE + ".business"); //NOSONAR  Reason:EIAS

	//////////////////////////////////////////////////////////////////////////////
	/// Costanti identificative degli Application Data
	//////////////////////////////////////////////////////////////////////////////

	// ApplicationData: [idAllegatoIspSelezionato, scope:USER_SESSION]
	public static final String APPDATA_IDALLEGATOISPSELEZIONATO_CODE = "appDataidAllegatoIspSelezionato";

	// ApplicationData: [elencoTipiCombustibileIsp, scope:USER_SESSION]
	public static final String APPDATA_ELENCOTIPICOMBUSTIBILEISP_CODE = "appDataelencoTipiCombustibileIsp";

	// ApplicationData: [elencoApparecchiatureIsp, scope:USER_SESSION]
	public static final String APPDATA_ELENCOAPPARECCHIATUREISP_CODE = "appDataelencoApparecchiatureIsp";

	// ApplicationData: [RicercaApparecchiatureRappProva, scope:USER_SESSION]
	public static final String APPDATA_RICERCAAPPARECCHIATURERAPPPROVA_CODE = "appDataRicercaApparecchiatureRappProva";

	// ApplicationData: [elencoTipiDocumentoProfilatiIsp, scope:USER_SESSION]
	public static final String APPDATA_ELENCOTIPIDOCUMENTOPROFILATIISP_CODE = "appDataelencoTipiDocumentoProfilatiIsp";

	// ApplicationData: [allegatoIsp, scope:USER_SESSION]
	public static final String APPDATA_ALLEGATOISP_CODE = "appDataallegatoIsp";

	// ApplicationData: [utenteLoggato, scope:USER_SESSION]
	public static final String APPDATA_UTENTELOGGATO_CODE = "appDatautenteLoggato";

	// ApplicationData: [paginaChiamante, scope:USER_SESSION]
	public static final String APPDATA_PAGINACHIAMANTE_CODE = "appDatapaginaChiamante";

	// ApplicationData: [idIspezioneSelezionato, scope:USER_SESSION]
	public static final String APPDATA_IDISPEZIONESELEZIONATO_CODE = "appDataidIspezioneSelezionato";

	// ApplicationData: [aggiornaElencoIspezioniAllegati, scope:USER_SESSION]
	public static final String APPDATA_AGGIORNAELENCOISPEZIONIALLEGATI_CODE = "appDataaggiornaElencoIspezioniAllegati";

	// ApplicationData: [messaggioDinamico, scope:USER_SESSION]
	public static final String APPDATA_MESSAGGIODINAMICO_CODE = "appDatamessaggioDinamico";

	//////////////////////////////////////////////////////////////////////////////
	/// Metodi associati alla U.I.
	//////////////////////////////////////////////////////////////////////////////

	// nome del content panel associato al bean
	public static final String CPNAME = "cpInitRapProva";

	public static final String MULTIPANEL_MPGESTIONEALLEGATO = "mpGestioneAllegato";
	public static final String MPI_MPGESTIONEALLEGATO_FPINSERIMENTO = CPNAME + "_" + MULTIPANEL_MPGESTIONEALLEGATO + "_"
			+ "fpInserimento";
	public static final String MPI_MPGESTIONEALLEGATO_FPMODIFICA = CPNAME + "_" + MULTIPANEL_MPGESTIONEALLEGATO + "_"
			+ "fpModifica";

	public static final String MULTIPANEL_MPUPLOADALLEGATO = "mpUploadAllegato";
	public static final String MPI_MPUPLOADALLEGATO_FPUPLOADALLEGATO = CPNAME + "_" + MULTIPANEL_MPUPLOADALLEGATO + "_"
			+ "fpUploadAllegato";

	/** 
	 * Restituisce il tab correntemente visibile in un determinato tab set
	 */
	private String getCurrentTab(Map session, String tabSetName) {
		String value = (String) session.get(CPNAME + "_" + tabSetName + "_selectedMultiPanel");
		return value;
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo ricercaElencoApparecchiuature definito in un ExecCommand del
	 * ContentPanel cpInitRapProva
	 */
	public ExecResults ricercaElencoApparecchiuature(

			it.csi.sigit.sigitwebn.dto.gestisci_rapprova.CpInitRapProvaModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String RICERCAELENCOAPPARECCHIUATURE_OUTCOME_CODE__OK_NO_COMBUSTIBILE = //NOSONAR  Reason:EIAS
				"OK_NO_COMBUSTIBILE"; //NOSONAR  Reason:EIAS
		final String RICERCAELENCOAPPARECCHIUATURE_OUTCOME_CODE__OK_COMBUSTIBILE = //NOSONAR  Reason:EIAS
				"OK_COMBUSTIBILE"; //NOSONAR  Reason:EIAS
		final String RICERCAELENCOAPPARECCHIUATURE_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R1328476531) ENABLED START*/

			try {

				RicercaApparecchiatureRappProva ricerca = theModel.getAppDataRicercaApparecchiatureRappProva();

				//la ricerca diventa possibile solo se sono settati i valori di data/tipo documento
				getValidationMgr().validazioneCercaApparecchiaturePerRapProva(ricerca);

				//in base al tipo allegato selezionato viene caricato o no la combo del combustibile
				if (Constants.RAPP_PROVA_ALLEGATO_TIPO_1.equals(ricerca.getIdTipoAllegato())) {
					//vengono popolate le combo che verranno rese visibili
					theModel.setAppDataelencoTipiCombustibileIsp(
							getSigitMgr().cercaElencoCombustibili(ricerca.getIdTipoAllegato()));

					result.setResultCode(RICERCAELENCOAPPARECCHIUATURE_OUTCOME_CODE__OK_COMBUSTIBILE);
				} else {
					result.setResultCode(RICERCAELENCOAPPARECCHIUATURE_OUTCOME_CODE__OK_NO_COMBUSTIBILE);
				}
				DettaglioAllegato allegato = theModel.getAppDataallegatoIsp();
				if (allegato == null) {
					allegato = new DettaglioAllegato();
					theModel.setAppDataallegatoIsp(allegato);
				}

				Ispezione2018 ispezione = getSigitMgr().caricaIspezioneDaId(
						ConvertUtil.convertToString(theModel.getAppDataidIspezioneSelezionato()), false, false);

				//vengono riportati sull'appdata dell'allegato le info indicate nella ricerca in modo da poter eseguire la ricerca
				allegato.setDataControllo(ricerca.getDataIspezione());
				allegato.setIdTipoAllegato(ricerca.getIdTipoAllegato());
				allegato.setCodiceImpianto(ispezione.getCodiceImpianto());
				allegato.setOraArrivo(ricerca.getOraIspezione());

				//vengono resettate le info su una qualsiasi ricerca pregressa
				allegato.setIdApparecchiature(null);
				allegato.setIdApparecchiatureFunz(null);
				allegato.setIdTipiCombustibile(null);

				theModel.setAppDataallegatoIsp(allegato);

				theModel.setAppDataelencoApparecchiatureIsp(
						getSigitMgr().cercaElencoApparecchiature(theModel.getAppDataallegatoIsp()));

			} catch (ManagerException e) {
				Validator.gestisciEccezione(result, e);
			}

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
	 * ContentPanel cpInitRapProva
	 */
	public ExecResults resettaRicercaElencoApparecchiuature(

			it.csi.sigit.sigitwebn.dto.gestisci_rapprova.CpInitRapProvaModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String RESETTARICERCAELENCOAPPARECCHIUATURE_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String RESETTARICERCAELENCOAPPARECCHIUATURE_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R2007927219) ENABLED START*/
			//resetta tutto quello che e' stato impostato nella ricerca e tutto cio' che è nei risultati
			theModel.setAppDataRicercaApparecchiatureRappProva(new RicercaApparecchiatureRappProva());

			theModel.setAppDataallegatoIsp(new DettaglioAllegato());
			result.setResultCode(RESETTARICERCAELENCOAPPARECCHIUATURE_OUTCOME_CODE__OK);

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
	 * Implementazione del metodo ricaricaElencoApparecchiature definito in un ExecCommand del
	 * ContentPanel cpInitRapProva
	 */
	public ExecResults ricaricaElencoApparecchiature(

			it.csi.sigit.sigitwebn.dto.gestisci_rapprova.CpInitRapProvaModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String RICARICAELENCOAPPARECCHIATURE_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-668957057) ENABLED START*/
			//metodo invocato tutte le volte che viene modificata la selezione dalla combo COMBUSTIBILE.
			//tale interazione produce effetti sulla lista delle apparecchiature selezionabili
			//questo vuol dire che la prima operazione da fare al cambiamento di combustibile e' svuotare la selezione delle apparecchiature
			DettaglioAllegato allegato = theModel.getAppDataallegatoIsp();
			allegato.setIdApparecchiature(null);

			//riesegue la ricerca delle apparecchiature alla luce del cambiamento sulla selezione del combustibile
			theModel.setAppDataelencoApparecchiatureIsp(
					getSigitMgr().cercaElencoApparecchiature(theModel.getAppDataallegatoIsp()));

			result.setResultCode(RICARICAELENCOAPPARECCHIATURE_OUTCOME_CODE__OK);

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::ricaricaElencoApparecchiature] Errore occorso nell'esecuzione del metodo:" + e,
					e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo ripulisciDatiAllegato definito in un ExecCommand del
	 * ContentPanel cpInitRapProva
	 */
	public ExecResults ripulisciDatiAllegato(

			it.csi.sigit.sigitwebn.dto.gestisci_rapprova.CpInitRapProvaModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String RIPULISCIDATIALLEGATO_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R1266062863) ENABLED START*/
			//vengono resettate tutte le info che possono essere state settate nel form panel
			theModel.setAppDataallegatoIsp(null);
			theModel.setAppDataRicercaApparecchiatureRappProva(null);

			// impostazione del result code 
			result.setResultCode(RIPULISCIDATIALLEGATO_OUTCOME_CODE__OK);

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
	 * Implementazione del metodo gestUploadAllegato definito in un ExecCommand del
	 * ContentPanel cpInitRapProva
	 */
	public ExecResults gestUploadAllegato(

			it.csi.sigit.sigitwebn.dto.gestisci_rapprova.CpInitRapProvaModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GESTUPLOADALLEGATO_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String GESTUPLOADALLEGATO_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R2050180133) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			DettaglioAllegato dettaglioAllegato = theModel.getAppDataallegatoIsp();
			UtenteLoggato utenteLoggato = theModel.getAppDatautenteLoggato();

			try {
				Integer fkManutentore = null; //settato a partire dalle apparecchiature se l'allegato non esiste, altrimenti viene preso il dato dall'allegato stesso
				//controllo se i campi obbligatori sono stati valorizzati
				getValidationMgr().validazioneFormaleDatiRapProva(dettaglioAllegato, true);

				fkManutentore = ConvertUtil.convertToInteger(
						GenericUtil.getFkManutentore(dettaglioAllegato.getIdApparecchiature().get(0)));

				PersonaGiuridica personaGiuridica = getDbMgr().cercaPersonaGiuridicaById(fkManutentore);

				//controllo se il manutentore loggato non abbia l'attivita' cessata
				getValidationMgr().verificaDataCessazioneAttivita(dettaglioAllegato.getDataControllo(),
						personaGiuridica.getDataCessazione());

				/*
				//setto a BOZZA l'allegato che si sta per aprire (se ha passato tutti i controlli precedenti)
				dettaglioAllegato.setIdStatoRapporto(Constants.ID_STATO_RAPPORTO_BOZZA);
				//setto il codice fiscale dell'utente loggato
				dettaglioAllegato.setCodFiscaleUtenteLoggato(theModel.getAppDatautenteLoggato().getCodiceFiscale());
				//setto il flagControlloBozza a false(0) perche' se e' null va in eccezione quando cerco di inviarlo
				dettaglioAllegato.setFlagControlloBozza(Constants.FLAG_CONTROLLO_BOZZA_ALLEGATO_FALSE);
				//setto da dove sto arrivando
				dettaglioAllegato.setArrivoDa(Constants.ARRIVO_DA_IMPIANTO_ISP);
				
				dettaglioAllegato.setCodiceBollino(MapDto.costruisciCodiceBollino(dettaglioAllegato.getSiglaBollino(),
						ConvertUtil.convertToBigDecimal(dettaglioAllegato.getNumeroBollinoVerde())));
				
				//rimetto in sessione l'oggetto dettaglio allegato per la action showAllegatoNow
				theModel.getSession().put(Constants.SESSIONE_VAR_DETT_ALLEGATO, dettaglioAllegato);
				
				theModel.setAppDataallegatoIsp(dettaglioAllegato);
				 */

				result.setResultCode(GESTUPLOADALLEGATO_OUTCOME_CODE__OK);

			} catch (ManagerException ex) {
				Validator.gestisciEccezione(result, ex);
			}

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::gestUploadAllegato] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo gestisciRappProvaWeb definito in un ExecCommand del
	 * ContentPanel cpInitRapProva
	 */
	public ExecResults gestisciRappProvaWeb(

			it.csi.sigit.sigitwebn.dto.gestisci_rapprova.CpInitRapProvaModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GESTISCIRAPPPROVAWEB_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String GESTISCIRAPPPROVAWEB_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-1166820316) ENABLED START*/
			//metodo invocato quando si clicca sul botton RAPP PROVA WEB
			DettaglioAllegato dettaglioAllegato = theModel.getAppDataallegatoIsp();
			try {
				Integer fkManutentore = null; //settato a partire dalle apparecchiature se l'allegato non esiste, altrimenti viene preso il dato dall'allegato stesso
				if (GenericUtil.isNullOrEmpty(dettaglioAllegato.getIdAllegato())) {
					//controllo se i campi obbligatori sono stati valorizzati
					getValidationMgr().validazioneFormaleDatiRapProva(dettaglioAllegato, false);

					fkManutentore = ConvertUtil.convertToInteger(
							GenericUtil.getFkManutentore(dettaglioAllegato.getIdApparecchiature().get(0)));

					dettaglioAllegato.setIdPersonaGiuridica(fkManutentore);

					dettaglioAllegato
							.setIdCom4Manut(GenericUtil.recuperaComp4Manut(dettaglioAllegato.getIdApparecchiature()));

					dettaglioAllegato.setIdApparecchiatureFunz(
							GenericUtil.recuperaProgressivo(dettaglioAllegato.getIdApparecchiature()));

					// beppe - non penso che serva questa chiamata, tanto l'unico dato che serve sotto è l'identidicativo ispezione, che dovrei avere 
					// infatti faccio la ricerca per identificativo ispezione... - per adesso lo lascio
					Ispezione2018 ispezioneOrigine = getSigitMgr().caricaIspezioneDaId(
							ConvertUtil.convertToString(theModel.getAppDataidIspezioneSelezionato()), false, false);

					SigitRIspezIspetDto ispezIspet = getDbMgr()
							.cercaUltimoRIspezIspetByIdIspezione(ispezioneOrigine.getIdentificativoIspezione());

					dettaglioAllegato.setIdIspezione2018(
							ConvertUtil.convertToInteger(ispezioneOrigine.getIdentificativoIspezione()));

					dettaglioAllegato.setIdIspezIspet(ConvertUtil.convertToString(ispezIspet.getIdIspezIspet()));

				} else {
					fkManutentore = dettaglioAllegato.getIdPersonaGiuridica();
					Ruolo profiloUtente = theModel.getAppDatautenteLoggato().getRuolo();

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
				dettaglioAllegato.setCodFiscaleUtenteLoggato(theModel.getAppDatautenteLoggato().getCodiceFiscale());
				//setto il flagControlloBozza a false(0) perche' se e' null va in eccezione quando cerco di inviarlo
				dettaglioAllegato.setFlagControlloBozza(Constants.FLAG_CONTROLLO_BOZZA_ALLEGATO_FALSE);
				//setto da dove sto arrivando
				dettaglioAllegato.setArrivoDa(Constants.ARRIVO_DA_IMPIANTO_ISP);

				dettaglioAllegato.setCodiceBollino(MapDto.costruisciCodiceBollino(dettaglioAllegato.getSiglaBollino(),
						ConvertUtil.convertToBigDecimal(dettaglioAllegato.getNumeroBollinoVerde())));

				//rimetto in sessione l'oggetto dettaglio allegato per la action showAllegatoNow
				theModel.getSession().put(Constants.SESSIONE_VAR_DETT_ALLEGATO, dettaglioAllegato);

				theModel.setAppDataallegatoIsp(dettaglioAllegato);

				result.setResultCode(GESTISCIRAPPPROVAWEB_OUTCOME_CODE__OK);

			} catch (ManagerException ex) {
				Validator.gestisciEccezione(result, ex);
			}

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
	 * Implementazione del metodo caricaScansione definito in un ExecCommand del
	 * ContentPanel cpInitRapProva
	 */
	public ExecResults caricaScansione(

			it.csi.sigit.sigitwebn.dto.gestisci_rapprova.CpInitRapProvaModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String CARICASCANSIONE_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String CARICASCANSIONE_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R25180890) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			try {
				File file = theModel.getWidg_fuUploadAllegato();
				if (file != null) {
					log.debug("elaborazione file");

					String nomeFile = theModel.getWidg_fuUploadAllegatoFileName();
					String contType = theModel.getWidg_fuUploadAllegatoContentType();

					getValidationMgr().validazioneFormaleUpdateFile(file, nomeFile, contType);

					// SE FUNZIONA E' DA REPLICARE NEGLI ALTRI PUNTI DEL CODICE!
					/*
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
					 */
					DettaglioAllegato dettaglioAllegato = theModel.getAppDataallegatoIsp();
					UtenteLoggato utenteLoggato = theModel.getAppDatautenteLoggato();

					Integer fkManutentore = null; //settato a partire dalle apparecchiature se l'allegato non esiste, altrimenti viene preso il dato dall'allegato stesso
					fkManutentore = ConvertUtil.convertToInteger(
							GenericUtil.getFkManutentore(dettaglioAllegato.getIdApparecchiature().get(0)));

					dettaglioAllegato.setIdPersonaGiuridica(fkManutentore);

					dettaglioAllegato
							.setIdCom4Manut(GenericUtil.recuperaComp4Manut(dettaglioAllegato.getIdApparecchiature()));

					dettaglioAllegato.setIdApparecchiatureFunz(
							GenericUtil.recuperaProgressivo(dettaglioAllegato.getIdApparecchiature()));

					// beppe - non penso che serva questa chiamata, tanto l'unico dato che serve sotto è l'identidicativo ispezione, che dovrei avere 
					// infatti faccio la ricerca per identificativo ispezione... - lo tolgo (se funziono lo toglierò anche nel metodo gestisciRappProvaWeb)
					Ispezione2018 ispezioneOrigine = getSigitMgr().caricaIspezioneDaId(
							ConvertUtil.convertToString(theModel.getAppDataidIspezioneSelezionato()), false, false);

					log.debug("###################");
					log.debug("STAMPO theModel.getAppDataidIspezioneSelezionato(): "
							+ theModel.getAppDataidIspezioneSelezionato());
					log.debug("STAMPO ispezioneOrigine.getIdentificativoIspezione(): "
							+ ispezioneOrigine.getIdentificativoIspezione());
					log.debug("###################");

					SigitRIspezIspetDto ispezIspet = getDbMgr()
							.cercaUltimoRIspezIspetByIdIspezione(ispezioneOrigine.getIdentificativoIspezione());

					dettaglioAllegato.setIdIspezione2018(
							ConvertUtil.convertToInteger(ispezioneOrigine.getIdentificativoIspezione()));

					dettaglioAllegato.setIdIspezIspet(ConvertUtil.convertToString(ispezIspet.getIdIspezIspet()));

					dettaglioAllegato.setIdStatoRapporto(Constants.ID_STATO_RAPPORTO_INVIATO);
					//setto il codice fiscale dell'utente loggato
					dettaglioAllegato.setCodFiscaleUtenteLoggato(theModel.getAppDatautenteLoggato().getCodiceFiscale());
					//setto il flagControlloBozza a false(0) perche' se e' null va in eccezione quando cerco di inviarlo
					dettaglioAllegato.setFlagControlloBozza(Constants.FLAG_CONTROLLO_BOZZA_ALLEGATO_FALSE);

					ImportFileSuper doc = new ImportFileSuper();
					doc.setContentType(contType);
					doc.setFile(file);
					doc.setNomeFile(nomeFile);

					getSigitMgr().salvaRapProva(dettaglioAllegato, true, doc, utenteLoggato);

					theModel.getSession().put(Constants.SESSIONE_VAR_MESSAGGE,
							new Message(Messages.INFO_FILE_CARICATO_CORRETTAMENTE, Message.INFO));

					result.setResultCode(CARICASCANSIONE_OUTCOME_CODE__OK);

				} else {
					throw new ValidationManagerException(new Message("Selezionare un file"));

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
			log.error("[BackEndFacade::caricaScansione] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo gestisciIndietro definito in un ExecCommand del
	 * ContentPanel cpInitRapProva
	 */
	public ExecResults gestisciIndietro(

			it.csi.sigit.sigitwebn.dto.gestisci_rapprova.CpInitRapProvaModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GESTISCIINDIETRO_OUTCOME_CODE__OK_ISPEZIONE = //NOSONAR  Reason:EIAS
				"OK_ISPEZIONE"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R1110710681) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			// impostazione del result code 
			result.setResultCode(GESTISCIINDIETRO_OUTCOME_CODE__OK_ISPEZIONE);

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
	 * ContentPanel cpInitRapProva
	 */
	public ExecResults isRuoloAbilitato(

			it.csi.sigit.sigitwebn.dto.gestisci_rapprova.CpInitRapProvaModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String ISRUOLOABILITATO_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R470565878) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			UtenteLoggato utente = theModel.getAppDatautenteLoggato();

			if (GenericUtil.isUtenteAbilitatoRapProva(utente)) {
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
	 * Implementazione del metodo inizializzaRapportoProva definito in un ExecCommand del
	 * ContentPanel cpInitRapProva
	 */
	public ExecResults inizializzaRapportoProva(

			it.csi.sigit.sigitwebn.dto.gestisci_rapprova.CpInitRapProvaModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String INIZIALIZZARAPPORTOPROVA_OUTCOME_CODE__OK_INSERIMENTO = //NOSONAR  Reason:EIAS
				"OK_INSERIMENTO"; //NOSONAR  Reason:EIAS
		final String INIZIALIZZARAPPORTOPROVA_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R193622537) ENABLED START*/

			Integer rappProvaSelezionato = theModel.getAppDataidAllegatoIspSelezionato();
			inizializzaCombo(theModel);
			//se rappProvaSelezionato e' nullo vuol dire che si arriva dall'inserisci rap prova.
			//in caso contrario vanno caricati i dati dello stesso.
			//			if (rappProvaSelezionato == null) {
			//trattandosi di inserimento vengono resettate le info sulla ricerca
			theModel.setAppDataRicercaApparecchiatureRappProva(new RicercaApparecchiatureRappProva());
			theModel.setAppDataallegatoIsp(new DettaglioAllegato());
			result.setResultCode(INIZIALIZZARAPPORTOPROVA_OUTCOME_CODE__OK_INSERIMENTO);
			//			} else {
			//				//nel caso di caricamento del dettaglio con modifica, le combo su combustibile e apparecchiature sono già precaricate.
			//				//nel caso di inserimento le combo appaiono solo quando si clicca sul cerca
			//
			//				DettaglioAllegato allegato = getDbMgr().getDettaglioAllegatoById(rappProvaSelezionato);
			//				theModel.setAppDataallegatoIsp(allegato);
			//
			//				if (Constants.RAPP_PROVA_ALLEGATO_TIPO_1.equals(allegato.getTipoAllegato())) {
			//					//vengono popolate le combo che verranno rese visibili
			//					theModel.setAppDataelencoTipiCombustibileIsp(
			//							getSigitMgr().cercaElencoCombustibili(allegato.getTipoAllegato()));
			//					result.setResultCode(INIZIALIZZARAPPORTOPROVA_OUTCOME_CODE__OK_MODIFICA_OK_COMBUSTIBILE);
			//				} else {
			//					result.setResultCode(INIZIALIZZARAPPORTOPROVA_OUTCOME_CODE__OK_MODIFICA_KO_COMBUSTIBILE);
			//				}
			//
			//				theModel.setAppDataelencoApparecchiatureIsp(
			//						getSigitMgr().cercaElencoApparecchiature(theModel.getAppDataallegatoIsp()));
			//			}

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::inizializzaRapportoProva] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	//////////////////////////////////////////////////////////////////////////////
	/// Metodi statici per il reset delle tabelle
	//////////////////////////////////////////////////////////////////////////////

	//////////////////////////////////////////////////////////////////////////////
	/// Property aggiuntive del bean
	//////////////////////////////////////////////////////////////////////////////
	/*PROTECTED REGION ID(R1666053175) ENABLED START*/
	private ConnectorMgr connectorMgr;

	public ConnectorMgr getConnectorMgr() {
		return connectorMgr;
	}

	public void setConnectorMgr(ConnectorMgr connectorMgr) {
		this.connectorMgr = connectorMgr;
	}

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

	private ValidationMgr validationMgr;

	public ValidationMgr getValidationMgr() {
		return validationMgr;
	}

	public void setValidationMgr(ValidationMgr validationMgr) {
		this.validationMgr = validationMgr;
	}

	private void inizializzaCombo(it.csi.sigit.sigitwebn.dto.gestisci_rapprova.CpInitRapProvaModel theModel)
			throws ManagerException {
		try {

			//			//caricamento dati ispezione
			//			Ispezione2018 ispezione = getSigitMgr()
			//					.caricaIspezioneDaId(ConvertUtil.convertToString(idIspezioneSelezionata), false, false);
			//			theModel.setAppDataIspezione2018(ispezione);
			//
			//			//caricamento dati impianto
			//			theModel.setAppDataidentificativoImpianto(
			//					getSigitMgr().caricaDatiImpiantoPerAllegati(ispezione.getCodiceImpianto()));

			//se la lista delle tipologie di documento non e' gia' popolata
			if (theModel.getAppDataelencoTipiDocumentoProfilatiIsp() == null
					|| theModel.getAppDataelencoTipiDocumentoProfilatiIsp().isEmpty()) {
				theModel.setAppDataelencoTipiDocumentoProfilatiIsp(getDbMgr().cercaListaTipiDocumentoRapProva());
			}

		} catch (ManagerException e) {
			log.error("Errore: ", e);
			throw e;
		}
	}

	/*PROTECTED REGION END*/
}
