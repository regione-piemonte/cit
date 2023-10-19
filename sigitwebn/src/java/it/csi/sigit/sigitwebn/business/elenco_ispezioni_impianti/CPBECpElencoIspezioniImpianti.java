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

/*PROTECTED REGION ID(R1734274649) ENABLED START*/
import it.csi.sigit.sigitwebn.business.manager.DbMgr;
import it.csi.sigit.sigitwebn.business.manager.ServiziMgr;
import it.csi.sigit.sigitwebn.business.manager.ConnectorMgr;
import it.csi.sigit.sigitwebn.business.manager.SigitMgr;
import it.csi.sigit.sigitwebn.business.manager.ValidationMgr;
import it.csi.sigit.sigitwebn.business.manager.util.ManagerException;
import it.csi.sigit.sigitwebn.business.manager.util.Message;
import it.csi.sigit.sigitwebn.business.manager.util.ValidationManagerException;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.SigitTDocAggiuntivaDto;
/*PROTECTED REGION END*/

public class CPBECpElencoIspezioniImpianti {

	/**  */
	protected static final Logger log = //NOSONAR  Reason:EIAS 
			Logger.getLogger(Constants.APPLICATION_CODE + ".business"); //NOSONAR  Reason:EIAS

	//////////////////////////////////////////////////////////////////////////////
	/// Costanti identificative degli Application Data
	//////////////////////////////////////////////////////////////////////////////

	// ApplicationData: [utenteLoggato, scope:USER_SESSION]
	public static final String APPDATA_UTENTELOGGATO_CODE = "appDatautenteLoggato";

	// ApplicationData: [idImpiantoSelez, scope:USER_SESSION]
	public static final String APPDATA_IDIMPIANTOSELEZ_CODE = "appDataidImpiantoSelez";

	// ApplicationData: [paginaChiamanteImp, scope:USER_SESSION]
	public static final String APPDATA_PAGINACHIAMANTEIMP_CODE = "appDatapaginaChiamanteImp";

	// ApplicationData: [messaggioDinamico, scope:USER_SESSION]
	public static final String APPDATA_MESSAGGIODINAMICO_CODE = "appDatamessaggioDinamico";

	// ApplicationData: [elencoIspezioniPerImpianto, scope:USER_SESSION]
	public static final String APPDATA_ELENCOISPEZIONIPERIMPIANTO_CODE = "appDataelencoIspezioniPerImpianto";

	// ApplicationData: [idIspezioneImpiantoSelezionato, scope:USER_SESSION]
	public static final String APPDATA_IDISPEZIONEIMPIANTOSELEZIONATO_CODE = "appDataidIspezioneImpiantoSelezionato";

	// ApplicationData: [allegatoIsp, scope:USER_SESSION]
	public static final String APPDATA_ALLEGATOISP_CODE = "appDataallegatoIsp";

	// ApplicationData: [ispezione, scope:USER_SESSION]
	public static final String APPDATA_ISPEZIONE_CODE = "appDataispezione";

	// ApplicationData: [gestioneIspezioniImpianto, scope:USER_SESSION]
	public static final String APPDATA_GESTIONEISPEZIONIIMPIANTO_CODE = "appDatagestioneIspezioniImpianto";

	// ApplicationData: [elencoTipiDocumentoProfilatiIsp, scope:USER_SESSION]
	public static final String APPDATA_ELENCOTIPIDOCUMENTOPROFILATIISP_CODE = "appDataelencoTipiDocumentoProfilatiIsp";

	// ApplicationData: [isAbilitazioneDatiIspezione, scope:USER_SESSION]
	public static final String APPDATA_ISABILITAZIONEDATIISPEZIONE_CODE = "appDataisAbilitazioneDatiIspezione";

	// ApplicationData: [aggiornaElencoIspezioni, scope:USER_SESSION]
	public static final String APPDATA_AGGIORNAELENCOISPEZIONI_CODE = "appDataaggiornaElencoIspezioni";

	// ApplicationData: [elencoCombustibili, scope:USER_SESSION]
	public static final String APPDATA_ELENCOCOMBUSTIBILI_CODE = "appDataelencoCombustibili";

	// ApplicationData: [elencoApparecchiatureIsp, scope:USER_SESSION]
	public static final String APPDATA_ELENCOAPPARECCHIATUREISP_CODE = "appDataelencoApparecchiatureIsp";

	// ApplicationData: [elencoTipiCombustibileIsp, scope:USER_SESSION]
	public static final String APPDATA_ELENCOTIPICOMBUSTIBILEISP_CODE = "appDataelencoTipiCombustibileIsp";

	// ApplicationData: [elencoTipiDocumentoProfilati, scope:USER_SESSION]
	public static final String APPDATA_ELENCOTIPIDOCUMENTOPROFILATI_CODE = "appDataelencoTipiDocumentoProfilati";

	// ApplicationData: [aggiornaElencoIspezioniAllegati, scope:USER_SESSION]
	public static final String APPDATA_AGGIORNAELENCOISPEZIONIALLEGATI_CODE = "appDataaggiornaElencoIspezioniAllegati";

	// ApplicationData: [paginaChiamanteDocumenti, scope:USER_SESSION]
	public static final String APPDATA_PAGINACHIAMANTEDOCUMENTI_CODE = "appDatapaginaChiamanteDocumenti";

	// ApplicationData: [identificativoImpianto, scope:USER_SESSION]
	public static final String APPDATA_IDENTIFICATIVOIMPIANTO_CODE = "appDataidentificativoImpianto";

	// ApplicationData: [identificativoIspezione, scope:USER_SESSION]
	public static final String APPDATA_IDENTIFICATIVOISPEZIONE_CODE = "appDataidentificativoIspezione";

	//////////////////////////////////////////////////////////////////////////////
	/// Metodi associati alla U.I.
	//////////////////////////////////////////////////////////////////////////////

	// nome del content panel associato al bean
	public static final String CPNAME = "cpElencoIspezioniImpianti";

	public static final String MULTIPANEL_MPDATIISPEZIONE = "mpDatiIspezione";
	public static final String MPI_MPDATIISPEZIONE_FPDATIISPEZIONEIN = CPNAME + "_" + MULTIPANEL_MPDATIISPEZIONE + "_"
			+ "fpDatiIspezioneIn";

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
	 * Implementazione del metodo inserisciIspezionePerImpianto definito in un ExecCommand del
	 * ContentPanel cpElencoIspezioniImpianti
	 */
	public ExecResults inserisciIspezionePerImpianto(

			it.csi.sigit.sigitwebn.dto.elenco_ispezioni_impianti.CpElencoIspezioniImpiantiModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String INSERISCIISPEZIONEPERIMPIANTO_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String INSERISCIISPEZIONEPERIMPIANTO_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R650372961) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			DettaglioIspezione ispezione = new DettaglioIspezione();

			UtenteLoggato utente = theModel.getAppDatautenteLoggato();

			String descrizioneRuolo = utente.getRuolo().getDescRuolo();

			log.debug(" gestisciAbilIspettore ---> descrizioneRuolo: " + descrizioneRuolo);

			ispezione.setCodiceImpianto(ReplaceSpecialCharUtils.sanitize(
					theModel.getAppDataidentificativoImpianto().getCodiceImpianto()));

			if (descrizioneRuolo.equalsIgnoreCase(Constants.RUOLO_ISPETTORE)) {

				PersonaFisica ispettore = getDbMgr().cercaPersonaFisicaByCF(utente.getCodiceFiscale());

				ispezione.setIspettoreId(ispettore.getIdPersonaFisica());
				ispezione.setIspettoreCF(ReplaceSpecialCharUtils.sanitize(ispettore.getCodiceFiscale()));
				ispezione.setIspettoreNome(ReplaceSpecialCharUtils.sanitize(ispettore.getNome()));
				ispezione.setIspettoreCognome(ReplaceSpecialCharUtils.sanitize(ispettore.getCognome()));

			}

			theModel.setAppDataispezione(ispezione);

			// impostazione del result code 
			result.setResultCode(INSERISCIISPEZIONEPERIMPIANTO_OUTCOME_CODE__OK);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::inserisciIspezionePerImpianto] Errore occorso nell'esecuzione del metodo:" + e,
					e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo gestisciAbilIspettore definito in un ExecCommand del
	 * ContentPanel cpElencoIspezioniImpianti
	 */
	public ExecResults gestisciAbilIspettore(

			it.csi.sigit.sigitwebn.dto.elenco_ispezioni_impianti.CpElencoIspezioniImpiantiModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GESTISCIABILISPETTORE_OUTCOME_CODE__ABILITA = //NOSONAR  Reason:EIAS
				"ABILITA"; //NOSONAR  Reason:EIAS
		final String GESTISCIABILISPETTORE_OUTCOME_CODE__DISABILITA = //NOSONAR  Reason:EIAS
				"DISABILITA"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R1737006758) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			UtenteLoggato utente = theModel.getAppDatautenteLoggato();

			String descrizioneRuolo = utente.getRuolo().getDescRuolo();

			log.debug(" gestisciAbilIspettore ---> descrizioneRuolo: " + descrizioneRuolo);

			if (descrizioneRuolo.equals(Constants.RUOLO_SUPER)) {
				// impostazione del result code 
				result.setResultCode(GESTISCIABILISPETTORE_OUTCOME_CODE__ABILITA);
			} else if (descrizioneRuolo.equals(Constants.RUOLO_ISPETTORE)) {
				// impostazione del result code 
				result.setResultCode(GESTISCIABILISPETTORE_OUTCOME_CODE__DISABILITA);
			}

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::gestisciAbilIspettore] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo modificaIspezionePerImpianto definito in un ExecCommand del
	 * ContentPanel cpElencoIspezioniImpianti
	 */
	public ExecResults modificaIspezionePerImpianto(

			it.csi.sigit.sigitwebn.dto.elenco_ispezioni_impianti.CpElencoIspezioniImpiantiModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String MODIFICAISPEZIONEPERIMPIANTO_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String MODIFICAISPEZIONEPERIMPIANTO_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-2124023216) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			try {
				Integer idIspezioneSelezionata = theModel.getAppDataidIspezioneImpiantoSelezionato();
				log.debug(" ISPEZIONI ----> MODIFICA ISPEZIONI ------------> idIspezioneSelezionata: "
						+ idIspezioneSelezionata);

				//se non lo hanno selezionato questo metodo mi blocca
				getValidationMgr().checkSelezioneElemento(ConvertUtil.convertToString(idIspezioneSelezionata));

				DettaglioIspezione dettaglioIspezione = getDbMgr().getDettaglioIspezioneById(idIspezioneSelezionata);

				if (dettaglioIspezione.getIdStatoIspezione().intValue() != Constants.ID_STATO_ISPEZIONE_BOZZA) {

					throw new ValidationManagerException(new Message(Messages.S114));

				} else {
					theModel.setAppDataispezione(dettaglioIspezione);

					// impostazione del result code 
					result.setResultCode(MODIFICAISPEZIONEPERIMPIANTO_OUTCOME_CODE__OK);
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
			log.error("[BackEndFacade::modificaIspezionePerImpianto] Errore occorso nell'esecuzione del metodo:" + e,
					e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo consolidaIspezionePerImpianto definito in un ExecCommand del
	 * ContentPanel cpElencoIspezioniImpianti
	 */
	public ExecResults consolidaIspezionePerImpianto(

			it.csi.sigit.sigitwebn.dto.elenco_ispezioni_impianti.CpElencoIspezioniImpiantiModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String CONSOLIDAISPEZIONEPERIMPIANTO_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String CONSOLIDAISPEZIONEPERIMPIANTO_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-303261804) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			try {
				Integer idIspezioneSelezionata = theModel.getAppDataidIspezioneImpiantoSelezionato();
				log.debug(" ISPEZIONI ----> CONSOLIDA ISPEZIONI ------------> idIspezioneSelezionata: "
						+ idIspezioneSelezionata);

				//se non lo hanno selezionato questo metodo mi blocca
				getValidationMgr().checkSelezioneElemento(ConvertUtil.convertToString(idIspezioneSelezionata));

				DettaglioIspezione dettaglioIspezione = getDbMgr().getDettaglioIspezioneById(idIspezioneSelezionata);

				getValidationMgr().validazioneFormaleConsolidaIspezione(dettaglioIspezione);

				theModel.setAppDataispezione(dettaglioIspezione);

				//lo spedisco a una maschera di conferma
				Message msg = new Message(Messages.C006);
				theModel.setAppDatamessaggioDinamico(ReplaceSpecialCharUtils.sanitize(msg.getText()));

				// impostazione del result code 
				result.setResultCode(CONSOLIDAISPEZIONEPERIMPIANTO_OUTCOME_CODE__OK);
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
			log.error("[BackEndFacade::consolidaIspezionePerImpianto] Errore occorso nell'esecuzione del metodo:" + e,
					e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo annullaIspezionePerImpianto definito in un ExecCommand del
	 * ContentPanel cpElencoIspezioniImpianti
	 */
	public ExecResults annullaIspezionePerImpianto(

			it.csi.sigit.sigitwebn.dto.elenco_ispezioni_impianti.CpElencoIspezioniImpiantiModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String ANNULLAISPEZIONEPERIMPIANTO_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String ANNULLAISPEZIONEPERIMPIANTO_OUTCOME_CODE__OK_CANC = //NOSONAR  Reason:EIAS
				"OK_CANC"; //NOSONAR  Reason:EIAS
		final String ANNULLAISPEZIONEPERIMPIANTO_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-1582475489) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			try {
				Integer idIspezioneSelezionata = theModel.getAppDataidIspezioneImpiantoSelezionato();
				log.debug(" ISPEZIONI ----> ANNULLA ISPEZIONI ------------> idIspezioneSelezionata: "
						+ idIspezioneSelezionata);

				//se non lo hanno selezionato questo metodo mi blocca
				getValidationMgr().checkSelezioneElemento(ConvertUtil.convertToString(idIspezioneSelezionata));

				DettaglioIspezione dettaglioIspezione = getDbMgr().getDettaglioIspezioneById(idIspezioneSelezionata);

				if (dettaglioIspezione.getIdStatoIspezione() == Constants.ID_STATO_ISPEZIONE_ANNULLATO) {

					throw new ValidationManagerException(new Message(Messages.S120));

				} else if (dettaglioIspezione.getIdStatoIspezione() == Constants.ID_STATO_ISPEZIONE_BOZZA) {
					theModel.setAppDataispezione(dettaglioIspezione);

					String msg = Messages.C007;

					/*
					List<SigitTDocAggiuntivaDto> dtoListDoc = getDbMgr().findDocIspezioneById(idIspezioneSelezionata);
					
					if (dtoListDoc != null && dtoListDoc.size() > 0) {
						// Vuol dire che ci sobo dei documenti collegati all'ispezione che si vuole cancellare
						msg += Constants.VALUE_ENTER_HTML + Messages.C007_1;
					}
					*/

					//lo spedisco a una maschera di conferma
					theModel.setAppDatamessaggioDinamico(ReplaceSpecialCharUtils.sanitize(msg));

					// impostazione del result code 
					result.setResultCode(ANNULLAISPEZIONEPERIMPIANTO_OUTCOME_CODE__OK_CANC);
				} else {
					theModel.setAppDataispezione(dettaglioIspezione);

					//lo spedisco a una maschera di conferma
					Message msg = new Message(Messages.C005, ConvertUtil.convertToString(idIspezioneSelezionata));
					theModel.setAppDatamessaggioDinamico(ReplaceSpecialCharUtils.sanitize(msg.getText()));

					// impostazione del result code 
					result.setResultCode(ANNULLAISPEZIONEPERIMPIANTO_OUTCOME_CODE__OK);
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
			log.error("[BackEndFacade::annullaIspezionePerImpianto] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo dettaglioIspezionePerImpianto definito in un ExecCommand del
	 * ContentPanel cpElencoIspezioniImpianti
	 */
	public ExecResults dettaglioIspezionePerImpianto(

			it.csi.sigit.sigitwebn.dto.elenco_ispezioni_impianti.CpElencoIspezioniImpiantiModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String DETTAGLIOISPEZIONEPERIMPIANTO_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String DETTAGLIOISPEZIONEPERIMPIANTO_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-1181522047) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			try {

				Integer idIspezioneSelezionata = theModel.getAppDataidIspezioneImpiantoSelezionato();
				log.debug(" ISPEZIONI ----> DETTAGLIO ISPEZIONI ------------> idIspezioneSelezionata: "
						+ idIspezioneSelezionata);

				//se non lo hanno selezionato questo metodo mi blocca
				getValidationMgr().checkSelezioneElemento(ConvertUtil.convertToString(idIspezioneSelezionata));

				result.setResultCode(DETTAGLIOISPEZIONEPERIMPIANTO_OUTCOME_CODE__OK);

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
			log.error("[BackEndFacade::dettaglioIspezionePerImpianto] Errore occorso nell'esecuzione del metodo:" + e,
					e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo inserisciAllegatoIspePerImpianto definito in un ExecCommand del
	 * ContentPanel cpElencoIspezioniImpianti
	 */
	public ExecResults inserisciAllegatoIspePerImpianto(

			it.csi.sigit.sigitwebn.dto.elenco_ispezioni_impianti.CpElencoIspezioniImpiantiModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String INSERISCIALLEGATOISPEPERIMPIANTO_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String INSERISCIALLEGATOISPEPERIMPIANTO_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-1508442205) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			try {

				Integer idIspezioneSelezionata = theModel.getAppDataidIspezioneImpiantoSelezionato();
				log.debug(" ISPEZIONI ----> ANNULLA ISPEZIONI ------------> idIspezioneSelezionata: "
						+ idIspezioneSelezionata);

				//se non lo hanno selezionato questo metodo mi blocca
				getValidationMgr().checkSelezioneElemento(ConvertUtil.convertToString(idIspezioneSelezionata));

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

					// vado a caricare la combo dei tipi docuimenti
					precaricaCombo(theModel);

					result.setResultCode(INSERISCIALLEGATOISPEPERIMPIANTO_OUTCOME_CODE__OK);
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
			log.error(
					"[BackEndFacade::inserisciAllegatoIspePerImpianto] Errore occorso nell'esecuzione del metodo:" + e,
					e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo modificaAllegatoIspePerImpianto definito in un ExecCommand del
	 * ContentPanel cpElencoIspezioniImpianti
	 */
	public ExecResults modificaAllegatoIspePerImpianto(

			it.csi.sigit.sigitwebn.dto.elenco_ispezioni_impianti.CpElencoIspezioniImpiantiModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String MODIFICAALLEGATOISPEPERIMPIANTO_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String MODIFICAALLEGATOISPEPERIMPIANTO_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-1194306988) ENABLED START*/
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

				result.setResultCode(MODIFICAALLEGATOISPEPERIMPIANTO_OUTCOME_CODE__OK);
			} catch (ManagerException ex) {

				Validator.gestisciEccezione(result, ex);
			}

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::modificaAllegatoIspePerImpianto] Errore occorso nell'esecuzione del metodo:" + e,
					e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo visualizzaDettaglioAllegatoIspPerImpianto definito in un ExecCommand del
	 * ContentPanel cpElencoIspezioniImpianti
	 */
	public ExecResults visualizzaDettaglioAllegatoIspPerImpianto(

			it.csi.sigit.sigitwebn.dto.elenco_ispezioni_impianti.CpElencoIspezioniImpiantiModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String VISUALIZZADETTAGLIOALLEGATOISPPERIMPIANTO_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String VISUALIZZADETTAGLIOALLEGATOISPPERIMPIANTO_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R2105883950) ENABLED START*/
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

					theModel.getSession().put(Constants.SESSIONE_VAR_ID_IMPIANTO, theModel.getAppDataidImpiantoSelez());

					DettaglioAllegato allegato = getDbMgr()
							.getDettaglioAllegatoById(dettaglioIspezione.getIdAllegato());

					theModel.setAppDataallegatoIsp(allegato);
				}

				result.setResultCode(VISUALIZZADETTAGLIOALLEGATOISPPERIMPIANTO_OUTCOME_CODE__OK);
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
					"[BackEndFacade::visualizzaDettaglioAllegatoIspPerImpianto] Errore occorso nell'esecuzione del metodo:"
							+ e,
					e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo annullaAllegatoIspePerImpianto definito in un ExecCommand del
	 * ContentPanel cpElencoIspezioniImpianti
	 */
	public ExecResults annullaAllegatoIspePerImpianto(

			it.csi.sigit.sigitwebn.dto.elenco_ispezioni_impianti.CpElencoIspezioniImpiantiModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String ANNULLAALLEGATOISPEPERIMPIANTO_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String ANNULLAALLEGATOISPEPERIMPIANTO_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R156864293) ENABLED START*/
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

					allegato.setCodiceImpianto(ReplaceSpecialCharUtils.sanitize(
							dettaglioIspezione.getCodiceImpianto()));

					theModel.setAppDataallegatoIsp(allegato);

					//lo spedisco a una maschera di conferma
					Message msg = new Message(Messages.C004);
					theModel.setAppDatamessaggioDinamico(msg.getText());

				}

				result.setResultCode(ANNULLAALLEGATOISPEPERIMPIANTO_OUTCOME_CODE__OK);
			} catch (ManagerException ex) {

				Validator.gestisciEccezione(result, ex);
			}

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::annullaAllegatoIspePerImpianto] Errore occorso nell'esecuzione del metodo:" + e,
					e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo visualizzaRicevutaAllegatoIspPerImpianto definito in un ExecCommand del
	 * ContentPanel cpElencoIspezioniImpianti
	 */
	public ExecResults visualizzaRicevutaAllegatoIspPerImpianto(

			it.csi.sigit.sigitwebn.dto.elenco_ispezioni_impianti.CpElencoIspezioniImpiantiModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String VISUALIZZARICEVUTAALLEGATOISPPERIMPIANTO_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String VISUALIZZARICEVUTAALLEGATOISPPERIMPIANTO_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R1855480304) ENABLED START*/
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
					result.setResultCode(VISUALIZZARICEVUTAALLEGATOISPPERIMPIANTO_OUTCOME_CODE__OK);
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
			log.error(
					"[BackEndFacade::visualizzaRicevutaAllegatoIspPerImpianto] Errore occorso nell'esecuzione del metodo:"
							+ e,
					e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo documentazioneAllegatoIspPerImpianto definito in un ExecCommand del
	 * ContentPanel cpElencoIspezioniImpianti
	 */
	public ExecResults documentazioneAllegatoIspPerImpianto(

			it.csi.sigit.sigitwebn.dto.elenco_ispezioni_impianti.CpElencoIspezioniImpiantiModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String DOCUMENTAZIONEALLEGATOISPPERIMPIANTO_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String DOCUMENTAZIONEALLEGATOISPPERIMPIANTO_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R91258812) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			Integer idIspezioneSelezionata = theModel.getAppDataidIspezioneImpiantoSelezionato();

			try {
				getValidationMgr().checkSelezioneElemento(idIspezioneSelezionata);

				log.debug("idIspezioneSelezionata: " + idIspezioneSelezionata);

				//theModel.setAppDataidentificativoImpianto(getIdentificativoImpianto(theModel));

				theModel.setAppDatapaginaChiamanteDocumenti(Constants.PAG_GEST_ISPEZIONI);

				ArrayList<DettaglioIspezione> elencoIsp = theModel.getAppDataelencoIspezioniPerImpianto();

				for (DettaglioIspezione dettaglioIspezione : elencoIsp) {

					if (dettaglioIspezione.getIdIspezione().intValue() == idIspezioneSelezionata.intValue()) {

						log.debug("TROVATA ISPEZIONE: " + dettaglioIspezione);

						theModel.setAppDataidentificativoIspezione(dettaglioIspezione);
						break;
					}
				}

				// impostazione del result code 
				result.setResultCode(DOCUMENTAZIONEALLEGATOISPPERIMPIANTO_OUTCOME_CODE__OK);
			} catch (ManagerException ex) {

				Validator.gestisciEccezione(result, ex);
			}

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
	 * ContentPanel cpElencoIspezioniImpianti
	 */
	public ExecResults tornaPaginaChiamante(

			it.csi.sigit.sigitwebn.dto.elenco_ispezioni_impianti.CpElencoIspezioniImpiantiModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String TORNAPAGINACHIAMANTE_OUTCOME_CODE__RIS_RIC_IMPIANTO = //NOSONAR  Reason:EIAS
				"RIS_RIC_IMPIANTO"; //NOSONAR  Reason:EIAS
		final String TORNAPAGINACHIAMANTE_OUTCOME_CODE__RIS_RIC_AVZ_IMPIANTI = //NOSONAR  Reason:EIAS
				"RIS_RIC_AVZ_IMPIANTI"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-1442954396) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			log.debug(" INDIETRO DALLA FORM DELL'ELENCO ALLEGATI DELL'IMPIANTO");
			String paginaChiamante = theModel.getAppDatapaginaChiamanteImp();
			log.debug(" tornaPaginaChiamante ---> " + paginaChiamante);

			if (Constants.PAG_RIS_RIC_AVZ_IMPIANTI.equals(paginaChiamante))
				result.setResultCode(TORNAPAGINACHIAMANTE_OUTCOME_CODE__RIS_RIC_AVZ_IMPIANTI);
			else if (Constants.PAG_RIS_RIC_IMPIANTI.equals(paginaChiamante))
				result.setResultCode(TORNAPAGINACHIAMANTE_OUTCOME_CODE__RIS_RIC_IMPIANTO);

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
	 * Implementazione del metodo cercaIspettore definito in un ExecCommand del
	 * ContentPanel cpElencoIspezioniImpianti
	 */
	public ExecResults cercaIspettore(

			it.csi.sigit.sigitwebn.dto.elenco_ispezioni_impianti.CpElencoIspezioniImpiantiModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String CERCAISPETTORE_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String CERCAISPETTORE_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-1395299379) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			try {
				DettaglioIspezione ispezione = theModel.getAppDataispezione();

				if (log.isDebugEnabled())
					GenericUtil.stampa(ispezione, true, 3);

				getValidationMgr().verificaIspettore(ispezione.getIspettoreCF());

				PersonaFisica ispettore = getDbMgr().cercaPersonaFisicaByCF(ispezione.getIspettoreCF());

				if (ispettore != null) {
					ispezione.setIspettoreId(ispettore.getIdPersonaFisica());
					ispezione.setIspettoreNome(ReplaceSpecialCharUtils.sanitize(ispettore.getNome()));
					ispezione.setIspettoreCognome(ReplaceSpecialCharUtils.sanitize(ispettore.getCognome()));
				} else {
					throw new ValidationManagerException(new Message(Messages.S125));
				}

				// impostazione del result code 
				result.setResultCode(CERCAISPETTORE_OUTCOME_CODE__OK);

			} catch (ManagerException ex) {
				log.error("Errore: ", ex);
				Validator.gestisciEccezione(result, ex);
			}

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::cercaIspettore] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo nuovaRicercaIspettore definito in un ExecCommand del
	 * ContentPanel cpElencoIspezioniImpianti
	 */
	public ExecResults nuovaRicercaIspettore(

			it.csi.sigit.sigitwebn.dto.elenco_ispezioni_impianti.CpElencoIspezioniImpiantiModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String NUOVARICERCAISPETTORE_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String NUOVARICERCAISPETTORE_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-1391733481) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			DettaglioIspezione ispezione = theModel.getAppDataispezione();

			ispezione.setIspettoreId(null);
			ispezione.setIspettoreNome(null);
			ispezione.setIspettoreCognome(null);

			// impostazione del result code 
			result.setResultCode(NUOVARICERCAISPETTORE_OUTCOME_CODE__OK);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::nuovaRicercaIspettore] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo ripulisciDatiIspezione definito in un ExecCommand del
	 * ContentPanel cpElencoIspezioniImpianti
	 */
	public ExecResults ripulisciDatiIspezione(

			it.csi.sigit.sigitwebn.dto.elenco_ispezioni_impianti.CpElencoIspezioniImpiantiModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String RIPULISCIDATIISPEZIONE_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-1826329828) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			DettaglioIspezione ispezione = theModel.getAppDataispezione();

			// Se sono in inserimento ripulisco il campo, in caso di modifica il campo non e' modificabile 
			if (GenericUtil.isNotNullOrEmpty(ispezione.getIdIspezione())) {
				ispezione.setDataIspezione(null);
			}

			ispezione.setEnteCompetente(null);
			ispezione.setEsitoIspezione(null);
			ispezione.setNote(null);

			// impostazione del result code 
			result.setResultCode(RIPULISCIDATIISPEZIONE_OUTCOME_CODE__OK);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::ripulisciDatiIspezione] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo chiudiDatiIspezione definito in un ExecCommand del
	 * ContentPanel cpElencoIspezioniImpianti
	 */
	public ExecResults chiudiDatiIspezione(

			it.csi.sigit.sigitwebn.dto.elenco_ispezioni_impianti.CpElencoIspezioniImpiantiModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String CHIUDIDATIISPEZIONE_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R268845446) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			// impostazione del result code 
			result.setResultCode(CHIUDIDATIISPEZIONE_OUTCOME_CODE__OK);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::chiudiDatiIspezione] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo generazioneIspezione definito in un ExecCommand del
	 * ContentPanel cpElencoIspezioniImpianti
	 */
	public ExecResults generazioneIspezione(

			it.csi.sigit.sigitwebn.dto.elenco_ispezioni_impianti.CpElencoIspezioniImpiantiModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GENERAZIONEISPEZIONE_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String GENERAZIONEISPEZIONE_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-1565206051) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			log.debug("########### generazioneIspezione ###########");

			try {
				DettaglioIspezione ispezione = theModel.getAppDataispezione();

				//controllo se i campi obbligatori sono stati valorizzati
				getValidationMgr().validazioneFormaleDatiIspezione(ispezione);

				if (GenericUtil.isNullOrEmpty(ispezione.getIdIspezione())) {
					// Sono in inseriemnto
					//					getDbMgr().inserisciIspezione(ispezione, theModel.getAppDatautenteLoggato().getCodiceFiscale());

					result.getGlobalMessages().add(Messages.INFO_INSERIMENTO_CORRETTO);
				} else {
					// Sono in modifcia
					// Sono in inseriemnto
					//					getDbMgr().modificaIspezione(ispezione, theModel.getAppDatautenteLoggato().getCodiceFiscale());

					result.getGlobalMessages().add(Messages.INFO_MODIFICA_CORRETTA);
				}

				theModel.setAppDataaggiornaElencoIspezioni(true);

				// Ricarico l'elenco
				//caricaElencoIspezioni(theModel);
				//theModel.setAppDataaggiornaElencoIspezioni(true);

				// impostazione del result code 
				result.setResultCode(GENERAZIONEISPEZIONE_OUTCOME_CODE__OK);

			} catch (ManagerException ex) {
				log.error("Errore: ", ex);
				Validator.gestisciEccezione(result, ex);
			}

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::generazioneIspezione] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo cercaComboPerAllegato definito in un ExecCommand del
	 * ContentPanel cpElencoIspezioniImpianti
	 */
	public ExecResults cercaComboPerAllegato(

			it.csi.sigit.sigitwebn.dto.elenco_ispezioni_impianti.CpElencoIspezioniImpiantiModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String CERCACOMBOPERALLEGATO_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String CERCACOMBOPERALLEGATO_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R1788325248) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			try {
				DettaglioAllegato allegato = theModel.getAppDataallegatoIsp();
				getValidationMgr().validazioneFormaleDatiAllegatoIspCercaOLD(allegato);

				caricaCombo(theModel);

				// impostazione del result code 
				result.setResultCode(CERCACOMBOPERALLEGATO_OUTCOME_CODE__OK);

				// modifica degli attributi del model (che verranno propagati allo strato
				// di presentation). si puo' agire anche direttamente sull'attributo "session".
			} catch (ManagerException ex) {
				log.error("Errore: ", ex);
				Validator.gestisciEccezione(result, ex);
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
	 * Implementazione del metodo caricaElencoApparecchiatureByComb definito in un ExecCommand del
	 * ContentPanel cpElencoIspezioniImpianti
	 */
	public ExecResults caricaElencoApparecchiatureByComb(

			it.csi.sigit.sigitwebn.dto.elenco_ispezioni_impianti.CpElencoIspezioniImpiantiModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String CARICAELENCOAPPARECCHIATUREBYCOMB_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String CARICAELENCOAPPARECCHIATUREBYCOMB_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R1164526700) ENABLED START*/
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
	 * ContentPanel cpElencoIspezioniImpianti
	 */
	public ExecResults ripulisciDatiAllegato(

			it.csi.sigit.sigitwebn.dto.elenco_ispezioni_impianti.CpElencoIspezioniImpiantiModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String RIPULISCIDATIALLEGATO_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R873802443) ENABLED START*/
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
	 * ContentPanel cpElencoIspezioniImpianti
	 */
	public ExecResults chiudiDatiAllegato(

			it.csi.sigit.sigitwebn.dto.elenco_ispezioni_impianti.CpElencoIspezioniImpiantiModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String CHIUDIDATIALLEGATO_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-305537247) ENABLED START*/
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
	 * Implementazione del metodo generazioneAllegati definito in un ExecCommand del
	 * ContentPanel cpElencoIspezioniImpianti
	 */
	public ExecResults generazioneAllegati(

			it.csi.sigit.sigitwebn.dto.elenco_ispezioni_impianti.CpElencoIspezioniImpiantiModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GENERAZIONEALLEGATI_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String GENERAZIONEALLEGATI_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R17714224) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			DettaglioAllegato dettaglioAllegato = theModel.getAppDataallegatoIsp();

			Ruolo profiloUtente = theModel.getAppDatautenteLoggato().getRuolo();

			try {

				log.debug("FRAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA CODICE IMPIANTO : "
						+ dettaglioAllegato.getCodiceImpianto());
				log.debug("FRAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA RUOLO UTENTE : " + profiloUtente.getDescRuolo());

				if (GenericUtil.isNullOrEmpty(dettaglioAllegato.getIdAllegato())) {
					// Sono in inserimento, devo verificare i dati
					// Serve questo controllo????
					/*
					PersonaGiuridica personaGiuridica = getSigitMgr()
							.verificaTipoDocumentoAssociatoManutentore(
									dettaglioAllegato.getCodiceImpianto(),
									dettaglioAllegato.getIdTipoAllegato());
					 */
					//controllo se i campi obbligatori sono stati valorizzati
					getValidationMgr().validazioneFormaleDatiAllegatoIsp(dettaglioAllegato);
				}

				log.debug("fraaaaaaaaaaaaaaaa numero bollino verde : " + dettaglioAllegato.getNumeroBollinoVerde());
				//controllo se hanno inserito il numero bollino

				//vado a settare l'idImpiantoRuoloPfPg
				//				String idImpiantoRuolo = getDbMgr().getIdImpiantoRuoloPfPg(
				//						dettaglioAllegato.getCodiceImpianto(),
				//						personaGiuridica.getIdPersonaGiuridica(),
				//						ConvertUtil.convertToInteger(dettaglioAllegato
				//								.getIdTipoAllegato()));

				dettaglioAllegato.setIdIspezione2018(theModel.getAppDataidIspezioneImpiantoSelezionato());

				// Devo ripulire l'id della combo apparecchiature (e' comp4mnaut#fKManut#progressivo), devo recupero il progressivo
				dettaglioAllegato.setIdApparecchiature(
						GenericUtil.recuperaProgressivo(dettaglioAllegato.getIdApparecchiature()));

				dettaglioAllegato.setIdIspezione(theModel.getAppDataidIspezioneImpiantoSelezionato());

				//setto a BOZZA l'allegato che si sta per aprire (se ha passato tutti i controlli precedenti)
				dettaglioAllegato.setIdStatoRapporto(Constants.ID_STATO_RAPPORTO_BOZZA);
				//setto il codice fiscale dell'utente loggato
				dettaglioAllegato.setCodFiscaleUtenteLoggato(ReplaceSpecialCharUtils.sanitize(
						theModel.getAppDatautenteLoggato().getCodiceFiscale()));
				//setto il flagControlloBozza a false(0) perche' se e' null va in eccezione quando cerco di inviarlo
				dettaglioAllegato.setFlagControlloBozza(Constants.FLAG_CONTROLLO_BOZZA_ALLEGATO_FALSE);
				//setto da dove sto arrivando
				dettaglioAllegato.setArrivoDa(Constants.ARRIVO_DA_IMPIANTO_ISP);

				theModel.setAppDataallegatoIsp(dettaglioAllegato);

				//rimuovo dalla sessione eventuale dettaglio allegato presente 
				theModel.getSession().remove(Constants.SESSIONE_VAR_DETT_ALLEGATO);

				//metto in sessione l'oggetto dettaglio allegato per la action showAllegato che chiama Modol
				theModel.getSession().put(Constants.SESSIONE_VAR_DETT_ALLEGATO, dettaglioAllegato);

				theModel.getSession().put(Constants.SESSIONE_VAR_UTENTE_LOGGATO, theModel.getAppDatautenteLoggato());

				theModel.setAppDataaggiornaElencoIspezioniAllegati(true);

				// impostazione del result code 
				result.setResultCode(GENERAZIONEALLEGATI_OUTCOME_CODE__OK);

			} catch (ManagerException ex) {
				log.debug("Errore: ", ex);
				Validator.gestisciEccezione(result, ex);
			}

			result.setModel(theModel);
			return result;

			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::generazioneAllegati] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo salvaConsolidaIspezione definito in un ExecCommand del
	 * ContentPanel cpElencoIspezioniImpianti
	 */
	public ExecResults salvaConsolidaIspezione(

			it.csi.sigit.sigitwebn.dto.elenco_ispezioni_impianti.CpElencoIspezioniImpiantiModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String SALVACONSOLIDAISPEZIONE_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String SALVACONSOLIDAISPEZIONE_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-1922049811) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			//			try {
			DettaglioIspezione dettaglio = theModel.getAppDataispezione();

			log.debug("****************** DENTRO CONSOLIDA ISPEZIONE *******************");

			if (log.isDebugEnabled())
				GenericUtil.stampa(dettaglio, true, 3);

			//chiamo il metodo di aggiornamento, update dell'allegato e il suo invio ad index
			//				getConnectorMgr().consolidaIspezione(dettaglio, theModel.getAppDatautenteLoggato().getCodiceFiscale());

			//				theModel.getSession().put(
			//						Constants.SESSIONE_VAR_MESSAGGE,
			//						new Message(Messages.INFO_SALVATAGGIO_CORRETTO,
			//								Message.INFO));

			result.getGlobalMessages().add(Messages.INFO_SALVATAGGIO_CORRETTO);

			theModel.setAppDataaggiornaElencoIspezioni(true);

			// impostazione del result code 
			result.setResultCode(SALVACONSOLIDAISPEZIONE_OUTCOME_CODE__OK);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".
			//			} catch (ManagerException ex) {
			//
			//				//result.getGlobalErrors().add(Messages.ERROR_RECUPERO_SERVIZIO);
			//
			//				//				theModel.getSession().put(
			//				//						Constants.SESSIONE_VAR_MESSAGGE,
			//				//						new Message(Messages.ERROR_RECUPERO_SERVIZIO,
			//				//								Message.ERROR));
			//
			//				Validator.gestisciEccezione(result, ex);
			//			}

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::salvaConsolidaIspezione] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo salvaAnnullaIspezione definito in un ExecCommand del
	 * ContentPanel cpElencoIspezioniImpianti
	 */
	public ExecResults salvaAnnullaIspezione(

			it.csi.sigit.sigitwebn.dto.elenco_ispezioni_impianti.CpElencoIspezioniImpiantiModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String SALVAANNULLAISPEZIONE_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String SALVAANNULLAISPEZIONE_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-817526526) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			//			try {
			DettaglioIspezione dettaglio = theModel.getAppDataispezione();

			log.debug("****************** DENTRO ANNULLA ISPEZIONE *******************");

			if (log.isDebugEnabled())
				GenericUtil.stampa(dettaglio, true, 3);

			// se lo stato ispezione e' CONSOLIDATO, devo impostare lo stato ispezione a ANNULLATO e il relativo (eventuale) rapporto in RESPINTO 
			// chiamo il metodo di aggiornamento, update dell'allegato e il suo invio ad index
			//				getConnectorMgr().annullaIspezione(dettaglio, theModel.getAppDatautenteLoggato().getCodiceFiscale());

			// se lo stato ispezione e' BOZZA, devo cancellare fisicamente l'ispezione e il relativo (eventuale) rapporto  

			//				theModel.getSession().put(
			//						Constants.SESSIONE_VAR_MESSAGGE,
			//						new Message(Messages.INFO_ANNULLAMENTO_CORRETTO,
			//								Message.INFO));

			result.getGlobalMessages().add(Messages.INFO_ANNULLAMENTO_CORRETTO);

			log.debug("@@@@ setto il messaggio!!!! ");

			theModel.setAppDataaggiornaElencoIspezioni(true);
			theModel.setAppDataidIspezioneImpiantoSelezionato(null);

			// impostazione del result code 
			result.setResultCode(SALVAANNULLAISPEZIONE_OUTCOME_CODE__OK);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".
			//			} catch (ManagerException ex) {
			//
			//				//result.getGlobalErrors().add(Messages.ERROR_RECUPERO_SERVIZIO);
			//
			//				Validator.gestisciEccezione(result, ex);
			//			}

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::salvaAnnullaIspezione] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo salvaAnnullaAllegato definito in un ExecCommand del
	 * ContentPanel cpElencoIspezioniImpianti
	 */
	public ExecResults salvaAnnullaAllegato(

			it.csi.sigit.sigitwebn.dto.elenco_ispezioni_impianti.CpElencoIspezioniImpiantiModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String SALVAANNULLAALLEGATO_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String SALVAANNULLAALLEGATO_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R906344485) ENABLED START*/
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

				theModel.setAppDataaggiornaElencoIspezioni(true);
				theModel.setAppDataidIspezioneImpiantoSelezionato(null);

				result.setResultCode(SALVAANNULLAALLEGATO_OUTCOME_CODE__OK);

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
			log.error("[BackEndFacade::salvaAnnullaAllegato] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo salvaCancellaIspezione definito in un ExecCommand del
	 * ContentPanel cpElencoIspezioniImpianti
	 */
	public ExecResults salvaCancellaIspezione(

			it.csi.sigit.sigitwebn.dto.elenco_ispezioni_impianti.CpElencoIspezioniImpiantiModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String SALVACANCELLAISPEZIONE_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String SALVACANCELLAISPEZIONE_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-1294660638) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			//			try {
			DettaglioIspezione dettaglio = theModel.getAppDataispezione();

			log.debug("****************** DENTRO CANCELLA ISPEZIONE *******************");

			if (log.isDebugEnabled())
				GenericUtil.stampa(dettaglio, true, 3);

			// siccome lo stato dell'ispezione e' BOZZA, devo cancellare fisicamente l'ispezione e i relativi (eventuali) rapporto e documenti 
			//				getSigitMgr().cancellaIspezione(dettaglio, theModel.getAppDatautenteLoggato().getCodiceFiscale());

			result.getGlobalMessages().add(Messages.INFO_ELIMINAZIONE_CORRETTA);

			log.debug("@@@@ setto il messaggio!!!! ");

			theModel.setAppDataaggiornaElencoIspezioni(true);
			theModel.setAppDataidIspezioneImpiantoSelezionato(null);

			// impostazione del result code 
			result.setResultCode(SALVACANCELLAISPEZIONE_OUTCOME_CODE__OK);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".
			//			} catch (ManagerException ex) {
			//
			//				//result.getGlobalErrors().add(Messages.ERROR_RECUPERO_SERVIZIO);
			//
			//				Validator.gestisciEccezione(result, ex);
			//			}

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::salvaCancellaIspezione] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo inizializzaElencoIspezioni definito in un ExecCommand del
	 * ContentPanel cpElencoIspezioniImpianti
	 */
	public ExecResults inizializzaElencoIspezioni(

			it.csi.sigit.sigitwebn.dto.elenco_ispezioni_impianti.CpElencoIspezioniImpiantiModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String INIZIALIZZAELENCOISPEZIONI_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String INIZIALIZZAELENCOISPEZIONI_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R1127653496) ENABLED START*/
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

			IspezioniPerImpianto impianto;

			try {

				DettaglioIspezione dettaglioIspezione = theModel.getAppDataispezione();
				if (dettaglioIspezione == null) {
					dettaglioIspezione = new DettaglioIspezione();
				}

				//				//setto la sigla bollino di default e' RP
				//				datiAllegato.setSiglaBollino(Constants.SIGLA_BOLLINO_RP);
				//				//setto il codice impianto selezionato dall'elenco degli impianti
				//				datiAllegato.setCodiceImpianto(codiceImpianto);
				//				theModel.setAppDataispezione(datiAllegato);

				//carico le combo presenti
				//this.precaricaCombo(theModel, utenteLoggato);

				impianto = this.getSigitMgr().cercaIspezioniPerCodiceImpianto(codiceImpianto);

				log.debug("STAMPO L'IMPIANTO: " + impianto);

				if (impianto != null) {
					theModel.setAppDataidentificativoImpianto(impianto.getIdentificativoImpianto());

					theModel.setAppDataelencoIspezioniPerImpianto(impianto.getListaIspezioni());

				} else {
					theModel.setAppDataidentificativoImpianto(new IdentificativoImpianto());
					theModel.setAppDataelencoIspezioniPerImpianto(new ArrayList<DettaglioIspezione>());
				}

				theModel.setAppDataaggiornaElencoIspezioni(false);

				// impostazione del result code 
				result.setResultCode(INIZIALIZZAELENCOISPEZIONI_OUTCOME_CODE__OK);
			} catch (ManagerException ex) {

				Validator.gestisciEccezione(result, ex);

			}

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::inizializzaElencoIspezioni] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo isVisualizzaBtnInserisciIspezione definito in un ExecCommand del
	 * ContentPanel cpElencoIspezioniImpianti
	 */
	public ExecResults isVisualizzaBtnInserisciIspezione(

			it.csi.sigit.sigitwebn.dto.elenco_ispezioni_impianti.CpElencoIspezioniImpiantiModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String ISVISUALIZZABTNINSERISCIISPEZIONE_OUTCOME_CODE__SI = //NOSONAR  Reason:EIAS
				"SI"; //NOSONAR  Reason:EIAS
		final String ISVISUALIZZABTNINSERISCIISPEZIONE_OUTCOME_CODE__NO = //NOSONAR  Reason:EIAS
				"NO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-1639514161) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			UtenteLoggato utente = theModel.getAppDatautenteLoggato();

			log.debug(" VISUALIZZAZIONE BOTTONE INSERISCI ISPEZIONE ---> PER IMPIANTO");

			String descrizioneRuolo = utente.getRuolo().getDescRuolo();

			log.debug(" isVisualizzaBtnInserisciIspezione ---> descrizioneRuolo: " + descrizioneRuolo);

			if (descrizioneRuolo.equals(Constants.RUOLO_SUPER) || descrizioneRuolo.equals(Constants.RUOLO_ISPETTORE)) {
				// impostazione del result code 
				result.setResultCode(ISVISUALIZZABTNINSERISCIISPEZIONE_OUTCOME_CODE__SI);
			} else {
				// impostazione del result code 
				result.setResultCode(ISVISUALIZZABTNINSERISCIISPEZIONE_OUTCOME_CODE__NO);
			}

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error(
					"[BackEndFacade::isVisualizzaBtnInserisciIspezione] Errore occorso nell'esecuzione del metodo:" + e,
					e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo gestioneVisBottoniInit definito in un ExecCommand del
	 * ContentPanel cpElencoIspezioniImpianti
	 */
	public ExecResults gestioneVisBottoniInit(

			it.csi.sigit.sigitwebn.dto.elenco_ispezioni_impianti.CpElencoIspezioniImpiantiModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GESTIONEVISBOTTONIINIT_OUTCOME_CODE__VISUALIZZA = //NOSONAR  Reason:EIAS
				"VISUALIZZA"; //NOSONAR  Reason:EIAS
		final String GESTIONEVISBOTTONIINIT_OUTCOME_CODE__NASCONDI = //NOSONAR  Reason:EIAS
				"NASCONDI"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R1469506937) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			ArrayList<DettaglioIspezione> listIspezioni = theModel.getAppDataelencoIspezioniPerImpianto();

			if (listIspezioni != null && listIspezioni.size() > 0) {
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
	 * Implementazione del metodo isVisualizzaBtnModificaIspezione definito in un ExecCommand del
	 * ContentPanel cpElencoIspezioniImpianti
	 */
	public ExecResults isVisualizzaBtnModificaIspezione(

			it.csi.sigit.sigitwebn.dto.elenco_ispezioni_impianti.CpElencoIspezioniImpiantiModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String ISVISUALIZZABTNMODIFICAISPEZIONE_OUTCOME_CODE__SI = //NOSONAR  Reason:EIAS
				"SI"; //NOSONAR  Reason:EIAS
		final String ISVISUALIZZABTNMODIFICAISPEZIONE_OUTCOME_CODE__NO = //NOSONAR  Reason:EIAS
				"NO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R1053016780) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			UtenteLoggato utente = theModel.getAppDatautenteLoggato();

			log.debug(" VISUALIZZAZIONE BOTTONE MODIFICA ISPEZIONE ---> PER IMPIANTO");

			String descrizioneRuolo = utente.getRuolo().getDescRuolo();

			log.debug(" isVisualizzaBtnModificaIspezione ---> descrizioneRuolo: " + descrizioneRuolo);

			if (descrizioneRuolo.equals(Constants.RUOLO_SUPER) || descrizioneRuolo.equals(Constants.RUOLO_ISPETTORE)) {
				// impostazione del result code 
				result.setResultCode(ISVISUALIZZABTNMODIFICAISPEZIONE_OUTCOME_CODE__SI);
			} else {
				// impostazione del result code 
				result.setResultCode(ISVISUALIZZABTNMODIFICAISPEZIONE_OUTCOME_CODE__NO);
			}

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error(
					"[BackEndFacade::isVisualizzaBtnModificaIspezione] Errore occorso nell'esecuzione del metodo:" + e,
					e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo isVisualizzaBtnConsolidaIspezione definito in un ExecCommand del
	 * ContentPanel cpElencoIspezioniImpianti
	 */
	public ExecResults isVisualizzaBtnConsolidaIspezione(

			it.csi.sigit.sigitwebn.dto.elenco_ispezioni_impianti.CpElencoIspezioniImpiantiModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String ISVISUALIZZABTNCONSOLIDAISPEZIONE_OUTCOME_CODE__SI = //NOSONAR  Reason:EIAS
				"SI"; //NOSONAR  Reason:EIAS
		final String ISVISUALIZZABTNCONSOLIDAISPEZIONE_OUTCOME_CODE__NO = //NOSONAR  Reason:EIAS
				"NO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-1538625156) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			UtenteLoggato utente = theModel.getAppDatautenteLoggato();

			log.debug(" VISUALIZZAZIONE BOTTONE CONSOLIDA ISPEZIONE ---> PER IMPIANTO");

			String descrizioneRuolo = utente.getRuolo().getDescRuolo();

			log.debug(" isVisualizzaBtnConsolidaIspezione ---> descrizioneRuolo: " + descrizioneRuolo);

			if (descrizioneRuolo.equals(Constants.RUOLO_SUPER) || descrizioneRuolo.equals(Constants.RUOLO_ISPETTORE)) {
				// impostazione del result code 
				result.setResultCode(ISVISUALIZZABTNCONSOLIDAISPEZIONE_OUTCOME_CODE__SI);
			} else {
				// impostazione del result code 
				result.setResultCode(ISVISUALIZZABTNCONSOLIDAISPEZIONE_OUTCOME_CODE__NO);
			}

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error(
					"[BackEndFacade::isVisualizzaBtnConsolidaIspezione] Errore occorso nell'esecuzione del metodo:" + e,
					e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo isVisualizzaBtnAnnullaIspezione definito in un ExecCommand del
	 * ContentPanel cpElencoIspezioniImpianti
	 */
	public ExecResults isVisualizzaBtnAnnullaIspezione(

			it.csi.sigit.sigitwebn.dto.elenco_ispezioni_impianti.CpElencoIspezioniImpiantiModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String ISVISUALIZZABTNANNULLAISPEZIONE_OUTCOME_CODE__SI = //NOSONAR  Reason:EIAS
				"SI"; //NOSONAR  Reason:EIAS
		final String ISVISUALIZZABTNANNULLAISPEZIONE_OUTCOME_CODE__NO = //NOSONAR  Reason:EIAS
				"NO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-1380255407) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			UtenteLoggato utente = theModel.getAppDatautenteLoggato();

			log.debug(" VISUALIZZAZIONE BOTTONE ANNULLA ISPEZIONE ---> PER IMPIANTO");

			String descrizioneRuolo = utente.getRuolo().getDescRuolo();

			log.debug(" isVisualizzaBtnAnnullaIspezione ---> descrizioneRuolo: " + descrizioneRuolo);

			if (descrizioneRuolo.equals(Constants.RUOLO_SUPER) || descrizioneRuolo.equals(Constants.RUOLO_ISPETTORE)) {
				// impostazione del result code 
				result.setResultCode(ISVISUALIZZABTNANNULLAISPEZIONE_OUTCOME_CODE__SI);
			} else {
				// impostazione del result code 
				result.setResultCode(ISVISUALIZZABTNANNULLAISPEZIONE_OUTCOME_CODE__NO);
			}

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::isVisualizzaBtnAnnullaIspezione] Errore occorso nell'esecuzione del metodo:" + e,
					e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo isVisualizzaBtnInserisciAllegato definito in un ExecCommand del
	 * ContentPanel cpElencoIspezioniImpianti
	 */
	public ExecResults isVisualizzaBtnInserisciAllegato(

			it.csi.sigit.sigitwebn.dto.elenco_ispezioni_impianti.CpElencoIspezioniImpiantiModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String ISVISUALIZZABTNINSERISCIALLEGATO_OUTCOME_CODE__SI = //NOSONAR  Reason:EIAS
				"SI"; //NOSONAR  Reason:EIAS
		final String ISVISUALIZZABTNINSERISCIALLEGATO_OUTCOME_CODE__NO = //NOSONAR  Reason:EIAS
				"NO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R2126754744) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			UtenteLoggato utente = theModel.getAppDatautenteLoggato();

			log.debug(" VISUALIZZAZIONE BOTTONE INSERISCI ALLEGATO ---> PER IMPIANTO");

			String descrizioneRuolo = utente.getRuolo().getDescRuolo();

			log.debug(" isVisualizzaBtnInserisciAllegato ---> descrizioneRuolo: " + descrizioneRuolo);

			if (descrizioneRuolo.equals(Constants.RUOLO_SUPER) || descrizioneRuolo.equals(Constants.RUOLO_ISPETTORE)) {
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
	 * Implementazione del metodo isVisualizzaBtnModificaAllegato definito in un ExecCommand del
	 * ContentPanel cpElencoIspezioniImpianti
	 */
	public ExecResults isVisualizzaBtnModificaAllegato(

			it.csi.sigit.sigitwebn.dto.elenco_ispezioni_impianti.CpElencoIspezioniImpiantiModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String ISVISUALIZZABTNMODIFICAALLEGATO_OUTCOME_CODE__SI = //NOSONAR  Reason:EIAS
				"SI"; //NOSONAR  Reason:EIAS
		final String ISVISUALIZZABTNMODIFICAALLEGATO_OUTCOME_CODE__NO = //NOSONAR  Reason:EIAS
				"NO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R273947931) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			UtenteLoggato utente = theModel.getAppDatautenteLoggato();

			log.debug(" VISUALIZZAZIONE BOTTONE MODIFICA ALLEGATO ---> PER IMPIANTO");

			String descrizioneRuolo = utente.getRuolo().getDescRuolo();

			log.debug(" isVisualizzaBtnModificaAllegato ---> descrizioneRuolo: " + descrizioneRuolo);

			if (descrizioneRuolo.equals(Constants.RUOLO_SUPER) || descrizioneRuolo.equals(Constants.RUOLO_ISPETTORE)) {
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
	 * Implementazione del metodo isVisualizzaBtnDettaglioAllegato definito in un ExecCommand del
	 * ContentPanel cpElencoIspezioniImpianti
	 */
	public ExecResults isVisualizzaBtnDettaglioAllegato(

			it.csi.sigit.sigitwebn.dto.elenco_ispezioni_impianti.CpElencoIspezioniImpiantiModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String ISVISUALIZZABTNDETTAGLIOALLEGATO_OUTCOME_CODE__SI = //NOSONAR  Reason:EIAS
				"SI"; //NOSONAR  Reason:EIAS
		final String ISVISUALIZZABTNDETTAGLIOALLEGATO_OUTCOME_CODE__NO = //NOSONAR  Reason:EIAS
				"NO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-306551848) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			// impostazione del result code 
			result.setResultCode(ISVISUALIZZABTNDETTAGLIOALLEGATO_OUTCOME_CODE__SI);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error(
					"[BackEndFacade::isVisualizzaBtnDettaglioAllegato] Errore occorso nell'esecuzione del metodo:" + e,
					e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo isVisualizzaBtnAnnullaAllegato definito in un ExecCommand del
	 * ContentPanel cpElencoIspezioniImpianti
	 */
	public ExecResults isVisualizzaBtnAnnullaAllegato(

			it.csi.sigit.sigitwebn.dto.elenco_ispezioni_impianti.CpElencoIspezioniImpiantiModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String ISVISUALIZZABTNANNULLAALLEGATO_OUTCOME_CODE__SI = //NOSONAR  Reason:EIAS
				"SI"; //NOSONAR  Reason:EIAS
		final String ISVISUALIZZABTNANNULLAALLEGATO_OUTCOME_CODE__NO = //NOSONAR  Reason:EIAS
				"NO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-1744207370) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			UtenteLoggato utente = theModel.getAppDatautenteLoggato();

			log.debug(" VISUALIZZAZIONE BOTTONE ANNULLA ALLEGATO ---> PER IMPIANTO");

			String descrizioneRuolo = utente.getRuolo().getDescRuolo();

			log.debug(" isVisualizzaBtnAnnullaAllegato ---> descrizioneRuolo: " + descrizioneRuolo);

			if (descrizioneRuolo.equals(Constants.RUOLO_SUPER) || descrizioneRuolo.equals(Constants.RUOLO_ISPETTORE)) {
				// impostazione del result code 
				result.setResultCode(ISVISUALIZZABTNANNULLAALLEGATO_OUTCOME_CODE__SI);
			} else {
				// impostazione del result code 
				result.setResultCode(ISVISUALIZZABTNANNULLAALLEGATO_OUTCOME_CODE__NO);
			}

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::isVisualizzaBtnAnnullaAllegato] Errore occorso nell'esecuzione del metodo:" + e,
					e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo isVisualizzaBtnRicevutaAllegato definito in un ExecCommand del
	 * ContentPanel cpElencoIspezioniImpianti
	 */
	public ExecResults isVisualizzaBtnRicevutaAllegato(

			it.csi.sigit.sigitwebn.dto.elenco_ispezioni_impianti.CpElencoIspezioniImpiantiModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String ISVISUALIZZABTNRICEVUTAALLEGATO_OUTCOME_CODE__SI = //NOSONAR  Reason:EIAS
				"SI"; //NOSONAR  Reason:EIAS
		final String ISVISUALIZZABTNRICEVUTAALLEGATO_OUTCOME_CODE__NO = //NOSONAR  Reason:EIAS
				"NO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-1768272642) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			UtenteLoggato utente = theModel.getAppDatautenteLoggato();

			log.debug(" VISUALIZZAZIONE BOTTONE RICEVUTA ALLEGATO PER IMPIANTO");

			String descrizioneRuolo = utente.getRuolo().getDescRuolo();

			log.debug(" isVisualizzaBtnRicevutaAllegatoRef ---> descrizioneRuolo: " + descrizioneRuolo);

			if (descrizioneRuolo.equals(Constants.RUOLO_SUPER) || descrizioneRuolo.equals(Constants.RUOLO_ISPETTORE)) {
				// impostazione del result code 
				result.setResultCode(ISVISUALIZZABTNRICEVUTAALLEGATO_OUTCOME_CODE__SI);
			} else {
				// impostazione del result code 
				result.setResultCode(ISVISUALIZZABTNRICEVUTAALLEGATO_OUTCOME_CODE__NO);
			}

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::isVisualizzaBtnRicevutaAllegato] Errore occorso nell'esecuzione del metodo:" + e,
					e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo isVisualizzaBtnDocumentazione definito in un ExecCommand del
	 * ContentPanel cpElencoIspezioniImpianti
	 */
	public ExecResults isVisualizzaBtnDocumentazione(

			it.csi.sigit.sigitwebn.dto.elenco_ispezioni_impianti.CpElencoIspezioniImpiantiModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String ISVISUALIZZABTNDOCUMENTAZIONE_OUTCOME_CODE__SI = //NOSONAR  Reason:EIAS
				"SI"; //NOSONAR  Reason:EIAS
		final String ISVISUALIZZABTNDOCUMENTAZIONE_OUTCOME_CODE__NO = //NOSONAR  Reason:EIAS
				"NO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-1467568757) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			UtenteLoggato utente = theModel.getAppDatautenteLoggato();

			log.debug(" VISUALIZZAZIONE BOTTONE RICEVUTA ALLEGATO PER IMPIANTO");

			String descrizioneRuolo = utente.getRuolo().getDescRuolo();

			log.debug(" isVisualizzaBtnRicevutaAllegatoRef ---> descrizioneRuolo: " + descrizioneRuolo);

			if (descrizioneRuolo.equals(Constants.RUOLO_SUPER) || descrizioneRuolo.equals(Constants.RUOLO_ISPETTORE)
					|| descrizioneRuolo.equals(Constants.RUOLO_CONSULTATORE)
					|| descrizioneRuolo.equals(Constants.RUOLO_VALIDATORE)) {
				// impostazione del result code 
				result.setResultCode(ISVISUALIZZABTNDOCUMENTAZIONE_OUTCOME_CODE__SI);
			} else {
				// impostazione del result code 
				result.setResultCode(ISVISUALIZZABTNDOCUMENTAZIONE_OUTCOME_CODE__NO);
			}

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::isVisualizzaBtnDocumentazione] Errore occorso nell'esecuzione del metodo:" + e,
					e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo aggiornaDatiPagina definito in un ExecCommand del
	 * ContentPanel cpElencoIspezioniImpianti
	 */
	public ExecResults aggiornaDatiPagina(

			it.csi.sigit.sigitwebn.dto.elenco_ispezioni_impianti.CpElencoIspezioniImpiantiModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String AGGIORNADATIPAGINA_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String AGGIORNADATIPAGINA_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R771000492) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			try {

				result.setResultCode(AGGIORNADATIPAGINA_OUTCOME_CODE__KO);
				//				Message msg = (Message) theModel.getSession().get(
				//						Constants.SESSIONE_VAR_MESSAGGE);
				//
				//				log.debug("@@@@@@@ MESSAGGIO: " + msg);
				//
				//				if (msg != null) {
				//					if (msg.getType() == Message.ERROR)
				//						result.getGlobalErrors().add(msg.getText());
				//					else
				//						result.getGlobalMessages().add(msg.getText());
				//
				//					theModel.getSession().remove(
				//							Constants.SESSIONE_VAR_MESSAGGE);
				//				}

				//devo riaggiornare la lista degli allegati
				log.debug(" dentro aggiorna dati pagina  codice impianto: " + theModel.getAppDataidImpiantoSelez());

				log.debug(" devo aggiornare la pagina: " + theModel.getAppDataaggiornaElencoIspezioni());

				if (theModel.getAppDataaggiornaElencoIspezioni()) {

					caricaElencoIspezioni(theModel);

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
	 * ContentPanel cpElencoIspezioniImpianti
	 */
	public ExecResults gestioneVisBottoniRef(

			it.csi.sigit.sigitwebn.dto.elenco_ispezioni_impianti.CpElencoIspezioniImpiantiModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GESTIONEVISBOTTONIREF_OUTCOME_CODE__VISUALIZZA = //NOSONAR  Reason:EIAS
				"VISUALIZZA"; //NOSONAR  Reason:EIAS
		final String GESTIONEVISBOTTONIREF_OUTCOME_CODE__NASCONDI = //NOSONAR  Reason:EIAS
				"NASCONDI"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R851193020) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			ArrayList<DettaglioIspezione> listIspezioni = theModel.getAppDataelencoIspezioniPerImpianto();

			if (listIspezioni != null && listIspezioni.size() > 0) {
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
	 * Implementazione del metodo isVisualizzaBtnModificaIspezioneRef definito in un ExecCommand del
	 * ContentPanel cpElencoIspezioniImpianti
	 */
	public ExecResults isVisualizzaBtnModificaIspezioneRef(

			it.csi.sigit.sigitwebn.dto.elenco_ispezioni_impianti.CpElencoIspezioniImpiantiModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String ISVISUALIZZABTNMODIFICAISPEZIONEREF_OUTCOME_CODE__SI = //NOSONAR  Reason:EIAS
				"SI"; //NOSONAR  Reason:EIAS
		final String ISVISUALIZZABTNMODIFICAISPEZIONEREF_OUTCOME_CODE__NO = //NOSONAR  Reason:EIAS
				"NO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R312842809) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			UtenteLoggato utente = theModel.getAppDatautenteLoggato();

			log.debug(" VISUALIZZAZIONE BOTTONE MODIFICA ISPEZIONE PER IMPIANTO");

			String descrizioneRuolo = utente.getRuolo().getDescRuolo();

			log.debug(" isVisualizzaBtnModificaIspezioneRef ---> descrizioneRuolo: " + descrizioneRuolo);

			if (descrizioneRuolo.equals(Constants.RUOLO_SUPER) || descrizioneRuolo.equals(Constants.RUOLO_ISPETTORE)) {
				// impostazione del result code 
				result.setResultCode(ISVISUALIZZABTNMODIFICAISPEZIONEREF_OUTCOME_CODE__SI);
			} else {
				// impostazione del result code 
				result.setResultCode(ISVISUALIZZABTNMODIFICAISPEZIONEREF_OUTCOME_CODE__NO);
			}

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
	 * ContentPanel cpElencoIspezioniImpianti
	 */
	public ExecResults isVisualizzaBtnConsolidaIspezioneRef(

			it.csi.sigit.sigitwebn.dto.elenco_ispezioni_impianti.CpElencoIspezioniImpiantiModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String ISVISUALIZZABTNCONSOLIDAISPEZIONEREF_OUTCOME_CODE__SI = //NOSONAR  Reason:EIAS
				"SI"; //NOSONAR  Reason:EIAS
		final String ISVISUALIZZABTNCONSOLIDAISPEZIONEREF_OUTCOME_CODE__NO = //NOSONAR  Reason:EIAS
				"NO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-959959671) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			UtenteLoggato utente = theModel.getAppDatautenteLoggato();

			log.debug(" VISUALIZZAZIONE BOTTONE CONSOLIDA ISPEZIONE PER IMPIANTO");

			String descrizioneRuolo = utente.getRuolo().getDescRuolo();

			log.debug(" isVisualizzaBtnConsolidaIspezioneRef ---> descrizioneRuolo: " + descrizioneRuolo);

			if (descrizioneRuolo.equals(Constants.RUOLO_SUPER) || descrizioneRuolo.equals(Constants.RUOLO_ISPETTORE)) {
				// impostazione del result code 
				result.setResultCode(ISVISUALIZZABTNCONSOLIDAISPEZIONEREF_OUTCOME_CODE__SI);
			} else {
				// impostazione del result code 
				result.setResultCode(ISVISUALIZZABTNCONSOLIDAISPEZIONEREF_OUTCOME_CODE__NO);
			}

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
	 * ContentPanel cpElencoIspezioniImpianti
	 */
	public ExecResults isVisualizzaBtnAnnullaIspezioneRef(

			it.csi.sigit.sigitwebn.dto.elenco_ispezioni_impianti.CpElencoIspezioniImpiantiModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String ISVISUALIZZABTNANNULLAISPEZIONEREF_OUTCOME_CODE__SI = //NOSONAR  Reason:EIAS
				"SI"; //NOSONAR  Reason:EIAS
		final String ISVISUALIZZABTNANNULLAISPEZIONEREF_OUTCOME_CODE__NO = //NOSONAR  Reason:EIAS
				"NO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R1159141780) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			UtenteLoggato utente = theModel.getAppDatautenteLoggato();

			log.debug(" VISUALIZZAZIONE BOTTONE ANNULLA ISPEZIONE PER IMPIANTO");

			String descrizioneRuolo = utente.getRuolo().getDescRuolo();

			log.debug(" isVisualizzaBtnAnnullaIspezioneRef ---> descrizioneRuolo: " + descrizioneRuolo);

			if (descrizioneRuolo.equals(Constants.RUOLO_SUPER) || descrizioneRuolo.equals(Constants.RUOLO_ISPETTORE)) {
				// impostazione del result code 
				result.setResultCode(ISVISUALIZZABTNANNULLAISPEZIONEREF_OUTCOME_CODE__SI);
			} else {
				// impostazione del result code 
				result.setResultCode(ISVISUALIZZABTNANNULLAISPEZIONEREF_OUTCOME_CODE__NO);
			}

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
	 * ContentPanel cpElencoIspezioniImpianti
	 */
	public ExecResults isVisualizzaBtnInserisciAllegatoRef(

			it.csi.sigit.sigitwebn.dto.elenco_ispezioni_impianti.CpElencoIspezioniImpiantiModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String ISVISUALIZZABTNINSERISCIALLEGATOREF_OUTCOME_CODE__SI = //NOSONAR  Reason:EIAS
				"SI"; //NOSONAR  Reason:EIAS
		final String ISVISUALIZZABTNINSERISCIALLEGATOREF_OUTCOME_CODE__NO = //NOSONAR  Reason:EIAS
				"NO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-875892275) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			UtenteLoggato utente = theModel.getAppDatautenteLoggato();

			log.debug(" VISUALIZZAZIONE BOTTONE INSERISCI ALLEGATO PER IMPIANTO");

			String descrizioneRuolo = utente.getRuolo().getDescRuolo();

			log.debug(" isVisualizzaBtnInserisciAllegatoRef ---> descrizioneRuolo: " + descrizioneRuolo);

			if (descrizioneRuolo.equals(Constants.RUOLO_SUPER) || descrizioneRuolo.equals(Constants.RUOLO_ISPETTORE)) {
				// impostazione del result code 
				result.setResultCode(ISVISUALIZZABTNINSERISCIALLEGATOREF_OUTCOME_CODE__SI);
			} else {
				// impostazione del result code 
				result.setResultCode(ISVISUALIZZABTNINSERISCIALLEGATOREF_OUTCOME_CODE__NO);
			}

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
	 * ContentPanel cpElencoIspezioniImpianti
	 */
	public ExecResults isVisualizzaBtnModificaAllegatoRef(

			it.csi.sigit.sigitwebn.dto.elenco_ispezioni_impianti.CpElencoIspezioniImpiantiModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String ISVISUALIZZABTNMODIFICAALLEGATOREF_OUTCOME_CODE__SI = //NOSONAR  Reason:EIAS
				"SI"; //NOSONAR  Reason:EIAS
		final String ISVISUALIZZABTNMODIFICAALLEGATOREF_OUTCOME_CODE__NO = //NOSONAR  Reason:EIAS
				"NO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R1076029834) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			UtenteLoggato utente = theModel.getAppDatautenteLoggato();

			log.debug(" VISUALIZZAZIONE BOTTONE MODIFICA ALLEGATO PER IMPIANTO");

			String descrizioneRuolo = utente.getRuolo().getDescRuolo();

			log.debug(" isVisualizzaBtnModificaAllegatoRef ---> descrizioneRuolo: " + descrizioneRuolo);

			if (descrizioneRuolo.equals(Constants.RUOLO_SUPER) || descrizioneRuolo.equals(Constants.RUOLO_ISPETTORE)) {
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
	 * Implementazione del metodo isVisualizzaBtnDettaglioAllegatoRef definito in un ExecCommand del
	 * ContentPanel cpElencoIspezioniImpianti
	 */
	public ExecResults isVisualizzaBtnDettaglioAllegatoRef(

			it.csi.sigit.sigitwebn.dto.elenco_ispezioni_impianti.CpElencoIspezioniImpiantiModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String ISVISUALIZZABTNDETTAGLIOALLEGATOREF_OUTCOME_CODE__SI = //NOSONAR  Reason:EIAS
				"SI"; //NOSONAR  Reason:EIAS
		final String ISVISUALIZZABTNDETTAGLIOALLEGATOREF_OUTCOME_CODE__NO = //NOSONAR  Reason:EIAS
				"NO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-1054552659) ENABLED START*/
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
	 * ContentPanel cpElencoIspezioniImpianti
	 */
	public ExecResults isVisualizzaBtnAnnullaAllegatoRef(

			it.csi.sigit.sigitwebn.dto.elenco_ispezioni_impianti.CpElencoIspezioniImpiantiModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String ISVISUALIZZABTNANNULLAALLEGATOREF_OUTCOME_CODE__SI = //NOSONAR  Reason:EIAS
				"SI"; //NOSONAR  Reason:EIAS
		final String ISVISUALIZZABTNANNULLAALLEGATOREF_OUTCOME_CODE__NO = //NOSONAR  Reason:EIAS
				"NO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-836332849) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			UtenteLoggato utente = theModel.getAppDatautenteLoggato();

			log.debug(" VISUALIZZAZIONE BOTTONE ANNULLA ALLEGATO PER IMPIANTO");

			String descrizioneRuolo = utente.getRuolo().getDescRuolo();

			log.debug(" isVisualizzaBtnAnnullaAllegatoRef ---> descrizioneRuolo: " + descrizioneRuolo);

			if (descrizioneRuolo.equals(Constants.RUOLO_SUPER) || descrizioneRuolo.equals(Constants.RUOLO_ISPETTORE)) {
				// impostazione del result code 
				result.setResultCode(ISVISUALIZZABTNANNULLAALLEGATOREF_OUTCOME_CODE__SI);
			} else {
				// impostazione del result code 
				result.setResultCode(ISVISUALIZZABTNANNULLAALLEGATOREF_OUTCOME_CODE__NO);
			}

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
	 * ContentPanel cpElencoIspezioniImpianti
	 */
	public ExecResults isVisualizzaBtnRicevutaAllegatoRef(

			it.csi.sigit.sigitwebn.dto.elenco_ispezioni_impianti.CpElencoIspezioniImpiantiModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String ISVISUALIZZABTNRICEVUTAALLEGATOREF_OUTCOME_CODE__SI = //NOSONAR  Reason:EIAS
				"SI"; //NOSONAR  Reason:EIAS
		final String ISVISUALIZZABTNRICEVUTAALLEGATOREF_OUTCOME_CODE__NO = //NOSONAR  Reason:EIAS
				"NO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-505312569) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			UtenteLoggato utente = theModel.getAppDatautenteLoggato();

			log.debug(" VISUALIZZAZIONE BOTTONE RICEVUTA ALLEGATO PER IMPIANTO");

			String descrizioneRuolo = utente.getRuolo().getDescRuolo();

			log.debug(" isVisualizzaBtnRicevutaAllegatoRef ---> descrizioneRuolo: " + descrizioneRuolo);

			if (descrizioneRuolo.equals(Constants.RUOLO_SUPER) || descrizioneRuolo.equals(Constants.RUOLO_ISPETTORE)) {
				// impostazione del result code 
				result.setResultCode(ISVISUALIZZABTNRICEVUTAALLEGATOREF_OUTCOME_CODE__SI);
			} else {
				// impostazione del result code 
				result.setResultCode(ISVISUALIZZABTNRICEVUTAALLEGATOREF_OUTCOME_CODE__NO);
			}

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
	 * ContentPanel cpElencoIspezioniImpianti
	 */
	public ExecResults aggiornaDatiPaginaRef(

			it.csi.sigit.sigitwebn.dto.elenco_ispezioni_impianti.CpElencoIspezioniImpiantiModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String AGGIORNADATIPAGINAREF_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String AGGIORNADATIPAGINAREF_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-278362023) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			result.setResultCode(AGGIORNADATIPAGINAREF_OUTCOME_CODE__OK);

			Message msg = (Message) theModel.getSession().get(Constants.SESSIONE_VAR_MESSAGGE);

			log.debug("@@@@@@@ MESSAGGIO: " + msg);

			if (msg != null) {
				if (msg.getType() == Message.ERROR)
					result.getGlobalErrors().add(msg.getText());
				else
					result.getGlobalMessages().add(msg.getText());

				theModel.getSession().remove(Constants.SESSIONE_VAR_MESSAGGE);

				caricaElencoIspezioni(theModel);
			}

			log.debug("aggiornaDatiPaginaRef - theModel.getAppDataaggiornaElencoIspezioniAllegati(): "
					+ theModel.getAppDataaggiornaElencoIspezioni());

			if (theModel.getAppDataaggiornaElencoIspezioniAllegati() != null
					&& theModel.getAppDataaggiornaElencoIspezioniAllegati()) {

				caricaElencoIspezioni(theModel);
				theModel.setAppDataaggiornaElencoIspezioniAllegati(false);

				// impostazione del result code 
				result.setResultCode(AGGIORNADATIPAGINAREF_OUTCOME_CODE__OK);
			} else {
				result.setResultCode(AGGIORNADATIPAGINAREF_OUTCOME_CODE__KO);
			}

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
	 * permette di resettare lo stato di paginazione della tabella widg_tblElencoIspezioni
	 */
	public static void resetClearStatus_widg_tblElencoIspezioni(java.util.Map session) {
		session.put("cpElencoIspezioniImpianti_tblElencoIspezioni_clearStatus", Boolean.TRUE);
	}

	//////////////////////////////////////////////////////////////////////////////
	/// Property aggiuntive del bean
	//////////////////////////////////////////////////////////////////////////////
	/*PROTECTED REGION ID(R1213931253) ENABLED START*/
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

	private ConnectorMgr connectorMgr;

	public ConnectorMgr getConnectorMgr() {
		return connectorMgr;
	}

	public void setConnectorMgr(ConnectorMgr connectorMgr) {
		this.connectorMgr = connectorMgr;
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

	private void precaricaCombo(
			it.csi.sigit.sigitwebn.dto.elenco_ispezioni_impianti.CpElencoIspezioniImpiantiModel theModel)
			throws BEException {
		try {

			log.debug("theModel.getAppDataallegatoIsp().getCodiceImpianto(): "
					+ theModel.getAppDataallegatoIsp().getCodiceImpianto());

			theModel.setAppDataelencoTipiDocumentoProfilatiIsp(
					getDbMgr().cercaListaTipiDocumentoProfilato(theModel.getAppDataallegatoIsp().getCodiceImpianto()));

			theModel.setAppDataelencoTipiCombustibileIsp(new ArrayList<CodeDescription>());
			theModel.setAppDataelencoApparecchiatureIsp(new ArrayList<CodeDescription>());
			//theModel.setAppDataelencoNumeroBollinoVerdeIsp(new ArrayList<CodeDescription>());

		} catch (ManagerException e) {
			throw new BEException("Errore in CpElencoAllegatiImpiantiModel per il metodo  precaricaCombo:" + e, e);
		}

	}

	private void caricaCombo(
			it.csi.sigit.sigitwebn.dto.elenco_ispezioni_impianti.CpElencoIspezioniImpiantiModel theModel)
			throws BEException {

		try {

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

	private void caricaElencoIspezioni(
			it.csi.sigit.sigitwebn.dto.elenco_ispezioni_impianti.CpElencoIspezioniImpiantiModel theModel)
			throws ManagerException {
		log.debug("caricaElencoIspezioni: START");
		try {
			log.debug("Carico l'elenco delle ispezioni");
			String codiceImpianto = theModel.getAppDataidImpiantoSelez();
			IspezioniPerImpianto impianto;

			impianto = getSigitMgr().cercaIspezioniPerCodiceImpianto(codiceImpianto);

			if (impianto != null) {
				theModel.setAppDataelencoIspezioniPerImpianto(impianto.getListaIspezioni());
			}
			resetClearStatus_widg_tblElencoIspezioni(theModel.getSession());
			theModel.setAppDataaggiornaElencoIspezioni(false);

			log.debug("caricaElencoIspezioni: END");
		} catch (ManagerException e) {
			log.error("Errore: ", e);
			throw e;
		}

	}

	private void caricaElencoAllegati(
			it.csi.sigit.sigitwebn.dto.elenco_ispezioni_impianti.CpElencoIspezioniImpiantiModel theModel)
			throws ManagerException {

		try {
			log.debug("Carico l'elenco degli allegato");
			String codiceImpianto = theModel.getAppDataidImpiantoSelez();
			IspezioniPerImpianto impianto;

			impianto = getSigitMgr().cercaIspezioniPerCodiceImpianto(codiceImpianto);

			if (impianto != null) {
				theModel.setAppDataelencoIspezioniPerImpianto(impianto.getListaIspezioni());
			}
			resetClearStatus_widg_tblElencoIspezioni(theModel.getSession());
			theModel.setAppDataaggiornaElencoIspezioni(false);

			log.debug("CaricaElencoAllegati: END");
		} catch (ManagerException e) {
			log.error("Errore: ", e);
			throw e;
		}

	}

	/*PROTECTED REGION END*/
}
