package it.csi.sigit.elencom.business.ricerca_module;

import java.util.*;

import it.csi.sigit.elencom.dto.*;
import it.csi.sigit.elencom.dto.common.*;
import it.csi.sigit.elencom.dto.ricercamanutentoretns.*;

import org.apache.log4j.*;
import it.csi.sigit.elencom.util.*;
import it.csi.sigit.elencom.business.*;

/*PROTECTED REGION ID(R-2044612447) ENABLED START*/
import it.csi.sigit.elencom.business.manager.ElencoManager;
import it.csi.sigit.elencom.dto.ricercamanutentoretns.CodiceDescrizione;
import it.csi.sigit.elencom.dto.ricercamanutentoretns.Corso;
import it.csi.sigit.elencom.dto.ricercamanutentoretns.FiltroManutentore;
import it.csi.sigit.elencom.dto.ricercamanutentoretns.Manutentore;

import org.apache.commons.lang.StringUtils;

/*PROTECTED REGION END*/

public class CPBECpRicerca {

	/**  */
	protected static final Logger log = //NOSONAR  Reason:EIAS 
			Logger.getLogger(Constants.APPLICATION_CODE + ".business"); //NOSONAR  Reason:EIAS

	//////////////////////////////////////////////////////////////////////////////
	/// Costanti identificative degli Application Data
	//////////////////////////////////////////////////////////////////////////////

	// ApplicationData: [crumbs, scope:USER_SESSION]
	public static final String APPDATA_CRUMBS_CODE = "appDatacrumbs";

	// ApplicationData: [currentUser, scope:USER_SESSION]
	public static final String APPDATA_CURRENTUSER_CODE = "appDatacurrentUser";

	// ApplicationData: [TreeStatus, scope:USER_SESSION]
	public static final String APPDATA_TREESTATUS_CODE = "appDataTreeStatus";

	// ApplicationData: [comboComuni, scope:USER_SESSION]
	public static final String APPDATA_COMBOCOMUNI_CODE = "appDatacomboComuni";

	// ApplicationData: [comboProvince, scope:USER_SESSION]
	public static final String APPDATA_COMBOPROVINCE_CODE = "appDatacomboProvince";

	// ApplicationData: [filtroManutentore, scope:USER_SESSION]
	public static final String APPDATA_FILTROMANUTENTORE_CODE = "appDatafiltroManutentore";

	// ApplicationData: [manutentoreAppData, scope:USER_SESSION]
	public static final String APPDATA_MANUTENTOREAPPDATA_CODE = "appDatamanutentoreAppData";

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
	//////////////////////////////////////////////////////////////////////////////

	// nome del content panel associato al bean
	public static final String CPNAME = "cpRicerca";

	public static final String MULTIPANEL_MPMANU = "mpManu";
	public static final String MPI_MPMANU_FPTAB = CPNAME + "_" + MULTIPANEL_MPMANU + "_" + "fpTab";
	public static final String MULTIPANEL_MPDETTMANU = "mpDettManu";
	public static final String MPI_MPDETTMANU_FPCORSI = CPNAME + "_" + MULTIPANEL_MPDETTMANU + "_" + "fpCorsi";

	/** 
	 * Restituisce il tab correntemente visibile in un determinato tab set
	 */
	private String getCurrentTab(Map session, String tabSetName) {
		String value = (String) session.get(CPNAME + "_" + tabSetName + "_selectedMultiPanel");
		return value;
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo LoadComuni definito in un ExecCommand del
	 * ContentPanel cpRicerca
	 */
	public ExecResults LoadComuni(

			it.csi.sigit.elencom.dto.ricerca_module.CpRicercaModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String LOADCOMUNI_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"Ok"; //NOSONAR  Reason:EIAS
		final String LOADCOMUNI_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"Ko"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-1588855003) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:
			String header = "LoadComuni - ";
			log.debug(header + "inizio");

			// impostazione del result code
			result.setResultCode(LOADCOMUNI_OUTCOME_CODE__OK);
			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			String input = theModel.getAppDatafiltroManutentore().getProvincia();
			log.debug(" provincia  =" + input);

			theModel.setAppDatacomboComuni(getElencoManager().getListaComuni(input));

			//theModel.setAppDatacomboComuni(new ArrayList<CodiceDescrizione>());
			log.debug(" azzero la tabella!! ");

			theModel.setAppDatamanutentoriAppData(new ArrayList<Manutentore>());
			log.debug(" fine ");

			result.setModel(theModel);
			log.debug(header + "fine");
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::LoadComuni] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo recepisciDettWMS definito in un ExecCommand del
	 * ContentPanel cpRicerca
	 */
	public ExecResults recepisciDettWMS(

			it.csi.sigit.elencom.dto.ricerca_module.CpRicercaModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String RECEPISCIDETTWMS_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-1258631671) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			// impostazione del result code 
			result.setResultCode(RECEPISCIDETTWMS_OUTCOME_CODE__OK);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::recepisciDettWMS] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo caricaManutentori definito in un ExecCommand del
	 * ContentPanel cpRicerca
	 */
	public ExecResults caricaManutentori(

			it.csi.sigit.elencom.dto.ricerca_module.CpRicercaModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String CARICAMANUTENTORI_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String CARICAMANUTENTORI_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R272914269) ENABLED START*/

			log.debug("caricamento elenco persone giuridiche");
			try {
				FiltroManutentore filtroManutentore = theModel.getAppDatafiltroManutentore();
				if (StringUtils.isEmpty(filtroManutentore.getProvincia())
						&& StringUtils.isEmpty(filtroManutentore.getDenominazione())) {
					log.debug("filtri non selezionati");
					result.getGlobalErrors().add("Inserire almeno uno tra provincia e denominazione.");
					result.setResultCode(CARICAMANUTENTORI_OUTCOME_CODE__KO);
				} else {
					log.debug("caricamento elenco da DB");
					theModel.setAppDatamanutentoriAppData(getElencoManager().getListaManutentori(filtroManutentore));
					result.setResultCode(CARICAMANUTENTORI_OUTCOME_CODE__OK);
				}
				resetClearStatus_widg_tbCorsi(theModel.getSession());
				resetClearStatus_widg_tbElenco(theModel.getSession());
				theModel.setAppDataidManutentoreSelezionato(null);
			} catch (Exception e) {
				result.getGlobalErrors().add("Si e' verificato un errore. Contattare l'amministratore del sistema.");
				result.setResultCode(CARICAMANUTENTORI_OUTCOME_CODE__KO);
			}
			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::caricaManutentori] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo apriDettaglio definito in un ExecCommand del
	 * ContentPanel cpRicerca
	 */
	public ExecResults apriDettaglio(

			it.csi.sigit.elencom.dto.ricerca_module.CpRicercaModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String APRIDETTAGLIO_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String APRIDETTAGLIO_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-1670617863) ENABLED START*/

			log.debug("caricamento corsi");
			try {
				String idManutentoreSelezionato = theModel.getAppDataidManutentoreSelezionato();
				if (StringUtils.isEmpty(idManutentoreSelezionato)) {
					result.getGlobalErrors().add("Selezionare una voce dall'elenco.");
					result.setResultCode(APRIDETTAGLIO_OUTCOME_CODE__KO);
				} else {
					ArrayList<Corso> listaCorsi = getElencoManager()
							.getListaCorsi(new Integer(idManutentoreSelezionato));
					theModel.setAppDataelencoCorsi(listaCorsi);
					result.setResultCode(APRIDETTAGLIO_OUTCOME_CODE__OK);
					ArrayList<Manutentore> manutentori = theModel.getAppDatamanutentoriAppData();
					for (Manutentore manutentore : manutentori) {
						if (manutentore.getIdManutentore().equals(idManutentoreSelezionato))
							theModel.setAppDatamanutentoreAppData(manutentore);
					}
				}
			} catch (Exception e) {
				log.error("Errore: ", e);
				result.getGlobalErrors().add("Se e' verificato un errore.");
				result.setResultCode(APRIDETTAGLIO_OUTCOME_CODE__OK);
			}
			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::apriDettaglio] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo gestioneIngresso definito in un ExecCommand del
	 * ContentPanel cpRicerca
	 */
	public ExecResults gestioneIngresso(

			it.csi.sigit.elencom.dto.ricerca_module.CpRicercaModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GESTIONEINGRESSO_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R190904228) ENABLED START*/

			theModel.setAppDatacomboComuni(new ArrayList<CodiceDescrizione>());
			theModel.setAppDatamanutentoriAppData(new ArrayList<Manutentore>());
			result.setResultCode(GESTIONEINGRESSO_OUTCOME_CODE__OK);
			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::gestioneIngresso] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	//////////////////////////////////////////////////////////////////////////////
	/// Metodi statici per il reset delle tabelle
	//////////////////////////////////////////////////////////////////////////////

	/**
	 * permette di resettare lo stato di paginazione della tabella widg_tbElenco
	 */
	public static void resetClearStatus_widg_tbElenco(java.util.Map session) {
		session.put("cpRicerca_tbElenco_clearStatus", Boolean.TRUE);
	}

	/**
	 * permette di resettare lo stato di paginazione della tabella widg_tbCorsi
	 */
	public static void resetClearStatus_widg_tbCorsi(java.util.Map session) {
		session.put("cpRicerca_tbCorsi_clearStatus", Boolean.TRUE);
	}

	//////////////////////////////////////////////////////////////////////////////
	/// Property aggiuntive del bean
	//////////////////////////////////////////////////////////////////////////////
	/*PROTECTED REGION ID(R1130533293) ENABLED START*/
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
