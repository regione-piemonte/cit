package it.csi.sigit.sigitwebn.business.risultato_ricerca_codici_impianto_liberi;

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

/*PROTECTED REGION ID(R-340184038) ENABLED START*/

/*PROTECTED REGION END*/

public class CPBECpRisRicCodiciLib {

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

	//////////////////////////////////////////////////////////////////////////////
	/// Metodi associati alla U.I.
	//////////////////////////////////////////////////////////////////////////////

	// nome del content panel associato al bean
	public static final String CPNAME = "cpRisRicCodiciLib";

	/** 
	 * Restituisce il tab correntemente visibile in un determinato tab set
	 */
	private String getCurrentTab(Map session, String tabSetName) {
		String value = (String) session.get(CPNAME + "_" + tabSetName + "_selectedMultiPanel");
		return value;
	}

	//////////////////////////////////////////////////////////////////////////////
	/// Metodi statici per il reset delle tabelle
	//////////////////////////////////////////////////////////////////////////////

	/**
	 * permette di resettare lo stato di paginazione della tabella widg_tbRisultatoRicCodiciLib
	 */
	public static void resetClearStatus_widg_tbRisultatoRicCodiciLib(java.util.Map session) {
		session.put("cpRisRicCodiciLib_tbRisultatoRicCodiciLib_clearStatus", Boolean.TRUE);
	}

	//////////////////////////////////////////////////////////////////////////////
	/// Property aggiuntive del bean
	//////////////////////////////////////////////////////////////////////////////
	/*PROTECTED REGION ID(R918311572) ENABLED START*/
	//// inserire qui le property che si vogliono iniettare in questo bean (es. dao, proxy di pd, ...) 
	/*PROTECTED REGION END*/
}
