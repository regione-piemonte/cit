package it.csi.sigit.sigitwebn.business.risultato_ricerca_allegati_module;

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

/*PROTECTED REGION ID(R757601269) ENABLED START*/
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.SigitVRicercaAllegatiDto;
import it.csi.sigit.sigitwebn.business.manager.DbMgr;
import it.csi.sigit.sigitwebn.business.manager.SigitMgr;
import it.csi.sigit.sigitwebn.business.manager.ConnectorMgr;

import it.csi.sigit.sigitwebn.business.manager.ValidationMgr;
import it.csi.sigit.sigitwebn.business.manager.util.DbManagerException;
import it.csi.sigit.sigitwebn.business.manager.util.ManagerException;
import it.csi.sigit.sigitwebn.business.manager.util.Message;
import it.csi.sigit.sigitwebn.business.manager.util.ServiceException;
import it.csi.sigit.sigitwebn.business.manager.util.ValidationManagerException;
import it.csi.sigit.sigitwebn.dto.ExecResults;
import it.csi.sigit.sigitwebn.dto.allegati.DettaglioAllegato;
import it.csi.sigit.sigitwebn.dto.allegati.ElencoAllegati;
import it.csi.sigit.sigitwebn.dto.main.UtenteLoggato;
import it.csi.sigit.sigitwebn.dto.risultato_ricerca_allegati_module.CpRisultatoRicercaAllegatiModel;
import it.csi.sigit.sigitwebn.util.mail.ResultInvioMail;

import java.util.ArrayList;
import java.util.Map;

/*PROTECTED REGION END*/

public class CPBECpRisultatoRicercaAllegati {

	/**  */
	protected static final Logger log = //NOSONAR  Reason:EIAS 
			Logger.getLogger(Constants.APPLICATION_CODE + ".business"); //NOSONAR  Reason:EIAS

	//////////////////////////////////////////////////////////////////////////////
	/// Costanti identificative degli Application Data
	//////////////////////////////////////////////////////////////////////////////

	// ApplicationData: [utenteLoggato, scope:USER_SESSION]
	public static final String APPDATA_UTENTELOGGATO_CODE = "appDatautenteLoggato";

	// ApplicationData: [identificativoImpianto, scope:USER_SESSION]
	public static final String APPDATA_IDENTIFICATIVOIMPIANTO_CODE = "appDataidentificativoImpianto";

	// ApplicationData: [elencoAllegati, scope:USER_SESSION]
	public static final String APPDATA_ELENCOALLEGATI_CODE = "appDataelencoAllegati";

	// ApplicationData: [ricercaAllegati, scope:USER_SESSION]
	public static final String APPDATA_RICERCAALLEGATI_CODE = "appDataricercaAllegati";

	// ApplicationData: [idAllegatoSelezionato, scope:USER_SESSION]
	public static final String APPDATA_IDALLEGATOSELEZIONATO_CODE = "appDataidAllegatoSelezionato";

	// ApplicationData: [currentUser, scope:USER_SESSION]
	public static final String APPDATA_CURRENTUSER_CODE = "appDatacurrentUser";

	// ApplicationData: [aggiornaElencoAllegati, scope:USER_SESSION]
	public static final String APPDATA_AGGIORNAELENCOALLEGATI_CODE = "appDataaggiornaElencoAllegati";

	// ApplicationData: [messaggioDinamico, scope:USER_SESSION]
	public static final String APPDATA_MESSAGGIODINAMICO_CODE = "appDatamessaggioDinamico";

	// ApplicationData: [elencoProvince, scope:USER_SESSION]
	public static final String APPDATA_ELENCOPROVINCE_CODE = "appDataelencoProvince";

	// ApplicationData: [allegato, scope:USER_SESSION]
	public static final String APPDATA_ALLEGATO_CODE = "appDataallegato";

	// ApplicationData: [paginaChiamanteAllegati, scope:USER_SESSION]
	public static final String APPDATA_PAGINACHIAMANTEALLEGATI_CODE = "appDatapaginaChiamanteAllegati";

	// ApplicationData: [dettaglioElencoAllegati, scope:USER_SESSION]
	public static final String APPDATA_DETTAGLIOELENCOALLEGATI_CODE = "appDatadettaglioElencoAllegati";

	// ApplicationData: [reeMenuTree, scope:USER_SESSION]
	public static final String APPDATA_REEMENUTREE_CODE = "appDatareeMenuTree";

	//////////////////////////////////////////////////////////////////////////////
	/// Metodi associati alla U.I.
	//////////////////////////////////////////////////////////////////////////////

	// nome del content panel associato al bean
	public static final String CPNAME = "cpRisultatoRicercaAllegati";

	/** 
	 * Restituisce il tab correntemente visibile in un determinato tab set
	 */
	private String getCurrentTab(Map session, String tabSetName) {
		String value = (String) session.get(CPNAME + "_" + tabSetName + "_selectedMultiPanel");
		return value;
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo gestisciReeWeb definito in un ExecCommand del
	 * ContentPanel cpRisultatoRicercaAllegati
	 */
	public ExecResults gestisciReeWeb(

			it.csi.sigit.sigitwebn.dto.risultato_ricerca_allegati_module.CpRisultatoRicercaAllegatiModel theModel

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
			/*PROTECTED REGION ID(R-923290187) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			Integer idAllegatoSelezionato = theModel.getAppDataidAllegatoSelezionato();
			log.debug(
					" FRAAAAA ----> MODIFICA ALLEGATO  dentro RISULTATO RICERCA ALLEGATI------------> idAllegatoSelezionato: "
							+ idAllegatoSelezionato);
			Ruolo ruoloUtente = theModel.getAppDatautenteLoggato().getRuolo();

			try {
				//se non lo hanno selezionato questo metodo mi blocca
				getValidationMgr().checkSelezioneElemento(ConvertUtil.convertToString(idAllegatoSelezionato));

				allegatoSelezIsREE(theModel);

				DettaglioAllegato dettaglioAllegato = getSigitMgr().gestisciAllegatoById(idAllegatoSelezionato);

				IdentificativoImpianto identificativo = getSigitMgr()
						.cercaIdentificativoImpianto(dettaglioAllegato.getCodiceImpianto());

				theModel.setAppDataidentificativoImpianto(identificativo);

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
						dettaglioAllegato.setArrivoDa(Constants.ARRIVO_DA_ALLEGATI);

						theModel.setAppDataallegato(dettaglioAllegato);

						//rimetto in sessione l'oggetto dettaglio allegato per la action showAllegatoNow
						theModel.getSession().put(Constants.SESSIONE_VAR_DETT_ALLEGATO, dettaglioAllegato);

						theModel.setAppDataaggiornaElencoAllegati(true);

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

					} else {
						//se l'allegato e' in stato inviato e/o respinto 
						/* getValidationMgr()
								.verificaSeAllegatoModificabile(
										ConvertUtil.convertToInteger(dettaglioAllegato
												.getIdImpiantoRuoloPfPg()),
										ruoloUtente.getIdPersonaGiuridica(), false);*/

						result.getGlobalErrors().add(Messages.S040);

						// impostazione del result code 
						result.setResultCode(GESTISCIREEWEB_OUTCOME_CODE__KO);
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
			log.error("[BackEndFacade::gestisciReeWeb] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo dettaglioAllegato definito in un ExecCommand del
	 * ContentPanel cpRisultatoRicercaAllegati
	 */
	public ExecResults dettaglioAllegato(

			it.csi.sigit.sigitwebn.dto.risultato_ricerca_allegati_module.CpRisultatoRicercaAllegatiModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String DETTAGLIOALLEGATO_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String DETTAGLIOALLEGATO_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-665039922) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			Integer idAllegatoSelezionato = theModel.getAppDataidAllegatoSelezionato();
			log.debug(" BEPPE ----> DETTAGLIO ALLEGATO ------------> idAllegatoSelezionato: " + idAllegatoSelezionato);

			try {

				Ruolo ruoloUtente = theModel.getAppDatautenteLoggato().getRuolo();

				//se non lo hanno selezionato questo metodo mi blocca
				getValidationMgr().checkSelezioneElemento(ConvertUtil.convertToString(idAllegatoSelezionato));

				allegatoSelezIsREE(theModel);

				getValidationMgr().validazioneFormaleDettaglioAllegato(idAllegatoSelezionato, ruoloUtente);

				String idImpianto = getCodiceImpianto(theModel.getAppDataelencoAllegati(), idAllegatoSelezionato);

				theModel.getSession().put(Constants.SESSIONE_VAR_ID_ALLEGATO,
						ConvertUtil.convertToString(idAllegatoSelezionato));

				theModel.getSession().put(Constants.SESSIONE_VAR_ID_IMPIANTO, idImpianto);

				// impostazione del result code 
				result.setResultCode(DETTAGLIOALLEGATO_OUTCOME_CODE__OK);
			} catch (ManagerException ex) {
				Validator.gestisciEccezione(result, ex);

			}

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::dettaglioAllegato] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo inviaAllegato definito in un ExecCommand del
	 * ContentPanel cpRisultatoRicercaAllegati
	 */
	public ExecResults inviaAllegato(

			it.csi.sigit.sigitwebn.dto.risultato_ricerca_allegati_module.CpRisultatoRicercaAllegatiModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String INVIAALLEGATO_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String INVIAALLEGATO_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-1445673648) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			try {

				Integer idAllegatoSelezionato = theModel.getAppDataidAllegatoSelezionato();
				log.debug(
						" FRAAAAA ----> INVIA ALLEGATO  da RISULTATO RICERCA ALLEGATI------------> idAllegatoSelezionato: "
								+ idAllegatoSelezionato);
				Ruolo ruoloUtente = theModel.getAppDatautenteLoggato().getRuolo();

				//controllo che abbiano selezionato un allegato
				getValidationMgr().checkSelezioneElemento(ConvertUtil.convertToString(idAllegatoSelezionato));

				allegatoSelezIsREE(theModel);

				String codiceImpianto = getCodiceImpianto(theModel.getAppDataelencoAllegati(), idAllegatoSelezionato);

				log.debug("Codice impianto: " + codiceImpianto);

				//vado a cercare il dettaglio dell'allegato con la primary Key
				DettaglioAllegato dettaglioAllegato = this.getDbMgr()
						.getDettaglioAllegatoByIdAllegato(idAllegatoSelezionato, codiceImpianto);

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
				} else if (getSigitMgr().isPresenteLibrettoBozza(codiceImpianto)) {
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
						result.setResultCode(INVIAALLEGATO_OUTCOME_CODE__KO);
					} else {
						//vuol dire che e' in stato BOZZA, controllo il flag sulla tabella sigit_t_allegato e' stato ceccato
						if (dettaglioAllegato.getFlagControlloBozza() != Constants.FLAG_CONTROLLO_BOZZA_ALLEGATO_TRUE) {
							result.getGlobalErrors().add(Messages.S065);
							result.setResultCode(INVIAALLEGATO_OUTCOME_CODE__KO);
						} else if (getValidationMgr().isNessunResponsabileByCodImpiantoApp(codiceImpianto,
								dettaglioAllegato.getDataControllo(), dettaglioAllegato.getIdTipoAllegato(),
								dettaglioAllegato.getIdApparecchiature())) {
							throw new ValidationManagerException(
									new Message(Messages.ERROR_RESPONSABILE_DATA_RAPP_ASSENTE));
						} else if (getDbMgr().cercaResponsabileAttivoByCodImpianto(
								ConvertUtil.convertToInteger(codiceImpianto)) == null) {
							// Vuol dire che non c'e' un respansabile attivo alla sysdate, non riuscirei a creare il libretto
							throw new ValidationManagerException(new Message(Messages.ERROR_RESPONSABILE_ASSENTE));
						} else if (!getValidationMgr().isVerificaCodiceBollValidoDataControllo(
								dettaglioAllegato.getSiglaBollino(), dettaglioAllegato.getNumeroBollinoVerde(),
								dettaglioAllegato.getDataControllo())) {
							// Ho gia' rilanciato l'eccezione (dentro il metodo di controllo)
						} else {
						*/
				//vado a recuperare dei dati che non sono contenuti nella tabella di sigit_t_allegato
				//dettaglioAllegato.setCodiceImpianto(codiceImpianto);
				dettaglioAllegato.setCodFiscaleUtenteLoggato(ReplaceSpecialCharUtils.sanitize(theModel.getAppDatautenteLoggato().getCodiceFiscale()));
				dettaglioAllegato.setArrivoDa(Constants.ARRIVO_DA_ALLEGATI);
				//setto l'allegato trovato con primary Key nell'oggetto in sessione
				theModel.setAppDataallegato(dettaglioAllegato);
				//lo spedisco a una maschera di conferma
				Message msg = new Message(Messages.C003, "REE");
				theModel.setAppDatamessaggioDinamico(ReplaceSpecialCharUtils.sanitize(msg.getText()));

				theModel.setAppDataaggiornaElencoAllegati(true);

				// impostazione del result code 
				result.setResultCode(INVIAALLEGATO_OUTCOME_CODE__OK);
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
			log.error("[BackEndFacade::inviaAllegato] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo respingiAllegato definito in un ExecCommand del
	 * ContentPanel cpRisultatoRicercaAllegati
	 */
	public ExecResults respingiAllegato(

			it.csi.sigit.sigitwebn.dto.risultato_ricerca_allegati_module.CpRisultatoRicercaAllegatiModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String RESPINGIALLEGATO_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String RESPINGIALLEGATO_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-632252234) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			//			/theModel.setAppDataisAbilitazioneDatiAllegato(false);

			Integer idAllegatoSelezionato = theModel.getAppDataidAllegatoSelezionato();
			log.debug(" BEPPE ----> RESPINGI ALLEGATO ------------> idAllegatoSelezionato: " + idAllegatoSelezionato);
			try {
				//se non lo hanno selezionato questo metodo mi blocca
				getValidationMgr().checkSelezioneElemento(ConvertUtil.convertToString(idAllegatoSelezionato));

				allegatoSelezIsREE(theModel);

				getValidationMgr()
						.validazioneFormaleRespingiAllegato(ConvertUtil.convertToString(idAllegatoSelezionato));

				// Setto la pagina da cui arrivo
				theModel.setAppDatapaginaChiamanteAllegati(Constants.PAG_RIS_RIC_AVZ_ALLEGATI);

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
				 
				
				// Ricarico gli allegati
				caricaElencoAllegati(theModel);
				//result.getGlobalMessages().add(messaggio.getText());
				gestioneMsgRicerca(theModel, result);
				 */

				// impostazione del result code 
				result.setResultCode(RESPINGIALLEGATO_OUTCOME_CODE__OK);
			} catch (ManagerException ex) {
				Validator.gestisciEccezione(result, ex);

			}
			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::respingiAllegato] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo eliminaAllegato definito in un ExecCommand del
	 * ContentPanel cpRisultatoRicercaAllegati
	 */
	public ExecResults eliminaAllegato(

			it.csi.sigit.sigitwebn.dto.risultato_ricerca_allegati_module.CpRisultatoRicercaAllegatiModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String ELIMINAALLEGATO_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String ELIMINAALLEGATO_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-857971288) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			try {

				Integer idAllegatoSelezionato = theModel.getAppDataidAllegatoSelezionato();
				log.debug(
						" BEPPE ----> ELIMINA ALLEGATO ------------> idAllegatoSelezionato: " + idAllegatoSelezionato);

				//controllo che abbiano selezionato un allegato
				getValidationMgr().checkSelezioneElemento(ConvertUtil.convertToString(idAllegatoSelezionato));

				allegatoSelezIsREE(theModel);

				getValidationMgr().validazioneFormaleEliminaAllegato(idAllegatoSelezionato,
						theModel.getAppDatautenteLoggato().getRuolo().getDescRuolo(),
						theModel.getAppDatautenteLoggato().getRuolo().getIdPersonaGiuridica());

				//theModel.setAppDataisAbilitazioneDatiAllegato(false);
				//lo spedisco a una maschera di conferma

				Message msg = new Message(Messages.C004);
				theModel.setAppDatamessaggioDinamico(ReplaceSpecialCharUtils.sanitize(msg.getText()));

				// impostazione del result code 
				result.setResultCode(ELIMINAALLEGATO_OUTCOME_CODE__OK);

			} catch (ManagerException ex) {

				Validator.gestisciEccezione(result, ex);
			}

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::eliminaAllegato] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo ricevutaAllegato definito in un ExecCommand del
	 * ContentPanel cpRisultatoRicercaAllegati
	 */
	public ExecResults ricevutaAllegato(

			it.csi.sigit.sigitwebn.dto.risultato_ricerca_allegati_module.CpRisultatoRicercaAllegatiModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String RICEVUTAALLEGATO_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String RICEVUTAALLEGATO_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-255816120) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			Integer idAllegatoSelezionato = theModel.getAppDataidAllegatoSelezionato();
			log.debug(" BEPPE ----> RICEVUTA ALLEGATO ------------> idAllegatoSelezionato: " + idAllegatoSelezionato);

			try {

				//se non lo hanno selezionato questo metodo mi blocca
				getValidationMgr().checkSelezioneElemento(ConvertUtil.convertToString(idAllegatoSelezionato));

				allegatoSelezIsREE(theModel);

				//theModel.setAppDataisAbilitazioneDatiAllegato(false);

				getValidationMgr().validazioneFormaleStampaRicevutaAllegato(idAllegatoSelezionato,
						theModel.getAppDatautenteLoggato().getRuolo().getDescRuolo(),
						theModel.getAppDatautenteLoggato().getRuolo().getIdPersonaGiuridica());

				theModel.getSession().put(Constants.SESSIONE_VAR_ID_ALLEGATO,
						ConvertUtil.convertToString(idAllegatoSelezionato));

				//				theModel.getSession().put(
				//						Constants.SESSIONE_VAR_ACTION_PAGE_BACK,
				//						Constants.RETURN_PAGE_ELENCO_ALLEGATI_DA_PDF);

				// impostazione del result code 
				result.setResultCode(RICEVUTAALLEGATO_OUTCOME_CODE__OK);
			} catch (ManagerException ex) {
				Validator.gestisciEccezione(result, ex);

			}

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::ricevutaAllegato] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo visualizzaDocumentazione definito in un ExecCommand del
	 * ContentPanel cpRisultatoRicercaAllegati
	 */
	public ExecResults visualizzaDocumentazione(

			it.csi.sigit.sigitwebn.dto.risultato_ricerca_allegati_module.CpRisultatoRicercaAllegatiModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String VISUALIZZADOCUMENTAZIONE_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String VISUALIZZADOCUMENTAZIONE_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R156159581) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			try {
				Integer idAllegatoSelezionato = theModel.getAppDataidAllegatoSelezionato();
				log.debug(" DOCUMENTAZIONE ALLEGATO ------------> idAllegatoSelezionato: " + idAllegatoSelezionato);
				Ruolo ruoloUtente = theModel.getAppDatautenteLoggato().getRuolo();

				//controllo che abbiano selezionato un allegato
				getValidationMgr().checkSelezioneElemento(ConvertUtil.convertToString(idAllegatoSelezionato));

				allegatoSelezIsREE(theModel);

				getValidationMgr().validazioneFormaleDocumentazioneAllegato(idAllegatoSelezionato, ruoloUtente);

				String codiceImpianto = getCodiceImpianto(theModel.getAppDataelencoAllegati(), idAllegatoSelezionato);

				DettaglioAllegato dettaglioAllegato = getSigitMgr().gestisciAllegatoById(idAllegatoSelezionato);

				IdentificativoImpianto identificativo = getSigitMgr().cercaIdentificativoImpianto(codiceImpianto);

				theModel.setAppDataidentificativoImpianto(identificativo);

				//				dettaglioAllegato.setCodiceBollino(MapDto.costruisciCodiceBollino(dettaglioAllegato.getSiglaBollino(),
				//						ConvertUtil.convertToBigDecimal(dettaglioAllegato.getNumeroBollinoVerde())));

				//setto il codice impianto che la 
				//dettaglioAllegato.setCodiceImpianto(codiceImpianto);

				//			// Ho centralizzato i controlli
				//			getValidationMgr().validazioneFormaleInviaAllegato(dettaglioAllegato, ruoloUtente);

				//theModel.setAppDataisAbilitazioneDatiAllegato(false);
				//setto anche parametri che non si ottengono con la primary Key
				/*dettaglioAllegato.setCodiceImpianto(theModel
					.getAppDataidImpiantoSelez());*/

				dettaglioAllegato.setArrivoDa(Constants.ARRIVO_DA_ALLEGATI);
				dettaglioAllegato.setCodFiscaleUtenteLoggato(ReplaceSpecialCharUtils.sanitize(theModel.getAppDatautenteLoggato().getCodiceFiscale()));
				//setto l'allegato trovato con primary Key nell'oggetto in sessione
				theModel.setAppDataallegato(dettaglioAllegato);

				// impostazione del result code 
				result.setResultCode(VISUALIZZADOCUMENTAZIONE_OUTCOME_CODE__OK);

			} catch (ManagerException ex) {

				Validator.gestisciEccezione(result, ex);
			}

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::visualizzaDocumentazione] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo indietroElencoAllegati definito in un ExecCommand del
	 * ContentPanel cpRisultatoRicercaAllegati
	 */
	public ExecResults indietroElencoAllegati(

			it.csi.sigit.sigitwebn.dto.risultato_ricerca_allegati_module.CpRisultatoRicercaAllegatiModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String INDIETROELENCOALLEGATI_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R1173832641) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:
			log.debug(" PASSATO DAL BOTTONE INDIETRO ELENCO ALLEGATI");
			// impostazione del result code 
			result.setResultCode(INDIETROELENCOALLEGATI_OUTCOME_CODE__OK);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::indietroElencoAllegati] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo salvaEliminaAllegato definito in un ExecCommand del
	 * ContentPanel cpRisultatoRicercaAllegati
	 */
	public ExecResults salvaEliminaAllegato(

			it.csi.sigit.sigitwebn.dto.risultato_ricerca_allegati_module.CpRisultatoRicercaAllegatiModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String SALVAELIMINAALLEGATO_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String SALVAELIMINAALLEGATO_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-498955451) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			try {
				Integer idAllegatoSelezionato = theModel.getAppDataidAllegatoSelezionato();

				getSigitMgr().eliminaAllegato(ConvertUtil.convertToString(idAllegatoSelezionato),
						theModel.getAppDatautenteLoggato().getCodiceFiscale());

				//				ArrayList<ElencoAllegati> elencoAllegati = getSigitMgr()
				//						.cercaElencoAllegati(
				//								theModel.getAppDataricercaAllegati(),
				//								theModel.getAppDatautenteLoggato().getRuolo()
				//										.getDescRuolo());
				//
				//				theModel.setAppDataelencoAllegati(elencoAllegati);

				theModel.setAppDataaggiornaElencoAllegati(true);

				theModel.getSession().put(Constants.SESSIONE_VAR_MESSAGGE,
						new Message(Messages.INFO_ELIMINAZIONE_CORRETTA, Message.INFO));

				result.getGlobalMessages().add(Messages.INFO_ELIMINAZIONE_CORRETTA);

				theModel.setAppDataidAllegatoSelezionato(null);

				result.setResultCode(SALVAELIMINAALLEGATO_OUTCOME_CODE__OK);

			} catch (ManagerException ex) {

				theModel.getSession().put(Constants.SESSIONE_VAR_MESSAGGE,
						new Message(Messages.ERROR_RECUPERO_SERVIZIO, Message.ERROR));

				Validator.gestisciEccezione(result, ex);
			}

			//theModel.getAppDataaggiornaElencoAllegati();

			//result.getGlobalMessages().add(Messages.INFO_ELIMINAZIONE_CORRETTA);

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
	 * Implementazione del metodo salvaInviaAllegato definito in un ExecCommand del
	 * ContentPanel cpRisultatoRicercaAllegati
	 */
	public ExecResults salvaInviaAllegato(

			it.csi.sigit.sigitwebn.dto.risultato_ricerca_allegati_module.CpRisultatoRicercaAllegatiModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String SALVAINVIAALLEGATO_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String SALVAINVIAALLEGATO_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R181513773) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			try {
				DettaglioAllegato dettaglio = theModel.getAppDataallegato();
				log.debug(
						"****************** DENTRO SALVA ED INVIA ALLEGATO DA RISULTATO RICERCA ALLEGATI *******************");

				if (log.isDebugEnabled())
					GenericUtil.stampa(dettaglio, true, 3);

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

					//chiamo il metodo di aggiornamento, update dell'allegato e il suo invio ad index
					ResultInvioMail resultInvioMail = getConnectorMgr().inviaAllegatoTrans(dettaglio,
							ruolo.getIdPgCat(), theModel.getAppDatautenteLoggato());

					String msg = getSigitMgr().getMsgInvioRee(dettaglio, allegatoDto, resultInvioMail);

					theModel.getSession().put(Constants.SESSIONE_VAR_MESSAGGE, new Message(msg, Message.INFO));

					theModel.setAppDataaggiornaElencoAllegati(true);

					// impostazione del result code 
					result.setResultCode(SALVAINVIAALLEGATO_OUTCOME_CODE__OK);
				}

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
			log.error("[BackEndFacade::salvaInviaAllegato] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo isRuoloAbilitato definito in un ExecCommand del
	 * ContentPanel cpRisultatoRicercaAllegati
	 */
	public ExecResults isRuoloAbilitato(

			it.csi.sigit.sigitwebn.dto.risultato_ricerca_allegati_module.CpRisultatoRicercaAllegatiModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String ISRUOLOABILITATO_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R220600478) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			UtenteLoggato utente = theModel.getAppDatautenteLoggato();

			if (GenericUtil.isRuoloAbilitatoAccessoRicercaAllegati(utente)) {
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
	 * ContentPanel cpRisultatoRicercaAllegati
	 */
	public ExecResults inizializzaElencoAllegati(

			it.csi.sigit.sigitwebn.dto.risultato_ricerca_allegati_module.CpRisultatoRicercaAllegatiModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String INIZIALIZZAELENCOALLEGATI_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String INIZIALIZZAELENCOALLEGATI_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-916686387) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			try {
				if (theModel.getAppDataaggiornaElencoAllegati()) {

					//reset elenco allegati
					theModel.setAppDataelencoAllegati(new ArrayList<ElencoAllegati>());

					//per i responsabili/terzo resp controlliamo se ha impianti in carico, se non ci sono, non carica niente
					ArrayList<String> listaCodiciImpianti = theModel.getAppDataricercaAllegati()
							.getElencoCodiciImpianto();
					String descrRuoloUtente = theModel.getAppDatautenteLoggato().getRuolo().getDescRuolo();
					if ((listaCodiciImpianti == null || listaCodiciImpianti.isEmpty())
							&& (descrRuoloUtente.equalsIgnoreCase(Constants.RUOLO_RESPONSABILE_IMPRESA)
									|| descrRuoloUtente.equalsIgnoreCase(Constants.RUOLO_PROPRIETARIO_IMPRESA)
									|| descrRuoloUtente.equalsIgnoreCase(Constants.RUOLO_RESPONSABILE)
									|| descrRuoloUtente.equalsIgnoreCase(Constants.RUOLO_PROPRIETARIO)
									|| descrRuoloUtente.equalsIgnoreCase(Constants.RUOLO_3RESPONSABILE))) {
						log.debug("Nessun impianto per il responsabile");
					} else {
						caricaElencoAllegati(theModel);
					}

					gestioneMsgRicerca(theModel, result);

					String msg = theModel.getAppDatamessaggioDinamico();

					if (GenericUtil.isNotNullOrEmpty(msg)) {
						result.getGlobalMessages().add(msg);
						theModel.setAppDatamessaggioDinamico(null);

					}

					theModel.setAppDataidAllegatoSelezionato(null);

				}

				// impostazione del result code 
				result.setResultCode(INIZIALIZZAELENCOALLEGATI_OUTCOME_CODE__OK);
			} catch (ManagerException ex) {
				Validator.gestisciEccezione(result, ex);
			}
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
	 * Implementazione del metodo gestioneVisBottoniInit definito in un ExecCommand del
	 * ContentPanel cpRisultatoRicercaAllegati
	 */
	public ExecResults gestioneVisBottoniInit(

			it.csi.sigit.sigitwebn.dto.risultato_ricerca_allegati_module.CpRisultatoRicercaAllegatiModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GESTIONEVISBOTTONIINIT_OUTCOME_CODE__VISUALIZZA = //NOSONAR  Reason:EIAS
				"VISUALIZZA"; //NOSONAR  Reason:EIAS
		final String GESTIONEVISBOTTONIINIT_OUTCOME_CODE__NASCONDI = //NOSONAR  Reason:EIAS
				"NASCONDI"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-2031838883) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			ArrayList<ElencoAllegati> listAllegati = theModel.getAppDataelencoAllegati();

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
	 * ContentPanel cpRisultatoRicercaAllegati
	 */
	public ExecResults isVisualizzaBtnModificaAllegato(

			it.csi.sigit.sigitwebn.dto.risultato_ricerca_allegati_module.CpRisultatoRicercaAllegatiModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String ISVISUALIZZABTNMODIFICAALLEGATO_OUTCOME_CODE__SI = //NOSONAR  Reason:EIAS
				"SI"; //NOSONAR  Reason:EIAS
		final String ISVISUALIZZABTNMODIFICAALLEGATO_OUTCOME_CODE__NO = //NOSONAR  Reason:EIAS
				"NO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-1289188937) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			UtenteLoggato utente = theModel.getAppDatautenteLoggato();

			log.debug(" VISUALIZZAZIONE BOTTONE MODIFICA ALLEGATO");

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
	 * ContentPanel cpRisultatoRicercaAllegati
	 */
	public ExecResults isVisualizzaBtnInviaAllegato(

			it.csi.sigit.sigitwebn.dto.risultato_ricerca_allegati_module.CpRisultatoRicercaAllegatiModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String ISVISUALIZZABTNINVIAALLEGATO_OUTCOME_CODE__SI = //NOSONAR  Reason:EIAS
				"SI"; //NOSONAR  Reason:EIAS
		final String ISVISUALIZZABTNINVIAALLEGATO_OUTCOME_CODE__NO = //NOSONAR  Reason:EIAS
				"NO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-498291906) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			UtenteLoggato utente = theModel.getAppDatautenteLoggato();

			log.debug(" VISUALIZZAZIONE BOTTONE INVIA ALLEGATO");

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
	 * ContentPanel cpRisultatoRicercaAllegati
	 */
	public ExecResults isVisualizzaBtnRespingiAllegato(

			it.csi.sigit.sigitwebn.dto.risultato_ricerca_allegati_module.CpRisultatoRicercaAllegatiModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String ISVISUALIZZABTNRESPINGIALLEGATO_OUTCOME_CODE__SI = //NOSONAR  Reason:EIAS
				"SI"; //NOSONAR  Reason:EIAS
		final String ISVISUALIZZABTNRESPINGIALLEGATO_OUTCOME_CODE__NO = //NOSONAR  Reason:EIAS
				"NO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R587121672) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			UtenteLoggato utente = theModel.getAppDatautenteLoggato();

			log.debug(" VISUALIZZAZIONE BOTTONE RESPINGI ALLEGATO");

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
	 * ContentPanel cpRisultatoRicercaAllegati
	 */
	public ExecResults isVisualizzaBtnRicevuta(

			it.csi.sigit.sigitwebn.dto.risultato_ricerca_allegati_module.CpRisultatoRicercaAllegatiModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String ISVISUALIZZABTNRICEVUTA_OUTCOME_CODE__SI = //NOSONAR  Reason:EIAS
				"SI"; //NOSONAR  Reason:EIAS
		final String ISVISUALIZZABTNRICEVUTA_OUTCOME_CODE__NO = //NOSONAR  Reason:EIAS
				"NO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R770755283) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			UtenteLoggato utente = theModel.getAppDatautenteLoggato();

			log.debug(" VISUALIZZAZIONE BOTTONE RICEVUTA ALLEGATO");

			String descrizioneRuolo = utente.getRuolo().getDescRuolo();

			log.debug(" isVisualizzaBtnRicevuta ---> descrizioneRuolo: " + descrizioneRuolo);

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
	 * ContentPanel cpRisultatoRicercaAllegati
	 */
	public ExecResults isVisualizzaBtnEliminaAllegato(

			it.csi.sigit.sigitwebn.dto.risultato_ricerca_allegati_module.CpRisultatoRicercaAllegatiModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String ISVISUALIZZABTNELIMINAALLEGATO_OUTCOME_CODE__SI = //NOSONAR  Reason:EIAS
				"SI"; //NOSONAR  Reason:EIAS
		final String ISVISUALIZZABTNELIMINAALLEGATO_OUTCOME_CODE__NO = //NOSONAR  Reason:EIAS
				"NO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-957183978) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			UtenteLoggato utente = theModel.getAppDatautenteLoggato();

			log.debug(" VISUALIZZAZIONE BOTTONE ELIMINA ALLEGATO");

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
	 * Implementazione del metodo aggiornaElencoAllegati definito in un ExecCommand del
	 * ContentPanel cpRisultatoRicercaAllegati
	 */
	public ExecResults aggiornaElencoAllegati(

			it.csi.sigit.sigitwebn.dto.risultato_ricerca_allegati_module.CpRisultatoRicercaAllegatiModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String AGGIORNAELENCOALLEGATI_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String AGGIORNAELENCOALLEGATI_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-155887879) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:
			log.debug(" PASSO DA AGGIORNA ELENCO");

			try {

				Message msg = (Message) theModel.getSession().get(Constants.SESSIONE_VAR_MESSAGGE);
				if (msg != null) {
					if (msg.getType() == Message.ERROR)
						result.getGlobalErrors().add(msg.getText());
					else
						result.getGlobalMessages().add(msg.getText());

					theModel.getSession().remove(Constants.SESSIONE_VAR_MESSAGGE);
				}

				if (theModel.getAppDataaggiornaElencoAllegati()) {

					// Ricarico gli allegati

					//per i responsabili/terzo resp controlliamo se ha impianti in carico, se non ci sono, non carica niente
					ArrayList<String> listaCodiciImpianti = theModel.getAppDataricercaAllegati()
							.getElencoCodiciImpianto();
					String descrRuoloUtente = theModel.getAppDatautenteLoggato().getRuolo().getDescRuolo();
					if ((listaCodiciImpianti == null || listaCodiciImpianti.isEmpty())
							&& (descrRuoloUtente.equalsIgnoreCase(Constants.RUOLO_RESPONSABILE_IMPRESA)
									|| descrRuoloUtente.equalsIgnoreCase(Constants.RUOLO_PROPRIETARIO_IMPRESA)
									|| descrRuoloUtente.equalsIgnoreCase(Constants.RUOLO_RESPONSABILE)
									|| descrRuoloUtente.equalsIgnoreCase(Constants.RUOLO_PROPRIETARIO)
									|| descrRuoloUtente.equalsIgnoreCase(Constants.RUOLO_3RESPONSABILE))) {
						log.debug("Nessun impianto per il responsabile");
					} else {
						caricaElencoAllegati(theModel);
					}

					gestioneMsgRicerca(theModel, result);

					// impostazione del result code 
					result.setResultCode(AGGIORNAELENCOALLEGATI_OUTCOME_CODE__OK);
				} else {
					// impostazione del result code 
					result.setResultCode(AGGIORNAELENCOALLEGATI_OUTCOME_CODE__KO);
				}
			} catch (ManagerException ex) {
				Validator.gestisciEccezione(result, ex);
			}
			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::aggiornaElencoAllegati] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo gestioneVisBottoniRef definito in un ExecCommand del
	 * ContentPanel cpRisultatoRicercaAllegati
	 */
	public ExecResults gestioneVisBottoniRef(

			it.csi.sigit.sigitwebn.dto.risultato_ricerca_allegati_module.CpRisultatoRicercaAllegatiModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GESTIONEVISBOTTONIREF_OUTCOME_CODE__VISUALIZZA = //NOSONAR  Reason:EIAS
				"VISUALIZZA"; //NOSONAR  Reason:EIAS
		final String GESTIONEVISBOTTONIREF_OUTCOME_CODE__NASCONDI = //NOSONAR  Reason:EIAS
				"NASCONDI"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R45509720) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			ArrayList<ElencoAllegati> listAllegati = theModel.getAppDataelencoAllegati();

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
	 * ContentPanel cpRisultatoRicercaAllegati
	 */
	public ExecResults isVisualizzaBtnModificaAllegatoRef(

			it.csi.sigit.sigitwebn.dto.risultato_ricerca_allegati_module.CpRisultatoRicercaAllegatiModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String ISVISUALIZZABTNMODIFICAALLEGATOREF_OUTCOME_CODE__SI = //NOSONAR  Reason:EIAS
				"SI"; //NOSONAR  Reason:EIAS
		final String ISVISUALIZZABTNMODIFICAALLEGATOREF_OUTCOME_CODE__NO = //NOSONAR  Reason:EIAS
				"NO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-298981522) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			UtenteLoggato utente = theModel.getAppDatautenteLoggato();

			log.debug(" VISUALIZZAZIONE BOTTONE MODIFICA ALLEGATO");

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
	 * ContentPanel cpRisultatoRicercaAllegati
	 */
	public ExecResults isVisualizzaBtnInviaAllegatoRef(

			it.csi.sigit.sigitwebn.dto.risultato_ricerca_allegati_module.CpRisultatoRicercaAllegatiModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String ISVISUALIZZABTNINVIAALLEGATOREF_OUTCOME_CODE__SI = //NOSONAR  Reason:EIAS
				"SI"; //NOSONAR  Reason:EIAS
		final String ISVISUALIZZABTNINVIAALLEGATOREF_OUTCOME_CODE__NO = //NOSONAR  Reason:EIAS
				"NO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-876116857) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			UtenteLoggato utente = theModel.getAppDatautenteLoggato();

			log.debug(" VISUALIZZAZIONE BOTTONE INVIA ALLEGATO");

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
	 * ContentPanel cpRisultatoRicercaAllegati
	 */
	public ExecResults isVisualizzaBtnRespingiAllegatoRef(

			it.csi.sigit.sigitwebn.dto.risultato_ricerca_allegati_module.CpRisultatoRicercaAllegatiModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String ISVISUALIZZABTNRESPINGIALLEGATOREF_OUTCOME_CODE__SI = //NOSONAR  Reason:EIAS
				"SI"; //NOSONAR  Reason:EIAS
		final String ISVISUALIZZABTNRESPINGIALLEGATOREF_OUTCOME_CODE__NO = //NOSONAR  Reason:EIAS
				"NO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-2128986243) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			UtenteLoggato utente = theModel.getAppDatautenteLoggato();

			log.debug(" VISUALIZZAZIONE BOTTONE RESPINGI ALLEGATO");

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
	 * ContentPanel cpRisultatoRicercaAllegati
	 */
	public ExecResults isVisualizzaBtnRicevutaRef(

			it.csi.sigit.sigitwebn.dto.risultato_ricerca_allegati_module.CpRisultatoRicercaAllegatiModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String ISVISUALIZZABTNRICEVUTAREF_OUTCOME_CODE__SI = //NOSONAR  Reason:EIAS
				"SI"; //NOSONAR  Reason:EIAS
		final String ISVISUALIZZABTNRICEVUTAREF_OUTCOME_CODE__NO = //NOSONAR  Reason:EIAS
				"NO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R1006551250) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			UtenteLoggato utente = theModel.getAppDatautenteLoggato();

			log.debug(" VISUALIZZAZIONE BOTTONE RICEVUTA ALLEGATO");

			String descrizioneRuolo = utente.getRuolo().getDescRuolo();

			log.debug(" isVisualizzaBtnRicevutaRef ---> descrizioneRuolo: " + descrizioneRuolo);

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
	 * ContentPanel cpRisultatoRicercaAllegati
	 */
	public ExecResults isVisualizzaBtnEliminaAllegatoRef(

			it.csi.sigit.sigitwebn.dto.risultato_ricerca_allegati_module.CpRisultatoRicercaAllegatiModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String ISVISUALIZZABTNELIMINAALLEGATOREF_OUTCOME_CODE__SI = //NOSONAR  Reason:EIAS
				"SI"; //NOSONAR  Reason:EIAS
		final String ISVISUALIZZABTNELIMINAALLEGATOREF_OUTCOME_CODE__NO = //NOSONAR  Reason:EIAS
				"NO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-848930641) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			UtenteLoggato utente = theModel.getAppDatautenteLoggato();

			log.debug(" VISUALIZZAZIONE BOTTONE ELIMINA ALLEGATO");

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
	 * permette di resettare lo stato di paginazione della tabella widg_tbRisRicercaAllegati
	 */
	public static void resetClearStatus_widg_tbRisRicercaAllegati(java.util.Map session) {
		session.put("cpRisultatoRicercaAllegati_tbRisRicercaAllegati_clearStatus", Boolean.TRUE);
	}

	//////////////////////////////////////////////////////////////////////////////
	/// Property aggiuntive del bean
	//////////////////////////////////////////////////////////////////////////////
	/*PROTECTED REGION ID(R1484243039) ENABLED START*/
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

	private String getCodiceImpianto(ArrayList<ElencoAllegati> elenco, Integer idAllegatoSelezionato) {
		String value = null;
		for (ElencoAllegati dto : elenco) {
			if (ConvertUtil.convertToString(dto.getId())
					.equalsIgnoreCase(ConvertUtil.convertToString(idAllegatoSelezionato)))
				value = dto.getCodiceImpianto();
		}
		return value;

	}

	private void caricaElencoAllegati(
			it.csi.sigit.sigitwebn.dto.risultato_ricerca_allegati_module.CpRisultatoRicercaAllegatiModel theModel)
			throws ManagerException, ServiceException {
		try {

			log.debug("MAX num righe da visualizzare = " + theModel.getAppDataricercaAllegati().getNumeroRea());
			ArrayList<ElencoAllegati> elencoAllegati = getSigitMgr().cercaElencoAllegati(
					theModel.getAppDataricercaAllegati(), theModel.getAppDatautenteLoggato().getRuolo().getDescRuolo(),
					theModel.getAppDatautenteLoggato().getRuolo().getIstatAbilitazione());
			theModel.setAppDataelencoAllegati(elencoAllegati);
			theModel.setAppDataaggiornaElencoAllegati(false);
			resetClearStatus_widg_tbRisRicercaAllegati(theModel.getSession());
		} catch (ManagerException e) {
			throw e;
		}
	}

	private void gestioneMsgRicerca(CpRisultatoRicercaAllegatiModel theModel, ExecResults result)
			throws DbManagerException {
		Integer maxNumRighe = getDbMgr().cercaConfigValueNumerico(Constants.MAX_RIGHE);
		log.debug("MAX num righe da visualizzare = " + maxNumRighe);
		ArrayList<ElencoAllegati> risRicAllegatiList = theModel.getAppDataelencoAllegati();
		if (risRicAllegatiList != null && risRicAllegatiList.size() == maxNumRighe)
			result.getGlobalMessages()
					.add(Messages.MSG_RISULTATI_RICERCA.replaceFirst("##value##", maxNumRighe.toString()));
	}

	private void allegatoSelezIsREE(CpRisultatoRicercaAllegatiModel theModel) throws ValidationManagerException {

		ArrayList<ElencoAllegati> elencoAllegati = theModel.getAppDataelencoAllegati();

		Integer idAllegatoSelezionato = theModel.getAppDataidAllegatoSelezionato();

		for (ElencoAllegati allegato : elencoAllegati) {

			if (allegato.getId().intValue() == idAllegatoSelezionato.intValue()) {

				String idTipoAllegato = ConvertUtil.convertToString(allegato.getIdTipoAllegato());
				if (idTipoAllegato.equals(Constants.ALLEGATO_TIPO_1)
						|| idTipoAllegato.equals(Constants.ALLEGATO_TIPO_1B)
						|| idTipoAllegato.equals(Constants.ALLEGATO_TIPO_2)
						|| idTipoAllegato.equals(Constants.ALLEGATO_TIPO_3)
						|| idTipoAllegato.equals(Constants.ALLEGATO_TIPO_4)) {
					// Posso procedere
				} else {
					// NON posso procedere
					throw new ValidationManagerException(new Message(Messages.ERRORE_ALLEGATO_NON_REE));
				}
			}
		}

	}

	/*PROTECTED REGION END*/
}
