package it.csi.sigit.sigitweba.business.home_module;

import java.util.*;

import it.csi.sigit.sigitweba.dto.*;
import it.csi.sigit.sigitweba.dto.common.*;
import it.csi.sigit.sigitweba.dto.accreditamento_tns.*;

import org.apache.log4j.*;
import it.csi.sigit.sigitweba.util.*;
import it.csi.sigit.sigitweba.business.*;

/*PROTECTED REGION ID(R-1185626779) ENABLED START*/

/*PROTECTED REGION END*/

public class CPBECpHome {

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
	public static final String CPNAME = "cpHome";

	/** 
	 * Restituisce il tab correntemente visibile in un determinato tab set
	 */
	private String getCurrentTab(Map session, String tabSetName) {
		String value = (String) session.get(CPNAME + "_" + tabSetName + "_selectedMultiPanel");
		return value;
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo gestioneMessaggio definito in un ExecCommand del
	 * ContentPanel cpHome
	 */
	public ExecResults gestioneMessaggio(

			it.csi.sigit.sigitweba.dto.home_module.CpHomeModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GESTIONEMESSAGGIO_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R640471887) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			System.out.println("SONO NELLA HOME error: " + theModel.getAppDatamessaggioErrore());

			result.getGlobalErrors().clear();

			System.out.println("\n\nresult.getGlobalErrors().size(): " + result.getGlobalErrors().size());

			String error = theModel.getAppDatamessaggioErrore();

			if (error != null) {
				System.out.println("\n\n**** SETTO errore****\n\n");

				result.getGlobalErrors().add(error);

				theModel.setAppDatamessaggioErrore(null);
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

	//////////////////////////////////////////////////////////////////////////////
	/// Metodi statici per il reset delle tabelle
	//////////////////////////////////////////////////////////////////////////////

	//////////////////////////////////////////////////////////////////////////////
	/// Property aggiuntive del bean
	//////////////////////////////////////////////////////////////////////////////
	/*PROTECTED REGION ID(R-1358798737) ENABLED START*/
	//// inserire qui le property che si vogliono iniettare in questo bean (es. dao, proxy di pd, ...) 
	/*PROTECTED REGION END*/
}
