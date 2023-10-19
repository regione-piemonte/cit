package it.csi.sigit.elencom.business.ricerca_module;

import java.util.*;

import it.csi.sigit.elencom.business.dao.elencom.exceptions.OdVistaDettaglioImpiantiDaoException;
import it.csi.sigit.elencom.dto.*;
import it.csi.sigit.elencom.dto.common.*;
import it.csi.sigit.elencom.dto.ricercamanutentoretns.*;

import org.apache.log4j.*;
import it.csi.sigit.elencom.util.*;
import it.csi.sigit.elencom.business.*;

/*PROTECTED REGION ID(R1731366140) ENABLED START*/
import it.csi.sigit.elencom.business.manager.ElencoManager;
/*PROTECTED REGION END*/

public class CPBECpDettWMS {

	/**  */
	protected static final Logger log = //NOSONAR  Reason:EIAS 
			Logger.getLogger(Constants.APPLICATION_CODE + ".business"); //NOSONAR  Reason:EIAS

	//////////////////////////////////////////////////////////////////////////////
	/// Costanti identificative degli Application Data
	//////////////////////////////////////////////////////////////////////////////

	// ApplicationData: [currentDettaglioGeografico, scope:USER_SESSION]
	public static final String APPDATA_CURRENTDETTAGLIOGEOGRAFICO_CODE = "appDatacurrentDettaglioGeografico";

	// ApplicationData: [listDettaglioGeografico, scope:USER_SESSION]
	public static final String APPDATA_LISTDETTAGLIOGEOGRAFICO_CODE = "appDatalistDettaglioGeografico";

	// ApplicationData: [paginaSelezionata, scope:USER_SESSION]
	public static final String APPDATA_PAGINASELEZIONATA_CODE = "appDatapaginaSelezionata";

	// ApplicationData: [WMSComp, scope:USER_SESSION]
	public static final String APPDATA_WMSCOMP_CODE = "appDataWMSComp";

	// ApplicationData: [WMSCoordinates, scope:USER_SESSION]
	public static final String APPDATA_WMSCOORDINATES_CODE = "appDataWMSCoordinates";

	//////////////////////////////////////////////////////////////////////////////
	/// Metodi associati alla U.I.
	//////////////////////////////////////////////////////////////////////////////

	// nome del content panel associato al bean
	public static final String CPNAME = "cpDettWMS";

	public static final String MULTIPANEL_MULTIDATAPANEL = "multiDataPanel";
	public static final String MPI_MULTIDATAPANEL_FPDATI = CPNAME + "_" + MULTIPANEL_MULTIDATAPANEL + "_" + "fpDati";
	public static final String MPI_MULTIDATAPANEL_FPMESSAGGIO = CPNAME + "_" + MULTIPANEL_MULTIDATAPANEL + "_"
			+ "fpMessaggio";

	/** 
	 * Restituisce il tab correntemente visibile in un determinato tab set
	 */
	private String getCurrentTab(Map session, String tabSetName) {
		String value = (String) session.get(CPNAME + "_" + tabSetName + "_selectedMultiPanel");
		return value;
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo gestisciSuccessivo definito in un ExecCommand del
	 * ContentPanel cpDettWMS
	 */
	public ExecResults gestisciSuccessivo(

			it.csi.sigit.elencom.dto.ricerca_module.CpDettWMSModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GESTISCISUCCESSIVO_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String GESTISCISUCCESSIVO_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		final String GESTISCISUCCESSIVO_OUTCOME_CODE__OK_ULTIMO = //NOSONAR  Reason:EIAS
				"OK_ULTIMO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R1586539409) ENABLED START*/
			ArrayList<DettaglioGeograficoPortale> list = theModel.getAppDatalistDettaglioGeografico();
			Integer paginaSelez = theModel.getAppDatapaginaSelezionata();
			paginaSelez++;
			if ((list.size() - 1) == paginaSelez) {
				result.setResultCode(GESTISCISUCCESSIVO_OUTCOME_CODE__OK_ULTIMO);
				theModel.setAppDatacurrentDettaglioGeografico(list.get(paginaSelez));
				theModel.setAppDatapaginaSelezionata(paginaSelez);
			} else if (list.size() - 1 < paginaSelez) {
				result.setResultCode(GESTISCISUCCESSIVO_OUTCOME_CODE__KO);
			} else {
				theModel.setAppDatacurrentDettaglioGeografico(list.get(paginaSelez));
				theModel.setAppDatapaginaSelezionata(paginaSelez);
				result.setResultCode(GESTISCISUCCESSIVO_OUTCOME_CODE__OK);
			}
			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::gestisciSuccessivo] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo gestisciPrecedente definito in un ExecCommand del
	 * ContentPanel cpDettWMS
	 */
	public ExecResults gestisciPrecedente(

			it.csi.sigit.elencom.dto.ricerca_module.CpDettWMSModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GESTISCIPRECEDENTE_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String GESTISCIPRECEDENTE_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		final String GESTISCIPRECEDENTE_OUTCOME_CODE__OK_PRIMO = //NOSONAR  Reason:EIAS
				"OK_PRIMO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-1461166665) ENABLED START*/
			ArrayList<DettaglioGeograficoPortale> list = theModel.getAppDatalistDettaglioGeografico();
			Integer paginaSelez = theModel.getAppDatapaginaSelezionata();
			paginaSelez--;
			log.info(paginaSelez);
			log.info(list.size());
			log.info(paginaSelez == 0);
			if (paginaSelez == 0) {
				result.setResultCode(GESTISCIPRECEDENTE_OUTCOME_CODE__OK_PRIMO);
				theModel.setAppDatacurrentDettaglioGeografico(list.get(paginaSelez));
				theModel.setAppDatapaginaSelezionata(paginaSelez);
			} else if (paginaSelez < 0) {
				result.setResultCode(GESTISCIPRECEDENTE_OUTCOME_CODE__KO);
			} else {
				theModel.setAppDatacurrentDettaglioGeografico(list.get(paginaSelez));
				theModel.setAppDatapaginaSelezionata(paginaSelez);
				result.setResultCode(GESTISCIPRECEDENTE_OUTCOME_CODE__OK);
			}
			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::gestisciPrecedente] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo clearFields definito in un ExecCommand del
	 * ContentPanel cpDettWMS
	 */
	public ExecResults clearFields(

			it.csi.sigit.elencom.dto.ricerca_module.CpDettWMSModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String CLEARFIELDS_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-2083137581) ENABLED START*/
			DettaglioGeograficoPortale dto = new DettaglioGeograficoPortale();
			dto.setImpianto(null);
			dto.setUbicazione(null);
			dto.setPotClimaEst(null);
			dto.setPotClimaInv(null);
			dto.setComponente(null);
			dto.setVolRaffM3(null);
			dto.setVolRiscM3(null);
			theModel.setAppDatalistDettaglioGeografico(null);
			theModel.setAppDatacurrentDettaglioGeografico(dto);
			result.setResultCode(CLEARFIELDS_OUTCOME_CODE__OK);
			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".
			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::clearFields] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo visualizzaInterrogazioneGeoportale definito in un ExecCommand del
	 * ContentPanel cpDettWMS
	 */
	public ExecResults visualizzaInterrogazioneGeoportale(

			it.csi.sigit.elencom.dto.ricerca_module.CpDettWMSModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String VISUALIZZAINTERROGAZIONEGEOPORTALE_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String VISUALIZZAINTERROGAZIONEGEOPORTALE_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		final String VISUALIZZAINTERROGAZIONEGEOPORTALE_OUTCOME_CODE__OK_SINGOLO = //NOSONAR  Reason:EIAS
				"OK_SINGOLO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-36544421) ENABLED START*/
			String[] coordinates = theModel.getAppDataWMSCoordinates().split(";");
			// impostazione del result code
			if (theModel.getAppDataWMSComp() != null) {
				ArrayList<DettaglioGeograficoPortale> dettagli = getElencoManager()
						.getDettaglioGeoportale(coordinates[0], coordinates[1], theModel.getAppDataWMSComp());
				if (dettagli != null && dettagli.size() != 0) {
					theModel.setAppDatalistDettaglioGeografico(dettagli);
					theModel.setAppDatacurrentDettaglioGeografico(dettagli.get(0));
					theModel.setAppDatapaginaSelezionata(0);
					if (dettagli.size() == 1) {
						log.debug("-----------OK SINGOLO-------------");
						result.setResultCode(VISUALIZZAINTERROGAZIONEGEOPORTALE_OUTCOME_CODE__OK_SINGOLO);
					} else {
						log.debug("-----------OK-------------");
						result.setResultCode(VISUALIZZAINTERROGAZIONEGEOPORTALE_OUTCOME_CODE__OK);
					}
				} else {
					log.debug("-----------KO-------------");
					result.getGlobalMessages().add("Nessun elemento trovato");
					result.setResultCode(VISUALIZZAINTERROGAZIONEGEOPORTALE_OUTCOME_CODE__KO);
				}

			}
			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::visualizzaInterrogazioneGeoportale] Errore occorso nell'esecuzione del metodo:"
					+ e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo checkAppdata definito in un ExecCommand del
	 * ContentPanel cpDettWMS
	 */
	public ExecResults checkAppdata(

			it.csi.sigit.elencom.dto.ricerca_module.CpDettWMSModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String CHECKAPPDATA_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String CHECKAPPDATA_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R2013256316) ENABLED START*/
			if (theModel.getAppDatalistDettaglioGeografico() != null)
				result.setResultCode(CHECKAPPDATA_OUTCOME_CODE__OK);
			else
				result.setResultCode(CHECKAPPDATA_OUTCOME_CODE__KO);
			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::checkAppdata] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo refreshInterrogazioneGeoportale definito in un ExecCommand del
	 * ContentPanel cpDettWMS
	 */
	public ExecResults refreshInterrogazioneGeoportale(

			it.csi.sigit.elencom.dto.ricerca_module.CpDettWMSModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String REFRESHINTERROGAZIONEGEOPORTALE_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String REFRESHINTERROGAZIONEGEOPORTALE_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		final String REFRESHINTERROGAZIONEGEOPORTALE_OUTCOME_CODE__OK_SINGOLO = //NOSONAR  Reason:EIAS
				"OK_SINGOLO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-1638875342) ENABLED START*/
			String[] coordinates = theModel.getAppDataWMSCoordinates().split(";");
			// impostazione del result code
			if (theModel.getAppDataWMSComp() != null) {
				ArrayList<DettaglioGeograficoPortale> dettagli = getElencoManager()
						.getDettaglioGeoportale(coordinates[0], coordinates[1], theModel.getAppDataWMSComp());
				if (dettagli != null && dettagli.size() != 0) {
					theModel.setAppDatalistDettaglioGeografico(dettagli);
					theModel.setAppDatacurrentDettaglioGeografico(dettagli.get(0));
					theModel.setAppDatapaginaSelezionata(0);
					if (dettagli.size() == 1) {
						log.debug("-----------OK SINGOLO-------------");
						result.setResultCode(REFRESHINTERROGAZIONEGEOPORTALE_OUTCOME_CODE__OK_SINGOLO);
					} else {
						log.debug("-----------OK-------------");
						result.setResultCode(REFRESHINTERROGAZIONEGEOPORTALE_OUTCOME_CODE__OK);
					}
				} else {
					log.debug("-----------KO-------------");
					result.getGlobalMessages().add("Nessun elemento trovato");
					result.setResultCode(REFRESHINTERROGAZIONEGEOPORTALE_OUTCOME_CODE__KO);
				}

			}
			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::refreshInterrogazioneGeoportale] Errore occorso nell'esecuzione del metodo:" + e,
					e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	//////////////////////////////////////////////////////////////////////////////
	/// Metodi statici per il reset delle tabelle
	//////////////////////////////////////////////////////////////////////////////

	//////////////////////////////////////////////////////////////////////////////
	/// Property aggiuntive del bean
	//////////////////////////////////////////////////////////////////////////////
	/*PROTECTED REGION ID(R1820169074) ENABLED START*/
	//// inserire qui le property che si vogliono iniettare in questo bean (es. dao, proxy di pd, ...)
	ElencoManager elencoManager = null;

	public ElencoManager getElencoManager() {
		return elencoManager;
	}

	public void setElencoManager(ElencoManager elencoManager) {
		this.elencoManager = elencoManager;
	}
	/*PROTECTED REGION END*/
}
