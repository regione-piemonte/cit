package it.csi.sigit.sigitwebn.business.elenco_allegati_impianti;

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

/*PROTECTED REGION ID(R1473011446) ENABLED START*/
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.SigitDStatoImpDto;

import it.csi.sigit.sigitwebn.business.gestisci_verifica.CPBECpGestVerifica.TipoVerificaEnum;
import it.csi.sigit.sigitwebn.business.manager.ConnectorMgr;
import it.csi.sigit.sigitwebn.business.manager.DbMgr;
import it.csi.sigit.sigitwebn.business.manager.ServiziMgr;
import it.csi.sigit.sigitwebn.business.manager.SigitMgr;
import it.csi.sigit.sigitwebn.business.manager.ValidationMgr;
import it.csi.sigit.sigitwebn.business.manager.util.ManagerException;
import it.csi.sigit.sigitwebn.business.manager.util.Message;
import it.csi.sigit.sigitwebn.business.manager.util.ValidationManagerException;
import it.csi.sigit.sigitwebn.dto.ExecResults;
import it.csi.sigit.sigitwebn.dto.accesso.PersonaGiuridica;
import it.csi.sigit.sigitwebn.dto.accesso.Ruolo;
import it.csi.sigit.sigitwebn.dto.allegati.AllegatiPerImpianto;
import it.csi.sigit.sigitwebn.dto.allegati.DettaglioAllegato;
import it.csi.sigit.sigitwebn.dto.allegati.IdentificativoImpiantoAllegato;
import it.csi.sigit.sigitwebn.dto.common.CodeDescription;
import it.csi.sigit.sigitwebn.dto.main.UtenteLoggato;
import it.csi.sigit.sigitwebn.util.mail.ResultInvioMail;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.SigitTAllegatoPk;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.SigitTAllegatoDto;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.SigitVRicercaAllegatiDto;

import java.math.BigDecimal;

import com.bea.utils.ValidationUtil;
/*PROTECTED REGION END*/

public class CPBECpElencoAllegatiImpianti {

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

	// ApplicationData: [identificativoImpianto, scope:USER_SESSION]
	public static final String APPDATA_IDENTIFICATIVOIMPIANTO_CODE = "appDataidentificativoImpianto";

	// ApplicationData: [reeMenuTree, scope:USER_SESSION]
	public static final String APPDATA_REEMENUTREE_CODE = "appDatareeMenuTree";

	// ApplicationData: [verifica, scope:USER_SESSION]
	public static final String APPDATA_VERIFICA_CODE = "appDataverifica";

	// ApplicationData: [paginaChiamante, scope:USER_SESSION]
	public static final String APPDATA_PAGINACHIAMANTE_CODE = "appDatapaginaChiamante";

	//////////////////////////////////////////////////////////////////////////////
	/// Metodi associati alla U.I.
	//////////////////////////////////////////////////////////////////////////////

	// nome del content panel associato al bean
	public static final String CPNAME = "cpElencoAllegatiImpianti";

	public static final String MULTIPANEL_MPDATIALLEGATO = "mpDatiAllegato";
	public static final String MPI_MPDATIALLEGATO_FPDATIALLEGATO = CPNAME + "_" + MULTIPANEL_MPDATIALLEGATO + "_"
			+ "fpDatiAllegato";

	/** 
	 * Restituisce il tab correntemente visibile in un determinato tab set
	 */
	private String getCurrentTab(Map session, String tabSetName) {
		String value = (String) session.get(CPNAME + "_" + tabSetName + "_selectedMultiPanel");
		return value;
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo inserisciAllegatoPerImpianto definito in un ExecCommand del
	 * ContentPanel cpElencoAllegatiImpianti
	 */
	public ExecResults inserisciAllegatoPerImpianto(

			it.csi.sigit.sigitwebn.dto.elenco_allegati_impianti.CpElencoAllegatiImpiantiModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String INSERISCIALLEGATOPERIMPIANTO_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String INSERISCIALLEGATOPERIMPIANTO_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-1783459033) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			// BEPPE prova modifica ottimizzazione
			//			String codiceImpianto = theModel.getAppDataallegato()
			//					.getCodiceImpianto();

			String codiceImpianto = theModel.getAppDataidImpiantoSelez();

			log.debug("Nella pagina elenco allegati da impianti ----> CODICE IMPIANTO: " + codiceImpianto);
			try {
				//				if (getSigitMgr().isPresenteLibrettoBozza(codiceImpianto)) {
				//					throw new ValidationManagerException(new Message(Messages.S055));
				//				} else 
				Integer idStatoImpianto = getSigitMgr().getIdStatoImpiantoByCodiceImp(codiceImpianto);
				if (!idStatoImpianto.equals(Constants.ID_STATO_IMP_VALIDO)) {
					SigitDStatoImpDto statoImpDto = getSigitMgr().getDescStatoImpiantoByIdStato(idStatoImpianto);
					String message = Messages.ERROR_INSERISCI_ALLEGATO_IMPIANTO_STATO + statoImpDto.getDesStato();
					log.debug(message);
					throw new ValidationManagerException(new Message(message));
				} else if (!getSigitMgr().isPresenteLibrettoConsolidato(codiceImpianto)) {
					throw new ValidationManagerException(new Message(Messages.S056_BIS));
				} else if (!getValidationMgr()
						.isImpiantoTipoImpiantoValorizzato(ConvertUtil.convertToBigDecimal(codiceImpianto))) {
					log.debug("Dati impianto non aggiornati");
					throw new ValidationManagerException(new Message(Messages.S158));
				} else {
					//mi apri una nuova sezione sotto quella esistente(mi fai vedere alcuni elementi ed altri no)
					// impostazione del result code 
					theModel.setAppDataisAbilitazioneDatiAllegato(true);
					//vado a ripulire di alcuni dati che magari il DettaglioAllegato si tiene in sessione se passo da modifica
					DettaglioAllegato dettaglio = new DettaglioAllegato();
					dettaglio.setCodiceImpianto(ReplaceSpecialCharUtils.sanitize(theModel.getAppDataidImpiantoSelez()));
					dettaglio.setSiglaBollino(Constants.SIGLA_BOLLINO_RP);

					Ruolo profiloUtente = theModel.getAppDatautenteLoggato().getRuolo();

					if (Constants.RUOLO_IMPRESA.equalsIgnoreCase(profiloUtente.getDescRuolo())) {
						dettaglio.setIdPersonaGiuridica(profiloUtente.getIdPersonaGiuridica());
					}

					theModel.setAppDataallegato(dettaglio);

					//vado a ricaricare la combo del numero bollino perche' non so se da questo bottone arrivo appena entrano nel form
					//oppure dopo che hanno fatto modifica e si potrebbe aver tenuto in sessione la combo del numero bollino caricata in modo scorretto
					this.precaricaCombo(theModel, theModel.getAppDatautenteLoggato());

					result.setResultCode(INSERISCIALLEGATOPERIMPIANTO_OUTCOME_CODE__OK);
				}
				// modifica degli attributi del model (che verranno propagati allo strato
				// di presentation). si puo' agire anche direttamente sull'attributo "session".
			} catch (ManagerException ex) {

				Validator.gestisciEccezione(result, ex);
			}

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::inserisciAllegatoPerImpianto] Errore occorso nell'esecuzione del metodo:" + e,
					e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo gestisciReeWebMod definito in un ExecCommand del
	 * ContentPanel cpElencoAllegatiImpianti
	 */
	public ExecResults gestisciReeWebMod(

			it.csi.sigit.sigitwebn.dto.elenco_allegati_impianti.CpElencoAllegatiImpiantiModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GESTISCIREEWEBMOD_OUTCOME_CODE__TIPO1 = //NOSONAR  Reason:EIAS
				"TIPO1"; //NOSONAR  Reason:EIAS
		final String GESTISCIREEWEBMOD_OUTCOME_CODE__TIPO2 = //NOSONAR  Reason:EIAS
				"TIPO2"; //NOSONAR  Reason:EIAS
		final String GESTISCIREEWEBMOD_OUTCOME_CODE__TIPO3 = //NOSONAR  Reason:EIAS
				"TIPO3"; //NOSONAR  Reason:EIAS
		final String GESTISCIREEWEBMOD_OUTCOME_CODE__TIPO4 = //NOSONAR  Reason:EIAS
				"TIPO4"; //NOSONAR  Reason:EIAS
		final String GESTISCIREEWEBMOD_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R1669675682) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			Integer idAllegatoSelezionato = theModel.getAppDataidAllegatoImpiantoSelezionato();

			log.debug(
					" FRAAAAA ----> MODIFICA ALLEGATO  dentro RISULTATO RICERCA ALLEGATI------------> idAllegatoSelezionato: "
							+ idAllegatoSelezionato);
			Ruolo ruoloUtente = theModel.getAppDatautenteLoggato().getRuolo();

			try {
				//se non lo hanno selezionato questo metodo mi blocca
				getValidationMgr().checkSelezioneElemento(ConvertUtil.convertToString(idAllegatoSelezionato));

				DettaglioAllegato dettaglioAllegato = getSigitMgr().gestisciAllegatoById(idAllegatoSelezionato);

				//String codiceImpianto = getCodiceImpianto(theModel.getAppDataelencoAllegati(), idAllegatoSelezionato);

				log.debug("Codice impianto : " + dettaglioAllegato.getCodiceImpianto());

				if (dettaglioAllegato.getRuoloFunzionale().equalsIgnoreCase(Constants.RUOLO_ISPETTORE)) {
					throw new ValidationManagerException(new Message(Messages.S122));
					//				} else if (getSigitMgr().isPresenteLibrettoBozza(codiceImpianto)) {
					//					throw new ValidationManagerException(new Message(Messages.S055));
				} else {
					//devo fare dei controlli di merito sul tipo di allegato associato all'utenteloggato
					//					String descrizioneStatoRapporto = dettaglioAllegato
					//							.getStatoAllegato();

					log.debug("FRAAAAAAAAAAAAAAAAA --> LO STATO DELL'ALLEGATO : "
							+ dettaglioAllegato.getIdStatoRapporto());

					if (dettaglioAllegato.getIdStatoRapporto().intValue() == Constants.ID_STATO_RAPPORTO_BOZZA) {
						//si puo' modificare
						if (ruoloUtente.getDescRuolo().equalsIgnoreCase(Constants.RUOLO_IMPRESA)) {
							//controlo se e' l'utente corrente che lo sta modificando e' quello che lo ha creato
							getValidationMgr().verificaSeAllegatoModificabile(dettaglioAllegato.getIdPersonaGiuridica(),
									ruoloUtente.getIdPersonaGiuridica(), Messages.S040);

						}

						/*
						dettaglioAllegato.setCodiceImpianto(codiceImpianto);
						if (getValidationMgr().isNessunResponsabileByCodImpiantoApp(
								dettaglioAllegato.getCodiceImpianto(), dettaglioAllegato.getDataControllo(),
								dettaglioAllegato.getIdTipoAllegato(), dettaglioAllegato.getIdApparecchiature())) {
							throw new ValidationManagerException(
									new Message(Messages.ERROR_RESPONSABILE_DATA_RAPP_ASSENTE));
						}
						*/

						PersonaGiuridica personaGiuridica = getDbMgr()
								.cercaPersonaGiuridicaById(dettaglioAllegato.getIdPersonaGiuridica());

						//controllo se il manutentore loggato non abbia l'attivita' cessata
						getValidationMgr().verificaDataCessazioneAttivita(dettaglioAllegato.getDataControllo(),
								personaGiuridica.getDataCessazione());

						dettaglioAllegato
								.setCodFiscaleUtenteLoggato(theModel.getAppDatautenteLoggato().getCodiceFiscale());

						//						dettaglioAllegato
						//								.setCodiceBollino(MapDto.costruisciCodiceBollino(dettaglioAllegato.getSiglaBollino(),
						//										ConvertUtil.convertToBigDecimal(dettaglioAllegato.getNumeroBollinoVerde())));

						if (log.isDebugEnabled())
							GenericUtil.stampa(dettaglioAllegato, true, 3);

						//setto da dove sto arrivando
						dettaglioAllegato.setArrivoDa(Constants.ARRIVO_DA_IMPIANTO);

						theModel.setAppDataallegato(dettaglioAllegato);

						//rimetto in sessione l'oggetto dettaglio allegato per la action showAllegatoNow
						theModel.getSession().put(Constants.SESSIONE_VAR_DETT_ALLEGATO, dettaglioAllegato);

						theModel.setAppDataaggiornaElencoAllegati(true);

						// DEVO COPIARE I CONTROLLI DI GENERAZIONE ALLEGATO
						if (Constants.ALLEGATO_TIPO_1.equals(dettaglioAllegato.getIdTipoAllegato())
								|| Constants.ALLEGATO_TIPO_1B.equals(dettaglioAllegato.getIdTipoAllegato()))
							result.setResultCode(GESTISCIREEWEBMOD_OUTCOME_CODE__TIPO1);
						if (Constants.ALLEGATO_TIPO_2.equals(dettaglioAllegato.getIdTipoAllegato()))
							result.setResultCode(GESTISCIREEWEBMOD_OUTCOME_CODE__TIPO2);
						if (Constants.ALLEGATO_TIPO_3.equals(dettaglioAllegato.getIdTipoAllegato()))
							result.setResultCode(GESTISCIREEWEBMOD_OUTCOME_CODE__TIPO3);
						if (Constants.ALLEGATO_TIPO_4.equals(dettaglioAllegato.getIdTipoAllegato()))
							result.setResultCode(GESTISCIREEWEBMOD_OUTCOME_CODE__TIPO4);

					} else {
						//se l'allegato e' in stato inviato e/o respinto 
						/* getValidationMgr()
								.verificaSeAllegatoModificabile(
										ConvertUtil.convertToInteger(dettaglioAllegato
												.getIdImpiantoRuoloPfPg()),
										ruoloUtente.getIdPersonaGiuridica(), false);*/

						result.getGlobalErrors().add(Messages.S040);

						// impostazione del result code 
						result.setResultCode(GESTISCIREEWEBMOD_OUTCOME_CODE__KO);
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
			log.error("[BackEndFacade::gestisciReeWebMod] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo visualizzaDettaglioAllegatoPerImpianto definito in un ExecCommand del
	 * ContentPanel cpElencoAllegatiImpianti
	 */
	public ExecResults visualizzaDettaglioAllegatoPerImpianto(

			it.csi.sigit.sigitwebn.dto.elenco_allegati_impianti.CpElencoAllegatiImpiantiModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String VISUALIZZADETTAGLIOALLEGATOPERIMPIANTO_OUTCOME_CODE__OK_FIRMATO = //NOSONAR  Reason:EIAS
				"OK_FIRMATO"; //NOSONAR  Reason:EIAS
		final String VISUALIZZADETTAGLIOALLEGATOPERIMPIANTO_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		final String VISUALIZZADETTAGLIOALLEGATOPERIMPIANTO_OUTCOME_CODE__OK_SINGOLO = //NOSONAR  Reason:EIAS
				"OK_SINGOLO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-344028337) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			theModel.setAppDataisAbilitazioneDatiAllegato(false);

			Integer idAllegatoSelezionato = theModel.getAppDataidAllegatoImpiantoSelezionato();
			log.debug(" BEPPE ----> DETTAGLIO ALLEGATO ------------> idAllegatoSelezionato: " + idAllegatoSelezionato);

			try {

				Ruolo ruoloUtente = theModel.getAppDatautenteLoggato().getRuolo();

				//se non lo hanno selezionato questo metodo mi blocca
				getValidationMgr().checkSelezioneElemento(ConvertUtil.convertToString(idAllegatoSelezionato));

				getValidationMgr().validazioneFormaleDettaglioAllegato(idAllegatoSelezionato, ruoloUtente);

				SigitTAllegatoDto allegato = getDbMgr().getSigitTAllegatoDao()
						.findByPrimaryKey(new SigitTAllegatoPk(new BigDecimal(idAllegatoSelezionato)));
				theModel.getSession().put(Constants.SESSIONE_VAR_ID_ALLEGATO,
						ConvertUtil.convertToString(idAllegatoSelezionato));

				theModel.getSession().put(Constants.SESSIONE_VAR_ID_IMPIANTO, theModel.getAppDataidImpiantoSelez());

				if (allegato != null && allegato.getUidIndexFirmato() != null)
					result.setResultCode(VISUALIZZADETTAGLIOALLEGATOPERIMPIANTO_OUTCOME_CODE__OK_FIRMATO);
				else
					result.setResultCode(VISUALIZZADETTAGLIOALLEGATOPERIMPIANTO_OUTCOME_CODE__OK_SINGOLO);
			} catch (ManagerException ex) {
				Validator.gestisciEccezione(result, ex);

			}

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

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
	 * Implementazione del metodo inviaAllegatoPerImpianto definito in un ExecCommand del
	 * ContentPanel cpElencoAllegatiImpianti
	 */
	public ExecResults inviaAllegatoPerImpianto(

			it.csi.sigit.sigitwebn.dto.elenco_allegati_impianti.CpElencoAllegatiImpiantiModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String INVIAALLEGATOPERIMPIANTO_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String INVIAALLEGATOPERIMPIANTO_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R1823307717) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			try {

				Integer idAllegatoSelezionato = theModel.getAppDataidAllegatoImpiantoSelezionato();
				log.debug(
						" FRAAAAA ----> INVIA ALLEGATO ------------> idAllegatoSelezionato: " + idAllegatoSelezionato);
				Ruolo ruoloUtente = theModel.getAppDatautenteLoggato().getRuolo();

				//controllo che abbiano selezionato un allegato
				getValidationMgr().checkSelezioneElemento(ConvertUtil.convertToString(idAllegatoSelezionato));

				//vado a cercare il dettaglio dell'allegato con la primary Key
				DettaglioAllegato dettaglioAllegato = this.getDbMgr()
						.getDettaglioAllegatoByIdAllegato(idAllegatoSelezionato, theModel.getAppDataidImpiantoSelez());

				//setto il codice impianto che la 

				dettaglioAllegato.setCodiceImpianto(ReplaceSpecialCharUtils.sanitize(theModel.getAppDataidImpiantoSelez()));

				// Ho centralizzato i controlli
				getValidationMgr().validazioneFormaleInviaAllegato(dettaglioAllegato, ruoloUtente);

				/*
				if (dettaglioAllegato.getIdStatoPg().intValue() == Constants.ID_STATO_IMPRESA_SOSPESA
						|| dettaglioAllegato.getIdStatoPg().intValue() == Constants.ID_STATO_IMPRESA_RADIATA) {
					throw new ValidationManagerException(new Message(Messages.S147, dettaglioAllegato.getCodiceReaPg(),
							dettaglioAllegato.getCodiceFiscalePg()));
				} else if (dettaglioAllegato.getIdStatoPg().intValue() == Constants.ID_STATO_IMPRESA_CESSATA) {
					PersonaGiuridica personaGiuridica = getDbMgr()
							.cercaPersonaGiuridicaById(dettaglioAllegato.getIdPersonaGiuridica());
				
					//controllo se il manutentore loggato non abbia l'attivita' cessata
					getValidationMgr().verificaDataCessazioneAttivita(dettaglioAllegato.getDataControllo(),
							personaGiuridica.getDataCessazione());
				}
				
				if (dettaglioAllegato.getRuoloFunzionale().equalsIgnoreCase(Constants.RUOLO_ISPETTORE)) {
					throw new ValidationManagerException(new Message(Messages.S122));
				} else if (getSigitMgr().isPresenteLibrettoBozza(theModel.getAppDataidImpiantoSelez())) {
					throw new ValidationManagerException(new Message(Messages.S055));
				} else {
					//controllo se l'allegato e' stato creato dal manutentore o installatore loggati
					if (ruoloUtente.getDescRuolo().equalsIgnoreCase(Constants.RUOLO_INSTALLATORE)
							|| ruoloUtente.getDescRuolo().equalsIgnoreCase(Constants.RUOLO_MANUTENTORE)) {
						//conosco l'idPersonaGiuridica dell'utente la confronto con quella legata all'allegato
						getValidationMgr().verificaSeAllegatoModificabile(dettaglioAllegato.getIdPersonaGiuridica(),
								ruoloUtente.getIdPersonaGiuridica(), Messages.S044);
				
					}
				
					if (Constants.DESC_STATO_RAPPORTO_INVIATO.equalsIgnoreCase(dettaglioAllegato.getStatoAllegato())
							|| Constants.DESC_STATO_RAPPORTO_RESPINTO
									.equalsIgnoreCase(dettaglioAllegato.getStatoAllegato())) {
				
						result.getGlobalErrors().add(Messages.S040);
						result.setResultCode(INVIAALLEGATOPERIMPIANTO_OUTCOME_CODE__KO);
				
					} else {
						//						//vuol dire che e' in stato BOZZA, controllo il flag sulla tabella sigit_t_allegato e' stato ceccato
						//						if (dettaglioAllegato.getFlagControlloBozza() != Constants.FLAG_CONTROLLO_BOZZA_ALLEGATO_TRUE) {
						//							result.getGlobalErrors().add(Messages.S065);
						//							result.setResultCode(INVIAALLEGATOPERIMPIANTO_OUTCOME_CODE__KO);
						//						} 
				
						String errori = getValidationMgr()
								.isAllegatoInviabile(ConvertUtil.convertToString(idAllegatoSelezionato));
				
						if (errori != null) {
							// Vuol dire che ci sono deglie rrori, quindi non si puo' inviare 'allegato
							result.getGlobalErrors().add(errori);
							result.setResultCode(INVIAALLEGATOPERIMPIANTO_OUTCOME_CODE__KO);
						} else if (getValidationMgr().isNessunResponsabileByCodImpiantoApp(
								dettaglioAllegato.getCodiceImpianto(), dettaglioAllegato.getDataControllo(),
								dettaglioAllegato.getIdTipoAllegato(), dettaglioAllegato.getIdApparecchiature())) {
							throw new ValidationManagerException(
									new Message(Messages.ERROR_RESPONSABILE_DATA_RAPP_ASSENTE));
						} else if (getDbMgr().cercaResponsabileAttivoByCodImpianto(
								ConvertUtil.convertToInteger(dettaglioAllegato.getCodiceImpianto())) == null) {
							// Vuol dire che non c'e' un respansabile attivo alla sysdate, non riuscirei a creare il libretto
							throw new ValidationManagerException(new Message(Messages.ERROR_RESPONSABILE_ASSENTE));
						} else if (!getValidationMgr().isVerificaCodiceBollValidoDataControllo(
								dettaglioAllegato.getSiglaBollino(), dettaglioAllegato.getNumeroBollinoVerde(),
								dettaglioAllegato.getDataControllo())) {
							// Ho gia' rilanciato l'eccezione (dentro il metodo di controllo)
						} else {
							
							*/

				theModel.setAppDataisAbilitazioneDatiAllegato(false);
				//setto anche parametri che non si ottengono con la primary Key
				/*dettaglioAllegato.setCodiceImpianto(theModel
						.getAppDataidImpiantoSelez());*/

				dettaglioAllegato.setArrivoDa(Constants.ARRIVO_DA_IMPIANTO);
				dettaglioAllegato.setCodFiscaleUtenteLoggato(ReplaceSpecialCharUtils.sanitize(theModel.getAppDatautenteLoggato().getCodiceFiscale()));
				//setto l'allegato trovato con primary Key nell'oggetto in sessione
				theModel.setAppDataallegato(dettaglioAllegato);
				//lo spedisco a una maschera di conferma
				Message msg = new Message(Messages.C003, "REE");
				theModel.setAppDatamessaggioDinamico(ReplaceSpecialCharUtils.sanitize(msg.getText()));

				// impostazione del result code 
				result.setResultCode(INVIAALLEGATOPERIMPIANTO_OUTCOME_CODE__OK);
				//}

				//}
				//}

			} catch (ManagerException ex) {

				Validator.gestisciEccezione(result, ex);
			}

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::inviaAllegatoPerImpianto] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo respingiAllegatoPerImpianto definito in un ExecCommand del
	 * ContentPanel cpElencoAllegatiImpianti
	 */
	public ExecResults respingiAllegatoPerImpianto(

			it.csi.sigit.sigitwebn.dto.elenco_allegati_impianti.CpElencoAllegatiImpiantiModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String RESPINGIALLEGATOPERIMPIANTO_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String RESPINGIALLEGATOPERIMPIANTO_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-24354687) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:
			theModel.setAppDataisAbilitazioneDatiAllegato(false);

			Integer idAllegatoSelezionato = theModel.getAppDataidAllegatoImpiantoSelezionato();
			log.debug(" BEPPE ----> RESPINGI ALLEGATO ------------> idAllegatoSelezionato: " + idAllegatoSelezionato);

			try {

				//se non lo hanno selezionato questo metodo mi blocca
				getValidationMgr().checkSelezioneElemento(ConvertUtil.convertToString(idAllegatoSelezionato));

				getValidationMgr()
						.validazioneFormaleRespingiAllegato(ConvertUtil.convertToString(idAllegatoSelezionato));

				// Setto la pagina da cui arrivo
				theModel.setAppDatapaginaChiamanteAllegati(Constants.PAG_ELENCO_ALL_IMPIANTI);

				// Setto il dettaglio dell'allegato
				theModel.setAppDatadettaglioElencoAllegati(
						getSigitMgr().cercaAllegatoById(ConvertUtil.convertToString(idAllegatoSelezionato)));

				/*
				String elencoMail = getSigitMgr().respingiAllegato(
						ConvertUtil.convertToString(idAllegatoSelezionato),
						theModel.getAppDatautenteLoggato().getCodiceFiscale());
				
				Message messaggio = new Message();
				if (GenericUtil.isNotNullOrEmpty(elencoMail)) {
					messaggio
							.setText(Messages.INFO_ALLEGATO_RESPINTO_CORRETTAMENTE);
					messaggio.replacePlaceholder(elencoMail);
				} else {
					messaggio
							.setText(Messages.INFO_ALLEGATO_RESPINTO_CORRETTAMENTE_NO_MAIL);
				}
				
				result.getGlobalMessages().add(messaggio.getText());
				
				// Ricarico gli allegati
				caricaElencoAllegati(theModel);
				 */

				// impostazione del result code 
				result.setResultCode(RESPINGIALLEGATOPERIMPIANTO_OUTCOME_CODE__OK);
			} catch (ManagerException ex) {
				Validator.gestisciEccezione(result, ex);

			}

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::respingiAllegatoPerImpianto] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo eliminaAllegatoPerImpianto definito in un ExecCommand del
	 * ContentPanel cpElencoAllegatiImpianti
	 */
	public ExecResults eliminaAllegatoPerImpianto(

			it.csi.sigit.sigitwebn.dto.elenco_allegati_impianti.CpElencoAllegatiImpiantiModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String ELIMINAALLEGATOPERIMPIANTO_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String ELIMINAALLEGATOPERIMPIANTO_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R285815981) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			try {

				Integer idAllegatoSelezionato = theModel.getAppDataidAllegatoImpiantoSelezionato();
				log.debug(
						" BEPPE ----> ELIMINA ALLEGATO ------------> idAllegatoSelezionato: " + idAllegatoSelezionato);

				//controllo che abbiano selezionato un allegato
				getValidationMgr().checkSelezioneElemento(ConvertUtil.convertToString(idAllegatoSelezionato));

				Ruolo ruoloUtente = theModel.getAppDatautenteLoggato().getRuolo();

				//				DettaglioAllegato dettaglioAllegato = this.getDbMgr()
				//						.getDettaglioAllegatoById(idAllegatoSelezionato);

				getValidationMgr().validazioneFormaleEliminaAllegato(idAllegatoSelezionato, ruoloUtente.getDescRuolo(),
						ruoloUtente.getIdPersonaGiuridica());

				theModel.setAppDataisAbilitazioneDatiAllegato(false);
				//lo spedisco a una maschera di conferma

				Message msg = new Message(Messages.C004);
				theModel.setAppDatamessaggioDinamico(ReplaceSpecialCharUtils.sanitize(msg.getText()));

				// impostazione del result code 
				result.setResultCode(ELIMINAALLEGATOPERIMPIANTO_OUTCOME_CODE__OK);

			} catch (ManagerException ex) {

				Validator.gestisciEccezione(result, ex);
			}

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::eliminaAllegatoPerImpianto] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo gestAvviaVerifica definito in un ExecCommand del
	 * ContentPanel cpElencoAllegatiImpianti
	 */
	public ExecResults gestAvviaVerifica(

			it.csi.sigit.sigitwebn.dto.elenco_allegati_impianti.CpElencoAllegatiImpiantiModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GESTAVVIAVERIFICA_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String GESTAVVIAVERIFICA_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R1374312562) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			Integer idAllegatoSelezionato = theModel.getAppDataidAllegatoImpiantoSelezionato();

			try {
				getValidationMgr().checkSelezioneElemento(idAllegatoSelezionato);
				theModel.setAppDatapaginaChiamante(Constants.PAG_ELENCO_ALL_IMPIANTI);

				//theModel.setAppDataisAbilitazioneDatiAllegato(false);
				log.debug(
						"risultato ricerca allegati impianti  nel bottone gestAvviaVerifica --> idAllegatoSelezionato: "
								+ idAllegatoSelezionato);

				//DettaglioAllegato dettaglioAllegato = getIdentificativoAllegato(theModel);
				DettaglioAllegato dettaglioAllegato = getSigitMgr().gestisciAllegatoById(idAllegatoSelezionato);

				if (dettaglioAllegato.getIdStatoRapporto().intValue() != Constants.ID_STATO_RAPPORTO_INVIATO) {
					throw new ValidationManagerException(new Message(Messages.S046_VER));
				}

				IdentificativoImpianto identImpianto = theModel.getAppDataidentificativoImpianto();

				UtenteLoggato utente = theModel.getAppDatautenteLoggato();

				Verifica verifica = new Verifica();
				verifica.setTipoVerifica(TipoVerificaEnum.REE.getIdDb());
				verifica.setIdAllegato(ConvertUtil.convertToString(idAllegatoSelezionato));
				verifica.setCodiceImpianto(ReplaceSpecialCharUtils.sanitize(identImpianto.getCodiceImpianto()));
				verifica.setIdDatoDistributore(Constants.DATO_NON_DISPONIBILE_S);
				verifica.setCfUtenteCaricamento(ReplaceSpecialCharUtils.sanitize(utente.getCodiceFiscale()));
				verifica.setDenomUtenteCaricamento(ReplaceSpecialCharUtils.sanitize(utente.getDenominazione()));
				verifica.setEseguitoDa(ReplaceSpecialCharUtils.sanitize(utente.getDenominazione()) + " (" + ReplaceSpecialCharUtils.sanitize(utente.getCodiceFiscale()) + ")");
				verifica.setDataCaricamento(ReplaceSpecialCharUtils.sanitize(DateUtil.getDataCorrenteFormat()));

				verifica.setSiglaBollino(ReplaceSpecialCharUtils.sanitize(dettaglioAllegato.getSiglaBollino()));
				verifica.setNumeroBollino(ReplaceSpecialCharUtils.sanitize(dettaglioAllegato.getNumeroBollinoVerde()));

				String msgConferma = "Vuoi creare una verifica sul REE " + dettaglioAllegato.getCodiceBollino()
						+ " per l'impianto " + identImpianto.getCodiceImpianto() + " " + identImpianto.getUbicazione()
						+ "?";

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
	 * Implementazione del metodo ricevutaPerImpianto definito in un ExecCommand del
	 * ContentPanel cpElencoAllegatiImpianti
	 */
	public ExecResults ricevutaPerImpianto(

			it.csi.sigit.sigitwebn.dto.elenco_allegati_impianti.CpElencoAllegatiImpiantiModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String RICEVUTAPERIMPIANTO_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String RICEVUTAPERIMPIANTO_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R1999224790) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			Integer idAllegatoSelezionato = theModel.getAppDataidAllegatoImpiantoSelezionato();
			log.debug(" BEPPE ----> RICEVUTA ALLEGATO ------------> idAllegatoSelezionato: " + idAllegatoSelezionato);

			try {

				//se non lo hanno selezionato questo metodo mi blocca
				getValidationMgr().checkSelezioneElemento(ConvertUtil.convertToString(idAllegatoSelezionato));
				theModel.setAppDataisAbilitazioneDatiAllegato(false);

				getValidationMgr().validazioneFormaleStampaRicevutaAllegato(idAllegatoSelezionato,
						theModel.getAppDatautenteLoggato().getRuolo().getDescRuolo(),
						theModel.getAppDatautenteLoggato().getRuolo().getIdPersonaGiuridica());

				theModel.getSession().put(Constants.SESSIONE_VAR_ID_ALLEGATO,
						ConvertUtil.convertToString(idAllegatoSelezionato));

				//				theModel.getSession().put(
				//						Constants.SESSIONE_VAR_ACTION_PAGE_BACK,
				//						Constants.RETURN_PAGE_ELENCO_ALLEGATI_IMPIANTO_DA_PDF);

				log.debug("DEVO APRIRE IL PDF");

				// impostazione del result code 
				result.setResultCode(RICEVUTAPERIMPIANTO_OUTCOME_CODE__OK);
			} catch (ManagerException ex) {
				Validator.gestisciEccezione(result, ex);

			}

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::ricevutaPerImpianto] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo visualizzaDocumentazioneAllegatoPerImpianto definito in un ExecCommand del
	 * ContentPanel cpElencoAllegatiImpianti
	 */
	public ExecResults visualizzaDocumentazioneAllegatoPerImpianto(

			it.csi.sigit.sigitwebn.dto.elenco_allegati_impianti.CpElencoAllegatiImpiantiModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String VISUALIZZADOCUMENTAZIONEALLEGATOPERIMPIANTO_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String VISUALIZZADOCUMENTAZIONEALLEGATOPERIMPIANTO_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-1112632493) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:
			try {
				Integer idAllegatoSelezionato = theModel.getAppDataidAllegatoImpiantoSelezionato();
				log.debug(" DOCUMENTAZIONE ALLEGATO ------------> idAllegatoSelezionato: " + idAllegatoSelezionato);
				Ruolo ruoloUtente = theModel.getAppDatautenteLoggato().getRuolo();

				//controllo che abbiano selezionato un allegato
				getValidationMgr().checkSelezioneElemento(ConvertUtil.convertToString(idAllegatoSelezionato));

				getValidationMgr().validazioneFormaleDocumentazioneAllegato(idAllegatoSelezionato, ruoloUtente);

				DettaglioAllegato dettaglioAllegato = getSigitMgr().gestisciAllegatoById(idAllegatoSelezionato);

				//				dettaglioAllegato.setCodiceBollino(MapDto.costruisciCodiceBollino(dettaglioAllegato.getSiglaBollino(),
				//						ConvertUtil.convertToBigDecimal(dettaglioAllegato.getNumeroBollinoVerde())));

				//setto il codice impianto che la 
				dettaglioAllegato.setCodiceImpianto(ReplaceSpecialCharUtils.sanitize(theModel.getAppDataidImpiantoSelez()));

				//			// Ho centralizzato i controlli
				//			getValidationMgr().validazioneFormaleInviaAllegato(dettaglioAllegato, ruoloUtente);

				//theModel.setAppDataisAbilitazioneDatiAllegato(false);
				//setto anche parametri che non si ottengono con la primary Key
				/*dettaglioAllegato.setCodiceImpianto(theModel
					.getAppDataidImpiantoSelez());*/

				dettaglioAllegato.setArrivoDa(Constants.ARRIVO_DA_IMPIANTO);
				dettaglioAllegato.setCodFiscaleUtenteLoggato(ReplaceSpecialCharUtils.sanitize(theModel.getAppDatautenteLoggato().getCodiceFiscale()));
				//setto l'allegato trovato con primary Key nell'oggetto in sessione
				theModel.setAppDataallegato(dettaglioAllegato);

				//rimetto in sessione l'oggetto dettaglio allegato per la action showAllegatoNow
				theModel.getSession().put(Constants.SESSIONE_VAR_DETT_ALLEGATO, dettaglioAllegato);

				// impostazione del result code 
				result.setResultCode(VISUALIZZADOCUMENTAZIONEALLEGATOPERIMPIANTO_OUTCOME_CODE__OK);

			} catch (ManagerException ex) {

				Validator.gestisciEccezione(result, ex);
			}
			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error(
					"[BackEndFacade::visualizzaDocumentazioneAllegatoPerImpianto] Errore occorso nell'esecuzione del metodo:"
							+ e,
					e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo preparaAperturaCaricaReeFirmato definito in un ExecCommand del
	 * ContentPanel cpElencoAllegatiImpianti
	 */
	public ExecResults preparaAperturaCaricaReeFirmato(

			it.csi.sigit.sigitwebn.dto.elenco_allegati_impianti.CpElencoAllegatiImpiantiModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String PREPARAAPERTURACARICAREEFIRMATO_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String PREPARAAPERTURACARICAREEFIRMATO_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		final String PREPARAAPERTURACARICAREEFIRMATO_OUTCOME_CODE__OK_CONFERMA = //NOSONAR  Reason:EIAS
				"OK_CONFERMA"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-1761311963) ENABLED START*/
			Integer idAllegatoSelezionato = theModel.getAppDataidAllegatoImpiantoSelezionato();
			Ruolo profiloUtente = theModel.getAppDatautenteLoggato().getRuolo();

			if (GenericUtil.isNotNullOrEmpty(idAllegatoSelezionato)) {
				SigitTAllegatoDto allegatoDto = dbMgr.getSigitTAllegatoDao()
						.findByPrimaryKey(new SigitTAllegatoPk(BigDecimal.valueOf(idAllegatoSelezionato)));
				if (GenericUtil.isNotNullOrEmpty(allegatoDto)) {
					DettaglioAllegato dettaglioAllegato = getDbMgr().getDettaglioAllegatoById(idAllegatoSelezionato);
					if (dettaglioAllegato.getStatoAllegato().equals(Constants.DESC_STATO_RAPPORTO_INVIATO)) {
						if (profiloUtente.getDescRuolo().equals(Constants.RUOLO_IMPRESA)) {
							getValidationMgr().validazioneFormaleDettaglioAllegato(idAllegatoSelezionato,
									profiloUtente);
							if (GenericUtil.isNullOrEmpty(allegatoDto.getUidIndexFirmato()))
								result.setResultCode(PREPARAAPERTURACARICAREEFIRMATO_OUTCOME_CODE__OK);
							else
								result.setResultCode(PREPARAAPERTURACARICAREEFIRMATO_OUTCOME_CODE__OK_CONFERMA);
						} else {
							if (GenericUtil.isNullOrEmpty(allegatoDto.getUidIndexFirmato()))
								result.setResultCode(PREPARAAPERTURACARICAREEFIRMATO_OUTCOME_CODE__OK);
							else
								result.setResultCode(PREPARAAPERTURACARICAREEFIRMATO_OUTCOME_CODE__OK_CONFERMA);
						}
					} else {
						result.getGlobalErrors().add("L'allegato deve essere nello stato INVIATO.");
						theModel.setAppDataidAllegatoImpiantoSelezionato(null);
						result.setResultCode(PREPARAAPERTURACARICAREEFIRMATO_OUTCOME_CODE__KO);
					}
				} else {
					result.getGlobalErrors().add("Allegato non trovato.");
					theModel.setAppDataidAllegatoImpiantoSelezionato(null);
					result.setResultCode(PREPARAAPERTURACARICAREEFIRMATO_OUTCOME_CODE__KO);
				}
			} else {
				result.getGlobalErrors().add("Selezionare una voce dall'elenco.");
				theModel.setAppDataidAllegatoImpiantoSelezionato(null);
				result.setResultCode(PREPARAAPERTURACARICAREEFIRMATO_OUTCOME_CODE__KO);
			}
			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::preparaAperturaCaricaReeFirmato] Errore occorso nell'esecuzione del metodo:" + e,
					e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo tornaPaginaChiamante definito in un ExecCommand del
	 * ContentPanel cpElencoAllegatiImpianti
	 */
	public ExecResults tornaPaginaChiamante(

			it.csi.sigit.sigitwebn.dto.elenco_allegati_impianti.CpElencoAllegatiImpiantiModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String TORNAPAGINACHIAMANTE_OUTCOME_CODE__RIS_RIC_IMPIANTO = //NOSONAR  Reason:EIAS
				"RIS_RIC_IMPIANTO"; //NOSONAR  Reason:EIAS
		final String TORNAPAGINACHIAMANTE_OUTCOME_CODE__GEST_IMPIANTO = //NOSONAR  Reason:EIAS
				"GEST_IMPIANTO"; //NOSONAR  Reason:EIAS
		final String TORNAPAGINACHIAMANTE_OUTCOME_CODE__IMP_RESP = //NOSONAR  Reason:EIAS
				"IMP_RESP"; //NOSONAR  Reason:EIAS
		final String TORNAPAGINACHIAMANTE_OUTCOME_CODE__RIS_RIC_AVZ_IMPIANTI = //NOSONAR  Reason:EIAS
				"RIS_RIC_AVZ_IMPIANTI"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-595899481) ENABLED START*/
			log.debug(" INDIETRO DALLA FORM DELL'ELENCO ALLEGATI DELL'IMPIANTO");
			String paginaChiamante = theModel.getAppDatapaginaChiamanteImp();
			log.debug(" tornaPaginaChiamante ---> " + paginaChiamante);
			if (Constants.PAG_GEST_IMPIANTI.equals(paginaChiamante))
				result.setResultCode(TORNAPAGINACHIAMANTE_OUTCOME_CODE__GEST_IMPIANTO);
			else if (Constants.PAG_RIS_RIC_AVZ_IMPIANTI.equals(paginaChiamante))
				result.setResultCode(TORNAPAGINACHIAMANTE_OUTCOME_CODE__RIS_RIC_AVZ_IMPIANTI);
			else if (Constants.PAG_RIS_RIC_IMPIANTI.equals(paginaChiamante))
				result.setResultCode(TORNAPAGINACHIAMANTE_OUTCOME_CODE__RIS_RIC_IMPIANTO);
			else if (Constants.PAG_GEST_IMPIANTI_RESP.equals(paginaChiamante))
				result.setResultCode(TORNAPAGINACHIAMANTE_OUTCOME_CODE__IMP_RESP);
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
	 * Implementazione del metodo cercaApparecchiature definito in un ExecCommand del
	 * ContentPanel cpElencoAllegatiImpianti
	 */
	public ExecResults cercaApparecchiature(

			it.csi.sigit.sigitwebn.dto.elenco_allegati_impianti.CpElencoAllegatiImpiantiModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String CERCAAPPARECCHIATURE_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String CERCAAPPARECCHIATURE_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R1864080018) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			DettaglioAllegato allegato = theModel.getAppDataallegato();

			log.debug("FRAAAAAAAAAAAAAA  -- > caricaNumeriBollinoVerde --- BEGIN ");
			log.debug("FRAAAAAAAAAAAAAA  -- > caricaNumeriBollinoVerde --- CODICE IMPIANTO "
					+ allegato.getCodiceImpianto());
			log.debug("FRAAAAAAAAAAAAAA  -- > caricaNumeriBollinoVerde --- ID TIPO DOCUMENTO "
					+ allegato.getIdTipoAllegato());

			try {
				getValidationMgr().validazioneFormaleDatiAllegatoCerca(allegato);

				allegato.setIdApparecchiature(null);
				allegato.setNumeroBollinoVerde(null);
				allegato.setIdTipiCombustibile(null);

				theModel.setAppDataelencoTipiCombustibile(
						getSigitMgr().cercaElencoCombustibili(allegato.getIdTipoAllegato()));

				theModel.setAppDataelencoApparecchiature(getSigitMgr().cercaElencoApparecchiature(allegato));

				// impostazione del result code 
				result.setResultCode(CERCAAPPARECCHIATURE_OUTCOME_CODE__OK);

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
			log.error("[BackEndFacade::cercaApparecchiature] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo gestioneVisBollini definito in un ExecCommand del
	 * ContentPanel cpElencoAllegatiImpianti
	 */
	public ExecResults gestioneVisBollini(

			it.csi.sigit.sigitwebn.dto.elenco_allegati_impianti.CpElencoAllegatiImpiantiModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GESTIONEVISBOLLINI_OUTCOME_CODE__VISUALIZZA = //NOSONAR  Reason:EIAS
				"VISUALIZZA"; //NOSONAR  Reason:EIAS
		final String GESTIONEVISBOLLINI_OUTCOME_CODE__NASCONDI = //NOSONAR  Reason:EIAS
				"NASCONDI"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R1190995442) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			UtenteLoggato utente = theModel.getAppDatautenteLoggato();

			log.debug(" VISUALIZZAZIONE BOTTONE VERIFICA APPARECCHIATURE");

			String descrizioneRuolo = utente.getRuolo().getDescRuolo();

			log.debug(" isVisualizzaBtnModificaAllegato ---> descrizioneRuolo: " + descrizioneRuolo);

			if (descrizioneRuolo.equals(Constants.RUOLO_VALIDATORE) || descrizioneRuolo.equals(Constants.RUOLO_SUPER)) {
				// impostazione del result code 
				result.setResultCode(GESTIONEVISBOLLINI_OUTCOME_CODE__NASCONDI);
			} else {
				// impostazione del result code 
				result.setResultCode(GESTIONEVISBOLLINI_OUTCOME_CODE__VISUALIZZA);
			}

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::gestioneVisBollini] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo gestioneCombustibile definito in un ExecCommand del
	 * ContentPanel cpElencoAllegatiImpianti
	 */
	public ExecResults gestioneCombustibile(

			it.csi.sigit.sigitwebn.dto.elenco_allegati_impianti.CpElencoAllegatiImpiantiModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GESTIONECOMBUSTIBILE_OUTCOME_CODE__VISUALIZZA = //NOSONAR  Reason:EIAS
				"VISUALIZZA"; //NOSONAR  Reason:EIAS
		final String GESTIONECOMBUSTIBILE_OUTCOME_CODE__NASCONDI = //NOSONAR  Reason:EIAS
				"NASCONDI"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R482797749) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			int idTipoDoc = ConvertUtil.convertToInteger(theModel.getAppDataallegato().getIdTipoAllegato()).intValue();

			if (idTipoDoc == ConvertUtil.convertToInteger(Constants.ALLEGATO_TIPO_1)
					|| idTipoDoc == ConvertUtil.convertToInteger(Constants.ALLEGATO_TIPO_1B)) {
				// impostazione del result code 
				result.setResultCode(GESTIONECOMBUSTIBILE_OUTCOME_CODE__VISUALIZZA);
			} else {
				// impostazione del result code 
				result.setResultCode(GESTIONECOMBUSTIBILE_OUTCOME_CODE__NASCONDI);
			}

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::gestioneCombustibile] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo caricaElencoApparecchiatureByComb definito in un ExecCommand del
	 * ContentPanel cpElencoAllegatiImpianti
	 */
	public ExecResults caricaElencoApparecchiatureByComb(

			it.csi.sigit.sigitwebn.dto.elenco_allegati_impianti.CpElencoAllegatiImpiantiModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String CARICAELENCOAPPARECCHIATUREBYCOMB_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-781909751) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			log.debug("ENTRO in caricaElencoApparecchiatureByComb");
			// Ricarico solo la combo delle apparecchiature
			theModel.setAppDataelencoApparecchiature(
					getSigitMgr().cercaElencoApparecchiature(theModel.getAppDataallegato()));

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
	 * Implementazione del metodo verificaApparecchiature definito in un ExecCommand del
	 * ContentPanel cpElencoAllegatiImpianti
	 */
	public ExecResults verificaApparecchiature(

			it.csi.sigit.sigitwebn.dto.elenco_allegati_impianti.CpElencoAllegatiImpiantiModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String VERIFICAAPPARECCHIATURE_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String VERIFICAAPPARECCHIATURE_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-1162197031) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			try {
				DettaglioAllegato allegato = theModel.getAppDataallegato();

				log.debug("@@@ STAMPO allegato.getIdApparecchiature(): " + allegato.getIdApparecchiature());

				getValidationMgr().verificaManutentoreUnivoco(allegato);

				// Se passo di qua son sicuro che tutte le apparecchiature selezionate appartengono allo stesso manutentore, quindi vado a recuperare i suoi bollini 
				String fkManutNew = GenericUtil.getFkManutentore(allegato.getIdApparecchiature().get(0));

				/*
				 * Beppe - adesso c'è l'assegnazione automatica
				ArrayList<CodeDescription> value = new ArrayList<CodeDescription>();
				
				if (allegato.getIdTipoAllegato() != null) {
					value = this.getSigitMgr().cercaElencoNumeriBollinoVerde(ConvertUtil.convertToInteger(fkManutNew),
							ConvertUtil.convertToInteger(allegato.getCodiceImpianto()), allegato.getIdAllegato());
				}
				
				//devo ricaricare la combo della tipologia di documento
				theModel.setAppDataelencoNumeroBollinoVerde(value);
				*/

				// impostazione del result code 
				result.setResultCode(VERIFICAAPPARECCHIATURE_OUTCOME_CODE__OK);

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
			log.error("[BackEndFacade::verificaApparecchiature] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo chiudiDatiAllegato definito in un ExecCommand del
	 * ContentPanel cpElencoAllegatiImpianti
	 */
	public ExecResults chiudiDatiAllegato(

			it.csi.sigit.sigitwebn.dto.elenco_allegati_impianti.CpElencoAllegatiImpiantiModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String CHIUDIDATIALLEGATO_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-1520296924) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:
			theModel.setAppDataisAbilitazioneDatiAllegato(false);
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
	 * Implementazione del metodo gestisciReeWeb definito in un ExecCommand del
	 * ContentPanel cpElencoAllegatiImpianti
	 */
	public ExecResults gestisciReeWeb(

			it.csi.sigit.sigitwebn.dto.elenco_allegati_impianti.CpElencoAllegatiImpiantiModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GESTISCIREEWEB_OUTCOME_CODE__TIPO1 = //NOSONAR  Reason:EIAS
				"TIPO1"; //NOSONAR  Reason:EIAS
		final String GESTISCIREEWEB_OUTCOME_CODE__TIPO2 = //NOSONAR  Reason:EIAS
				"TIPO2"; //NOSONAR  Reason:EIAS
		final String GESTISCIREEWEB_OUTCOME_CODE__TIPO3 = //NOSONAR  Reason:EIAS
				"TIPO3"; //NOSONAR  Reason:EIAS
		final String GESTISCIREEWEB_OUTCOME_CODE__TIPO4 = //NOSONAR  Reason:EIAS
				"TIPO4"; //NOSONAR  Reason:EIAS
		final String GESTISCIREEWEB_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-456977324) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			DettaglioAllegato dettaglioAllegato = theModel.getAppDataallegato();
			Ruolo profiloUtente = theModel.getAppDatautenteLoggato().getRuolo();
			//GenericUtil.stampa(dettaglioAllegato, true, 3);

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

					log.debug("Sono in inserimento reeWeb");

					//se sono in inserimento ... in modifica bypasso questi controlli

					getValidationMgr().validazioneFormaleDatiAllegato(dettaglioAllegato);

					fkManutentore = ConvertUtil.convertToInteger(
							GenericUtil.getFkManutentore(dettaglioAllegato.getIdApparecchiature().get(0)));

					// recupero il manutentore (siccome appartengono tutti allo stesso manutentore, prendo il primo
					String manutApp = dettaglioAllegato.getIdApparecchiature().get(0);

					dettaglioAllegato.setIdPersonaGiuridica(
							ConvertUtil.convertToInteger(GenericUtil.getFkManutentore(manutApp)));

					//controllo se i campi obbligatori sono stati valorizzati
					getValidationMgr().verificaDatiAllegato(dettaglioAllegato, fkManutentore);

					// Se sono in inserimento devo ripulire l'id
					// Devo ripulire l'id della combo apparecchiature (e' comp4mnaut#fKManut#progressivo), devo recupero il com4manut
					dettaglioAllegato
							.setIdCom4Manut(GenericUtil.recuperaComp4Manut(dettaglioAllegato.getIdApparecchiature()));

					//GenericUtil.stampa(dettaglioAllegato, true, 3);

					log.debug("Stampo dettaglioAllegato.getIdApparecchiature() (prima): "
							+ dettaglioAllegato.getIdApparecchiature());

					// Devo ripulire l'id della combo apparecchiature (e' comp4mnaut#fKManut#progressivo), devo recupero il progressivo
					dettaglioAllegato.setIdApparecchiatureFunz(
							GenericUtil.recuperaProgressivo(dettaglioAllegato.getIdApparecchiature()));
					//					dettaglioAllegato.setIdApparecchiature(
					//							GenericUtil.recuperaProgressivo(dettaglioAllegato.getIdApparecchiature()));

					log.debug("Stampo dettaglioAllegato.getIdApparecchiature() (dopo): "
							+ dettaglioAllegato.getIdApparecchiature());

				} else {

					log.debug("Sono in modifica reeWeb");

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
				dettaglioAllegato.setCodFiscaleUtenteLoggato(theModel.getAppDatautenteLoggato().getCodiceFiscale());
				//setto il flagControlloBozza a false(0) perche' se e' null va in eccezione quando cerco di inviarlo
				dettaglioAllegato.setFlagControlloBozza(Constants.FLAG_CONTROLLO_BOZZA_ALLEGATO_FALSE);
				//setto da dove sto arrivando
				dettaglioAllegato.setArrivoDa(Constants.ARRIVO_DA_IMPIANTO);

				log.debug("BEPPE - prima di mettere in sessione: " + dettaglioAllegato);

				//rimetto in sessione l'oggetto dettaglio allegato per la action showAllegatoNow
				theModel.getSession().put(Constants.SESSIONE_VAR_DETT_ALLEGATO, dettaglioAllegato);

				theModel.setAppDataallegato(dettaglioAllegato);

				theModel.setAppDataaggiornaElencoAllegati(true);

				if (log.isDebugEnabled())
					GenericUtil.stampa(dettaglioAllegato, true, 3);

				// DEVO COPIARE I CONTROLLI DI GENERAZIONE ALLEGATO
				if (Constants.ALLEGATO_TIPO_1.equals(dettaglioAllegato.getIdTipoAllegato())
						|| Constants.ALLEGATO_TIPO_1B.equals(dettaglioAllegato.getIdTipoAllegato()))
					result.setResultCode(GESTISCIREEWEB_OUTCOME_CODE__TIPO1);
				if (Constants.ALLEGATO_TIPO_2.equals(dettaglioAllegato.getIdTipoAllegato()))
					result.setResultCode(GESTISCIREEWEB_OUTCOME_CODE__TIPO2);
				if (Constants.ALLEGATO_TIPO_3.equals(dettaglioAllegato.getIdTipoAllegato()))
					result.setResultCode(GESTISCIREEWEB_OUTCOME_CODE__TIPO3);
				if (Constants.ALLEGATO_TIPO_4.equals(dettaglioAllegato.getIdTipoAllegato()))
					result.setResultCode(GESTISCIREEWEB_OUTCOME_CODE__TIPO4);

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
			log.error("[BackEndFacade::gestisciReeWeb] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo salvaInviaAllegato definito in un ExecCommand del
	 * ContentPanel cpElencoAllegatiImpianti
	 */
	public ExecResults salvaInviaAllegato(

			it.csi.sigit.sigitwebn.dto.elenco_allegati_impianti.CpElencoAllegatiImpiantiModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String SALVAINVIAALLEGATO_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String SALVAINVIAALLEGATO_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R2122229068) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			try {
				DettaglioAllegato dettaglio = theModel.getAppDataallegato();
				log.debug("****************** DENTRO SALVA ED INVIA ALLEGATO *******************");

				if (log.isDebugEnabled())
					GenericUtil.stampa(dettaglio, true, 3);
				//chiamo il metodo di aggiornamento, update dell'allegato e il suo invio ad index

				SigitVRicercaAllegatiDto allegatoDto = getDbMgr()
						.cercaSigitVRicercaAllegatiByIdAllegato(dettaglio.getIdAllegato());
				Integer idStatoRapp = ConvertUtil.convertToInteger(allegatoDto.getFkStatoRapp());
				if (Constants.ID_STATO_RAPPORTO_INVIATO == idStatoRapp
						|| Constants.ID_STATO_RAPPORTO_RESPINTO == idStatoRapp) {

					result.getGlobalErrors().add(Messages.S129);
					theModel.getSession().put(Constants.SESSIONE_VAR_MESSAGGE,
							new Message(Messages.S129, Message.ERROR));
					result.setResultCode(SALVAINVIAALLEGATO_OUTCOME_CODE__KO);
				} else {
					// Recupero l'utente loggato per capire se e' un CAT
					Ruolo ruolo = theModel.getAppDatautenteLoggato().getRuolo();

					ResultInvioMail resultInvioMail = getConnectorMgr().inviaAllegatoTrans(dettaglio,
							ruolo.getIdPgCat(), theModel.getAppDatautenteLoggato());

					// BUG - devo verificare che l'allegano non sia gia' in stato INVIATO, l'utente potrebbe aver fatto F%

					String msg = getSigitMgr().getMsgInvioRee(dettaglio, allegatoDto, resultInvioMail);

					theModel.getSession().put(Constants.SESSIONE_VAR_MESSAGGE, new Message(msg, Message.INFO));

					theModel.setAppDataaggiornaElencoAllegati(true);

					// impostazione del result code 
					result.setResultCode(SALVAINVIAALLEGATO_OUTCOME_CODE__OK);

					// modifica degli attributi del model (che verranno propagati allo strato
					// di presentation). si puo' agire anche direttamente sull'attributo "session".
				}
			} catch (ManagerException ex) {

				theModel.getSession().put(Constants.SESSIONE_VAR_MESSAGGE,
						new Message(Messages.ERROR_RECUPERO_SERVIZIO, Message.ERROR));

				Validator.gestisciEccezione(result, ex);
			}

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::salvaInviaAllegato] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo salvaEliminaAllegato definito in un ExecCommand del
	 * ContentPanel cpElencoAllegatiImpianti
	 */
	public ExecResults salvaEliminaAllegato(

			it.csi.sigit.sigitwebn.dto.elenco_allegati_impianti.CpElencoAllegatiImpiantiModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String SALVAELIMINAALLEGATO_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String SALVAELIMINAALLEGATO_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R512636580) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			try {
				Integer idAllegatoSelezionato = theModel.getAppDataidAllegatoImpiantoSelezionato();

				getSigitMgr().eliminaAllegato(ConvertUtil.convertToString(idAllegatoSelezionato),
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

				theModel.getSession().put(Constants.SESSIONE_VAR_MESSAGGE,
						new Message(Messages.INFO_ELIMINAZIONE_CORRETTA, Message.INFO));

				result.getGlobalMessages().add(Messages.INFO_ELIMINAZIONE_CORRETTA);

				theModel.setAppDataaggiornaElencoAllegati(true);
				theModel.setAppDataidAllegatoImpiantoSelezionato(null);
				theModel.setAppDatamessaggioDinamico(null);

				result.setResultCode(SALVAELIMINAALLEGATO_OUTCOME_CODE__OK);

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
			log.error("[BackEndFacade::salvaEliminaAllegato] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo isRuoloAbilitato definito in un ExecCommand del
	 * ContentPanel cpElencoAllegatiImpianti
	 */
	public ExecResults isRuoloAbilitato(

			it.csi.sigit.sigitwebn.dto.elenco_allegati_impianti.CpElencoAllegatiImpiantiModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String ISRUOLOABILITATO_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R1670663037) ENABLED START*/
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
	 * Implementazione del metodo inizializzaElencoAllegati definito in un ExecCommand del
	 * ContentPanel cpElencoAllegatiImpianti
	 */
	public ExecResults inizializzaElencoAllegati(

			it.csi.sigit.sigitwebn.dto.elenco_allegati_impianti.CpElencoAllegatiImpiantiModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String INIZIALIZZAELENCOALLEGATI_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String INIZIALIZZAELENCOALLEGATI_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-222293554) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:
			log.debug(" inizializzaElencoAllegati --> CARICA LE INFO DALLE VISTE : ");
			//Mi arriva il codice impianto dalla sessione
			String codiceImpianto = theModel.getAppDataidImpiantoSelez();
			log.debug(" FRAAAA ID IMPIANTO SELEZIONATO: " + codiceImpianto);
			UtenteLoggato utenteLoggato = theModel.getAppDatautenteLoggato();

			//			log.debug(" FRAAAA CODICE FISCALE UTENTE LOGGATO: "
			//					+ utenteLoggato.getCodiceFiscale());
			//			log.debug(" FRAAAA DENOMINAZIONE UTENTE LOGGATO: "
			//					+ utenteLoggato.getDenominazione());
			//			log.debug(" FRAAAA RUOLO CODICE FISCALE: "
			//					+ utenteLoggato.getRuolo().getCodiceFiscale());
			//			log.debug(" FRAAAA RUOLO CODICE REA: "
			//					+ utenteLoggato.getRuolo().getCodiceRea());
			//			log.debug(" FRAAAA RUOLO DATA CESSAZIONE: "
			//					+ utenteLoggato.getRuolo().getDataCessazione());
			//			log.debug(" FRAAAA RUOLO DENOMINAZIONE DITTA: "
			//					+ utenteLoggato.getRuolo().getDenomDitta());
			//			log.debug(" FRAAAA RUOLO DESCRIZIONE RUOLO: "
			//					+ utenteLoggato.getRuolo().getDescRuolo());
			//			log.debug(" FRAAAA RUOLO SIGLA REA: "
			//					+ utenteLoggato.getRuolo().getSiglaRea());
			//			log.debug(" FRAAAA RUOLO ID PERSONA GIURIDICA: "
			//					+ utenteLoggato.getRuolo().getIdPersonaGiuridica());
			//			log.debug(" FRAAAA RUOLO ID RUOLO DA NON PRENDERE IN CONSIDERAZIONE: "
			//					+ utenteLoggato.getRuolo().getIdRuolo());
			//			log.debug(" FRAAAA RUOLO NUMERO REA: "
			//					+ utenteLoggato.getRuolo().getNumeroRea());

			AllegatiPerImpianto impianto;

			try {

				// BEPPE E' UNA PROVA
				/*
				DettaglioAllegato datiAllegato = theModel.getAppDataallegato();
				if (datiAllegato == null) {
					datiAllegato = new DettaglioAllegato();
				}
				
				//setto la sigla bollino di default e' RP
				datiAllegato.setSiglaBollino(Constants.SIGLA_BOLLINO_RP);
				//setto il codice impianto selezionato dall'elenco degli impianti
				datiAllegato.setCodiceImpianto(codiceImpianto);
				theModel.setAppDataallegato(datiAllegato);
				
				//carico le combo presenti
				this.precaricaCombo(theModel, utenteLoggato);
				 */

				// Questa gestione mi serve nel caso, ad esempio, su ree web si invia l'allegato, quando si riatterra su questa pagina bisogna visualizzare il messaggio
				Message msg = (Message) theModel.getSession().get(Constants.SESSIONE_VAR_MESSAGGE);
				if (msg != null) {
					if (msg.getType() == Message.ERROR)
						result.getGlobalErrors().add(msg.getText());
					else
						result.getGlobalMessages().add(msg.getText());

					theModel.getSession().remove(Constants.SESSIONE_VAR_MESSAGGE);
				}

				theModel.setAppDataelencoTipiDocumentoProfilati(null);

				boolean contaVerifiche = true;
				impianto = this.getSigitMgr().cercaAllegatiPerCodiceImpianto(codiceImpianto, contaVerifiche);

				if (impianto != null) {
					theModel.setAppDataidentificativoImpianto(impianto.getIdentificativoImpianto());

					theModel.setAppDataelencoAllegatiPerImpianto(impianto.getListaAllegati());

				} else {
					theModel.setAppDataelencoAllegatiPerImpianto(new ArrayList<DettaglioAllegato>());
					theModel.setAppDataidentificativoImpianto(new IdentificativoImpianto());
				}

				theModel.setAppDataaggiornaElencoAllegati(false);

				String msgDinamico = theModel.getAppDatamessaggioDinamico();

				if (GenericUtil.isNotNullOrEmpty(msgDinamico)) {
					result.getGlobalMessages().add(msgDinamico);
					theModel.setAppDatamessaggioDinamico(null);

				}

				theModel.setAppDataidAllegatoImpiantoSelezionato(null);

			} catch (ManagerException ex) {

				Validator.gestisciEccezione(result, ex);

			}

			// impostazione del result code
			result.setResultCode(INIZIALIZZAELENCOALLEGATI_OUTCOME_CODE__OK);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::inizializzaElencoAllegati] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo isVisualizzaBtnInserisciAllegato definito in un ExecCommand del
	 * ContentPanel cpElencoAllegatiImpianti
	 */
	public ExecResults isVisualizzaBtnInserisciAllegato(

			it.csi.sigit.sigitwebn.dto.elenco_allegati_impianti.CpElencoAllegatiImpiantiModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String ISVISUALIZZABTNINSERISCIALLEGATO_OUTCOME_CODE__SI = //NOSONAR  Reason:EIAS
				"SI"; //NOSONAR  Reason:EIAS
		final String ISVISUALIZZABTNINSERISCIALLEGATO_OUTCOME_CODE__NO = //NOSONAR  Reason:EIAS
				"NO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R1648324475) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			UtenteLoggato utente = theModel.getAppDatautenteLoggato();

			log.debug(" VISUALIZZAZIONE BOTTONE INSERISCI ALLEGATO ---> PER IMPIANTO");

			String descrizioneRuolo = utente.getRuolo().getDescRuolo();

			log.debug(" isVisualizzaBtnInserisciAllegato ---> descrizioneRuolo: " + descrizioneRuolo);

			if (descrizioneRuolo.equals(Constants.RUOLO_IMPRESA) || descrizioneRuolo.equals(Constants.RUOLO_VALIDATORE)
					|| descrizioneRuolo.equals(Constants.RUOLO_SUPER)) {
				// impostazione del result code
				result.setResultCode(ISVISUALIZZABTNINSERISCIALLEGATO_OUTCOME_CODE__SI);
			} else {
				// impostazione del result code
				result.setResultCode(ISVISUALIZZABTNINSERISCIALLEGATO_OUTCOME_CODE__NO);
			}

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error(
					"[BackEndFacade::isVisualizzaBtnInserisciAllegato] Errore occorso nell'esecuzione del metodo:" + e,
					e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo gestioneVisBottoniInit definito in un ExecCommand del
	 * ContentPanel cpElencoAllegatiImpianti
	 */
	public ExecResults gestioneVisBottoniInit(

			it.csi.sigit.sigitwebn.dto.elenco_allegati_impianti.CpElencoAllegatiImpiantiModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GESTIONEVISBOTTONIINIT_OUTCOME_CODE__VISUALIZZA = //NOSONAR  Reason:EIAS
				"VISUALIZZA"; //NOSONAR  Reason:EIAS
		final String GESTIONEVISBOTTONIINIT_OUTCOME_CODE__NASCONDI = //NOSONAR  Reason:EIAS
				"NASCONDI"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-554505988) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			ArrayList<DettaglioAllegato> listAllegati = theModel.getAppDataelencoAllegatiPerImpianto();

			if (listAllegati != null && listAllegati.size() > 0) {
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
	 * Implementazione del metodo isVisualizzaBtnModificaAllegato definito in un ExecCommand del
	 * ContentPanel cpElencoAllegatiImpianti
	 */
	public ExecResults isVisualizzaBtnModificaAllegato(

			it.csi.sigit.sigitwebn.dto.elenco_allegati_impianti.CpElencoAllegatiImpiantiModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String ISVISUALIZZABTNMODIFICAALLEGATO_OUTCOME_CODE__SI = //NOSONAR  Reason:EIAS
				"SI"; //NOSONAR  Reason:EIAS
		final String ISVISUALIZZABTNMODIFICAALLEGATO_OUTCOME_CODE__NO = //NOSONAR  Reason:EIAS
				"NO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-295674632) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			UtenteLoggato utente = theModel.getAppDatautenteLoggato();

			log.debug(" VISUALIZZAZIONE BOTTONE MODIFICA ALLEGATO PER IMPIANTO");

			String descrizioneRuolo = utente.getRuolo().getDescRuolo();

			log.debug(" isVisualizzaBtnModificaAllegato ---> descrizioneRuolo: " + descrizioneRuolo);

			if (descrizioneRuolo.equals(Constants.RUOLO_IMPRESA) || descrizioneRuolo.equals(Constants.RUOLO_VALIDATORE)
					|| descrizioneRuolo.equals(Constants.RUOLO_SUPER)) {
				// impostazione del result code
				result.setResultCode(ISVISUALIZZABTNMODIFICAALLEGATO_OUTCOME_CODE__SI);
			} else {
				// impostazione del result code
				result.setResultCode(ISVISUALIZZABTNMODIFICAALLEGATO_OUTCOME_CODE__NO);
			}

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::isVisualizzaBtnModificaAllegato] Errore occorso nell'esecuzione del metodo:" + e,
					e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo isVisualizzaBtnInviaAllegato definito in un ExecCommand del
	 * ContentPanel cpElencoAllegatiImpianti
	 */
	public ExecResults isVisualizzaBtnInviaAllegato(

			it.csi.sigit.sigitwebn.dto.elenco_allegati_impianti.CpElencoAllegatiImpiantiModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String ISVISUALIZZABTNINVIAALLEGATO_OUTCOME_CODE__SI = //NOSONAR  Reason:EIAS
				"SI"; //NOSONAR  Reason:EIAS
		final String ISVISUALIZZABTNINVIAALLEGATO_OUTCOME_CODE__NO = //NOSONAR  Reason:EIAS
				"NO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R1596098461) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			UtenteLoggato utente = theModel.getAppDatautenteLoggato();

			log.debug(" VISUALIZZAZIONE BOTTONE INVIA ALLEGATO  --> PER IMPIANTO");

			String descrizioneRuolo = utente.getRuolo().getDescRuolo();

			log.debug(" isVisualizzaBtnInviaAllegato ---> descrizioneRuolo: " + descrizioneRuolo);

			if (descrizioneRuolo.equals(Constants.RUOLO_IMPRESA) || descrizioneRuolo.equals(Constants.RUOLO_VALIDATORE)
					|| descrizioneRuolo.equals(Constants.RUOLO_SUPER)) {
				// impostazione del result code
				result.setResultCode(ISVISUALIZZABTNINVIAALLEGATO_OUTCOME_CODE__SI);
			} else {
				// impostazione del result code
				result.setResultCode(ISVISUALIZZABTNINVIAALLEGATO_OUTCOME_CODE__NO);
			}

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::isVisualizzaBtnInviaAllegato] Errore occorso nell'esecuzione del metodo:" + e,
					e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo isVisualizzaBtnRespingiAllegato definito in un ExecCommand del
	 * ContentPanel cpElencoAllegatiImpianti
	 */
	public ExecResults isVisualizzaBtnRespingiAllegato(

			it.csi.sigit.sigitwebn.dto.elenco_allegati_impianti.CpElencoAllegatiImpiantiModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String ISVISUALIZZABTNRESPINGIALLEGATO_OUTCOME_CODE__SI = //NOSONAR  Reason:EIAS
				"SI"; //NOSONAR  Reason:EIAS
		final String ISVISUALIZZABTNRESPINGIALLEGATO_OUTCOME_CODE__NO = //NOSONAR  Reason:EIAS
				"NO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R1580635977) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			UtenteLoggato utente = theModel.getAppDatautenteLoggato();

			log.debug(" VISUALIZZAZIONE BOTTONE RESPINGI ALLEGATO  --> PER IMPIANTO");

			String descrizioneRuolo = utente.getRuolo().getDescRuolo();

			log.debug(" isVisualizzaBtnRespingiAllegato ---> descrizioneRuolo: " + descrizioneRuolo);

			if (descrizioneRuolo.equals(Constants.RUOLO_VALIDATORE) || descrizioneRuolo.equals(Constants.RUOLO_SUPER)) {
				// impostazione del result code
				result.setResultCode(ISVISUALIZZABTNRESPINGIALLEGATO_OUTCOME_CODE__SI);
			} else {
				// impostazione del result code
				result.setResultCode(ISVISUALIZZABTNRESPINGIALLEGATO_OUTCOME_CODE__NO);
			}

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::isVisualizzaBtnRespingiAllegato] Errore occorso nell'esecuzione del metodo:" + e,
					e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo isVisualizzaBtnRicevuta definito in un ExecCommand del
	 * ContentPanel cpElencoAllegatiImpianti
	 */
	public ExecResults isVisualizzaBtnRicevuta(

			it.csi.sigit.sigitwebn.dto.elenco_allegati_impianti.CpElencoAllegatiImpiantiModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String ISVISUALIZZABTNRICEVUTA_OUTCOME_CODE__SI = //NOSONAR  Reason:EIAS
				"SI"; //NOSONAR  Reason:EIAS
		final String ISVISUALIZZABTNRICEVUTA_OUTCOME_CODE__NO = //NOSONAR  Reason:EIAS
				"NO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-676565228) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			UtenteLoggato utente = theModel.getAppDatautenteLoggato();

			log.debug(" VISUALIZZAZIONE BOTTONE INVIA ALLEGATO  ---> PER IMPIANTO");

			String descrizioneRuolo = utente.getRuolo().getDescRuolo();

			log.debug(" isVisualizzaBtnInviaAllegato ---> descrizioneRuolo: " + descrizioneRuolo);

			if (descrizioneRuolo.equals(Constants.RUOLO_IMPRESA) || descrizioneRuolo.equals(Constants.RUOLO_VALIDATORE)
					|| descrizioneRuolo.equals(Constants.RUOLO_SUPER)
					|| descrizioneRuolo.equals(Constants.RUOLO_ISPETTORE)
					|| descrizioneRuolo.equals(Constants.RUOLO_CONSULTATORE)
					|| descrizioneRuolo.equals(Constants.RUOLO_RESPONSABILE)
					|| descrizioneRuolo.equals(Constants.RUOLO_RESPONSABILE_IMPRESA)) {
				// impostazione del result code
				result.setResultCode(ISVISUALIZZABTNRICEVUTA_OUTCOME_CODE__SI);
			} else {
				// impostazione del result code
				result.setResultCode(ISVISUALIZZABTNRICEVUTA_OUTCOME_CODE__NO);
			}

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::isVisualizzaBtnRicevuta] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo isVisualizzaBtnEliminaAllegato definito in un ExecCommand del
	 * ContentPanel cpElencoAllegatiImpianti
	 */
	public ExecResults isVisualizzaBtnEliminaAllegato(

			it.csi.sigit.sigitwebn.dto.elenco_allegati_impianti.CpElencoAllegatiImpiantiModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String ISVISUALIZZABTNELIMINAALLEGATO_OUTCOME_CODE__SI = //NOSONAR  Reason:EIAS
				"SI"; //NOSONAR  Reason:EIAS
		final String ISVISUALIZZABTNELIMINAALLEGATO_OUTCOME_CODE__NO = //NOSONAR  Reason:EIAS
				"NO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R1707264181) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			UtenteLoggato utente = theModel.getAppDatautenteLoggato();

			log.debug(" VISUALIZZAZIONE BOTTONE ELIMINA ALLEGATO --> PER IMPIANTO");

			String descrizioneRuolo = utente.getRuolo().getDescRuolo();

			log.debug(" isVisualizzaBtnEliminaAllegato ---> descrizioneRuolo: " + descrizioneRuolo);

			if (descrizioneRuolo.equals(Constants.RUOLO_IMPRESA) || descrizioneRuolo.equals(Constants.RUOLO_VALIDATORE)
					|| descrizioneRuolo.equals(Constants.RUOLO_SUPER)) {
				// impostazione del result code
				result.setResultCode(ISVISUALIZZABTNELIMINAALLEGATO_OUTCOME_CODE__SI);
			} else {
				// impostazione del result code
				result.setResultCode(ISVISUALIZZABTNELIMINAALLEGATO_OUTCOME_CODE__NO);
			}

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::isVisualizzaBtnEliminaAllegato] Errore occorso nell'esecuzione del metodo:" + e,
					e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo aggiornaDatiPagina definito in un ExecCommand del
	 * ContentPanel cpElencoAllegatiImpianti
	 */
	public ExecResults aggiornaDatiPagina(

			it.csi.sigit.sigitwebn.dto.elenco_allegati_impianti.CpElencoAllegatiImpiantiModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String AGGIORNADATIPAGINA_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String AGGIORNADATIPAGINA_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-443759185) ENABLED START*/
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

				//devo riaggiornare la lista degli allegati
				log.debug("fraaaaaaaaaaaaaaa dentro aggiorna dati pagina  codice impianto: "
						+ theModel.getAppDataidImpiantoSelez());

				log.debug("aggiornaDatiPagina - theModel.getAppDataaggiornaElencoAllegati(): "
						+ theModel.getAppDataaggiornaElencoAllegati());

				if (theModel.getAppDataaggiornaElencoAllegati()) {

					caricaElencoAllegati(theModel);

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
	 * ContentPanel cpElencoAllegatiImpianti
	 */
	public ExecResults gestioneVisBottoniRef(

			it.csi.sigit.sigitwebn.dto.elenco_allegati_impianti.CpElencoAllegatiImpiantiModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GESTIONEVISBOTTONIREF_OUTCOME_CODE__VISUALIZZA = //NOSONAR  Reason:EIAS
				"VISUALIZZA"; //NOSONAR  Reason:EIAS
		final String GESTIONEVISBOTTONIREF_OUTCOME_CODE__NASCONDI = //NOSONAR  Reason:EIAS
				"NASCONDI"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R1340091609) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			ArrayList<DettaglioAllegato> listAllegati = theModel.getAppDataelencoAllegatiPerImpianto();

			if (listAllegati != null && listAllegati.size() > 0) {
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
	 * Implementazione del metodo isVisualizzaBtnModificaAllegatoRef definito in un ExecCommand del
	 * ContentPanel cpElencoAllegatiImpianti
	 */
	public ExecResults isVisualizzaBtnModificaAllegatoRef(

			it.csi.sigit.sigitwebn.dto.elenco_allegati_impianti.CpElencoAllegatiImpiantiModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String ISVISUALIZZABTNMODIFICAALLEGATOREF_OUTCOME_CODE__SI = //NOSONAR  Reason:EIAS
				"SI"; //NOSONAR  Reason:EIAS
		final String ISVISUALIZZABTNMODIFICAALLEGATOREF_OUTCOME_CODE__NO = //NOSONAR  Reason:EIAS
				"NO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R866041997) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			UtenteLoggato utente = theModel.getAppDatautenteLoggato();

			log.debug(" VISUALIZZAZIONE BOTTONE MODIFICA ALLEGATO PER IMPIANTO");

			String descrizioneRuolo = utente.getRuolo().getDescRuolo();

			log.debug(" isVisualizzaBtnModificaAllegato ---> descrizioneRuolo: " + descrizioneRuolo);

			if (descrizioneRuolo.equals(Constants.RUOLO_IMPRESA) || descrizioneRuolo.equals(Constants.RUOLO_VALIDATORE)
					|| descrizioneRuolo.equals(Constants.RUOLO_SUPER)) {
				// impostazione del result code 
				result.setResultCode(ISVISUALIZZABTNMODIFICAALLEGATOREF_OUTCOME_CODE__SI);
			} else {
				// impostazione del result code 
				result.setResultCode(ISVISUALIZZABTNMODIFICAALLEGATOREF_OUTCOME_CODE__NO);
			}

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
	 * Implementazione del metodo isVisualizzaBtnInviaAllegatoRef definito in un ExecCommand del
	 * ContentPanel cpElencoAllegatiImpianti
	 */
	public ExecResults isVisualizzaBtnInviaAllegatoRef(

			it.csi.sigit.sigitwebn.dto.elenco_allegati_impianti.CpElencoAllegatiImpiantiModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String ISVISUALIZZABTNINVIAALLEGATOREF_OUTCOME_CODE__SI = //NOSONAR  Reason:EIAS
				"SI"; //NOSONAR  Reason:EIAS
		final String ISVISUALIZZABTNINVIAALLEGATOREF_OUTCOME_CODE__NO = //NOSONAR  Reason:EIAS
				"NO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R117397448) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			UtenteLoggato utente = theModel.getAppDatautenteLoggato();

			log.debug(" VISUALIZZAZIONE BOTTONE INVIA ALLEGATO  --> PER IMPIANTO");

			String descrizioneRuolo = utente.getRuolo().getDescRuolo();

			log.debug(" isVisualizzaBtnInviaAllegato ---> descrizioneRuolo: " + descrizioneRuolo);

			if (descrizioneRuolo.equals(Constants.RUOLO_IMPRESA) || descrizioneRuolo.equals(Constants.RUOLO_VALIDATORE)
					|| descrizioneRuolo.equals(Constants.RUOLO_SUPER)) {
				// impostazione del result code 
				result.setResultCode(ISVISUALIZZABTNINVIAALLEGATOREF_OUTCOME_CODE__SI);
			} else {
				// impostazione del result code 
				result.setResultCode(ISVISUALIZZABTNINVIAALLEGATOREF_OUTCOME_CODE__NO);
			}

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::isVisualizzaBtnInviaAllegatoRef] Errore occorso nell'esecuzione del metodo:" + e,
					e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo isVisualizzaBtnRespingiAllegatoRef definito in un ExecCommand del
	 * ContentPanel cpElencoAllegatiImpianti
	 */
	public ExecResults isVisualizzaBtnRespingiAllegatoRef(

			it.csi.sigit.sigitwebn.dto.elenco_allegati_impianti.CpElencoAllegatiImpiantiModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String ISVISUALIZZABTNRESPINGIALLEGATOREF_OUTCOME_CODE__SI = //NOSONAR  Reason:EIAS
				"SI"; //NOSONAR  Reason:EIAS
		final String ISVISUALIZZABTNRESPINGIALLEGATOREF_OUTCOME_CODE__NO = //NOSONAR  Reason:EIAS
				"NO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-963962724) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			UtenteLoggato utente = theModel.getAppDatautenteLoggato();

			log.debug(" VISUALIZZAZIONE BOTTONE RESPINGI ALLEGATO  --> PER IMPIANTO");

			String descrizioneRuolo = utente.getRuolo().getDescRuolo();

			log.debug(" isVisualizzaBtnRespingiAllegato ---> descrizioneRuolo: " + descrizioneRuolo);

			if (descrizioneRuolo.equals(Constants.RUOLO_VALIDATORE) || descrizioneRuolo.equals(Constants.RUOLO_SUPER)) {
				// impostazione del result code 
				result.setResultCode(ISVISUALIZZABTNRESPINGIALLEGATOREF_OUTCOME_CODE__SI);
			} else {
				// impostazione del result code 
				result.setResultCode(ISVISUALIZZABTNRESPINGIALLEGATOREF_OUTCOME_CODE__NO);
			}

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::isVisualizzaBtnRespingiAllegatoRef] Errore occorso nell'esecuzione del metodo:"
					+ e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo isVisualizzaBtnRicevutaRef definito in un ExecCommand del
	 * ContentPanel cpElencoAllegatiImpianti
	 */
	public ExecResults isVisualizzaBtnRicevutaRef(

			it.csi.sigit.sigitwebn.dto.elenco_allegati_impianti.CpElencoAllegatiImpiantiModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String ISVISUALIZZABTNRICEVUTAREF_OUTCOME_CODE__SI = //NOSONAR  Reason:EIAS
				"SI"; //NOSONAR  Reason:EIAS
		final String ISVISUALIZZABTNRICEVUTAREF_OUTCOME_CODE__NO = //NOSONAR  Reason:EIAS
				"NO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R1057892593) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			UtenteLoggato utente = theModel.getAppDatautenteLoggato();

			log.debug(" VISUALIZZAZIONE BOTTONE INVIA ALLEGATO  ---> PER IMPIANTO");

			String descrizioneRuolo = utente.getRuolo().getDescRuolo();

			log.debug(" isVisualizzaBtnInviaAllegato ---> descrizioneRuolo: " + descrizioneRuolo);

			if (descrizioneRuolo.equals(Constants.RUOLO_IMPRESA) || descrizioneRuolo.equals(Constants.RUOLO_VALIDATORE)
					|| descrizioneRuolo.equals(Constants.RUOLO_SUPER)
					|| descrizioneRuolo.equals(Constants.RUOLO_ISPETTORE)
					|| descrizioneRuolo.equals(Constants.RUOLO_CONSULTATORE)
					|| descrizioneRuolo.equals(Constants.RUOLO_RESPONSABILE)
					|| descrizioneRuolo.equals(Constants.RUOLO_RESPONSABILE_IMPRESA)) {
				// impostazione del result code 
				result.setResultCode(ISVISUALIZZABTNRICEVUTAREF_OUTCOME_CODE__SI);
			} else {
				// impostazione del result code 
				result.setResultCode(ISVISUALIZZABTNRICEVUTAREF_OUTCOME_CODE__NO);
			}

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::isVisualizzaBtnRicevutaRef] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo isVisualizzaBtnEliminaAllegatoRef definito in un ExecCommand del
	 * ContentPanel cpElencoAllegatiImpianti
	 */
	public ExecResults isVisualizzaBtnEliminaAllegatoRef(

			it.csi.sigit.sigitwebn.dto.elenco_allegati_impianti.CpElencoAllegatiImpiantiModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String ISVISUALIZZABTNELIMINAALLEGATOREF_OUTCOME_CODE__SI = //NOSONAR  Reason:EIAS
				"SI"; //NOSONAR  Reason:EIAS
		final String ISVISUALIZZABTNELIMINAALLEGATOREF_OUTCOME_CODE__NO = //NOSONAR  Reason:EIAS
				"NO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R435576752) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			UtenteLoggato utente = theModel.getAppDatautenteLoggato();

			log.debug(" VISUALIZZAZIONE BOTTONE ELIMINA ALLEGATO --> PER IMPIANTO");

			String descrizioneRuolo = utente.getRuolo().getDescRuolo();

			log.debug(" isVisualizzaBtnEliminaAllegato ---> descrizioneRuolo: " + descrizioneRuolo);

			if (descrizioneRuolo.equals(Constants.RUOLO_IMPRESA) || descrizioneRuolo.equals(Constants.RUOLO_VALIDATORE)
					|| descrizioneRuolo.equals(Constants.RUOLO_SUPER)) {
				// impostazione del result code 
				result.setResultCode(ISVISUALIZZABTNELIMINAALLEGATOREF_OUTCOME_CODE__SI);
			} else {
				// impostazione del result code 
				result.setResultCode(ISVISUALIZZABTNELIMINAALLEGATOREF_OUTCOME_CODE__NO);
			}

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error(
					"[BackEndFacade::isVisualizzaBtnEliminaAllegatoRef] Errore occorso nell'esecuzione del metodo:" + e,
					e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	//////////////////////////////////////////////////////////////////////////////
	/// Metodi statici per il reset delle tabelle
	//////////////////////////////////////////////////////////////////////////////

	/**
	 * permette di resettare lo stato di paginazione della tabella widg_tblElencoAllegati
	 */
	public static void resetClearStatus_widg_tblElencoAllegati(java.util.Map session) {
		session.put("cpElencoAllegatiImpianti_tblElencoAllegati_clearStatus", Boolean.TRUE);
	}

	//////////////////////////////////////////////////////////////////////////////
	/// Property aggiuntive del bean
	//////////////////////////////////////////////////////////////////////////////
	/*PROTECTED REGION ID(R-777997698) ENABLED START*/
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

	private ConnectorMgr connectorMgr;

	public ConnectorMgr getConnectorMgr() {
		return connectorMgr;
	}

	public void setConnectorMgr(ConnectorMgr connectorMgr) {
		this.connectorMgr = connectorMgr;
	}

	private void precaricaCombo(
			it.csi.sigit.sigitwebn.dto.elenco_allegati_impianti.CpElencoAllegatiImpiantiModel theModel,
			UtenteLoggato utenteLoggato) throws BEException {

		try {

			// BEPPE - prova ottimizzazione

			//if (theModel.getAppDataelencoTipiDocumentoProfilati() == null) {
			//carico la combo dei tipi di allegato deve essere profilato
			theModel.setAppDataelencoTipiDocumentoProfilati(
					getDbMgr().cercaListaTipiDocumentoProfilato(theModel.getAppDataallegato().getCodiceImpianto()));
			//}

			/*
			 * Beppe - adesso c'è l'assegnazione automatica
			
			//carico la combo dei numero bollini in base all'utente loggato
			theModel.setAppDataelencoNumeroBollinoVerde(
					getSigitMgr().cercaElencoNumeriBollinoVerde(utenteLoggato.getRuolo().getIdPersonaGiuridica(),
							ConvertUtil.convertToInteger(theModel.getAppDataallegato().getCodiceImpianto()),
							theModel.getAppDataallegato().getIdAllegato()));
			*/

			/*
			if (theModel.getAppDataallegato().getIdTipoAllegato() != null) {
				theModel.setAppDataelencoNumeroBollinoVerde(getSigitMgr()
						.cercaElencoNumeriBollinoVerde(
								utenteLoggato.getRuolo().getIdPersonaGiuridica(),
								ConvertUtil.convertToInteger(theModel
										.getAppDataallegato()
										.getCodiceImpianto()),
								theModel.getAppDataallegato().getIdAllegato()));
			} else {
				theModel.setAppDataelencoNumeroBollinoVerde(getSigitMgr()
						.cercaElencoNumeriBollinoVerde(
								utenteLoggato.getRuolo().getIdPersonaGiuridica(),
								ConvertUtil.convertToInteger(theModel
										.getAppDataallegato()
										.getCodiceImpianto()),
								theModel.getAppDataallegato().getIdAllegato()));
			}
			 */

		} catch (ManagerException e) {
			throw new BEException("Errore in CpElencoAllegatiImpiantiModel per il metodo  precaricaCombo:" + e, e);
		}
	}

	private void caricaElencoAllegati(
			it.csi.sigit.sigitwebn.dto.elenco_allegati_impianti.CpElencoAllegatiImpiantiModel theModel)
			throws ManagerException {

		try {
			log.debug("Carico l'elenco degli allegato");
			String codiceImpianto = theModel.getAppDataidImpiantoSelez();
			AllegatiPerImpianto impianto;
			boolean contaVerifiche = true;
			impianto = getSigitMgr().cercaAllegatiPerCodiceImpianto(codiceImpianto, contaVerifiche);

			if (impianto != null) {
				theModel.setAppDataelencoAllegatiPerImpianto(impianto.getListaAllegati());
			}
			resetClearStatus_widg_tblElencoAllegati(theModel.getSession());
			theModel.setAppDataaggiornaElencoAllegati(false);
			log.debug("CaricaElencoAllegati: END");
		} catch (ManagerException e) {
			log.error("Errore: ", e);
			throw e;
		}

	}

	private DettaglioAllegato getIdentificativoAllegato(
			it.csi.sigit.sigitwebn.dto.elenco_allegati_impianti.CpElencoAllegatiImpiantiModel theModel) {
		DettaglioAllegato dettaglioAllegato = new DettaglioAllegato();

		String idImpiantoSelez = ConvertUtil.convertToString(theModel.getAppDataidAllegatoImpiantoSelezionato());

		ArrayList<DettaglioAllegato> risDettaglioAllegatoList = theModel.getAppDataelencoAllegatiPerImpianto();

		for (DettaglioAllegato risultatoDettaglioAllegato : risDettaglioAllegatoList) {

			if (risultatoDettaglioAllegato.getIdAllegato().equals(idImpiantoSelez)) {

				dettaglioAllegato = risultatoDettaglioAllegato;
			}
		}

		return dettaglioAllegato;

	}

	/*PROTECTED REGION END*/
}
