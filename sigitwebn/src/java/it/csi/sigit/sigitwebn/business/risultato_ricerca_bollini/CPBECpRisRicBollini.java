package it.csi.sigit.sigitwebn.business.risultato_ricerca_bollini;

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

/*PROTECTED REGION ID(R1969365553) ENABLED START*/
import it.csi.sigit.sigitwebn.business.BEException;
import it.csi.sigit.sigitwebn.business.manager.DbMgr;
import it.csi.sigit.sigitwebn.business.manager.SigitMgr;
import it.csi.sigit.sigitwebn.business.manager.ValidationMgr;
import it.csi.sigit.sigitwebn.business.manager.util.DbManagerException;
import it.csi.sigit.sigitwebn.business.manager.util.ManagerException;
import it.csi.sigit.sigitwebn.business.manager.util.Message;
import it.csi.sigit.sigitwebn.dto.ExecResults;
import it.csi.sigit.sigitwebn.dto.accesso.Ruolo;
import it.csi.sigit.sigitwebn.dto.main.RicercaTransazione;
import it.csi.sigit.sigitwebn.dto.main.RisultatoRicTransazione;
import it.csi.sigit.sigitwebn.dto.risultato_ricerca_bollini.CpRisRicBolliniModel;
import it.csi.sigit.sigitwebn.util.Constants;
import it.csi.sigit.sigitwebn.util.ConvertUtil;
import it.csi.sigit.sigitwebn.util.GenericUtil;
import it.csi.sigit.sigitwebn.util.Messages;
import it.csi.sigit.sigitwebn.util.Validator;

import java.util.ArrayList;
import java.util.Map;

import org.apache.log4j.Logger;

/*PROTECTED REGION END*/

public class CPBECpRisRicBollini {

	/**  */
	protected static final Logger log = //NOSONAR  Reason:EIAS 
			Logger.getLogger(Constants.APPLICATION_CODE + ".business"); //NOSONAR  Reason:EIAS

	//////////////////////////////////////////////////////////////////////////////
	/// Costanti identificative degli Application Data
	//////////////////////////////////////////////////////////////////////////////

	// ApplicationData: [elencoBollini, scope:USER_SESSION]
	public static final String APPDATA_ELENCOBOLLINI_CODE = "appDataelencoBollini";

	// ApplicationData: [idBollinoSelez, scope:USER_ACTION]
	public static final String APPDATA_IDBOLLINOSELEZ_CODE = "appDataidBollinoSelez";

	// ApplicationData: [aggiornaElencoBollini, scope:USER_SESSION]
	public static final String APPDATA_AGGIORNAELENCOBOLLINI_CODE = "appDataaggiornaElencoBollini";

	// ApplicationData: [ricercaBollini, scope:USER_SESSION]
	public static final String APPDATA_RICERCABOLLINI_CODE = "appDataricercaBollini";

	// ApplicationData: [utenteLoggato, scope:USER_SESSION]
	public static final String APPDATA_UTENTELOGGATO_CODE = "appDatautenteLoggato";

	//////////////////////////////////////////////////////////////////////////////
	/// Metodi associati alla U.I.
	//////////////////////////////////////////////////////////////////////////////

	// nome del content panel associato al bean
	public static final String CPNAME = "cpRisRicBollini";

	/** 
	 * Restituisce il tab correntemente visibile in un determinato tab set
	 */
	private String getCurrentTab(Map session, String tabSetName) {
		String value = (String) session.get(CPNAME + "_" + tabSetName + "_selectedMultiPanel");
		return value;
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo preparaAcquistaCodici definito in un ExecCommand del
	 * ContentPanel cpRisRicBollini
	 */
	public ExecResults preparaAcquistaCodici(

			it.csi.sigit.sigitwebn.dto.risultato_ricerca_bollini.CpRisRicBolliniModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String PREPARAACQUISTACODICI_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String PREPARAACQUISTACODICI_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-1515983337) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:
			Ruolo ruolo = theModel.getAppDatautenteLoggato().getRuolo();

			//nel caso di SUPER, VALIDATORE i controlli della impresa cessata li esegue nella maschera successiva 
			//in fase di ricerca
			if (ruolo.getDescRuolo().equalsIgnoreCase(Constants.RUOLO_SUPER)
					|| ruolo.getDescRuolo().equalsIgnoreCase(Constants.RUOLO_VALIDATORE)) {
				// impostazione del result code 
				result.setResultCode(PREPARAACQUISTACODICI_OUTCOME_CODE__OK);
			} else {

				log.debug(" prepara acquista bollini --> FRAAAAAAAAAAAAAAA DATA CESSAZIONE IMPRESA : "
						+ ruolo.getDataCessazione());

				if (GenericUtil.isNotNullOrEmpty(ruolo.getDataCessazione())) {
					try {
						getValidationMgr().checkDataCessazioneImpresa(ruolo.getDataCessazione());

						result.setResultCode(PREPARAACQUISTACODICI_OUTCOME_CODE__OK);

					} catch (ManagerException ex) {
						Validator.gestisciEccezione(result, ex);
					}

				} else {
					// impostazione del result code 
					result.setResultCode(PREPARAACQUISTACODICI_OUTCOME_CODE__OK);
				}
			}

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::preparaAcquistaCodici] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo tornaAllaPaginaChiamante definito in un ExecCommand del
	 * ContentPanel cpRisRicBollini
	 */
	public ExecResults tornaAllaPaginaChiamante(

			it.csi.sigit.sigitwebn.dto.risultato_ricerca_bollini.CpRisRicBolliniModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String TORNAALLAPAGINACHIAMANTE_OUTCOME_CODE__RICERCA = //NOSONAR  Reason:EIAS
				"RICERCA"; //NOSONAR  Reason:EIAS
		final String TORNAALLAPAGINACHIAMANTE_OUTCOME_CODE__HOME = //NOSONAR  Reason:EIAS
				"HOME"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R1867058060) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			result.setResultCode(TORNAALLAPAGINACHIAMANTE_OUTCOME_CODE__RICERCA);

			// Adesso tutti passano dalla ricerca, in modo che possano filtrare in caso di troppi risultati
			/*
			Ruolo ruoloUtLog = theModel.getAppDatautenteLoggato().getRuolo();
			
			if (ruoloUtLog.getDescRuolo().equalsIgnoreCase(
					Constants.RUOLO_MANUTENTORE)
					|| ruoloUtLog.getDescRuolo().equalsIgnoreCase(
							Constants.RUOLO_INSTALLATORE)) {
				// impostazione del result code 
				result.setResultCode(TORNAALLAPAGINACHIAMANTE_OUTCOME_CODE__HOME);
			} else {
				// impostazione del result code 
				result.setResultCode(TORNAALLAPAGINACHIAMANTE_OUTCOME_CODE__RICERCA);
			}
			 */

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::tornaAllaPaginaChiamante] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo gestioneMessaggio definito in un ExecCommand del
	 * ContentPanel cpRisRicBollini
	 */
	public ExecResults gestioneMessaggio(

			it.csi.sigit.sigitwebn.dto.risultato_ricerca_bollini.CpRisRicBolliniModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GESTIONEMESSAGGIO_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R2069829659) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			Message msg = (Message) theModel.getSession().get(Constants.SESSIONE_VAR_MESSAGGE);

			if (msg != null) {
				if (msg.isErrorMessage())
					result.getGlobalErrors().add(msg.getText());
				else
					result.getGlobalMessages().add(msg.getText());

				theModel.getSession().remove(Constants.SESSIONE_VAR_MESSAGGE);

			}

			// impostazione del result code 
			result.setResultCode(GESTIONEMESSAGGIO_OUTCOME_CODE__OK);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::gestioneMessaggio] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo gestioneAggElenco definito in un ExecCommand del
	 * ContentPanel cpRisRicBollini
	 */
	public ExecResults gestioneAggElenco(

			it.csi.sigit.sigitwebn.dto.risultato_ricerca_bollini.CpRisRicBolliniModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GESTIONEAGGELENCO_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String GESTIONEAGGELENCO_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-1795840147) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			try {
				if (theModel.getAppDataaggiornaElencoBollini()) {

					RicercaTransazione ricBollini = theModel.getAppDataricercaBollini();
					Ruolo ruoloUtLog = theModel.getAppDatautenteLoggato().getRuolo();

					if (log.isDebugEnabled())
						GenericUtil.stampa(ruoloUtLog, true, 3);

					if (!ruoloUtLog.getDescRuolo().equalsIgnoreCase(Constants.RUOLO_VALIDATORE)
							&& !ruoloUtLog.getDescRuolo().equalsIgnoreCase(Constants.RUOLO_SUPER)) {

						if (ricBollini == null) {
							ricBollini = new RicercaTransazione();
						}

						// Imposto i dati (non saranno modificabili)
						ricBollini.setIdSiglaRea(ruoloUtLog.getSiglaRea());
						ricBollini.setNumeroRea(ConvertUtil.convertToUDTPositiveInteger(ruoloUtLog.getNumeroRea()));
						ricBollini.setCodiceFiscale(ruoloUtLog.getCodiceFiscale());

					}

					// Adesso c'è l'assegnazione automatica dei bollini
					//					ArrayList<RisultatoRicTransazione> risRicCodBollinoList = getSigitMgr()
					//							.cercaElencoBollini(ricBollini);
					//					theModel.setAppDataelencoBollini(risRicCodBollinoList);

					theModel.setAppDataaggiornaElencoBollini(false);
				}

				gestioneMsgRicerca(theModel, result);
				// impostazione del result code 
				result.setResultCode(GESTIONEAGGELENCO_OUTCOME_CODE__OK);

			} catch (ManagerException ex) {

				Validator.gestisciEccezione(result, ex);

			}

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::gestioneAggElenco] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo gestioneVisBottoneAcquista definito in un ExecCommand del
	 * ContentPanel cpRisRicBollini
	 */
	public ExecResults gestioneVisBottoneAcquista(

			it.csi.sigit.sigitwebn.dto.risultato_ricerca_bollini.CpRisRicBolliniModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GESTIONEVISBOTTONEACQUISTA_OUTCOME_CODE__VISUALIZZA_AC = //NOSONAR  Reason:EIAS
				"VISUALIZZA_AC"; //NOSONAR  Reason:EIAS
		final String GESTIONEVISBOTTONEACQUISTA_OUTCOME_CODE__NASCONDI_AC = //NOSONAR  Reason:EIAS
				"NASCONDI_AC"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R1539785976) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			Ruolo ruoloUtLog = theModel.getAppDatautenteLoggato().getRuolo();

			/*if (ruoloUtLog.getDescRuolo().equalsIgnoreCase(
					Constants.RUOLO_VALIDATORE)
					|| ruoloUtLog.getDescRuolo().equalsIgnoreCase(
							Constants.RUOLO_SUPER)) {
			
				result.setResultCode(GESTIONEVISBOTTONEACQUISTA_OUTCOME_CODE__NASCONDI_AC);
			
			} else {
				result.setResultCode(GESTIONEVISBOTTONEACQUISTA_OUTCOME_CODE__VISUALIZZA_AC);
			
			}*/

			//per evitare di cancellare il metodo sul modello faccio che chiunque arrivi veda il bottone
			result.setResultCode(GESTIONEVISBOTTONEACQUISTA_OUTCOME_CODE__VISUALIZZA_AC);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::gestioneVisBottoneAcquista] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo gestioneVisBottoneStampa definito in un ExecCommand del
	 * ContentPanel cpRisRicBollini
	 */
	public ExecResults gestioneVisBottoneStampa(

			it.csi.sigit.sigitwebn.dto.risultato_ricerca_bollini.CpRisRicBolliniModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GESTIONEVISBOTTONESTAMPA_OUTCOME_CODE__VISUALIZZA_ST = //NOSONAR  Reason:EIAS
				"VISUALIZZA_ST"; //NOSONAR  Reason:EIAS
		final String GESTIONEVISBOTTONESTAMPA_OUTCOME_CODE__NASCONDI_ST = //NOSONAR  Reason:EIAS
				"NASCONDI_ST"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R241910455) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			/*
			 * Regione piemonte ha stabilito che per adesso il bottone stampa e' superfluo
			 * per qualsiasi profilo, non ho fatto che reindirizzare al caso di nascondi bottone stampa
			 * in tutti i casi, ho praticamente commentato il codce di prima
			 */

			/*if (theModel.getAppDataelencoBollini().size() > 0) {
				// impostazione del result code 
				result.setResultCode(GESTIONEVISBOTTONESTAMPA_OUTCOME_CODE__VISUALIZZA_ST);
			} else {
				// impostazione del result code 
				result.setResultCode(GESTIONEVISBOTTONESTAMPA_OUTCOME_CODE__NASCONDI_ST);
			}*/

			// impostazione del result code 
			result.setResultCode(GESTIONEVISBOTTONESTAMPA_OUTCOME_CODE__NASCONDI_ST);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::gestioneVisBottoneStampa] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	//////////////////////////////////////////////////////////////////////////////
	/// Metodi statici per il reset delle tabelle
	//////////////////////////////////////////////////////////////////////////////

	/**
	 * permette di resettare lo stato di paginazione della tabella widg_tbRisultatoRicBollini
	 */
	public static void resetClearStatus_widg_tbRisultatoRicBollini(java.util.Map session) {
		session.put("cpRisRicBollini_tbRisultatoRicBollini_clearStatus", Boolean.TRUE);
	}

	//////////////////////////////////////////////////////////////////////////////
	/// Property aggiuntive del bean
	//////////////////////////////////////////////////////////////////////////////
	/*PROTECTED REGION ID(R1280677981) ENABLED START*/
	//// inserire qui le property che si vogliono iniettare in questo bean (es. dao, proxy di pd, ...) 
	private SigitMgr sigitMgr;
	private DbMgr dbMgr;

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

	public DbMgr getDbMgr() {
		return dbMgr;
	}

	public void setDbMgr(DbMgr dbMgr) {
		this.dbMgr = dbMgr;
	}

	private void gestioneMsgRicerca(CpRisRicBolliniModel theModel, ExecResults result) throws DbManagerException {
		Integer maxNumRighe = getDbMgr().cercaConfigValueNumerico(Constants.MAX_RIGHE_ACQUISISCI_CODICE);
		log.debug("MAX num righe da visualizzare = " + maxNumRighe);
		ArrayList<RisultatoRicTransazione> list = theModel.getAppDataelencoBollini();
		if (list != null && list.size() == maxNumRighe)
			result.getGlobalMessages()
					.add(Messages.MSG_RISULTATI_RICERCA.replaceFirst("##value##", maxNumRighe.toString()));
	}

	/*PROTECTED REGION END*/
}
