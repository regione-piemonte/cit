package it.csi.sigit.sigitwebn.business.back_office;

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

/*PROTECTED REGION ID(R171831775) ENABLED START*/
import it.csi.sigit.sigitwebn.business.manager.SigitMgr;
import it.csi.sigit.sigitwebn.business.manager.ValidationMgr;
import it.csi.sigit.sigitwebn.business.manager.util.ManagerException;
import it.csi.sigit.sigitwebn.business.manager.DbMgr;

/*PROTECTED REGION END*/

public class CPBECpElencoAbilitazioni {

	/**  */
	protected static final Logger log = //NOSONAR  Reason:EIAS 
			Logger.getLogger(Constants.APPLICATION_CODE + ".business"); //NOSONAR  Reason:EIAS

	//////////////////////////////////////////////////////////////////////////////
	/// Costanti identificative degli Application Data
	//////////////////////////////////////////////////////////////////////////////

	// ApplicationData: [utenteLoggato, scope:USER_SESSION]
	public static final String APPDATA_UTENTELOGGATO_CODE = "appDatautenteLoggato";

	// ApplicationData: [listaAbilitazioni, scope:USER_SESSION]
	public static final String APPDATA_LISTAABILITAZIONI_CODE = "appDatalistaAbilitazioni";

	// ApplicationData: [ricercaAbilitazione, scope:USER_SESSION]
	public static final String APPDATA_RICERCAABILITAZIONE_CODE = "appDataricercaAbilitazione";

	// ApplicationData: [elencoIstatAbilitazioni, scope:USER_SESSION]
	public static final String APPDATA_ELENCOISTATABILITAZIONI_CODE = "appDataelencoIstatAbilitazioni";

	// ApplicationData: [elencoRuolo, scope:USER_SESSION]
	public static final String APPDATA_ELENCORUOLO_CODE = "appDataelencoRuolo";

	// ApplicationData: [elencoUtentiPa, scope:USER_SESSION]
	public static final String APPDATA_ELENCOUTENTIPA_CODE = "appDataelencoUtentiPa";

	// ApplicationData: [idAbilitazioneSelez, scope:USER_SESSION]
	public static final String APPDATA_IDABILITAZIONESELEZ_CODE = "appDataidAbilitazioneSelez";

	// ApplicationData: [newMail, scope:USER_SESSION]
	public static final String APPDATA_NEWMAIL_CODE = "appDatanewMail";

	// ApplicationData: [messaggioDinamico, scope:USER_SESSION]
	public static final String APPDATA_MESSAGGIODINAMICO_CODE = "appDatamessaggioDinamico";

	//////////////////////////////////////////////////////////////////////////////
	/// Metodi associati alla U.I.
	//////////////////////////////////////////////////////////////////////////////

	// nome del content panel associato al bean
	public static final String CPNAME = "cpElencoAbilitazioni";

	public static final String MULTIPANEL_MPAGGMAIL = "mpAggMail";
	public static final String MPI_MPAGGMAIL_FPAGGMAIL = CPNAME + "_" + MULTIPANEL_MPAGGMAIL + "_" + "fpAggMail";

	/** 
	 * Restituisce il tab correntemente visibile in un determinato tab set
	 */
	private String getCurrentTab(Map session, String tabSetName) {
		String value = (String) session.get(CPNAME + "_" + tabSetName + "_selectedMultiPanel");
		return value;
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo ricercaAbilitazioni definito in un ExecCommand del
	 * ContentPanel cpElencoAbilitazioni
	 */
	public ExecResults ricercaAbilitazioni(

			it.csi.sigit.sigitwebn.dto.back_office.CpElencoAbilitazioniModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String RICERCAABILITAZIONI_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String RICERCAABILITAZIONI_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-1422844132) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			// Devo ricercare le abilitazioni
			theModel.setAppDatalistaAbilitazioni(
					getSigitMgr().getElencoAbilitazioniByFilter(theModel.getAppDataricercaAbilitazione()));

			// impostazione del result code 
			result.setResultCode(RICERCAABILITAZIONI_OUTCOME_CODE__OK);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::ricercaAbilitazioni] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo nuovaAbilitazione definito in un ExecCommand del
	 * ContentPanel cpElencoAbilitazioni
	 */
	public ExecResults nuovaAbilitazione(

			it.csi.sigit.sigitwebn.dto.back_office.CpElencoAbilitazioniModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String NUOVAABILITAZIONE_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String NUOVAABILITAZIONE_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-1419079484) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			// impostazione del result code 
			result.setResultCode(NUOVAABILITAZIONE_OUTCOME_CODE__OK);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::nuovaAbilitazione] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo cessaAbilitazione definito in un ExecCommand del
	 * ContentPanel cpElencoAbilitazioni
	 */
	public ExecResults cessaAbilitazione(

			it.csi.sigit.sigitwebn.dto.back_office.CpElencoAbilitazioniModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String CESSAABILITAZIONE_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String CESSAABILITAZIONE_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R1336174616) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			try {

				Integer idAbilitazioneSelez = theModel.getAppDataidAbilitazioneSelez();

				getValidationMgr().checkSelezioneElemento(idAbilitazioneSelez);

				Abilitazione abilitazione = getAbilitazioneSelez(theModel.getAppDatalistaAbilitazioni(),
						idAbilitazioneSelez);

				log.debug("cessaAbilitazione - Stampo l'idSelezionato: " + idAbilitazioneSelez);
				if (log.isDebugEnabled())
					GenericUtil.stampa(abilitazione, true, 3);

				if (abilitazione != null && abilitazione.getDataFine() == null) {

					getSigitMgr().cessaAbilitazione(abilitazione);

					// Devo ricercare le abilitazioni
					theModel.setAppDatalistaAbilitazioni(
							getSigitMgr().getElencoAbilitazioniByFilter(theModel.getAppDataricercaAbilitazione()));

					result.getGlobalMessages().add(Messages.INFO_MODIFICA_CORRETTA);

					// impostazione del result code 
					result.setResultCode(CESSAABILITAZIONE_OUTCOME_CODE__OK);
				} else {
					result.getGlobalErrors().add(Messages.ERROR_ABILITAZIONE_GIA_CESSATA);

					// impostazione del result code 
					result.setResultCode(CESSAABILITAZIONE_OUTCOME_CODE__KO);

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
			log.error("[BackEndFacade::cessaAbilitazione] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo aggiornaMailGruppo definito in un ExecCommand del
	 * ContentPanel cpElencoAbilitazioni
	 */
	public ExecResults aggiornaMailGruppo(

			it.csi.sigit.sigitwebn.dto.back_office.CpElencoAbilitazioniModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String AGGIORNAMAILGRUPPO_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String AGGIORNAMAILGRUPPO_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-795902878) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			try {

				Integer chiaveAbilitazione = theModel.getAppDataidAbilitazioneSelez();

				getValidationMgr().checkSelezioneElemento(chiaveAbilitazione);

				// impostazione del result code 
				result.setResultCode(AGGIORNAMAILGRUPPO_OUTCOME_CODE__OK);
			} catch (ManagerException ex) {
				Validator.gestisciEccezione(result, ex);

			}

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::aggiornaMailGruppo] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo salvaMailGruppo definito in un ExecCommand del
	 * ContentPanel cpElencoAbilitazioni
	 */
	public ExecResults salvaMailGruppo(

			it.csi.sigit.sigitwebn.dto.back_office.CpElencoAbilitazioniModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String SALVAMAILGRUPPO_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String SALVAMAILGRUPPO_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R173387255) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			try {

				Integer idAbilitazioneSelez = theModel.getAppDataidAbilitazioneSelez();

				getValidationMgr().validazioneFormaleAggMailGruppo(theModel.getAppDatanewMail());

				Abilitazione abilitazione = getAbilitazioneSelez(theModel.getAppDatalistaAbilitazioni(),
						idAbilitazioneSelez);

				getSigitMgr().aggiornaMailAbilitazione(abilitazione, theModel.getAppDatanewMail());

				// Devo ricercare le abilitazioni
				theModel.setAppDatalistaAbilitazioni(
						getSigitMgr().getElencoAbilitazioniByFilter(theModel.getAppDataricercaAbilitazione()));

				result.getGlobalMessages().add(Messages.INFO_MODIFICA_CORRETTA);

				// impostazione del result code 
				result.setResultCode(SALVAMAILGRUPPO_OUTCOME_CODE__OK);
			} catch (ManagerException ex) {
				Validator.gestisciEccezione(result, ex);

			}

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::salvaMailGruppo] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo isRuoloAbilitato definito in un ExecCommand del
	 * ContentPanel cpElencoAbilitazioni
	 */
	public ExecResults isRuoloAbilitato(

			it.csi.sigit.sigitwebn.dto.back_office.CpElencoAbilitazioniModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String ISRUOLOABILITATO_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-548443788) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			UtenteLoggato utente = theModel.getAppDatautenteLoggato();

			if (GenericUtil.isRuoloAbilitatoAccessoBackOffice(utente)) {
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
	 * Implementazione del metodo inizializzaElencoAbilitazioni definito in un ExecCommand del
	 * ContentPanel cpElencoAbilitazioni
	 */
	public ExecResults inizializzaElencoAbilitazioni(

			it.csi.sigit.sigitwebn.dto.back_office.CpElencoAbilitazioniModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String INIZIALIZZAELENCOABILITAZIONI_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String INIZIALIZZAELENCOABILITAZIONI_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-1371618527) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			log.debug("Entro su inizializzaElencoAbilitazioni");

			try {
				theModel.setAppDataelencoRuolo(getDbMgr().cercaListaRuoloPa());

				if (theModel.getAppDataelencoUtentiPa() == null) {
					theModel.setAppDataelencoUtentiPa(getSigitMgr().getElencoUtentiPa());
				}

				// Le ISTAT abilitazioni le ricarico ogni volta che entro
				theModel.setAppDataelencoIstatAbilitazioni(getDbMgr().cercaListaIstatAbilitazione());

				//theModel.setAppDataricercaAbilitazione(new Abilitazione());

				// Se c'è il messaggio dinamico e' perche' arrivo dall'inserimento
				String msgDinamico = theModel.getAppDatamessaggioDinamico();

				log.debug("inizializzaElencoAbilitazioni - msgDinamico: " + msgDinamico);

				if (GenericUtil.isNotNullOrEmpty(msgDinamico)) {
					result.getGlobalMessages().add(msgDinamico);
					theModel.setAppDatamessaggioDinamico(null);

				}

				// Devo ricercare le abilitazioni di default
				//theModel.setAppDatalistaAbilitazioni(getSigitMgr().getElencoAbilitazioniByFilter(null));
				theModel.setAppDatalistaAbilitazioni(
						getSigitMgr().getElencoAbilitazioniByFilter(theModel.getAppDataricercaAbilitazione()));

				// impostazione del result code 
				result.setResultCode(INIZIALIZZAELENCOABILITAZIONI_OUTCOME_CODE__OK);
			} catch (ManagerException ex) {
				Validator.gestisciEccezione(result, ex);

			}

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::inizializzaElencoAbilitazioni] Errore occorso nell'esecuzione del metodo:" + e,
					e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	//////////////////////////////////////////////////////////////////////////////
	/// Metodi statici per il reset delle tabelle
	//////////////////////////////////////////////////////////////////////////////

	/**
	 * permette di resettare lo stato di paginazione della tabella widg_tbElencoAbilitazioni
	 */
	public static void resetClearStatus_widg_tbElencoAbilitazioni(java.util.Map session) {
		session.put("cpElencoAbilitazioni_tbElencoAbilitazioni_clearStatus", Boolean.TRUE);
	}

	//////////////////////////////////////////////////////////////////////////////
	/// Property aggiuntive del bean
	//////////////////////////////////////////////////////////////////////////////
	/*PROTECTED REGION ID(R-1954108299) ENABLED START*/
	//// inserire qui le property che si vogliono iniettare in questo bean (es. dao, proxy di pd, ...)
	private SigitMgr sigitMgr;
	private DbMgr dbMgr;
	private ValidationMgr validationMgr;

	public SigitMgr getSigitMgr() {
		return sigitMgr;
	}

	public void setSigitMgr(SigitMgr sigitMgr) {
		this.sigitMgr = sigitMgr;
	}

	public DbMgr getDbMgr() {
		return dbMgr;
	}

	public void setDbMgr(DbMgr dbMgr) {
		this.dbMgr = dbMgr;
	}

	public ValidationMgr getValidationMgr() {
		return validationMgr;
	}

	public void setValidationMgr(ValidationMgr validationMgr) {
		this.validationMgr = validationMgr;
	}

	private Abilitazione getAbilitazioneSelez(ArrayList<Abilitazione> listAbilitazioni, Integer idAbilSelez) {
		return listAbilitazioni.get(idAbilSelez);
	}
	/*PROTECTED REGION END*/
}
