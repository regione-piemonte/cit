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

/*PROTECTED REGION ID(R452623041) ENABLED START*/
import it.csi.sigit.sigitwebn.business.manager.SigitMgr;
import it.csi.sigit.sigitwebn.business.manager.ConnectorMgr;
import it.csi.sigit.sigitwebn.business.manager.DbMgr;
import it.csi.sigit.sigitwebn.business.manager.util.DbManagerException;
import it.csi.sigit.sigitwebn.business.manager.util.ManagerException;

/*PROTECTED REGION END*/

public class CPBECpBackOffice {

	/**  */
	protected static final Logger log = //NOSONAR  Reason:EIAS 
			Logger.getLogger(Constants.APPLICATION_CODE + ".business"); //NOSONAR  Reason:EIAS

	//////////////////////////////////////////////////////////////////////////////
	/// Costanti identificative degli Application Data
	//////////////////////////////////////////////////////////////////////////////

	// ApplicationData: [utenteLoggato, scope:USER_SESSION]
	public static final String APPDATA_UTENTELOGGATO_CODE = "appDatautenteLoggato";

	// ApplicationData: [elencoCodImpianto, scope:USER_SESSION]
	public static final String APPDATA_ELENCOCODIMPIANTO_CODE = "appDataelencoCodImpianto";

	// ApplicationData: [riepilogoStoricizzazione, scope:USER_SESSION]
	public static final String APPDATA_RIEPILOGOSTORICIZZAZIONE_CODE = "appDatariepilogoStoricizzazione";

	// ApplicationData: [countImpiantiAggiornatiADataAggiornaCoord, scope:USER_SESSION]
	public static final String APPDATA_COUNTIMPIANTIAGGIORNATIADATAAGGIORNACOORD_CODE = "appDatacountImpiantiAggiornatiADataAggiornaCoord";

	// ApplicationData: [countImpiantiSenzaCoordinate, scope:USER_SESSION]
	public static final String APPDATA_COUNTIMPIANTISENZACOORDINATE_CODE = "appDatacountImpiantiSenzaCoordinate";

	//////////////////////////////////////////////////////////////////////////////
	/// Metodi associati alla U.I.
	//////////////////////////////////////////////////////////////////////////////

	// nome del content panel associato al bean
	public static final String CPNAME = "cpBackOffice";

	/** 
	 * Restituisce il tab correntemente visibile in un determinato tab set
	 */
	private String getCurrentTab(Map session, String tabSetName) {
		String value = (String) session.get(CPNAME + "_" + tabSetName + "_selectedMultiPanel");
		return value;
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo gestPulisciLog definito in un ExecCommand del
	 * ContentPanel cpBackOffice
	 */
	public ExecResults gestPulisciLog(

			it.csi.sigit.sigitwebn.dto.back_office.CpBackOfficeModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GESTPULISCILOG_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String GESTPULISCILOG_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R1479846542) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			try {

				getConnectorMgr().storicizzaLog();

				// Riaggiorno i dati
				RiepilogoStoricizzazione riepilogo = theModel.getAppDatariepilogoStoricizzazione();
				getDbMgr().getRecordsLog(riepilogo);
				theModel.setAppDatariepilogoStoricizzazione(riepilogo);

				result.getGlobalMessages().add(Messages.INFO_SALVATAGGIO_CORRETTO);

				// impostazione del result code 
				result.setResultCode(GESTPULISCILOG_OUTCOME_CODE__OK);

			} catch (ManagerException ex) {

				Validator.gestisciEccezione(result, ex);

			}

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::gestPulisciLog] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo gestStoricizzaLibretti definito in un ExecCommand del
	 * ContentPanel cpBackOffice
	 */
	public ExecResults gestStoricizzaLibretti(

			it.csi.sigit.sigitwebn.dto.back_office.CpBackOfficeModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GESTSTORICIZZALIBRETTI_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String GESTSTORICIZZALIBRETTI_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R1358727732) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			try {

				getConnectorMgr().storicizzaLibretti();

				// Riaggiorno i dati
				RiepilogoStoricizzazione riepilogo = theModel.getAppDatariepilogoStoricizzazione();
				getDbMgr().getRecordsLibretti(riepilogo);
				theModel.setAppDatariepilogoStoricizzazione(riepilogo);

				result.getGlobalMessages().add(Messages.INFO_SALVATAGGIO_CORRETTO);

				// impostazione del result code 
				result.setResultCode(GESTSTORICIZZALIBRETTI_OUTCOME_CODE__OK);

			} catch (ManagerException ex) {

				Validator.gestisciEccezione(result, ex);

			}

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::gestStoricizzaLibretti] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo gestStoricizzaLogAccesso definito in un ExecCommand del
	 * ContentPanel cpBackOffice
	 */
	public ExecResults gestStoricizzaLogAccesso(

			it.csi.sigit.sigitwebn.dto.back_office.CpBackOfficeModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GESTSTORICIZZALOGACCESSO_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String GESTSTORICIZZALOGACCESSO_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-1334286978) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			try {

				getConnectorMgr().storicizzaLogAccesso();

				// Riaggiorno i dati
				RiepilogoStoricizzazione riepilogo = theModel.getAppDatariepilogoStoricizzazione();
				getDbMgr().getRecordsLogAccesso(riepilogo);
				theModel.setAppDatariepilogoStoricizzazione(riepilogo);

				result.getGlobalMessages().add(Messages.INFO_SALVATAGGIO_CORRETTO);

				// impostazione del result code 
				result.setResultCode(GESTSTORICIZZALOGACCESSO_OUTCOME_CODE__OK);
			} catch (ManagerException ex) {
				Validator.gestisciEccezione(result, ex);
			}

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::gestStoricizzaLogAccesso] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo gestAbilitazioni definito in un ExecCommand del
	 * ContentPanel cpBackOffice
	 */
	public ExecResults gestAbilitazioni(

			it.csi.sigit.sigitwebn.dto.back_office.CpBackOfficeModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GESTABILITAZIONI_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String GESTABILITAZIONI_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-1779041678) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			// impostazione del result code 
			result.setResultCode(GESTABILITAZIONI_OUTCOME_CODE__OK);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::gestAbilitazioni] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo gestSubentro definito in un ExecCommand del
	 * ContentPanel cpBackOffice
	 */
	public ExecResults gestSubentro(

			it.csi.sigit.sigitwebn.dto.back_office.CpBackOfficeModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GESTSUBENTRO_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String GESTSUBENTRO_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R435127859) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			// impostazione del result code 
			result.setResultCode(GESTSUBENTRO_OUTCOME_CODE__OK);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::gestSubentro] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo gestAggiornamentoCoordinate definito in un ExecCommand del
	 * ContentPanel cpBackOffice
	 */
	public ExecResults gestAggiornamentoCoordinate(

			it.csi.sigit.sigitwebn.dto.back_office.CpBackOfficeModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GESTAGGIORNAMENTOCOORDINATE_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-1725968334) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:
			getSigitMgr().aggiornaCoordinateImpianti();
			aggiornaCountCoordinate(theModel);
			// impostazione del result code 
			result.getGlobalMessages().add(Messages.INFO_SALVATAGGIO_CORRETTO);
			result.setResultCode(GESTAGGIORNAMENTOCOORDINATE_OUTCOME_CODE__OK);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::gestAggiornamentoCoordinate] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo isRuoloAbilitato definito in un ExecCommand del
	 * ContentPanel cpBackOffice
	 */
	public ExecResults isRuoloAbilitato(

			it.csi.sigit.sigitwebn.dto.back_office.CpBackOfficeModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String ISRUOLOABILITATO_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R1605877842) ENABLED START*/
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
	 * Implementazione del metodo inizializzaElencoRecord definito in un ExecCommand del
	 * ContentPanel cpBackOffice
	 */
	public ExecResults inizializzaElencoRecord(

			it.csi.sigit.sigitwebn.dto.back_office.CpBackOfficeModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String INIZIALIZZAELENCORECORD_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String INIZIALIZZAELENCORECORD_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R641835195) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			RiepilogoStoricizzazione riepilogo = new RiepilogoStoricizzazione();

			getDbMgr().getRecordsLog(riepilogo);
			getDbMgr().getRecordsLibretti(riepilogo);
			getDbMgr().getRecordsLogAccesso(riepilogo);
			theModel.setAppDatariepilogoStoricizzazione(riepilogo);

			aggiornaCountCoordinate(theModel);

			// impostazione del result code 
			result.setResultCode(INIZIALIZZAELENCORECORD_OUTCOME_CODE__OK);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::inizializzaElencoRecord] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	//////////////////////////////////////////////////////////////////////////////
	/// Metodi statici per il reset delle tabelle
	//////////////////////////////////////////////////////////////////////////////

	//////////////////////////////////////////////////////////////////////////////
	/// Property aggiuntive del bean
	//////////////////////////////////////////////////////////////////////////////
	/*PROTECTED REGION ID(R-1622678701) ENABLED START*/
	//// inserire qui le property che si vogliono iniettare in questo bean (es. dao, proxy di pd, ...)

	private SigitMgr sigitMgr;
	private ConnectorMgr connectorMgr;
	private DbMgr dbMgr;

	public DbMgr getDbMgr() {
		return dbMgr;
	}

	public void setDbMgr(DbMgr dbMgr) {
		this.dbMgr = dbMgr;
	}

	public SigitMgr getSigitMgr() {
		return sigitMgr;
	}

	public void setSigitMgr(SigitMgr sigitMgr) {
		this.sigitMgr = sigitMgr;
	}

	public ConnectorMgr getConnectorMgr() {
		return connectorMgr;
	}

	public void setConnectorMgr(ConnectorMgr connectorMgr) {
		this.connectorMgr = connectorMgr;
	}

	private void aggiornaCountCoordinate(it.csi.sigit.sigitwebn.dto.back_office.CpBackOfficeModel theModel)
			throws DbManagerException {
		Integer countImpiantiSenzaCoordinate = getDbMgr().getRecordsImpiantiSenzaCoordinate();

		String dataAggiornaCoord = getDbMgr().cercaConfigValue(Constants.CHIAVE_CONFIG_DATA_AGGIORNAMENTO_COORDINATE)
				.getValoreConfigChar();

		Integer countImpiantiAggiornatiAData = getDbMgr().getRecordsImpiantiAggiornatiAData(dataAggiornaCoord);

		theModel.setAppDatacountImpiantiSenzaCoordinate(countImpiantiSenzaCoordinate);

		theModel.setAppDatacountImpiantiAggiornatiADataAggiornaCoord(
				dataAggiornaCoord + " " + countImpiantiAggiornatiAData);
	}
	/*PROTECTED REGION END*/
}
