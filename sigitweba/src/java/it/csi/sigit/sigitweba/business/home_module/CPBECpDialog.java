package it.csi.sigit.sigitweba.business.home_module;

import java.util.*;

import it.csi.sigit.sigitweba.dto.*;
import it.csi.sigit.sigitweba.dto.common.*;
import it.csi.sigit.sigitweba.dto.accreditamento_tns.*;

import org.apache.log4j.*;
import it.csi.sigit.sigitweba.util.*;
import it.csi.sigit.sigitweba.business.*;

/*PROTECTED REGION ID(R2043860060) ENABLED START*/

/*PROTECTED REGION END*/

public class CPBECpDialog {

	/**  */
	protected static final Logger log = //NOSONAR  Reason:EIAS 
			Logger.getLogger(Constants.APPLICATION_CODE + ".business"); //NOSONAR  Reason:EIAS

	//////////////////////////////////////////////////////////////////////////////
	/// Costanti identificative degli Application Data
	//////////////////////////////////////////////////////////////////////////////

	// ApplicationData: [messaggioErrore, scope:USER_SESSION]
	public static final String APPDATA_MESSAGGIOERRORE_CODE = "appDatamessaggioErrore";

	//////////////////////////////////////////////////////////////////////////////
	/// Metodi associati alla U.I.
	//////////////////////////////////////////////////////////////////////////////

	// nome del content panel associato al bean
	public static final String CPNAME = "cpDialog";

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

	//////////////////////////////////////////////////////////////////////////////
	/// Property aggiuntive del bean
	//////////////////////////////////////////////////////////////////////////////
	/*PROTECTED REGION ID(R394297688) ENABLED START*/
	//// inserire qui le property che si vogliono iniettare in questo bean (es. dao, proxy di pd, ...) 
	/*PROTECTED REGION END*/
}
