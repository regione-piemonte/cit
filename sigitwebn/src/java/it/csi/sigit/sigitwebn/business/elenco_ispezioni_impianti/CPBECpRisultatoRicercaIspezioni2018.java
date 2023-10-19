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

/*PROTECTED REGION ID(R124074963) ENABLED START*/
import it.csi.sigit.sigitwebn.business.manager.SigitMgr;
import it.csi.sigit.sigitwebn.business.manager.DbMgr;
import it.csi.sigit.sigitwebn.business.manager.ServiziMgr;
import it.csi.sigit.sigitwebn.business.manager.ValidationMgr;
import it.csi.sigit.sigitwebn.business.manager.util.DbManagerException;
import it.csi.sigit.sigitwebn.business.manager.util.ManagerException;
/*PROTECTED REGION END*/

public class CPBECpRisultatoRicercaIspezioni2018 {

	/**  */
	protected static final Logger log = //NOSONAR  Reason:EIAS 
			Logger.getLogger(Constants.APPLICATION_CODE + ".business"); //NOSONAR  Reason:EIAS

	//////////////////////////////////////////////////////////////////////////////
	/// Costanti identificative degli Application Data
	//////////////////////////////////////////////////////////////////////////////

	// ApplicationData: [ElencoIspezioni2018, scope:USER_SESSION]
	public static final String APPDATA_ELENCOISPEZIONI2018_CODE = "appDataElencoIspezioni2018";

	// ApplicationData: [idIspezioneSelezionato, scope:USER_SESSION]
	public static final String APPDATA_IDISPEZIONESELEZIONATO_CODE = "appDataidIspezioneSelezionato";

	// ApplicationData: [utenteLoggato, scope:USER_SESSION]
	public static final String APPDATA_UTENTELOGGATO_CODE = "appDatautenteLoggato";

	// ApplicationData: [RicercaIspezioni2018, scope:USER_SESSION]
	public static final String APPDATA_RICERCAISPEZIONI2018_CODE = "appDataRicercaIspezioni2018";

	// ApplicationData: [elencoStatiIspezione, scope:USER_SESSION]
	public static final String APPDATA_ELENCOSTATIISPEZIONE_CODE = "appDataelencoStatiIspezione";

	// ApplicationData: [Ispezione2018, scope:USER_SESSION]
	public static final String APPDATA_ISPEZIONE2018_CODE = "appDataIspezione2018";

	// ApplicationData: [idVerificaSelezionata, scope:USER_SESSION]
	public static final String APPDATA_IDVERIFICASELEZIONATA_CODE = "appDataidVerificaSelezionata";

	// ApplicationData: [idAccertamentoSelezionato, scope:USER_SESSION]
	public static final String APPDATA_IDACCERTAMENTOSELEZIONATO_CODE = "appDataidAccertamentoSelezionato";

	// ApplicationData: [paginaChiamante, scope:USER_SESSION]
	public static final String APPDATA_PAGINACHIAMANTE_CODE = "appDatapaginaChiamante";

	// ApplicationData: [aggiornaDati, scope:USER_SESSION]
	public static final String APPDATA_AGGIORNADATI_CODE = "appDataaggiornaDati";

	// ApplicationData: [elencoProvincePiemonteIstat, scope:USER_SESSION]
	public static final String APPDATA_ELENCOPROVINCEPIEMONTEISTAT_CODE = "appDataelencoProvincePiemonteIstat";

	//////////////////////////////////////////////////////////////////////////////
	/// Metodi associati alla U.I.
	//////////////////////////////////////////////////////////////////////////////

	// nome del content panel associato al bean
	public static final String CPNAME = "cpRisultatoRicercaIspezioni2018";

	/** 
	 * Restituisce il tab correntemente visibile in un determinato tab set
	 */
	private String getCurrentTab(Map session, String tabSetName) {
		String value = (String) session.get(CPNAME + "_" + tabSetName + "_selectedMultiPanel");
		return value;
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo preparaAperturaDettaglioIspezione definito in un ExecCommand del
	 * ContentPanel cpRisultatoRicercaIspezioni2018
	 */
	public ExecResults preparaAperturaDettaglioIspezione(

			it.csi.sigit.sigitwebn.dto.elenco_ispezioni_impianti.CpRisultatoRicercaIspezioni2018Model theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String PREPARAAPERTURADETTAGLIOISPEZIONE_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String PREPARAAPERTURADETTAGLIOISPEZIONE_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-999996748) ENABLED START*/

			try {

				getValidationMgr().checkSelezioneElemento(theModel.getAppDataidIspezioneSelezionato());

				Ispezione2018 ispezioneEsistente = new Ispezione2018();
				ispezioneEsistente.setIdentificativoIspezione(
						ConvertUtil.convertToString(theModel.getAppDataidIspezioneSelezionato()));

				theModel.setAppDataIspezione2018(ispezioneEsistente);

				//				theModel.setAppDataProvenienzaDettaglioIspezione2018("RICERCA");
				theModel.setAppDatapaginaChiamante(Constants.PAG_ELENCO_ISPEZIONI);

				theModel.setAppDataaggiornaDati(Boolean.TRUE);

				result.setResultCode(PREPARAAPERTURADETTAGLIOISPEZIONE_OUTCOME_CODE__OK);

			} catch (ManagerException ex) {

				Validator.gestisciEccezione(result, ex);
			}

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error(
					"[BackEndFacade::preparaAperturaDettaglioIspezione] Errore occorso nell'esecuzione del metodo:" + e,
					e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo preparaDowloadCopertina definito in un ExecCommand del
	 * ContentPanel cpRisultatoRicercaIspezioni2018
	 */
	public ExecResults preparaDowloadCopertina(

			it.csi.sigit.sigitwebn.dto.elenco_ispezioni_impianti.CpRisultatoRicercaIspezioni2018Model theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String PREPARADOWLOADCOPERTINA_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String PREPARADOWLOADCOPERTINA_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R1898942246) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:
			try {
				getValidationMgr().checkSelezioneElemento(theModel.getAppDataidIspezioneSelezionato());
				result.setResultCode(PREPARADOWLOADCOPERTINA_OUTCOME_CODE__OK);
			} catch (ManagerException ex) {

				Validator.gestisciEccezione(result, ex);
			}
			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::preparaDowloadCopertina] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo preparaDownloadLetteraAvviso definito in un ExecCommand del
	 * ContentPanel cpRisultatoRicercaIspezioni2018
	 */
	public ExecResults preparaDownloadLetteraAvviso(

			it.csi.sigit.sigitwebn.dto.elenco_ispezioni_impianti.CpRisultatoRicercaIspezioni2018Model theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String PREPARADOWNLOADLETTERAAVVISO_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String PREPARADOWNLOADLETTERAAVVISO_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R632109844) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			// impostazione del result code
			try {
				getValidationMgr().checkSelezioneElemento(theModel.getAppDataidIspezioneSelezionato());
				result.setResultCode(PREPARADOWNLOADLETTERAAVVISO_OUTCOME_CODE__OK);
			} catch (ManagerException ex) {

				Validator.gestisciEccezione(result, ex);
			}
			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::preparaDownloadLetteraAvviso] Errore occorso nell'esecuzione del metodo:" + e,
					e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo gestisciIndietroRisultatoRicercaIspezioni definito in un ExecCommand del
	 * ContentPanel cpRisultatoRicercaIspezioni2018
	 */
	public ExecResults gestisciIndietroRisultatoRicercaIspezioni(

			it.csi.sigit.sigitwebn.dto.elenco_ispezioni_impianti.CpRisultatoRicercaIspezioni2018Model theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GESTISCIINDIETRORISULTATORICERCAISPEZIONI_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String GESTISCIINDIETRORISULTATORICERCAISPEZIONI_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-1134539915) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			// impostazione del result code 
			result.setResultCode(GESTISCIINDIETRORISULTATORICERCAISPEZIONI_OUTCOME_CODE__OK);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error(
					"[BackEndFacade::gestisciIndietroRisultatoRicercaIspezioni] Errore occorso nell'esecuzione del metodo:"
							+ e,
					e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo isRuoloAbilitato definito in un ExecCommand del
	 * ContentPanel cpRisultatoRicercaIspezioni2018
	 */
	public ExecResults isRuoloAbilitato(

			it.csi.sigit.sigitwebn.dto.elenco_ispezioni_impianti.CpRisultatoRicercaIspezioni2018Model theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String ISRUOLOABILITATO_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-1500219136) ENABLED START*/
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
	 * Implementazione del metodo mostraRisultatoRicercaIspezioni definito in un ExecCommand del
	 * ContentPanel cpRisultatoRicercaIspezioni2018
	 */
	public ExecResults mostraRisultatoRicercaIspezioni(

			it.csi.sigit.sigitwebn.dto.elenco_ispezioni_impianti.CpRisultatoRicercaIspezioni2018Model theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String MOSTRARISULTATORICERCAISPEZIONI_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R196165026) ENABLED START*/
			try {
				if (theModel.getAppDataelencoStatiIspezione() == null
						|| theModel.getAppDataelencoStatiIspezione().isEmpty()) {
					theModel.setAppDataelencoStatiIspezione(getSigitMgr().getElencoStatiISpezione());
				}

				if (theModel.getAppDataelencoProvincePiemonteIstat() == null
						|| theModel.getAppDataelencoProvincePiemonteIstat().isEmpty()) {
					theModel.setAppDataelencoProvincePiemonteIstat(getServiziMgr().getListaIstatProvincePiemonte());
				}

				List<Ispezione2018> listaRisultati = getSigitMgr().findIspezioniByFilter(
						theModel.getAppDataRicercaIspezioni2018(),
						ConvertUtil.convertIdDescriptionsInMap(theModel.getAppDataelencoStatiIspezione()),
						ConvertUtil.convertCodeDescriptionsInMap(theModel.getAppDataelencoProvincePiemonteIstat()));

				theModel.setAppDataElencoIspezioni2018((ArrayList<Ispezione2018>) listaRisultati);

				gestioneMsgRicerca(theModel, result);

				result.setResultCode(MOSTRARISULTATORICERCAISPEZIONI_OUTCOME_CODE__OK);
			} catch (ManagerException ex) {
				Validator.gestisciEccezione(result, ex);
			}

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::mostraRisultatoRicercaIspezioni] Errore occorso nell'esecuzione del metodo:" + e,
					e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	//////////////////////////////////////////////////////////////////////////////
	/// Metodi statici per il reset delle tabelle
	//////////////////////////////////////////////////////////////////////////////

	/**
	 * permette di resettare lo stato di paginazione della tabella widg_tbRisultatiRicerca
	 */
	public static void resetClearStatus_widg_tbRisultatiRicerca(java.util.Map session) {
		session.put("cpRisultatoRicercaIspezioni2018_tbRisultatiRicerca_clearStatus", Boolean.TRUE);
	}

	//////////////////////////////////////////////////////////////////////////////
	/// Property aggiuntive del bean
	//////////////////////////////////////////////////////////////////////////////
	/*PROTECTED REGION ID(R-1252767365) ENABLED START*/
	private SigitMgr sigitMgr;

	public SigitMgr getSigitMgr() {
		return sigitMgr;
	}

	public void setSigitMgr(SigitMgr sigitMgr) {
		this.sigitMgr = sigitMgr;
	}

	private DbMgr dbMgr;

	public DbMgr getDbMgr() {
		return dbMgr;
	}

	public void setDbMgr(DbMgr dbMgr) {
		this.dbMgr = dbMgr;
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

	private void gestioneMsgRicerca(
			it.csi.sigit.sigitwebn.dto.elenco_ispezioni_impianti.CpRisultatoRicercaIspezioni2018Model theModel,
			ExecResults result) throws DbManagerException {
		Integer maxNumRighe = getDbMgr().cercaConfigValueNumerico(Constants.MAX_RIGHE);
		log.debug("MAX num righe da visualizzare = " + maxNumRighe);
		ArrayList<Ispezione2018> risRicIspezione2018List = theModel.getAppDataElencoIspezioni2018();
		if (risRicIspezione2018List != null && risRicIspezione2018List.size() == maxNumRighe)
			result.getGlobalMessages()
					.add(Messages.MSG_RISULTATI_RICERCA.replaceFirst("##value##", maxNumRighe.toString()));
	}

	/*PROTECTED REGION END*/
}
