package it.csi.sigit.sigitwebn.business.risultato_ricerca_codici_impianto;

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

/*PROTECTED REGION ID(R-1119782211) ENABLED START*/
import it.csi.sigit.sigitwebn.business.BEException;
import it.csi.sigit.sigitwebn.business.manager.DbMgr;
import it.csi.sigit.sigitwebn.business.manager.SigitMgr;
import it.csi.sigit.sigitwebn.business.manager.ValidationMgr;
import it.csi.sigit.sigitwebn.business.manager.util.DbManagerException;
import it.csi.sigit.sigitwebn.business.manager.util.ManagerException;
import it.csi.sigit.sigitwebn.business.manager.util.Message;
import it.csi.sigit.sigitwebn.dto.ExecResults;
import it.csi.sigit.sigitwebn.dto.accesso.Ruolo;
import it.csi.sigit.sigitwebn.dto.codici_impianto.RisultatoRicCodImpiantoLib;
import it.csi.sigit.sigitwebn.dto.main.RisultatoRicTransazione;
import it.csi.sigit.sigitwebn.dto.risultato_ricerca_codici_impianto.CpRisRicCodiciModel;
import it.csi.sigit.sigitwebn.util.Constants;
import it.csi.sigit.sigitwebn.util.ConvertUtil;
import it.csi.sigit.sigitwebn.util.GenericUtil;
import it.csi.sigit.sigitwebn.util.Messages;
import it.csi.sigit.sigitwebn.util.Validator;

import java.util.ArrayList;
import java.util.Map;

import org.apache.log4j.Logger;

/*PROTECTED REGION END*/

public class CPBECpRisRicCodici {

	/**  */
	protected static final Logger log = //NOSONAR  Reason:EIAS 
			Logger.getLogger(Constants.APPLICATION_CODE + ".business"); //NOSONAR  Reason:EIAS

	//////////////////////////////////////////////////////////////////////////////
	/// Costanti identificative degli Application Data
	//////////////////////////////////////////////////////////////////////////////

	// ApplicationData: [elencoCodImpianto, scope:USER_SESSION]
	public static final String APPDATA_ELENCOCODIMPIANTO_CODE = "appDataelencoCodImpianto";

	// ApplicationData: [ricercaCodImpianto, scope:USER_SESSION]
	public static final String APPDATA_RICERCACODIMPIANTO_CODE = "appDataricercaCodImpianto";

	// ApplicationData: [idCodImpiantoSelez, scope:USER_SESSION]
	public static final String APPDATA_IDCODIMPIANTOSELEZ_CODE = "appDataidCodImpiantoSelez";

	// ApplicationData: [aggiornaElencoCodImpianto, scope:USER_SESSION]
	public static final String APPDATA_AGGIORNAELENCOCODIMPIANTO_CODE = "appDataaggiornaElencoCodImpianto";

	// ApplicationData: [utenteLoggato, scope:USER_SESSION]
	public static final String APPDATA_UTENTELOGGATO_CODE = "appDatautenteLoggato";

	// ApplicationData: [elencoCodImpiantoLiberi, scope:USER_SESSION]
	public static final String APPDATA_ELENCOCODIMPIANTOLIBERI_CODE = "appDataelencoCodImpiantoLiberi";

	// ApplicationData: [acquisizioneCodiciImpianto, scope:USER_SESSION]
	public static final String APPDATA_ACQUISIZIONECODICIIMPIANTO_CODE = "appDataacquisizioneCodiciImpianto";

	//////////////////////////////////////////////////////////////////////////////
	/// Metodi associati alla U.I.
	//////////////////////////////////////////////////////////////////////////////

	// nome del content panel associato al bean
	public static final String CPNAME = "cpRisRicCodici";

	/** 
	 * Restituisce il tab correntemente visibile in un determinato tab set
	 */
	private String getCurrentTab(Map session, String tabSetName) {
		String value = (String) session.get(CPNAME + "_" + tabSetName + "_selectedMultiPanel");
		return value;
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo preparaAcquisisciCodici definito in un ExecCommand del
	 * ContentPanel cpRisRicCodici
	 */
	public ExecResults preparaAcquisisciCodici(

			it.csi.sigit.sigitwebn.dto.risultato_ricerca_codici_impianto.CpRisRicCodiciModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String PREPARAACQUISISCICODICI_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String PREPARAACQUISISCICODICI_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-1817851552) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:
			Ruolo ruolo = theModel.getAppDatautenteLoggato().getRuolo();

			if (ruolo.getDescRuolo().equalsIgnoreCase(Constants.RUOLO_SUPER)
					|| ruolo.getDescRuolo().equalsIgnoreCase(Constants.RUOLO_VALIDATORE)) {

				// impostazione del result code 
				result.setResultCode(PREPARAACQUISISCICODICI_OUTCOME_CODE__OK);
			} else {

				log.debug("FRAAAAAAAAAAAAAAA DATA CESSAZIONE IMPRESA : " + ruolo.getDataCessazione());

				if (GenericUtil.isNotNullOrEmpty(ruolo.getDataCessazione())) {
					try {
						getValidationMgr().checkDataCessazioneImpresa(ruolo.getDataCessazione());

						result.setResultCode(PREPARAACQUISISCICODICI_OUTCOME_CODE__OK);

					} catch (ManagerException ex) {
						Validator.gestisciEccezione(result, ex);
					}

				} else {
					// impostazione del result code 
					result.setResultCode(PREPARAACQUISISCICODICI_OUTCOME_CODE__OK);
				}

			}

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::preparaAcquisisciCodici] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo gestisciDettaglioCodice definito in un ExecCommand del
	 * ContentPanel cpRisRicCodici
	 */
	public ExecResults gestisciDettaglioCodice(

			it.csi.sigit.sigitwebn.dto.risultato_ricerca_codici_impianto.CpRisRicCodiciModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GESTISCIDETTAGLIOCODICE_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String GESTISCIDETTAGLIOCODICE_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-1870192853) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			String idCodImpiantoSelez = theModel.getAppDataidCodImpiantoSelez();

			try {
				getValidationMgr().checkSelezioneElemento(idCodImpiantoSelez);

				Integer idCodImpSelez = ConvertUtil.convertToInteger(idCodImpiantoSelez);

				ArrayList<RisultatoRicTransazione> ricCodImpiantoList = theModel.getAppDataelencoCodImpianto();

				for (RisultatoRicTransazione risultatoRicCodImpianto : ricCodImpiantoList) {

					if (risultatoRicCodImpianto.getIdTransazione().intValue() == idCodImpSelez.intValue()) {
						ArrayList<RisultatoRicCodImpiantoLib> ricCodImpiantoLiberiList = getSigitMgr()
								.cercaElencoCodiciLiberi(risultatoRicCodImpianto, idCodImpSelez);

						theModel.setAppDataelencoCodImpiantoLiberi(ricCodImpiantoLiberiList);
						break;
					}
				}

				// impostazione del result code 
				result.setResultCode(GESTISCIDETTAGLIOCODICE_OUTCOME_CODE__OK);

			} catch (ManagerException ex) {

				Validator.gestisciEccezione(result, ex);

			}
			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::gestisciDettaglioCodice] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo gestioneMessaggio definito in un ExecCommand del
	 * ContentPanel cpRisRicCodici
	 */
	public ExecResults gestioneMessaggio(

			it.csi.sigit.sigitwebn.dto.risultato_ricerca_codici_impianto.CpRisRicCodiciModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GESTIONEMESSAGGIO_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-1502357337) ENABLED START*/
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
	 * ContentPanel cpRisRicCodici
	 */
	public ExecResults gestioneAggElenco(

			it.csi.sigit.sigitwebn.dto.risultato_ricerca_codici_impianto.CpRisRicCodiciModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GESTIONEAGGELENCO_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String GESTIONEAGGELENCO_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-1073059847) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			try {
				if (theModel.getAppDataaggiornaElencoCodImpianto()) {

					// Adesso c'è l'assegnazione automatica dei bollini
					//					ArrayList<RisultatoRicTransazione> risRicCodImpiantoList = getSigitMgr()
					//							.cercaElencoCodici(theModel.getAppDataricercaCodImpianto());
					//					theModel.setAppDataelencoCodImpianto(risRicCodImpiantoList);

					theModel.setAppDataaggiornaElencoCodImpianto(false);
				}
				gestioneMsgRicerca(theModel, result);
				// impostazione del result code 
				result.setResultCode(GESTIONEAGGELENCO_OUTCOME_CODE__OK);

			} catch (ManagerException ex) {
				Validator.gestisciEccezione(result, ex);
			}
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
	 * Implementazione del metodo gestioneVisBottoneDettaglio definito in un ExecCommand del
	 * ContentPanel cpRisRicCodici
	 */
	public ExecResults gestioneVisBottoneDettaglio(

			it.csi.sigit.sigitwebn.dto.risultato_ricerca_codici_impianto.CpRisRicCodiciModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GESTIONEVISBOTTONEDETTAGLIO_OUTCOME_CODE__VISUALIZZA_DET = //NOSONAR  Reason:EIAS
				"VISUALIZZA_DET"; //NOSONAR  Reason:EIAS
		final String GESTIONEVISBOTTONEDETTAGLIO_OUTCOME_CODE__NASCONDI_DET = //NOSONAR  Reason:EIAS
				"NASCONDI_DET"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R1692342756) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			if (theModel.getAppDataelencoCodImpianto().size() > 0) {
				// impostazione del result code 
				result.setResultCode(GESTIONEVISBOTTONEDETTAGLIO_OUTCOME_CODE__VISUALIZZA_DET);
			} else {
				// impostazione del result code 
				result.setResultCode(GESTIONEVISBOTTONEDETTAGLIO_OUTCOME_CODE__NASCONDI_DET);
			}

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::gestioneVisBottoneDettaglio] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	//////////////////////////////////////////////////////////////////////////////
	/// Metodi statici per il reset delle tabelle
	//////////////////////////////////////////////////////////////////////////////

	/**
	 * permette di resettare lo stato di paginazione della tabella widg_tbRisultatoRicCodici
	 */
	public static void resetClearStatus_widg_tbRisultatoRicCodici(java.util.Map session) {
		session.put("cpRisRicCodici_tbRisultatoRicCodici_clearStatus", Boolean.TRUE);
	}

	//////////////////////////////////////////////////////////////////////////////
	/// Property aggiuntive del bean
	//////////////////////////////////////////////////////////////////////////////
	/*PROTECTED REGION ID(R-566015721) ENABLED START*/
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

	private void gestioneMsgRicerca(CpRisRicCodiciModel theModel, ExecResults result) throws DbManagerException {
		Integer maxNumRighe = getDbMgr().cercaConfigValueNumerico(Constants.MAX_RIGHE_ACQUISISCI_CODICE);
		log.debug("MAX num righe da visualizzare = " + maxNumRighe);
		ArrayList<RisultatoRicTransazione> list = theModel.getAppDataelencoCodImpianto();
		if (list != null && list.size() == maxNumRighe)
			result.getGlobalMessages()
					.add(Messages.MSG_RISULTATI_RICERCA.replaceFirst("##value##", maxNumRighe.toString()));
	}

	/*PROTECTED REGION END*/
}
