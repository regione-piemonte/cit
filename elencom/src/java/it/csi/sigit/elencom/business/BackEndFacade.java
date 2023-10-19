package it.csi.sigit.elencom.business;

import java.util.*;

import it.csi.sigit.elencom.dto.*;

import org.apache.log4j.*;
import it.csi.sigit.elencom.util.*;

/*PROTECTED REGION ID(R-1534196706) ENABLED START*/
import it.csi.sigit.elencom.business.manager.ElencoManager;
import it.csi.sigit.elencom.dto.ricercamanutentoretns.CodiceDescrizione;
/*PROTECTED REGION END*/

public class BackEndFacade {

	/**  */
	protected static final Logger log = //NOSONAR  Reason:EIAS 
			Logger.getLogger(Constants.APPLICATION_CODE + ".business"); //NOSONAR  Reason:EIAS

	//////////////////////////////////////////////////////////////////////////////
	/// Costanti identificative degli Application Data
	//////////////////////////////////////////////////////////////////////////////

	// ApplicationData: [currentUser, scope:USER_SESSION]
	public static final String APPDATA_CURRENTUSER_CODE = "appDatacurrentUser";

	// ApplicationData: [TreeStatus, scope:USER_SESSION]
	public static final String APPDATA_TREESTATUS_CODE = "appDataTreeStatus";

	// ApplicationData: [crumbs, scope:USER_SESSION]
	public static final String APPDATA_CRUMBS_CODE = "appDatacrumbs";

	// ApplicationData: [WMSCoordinates, scope:USER_SESSION]
	public static final String APPDATA_WMSCOORDINATES_CODE = "appDataWMSCoordinates";

	// ApplicationData: [WMSComp, scope:USER_SESSION]
	public static final String APPDATA_WMSCOMP_CODE = "appDataWMSComp";

	// ApplicationData: [listDettaglioGeografico, scope:USER_SESSION]
	public static final String APPDATA_LISTDETTAGLIOGEOGRAFICO_CODE = "appDatalistDettaglioGeografico";

	// ApplicationData: [currentDettaglioGeografico, scope:USER_SESSION]
	public static final String APPDATA_CURRENTDETTAGLIOGEOGRAFICO_CODE = "appDatacurrentDettaglioGeografico";

	// ApplicationData: [paginaSelezionata, scope:USER_SESSION]
	public static final String APPDATA_PAGINASELEZIONATA_CODE = "appDatapaginaSelezionata";

	// ApplicationData: [manutentoreAppData, scope:USER_SESSION]
	public static final String APPDATA_MANUTENTOREAPPDATA_CODE = "appDatamanutentoreAppData";

	// ApplicationData: [filtroManutentore, scope:USER_SESSION]
	public static final String APPDATA_FILTROMANUTENTORE_CODE = "appDatafiltroManutentore";

	// ApplicationData: [comboProvince, scope:USER_SESSION]
	public static final String APPDATA_COMBOPROVINCE_CODE = "appDatacomboProvince";

	// ApplicationData: [comboComuni, scope:USER_SESSION]
	public static final String APPDATA_COMBOCOMUNI_CODE = "appDatacomboComuni";

	// ApplicationData: [manutentoriAppData, scope:USER_SESSION]
	public static final String APPDATA_MANUTENTORIAPPDATA_CODE = "appDatamanutentoriAppData";

	// ApplicationData: [idManutentoreSelezionato, scope:USER_SESSION]
	public static final String APPDATA_IDMANUTENTORESELEZIONATO_CODE = "appDataidManutentoreSelezionato";

	// ApplicationData: [UrlHome, scope:USER_SESSION]
	public static final String APPDATA_URLHOME_CODE = "appDataUrlHome";

	// ApplicationData: [elencoCorsi, scope:USER_SESSION]
	public static final String APPDATA_ELENCOCORSI_CODE = "appDataelencoCorsi";

	//////////////////////////////////////////////////////////////////////////////
	/// Metodi associati alla U.I.
	/// - i metodi relativi a menu e azioni di inizializzazione sono direttamente 
	///   implementati in questa classe
	/// - i metodi relativi ai singoli content panel sono delegati nei rispettivi
	///   bean
	//////////////////////////////////////////////////////////////////////////////

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo LoadComuni utilizzato in un ExecCommand
	 * del ContentPanel cpRicerca
	 */
	public ExecResults LoadComuni(

			it.csi.sigit.elencom.dto.ricerca_module.CpRicercaModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpRicerca
		return getCPBECpRicerca().LoadComuni(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo recepisciDettWMS utilizzato in un ExecCommand
	 * del ContentPanel cpRicerca
	 */
	public ExecResults recepisciDettWMS(

			it.csi.sigit.elencom.dto.ricerca_module.CpRicercaModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpRicerca
		return getCPBECpRicerca().recepisciDettWMS(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo caricaManutentori utilizzato in un ExecCommand
	 * del ContentPanel cpRicerca
	 */
	public ExecResults caricaManutentori(

			it.csi.sigit.elencom.dto.ricerca_module.CpRicercaModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpRicerca
		return getCPBECpRicerca().caricaManutentori(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo apriDettaglio utilizzato in un ExecCommand
	 * del ContentPanel cpRicerca
	 */
	public ExecResults apriDettaglio(

			it.csi.sigit.elencom.dto.ricerca_module.CpRicercaModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpRicerca
		return getCPBECpRicerca().apriDettaglio(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo gestioneIngresso utilizzato in un ExecCommand
	 * del ContentPanel cpRicerca
	 */
	public ExecResults gestioneIngresso(

			it.csi.sigit.elencom.dto.ricerca_module.CpRicercaModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpRicerca
		return getCPBECpRicerca().gestioneIngresso(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo gestisciSuccessivo utilizzato in un ExecCommand
	 * del ContentPanel cpDettWMS
	 */
	public ExecResults gestisciSuccessivo(

			it.csi.sigit.elencom.dto.ricerca_module.CpDettWMSModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpDettWMS
		return getCPBECpDettWMS().gestisciSuccessivo(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo gestisciPrecedente utilizzato in un ExecCommand
	 * del ContentPanel cpDettWMS
	 */
	public ExecResults gestisciPrecedente(

			it.csi.sigit.elencom.dto.ricerca_module.CpDettWMSModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpDettWMS
		return getCPBECpDettWMS().gestisciPrecedente(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo clearFields utilizzato in un ExecCommand
	 * del ContentPanel cpDettWMS
	 */
	public ExecResults clearFields(

			it.csi.sigit.elencom.dto.ricerca_module.CpDettWMSModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpDettWMS
		return getCPBECpDettWMS().clearFields(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo visualizzaInterrogazioneGeoportale utilizzato in un ExecCommand
	 * del ContentPanel cpDettWMS
	 */
	public ExecResults visualizzaInterrogazioneGeoportale(

			it.csi.sigit.elencom.dto.ricerca_module.CpDettWMSModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpDettWMS
		return getCPBECpDettWMS().visualizzaInterrogazioneGeoportale(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo checkAppdata utilizzato in un ExecCommand
	 * del ContentPanel cpDettWMS
	 */
	public ExecResults checkAppdata(

			it.csi.sigit.elencom.dto.ricerca_module.CpDettWMSModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpDettWMS
		return getCPBECpDettWMS().checkAppdata(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo refreshInterrogazioneGeoportale utilizzato in un ExecCommand
	 * del ContentPanel cpDettWMS
	 */
	public ExecResults refreshInterrogazioneGeoportale(

			it.csi.sigit.elencom.dto.ricerca_module.CpDettWMSModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpDettWMS
		return getCPBECpDettWMS().refreshInterrogazioneGeoportale(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo GoMenu definito in un ExecCommand del
	 * ContentPanel 
	 */
	public ExecResults GoMenu(

			it.csi.sigit.elencom.dto.GlobalMenuModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GOMENU_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"Ok"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R257452533) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			String header = "GoMenu==>.";
			log.debug(header + "inizio");

			// impostazione del result code
			result.setResultCode("Ok");
			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".
			log.debug(header + "UrlHome =" + getElencoManager().getUrlHome());

			theModel.setAppDataUrlHome(getElencoManager().getUrlHome());

			result.setModel(theModel);
			log.debug(header + "fine");
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::GoMenu] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo initApplicativo definito in un ExecCommand del
	 * ContentPanel 
	 */
	public ExecResults initApplicativo(

			it.csi.sigit.elencom.dto.GlobalHomeModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String INITAPPLICATIVO_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"Ok"; //NOSONAR  Reason:EIAS
		final String INITAPPLICATIVO_OUTCOME_CODE__WMS = //NOSONAR  Reason:EIAS
				"WMS"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-544167614) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			if (theModel.getWms() != null) {
				if (theModel.getAppDataWMSCoordinates() == null && theModel.getAppDataWMSComp() == null) {
					log.debug("appdata null");
					theModel.setAppDataWMSCoordinates(theModel.getWms());
					theModel.setAppDataWMSComp(theModel.getComp());
				} else if ((!theModel.getAppDataWMSCoordinates().equals(theModel.getWms()))
						|| (!theModel.getAppDataWMSComp().equals(theModel.getComp()))) {
					log.debug("DIVERSI");
					theModel.setAppDatacurrentDettaglioGeografico(null);
					theModel.setAppDatalistDettaglioGeografico(null);
					theModel.setAppDataWMSCoordinates(theModel.getWms());
					theModel.setAppDataWMSComp(theModel.getComp());
				}
				result.setResultCode(INITAPPLICATIVO_OUTCOME_CODE__WMS);
			} else {
				String header = "initApplicativo==>.";
				log.debug(header + "inizio");
				it.csi.sigit.elencom.dto.ricercamanutentoretns.FiltroManutentore filtro = new it.csi.sigit.elencom.dto.ricercamanutentoretns.FiltroManutentore();

				if (theModel.getAppDatafiltroManutentore() == null) {
					log.debug(header + "setto il filtro a vuoto");
					theModel.setAppDatafiltroManutentore(filtro);
					theModel.setAppDatacomboProvince(getElencoManager().getListaProvince());
					log.debug(header + "setto a null la comboComuni");
					theModel.setAppDatacomboComuni(new ArrayList<CodiceDescrizione>());

				}
				log.debug(" azzero la tabella!! ");
				resetClearStatus_widg_tRicerca(theModel.getSession());

				// impostazione del result code
				result.setResultCode(INITAPPLICATIVO_OUTCOME_CODE__OK);
				// modifica degli attributi del model (che verranno propagati allo strato
			}
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::initApplicativo] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	//////////////////////////////////////////////////////////////////////////////
	/// Property relative ai bean spring associati agli specifici content panel
	//////////////////////////////////////////////////////////////////////////////

	/**
	 * riferimento al CPBE del content panel cpRicerca
	 */
	private it.csi.sigit.elencom.business.ricerca_module.CPBECpRicerca cPBECpRicerca = null;

	/**
	 * riferimento al CPBE del content panel cpRicerca
	 */
	public void setCPBECpRicerca(it.csi.sigit.elencom.business.ricerca_module.CPBECpRicerca bean) {
		this.cPBECpRicerca = bean;
	}

	/**
	 * riferimento al CPBE del content panel cpRicerca
	 */
	public it.csi.sigit.elencom.business.ricerca_module.CPBECpRicerca getCPBECpRicerca() {
		return this.cPBECpRicerca;
	}

	/**
	 * riferimento al CPBE del content panel cpDettWMS
	 */
	private it.csi.sigit.elencom.business.ricerca_module.CPBECpDettWMS cPBECpDettWMS = null;

	/**
	 * riferimento al CPBE del content panel cpDettWMS
	 */
	public void setCPBECpDettWMS(it.csi.sigit.elencom.business.ricerca_module.CPBECpDettWMS bean) {
		this.cPBECpDettWMS = bean;
	}

	/**
	 * riferimento al CPBE del content panel cpDettWMS
	 */
	public it.csi.sigit.elencom.business.ricerca_module.CPBECpDettWMS getCPBECpDettWMS() {
		return this.cPBECpDettWMS;
	}

	//////////////////////////////////////////////////////////////////////////////
	/// Property aggiuntive del bean
	//////////////////////////////////////////////////////////////////////////////
	/*PROTECTED REGION ID(R-1264235389) ENABLED START*/
	//// inserire qui le property che si vogliono iniettare in questo bean (es. dao, proxy di pd, ...) 

	//////////////////////////////////////////////////////////////////////////////
	/// Metodi statici per il reset delle tabelle
	//////////////////////////////////////////////////////////////////////////////

	public static void resetClearStatus_widg_tRicerca(java.util.Map session) {
		session.put("cpRicerca_tRicerca_clearStatus", Boolean.TRUE);

	}

	ElencoManager elencoManager = null;

	public ElencoManager getElencoManager() {
		return elencoManager;
	}

	public void setElencoManager(ElencoManager elencoManager) {
		this.elencoManager = elencoManager;
	}
	/*PROTECTED REGION END*/
}
